package com.umlaut.crowd.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.rtt.RangingRequest;
import android.net.wifi.rtt.RangingResult;
import android.net.wifi.rtt.RangingResultCallback;
import android.net.wifi.rtt.WifiRttManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.format.Formatter;
import android.util.Log;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class ee {
    private static final String t = "ee";
    private static final boolean u = false;
    public static final int v = -1;
    /* access modifiers changed from: private */
    public final WifiManager a;
    private re b;
    private WifiRttManager c;
    private final ConnectivityManager d;
    private h e;
    private boolean f = false;
    private final z7 g;
    private final Context h;
    private String i = "";
    private boolean j;
    private Method k;
    private final long l;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public boolean n = false;
    private final Object o = new Object();
    private String p = "";
    /* access modifiers changed from: private */
    public final Set<ne> q;
    /* access modifiers changed from: private */
    public ArrayList<c1> r;
    /* access modifiers changed from: private */
    public WifiConfiguration s;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ee.this.c();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            WifiConfiguration wifiConfiguration;
            if (ee.this.a != null) {
                List<WifiConfiguration> configuredNetworks = ee.this.a.getConfiguredNetworks();
                if (configuredNetworks != null) {
                    Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        wifiConfiguration = it.next();
                        if (wifiConfiguration.status == 0) {
                            break;
                        }
                    }
                }
                wifiConfiguration = null;
                synchronized (ee.this) {
                    WifiConfiguration unused = ee.this.s = wifiConfiguration;
                }
            }
        }
    }

    class c extends RangingResultCallback {
        final /* synthetic */ List a;

        c(List list) {
            this.a = list;
        }

        public void onRangingFailure(int i) {
            for (ne a2 : ee.this.q) {
                a2.a(this.a, (List<RangingResult>) null);
            }
        }

        public void onRangingResults(List<RangingResult> list) {
            for (ne a2 : ee.this.q) {
                a2.a(this.a, list);
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            if (!ee.this.n && !ee.this.m && ee.this.i()) {
                boolean unused = ee.this.n = true;
                ee.this.a(false);
                boolean unused2 = ee.this.n = false;
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            ee.this.a(true);
            InsightCore.getInsightSettings().e(SystemClock.elapsedRealtime());
            boolean unused = ee.this.m = false;
        }
    }

    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        static {
            /*
                com.umlaut.crowd.internal.fe[] r0 = com.umlaut.crowd.internal.fe.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.umlaut.crowd.internal.fe r2 = com.umlaut.crowd.internal.fe.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.fe r3 = com.umlaut.crowd.internal.fe.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.fe r4 = com.umlaut.crowd.internal.fe.SUSPENDED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.umlaut.crowd.internal.d[] r3 = com.umlaut.crowd.internal.d.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                a = r3
                com.umlaut.crowd.internal.d r4 = com.umlaut.crowd.internal.d.Full     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.umlaut.crowd.internal.d r3 = com.umlaut.crowd.internal.d.Anonymized     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.AnonymizedAndHashed     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Hashed     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.None     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.ee.f.<clinit>():void");
        }
    }

    private class g implements Callable<Integer> {
        int a;
        int b;

        g(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            ((com.umlaut.crowd.internal.c1) com.umlaut.crowd.internal.ee.b(r5.c).get(r0)).Online = com.umlaut.crowd.internal.tb.Unknown;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
            ((com.umlaut.crowd.internal.c1) com.umlaut.crowd.internal.ee.b(r5.c).get(r0)).Timestamp = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0082, code lost:
            throw r1;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004b */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer call() throws java.lang.Exception {
            /*
                r5 = this;
                int r0 = r5.a
                r1 = 0
            L_0x0003:
                int r2 = r5.b
                if (r0 > r2) goto L_0x0083
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.internal.ee.this     // Catch:{ Exception -> 0x004b }
                java.util.ArrayList r2 = r2.r     // Catch:{ Exception -> 0x004b }
                java.lang.Object r2 = r2.get(r0)     // Catch:{ Exception -> 0x004b }
                com.umlaut.crowd.internal.c1 r2 = (com.umlaut.crowd.internal.c1) r2     // Catch:{ Exception -> 0x004b }
                java.lang.String r2 = r2.IpAddress_Full     // Catch:{ Exception -> 0x004b }
                java.net.InetAddress r2 = java.net.InetAddress.getByName(r2)     // Catch:{ Exception -> 0x004b }
                r3 = 500(0x1f4, float:7.0E-43)
                boolean r2 = r2.isReachable(r3)     // Catch:{ Exception -> 0x004b }
                com.umlaut.crowd.internal.ee r3 = com.umlaut.crowd.internal.ee.this     // Catch:{ Exception -> 0x004b }
                java.util.ArrayList r3 = r3.r     // Catch:{ Exception -> 0x004b }
                java.lang.Object r3 = r3.get(r0)     // Catch:{ Exception -> 0x004b }
                com.umlaut.crowd.internal.c1 r3 = (com.umlaut.crowd.internal.c1) r3     // Catch:{ Exception -> 0x004b }
                if (r2 == 0) goto L_0x0030
                com.umlaut.crowd.internal.tb r2 = com.umlaut.crowd.internal.tb.Yes     // Catch:{ Exception -> 0x004b }
                goto L_0x0032
            L_0x0030:
                com.umlaut.crowd.internal.tb r2 = com.umlaut.crowd.internal.tb.No     // Catch:{ Exception -> 0x004b }
            L_0x0032:
                r3.Online = r2     // Catch:{ Exception -> 0x004b }
                int r1 = r1 + 1
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.internal.ee.this
                java.util.ArrayList r2 = r2.r
                java.lang.Object r2 = r2.get(r0)
                com.umlaut.crowd.internal.c1 r2 = (com.umlaut.crowd.internal.c1) r2
                long r3 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()
                r2.Timestamp = r3
                goto L_0x006d
            L_0x0049:
                r1 = move-exception
                goto L_0x0070
            L_0x004b:
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.internal.ee.this     // Catch:{ all -> 0x0049 }
                java.util.ArrayList r2 = r2.r     // Catch:{ all -> 0x0049 }
                java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0049 }
                com.umlaut.crowd.internal.c1 r2 = (com.umlaut.crowd.internal.c1) r2     // Catch:{ all -> 0x0049 }
                com.umlaut.crowd.internal.tb r3 = com.umlaut.crowd.internal.tb.Unknown     // Catch:{ all -> 0x0049 }
                r2.Online = r3     // Catch:{ all -> 0x0049 }
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.internal.ee.this
                java.util.ArrayList r2 = r2.r
                java.lang.Object r2 = r2.get(r0)
                com.umlaut.crowd.internal.c1 r2 = (com.umlaut.crowd.internal.c1) r2
                long r3 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()
                r2.Timestamp = r3
            L_0x006d:
                int r0 = r0 + 1
                goto L_0x0003
            L_0x0070:
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.internal.ee.this
                java.util.ArrayList r2 = r2.r
                java.lang.Object r0 = r2.get(r0)
                com.umlaut.crowd.internal.c1 r0 = (com.umlaut.crowd.internal.c1) r0
                long r2 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()
                r0.Timestamp = r2
                throw r1
            L_0x0083:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.ee.g.call():java.lang.Integer");
        }
    }

    private class h extends BroadcastReceiver {
        private h() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                action.hashCode();
                char c = 65535;
                switch (action.hashCode()) {
                    case -1875733435:
                        if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -343630553:
                        if (action.equals("android.net.wifi.STATE_CHANGE")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1878357501:
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        ee.this.a(intent);
                        return;
                    case 1:
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null && networkInfo.getDetailedState() != null) {
                            ee.this.a(fe.fromDetailedState(networkInfo.getDetailedState()));
                            return;
                        }
                        return;
                    case 2:
                        for (ne a2 : ee.this.q) {
                            a2.a(intent);
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* synthetic */ h(ee eeVar, a aVar) {
            this();
        }
    }

    public ee(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.h = applicationContext;
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.d = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 28) {
            this.c = (WifiRttManager) applicationContext.getSystemService("wifirtt");
        }
        this.b = re.Unknown;
        this.q = new HashSet();
        this.r = new ArrayList<>();
        this.g = new z7();
        this.l = InsightCore.getInsightConfig().j2();
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
    }

    /* access modifiers changed from: private */
    public boolean i() {
        if (this.h.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != -1 && this.a.isWifiEnabled() && this.a.getConnectionInfo() != null && this.a.getConnectionInfo().getSupplicantState() == SupplicantState.COMPLETED) {
            return true;
        }
        return false;
    }

    private void n() {
        if (Build.VERSION.SDK_INT < 29) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().submit(new b());
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public com.umlaut.crowd.internal.DWI getWifiInfo() {
        /*
            r10 = this;
            java.lang.String r0 = " Mbps"
            com.umlaut.crowd.internal.DWI r1 = new com.umlaut.crowd.internal.DWI
            r1.<init>()
            android.content.Context r2 = r10.h     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = "android.permission.ACCESS_WIFI_STATE"
            int r2 = r2.checkCallingOrSelfPermission(r3)     // Catch:{ Exception -> 0x01db }
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x0016
            r1.MissingPermission = r4     // Catch:{ Exception -> 0x01db }
            return r1
        L_0x0016:
            android.net.wifi.WifiManager r2 = r10.a     // Catch:{ Exception -> 0x01db }
            if (r2 == 0) goto L_0x01db
            android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x01db }
            if (r2 == 0) goto L_0x01db
            com.umlaut.crowd.internal.re r3 = r10.b     // Catch:{ Exception -> 0x01db }
            r1.WifiState = r3     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = r2.getBSSID()     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = com.umlaut.crowd.internal.aa.a((java.lang.String) r3)     // Catch:{ Exception -> 0x01db }
            r1.WifiBSSID_Full = r3     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = r10.a((java.lang.String) r3)     // Catch:{ Exception -> 0x01db }
            r1.WifiBSSID = r3     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = r2.getSSID()     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = com.umlaut.crowd.internal.aa.a((java.lang.String) r3)     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = com.umlaut.crowd.internal.aa.d(r3)     // Catch:{ Exception -> 0x01db }
            r1.WifiSSID_Full = r3     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = r10.c((java.lang.String) r3)     // Catch:{ Exception -> 0x01db }
            r1.WifiSSID = r3     // Catch:{ Exception -> 0x01db }
            android.net.wifi.SupplicantState r3 = r2.getSupplicantState()     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.se r3 = com.umlaut.crowd.internal.se.fromSupplicantState(r3)     // Catch:{ Exception -> 0x01db }
            r1.WifiSupplicantState = r3     // Catch:{ Exception -> 0x01db }
            android.content.Context r3 = r10.h     // Catch:{ Exception -> 0x01db }
            java.lang.String r5 = "android.permission.ACCESS_NETWORK_STATE"
            int r3 = r3.checkCallingOrSelfPermission(r5)     // Catch:{ Exception -> 0x01db }
            r5 = 0
            if (r3 != 0) goto L_0x0064
            android.net.ConnectivityManager r3 = r10.d     // Catch:{ Exception -> 0x01db }
            android.net.NetworkInfo r3 = r3.getNetworkInfo(r4)     // Catch:{ Exception -> 0x01db }
            goto L_0x0065
        L_0x0064:
            r3 = r5
        L_0x0065:
            if (r3 == 0) goto L_0x0071
            android.net.NetworkInfo$DetailedState r3 = r3.getDetailedState()     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.fe r3 = com.umlaut.crowd.internal.fe.fromDetailedState(r3)     // Catch:{ Exception -> 0x01db }
            r1.WifiDetailedState = r3     // Catch:{ Exception -> 0x01db }
        L_0x0071:
            com.umlaut.crowd.internal.l7 r3 = com.umlaut.crowd.InsightCore.getRadioController()     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.enums.ConnectionTypes r3 = r3.e()     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.re r6 = r10.b     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.re r7 = com.umlaut.crowd.internal.re.Enabled     // Catch:{ Exception -> 0x01db }
            if (r6 != r7) goto L_0x009d
            com.umlaut.crowd.internal.se r6 = r1.WifiSupplicantState     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.se r7 = com.umlaut.crowd.internal.se.COMPLETED     // Catch:{ Exception -> 0x01db }
            if (r6 == r7) goto L_0x008b
            com.umlaut.crowd.internal.fe r6 = r1.WifiDetailedState     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.fe r7 = com.umlaut.crowd.internal.fe.CONNECTED     // Catch:{ Exception -> 0x01db }
            if (r6 != r7) goto L_0x009d
        L_0x008b:
            com.umlaut.crowd.internal.z7 r6 = r10.g     // Catch:{ Exception -> 0x01db }
            boolean r6 = r6.b()     // Catch:{ Exception -> 0x01db }
            if (r6 == 0) goto L_0x00a1
            java.lang.String r6 = r1.WifiBSSID_Full     // Catch:{ Exception -> 0x01db }
            java.lang.String r7 = r10.p     // Catch:{ Exception -> 0x01db }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x01db }
            if (r6 == 0) goto L_0x00a1
        L_0x009d:
            com.umlaut.crowd.enums.ConnectionTypes r6 = com.umlaut.crowd.enums.ConnectionTypes.Ethernet     // Catch:{ Exception -> 0x01db }
            if (r3 != r6) goto L_0x00b0
        L_0x00a1:
            com.umlaut.crowd.internal.z7 r3 = r10.g     // Catch:{ Exception -> 0x01db }
            android.net.wifi.WifiManager r6 = r10.a     // Catch:{ Exception -> 0x01db }
            android.net.ConnectivityManager r7 = r10.d     // Catch:{ Exception -> 0x01db }
            android.content.Context r8 = r10.h     // Catch:{ Exception -> 0x01db }
            java.lang.String r6 = com.umlaut.crowd.internal.z7.a(r6, r7, r8)     // Catch:{ Exception -> 0x01db }
            r3.a((java.lang.String) r6)     // Catch:{ Exception -> 0x01db }
        L_0x00b0:
            java.lang.String r3 = r1.WifiBSSID_Full     // Catch:{ Exception -> 0x01db }
            r10.p = r3     // Catch:{ Exception -> 0x01db }
            int r3 = r2.getRssi()     // Catch:{ Exception -> 0x01db }
            r1.WifiRxLev = r3     // Catch:{ Exception -> 0x01db }
            int r3 = r2.getLinkSpeed()     // Catch:{ Exception -> 0x01db }
            if (r3 < 0) goto L_0x00da
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01db }
            r6.<init>()     // Catch:{ Exception -> 0x01db }
            r6.append(r3)     // Catch:{ Exception -> 0x01db }
            r6.append(r0)     // Catch:{ Exception -> 0x01db }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x01db }
            r1.WifiLinkSpeed = r0     // Catch:{ Exception -> 0x01db }
            long r6 = (long) r3     // Catch:{ Exception -> 0x01db }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r8
            long r6 = r6 * r8
            r1.WifiLinkSpeedBps = r6     // Catch:{ Exception -> 0x01db }
        L_0x00da:
            int r0 = r10.e()     // Catch:{ Exception -> 0x01db }
            r1.WifiLinkQuality = r0     // Catch:{ Exception -> 0x01db }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01db }
            r3 = 21
            if (r0 < r3) goto L_0x00e9
            r10.a((com.umlaut.crowd.internal.DWI) r1, (android.net.wifi.WifiInfo) r2)     // Catch:{ Exception -> 0x01db }
        L_0x00e9:
            com.umlaut.crowd.IC r3 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ Exception -> 0x01db }
            boolean r3 = r3.d2()     // Catch:{ Exception -> 0x01db }
            if (r3 == 0) goto L_0x00fa
            java.lang.String r3 = com.umlaut.crowd.internal.n6.a()     // Catch:{ Exception -> 0x01db }
            r1.WifiMacAddress = r3     // Catch:{ Exception -> 0x01db }
            goto L_0x0104
        L_0x00fa:
            java.lang.String r3 = r2.getMacAddress()     // Catch:{ Exception -> 0x01db }
            java.lang.String r3 = com.umlaut.crowd.internal.aa.a((java.lang.String) r3)     // Catch:{ Exception -> 0x01db }
            r1.WifiMacAddress = r3     // Catch:{ Exception -> 0x01db }
        L_0x0104:
            android.net.wifi.WifiManager r3 = r10.a     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.o3 r3 = r10.a((android.net.wifi.WifiManager) r3)     // Catch:{ Exception -> 0x01db }
            r1.HotspotState = r3     // Catch:{ Exception -> 0x01db }
            r3 = 30
            if (r0 < r3) goto L_0x011a
            int r0 = r2.getWifiStandard()     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.qe r0 = com.umlaut.crowd.internal.qe.getWifiStandard(r0)     // Catch:{ Exception -> 0x01db }
            r1.WifiStandard = r0     // Catch:{ Exception -> 0x01db }
        L_0x011a:
            java.lang.String r0 = r10.i     // Catch:{ Exception -> 0x01db }
            int r0 = r0.length()     // Catch:{ Exception -> 0x01db }
            if (r0 != 0) goto L_0x017e
            r0 = 4
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ Exception -> 0x01db }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01db }
            r0.order(r3)     // Catch:{ Exception -> 0x01db }
            int r2 = r2.getIpAddress()     // Catch:{ Exception -> 0x01db }
            r0.putInt(r2)     // Catch:{ Exception -> 0x01db }
            byte[] r0 = r0.array()     // Catch:{ Exception -> 0x01db }
            java.util.Enumeration r2 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x01db }
            if (r2 == 0) goto L_0x017e
        L_0x013d:
            boolean r3 = r2.hasMoreElements()     // Catch:{ Exception -> 0x01db }
            java.lang.String r6 = r10.i     // Catch:{ Exception -> 0x01db }
            int r6 = r6.length()     // Catch:{ Exception -> 0x01db }
            if (r6 != 0) goto L_0x014b
            r6 = 1
            goto L_0x014c
        L_0x014b:
            r6 = 0
        L_0x014c:
            r3 = r3 & r6
            if (r3 == 0) goto L_0x017e
            java.lang.Object r3 = r2.nextElement()     // Catch:{ Exception -> 0x01db }
            java.net.NetworkInterface r3 = (java.net.NetworkInterface) r3     // Catch:{ Exception -> 0x01db }
            if (r3 == 0) goto L_0x013d
            java.util.Enumeration r6 = r3.getInetAddresses()     // Catch:{ Exception -> 0x01db }
            if (r6 == 0) goto L_0x013d
        L_0x015d:
            boolean r7 = r6.hasMoreElements()     // Catch:{ Exception -> 0x01db }
            if (r7 == 0) goto L_0x013d
            java.lang.Object r7 = r6.nextElement()     // Catch:{ Exception -> 0x01db }
            java.net.InetAddress r7 = (java.net.InetAddress) r7     // Catch:{ Exception -> 0x01db }
            java.net.InetAddress r8 = java.net.InetAddress.getByAddress(r5, r0)     // Catch:{ UnknownHostException -> 0x015d }
            boolean r7 = r7.equals(r8)     // Catch:{ UnknownHostException -> 0x015d }
            if (r7 == 0) goto L_0x015d
            java.lang.String r7 = r3.getName()     // Catch:{ UnknownHostException -> 0x015d }
            java.lang.String r7 = com.umlaut.crowd.internal.aa.a((java.lang.String) r7)     // Catch:{ UnknownHostException -> 0x015d }
            r10.i = r7     // Catch:{ UnknownHostException -> 0x015d }
            goto L_0x013d
        L_0x017e:
            monitor-enter(r10)     // Catch:{ Exception -> 0x01b2 }
            android.net.wifi.WifiConfiguration r0 = r10.s     // Catch:{ all -> 0x01af }
            if (r0 == 0) goto L_0x01ad
            int r2 = r0.status     // Catch:{ all -> 0x01af }
            if (r2 != 0) goto L_0x01ad
            com.umlaut.crowd.internal.ce r0 = r10.a((android.net.wifi.WifiConfiguration) r0)     // Catch:{ all -> 0x01af }
            r1.WifiAuthAlgorithm = r0     // Catch:{ all -> 0x01af }
            android.net.wifi.WifiConfiguration r0 = r10.s     // Catch:{ all -> 0x01af }
            com.umlaut.crowd.internal.je r0 = r10.c((android.net.wifi.WifiConfiguration) r0)     // Catch:{ all -> 0x01af }
            r1.WifiKeyManagement = r0     // Catch:{ all -> 0x01af }
            android.net.wifi.WifiConfiguration r0 = r10.s     // Catch:{ all -> 0x01af }
            com.umlaut.crowd.internal.ie r0 = r10.b((android.net.wifi.WifiConfiguration) r0)     // Catch:{ all -> 0x01af }
            r1.WifiGroupCipher = r0     // Catch:{ all -> 0x01af }
            android.net.wifi.WifiConfiguration r0 = r10.s     // Catch:{ all -> 0x01af }
            com.umlaut.crowd.internal.ke r0 = r10.d((android.net.wifi.WifiConfiguration) r0)     // Catch:{ all -> 0x01af }
            r1.WifiPairwiseCipher = r0     // Catch:{ all -> 0x01af }
            android.net.wifi.WifiConfiguration r0 = r10.s     // Catch:{ all -> 0x01af }
            com.umlaut.crowd.internal.le r0 = r10.e((android.net.wifi.WifiConfiguration) r0)     // Catch:{ all -> 0x01af }
            r1.WifiProtocol = r0     // Catch:{ all -> 0x01af }
        L_0x01ad:
            monitor-exit(r10)     // Catch:{ all -> 0x01af }
            goto L_0x01b2
        L_0x01af:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x01af }
            throw r0     // Catch:{ Exception -> 0x01b2 }
        L_0x01b2:
            com.umlaut.crowd.internal.fe r0 = r1.WifiDetailedState     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.fe r2 = com.umlaut.crowd.internal.fe.CONNECTED     // Catch:{ Exception -> 0x01db }
            if (r0 != r2) goto L_0x01bb
            r10.a()     // Catch:{ Exception -> 0x01db }
        L_0x01bb:
            monitor-enter(r10)     // Catch:{ Exception -> 0x01db }
            com.umlaut.crowd.internal.z7 r0 = r10.g     // Catch:{ all -> 0x01d8 }
            com.umlaut.crowd.internal.z7$b r0 = r0.a()     // Catch:{ all -> 0x01d8 }
            java.lang.String r2 = r0.c     // Catch:{ all -> 0x01d8 }
            r1.RouterName = r2     // Catch:{ all -> 0x01d8 }
            java.lang.String r2 = r0.d     // Catch:{ all -> 0x01d8 }
            r1.RouterModel = r2     // Catch:{ all -> 0x01d8 }
            java.lang.String r2 = r0.e     // Catch:{ all -> 0x01d8 }
            r1.RouterManufacturer = r2     // Catch:{ all -> 0x01d8 }
            java.lang.String r0 = r0.b     // Catch:{ all -> 0x01d8 }
            java.lang.String r0 = r10.b((java.lang.String) r0)     // Catch:{ all -> 0x01d8 }
            r1.DefaultGatewayMacAddress = r0     // Catch:{ all -> 0x01d8 }
            monitor-exit(r10)     // Catch:{ all -> 0x01d8 }
            goto L_0x01db
        L_0x01d8:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x01d8 }
            throw r0     // Catch:{ Exception -> 0x01db }
        L_0x01db:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.ee.getWifiInfo():com.umlaut.crowd.internal.DWI");
    }

    public long h() {
        String str = this.i;
        if (str == null || str.length() == 0) {
            getWifiInfo();
        }
        String str2 = this.i;
        if (str2 == null || str2.length() == 0) {
            return -1;
        }
        return pc.b(this.i);
    }

    public void j() {
        if (this.e == null) {
            this.e = new h(this, (a) null);
        }
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.h.registerReceiver(this.e, intentFilter);
        this.f = true;
    }

    public boolean k() {
        if (this.h.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0 && this.a.isScanAlwaysAvailable() && this.h.checkCallingOrSelfPermission("android.permission.CHANGE_WIFI_STATE") == 0) {
            return this.a.startScan();
        }
        return false;
    }

    public void l() {
        h hVar = this.e;
        if (hVar != null && this.f) {
            try {
                this.f = false;
                this.h.unregisterReceiver(hVar);
            } catch (Exception e2) {
                String str = t;
                Log.e(str, "stopListening" + e2);
            }
        }
    }

    public void m() {
        if (this.l > 0) {
            ThreadManager.getInstance().getCachedThreadPool().submit(new d());
        }
    }

    private ke d(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedPairwiseCiphers.get(2)) {
            return ke.CCMP;
        }
        if (wifiConfiguration.allowedPairwiseCiphers.get(1)) {
            return ke.CCMP;
        }
        if (wifiConfiguration.allowedPairwiseCiphers.get(0)) {
            return ke.CCMP;
        }
        return ke.Unknown;
    }

    private int e() {
        if (this.j) {
            return -1;
        }
        String[] a2 = i9.a("/proc/net/wireless");
        if (a2.length == 0) {
            this.j = true;
            return -1;
        }
        if (a2.length > 2) {
            int i2 = 2;
            while (i2 < a2.length) {
                String[] a3 = aa.a(a2[i2].trim().split(" "));
                if (a3.length <= 4 || !a3[0].equals("wlan0:")) {
                    i2++;
                } else {
                    try {
                        return Integer.parseInt(a3[2].replace(".", ""));
                    } catch (NumberFormatException unused) {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    public long f() {
        if (this.i.length() == 0) {
            getWifiInfo();
        }
        if (this.i.length() == 0) {
            return -1;
        }
        return pc.a(this.i);
    }

    public List<ScanResult> g() {
        if (this.h.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == -1) {
            return null;
        }
        return this.a.getScanResults();
    }

    private String b(String str) {
        int i2;
        if (str.length() == 0 || (i2 = f.a[InsightCore.getInsightConfig().e2().ordinal()]) == 1) {
            return str;
        }
        String str2 = "xx:xx:xx:xx:xx:xx";
        if (i2 != 2) {
            if (i2 == 3) {
                String a2 = k3.a(str);
                if (str.length() == 17) {
                    str2 = str.substring(0, 9) + "xx:xx:xx";
                }
                return "MAC:" + str2 + "-HASH:" + a2;
            } else if (i2 != 4) {
                return "";
            } else {
                return "HASH:" + k3.a(str);
            }
        } else if (str.length() != 17) {
            return str2;
        } else {
            return str.substring(0, 9) + "xx:xx:xx";
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                this.k = wifiManager.getClass().getDeclaredMethod("getWifiApState", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    private String a(String str) {
        int i2;
        if (str.length() == 0 || (i2 = f.a[InsightCore.getInsightConfig().c2().ordinal()]) == 1) {
            return str;
        }
        if (i2 != 2) {
            return "";
        }
        if (str.length() != 17) {
            return "xx:xx:xx:xx:xx:xx";
        }
        return str.substring(0, 9) + "xx:xx:xx";
    }

    private String c(String str) {
        return (str.length() == 0 || f.a[InsightCore.getInsightConfig().f2().ordinal()] == 1) ? str : "";
    }

    public String d() {
        return this.h.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0 ? Formatter.formatIpAddress(this.a.getConnectionInfo().getIpAddress()) : "";
    }

    private je c(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            return je.WPA_PSK;
        }
        if (wifiConfiguration.allowedAuthAlgorithms.get(3)) {
            return je.IEEE8021X;
        }
        if (wifiConfiguration.allowedKeyManagement.get(2)) {
            return je.WPA_EAP;
        }
        return je.NONE;
    }

    private le e(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedProtocols.get(1)) {
            return le.RSN;
        }
        if (wifiConfiguration.allowedProtocols.get(0)) {
            return le.WPA;
        }
        return le.Unknown;
    }

    private ce a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedAuthAlgorithms.get(0)) {
            return ce.OPEN;
        }
        if (wifiConfiguration.allowedAuthAlgorithms.get(2)) {
            return ce.LEAP;
        }
        if (wifiConfiguration.allowedAuthAlgorithms.get(1)) {
            return ce.SHARED;
        }
        return ce.Unknown;
    }

    private void a(DWI dwi, WifiInfo wifiInfo) {
        dwi.WifiFrequency = wifiInfo.getFrequency();
    }

    /* access modifiers changed from: private */
    public void a(fe feVar) {
        int i2 = f.b[feVar.ordinal()];
        if (i2 == 1) {
            m();
        } else if (!(i2 == 2 || i2 == 3)) {
            return;
        }
        try {
            this.g.c();
            this.g.a(z7.a(this.a, this.d, this.h));
        } catch (Exception unused) {
        }
        n();
    }

    private ie b(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedGroupCiphers.get(3)) {
            return ie.CCMP;
        }
        if (wifiConfiguration.allowedGroupCiphers.get(2)) {
            return ie.TKIP;
        }
        if (wifiConfiguration.allowedGroupCiphers.get(1)) {
            return ie.WEP104;
        }
        if (wifiConfiguration.allowedGroupCiphers.get(0)) {
            return ie.WEP40;
        }
        return ie.Unknown;
    }

    /* access modifiers changed from: private */
    public void a(Intent intent) {
        int intExtra = intent.getIntExtra("wifi_state", 4);
        if (intExtra == 0) {
            this.b = re.Disabling;
        } else if (intExtra == 1) {
            this.b = re.Disabled;
        } else if (intExtra == 2) {
            this.b = re.Enabling;
        } else if (intExtra != 3) {
            this.b = re.Unknown;
        } else {
            this.b = re.Enabled;
        }
    }

    public void b(ne neVar) {
        this.q.remove(neVar);
    }

    public ArrayList<c1> b() {
        return i() ? a(this.r) : new ArrayList<>();
    }

    public boolean a(List<ScanResult> list) {
        WifiRttManager wifiRttManager;
        if (!(Build.VERSION.SDK_INT >= 28 && a(this.h)) || list == null || list.isEmpty() || (wifiRttManager = this.c) == null || !wifiRttManager.isAvailable()) {
            return false;
        }
        List<ScanResult> subList = list.subList(0, Math.min(list.size(), RangingRequest.getMaxPeers()));
        RangingRequest.Builder builder = new RangingRequest.Builder();
        builder.addAccessPoints(subList);
        a(builder.build(), list);
        return true;
    }

    private void a(RangingRequest rangingRequest, List<ScanResult> list) {
        this.c.startRanging(rangingRequest, ThreadManager.getInstance().getCachedThreadPool(), new c(list));
    }

    public static l9 a(DWI dwi) {
        if (dwi == null) {
            return l9.Unknown;
        }
        int i2 = dwi.WifiRxLev;
        if (i2 >= 0) {
            return l9.Unknown;
        }
        int calculateSignalLevel = WifiManager.calculateSignalLevel(i2, 5);
        if (calculateSignalLevel == 0) {
            return l9.Bad;
        }
        if (calculateSignalLevel == 1) {
            return l9.Poor;
        }
        if (calculateSignalLevel == 2) {
            return l9.Fair;
        }
        if (calculateSignalLevel == 3) {
            return l9.Good;
        }
        return l9.Excellent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.umlaut.crowd.internal.o3 a(android.net.wifi.WifiManager r3) {
        /*
            r2 = this;
            java.lang.reflect.Method r0 = r2.k
            if (r0 == 0) goto L_0x0010
            r1 = 0
            java.lang.Object r3 = r0.invoke(r3, r1)     // Catch:{ Exception -> 0x0010 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0010 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0010 }
            goto L_0x0011
        L_0x0010:
            r3 = -1
        L_0x0011:
            switch(r3) {
                case 10: goto L_0x0023;
                case 11: goto L_0x0020;
                case 12: goto L_0x001d;
                case 13: goto L_0x001a;
                case 14: goto L_0x0017;
                default: goto L_0x0014;
            }
        L_0x0014:
            com.umlaut.crowd.internal.o3 r3 = com.umlaut.crowd.internal.o3.Unknown
            return r3
        L_0x0017:
            com.umlaut.crowd.internal.o3 r3 = com.umlaut.crowd.internal.o3.Failed
            return r3
        L_0x001a:
            com.umlaut.crowd.internal.o3 r3 = com.umlaut.crowd.internal.o3.Enabled
            return r3
        L_0x001d:
            com.umlaut.crowd.internal.o3 r3 = com.umlaut.crowd.internal.o3.Enabling
            return r3
        L_0x0020:
            com.umlaut.crowd.internal.o3 r3 = com.umlaut.crowd.internal.o3.Disabled
            return r3
        L_0x0023:
            com.umlaut.crowd.internal.o3 r3 = com.umlaut.crowd.internal.o3.Disabling
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.ee.a(android.net.wifi.WifiManager):com.umlaut.crowd.internal.o3");
    }

    public void a(ne neVar) {
        this.q.add(neVar);
    }

    private static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.wifi.rtt") && context.checkCallingOrSelfPermission("android.permission.CHANGE_WIFI_STATE") == 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private ArrayList<c1> a(ArrayList<c1> arrayList) {
        ArrayList<c1> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return arrayList2;
        }
        synchronized (this) {
            arrayList2.addAll(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            long timeInMillis = TimeServer.getTimeInMillis();
            Iterator<c1> it = arrayList2.iterator();
            while (it.hasNext()) {
                c1 next = it.next();
                long j2 = next.Timestamp;
                if (j2 > 0) {
                    long j3 = timeInMillis - j2;
                    next.Age = j3;
                    next.EntryUsedAge += j3;
                    next.EntryUpdatedAge += j3;
                    next.EntryConfirmedAge += j3;
                }
            }
        }
        return arrayList2;
    }

    private void a() {
        if (this.l > 0 && !this.m) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long v2 = InsightCore.getInsightSettings().v();
            if (this.l + v2 < elapsedRealtime || elapsedRealtime < v2) {
                this.m = true;
                ThreadManager.getInstance().getCachedThreadPool().execute(new e());
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r0.shutdown();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00e2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.i     // Catch:{ Exception -> 0x00ea }
            java.lang.String r1 = r8.d()     // Catch:{ Exception -> 0x00ea }
            com.umlaut.crowd.internal.c4 r0 = com.umlaut.crowd.internal.de.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x00ea }
            if (r0 == 0) goto L_0x00ea
            int[] r1 = r0.b     // Catch:{ Exception -> 0x00ea }
            if (r1 == 0) goto L_0x00ea
            int[] r1 = r0.a     // Catch:{ Exception -> 0x00ea }
            if (r1 == 0) goto L_0x00ea
            int[] r1 = r0.c     // Catch:{ Exception -> 0x00ea }
            if (r1 != 0) goto L_0x001a
            goto L_0x00ea
        L_0x001a:
            r1 = 1
            if (r9 != 0) goto L_0x002f
            com.umlaut.crowd.internal.ge r9 = new com.umlaut.crowd.internal.ge     // Catch:{ Exception -> 0x00ea }
            java.lang.String r2 = r8.i     // Catch:{ Exception -> 0x00ea }
            r9.<init>(r2, r1)     // Catch:{ Exception -> 0x00ea }
            r9.start()     // Catch:{ Exception -> 0x00ea }
            r9.join()     // Catch:{ InterruptedException -> 0x002a }
        L_0x002a:
            java.util.Map r9 = r9.a()     // Catch:{ Exception -> 0x00ea }
            goto L_0x0035
        L_0x002f:
            java.lang.String r9 = r8.i     // Catch:{ Exception -> 0x00ea }
            java.util.Map r9 = com.umlaut.crowd.internal.de.a((java.lang.String) r9, (com.umlaut.crowd.internal.c4) r0)     // Catch:{ Exception -> 0x00ea }
        L_0x0035:
            if (r9 == 0) goto L_0x0041
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ea }
            java.util.Collection r9 = r9.values()     // Catch:{ Exception -> 0x00ea }
            r2.<init>(r9)     // Catch:{ Exception -> 0x00ea }
            goto L_0x0045
        L_0x0041:
            java.util.ArrayList r2 = com.umlaut.crowd.internal.de.a()     // Catch:{ Exception -> 0x00ea }
        L_0x0045:
            boolean r9 = r2.isEmpty()     // Catch:{ Exception -> 0x00ea }
            if (r9 != 0) goto L_0x00ea
            java.lang.String r9 = ""
            android.net.wifi.WifiManager r3 = r8.a     // Catch:{ Exception -> 0x00ea }
            android.net.wifi.WifiInfo r3 = r3.getConnectionInfo()     // Catch:{ Exception -> 0x00ea }
            if (r3 == 0) goto L_0x0063
            java.lang.String r4 = r3.getBSSID()     // Catch:{ Exception -> 0x00ea }
            if (r4 == 0) goto L_0x0063
            java.lang.String r9 = r3.getBSSID()     // Catch:{ Exception -> 0x00ea }
            java.lang.String r9 = r8.a((java.lang.String) r9)     // Catch:{ Exception -> 0x00ea }
        L_0x0063:
            java.util.Iterator r3 = r2.iterator()     // Catch:{ Exception -> 0x00ea }
        L_0x0067:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00ea }
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00ea }
            com.umlaut.crowd.internal.c1 r4 = (com.umlaut.crowd.internal.c1) r4     // Catch:{ Exception -> 0x00ea }
            r4.WifiBSSID = r9     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = r4.MacAddress     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = com.umlaut.crowd.internal.de.a((java.lang.String) r5)     // Catch:{ Exception -> 0x00ea }
            r4.MacAddress = r5     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = r4.IpAddress_Full     // Catch:{ Exception -> 0x00ea }
            int[] r6 = r0.c     // Catch:{ Exception -> 0x00ea }
            short r7 = r0.d     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = com.umlaut.crowd.internal.de.a(r5, r6, r7)     // Catch:{ Exception -> 0x00ea }
            r4.IpAddress = r5     // Catch:{ Exception -> 0x00ea }
            goto L_0x0067
        L_0x008a:
            java.lang.Object r9 = r8.o     // Catch:{ Exception -> 0x00ea }
            monitor-enter(r9)     // Catch:{ Exception -> 0x00ea }
            r8.r = r2     // Catch:{ all -> 0x00e7 }
            int r0 = r2.size()     // Catch:{ all -> 0x00e7 }
            int r2 = com.umlaut.crowd.threads.ThreadManager.e     // Catch:{ all -> 0x00e7 }
            if (r0 >= r2) goto L_0x0098
            r2 = 1
        L_0x0098:
            java.util.ArrayList<com.umlaut.crowd.internal.c1> r0 = r8.r     // Catch:{ all -> 0x00e7 }
            int r0 = r0.size()     // Catch:{ all -> 0x00e7 }
            float r0 = (float) r0     // Catch:{ all -> 0x00e7 }
            float r3 = (float) r2     // Catch:{ all -> 0x00e7 }
            float r0 = r0 / r3
            int r0 = java.lang.Math.round(r0)     // Catch:{ all -> 0x00e7 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00e7 }
            r3.<init>()     // Catch:{ all -> 0x00e7 }
            r4 = 0
        L_0x00ab:
            if (r4 >= r2) goto L_0x00c6
            int r5 = r4 * r0
            int r4 = r4 + 1
            if (r4 != r2) goto L_0x00ba
            java.util.ArrayList<com.umlaut.crowd.internal.c1> r6 = r8.r     // Catch:{ all -> 0x00e7 }
            int r6 = r6.size()     // Catch:{ all -> 0x00e7 }
            goto L_0x00bc
        L_0x00ba:
            int r6 = r5 + r0
        L_0x00bc:
            int r6 = r6 - r1
            com.umlaut.crowd.internal.ee$g r7 = new com.umlaut.crowd.internal.ee$g     // Catch:{ all -> 0x00e7 }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x00e7 }
            r3.add(r7)     // Catch:{ all -> 0x00e7 }
            goto L_0x00ab
        L_0x00c6:
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()     // Catch:{ all -> 0x00e7 }
            java.util.List r1 = r0.invokeAll(r3)     // Catch:{ Exception -> 0x00e2 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00e2 }
        L_0x00d2:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x00e2 }
            if (r2 == 0) goto L_0x00e5
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x00e2 }
            java.util.concurrent.Future r2 = (java.util.concurrent.Future) r2     // Catch:{ Exception -> 0x00e2 }
            r2.get()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d2
        L_0x00e2:
            r0.shutdown()     // Catch:{ all -> 0x00e7 }
        L_0x00e5:
            monitor-exit(r9)     // Catch:{ all -> 0x00e7 }
            goto L_0x00ea
        L_0x00e7:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00e7 }
            throw r0     // Catch:{ Exception -> 0x00ea }
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.ee.a(boolean):void");
    }
}
