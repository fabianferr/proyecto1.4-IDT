package com.umlaut.crowd.internal;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.TrafficStats;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.database.metrics.SignalStrengthLocationShare;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.o0;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.AppUsageUtils;
import com.umlaut.crowd.utils.PermissionUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class n {
    private static final boolean X = false;
    private static final boolean Y = false;
    private static final long Z = 1000;
    private static final long a0 = 30000;
    private static final long b0 = 2000;
    /* access modifiers changed from: private */
    public static final String c0 = "n";
    private o0 A;
    private o0 B;
    private f C;
    /* access modifiers changed from: private */
    public yd D;
    /* access modifiers changed from: private */
    public long E;
    /* access modifiers changed from: private */
    public long F;
    /* access modifiers changed from: private */
    public j1 G;
    /* access modifiers changed from: private */
    public long H;
    /* access modifiers changed from: private */
    public boolean I;
    /* access modifiers changed from: private */
    public long J;
    /* access modifiers changed from: private */
    public boolean K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    /* access modifiers changed from: private */
    public k9 R;
    /* access modifiers changed from: private */
    public k9 S;
    /* access modifiers changed from: private */
    public ArrayList<SignalStrengthLocationShare> T;
    private NetworkStatsManager U;
    /* access modifiers changed from: private */
    public ArrayList<o> V;
    private Runnable W;
    /* access modifiers changed from: private */
    public r3 a = null;
    /* access modifiers changed from: private */
    public x b;
    /* access modifiers changed from: private */
    public boolean c;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> d;
    /* access modifiers changed from: private */
    public String e = "";
    /* access modifiers changed from: private */
    public p f;
    public long g;
    /* access modifiers changed from: private */
    public long h;
    /* access modifiers changed from: private */
    public long i;
    /* access modifiers changed from: private */
    public CLC j;
    /* access modifiers changed from: private */
    public Context k;
    /* access modifiers changed from: private */
    public long l;
    /* access modifiers changed from: private */
    public long m;
    /* access modifiers changed from: private */
    public long n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public ArrayList<c5> q;
    /* access modifiers changed from: private */
    public g r;
    /* access modifiers changed from: private */
    public String s;
    /* access modifiers changed from: private */
    public IS t;
    /* access modifiers changed from: private */
    public long u;
    /* access modifiers changed from: private */
    public long v;
    /* access modifiers changed from: private */
    public long w;
    /* access modifiers changed from: private */
    public long x;
    /* access modifiers changed from: private */
    public long y;
    /* access modifiers changed from: private */
    public long z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (CDC.f(n.this.k) == z8.On) {
                n nVar = n.this;
                nVar.g = nVar.t.t() + 1;
                n.this.t.c(n.this.g);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (n.this.b()) {
                g unused = n.this.r = new g(n.this, (a) null);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                n.this.k.registerReceiver(n.this.r, intentFilter);
                n.this.e();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (n.this.r != null) {
                try {
                    n.this.k.unregisterReceiver(n.this.r);
                } catch (Exception e) {
                    String a2 = n.c0;
                    Log.e(a2, "stopListening: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            n.this.g();
        }
    }

    class d implements Runnable {
        d() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x0526  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x054c  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x05be  */
        /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0391  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0394  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x04de  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x04ed  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r29 = this;
                r1 = r29
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                boolean r0 = r0.c
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                com.umlaut.crowd.internal.ub r0 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()
                com.umlaut.crowd.internal.n r2 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.r3 r2 = r2.a
                com.umlaut.crowd.internal.v8 r2 = r2.b()
                if (r2 == 0) goto L_0x05aa
                java.lang.String r3 = r2.a
                com.umlaut.crowd.internal.n r4 = com.umlaut.crowd.internal.n.this
                java.lang.String r4 = r4.e
                boolean r3 = r3.equals(r4)
                r4 = 4
                r5 = 3
                r7 = 5
                r8 = 2
                r9 = 7200000(0x6ddd00, double:3.5572727E-317)
                r11 = 0
                r12 = 1
                if (r3 != 0) goto L_0x0213
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                r3.a((com.umlaut.crowd.internal.ub) r0)     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                r3.b((com.umlaut.crowd.internal.ub) r0)     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01f8 }
                long r13 = r13 - r9
                long unused = r3.J = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r13 = r2.a     // Catch:{ Exception -> 0x01f8 }
                java.lang.String unused = r3.e = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.h = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r13 = r3.h     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.i = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r13 = new com.umlaut.crowd.internal.p     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r14 = r3.s     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r15 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.IS r15 = r15.t     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r15 = r15.q()     // Catch:{ Exception -> 0x01f8 }
                r13.<init>(r14, r15)     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p unused = r3.f = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.ee r13 = com.umlaut.crowd.InsightCore.getWifiController()     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.DWI r13 = r13.getWifiInfo()     // Catch:{ Exception -> 0x01f8 }
                r3.WifiInfoOnStart = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.l7 r13 = com.umlaut.crowd.InsightCore.getRadioController()     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.DRI r13 = r13.getRadioInfoForDefaultDataSim()     // Catch:{ Exception -> 0x01f8 }
                r3.RadioInfoOnStart = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r13 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                android.content.Context r13 = r13.k     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.g3 r13 = com.umlaut.crowd.internal.g3.a((android.content.Context) r13)     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r14 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r14 = r14.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.DRI r14 = r14.RadioInfoOnStart     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r15 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r15 = r15.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.DWI r15 = r15.WifiInfoOnStart     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r6 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r6 = r6.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.DRI r6 = r6.RadioInfoOnStart     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.enums.ConnectionTypes r6 = r6.ConnectionType     // Catch:{ Exception -> 0x01f8 }
                boolean r6 = com.umlaut.crowd.internal.g3.a((com.umlaut.crowd.enums.ConnectionTypes) r6)     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.e4 r6 = r13.a(r14, r15, r6)     // Catch:{ Exception -> 0x01f8 }
                r3.IspInfoOnStart = r6     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r6 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.r3 r6 = r6.a     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.c3 r6 = r6.c()     // Catch:{ Exception -> 0x01f8 }
                r3.ForegroundDetectionMode = r6     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r6 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r13 = r6.g     // Catch:{ Exception -> 0x01f8 }
                r3.ScreenSession = r13     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r6.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r6 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r6 = r6.e     // Catch:{ Exception -> 0x01f8 }
                r3.PackageName = r6     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r6 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.x r6 = r6.b     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.z r6 = r6.a()     // Catch:{ Exception -> 0x01f8 }
                r3.BatteryInfoOnStart = r6     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                r3.TimeInfoOnStart = r0     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r0 = r0.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.ub r3 = r3.TimeInfoOnStart     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r3 = r3.TimestampTableau     // Catch:{ Exception -> 0x01f8 }
                r0.TimestampOnStart = r3     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r0 = r0.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.ub r3 = r3.TimeInfoOnStart     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r6 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r6 = r6.f     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r6 = r6.GUID     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r3 = com.umlaut.crowd.internal.k3.a((com.umlaut.crowd.internal.ub) r3, (java.lang.String) r6)     // Catch:{ Exception -> 0x01f8 }
                r0.AusId = r3     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r0 = r0.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.CLC r3 = r3.j     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.q4 r3 = r3.getLastLocationInfo()     // Catch:{ Exception -> 0x01f8 }
                r0.LocationInfoOnStart = r3     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                int r3 = r2.b     // Catch:{ Exception -> 0x01f8 }
                long r18 = r0.J     // Catch:{ Exception -> 0x01f8 }
                long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01f8 }
                long r20 = r13 + r9
                r16 = r0
                r17 = r3
                long[] r0 = r16.a(r17, r18, r20)     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                r9 = r0[r11]     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.l = r9     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                r9 = r0[r12]     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.m = r9     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r9 = r3.l     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.n = r9     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r9 = r3.m     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.o = r9     // Catch:{ Exception -> 0x01f8 }
                r8 = r0[r8]     // Catch:{ Exception -> 0x01f8 }
                r5 = r0[r5]     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                r10 = r0[r4]     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.w = r10     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                r10 = r0[r7]     // Catch:{ Exception -> 0x01f8 }
                long unused = r3.x = r10     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r3 = r0.w     // Catch:{ Exception -> 0x01f8 }
                long unused = r0.y = r3     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r3 = r0.x     // Catch:{ Exception -> 0x01f8 }
                long unused = r0.z = r3     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r3 = r0.l     // Catch:{ Exception -> 0x01f8 }
                long r8 = r8 - r3
                long unused = r0.u = r8     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                long r3 = r0.m     // Catch:{ Exception -> 0x01f8 }
                long r5 = r5 - r3
                long unused = r0.v = r5     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r0 = r0.f     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                java.lang.String r4 = r3.e     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.i r3 = r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x01f8 }
                r0.AppCategory = r3     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                int r2 = r2.b     // Catch:{ Exception -> 0x01f8 }
                int unused = r0.p = r2     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                java.util.ArrayList r0 = r0.V     // Catch:{ Exception -> 0x01f8 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01f8 }
            L_0x01e0:
                boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x01f8 }
                if (r2 == 0) goto L_0x05aa
                java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.o r2 = (com.umlaut.crowd.internal.o) r2     // Catch:{ Exception -> 0x01f8 }
                if (r2 == 0) goto L_0x01e0
                com.umlaut.crowd.internal.n r3 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x01f8 }
                com.umlaut.crowd.internal.p r3 = r3.f     // Catch:{ Exception -> 0x01f8 }
                r2.b(r3)     // Catch:{ Exception -> 0x01f8 }
                goto L_0x01e0
            L_0x01f8:
                r0 = move-exception
                java.lang.String r2 = com.umlaut.crowd.internal.n.c0
                java.lang.String r0 = r0.getMessage()
                android.util.Log.e(r2, r0)
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                java.lang.String r2 = ""
                java.lang.String unused = r0.e = r2
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                r2 = 0
                com.umlaut.crowd.internal.p unused = r0.f = r2
                goto L_0x05aa
            L_0x0213:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                int r3 = r2.b
                long r18 = r0.J
                long r13 = java.lang.System.currentTimeMillis()
                long r20 = r13 + r9
                r16 = r0
                r17 = r3
                long[] r0 = r16.a(r17, r18, r20)
                r9 = r0[r11]
                r13 = r0[r12]
                r16 = r0[r8]
                r5 = r0[r5]
                r3 = r0[r4]
                r11 = r0[r7]
                r19 = 0
                int r0 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
                if (r0 < 0) goto L_0x023e
                r21 = r9
                goto L_0x0240
            L_0x023e:
                r21 = r19
            L_0x0240:
                long r7 = r16 - r21
                int r0 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
                if (r0 < 0) goto L_0x0248
                r19 = r13
            L_0x0248:
                long r5 = r5 - r19
                r16 = r11
                long r11 = android.os.SystemClock.elapsedRealtime()
                com.umlaut.crowd.internal.c5 r15 = new com.umlaut.crowd.internal.c5
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                java.lang.String r0 = r0.s
                r20 = r2
                com.umlaut.crowd.internal.n r2 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.IS r2 = r2.t
                java.lang.String r2 = r2.q()
                r15.<init>(r0, r2)
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long r21 = android.os.SystemClock.elapsedRealtime()
                com.umlaut.crowd.internal.n r2 = com.umlaut.crowd.internal.n.this
                long r23 = r2.h
                r25 = r3
                long r2 = r21 - r23
                long unused = r0.F = r2
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long r2 = r0.F
                r15.Delta = r2
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long r2 = r0.i
                long r2 = r11 - r2
                double r2 = (double) r2
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x0339 }
                long r21 = r0.n     // Catch:{ Exception -> 0x0339 }
                r23 = r11
                long r11 = r9 - r21
                double r11 = (double) r11
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r2)
                double r11 = r11 / r2
                r21 = 4620693217682128896(0x4020000000000000, double:8.0)
                double r11 = r11 * r21
                r27 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r11 = r11 * r27
                long r11 = java.lang.Math.round(r11)     // Catch:{ Exception -> 0x0337 }
                int r0 = (int) r11     // Catch:{ Exception -> 0x0337 }
                r15.ThroughputRateRx = r0     // Catch:{ Exception -> 0x0337 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x0337 }
                long r11 = r0.o     // Catch:{ Exception -> 0x0337 }
                long r11 = r13 - r11
                double r11 = (double) r11
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r2)
                double r11 = r11 / r2
                double r11 = r11 * r21
                double r11 = r11 * r27
                long r11 = java.lang.Math.round(r11)     // Catch:{ Exception -> 0x0337 }
                int r0 = (int) r11     // Catch:{ Exception -> 0x0337 }
                r15.ThroughputRateTx = r0     // Catch:{ Exception -> 0x0337 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x0337 }
                long r11 = r0.u     // Catch:{ Exception -> 0x0337 }
                long r11 = r7 - r11
                double r11 = (double) r11
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r2)
                double r11 = r11 / r2
                double r11 = r11 * r21
                double r11 = r11 * r27
                long r11 = java.lang.Math.round(r11)     // Catch:{ Exception -> 0x0337 }
                int r0 = (int) r11     // Catch:{ Exception -> 0x0337 }
                r15.ThroughputRateRxBackground = r0     // Catch:{ Exception -> 0x0337 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x0337 }
                long r11 = r0.v     // Catch:{ Exception -> 0x0337 }
                long r11 = r5 - r11
                double r11 = (double) r11
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r2)
                double r11 = r11 / r2
                double r11 = r11 * r21
                double r11 = r11 * r27
                long r11 = java.lang.Math.round(r11)     // Catch:{ Exception -> 0x0337 }
                int r0 = (int) r11     // Catch:{ Exception -> 0x0337 }
                r15.ThroughputRateTxBackground = r0     // Catch:{ Exception -> 0x0337 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x0337 }
                long r11 = r0.y     // Catch:{ Exception -> 0x0337 }
                long r11 = r25 - r11
                double r11 = (double) r11
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r2)
                double r11 = r11 / r2
                double r11 = r11 * r21
                double r11 = r11 * r27
                long r11 = java.lang.Math.round(r11)     // Catch:{ Exception -> 0x0337 }
                int r0 = (int) r11     // Catch:{ Exception -> 0x0337 }
                r15.ThroughputRateRxOverall = r0     // Catch:{ Exception -> 0x0337 }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ Exception -> 0x0337 }
                long r11 = r0.z     // Catch:{ Exception -> 0x0337 }
                long r11 = r16 - r11
                double r11 = (double) r11
                java.lang.Double.isNaN(r11)
                java.lang.Double.isNaN(r2)
                double r11 = r11 / r2
                double r11 = r11 * r21
                double r11 = r11 * r27
                long r2 = java.lang.Math.round(r11)     // Catch:{ Exception -> 0x0337 }
                int r0 = (int) r2     // Catch:{ Exception -> 0x0337 }
                r15.ThroughputRateTxOverall = r0     // Catch:{ Exception -> 0x0337 }
                goto L_0x0355
            L_0x0337:
                r0 = move-exception
                goto L_0x033c
            L_0x0339:
                r0 = move-exception
                r23 = r11
            L_0x033c:
                java.lang.String r2 = com.umlaut.crowd.internal.n.c0
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "calcThroughput: "
                r3.<init>(r4)
                java.lang.String r0 = r0.getMessage()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                android.util.Log.e(r2, r0)
            L_0x0355:
                long r2 = android.os.SystemClock.elapsedRealtime()
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long r11 = r0.H
                long r2 = r2 - r11
                int r0 = android.os.Build.VERSION.SDK_INT
                r4 = 28
                if (r0 < r4) goto L_0x037a
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.p r0 = r0.f
                com.umlaut.crowd.internal.c3 r0 = r0.ForegroundDetectionMode
                com.umlaut.crowd.internal.c3 r4 = com.umlaut.crowd.internal.c3.Lollipop
                if (r0 != r4) goto L_0x037a
                int r0 = r15.ThroughputRateRxOverall
                if (r0 > 0) goto L_0x0394
                int r0 = r15.ThroughputRateTxOverall
                if (r0 > 0) goto L_0x0394
            L_0x037a:
                int r0 = r15.ThroughputRateRx
                if (r0 > 0) goto L_0x0394
                int r0 = r15.ThroughputRateTx
                if (r0 > 0) goto L_0x0394
                r11 = 30000(0x7530, double:1.4822E-319)
                int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r0 >= 0) goto L_0x0394
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                boolean r0 = r0.I
                if (r0 == 0) goto L_0x0391
                goto L_0x0394
            L_0x0391:
                r2 = 0
                goto L_0x049b
            L_0x0394:
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.InsightCore.getRadioController()
                com.umlaut.crowd.internal.DRI r2 = r0.getRadioInfoForDefaultDataSim()
                com.umlaut.crowd.enums.NetworkTypes r0 = r2.DisplayNetworkType
                r15.DisplayNetworkType = r0
                com.umlaut.crowd.enums.ConnectionTypes r0 = r2.ConnectionType
                r15.ConnectionType = r0
                com.umlaut.crowd.enums.NetworkTypes r0 = r2.NetworkType
                r15.NetworkType = r0
                com.umlaut.crowd.internal.tb r0 = r2.NrAvailable
                r15.NrAvailable = r0
                com.umlaut.crowd.internal.o6 r0 = r2.NrState
                r15.NrState = r0
                int r0 = r2.RXLevel
                r15.RxLevel = r0
                java.lang.String r0 = r2.MCC
                r15.MCC = r0
                java.lang.String r0 = r2.MNC
                r15.MNC = r0
                java.lang.String r0 = r2.GsmCellId
                r15.GsmCellId = r0
                java.lang.String r0 = r2.GsmLAC
                r15.GsmLAC = r0
                com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.InsightCore.getRadioController()
                int r3 = r2.SubscriptionId
                com.umlaut.crowd.enums.NetworkTypes r0 = r0.j((int) r3)
                r15.VoiceNetworkType = r0
                r3 = r20
                int r0 = r3.b
                int[] r0 = com.umlaut.crowd.internal.d1.a(r0)
                int r3 = r3.b
                int[] r3 = com.umlaut.crowd.internal.d1.b(r3)
                if (r0 == 0) goto L_0x03f3
                if (r3 == 0) goto L_0x03f3
                r4 = 0
                r11 = r0[r4]
                r12 = r3[r4]
                int r11 = r11 + r12
                r15.IPv4 = r11
                r11 = 1
                r0 = r0[r11]
                r3 = r3[r11]
                int r0 = r0 + r3
                r15.IPv6 = r0
                goto L_0x03f4
            L_0x03f3:
                r4 = 0
            L_0x03f4:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.CLC r0 = r0.j
                com.umlaut.crowd.internal.q4 r0 = r0.getLastLocationInfo()
                r15.LocationInfo = r0
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.j1 r0 = r0.G
                com.umlaut.crowd.internal.n1 r0 = r0.b()
                r15.CpuLoadInfo = r0
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.x r0 = r0.b
                com.umlaut.crowd.internal.z r0 = r0.a()
                r15.BatteryInfo = r0
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.p r0 = r0.f
                if (r0 == 0) goto L_0x049b
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.p r0 = r0.f     // Catch:{ NullPointerException -> 0x048f }
                java.lang.String r0 = r0.AusId     // Catch:{ NullPointerException -> 0x048f }
                r15.FkAusId = r0     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.p r0 = r0.f     // Catch:{ NullPointerException -> 0x048f }
                r0.a(r15)     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ NullPointerException -> 0x048f }
                long unused = r0.H = r11     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.IC r0 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ NullPointerException -> 0x048f }
                boolean r0 = r0.y()     // Catch:{ NullPointerException -> 0x048f }
                if (r0 == 0) goto L_0x044d
                com.umlaut.crowd.internal.q4 r0 = new com.umlaut.crowd.internal.q4     // Catch:{ NullPointerException -> 0x048f }
                r0.<init>()     // Catch:{ NullPointerException -> 0x048f }
                r15.LocationInfo = r0     // Catch:{ NullPointerException -> 0x048f }
            L_0x044d:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                java.util.ArrayList r0 = r0.q     // Catch:{ NullPointerException -> 0x048f }
                r0.add(r15)     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                java.util.ArrayList r0 = r0.q     // Catch:{ NullPointerException -> 0x048f }
                int r0 = r0.size()     // Catch:{ NullPointerException -> 0x048f }
                r3 = 5
                if (r0 != r3) goto L_0x048d
                com.umlaut.crowd.internal.u1 r0 = com.umlaut.crowd.InsightCore.getDatabaseHelper()     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.w2 r3 = com.umlaut.crowd.internal.w2.MPA     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.n r11 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                java.util.ArrayList r11 = r11.q     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.n r12 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                java.util.ArrayList r12 = r12.q     // Catch:{ NullPointerException -> 0x048f }
                int r12 = r12.size()     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.c5[] r12 = new com.umlaut.crowd.internal.c5[r12]     // Catch:{ NullPointerException -> 0x048f }
                java.lang.Object[] r11 = r11.toArray(r12)     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.RBR[] r11 = (com.umlaut.crowd.internal.RBR[]) r11     // Catch:{ NullPointerException -> 0x048f }
                r0.a((com.umlaut.crowd.internal.w2) r3, (com.umlaut.crowd.internal.RBR[]) r11)     // Catch:{ NullPointerException -> 0x048f }
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this     // Catch:{ NullPointerException -> 0x048f }
                java.util.ArrayList r0 = r0.q     // Catch:{ NullPointerException -> 0x048f }
                r0.clear()     // Catch:{ NullPointerException -> 0x048f }
            L_0x048d:
                r11 = 1
                goto L_0x049c
            L_0x048f:
                r0 = move-exception
                java.lang.String r3 = com.umlaut.crowd.internal.n.c0
                java.lang.String r0 = r0.getMessage()
                android.util.Log.e(r3, r0)
            L_0x049b:
                r11 = 0
            L_0x049c:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                r3 = r23
                long unused = r0.i = r3
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long unused = r0.n = r9
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long unused = r0.o = r13
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long unused = r0.u = r7
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                long unused = r0.v = r5
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                r3 = r25
                long unused = r0.y = r3
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                r3 = r16
                long unused = r0.z = r3
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                boolean r0 = r0.K
                if (r0 == 0) goto L_0x05aa
                if (r11 == 0) goto L_0x05aa
                if (r2 == 0) goto L_0x05aa
                int[] r0 = com.umlaut.crowd.internal.n.e.b
                com.umlaut.crowd.enums.ConnectionTypes r3 = r15.ConnectionType
                int r3 = r3.ordinal()
                r0 = r0[r3]
                r3 = 1
                if (r0 == r3) goto L_0x04ed
                r3 = 2
                if (r0 == r3) goto L_0x04e7
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.n.J(r0)
                goto L_0x0520
            L_0x04e7:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.n.I(r0)
                goto L_0x0520
            L_0x04ed:
                com.umlaut.crowd.enums.NetworkTypes r0 = r15.NetworkType
                com.umlaut.crowd.internal.o6 r3 = r15.NrState
                com.umlaut.crowd.enums.NetworkTypes r4 = r15.DisplayNetworkType
                com.umlaut.crowd.enums.NetworkGenerations r0 = com.umlaut.crowd.internal.l7.a((com.umlaut.crowd.enums.NetworkTypes) r0, (com.umlaut.crowd.internal.o6) r3, (com.umlaut.crowd.enums.NetworkTypes) r4)
                int[] r3 = com.umlaut.crowd.internal.n.e.a
                int r0 = r0.ordinal()
                r0 = r3[r0]
                switch(r0) {
                    case 1: goto L_0x051b;
                    case 2: goto L_0x0515;
                    case 3: goto L_0x050f;
                    case 4: goto L_0x0509;
                    case 5: goto L_0x0509;
                    case 6: goto L_0x0503;
                    default: goto L_0x0502;
                }
            L_0x0502:
                goto L_0x0520
            L_0x0503:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.n.I(r0)
                goto L_0x0520
            L_0x0509:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.n.H(r0)
                goto L_0x0520
            L_0x050f:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.n.G(r0)
                goto L_0x0520
            L_0x0515:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.n.F(r0)
                goto L_0x0520
            L_0x051b:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.n.E(r0)
            L_0x0520:
                com.umlaut.crowd.enums.ConnectionTypes r0 = r15.ConnectionType
                com.umlaut.crowd.enums.ConnectionTypes r3 = com.umlaut.crowd.enums.ConnectionTypes.Mobile
                if (r0 != r3) goto L_0x054c
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.k9 r0 = r0.R
                com.umlaut.crowd.internal.l9 r4 = com.umlaut.crowd.internal.l7.b((com.umlaut.crowd.internal.DRI) r2)
                r0.addMeasurement(r4)
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                java.util.ArrayList r0 = r0.T
                com.umlaut.crowd.internal.n r4 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.CLC r4 = r4.j
                com.umlaut.crowd.internal.q4 r4 = r4.getLastLocationInfo()
                r5 = 0
                com.umlaut.crowd.database.metrics.SignalStrengthLocationShare r2 = com.umlaut.crowd.database.metrics.SignalStrengthLocationShare.a(r3, r4, r2, r5)
                r0.add(r2)
                goto L_0x05aa
            L_0x054c:
                com.umlaut.crowd.enums.ConnectionTypes r4 = com.umlaut.crowd.enums.ConnectionTypes.WiFi
                if (r0 != r4) goto L_0x05aa
                com.umlaut.crowd.internal.ee r0 = com.umlaut.crowd.InsightCore.getWifiController()
                com.umlaut.crowd.internal.DWI r0 = r0.getWifiInfo()
                com.umlaut.crowd.internal.n r5 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.k9 r5 = r5.S
                com.umlaut.crowd.internal.l9 r6 = com.umlaut.crowd.internal.ee.a((com.umlaut.crowd.internal.DWI) r0)
                r5.addMeasurement(r6)
                com.umlaut.crowd.internal.n r5 = com.umlaut.crowd.internal.n.this
                java.util.ArrayList r5 = r5.T
                com.umlaut.crowd.internal.n r6 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.CLC r6 = r6.j
                com.umlaut.crowd.internal.q4 r6 = r6.getLastLocationInfo()
                com.umlaut.crowd.database.metrics.SignalStrengthLocationShare r4 = com.umlaut.crowd.database.metrics.SignalStrengthLocationShare.a(r4, r6, r2, r0)
                r5.add(r4)
                int r4 = r2.RXLevel
                if (r4 == 0) goto L_0x05aa
                com.umlaut.crowd.enums.NetworkTypes r4 = r2.NetworkType
                com.umlaut.crowd.enums.NetworkTypes r5 = com.umlaut.crowd.enums.NetworkTypes.Unknown
                if (r4 == r5) goto L_0x05aa
                com.umlaut.crowd.internal.n r4 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.k9 r4 = r4.R
                com.umlaut.crowd.internal.l9 r5 = com.umlaut.crowd.internal.l7.b((com.umlaut.crowd.internal.DRI) r2)
                r4.addMeasurement(r5)
                com.umlaut.crowd.internal.n r4 = com.umlaut.crowd.internal.n.this
                java.util.ArrayList r4 = r4.T
                com.umlaut.crowd.internal.n r5 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.internal.CLC r5 = r5.j
                com.umlaut.crowd.internal.q4 r5 = r5.getLastLocationInfo()
                com.umlaut.crowd.database.metrics.SignalStrengthLocationShare r0 = com.umlaut.crowd.database.metrics.SignalStrengthLocationShare.a(r3, r5, r2, r0)
                r4.add(r0)
            L_0x05aa:
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                boolean r0 = r0.c
                if (r0 != 0) goto L_0x05d3
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                java.util.concurrent.ScheduledFuture r0 = r0.d
                boolean r0 = r0.isCancelled()
                if (r0 != 0) goto L_0x05d3
                com.umlaut.crowd.internal.n r0 = com.umlaut.crowd.internal.n.this
                com.umlaut.crowd.threads.ThreadManager r2 = com.umlaut.crowd.threads.ThreadManager.getInstance()
                java.util.concurrent.ScheduledExecutorService r2 = r2.getSingleThreadScheduledExecutor()
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
                r4 = 1000(0x3e8, double:4.94E-321)
                java.util.concurrent.ScheduledFuture r2 = r2.schedule(r1, r4, r3)
                java.util.concurrent.ScheduledFuture unused = r0.d = r2
            L_0x05d3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.n.d.run():void");
        }
    }

    static /* synthetic */ class e {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        static {
            /*
                com.umlaut.crowd.enums.ConnectionTypes[] r0 = com.umlaut.crowd.enums.ConnectionTypes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.umlaut.crowd.enums.ConnectionTypes r2 = com.umlaut.crowd.enums.ConnectionTypes.Mobile     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.enums.ConnectionTypes r3 = com.umlaut.crowd.enums.ConnectionTypes.Unknown     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.umlaut.crowd.enums.NetworkGenerations[] r2 = com.umlaut.crowd.enums.NetworkGenerations.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                a = r2
                com.umlaut.crowd.enums.NetworkGenerations r3 = com.umlaut.crowd.enums.NetworkGenerations.Gen2     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.umlaut.crowd.enums.NetworkGenerations r2 = com.umlaut.crowd.enums.NetworkGenerations.Gen3     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen4     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5NSA     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Unknown     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.n.e.<clinit>():void");
        }
    }

    private class f implements o0.b {
        private f() {
        }

        public void a(boolean z, Date date, String str, String str2, int i) {
            if (n.this.f != null) {
                ub timeInfo = TimeServer.getTimeInfo();
                if (n.this.D != null) {
                    n.this.b(timeInfo);
                }
                n nVar = n.this;
                yd unused = nVar.D = new yd(nVar.s, n.this.t.q());
                long unused2 = n.this.E = SystemClock.elapsedRealtime();
                n.this.D.TimeInfoOnStart = timeInfo;
                n.this.D.WebId = k3.a(n.this.D.TimeInfoOnStart, n.this.D.GUID);
                n.this.D.FkAusDelta = n.this.F;
                n.this.D.Bookmarked = z;
                n.this.D.FkAusId = n.this.f.AusId;
                n.this.D.Url = str2;
                n.this.D.Visits = i;
            }
        }

        /* synthetic */ f(n nVar, a aVar) {
            this();
        }
    }

    private class g extends BroadcastReceiver {

        class a implements Runnable {
            a() {
            }

            public void run() {
                n.this.a(TimeServer.getTimeInfo());
            }
        }

        private g() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                    if (!n.this.c) {
                        n.this.g();
                        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
                    }
                } else if (intent.getAction().equals("android.intent.action.SCREEN_ON") && n.this.c) {
                    n nVar = n.this;
                    nVar.g = nVar.t.t() + 1;
                    n.this.t.c(n.this.g);
                    n.this.a.d();
                    n.this.e();
                }
            }
        }

        /* synthetic */ g(n nVar, a aVar) {
            this();
        }
    }

    public n(Context context) {
        boolean z2 = false;
        this.K = false;
        this.W = new d();
        this.j = new CLC(context);
        this.k = context;
        this.G = new j1();
        this.b = new x(context);
        IC insightConfig = InsightCore.getInsightConfig();
        this.s = insightConfig.f1();
        this.I = insightConfig.e();
        this.R = new k9();
        this.S = new k9();
        this.T = new ArrayList<>();
        this.q = new ArrayList<>();
        this.V = new ArrayList<>();
        if (insightConfig.m1() && !insightConfig.t1()) {
            z2 = true;
        }
        this.K = z2;
        if (z2) {
            c();
        }
        IS is = new IS(this.k);
        this.t = is;
        if (is.c() && b()) {
            this.C = new f(this, (a) null);
            try {
                o0 o0Var = new o0(context, o0.c.AndroidStock);
                this.A = o0Var;
                o0Var.a(this.C);
                context.getContentResolver().registerContentObserver(this.A.a(), true, this.A);
            } catch (Exception e2) {
                String str = c0;
                Log.d(str, "registerContentObserver: " + e2.getMessage());
            }
            try {
                o0 o0Var2 = new o0(context, o0.c.GoogleChrome);
                this.B = o0Var2;
                o0Var2.a(this.C);
                context.getContentResolver().registerContentObserver(this.B.a(), true, this.B);
            } catch (Exception e3) {
                String str2 = c0;
                Log.d(str2, "registerContentObserver: " + e3.getMessage());
            }
        }
        d();
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
    }

    static /* synthetic */ int E(n nVar) {
        int i2 = nVar.L;
        nVar.L = i2 + 1;
        return i2;
    }

    static /* synthetic */ int F(n nVar) {
        int i2 = nVar.M;
        nVar.M = i2 + 1;
        return i2;
    }

    static /* synthetic */ int G(n nVar) {
        int i2 = nVar.N;
        nVar.N = i2 + 1;
        return i2;
    }

    static /* synthetic */ int H(n nVar) {
        int i2 = nVar.O;
        nVar.O = i2 + 1;
        return i2;
    }

    static /* synthetic */ int I(n nVar) {
        int i2 = nVar.Q;
        nVar.Q = i2 + 1;
        return i2;
    }

    static /* synthetic */ int J(n nVar) {
        int i2 = nVar.P;
        nVar.P = i2 + 1;
        return i2;
    }

    private void c() {
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R.reset();
        this.S.reset();
        this.T.clear();
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f = null;
        if (CDC.f(this.k) != z8.On) {
            this.c = true;
        } else if (!InsightCore.getInsightConfig().f() || this.a.c() != c3.Linux) {
            this.c = false;
            this.d = ThreadManager.getInstance().getSingleThreadScheduledExecutor().schedule(this.W, 1000, TimeUnit.MILLISECONDS);
            this.j.startListening(CLC.ProviderMode.Passive);
        } else {
            this.c = true;
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        this.c = true;
        ScheduledFuture<?> scheduledFuture = this.d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.e = "";
        this.j.stopListening();
    }

    public void d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            this.a = new z2(this.k);
            return;
        }
        b3 b3Var = new b3(this.k);
        this.a = b3Var;
        if (!b3Var.a()) {
            this.a = new a3();
        } else if (i2 >= 23) {
            this.U = (NetworkStatsManager) this.k.getSystemService(NetworkStatsManager.class);
        }
    }

    public void f() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b());
    }

    public void h() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new c());
    }

    public void b(o oVar) {
        this.V.remove(oVar);
    }

    /* access modifiers changed from: private */
    public boolean b() {
        return (TrafficStats.getTotalRxBytes() == -1 || TrafficStats.getTotalTxBytes() == -1) ? false : true;
    }

    /* access modifiers changed from: private */
    public void b(ub ubVar) {
        yd ydVar = this.D;
        if (ydVar != null) {
            ydVar.TimeInfoOnEnd = ubVar;
            ydVar.Duration = SystemClock.elapsedRealtime() - this.E;
            InsightCore.getDatabaseHelper().a(w2.WEB, (RBR) this.D);
            this.D = null;
        }
    }

    public void a(o oVar) {
        this.V.add(oVar);
    }

    /* access modifiers changed from: private */
    public i a(String str) {
        Context context = this.k;
        if (context != null && Build.VERSION.SDK_INT >= 26) {
            try {
                return AppUsageUtils.getAppCategory(context.getPackageManager().getApplicationInfo(str, 0).category);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return i.Unknown;
    }

    /* access modifiers changed from: private */
    public void a(ub ubVar) {
        p pVar = this.f;
        if (pVar != null) {
            pVar.AppUsageTime = SystemClock.elapsedRealtime() - this.h;
            if (this.f.AppUsageTime > 2000) {
                if (this.q.size() > 0) {
                    u1 databaseHelper = InsightCore.getDatabaseHelper();
                    w2 w2Var = w2.MPA;
                    ArrayList<c5> arrayList = this.q;
                    databaseHelper.a(w2Var, (RBR[]) arrayList.toArray(new c5[arrayList.size()]));
                }
                this.f.LocationInfoOnEnd = this.j.getLastLocationInfo();
                this.f.RadioInfoOnEnd = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
                this.f.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
                this.f.BatteryInfoOnEnd = this.b.a();
                p pVar2 = this.f;
                pVar2.TimeInfoOnEnd = ubVar;
                pVar2.TimestampOnEnd = ubVar.TimestampTableau;
                long[] a2 = a(this.p, this.J, System.currentTimeMillis());
                p pVar3 = this.f;
                pVar3.SessionTotalRxBytes = a2[0] - this.l;
                pVar3.SessionTotalTxBytes = a2[1] - this.m;
                if (pVar3.OverallRxMaxValue > 0) {
                    pVar3.OverallTotalRxBytes = a2[4] - this.w;
                }
                if (pVar3.OverallTxMaxValue > 0) {
                    pVar3.OverallTotalTxBytes = a2[5] - this.x;
                }
                if (g3.a(pVar3.RadioInfoOnEnd.ConnectionType)) {
                    p pVar4 = this.f;
                    g3 a3 = g3.a(this.k);
                    p pVar5 = this.f;
                    pVar4.IspInfoOnEnd = a3.a(pVar5.RadioInfoOnEnd, pVar5.WifiInfoOnEnd, true);
                    if (g3.a(this.f.RadioInfoOnStart.ConnectionType)) {
                        p pVar6 = this.f;
                        if (!pVar6.IspInfoOnStart.SuccessfulIspLookup) {
                            g3 a4 = g3.a(this.k);
                            p pVar7 = this.f;
                            pVar6.IspInfoOnStart = a4.a(pVar7.RadioInfoOnStart, pVar7.WifiInfoOnStart, false);
                        }
                    }
                }
                if (InsightCore.getInsightConfig().y()) {
                    this.f.LocationInfoOnStart = new q4();
                    this.f.LocationInfoOnEnd = new q4();
                }
                InsightCore.getDatabaseHelper().a(w2.AUS, (RBR) this.f);
                if (InsightCore.getQoeManagerEnabled() && InsightCore.getQoeManager().b()) {
                    InsightCore.getQoeManager().b(this.f);
                }
                Iterator<o> it = this.V.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if (next != null) {
                        next.a(this.f);
                    }
                }
            }
            this.q.clear();
            if (this.K) {
                InsightCore.getStatsDatabase().a(this.f);
                InsightCore.getStatsDatabase().a(ubVar, this.L, this.M, this.N, this.O, this.P, this.Q);
                InsightCore.getStatsDatabase().a(ubVar, this.R, this.S);
                InsightCore.getStatsDatabase().a(ubVar, (List<SignalStrengthLocationShare>) this.T);
                c();
            }
        }
    }

    /* access modifiers changed from: private */
    public long[] a(int i2, long j2, long j3) {
        int i3 = i2;
        long[] jArr = {0, 0, 0, 0, 0, 0};
        try {
            p pVar = this.f;
            if (pVar == null || pVar.ForegroundDetectionMode != c3.Lollipop || this.U == null || InsightCore.getInsightConfig().h() != mc.Auto || !PermissionUtils.hasReadPhoneStatePermission(this.k)) {
                jArr[0] = TrafficStats.getUidRxBytes(i2);
                jArr[1] = TrafficStats.getUidTxBytes(i2);
                jArr[2] = TrafficStats.getTotalRxBytes();
                jArr[3] = TrafficStats.getTotalTxBytes();
            } else if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkStats.Bucket bucket = new NetworkStats.Bucket();
                    NetworkStats querySummary = this.U.querySummary(1, (String) null, j2, j3);
                    if (querySummary != null) {
                        while (querySummary.getNextBucket(bucket)) {
                            if (bucket.getUid() == i3) {
                                jArr[0] = jArr[0] + bucket.getRxBytes();
                                jArr[1] = jArr[1] + bucket.getTxBytes();
                            }
                            jArr[2] = jArr[2] + bucket.getRxBytes();
                            jArr[3] = jArr[3] + bucket.getTxBytes();
                        }
                        querySummary.close();
                    }
                    NetworkStats querySummary2 = this.U.querySummary(0, a(0), j2, j3);
                    if (querySummary2 != null) {
                        while (querySummary2.getNextBucket(bucket)) {
                            if (bucket.getUid() == i3) {
                                jArr[0] = jArr[0] + bucket.getRxBytes();
                                jArr[1] = jArr[1] + bucket.getTxBytes();
                            }
                            jArr[2] = jArr[2] + bucket.getRxBytes();
                            jArr[3] = jArr[3] + bucket.getTxBytes();
                        }
                        querySummary2.close();
                    }
                } catch (Exception e2) {
                    String str = c0;
                    Log.d(str, "getUidAndTotalBytes: " + e2.getMessage());
                    jArr[0] = TrafficStats.getUidRxBytes(i2);
                    jArr[1] = TrafficStats.getUidTxBytes(i2);
                    jArr[2] = TrafficStats.getTotalRxBytes();
                    jArr[3] = TrafficStats.getTotalTxBytes();
                }
            } else {
                jArr[0] = TrafficStats.getUidRxBytes(i2);
                jArr[1] = TrafficStats.getUidTxBytes(i2);
                jArr[2] = TrafficStats.getTotalRxBytes();
                jArr[3] = TrafficStats.getTotalTxBytes();
            }
            if (Build.VERSION.SDK_INT >= 28) {
                jArr[4] = TrafficStats.getTotalRxBytes();
                jArr[5] = TrafficStats.getTotalTxBytes();
            } else {
                jArr[4] = jArr[2];
                jArr[5] = jArr[3];
            }
        } catch (Exception e3) {
            String str2 = c0;
            Log.d(str2, "getUidAndTotalBytes: " + e3.getMessage());
        }
        return jArr;
    }

    private String a(int i2) {
        return i2 == 0 ? ((TelephonyManager) this.k.getSystemService("phone")).getSubscriberId() : "";
    }
}
