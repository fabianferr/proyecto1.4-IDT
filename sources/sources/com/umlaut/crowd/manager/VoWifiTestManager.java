package com.umlaut.crowd.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CDC;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.DRI;
import com.umlaut.crowd.internal.DWI;
import com.umlaut.crowd.internal.RBR;
import com.umlaut.crowd.internal.a2;
import com.umlaut.crowd.internal.aa;
import com.umlaut.crowd.internal.e4;
import com.umlaut.crowd.internal.f2;
import com.umlaut.crowd.internal.fe;
import com.umlaut.crowd.internal.g3;
import com.umlaut.crowd.internal.i9;
import com.umlaut.crowd.internal.k3;
import com.umlaut.crowd.internal.qd;
import com.umlaut.crowd.internal.rc;
import com.umlaut.crowd.internal.re;
import com.umlaut.crowd.internal.ub;
import com.umlaut.crowd.internal.v;
import com.umlaut.crowd.internal.w2;
import com.umlaut.crowd.internal.x3;
import com.umlaut.crowd.speedtest.IBandwidthListener;
import com.umlaut.crowd.speedtest.SpeedtestEngineError;
import com.umlaut.crowd.speedtest.SpeedtestEngineStatus;
import com.umlaut.crowd.timeserver.TimeServer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class VoWifiTestManager {
    private static final String s = "VoWifiTestManager";
    private static final boolean t = false;
    private static final String u = "Q0xJRU5UIFJFUVVFU1Q=";
    private static final String v = "U0VSVkVSIEFOU1dFUg==";
    private static final String w = "LlhKIDipf84AAAAAAAAAACEgIggAAAAAAAABKCIAAGwAAABoAQEACwMAAAwBAAAMgA4BAAMAAAwBAAAMgA4AgAMAAAgBAAADAwAACAEAAAIDAAAIAgAAAgMAAAgCAAABAwAACAMAAAIDAAAIAwAAAQMAAAgEAAACAwAACAQAAAUAAAAIBAAADigAAIgAAgAAVxYPFCtnxOFOt5Eg1tglVo5ME2TEzc4XHI8uahJlSuU8tZjJN3JVGX3Vix2FcE0ih02ljAsmc3RYC8/uor3yerj80ofsY8317/8pS+/3fLgb4duneSiobxcIrNHg0uRGsb7WFVJtJaK6b94i14MaOdrNqtH2H10GVRJu++QRrXUAAAAYOjCSIPd0/CK5KdH87vGbTmhtDeU=";
    private static final int x = 86400000;
    /* access modifiers changed from: private */
    public Context a;
    /* access modifiers changed from: private */
    public String b;
    /* access modifiers changed from: private */
    public boolean c;
    /* access modifiers changed from: private */
    public NetworkInfo.State d = NetworkInfo.State.UNKNOWN;
    private h e;
    /* access modifiers changed from: private */
    public CLC f;
    /* access modifiers changed from: private */
    public VoWifiTestListener g;
    /* access modifiers changed from: private */
    public boolean h;
    private String i;
    private String j;
    /* access modifiers changed from: private */
    public String k;
    private AsyncTask l;
    private boolean m;
    private qd n;
    private Thread o;
    private DatagramSocket p;
    private DatagramSocket q;
    /* access modifiers changed from: private */
    public HashMap<String, Long> r;

    enum ProgressState {
        DeviceInfoReported,
        WiFiAndRadioInfoReported,
        LatencyTestStarted,
        LatencyTestReported,
        InternalIpAddressReported,
        ExternalIpAddressStarted,
        ExternalIpAddressReported,
        DNSLookupStarted,
        DNSLookupReported,
        EpdgIkeResponseStarted,
        EpdgIkeResponseReported,
        PortTestStarted,
        PortTestReported
    }

    public interface VoWifiTestListener {
        void OnPortTestReported(e eVar);

        void onDNSLookupReported(String str);

        void onDNSLookupStarted();

        void onDeviceInfoReported(a2 a2Var);

        void onEpdgIkeResponseReported(d dVar);

        void onEpdgIkeResponseStarted();

        void onExternalIpAddressReported(e4 e4Var);

        void onExternalIpAddressStarted();

        void onInternalIpAddressReported(String str);

        void onLatencyTestReported(int i);

        void onLatencyTestStarted();

        void onPortTestStarted();

        void onTestStatusChanged(f fVar, qd qdVar);

        void onWiFiAndRadioInfoReported(DWI dwi, DRI dri);
    }

    class a implements IBandwidthListener {
        final /* synthetic */ int[] a;
        final /* synthetic */ CountDownLatch b;

        a(int[] iArr, CountDownLatch countDownLatch) {
            this.a = iArr;
            this.b = countDownLatch;
        }

        public void onPingProgress(float f, int i) {
            int[] iArr = this.a;
            iArr[0] = iArr[0] + i;
            iArr[1] = iArr[1] + 1;
        }

        public void onTestStatusChanged(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j) {
            if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ABORTED) {
                this.b.countDown();
            }
        }

        public void onTracerouteProgress(float f, String str, int i, int i2) {
        }

        public void onTransferProgress(float f, long j) {
        }

        public void onTransferProgressRemote(float f, long j) {
        }
    }

    class b implements Runnable {
        final /* synthetic */ v a;
        final /* synthetic */ qd b;
        final /* synthetic */ CountDownLatch c;

        b(v vVar, qd qdVar, CountDownLatch countDownLatch) {
            this.a = vVar;
            this.b = qdVar;
            this.c = countDownLatch;
        }

        public void run() {
            this.a.i(this.b.VwtId);
            String a2 = VoWifiTestManager.this.k;
            if (a2.isEmpty()) {
                a2 = this.b.EPDGServerIp;
            }
            this.a.a(a2, 10, 200, 5000, 56, false, true, com.umlaut.crowd.internal.a.Unknown);
            try {
                this.c.await(30, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
                this.a.a();
            }
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState[] r0 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.DeviceInfoReported     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.WiFiAndRadioInfoReported     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.InternalIpAddressReported     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.ExternalIpAddressStarted     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.ExternalIpAddressReported     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.LatencyTestStarted     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.LatencyTestReported     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.DNSLookupStarted     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.DNSLookupReported     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.EpdgIkeResponseStarted     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.EpdgIkeResponseReported     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.PortTestStarted     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.umlaut.crowd.manager.VoWifiTestManager$ProgressState r1 = com.umlaut.crowd.manager.VoWifiTestManager.ProgressState.PortTestReported     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.manager.VoWifiTestManager.c.<clinit>():void");
        }
    }

    public class d {
        public byte[] a = new byte[0];
        public byte[] b = new byte[0];
        public int c = -1;
        public int d = -1;
        public int e = -1;
        public int f = -1;
        public x3 g;
        public x3 h;
        public boolean i;

        public d() {
            x3 x3Var = x3.UNKNOWN;
            this.g = x3Var;
            this.h = x3Var;
            this.i = false;
        }
    }

    public enum f {
        Started,
        Canceled,
        Finished
    }

    private class g extends AsyncTask<Void, a, qd> {

        class a {
            ProgressState a;
            Object[] b;

            a() {
            }
        }

        private g() {
        }

        private void a(ProgressState progressState, Object... objArr) {
            if (VoWifiTestManager.this.g != null) {
                a aVar = new a();
                aVar.a = progressState;
                aVar.b = objArr;
                publishProgress(new a[]{aVar});
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            if (VoWifiTestManager.this.g != null) {
                VoWifiTestManager.this.g.onTestStatusChanged(f.Canceled, (qd) null);
            }
            boolean unused = VoWifiTestManager.this.c = false;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = VoWifiTestManager.this.c = true;
            if (VoWifiTestManager.this.g != null) {
                VoWifiTestManager.this.g.onTestStatusChanged(f.Started, (qd) null);
            }
        }

        /* synthetic */ g(VoWifiTestManager voWifiTestManager, a aVar) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(a... aVarArr) {
            super.onProgressUpdate(aVarArr);
            if (VoWifiTestManager.this.g != null && aVarArr != null && aVarArr.length != 0) {
                a aVar = aVarArr[0];
                switch (c.a[aVar.a.ordinal()]) {
                    case 1:
                        VoWifiTestManager.this.g.onDeviceInfoReported((a2) aVar.b[0]);
                        return;
                    case 2:
                        VoWifiTestListener c = VoWifiTestManager.this.g;
                        Object[] objArr = aVar.b;
                        c.onWiFiAndRadioInfoReported((DWI) objArr[0], (DRI) objArr[1]);
                        return;
                    case 3:
                        VoWifiTestManager.this.g.onInternalIpAddressReported((String) aVar.b[0]);
                        return;
                    case 4:
                        VoWifiTestManager.this.g.onExternalIpAddressStarted();
                        return;
                    case 5:
                        VoWifiTestManager.this.g.onExternalIpAddressReported((e4) aVar.b[0]);
                        return;
                    case 6:
                        VoWifiTestManager.this.g.onLatencyTestStarted();
                        return;
                    case 7:
                        VoWifiTestManager.this.g.onLatencyTestReported(((Integer) aVar.b[0]).intValue());
                        return;
                    case 8:
                        VoWifiTestManager.this.g.onDNSLookupStarted();
                        return;
                    case 9:
                        VoWifiTestManager.this.g.onDNSLookupReported((String) aVar.b[0]);
                        return;
                    case 10:
                        VoWifiTestManager.this.g.onEpdgIkeResponseStarted();
                        return;
                    case 11:
                        VoWifiTestManager.this.g.onEpdgIkeResponseReported((d) aVar.b[0]);
                        return;
                    case 12:
                        VoWifiTestManager.this.g.onPortTestStarted();
                        return;
                    case 13:
                        VoWifiTestManager.this.g.OnPortTestReported((e) aVar.b[0]);
                        return;
                    default:
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public qd doInBackground(Void... voidArr) {
            qd qdVar = new qd(VoWifiTestManager.this.b, new IS(VoWifiTestManager.this.a).q());
            qdVar.TriggerEvent = rc.Automatic;
            ub timeInfo = TimeServer.getTimeInfo();
            qdVar.TimeInfoOnStart = timeInfo;
            qdVar.VwtId = k3.a(timeInfo, qdVar.GUID);
            DRI j = InsightCore.getRadioController().j();
            qdVar.RadioInfoOnStart = j;
            a2 deviceInfo = CDC.getDeviceInfo(VoWifiTestManager.this.a);
            qdVar.DeviceInfo = deviceInfo;
            a(ProgressState.DeviceInfoReported, deviceInfo);
            DWI wifiInfo = InsightCore.getWifiController().getWifiInfo();
            qdVar.WifiInfoOnStart = wifiInfo;
            a(ProgressState.WiFiAndRadioInfoReported, wifiInfo, j);
            qdVar.LocationInfoOnStart = VoWifiTestManager.this.f.getLastLocationInfo();
            qdVar.FirmwareCSC = VoWifiTestManager.this.a();
            fe feVar = wifiInfo.WifiDetailedState;
            if (!(feVar == fe.Unknown ? wifiInfo.WifiState == re.Enabled : feVar == fe.CONNECTED)) {
                return qdVar;
            }
            a(ProgressState.InternalIpAddressReported, InsightCore.getWifiController().d());
            if (isCancelled()) {
                return null;
            }
            a(ProgressState.ExternalIpAddressStarted, new Object[0]);
            e4 b = g3.a(VoWifiTestManager.this.a).b(j, wifiInfo, false);
            a(ProgressState.ExternalIpAddressReported, b);
            try {
                e4 e4Var = (e4) b.clone();
                if (!b.IpAddress.isEmpty()) {
                    InetAddress byName = InetAddress.getByName(b.IpAddress);
                    e4Var.IpAddress = "";
                    e4Var.IpAddress = aa.a(byName);
                    qdVar.IspInfo = e4Var;
                }
            } catch (Exception unused) {
            }
            if (isCancelled()) {
                return null;
            }
            a(ProgressState.DNSLookupStarted, new Object[0]);
            String epdgServerIp = VoWifiTestManager.this.getEpdgServerIp();
            qdVar.EPDGServerIp = epdgServerIp;
            a(ProgressState.DNSLookupReported, epdgServerIp);
            if (isCancelled()) {
                return null;
            }
            if (epdgServerIp != null && !epdgServerIp.isEmpty()) {
                a(ProgressState.EpdgIkeResponseStarted, new Object[0]);
                d epdgIkeResponse = VoWifiTestManager.this.getEpdgIkeResponse(qdVar.EPDGServerIp);
                qdVar.EPDGResponse1 = Base64.encodeToString(epdgIkeResponse.a, 2);
                qdVar.EPDGResponse2 = Base64.encodeToString(epdgIkeResponse.b, 2);
                qdVar.EPDGResponse1FirstPayload = epdgIkeResponse.c;
                qdVar.EPDGResponse2FirstPayload = epdgIkeResponse.d;
                qdVar.EPDGResponse1NotifyMessageCode = epdgIkeResponse.e;
                qdVar.EPDGResponse2NotifyMessageCode = epdgIkeResponse.f;
                qdVar.EPDGResponse1NotifyMessageType = epdgIkeResponse.g;
                qdVar.EPDGResponse2NotifyMessageType = epdgIkeResponse.h;
                qdVar.EPDGHandshakeSuccessful = epdgIkeResponse.i;
                a(ProgressState.EpdgIkeResponseReported, epdgIkeResponse);
                if (isCancelled()) {
                    return null;
                }
                a(ProgressState.LatencyTestStarted, new Object[0]);
                a(ProgressState.LatencyTestReported, Integer.valueOf(VoWifiTestManager.this.getLatency(qdVar)));
                if (isCancelled()) {
                    return null;
                }
            }
            a(ProgressState.PortTestStarted, new Object[0]);
            e portTestResult = VoWifiTestManager.this.getPortTestResult();
            qdVar.Port500Open = portTestResult.a;
            qdVar.Port4500Open = portTestResult.b;
            qdVar.Port10000Open = portTestResult.c;
            qdVar.Port5060Open = portTestResult.d;
            qdVar.Port5061Open = portTestResult.e;
            a(ProgressState.PortTestReported, portTestResult);
            if (VoWifiTestManager.this.h) {
                return null;
            }
            qdVar.TimeInfoOnEnd = TimeServer.getTimeInfo();
            qdVar.RadioInfoOnEnd = InsightCore.getRadioController().j();
            qdVar.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
            qdVar.LocationInfoOnEnd = VoWifiTestManager.this.f.getLastLocationInfo();
            return qdVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(qd qdVar) {
            super.onPostExecute(qdVar);
            if (qdVar != null) {
                if (VoWifiTestManager.this.g != null) {
                    VoWifiTestManager.this.g.onTestStatusChanged(f.Finished, qdVar);
                }
                InsightCore.getDatabaseHelper().a(w2.VWT, (RBR) qdVar);
                VoWifiTestManager.this.r.put(qdVar.WifiInfoOnStart.WifiBSSID_Full, Long.valueOf(SystemClock.elapsedRealtime()));
            } else if (VoWifiTestManager.this.g != null) {
                VoWifiTestManager.this.g.onTestStatusChanged(f.Canceled, (qd) null);
            }
            boolean unused = VoWifiTestManager.this.c = false;
        }
    }

    private class h extends BroadcastReceiver {
        private h() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && !aa.c(intent.getAction()) && intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (VoWifiTestManager.this.d == NetworkInfo.State.CONNECTING && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    if (!VoWifiTestManager.this.c && !VoWifiTestManager.this.a(InsightCore.getWifiController().getWifiInfo().WifiBSSID_Full)) {
                        VoWifiTestManager.this.startFullTest();
                    }
                } else if (VoWifiTestManager.this.d == NetworkInfo.State.CONNECTED && ((networkInfo.getState() == NetworkInfo.State.DISCONNECTED || networkInfo.getState() == NetworkInfo.State.DISCONNECTING) && VoWifiTestManager.this.c)) {
                    VoWifiTestManager.this.cancelFullTest();
                }
                NetworkInfo.State unused = VoWifiTestManager.this.d = networkInfo.getState();
            }
        }

        /* synthetic */ h(VoWifiTestManager voWifiTestManager, a aVar) {
            this();
        }
    }

    public VoWifiTestManager(Context context) {
        this.a = context;
        IC insightConfig = InsightCore.getInsightConfig();
        this.b = insightConfig.f1();
        this.e = new h(this, (a) null);
        this.f = new CLC(context);
        this.i = insightConfig.X1();
        this.j = insightConfig.V1();
        this.k = insightConfig.U1();
        this.r = new HashMap<>();
    }

    public void beginTest() {
        qd qdVar = new qd(this.b, new IS(this.a).q());
        this.n = qdVar;
        qdVar.TriggerEvent = rc.Manual;
        this.h = false;
        ub timeInfo = TimeServer.getTimeInfo();
        qd qdVar2 = this.n;
        qdVar2.TimeInfoOnStart = timeInfo;
        qdVar2.VwtId = k3.a(timeInfo, qdVar2.GUID);
        this.n.RadioInfoOnStart = InsightCore.getRadioController().j();
        this.n.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
        this.n.LocationInfoOnStart = this.f.getLastLocationInfo();
        this.n.DeviceInfo = CDC.getDeviceInfo(this.a);
        this.n.FirmwareCSC = a();
    }

    public void cancelEpdgIkeRequest() {
        DatagramSocket datagramSocket = this.q;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public void cancelFullTest() {
        if (this.c) {
            this.h = true;
            AsyncTask asyncTask = this.l;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
        }
    }

    public void cancelLatencyTest() {
        Thread thread = this.o;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public void cancelPortTest() {
        this.m = true;
        DatagramSocket datagramSocket = this.p;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public void endTest() {
        qd qdVar = this.n;
        if (qdVar != null) {
            qdVar.TimeInfoOnEnd = TimeServer.getTimeInfo();
            this.n.RadioInfoOnEnd = InsightCore.getRadioController().j();
            this.n.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
            this.n.LocationInfoOnEnd = this.f.getLastLocationInfo();
            InsightCore.getDatabaseHelper().a(w2.VWT, (RBR) this.n);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0178, code lost:
        if (r2 != null) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0187, code lost:
        if (r2 == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0189, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x018c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.umlaut.crowd.manager.VoWifiTestManager.d getEpdgIkeResponse(java.lang.String r23) {
        /*
            r22 = this;
            r1 = r22
            com.umlaut.crowd.manager.VoWifiTestManager$d r0 = new com.umlaut.crowd.manager.VoWifiTestManager$d
            r0.<init>()
            java.lang.String r2 = "LlhKIDipf84AAAAAAAAAACEgIggAAAAAAAABKCIAAGwAAABoAQEACwMAAAwBAAAMgA4BAAMAAAwBAAAMgA4AgAMAAAgBAAADAwAACAEAAAIDAAAIAgAAAgMAAAgCAAABAwAACAMAAAIDAAAIAwAAAQMAAAgEAAACAwAACAQAAAUAAAAIBAAADigAAIgAAgAAVxYPFCtnxOFOt5Eg1tglVo5ME2TEzc4XHI8uahJlSuU8tZjJN3JVGX3Vix2FcE0ih02ljAsmc3RYC8/uor3yerj80ofsY8317/8pS+/3fLgb4duneSiobxcIrNHg0uRGsb7WFVJtJaK6b94i14MaOdrNqtH2H10GVRJu++QRrXUAAAAYOjCSIPd0/CK5KdH87vGbTmhtDeU="
            r3 = 0
            byte[] r2 = android.util.Base64.decode(r2, r3)
            java.net.DatagramPacket r4 = new java.net.DatagramPacket     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r5 = r2.length     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.InetAddress r6 = java.net.InetAddress.getByName(r23)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r7 = 500(0x1f4, float:7.0E-43)
            r4.<init>(r2, r5, r6, r7)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramPacket r5 = new java.net.DatagramPacket     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r6]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r5.<init>(r8, r6)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramSocket r8 = new java.net.DatagramSocket     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r8.<init>()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r1.q = r8     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r9 = 10000(0x2710, float:1.4013E-41)
            r8.setSoTimeout(r9)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramSocket r8 = r1.q     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r8.send(r4)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramSocket r4 = r1.q     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r4.receive(r5)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r4 = r5.getLength()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte[] r8 = new byte[r4]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte[] r10 = r5.getData()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r5 = r5.getLength()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.lang.System.arraycopy(r10, r3, r8, r3, r5)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.a = r8     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r5 = 2
            r10 = 1
            r11 = 16
            if (r4 <= r11) goto L_0x0064
            byte[] r12 = new byte[r5]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r12[r3] = r3     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r13 = r8[r11]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r12[r10] = r13     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r12)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            short r12 = r12.getShort()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.c = r12     // Catch:{ IOException -> 0x0184, all -> 0x017b }
        L_0x0064:
            int r12 = r0.c     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r13 = 33
            if (r12 != r13) goto L_0x006e
            r0.i = r10     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            goto L_0x0176
        L_0x006e:
            r14 = 36
            if (r4 < r14) goto L_0x0176
            r15 = 41
            if (r12 != r15) goto L_0x0176
            byte[] r12 = new byte[r5]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r16 = 34
            byte r17 = r8[r16]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r12[r3] = r17     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r17 = 35
            byte r18 = r8[r17]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r12[r10] = r18     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r12)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            short r12 = r12.getShort()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.e = r12     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            com.umlaut.crowd.internal.x3 r9 = r1.a((int) r12)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.g = r9     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r9 = 16390(0x4006, float:2.2967E-41)
            if (r12 != r9) goto L_0x0176
            r9 = 52
            if (r4 < r9) goto L_0x0176
            r2[r11] = r15     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte[] r4 = new byte[r11]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.lang.System.arraycopy(r8, r14, r4, r3, r11)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r8 = 24
            byte[] r12 = new byte[r8]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r12[r3] = r13     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r12[r10] = r3     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r12[r5] = r3     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r18 = 3
            r12[r18] = r8     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r19 = 4
            r12[r19] = r3     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r20 = 5
            r12[r20] = r3     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r20 = 64
            r21 = 6
            r12[r21] = r20     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r20 = 7
            r12[r20] = r21     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r15 = 8
            java.lang.System.arraycopy(r4, r3, r12, r15, r11)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r4 = r2.length     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r4 = r4 + r8
            byte[] r15 = new byte[r4]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r14 = 28
            java.lang.System.arraycopy(r2, r3, r15, r3, r14)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.lang.System.arraycopy(r12, r3, r15, r14, r8)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r12 = r2.length     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r12 = r12 - r14
            java.lang.System.arraycopy(r2, r14, r15, r9, r12)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.allocate(r19)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.nio.ByteBuffer r2 = r9.putInt(r2)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte[] r2 = r2.array()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r9 = r2[r3]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r15[r8] = r9     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r8 = r2[r10]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r9 = 25
            r15[r9] = r8     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r8 = r2[r5]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r9 = 26
            r15[r9] = r8     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r2 = r2[r18]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r8 = 27
            r15[r8] = r2     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramPacket r2 = new java.net.DatagramPacket     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.lang.String r8 = r1.j     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.InetAddress r8 = java.net.InetAddress.getByName(r8)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r2.<init>(r15, r4, r8, r7)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramPacket r4 = new java.net.DatagramPacket     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte[] r7 = new byte[r6]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r4.<init>(r7, r6)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramSocket r6 = r1.q     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r7 = 10000(0x2710, float:1.4013E-41)
            r6.setSoTimeout(r7)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramSocket r6 = r1.q     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r6.send(r2)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.net.DatagramSocket r2 = r1.q     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r2.receive(r4)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r2 = r4.getLength()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte[] r6 = new byte[r2]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte[] r7 = r4.getData()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            int r4 = r4.getLength()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.lang.System.arraycopy(r7, r3, r6, r3, r4)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.b = r6     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            if (r2 <= r11) goto L_0x0176
            byte[] r4 = new byte[r5]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r4[r3] = r3     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r7 = r6[r11]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r4[r10] = r7     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            short r4 = r4.getShort()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.d = r4     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            if (r4 != r13) goto L_0x0152
            r0.i = r10     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            goto L_0x0176
        L_0x0152:
            r4 = 36
            if (r2 < r4) goto L_0x0176
            byte r2 = r6[r11]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r4 = 41
            if (r2 != r4) goto L_0x0176
            byte[] r2 = new byte[r5]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r4 = r6[r16]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r2[r3] = r4     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            byte r3 = r6[r17]     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r2[r10] = r3     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            short r2 = r2.getShort()     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.f = r2     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            com.umlaut.crowd.internal.x3 r2 = r1.a((int) r2)     // Catch:{ IOException -> 0x0184, all -> 0x017b }
            r0.h = r2     // Catch:{ IOException -> 0x0184, all -> 0x017b }
        L_0x0176:
            java.net.DatagramSocket r2 = r1.q
            if (r2 == 0) goto L_0x018c
            goto L_0x0189
        L_0x017b:
            r0 = move-exception
            java.net.DatagramSocket r2 = r1.q
            if (r2 == 0) goto L_0x0183
            r2.close()
        L_0x0183:
            throw r0
        L_0x0184:
            java.net.DatagramSocket r2 = r1.q
            if (r2 == 0) goto L_0x018c
        L_0x0189:
            r2.close()
        L_0x018c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.manager.VoWifiTestManager.getEpdgIkeResponse(java.lang.String):com.umlaut.crowd.manager.VoWifiTestManager$d");
    }

    public String getEpdgServerIp() {
        try {
            return f2.a().b(this.j, 10000);
        } catch (UnknownHostException unused) {
            return "";
        }
    }

    public int getLatency(qd qdVar) {
        int[] iArr = {0, 0};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        v vVar = new v(new a(iArr, countDownLatch), this.a);
        Thread thread = new Thread(new b(vVar, qdVar, countDownLatch));
        this.o = thread;
        thread.start();
        try {
            this.o.join();
        } catch (InterruptedException unused) {
            vVar.a();
        }
        int i2 = iArr[1];
        if (i2 <= 0) {
            return -1;
        }
        return iArr[0] / i2;
    }

    public e getPortTestResult() {
        int i2;
        this.m = false;
        e eVar = new e();
        try {
            String str = this.i;
            ArrayList arrayList = new ArrayList();
            arrayList.add(10000);
            arrayList.add(5060);
            arrayList.add(5061);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(500);
            arrayList2.add(Integer.valueOf(IronSourceConstants.NT_AUCTION_REQUEST));
            Iterator it = arrayList.iterator();
            while (true) {
                i2 = 3000;
                if (!it.hasNext()) {
                    break;
                }
                Integer num = (Integer) it.next();
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(str, num.intValue()), 3000);
                    socket.close();
                    eVar.a(num.intValue(), true);
                } catch (Exception unused) {
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Integer num2 = (Integer) it2.next();
                DatagramSocket datagramSocket = new DatagramSocket();
                this.p = datagramSocket;
                datagramSocket.setSoTimeout(i2);
                InetAddress byName = InetAddress.getByName(str);
                byte[] bytes = u.getBytes();
                int length = v.getBytes().length;
                byte[] bArr = new byte[length];
                int i3 = 0;
                boolean z = false;
                while (true) {
                    if (i3 >= 3) {
                        break;
                    } else if (z) {
                        break;
                    } else if (this.h) {
                        break;
                    } else if (this.m) {
                        break;
                    } else {
                        this.p.send(new DatagramPacket(bytes, bytes.length, byName, num2.intValue()));
                        DatagramPacket datagramPacket = new DatagramPacket(bArr, length);
                        try {
                            this.p.receive(datagramPacket);
                            if (new String(datagramPacket.getData()).equals(v)) {
                                eVar.a(num2.intValue(), true);
                                z = true;
                            }
                        } catch (IOException unused2) {
                        }
                        i3++;
                    }
                }
                this.p.close();
                i2 = 3000;
            }
        } catch (IOException unused3) {
        }
        return eVar;
    }

    public qd getVoWifiTestResult() {
        return this.n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isConnectedToWifi() {
        /*
            r4 = this;
            com.umlaut.crowd.internal.qd r0 = r4.n
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.umlaut.crowd.internal.DWI r0 = r0.WifiInfoOnStart
            com.umlaut.crowd.internal.fe r2 = r0.WifiDetailedState
            com.umlaut.crowd.internal.fe r3 = com.umlaut.crowd.internal.fe.Unknown
            if (r2 == r3) goto L_0x0013
            com.umlaut.crowd.internal.fe r0 = com.umlaut.crowd.internal.fe.CONNECTED
            if (r2 != r0) goto L_0x001a
            goto L_0x0019
        L_0x0013:
            com.umlaut.crowd.internal.re r0 = r0.WifiState
            com.umlaut.crowd.internal.re r2 = com.umlaut.crowd.internal.re.Enabled
            if (r0 != r2) goto L_0x001a
        L_0x0019:
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.manager.VoWifiTestManager.isConnectedToWifi():boolean");
    }

    public void resetOnStartInfo() {
        qd qdVar = this.n;
        if (qdVar != null) {
            qdVar.TimeInfoOnStart = TimeServer.getTimeInfo();
            this.n.RadioInfoOnStart = InsightCore.getRadioController().j();
            this.n.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
            this.n.LocationInfoOnStart = this.f.getLastLocationInfo();
        }
    }

    public void setVoWifiTestListener(VoWifiTestListener voWifiTestListener) {
        this.g = voWifiTestListener;
    }

    public void startFullTest() {
        if (!this.c) {
            this.h = false;
            this.l = new g(this, (a) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void startListeners(CLC.ProviderMode providerMode) {
        this.f.startListening(providerMode);
    }

    public void startMonitor() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.a.registerReceiver(this.e, intentFilter);
        startListeners(CLC.ProviderMode.Passive);
    }

    public void stopListeners() {
        this.f.stopListening();
    }

    public void stopMonitor() {
        h hVar = this.e;
        if (hVar != null) {
            try {
                this.a.unregisterReceiver(hVar);
            } catch (Exception e2) {
                String str = s;
                Log.e(str, "stopMonitor: " + e2.getMessage());
            }
        }
        stopListeners();
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashMap<String, Long> hashMap = new HashMap<>();
        for (String next : this.r.keySet()) {
            long longValue = this.r.get(next).longValue();
            if (elapsedRealtime - longValue < 86400000) {
                hashMap.put(next, Long.valueOf(longValue));
            }
        }
        this.r = hashMap;
        return hashMap.containsKey(str);
    }

    public class e {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;

        public e() {
        }

        public void a(int i, boolean z) {
            if (i == 500) {
                this.a = z;
            } else if (i == 4500) {
                this.b = z;
            } else if (i == 10000) {
                this.c = z;
            } else if (i == 5060) {
                this.d = z;
            } else if (i == 5061) {
                this.e = z;
            }
        }

        public boolean a() {
            return this.a && this.b && this.c && this.d && this.e;
        }
    }

    private x3 a(int i2) {
        if (i2 == 1) {
            return x3.UNSUPPORTED_CRITICAL_PAYLOAD;
        }
        if (i2 == 7) {
            return x3.INVALID_SYNTAX;
        }
        if (i2 == 9) {
            return x3.INVALID_MESSAGE_ID;
        }
        if (i2 == 11) {
            return x3.INVALID_SPI;
        }
        if (i2 == 14) {
            return x3.NO_PROPOSAL_CHOSEN;
        }
        if (i2 == 17) {
            return x3.INVALID_KE_PAYLOAD;
        }
        if (i2 == 24) {
            return x3.AUTHENTICATION_FAILED;
        }
        if (i2 == 16393) {
            return x3.REKEY_SA;
        }
        if (i2 == 4) {
            return x3.INVALID_IKE_SPI;
        }
        if (i2 == 5) {
            return x3.INVALID_MAJOR_VERSION;
        }
        switch (i2) {
            case 35:
                return x3.NO_ADDITIONAL_SAS;
            case 36:
                return x3.INTERNAL_ADDRESS_FAILURE;
            case 37:
                return x3.FAILED_CP_REQUIRED;
            case 38:
                return x3.TS_UNACCEPTABLE;
            case 39:
                return x3.INVALID_SELECTORS;
            case 40:
                return x3.TEMPORARY_FAILURE;
            case 41:
                return x3.CHILD_SA_NOT_FOUND;
            default:
                switch (i2) {
                    case 16388:
                        return x3.NAT_DETECTION_SOURCE_IP;
                    case 16389:
                        return x3.NAT_DETECTION_DESTINATION_IP;
                    case 16390:
                        return x3.COOKIE;
                    default:
                        return x3.UNKNOWN;
                }
        }
    }

    /* access modifiers changed from: private */
    public String a() {
        String[] b2 = i9.b("getprop ril.official_cscver");
        if (b2.length <= 0 || b2[0].isEmpty()) {
            return aa.a(Build.DISPLAY);
        }
        return b2[0];
    }
}
