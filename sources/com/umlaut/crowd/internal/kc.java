package com.umlaut.crowd.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class kc {
    private static final String l = "kc";
    private static final boolean m = false;
    private static final String n = "p3insrpvl";
    private static final String o = "P3INS_PFK_TRAFFICANALYZER_RPVL";
    private static final long p = 1000;
    private static final double q = 3000.0d;
    private static SharedPreferences r;
    /* access modifiers changed from: private */
    public CLC a;
    /* access modifiers changed from: private */
    public j1 b;
    /* access modifiers changed from: private */
    public x c;
    private boolean d = true;
    /* access modifiers changed from: private */
    public Context e;
    private ScheduledFuture<?> f;
    /* access modifiers changed from: private */
    public q7 g;
    /* access modifiers changed from: private */
    public e h;
    /* access modifiers changed from: private */
    public n7 i;
    /* access modifiers changed from: private */
    public boolean j = false;
    private final Runnable k = new d();

    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void run() {
            kc.this.a(this.a);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (!kc.this.j && TrafficStats.getMobileRxBytes() != -1 && TrafficStats.getMobileTxBytes() != -1) {
                e unused = kc.this.h = new e(kc.this, (a) null);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                kc.this.e.registerReceiver(kc.this.h, intentFilter);
                if (CDC.f(kc.this.e) == z8.On) {
                    kc.this.c();
                }
                boolean unused2 = kc.this.j = true;
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (kc.this.j) {
                kc.this.e();
                if (kc.this.h != null) {
                    kc.this.e.unregisterReceiver(kc.this.h);
                }
                boolean unused = kc.this.j = false;
            }
        }
    }

    class d implements Runnable {
        private long a;
        private long b;
        private long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;
        private long i;

        d() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00fe  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0163  */
        /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r62 = this;
                r0 = r62
                long r1 = com.umlaut.crowd.internal.pc.e()
                com.umlaut.crowd.internal.ee r3 = com.umlaut.crowd.InsightCore.getWifiController()
                long r3 = r3.f()
                long r5 = com.umlaut.crowd.internal.pc.b()
                long r7 = com.umlaut.crowd.internal.pc.f()
                com.umlaut.crowd.internal.ee r9 = com.umlaut.crowd.InsightCore.getWifiController()
                long r9 = r9.h()
                long r11 = com.umlaut.crowd.internal.pc.c()
                long r13 = android.os.SystemClock.elapsedRealtime()
                r15 = r11
                long r11 = r0.a
                r17 = 4658815484840378368(0x40a7700000000000, double:3000.0)
                r19 = 4652007308841189376(0x408f400000000000, double:1000.0)
                r21 = 4620693217682128896(0x4020000000000000, double:8.0)
                r23 = 0
                int r25 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
                if (r25 <= 0) goto L_0x007f
                r25 = r5
                long r5 = r0.b
                int r27 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r27 <= 0) goto L_0x0081
                r0.a = r1
                r0.b = r7
                r27 = r9
                long r9 = r0.g
                long r9 = r13 - r9
                double r9 = (double) r9
                r0.g = r13
                int r29 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
                if (r29 > 0) goto L_0x0083
                long r1 = r1 - r11
                long r7 = r7 - r5
                double r5 = (double) r1
                java.lang.Double.isNaN(r5)
                java.lang.Double.isNaN(r9)
                double r5 = r5 / r9
                double r5 = r5 * r21
                double r5 = r5 * r19
                long r5 = java.lang.Math.round(r5)
                double r11 = (double) r7
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r9)
                double r11 = r11 / r9
                double r11 = r11 * r21
                double r11 = r11 * r19
                long r9 = java.lang.Math.round(r11)
                r39 = r1
                r35 = r5
                r41 = r7
                r37 = r9
                goto L_0x008b
            L_0x007f:
                r25 = r5
            L_0x0081:
                r27 = r9
            L_0x0083:
                r35 = r23
                r37 = r35
                r39 = r37
                r41 = r39
            L_0x008b:
                long r1 = r0.c
                int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r5 <= 0) goto L_0x00ea
                long r5 = r0.d
                int r7 = (r27 > r5 ? 1 : (r27 == r5 ? 0 : -1))
                if (r7 <= 0) goto L_0x00ea
                r0.c = r3
                r3 = r27
                r0.d = r3
                com.umlaut.crowd.internal.ee r3 = com.umlaut.crowd.InsightCore.getWifiController()
                com.umlaut.crowd.internal.DWI r3 = r3.getWifiInfo()
                long r7 = r0.h
                long r7 = r13 - r7
                double r7 = (double) r7
                r0.h = r13
                int r4 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
                if (r4 > 0) goto L_0x00f0
                long r9 = r0.c
                long r9 = r9 - r1
                long r1 = r0.d
                long r1 = r1 - r5
                double r4 = (double) r9
                java.lang.Double.isNaN(r4)
                java.lang.Double.isNaN(r7)
                double r4 = r4 / r7
                double r4 = r4 * r21
                double r4 = r4 * r19
                long r4 = java.lang.Math.round(r4)
                double r11 = (double) r1
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r7)
                double r11 = r11 / r7
                double r11 = r11 * r21
                double r11 = r11 * r19
                long r6 = java.lang.Math.round(r11)
                long r11 = r3.WifiLinkSpeedBps
                int r8 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r8 < 0) goto L_0x00f0
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 >= 0) goto L_0x00e1
                goto L_0x00f0
            L_0x00e1:
                r53 = r1
                r31 = r4
                r33 = r6
                r51 = r9
                goto L_0x00f8
            L_0x00ea:
                com.umlaut.crowd.internal.DWI r1 = new com.umlaut.crowd.internal.DWI
                r1.<init>()
                r3 = r1
            L_0x00f0:
                r31 = r23
                r33 = r31
                r51 = r33
                r53 = r51
            L_0x00f8:
                long r1 = r0.e
                int r4 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
                if (r4 <= 0) goto L_0x0143
                long r4 = r0.f
                int r6 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x0143
                r6 = r25
                r0.e = r6
                r8 = r15
                r0.f = r8
                long r10 = r0.i
                long r10 = r13 - r10
                double r10 = (double) r10
                r0.i = r13
                int r12 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
                if (r12 > 0) goto L_0x0143
                long r1 = r6 - r1
                long r4 = r8 - r4
                double r6 = (double) r1
                java.lang.Double.isNaN(r6)
                java.lang.Double.isNaN(r10)
                double r6 = r6 / r10
                double r6 = r6 * r21
                double r6 = r6 * r19
                long r6 = java.lang.Math.round(r6)
                double r8 = (double) r4
                java.lang.Double.isNaN(r8)
                java.lang.Double.isNaN(r10)
                double r8 = r8 / r10
                double r8 = r8 * r21
                double r8 = r8 * r19
                long r8 = java.lang.Math.round(r8)
                r47 = r1
                r49 = r4
                r43 = r6
                r45 = r8
                goto L_0x014b
            L_0x0143:
                r43 = r23
                r45 = r43
                r47 = r45
                r49 = r47
            L_0x014b:
                int r1 = (r35 > r23 ? 1 : (r35 == r23 ? 0 : -1))
                if (r1 > 0) goto L_0x0163
                int r1 = (r31 > r23 ? 1 : (r31 == r23 ? 0 : -1))
                if (r1 > 0) goto L_0x0163
                int r1 = (r43 > r23 ? 1 : (r43 == r23 ? 0 : -1))
                if (r1 > 0) goto L_0x0163
                int r1 = (r37 > r23 ? 1 : (r37 == r23 ? 0 : -1))
                if (r1 > 0) goto L_0x0163
                int r1 = (r33 > r23 ? 1 : (r33 == r23 ? 0 : -1))
                if (r1 > 0) goto L_0x0163
                int r1 = (r45 > r23 ? 1 : (r45 == r23 ? 0 : -1))
                if (r1 <= 0) goto L_0x01c6
            L_0x0163:
                com.umlaut.crowd.IC r1 = com.umlaut.crowd.InsightCore.getInsightConfig()
                boolean r1 = r1.D()
                if (r1 == 0) goto L_0x0173
                com.umlaut.crowd.internal.q4 r1 = new com.umlaut.crowd.internal.q4
                r1.<init>()
                goto L_0x017d
            L_0x0173:
                com.umlaut.crowd.internal.kc r1 = com.umlaut.crowd.internal.kc.this
                com.umlaut.crowd.internal.CLC r1 = r1.a
                com.umlaut.crowd.internal.q4 r1 = r1.getLastLocationInfo()
            L_0x017d:
                r57 = r1
                com.umlaut.crowd.internal.l7 r1 = com.umlaut.crowd.InsightCore.getRadioController()
                com.umlaut.crowd.internal.DRI r1 = r1.getRadioInfoForDefaultDataSim()
                r55 = r1
                com.umlaut.crowd.internal.kc r2 = com.umlaut.crowd.internal.kc.this
                android.content.Context r2 = r2.e
                com.umlaut.crowd.internal.g3 r2 = com.umlaut.crowd.internal.g3.a((android.content.Context) r2)
                com.umlaut.crowd.enums.ConnectionTypes r4 = r1.ConnectionType
                boolean r4 = com.umlaut.crowd.internal.g3.a((com.umlaut.crowd.enums.ConnectionTypes) r4)
                com.umlaut.crowd.internal.e4 r61 = r2.a(r1, r3, r4)
                com.umlaut.crowd.internal.kc r1 = com.umlaut.crowd.internal.kc.this
                com.umlaut.crowd.internal.q7 r29 = r1.g
                com.umlaut.crowd.internal.ub r30 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()
                com.umlaut.crowd.internal.kc r1 = com.umlaut.crowd.internal.kc.this
                com.umlaut.crowd.internal.n7 r58 = r1.i
                com.umlaut.crowd.internal.kc r1 = com.umlaut.crowd.internal.kc.this
                com.umlaut.crowd.internal.x r1 = r1.c
                com.umlaut.crowd.internal.z r59 = r1.a()
                com.umlaut.crowd.internal.kc r1 = com.umlaut.crowd.internal.kc.this
                com.umlaut.crowd.internal.j1 r1 = r1.b
                com.umlaut.crowd.internal.n1 r60 = r1.b()
                r56 = r3
                r29.a(r30, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r56, r57, r58, r59, r60, r61)
            L_0x01c6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.kc.d.run():void");
        }
    }

    private class e extends BroadcastReceiver {

        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public void run() {
                if (this.a.equals("android.intent.action.SCREEN_OFF")) {
                    kc.this.e();
                } else if (this.a.equals("android.intent.action.SCREEN_ON")) {
                    kc kcVar = kc.this;
                    kcVar.b(kcVar.e);
                    kc.this.c();
                }
            }
        }

        private e() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(intent.getAction()));
            }
        }

        /* synthetic */ e(kc kcVar, a aVar) {
            this();
        }
    }

    public kc(Context context) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(context));
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.d) {
            this.d = false;
            this.f = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(this.k, 0, 1000, TimeUnit.MILLISECONDS);
            this.a.startListening(CLC.ProviderMode.Passive);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        this.d = true;
        ScheduledFuture<?> scheduledFuture = this.f;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.a.stopListening();
    }

    public void d() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new c());
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        a2 deviceInfo = CDC.getDeviceInfo(context);
        n7 n7Var = new n7();
        this.i = n7Var;
        n7Var.d = deviceInfo.SimOperatorName;
        n7Var.c = deviceInfo.SimOperator;
        n7Var.a = deviceInfo.OS;
        n7Var.b = deviceInfo.OSVersion;
        n7Var.g = deviceInfo.SimState;
        n7Var.i = deviceInfo.PowerSaveMode;
        n7Var.e = deviceInfo.DeviceManufacturer;
        n7Var.f = deviceInfo.DeviceName;
        n7Var.h = deviceInfo.TAC;
        o9 defaultDataSimInfo = deviceInfo.MultiSimInfo.getDefaultDataSimInfo();
        n7 n7Var2 = this.i;
        n7Var2.j = defaultDataSimInfo.CarrierName;
        n7Var2.k = defaultDataSimInfo.DataRoaming;
        n7Var2.l = defaultDataSimInfo.Mcc;
        n7Var2.m = defaultDataSimInfo.Mnc;
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        this.e = context;
        r = context.getSharedPreferences(n, 0);
        b(this.e);
        String a2 = a();
        if (a2.length() > 0) {
            q7 a3 = q7.a(a2);
            this.g = a3;
            if (a3 == null) {
                this.g = new q7();
            }
        } else {
            this.g = new q7();
        }
        this.a = new CLC(context);
        this.b = new j1();
        this.c = new x(context);
    }

    public void b() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b());
    }

    private String a() {
        return r.getString(o, "");
    }

    static void a(String str) {
        SharedPreferences sharedPreferences = r;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(o, str).commit();
        }
    }
}
