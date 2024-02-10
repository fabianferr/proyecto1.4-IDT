package com.umlaut.crowd;

import android.app.Notification;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.Settings;
import com.umlaut.crowd.database.StatsDatabase;
import com.umlaut.crowd.internal.b6;
import com.umlaut.crowd.internal.d3;
import com.umlaut.crowd.internal.ee;
import com.umlaut.crowd.internal.f1;
import com.umlaut.crowd.internal.g1;
import com.umlaut.crowd.internal.i0;
import com.umlaut.crowd.internal.kc;
import com.umlaut.crowd.internal.kd;
import com.umlaut.crowd.internal.l7;
import com.umlaut.crowd.internal.ld;
import com.umlaut.crowd.internal.n;
import com.umlaut.crowd.internal.nd;
import com.umlaut.crowd.internal.oe;
import com.umlaut.crowd.internal.s;
import com.umlaut.crowd.internal.sd;
import com.umlaut.crowd.internal.u1;
import com.umlaut.crowd.internal.u4;
import com.umlaut.crowd.internal.w5;
import com.umlaut.crowd.internal.y3;
import com.umlaut.crowd.internal.z9;
import com.umlaut.crowd.manager.VoWifiTestManager;
import com.umlaut.crowd.qoe.QoeManager;
import com.umlaut.crowd.service.ConnectivityService;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import java.security.PublicKey;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class InsightCore {
    /* access modifiers changed from: private */
    public static InsightCore B = null;
    public static final String LIB_BUILD = "20230301124918";
    public static final String LIB_COPYRIGHT = "© 2014 - 2023 umlaut communications GmbH";
    public static final String LIB_NAME = "insight Core SDK";
    private d3 A;
    private IC a;
    private TimeServer b;
    /* access modifiers changed from: private */
    public j c;
    /* access modifiers changed from: private */
    public nd d;
    private QoeManager e;
    /* access modifiers changed from: private */
    public IS f;
    /* access modifiers changed from: private */
    public final Context g;
    private PublicKey h;
    private OnGuidChangedListener i;
    private OnLoggingEventListener j;
    private OnConnectivityTestListener k;
    private kc l;
    private u1 m;
    private i0 n;
    private StatsDatabase o;
    private l7 p;
    private ee q;
    private sd r;
    /* access modifiers changed from: private */
    public n s;
    private b6 t;
    private w5 u;
    private VoWifiTestManager v;
    private f1 w;
    /* access modifiers changed from: private */
    public y3 x;
    private oe y;
    private s z;

    public interface OnConnectivityTestListener {
        void onConnectivityTestEnd(g1 g1Var);

        void onConnectivityTestStart();
    }

    public interface OnGuidChangedListener {
        void OnGuidChanged(String str);
    }

    public interface OnInsightCoreInitializedListener {
        void onInitializationCompleted();
    }

    public interface OnLoggingEventListener {
        void onLoggingEvent(u4 u4Var, long j, Map<String, String> map);
    }

    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ OnInsightCoreInitializedListener c;

        a(Context context, int i, OnInsightCoreInitializedListener onInsightCoreInitializedListener) {
            this.a = context;
            this.b = i;
            this.c = onInsightCoreInitializedListener;
        }

        public void run() {
            InsightCore.b(this.a, this.b, this.c);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (InsightCore.isInitialized() && !InsightCore.e()) {
                if (InsightCore.B.x == null) {
                    y3 unused = InsightCore.B.x = new y3(InsightCore.B.g);
                }
                InsightCore.B.x.a();
            }
        }
    }

    class c implements Callable<Boolean> {
        c() {
        }

        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(InsightCore.e());
        }
    }

    class d implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ Notification b;

        d(boolean z, Notification notification) {
            this.a = z;
            this.b = notification;
        }

        public void run() {
            if (InsightCore.B.f.n() && !InsightCore.e() && com.umlaut.crowd.internal.f.b(InsightCore.B.g)) {
                Intent intent = new Intent(InsightCore.B.g, ConnectivityService.class);
                intent.putExtra(ConnectivityService.o, this.a);
                intent.putExtra(ConnectivityService.p, this.b);
                InsightCore.B.g.startService(intent);
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ boolean a;

        e(boolean z) {
            this.a = z;
        }

        public void run() {
            if (InsightCore.B.f.G()) {
                InsightCore.B.f.b(this.a);
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ Context a;

        f(Context context) {
            this.a = context;
        }

        public void run() {
            JobScheduler jobScheduler;
            Context applicationContext = this.a.getApplicationContext();
            if (InsightCore.isInitialized()) {
                InsightCore.B.g();
                InsightCore.getRadioController().A();
                InsightCore.getWifiController().l();
                if (InsightCore.B.c != null) {
                    InsightCore.B.g.unregisterReceiver(InsightCore.B.c);
                }
            } else if (!com.umlaut.crowd.internal.f.b(applicationContext) && (jobScheduler = (JobScheduler) applicationContext.getSystemService("jobscheduler")) != null) {
                jobScheduler.cancel(f1.f);
                jobScheduler.cancel(y3.f);
            }
            InsightCore unused = InsightCore.B = null;
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            if (InsightCore.B.s != null) {
                InsightCore.B.s.d();
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            InsightCore.B.f.a(true);
        }
    }

    class i implements Runnable {
        final /* synthetic */ long a;

        i(long j) {
            this.a = j;
        }

        public void run() {
            InsightCore.B.f.b(this.a);
        }
    }

    private class j extends BroadcastReceiver {
        private j() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                if (InsightCore.e()) {
                    InsightCore.this.g();
                    return;
                }
                InsightCore.startServices();
                if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && InsightCore.getInsightSettings().e()) {
                    InsightCore.this.d.uploadFiles(false);
                }
            }
        }

        /* synthetic */ j(InsightCore insightCore, a aVar) {
            this();
        }
    }

    private InsightCore(Context context) {
        this.g = context.getApplicationContext();
    }

    public static void DEBUG_uploadFiles() {
        B.d.uploadFiles(true);
    }

    public static n getAppUsageManager() {
        return B.s;
    }

    public static boolean getAppUsageServiceEnabled() {
        return B.f.d();
    }

    public static s getBackgroundTestManager() {
        InsightCore insightCore = B;
        if (insightCore.z == null) {
            insightCore.z = new s(B.g);
        }
        return B.z;
    }

    public static boolean getBackgroundTestServiceEnabled() {
        return B.f.f();
    }

    public static i0 getBluetoothController() {
        return B.n;
    }

    public static boolean getConnectivityKeepaliveEnabled() {
        return B.f.m();
    }

    public static boolean getConnectivityTestEnabled() {
        return B.f.n();
    }

    public static boolean getCoverageMapperServiceEnabled() {
        return B.f.o();
    }

    public static u1 getDatabaseHelper() {
        return B.m;
    }

    public static d3 getForegroundTestManager() {
        InsightCore insightCore = B;
        if (insightCore.A == null) {
            insightCore.A = new d3(B.g);
        }
        return B.A;
    }

    public static String getGUID() {
        if (!isInitialized()) {
            return "InsightCore SDK not initialized";
        }
        return B.f.q();
    }

    public static IC getInsightConfig() {
        return B.a;
    }

    public static IS getInsightSettings() {
        return B.f;
    }

    public static boolean getMessagingServiceEnabled() {
        return B.f.C();
    }

    public static b6 getNirManager() {
        InsightCore insightCore = B;
        if (insightCore.t == null) {
            insightCore.t = new b6(B.g);
        }
        return B.t;
    }

    public static OnConnectivityTestListener getOnConnectivityTestListener() {
        return B.k;
    }

    public static OnGuidChangedListener getOnGuidChangedListener() {
        return B.i;
    }

    public static OnLoggingEventListener getOnLoggingEventListener() {
        return B.j;
    }

    public static String getProjectID() {
        if (!isInitialized()) {
            return "InsightCore SDK not initialized";
        }
        return B.a.f1();
    }

    public static PublicKey getPublicKey() {
        return B.h;
    }

    public static QoeManager getQoeManager() {
        InsightCore insightCore = B;
        if (insightCore.e == null) {
            insightCore.e = new QoeManager(B.g);
        }
        return B.e;
    }

    public static boolean getQoeManagerEnabled() {
        return B.f.E();
    }

    public static l7 getRadioController() {
        return B.p;
    }

    public static StatsDatabase getStatsDatabase() {
        return B.o;
    }

    public static synchronized TimeServer getTimeServer() {
        TimeServer timeServer;
        synchronized (InsightCore.class) {
            timeServer = B.b;
        }
        return timeServer;
    }

    public static boolean getTrafficAnalyzerEnabled() {
        return B.f.H();
    }

    public static kd[] getUploadExtraInfo() {
        kd[] a2 = ld.a(getInsightSettings().J());
        return a2 == null ? new kd[0] : a2;
    }

    public static nd getUploadManager() {
        return B.d;
    }

    public static VoWifiTestManager getVoWifiTestManager() {
        InsightCore insightCore = B;
        if (insightCore.v == null) {
            insightCore.v = new VoWifiTestManager(B.g);
        }
        return B.v;
    }

    public static boolean getVoWifiTestManagerEnabled() {
        return B.f.N();
    }

    public static sd getVoiceManager() {
        return B.r;
    }

    public static boolean getVoiceServiceEnabled() {
        return B.f.P();
    }

    public static ee getWifiController() {
        return B.q;
    }

    public static boolean getWifiScanServiceEnabled() {
        return B.f.Q();
    }

    public static void init(Context context, int i2) {
        b(context, i2, (OnInsightCoreInitializedListener) null);
    }

    public static void initAsync(Context context, int i2, OnInsightCoreInitializedListener onInsightCoreInitializedListener) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(context, i2, onInsightCoreInitializedListener));
    }

    public static boolean isExpiredCore() {
        try {
            return ((Boolean) ThreadManager.getInstance().getSingleThreadScheduledExecutor().submit(new c()).get()).booleanValue();
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return true;
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return true;
        }
    }

    public static synchronized boolean isInitialized() {
        boolean z2;
        synchronized (InsightCore.class) {
            z2 = B != null;
        }
        return z2;
    }

    public static void openPrivacyWebPage(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getInsightConfig().e1() + getGUID())));
    }

    public static void putUploadExtraInfo(String str, String str2) {
        String str3;
        if (str.length() != 0 && str2.length() != 0) {
            kd[] uploadExtraInfo = getUploadExtraInfo();
            boolean z2 = false;
            for (kd kdVar : uploadExtraInfo) {
                if (kdVar.Key.equals(str)) {
                    kdVar.Value = str2;
                    z2 = true;
                }
            }
            if (!z2) {
                int length = uploadExtraInfo.length + 1;
                kd[] kdVarArr = new kd[length];
                kd kdVar2 = new kd(str, str2);
                System.arraycopy(uploadExtraInfo, 0, kdVarArr, 0, uploadExtraInfo.length);
                kdVarArr[length - 1] = kdVar2;
                str3 = ld.a(kdVarArr);
            } else {
                str3 = ld.a(uploadExtraInfo);
            }
            getInsightSettings().f(str3);
        }
    }

    public static void reInitializeForegroundAppDetector() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new g());
    }

    public static void refreshGuid() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new h());
    }

    public static void register(boolean z2) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new e(z2));
    }

    public static void runConnectivityTestInForeground(boolean z2, Notification notification) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new d(z2, notification));
    }

    public static void setAppUsageServiceEnabled(boolean z2) {
        if (getAppUsageServiceEnabled() != z2) {
            B.f.e(z2);
            InsightCore insightCore = B;
            if (insightCore.s == null) {
                insightCore.s = new n(B.g);
            }
            if (z2) {
                B.s.f();
            } else {
                B.s.h();
            }
        }
    }

    public static void setBackgroundTestServiceEnabled(boolean z2) {
        if (getBackgroundTestServiceEnabled() != z2) {
            B.f.g(z2);
            InsightCore insightCore = B;
            if (insightCore.z == null) {
                insightCore.z = new s(B.g);
            }
            if (z2) {
                B.z.a();
            } else {
                B.z.f();
            }
        }
    }

    public static void setConnectivityKeepaliveEnabled(boolean z2) {
        if (getConnectivityKeepaliveEnabled() != z2) {
            B.f.h(z2);
            if (!e()) {
                InsightCore insightCore = B;
                if (insightCore.w == null) {
                    insightCore.w = new f1(B.g);
                }
                if (z2) {
                    B.w.a();
                } else if (!getConnectivityTestEnabled()) {
                    B.w.h();
                }
            }
        }
    }

    public static void setConnectivityTestEnabled(boolean z2) {
        if (getConnectivityTestEnabled() != z2) {
            B.f.i(z2);
            if (!e()) {
                InsightCore insightCore = B;
                if (insightCore.w == null) {
                    insightCore.w = new f1(B.g);
                }
                if (z2) {
                    B.w.a();
                } else if (!getConnectivityKeepaliveEnabled()) {
                    B.w.h();
                }
            }
        }
    }

    public static void setCoverageMapperServiceEnabled(boolean z2) {
        if (getCoverageMapperServiceEnabled() != z2) {
            B.f.j(z2);
            InsightCore insightCore = B;
            if (insightCore.t == null) {
                insightCore.t = new b6(B.g);
            }
            if (z2) {
                B.t.f();
            } else {
                B.t.k();
            }
        }
    }

    public static void setGuidMaxAge(long j2) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new i(j2));
    }

    public static void setMessagingServiceEnabled(boolean z2) {
        if (getMessagingServiceEnabled() != z2) {
            B.f.k(z2);
            InsightCore insightCore = B;
            if (insightCore.u == null) {
                insightCore.u = new w5(B.g);
            }
            if (z2) {
                B.u.a();
            } else {
                B.u.b();
            }
        }
    }

    public static void setOnConnectivityTestListener(OnConnectivityTestListener onConnectivityTestListener) {
        B.k = onConnectivityTestListener;
    }

    public static void setOnGuidChangedListener(OnGuidChangedListener onGuidChangedListener) {
        B.i = onGuidChangedListener;
    }

    public static void setOnLoggingEventListener(OnLoggingEventListener onLoggingEventListener) {
        B.j = onLoggingEventListener;
    }

    public static void setQoeManagerEnabled(boolean z2) {
        B.f.l(z2);
        if (z2) {
            InsightCore insightCore = B;
            if (insightCore.e == null) {
                insightCore.e = new QoeManager(B.g);
            }
        }
    }

    public static void setTrafficAnalyzerEnabled(boolean z2) {
        if (getTrafficAnalyzerEnabled() != z2) {
            B.f.n(z2);
            InsightCore insightCore = B;
            if (insightCore.l == null) {
                insightCore.l = new kc(B.g);
            }
            if (z2) {
                B.l.b();
            } else {
                B.l.d();
            }
        }
    }

    public static void setVoWifiTestManagerEnabled(boolean z2) {
        if (getVoWifiTestManagerEnabled() != z2) {
            B.f.p(z2);
            InsightCore insightCore = B;
            if (insightCore.v == null) {
                insightCore.v = new VoWifiTestManager(B.g);
            }
            if (z2) {
                B.v.startMonitor();
            } else {
                B.v.stopMonitor();
            }
        }
    }

    public static void setVoiceServiceEnabled(boolean z2) {
        if (getVoiceServiceEnabled() != z2) {
            B.f.q(z2);
            InsightCore insightCore = B;
            if (insightCore.r == null) {
                insightCore.r = new sd(B.g);
            }
            if (z2) {
                B.r.l();
            } else {
                B.r.m();
            }
        }
    }

    public static void setWifiScanServiceEnabled(boolean z2) {
        if (getWifiScanServiceEnabled() != z2) {
            B.f.r(z2);
            InsightCore insightCore = B;
            if (insightCore.y == null) {
                insightCore.y = new oe(B.g);
            }
            if (z2) {
                B.y.d();
            } else {
                B.y.e();
            }
        }
    }

    public static void startServices() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b());
    }

    public static void terminate(Context context) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new f(context));
    }

    private void c() {
        String b2 = this.f.b();
        String string = Settings.Secure.getString(this.g.getContentResolver(), "android_id");
        if (b2 == null || b2.isEmpty()) {
            this.f.c(string);
        } else if (!b2.equals(string)) {
            this.f.c(string);
            refreshGuid();
        }
    }

    private void d() {
        this.b = new TimeServer();
        this.d = new nd(this.g);
        this.f = new IS(this.g);
        if (getInsightConfig().a()) {
            c();
        }
        this.c = new j(this, (a) null);
        l7 l7Var = new l7(this.g);
        this.p = l7Var;
        l7Var.z();
        ee eeVar = new ee(this.g);
        this.q = eeVar;
        eeVar.j();
        if (this.f.E()) {
            this.e = new QoeManager(this.g);
        }
        d3 d3Var = new d3(this.g);
        this.A = d3Var;
        d3Var.e();
        this.m = new u1(this.g);
        this.n = new i0(this.g);
        this.o = new StatsDatabase(this.g);
        this.g.registerReceiver(this.c, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    /* access modifiers changed from: private */
    public static boolean e() {
        if (getInsightConfig().f0() != -1 && TimeServer.getTimeInMillis() > getInsightConfig().f0()) {
            return true;
        }
        return false;
    }

    private void f() {
        if (!e()) {
            if (this.f.H()) {
                kc kcVar = new kc(this.g);
                this.l = kcVar;
                kcVar.b();
            }
            if (this.f.P()) {
                sd sdVar = new sd(this.g);
                this.r = sdVar;
                sdVar.l();
            }
            if (this.f.d()) {
                n nVar = new n(this.g);
                this.s = nVar;
                nVar.f();
            }
            if (this.f.o()) {
                b6 b6Var = new b6(this.g);
                this.t = b6Var;
                b6Var.f();
            }
            if (this.f.C()) {
                w5 w5Var = new w5(this.g);
                this.u = w5Var;
                w5Var.a();
            }
            if (this.f.N()) {
                VoWifiTestManager voWifiTestManager = new VoWifiTestManager(this.g);
                this.v = voWifiTestManager;
                voWifiTestManager.startMonitor();
            }
            if (this.f.n() || this.f.m()) {
                f1 f1Var = new f1(this.g);
                this.w = f1Var;
                f1Var.a();
            }
            if (this.f.Q()) {
                oe oeVar = new oe(this.g);
                this.y = oeVar;
                oeVar.d();
            }
            if (this.f.f()) {
                s sVar = new s(this.g);
                this.z = sVar;
                sVar.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        n nVar = this.s;
        if (nVar != null) {
            nVar.h();
        }
        w5 w5Var = this.u;
        if (w5Var != null) {
            w5Var.b();
        }
        b6 b6Var = this.t;
        if (b6Var != null) {
            b6Var.k();
        }
        kc kcVar = this.l;
        if (kcVar != null) {
            kcVar.d();
        }
        sd sdVar = this.r;
        if (sdVar != null) {
            sdVar.m();
        }
        VoWifiTestManager voWifiTestManager = this.v;
        if (voWifiTestManager != null) {
            voWifiTestManager.stopMonitor();
        }
        f1 f1Var = this.w;
        if (f1Var != null) {
            f1Var.h();
        }
        oe oeVar = this.y;
        if (oeVar != null) {
            oeVar.e();
        }
        s sVar = this.z;
        if (sVar != null) {
            sVar.f();
        }
        d3 d3Var = this.A;
        if (d3Var != null) {
            d3Var.g();
        }
        y3 y3Var = this.x;
        if (y3Var != null) {
            y3Var.d();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        throw new java.lang.IllegalArgumentException("configuration is invalid");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r3, byte[] r4, com.umlaut.crowd.InsightCore.OnInsightCoreInitializedListener r5) {
        /*
            java.lang.Class<com.umlaut.crowd.InsightCore> r0 = com.umlaut.crowd.InsightCore.class
            monitor-enter(r0)
            java.lang.String r1 = "insight Core SDK"
            java.lang.String r2 = "Initializing..."
            android.util.Log.i(r1, r2)     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0057
            if (r4 == 0) goto L_0x004f
            com.umlaut.crowd.InsightCore r1 = B     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x001b
            java.lang.String r3 = "insight Core SDK"
            java.lang.String r4 = "Already initialized"
            android.util.Log.i(r3, r4)     // Catch:{ all -> 0x005f }
            monitor-exit(r0)
            return
        L_0x001b:
            com.umlaut.crowd.ICB r4 = com.umlaut.crowd.ICB.a(r4)     // Catch:{ Exception -> 0x0047 }
            com.umlaut.crowd.InsightCore r1 = new com.umlaut.crowd.InsightCore     // Catch:{ all -> 0x005f }
            r1.<init>(r3)     // Catch:{ all -> 0x005f }
            B = r1     // Catch:{ all -> 0x005f }
            java.security.PublicKey r3 = r4.a     // Catch:{ all -> 0x005f }
            r1.h = r3     // Catch:{ all -> 0x005f }
            com.umlaut.crowd.IC r3 = r4.b     // Catch:{ all -> 0x005f }
            r1.a = r3     // Catch:{ all -> 0x005f }
            r1.d()     // Catch:{ all -> 0x005f }
            com.umlaut.crowd.InsightCore r3 = B     // Catch:{ all -> 0x005f }
            r3.f()     // Catch:{ all -> 0x005f }
            startServices()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "insight Core SDK"
            java.lang.String r4 = "Initialized"
            android.util.Log.i(r3, r4)     // Catch:{ all -> 0x005f }
            if (r5 == 0) goto L_0x0045
            r5.onInitializationCompleted()     // Catch:{ all -> 0x005f }
        L_0x0045:
            monitor-exit(r0)
            return
        L_0x0047:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "configuration is invalid"
            r3.<init>(r4)     // Catch:{ all -> 0x005f }
            throw r3     // Catch:{ all -> 0x005f }
        L_0x004f:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "config is null"
            r3.<init>(r4)     // Catch:{ all -> 0x005f }
            throw r3     // Catch:{ all -> 0x005f }
        L_0x0057:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "context is null"
            r3.<init>(r4)     // Catch:{ all -> 0x005f }
            throw r3     // Catch:{ all -> 0x005f }
        L_0x005f:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.InsightCore.init(android.content.Context, byte[], com.umlaut.crowd.InsightCore$OnInsightCoreInitializedListener):void");
    }

    /* access modifiers changed from: private */
    public static void b(Context context, int i2, OnInsightCoreInitializedListener onInsightCoreInitializedListener) {
        try {
            init(context, z9.a(context.getResources().openRawResource(i2)), onInsightCoreInitializedListener);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Error while opening the raw resource");
        }
    }
}
