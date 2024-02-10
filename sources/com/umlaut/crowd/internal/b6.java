package com.umlaut.crowd.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.NetworkTypes;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class b6 implements m7 {
    /* access modifiers changed from: private */
    public static final String V = "b6";
    private static final boolean W = false;
    private static final int X = 500;
    private static final int Y = 2000;
    private static final int Z = 1000;
    private static final int a0 = 10000;
    private static final int b0 = 1000;
    private static final int c0 = 1000;
    private static final int d0 = 1000;
    private static final int e0 = 2000;
    private static final int f0 = 30000;
    private static final String g0 = "p3insnir";
    private static final String h0 = "P3INS_PFK_NIR_FIRSTCELLID_LATITUDE";
    private static final String i0 = "P3INS_PFK_NIR_FIRSTCELLID_LONGITUDE";
    private static final String j0 = "P3INS_PFK_NIR_FIRSTCELLID_GSMCELLID";
    private int A = -1;
    private o6 B = o6.Unknown;
    private NetworkTypes C = NetworkTypes.Unknown;
    private int D = -1;
    private l E;
    private final m F;
    private int G = 0;
    private int H;
    private final boolean I;
    private final boolean J;
    /* access modifiers changed from: private */
    public final boolean K;
    /* access modifiers changed from: private */
    public final boolean L;
    /* access modifiers changed from: private */
    public rc M;
    /* access modifiers changed from: private */
    public rc N;
    /* access modifiers changed from: private */
    public ConnectivityManager.NetworkCallback O;
    /* access modifiers changed from: private */
    public final BroadcastReceiver P;
    private final Runnable Q;
    private final Runnable R;
    private final Runnable S;
    private final Runnable T;
    private final Runnable U;
    private final SharedPreferences a;
    /* access modifiers changed from: private */
    public final Context b;
    private final IS c;
    private final String d;
    /* access modifiers changed from: private */
    public final CLC e;
    /* access modifiers changed from: private */
    public final CLC.ProviderMode f;
    /* access modifiers changed from: private */
    public long g;
    private TelephonyManager h;
    /* access modifiers changed from: private */
    public final ConnectivityManager i;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> j;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> k;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> l;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> m;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public final long p;
    /* access modifiers changed from: private */
    public long q;
    /* access modifiers changed from: private */
    public long r;
    /* access modifiers changed from: private */
    public long s;
    /* access modifiers changed from: private */
    public final long t;
    /* access modifiers changed from: private */
    public final long u;
    /* access modifiers changed from: private */
    public final boolean v;
    /* access modifiers changed from: private */
    public long w;
    /* access modifiers changed from: private */
    public final long x;
    /* access modifiers changed from: private */
    public long y;
    /* access modifiers changed from: private */
    public final long z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (b6.this.L) {
                b6.this.i();
            }
            b6.this.e.startListening(CLC.ProviderMode.Passive);
            if (b6.this.K && Build.VERSION.SDK_INT >= 24) {
                try {
                    b6.this.i.registerDefaultNetworkCallback(b6.this.O);
                } catch (RuntimeException e) {
                    String a2 = b6.V;
                    Log.e(a2, "registerDefaultNetworkCallback: " + e);
                }
            }
            if (b6.this.p > 0 || b6.this.t > 0) {
                InsightCore.getRadioController().a((m7) b6.this);
                if (b6.this.p > 0) {
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
                    intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
                    b6.this.b.registerReceiver(b6.this.P, intentFilter);
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            b6.this.e.stopListening();
            if (b6.this.K && Build.VERSION.SDK_INT >= 24) {
                try {
                    b6.this.i.unregisterNetworkCallback(b6.this.O);
                } catch (Exception e) {
                    String a2 = b6.V;
                    Log.e(a2, "unregisterNetworkCallback: " + e);
                }
            }
            if (b6.this.p > 0 || b6.this.t > 0) {
                InsightCore.getRadioController().b((m7) b6.this);
                if (b6.this.p > 0) {
                    b6.this.b.unregisterReceiver(b6.this.P);
                }
            }
            if (b6.this.L) {
                b6.this.l();
            }
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        public void onReceive(Context context, Intent intent) {
            long unused = b6.this.q = SystemClock.elapsedRealtime();
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            b6 b6Var = b6.this;
            h6 a2 = b6Var.a(b6Var.e.getLastLocationInfo(), b6.this.M, true);
            InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
            if (b6.this.o + b6.this.p < SystemClock.elapsedRealtime()) {
                b6.this.j.cancel(false);
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            b6 b6Var = b6.this;
            h6 a2 = b6Var.a(b6Var.e.getLastLocationInfo(), rc.CellIdChange, true);
            InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
            if (b6.this.r + b6.this.t < SystemClock.elapsedRealtime()) {
                b6.this.k.cancel(false);
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        public void run() {
            b6 b6Var = b6.this;
            h6 a2 = b6Var.a(b6Var.e.getLastLocationInfo(), rc.NrStateChange, true);
            if (!b6.this.v || t4.a(a2.LocationInfo, a2.RadioInfo)) {
                InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
            }
            if (b6.this.s + b6.this.u < SystemClock.elapsedRealtime()) {
                b6.this.l.cancel(false);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            if (SystemClock.elapsedRealtime() > b6.this.g + 2000) {
                b6 b6Var = b6.this;
                h6 a2 = b6Var.a(b6Var.e.getLastLocationInfo(), rc.Foreground, false);
                InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
            }
            if (b6.this.w + b6.this.x < SystemClock.elapsedRealtime()) {
                b6.this.m.cancel(false);
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            b6 b6Var = b6.this;
            h6 a2 = b6Var.a(b6Var.e.getLastLocationInfo(), rc.SamsungNetworkUpdate, true);
            InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
            if (b6.this.y + b6.this.z < SystemClock.elapsedRealtime()) {
                b6.this.n.cancel(false);
            }
        }
    }

    class i implements CLC.e {

        class a implements Runnable {
            final /* synthetic */ q4 a;

            a(q4 q4Var) {
                this.a = q4Var;
            }

            public void run() {
                h6 h6Var;
                if (this.a.LocationProvider == s4.Gps && (b6.this.f == CLC.ProviderMode.GpsAndNetwork || b6.this.f == CLC.ProviderMode.Gps)) {
                    h6Var = b6.this.a(this.a, rc.LocationUpdateGps, false);
                } else {
                    s4 s4Var = this.a.LocationProvider;
                    if ((s4Var == s4.Network || s4Var == s4.Fused) && (b6.this.f == CLC.ProviderMode.GpsAndNetwork || b6.this.f == CLC.ProviderMode.Network)) {
                        h6Var = b6.this.a(this.a, rc.LocationUpdateNetwork, false);
                    } else {
                        h6Var = null;
                    }
                }
                if (h6Var != null) {
                    InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) h6Var, h6Var.timestampMillis);
                }
            }
        }

        i() {
        }

        public void a(q4 q4Var) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= b6.this.g + 500) {
                long unused = b6.this.g = elapsedRealtime;
                ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(q4Var));
            }
        }
    }

    class j extends ConnectivityManager.NetworkCallback {
        j() {
        }

        public void onAvailable(Network network) {
            b6.this.a(network, (NetworkCapabilities) null);
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            b6.this.a(network, networkCapabilities);
        }

        public void onLost(Network network) {
            b6.this.a(network, (NetworkCapabilities) null);
        }
    }

    class k implements Runnable {
        final /* synthetic */ NetworkCapabilities a;
        final /* synthetic */ Network b;

        k(NetworkCapabilities networkCapabilities, Network network) {
            this.a = networkCapabilities;
            this.b = network;
        }

        public void run() {
            rc rcVar;
            rc rcVar2;
            NetworkCapabilities networkCapabilities = this.a;
            if (networkCapabilities == null) {
                networkCapabilities = b6.this.i.getNetworkCapabilities(this.b);
            }
            boolean a2 = n6.a(networkCapabilities);
            if (a2 && b6.this.N != (rcVar2 = rc.InternetConnected)) {
                rc unused = b6.this.N = rcVar2;
                b6.this.takeConnectivityNIR(true);
            } else if (!a2 && b6.this.N != (rcVar = rc.InternetDisconnected)) {
                rc unused2 = b6.this.N = rcVar;
                b6.this.takeConnectivityNIR(false);
            }
        }
    }

    private static class l {
        String a;
        double b;
        double c;

        l(String str, double d, double d2) {
            this.a = str;
            this.b = d;
            this.c = d2;
        }
    }

    public b6(Context context) {
        int b2;
        rc rcVar = rc.Unknown;
        this.M = rcVar;
        this.N = rcVar;
        this.O = null;
        this.P = new c();
        this.Q = new d();
        this.R = new e();
        this.S = new f();
        this.T = new g();
        this.U = new h();
        this.b = context;
        IS is = new IS(context);
        this.c = is;
        this.d = InsightCore.getInsightConfig().f1();
        this.a = context.getSharedPreferences(g0, 0);
        this.f = is.p();
        this.J = InsightCore.getInsightConfig().o1();
        this.p = InsightCore.getInsightConfig().m0();
        this.t = InsightCore.getInsightConfig().g0();
        this.x = InsightCore.getInsightConfig().i0();
        this.z = InsightCore.getInsightConfig().n0();
        this.u = InsightCore.getInsightConfig().k0();
        this.v = InsightCore.getInsightConfig().l0();
        this.I = InsightCore.getInsightConfig().P0();
        this.L = InsightCore.getInsightConfig().o0();
        int Q0 = InsightCore.getInsightConfig().Q0();
        this.H = Q0;
        if (Q0 <= 0) {
            this.H = 1;
        }
        this.K = InsightCore.getInsightConfig().j0();
        this.h = (TelephonyManager) context.getSystemService("phone");
        this.i = (ConnectivityManager) context.getSystemService("connectivity");
        this.F = new m((c) null);
        int i2 = Build.VERSION.SDK_INT;
        if (!(i2 < 24 || this.h == null || (b2 = CDC.b()) == -1)) {
            this.h = this.h.createForSubscriptionId(b2);
        }
        CLC clc = new CLC(context);
        this.e = clc;
        clc.a((CLC.e) new i());
        if (i2 >= 24) {
            this.O = new j();
        }
    }

    public void takeConnectivityNIR(boolean z2) {
        h6 a2 = a(this.e.getLastLocationInfo(), z2 ? rc.InternetConnected : rc.InternetDisconnected, true);
        InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
    }

    private void c() {
        String string = this.a.getString(j0, "");
        if (!string.isEmpty()) {
            this.E = new l(string, Double.longBitsToDouble(this.a.getLong(h0, 0)), Double.longBitsToDouble(this.a.getLong(i0, 0)));
        }
    }

    private void d() {
        this.r = SystemClock.elapsedRealtime();
        ScheduledFuture<?> scheduledFuture = this.k;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.k = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(this.R, 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    private void g() {
        this.s = SystemClock.elapsedRealtime();
        ScheduledFuture<?> scheduledFuture = this.l;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.l = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(this.S, 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    private void h() {
        this.y = SystemClock.elapsedRealtime();
        ScheduledFuture<?> scheduledFuture = this.n;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.n = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(this.U, 0, 2000, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        h6 a2 = a(this.e.getLastLocationInfo(), rc.Start, true);
        InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
    }

    /* access modifiers changed from: private */
    public void l() {
        h6 a2 = a(this.e.getLastLocationInfo(), rc.Stop, true);
        InsightCore.getDatabaseHelper().b(w2.NIR, (RBR) a2, a2.timestampMillis);
    }

    public void e() {
        this.w = SystemClock.elapsedRealtime();
        ScheduledFuture<?> scheduledFuture = this.m;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.m = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(this.T, 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    public void f() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
    }

    public void j() {
        ScheduledFuture<?> scheduledFuture = this.m;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void k() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b());
    }

    public h6 m() {
        return a(this.e.getLastLocationInfo(), rc.PeriodicExternal, true);
    }

    private v0 b() {
        TelephonyManager telephonyManager = this.h;
        if (telephonyManager == null) {
            return v0.Unknown;
        }
        int callState = telephonyManager.getCallState();
        if (callState == 0) {
            return v0.Idle;
        }
        if (callState == 1) {
            return v0.Ringing;
        }
        if (callState != 2) {
            return v0.Unknown;
        }
        return v0.Offhook;
    }

    /* access modifiers changed from: private */
    public void a(Network network, NetworkCapabilities networkCapabilities) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new k(networkCapabilities, network));
    }

    private static class m {
        String a;
        String b;
        String c;
        NetworkTypes d;
        String e;
        String f;
        int g;

        private m() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = NetworkTypes.Unknown;
            this.e = "";
            this.f = "";
        }

        /* access modifiers changed from: package-private */
        public void a(String str, String str2, String str3, NetworkTypes networkTypes, String str4, String str5, int i) {
            this.b = str;
            this.a = str2;
            this.c = str3;
            this.d = networkTypes;
            this.e = str4;
            this.f = str5;
            this.g = i;
        }

        /* synthetic */ m(c cVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public h6 a(q4 q4Var, rc rcVar, boolean z2) {
        String str;
        l lVar;
        l lVar2;
        l lVar3;
        h6 h6Var = new h6(this.d, this.c.q());
        if (this.I) {
            int i2 = this.G;
            this.G = i2 + 1;
            if (i2 % this.H == 0 || z2) {
                h6Var.CellInfo = InsightCore.getRadioController().d();
            }
        }
        ub timeInfo = TimeServer.getTimeInfo();
        h6Var.TimeInfo = timeInfo;
        h6Var.Timestamp = timeInfo.TimestampTableau;
        h6Var.timestampMillis = timeInfo.TimestampMillis;
        h6Var.NirId = k3.a(timeInfo, h6Var.GUID);
        h6Var.LocationInfo = q4Var;
        h6Var.TriggerEvent = rcVar;
        h6Var.ScreenState = CDC.f(this.b);
        h6Var.CallState = b();
        h6Var.WifiInfo = InsightCore.getWifiController().getWifiInfo();
        h6Var.RadioInfo = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
        String str2 = "";
        synchronized (this) {
            if (this.E == null) {
                c();
            }
            if (a(h6Var.RadioInfo.GsmCellId)) {
                q4 q4Var2 = h6Var.LocationInfo;
                if (q4Var2.LocationProvider != s4.Unknown && q4Var2.IsMocked != 1 && q4Var2.LocationAge < 30000 && ((lVar3 = this.E) == null || !lVar3.a.equals(h6Var.RadioInfo.GsmCellId))) {
                    String str3 = h6Var.RadioInfo.GsmCellId;
                    q4 q4Var3 = h6Var.LocationInfo;
                    l lVar4 = new l(str3, q4Var3.LocationLatitude, q4Var3.LocationLongitude);
                    this.E = lVar4;
                    h6Var.CellIdDeltaDistance = 0.0d;
                    a(lVar4);
                }
                str2 = h6Var.RadioInfo.GsmCellId;
            } else if (a(h6Var.RadioInfo.CdmaBaseStationId)) {
                q4 q4Var4 = h6Var.LocationInfo;
                if (q4Var4.LocationProvider != s4.Unknown && q4Var4.IsMocked != 1 && q4Var4.LocationAge < 30000 && ((lVar2 = this.E) == null || !lVar2.a.equals(h6Var.RadioInfo.CdmaBaseStationId))) {
                    String str4 = h6Var.RadioInfo.CdmaBaseStationId;
                    q4 q4Var5 = h6Var.LocationInfo;
                    l lVar5 = new l(str4, q4Var5.LocationLatitude, q4Var5.LocationLongitude);
                    this.E = lVar5;
                    h6Var.CellIdDeltaDistance = 0.0d;
                    a(lVar5);
                }
                str2 = h6Var.RadioInfo.CdmaBaseStationId;
            }
            str = str2;
        }
        q4 q4Var6 = h6Var.LocationInfo;
        if (q4Var6.LocationProvider != s4.Unknown && q4Var6.IsMocked != 1 && !str.isEmpty() && (lVar = this.E) != null && lVar.a.equals(str) && h6Var.CellIdDeltaDistance == -1.0d) {
            l lVar6 = this.E;
            double d2 = lVar6.b;
            double d3 = lVar6.c;
            q4 q4Var7 = h6Var.LocationInfo;
            h6Var.CellIdDeltaDistance = e2.a(d2, d3, q4Var7.LocationLatitude, q4Var7.LocationLongitude);
        }
        if (!str.isEmpty() && !str.equals(this.F.a)) {
            m mVar = this.F;
            h6Var.PrevNirId = mVar.b;
            h6Var.PrevCellId = mVar.a;
            h6Var.PrevLAC = mVar.c;
            h6Var.PrevNetworkType = mVar.d;
            h6Var.PrevMCC = mVar.e;
            h6Var.PrevMNC = mVar.f;
            h6Var.PrevRXLevel = mVar.g;
        }
        m mVar2 = this.F;
        String str5 = h6Var.NirId;
        DRI dri = h6Var.RadioInfo;
        mVar2.a(str5, str, dri.GsmLAC, dri.NetworkType, dri.MCC, dri.MNC, dri.RXLevel);
        if (this.J) {
            InsightCore.getStatsDatabase().a(h6Var);
        }
        return h6Var;
    }

    private static boolean a(String str) {
        return !str.isEmpty() && !str.equals(Integer.toString(Integer.MAX_VALUE));
    }

    private void a(int i2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.q + 10000 <= elapsedRealtime) {
            if (i2 == 1) {
                this.M = rc.OutOfService;
            } else if (i2 == 2) {
                this.M = rc.EmergencyOnly;
            }
            this.o = elapsedRealtime;
            ScheduledFuture<?> scheduledFuture = this.j;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.j = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(this.Q, 0, 1000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void a(TelephonyDisplayInfo telephonyDisplayInfo, o6 o6Var, int i2) {
        NetworkTypes networkTypes;
        NetworkTypes networkTypes2;
        if (InsightCore.getRadioController().c().DefaultDataSimId == i2 && this.u > 0 && Build.VERSION.SDK_INT > 30 && o6Var == o6.Unknown) {
            NetworkTypes e2 = l7.e(telephonyDisplayInfo.getOverrideNetworkType());
            NetworkTypes networkTypes3 = this.C;
            NetworkTypes networkTypes4 = NetworkTypes.NR_NSA;
            if ((networkTypes3 == networkTypes4 || networkTypes3 == (networkTypes = NetworkTypes.NR_NSA_MMWAVE) || networkTypes3 == (networkTypes2 = NetworkTypes.NR_ADVANCED) || e2 == networkTypes4 || e2 == networkTypes || e2 == networkTypes2) && networkTypes3 != e2) {
                g();
            }
            this.C = e2;
        }
    }

    public void a(ServiceState serviceState, j6[] j6VarArr, int i2) {
        if (InsightCore.getRadioController().c().DefaultDataSimId == i2) {
            if (this.p > 0) {
                int state = serviceState.getState();
                if ((state == 1 || state == 2) && this.A == 0) {
                    a(state);
                }
                this.A = state;
            }
            if (this.u > 0) {
                o6 c2 = l7.c(j6VarArr);
                o6 o6Var = this.B;
                o6 o6Var2 = o6.CONNECTED;
                if ((o6Var == o6Var2 || c2 == o6Var2) && o6Var != c2) {
                    g();
                }
                this.B = c2;
            }
        }
    }

    public void a(CellLocation cellLocation, int i2) {
        int i3;
        if (this.t > 0 && InsightCore.getRadioController().c().DefaultDataSimId == i2 && cellLocation != null) {
            if (cellLocation.getClass().equals(GsmCellLocation.class)) {
                i3 = ((GsmCellLocation) cellLocation).getCid();
            } else {
                i3 = cellLocation.getClass().equals(CdmaCellLocation.class) ? ((CdmaCellLocation) cellLocation).getBaseStationId() : -1;
            }
            int i4 = this.D;
            if (i3 != i4 && i4 != -1 && i3 > 0 && i3 != Integer.MAX_VALUE) {
                this.D = i3;
                d();
            } else if (i3 > 0 && i3 < Integer.MAX_VALUE) {
                this.D = i3;
            }
        }
    }

    public void a(String str, boolean z2, int i2) {
        if (this.z > 0 && z2 && InsightCore.getRadioController().c().DefaultDataSimId == i2) {
            h();
        }
    }

    private void a(l lVar) {
        this.a.edit().putString(j0, lVar.a).commit();
        this.a.edit().putLong(h0, Double.doubleToRawLongBits(lVar.b)).commit();
        this.a.edit().putLong(i0, Double.doubleToRawLongBits(lVar.c)).commit();
    }
}
