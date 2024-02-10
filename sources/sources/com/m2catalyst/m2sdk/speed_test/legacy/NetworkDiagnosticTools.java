package com.m2catalyst.m2sdk.speed_test.legacy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Network;
import android.os.Build;
import android.os.SystemClock;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.j6;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults;
import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import com.m2catalyst.m2sdk.ndt.models.LatencyTestResults;
import com.m2catalyst.m2sdk.o1;
import com.vungle.ads.internal.presenter.NativeAdPresenter;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.net.SocketFactory;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkDiagnosticTools {
    public static final int BANDWIDTH_ALGORITHM_DYNAMIC = 2;
    static final int BANDWIDTH_ALGORITHM_FIXED = 1;
    public static final int BANDWIDTH_ALGORITHM_LIBRE = 4;
    public static final int BANDWIDTH_ALGORITHM_MULTITHREAD = 3;
    public static final int BANDWIDTH_ALGORITHM_UNDEFINED = Integer.MIN_VALUE;
    public static final int LATENCY_ALGORITHM_INTERNAL = 3;
    public static final int LATENCY_ALGORITHM_LIBRE = 4;
    private static final String TAG = "NDT";
    public static NetworkDiagnosticTools _instance;
    /* access modifiers changed from: private */
    public static j6 libreSpeedTest;
    /* access modifiers changed from: private */
    public double Bps_To_Mbps;
    /* access modifiers changed from: private */
    public double Mbps_To_Bps;
    /* access modifiers changed from: private */
    public int bandwidthAlgorithm;
    private Context context;
    /* access modifiers changed from: private */
    public DiagnosticsResults currentTestResults;
    /* access modifiers changed from: private */
    public int dataSize;
    /* access modifiers changed from: private */
    public boolean downloadAverageLeveledOut;
    /* access modifiers changed from: private */
    public float downloadAvg;
    /* access modifiers changed from: private */
    public boolean downloadConnectionTimedOut;
    /* access modifiers changed from: private */
    public double downloadMax;
    /* access modifiers changed from: private */
    public double downloadMin;
    /* access modifiers changed from: private */
    public ArrayList<Double> downloadTestSpeeds;
    /* access modifiers changed from: private */
    public ArrayList<Double> downloadTestSpeedsAverages;
    ArrayList<String> ipAddresses;
    private boolean isTestRunning;
    private DiagnosticsResults lastTestResults;
    private int latencyAlgorithm;
    private String libreDlOverheadFactor;
    private String libreUlOverheadFactor;
    private ArrayList<ThroughputTestSystemListener> listeners;
    /* access modifiers changed from: private */
    public ThroughputTestSystemListener mListener;
    protected WebSocketClient mWebSocketClient;
    private MNSI mnsi;
    private Network network;
    private NetworkChangeReceiver networkChangeReceiver;
    private int networkType;
    /* access modifiers changed from: private */
    public int numberOfThreads;
    private Process pingProcess;
    /* access modifiers changed from: private */
    public long receivedDataSize;
    /* access modifiers changed from: private */
    public ArrayList<Long> receivedDataTimes;
    /* access modifiers changed from: private */
    public ArrayList<Integer> receivedPacketSizes;
    /* access modifiers changed from: private */
    public boolean reconnecting;
    /* access modifiers changed from: private */
    public int responseCount;
    /* access modifiers changed from: private */
    public long responseDuration;
    private String selectedProtocol;
    /* access modifiers changed from: private */
    public int sentCount;
    /* access modifiers changed from: private */
    public long sentDuration;
    /* access modifiers changed from: private */
    public long startTime;
    private int totalDataSize;
    /* access modifiers changed from: private */
    public float uploadAvg;
    /* access modifiers changed from: private */
    public double uploadMax;
    /* access modifiers changed from: private */
    public double uploadMin;
    /* access modifiers changed from: private */
    public ArrayList<Double> uploadTestSpeeds;
    /* access modifiers changed from: private */
    public ArrayList<Double> uploadTestSpeedsAverages;

    public class NetworkChangeReceiver extends BroadcastReceiver {
        public NetworkChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            NetworkDiagnosticTools.this.updateNetworkType(context);
        }
    }

    public static class NetworkDiagnosticToolsHolder {
        public static final NetworkDiagnosticTools instance = new NetworkDiagnosticTools();

        private NetworkDiagnosticToolsHolder() {
        }
    }

    public class Stats {
        public double avg;
        public double max;
        public double min;
        public double standardDeviation;

        public Stats() {
        }
    }

    private NetworkDiagnosticTools() {
        this.selectedProtocol = "speed-test-protocol-v2";
        this.ipAddresses = new ArrayList<>();
        this.totalDataSize = 1024000;
        this.dataSize = 102400;
        this.numberOfThreads = 4;
        this.sentCount = 5;
        this.responseCount = 0;
        this.Mbps_To_Bps = 131072.0d;
        this.Bps_To_Mbps = 7.62939453125E-6d;
        this.uploadTestSpeeds = new ArrayList<>();
        this.uploadTestSpeedsAverages = new ArrayList<>();
        this.downloadTestSpeeds = new ArrayList<>();
        this.downloadTestSpeedsAverages = new ArrayList<>();
        this.receivedDataSize = 0;
        this.isTestRunning = false;
        this.reconnecting = false;
        this.networkType = 1;
        this.listeners = new ArrayList<>();
    }

    private void addNetworkConnectivityListener(Context context2) {
        this.networkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context2.getApplicationContext().registerReceiver(this.networkChangeReceiver, intentFilter);
    }

    private double calculateJitter(ArrayList<Double> arrayList, ArrayList<Double> arrayList2) {
        double size;
        int i = 0;
        M2SDKLogger.Companion.getLogger(TAG).d(TAG, "start calculating jitter", new String[0]);
        int i2 = this.latencyAlgorithm;
        double d = 0.0d;
        if (i2 == 3) {
            if (arrayList == null || arrayList.size() == 0) {
                return 2.147483647E9d;
            }
            ArrayList arrayList3 = new ArrayList();
            while (i < arrayList.size()) {
                if (i != 0) {
                    arrayList3.add(Double.valueOf(Math.abs(arrayList.get(i).doubleValue() - arrayList.get(i - 1).doubleValue())));
                }
                i++;
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                d += ((Double) it.next()).doubleValue();
            }
            size = (double) arrayList3.size();
            Double.isNaN(size);
        } else if (i2 != 4 || arrayList2 == null || arrayList2.size() == 0) {
            return 2.147483647E9d;
        } else {
            while (i < arrayList2.size()) {
                d += arrayList2.get(i).doubleValue();
                i++;
            }
            size = (double) arrayList2.size();
            Double.isNaN(size);
        }
        return d / size;
    }

    private void connect() {
        Socket socket;
        try {
            URI uri = new URI(getWebSocketUrl());
            HashMap hashMap = new HashMap();
            hashMap.put("sec-websocket-protocol", this.selectedProtocol);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Protocol(this.selectedProtocol));
            this.mWebSocketClient = new WebSocketClient(uri, new Draft_6455((List<IExtension>) arrayList, (List<IProtocol>) arrayList2), hashMap) {
                public void onClose(int i, String str, boolean z) {
                    M2SDKLogger.Companion companion = M2SDKLogger.Companion;
                    M2SDKLogger logger = companion.getLogger(NetworkDiagnosticTools.TAG);
                    StringBuilder sb = new StringBuilder();
                    sb.append(hashCode());
                    sb.append(", ");
                    sb.append(NetworkDiagnosticTools.this.currentTestResults.getDebugTestNumber());
                    sb.append(" - Closed, ");
                    sb.append(z ? "remotely" : "locally");
                    sb.append(", ");
                    sb.append(i);
                    sb.append(", ");
                    sb.append(str);
                    logger.d(NetworkDiagnosticTools.TAG, sb.toString(), new String[0]);
                    if (i != 1000) {
                        NetworkDiagnosticTools networkDiagnosticTools = NetworkDiagnosticTools.this;
                        networkDiagnosticTools.testFailure("Early onClose, (" + i + ") " + WebSocketCodes.lookupWebSocketCode(i).description, 5);
                    }
                    NetworkDiagnosticTools networkDiagnosticTools2 = NetworkDiagnosticTools.this;
                    if (networkDiagnosticTools2.downloadConnectionTimedOut || networkDiagnosticTools2.downloadAverageLeveledOut) {
                        M2SDKLogger logger2 = companion.getLogger(NetworkDiagnosticTools.TAG);
                        StringBuilder sb2 = new StringBuilder("Web socket closed, reinitialize web socket: ");
                        String str2 = "";
                        sb2.append(NetworkDiagnosticTools.this.downloadConnectionTimedOut ? "Download connection timed out" : str2);
                        if (NetworkDiagnosticTools.this.downloadAverageLeveledOut) {
                            str2 = "Download Averaged out";
                        }
                        sb2.append(str2);
                        logger2.d(NetworkDiagnosticTools.TAG, sb2.toString(), new String[0]);
                        NetworkDiagnosticTools.this.reinitializeWebSocket();
                    }
                }

                public void onCloseInitiated(int i, String str) {
                    super.onCloseInitiated(i, str);
                    M2SDKLogger logger = M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG);
                    logger.d(NetworkDiagnosticTools.TAG, hashCode() + ", " + NetworkDiagnosticTools.this.currentTestResults.getDebugTestNumber() + " - close initiated, , " + i + ", " + str, new String[0]);
                }

                public void onClosing(int i, String str, boolean z) {
                    super.onClosing(i, str, z);
                    M2SDKLogger logger = M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG);
                    StringBuilder sb = new StringBuilder();
                    sb.append(hashCode());
                    sb.append(", ");
                    sb.append(NetworkDiagnosticTools.this.currentTestResults.getDebugTestNumber());
                    sb.append(" - closing, ");
                    sb.append(z ? "remotely" : "locally");
                    sb.append(", ");
                    sb.append(i);
                    sb.append(", ");
                    sb.append(str);
                    logger.d(NetworkDiagnosticTools.TAG, sb.toString(), new String[0]);
                }

                public void onError(Exception exc) {
                    M2SDKLogger logger = M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG);
                    logger.d(NetworkDiagnosticTools.TAG, "test number:" + NetworkDiagnosticTools.this.currentTestResults.getDebugTestNumber() + " - " + hashCode() + ", Web socket error", exc.getMessage());
                    NetworkDiagnosticTools.this.setTestRunning(false);
                    NetworkDiagnosticTools.this.testFailure(exc.getClass().getName(), 3);
                }

                /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[Catch:{ JSONException -> 0x02f9 }] */
                /* JADX WARNING: Removed duplicated region for block: B:25:0x0167 A[Catch:{ JSONException -> 0x02f9 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onMessage(java.lang.String r21) {
                    /*
                        r20 = this;
                        r1 = r20
                        java.lang.String r0 = "Upload Speeds have Settled, Buffered Data = "
                        java.lang.String r2 = "UploadTestUpdateMessage, "
                        monitor-enter(r20)
                        r3 = 0
                        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02f9 }
                        r5 = r21
                        r4.<init>(r5)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r5 = "message"
                        java.lang.String r5 = r4.getString(r5)     // Catch:{ JSONException -> 0x02f9 }
                        int r6 = r5.hashCode()     // Catch:{ JSONException -> 0x02f9 }
                        r7 = 787591019(0x2ef1af6b, float:1.09905716E-10)
                        r8 = -1
                        r9 = 1
                        if (r6 == r7) goto L_0x0030
                        r7 = 1258460260(0x4b029464, float:8557668.0)
                        if (r6 == r7) goto L_0x0026
                        goto L_0x003a
                    L_0x0026:
                        java.lang.String r6 = "UploadTestResultsMessage"
                        boolean r5 = r5.equals(r6)     // Catch:{ JSONException -> 0x02f9 }
                        if (r5 == 0) goto L_0x003a
                        r5 = 1
                        goto L_0x003b
                    L_0x0030:
                        java.lang.String r6 = "UploadTestUpdateMessage"
                        boolean r5 = r5.equals(r6)     // Catch:{ JSONException -> 0x02f9 }
                        if (r5 == 0) goto L_0x003a
                        r5 = 0
                        goto L_0x003b
                    L_0x003a:
                        r5 = -1
                    L_0x003b:
                        r6 = -4616189618054758400(0xbff0000000000000, double:-1.0)
                        if (r5 == 0) goto L_0x0167
                        if (r5 == r9) goto L_0x0043
                        goto L_0x0328
                    L_0x0043:
                        java.lang.String r0 = "speeds"
                        org.json.JSONArray r0 = r4.getJSONArray(r0)     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ JSONException -> 0x02f9 }
                        r2.<init>()     // Catch:{ JSONException -> 0x02f9 }
                        r4 = 0
                    L_0x0050:
                        int r5 = r0.length()     // Catch:{ JSONException -> 0x02f9 }
                        if (r4 >= r5) goto L_0x009d
                        com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r5 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r8 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r5 = r5.getLogger(r8)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r8 = "NDT"
                        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02f9 }
                        r10.<init>()     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r11 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r11 = r11.currentTestResults     // Catch:{ JSONException -> 0x02f9 }
                        int r11 = r11.getDebugTestNumber()     // Catch:{ JSONException -> 0x02f9 }
                        r10.append(r11)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r11 = " - Speed: "
                        r10.append(r11)     // Catch:{ JSONException -> 0x02f9 }
                        double r11 = r0.optDouble(r4, r6)     // Catch:{ JSONException -> 0x02f9 }
                        r10.append(r11)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r10 = r10.toString()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String[] r11 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x02f9 }
                        r5.d(r8, r10, r11)     // Catch:{ JSONException -> 0x02f9 }
                        double r10 = r0.optDouble(r4, r6)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r5 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        double r12 = r5.Mbps_To_Bps     // Catch:{ JSONException -> 0x02f9 }
                        double r10 = r10 * r12
                        java.lang.Double r5 = java.lang.Double.valueOf(r10)     // Catch:{ JSONException -> 0x02f9 }
                        r2.add(r5)     // Catch:{ JSONException -> 0x02f9 }
                        int r4 = r4 + 1
                        goto L_0x0050
                    L_0x009d:
                        com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r4 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r4 = r0.getLogger(r4)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r5 = "NDT"
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02f9 }
                        r6.<init>()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r7 = "Count = "
                        r6.append(r7)     // Catch:{ JSONException -> 0x02f9 }
                        int r7 = r2.size()     // Catch:{ JSONException -> 0x02f9 }
                        r6.append(r7)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r7 = ", remove impossibles"
                        r6.append(r7)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x02f9 }
                        r4.d(r5, r6, r7)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r4 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        r4.removeImpossibles(r2)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r4 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r4 = r0.getLogger(r4)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r5 = "NDT"
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02f9 }
                        r6.<init>()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r7 = "Count = "
                        r6.append(r7)     // Catch:{ JSONException -> 0x02f9 }
                        int r7 = r2.size()     // Catch:{ JSONException -> 0x02f9 }
                        r6.append(r7)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r7 = ", trim speeds"
                        r6.append(r7)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x02f9 }
                        r4.d(r5, r6, r7)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r4 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList unused = r4.trimSpeeds(r2)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r4 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.getLogger(r4)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r4 = "NDT"
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02f9 }
                        r5.<init>()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r6 = "Count = "
                        r5.append(r6)     // Catch:{ JSONException -> 0x02f9 }
                        int r6 = r2.size()     // Catch:{ JSONException -> 0x02f9 }
                        r5.append(r6)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r6 = ", Calc min, max, avg"
                        r5.append(r6)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x02f9 }
                        r0.d(r4, r5, r6)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.Object r0 = r2.get(r3)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ JSONException -> 0x02f9 }
                        float r13 = r0.floatValue()     // Catch:{ JSONException -> 0x02f9 }
                        int r0 = r2.size()     // Catch:{ JSONException -> 0x02f9 }
                        int r0 = r0 - r9
                        java.lang.Object r0 = r2.get(r0)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ JSONException -> 0x02f9 }
                        float r14 = r0.floatValue()     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools$Stats r0 = r0.calculateStats(r2)     // Catch:{ JSONException -> 0x02f9 }
                        double r4 = r0.avg     // Catch:{ JSONException -> 0x02f9 }
                        float r15 = (float) r4     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r2 = new com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults     // Catch:{ JSONException -> 0x02f9 }
                        r11 = 2
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r4 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        int r12 = r4.bandwidthAlgorithm     // Catch:{ JSONException -> 0x02f9 }
                        int r5 = r4.sentCount     // Catch:{ JSONException -> 0x02f9 }
                        int r6 = r4.numberOfThreads     // Catch:{ JSONException -> 0x02f9 }
                        int r5 = r5 * r6
                        int r4 = r4.dataSize     // Catch:{ JSONException -> 0x02f9 }
                        int r5 = r5 * r4
                        long r4 = (long) r5     // Catch:{ JSONException -> 0x02f9 }
                        r10 = r2
                        r16 = r4
                        r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ JSONException -> 0x02f9 }
                        r0.onUploadTestComplete(r2)     // Catch:{ JSONException -> 0x02f9 }
                        goto L_0x0328
                    L_0x0167:
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r5 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        boolean r5 = r5.isTestRunning()     // Catch:{ JSONException -> 0x02f9 }
                        if (r5 == 0) goto L_0x02e4
                        java.lang.String r5 = "packetsReceived"
                        int r5 = r4.optInt(r5, r8)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r9 = "packetsExpected"
                        int r8 = r4.optInt(r9, r8)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r9 = "currentSpeed"
                        double r6 = r4.optDouble(r9, r6)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r4 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        double r9 = r4.Mbps_To_Bps     // Catch:{ JSONException -> 0x02f9 }
                        double r6 = r6 * r9
                        java.util.ArrayList r4 = r4.uploadTestSpeeds     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.Double r9 = java.lang.Double.valueOf(r6)     // Catch:{ JSONException -> 0x02f9 }
                        r4.add(r9)     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r9 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList r9 = r9.uploadTestSpeeds     // Catch:{ JSONException -> 0x02f9 }
                        r4.<init>(r9)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r9 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        r9.removeImpossibles(r4)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r9 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList r4 = r9.trimByIQRMean(r4)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r9 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools$Stats r9 = r9.calculateStats(r4)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r10 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList r10 = r10.uploadTestSpeedsAverages     // Catch:{ JSONException -> 0x02f9 }
                        double r11 = r9.avg     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ JSONException -> 0x02f9 }
                        r10.add(r11)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r10 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r11 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r11 = r10.getLogger(r11)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r12 = "NDT"
                        java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02f9 }
                        r13.<init>(r2)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r2 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        double r14 = r2.Bps_To_Mbps     // Catch:{ JSONException -> 0x02f9 }
                        double r14 = r14 * r6
                        r13.append(r14)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r2 = ", "
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r2 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList r2 = r2.uploadTestSpeeds     // Catch:{ JSONException -> 0x02f9 }
                        int r2 = r2.size()     // Catch:{ JSONException -> 0x02f9 }
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r2 = ", "
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        int r2 = r4.size()     // Catch:{ JSONException -> 0x02f9 }
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r2 = ", "
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        double r14 = r9.avg     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r2 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        double r16 = r2.Bps_To_Mbps     // Catch:{ JSONException -> 0x02f9 }
                        double r14 = r14 * r16
                        r13.append(r14)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r2 = ", "
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        r13.append(r5)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r2 = ", "
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r2 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        org.java_websocket.client.WebSocketClient r2 = r2.mWebSocketClient     // Catch:{ JSONException -> 0x02f9 }
                        boolean r2 = r2.hasBufferedData()     // Catch:{ JSONException -> 0x02f9 }
                        r13.append(r2)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r2 = r13.toString()     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x02f9 }
                        r11.d(r12, r2, r4)     // Catch:{ JSONException -> 0x02f9 }
                        long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r2 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        long r13 = r2.startTime     // Catch:{ JSONException -> 0x02f9 }
                        long r11 = r11 - r13
                        r13 = 30000(0x7530, double:1.4822E-319)
                        int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                        if (r4 <= 0) goto L_0x0270
                        java.lang.String r0 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r10.getLogger(r0)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r2 = "NDT"
                        java.lang.String r4 = "Upload taking too long, manual time out"
                        java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x02f9 }
                        r0.d(r2, r4, r6)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r2 = new com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults     // Catch:{ JSONException -> 0x02f9 }
                        r11 = 2
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r4 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        int r12 = r4.bandwidthAlgorithm     // Catch:{ JSONException -> 0x02f9 }
                        double r6 = r9.min     // Catch:{ JSONException -> 0x02f9 }
                        float r13 = (float) r6     // Catch:{ JSONException -> 0x02f9 }
                        double r6 = r9.max     // Catch:{ JSONException -> 0x02f9 }
                        float r14 = (float) r6     // Catch:{ JSONException -> 0x02f9 }
                        double r6 = r9.avg     // Catch:{ JSONException -> 0x02f9 }
                        float r15 = (float) r6     // Catch:{ JSONException -> 0x02f9 }
                        int r4 = r4.dataSize     // Catch:{ JSONException -> 0x02f9 }
                        int r5 = r5 * r4
                        long r4 = (long) r5     // Catch:{ JSONException -> 0x02f9 }
                        r10 = r2
                        r16 = r4
                        r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ JSONException -> 0x02f9 }
                        r0.onUploadTestComplete(r2)     // Catch:{ JSONException -> 0x02f9 }
                        goto L_0x0328
                    L_0x0270:
                        boolean r2 = r2.isValidSpeed(r6)     // Catch:{ JSONException -> 0x02f9 }
                        if (r2 == 0) goto L_0x0287
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r2 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.ThroughputTestSystemListener r11 = r2.mListener     // Catch:{ JSONException -> 0x02f9 }
                        double r12 = (double) r5     // Catch:{ JSONException -> 0x02f9 }
                        double r14 = (double) r8     // Catch:{ JSONException -> 0x02f9 }
                        double r3 = r9.avg     // Catch:{ JSONException -> 0x02f9 }
                        r16 = r6
                        r18 = r3
                        r11.uploadTestUpdate(r12, r14, r16, r18)     // Catch:{ JSONException -> 0x02f9 }
                    L_0x0287:
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r3 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        java.util.ArrayList r4 = r3.uploadTestSpeedsAverages     // Catch:{ JSONException -> 0x02f9 }
                        boolean r3 = r3.hasAverageSpeedsSettled(r4)     // Catch:{ JSONException -> 0x02f9 }
                        if (r3 == 0) goto L_0x0328
                        java.lang.String r3 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r3 = r10.getLogger(r3)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r4 = "NDT"
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02f9 }
                        r6.<init>(r0)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        org.java_websocket.client.WebSocketClient r0 = r0.mWebSocketClient     // Catch:{ JSONException -> 0x02f9 }
                        boolean r0 = r0.hasBufferedData()     // Catch:{ JSONException -> 0x02f9 }
                        r6.append(r0)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r0 = r6.toString()     // Catch:{ JSONException -> 0x02f9 }
                        r2 = 0
                        java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x02f9 }
                        r3.d(r4, r0, r6)     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        org.java_websocket.client.WebSocketClient r0 = r0.mWebSocketClient     // Catch:{ JSONException -> 0x02f9 }
                        boolean r0 = r0.hasBufferedData()     // Catch:{ JSONException -> 0x02f9 }
                        if (r0 == 0) goto L_0x0328
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults r3 = new com.m2catalyst.m2sdk.ndt.models.BandwidthTestResults     // Catch:{ JSONException -> 0x02f9 }
                        r11 = 2
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r4 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ JSONException -> 0x02f9 }
                        int r12 = r4.bandwidthAlgorithm     // Catch:{ JSONException -> 0x02f9 }
                        double r6 = r9.min     // Catch:{ JSONException -> 0x02f9 }
                        float r13 = (float) r6     // Catch:{ JSONException -> 0x02f9 }
                        double r6 = r9.max     // Catch:{ JSONException -> 0x02f9 }
                        float r14 = (float) r6     // Catch:{ JSONException -> 0x02f9 }
                        double r6 = r9.avg     // Catch:{ JSONException -> 0x02f9 }
                        float r15 = (float) r6     // Catch:{ JSONException -> 0x02f9 }
                        int r4 = r4.dataSize     // Catch:{ JSONException -> 0x02f9 }
                        int r5 = r5 * r4
                        long r4 = (long) r5     // Catch:{ JSONException -> 0x02f9 }
                        r10 = r3
                        r16 = r4
                        r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ JSONException -> 0x02f9 }
                        r0.onUploadTestComplete(r3)     // Catch:{ JSONException -> 0x02f9 }
                        goto L_0x0328
                    L_0x02e4:
                        com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r3 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r0 = r0.getLogger(r3)     // Catch:{ JSONException -> 0x02f9 }
                        java.lang.String r3 = "NDT"
                        java.lang.String r4 = "Received UploadTestUpdateMessage after finishing test"
                        r2 = 0
                        java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x02f9 }
                        r0.d(r3, r4, r5)     // Catch:{ JSONException -> 0x02f9 }
                        goto L_0x0328
                    L_0x02f7:
                        r0 = move-exception
                        goto L_0x032a
                    L_0x02f9:
                        r0 = move-exception
                        com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x02f7 }
                        java.lang.String r4 = "NDT"
                        com.m2catalyst.m2sdk.logger.M2SDKLogger r3 = r3.getLogger(r4)     // Catch:{ all -> 0x02f7 }
                        java.lang.String r4 = "NDT"
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f7 }
                        r5.<init>()     // Catch:{ all -> 0x02f7 }
                        java.lang.String r6 = "Failure to deconstruct upload test complete object "
                        r5.append(r6)     // Catch:{ all -> 0x02f7 }
                        java.lang.String r6 = r0.getLocalizedMessage()     // Catch:{ all -> 0x02f7 }
                        r5.append(r6)     // Catch:{ all -> 0x02f7 }
                        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x02f7 }
                        r2 = 0
                        java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x02f7 }
                        r3.e(r4, r5, r2)     // Catch:{ all -> 0x02f7 }
                        r0.printStackTrace()     // Catch:{ all -> 0x02f7 }
                        com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools r0 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.this     // Catch:{ all -> 0x02f7 }
                        r2 = 0
                        r0.onUploadTestComplete(r2)     // Catch:{ all -> 0x02f7 }
                    L_0x0328:
                        monitor-exit(r20)     // Catch:{ all -> 0x02f7 }
                        return
                    L_0x032a:
                        monitor-exit(r20)     // Catch:{ all -> 0x02f7 }
                        goto L_0x032d
                    L_0x032c:
                        throw r0
                    L_0x032d:
                        goto L_0x032c
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.AnonymousClass1.onMessage(java.lang.String):void");
                }

                public void onOpen(ServerHandshake serverHandshake) {
                    ThroughputTestSystemListener r0;
                    M2SDKLogger logger = M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG);
                    logger.d(NetworkDiagnosticTools.TAG, NetworkDiagnosticTools.this.currentTestResults.getDebugTestNumber() + " - Web Socket client connected, " + hashCode() + ", " + NetworkDiagnosticTools.this.reconnecting + ", " + NetworkDiagnosticTools.this.downloadConnectionTimedOut + ", " + NetworkDiagnosticTools.this.downloadAverageLeveledOut, new String[0]);
                    NetworkDiagnosticTools.this.setTestRunning(true);
                    NetworkDiagnosticTools networkDiagnosticTools = NetworkDiagnosticTools.this;
                    if (networkDiagnosticTools.reconnecting || (r0 = networkDiagnosticTools.mListener) == null) {
                        networkDiagnosticTools.reconnecting = false;
                        if (networkDiagnosticTools.downloadConnectionTimedOut || networkDiagnosticTools.downloadAverageLeveledOut) {
                            networkDiagnosticTools.downloadConnectionTimedOut = false;
                            networkDiagnosticTools.downloadAverageLeveledOut = false;
                            if (networkDiagnosticTools.bandwidthAlgorithm != 4) {
                                NetworkDiagnosticTools networkDiagnosticTools2 = NetworkDiagnosticTools.this;
                                networkDiagnosticTools.onDownloadTestComplete(new BandwidthTestResults(1, networkDiagnosticTools2.bandwidthAlgorithm, (float) networkDiagnosticTools2.downloadMin, (float) networkDiagnosticTools2.downloadMax, networkDiagnosticTools2.downloadAvg, networkDiagnosticTools2.receivedDataSize));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    r0.webSocketClientOpened();
                }

                public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
                    super.onWebsocketPing(webSocket, framedata);
                    M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG).d(NetworkDiagnosticTools.TAG, "onWebSocketPing", new String[0]);
                }

                public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
                    super.onWebsocketPong(webSocket, framedata);
                    M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG).d(NetworkDiagnosticTools.TAG, "onWebsocketPong", new String[0]);
                }

                public void sendPing() {
                    super.sendPing();
                    M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG).d(NetworkDiagnosticTools.TAG, "sendPing", new String[0]);
                }

                public void onMessage(ByteBuffer byteBuffer) {
                    int i;
                    super.onMessage(byteBuffer);
                    synchronized (this) {
                        NetworkDiagnosticTools networkDiagnosticTools = NetworkDiagnosticTools.this;
                        networkDiagnosticTools.responseCount = networkDiagnosticTools.responseCount + 1;
                        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                        NetworkDiagnosticTools.this.receivedDataTimes.add(Long.valueOf(elapsedRealtimeNanos));
                        int limit = byteBuffer.limit();
                        NetworkDiagnosticTools networkDiagnosticTools2 = NetworkDiagnosticTools.this;
                        networkDiagnosticTools2.receivedDataSize = networkDiagnosticTools2.receivedDataSize + ((long) limit);
                        networkDiagnosticTools2.receivedPacketSizes.add(Integer.valueOf(limit));
                        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
                        M2SDKLogger logger = companion.getLogger(NetworkDiagnosticTools.TAG);
                        logger.d(NetworkDiagnosticTools.TAG, NetworkDiagnosticTools.this.currentTestResults.getDebugTestNumber() + " - Response - " + NetworkDiagnosticTools.this.responseCount + ", " + byteBuffer.get(0) + ", " + (limit / 1024) + " kBs, " + new Date().getTime(), new String[0]);
                        M2SDKLogger logger2 = companion.getLogger(NetworkDiagnosticTools.TAG);
                        StringBuilder sb = new StringBuilder("Times = ");
                        sb.append(NetworkDiagnosticTools.this.receivedDataTimes.toString());
                        logger2.d(NetworkDiagnosticTools.TAG, sb.toString(), new String[0]);
                        if (NetworkDiagnosticTools.this.receivedDataTimes.size() > 1) {
                            double d = (double) limit;
                            ArrayList r0 = NetworkDiagnosticTools.this.receivedDataTimes;
                            double longValue = (double) (elapsedRealtimeNanos - ((Long) r0.get(r0.size() - 2)).longValue());
                            Double.isNaN(longValue);
                            Double.isNaN(d);
                            double d2 = d / (longValue / 1.0E9d);
                            if (!Double.isInfinite(d2)) {
                                NetworkDiagnosticTools.this.downloadTestSpeeds.add(Double.valueOf(d2));
                                ArrayList arrayList = new ArrayList(NetworkDiagnosticTools.this.downloadTestSpeeds);
                                NetworkDiagnosticTools.this.removeImpossibles(arrayList);
                                NetworkDiagnosticTools.this.downloadTestSpeedsAverages.add(Double.valueOf(NetworkDiagnosticTools.this.calculateStats(NetworkDiagnosticTools.this.trimByIQRMean(arrayList)).avg));
                            }
                            NetworkDiagnosticTools networkDiagnosticTools3 = NetworkDiagnosticTools.this;
                            ThroughputTestSystemListener r9 = networkDiagnosticTools3.mListener;
                            ArrayList r02 = networkDiagnosticTools3.receivedDataTimes;
                            long longValue2 = ((Long) r02.get(r02.size() - 1)).longValue();
                            ArrayList r03 = NetworkDiagnosticTools.this.receivedDataTimes;
                            i = 0;
                            r9.downloadTestUpdate(limit, longValue2 - ((Long) r03.get(r03.size() - 2)).longValue(), NetworkDiagnosticTools.this.receivedDataSize, d2);
                        } else {
                            i = 0;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "downloadResponse");
                            jSONObject.put("count", NetworkDiagnosticTools.this.responseCount);
                        } catch (JSONException e) {
                            M2SDKLogger logger3 = M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG);
                            logger3.e(NetworkDiagnosticTools.TAG, "Failure constructing download response JSON object " + e.getLocalizedMessage(), new String[i]);
                            e.printStackTrace();
                        }
                        NetworkDiagnosticTools.this.mWebSocketClient.send(jSONObject.toString());
                        M2SDKLogger.Companion companion2 = M2SDKLogger.Companion;
                        M2SDKLogger logger4 = companion2.getLogger(NetworkDiagnosticTools.TAG);
                        logger4.d(NetworkDiagnosticTools.TAG, "TIMEOUT: " + Long.toString(SystemClock.elapsedRealtime() - NetworkDiagnosticTools.this.startTime), new String[i]);
                        if (SystemClock.elapsedRealtime() - NetworkDiagnosticTools.this.startTime > 30000) {
                            companion2.getLogger(NetworkDiagnosticTools.TAG).d(NetworkDiagnosticTools.TAG, "Timeout limit reached: set variable", new String[i]);
                            NetworkDiagnosticTools.this.downloadConnectionTimedOut = true;
                        }
                        NetworkDiagnosticTools networkDiagnosticTools4 = NetworkDiagnosticTools.this;
                        if (networkDiagnosticTools4.downloadAverageLeveledOut || networkDiagnosticTools4.downloadConnectionTimedOut || networkDiagnosticTools4.responseCount == networkDiagnosticTools4.sentCount * networkDiagnosticTools4.numberOfThreads) {
                            networkDiagnosticTools4.responseDuration = SystemClock.elapsedRealtime() - NetworkDiagnosticTools.this.startTime;
                            M2SDKLogger logger5 = companion2.getLogger(NetworkDiagnosticTools.TAG);
                            logger5.d(NetworkDiagnosticTools.TAG, NetworkDiagnosticTools.this.currentTestResults.getDebugTestNumber() + " - Sent Duration = " + NetworkDiagnosticTools.this.sentDuration + ", Response Duration = " + NetworkDiagnosticTools.this.responseDuration, new String[i]);
                            NetworkDiagnosticTools networkDiagnosticTools5 = NetworkDiagnosticTools.this;
                            networkDiagnosticTools5.downloadMax = 0.0d;
                            networkDiagnosticTools5.downloadMin = Double.MAX_VALUE;
                            networkDiagnosticTools5.downloadAvg = 0.0f;
                            ArrayList arrayList2 = new ArrayList();
                            for (int i2 = 1; i2 < NetworkDiagnosticTools.this.receivedDataTimes.size(); i2++) {
                                double intValue = (double) ((Integer) NetworkDiagnosticTools.this.receivedPacketSizes.get(i2)).intValue();
                                double longValue3 = (double) (((Long) NetworkDiagnosticTools.this.receivedDataTimes.get(i2)).longValue() - ((Long) NetworkDiagnosticTools.this.receivedDataTimes.get(i2 - 1)).longValue());
                                Double.isNaN(longValue3);
                                Double.isNaN(intValue);
                                double d3 = intValue / (longValue3 / 1.0E9d);
                                if (!Double.isInfinite(d3)) {
                                    arrayList2.add(Double.valueOf(d3));
                                }
                            }
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                Double d4 = (Double) it.next();
                                double doubleValue = d4.doubleValue();
                                NetworkDiagnosticTools networkDiagnosticTools6 = NetworkDiagnosticTools.this;
                                if (doubleValue < networkDiagnosticTools6.downloadMin) {
                                    networkDiagnosticTools6.downloadMin = d4.doubleValue();
                                }
                                double doubleValue2 = d4.doubleValue();
                                NetworkDiagnosticTools networkDiagnosticTools7 = NetworkDiagnosticTools.this;
                                if (doubleValue2 > networkDiagnosticTools7.downloadMax) {
                                    networkDiagnosticTools7.downloadMax = d4.doubleValue();
                                }
                                NetworkDiagnosticTools networkDiagnosticTools8 = NetworkDiagnosticTools.this;
                                double r5 = (double) networkDiagnosticTools8.downloadAvg;
                                double doubleValue3 = d4.doubleValue();
                                Double.isNaN(r5);
                                networkDiagnosticTools8.downloadAvg = (float) (r5 + doubleValue3);
                            }
                            NetworkDiagnosticTools networkDiagnosticTools9 = NetworkDiagnosticTools.this;
                            networkDiagnosticTools9.downloadAvg = networkDiagnosticTools9.downloadAvg / ((float) arrayList2.size());
                            NetworkDiagnosticTools networkDiagnosticTools10 = NetworkDiagnosticTools.this;
                            boolean r2 = networkDiagnosticTools10.downloadConnectionTimedOut;
                            if (!r2) {
                                if (!networkDiagnosticTools10.downloadAverageLeveledOut) {
                                    if (networkDiagnosticTools10.bandwidthAlgorithm != 4) {
                                        NetworkDiagnosticTools networkDiagnosticTools11 = NetworkDiagnosticTools.this;
                                        networkDiagnosticTools10.onDownloadTestComplete(new BandwidthTestResults(1, networkDiagnosticTools11.bandwidthAlgorithm, (float) networkDiagnosticTools11.downloadMin, (float) networkDiagnosticTools11.downloadMax, networkDiagnosticTools11.downloadAvg, networkDiagnosticTools11.receivedDataSize));
                                    }
                                }
                            }
                            if (r2) {
                                M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG).d(NetworkDiagnosticTools.TAG, "Download taking too long, manually timed out", new String[i]);
                            }
                            if (NetworkDiagnosticTools.this.downloadAverageLeveledOut) {
                                M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG).d(NetworkDiagnosticTools.TAG, "Download settled, we are going to cut the test short", new String[i]);
                            }
                            NetworkDiagnosticTools.this.reinitializeWebSocket();
                        }
                    }
                }
            };
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
            logger.d(TAG, this.mWebSocketClient.hashCode() + ", Create WebSocket Instance", new String[0]);
            this.mWebSocketClient.setConnectionLostTimeout(120);
            try {
                socket = SocketFactory.getDefault().createSocket();
            } catch (IOException e) {
                M2SDKLogger.Companion.getLogger(TAG).e(TAG, "Error creating socket", e.getMessage());
                socket = null;
            }
            if (!(Build.VERSION.SDK_INT < 21 || this.network == null || socket == null)) {
                try {
                    M2SDKLogger logger2 = M2SDKLogger.Companion.getLogger(TAG);
                    logger2.d(TAG, "Binding socket (" + socket + ") to network (" + this.network + ")", new String[0]);
                    this.network.bindSocket(socket);
                    this.mWebSocketClient.setSocket(socket);
                } catch (IOException e2) {
                    M2SDKLogger.Companion.getLogger(TAG).e(TAG, "Error binding socket to network", e2.getMessage());
                }
            }
            M2SDKLogger logger3 = M2SDKLogger.Companion.getLogger(TAG);
            logger3.d(TAG, this.currentTestResults.getDebugTestNumber() + " - Connecting... " + uri.toString() + ", " + this.selectedProtocol, new String[0]);
            this.mWebSocketClient.connect();
        } catch (URISyntaxException e3) {
            M2SDKLogger logger4 = M2SDKLogger.Companion.getLogger(TAG);
            logger4.e(TAG, "URI syntax exception Failure to connect: " + e3.getMessage(), new String[0]);
            e3.printStackTrace();
            setTestRunning(false);
        }
    }

    public static NetworkDiagnosticTools getInstance() {
        if (_instance == null) {
            _instance = new NetworkDiagnosticTools();
            M2SDKLogger.Companion.getLogger(TAG).d(TAG, "new ndt class instance created", new String[0]);
        }
        return _instance;
    }

    private List<Double> getLowerQuartile(ArrayList<Double> arrayList) {
        return arrayList.subList(0, arrayList.size() / 2);
    }

    private double getMean(ArrayList<Double> arrayList) {
        Iterator<Double> it = arrayList.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += it.next().doubleValue();
        }
        double size = (double) arrayList.size();
        Double.isNaN(size);
        return d / size;
    }

    private double getMedian(List<Double> list) {
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2).doubleValue();
        }
        return (list.get(list.size() / 2).doubleValue() + list.get((list.size() / 2) - 1).doubleValue()) / 2.0d;
    }

    private ArrayList<Double> getUpperHalf(ArrayList<Double> arrayList) {
        int i;
        if (arrayList.size() % 2 == 0) {
            i = arrayList.size() / 2;
        } else {
            i = (arrayList.size() / 2) + 1;
        }
        Iterator<Double> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext() && i2 < i) {
            it.next().doubleValue();
            it.remove();
            i2++;
        }
        return arrayList;
    }

    private List<Double> getUpperQuartile(ArrayList<Double> arrayList) {
        if (arrayList.size() % 2 == 0) {
            return arrayList.subList(arrayList.size() / 2, arrayList.size());
        }
        return arrayList.subList((arrayList.size() / 2) + 1, arrayList.size());
    }

    private String getWebSocketUrl() {
        if (this.ipAddresses.size() == 0) {
            return null;
        }
        return "ws://" + this.ipAddresses.get(0) + ":8000";
    }

    /* access modifiers changed from: private */
    public void libreTest() {
        this.downloadMax = 0.0d;
        this.downloadMin = Double.MAX_VALUE;
        this.downloadAvg = 0.0f;
        this.uploadMax = 0.0d;
        this.uploadMin = Double.MAX_VALUE;
        this.uploadAvg = 0.0f;
        final boolean[] zArr = new boolean[10];
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        new ArrayList();
        libreSpeedTest.a((j6.b) new j6.b() {
            public void onCriticalFailure(String str) {
                if (NetworkDiagnosticTools.this.isTestRunning()) {
                    M2SDKLogger.Companion.getLogger(NetworkDiagnosticTools.TAG).d(NetworkDiagnosticTools.TAG, "Libre critical failure", new String[0]);
                    NetworkDiagnosticTools.libreSpeedTest.a();
                    NetworkDiagnosticTools.this.mListener.setTestFailedCalledFalse();
                    NetworkDiagnosticTools.this.mListener.testFailed("Network Lost", 8, true);
                }
            }

            public void onDownloadUpdate(double d, double d2) {
                double d3 = d;
                float f = (float) ((d3 / 8.0d) * 1024.0d * 1024.0d);
                NetworkDiagnosticTools.this.downloadAvg = f;
                if (f < 0.0f) {
                    onCriticalFailure("Socket closed");
                }
                if (d3 > 0.0d) {
                    NetworkDiagnosticTools networkDiagnosticTools = NetworkDiagnosticTools.this;
                    if (d3 < networkDiagnosticTools.downloadMin) {
                        networkDiagnosticTools.downloadMin = (double) ((float) d3);
                    }
                }
                if (d3 > 0.0d) {
                    NetworkDiagnosticTools networkDiagnosticTools2 = NetworkDiagnosticTools.this;
                    if (d3 > networkDiagnosticTools2.downloadMax) {
                        networkDiagnosticTools2.downloadMax = (double) ((float) d3);
                    }
                }
                NetworkDiagnosticTools networkDiagnosticTools3 = NetworkDiagnosticTools.this;
                networkDiagnosticTools3.mListener.downloadTestUpdate(0, 0, 0, (double) networkDiagnosticTools3.downloadAvg);
                if (d2 >= 1.0d) {
                    NetworkDiagnosticTools networkDiagnosticTools4 = NetworkDiagnosticTools.this;
                    networkDiagnosticTools4.downloadMax = (networkDiagnosticTools4.downloadMax / 8.0d) * 1024.0d * 1024.0d;
                    networkDiagnosticTools4.downloadMin = (networkDiagnosticTools4.downloadMin / 8.0d) * 1024.0d * 1024.0d;
                    NetworkDiagnosticTools networkDiagnosticTools5 = NetworkDiagnosticTools.this;
                    networkDiagnosticTools4.onDownloadTestComplete(new BandwidthTestResults(1, networkDiagnosticTools5.bandwidthAlgorithm, (float) networkDiagnosticTools5.downloadMin, (float) networkDiagnosticTools5.downloadMax, networkDiagnosticTools5.downloadAvg, networkDiagnosticTools5.receivedDataSize));
                }
            }

            public void onEnd() {
            }

            public void onIPInfoUpdate(String str) {
                if (str != null && !str.equals("") && !str.equals(" ")) {
                    str.split(" ");
                }
                NetworkDiagnosticTools.this.libreTestSetup("P");
                NetworkDiagnosticTools.this.libreTest();
            }

            public void onPingJitterUpdate(double d, double d2, double d3) {
                int i = (int) (d3 * 10.0d);
                if (i > 0) {
                    boolean[] zArr = zArr;
                    int i2 = i - 1;
                    if (!zArr[i2]) {
                        zArr[i2] = true;
                        NetworkDiagnosticTools.this.mListener.latencyUpdate(d, 10, i, d2);
                        arrayList.add(Double.valueOf(d));
                        arrayList2.add(Double.valueOf(d2));
                        return;
                    }
                    LatencyTestResults latencyTestResults = new LatencyTestResults();
                    if (NetworkDiagnosticTools.this.ipAddresses.size() > 0) {
                        latencyTestResults.setServerIP(NetworkDiagnosticTools.this.ipAddresses.get(0));
                        latencyTestResults.setAlgorithm(4);
                    }
                    NetworkDiagnosticTools.this.doManualLatencyCalculations(arrayList, latencyTestResults, arrayList2);
                    NetworkDiagnosticTools.this.onLatencyTestComplete(latencyTestResults);
                }
            }

            public void onTestIDReceived(String str, String str2) {
            }

            public void onUploadUpdate(double d, double d2) {
                double d3 = d;
                float f = (float) ((d3 / 8.0d) * 1024.0d * 1024.0d);
                NetworkDiagnosticTools.this.uploadAvg = f;
                if (f < 0.0f) {
                    onCriticalFailure("Socket closed");
                }
                NetworkDiagnosticTools networkDiagnosticTools = NetworkDiagnosticTools.this;
                double r6 = (double) networkDiagnosticTools.uploadAvg;
                if (r6 > 0.0d && r6 < networkDiagnosticTools.uploadMin) {
                    networkDiagnosticTools.uploadMin = d3;
                }
                if (r6 > 0.0d && r6 > networkDiagnosticTools.uploadMax) {
                    networkDiagnosticTools.uploadMax = d3;
                }
                networkDiagnosticTools.mListener.uploadTestUpdate(0.0d, 0.0d, 0.0d, r6);
                if (d2 >= 1.0d) {
                    NetworkDiagnosticTools networkDiagnosticTools2 = NetworkDiagnosticTools.this;
                    networkDiagnosticTools2.uploadMax = (networkDiagnosticTools2.uploadMax / 8.0d) * 1024.0d * 1024.0d;
                    networkDiagnosticTools2.uploadMin = (networkDiagnosticTools2.uploadMin / 8.0d) * 1024.0d * 1024.0d;
                    NetworkDiagnosticTools networkDiagnosticTools3 = NetworkDiagnosticTools.this;
                    networkDiagnosticTools2.onUploadTestComplete(new BandwidthTestResults(2, networkDiagnosticTools3.bandwidthAlgorithm, (float) networkDiagnosticTools3.uploadMin, (float) networkDiagnosticTools3.uploadMax, networkDiagnosticTools3.uploadAvg, 0));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void libreTestSetup(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "http://"
            java.lang.String r1 = "{\"test_order\":\""
            java.lang.String r2 = com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTestConfig.LIBRE_DEFAULT_OVERHEAD_FACTOR
            java.lang.String r3 = "D"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x0012
            java.lang.String r2 = r8.libreDlOverheadFactor
            goto L_0x001c
        L_0x0012:
            java.lang.String r3 = "U"
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x001c
            java.lang.String r2 = r8.libreUlOverheadFactor
        L_0x001c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r3.<init>(r1)     // Catch:{ all -> 0x00b9 }
            r3.append(r9)     // Catch:{ all -> 0x00b9 }
            java.lang.String r9 = "\",\"getIp_ispInfo\":\"false\",\"time_auto\":\"true\",\"overheadCompensationFactor\":\""
            r3.append(r9)     // Catch:{ all -> 0x00b9 }
            r3.append(r2)     // Catch:{ all -> 0x00b9 }
            java.lang.String r9 = "\"}"
            r3.append(r9)     // Catch:{ all -> 0x00b9 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x00b9 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00b9 }
            r1.<init>(r9)     // Catch:{ all -> 0x00b9 }
            com.m2catalyst.m2sdk.k6 r9 = new com.m2catalyst.m2sdk.k6     // Catch:{ all -> 0x00b9 }
            r9.<init>(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.String r1 = "{}"
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00b9 }
            r2.<init>(r1)     // Catch:{ all -> 0x00b9 }
            com.m2catalyst.m2sdk.o6 r1 = new com.m2catalyst.m2sdk.o6     // Catch:{ all -> 0x00b9 }
            r1.<init>(r2)     // Catch:{ all -> 0x00b9 }
            com.m2catalyst.m2sdk.j6 r2 = libreSpeedTest     // Catch:{ all -> 0x00b9 }
            if (r2 == 0) goto L_0x0053
            r2.a()     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            com.m2catalyst.m2sdk.j6 r2 = new com.m2catalyst.m2sdk.j6     // Catch:{ all -> 0x00b9 }
            r2.<init>()     // Catch:{ all -> 0x00b9 }
            libreSpeedTest = r2     // Catch:{ all -> 0x00b9 }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = "NDT"
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.getLogger(r3)     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = "NDT"
            java.lang.String r4 = "Libre setup successful"
            r5 = 0
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ all -> 0x00b9 }
            r2.d(r3, r4, r6)     // Catch:{ all -> 0x00b9 }
            com.m2catalyst.m2sdk.j6 r2 = libreSpeedTest     // Catch:{ all -> 0x00b9 }
            r2.a((com.m2catalyst.m2sdk.k6) r9)     // Catch:{ all -> 0x00b9 }
            com.m2catalyst.m2sdk.j6 r9 = libreSpeedTest     // Catch:{ all -> 0x00b9 }
            java.lang.Object r2 = r9.e     // Catch:{ all -> 0x00b9 }
            monitor-enter(r2)     // Catch:{ all -> 0x00b9 }
            int r3 = r9.d     // Catch:{ all -> 0x00b6 }
            if (r3 != 0) goto L_0x00ae
            com.m2catalyst.m2sdk.o6 r3 = new com.m2catalyst.m2sdk.o6     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = r1.a     // Catch:{ all -> 0x00b6 }
            java.lang.String r6 = r1.b     // Catch:{ all -> 0x00b6 }
            java.lang.String r7 = r1.c     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = r1.d     // Catch:{ all -> 0x00b6 }
            r3.<init>(r4, r6, r7, r1)     // Catch:{ all -> 0x00b6 }
            r9.c = r3     // Catch:{ all -> 0x00b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b6 }
            com.m2catalyst.m2sdk.r6 r9 = new com.m2catalyst.m2sdk.r6     // Catch:{ all -> 0x00b9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r1.<init>(r0)     // Catch:{ all -> 0x00b9 }
            java.util.ArrayList<java.lang.String> r0 = r8.ipAddresses     // Catch:{ all -> 0x00b9 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00b9 }
            r1.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = ":8000"
            r1.append(r0)     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00b9 }
            r9.<init>(r0)     // Catch:{ all -> 0x00b9 }
            com.m2catalyst.m2sdk.j6 r0 = libreSpeedTest     // Catch:{ all -> 0x00b9 }
            r0.a((com.m2catalyst.m2sdk.r6) r9)     // Catch:{ all -> 0x00b9 }
            return
        L_0x00ae:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b6 }
            java.lang.String r0 = "Cannot change config at this moment"
            r9.<init>(r0)     // Catch:{ all -> 0x00b6 }
            throw r9     // Catch:{ all -> 0x00b6 }
        L_0x00b6:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00b6 }
            throw r9     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            r9 = move-exception
            java.io.PrintStream r0 = java.lang.System.err
            r0.println(r9)
            r9 = 0
            libreSpeedTest = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.libreTestSetup(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void onDownloadTestComplete(BandwidthTestResults bandwidthTestResults) {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        logger.d(TAG, "Test number:" + this.currentTestResults.getDebugTestNumber() + " - Download Test complete", new String[0]);
        this.currentTestResults.setDownloadTestResults(bandwidthTestResults);
        this.currentTestResults.setEndTime(Long.valueOf(System.currentTimeMillis()));
        ThroughputTestSystemListener throughputTestSystemListener = this.mListener;
        if (throughputTestSystemListener != null) {
            throughputTestSystemListener.downloadTestComplete(bandwidthTestResults);
        }
    }

    /* access modifiers changed from: private */
    public void onLatencyTestComplete(LatencyTestResults latencyTestResults) {
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        M2SDKLogger logger = companion.getLogger(TAG);
        logger.d(TAG, "test number:" + this.currentTestResults.getDebugTestNumber() + " - Latency Test Complete", new String[0]);
        this.currentTestResults.setLatencyResults(latencyTestResults);
        this.currentTestResults.setEndTime(Long.valueOf(System.currentTimeMillis()));
        M2SDKLogger logger2 = companion.getLogger(TAG);
        logger2.d(TAG, "latency end time: " + this.currentTestResults.getEndTime(), new String[0]);
        ThroughputTestSystemListener throughputTestSystemListener = this.mListener;
        if (throughputTestSystemListener != null) {
            throughputTestSystemListener.latencyTestComplete(latencyTestResults);
        }
    }

    /* access modifiers changed from: private */
    public void onUploadTestComplete(BandwidthTestResults bandwidthTestResults) {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        logger.d(TAG, "Test number:" + this.currentTestResults.getDebugTestNumber() + " - Upload Test complete", new String[0]);
        this.currentTestResults.setUploadTestResults(bandwidthTestResults);
        this.currentTestResults.setEndTime(Long.valueOf(System.currentTimeMillis()));
        ThroughputTestSystemListener throughputTestSystemListener = this.mListener;
        if (throughputTestSystemListener != null) {
            throughputTestSystemListener.uploadTestComplete(bandwidthTestResults);
            this.mListener.throughputTestComplete(this.currentTestResults);
        }
    }

    private String readFileFromAssets(String str) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.context.getAssets().open(str)));
        String str2 = "";
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str2 = str2 + readLine;
            } catch (EOFException unused) {
            }
        }
        return str2;
    }

    private void removeNetworkConnectivityListener(Context context2) {
        if (this.networkChangeReceiver != null && context2 != null) {
            try {
                context2.getApplicationContext().unregisterReceiver(this.networkChangeReceiver);
            } catch (IllegalArgumentException e) {
                M2SDKLogger.Companion.getLogger(TAG).e(TAG, "Error unregistering NetworkConnectivityListener", e.getMessage());
            }
            this.networkChangeReceiver = null;
        }
    }

    private void setupUploadTest() {
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        M2SDKLogger logger = companion.getLogger(TAG);
        logger.d(TAG, this.currentTestResults.getDebugTestNumber() + " - Setup Upload test Begin...", new String[0]);
        this.uploadTestSpeeds.clear();
        this.uploadTestSpeedsAverages.clear();
        WebSocketClient webSocketClient = this.mWebSocketClient;
        if (webSocketClient == null || !webSocketClient.isOpen()) {
            M2SDKLogger logger2 = companion.getLogger(TAG);
            logger2.d(TAG, "WebSocket not open for upload test, mWebSocketClient" + this.mWebSocketClient, new String[0]);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "upload");
            jSONObject.put("count", this.sentCount * this.numberOfThreads);
            jSONObject.put("dataSize", this.dataSize);
            jSONObject.put("algorithm", this.bandwidthAlgorithm);
        } catch (JSONException e) {
            M2SDKLogger logger3 = M2SDKLogger.Companion.getLogger(TAG);
            logger3.e(TAG, "Failure constructing upload JSON object " + e.getLocalizedMessage(), new String[0]);
            e.printStackTrace();
        }
        this.startTime = SystemClock.elapsedRealtime();
        this.mWebSocketClient.send(jSONObject.toString());
    }

    /* access modifiers changed from: private */
    public void startDownloadTest() {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        StringBuilder sb = new StringBuilder();
        sb.append(this.currentTestResults.getDebugTestNumber());
        sb.append(" - Start download test Begin...Data Size = ");
        double d = (double) this.dataSize;
        Double.isNaN(d);
        sb.append((d / 1024.0d) / 1024.0d);
        sb.append(" MB");
        logger.d(TAG, sb.toString(), new String[0]);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", NativeAdPresenter.DOWNLOAD);
            jSONObject.put("count", this.sentCount);
            jSONObject.put("dataSize", this.dataSize);
            jSONObject.put("algorithm", this.bandwidthAlgorithm);
        } catch (JSONException e) {
            M2SDKLogger logger2 = M2SDKLogger.Companion.getLogger(TAG);
            logger2.e(TAG, "Failure constructing download JSON object " + e.getLocalizedMessage(), new String[0]);
            e.printStackTrace();
        }
        try {
            this.mWebSocketClient.send(jSONObject.toString());
        } catch (WebsocketNotConnectedException e2) {
            M2SDKLogger logger3 = M2SDKLogger.Companion.getLogger(TAG);
            logger3.e(TAG, "Websocket not connected download: " + e2.getMessage(), new String[0]);
            testFailure(e2.getClass().getName(), 2);
        }
        this.sentDuration = SystemClock.elapsedRealtime() - this.startTime;
    }

    /* access modifiers changed from: private */
    public void startUploadTest() {
        WebSocketClient webSocketClient;
        this.responseCount = 0;
        int i = this.dataSize;
        byte[] bArr = new byte[i];
        new Random().nextBytes(bArr);
        int i2 = 0;
        while (i2 < this.sentCount) {
            try {
                if (isTestRunning() && (webSocketClient = this.mWebSocketClient) != null && webSocketClient.isOpen() && !this.mWebSocketClient.isClosing()) {
                    M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
                    logger.d(TAG, Thread.currentThread().getId() + "," + this.mWebSocketClient.hashCode() + ", send, " + i + ", " + i2 + ", " + this.sentCount, new String[0]);
                    this.mWebSocketClient.send(bArr);
                }
                i2++;
            } catch (WebsocketNotConnectedException e) {
                M2SDKLogger logger2 = M2SDKLogger.Companion.getLogger(TAG);
                logger2.e(TAG, "WebSocket not connected for upload: " + e.getLocalizedMessage(), new String[0]);
                if (isTestRunning()) {
                    testFailure(e.getClass().getName(), 2);
                }
            }
        }
        this.sentDuration = SystemClock.elapsedRealtime() - this.startTime;
    }

    /* access modifiers changed from: private */
    public void testFailure(String str, int i) {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        logger.d(TAG, "Throughput test failure: " + str + ", " + i, new String[0]);
        setTestRunning(false);
        this.mListener.testFailed(str, i, true);
    }

    /* access modifiers changed from: private */
    public ArrayList<Double> trimSpeeds(ArrayList<Double> arrayList) {
        trimByIQRMean(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void updateNetworkType(Context context2) {
        this.networkType = NDTMigrationUtilsWrapper.INSTANCE.getActiveDataNetworkType(context2);
    }

    public Stats calculateStats(List<Double> list) {
        Stats stats = new Stats();
        if (!(list == null || list.size() == 0)) {
            stats.min = list.get(0).doubleValue();
            stats.max = list.get(0).doubleValue();
            double d = 0.0d;
            double d2 = 0.0d;
            for (Double doubleValue : list) {
                double doubleValue2 = doubleValue.doubleValue();
                d2 += doubleValue2;
                if (doubleValue2 < stats.min) {
                    stats.min = doubleValue2;
                }
                if (doubleValue2 > stats.max) {
                    stats.max = doubleValue2;
                }
            }
            double size = (double) list.size();
            Double.isNaN(size);
            double d3 = d2 / size;
            stats.avg = d3;
            double[] dArr = new double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                double pow = Math.pow(list.get(i).doubleValue() - d3, 2.0d);
                dArr[i] = pow;
                d += pow;
            }
            double size2 = (double) list.size();
            Double.isNaN(size2);
            stats.standardDeviation = Math.sqrt(d / size2);
        }
        return stats;
    }

    public void disconnect() {
        if (this.mWebSocketClient != null) {
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
            logger.d(TAG, this.currentTestResults.getDebugTestNumber() + " - Close web socket, " + this.mWebSocketClient.hashCode(), new String[0]);
            this.mWebSocketClient.close();
            this.mWebSocketClient = null;
        }
    }

    public void doManualLatencyCalculations(ArrayList<Double> arrayList, LatencyTestResults latencyTestResults, ArrayList<Double> arrayList2) {
        if (latencyTestResults == null || arrayList == null || arrayList.size() == 0) {
            this.mListener.setTestFailedCalledTrue();
            this.mListener.finishTesting();
            M2SDKLogger.Companion.getLogger(TAG).d(TAG, "manual calculation aborted", new String[0]);
            return;
        }
        Stats calculateStats = calculateStats(arrayList);
        latencyTestResults.setAverage(Float.valueOf((float) calculateStats.avg));
        latencyTestResults.setMinimum(Float.valueOf((float) calculateStats.min));
        latencyTestResults.setMaximum(Float.valueOf((float) calculateStats.max));
        latencyTestResults.setLatencyTimes(arrayList);
        latencyTestResults.setJitter(Double.valueOf(calculateJitter(arrayList, arrayList2)));
        ArrayList arrayList3 = new ArrayList();
        Iterator<Double> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(Double.valueOf(Math.pow(it.next().doubleValue() - calculateStats.avg, 2.0d)));
        }
        latencyTestResults.setMDev(Float.valueOf((float) Math.sqrt(calculateStats(arrayList3).avg)));
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        logger.d(TAG, "manual calculation : " + latencyTestResults.toMessage(), new String[0]);
    }

    public void forceStopTest() {
        j6 j6Var = libreSpeedTest;
        if (j6Var != null) {
            j6Var.a();
        }
        this.mListener.setTestFailedCalledFalse();
        this.mListener.testFailed("Manual test initiated", -1, false);
    }

    public Float getAverageFromList(List<Float> list, Float f) {
        if (list.size() == 0) {
            list.add(f);
            return f;
        }
        Float valueOf = Float.valueOf((f.floatValue() + Float.valueOf(list.get(list.size() - 1).floatValue() * ((float) list.size())).floatValue()) / ((float) (list.size() + 1)));
        list.add(valueOf);
        return valueOf;
    }

    public DiagnosticsResults getCurrentTestResults() {
        return this.currentTestResults;
    }

    public Network getNetwork() {
        return this.network;
    }

    public LatencyTestResults getPingStats(String str, ArrayList<Double> arrayList) {
        LatencyTestResults latencyTestResults = new LatencyTestResults();
        try {
            str = str.substring(str.indexOf("/mdev = ") + 8, str.lastIndexOf(" ms"));
            String[] split = str.split("/");
            latencyTestResults.setMinimum(Float.valueOf(split[0]));
            latencyTestResults.setMaximum(Float.valueOf(split[2]));
            latencyTestResults.setAverage(Float.valueOf(split[1]));
            latencyTestResults.setMDev(Float.valueOf(split[3]));
            latencyTestResults.setLatencyTimes(arrayList);
            latencyTestResults.setJitter(Double.valueOf(calculateJitter(arrayList, (ArrayList<Double>) null)));
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
            logger.d(TAG, "calculating test times:: " + latencyTestResults.toMessage(), new String[0]);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            M2SDKLogger logger2 = M2SDKLogger.Companion.getLogger(TAG);
            logger2.e(TAG, "calculation error: " + e.getMessage() + "String: " + str, new String[0]);
            doManualLatencyCalculations(arrayList, latencyTestResults, (ArrayList<Double>) null);
        }
        return latencyTestResults;
    }

    public int getResponseCount() {
        return this.responseCount;
    }

    public boolean hasAverageSpeedsSettled(List<Double> list) {
        if (list.size() < 20) {
            return false;
        }
        Stats calculateStats = calculateStats(list.subList(list.size() - 20, list.size()));
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        logger.d(TAG, "Average Speed Stats, " + calculateStats.standardDeviation + ", " + calculateStats.avg + ", " + (calculateStats.standardDeviation / calculateStats.avg), new String[0]);
        if (calculateStats.standardDeviation / calculateStats.avg < 0.01d) {
            return true;
        }
        return false;
    }

    public void initializeNewTest(Context context2, MNSI mnsi2, NetworkDiagnosticTestConfig networkDiagnosticTestConfig) {
        M2SDKLogger.Companion.getLogger(TAG).d(TAG, "initializeNewTest", new String[0]);
        this.context = context2;
        this.mnsi = mnsi2;
        this.downloadConnectionTimedOut = false;
        this.downloadAverageLeveledOut = false;
        updateNetworkType(context2);
        addNetworkConnectivityListener(context2);
        DiagnosticsResults diagnosticsResults = new DiagnosticsResults();
        this.currentTestResults = diagnosticsResults;
        diagnosticsResults.setTimeOffset(o1.a(Long.valueOf(mnsi2.getTimeStamp())));
        this.currentTestResults.setConnectionType(Integer.valueOf(NDTMigrationUtilsWrapper.INSTANCE.getActiveDataNetworkType(context2)));
        this.currentTestResults.setMnsi(mnsi2);
        this.bandwidthAlgorithm = networkDiagnosticTestConfig.bandwidthAlgorithm.intValue();
        this.latencyAlgorithm = networkDiagnosticTestConfig.LatencyAlgorithm.intValue();
        this.libreDlOverheadFactor = networkDiagnosticTestConfig.getLibreDlOverheadFactor();
        this.libreUlOverheadFactor = networkDiagnosticTestConfig.getLibreUlOverheadFactor();
    }

    public boolean isTestRunning() {
        return this.isTestRunning;
    }

    public boolean isValidSpeed(double d) {
        return isValidSpeed(d, true);
    }

    public boolean isWebSocketConnected() {
        return this.mWebSocketClient.isOpen();
    }

    public void monitorConnectivityManager(Context context2) {
    }

    public LatencyTestResults ping(String str) {
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        companion.getLogger(TAG).d(TAG, "start-ping", new String[0]);
        Runtime runtime = Runtime.getRuntime();
        if (this.pingProcess != null) {
            return null;
        }
        this.pingProcess = runtime.exec("ping -c 10 " + str2);
        companion.getLogger(TAG).d(TAG, "pinging", new String[0]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.pingProcess.getInputStream()));
        ArrayList arrayList = new ArrayList();
        int i = 1;
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            sb.append(readLine);
            sb.append("\n");
            M2SDKLogger.Companion companion2 = M2SDKLogger.Companion;
            companion2.getLogger(TAG).d(TAG, "echo line: ".concat(readLine), new String[0]);
            if (readLine.contains("time=")) {
                int indexOf = readLine.indexOf("time=");
                M2SDKLogger logger = companion2.getLogger(TAG);
                logger.d(TAG, "start time index: " + indexOf, new String[0]);
                try {
                    double parseDouble = Double.parseDouble(readLine.substring(indexOf + 5, readLine.indexOf(" ms")));
                    M2SDKLogger logger2 = companion2.getLogger(TAG);
                    logger2.d(TAG, "latency value: " + parseDouble, new String[0]);
                    this.mListener.latencyUpdate(parseDouble, 10, i, 0.0d);
                    arrayList.add(Double.valueOf(parseDouble));
                    i++;
                } catch (StringIndexOutOfBoundsException e) {
                    M2SDKLogger logger3 = M2SDKLogger.Companion.getLogger(TAG);
                    logger3.e(TAG, "error: " + e.getLocalizedMessage(), new String[0]);
                    e.printStackTrace();
                }
            }
        }
        M2SDKLogger.Companion companion3 = M2SDKLogger.Companion;
        M2SDKLogger logger4 = companion3.getLogger(TAG);
        logger4.d(TAG, "before calculation latency times: " + arrayList.size(), new String[0]);
        M2SDKLogger logger5 = companion3.getLogger(TAG);
        logger5.d(TAG, "before calculation full echo: " + sb.toString(), new String[0]);
        LatencyTestResults pingStats = getPingStats(sb.toString(), arrayList);
        pingStats.setServerIP(str2);
        this.pingProcess = null;
        M2SDKLogger logger6 = companion3.getLogger(TAG);
        logger6.d(TAG, this.currentTestResults.getDebugTestNumber() + " - Latency Results: " + pingStats.toMessage(), new String[0]);
        return pingStats;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.getLogger(TAG);
        r2.e(TAG, r6.currentTestResults.getDebugTestNumber() + " - Interrupted Exception: Reconnect unsuccessful", new java.lang.String[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0081, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
        r6.reconnecting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean reconnectWebSocket() {
        /*
            r6 = this;
            java.lang.String r0 = "NDT"
            r1 = 1
            r6.reconnecting = r1
            r1 = 0
            org.java_websocket.client.WebSocketClient r2 = r6.mWebSocketClient     // Catch:{ InterruptedException -> 0x005d }
            if (r2 == 0) goto L_0x0036
            boolean r2 = r2.reconnectBlocking()     // Catch:{ InterruptedException -> 0x005d }
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ InterruptedException -> 0x005d }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r3 = r3.getLogger(r0)     // Catch:{ InterruptedException -> 0x005d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x005d }
            r4.<init>()     // Catch:{ InterruptedException -> 0x005d }
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r5 = r6.currentTestResults     // Catch:{ InterruptedException -> 0x005d }
            int r5 = r5.getDebugTestNumber()     // Catch:{ InterruptedException -> 0x005d }
            r4.append(r5)     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String r5 = " - Reconnect successful: "
            r4.append(r5)     // Catch:{ InterruptedException -> 0x005d }
            r4.append(r2)     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String r4 = r4.toString()     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ InterruptedException -> 0x005d }
            r3.d(r0, r4, r5)     // Catch:{ InterruptedException -> 0x005d }
            r6.reconnecting = r1
            return r2
        L_0x0036:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ InterruptedException -> 0x005d }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.getLogger(r0)     // Catch:{ InterruptedException -> 0x005d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x005d }
            r3.<init>()     // Catch:{ InterruptedException -> 0x005d }
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r4 = r6.currentTestResults     // Catch:{ InterruptedException -> 0x005d }
            int r4 = r4.getDebugTestNumber()     // Catch:{ InterruptedException -> 0x005d }
            r3.append(r4)     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String r4 = " - Websocket client is null, cannot reconnectWebSocket"
            r3.append(r4)     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String r3 = r3.toString()     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String[] r4 = new java.lang.String[r1]     // Catch:{ InterruptedException -> 0x005d }
            r2.d(r0, r3, r4)     // Catch:{ InterruptedException -> 0x005d }
            r6.reconnecting = r1
            return r1
        L_0x005b:
            r0 = move-exception
            goto L_0x0082
        L_0x005d:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion     // Catch:{ all -> 0x005b }
            com.m2catalyst.m2sdk.logger.M2SDKLogger r2 = r2.getLogger(r0)     // Catch:{ all -> 0x005b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r3.<init>()     // Catch:{ all -> 0x005b }
            com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults r4 = r6.currentTestResults     // Catch:{ all -> 0x005b }
            int r4 = r4.getDebugTestNumber()     // Catch:{ all -> 0x005b }
            r3.append(r4)     // Catch:{ all -> 0x005b }
            java.lang.String r4 = " - Interrupted Exception: Reconnect unsuccessful"
            r3.append(r4)     // Catch:{ all -> 0x005b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005b }
            java.lang.String[] r4 = new java.lang.String[r1]     // Catch:{ all -> 0x005b }
            r2.e(r0, r3, r4)     // Catch:{ all -> 0x005b }
            r6.reconnecting = r1
            return r1
        L_0x0082:
            r6.reconnecting = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.speed_test.legacy.NetworkDiagnosticTools.reconnectWebSocket():boolean");
    }

    public void registerListener(ThroughputTestSystemListener throughputTestSystemListener) {
        this.mListener = throughputTestSystemListener;
    }

    public void reinitializeWebSocket() {
        this.reconnecting = true;
        if (!this.mWebSocketClient.isOpen()) {
            connect();
        } else {
            this.mWebSocketClient.close();
        }
    }

    public void removeImpossibles(ArrayList<Double> arrayList) {
        removeImpossibles(arrayList, true);
    }

    public void removeListener(ThroughputTestSystemListener throughputTestSystemListener) {
        ArrayList<ThroughputTestSystemListener> arrayList = this.listeners;
        if (arrayList != null) {
            arrayList.remove(throughputTestSystemListener);
        }
    }

    public void runDownloadTest() {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        logger.d(TAG, "runDownloadTest, " + this.mWebSocketClient, new String[0]);
        if (this.bandwidthAlgorithm == 4) {
            libreTestSetup("D");
            libreTest();
            return;
        }
        WebSocketClient webSocketClient = this.mWebSocketClient;
        if (webSocketClient != null && webSocketClient.isOpen()) {
            MonitorStatsLogger.INSTANCE.increment(LoggingEvents.NDT_START_TEST_DOWNLOAD, 1, false);
            this.startTime = SystemClock.elapsedRealtime();
            this.responseCount = 0;
            this.receivedDataSize = 0;
            this.receivedDataTimes = new ArrayList<>();
            this.receivedPacketSizes = new ArrayList<>();
            this.downloadTestSpeeds.clear();
            this.downloadTestSpeedsAverages.clear();
            for (int i = 0; i < this.numberOfThreads; i++) {
                new Thread(new Runnable() {
                    public void run() {
                        NetworkDiagnosticTools.this.startDownloadTest();
                    }
                }).start();
            }
        }
    }

    public LatencyTestResults runLatencyTest() {
        MonitorStatsLogger.INSTANCE.increment(LoggingEvents.NDT_START_TEST_LATENCY, 1, false);
        int i = this.latencyAlgorithm;
        LatencyTestResults latencyTestResults = null;
        if (i == 3) {
            M2SDKLogger.Companion.getLogger(TAG).d(TAG, "Run ISO ping test", new String[0]);
            try {
                latencyTestResults = ping(new URI(getWebSocketUrl()).getHost());
                latencyTestResults.setAlgorithm(Integer.valueOf(this.latencyAlgorithm));
            } catch (IOException | InterruptedException | URISyntaxException e) {
                M2SDKLogger.Companion companion = M2SDKLogger.Companion;
                M2SDKLogger logger = companion.getLogger(TAG);
                logger.e(TAG, "Ping URI exceptionFailure to connect: " + e.getMessage(), new String[0]);
                e.printStackTrace();
                M2SDKLogger logger2 = companion.getLogger(TAG);
                logger2.e(TAG, "latency error: " + e.getMessage(), new String[0]);
            }
            onLatencyTestComplete(latencyTestResults);
        } else if (i == 4) {
            M2SDKLogger.Companion.getLogger(TAG).d(TAG, "Run Libre ping test", new String[0]);
            libreTestSetup("P");
            libreTest();
        }
        return latencyTestResults;
    }

    public void runUploadTest() {
        MonitorStatsLogger.INSTANCE.increment(LoggingEvents.NDT_START_TEST_UPLOAD, 1, false);
        if (this.bandwidthAlgorithm == 4) {
            libreTestSetup("U");
            libreTest();
            return;
        }
        setupUploadTest();
        this.startTime = SystemClock.elapsedRealtime();
        for (int i = 0; i < this.numberOfThreads; i++) {
            new Thread(new Runnable() {
                public void run() {
                    NetworkDiagnosticTools.this.startUploadTest();
                }
            }).start();
        }
    }

    public void setNetwork(Network network2) {
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger(TAG);
        logger.d(TAG, "setNetwork - " + network2, new String[0]);
        this.network = network2;
    }

    public void setTestRunning(boolean z) {
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        M2SDKLogger logger = companion.getLogger(TAG);
        logger.d(TAG, "set test running, " + z, new String[0]);
        this.isTestRunning = z;
        if (!z && this.pingProcess != null) {
            companion.getLogger().d(TAG, "Ping Process still running.... destroy it.", new String[0]);
            this.pingProcess.destroy();
            this.pingProcess = null;
        }
        if (!z) {
            removeNetworkConnectivityListener(this.context);
        }
    }

    public boolean setUpWebSocketClient(int i, int i2, int i3) {
        setTestRunning(true);
        this.totalDataSize = i2;
        this.dataSize = i;
        this.bandwidthAlgorithm = i3;
        this.sentCount = (i2 / i) / this.numberOfThreads;
        if (this.ipAddresses.size() != 0) {
            connect();
            return true;
        }
        setTestRunning(false);
        return false;
    }

    public void stopManualTest() {
        j6 j6Var = libreSpeedTest;
        if (j6Var != null) {
            j6Var.a();
        }
        this.mListener.setTestFailedCalledTrue();
        this.mListener.finishTesting();
    }

    public ArrayList<Double> trimByIQRMean(ArrayList<Double> arrayList) {
        Collections.sort(arrayList);
        if (arrayList.size() <= 1) {
            return arrayList;
        }
        double mean = getMean(arrayList);
        double doubleValue = mean - arrayList.get(0).doubleValue();
        double doubleValue2 = arrayList.get(arrayList.size() - 1).doubleValue() - mean;
        double median = (getMedian(getUpperQuartile(arrayList)) - getMedian(getLowerQuartile(arrayList))) * 1.5d;
        if (doubleValue > doubleValue2) {
            if (doubleValue <= median) {
                return arrayList;
            }
            arrayList.remove(0);
            return trimByIQRMean(arrayList);
        } else if (doubleValue2 <= median) {
            return arrayList;
        } else {
            arrayList.remove(arrayList.size() - 1);
            return trimByIQRMean(arrayList);
        }
    }

    public boolean isValidSpeed(double d, boolean z) {
        int dataNetworkType;
        if (d < 0.0d) {
            return false;
        }
        MNSI mnsi2 = this.mnsi;
        double d2 = 2.62144E8d;
        if (!(mnsi2 == null || this.networkType != 0 || (dataNetworkType = mnsi2.getDataNetworkType()) == 20)) {
            switch (dataNetworkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    d2 = 39321.6d;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 17:
                    d2 = 943718.4d;
                    break;
                case 13:
                    d2 = 3.93216E7d;
                    break;
                case 15:
                    d2 = 5505024.0d;
                    break;
            }
        }
        if (!z) {
            d2 = ((d2 / 1024.0d) / 1024.0d) * 8.0d;
        }
        if (d < d2) {
            return true;
        }
        return false;
    }

    public void removeImpossibles(ArrayList<Double> arrayList, boolean z) {
        Iterator<Double> it = arrayList.iterator();
        arrayList.size();
        while (it.hasNext()) {
            if (!isValidSpeed(it.next().doubleValue(), z)) {
                it.remove();
            }
        }
    }
}
