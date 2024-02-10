package com.umlaut.crowd.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.bc;
import com.umlaut.crowd.internal.na;
import com.umlaut.crowd.internal.tc;
import com.umlaut.crowd.speedtest.IBandwidthListener;
import com.umlaut.crowd.speedtest.SpeedtestEngineError;
import com.umlaut.crowd.speedtest.SpeedtestEngineStatus;
import com.umlaut.crowd.threads.ThreadManager;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class v implements bc.d, k2, ca, fa, s2, tc, t3 {
    public static final String m0 = "v";
    private static final boolean n0 = false;
    private static final HashMap<Object, w2> o0 = new HashMap<>();
    /* access modifiers changed from: private */
    public int A;
    /* access modifiers changed from: private */
    public int B;
    /* access modifiers changed from: private */
    public long C;
    /* access modifiers changed from: private */
    public long D;
    private long E;
    private long F;
    /* access modifiers changed from: private */
    public int G;
    /* access modifiers changed from: private */
    public long H;
    private long I;
    /* access modifiers changed from: private */
    public long J;
    /* access modifiers changed from: private */
    public boolean K = true;
    /* access modifiers changed from: private */
    public final String L;
    /* access modifiers changed from: private */
    public final IS M;
    /* access modifiers changed from: private */
    public int N = 10000;
    /* access modifiers changed from: private */
    public n O;
    /* access modifiers changed from: private */
    public n P;
    /* access modifiers changed from: private */
    public n Q;
    private long R;
    /* access modifiers changed from: private */
    public long S;
    /* access modifiers changed from: private */
    public long T;
    /* access modifiers changed from: private */
    public long U;
    private String V;
    private AsyncTask<Void, Void, p4> W;
    private String X = "";
    private String Y = "";
    private String Z = "";
    /* access modifiers changed from: private */
    public final IBandwidthListener a;
    private String a0 = "";
    /* access modifiers changed from: private */
    public final Context b;
    private String b0 = "";
    /* access modifiers changed from: private */
    public CLC c;
    private String c0 = "";
    /* access modifiers changed from: private */
    public x d;
    /* access modifiers changed from: private */
    public String d0 = "";
    /* access modifiers changed from: private */
    public RP3 e;
    /* access modifiers changed from: private */
    public String e0 = "";
    /* access modifiers changed from: private */
    public bc f;
    /* access modifiers changed from: private */
    public boolean f0;
    /* access modifiers changed from: private */
    public ArrayList<k7> g;
    /* access modifiers changed from: private */
    public boolean g0 = true;
    /* access modifiers changed from: private */
    public ArrayList<e5> h;
    /* access modifiers changed from: private */
    public boolean h0 = false;
    /* access modifiers changed from: private */
    public ArrayList<g5> i;
    /* access modifiers changed from: private */
    public s6 i0;
    /* access modifiers changed from: private */
    public ArrayList<g5> j;
    /* access modifiers changed from: private */
    public v2 j0;
    /* access modifiers changed from: private */
    public HashMap<Object, w2> k;
    /* access modifiers changed from: private */
    public x2 k0;
    /* access modifiers changed from: private */
    public ArrayList<j7> l;
    /* access modifiers changed from: private */
    public ja l0;
    /* access modifiers changed from: private */
    public ArrayList<j7> m;
    /* access modifiers changed from: private */
    public ArrayList<DRI> n;
    /* access modifiers changed from: private */
    public ArrayList<DWI> o;
    /* access modifiers changed from: private */
    public ArrayList<DRI> p;
    /* access modifiers changed from: private */
    public ArrayList<DRI> q;
    /* access modifiers changed from: private */
    public ArrayList<DWI> r;
    /* access modifiers changed from: private */
    public ArrayList<DWI> s;
    /* access modifiers changed from: private */
    public long t;
    /* access modifiers changed from: private */
    public int u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public int w;
    /* access modifiers changed from: private */
    public int x;
    /* access modifiers changed from: private */
    public int y;
    /* access modifiers changed from: private */
    public int z;

    class a implements Runnable {
        final /* synthetic */ kb a;
        final /* synthetic */ j7 b;
        final /* synthetic */ tc.a c;
        final /* synthetic */ int d;
        final /* synthetic */ j7[] e;

        a(kb kbVar, j7 j7Var, tc.a aVar, int i, j7[] j7VarArr) {
            this.a = kbVar;
            this.b = j7Var;
            this.c = aVar;
            this.d = i;
            this.e = j7VarArr;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x00cd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.xc r0 = r0.pkgDown
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                java.util.HashMap r0 = r0.k
                java.util.HashMap r1 = com.umlaut.crowd.internal.v.c()
                r0.putAll(r1)
                com.umlaut.crowd.internal.j7 r0 = r7.b
                long r1 = r0.lastPkgTime
                long r3 = r0.firstPkgTime
                long r1 = r1 - r3
                r3 = 1000000(0xf4240, double:4.940656E-318)
                long r1 = r1 / r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.tc$a r3 = r7.c
                int r3 = r3.a()
                r0.UDPTestStatus = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                r0.MeasurementDurationClient = r1
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.pkgsReceived
                r0.OverallPackagesReceivedClient = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.jitterPkgCnt
                r0.OverallJitterPackagesCountClient = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.jitterSum
                r0.OverallJitterSumClient = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                java.util.ArrayList r0 = r0.l
                int r3 = r7.d
                com.umlaut.crowd.internal.j7[] r4 = r7.e
                int r4 = r4.length
                int r3 = r3 + r4
                com.umlaut.crowd.internal.v9.b(r0, r3)
                r0 = 0
            L_0x0073:
                com.umlaut.crowd.internal.j7[] r3 = r7.e
                int r3 = r3.length
                if (r0 >= r3) goto L_0x008b
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this
                java.util.ArrayList r3 = r3.l
                int r4 = r7.d
                int r4 = r4 + r0
                com.umlaut.crowd.internal.j7[] r5 = r7.e
                r5 = r5[r0]
                r3.set(r4, r5)
                int r0 = r0 + 1
                goto L_0x0073
            L_0x008b:
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_UDP_FIXEDRECEIVEDATA
                if (r0 == r3) goto L_0x00ba
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_UDP_FIXEDSENDDATA
                if (r0 != r3) goto L_0x00a0
                goto L_0x00ba
            L_0x00a0:
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_UDP_FIXEDTIMEFRAME
                if (r0 != r3) goto L_0x00b8
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                long r3 = com.umlaut.crowd.internal.v.U(r0)
                float r0 = (float) r3
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this
                int r3 = r3.A
                goto L_0x00c5
            L_0x00b8:
                r0 = 0
                goto L_0x00c7
            L_0x00ba:
                com.umlaut.crowd.internal.j7 r0 = r7.b
                long r3 = r0.pkgsReceived
                float r0 = (float) r3
                com.umlaut.crowd.internal.kb r3 = r7.a
                com.umlaut.crowd.internal.ob r3 = (com.umlaut.crowd.internal.ob) r3
                int r3 = r3.packageCntDown
            L_0x00c5:
                float r3 = (float) r3
                float r0 = r0 / r3
            L_0x00c7:
                r3 = 1065353216(0x3f800000, float:1.0)
                int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r4 <= 0) goto L_0x00cf
                r0 = 1065353216(0x3f800000, float:1.0)
            L_0x00cf:
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.pkgsReceived
                com.umlaut.crowd.internal.kb r5 = r7.a
                com.umlaut.crowd.internal.xc r5 = r5.pkgDown
                int r5 = r5.pkgSize
                long r5 = (long) r5
                long r3 = r3 * r5
                r5 = 8
                long r3 = r3 * r5
                double r3 = (double) r3
                double r1 = (double) r1
                r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
                java.lang.Double.isNaN(r1)
                double r1 = r1 / r5
                java.lang.Double.isNaN(r3)
                double r3 = r3 / r1
                long r1 = (long) r3
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.speedtest.IBandwidthListener r3 = r3.a
                r3.onTransferProgress(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v.a.run():void");
        }
    }

    class b implements Runnable {
        final /* synthetic */ kb a;
        final /* synthetic */ j7 b;
        final /* synthetic */ tc.a c;
        final /* synthetic */ int d;
        final /* synthetic */ j7[] e;

        b(kb kbVar, j7 j7Var, tc.a aVar, int i, j7[] j7VarArr) {
            this.a = kbVar;
            this.b = j7Var;
            this.c = aVar;
            this.d = i;
            this.e = j7VarArr;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x00c0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.xc r0 = r0.pkgUp
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                com.umlaut.crowd.internal.j7 r0 = r7.b
                long r1 = r0.lastPkgTime
                long r3 = r0.firstPkgTime
                long r1 = r1 - r3
                r3 = 1000000(0xf4240, double:4.940656E-318)
                long r1 = r1 / r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.tc$a r3 = r7.c
                int r3 = r3.a()
                r0.UDPTestStatus = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                r0.MeasurementDurationServer = r1
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.pkgsReceived
                r0.OverallPackagesReceivedServer = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.jitterPkgCnt
                r0.OverallJitterPackagesCountServer = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                com.umlaut.crowd.internal.jd r0 = (com.umlaut.crowd.internal.jd) r0
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.jitterSum
                r0.OverallJitterSumServer = r3
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                java.util.ArrayList r0 = r0.m
                int r3 = r7.d
                com.umlaut.crowd.internal.j7[] r4 = r7.e
                int r4 = r4.length
                int r3 = r3 + r4
                com.umlaut.crowd.internal.v9.b(r0, r3)
                r0 = 0
            L_0x0066:
                com.umlaut.crowd.internal.j7[] r3 = r7.e
                int r3 = r3.length
                if (r0 >= r3) goto L_0x007e
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this
                java.util.ArrayList r3 = r3.m
                int r4 = r7.d
                int r4 = r4 + r0
                com.umlaut.crowd.internal.j7[] r5 = r7.e
                r5 = r5[r0]
                r3.set(r4, r5)
                int r0 = r0 + 1
                goto L_0x0066
            L_0x007e:
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_UDP_FIXEDRECEIVEDATA
                if (r0 == r3) goto L_0x00ad
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_UDP_FIXEDSENDDATA
                if (r0 != r3) goto L_0x0093
                goto L_0x00ad
            L_0x0093:
                com.umlaut.crowd.internal.kb r0 = r7.a
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_UDP_FIXEDTIMEFRAME
                if (r0 != r3) goto L_0x00ab
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                long r3 = com.umlaut.crowd.internal.v.X(r0)
                float r0 = (float) r3
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this
                int r3 = r3.B
                goto L_0x00b8
            L_0x00ab:
                r0 = 0
                goto L_0x00ba
            L_0x00ad:
                com.umlaut.crowd.internal.j7 r0 = r7.b
                long r3 = r0.pkgsReceived
                float r0 = (float) r3
                com.umlaut.crowd.internal.kb r3 = r7.a
                com.umlaut.crowd.internal.ob r3 = (com.umlaut.crowd.internal.ob) r3
                int r3 = r3.packageCntDown
            L_0x00b8:
                float r3 = (float) r3
                float r0 = r0 / r3
            L_0x00ba:
                r3 = 1065353216(0x3f800000, float:1.0)
                int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r4 <= 0) goto L_0x00c2
                r0 = 1065353216(0x3f800000, float:1.0)
            L_0x00c2:
                com.umlaut.crowd.internal.j7 r3 = r7.b
                long r3 = r3.pkgsReceived
                com.umlaut.crowd.internal.kb r5 = r7.a
                com.umlaut.crowd.internal.xc r5 = r5.pkgUp
                int r5 = r5.pkgSize
                long r5 = (long) r5
                long r3 = r3 * r5
                r5 = 8
                long r3 = r3 * r5
                double r3 = (double) r3
                double r1 = (double) r1
                r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
                java.lang.Double.isNaN(r1)
                double r1 = r1 / r5
                java.lang.Double.isNaN(r3)
                double r3 = r3 / r1
                long r1 = (long) r3
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.speedtest.IBandwidthListener r3 = r3.a
                r3.onTransferProgressRemote(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v.b.run():void");
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0077 */
        static {
            /*
                com.umlaut.crowd.internal.z4[] r0 = com.umlaut.crowd.internal.z4.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.umlaut.crowd.internal.z4 r2 = com.umlaut.crowd.internal.z4.CTItem     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.z4 r3 = com.umlaut.crowd.internal.z4.NoChange     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.z4 r4 = com.umlaut.crowd.internal.z4.Random     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.z4 r5 = com.umlaut.crowd.internal.z4.FullSuccessful     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.z4 r6 = com.umlaut.crowd.internal.z4.TotalTests     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.umlaut.crowd.internal.m5[] r5 = com.umlaut.crowd.internal.m5.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                a = r5
                com.umlaut.crowd.internal.m5 r6 = com.umlaut.crowd.internal.m5.HTTP     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.umlaut.crowd.internal.m5 r5 = com.umlaut.crowd.internal.m5.HTTP_FD     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.umlaut.crowd.internal.m5 r1 = com.umlaut.crowd.internal.m5.HTTPS     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006d }
                com.umlaut.crowd.internal.m5 r1 = com.umlaut.crowd.internal.m5.HTTPS_FD     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0077 }
                com.umlaut.crowd.internal.m5 r1 = com.umlaut.crowd.internal.m5.TCP20000     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0082 }
                com.umlaut.crowd.internal.m5 r1 = com.umlaut.crowd.internal.m5.TCP20000_FD     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v.c.<clinit>():void");
        }
    }

    class d implements Runnable {
        final /* synthetic */ sa a;
        final /* synthetic */ m5 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ a d;

        d(sa saVar, m5 m5Var, boolean z, a aVar) {
            this.a = saVar;
            this.b = m5Var;
            this.c = z;
            this.d = aVar;
        }

        public void run() {
            boolean z;
            int i;
            if (this.a != null) {
                switch (c.a[this.b.ordinal()]) {
                    case 1:
                    case 2:
                        i = 80;
                        break;
                    case 3:
                    case 4:
                        i = 80;
                        z = true;
                        break;
                    case 5:
                    case 6:
                        i = 20000;
                        break;
                    default:
                        i = 0;
                        break;
                }
                z = false;
                v.this.f();
                boolean unused = v.this.g0 = this.c;
                ja unused2 = v.this.l0 = this.a.a();
                m5 m5Var = this.b;
                m5 m5Var2 = m5.HTTP_FILE_DOWNLOAD;
                if (m5Var == m5Var2) {
                    v vVar = v.this;
                    RP3 unused3 = vVar.e = new u(vVar.L, v.this.M.q());
                    v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                    ((u) v.this.e).BwrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                    ((u) v.this.e).MeasurementLength = ((qa) this.a).a;
                    sa saVar = this.a;
                    ((u) v.this.e).MeasurementBytes = ((qa) saVar).b;
                    int length = saVar.e().ips.length;
                    if (length == 1 && (length = ((qa) this.a).testSockets) == 0) {
                        length = 1;
                    }
                    ((u) v.this.e).TestSockets = length;
                    long unused4 = v.this.t = (long) ((qa) this.a).a;
                    v vVar2 = v.this;
                    sa saVar2 = this.a;
                    int unused5 = vVar2.v = (int) (((long) ((qa) saVar2).a) / ((db) saVar2).reportingInterval);
                    int unused6 = v.this.u = (int) ((db) this.a).reportingInterval;
                } else if (m5Var == m5.HTTP_FILE_UPLOAD) {
                    v vVar3 = v.this;
                    RP3 unused7 = vVar3.e = new u(vVar3.L, v.this.M.q());
                    v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                    ((u) v.this.e).BwrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                    ((u) v.this.e).MeasurementLength = ((ra) this.a).a;
                    ((u) v.this.e).MeasurementBytes = ((ra) this.a).b;
                    sa saVar3 = this.a;
                    ((u) v.this.e).TestSockets = ((db) saVar3).testSockets;
                    long unused8 = v.this.t = (long) ((ra) saVar3).a;
                    v vVar4 = v.this;
                    sa saVar4 = this.a;
                    int unused9 = vVar4.v = (int) (((long) ((ra) saVar4).a) / ((db) saVar4).reportingInterval);
                    int unused10 = v.this.u = (int) ((db) this.a).reportingInterval;
                } else if (v.this.l0 == ja.TEST_TCPDOWNLOAD || v.this.l0 == ja.TEST_TCPUPLOAD) {
                    v vVar5 = v.this;
                    RP3 unused11 = vVar5.e = new u(vVar5.L, v.this.M.q());
                    v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                    ((u) v.this.e).BwrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                    ((u) v.this.e).MeasurementLength = (int) ((eb) this.a).measureLength;
                    sa saVar5 = this.a;
                    ((u) v.this.e).TestSockets = ((db) saVar5).testSockets;
                    long unused12 = v.this.t = ((eb) saVar5).measureLength;
                    v vVar6 = v.this;
                    sa saVar6 = this.a;
                    int unused13 = vVar6.v = (int) (((eb) saVar6).measureLength / ((db) saVar6).reportingInterval);
                    int unused14 = v.this.u = (int) ((db) this.a).reportingInterval;
                } else if (v.this.l0 == ja.TEST_TCPDOWNLOAD_SIZE || v.this.l0 == ja.TEST_TCPUPLOAD_SIZE) {
                    v vVar7 = v.this;
                    RP3 unused15 = vVar7.e = new u(vVar7.L, v.this.M.q());
                    v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                    ((u) v.this.e).BwrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                    ((u) v.this.e).MeasurementBytes = (long) ((int) ((fb) this.a).payloadsize);
                    ((u) v.this.e).TestSockets = ((db) this.a).testSockets;
                    int unused16 = v.this.v = 1;
                    int unused17 = v.this.u = (int) ((db) this.a).reportingInterval;
                } else if (v.this.l0 == ja.TEST_TCPPING) {
                    v vVar8 = v.this;
                    RP3 unused18 = vVar8.e = new p4(vVar8.L, v.this.M.q());
                    v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                    ((p4) v.this.e).LtrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                    ((p4) v.this.e).Pings = ((gb) this.a).count;
                    gb gbVar = (gb) this.a;
                    ((p4) v.this.e).Pause = gbVar.sleep;
                    long unused19 = v.this.t = ((long) gbVar.count) * ((long) gbVar.sleep);
                    int unused20 = v.this.v = ((gb) this.a).count;
                    int unused21 = v.this.G = ((gb) this.a).sleep;
                } else if (v.this.l0 == ja.TEST_TRACEROUTE) {
                    v vVar9 = v.this;
                    RP3 unused22 = vVar9.e = new ac(vVar9.L, v.this.M.q());
                    jb jbVar = (jb) this.a;
                    v.this.f.c(jbVar.timeoutPerProbe);
                    v.this.f.a(jbVar.maxHops);
                    v.this.f.b(jbVar.queries);
                    v.this.f.a(jbVar.server.ips[0], this.d);
                    return;
                } else {
                    ja k = v.this.l0;
                    ja jaVar = ja.TEST_FTPDOWNPERIOD;
                    if (k == jaVar || v.this.l0 == ja.TEST_FTPUPPERIOD) {
                        v vVar10 = v.this;
                        RP3 unused23 = vVar10.e = new u(vVar10.L, v.this.M.q());
                        v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                        ((u) v.this.e).BwrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                        ((u) v.this.e).TestSockets = 1;
                        if (v.this.l0 == jaVar) {
                            long unused24 = v.this.t = ((ma) this.a).duration;
                        } else if (v.this.l0 == ja.TEST_FTPUPPERIOD) {
                            long unused25 = v.this.t = ((pa) this.a).duration;
                        }
                        ((u) v.this.e).MeasurementLength = (int) v.this.t;
                        v vVar11 = v.this;
                        int unused26 = vVar11.v = (int) (vVar11.t / ((long) ((na) this.a).reportingInterval));
                        int unused27 = v.this.u = ((na) this.a).reportingInterval;
                    } else {
                        ja k2 = v.this.l0;
                        ja jaVar2 = ja.TEST_FTPDOWNFILESIZE;
                        if (k2 == jaVar2 || v.this.l0 == ja.TEST_FTPUPFILESIZE) {
                            v vVar12 = v.this;
                            RP3 unused28 = vVar12.e = new u(vVar12.L, v.this.M.q());
                            v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                            ((u) v.this.e).BwrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                            ((u) v.this.e).TestSockets = 1;
                            if (v.this.l0 == jaVar2) {
                                ((u) v.this.e).MeasurementBytes = ((la) this.a).fileSize;
                            } else if (v.this.l0 == ja.TEST_FTPUPFILESIZE) {
                                ((u) v.this.e).MeasurementBytes = ((oa) this.a).fileSize;
                            }
                            int unused29 = v.this.v = 1;
                            int unused30 = v.this.u = ((na) this.a).reportingInterval;
                        } else {
                            ja k3 = v.this.l0;
                            ja jaVar3 = ja.TEST_UDP_FIXEDRECEIVEDATA;
                            if (k3 == jaVar3 || v.this.l0 == ja.TEST_UDP_FIXEDSENDDATA || v.this.l0 == ja.TEST_UDP_FIXEDTIMEFRAME) {
                                v vVar13 = v.this;
                                RP3 unused31 = vVar13.e = new jd(vVar13.L, v.this.M.q());
                                v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                                ((jd) v.this.e).UdpId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                                kb kbVar = (kb) this.a;
                                xc xcVar = kbVar.pkgDown;
                                xc xcVar2 = kbVar.pkgUp;
                                if (xcVar != null) {
                                    int unused32 = v.this.w = xcVar.pkgInterval;
                                    ((jd) v.this.e).MeasurementPackageSizeClient = xcVar.pkgSize;
                                    ((jd) v.this.e).MeasurementDirection = b5.Downlink;
                                }
                                if (xcVar2 != null) {
                                    int unused33 = v.this.x = xcVar2.pkgInterval;
                                    ((jd) v.this.e).MeasurementPackageSizeServer = xcVar2.pkgSize;
                                    ((jd) v.this.e).MeasurementDirection = b5.Uplink;
                                }
                                if (!(xcVar2 == null || xcVar == null)) {
                                    ((jd) v.this.e).MeasurementDirection = b5.Simultaneous;
                                }
                                v vVar14 = v.this;
                                long unused34 = vVar14.C = (long) vVar14.w;
                                if (v.this.C == 0) {
                                    long unused35 = v.this.C = 1000;
                                }
                                v vVar15 = v.this;
                                long unused36 = vVar15.D = (long) vVar15.x;
                                if (v.this.D == 0) {
                                    long unused37 = v.this.D = 1000;
                                }
                                if (v.this.l0 == jaVar3 || v.this.l0 == ja.TEST_UDP_FIXEDSENDDATA) {
                                    ((jd) v.this.e).MeasurementPackagesClient = ((ob) this.a).packageCntDown;
                                    ((jd) v.this.e).MeasurementPackagesServer = ((ob) this.a).packageCntUp;
                                } else if (v.this.l0 == ja.TEST_UDP_FIXEDTIMEFRAME) {
                                    nb nbVar = (nb) this.a;
                                    long j = nbVar.timeframeDown;
                                    long j2 = nbVar.timeframeUp;
                                    ((jd) v.this.e).MeasurementLengthClient = j;
                                    ((jd) v.this.e).MeasurementLengthServer = j2;
                                    if (v.this.w > 0) {
                                        v vVar16 = v.this;
                                        int unused38 = vVar16.y = ((int) j) / vVar16.w;
                                    }
                                    if (v.this.x > 0) {
                                        v vVar17 = v.this;
                                        int unused39 = vVar17.z = ((int) j2) / vVar17.x;
                                    }
                                    v vVar18 = v.this;
                                    int unused40 = vVar18.A = (int) (j / vVar18.C);
                                    v vVar19 = v.this;
                                    int unused41 = vVar19.B = (int) (j2 / vVar19.D);
                                }
                            }
                        }
                    }
                }
                if (v.this.l0 == ja.TEST_TCPDOWNLOAD || v.this.l0 == ja.TEST_TCPDOWNLOAD_SIZE || v.this.l0 == ja.TEST_FTPDOWNFILESIZE || v.this.l0 == ja.TEST_FTPDOWNPERIOD) {
                    ((u) v.this.e).MeasurementDirection = b5.Downlink;
                } else if (v.this.l0 == ja.TEST_TCPUPLOAD || v.this.l0 == ja.TEST_TCPUPLOAD_SIZE || v.this.l0 == ja.TEST_FTPUPFILESIZE || v.this.l0 == ja.TEST_FTPUPPERIOD) {
                    ((u) v.this.e).MeasurementDirection = b5.Uplink;
                }
                if (v.this.t < 1) {
                    long unused42 = v.this.t = 1;
                }
                if (v.this.v < 1) {
                    int unused43 = v.this.v = 1;
                }
                ArrayList unused44 = v.this.g = new ArrayList();
                if (v.this.l0 != ja.TEST_TCPPING || InsightCore.getInsightConfig().L0()) {
                    v.this.e.CellInfoOnStart = InsightCore.getRadioController().d();
                }
                v.this.e.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
                v.this.e.RadioInfoOnStart = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
                if (v.this.f0) {
                    v.this.e.IspInfo = g3.a(v.this.b).a(v.this.e.RadioInfoOnStart, v.this.e.WifiInfoOnStart, g3.a(v.this.e.RadioInfoOnStart.ConnectionType));
                }
                v.this.e.Trigger = this.d;
                v.this.e.MeasurementType = this.b;
                v.this.e.BatteryInfoOnStart = v.this.d.a();
                v.this.e.MemoryInfoOnStart = CDC.d(v.this.b);
                v.this.e.TrafficInfoOnStart = CDC.f();
                v.this.e.DeviceInfo = CDC.getDeviceInfo(v.this.b);
                v.this.e.LocationInfoOnStart = v.this.c.getLastLocationInfo();
                v.this.e.TestEndState = t9.ConnectingToControlServer;
                v.this.e.IsAppInForeground = InsightCore.getForegroundTestManager().d();
                m5 m5Var3 = this.b;
                if (m5Var3 == m5Var2) {
                    try {
                        v vVar20 = v.this;
                        int q = v.this.N;
                        v vVar21 = v.this;
                        v2 unused45 = vVar20.j0 = new v2((qa) this.a, q, vVar21, vVar21, vVar21);
                        v.this.e.Server = Arrays.toString(this.a.e().ips).replace("[", "").replace("]", "").replace(" ", "");
                        v.this.e.ServerUrl = v.this.e.Server;
                        v.this.j0.start();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        v.this.a(l2.n);
                    }
                } else if (m5Var3 == m5.HTTP_FILE_UPLOAD) {
                    try {
                        ra raVar = (ra) this.a;
                        v vVar22 = v.this;
                        int q2 = v.this.N;
                        v vVar23 = v.this;
                        x2 unused46 = vVar22.k0 = new x2(raVar, q2, vVar23, vVar23);
                        v.this.e.Server = Arrays.toString(raVar.e().ips).replace("[", "").replace("]", "").replace(" ", "");
                        v.this.e.ServerUrl = v.this.e.Server;
                        v.this.k0.start();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        v.this.a(l2.n);
                    }
                } else {
                    v.this.e.ServerUrl = InsightCore.getInsightConfig().W0();
                    v vVar24 = v.this;
                    v vVar25 = vVar24;
                    s6 unused47 = vVar24.i0 = vVar25.a(new sa[]{this.a}, vVar24, i, this.b, z, vVar24.h0, v.this.N);
                    v.this.i0.start();
                }
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            try {
                if (v.this.i0 != null) {
                    v.this.i0.a();
                }
                if (v.this.j0 != null) {
                    v.this.j0.a();
                }
                if (v.this.k0 != null) {
                    v.this.k0.a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ l2 a;

        f(l2 l2Var) {
            this.a = l2Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: com.umlaut.crowd.internal.g5} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0122  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0185  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x023f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r12 = this;
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r0 = r0.e
                monitor-enter(r0)
                com.umlaut.crowd.internal.l2 r1 = r12.a     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.l2 r2 = com.umlaut.crowd.internal.l2.n     // Catch:{ all -> 0x034a }
                r3 = 1
                r4 = 0
                if (r1 == r2) goto L_0x0065
                com.umlaut.crowd.internal.l2 r5 = com.umlaut.crowd.internal.l2.END     // Catch:{ all -> 0x034a }
                if (r1 == r5) goto L_0x0065
                com.umlaut.crowd.internal.l2 r5 = com.umlaut.crowd.internal.l2.ABORTED     // Catch:{ all -> 0x034a }
                if (r1 != r5) goto L_0x0018
                goto L_0x0065
            L_0x0018:
                com.umlaut.crowd.internal.l2 r5 = com.umlaut.crowd.internal.l2.INIT_TEST     // Catch:{ all -> 0x034a }
                if (r1 != r5) goto L_0x00d5
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                boolean r1 = r1 instanceof com.umlaut.crowd.internal.p4     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x002e
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.w2 r5 = com.umlaut.crowd.internal.w2.LTR     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v.a((java.lang.Object) r1, (com.umlaut.crowd.internal.w2) r5)     // Catch:{ all -> 0x034a }
                goto L_0x0051
            L_0x002e:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                boolean r1 = r1 instanceof com.umlaut.crowd.internal.u     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x0040
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.w2 r5 = com.umlaut.crowd.internal.w2.BWR     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v.a((java.lang.Object) r1, (com.umlaut.crowd.internal.w2) r5)     // Catch:{ all -> 0x034a }
                goto L_0x0051
            L_0x0040:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                boolean r1 = r1 instanceof com.umlaut.crowd.internal.jd     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x0051
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.w2 r5 = com.umlaut.crowd.internal.w2.UTR     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v.a((java.lang.Object) r1, (com.umlaut.crowd.internal.w2) r5)     // Catch:{ all -> 0x034a }
            L_0x0051:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.IBandwidthListener r1 = r1.a     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r5 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.INIT     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineError r6 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r7 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r7 = r7.t     // Catch:{ all -> 0x034a }
                r1.onTestStatusChanged(r5, r6, r7)     // Catch:{ all -> 0x034a }
                goto L_0x00d5
            L_0x0065:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r6 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                java.util.HashMap r6 = r6.k     // Catch:{ all -> 0x034a }
                java.util.Collection r6 = r6.values()     // Catch:{ all -> 0x034a }
                r5.<init>(r6)     // Catch:{ all -> 0x034a }
                r6 = 44
                java.lang.String r5 = com.umlaut.crowd.internal.aa.a(r5, r6, r3)     // Catch:{ all -> 0x034a }
                r1.TestsInProgress = r5     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v.a((java.lang.Object) r1)     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.O     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x00a1
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.O     // Catch:{ all -> 0x034a }
                boolean r1 = r1.f     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x00a1
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.O     // Catch:{ all -> 0x034a }
                r1.f = r4     // Catch:{ all -> 0x034a }
            L_0x00a1:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.P     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x00bb
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.P     // Catch:{ all -> 0x034a }
                boolean r1 = r1.f     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x00bb
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.P     // Catch:{ all -> 0x034a }
                r1.f = r4     // Catch:{ all -> 0x034a }
            L_0x00bb:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.Q     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x00d5
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.Q     // Catch:{ all -> 0x034a }
                boolean r1 = r1.f     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x00d5
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v$n r1 = r1.Q     // Catch:{ all -> 0x034a }
                r1.f = r4     // Catch:{ all -> 0x034a }
            L_0x00d5:
                com.umlaut.crowd.internal.l2 r1 = r12.a     // Catch:{ all -> 0x034a }
                if (r1 == r2) goto L_0x00dd
                com.umlaut.crowd.internal.l2 r5 = com.umlaut.crowd.internal.l2.END     // Catch:{ all -> 0x034a }
                if (r1 != r5) goto L_0x0181
            L_0x00dd:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ja r1 = r1.l0     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ja r5 = com.umlaut.crowd.internal.ja.TEST_TCPPING     // Catch:{ all -> 0x034a }
                if (r1 != r5) goto L_0x00fa
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.p4 r1 = (com.umlaut.crowd.internal.p4) r1     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                java.util.ArrayList r3 = r3.h     // Catch:{ all -> 0x034a }
                r1.a(r3)     // Catch:{ all -> 0x034a }
                goto L_0x0181
            L_0x00fa:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.u r1 = (com.umlaut.crowd.internal.u) r1     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.b5 r5 = r1.MeasurementDirection     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.b5 r6 = com.umlaut.crowd.internal.b5.Downlink     // Catch:{ all -> 0x034a }
                if (r5 == r6) goto L_0x0116
                com.umlaut.crowd.internal.m5 r5 = r1.MeasurementType     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.m5 r6 = com.umlaut.crowd.internal.m5.HTTP_FILE_UPLOAD     // Catch:{ all -> 0x034a }
                if (r5 != r6) goto L_0x010f
                goto L_0x0116
            L_0x010f:
                com.umlaut.crowd.internal.v r5 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                java.util.ArrayList r5 = r5.j     // Catch:{ all -> 0x034a }
                goto L_0x011c
            L_0x0116:
                com.umlaut.crowd.internal.v r5 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                java.util.ArrayList r5 = r5.i     // Catch:{ all -> 0x034a }
            L_0x011c:
                boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x034a }
                if (r6 != 0) goto L_0x0181
                int r6 = r5.size()     // Catch:{ all -> 0x034a }
                int r6 = r6 - r3
                java.lang.Object r6 = r5.get(r6)     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.g5 r6 = (com.umlaut.crowd.internal.g5) r6     // Catch:{ all -> 0x034a }
                int r7 = r5.size()     // Catch:{ all -> 0x034a }
                if (r7 <= r3) goto L_0x016d
                int r7 = r1.MeasurementLength     // Catch:{ all -> 0x034a }
                if (r7 <= 0) goto L_0x013e
                long r8 = r6.Delta     // Catch:{ all -> 0x034a }
                long r10 = (long) r7     // Catch:{ all -> 0x034a }
                int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r7 > 0) goto L_0x0152
            L_0x013e:
                long r7 = r1.MeasurementBytes     // Catch:{ all -> 0x034a }
                r9 = 0
                int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r11 <= 0) goto L_0x016d
                com.umlaut.crowd.internal.v r7 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r7 = r7.H     // Catch:{ all -> 0x034a }
                long r9 = r1.MeasurementBytes     // Catch:{ all -> 0x034a }
                int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r11 <= 0) goto L_0x016d
            L_0x0152:
                com.umlaut.crowd.internal.v r7 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r8 = r6.BytesTransmitted     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v.e((com.umlaut.crowd.internal.v) r7, (long) r8)     // Catch:{ all -> 0x034a }
                int r6 = r5.size()     // Catch:{ all -> 0x034a }
                int r6 = r6 - r3
                r5.remove(r6)     // Catch:{ all -> 0x034a }
                int r6 = r5.size()     // Catch:{ all -> 0x034a }
                int r6 = r6 - r3
                java.lang.Object r3 = r5.get(r6)     // Catch:{ all -> 0x034a }
                r6 = r3
                com.umlaut.crowd.internal.g5 r6 = (com.umlaut.crowd.internal.g5) r6     // Catch:{ all -> 0x034a }
            L_0x016d:
                r1.a(r5)     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r7 = r3.H     // Catch:{ all -> 0x034a }
                r1.BytesTransmitted = r7     // Catch:{ all -> 0x034a }
                int r3 = r1.MeasurementDuration     // Catch:{ all -> 0x034a }
                if (r3 != 0) goto L_0x0181
                long r5 = r6.Delta     // Catch:{ all -> 0x034a }
                int r3 = (int) r5     // Catch:{ all -> 0x034a }
                r1.MeasurementDuration = r3     // Catch:{ all -> 0x034a }
            L_0x0181:
                com.umlaut.crowd.internal.l2 r1 = r12.a     // Catch:{ all -> 0x034a }
                if (r1 != r2) goto L_0x023f
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ja r1 = r1.l0     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ja r2 = com.umlaut.crowd.internal.ja.TEST_TCPPING     // Catch:{ all -> 0x034a }
                if (r1 != r2) goto L_0x0199
                com.umlaut.crowd.IC r1 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ all -> 0x034a }
                boolean r1 = r1.L0()     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x01a9
            L_0x0199:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.l7 r2 = com.umlaut.crowd.InsightCore.getRadioController()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.z0[] r2 = r2.d()     // Catch:{ all -> 0x034a }
                r1.CellInfoOnEnd = r2     // Catch:{ all -> 0x034a }
            L_0x01a9:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.x r2 = r2.d     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.z r2 = r2.a()     // Catch:{ all -> 0x034a }
                r1.BatteryInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.CLC r2 = r2.c     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.q4 r2 = r2.getLastLocationInfo()     // Catch:{ all -> 0x034a }
                r1.LocationInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                android.content.Context r2 = r2.b     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.n5 r2 = com.umlaut.crowd.internal.CDC.d((android.content.Context) r2)     // Catch:{ all -> 0x034a }
                r1.MemoryInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ub r2 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()     // Catch:{ all -> 0x034a }
                r1.TimeInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.nc r2 = com.umlaut.crowd.internal.CDC.f()     // Catch:{ all -> 0x034a }
                r1.TrafficInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.InsightCore.getWifiController()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.DWI r2 = r2.getWifiInfo()     // Catch:{ all -> 0x034a }
                r1.WifiInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.l7 r2 = com.umlaut.crowd.InsightCore.getRadioController()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.DRI r2 = r2.getRadioInfoForDefaultDataSim()     // Catch:{ all -> 0x034a }
                r1.RadioInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                r1.Success = r4     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                r1.g()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.IBandwidthListener r1 = r1.a     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.ERROR     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r3 = r3.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = r3.TestErrorReasonType     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r4 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r4 = r4.t     // Catch:{ all -> 0x034a }
                r1.onTestStatusChanged(r2, r3, r4)     // Catch:{ all -> 0x034a }
                goto L_0x0348
            L_0x023f:
                com.umlaut.crowd.internal.l2 r2 = com.umlaut.crowd.internal.l2.END     // Catch:{ all -> 0x034a }
                if (r1 != r2) goto L_0x0329
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineError r1 = r1.TestErrorReasonType     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineError r2 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK     // Catch:{ all -> 0x034a }
                if (r1 == r2) goto L_0x0308
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ja r1 = r1.l0     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ja r2 = com.umlaut.crowd.internal.ja.TEST_TCPPING     // Catch:{ all -> 0x034a }
                if (r1 != r2) goto L_0x0263
                com.umlaut.crowd.IC r1 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ all -> 0x034a }
                boolean r1 = r1.L0()     // Catch:{ all -> 0x034a }
                if (r1 == 0) goto L_0x0273
            L_0x0263:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.l7 r2 = com.umlaut.crowd.InsightCore.getRadioController()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.z0[] r2 = r2.d()     // Catch:{ all -> 0x034a }
                r1.CellInfoOnEnd = r2     // Catch:{ all -> 0x034a }
            L_0x0273:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.x r2 = r2.d     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.z r2 = r2.a()     // Catch:{ all -> 0x034a }
                r1.BatteryInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.CLC r2 = r2.c     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.q4 r2 = r2.getLastLocationInfo()     // Catch:{ all -> 0x034a }
                r1.LocationInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                android.content.Context r2 = r2.b     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.n5 r2 = com.umlaut.crowd.internal.CDC.d((android.content.Context) r2)     // Catch:{ all -> 0x034a }
                r1.MemoryInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ub r2 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()     // Catch:{ all -> 0x034a }
                r1.TimeInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.nc r2 = com.umlaut.crowd.internal.CDC.f()     // Catch:{ all -> 0x034a }
                r1.TrafficInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.InsightCore.getWifiController()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.DWI r2 = r2.getWifiInfo()     // Catch:{ all -> 0x034a }
                r1.WifiInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.l7 r2 = com.umlaut.crowd.InsightCore.getRadioController()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.DRI r2 = r2.getRadioInfoForDefaultDataSim()     // Catch:{ all -> 0x034a }
                r1.RadioInfoOnEnd = r2     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                r1.Success = r4     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                r1.g()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.IBandwidthListener r1 = r1.a     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.ERROR     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r3 = r3.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = r3.TestErrorReasonType     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r4 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r4 = r4.t     // Catch:{ all -> 0x034a }
                r1.onTestStatusChanged(r2, r3, r4)     // Catch:{ all -> 0x034a }
                goto L_0x0348
            L_0x0308:
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.t9 r3 = com.umlaut.crowd.internal.t9.Finish     // Catch:{ all -> 0x034a }
                r1.TestEndState = r3     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                r1.g()     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.IBandwidthListener r1 = r1.a     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r3 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.END     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r4 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r4 = r4.t     // Catch:{ all -> 0x034a }
                r1.onTestStatusChanged(r3, r2, r4)     // Catch:{ all -> 0x034a }
                goto L_0x0348
            L_0x0329:
                com.umlaut.crowd.internal.l2 r2 = com.umlaut.crowd.internal.l2.ABORTED     // Catch:{ all -> 0x034a }
                if (r1 != r2) goto L_0x0348
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.RP3 r1 = r1.e     // Catch:{ all -> 0x034a }
                r1.Success = r4     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.IBandwidthListener r1 = r1.a     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.ABORTED     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK     // Catch:{ all -> 0x034a }
                com.umlaut.crowd.internal.v r4 = com.umlaut.crowd.internal.v.this     // Catch:{ all -> 0x034a }
                long r4 = r4.t     // Catch:{ all -> 0x034a }
                r1.onTestStatusChanged(r2, r3, r4)     // Catch:{ all -> 0x034a }
            L_0x0348:
                monitor-exit(r0)     // Catch:{ all -> 0x034a }
                return
            L_0x034a:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x034a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v.f.run():void");
        }
    }

    class g implements Runnable {
        final /* synthetic */ sa a;
        final /* synthetic */ ab b;

        g(sa saVar, ab abVar) {
            this.a = saVar;
            this.b = abVar;
        }

        public void run() {
            ja a2 = this.a.a();
            if (this.b == ab.CONNECT) {
                v.this.e.TestEndState = t9.ConnectingToTestServer;
                if (v.this.e.MeasurementType == m5.HTTP_FILE_DOWNLOAD || v.this.e.MeasurementType == m5.HTTP_FILE_UPLOAD) {
                    v.this.a.onTestStatusChanged(SpeedtestEngineStatus.REGISTER, SpeedtestEngineError.OK, v.this.t);
                } else {
                    v.this.a.onTestStatusChanged(SpeedtestEngineStatus.CONNECT, SpeedtestEngineError.OK, v.this.t);
                }
                long unused = v.this.S = SystemClock.elapsedRealtime();
            }
            if (this.b == ab.REGISTER) {
                v.this.e.ConnectingTimeTestServerControl = SystemClock.elapsedRealtime() - v.this.S;
                if (!(v.this.e.MeasurementType == m5.HTTP_FILE_DOWNLOAD || v.this.e.MeasurementType == m5.HTTP_FILE_UPLOAD)) {
                    v.this.e.TestEndState = t9.ConnectedToTestServer;
                    v.this.a.onTestStatusChanged(SpeedtestEngineStatus.REGISTER, SpeedtestEngineError.OK, v.this.t);
                }
            }
            ab abVar = this.b;
            ab abVar2 = ab.SETUP_SOCKETS;
            if (abVar == abVar2) {
                if (v.this.e.MeasurementType == m5.HTTP_FILE_DOWNLOAD || v.this.e.MeasurementType == m5.HTTP_FILE_UPLOAD) {
                    v.this.a.onTestStatusChanged(SpeedtestEngineStatus.CONNECT, SpeedtestEngineError.OK, v.this.t);
                }
                long unused2 = v.this.T = SystemClock.elapsedRealtime();
            }
            ab abVar3 = this.b;
            ab abVar4 = ab.RUNNING;
            if (abVar3 == abVar4) {
                m5 m5Var = v.this.e.MeasurementType;
                m5 m5Var2 = m5.HTTP_FILE_DOWNLOAD;
                if (m5Var != m5Var2 && v.this.e.MeasurementType != m5.HTTP_FILE_UPLOAD) {
                    v.this.e.ConnectingTimeTestServerSockets = SystemClock.elapsedRealtime() - v.this.T;
                } else if (v.this.e.MeasurementType == m5Var2) {
                    ((u) v.this.e).TimeToFirstByte = SystemClock.elapsedRealtime() - v.this.U;
                }
                v.this.a.onTestStatusChanged(SpeedtestEngineStatus.RUN, SpeedtestEngineError.OK, v.this.t);
            } else if (abVar3 == ab.FINISHED) {
                v.this.e.Success = true;
                if (a2 != ja.TEST_TCPPING || InsightCore.getInsightConfig().L0()) {
                    v.this.e.CellInfoOnEnd = InsightCore.getRadioController().d();
                }
                v.this.e.TimeInfoOnEnd = TimeServer.getTimeInfo();
                v.this.e.BatteryInfoOnEnd = v.this.d.a();
                v.this.e.LocationInfoOnEnd = v.this.c.getLastLocationInfo();
                v.this.e.MemoryInfoOnEnd = CDC.d(v.this.b);
                v.this.e.TrafficInfoOnEnd = CDC.f();
                v.this.e.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
                v.this.e.RadioInfoOnEnd = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
                v.this.e.TestEndState = t9.TestEnd;
            }
            if (a2 == ja.TEST_TCPPING) {
                if (this.b == abVar4) {
                    v.this.e.TestEndState = t9.TestStart;
                    if (InsightCore.getInsightConfig().L0()) {
                        v.this.e.CellInfoOnStart = InsightCore.getRadioController().d();
                    }
                    v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                    v.this.e.BatteryInfoOnStart = v.this.d.a();
                    v.this.e.LocationInfoOnStart = v.this.c.getLastLocationInfo();
                    v.this.e.MemoryInfoOnStart = CDC.d(v.this.b);
                    v.this.e.TrafficInfoOnStart = CDC.f();
                    v.this.e.DeviceInfo = CDC.getDeviceInfo(v.this.b);
                    v.this.e.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
                    v.this.e.RadioInfoOnStart = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
                    ((p4) v.this.e).LtrId = k3.a(v.this.e.TimeInfoOnStart, v.this.e.GUID);
                }
            } else if (this.b == abVar2) {
                v.this.e.TestEndState = t9.TestStart;
                v.this.e.CellInfoOnStart = InsightCore.getRadioController().d();
                v.this.e.TimeInfoOnStart = TimeServer.getTimeInfo();
                v.this.e.BatteryInfoOnStart = v.this.d.a();
                v.this.e.LocationInfoOnStart = v.this.c.getLastLocationInfo();
                v.this.e.MemoryInfoOnStart = CDC.d(v.this.b);
                v.this.e.TrafficInfoOnStart = CDC.f();
                v.this.e.DeviceInfo = CDC.getDeviceInfo(v.this.b);
                v.this.e.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
                v.this.e.RadioInfoOnStart = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
            } else if ((a2 == ja.TEST_TCPUPLOAD || a2 == ja.TEST_TCPUPLOAD_SIZE) && v.this.e.MeasurementType != m5.HTTP_FILE_UPLOAD) {
                if (this.b == abVar4) {
                    n unused3 = v.this.O = new n(a2, v.this.v, v.this.u, v.this.n, v.this.o);
                    v.this.O.start();
                }
            } else if (a2 != ja.TEST_FTPUPFILESIZE && a2 != ja.TEST_FTPUPPERIOD) {
                ja jaVar = ja.TEST_UDP_FIXEDRECEIVEDATA;
                if (a2 == jaVar || a2 == ja.TEST_UDP_FIXEDSENDDATA || a2 == ja.TEST_UDP_FIXEDTIMEFRAME) {
                    ab abVar5 = this.b;
                    if (abVar5 == abVar4) {
                        if (((kb) this.a).pkgDown != null) {
                            n unused4 = v.this.P = new n(a2, v.this.y, v.this.w, v.this.p, v.this.r);
                            v.this.P.start();
                        }
                        if (((kb) this.a).pkgUp != null) {
                            n unused5 = v.this.Q = new n(a2, v.this.z, v.this.x, v.this.q, v.this.s);
                            v.this.Q.start();
                        }
                    } else if (abVar5 == ab.FINISHED) {
                        if (v.this.P != null && v.this.P.f) {
                            try {
                                if (this.a.a() == ja.TEST_UDP_FIXEDSENDDATA || this.a.a() == jaVar) {
                                    v.this.P.f = false;
                                }
                                v.this.P.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (v.this.Q != null && v.this.Q.f) {
                            try {
                                if (this.a.a() == ja.TEST_UDP_FIXEDSENDDATA || this.a.a() == ja.TEST_UDP_FIXEDRECEIVEDATA) {
                                    v.this.Q.f = false;
                                }
                                v.this.Q.join();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            } else if (this.b == abVar4) {
                n unused6 = v.this.O = new n(a2, v.this.v, v.this.u, v.this.n, v.this.o);
                v.this.O.start();
            }
        }
    }

    class h implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;

        h(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public void run() {
            v.this.k.putAll(v.c());
            float Y = ((float) (this.a + 1)) / ((float) v.this.v);
            if (Y > 1.0f) {
                Y = 1.0f;
            }
            if (v.this.K) {
                v vVar = v.this;
                long unused = vVar.J = ((long) (-vVar.G)) - this.b;
                boolean unused2 = v.this.K = false;
            }
            long j = this.b;
            DRI radioInfoForDefaultDataSim = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
            v vVar2 = v.this;
            e5 a2 = v9.a(j, radioInfoForDefaultDataSim, v.i(vVar2, ((long) vVar2.G) + this.b));
            synchronized (v.this.e) {
                v.this.h.add(a2);
            }
            v.this.a.onPingProgress(Y, (int) this.b);
        }
    }

    class i implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ db b;
        final /* synthetic */ int c;

        i(long j, db dbVar, int i) {
            this.a = j;
            this.b = dbVar;
            this.c = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                java.util.HashMap r0 = r0.k
                java.util.HashMap r1 = com.umlaut.crowd.internal.v.c()
                r0.putAll(r1)
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                long r1 = r10.a
                com.umlaut.crowd.internal.v.d((com.umlaut.crowd.internal.v) r0, (long) r1)
                com.umlaut.crowd.internal.db r0 = r10.b
                boolean r1 = r0 instanceof com.umlaut.crowd.internal.qa
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                if (r1 == 0) goto L_0x0038
                r1 = r0
                com.umlaut.crowd.internal.qa r1 = (com.umlaut.crowd.internal.qa) r1
                long r4 = r1.b
                int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r1 >= 0) goto L_0x0038
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                long r0 = r0.H
                float r0 = (float) r0
                com.umlaut.crowd.internal.db r1 = r10.b
                com.umlaut.crowd.internal.qa r1 = (com.umlaut.crowd.internal.qa) r1
                long r1 = r1.b
            L_0x0035:
                float r1 = (float) r1
            L_0x0036:
                float r0 = r0 / r1
                goto L_0x0098
            L_0x0038:
                boolean r1 = r0 instanceof com.umlaut.crowd.internal.ra
                if (r1 == 0) goto L_0x0053
                r1 = r0
                com.umlaut.crowd.internal.ra r1 = (com.umlaut.crowd.internal.ra) r1
                long r4 = r1.b
                int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r1 >= 0) goto L_0x0053
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                long r0 = r0.H
                float r0 = (float) r0
                com.umlaut.crowd.internal.db r1 = r10.b
                com.umlaut.crowd.internal.ra r1 = (com.umlaut.crowd.internal.ra) r1
                long r1 = r1.b
                goto L_0x0035
            L_0x0053:
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_TCPDOWNLOAD
                if (r0 == r1) goto L_0x008b
                com.umlaut.crowd.internal.db r0 = r10.b
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_TCPUPLOAD
                if (r0 != r1) goto L_0x0066
                goto L_0x008b
            L_0x0066:
                com.umlaut.crowd.internal.db r0 = r10.b
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_TCPDOWNLOAD_SIZE
                if (r0 == r1) goto L_0x007d
                com.umlaut.crowd.internal.db r0 = r10.b
                com.umlaut.crowd.internal.ja r0 = r0.a()
                com.umlaut.crowd.internal.ja r1 = com.umlaut.crowd.internal.ja.TEST_TCPUPLOAD_SIZE
                if (r0 != r1) goto L_0x007b
                goto L_0x007d
            L_0x007b:
                r0 = 0
                goto L_0x0098
            L_0x007d:
                com.umlaut.crowd.internal.v r0 = com.umlaut.crowd.internal.v.this
                long r0 = r0.H
                float r0 = (float) r0
                com.umlaut.crowd.internal.db r1 = r10.b
                com.umlaut.crowd.internal.fb r1 = (com.umlaut.crowd.internal.fb) r1
                long r1 = r1.payloadsize
                goto L_0x0035
            L_0x008b:
                int r0 = r10.c
                int r0 = r0 + 1
                float r0 = (float) r0
                com.umlaut.crowd.internal.v r1 = com.umlaut.crowd.internal.v.this
                int r1 = r1.v
                float r1 = (float) r1
                goto L_0x0036
            L_0x0098:
                r1 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r2 <= 0) goto L_0x00a0
                r0 = 1065353216(0x3f800000, float:1.0)
            L_0x00a0:
                long r1 = r10.a
                com.umlaut.crowd.internal.v r3 = com.umlaut.crowd.internal.v.this
                int r3 = r3.u
                long r3 = (long) r3
                com.umlaut.crowd.internal.l7 r5 = com.umlaut.crowd.InsightCore.getRadioController()
                com.umlaut.crowd.internal.DRI r5 = r5.getRadioInfoForDefaultDataSim()
                com.umlaut.crowd.internal.ee r6 = com.umlaut.crowd.InsightCore.getWifiController()
                com.umlaut.crowd.internal.DWI r6 = r6.getWifiInfo()
                com.umlaut.crowd.internal.v r7 = com.umlaut.crowd.internal.v.this
                int r8 = r7.u
                long r8 = (long) r8
                long r7 = com.umlaut.crowd.internal.v.i((com.umlaut.crowd.internal.v) r7, (long) r8)
                com.umlaut.crowd.internal.g5 r1 = com.umlaut.crowd.internal.v9.a(r1, r3, r5, r6, r7)
                if (r1 != 0) goto L_0x00cb
                return
            L_0x00cb:
                com.umlaut.crowd.internal.db r2 = r10.b
                com.umlaut.crowd.internal.ja r2 = r2.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_TCPDOWNLOAD
                if (r2 == r3) goto L_0x00eb
                com.umlaut.crowd.internal.db r2 = r10.b
                com.umlaut.crowd.internal.ja r2 = r2.a()
                com.umlaut.crowd.internal.ja r3 = com.umlaut.crowd.internal.ja.TEST_TCPDOWNLOAD_SIZE
                if (r2 == r3) goto L_0x00eb
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.internal.RP3 r2 = r2.e
                com.umlaut.crowd.internal.m5 r2 = r2.MeasurementType
                com.umlaut.crowd.internal.m5 r3 = com.umlaut.crowd.internal.m5.HTTP_FILE_UPLOAD
                if (r2 != r3) goto L_0x00f4
            L_0x00eb:
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this
                java.util.ArrayList r2 = r2.i
                r2.add(r1)
            L_0x00f4:
                com.umlaut.crowd.internal.v r2 = com.umlaut.crowd.internal.v.this
                com.umlaut.crowd.speedtest.IBandwidthListener r2 = r2.a
                long r3 = r1.ThroughputRate
                r2.onTransferProgress(r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v.i.run():void");
        }
    }

    class j implements Runnable {
        final /* synthetic */ long[] a;
        final /* synthetic */ db b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;

        j(long[] jArr, db dbVar, long j, long j2) {
            this.a = jArr;
            this.b = dbVar;
            this.c = j;
            this.d = j2;
        }

        public void run() {
            long[] jArr = this.a;
            if (jArr == null || jArr.length < 2) {
                if (v.this.O != null) {
                    try {
                        if (this.b.a() == ja.TEST_TCPUPLOAD_SIZE) {
                            v.this.O.f = false;
                        }
                        v.this.O.join();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (this.b.a() == ja.TEST_TCPUPLOAD || this.b.a() == ja.TEST_TCPUPLOAD_SIZE) {
                if (this.c > this.d) {
                    ((u) v.this.e).MeasurementDuration = (int) (this.c - this.d);
                }
                if (v.this.O != null) {
                    try {
                        if (this.b.a() == ja.TEST_TCPUPLOAD_SIZE) {
                            v.this.O.f = false;
                        }
                        v.this.O.join();
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
                long unused = v.this.H = 0;
                int i = 0;
                for (long j : this.a) {
                    DRI a2 = v9.a(i, v.this.u, (List<DRI>) v.this.n);
                    DWI b2 = v9.b(i, v.this.u, v.this.o);
                    ArrayList G = v.this.j;
                    long Z = (long) v.this.u;
                    i += v.this.u;
                    G.add(v9.a(j, Z, a2, b2, (long) i));
                    v.d(v.this, j);
                }
            }
        }
    }

    class k implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ na b;
        final /* synthetic */ int c;

        k(long j, na naVar, int i) {
            this.a = j;
            this.b = naVar;
            this.c = i;
        }

        public void run() {
            float f;
            float f2;
            long j;
            v.this.k.putAll(v.c());
            v.d(v.this, this.a);
            ja a2 = this.b.a();
            ja jaVar = ja.TEST_FTPDOWNPERIOD;
            if (a2 == jaVar || this.b.a() == ja.TEST_FTPUPPERIOD) {
                f2 = (float) (this.c + 1);
                f = (float) v.this.v;
            } else {
                if (this.b.a() == ja.TEST_FTPDOWNFILESIZE) {
                    f2 = (float) v.this.H;
                    j = ((la) this.b).fileSize;
                } else {
                    f2 = (float) v.this.H;
                    j = ((oa) this.b).fileSize;
                }
                f = (float) j;
            }
            float f3 = f2 / f;
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            DRI radioInfoForDefaultDataSim = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
            DWI wifiInfo = InsightCore.getWifiController().getWifiInfo();
            v vVar = v.this;
            g5 a3 = v9.a(this.a, (long) v.this.u, radioInfoForDefaultDataSim, wifiInfo, v.i(vVar, (long) vVar.u));
            if (a3 != null) {
                if (this.b.a() == jaVar || this.b.a() == ja.TEST_FTPDOWNFILESIZE) {
                    v.this.i.add(a3);
                }
                v.this.a.onTransferProgress(f3, a3.ThroughputRate);
            }
        }
    }

    class l implements Runnable {
        final /* synthetic */ long[] a;
        final /* synthetic */ na b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;

        l(long[] jArr, na naVar, long j, long j2) {
            this.a = jArr;
            this.b = naVar;
            this.c = j;
            this.d = j2;
        }

        public void run() {
            long[] jArr = this.a;
            if (jArr != null && jArr.length >= 1) {
                ja a2 = this.b.a();
                ja jaVar = ja.TEST_FTPUPFILESIZE;
                if (a2 == jaVar || this.b.a() == ja.TEST_FTPUPPERIOD) {
                    ((u) v.this.e).MeasurementDuration = (int) (this.c - this.d);
                    if (v.this.O != null) {
                        try {
                            if (this.b.a() == jaVar) {
                                v.this.O.f = false;
                            }
                            v.this.O.join();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    long unused = v.this.H = 0;
                    int i = 0;
                    for (long j : this.a) {
                        DRI a3 = v9.a(i, v.this.u, (List<DRI>) v.this.n);
                        DWI b2 = v9.b(i, v.this.u, v.this.o);
                        ArrayList G = v.this.j;
                        long Z = (long) v.this.u;
                        i += v.this.u;
                        G.add(v9.a(j, Z, a3, b2, (long) i));
                        v.d(v.this, j);
                    }
                    ((u) v.this.e).a(v.this.j);
                    ((u) v.this.e).BytesTransmitted = v.this.H;
                }
            } else if (v.this.O != null) {
                try {
                    if (this.b.a() == ja.TEST_FTPUPFILESIZE) {
                        v.this.O.f = false;
                    }
                    v.this.O.join();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private class m extends AsyncTask<Void, Void, p4> {
        /* access modifiers changed from: private */
        public x6 a;
        private String b;
        /* access modifiers changed from: private */
        public final int c;
        private int d;
        /* access modifiers changed from: private */
        public final int e;
        private final int f;
        private final String[] g;
        private final z4 h;
        private final boolean i;
        private final m5 j;
        private final int k;
        private final a l;
        final boolean[] m = {false};
        final int[] n = {0};
        final HashMap<Object, w2> o = new HashMap<>();

        class a implements Comparator<LC> {
            a() {
            }

            /* renamed from: a */
            public int compare(LC lc, LC lc2) {
                return lc.successfulTests - lc2.successfulTests;
            }
        }

        class b implements Comparator<LC> {
            b() {
            }

            /* renamed from: a */
            public int compare(LC lc, LC lc2) {
                return lc.totalTests - lc2.totalTests;
            }
        }

        class c implements w6 {
            private final ArrayList<e5> a;

            public c(ArrayList<e5> arrayList) {
                this.a = arrayList;
            }

            public void a() {
                v.this.a.onTestStatusChanged(SpeedtestEngineStatus.RUN, SpeedtestEngineError.OK, ((long) m.this.c) * ((long) m.this.e));
            }

            public void b(int i, long j, long j2) {
                if (m.this.isCancelled()) {
                    m.this.a.a();
                    return;
                }
                if (j2 >= 0) {
                    m mVar = m.this;
                    boolean z = true;
                    mVar.m[0] = true;
                    int[] iArr = mVar.n;
                    iArr[0] = iArr[0] + 1;
                    synchronized (this.a) {
                        Iterator<e5> it = this.a.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            e5 next = it.next();
                            if (next.Delta == j) {
                                next.Rtt = (int) j2;
                                break;
                            }
                        }
                        if (!z) {
                            this.a.add(m.this.a(j, (int) j2));
                        }
                    }
                }
                m.this.o.putAll(v.c());
                v.this.a.onPingProgress(((float) i) / ((float) m.this.c), Math.max((int) j2, 0));
            }

            public void a(int i, long j) {
                boolean z;
                if (m.this.isCancelled()) {
                    m.this.a.a();
                    return;
                }
                synchronized (this.a) {
                    Iterator<e5> it = this.a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().Delta == j) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        this.a.add(m.this.a(j, -1));
                    }
                }
            }

            public void a(int i, long j, long j2) {
                if (m.this.isCancelled()) {
                    m.this.a.a();
                }
            }
        }

        public m(String str, int i2, int i3, int i4, int i5, boolean z, m5 m5Var, int i6, a aVar) {
            v.this.f();
            this.b = str;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.i = z;
            this.j = m5Var;
            this.k = i6;
            this.l = aVar;
            if (i3 < 200) {
                this.d = 200;
            }
            v.this.a.onTestStatusChanged(SpeedtestEngineStatus.CONNECT, SpeedtestEngineError.OK, ((long) i2) * ((long) i4));
            IS insightSettings = InsightCore.getInsightSettings();
            this.g = insightSettings.l();
            this.h = z4.valueOf(insightSettings.k());
        }

        private boolean d(p4 p4Var, ArrayList<e5> arrayList) {
            ha haVar = new ha(v.this.b, new c(arrayList), p4Var.Server, this.c, this.d, this.e, this.k, p4Var.ServerUrl);
            this.a = haVar;
            return haVar.a(p4Var);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
            x6 x6Var = this.a;
            if (x6Var != null) {
                x6Var.a();
            }
            v.a((Object) v.this);
            v.this.a.onTestStatusChanged(SpeedtestEngineStatus.ABORTED, SpeedtestEngineError.OK, 0);
        }

        private boolean b(p4 p4Var, ArrayList<e5> arrayList) {
            ia iaVar = new ia(v.this.b, new c(arrayList), p4Var.Server, this.c, this.d, this.e, this.k, p4Var.ServerUrl);
            this.a = iaVar;
            return iaVar.a(p4Var);
        }

        private boolean c(p4 p4Var, ArrayList<e5> arrayList) {
            v3 v3Var = new v3(v.this.b, new c(arrayList), p4Var.Server, this.c, this.d, this.e, this.f);
            this.a = v3Var;
            return v3Var.a(p4Var);
        }

        private boolean a(p4 p4Var, ArrayList<e5> arrayList) {
            id idVar = new id(v.this.b, new c(arrayList), this.b, this.c, this.d, this.e, this.k);
            this.a = idVar;
            return idVar.a(p4Var);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public p4 doInBackground(Void... voidArr) {
            List<LC> list;
            v.a((Object) v.this, w2.LTR);
            if (isCancelled()) {
                return null;
            }
            if (this.j == m5.IPING) {
                list = a(this.g, this.h, this.b);
            } else {
                list = a(this.g, z4.CTItem, this.b);
            }
            p4 p4Var = null;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long uptimeMillis = SystemClock.uptimeMillis();
                LC lc = list.get(i2);
                lc.totalTests++;
                this.b = lc.address;
                ArrayList arrayList = new ArrayList();
                p4 p4Var2 = new p4(v.this.L, v.this.M.q());
                p4Var2.Trigger = this.l;
                if (InsightCore.getInsightConfig().L0()) {
                    p4Var2.CellInfoOnStart = InsightCore.getRadioController().d();
                }
                p4Var2.WifiInfoOnStart = InsightCore.getWifiController().getWifiInfo();
                p4Var2.RadioInfoOnStart = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
                if (v.this.f0) {
                    g3 a2 = g3.a(v.this.b);
                    DRI dri = p4Var2.RadioInfoOnStart;
                    p4Var2.IspInfo = a2.a(dri, p4Var2.WifiInfoOnStart, g3.a(dri.ConnectionType));
                }
                p4Var2.BatteryInfoOnStart = v.this.d.a();
                p4Var2.ScreenStateOnStart = CDC.f(v.this.b);
                ub timeInfo = TimeServer.getTimeInfo();
                p4Var2.TimeInfoOnStart = timeInfo;
                p4Var2.LtrId = k3.a(timeInfo, p4Var2.GUID);
                p4Var2.MemoryInfoOnStart = CDC.d(v.this.b);
                p4Var2.TrafficInfoOnStart = CDC.f();
                p4Var2.DeviceInfo = CDC.getDeviceInfo(v.this.b);
                p4Var2.IsAppInForeground = InsightCore.getForegroundTestManager().d();
                p4Var2.Pings = this.c;
                p4Var2.Pause = this.d;
                p4Var2.CallStateOnStart = ud.a(v.this.b);
                p4Var2.LocationInfoOnStart = v.this.c.getLastLocationInfo();
                if (!v.this.e0.isEmpty()) {
                    p4Var2.ServerUrl = v.this.e0;
                } else {
                    p4Var2.ServerUrl = this.b;
                }
                try {
                    InetAddress inetAddress = f2.a().a(this.b, this.e, true).d()[0];
                    if (inetAddress instanceof Inet6Address) {
                        p4Var2.IpVersion = d4.IPv6;
                    } else {
                        p4Var2.IpVersion = d4.IPv4;
                    }
                    p4Var2.Server = inetAddress.getHostAddress();
                } catch (UnknownHostException unused) {
                    p4Var2.Server = this.b;
                }
                m5 m5Var = this.j;
                p4Var2.MeasurementType = m5Var;
                if (m5Var == m5.IPING || m5Var == m5.ICMP_PING) {
                    if (!c(p4Var2, arrayList)) {
                        return null;
                    }
                } else if (m5Var == m5.TCP_PING) {
                    if (!d(p4Var2, arrayList)) {
                        return null;
                    }
                } else if (m5Var == m5.HTTP_PING) {
                    if (!b(p4Var2, arrayList)) {
                        return null;
                    }
                } else if (m5Var != m5.UDP_DNS_PING || !a(p4Var2, (ArrayList<e5>) arrayList)) {
                    return null;
                }
                p4Var2.TestEndState = t9.Finish;
                SpeedtestEngineError speedtestEngineError = SpeedtestEngineError.OK;
                p4Var2.TestErrorReasonType = speedtestEngineError;
                p4Var2.TestErrorReason = speedtestEngineError.name();
                p4Var2.Success = this.m[0];
                p4Var2.SuccessfulPings = this.n[0];
                p4Var2.TestsInProgress = aa.a(new ArrayList(this.o.values()), AbstractJsonLexerKt.COMMA, true);
                if (arrayList.size() > 0) {
                    p4Var2.a(arrayList);
                }
                if (InsightCore.getInsightConfig().L0()) {
                    p4Var2.CellInfoOnEnd = InsightCore.getRadioController().d();
                }
                p4Var2.BatteryInfoOnEnd = v.this.d.a();
                p4Var2.LocationInfoOnEnd = v.this.c.getLastLocationInfo();
                p4Var2.ScreenStateOnEnd = CDC.f(v.this.b);
                p4Var2.MemoryInfoOnEnd = CDC.d(v.this.b);
                p4Var2.TimeInfoOnEnd = TimeServer.getTimeInfo();
                p4Var2.TrafficInfoOnEnd = CDC.f();
                p4Var2.DurationOverallNoSleep = SystemClock.uptimeMillis() - uptimeMillis;
                p4Var2.DurationOverall = SystemClock.elapsedRealtime() - elapsedRealtime;
                p4Var2.CallStateOnEnd = ud.a(v.this.b);
                String c2 = f9.c(this.b);
                p4Var2.Rdns = c2;
                if (c2.equals(p4Var2.Server) && !v.this.e0.isEmpty()) {
                    p4Var2.Rdns = v.this.e0;
                }
                p4Var2.AirportCode = this.h == z4.CTItem ? v.this.d0 : f9.a(p4Var2.Rdns);
                p4Var2.WifiInfoOnEnd = InsightCore.getWifiController().getWifiInfo();
                p4Var2.RadioInfoOnEnd = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
                if (v.this.f0 && !p4Var2.IspInfo.SuccessfulIspLookup) {
                    p4Var2.IspInfo = g3.a(v.this.b).a(p4Var2.RadioInfoOnStart, p4Var2.WifiInfoOnStart, false);
                }
                if (this.m[0]) {
                    lc.successfulTests++;
                    p4Var = p4Var2;
                    break;
                } else if (isCancelled()) {
                    return null;
                } else {
                    i2++;
                    p4Var = p4Var2;
                }
            }
            if (this.h != z4.CTItem) {
                a(list);
            }
            if (InsightCore.getInsightConfig().A() && p4Var != null) {
                p4Var.LocationInfoOnStart = new q4();
                p4Var.LocationInfoOnEnd = new q4();
            }
            return p4Var;
        }

        /* access modifiers changed from: private */
        public e5 a(long j2, int i2) {
            e5 e5Var = new e5();
            e5Var.Delta = j2;
            DRI radioInfoForDefaultDataSim = InsightCore.getRadioController().getRadioInfoForDefaultDataSim();
            e5Var.DisplayNetworkType = radioInfoForDefaultDataSim.DisplayNetworkType;
            e5Var.ConnectionType = radioInfoForDefaultDataSim.ConnectionType;
            e5Var.NetworkType = radioInfoForDefaultDataSim.NetworkType;
            e5Var.NrAvailable = radioInfoForDefaultDataSim.NrAvailable;
            e5Var.NrState = radioInfoForDefaultDataSim.NrState;
            e5Var.RxLev = radioInfoForDefaultDataSim.RXLevel;
            e5Var.Rtt = i2;
            return e5Var;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(p4 p4Var) {
            super.onPostExecute(p4Var);
            v.a((Object) v.this);
            if (p4Var != null) {
                RP3 unused = v.this.e = p4Var;
                if (this.i && InsightCore.isInitialized() && InsightCore.getDatabaseHelper() != null) {
                    v.this.g();
                }
                v.this.a.onTestStatusChanged(SpeedtestEngineStatus.END, SpeedtestEngineError.OK, 0);
                return;
            }
            v.this.a.onTestStatusChanged(SpeedtestEngineStatus.ABORTED, SpeedtestEngineError.OK, 0);
        }

        private void a(List<LC> list) {
            HashSet hashSet = new HashSet();
            for (LC lc : list) {
                hashSet.add(lc.toString());
            }
            InsightCore.getInsightSettings().d((Set<String>) hashSet);
        }

        private List<LC> a(String[] strArr, z4 z4Var, String str) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            Set<String> s = InsightCore.getInsightSettings().s();
            LinkedList<LC> linkedList3 = new LinkedList<>();
            if (s != null) {
                for (String fromJson : s) {
                    LC lc = (LC) JsonUtils.fromJson(fromJson, LC.class);
                    if (lc != null) {
                        linkedList3.add(lc);
                    }
                }
            }
            for (String str2 : strArr) {
                LC lc2 = new LC();
                lc2.address = str2;
                linkedList2.add(lc2);
            }
            for (LC lc3 : linkedList3) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (strArr[i2].equals(lc3.address)) {
                        linkedList2.set(i2, lc3);
                    }
                }
            }
            int i3 = c.b[z4Var.ordinal()];
            if (i3 == 1) {
                LC lc4 = new LC();
                lc4.address = str;
                linkedList.add(lc4);
                return linkedList;
            } else if (i3 == 2) {
                return linkedList2;
            } else {
                if (i3 == 3) {
                    Collections.shuffle(linkedList2, new Random(System.nanoTime()));
                    return new LinkedList(linkedList2);
                } else if (i3 == 4) {
                    Collections.sort(linkedList2, new a());
                    return new LinkedList(linkedList2);
                } else if (i3 != 5) {
                    return linkedList;
                } else {
                    Collections.sort(linkedList2, new b());
                    return new LinkedList(linkedList2);
                }
            }
        }
    }

    private static class n extends Thread {
        private final ja a;
        private final int b;
        private final int c;
        ArrayList<DRI> d;
        ArrayList<DWI> e;
        public boolean f = true;

        public n(ja jaVar, int i, int i2, ArrayList<DRI> arrayList, ArrayList<DWI> arrayList2) {
            this.a = jaVar;
            this.b = i2;
            this.c = i;
            this.d = arrayList;
            this.e = arrayList2;
        }

        public void run() {
            ja jaVar = this.a;
            if (jaVar == ja.TEST_TCPUPLOAD_SIZE || jaVar == ja.TEST_FTPUPFILESIZE || jaVar == ja.TEST_UDP_FIXEDSENDDATA || jaVar == ja.TEST_UDP_FIXEDRECEIVEDATA) {
                while (this.f) {
                    this.d.add(InsightCore.getRadioController().getRadioInfoForDefaultDataSim());
                    this.e.add(InsightCore.getWifiController().getWifiInfo());
                    try {
                        Thread.sleep((long) this.b);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                return;
            }
            int i = 0;
            while (i < this.c) {
                this.d.add(InsightCore.getRadioController().getRadioInfoForDefaultDataSim());
                this.e.add(InsightCore.getWifiController().getWifiInfo());
                if (this.f) {
                    try {
                        Thread.sleep((long) this.b);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public v(IBandwidthListener iBandwidthListener, Context context) {
        if (iBandwidthListener != null) {
            this.a = iBandwidthListener;
            this.b = context;
            IC insightConfig = InsightCore.getInsightConfig();
            this.L = insightConfig.f1();
            this.M = new IS(context);
            a(context, insightConfig);
            return;
        }
        throw new IllegalArgumentException("ISpeedtestListener is NULL");
    }

    static /* synthetic */ long U(v vVar) {
        long j2 = vVar.E + 1;
        vVar.E = j2;
        return j2;
    }

    static /* synthetic */ long X(v vVar) {
        long j2 = vVar.F + 1;
        vVar.F = j2;
        return j2;
    }

    public void b(na naVar, long j2) {
    }

    public boolean b(ta[] taVarArr) {
        return false;
    }

    public void onTestStatusChanged(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j2) {
        if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ERROR) {
            ac b2 = this.f.b();
            b2.AirportCode = this.d0;
            if (b2.Rdns.equals(b2.Server) && !this.e0.isEmpty()) {
                b2.Rdns = this.e0;
            }
            if (!this.e0.isEmpty()) {
                b2.ServerUrl = this.e0;
            } else {
                b2.ServerUrl = b2.Server;
            }
            this.e = b2;
            g();
        }
        this.a.onTestStatusChanged(speedtestEngineStatus, speedtestEngineError, j2);
    }

    public void onTracerouteProgress(float f2, String str, int i2, int i3) {
        this.a.onTracerouteProgress(f2, str, i2, i3);
    }

    static /* synthetic */ long i(v vVar, long j2) {
        long j3 = vVar.J + j2;
        vVar.J = j3;
        return j3;
    }

    static /* synthetic */ long d(v vVar, long j2) {
        long j3 = vVar.H + j2;
        vVar.H = j3;
        return j3;
    }

    static /* synthetic */ long e(v vVar, long j2) {
        long j3 = vVar.H - j2;
        vVar.H = j3;
        return j3;
    }

    public void d(String str) {
        this.e0 = str;
    }

    public void e(String str) {
        this.Y = str;
    }

    public void f(String str) {
        this.b0 = str;
    }

    public void g(String str) {
        this.X = str;
    }

    public void h() {
        a(CLC.ProviderMode.GpsAndNetwork);
    }

    public void i() {
        CLC clc = this.c;
        if (clc != null) {
            clc.stopListening();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        this.i = new ArrayList<>();
        this.h = new ArrayList<>();
        this.j = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.k = new HashMap<>();
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
        this.K = true;
        this.J = 0;
        this.H = 0;
        this.E = 0;
        this.F = 0;
    }

    /* access modifiers changed from: private */
    public void g() {
        jd jdVar;
        ac acVar;
        p4 p4Var;
        u uVar;
        RP3 rp3 = this.e;
        if (rp3 != null) {
            if (this.f0 && !rp3.IspInfo.SuccessfulIspLookup) {
                g3 a2 = g3.a(this.b);
                RP3 rp32 = this.e;
                rp3.IspInfo = a2.a(rp32.RadioInfoOnStart, rp32.WifiInfoOnStart, false);
            }
            RP3 rp33 = this.e;
            rp33.Meta = this.X;
            rp33.CampaignId = this.Y;
            rp33.SequenceID = this.c0;
            rp33.CustomerID = this.b0;
            rp33.IMEI = this.a0;
            rp33.IMSI = this.Z;
            rp33.QuestionAnswerList = (k7[]) this.g.toArray(new k7[0]);
            this.e.QuestionnaireName = aa.a(this.V);
            if (this.g0) {
                RP3 rp34 = this.e;
                String str = "saveResult";
                if (rp34 instanceof u) {
                    try {
                        uVar = (u) rp34.clone();
                    } catch (CloneNotSupportedException e2) {
                        Log.e(m0, str, e2);
                        uVar = (u) this.e;
                    }
                    InsightCore.getDatabaseHelper().a(w2.BWR, (RBR) uVar);
                } else if (rp34 instanceof p4) {
                    try {
                        p4Var = (p4) rp34.clone();
                    } catch (CloneNotSupportedException e3) {
                        Log.e(m0, str, e3);
                        p4Var = (p4) this.e;
                    }
                    InsightCore.getDatabaseHelper().a(w2.LTR, (RBR) p4Var);
                } else if (rp34 instanceof ac) {
                    try {
                        acVar = (ac) rp34.clone();
                    } catch (CloneNotSupportedException e4) {
                        Log.e(m0, str, e4);
                        acVar = (ac) this.e;
                    }
                    InsightCore.getDatabaseHelper().a(w2.TRC, (RBR) acVar);
                } else if (rp34 instanceof jd) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < this.l.size()) {
                        DRI a3 = v9.a(i3, this.w, (List<DRI>) this.p);
                        DWI b2 = v9.b(i3, this.w, this.r);
                        j7 j7Var = this.l.get(i2);
                        i3 += this.w;
                        arrayList.add(v9.a(j7Var.firstPkgTime, j7Var.lastPkgTime, ((jd) this.e).MeasurementPackageSizeClient, j7Var.pkgsReceived, j7Var.jitterSum, j7Var.jitterPkgCnt, a3, b2, i3));
                        i2++;
                        str = str;
                    }
                    String str2 = str;
                    ((jd) this.e).a(arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    for (int i5 = 0; i5 < this.m.size(); i5++) {
                        DRI a4 = v9.a(i4, this.x, (List<DRI>) this.q);
                        DWI b3 = v9.b(i4, this.x, this.s);
                        j7 j7Var2 = this.m.get(i5);
                        i4 += this.w;
                        arrayList2.add(v9.a(j7Var2.firstPkgTime, j7Var2.lastPkgTime, ((jd) this.e).MeasurementPackageSizeServer, j7Var2.pkgsReceived, j7Var2.jitterSum, j7Var2.jitterPkgCnt, a4, b3, i4));
                    }
                    ((jd) this.e).b(arrayList2);
                    try {
                        jdVar = (jd) this.e.clone();
                    } catch (CloneNotSupportedException e5) {
                        Log.e(m0, str2, e5);
                        jdVar = (jd) this.e;
                    }
                    InsightCore.getDatabaseHelper().a(w2.UTR, (RBR) jdVar);
                }
            }
        }
    }

    public void c(String str) {
        this.d0 = str;
    }

    public boolean d() {
        return InsightCore.getRadioController().l();
    }

    public boolean e() {
        return this.h0;
    }

    public void h(String str) {
        this.c0 = str;
    }

    public RP3 b() {
        try {
            return (RP3) this.e.clone();
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.e;
        }
    }

    public void c(String str, int i2, int i3, int i4, int i5, a aVar) {
        a(str, i2, i3, i4, 0, true, m5.UDP_DNS_PING, i5, aVar);
    }

    public void i(String str) {
        this.V = str;
    }

    public void c(na naVar, long j2) {
        this.I = j2;
    }

    public static synchronized HashMap<Object, w2> c() {
        HashMap<Object, w2> hashMap;
        synchronized (v.class) {
            hashMap = o0;
        }
        return hashMap;
    }

    public void b(boolean z2) {
        this.h0 = z2;
    }

    private d4 b(String str) {
        try {
            if (InetAddress.getByName(str) instanceof Inet6Address) {
                return d4.IPv6;
            }
            return d4.IPv4;
        } catch (UnknownHostException unused) {
            return d4.Unknown;
        }
    }

    private void a(Context context, IC ic) {
        this.c = new CLC(this.b);
        this.d = new x(this.b);
        this.f = new bc(this.b, this, this.c);
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.k = new HashMap<>();
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
        if (ic.v() && this.b.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT < 29) {
                    this.a0 = aa.a(telephonyManager.getDeviceId());
                    this.Z = aa.a(telephonyManager.getSubscriberId());
                } else if (this.b.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") == 0) {
                    PackageManager packageManager = this.b.getPackageManager();
                    if (packageManager.hasSystemFeature("android.hardware.telephony.gsm")) {
                        this.a0 = aa.a(telephonyManager.getImei());
                    } else if (packageManager.hasSystemFeature("android.hardware.telephony.cdma")) {
                        this.a0 = aa.a(telephonyManager.getMeid());
                    }
                    this.Z = aa.a(telephonyManager.getSubscriberId());
                }
            } catch (Exception e2) {
                Log.e(m0, e2.toString());
            }
        }
    }

    public void b(String str, int i2, int i3, int i4, int i5, a aVar) {
        a(str, i2, i3, i4, 0, true, m5.HTTP_PING, i5, aVar);
    }

    public void b(db dbVar, long j2) {
        m5 m5Var;
        if (dbVar.a() == ja.TEST_TCPDOWNLOAD || dbVar.a() == ja.TEST_TCPDOWNLOAD_SIZE || dbVar.a() == ja.TEST_TCPUPLOAD_SIZE || (m5Var = this.e.MeasurementType) == m5.HTTP_FILE_DOWNLOAD || m5Var == m5.HTTP_FILE_UPLOAD) {
            ((u) this.e).MeasurementDuration = (int) (j2 - this.I);
        }
    }

    public void b(kb kbVar, tc.a aVar, j7 j7Var, int i2, j7[] j7VarArr) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b(kbVar, j7Var, aVar, i2, j7VarArr));
    }

    public void a(CLC.ProviderMode providerMode) {
        if (this.c == null) {
            return;
        }
        if (InsightCore.getWifiController().getWifiInfo().WifiSSID.equals(InsightCore.getInsightConfig().h1())) {
            this.c.startListening(CLC.ProviderMode.RailNet);
        } else {
            this.c.startListening(providerMode);
        }
    }

    public void a(String str) {
        ArrayList<k7> arrayList = this.g;
        arrayList.add(new k7(arrayList.size() + 1, str));
    }

    public void a(boolean z2) {
        this.f0 = z2;
    }

    public void a(sa saVar, m5 m5Var, a aVar) {
        a(saVar, m5Var, true, aVar);
    }

    public void a(sa saVar, m5 m5Var, boolean z2, a aVar) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new d(saVar, m5Var, z2, aVar));
    }

    public void a() {
        AsyncTask<Void, Void, p4> asyncTask = this.W;
        if (asyncTask != null) {
            asyncTask.cancel(false);
        }
        bc bcVar = this.f;
        if (bcVar != null) {
            bcVar.a();
        }
        Thread thread = new Thread(new e());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void a(sa[] saVarArr) {
        wa e2;
        String W0 = InsightCore.getInsightConfig().W0();
        this.e.IpVersion = b(W0);
        if (saVarArr != null && saVarArr.length > 0 && (e2 = saVarArr[0].e()) != null) {
            this.e.Server = a(e2.ips);
        }
    }

    private String a(String[] strArr) {
        String str = "";
        if (strArr == null) {
            return str;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (String str2 : strArr) {
            try {
                InetAddress byName = InetAddress.getByName(str2);
                if (byName instanceof Inet6Address) {
                    str = str + str2 + ",";
                    z3 = true;
                } else if (byName instanceof Inet4Address) {
                    str = str + str2 + ",";
                    z2 = true;
                }
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
            }
        }
        RP3 rp3 = this.e;
        m5 m5Var = rp3.MeasurementType;
        if (m5Var == m5.HTTP_FILE_DOWNLOAD || m5Var == m5.HTTP_FILE_UPLOAD) {
            rp3.IpVersion = d4.Unknown;
            if (z2 && !z3) {
                rp3.IpVersion = d4.IPv4;
            } else if (!z2 && z3) {
                rp3.IpVersion = d4.IPv6;
            }
        }
        return str.contains(",") ? str.substring(0, str.length() - 1) : str;
    }

    /* access modifiers changed from: private */
    public s6 a(sa[] saVarArr, k2 k2Var, int i2, m5 m5Var, boolean z2, boolean z3, int i3) {
        int i4;
        t6 t6Var = new t6();
        t6Var.a = InsightCore.getInsightConfig().W0();
        t6Var.c = z2;
        t6Var.h = z3;
        t6Var.i = i3;
        t6Var.g = i2;
        t6Var.d = new ta[1];
        for (gb gbVar : saVarArr) {
            if (gbVar.a() == ja.TEST_TCPDOWNLOAD || gbVar.a() == ja.TEST_TCPDOWNLOAD_SIZE || gbVar.a() == ja.TEST_TCPUPLOAD || gbVar.a() == ja.TEST_TCPUPLOAD_SIZE) {
                t6Var.d[0] = new ga((db) gbVar, this);
            } else if (gbVar.a() == ja.TEST_TCPPING) {
                t6Var.d[0] = new da(gbVar, this);
            } else if (gbVar.a() == ja.TEST_FTPDOWNFILESIZE || gbVar.a() == ja.TEST_FTPDOWNPERIOD || gbVar.a() == ja.TEST_FTPUPFILESIZE || gbVar.a() == ja.TEST_FTPUPPERIOD) {
                if (m5Var == m5.FTPS_FD || m5Var == m5.FTPS_FT) {
                    na naVar = (na) gbVar;
                    naVar.controlEncryption = na.a.EXPLICIT;
                    naVar.dataEncryption = na.b.PRIVATE;
                }
                t6Var.d[0] = new t2((na) gbVar, this);
            } else if (gbVar.a() == ja.TEST_UDP_FIXEDRECEIVEDATA || gbVar.a() == ja.TEST_UDP_FIXEDSENDDATA || gbVar.a() == ja.TEST_UDP_FIXEDTIMEFRAME) {
                kb kbVar = (kb) gbVar;
                uc ucVar = new uc(kbVar, this);
                xc xcVar = kbVar.pkgDown;
                xc xcVar2 = kbVar.pkgUp;
                if (xcVar != null) {
                    i4 = xcVar.pkgInterval;
                } else {
                    i4 = xcVar2 != null ? xcVar2.pkgInterval : 1000;
                }
                ucVar.a((long) i4);
                t6Var.d[0] = ucVar;
            }
        }
        return new s6(t6Var, k2Var);
    }

    public void a(x7[] x7VarArr) {
        ((u) this.e).ResponseHeaders = x7VarArr;
    }

    public void a(int i2) {
        this.N = i2;
    }

    public void a(String str, int i2, int i3, int i4, int i5, boolean z2, boolean z3, a aVar) {
        m5 m5Var = m5.ICMP_PING;
        if (z2) {
            m5Var = m5.IPING;
        }
        a(str, i2, i3, i4, i5, z3, m5Var, 0, aVar);
    }

    public void a(String str, int i2, int i3, int i4, int i5, a aVar) {
        a(str, i2, i3, i4, 0, true, m5.TCP_PING, i5, aVar);
    }

    private void a(String str, int i2, int i3, int i4, int i5, boolean z2, m5 m5Var, int i6, a aVar) {
        this.g = new ArrayList<>();
        this.W = new m(str, i2, i3, i4, i5, z2, m5Var, i6, aVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void a(r5 r5Var, String str) {
        this.e.TestErrorReasonType = v9.a(r5Var);
        RP3 rp3 = this.e;
        rp3.TestErrorReason = a(rp3.TestErrorReasonType.name(), str);
    }

    private String a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            str = str + " - " + str2;
        }
        return str.length() > 250 ? str.substring(0, 250) : str;
    }

    public void a(l2 l2Var) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new f(l2Var));
    }

    public void a(z1 z1Var) {
        if (z1Var == z1.CONTROL_CONNECTING) {
            this.e.TestEndState = t9.ConnectingToControlServer;
            this.a.onTestStatusChanged(SpeedtestEngineStatus.CONNECT_CONTROL, SpeedtestEngineError.OK, this.t);
            this.R = SystemClock.elapsedRealtime();
        } else if (z1Var == z1.CONTROL_REQUEST) {
            RP3 rp3 = this.e;
            rp3.TestEndState = t9.ConnectedToControlServer;
            rp3.ConnectingTimeControlServer = SystemClock.elapsedRealtime() - this.R;
            this.a.onTestStatusChanged(SpeedtestEngineStatus.REQUEST, SpeedtestEngineError.OK, this.t);
        }
    }

    public void a(t6 t6Var) {
        if (this.h0 && t6Var.g == 80) {
            this.e.MeasurementType = m5.HTTP;
        }
    }

    public boolean a(ta[] taVarArr) {
        RP3 rp3 = this.e;
        m5 m5Var = rp3.MeasurementType;
        if (m5Var == m5.HTTP_FILE_DOWNLOAD || m5Var == m5.HTTP_FILE_UPLOAD) {
            rp3.ConnectingTimeTestServerSockets = SystemClock.elapsedRealtime() - this.T;
            this.U = SystemClock.elapsedRealtime();
            this.e.TestEndState = t9.ConnectedToTestServer;
        }
        sa[] saVarArr = new sa[taVarArr.length];
        for (int i2 = 0; i2 < taVarArr.length; i2++) {
            saVarArr[i2] = taVarArr[i2].b();
        }
        a(saVarArr);
        return true;
    }

    public void a(sa saVar, r5 r5Var, String str) {
        this.e.TestErrorReasonType = v9.a(r5Var);
        RP3 rp3 = this.e;
        rp3.TestErrorReason = a(rp3.TestErrorReasonType.name(), str);
    }

    public void a(sa saVar, ab abVar) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new g(saVar, abVar));
    }

    public void a(gb gbVar, int i2, long j2) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new h(i2, j2));
    }

    public void a(db dbVar, int i2, long j2) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new i(j2, dbVar, i2));
    }

    public void a(db dbVar, int i2, long j2, long j3, long[] jArr) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new j(jArr, dbVar, j3, j2));
    }

    public void a(db dbVar, long j2) {
        this.I = j2;
    }

    public void a(na naVar, int i2, long j2) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new k(j2, naVar, i2));
    }

    public void a(na naVar, int i2, long j2, long j3, long[] jArr) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new l(jArr, naVar, j3, j2));
    }

    public void a(na naVar, long j2) {
        if (naVar.a() == ja.TEST_FTPDOWNFILESIZE || naVar.a() == ja.TEST_FTPDOWNPERIOD) {
            ((u) this.e).MeasurementDuration = (int) (j2 - this.I);
        }
    }

    public void a(kb kbVar, long j2) {
        ((jd) this.e).WelcomePackageDelay = j2;
    }

    public void a(kb kbVar, tc.a aVar, j7 j7Var, int i2, j7[] j7VarArr) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a(kbVar, j7Var, aVar, i2, j7VarArr));
    }

    public void a(String str, a aVar) {
        f();
        this.f.a(str, aVar);
    }

    public static synchronized void a(Object obj, w2 w2Var) {
        synchronized (v.class) {
            o0.put(obj, w2Var);
        }
    }

    public static synchronized void a(Object obj) {
        synchronized (v.class) {
            o0.remove(obj);
        }
    }
}
