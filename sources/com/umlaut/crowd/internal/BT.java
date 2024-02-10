package com.umlaut.crowd.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.enums.ThreeState;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.zd;
import com.umlaut.crowd.internal.ze;
import com.umlaut.crowd.speedtest.IBandwidthListener;
import com.umlaut.crowd.speedtest.SpeedtestEngineError;
import com.umlaut.crowd.speedtest.SpeedtestEngineStatus;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class BT implements IBandwidthListener, zd, ze {
    /* access modifiers changed from: private */
    public static final String o = "BT";
    private static final boolean p = false;
    public static final int q = 3;
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public v b;
    /* access modifiers changed from: private */
    public wd c;
    /* access modifiers changed from: private */
    public af d;
    /* access modifiers changed from: private */
    public BGT e;
    /* access modifiers changed from: private */
    public BGTS f;
    /* access modifiers changed from: private */
    public CLC.ProviderMode g;
    private HandlerThread h;
    private d i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public Handler l;
    private final CountDownLatch m = new CountDownLatch(1);
    private OBTSL n;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (!BT.this.k) {
                boolean unused = BT.this.k = true;
                BT.this.b();
                BT.this.a(true);
                BT.this.f();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            BT.this.l.removeCallbacksAndMessages((Object) null);
            BT.this.a(true);
            BT.this.f();
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.umlaut.crowd.internal.zd$a[] r0 = com.umlaut.crowd.internal.zd.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.zd$a r1 = com.umlaut.crowd.internal.zd.a.End     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.zd$a r1 = com.umlaut.crowd.internal.zd.a.Cancel     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.zd$a r1 = com.umlaut.crowd.internal.zd.a.Error     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.BT.c.<clinit>():void");
        }
    }

    private class d implements Runnable {
        boolean a;

        class a implements Runnable {
            a() {
            }

            public void run() {
                BT.this.c.c();
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                BT.this.d.p();
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                if (BT.this.e != null && BT.this.e.Type != 500) {
                    BT.this.b.a();
                }
            }
        }

        /* renamed from: com.umlaut.crowd.internal.BT$d$d  reason: collision with other inner class name */
        class C0172d implements Runnable {
            C0172d() {
            }

            public void run() {
                if (BT.this.e != null) {
                    try {
                        d dVar = d.this;
                        dVar.s(BT.this.e);
                    } catch (Exception e) {
                        String a2 = BT.o;
                        Log.e(a2, "startTest: " + e.toString());
                        BT.this.f();
                    }
                } else {
                    BT.this.f();
                }
            }
        }

        private d() {
        }

        private BGT b() {
            if (BT.this.a == null) {
                return null;
            }
            CLC.ProviderMode unused = BT.this.g = InsightCore.getInsightConfig().q();
            BT bt = BT.this;
            BGTS unused2 = bt.f = bt.e();
            if (BT.this.f == null || BT.this.f.BackgroundTest == null || BT.this.f.BackgroundTest.length == 0) {
                return null;
            }
            z a2 = new x(BT.this.a).a();
            int r = InsightCore.getInsightConfig().r();
            if (r != -1 && a2.BatteryLevel < ((float) r)) {
                return null;
            }
            if (!InsightCore.getInsightConfig().k() && CDC.getPowerSaveMode(BT.this.a) == ThreeState.Enabled) {
                return null;
            }
            ub timeInfo = TimeServer.getTimeInfo();
            DRI radioInfoForDefaultDataSim = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
            DWI wifiInfo = InsightCore.getWifiController().getWifiInfo();
            q4 lastLocationInfo = new CLC(BT.this.a).getLastLocationInfo();
            for (BGT bgt : BT.this.f.BackgroundTest) {
                if (bgt.TestPerAP) {
                    ConnectionTypes connectionTypes = radioInfoForDefaultDataSim.ConnectionType;
                    if (connectionTypes == ConnectionTypes.WiFi) {
                        bgt.setAPHash(wifiInfo.WifiSSID_Full.hashCode());
                    } else if (connectionTypes == ConnectionTypes.Mobile) {
                        bgt.setAPHash(radioInfoForDefaultDataSim.GsmCellId.hashCode());
                    }
                }
            }
            Arrays.sort(BT.this.f.BackgroundTest);
            BGT[] bgtArr = BT.this.f.BackgroundTest;
            int length = bgtArr.length;
            int i = 0;
            while (i < length) {
                BGT bgt2 = bgtArr[i];
                int i2 = i;
                if (a(bgt2, timeInfo, a2, radioInfoForDefaultDataSim, wifiInfo, lastLocationInfo)) {
                    return bgt2;
                }
                i = i2 + 1;
            }
            return null;
        }

        private sa d(BGT bgt) {
            gb gbVar = new gb();
            gbVar.count = bgt.Pings;
            gbVar.sleep = bgt.Pause;
            return gbVar;
        }

        private sa e(BGT bgt) {
            jb jbVar = new jb();
            wa waVar = new wa();
            jbVar.server = waVar;
            waVar.ips = bgt.Url.split(",");
            int i = bgt.Pings;
            if (i > 0) {
                jbVar.queries = i;
            }
            int i2 = bgt.Length;
            if (i2 > 0) {
                jbVar.maxHops = i2;
            }
            return jbVar;
        }

        private sa f(BGT bgt) {
            ra raVar = new ra();
            raVar.a = bgt.Length;
            raVar.reportingInterval = (long) bgt.Reporting;
            raVar.testSockets = bgt.Sockets;
            wa waVar = new wa();
            raVar.server = waVar;
            waVar.ips = bgt.Url.split(",");
            raVar.f = bgt.TotalInterfaceTraffic;
            long j = bgt.Payload;
            if (j > 0) {
                raVar.b = j;
            }
            int i = bgt.BufferSize;
            if (i > 0) {
                raVar.d = i;
            }
            if (!bgt.Headers.isEmpty()) {
                raVar.c = bgt.Headers;
            }
            if (!bgt.RequestMethod.isEmpty()) {
                raVar.e = bgt.RequestMethod;
            }
            return raVar;
        }

        private sa g(BGT bgt) {
            ib ibVar = new ib();
            ibVar.payloadsize = bgt.Payload;
            ibVar.testSockets = bgt.Sockets;
            ibVar.reportingInterval = (long) bgt.Reporting;
            return ibVar;
        }

        private sa h(BGT bgt) {
            hb hbVar = new hb();
            hbVar.measureLength = (long) bgt.Length;
            hbVar.testSockets = bgt.Sockets;
            hbVar.reportingInterval = (long) bgt.Reporting;
            return hbVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = r2.Url;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean i(com.umlaut.crowd.internal.BGT r2) {
            /*
                r1 = this;
                int r0 = r2.Length
                if (r0 <= 0) goto L_0x0018
                java.lang.String r0 = r2.Url
                if (r0 == 0) goto L_0x0018
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x0018
                int r0 = r2.Sockets
                if (r0 <= 0) goto L_0x0018
                int r2 = r2.Reporting
                if (r2 <= 0) goto L_0x0018
                r2 = 1
                return r2
            L_0x0018:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.BT.d.i(com.umlaut.crowd.internal.BGT):boolean");
        }

        private boolean j(BGT bgt) {
            return bgt.Payload > 0 && bgt.Sockets > 0 && bgt.Reporting > 0;
        }

        private boolean k(BGT bgt) {
            return bgt.Length > 0 && bgt.Sockets > 0 && bgt.Reporting > 0;
        }

        private boolean l(BGT bgt) {
            String str;
            if (bgt.Pings <= 0 || bgt.Pause <= 0 || (str = bgt.Url) == null || str.isEmpty()) {
                return false;
            }
            long j = bgt.Payload;
            return j > 0 && j < 2147483647L;
        }

        private boolean m(BGT bgt) {
            return bgt.Pings > 0 && bgt.Pause > 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
            r0 = r2.Url;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
            r2 = r2.Port;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean n(com.umlaut.crowd.internal.BGT r2) {
            /*
                r1 = this;
                int r0 = r2.Pings
                if (r0 <= 0) goto L_0x001e
                int r0 = r2.Pause
                if (r0 <= 0) goto L_0x001e
                java.lang.String r0 = r2.Url
                if (r0 == 0) goto L_0x001e
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x001e
                int r2 = r2.Port
                r0 = -1
                if (r2 < r0) goto L_0x001e
                r0 = 2147483647(0x7fffffff, float:NaN)
                if (r2 >= r0) goto L_0x001e
                r2 = 1
                return r2
            L_0x001e:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.BT.d.n(com.umlaut.crowd.internal.BGT):boolean");
        }

        private boolean o(BGT bgt) {
            String str = bgt.Url;
            return str != null && !str.isEmpty();
        }

        private boolean p(BGT bgt) {
            String str = bgt.Url;
            return str != null && !str.isEmpty() && bgt.Reporting > 0;
        }

        private boolean q(BGT bgt) {
            String str = bgt.Url;
            return str != null && !str.isEmpty() && bgt.Reporting > 0;
        }

        private void r(BGT bgt) {
            BT bt = BT.this;
            BT bt2 = BT.this;
            v unused = bt.b = new v(bt2, bt2.a);
            BT.this.b.g(a(BT.this.a, bgt));
            BT.this.b.a(BT.this.j);
            BT.this.b.a(true);
            BT.this.b.a(BT.this.g);
            int i = bgt.Type;
            if (i == e.BACKGROUNDTEST_DOWNLOAD_HTTP_TIME.a() && k(bgt)) {
                BT.this.b.a(c(bgt), m5.HTTP, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_DOWNLOAD_HTTPS_TIME.a() && k(bgt)) {
                BT.this.b.a(c(bgt), m5.HTTPS, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_DOWNLOAD_HTTP_SIZE.a() && j(bgt)) {
                BT.this.b.a(b(bgt), m5.HTTP, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_DOWNLOAD_HTTPS_SIZE.a() && j(bgt)) {
                BT.this.b.a(b(bgt), m5.HTTPS, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_UPLOAD_HTTP_TIME.a() && k(bgt)) {
                BT.this.b.a(h(bgt), m5.HTTP, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_UPLOAD_HTTPS_TIME.a() && k(bgt)) {
                BT.this.b.a(h(bgt), m5.HTTPS, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_UPLOAD_HTTP_SIZE.a() && j(bgt)) {
                BT.this.b.a(g(bgt), m5.HTTP, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_UPLOAD_HTTPS_SIZE.a() && j(bgt)) {
                BT.this.b.a(g(bgt), m5.HTTPS, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_DOWNLOAD_CDN.a() && i(bgt)) {
                BT.this.b.a(a(bgt), m5.HTTP_FILE_DOWNLOAD, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_UPLOAD_CDN.a() && i(bgt)) {
                BT.this.b.a(f(bgt), m5.HTTP_FILE_UPLOAD, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_LATENCY_HTTP.a() && m(bgt)) {
                BT.this.b.a(d(bgt), m5.HTTP, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_LATENCY_HTTPS.a() && m(bgt)) {
                BT.this.b.a(d(bgt), m5.HTTPS, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_LATENCY_ICMP.a() && l(bgt)) {
                BT.this.b.a(bgt.Url, bgt.Pings, bgt.Pause, BT.this.j, (int) bgt.Payload, false, true, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_LATENCY_TCP_3WH.a() && n(bgt)) {
                if (bgt.Port == -1) {
                    bgt.Port = 80;
                }
                BT.this.b.a(bgt.Url, bgt.Pings, bgt.Pause, BT.this.j, bgt.Port, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_LATENCY_TCP_REQ.a() && n(bgt)) {
                if (bgt.Port == -1) {
                    bgt.Port = 80;
                }
                BT.this.b.b(bgt.Url, bgt.Pings, bgt.Pause, BT.this.j, bgt.Port, a.Conditional);
            } else if (i == e.BACKGROUNDTEST_LATENCY_UDP_DNS.a() && n(bgt)) {
                if (bgt.Port == -1) {
                    bgt.Port = 53;
                }
                BT.this.b.c(bgt.Url, bgt.Pings, bgt.Pause, BT.this.j, bgt.Port, a.Conditional);
            } else if (i != e.BACKGROUNDTEST_TRACEROUTE.a() || !o(bgt)) {
                BT.this.d();
            } else {
                BT.this.b.a(e(bgt), m5.TRACEROUTE, a.Conditional);
            }
        }

        /* access modifiers changed from: private */
        public void s(BGT bgt) {
            int i = bgt.Type;
            if (i == e.BACKGROUNDTEST_DOWNLOAD_HTTP_TIME.a() || i == e.BACKGROUNDTEST_DOWNLOAD_HTTPS_TIME.a() || i == e.BACKGROUNDTEST_DOWNLOAD_HTTP_SIZE.a() || i == e.BACKGROUNDTEST_DOWNLOAD_HTTPS_SIZE.a() || i == e.BACKGROUNDTEST_UPLOAD_HTTP_TIME.a() || i == e.BACKGROUNDTEST_UPLOAD_HTTPS_TIME.a() || i == e.BACKGROUNDTEST_UPLOAD_HTTP_SIZE.a() || i == e.BACKGROUNDTEST_UPLOAD_HTTPS_SIZE.a() || i == e.BACKGROUNDTEST_DOWNLOAD_CDN.a() || i == e.BACKGROUNDTEST_UPLOAD_CDN.a() || i == e.BACKGROUNDTEST_LATENCY_HTTP.a() || i == e.BACKGROUNDTEST_LATENCY_HTTPS.a() || i == e.BACKGROUNDTEST_LATENCY_ICMP.a() || i == e.BACKGROUNDTEST_LATENCY_TCP_3WH.a() || i == e.BACKGROUNDTEST_LATENCY_TCP_REQ.a() || i == e.BACKGROUNDTEST_LATENCY_UDP_DNS.a() || i == e.BACKGROUNDTEST_TRACEROUTE.a()) {
                r(bgt);
            } else if (i == e.BACKGROUNDTEST_WWW.a()) {
                t(bgt);
            } else if (i == e.BACKGROUNDTEST_YT.a()) {
                u(bgt);
            } else {
                BT.this.d();
            }
        }

        private void t(BGT bgt) {
            if (p(bgt)) {
                wd unused = BT.this.c = new wd(BT.this.a, BT.this.g, BT.this);
                BT.this.c.c(a(BT.this.a, bgt));
                BT.this.c.a(true);
                BT.this.c.a(bgt.Url, false, (long) bgt.Reporting, a.Conditional);
                return;
            }
            BT.this.d();
        }

        private void u(BGT bgt) {
            int i;
            if (q(bgt)) {
                af unused = BT.this.d = new af(BT.this.a, BT.this.g, BT.this);
                BT.this.d.e(true);
                BT.this.d.e(a(BT.this.a, bgt));
                BT.this.d.b(true);
                int i2 = bgt.Length;
                if (i2 > 0) {
                    int i3 = i2 / 1000;
                    i = i3 < 1 ? 1 : i3;
                } else {
                    i = -1;
                }
                BT.this.d.a(bgt.Width, bgt.Height);
                BT.this.d.b(bgt.Url, 0, i, ye.Default, (long) bgt.Reporting, cf.DEVICE_TEST, a.Conditional);
                return;
            }
            BT.this.d();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (BT.this.b != null) {
                BT.this.b.i();
            }
        }

        public void run() {
            if (this.a) {
                BT.this.f();
                return;
            }
            a(BT.this.a);
            try {
                BGT unused = BT.this.e = b();
            } catch (NullPointerException unused2) {
                BGT unused3 = BT.this.e = null;
            }
            if (BT.this.e == null) {
                BT.this.f();
                return;
            }
            double random = Math.random();
            String c2 = t.c(BT.this.a);
            if (c2.equals(BT.this.f.Id + "") && BT.this.e.ForceFirstTest) {
                random = 0.0d;
            }
            if (BT.this.e.Probability > random) {
                new Handler(Looper.getMainLooper()).post(new C0172d());
                return;
            }
            BT.this.a(false);
            BT.this.f();
        }

        /* synthetic */ d(BT bt, a aVar) {
            this();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a = true;
            if (BT.this.c != null) {
                new Handler(Looper.getMainLooper()).post(new a());
            }
            if (BT.this.d != null) {
                new Handler(Looper.getMainLooper()).post(new b());
            }
            if (BT.this.b != null) {
                ThreadManager.getInstance().getCachedThreadPool().execute(new c());
            }
        }

        private sa c(BGT bgt) {
            bb bbVar = new bb();
            bbVar.measureLength = (long) bgt.Length;
            bbVar.testSockets = bgt.Sockets;
            bbVar.reportingInterval = (long) bgt.Reporting;
            return bbVar;
        }

        private void a(Context context) {
            try {
                long a2 = t.a(context);
                long timeInMillis = TimeServer.getTimeInMillis();
                String j = InsightCore.getInsightConfig().j();
                if (j != null && !j.isEmpty()) {
                    if (InsightCore.getInsightConfig().u() + a2 < timeInMillis || a2 > timeInMillis) {
                        t.a(context, j);
                    }
                }
            } catch (Exception unused) {
            }
        }

        private boolean a(int i) {
            for (e a2 : e.values()) {
                if (a2.a() == i) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00f3 A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00f5 A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0109 A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x010b A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0176 A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0178 A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x019c A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x019e A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x025f A[Catch:{ Exception -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0260 A[Catch:{ Exception -> 0x0280 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(com.umlaut.crowd.internal.BGT r18, com.umlaut.crowd.internal.ub r19, com.umlaut.crowd.internal.z r20, com.umlaut.crowd.internal.DRI r21, com.umlaut.crowd.internal.DWI r22, com.umlaut.crowd.internal.q4 r23) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                r3 = r21
                r4 = r22
                r5 = r23
                java.lang.String r6 = ""
                int r7 = r1.Type
                boolean r7 = r0.a((int) r7)
                r8 = 0
                if (r7 != 0) goto L_0x0018
                return r8
            L_0x0018:
                long r9 = r18.nextTestTimestamp()
                long r11 = r2.TimestampMillis
                int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r7 <= 0) goto L_0x0023
                return r8
            L_0x0023:
                com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()
                boolean r7 = r7.l()
                if (r7 != 0) goto L_0x002e
                return r8
            L_0x002e:
                int r7 = r1.CurrentMonth
                int r9 = r2.month
                if (r7 == r9) goto L_0x0037
                r1.CurrentQuota = r8
                goto L_0x003e
            L_0x0037:
                int r7 = r1.CurrentQuota
                int r9 = r1.MaxMonthlyQuota
                if (r7 < r9) goto L_0x003e
                return r8
            L_0x003e:
                java.lang.String r1 = r1.Condition
                r7 = 1
                if (r1 == 0) goto L_0x0282
                boolean r9 = r1.isEmpty()
                if (r9 == 0) goto L_0x004b
                goto L_0x0282
            L_0x004b:
                r9 = r20
                com.umlaut.crowd.internal.a0 r9 = r9.BatteryStatus
                com.umlaut.crowd.internal.a0 r10 = com.umlaut.crowd.internal.a0.Charging
                if (r9 == r10) goto L_0x005a
                com.umlaut.crowd.internal.a0 r10 = com.umlaut.crowd.internal.a0.Full
                if (r9 != r10) goto L_0x0058
                goto L_0x005a
            L_0x0058:
                r9 = 0
                goto L_0x005b
            L_0x005a:
                r9 = 1
            L_0x005b:
                r10 = -1
                java.lang.String r11 = r3.MCC     // Catch:{ NumberFormatException -> 0x0063 }
                int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0063 }
                goto L_0x0064
            L_0x0063:
                r11 = -1
            L_0x0064:
                java.lang.String r12 = r3.MNC     // Catch:{ NumberFormatException -> 0x006b }
                int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x006b }
                goto L_0x006d
            L_0x006b:
                r12 = -1
            L_0x006d:
                java.util.Calendar r13 = java.util.Calendar.getInstance()
                long r14 = r2.TimestampMillis
                r13.setTimeInMillis(r14)
                r14 = 7
                int r13 = r13.get(r14)
                if (r13 != r7) goto L_0x007e
                goto L_0x0080
            L_0x007e:
                int r14 = r13 + -1
            L_0x0080:
                java.lang.String r10 = r3.GsmCellId
                boolean r10 = r10.isEmpty()
                if (r10 != 0) goto L_0x00a1
                java.lang.String r10 = r3.GsmCellId
                java.lang.String r13 = "-1"
                boolean r10 = r10.equals(r13)
                if (r10 != 0) goto L_0x00a1
                java.lang.String r10 = r3.GsmCellId
                r13 = 2147483647(0x7fffffff, float:NaN)
                java.lang.String r13 = java.lang.String.valueOf(r13)
                boolean r10 = r10.equals(r13)
                if (r10 == 0) goto L_0x00b3
            L_0x00a1:
                long r7 = r3.NrCellId
                r15 = 0
                int r13 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
                if (r13 < 0) goto L_0x00b5
                r15 = 68719476735(0xfffffffff, double:3.3951932655E-313)
                int r13 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
                if (r13 <= 0) goto L_0x00b3
                goto L_0x00b5
            L_0x00b3:
                r7 = 1
                goto L_0x00b6
            L_0x00b5:
                r7 = 0
            L_0x00b6:
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x0280 }
                r8.<init>()     // Catch:{ Exception -> 0x0280 }
                java.lang.String r13 = "timestamp"
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r15.<init>()     // Catch:{ Exception -> 0x0280 }
                r16 = r11
                long r10 = r2.TimestampMillis     // Catch:{ Exception -> 0x0280 }
                r15.append(r10)     // Catch:{ Exception -> 0x0280 }
                r15.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = r15.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r13, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = "connection"
                com.umlaut.crowd.enums.ConnectionTypes r11 = r3.ConnectionType     // Catch:{ Exception -> 0x0280 }
                java.lang.String r11 = r11.name()     // Catch:{ Exception -> 0x0280 }
                r8.put(r10, r11)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = "roaming"
                boolean r11 = r3.IsRoaming     // Catch:{ Exception -> 0x0280 }
                java.lang.String r13 = "1"
                java.lang.String r15 = "0"
                if (r11 == 0) goto L_0x00eb
                r11 = r13
                goto L_0x00ec
            L_0x00eb:
                r11 = r15
            L_0x00ec:
                r8.put(r10, r11)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = "charging"
                if (r9 == 0) goto L_0x00f5
                r9 = r13
                goto L_0x00f6
            L_0x00f5:
                r9 = r15
            L_0x00f6:
                r8.put(r10, r9)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "screenon"
                com.umlaut.crowd.internal.BT r10 = com.umlaut.crowd.internal.BT.this     // Catch:{ Exception -> 0x0280 }
                android.content.Context r10 = r10.a     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.internal.z8 r10 = com.umlaut.crowd.internal.CDC.f(r10)     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.internal.z8 r11 = com.umlaut.crowd.internal.z8.On     // Catch:{ Exception -> 0x0280 }
                if (r10 != r11) goto L_0x010b
                r10 = r13
                goto L_0x010c
            L_0x010b:
                r10 = r15
            L_0x010c:
                r8.put(r9, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "mcc"
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r10.<init>()     // Catch:{ Exception -> 0x0280 }
                r11 = r16
                r10.append(r11)     // Catch:{ Exception -> 0x0280 }
                r10.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r9, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "mnc"
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r10.<init>()     // Catch:{ Exception -> 0x0280 }
                r10.append(r12)     // Catch:{ Exception -> 0x0280 }
                r10.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r9, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "latitude"
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r10.<init>()     // Catch:{ Exception -> 0x0280 }
                double r11 = r5.LocationLatitude     // Catch:{ Exception -> 0x0280 }
                r10.append(r11)     // Catch:{ Exception -> 0x0280 }
                r10.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r9, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "longitude"
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r10.<init>()     // Catch:{ Exception -> 0x0280 }
                double r11 = r5.LocationLongitude     // Catch:{ Exception -> 0x0280 }
                r10.append(r11)     // Catch:{ Exception -> 0x0280 }
                r10.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r9, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "guid"
                java.lang.String r10 = com.umlaut.crowd.InsightCore.getGUID()     // Catch:{ Exception -> 0x0280 }
                r8.put(r9, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "metered"
                com.umlaut.crowd.internal.tb r10 = r3.IsMetered     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.internal.tb r11 = com.umlaut.crowd.internal.tb.Yes     // Catch:{ Exception -> 0x0280 }
                if (r10 != r11) goto L_0x0178
                r10 = r13
                goto L_0x0179
            L_0x0178:
                r10 = r15
            L_0x0179:
                r8.put(r9, r10)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = "rat"
                com.umlaut.crowd.enums.NetworkTypes r10 = r3.NetworkType     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.internal.o6 r11 = r3.NrState     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.enums.NetworkTypes r3 = r3.DisplayNetworkType     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.enums.NetworkGenerations r3 = com.umlaut.crowd.internal.l7.a((com.umlaut.crowd.enums.NetworkTypes) r10, (com.umlaut.crowd.internal.o6) r11, (com.umlaut.crowd.enums.NetworkTypes) r3)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = r3.name()     // Catch:{ Exception -> 0x0280 }
                r8.put(r9, r3)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "foreground"
                com.umlaut.crowd.internal.d3 r9 = com.umlaut.crowd.InsightCore.getForegroundTestManager()     // Catch:{ Exception -> 0x0280 }
                int r9 = r9.d()     // Catch:{ Exception -> 0x0280 }
                r10 = 1
                if (r9 != r10) goto L_0x019e
                r9 = r13
                goto L_0x019f
            L_0x019e:
                r9 = r15
            L_0x019f:
                r8.put(r3, r9)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "version"
                java.lang.String r9 = "20230301124918"
                r8.put(r3, r9)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "packagename"
                com.umlaut.crowd.internal.BT r9 = com.umlaut.crowd.internal.BT.this     // Catch:{ Exception -> 0x0280 }
                android.content.Context r9 = r9.a     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = r9.getPackageName()     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r9)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "locprovider"
                com.umlaut.crowd.internal.s4 r9 = r5.LocationProvider     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = r9.name()     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r9)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "locaccuracy"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r9.<init>()     // Catch:{ Exception -> 0x0280 }
                double r10 = r5.LocationAccuracyHorizontal     // Catch:{ Exception -> 0x0280 }
                r9.append(r10)     // Catch:{ Exception -> 0x0280 }
                r9.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r9)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "locage"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r9.<init>()     // Catch:{ Exception -> 0x0280 }
                long r10 = r5.LocationAge     // Catch:{ Exception -> 0x0280 }
                r9.append(r10)     // Catch:{ Exception -> 0x0280 }
                r9.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r5 = r9.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r5)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "wifilevel"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r5.<init>()     // Catch:{ Exception -> 0x0280 }
                int r9 = r4.WifiRxLev     // Catch:{ Exception -> 0x0280 }
                r10 = 5
                int r9 = android.net.wifi.WifiManager.calculateSignalLevel(r9, r10)     // Catch:{ Exception -> 0x0280 }
                r5.append(r9)     // Catch:{ Exception -> 0x0280 }
                r5.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r5)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "wifissid"
                java.lang.String r4 = r4.WifiSSID_Full     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r4)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "dayofweek"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r4.<init>()     // Catch:{ Exception -> 0x0280 }
                r4.append(r14)     // Catch:{ Exception -> 0x0280 }
                r4.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r4)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = "hour"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r4.<init>()     // Catch:{ Exception -> 0x0280 }
                int r2 = r2.hour     // Catch:{ Exception -> 0x0280 }
                r4.append(r2)     // Catch:{ Exception -> 0x0280 }
                r4.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r3, r2)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r2 = "devicemodel"
                java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0280 }
                r8.put(r2, r3)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r2 = "osapilevel"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0280 }
                r3.<init>()     // Catch:{ Exception -> 0x0280 }
                int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0280 }
                r3.append(r4)     // Catch:{ Exception -> 0x0280 }
                r3.append(r6)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0280 }
                r8.put(r2, r3)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r2 = "cellidavailable"
                if (r7 == 0) goto L_0x0260
                goto L_0x0261
            L_0x0260:
                r13 = r15
            L_0x0261:
                r8.put(r2, r13)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r2 = "callstate"
                com.umlaut.crowd.internal.BT r3 = com.umlaut.crowd.internal.BT.this     // Catch:{ Exception -> 0x0280 }
                android.content.Context r3 = r3.a     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.internal.v0 r3 = com.umlaut.crowd.internal.ud.a(r3)     // Catch:{ Exception -> 0x0280 }
                java.lang.String r3 = r3.name()     // Catch:{ Exception -> 0x0280 }
                r8.put(r2, r3)     // Catch:{ Exception -> 0x0280 }
                com.umlaut.crowd.internal.c8 r1 = com.umlaut.crowd.internal.c8.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0280 }
                boolean r1 = r1.a((java.util.Map<java.lang.String, java.lang.String>) r8)     // Catch:{ Exception -> 0x0280 }
                return r1
            L_0x0280:
                r1 = 0
                return r1
            L_0x0282:
                r1 = 1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.BT.d.a(com.umlaut.crowd.internal.BGT, com.umlaut.crowd.internal.ub, com.umlaut.crowd.internal.z, com.umlaut.crowd.internal.DRI, com.umlaut.crowd.internal.DWI, com.umlaut.crowd.internal.q4):boolean");
        }

        private sa b(BGT bgt) {
            cb cbVar = new cb();
            cbVar.payloadsize = bgt.Payload;
            cbVar.testSockets = bgt.Sockets;
            cbVar.reportingInterval = (long) bgt.Reporting;
            return cbVar;
        }

        private String a(Context context, BGT bgt) {
            long b2 = t.b(context);
            return b2 + ";" + BT.this.f.Hash + ";" + BT.this.f.Id + ";" + bgt.Id;
        }

        private sa a(BGT bgt) {
            qa qaVar = new qa();
            qaVar.a = bgt.Length;
            qaVar.reportingInterval = (long) bgt.Reporting;
            qaVar.testSockets = bgt.Sockets;
            wa waVar = new wa();
            qaVar.server = waVar;
            waVar.ips = bgt.Url.split(",");
            qaVar.e = bgt.TotalInterfaceTraffic;
            long j = bgt.Payload;
            if (j > 0) {
                qaVar.b = j;
            }
            int i = bgt.BufferSize;
            if (i > 0) {
                qaVar.d = i;
            }
            if (!bgt.Headers.isEmpty()) {
                qaVar.c = bgt.Headers;
            }
            return qaVar;
        }
    }

    public enum e {
        BACKGROUNDTEST_DOWNLOAD_HTTP_TIME(100),
        BACKGROUNDTEST_DOWNLOAD_HTTPS_TIME(110),
        BACKGROUNDTEST_DOWNLOAD_HTTP_SIZE(101),
        BACKGROUNDTEST_DOWNLOAD_HTTPS_SIZE(111),
        BACKGROUNDTEST_UPLOAD_HTTP_TIME(200),
        BACKGROUNDTEST_UPLOAD_HTTPS_TIME(210),
        BACKGROUNDTEST_UPLOAD_HTTP_SIZE(201),
        BACKGROUNDTEST_UPLOAD_HTTPS_SIZE(211),
        BACKGROUNDTEST_DOWNLOAD_CDN(300),
        BACKGROUNDTEST_UPLOAD_CDN(800),
        BACKGROUNDTEST_LATENCY_HTTP(400),
        BACKGROUNDTEST_LATENCY_HTTPS(410),
        BACKGROUNDTEST_LATENCY_ICMP(420),
        BACKGROUNDTEST_LATENCY_TCP_3WH(430),
        BACKGROUNDTEST_LATENCY_TCP_REQ(440),
        BACKGROUNDTEST_LATENCY_UDP_DNS(450),
        BACKGROUNDTEST_TRACEROUTE(500),
        BACKGROUNDTEST_WWW(600),
        BACKGROUNDTEST_YT(700);
        
        private final int a;

        private e(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    public BT(Context context) {
        this.a = context;
    }

    public void a(int i2) {
    }

    public void a(long j2, long j3, long j4) {
    }

    public void a(String str) {
    }

    public void onPingProgress(float f2, int i2) {
    }

    public void onTestStatusChanged(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j2) {
        if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ERROR || speedtestEngineStatus == SpeedtestEngineStatus.ABORTED) {
            d();
        }
    }

    public void onTracerouteProgress(float f2, String str, int i2, int i3) {
    }

    public void onTransferProgress(float f2, long j2) {
    }

    public void onTransferProgressRemote(float f2, long j2) {
    }

    /* access modifiers changed from: private */
    public void d() {
        if (!this.k) {
            new Handler(this.h.getLooper()).post(new b());
        }
    }

    /* access modifiers changed from: private */
    public BGTS e() {
        return t.d(this.a);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.k = true;
        this.l.removeCallbacksAndMessages((Object) null);
        d dVar = this.i;
        if (dVar != null) {
            dVar.c();
        }
        HandlerThread handlerThread = this.h;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.m.countDown();
        OBTSL obtsl = this.n;
        if (obtsl != null) {
            obtsl.a();
        }
    }

    public void c() {
        if (!InsightCore.isInitialized()) {
            Log.i(o, "executeTest: InsightCore not initialized");
            return;
        }
        OBTSL obtsl = this.n;
        if (obtsl != null) {
            obtsl.b();
        }
        this.j = InsightCore.getInsightConfig().t();
        HandlerThread handlerThread = new HandlerThread("BackgroundTestThread");
        this.h = handlerThread;
        handlerThread.start();
        this.l = new Handler(this.h.getLooper());
        this.i = new d(this, (a) null);
        new Handler(this.h.getLooper()).postDelayed(this.i, (long) InsightCore.getInsightConfig().n());
        this.k = false;
        this.l.postDelayed(new a(), (long) InsightCore.getInsightConfig().p());
        try {
            this.m.await();
        } catch (InterruptedException e2) {
            Log.d(o, e2.toString());
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void a(OBTSL obtsl) {
        this.n = obtsl;
    }

    public void a(WebView webView, zd.a aVar) {
        int i2 = c.a[aVar.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            d();
        }
    }

    public void a(WebView webView, ze.a aVar, String str) {
        if (aVar == ze.a.End || aVar == ze.a.Error || aVar == ze.a.Cancel) {
            d();
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        a(z, this.e);
        a(this.f);
    }

    private void a(boolean z, BGT bgt) {
        if (bgt != null) {
            ub timeInfo = TimeServer.getTimeInfo();
            bgt.setLastTestTimestamp(timeInfo.TimestampMillis);
            bgt.CurrentMonth = timeInfo.month;
            bgt.ForceFirstTest = false;
            if (z) {
                bgt.CurrentQuota++;
            }
        }
    }

    private void a(BGTS bgts) {
        if (bgts != null) {
            t.a(this.a, bgts);
        }
    }
}
