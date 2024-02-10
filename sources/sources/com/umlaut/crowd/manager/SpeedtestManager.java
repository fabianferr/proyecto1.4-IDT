package com.umlaut.crowd.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CDC;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.DRI;
import com.umlaut.crowd.internal.RBR;
import com.umlaut.crowd.internal.RDT;
import com.umlaut.crowd.internal.RLT;
import com.umlaut.crowd.internal.RP3;
import com.umlaut.crowd.internal.RST;
import com.umlaut.crowd.internal.RUT;
import com.umlaut.crowd.internal.aa;
import com.umlaut.crowd.internal.bb;
import com.umlaut.crowd.internal.f2;
import com.umlaut.crowd.internal.g3;
import com.umlaut.crowd.internal.gb;
import com.umlaut.crowd.internal.hb;
import com.umlaut.crowd.internal.i1;
import com.umlaut.crowd.internal.ja;
import com.umlaut.crowd.internal.k7;
import com.umlaut.crowd.internal.m5;
import com.umlaut.crowd.internal.p4;
import com.umlaut.crowd.internal.qa;
import com.umlaut.crowd.internal.ra;
import com.umlaut.crowd.internal.t9;
import com.umlaut.crowd.internal.u;
import com.umlaut.crowd.internal.ub;
import com.umlaut.crowd.internal.v;
import com.umlaut.crowd.internal.w2;
import com.umlaut.crowd.internal.wa;
import com.umlaut.crowd.internal.x;
import com.umlaut.crowd.internal.y6;
import com.umlaut.crowd.speedtest.IBandwidthListener;
import com.umlaut.crowd.speedtest.ISpeedtestListener;
import com.umlaut.crowd.speedtest.SpeedtestEngineError;
import com.umlaut.crowd.speedtest.SpeedtestEngineStatus;
import com.umlaut.crowd.speedtest.SpeedtestStatus;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class SpeedtestManager implements IBandwidthListener {
    public static final String C = "SpeedtestManager";
    private static final boolean D = false;
    private static final int E = 80;
    private wa A;
    /* access modifiers changed from: private */
    public Handler B;
    /* access modifiers changed from: private */
    public ISpeedtestListener a;
    /* access modifiers changed from: private */
    public Context b;
    private CLC c;
    private x d;
    /* access modifiers changed from: private */
    public RST e;
    private ArrayList<k7> f;
    private long g;
    private int h;
    private ja i;
    private String j;
    private IS k;
    private String l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    /* access modifiers changed from: private */
    public v s;
    /* access modifiers changed from: private */
    public String t;
    private String u;
    private String v;
    private int w;
    private int x;
    private wa y;
    private wa z;

    class a implements Runnable {
        final /* synthetic */ RLT a;

        a(RLT rlt) {
            this.a = rlt;
        }

        public void run() {
            SpeedtestManager.this.a.onLatencyTestResult(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ RDT a;

        b(RDT rdt) {
            this.a = rdt;
        }

        public void run() {
            SpeedtestManager.this.a.onDownloadTestResult(this.a);
        }
    }

    class c implements Runnable {
        final /* synthetic */ RUT a;

        c(RUT rut) {
            this.a = rut;
        }

        public void run() {
            SpeedtestManager.this.a.onUploadTestResult(this.a);
        }
    }

    class d implements Runnable {
        final /* synthetic */ gb a;

        d(gb gbVar) {
            this.a = gbVar;
        }

        public void run() {
            SpeedtestManager speedtestManager = SpeedtestManager.this;
            SpeedtestManager speedtestManager2 = SpeedtestManager.this;
            v unused = speedtestManager.s = new v(speedtestManager2, speedtestManager2.b);
            SpeedtestManager.this.s.h();
            SpeedtestManager.this.s.b(true);
            SpeedtestManager.this.s.a(this.a, SpeedtestManager.this.e.LatencyTest.MeasurementType, false, com.umlaut.crowd.internal.a.Manual);
        }
    }

    class e implements Runnable {
        final /* synthetic */ gb a;

        class a implements Runnable {
            a() {
            }

            public void run() {
                SpeedtestManager speedtestManager = SpeedtestManager.this;
                SpeedtestManager speedtestManager2 = SpeedtestManager.this;
                v unused = speedtestManager.s = new v(speedtestManager2, speedtestManager2.b);
                SpeedtestManager.this.s.h();
                v a2 = SpeedtestManager.this.s;
                gb gbVar = e.this.a;
                a2.a(gbVar.server.ips[0], gbVar.count, gbVar.sleep, 10000, 56, false, false, com.umlaut.crowd.internal.a.Manual);
            }
        }

        e(gb gbVar) {
            this.a = gbVar;
        }

        public void run() {
            try {
                String unused = SpeedtestManager.this.t = f2.a().b(SpeedtestManager.this.t, 10000);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            SpeedtestManager.this.B.post(new a());
        }
    }

    class f implements Runnable {
        final /* synthetic */ qa a;

        f(qa qaVar) {
            this.a = qaVar;
        }

        public void run() {
            SpeedtestManager speedtestManager = SpeedtestManager.this;
            SpeedtestManager speedtestManager2 = SpeedtestManager.this;
            v unused = speedtestManager.s = new v(speedtestManager2, speedtestManager2.b);
            SpeedtestManager.this.s.h();
            SpeedtestManager.this.s.a(this.a, SpeedtestManager.this.e.DownloadTest.MeasurementType, false, com.umlaut.crowd.internal.a.Manual);
        }
    }

    class g implements Runnable {
        final /* synthetic */ bb a;

        g(bb bbVar) {
            this.a = bbVar;
        }

        public void run() {
            SpeedtestManager speedtestManager = SpeedtestManager.this;
            SpeedtestManager speedtestManager2 = SpeedtestManager.this;
            v unused = speedtestManager.s = new v(speedtestManager2, speedtestManager2.b);
            SpeedtestManager.this.s.h();
            SpeedtestManager.this.s.b(true);
            SpeedtestManager.this.s.a(this.a, SpeedtestManager.this.e.DownloadTest.MeasurementType, false, com.umlaut.crowd.internal.a.Manual);
        }
    }

    class h implements Runnable {
        final /* synthetic */ ra a;

        h(ra raVar) {
            this.a = raVar;
        }

        public void run() {
            SpeedtestManager speedtestManager = SpeedtestManager.this;
            SpeedtestManager speedtestManager2 = SpeedtestManager.this;
            v unused = speedtestManager.s = new v(speedtestManager2, speedtestManager2.b);
            SpeedtestManager.this.s.h();
            SpeedtestManager.this.s.a(this.a, SpeedtestManager.this.e.UploadTest.MeasurementType, false, com.umlaut.crowd.internal.a.Manual);
        }
    }

    class i implements Runnable {
        final /* synthetic */ hb a;

        i(hb hbVar) {
            this.a = hbVar;
        }

        public void run() {
            SpeedtestManager speedtestManager = SpeedtestManager.this;
            SpeedtestManager speedtestManager2 = SpeedtestManager.this;
            v unused = speedtestManager.s = new v(speedtestManager2, speedtestManager2.b);
            SpeedtestManager.this.s.h();
            SpeedtestManager.this.s.b(true);
            SpeedtestManager.this.s.a(this.a, SpeedtestManager.this.e.UploadTest.MeasurementType, false, com.umlaut.crowd.internal.a.Manual);
        }
    }

    class j implements Runnable {
        final /* synthetic */ float a;
        final /* synthetic */ long b;

        j(float f, long j) {
            this.a = f;
            this.b = j;
        }

        public void run() {
            SpeedtestManager.this.a.onTransferProgress(this.a, this.b);
        }
    }

    class k implements Runnable {
        final /* synthetic */ float a;
        final /* synthetic */ int b;

        k(float f, int i) {
            this.a = f;
            this.b = i;
        }

        public void run() {
            SpeedtestManager.this.a.onPingProgress(this.a, this.b);
        }
    }

    class l implements Runnable {
        final /* synthetic */ SpeedtestStatus a;

        l(SpeedtestStatus speedtestStatus) {
            this.a = speedtestStatus;
        }

        public void run() {
            SpeedtestManager.this.a.onTestStatusChanged(this.a);
        }
    }

    public SpeedtestManager(ISpeedtestListener iSpeedtestListener, Context context) {
        if (iSpeedtestListener != null) {
            this.a = iSpeedtestListener;
            this.b = context;
            this.j = InsightCore.getInsightConfig().f1();
            this.k = new IS(this.b);
            f();
            return;
        }
        throw new IllegalArgumentException("ISpeedtestListener is NULL");
    }

    private void g() {
        this.f = new ArrayList<>();
    }

    private void h() {
        RST rst = this.e;
        if (rst != null && this.n) {
            ArrayList<k7> arrayList = this.f;
            rst.QuestionAnswerList = (k7[]) arrayList.toArray(new k7[arrayList.size()]);
            this.e.QuestionnaireName = aa.a(this.l);
            InsightCore.getDatabaseHelper().a(w2.ST, (RBR) this.e);
            if (InsightCore.getInsightConfig().o1()) {
                InsightCore.getStatsDatabase().a(this.e);
            }
        }
    }

    private void i() {
        this.e.TimeInfoOnEnd = TimeServer.getTimeInfo();
        this.e.BatteryInfoOnEnd = this.d.a();
        this.e.LocationInfoOnEnd = this.c.getLastLocationInfo();
        this.e.MemoryInfoOnEnd = CDC.d(this.b);
        this.e.RadioInfoOnEnd = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        this.e.TrafficInfoOnEnd = CDC.f();
        this.e.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
        RST rst = this.e;
        if (!rst.IspInfo.SuccessfulIspLookup) {
            g3 a2 = g3.a(this.b);
            RST rst2 = this.e;
            rst.IspInfo = a2.a(rst2.RadioInfoOnStart, rst2.WifiInfoOnStart, false);
        }
    }

    private void j() {
        this.e.RadioInfoOnStart = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        this.e.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
        RST rst = this.e;
        g3 a2 = g3.a(this.b);
        RST rst2 = this.e;
        DRI dri = rst2.RadioInfoOnStart;
        rst.IspInfo = a2.a(dri, rst2.WifiInfoOnStart, g3.a(dri.ConnectionType));
        this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
        RST rst3 = this.e;
        rst3.TestTimestamp = rst3.TimeInfoOnStart.TimestampTableau;
        rst3.DeviceInfo = CDC.getDeviceInfo(this.b);
        this.e.StorageInfo = CDC.j(this.b);
        this.e.BatteryInfoOnStart = this.d.a();
        this.e.MemoryInfoOnStart = CDC.d(this.b);
        this.e.TrafficInfoOnStart = CDC.f();
        this.e.LocationInfoOnStart = this.c.getLastLocationInfo();
    }

    private void k() {
        qa a2 = a();
        long j2 = (long) a2.a;
        this.g = j2;
        this.h = (int) (j2 / a2.reportingInterval);
        this.B.postDelayed(new f(a2), 500);
    }

    private void l() {
        ra d2 = d();
        long j2 = (long) d2.a;
        this.g = j2;
        this.h = (int) (j2 / d2.reportingInterval);
        this.B.postDelayed(new h(d2), 500);
    }

    private void m() {
        this.i = ja.TEST_TCPDOWNLOAD;
        if (this.q) {
            k();
        } else {
            o();
        }
    }

    private void n() {
        this.i = ja.TEST_TCPPING;
        if (this.p) {
            a(c());
        } else {
            b(c());
        }
    }

    private void o() {
        bb b2 = b();
        long j2 = b2.measureLength;
        this.g = j2;
        this.h = (int) (j2 / b2.reportingInterval);
        this.B.postDelayed(new g(b2), 500);
    }

    private void p() {
        hb e2 = e();
        long j2 = e2.measureLength;
        this.g = j2;
        this.h = (int) (j2 / e2.reportingInterval);
        this.B.postDelayed(new i(e2), 500);
    }

    private void q() {
        this.i = ja.TEST_TCPUPLOAD;
        if (this.r) {
            l();
        } else {
            p();
        }
    }

    public void addAnswer(String str) {
        ArrayList<k7> arrayList = this.f;
        arrayList.add(new k7(arrayList.size() + 1, str));
    }

    public void cancelSpeedtest() {
        v vVar = this.s;
        if (vVar != null) {
            vVar.a();
        }
    }

    @Deprecated
    public void enableTracerouteTest(boolean z2) {
        this.o = z2;
    }

    public RST getResult() {
        try {
            return (RST) this.e.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return this.e;
        }
    }

    public boolean hasDataConnection() {
        return InsightCore.getRadioController().l();
    }

    @Deprecated
    public boolean isTracerouteTestEnabled() {
        return this.o;
    }

    public void onPingProgress(float f2, int i2) {
        if (this.a != null) {
            this.B.post(new k(f2, i2));
        }
    }

    public void onTestStatusChanged(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j2) {
        a(this.i, speedtestEngineStatus);
    }

    public void onTracerouteProgress(float f2, String str, int i2, int i3) {
    }

    public void onTransferProgress(float f2, long j2) {
        if (this.a != null) {
            this.B.post(new j(f2, j2));
        }
    }

    public void onTransferProgressRemote(float f2, long j2) {
    }

    public void setSpeedtestName(String str) {
        this.l = str;
    }

    @Deprecated
    public void startListening() {
    }

    public void startSpeedtest() {
        startSpeedtest(InsightCore.getInsightConfig().d1(), InsightCore.getInsightConfig().b1(), InsightCore.getInsightConfig().c1(), true);
    }

    @Deprecated
    public void stopListening() {
    }

    public void updateSpeedTestServer(String[] strArr, String[] strArr2, String[] strArr3) {
        if (strArr != null && strArr.length > 0) {
            wa waVar = new wa();
            this.A = waVar;
            waVar.ips = strArr;
        }
        if (strArr2 != null && strArr2.length > 0) {
            wa waVar2 = new wa();
            this.y = waVar2;
            waVar2.ips = strArr2;
        }
        if (strArr3 != null && strArr3.length > 0) {
            wa waVar3 = new wa();
            this.z = waVar3;
            waVar3.ips = strArr3;
        }
    }

    private bb b() {
        bb bbVar = new bb();
        bbVar.testSockets = this.w;
        bbVar.measureLength = 7000;
        bbVar.reportingInterval = 200;
        wa waVar = this.y;
        if (waVar != null) {
            bbVar.server = waVar;
        }
        return bbVar;
    }

    private gb c() {
        gb gbVar = new gb();
        gbVar.count = this.x;
        if (this.p) {
            gbVar.sleep = 200;
            wa waVar = new wa();
            gbVar.server = waVar;
            waVar.ips = this.t.split(",");
        } else {
            gbVar.sleep = 50;
        }
        wa waVar2 = this.A;
        if (waVar2 != null) {
            gbVar.server = waVar2;
        }
        int i2 = gbVar.count;
        long j2 = (long) (gbVar.sleep * i2);
        this.g = j2;
        this.h = i2;
        if (j2 < 1) {
            this.g = 1;
        }
        if (i2 < 1) {
            this.h = 1;
        }
        return gbVar;
    }

    private ra d() {
        ra raVar = new ra();
        raVar.a = 7000;
        raVar.reportingInterval = 200;
        wa waVar = new wa();
        raVar.server = waVar;
        waVar.ips = this.v.split(",");
        wa waVar2 = this.z;
        if (waVar2 != null) {
            raVar.server = waVar2;
        }
        return raVar;
    }

    private hb e() {
        hb hbVar = new hb();
        hbVar.testSockets = this.w;
        hbVar.measureLength = 7000;
        hbVar.reportingInterval = 200;
        wa waVar = this.z;
        if (waVar != null) {
            hbVar.server = waVar;
        }
        return hbVar;
    }

    private void f() {
        this.c = new CLC(this.b);
        this.d = new x(this.b);
        this.f = new ArrayList<>();
        this.B = new Handler(Looper.getMainLooper());
    }

    public void startSpeedtest(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!this.m) {
            this.w = InsightCore.getInsightConfig().a1();
            this.t = InsightCore.getInsightConfig().Y0();
            this.u = InsightCore.getInsightConfig().U0();
            this.v = InsightCore.getInsightConfig().V0();
            this.x = InsightCore.getInsightConfig().Z0();
            this.p = z2;
            this.q = z3;
            this.r = z4;
            this.n = z5;
            g();
            this.m = true;
            this.e = new RST(this.j, this.k.q());
            j();
            m5 m5Var = m5.HTTP;
            if (InsightCore.getInsightConfig().X0() == 20000) {
                m5Var = m5.TCP20000;
            }
            RST rst = this.e;
            rst.LatencyTest.MeasurementType = m5Var;
            RDT rdt = rst.DownloadTest;
            rdt.MeasurementType = m5Var;
            RUT rut = rst.UploadTest;
            rut.MeasurementType = m5Var;
            if (this.q) {
                rdt.MeasurementType = m5.HTTP_FILE_DOWNLOAD;
            }
            if (this.r) {
                rut.MeasurementType = m5.HTTP_FILE_UPLOAD;
            }
            rst.SpeedtestEndState = t9.ConnectingToControlServer;
            n();
        }
    }

    private qa a() {
        qa qaVar = new qa();
        qaVar.a = 7000;
        qaVar.reportingInterval = 200;
        wa waVar = new wa();
        qaVar.server = waVar;
        waVar.ips = this.u.split(",");
        wa waVar2 = this.y;
        if (waVar2 != null) {
            qaVar.server = waVar2;
        }
        return qaVar;
    }

    private void b(gb gbVar) {
        this.e.LatencyTest.PingType = y6.TPing;
        this.B.post(new d(gbVar));
    }

    private void a(gb gbVar) {
        this.e.LatencyTest.PingType = y6.ICMP;
        ThreadManager.getInstance().getCachedThreadPool().execute(new e(gbVar));
    }

    private void b(SpeedtestEngineStatus speedtestEngineStatus) {
        p4 p4Var;
        if (speedtestEngineStatus == SpeedtestEngineStatus.CONNECT) {
            a(SpeedtestStatus.PING_INIT);
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.RUN) {
            this.e.SpeedtestEndState = t9.LatencyTestStart;
            a(SpeedtestStatus.PING_RUN);
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ERROR) {
            RP3 b2 = this.s.b();
            if (b2 instanceof p4) {
                try {
                    p4Var = (p4) b2.clone();
                } catch (CloneNotSupportedException e2) {
                    e2.printStackTrace();
                    p4Var = (p4) b2;
                }
                RLT rlt = this.e.LatencyTest;
                ub ubVar = p4Var.TimeInfoOnStart;
                rlt.TimeInfoOnStart = ubVar;
                rlt.TimestampOnStart = ubVar.TimestampTableau;
                rlt.BatteryInfoOnStart = p4Var.BatteryInfoOnStart;
                rlt.LocationInfoOnStart = p4Var.LocationInfoOnStart;
                rlt.MemoryInfoOnStart = p4Var.MemoryInfoOnStart;
                rlt.RadioInfoOnStart = p4Var.RadioInfoOnStart;
                rlt.TrafficInfoOnStart = p4Var.TrafficInfoOnStart;
                rlt.WifiInfoOnStart = p4Var.WifiInfoOnStart;
                ub ubVar2 = p4Var.TimeInfoOnEnd;
                rlt.TimeInfoOnEnd = ubVar2;
                rlt.TimestampOnEnd = ubVar2.TimestampTableau;
                rlt.BatteryInfoOnEnd = p4Var.BatteryInfoOnEnd;
                rlt.LocationInfoOnEnd = p4Var.LocationInfoOnEnd;
                rlt.MemoryInfoOnEnd = p4Var.MemoryInfoOnEnd;
                rlt.RadioInfoOnEnd = p4Var.RadioInfoOnEnd;
                rlt.TrafficInfoOnEnd = p4Var.TrafficInfoOnEnd;
                rlt.WifiInfoOnEnd = p4Var.WifiInfoOnEnd;
                rlt.RatShare2G = p4Var.RatShare2G;
                rlt.RatShare3G = p4Var.RatShare3G;
                rlt.RatShare4G = p4Var.RatShare4G;
                rlt.RatShare4G5G = p4Var.RatShare4G5G;
                rlt.RatShare5GSA = p4Var.RatShare5GSA;
                rlt.RatShareWiFi = p4Var.RatShareWiFi;
                rlt.RatShareUnknown = p4Var.RatShareUnknown;
                rlt.Server = p4Var.Server;
                rlt.IpVersion = p4Var.IpVersion;
                rlt.MeasurementType = p4Var.MeasurementType;
                rlt.Jitter = p4Var.Jitter;
                rlt.RttMin = i1.a(p4Var.MinValue);
                this.e.LatencyTest.RttMax = i1.a(p4Var.MaxValue);
                this.e.LatencyTest.RttAvg = i1.a(p4Var.AvgValue);
                this.e.LatencyTest.RttMed = i1.a(p4Var.MedValue);
                RLT rlt2 = this.e.LatencyTest;
                rlt2.MeasurementPointsLatency = p4Var.MeasurementPoints;
                rlt2.Success = p4Var.Success;
                a(rlt2);
            }
            if (speedtestEngineStatus == SpeedtestEngineStatus.END) {
                a(SpeedtestStatus.PING_END);
                this.e.SpeedtestEndState = t9.LatencyTestEnd;
                this.s.i();
                m();
            }
        }
    }

    private void a(ja jaVar, SpeedtestEngineStatus speedtestEngineStatus) {
        if (jaVar == ja.TEST_TCPPING) {
            b(speedtestEngineStatus);
        } else if (jaVar == ja.TEST_TCPDOWNLOAD) {
            a(speedtestEngineStatus);
        } else if (jaVar == ja.TEST_TCPUPLOAD) {
            c(speedtestEngineStatus);
        }
        if (jaVar == ja.TEST_TCPUPLOAD && speedtestEngineStatus == SpeedtestEngineStatus.END) {
            i();
            h();
            a(SpeedtestStatus.FINISH);
            this.m = false;
            this.s.i();
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.ABORTED) {
            a(SpeedtestStatus.ABORTED);
            this.m = false;
            this.s.i();
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.ERROR) {
            i();
            h();
            a(SpeedtestStatus.ERROR);
            this.m = false;
            this.s.i();
        }
    }

    private void c(SpeedtestEngineStatus speedtestEngineStatus) {
        u uVar;
        if (speedtestEngineStatus == SpeedtestEngineStatus.CONNECT) {
            this.e.SpeedtestEndState = t9.UploadTestStart;
            a(SpeedtestStatus.UP_INIT);
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.RUN) {
            a(SpeedtestStatus.UP_RUN);
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ERROR) {
            RP3 b2 = this.s.b();
            if (b2 instanceof u) {
                try {
                    uVar = (u) b2.clone();
                } catch (CloneNotSupportedException e2) {
                    e2.printStackTrace();
                    uVar = (u) b2;
                }
                RUT rut = this.e.UploadTest;
                ub ubVar = uVar.TimeInfoOnStart;
                rut.TimeInfoOnStart = ubVar;
                rut.TimestampOnStart = ubVar.TimestampTableau;
                rut.BatteryInfoOnStart = uVar.BatteryInfoOnStart;
                rut.LocationInfoOnStart = uVar.LocationInfoOnStart;
                rut.MemoryInfoOnStart = uVar.MemoryInfoOnStart;
                rut.RadioInfoOnStart = uVar.RadioInfoOnStart;
                rut.TrafficInfoOnStart = uVar.TrafficInfoOnStart;
                rut.WifiInfoOnStart = uVar.WifiInfoOnStart;
                ub ubVar2 = uVar.TimeInfoOnEnd;
                rut.TimeInfoOnEnd = ubVar2;
                rut.TimestampOnEnd = ubVar2.TimestampTableau;
                rut.BatteryInfoOnEnd = uVar.BatteryInfoOnEnd;
                rut.LocationInfoOnEnd = uVar.LocationInfoOnEnd;
                rut.MemoryInfoOnEnd = uVar.MemoryInfoOnEnd;
                rut.RadioInfoOnEnd = uVar.RadioInfoOnEnd;
                rut.TrafficInfoOnEnd = uVar.TrafficInfoOnEnd;
                rut.WifiInfoOnEnd = uVar.WifiInfoOnEnd;
                rut.RatShare2G = uVar.RatShare2G;
                rut.RatShare3G = uVar.RatShare3G;
                rut.RatShare4G = uVar.RatShare4G;
                rut.RatShare5GSA = uVar.RatShare5GSA;
                rut.RatShare4G5G = uVar.RatShare4G5G;
                rut.RatShareWiFi = uVar.RatShareWiFi;
                rut.RatShareUnknown = uVar.RatShareUnknown;
                rut.Server = uVar.Server;
                rut.IpVersion = uVar.IpVersion;
                rut.MeasurementType = uVar.MeasurementType;
                rut.MinValue = uVar.MinValue;
                rut.MaxValue = uVar.MaxValue;
                rut.AvgValue = uVar.AvgValue;
                rut.MedValue = uVar.MedValue;
                rut.MeasurementPointsUpload = uVar.MeasurementPoints;
                rut.Success = uVar.Success;
                a(rut);
            }
            if (speedtestEngineStatus == SpeedtestEngineStatus.END) {
                a(SpeedtestStatus.UP_END);
                this.e.SpeedtestEndState = t9.UploadTestEnd;
                this.s.i();
                h();
            }
        }
    }

    private void a(SpeedtestEngineStatus speedtestEngineStatus) {
        u uVar;
        if (speedtestEngineStatus == SpeedtestEngineStatus.CONNECT) {
            this.e.SpeedtestEndState = t9.DownloadTestStart;
            a(SpeedtestStatus.DOWN_INIT);
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.RUN) {
            a(SpeedtestStatus.DOWN_RUN);
        } else if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ERROR) {
            RP3 b2 = this.s.b();
            if (b2 instanceof u) {
                try {
                    uVar = (u) b2.clone();
                } catch (CloneNotSupportedException e2) {
                    e2.printStackTrace();
                    uVar = (u) b2;
                }
                RDT rdt = this.e.DownloadTest;
                ub ubVar = uVar.TimeInfoOnStart;
                rdt.TimeInfoOnStart = ubVar;
                rdt.TimestampOnStart = ubVar.TimestampTableau;
                rdt.BatteryInfoOnStart = uVar.BatteryInfoOnStart;
                rdt.LocationInfoOnStart = uVar.LocationInfoOnStart;
                rdt.MemoryInfoOnStart = uVar.MemoryInfoOnStart;
                rdt.RadioInfoOnStart = uVar.RadioInfoOnStart;
                rdt.TrafficInfoOnStart = uVar.TrafficInfoOnStart;
                rdt.WifiInfoOnStart = uVar.WifiInfoOnStart;
                ub ubVar2 = uVar.TimeInfoOnEnd;
                rdt.TimeInfoOnEnd = ubVar2;
                rdt.TimestampOnEnd = ubVar2.TimestampTableau;
                rdt.BatteryInfoOnEnd = uVar.BatteryInfoOnEnd;
                rdt.LocationInfoOnEnd = uVar.LocationInfoOnEnd;
                rdt.MemoryInfoOnEnd = uVar.MemoryInfoOnEnd;
                rdt.RadioInfoOnEnd = uVar.RadioInfoOnEnd;
                rdt.TrafficInfoOnEnd = uVar.TrafficInfoOnEnd;
                rdt.WifiInfoOnEnd = uVar.WifiInfoOnEnd;
                rdt.RatShare2G = uVar.RatShare2G;
                rdt.RatShare3G = uVar.RatShare3G;
                rdt.RatShare4G = uVar.RatShare4G;
                rdt.RatShare5GSA = uVar.RatShare5GSA;
                rdt.RatShare4G5G = uVar.RatShare4G5G;
                rdt.RatShareWiFi = uVar.RatShareWiFi;
                rdt.RatShareUnknown = uVar.RatShareUnknown;
                rdt.Server = uVar.Server;
                rdt.IpVersion = uVar.IpVersion;
                rdt.MeasurementType = uVar.MeasurementType;
                rdt.MinValue = uVar.MinValue;
                rdt.MaxValue = uVar.MaxValue;
                rdt.AvgValue = uVar.AvgValue;
                rdt.MedValue = uVar.MedValue;
                rdt.MeasurementPointsDownload = uVar.MeasurementPoints;
                rdt.Success = uVar.Success;
                a(rdt);
            }
            if (speedtestEngineStatus == SpeedtestEngineStatus.END) {
                a(SpeedtestStatus.DOWN_END);
                this.e.SpeedtestEndState = t9.DownloadTestEnd;
                this.s.i();
                q();
            }
        }
    }

    private void a(SpeedtestStatus speedtestStatus) {
        if (this.a != null) {
            this.B.post(new l(speedtestStatus));
        }
    }

    private void a(RLT rlt) {
        if (this.a != null) {
            this.B.post(new a(rlt));
        }
    }

    private void a(RDT rdt) {
        if (this.a != null) {
            this.B.post(new b(rdt));
        }
    }

    private void a(RUT rut) {
        if (this.a != null) {
            this.B.post(new c(rut));
        }
    }
}
