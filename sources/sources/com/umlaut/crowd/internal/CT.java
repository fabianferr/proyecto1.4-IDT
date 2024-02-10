package com.umlaut.crowd.internal;

import android.content.Context;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.speedtest.IBandwidthListener;
import com.umlaut.crowd.speedtest.SpeedtestEngineError;
import com.umlaut.crowd.speedtest.SpeedtestEngineStatus;
import com.umlaut.crowd.utils.JsonUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CT implements IBandwidthListener {
    private static final boolean v = false;
    private static final String w = "CT";
    public static final int x = 30000;
    private static final String y = "\r\n";
    private Context a;
    private CLC b;
    private IS c;
    private y1 d;
    private OCTL e;
    private g1 f;
    private v g;
    InsightCore.OnConnectivityTestListener h;
    private String i;
    private String j;
    private String k;
    private String l;
    private Random m = new Random();
    private float n;
    private boolean o;
    private boolean p;
    private int q;
    private double r;
    private double s;
    private boolean t;
    /* access modifiers changed from: private */
    public x1 u;

    class a implements p3 {
        a() {
        }

        public void a(x1 x1Var) {
            if (x1Var != null) {
                x1 unused = CT.this.u = x1Var;
            }
        }
    }

    class b implements Comparator<CC> {
        b() {
        }

        /* renamed from: a */
        public int compare(CC cc, CC cc2) {
            return cc.DNSSuccess - cc2.DNSSuccess;
        }
    }

    class c implements Comparator<CC> {
        c() {
        }

        /* renamed from: a */
        public int compare(CC cc, CC cc2) {
            return cc.TCPSuccess - cc2.TCPSuccess;
        }
    }

    class d implements Comparator<CC> {
        d() {
        }

        /* renamed from: a */
        public int compare(CC cc, CC cc2) {
            return cc.successfulTests - cc2.successfulTests;
        }
    }

    class e implements Comparator<CC> {
        e() {
        }

        /* renamed from: a */
        public int compare(CC cc, CC cc2) {
            return cc.totalTests - cc2.totalTests;
        }
    }

    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.r1[] r0 = com.umlaut.crowd.internal.r1.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.r1 r1 = com.umlaut.crowd.internal.r1.NoChange     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.r1 r1 = com.umlaut.crowd.internal.r1.Random     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.r1 r1 = com.umlaut.crowd.internal.r1.DNSSuccessful     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.r1 r1 = com.umlaut.crowd.internal.r1.TCPSuccessful     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.r1 r1 = com.umlaut.crowd.internal.r1.FullSuccessful     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.internal.r1 r1 = com.umlaut.crowd.internal.r1.TotalTests     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CT.f.<clinit>():void");
        }
    }

    public CT(Context context) {
        this.a = context;
        this.c = new IS(context);
        IC insightConfig = InsightCore.getInsightConfig();
        this.i = insightConfig.f1();
        this.j = insightConfig.S();
        this.k = insightConfig.R();
        this.l = insightConfig.W();
        this.n = insightConfig.c0();
        this.o = insightConfig.P();
        this.p = insightConfig.m1();
        this.r = insightConfig.Z();
        this.q = insightConfig.b0();
        this.s = (double) insightConfig.a0();
        this.t = insightConfig.U();
        this.b = new CLC(context);
    }

    private void c() {
        this.b.startListening(InsightCore.getInsightConfig().X());
    }

    private void d() {
        this.b.stopListening();
    }

    private void e() {
        int i2 = 0;
        double d2 = 2.147483647E9d;
        long j2 = 2147483647L;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            q4 lastLocationInfo = this.b.getLastLocationInfo();
            double d3 = lastLocationInfo.LocationAccuracyHorizontal;
            if (d3 > 0.0d) {
                d2 = d3;
            }
            long j3 = lastLocationInfo.LocationAge;
            if (j3 > 0) {
                j2 = j3;
            }
            i2++;
            if (i2 * 1000 >= this.q) {
                return;
            }
            if (d2 <= this.r && ((double) j2) <= this.s) {
                return;
            }
        }
    }

    public void b(a aVar) {
        b();
        a(a(aVar));
    }

    public void onPingProgress(float f2, int i2) {
    }

    public void onTestStatusChanged(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j2) {
        if (speedtestEngineStatus == SpeedtestEngineStatus.END || speedtestEngineStatus == SpeedtestEngineStatus.ABORTED || speedtestEngineStatus == SpeedtestEngineStatus.ERROR) {
            v vVar = this.g;
            if (vVar == null || vVar.b() == null) {
                v vVar2 = this.g;
                if (vVar2 != null) {
                    vVar2.i();
                }
                OCTL octl = this.e;
                if (octl != null) {
                    octl.a();
                    return;
                }
                return;
            }
            RP3 b2 = this.g.b();
            if (b2 instanceof p4) {
                if (!InsightCore.getInsightSettings().getConnectivityTestTracerouteEnabled() || !CDC.l(this.a)) {
                    this.g.i();
                    OCTL octl2 = this.e;
                    if (octl2 != null) {
                        octl2.a();
                    }
                } else {
                    this.g.a(b2.Server, b2.Trigger);
                }
                w4.a(v4.LatencyTest, u4.LatencyTestEnd, Collections.singletonMap("Successful", String.valueOf(b2.Success)));
                if ((this.f.Success || this.t) && InsightCore.isInitialized() && InsightCore.getInsightSettings().e()) {
                    InsightCore.getUploadManager().uploadFiles(false);
                }
            } else if (b2 instanceof ac) {
                this.g.i();
                OCTL octl3 = this.e;
                if (octl3 != null) {
                    octl3.a();
                }
            }
        }
    }

    public void onTracerouteProgress(float f2, String str, int i2, int i3) {
    }

    public void onTransferProgress(float f2, long j2) {
    }

    public void onTransferProgressRemote(float f2, long j2) {
    }

    public void a(OCTL octl) {
        this.e = octl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x03bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x03bd, code lost:
        r13 = r33;
        r6 = r0;
        r15 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x03c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x03c4, code lost:
        r26 = r6;
        r27 = r15;
        r13 = r33;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x03cb, code lost:
        r14 = true;
        r31 = r9;
        r9 = r8;
        r8 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03d5, code lost:
        r1 = r0;
        r8 = r9;
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x040d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x040f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0410, code lost:
        r1 = r0;
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0414, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0415, code lost:
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0417, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x09ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x09ad, code lost:
        r15 = r13;
        r26 = r14;
        r31 = r9;
        r9 = r8;
        r8 = r31;
        r13 = r33;
        r23 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x09ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x09bb, code lost:
        r15 = r13;
        r26 = r14;
        r31 = r9;
        r9 = r8;
        r8 = r31;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x09c5, code lost:
        r20 = r15;
        r12 = r16;
        r5 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x09cd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x09ce, code lost:
        r22 = r5;
        r15 = r13;
        r26 = r14;
        r31 = r9;
        r9 = r8;
        r8 = r31;
        r13 = r33;
        r20 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0a0e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x0a0f, code lost:
        r8 = r9;
        r26 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x0a17, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0a18, code lost:
        r22 = r5;
        r16 = r12;
        r33 = r13;
        r26 = r14;
        r31 = r9;
        r9 = r8;
        r8 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0a2c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0a2d, code lost:
        r31 = r9;
        r9 = r8;
        r8 = r31;
        r6 = r0;
        r12 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x0a36, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0a3c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0a3d, code lost:
        r13 = r33;
        r27 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0a43, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0a44, code lost:
        r24 = r13;
        r27 = r15;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x0a5a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x0a5b, code lost:
        r23 = r6;
        r24 = r13;
        r27 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x0a62, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0a63, code lost:
        r23 = r6;
        r24 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0a67, code lost:
        r14 = false;
        r13 = r33;
        r31 = r9;
        r9 = r8;
        r8 = r31;
        r6 = r0;
        r26 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0a74, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0a75, code lost:
        r8 = r9;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x0a78, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x0a7a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x0a7b, code lost:
        r23 = r6;
        r31 = r9;
        r9 = r8;
        r8 = r31;
        r24 = r13;
        r26 = r21;
        r14 = false;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x0ab0, code lost:
        r8.add(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:0x0acf, code lost:
        r8.add(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03d4 A[ExcHandler: all (r0v54 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:88:0x033a] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x040f A[ExcHandler: all (r0v49 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:117:0x03f2] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0589 A[SYNTHETIC, Splitter:B:193:0x0589] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x05b6  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x076b  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x076f  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0789  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0797 A[SYNTHETIC, Splitter:B:281:0x0797] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x07ab A[SYNTHETIC, Splitter:B:287:0x07ab] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x07d8 A[SYNTHETIC, Splitter:B:302:0x07d8] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0839 A[SYNTHETIC, Splitter:B:325:0x0839] */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x0903  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0974  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0983  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0a0e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:150:0x0473] */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0a74 A[ExcHandler: all (r0v22 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:75:0x0316] */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0ab0  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0acf  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0ad3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x0ab3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x075a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x077c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.umlaut.crowd.internal.g1 a(com.umlaut.crowd.internal.a r33) {
        /*
            r32 = this;
            r1 = r32
            java.lang.String r2 = "\r\n"
            com.umlaut.crowd.internal.x r3 = new com.umlaut.crowd.internal.x
            android.content.Context r4 = r1.a
            r3.<init>(r4)
            com.umlaut.crowd.internal.z r3 = r3.a()
            float r4 = r1.n
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 0
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x001f
            float r5 = r3.BatteryLevel
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x001f
            return r6
        L_0x001f:
            android.content.Context r4 = r1.a
            com.umlaut.crowd.internal.o9 r4 = com.umlaut.crowd.internal.CDC.h(r4)
            boolean r5 = r1.o
            if (r5 != 0) goto L_0x0042
            com.umlaut.crowd.internal.l7 r5 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.enums.ConnectionTypes r5 = r5.e()
            com.umlaut.crowd.enums.ConnectionTypes r7 = com.umlaut.crowd.enums.ConnectionTypes.Mobile
            if (r5 != r7) goto L_0x0042
            com.umlaut.crowd.internal.l7 r5 = com.umlaut.crowd.InsightCore.getRadioController()
            int r7 = r4.SubscriptionId
            boolean r5 = r5.k((int) r7)
            if (r5 == 0) goto L_0x0042
            return r6
        L_0x0042:
            com.umlaut.crowd.IS r7 = com.umlaut.crowd.InsightCore.getInsightSettings()     // Catch:{ Exception -> 0x006b }
            long r7 = r7.y()     // Catch:{ Exception -> 0x006b }
            long r9 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ Exception -> 0x006b }
            com.umlaut.crowd.IC r11 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ Exception -> 0x006b }
            long r11 = r11.d0()     // Catch:{ Exception -> 0x006b }
            long r11 = r11 + r7
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 < 0) goto L_0x0062
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r7 = r6
            goto L_0x007f
        L_0x0062:
            android.content.Context r7 = r1.a     // Catch:{ Exception -> 0x006b }
            boolean r7 = com.umlaut.crowd.internal.sc.a(r7)     // Catch:{ Exception -> 0x006b }
            r8 = r7
            r7 = r6
            goto L_0x0080
        L_0x006b:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "checkAndLoadTruststore: "
            r8.<init>(r9)
            java.lang.String r7 = r7.toString()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
        L_0x007f:
            r8 = 0
        L_0x0080:
            com.umlaut.crowd.IS r9 = com.umlaut.crowd.InsightCore.getInsightSettings()     // Catch:{ Exception -> 0x00a1 }
            long r9 = r9.u()     // Catch:{ Exception -> 0x00a1 }
            long r11 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()     // Catch:{ Exception -> 0x00a1 }
            com.umlaut.crowd.IC r13 = com.umlaut.crowd.InsightCore.getInsightConfig()     // Catch:{ Exception -> 0x00a1 }
            long r13 = r13.L()     // Catch:{ Exception -> 0x00a1 }
            long r13 = r13 + r9
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 < 0) goto L_0x009d
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x00a2
        L_0x009d:
            com.umlaut.crowd.internal.w0.a()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x00a2
        L_0x00a1:
        L_0x00a2:
            r1.u = r6
            boolean r9 = com.umlaut.crowd.InsightCore.isInitialized()
            if (r9 == 0) goto L_0x0ad3
            com.umlaut.crowd.internal.ee r9 = com.umlaut.crowd.InsightCore.getWifiController()
            if (r9 != 0) goto L_0x00b2
            goto L_0x0ad3
        L_0x00b2:
            com.umlaut.crowd.internal.ee r9 = com.umlaut.crowd.InsightCore.getWifiController()
            com.umlaut.crowd.internal.DWI r9 = r9.getWifiInfo()
            java.lang.String r10 = r9.WifiSSID
            com.umlaut.crowd.IC r11 = com.umlaut.crowd.InsightCore.getInsightConfig()
            java.lang.String r11 = r11.h1()
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x010a
            com.umlaut.crowd.internal.e1 r10 = new com.umlaut.crowd.internal.e1
            java.lang.String r11 = r1.i
            com.umlaut.crowd.IS r12 = r1.c
            java.lang.String r12 = r12.q()
            r10.<init>(r11, r12)
            r1.f = r10
            com.umlaut.crowd.internal.x1 r10 = new com.umlaut.crowd.internal.x1
            r10.<init>()
            r1.u = r10
            com.umlaut.crowd.IC r10 = com.umlaut.crowd.InsightCore.getInsightConfig()
            boolean r10 = r10.z()
            if (r10 != 0) goto L_0x00f4
            com.umlaut.crowd.internal.q4 r10 = com.umlaut.crowd.internal.y1.b()
            if (r10 == 0) goto L_0x00f4
            com.umlaut.crowd.internal.g1 r11 = r1.f
            r11.LocationInfo = r10
        L_0x00f4:
            com.umlaut.crowd.internal.y1 r10 = r1.d
            if (r10 != 0) goto L_0x00ff
            com.umlaut.crowd.internal.y1 r10 = new com.umlaut.crowd.internal.y1
            r10.<init>()
            r1.d = r10
        L_0x00ff:
            com.umlaut.crowd.internal.y1 r10 = r1.d
            com.umlaut.crowd.internal.CT$a r11 = new com.umlaut.crowd.internal.CT$a
            r11.<init>()
            r10.a((com.umlaut.crowd.internal.p3) r11)
            goto L_0x0119
        L_0x010a:
            com.umlaut.crowd.internal.g1 r10 = new com.umlaut.crowd.internal.g1
            java.lang.String r11 = r1.i
            com.umlaut.crowd.IS r12 = r1.c
            java.lang.String r12 = r12.q()
            r10.<init>(r11, r12)
            r1.f = r10
        L_0x0119:
            com.umlaut.crowd.internal.g1 r10 = r1.f
            r11 = r33
            r10.Trigger = r11
            com.umlaut.crowd.internal.l7 r11 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.DRI r11 = r11.getRadioInfoForDefaultDataSim()
            r10.RadioInfo = r11
            com.umlaut.crowd.internal.g1 r10 = r1.f
            r10.WifiInfo = r9
            android.content.Context r9 = r1.a
            com.umlaut.crowd.internal.g3 r9 = com.umlaut.crowd.internal.g3.a((android.content.Context) r9)
            com.umlaut.crowd.internal.g1 r11 = r1.f
            com.umlaut.crowd.internal.DRI r12 = r11.RadioInfo
            com.umlaut.crowd.internal.DWI r11 = r11.WifiInfo
            com.umlaut.crowd.enums.ConnectionTypes r13 = r12.ConnectionType
            boolean r13 = com.umlaut.crowd.internal.g3.a((com.umlaut.crowd.enums.ConnectionTypes) r13)
            com.umlaut.crowd.internal.e4 r9 = r9.a(r12, r11, r13)
            r10.IspInfo = r9
            double r9 = r1.r
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x0154
            int r9 = r1.q
            if (r9 <= 0) goto L_0x0154
            r32.e()
        L_0x0154:
            com.umlaut.crowd.IS r9 = com.umlaut.crowd.InsightCore.getInsightSettings()
            java.lang.String[] r9 = r9.j()
            com.umlaut.crowd.IS r10 = com.umlaut.crowd.InsightCore.getInsightSettings()
            java.lang.String r10 = r10.i()
            com.umlaut.crowd.internal.r1 r10 = com.umlaut.crowd.internal.r1.valueOf(r10)
            if (r7 == 0) goto L_0x017f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            com.umlaut.crowd.internal.g1 r12 = r1.f
            java.lang.String r13 = r12.ErrorReason
            r11.append(r13)
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            r12.ErrorReason = r7
        L_0x017f:
            com.umlaut.crowd.internal.g1 r7 = r1.f
            com.umlaut.crowd.internal.d3 r11 = com.umlaut.crowd.InsightCore.getForegroundTestManager()
            int r11 = r11.d()
            r7.IsAppInForeground = r11
            com.umlaut.crowd.internal.g1 r7 = r1.f
            java.lang.String r11 = "20230301124918"
            r7.Version = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r1.k
            r11.append(r12)
            java.lang.String r12 = "?id="
            r11.append(r12)
            java.util.Random r12 = r1.m
            long r12 = r12.nextLong()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r7.ServerFilename = r11
            com.umlaut.crowd.IC r7 = com.umlaut.crowd.InsightCore.getInsightConfig()
            boolean r7 = r7.r0()
            if (r7 == 0) goto L_0x01c5
            com.umlaut.crowd.internal.g1 r7 = r1.f
            com.umlaut.crowd.internal.l7 r11 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.z0[] r11 = r11.d()
            r7.CellInfo = r11
        L_0x01c5:
            com.umlaut.crowd.internal.g1 r7 = r1.f
            r7.BatteryInfo = r3
            android.content.Context r3 = r1.a
            com.umlaut.crowd.internal.a2 r3 = com.umlaut.crowd.internal.CDC.getDeviceInfo(r3)
            r7.DeviceInfo = r3
            com.umlaut.crowd.internal.g1 r3 = r1.f
            android.content.Context r7 = r1.a
            com.umlaut.crowd.internal.n5 r7 = com.umlaut.crowd.internal.CDC.d((android.content.Context) r7)
            r3.MemoryInfo = r7
            com.umlaut.crowd.IC r3 = com.umlaut.crowd.InsightCore.getInsightConfig()
            boolean r3 = r3.q0()
            if (r3 == 0) goto L_0x01f1
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.g[] r7 = r7.b()
            r3.ApnInfo = r7
        L_0x01f1:
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.l7 r11 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.y5 r11 = r11.c()
            int r11 = r11.DefaultDataSimId
            com.umlaut.crowd.internal.j6[] r7 = r7.h((int) r11)
            r3.NetworkRegistrationInfo = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.l7 r11 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.y5 r11 = r11.c()
            int r11 = r11.DefaultDataSimId
            com.umlaut.crowd.enums.NetworkTypes r7 = r7.j((int) r11)
            r3.VoiceNetworkType = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            android.content.Context r7 = r1.a
            com.umlaut.crowd.internal.v0 r7 = com.umlaut.crowd.internal.ud.a(r7)
            r3.CallState = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            android.content.Context r7 = r1.a
            com.umlaut.crowd.internal.y9 r7 = com.umlaut.crowd.internal.CDC.j(r7)
            r3.StorageInfo = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.nc r7 = com.umlaut.crowd.internal.CDC.f()
            r3.TrafficInfo = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            android.content.Context r7 = r1.a
            com.umlaut.crowd.internal.z8 r7 = com.umlaut.crowd.internal.CDC.f(r7)
            r3.ScreenState = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            android.content.Context r7 = r1.a
            com.umlaut.crowd.internal.w3 r7 = com.umlaut.crowd.internal.CDC.c((android.content.Context) r7)
            r3.IdleStateOnStart = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            r3.SimInfo = r4
            com.umlaut.crowd.internal.ub r4 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()
            r3.TimeInfo = r4
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.ub r4 = r3.TimeInfo
            java.lang.String r4 = r4.TimestampTableau
            r3.TestTimestamp = r4
            com.umlaut.crowd.IS r4 = com.umlaut.crowd.InsightCore.getInsightSettings()
            long r11 = r4.I()
            r3.TruststoreTimestamp = r11
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.ub r4 = r3.TimeInfo
            java.lang.String r7 = r3.GUID
            java.lang.String r4 = com.umlaut.crowd.internal.k3.a((com.umlaut.crowd.internal.ub) r4, (java.lang.String) r7)
            r3.CtId = r4
            com.umlaut.crowd.IS r3 = r1.c
            boolean r3 = r3.m()
            r4 = 1
            if (r3 == 0) goto L_0x028a
            com.umlaut.crowd.IS r3 = r1.c
            boolean r3 = r3.n()
            if (r3 != 0) goto L_0x028a
            com.umlaut.crowd.internal.g1 r3 = r1.f
            r3.IsKeepAlive = r4
        L_0x028a:
            com.umlaut.crowd.internal.g1 r3 = r1.f
            java.util.ArrayList r7 = new java.util.ArrayList
            java.util.HashMap r11 = com.umlaut.crowd.internal.v.c()
            java.util.Collection r11 = r11.values()
            r7.<init>(r11)
            r11 = 44
            java.lang.String r7 = com.umlaut.crowd.internal.aa.a(r7, r11, r4)
            r3.TestsInProgress = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.DRI r7 = r7.getRadioInfoForDefaultDataSim()
            r3.RadioInfo = r7
            com.umlaut.crowd.internal.g1 r3 = r1.f
            com.umlaut.crowd.internal.ee r7 = com.umlaut.crowd.InsightCore.getWifiController()
            com.umlaut.crowd.internal.DWI r7 = r7.getWifiInfo()
            r3.WifiInfo = r7
            long r11 = android.os.SystemClock.elapsedRealtime()
            long r13 = android.os.SystemClock.uptimeMillis()
            javax.net.ssl.HostnameVerifier r3 = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier()
            com.umlaut.crowd.internal.z3 r7 = new com.umlaut.crowd.internal.z3
            android.content.Context r15 = r1.a
            r7.<init>(r15, r8)
            java.util.List r8 = r1.a((java.lang.String[]) r9, (com.umlaut.crowd.internal.r1) r10)
            java.util.LinkedList r9 = new java.util.LinkedList
            r9.<init>()
            java.lang.String r10 = r1.j
            java.lang.String r15 = r1.l
            r33 = r15
            r5 = 0
            r18 = 0
            r19 = 0
            r15 = r13
            r13 = r11
            r11 = r6
            r12 = r10
            r10 = r11
        L_0x02e5:
            int r4 = r8.size()
            r20 = r10
            r21 = r11
            java.lang.String r10 = ""
            java.lang.String r11 = "; "
            if (r5 < r4) goto L_0x0311
            boolean r4 = r8.isEmpty()
            if (r4 == 0) goto L_0x0300
            int r4 = r12.length()
            if (r4 <= 0) goto L_0x0300
            goto L_0x0311
        L_0x0300:
            r29 = r8
            r27 = r15
            r8 = r18
            r12 = r19
            r15 = r20
            r4 = r21
            r5 = 0
            r16 = 0
            goto L_0x04dc
        L_0x0311:
            com.umlaut.crowd.internal.x5 r4 = new com.umlaut.crowd.internal.x5
            r4.<init>()
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0a7a, all -> 0x0a74 }
            long r15 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0a62, all -> 0x0a74 }
            com.umlaut.crowd.internal.CC r22 = new com.umlaut.crowd.internal.CC     // Catch:{ Exception -> 0x0a5a, all -> 0x0a74 }
            r22.<init>()     // Catch:{ Exception -> 0x0a5a, all -> 0x0a74 }
            int r18 = r18 + 1
            r23 = r6
            com.umlaut.crowd.internal.g1 r6 = r1.f     // Catch:{ Exception -> 0x0a43, all -> 0x0a74 }
            r24 = r13
            boolean r13 = r32.a()     // Catch:{ Exception -> 0x0a3c, all -> 0x0a74 }
            r6.LocalhostPingSuccess = r13     // Catch:{ Exception -> 0x0a3c, all -> 0x0a74 }
            android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0a3c, all -> 0x0a74 }
            boolean r6 = r8.isEmpty()     // Catch:{ Exception -> 0x0a3c, all -> 0x0a74 }
            if (r6 != 0) goto L_0x03ea
            java.lang.Object r6 = r8.get(r5)     // Catch:{ Exception -> 0x03da, all -> 0x03d4 }
            com.umlaut.crowd.internal.CC r6 = (com.umlaut.crowd.internal.CC) r6     // Catch:{ Exception -> 0x03da, all -> 0x03d4 }
            com.umlaut.crowd.internal.g1 r14 = r1.f     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            java.lang.String r13 = r6.address     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            r14.ServerHostname = r13     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            int r13 = r6.totalTests     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            r14 = 1
            int r13 = r13 + r14
            r6.totalTests = r13     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            int r13 = r5 + 1
            r4.Try = r13     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            r13.<init>()     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            com.umlaut.crowd.internal.g1 r14 = r1.f     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            java.lang.String r14 = r14.ServerHostname     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            r13.append(r14)     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            com.umlaut.crowd.internal.g1 r14 = r1.f     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            java.lang.String r14 = r14.ServerFilename     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            r13.append(r14)     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            r4.HostFile = r13     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            com.umlaut.crowd.internal.f2 r13 = com.umlaut.crowd.internal.f2.a()     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            com.umlaut.crowd.internal.g1 r14 = r1.f     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            java.lang.String r14 = r14.ServerHostname     // Catch:{ Exception -> 0x03c3, all -> 0x03d4 }
            r26 = r6
            r27 = r15
            r6 = 30000(0x7530, float:4.2039E-41)
            r15 = 0
            com.umlaut.crowd.internal.g2 r13 = r13.a((java.lang.String) r14, (int) r6, (boolean) r15)     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            com.umlaut.crowd.internal.g1 r6 = r1.f     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            java.lang.String r14 = r13.c()     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            r6.ServerIp = r14     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            com.umlaut.crowd.internal.g1 r6 = r1.f     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            int r14 = r13.e()     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            long r14 = (long) r14     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            r6.DurationDNS = r14     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            boolean r6 = r13.i()     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            if (r6 != 0) goto L_0x03b5
            boolean r6 = r13.h()     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            if (r6 == 0) goto L_0x03b5
            java.net.InetAddress[] r6 = r13.d()     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            r14 = 0
            r6 = r6[r14]     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            boolean r6 = r6 instanceof java.net.Inet6Address     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            if (r6 == 0) goto L_0x03ad
            com.umlaut.crowd.internal.g1 r6 = r1.f     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            java.lang.String r13 = r13.b()     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            r6.DnsServer = r13     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            goto L_0x03b5
        L_0x03ad:
            com.umlaut.crowd.internal.g1 r6 = r1.f     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            java.lang.String r13 = r13.a()     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
            r6.DnsServer = r13     // Catch:{ Exception -> 0x03bc, all -> 0x03d4 }
        L_0x03b5:
            r13 = r33
            r6 = r26
            r14 = 1
            goto L_0x0473
        L_0x03bc:
            r0 = move-exception
            r13 = r33
            r6 = r0
            r15 = r27
            goto L_0x03cb
        L_0x03c3:
            r0 = move-exception
            r26 = r6
            r27 = r15
            r13 = r33
            r6 = r0
        L_0x03cb:
            r10 = 0
            r14 = 1
            r31 = r9
            r9 = r8
            r8 = r31
            goto L_0x0a8c
        L_0x03d4:
            r0 = move-exception
            r1 = r0
            r8 = r9
            r5 = 1
            goto L_0x0acd
        L_0x03da:
            r0 = move-exception
            r27 = r15
            r13 = r33
            r6 = r0
            r14 = 0
            r17 = 1
        L_0x03e3:
            r31 = r9
            r9 = r8
            r8 = r31
            goto L_0x0a53
        L_0x03ea:
            r27 = r15
            int r6 = r33.length()     // Catch:{ Exception -> 0x0a38, all -> 0x0a74 }
            if (r6 <= 0) goto L_0x041c
            int r6 = r12.length()     // Catch:{ Exception -> 0x0414, all -> 0x040f }
            if (r6 <= 0) goto L_0x041c
            com.umlaut.crowd.internal.g1 r6 = r1.f     // Catch:{ Exception -> 0x0414, all -> 0x040f }
            r13 = r33
            r6.ServerIp = r13     // Catch:{ Exception -> 0x040d, all -> 0x040f }
            r6.ServerHostname = r12     // Catch:{ Exception -> 0x040d, all -> 0x040f }
            r14 = 0
            r6.DurationDNS = r14     // Catch:{ Exception -> 0x040d, all -> 0x040f }
            int r5 = r5 + -1
            r12 = r10
            r13 = r12
        L_0x0408:
            r6 = r22
            r14 = 0
            goto L_0x0473
        L_0x040d:
            r0 = move-exception
            goto L_0x0417
        L_0x040f:
            r0 = move-exception
            r1 = r0
            r8 = r9
            goto L_0x0a78
        L_0x0414:
            r0 = move-exception
            r13 = r33
        L_0x0417:
            r6 = r0
        L_0x0418:
            r14 = 0
            r17 = 0
            goto L_0x03e3
        L_0x041c:
            r13 = r33
            com.umlaut.crowd.internal.g1 r6 = r1.f     // Catch:{ Exception -> 0x0a36, all -> 0x0a74 }
            r6.ServerHostname = r12     // Catch:{ Exception -> 0x0a36, all -> 0x0a74 }
            int r5 = r5 + -1
            com.umlaut.crowd.internal.f2 r6 = com.umlaut.crowd.internal.f2.a()     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            java.lang.String r12 = r12.ServerHostname     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            r14 = 30000(0x7530, float:4.2039E-41)
            r15 = 0
            com.umlaut.crowd.internal.g2 r6 = r6.a((java.lang.String) r12, (int) r14, (boolean) r15)     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            java.lang.String r14 = r6.c()     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            r12.ServerIp = r14     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            int r14 = r6.e()     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            long r14 = (long) r14     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            r12.DurationDNS = r14     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            boolean r12 = r6.i()     // Catch:{ Exception -> 0x0a2c, all -> 0x0a74 }
            if (r12 != 0) goto L_0x0471
            boolean r12 = r6.h()     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            if (r12 == 0) goto L_0x0471
            java.net.InetAddress[] r12 = r6.d()     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            r14 = 0
            r12 = r12[r14]     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            boolean r12 = r12 instanceof java.net.Inet6Address     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            if (r12 == 0) goto L_0x0464
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            java.lang.String r6 = r6.b()     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            r12.DnsServer = r6     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            goto L_0x0471
        L_0x0464:
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            java.lang.String r6 = r6.a()     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            r12.DnsServer = r6     // Catch:{ Exception -> 0x046d, all -> 0x040f }
            goto L_0x0471
        L_0x046d:
            r0 = move-exception
            r6 = r0
            r12 = r10
            goto L_0x0418
        L_0x0471:
            r12 = r10
            goto L_0x0408
        L_0x0473:
            com.umlaut.crowd.internal.g1 r15 = r1.f     // Catch:{ Exception -> 0x0a17, all -> 0x0a0e }
            r16 = r12
            r33 = r13
            long r12 = r15.DurationDNS     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            r29 = 30000(0x7530, double:1.4822E-319)
            int r22 = (r12 > r29 ? 1 : (r12 == r29 ? 0 : -1))
            if (r22 > 0) goto L_0x09dd
            java.lang.String r15 = r15.ServerIp     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            r4.ServerIp = r15     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            r4.DurationDNS = r12     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            int r12 = r6.DNSSuccess     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            r13 = 1
            int r12 = r12 + r13
            r6.DNSSuccess = r12     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            int r19 = r19 + 1
            r12 = 30000(0x7530, float:4.2039E-41)
            javax.net.SocketFactory r13 = android.net.SSLCertificateSocketFactory.getDefault(r12)     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            android.net.SSLCertificateSocketFactory r13 = (android.net.SSLCertificateSocketFactory) r13     // Catch:{ Exception -> 0x09ff, all -> 0x0a0e }
            r12 = 1
            javax.net.ssl.TrustManager[] r15 = new javax.net.ssl.TrustManager[r12]     // Catch:{ Exception -> 0x09cd, all -> 0x0a0e }
            r12 = 0
            r15[r12] = r7     // Catch:{ Exception -> 0x09cd, all -> 0x0a0e }
            r13.setTrustManagers(r15)     // Catch:{ Exception -> 0x09cd, all -> 0x0a0e }
            java.net.InetSocketAddress r12 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x09cd, all -> 0x0a0e }
            com.umlaut.crowd.internal.g1 r15 = r1.f     // Catch:{ Exception -> 0x09cd, all -> 0x0a0e }
            java.lang.String r15 = r15.ServerIp     // Catch:{ Exception -> 0x09cd, all -> 0x0a0e }
            r22 = r5
            r5 = 443(0x1bb, float:6.21E-43)
            r12.<init>(r15, r5)     // Catch:{ Exception -> 0x09ba, all -> 0x0a0e }
            java.net.Socket r5 = r13.createSocket()     // Catch:{ Exception -> 0x09ba, all -> 0x0a0e }
            javax.net.ssl.SSLSocket r5 = (javax.net.ssl.SSLSocket) r5     // Catch:{ Exception -> 0x09ba, all -> 0x0a0e }
            long r29 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x09ac, all -> 0x0a0e }
            r15 = 30000(0x7530, float:4.2039E-41)
            r5.connect(r12, r15)     // Catch:{ Exception -> 0x09ac, all -> 0x0a0e }
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ Exception -> 0x09ac, all -> 0x0a0e }
            long r20 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x09ac, all -> 0x0a0e }
            r15 = r13
            r26 = r14
            long r13 = r20 - r29
            r12.DurationTcpConnect = r13     // Catch:{ Exception -> 0x099f, all -> 0x099b }
            int r12 = r6.TCPSuccess     // Catch:{ Exception -> 0x099f, all -> 0x099b }
            r13 = 1
            int r12 = r12 + r13
            r6.TCPSuccess = r12     // Catch:{ Exception -> 0x099f, all -> 0x099b }
            r4 = r6
            r29 = r8
            r8 = r18
            r12 = r19
            r13 = r24
            r16 = 1
            r6 = r5
            r5 = 1
        L_0x04dc:
            if (r5 == 0) goto L_0x0845
            long r18 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x080b }
            r33 = r5
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x080b }
            java.lang.String r5 = r5.ServerHostname     // Catch:{ Exception -> 0x080b }
            com.umlaut.crowd.internal.j3.a((android.net.SSLCertificateSocketFactory) r15, (java.net.Socket) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x080b }
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x0532 }
            java.lang.String r5 = r5.ServerHostname     // Catch:{ Exception -> 0x0532 }
            javax.net.ssl.SSLSession r15 = r6.getSession()     // Catch:{ Exception -> 0x0532 }
            boolean r3 = r3.verify(r5, r15)     // Catch:{ Exception -> 0x0532 }
            if (r3 != 0) goto L_0x052d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0532 }
            r3.<init>()     // Catch:{ Exception -> 0x0532 }
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x0532 }
            java.lang.String r15 = r5.SslException     // Catch:{ Exception -> 0x0532 }
            r3.append(r15)     // Catch:{ Exception -> 0x0532 }
            java.lang.String r15 = "Expected "
            r3.append(r15)     // Catch:{ Exception -> 0x0532 }
            com.umlaut.crowd.internal.g1 r15 = r1.f     // Catch:{ Exception -> 0x0532 }
            java.lang.String r15 = r15.ServerHostname     // Catch:{ Exception -> 0x0532 }
            r3.append(r15)     // Catch:{ Exception -> 0x0532 }
            java.lang.String r15 = " found "
            r3.append(r15)     // Catch:{ Exception -> 0x0532 }
            javax.net.ssl.SSLSession r15 = r6.getSession()     // Catch:{ Exception -> 0x0532 }
            java.security.Principal r15 = r15.getPeerPrincipal()     // Catch:{ Exception -> 0x0532 }
            r3.append(r15)     // Catch:{ Exception -> 0x0532 }
            r3.append(r11)     // Catch:{ Exception -> 0x0532 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0532 }
            r5.SslException = r3     // Catch:{ Exception -> 0x0532 }
            r20 = r12
            goto L_0x0557
        L_0x052d:
            r3 = r33
            r20 = r12
            goto L_0x0558
        L_0x0532:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x080b }
            r5.<init>()     // Catch:{ Exception -> 0x080b }
            com.umlaut.crowd.internal.g1 r15 = r1.f     // Catch:{ Exception -> 0x080b }
            r20 = r12
            java.lang.String r12 = r15.SslException     // Catch:{ Exception -> 0x0802 }
            r5.append(r12)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r12 = "Cannot validate hostname: "
            r5.append(r12)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ Exception -> 0x0802 }
            r5.append(r3)     // Catch:{ Exception -> 0x0802 }
            r5.append(r11)     // Catch:{ Exception -> 0x0802 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0802 }
            r15.SslException = r3     // Catch:{ Exception -> 0x0802 }
        L_0x0557:
            r3 = 0
        L_0x0558:
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x0802 }
            long r22 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0802 }
            r12 = r8
            r30 = r9
            long r8 = r22 - r18
            r5.DurationSSL = r8     // Catch:{ Exception -> 0x07fe }
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x07fe }
            javax.net.ssl.SSLSession r8 = r6.getSession()     // Catch:{ Exception -> 0x07fe }
            java.lang.String r8 = r8.getProtocol()     // Catch:{ Exception -> 0x07fe }
            com.umlaut.crowd.internal.q1 r8 = com.umlaut.crowd.internal.q1.convertFromString(r8)     // Catch:{ Exception -> 0x07fe }
            r5.ProtocolType = r8     // Catch:{ Exception -> 0x07fe }
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x07f2 }
            com.umlaut.crowd.internal.s1 r8 = r7.b()     // Catch:{ Exception -> 0x07f2 }
            r5.TestType = r8     // Catch:{ Exception -> 0x07f2 }
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x07f2 }
            com.umlaut.crowd.internal.s1 r5 = r5.TestType     // Catch:{ Exception -> 0x07f2 }
            com.umlaut.crowd.internal.s1 r8 = com.umlaut.crowd.internal.s1.SSLOwnTs     // Catch:{ Exception -> 0x07f2 }
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x07f2 }
            if (r5 != 0) goto L_0x05b6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05ac }
            r5.<init>()     // Catch:{ Exception -> 0x05ac }
            com.umlaut.crowd.internal.g1 r8 = r1.f     // Catch:{ Exception -> 0x05ac }
            java.lang.String r9 = r8.SslException     // Catch:{ Exception -> 0x05ac }
            r5.append(r9)     // Catch:{ Exception -> 0x05ac }
            java.lang.String r9 = "We couldn't use our own truststore, used: "
            r5.append(r9)     // Catch:{ Exception -> 0x05ac }
            com.umlaut.crowd.internal.g1 r9 = r1.f     // Catch:{ Exception -> 0x05ac }
            com.umlaut.crowd.internal.s1 r9 = r9.TestType     // Catch:{ Exception -> 0x05ac }
            r5.append(r9)     // Catch:{ Exception -> 0x05ac }
            r5.append(r11)     // Catch:{ Exception -> 0x05ac }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x05ac }
            r8.SslException = r5     // Catch:{ Exception -> 0x05ac }
            r5 = 0
            goto L_0x05b7
        L_0x05ac:
            r0 = move-exception
            r2 = r0
            r33 = r3
            r21 = r12
            r22 = r13
            goto L_0x07fa
        L_0x05b6:
            r5 = r3
        L_0x05b7:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x07f2 }
            r8.<init>()     // Catch:{ Exception -> 0x07f2 }
            com.umlaut.crowd.internal.g1 r9 = r1.f     // Catch:{ Exception -> 0x07f2 }
            java.lang.String r15 = r9.SslException     // Catch:{ Exception -> 0x07f2 }
            r8.append(r15)     // Catch:{ Exception -> 0x07f2 }
            java.lang.String r7 = r7.a()     // Catch:{ Exception -> 0x07f2 }
            r8.append(r7)     // Catch:{ Exception -> 0x07f2 }
            r8.append(r11)     // Catch:{ Exception -> 0x07f2 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x07f2 }
            r9.SslException = r7     // Catch:{ Exception -> 0x07f2 }
            r7 = 2048(0x800, float:2.87E-42)
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x07e8 }
            java.io.PrintWriter r8 = new java.io.PrintWriter     // Catch:{ Exception -> 0x07e8 }
            java.io.OutputStream r9 = r6.getOutputStream()     // Catch:{ Exception -> 0x07e8 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x07e8 }
            long r18 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x07e8 }
            java.lang.String r9 = "GET "
            r8.print(r9)     // Catch:{ Exception -> 0x07e8 }
            com.umlaut.crowd.internal.g1 r9 = r1.f     // Catch:{ Exception -> 0x07e8 }
            java.lang.String r9 = r9.ServerFilename     // Catch:{ Exception -> 0x07e8 }
            r8.print(r9)     // Catch:{ Exception -> 0x07e8 }
            java.lang.String r9 = " HTTP/1.1"
            r8.print(r9)     // Catch:{ Exception -> 0x07e8 }
            r8.print(r2)     // Catch:{ Exception -> 0x07e8 }
            java.lang.String r9 = "HOST: "
            r8.print(r9)     // Catch:{ Exception -> 0x07e8 }
            com.umlaut.crowd.internal.g1 r9 = r1.f     // Catch:{ Exception -> 0x07e8 }
            java.lang.String r9 = r9.ServerHostname     // Catch:{ Exception -> 0x07e8 }
            r8.print(r9)     // Catch:{ Exception -> 0x07e8 }
            r8.print(r2)     // Catch:{ Exception -> 0x07e8 }
            java.lang.String r9 = "Connection: close"
            r8.print(r9)     // Catch:{ Exception -> 0x07e8 }
            r8.print(r2)     // Catch:{ Exception -> 0x07e8 }
            r8.print(r2)     // Catch:{ Exception -> 0x07e8 }
            r8.print(r2)     // Catch:{ Exception -> 0x07e8 }
            r8.flush()     // Catch:{ Exception -> 0x07e8 }
            com.umlaut.crowd.internal.g1 r2 = r1.f     // Catch:{ Exception -> 0x07e8 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x07e8 }
            long r8 = r8 - r18
            r2.DurationHttpGetCommand = r8     // Catch:{ Exception -> 0x07e8 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x07e8 }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ Exception -> 0x07e8 }
            r18 = 0
        L_0x062c:
            com.umlaut.crowd.internal.z9$a r15 = com.umlaut.crowd.internal.z9.a.a(r2)     // Catch:{ all -> 0x07c8 }
            if (r15 == 0) goto L_0x075a
            r33 = r3
            int r3 = r15.a     // Catch:{ all -> 0x0757 }
            r22 = r13
            r14 = r12
            long r12 = (long) r3
            long r18 = r18 + r12
            java.lang.String r3 = r15.b     // Catch:{ all -> 0x0752 }
            java.lang.String r3 = r3.toUpperCase()     // Catch:{ all -> 0x0752 }
            java.lang.String r12 = "HTTP"
            boolean r12 = r3.startsWith(r12)     // Catch:{ all -> 0x0752 }
            if (r12 == 0) goto L_0x0698
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ all -> 0x0752 }
            long r24 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0752 }
            r21 = r14
            long r13 = r24 - r8
            r12.DurationHttpResponse = r13     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = " "
            java.lang.String[] r3 = r3.split(r12)     // Catch:{ all -> 0x07c2 }
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ all -> 0x07c2 }
            r13 = 1
            r3 = r3[r13]     // Catch:{ all -> 0x07c2 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x07c2 }
            r12.HTTPStatus = r3     // Catch:{ all -> 0x07c2 }
            com.umlaut.crowd.internal.g1 r3 = r1.f     // Catch:{ all -> 0x07c2 }
            int r3 = r3.HTTPStatus     // Catch:{ all -> 0x07c2 }
            r12 = 200(0xc8, float:2.8E-43)
            if (r3 == r12) goto L_0x074a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x07c2 }
            r3.<init>()     // Catch:{ all -> 0x07c2 }
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = r5.ErrorReason     // Catch:{ all -> 0x07c2 }
            r3.append(r12)     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = "Request failed! Unexcepted HTTP code: "
            r3.append(r12)     // Catch:{ all -> 0x07c2 }
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ all -> 0x07c2 }
            int r12 = r12.HTTPStatus     // Catch:{ all -> 0x07c2 }
            r3.append(r12)     // Catch:{ all -> 0x07c2 }
            r3.append(r11)     // Catch:{ all -> 0x07c2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x07c2 }
            r5.ErrorReason = r3     // Catch:{ all -> 0x07c2 }
            r3 = r33
            r12 = r21
            r13 = r22
            r5 = 0
            goto L_0x062c
        L_0x0698:
            r21 = r14
            java.lang.String r12 = "CONTENT-LENGTH:"
            boolean r12 = r3.startsWith(r12)     // Catch:{ all -> 0x07c2 }
            if (r12 == 0) goto L_0x06b6
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ NumberFormatException -> 0x074a }
            r13 = 15
            java.lang.String r3 = r3.substring(r13)     // Catch:{ NumberFormatException -> 0x074a }
            java.lang.String r3 = r3.trim()     // Catch:{ NumberFormatException -> 0x074a }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x074a }
            r12.HeaderContentLength = r3     // Catch:{ NumberFormatException -> 0x074a }
            goto L_0x074a
        L_0x06b6:
            java.lang.String r12 = "LAST-MODIFIED:"
            boolean r12 = r3.startsWith(r12)     // Catch:{ all -> 0x07c2 }
            if (r12 == 0) goto L_0x06d2
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{  }
            r13 = 14
            java.lang.String r3 = r3.substring(r13)     // Catch:{  }
            java.lang.String r3 = r3.trim()     // Catch:{  }
            long r13 = com.umlaut.crowd.internal.i1.c(r3)     // Catch:{  }
            r12.HeaderLastModified = r13     // Catch:{  }
            goto L_0x074a
        L_0x06d2:
            java.lang.String r12 = "X-AMZ-CF-ID:"
            boolean r12 = r3.startsWith(r12)     // Catch:{ all -> 0x07c2 }
            if (r12 == 0) goto L_0x06eb
            com.umlaut.crowd.internal.g1 r3 = r1.f     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = r15.b     // Catch:{ all -> 0x07c2 }
            r13 = 12
            java.lang.String r12 = r12.substring(r13)     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = r12.trim()     // Catch:{ all -> 0x07c2 }
            r3.AmazonId = r12     // Catch:{ all -> 0x07c2 }
            goto L_0x074a
        L_0x06eb:
            boolean r12 = r15.c     // Catch:{ all -> 0x07c2 }
            if (r12 != 0) goto L_0x0760
            boolean r12 = r3.equals(r10)     // Catch:{ all -> 0x07c2 }
            if (r12 == 0) goto L_0x06f7
            goto L_0x0760
        L_0x06f7:
            java.lang.String r12 = "X-AMZ-CF-POP:"
            boolean r12 = r3.startsWith(r12)     // Catch:{ all -> 0x07c2 }
            if (r12 != 0) goto L_0x0732
            java.lang.String r12 = "X-UML-CF-POP:"
            boolean r12 = r3.startsWith(r12)     // Catch:{ all -> 0x07c2 }
            if (r12 == 0) goto L_0x0708
            goto L_0x0732
        L_0x0708:
            java.lang.String r12 = "CF-RAY:"
            boolean r3 = r3.startsWith(r12)     // Catch:{ all -> 0x07c2 }
            if (r3 == 0) goto L_0x074a
            java.lang.String r3 = r15.b     // Catch:{ all -> 0x07c2 }
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x07c2 }
            r12 = 7
            java.lang.String r3 = r3.substring(r12)     // Catch:{ all -> 0x07c2 }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = "-"
            java.lang.String[] r3 = r3.split(r12)     // Catch:{ all -> 0x07c2 }
            com.umlaut.crowd.internal.g1 r12 = r1.f     // Catch:{ all -> 0x07c2 }
            int r13 = r3.length     // Catch:{ all -> 0x07c2 }
            r14 = 1
            if (r13 <= r14) goto L_0x072e
            r3 = r3[r14]     // Catch:{ all -> 0x07c2 }
            goto L_0x072f
        L_0x072e:
            r3 = r10
        L_0x072f:
            r12.AirportCode = r3     // Catch:{ all -> 0x07c2 }
            goto L_0x074a
        L_0x0732:
            com.umlaut.crowd.internal.g1 r3 = r1.f     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = r15.b     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = r12.toLowerCase()     // Catch:{ all -> 0x07c2 }
            r13 = 13
            java.lang.String r12 = r12.substring(r13)     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = r12.trim()     // Catch:{ all -> 0x07c2 }
            java.lang.String r12 = com.umlaut.crowd.internal.f9.d(r12)     // Catch:{ all -> 0x07c2 }
            r3.AirportCode = r12     // Catch:{ all -> 0x07c2 }
        L_0x074a:
            r3 = r33
            r12 = r21
            r13 = r22
            goto L_0x062c
        L_0x0752:
            r0 = move-exception
            r21 = r14
            goto L_0x07cf
        L_0x0757:
            r0 = move-exception
            goto L_0x07cb
        L_0x075a:
            r33 = r3
            r21 = r12
            r22 = r13
        L_0x0760:
            r12 = r18
            com.umlaut.crowd.internal.g1 r3 = r1.f     // Catch:{ all -> 0x07c4 }
            r3.HeaderBytesRead = r12     // Catch:{ all -> 0x07c4 }
            int r3 = r3.HeaderContentLength     // Catch:{ all -> 0x07c4 }
            r10 = -1
            if (r3 == r10) goto L_0x076f
            int r14 = (int) r12
            int r14 = r14 + r3
            long r14 = (long) r14
            goto L_0x0774
        L_0x076f:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0774:
            r18 = r12
        L_0x0776:
            int r3 = r2.read(r7)     // Catch:{ all -> 0x07c2 }
            if (r3 != r10) goto L_0x0789
            int r2 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r2 < 0) goto L_0x0781
            goto L_0x0793
        L_0x0781:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x07c2 }
            java.lang.String r3 = "Could not read all bytes"
            r2.<init>(r3)     // Catch:{ all -> 0x07c2 }
            throw r2     // Catch:{ all -> 0x07c2 }
        L_0x0789:
            long r12 = (long) r3
            long r18 = r18 + r12
            int r12 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r12 < 0) goto L_0x0791
            goto L_0x0793
        L_0x0791:
            if (r3 > 0) goto L_0x0776
        L_0x0793:
            r2 = r18
            if (r5 == 0) goto L_0x07a5
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ all -> 0x07a2 }
            r7 = 1
            r5.Success = r7     // Catch:{ all -> 0x07a2 }
            int r5 = r4.successfulTests     // Catch:{ all -> 0x07a2 }
            int r5 = r5 + r7
            r4.successfulTests = r5     // Catch:{ all -> 0x07a2 }
            goto L_0x07a5
        L_0x07a2:
            r0 = move-exception
            r4 = r0
            goto L_0x07d2
        L_0x07a5:
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x07b8
            com.umlaut.crowd.internal.g1 r4 = r1.f     // Catch:{ Exception -> 0x07e6 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x07e6 }
            long r12 = r12 - r8
            r4.DurationHttpReceive = r12     // Catch:{ Exception -> 0x07e6 }
            com.umlaut.crowd.internal.g1 r4 = r1.f     // Catch:{ Exception -> 0x07e6 }
            r4.BytesRead = r2     // Catch:{ Exception -> 0x07e6 }
        L_0x07b8:
            r6.close()     // Catch:{ Exception -> 0x07bc }
            goto L_0x07bd
        L_0x07bc:
        L_0x07bd:
            r3 = r33
            r4 = 1
            goto L_0x084f
        L_0x07c2:
            r0 = move-exception
            goto L_0x07cf
        L_0x07c4:
            r0 = move-exception
            r4 = r0
            r2 = r12
            goto L_0x07d2
        L_0x07c8:
            r0 = move-exception
            r33 = r3
        L_0x07cb:
            r21 = r12
            r22 = r13
        L_0x07cf:
            r4 = r0
            r2 = r18
        L_0x07d2:
            r12 = 0
            int r5 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x07e5
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x07e6 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x07e6 }
            long r12 = r12 - r8
            r5.DurationHttpReceive = r12     // Catch:{ Exception -> 0x07e6 }
            com.umlaut.crowd.internal.g1 r5 = r1.f     // Catch:{ Exception -> 0x07e6 }
            r5.BytesRead = r2     // Catch:{ Exception -> 0x07e6 }
        L_0x07e5:
            throw r4     // Catch:{ Exception -> 0x07e6 }
        L_0x07e6:
            r0 = move-exception
            goto L_0x07ef
        L_0x07e8:
            r0 = move-exception
            r33 = r3
            r21 = r12
            r22 = r13
        L_0x07ef:
            r2 = r0
            r4 = 1
            goto L_0x07fb
        L_0x07f2:
            r0 = move-exception
            r33 = r3
            r21 = r12
            r22 = r13
            r2 = r0
        L_0x07fa:
            r4 = 0
        L_0x07fb:
            r3 = r33
            goto L_0x0817
        L_0x07fe:
            r0 = move-exception
            r21 = r12
            goto L_0x0812
        L_0x0802:
            r0 = move-exception
            r21 = r8
            r30 = r9
            goto L_0x0812
        L_0x0808:
            r0 = move-exception
            r2 = r0
            goto L_0x083f
        L_0x080b:
            r0 = move-exception
            r21 = r8
            r30 = r9
            r20 = r12
        L_0x0812:
            r22 = r13
            r2 = r0
            r3 = 0
            r4 = 0
        L_0x0817:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0808 }
            java.lang.String r2 = r1.a((java.lang.String) r2)     // Catch:{ all -> 0x0808 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0808 }
            r5.<init>()     // Catch:{ all -> 0x0808 }
            com.umlaut.crowd.internal.g1 r7 = r1.f     // Catch:{ all -> 0x0808 }
            java.lang.String r8 = r7.ErrorReason     // Catch:{ all -> 0x0808 }
            r5.append(r8)     // Catch:{ all -> 0x0808 }
            r5.append(r2)     // Catch:{ all -> 0x0808 }
            r5.append(r11)     // Catch:{ all -> 0x0808 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0808 }
            r7.ErrorReason = r2     // Catch:{ all -> 0x0808 }
            if (r6 == 0) goto L_0x084f
            r6.close()     // Catch:{ Exception -> 0x083d }
            goto L_0x084f
        L_0x083d:
            goto L_0x084f
        L_0x083f:
            if (r6 == 0) goto L_0x0844
            r6.close()     // Catch:{ Exception -> 0x0844 }
        L_0x0844:
            throw r2
        L_0x0845:
            r21 = r8
            r30 = r9
            r20 = r12
            r22 = r13
            r3 = 0
            r4 = 0
        L_0x084f:
            com.umlaut.crowd.internal.g1 r2 = r1.f
            boolean r5 = r2 instanceof com.umlaut.crowd.internal.e1
            if (r5 == 0) goto L_0x086e
            com.umlaut.crowd.internal.x1 r5 = r1.u
            if (r5 == 0) goto L_0x086e
            r6 = r2
            com.umlaut.crowd.internal.e1 r6 = (com.umlaut.crowd.internal.e1) r6
            com.umlaut.crowd.internal.x1 r7 = r6.DbIceTripInfo
            java.lang.String r8 = r5.Vzn
            r7.Vzn = r8
            com.umlaut.crowd.internal.x1 r7 = r6.DbIceTripInfo
            java.lang.String r8 = r5.TrainType
            r7.TrainType = r8
            com.umlaut.crowd.internal.x1 r6 = r6.DbIceTripInfo
            java.lang.String r5 = r5.FinalStationName
            r6.FinalStationName = r5
        L_0x086e:
            com.umlaut.crowd.internal.l7 r5 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.DRI r5 = r5.getRadioInfoForDefaultDataSim()
            r2.RadioInfoOnEnd = r5
            com.umlaut.crowd.internal.g1 r2 = r1.f
            long r5 = android.os.SystemClock.uptimeMillis()
            long r5 = r5 - r27
            r2.DurationOverallNoSleep = r5
            com.umlaut.crowd.internal.g1 r2 = r1.f
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r5 = r5 - r22
            r2.DurationOverall = r5
            com.umlaut.crowd.internal.g1 r2 = r1.f
            android.content.Context r5 = r1.a
            com.umlaut.crowd.internal.w3 r5 = com.umlaut.crowd.internal.CDC.c((android.content.Context) r5)
            r2.IdleStateOnEnd = r5
            com.umlaut.crowd.internal.g1 r2 = r1.f
            int r5 = r30.size()
            com.umlaut.crowd.internal.x5[] r5 = new com.umlaut.crowd.internal.x5[r5]
            r8 = r30
            java.lang.Object[] r5 = r8.toArray(r5)
            com.umlaut.crowd.internal.x5[] r5 = (com.umlaut.crowd.internal.x5[]) r5
            r2.MultiCdnInfo = r5
            com.umlaut.crowd.internal.g1 r2 = r1.f
            r5 = r21
            long r5 = (long) r5
            r7 = r20
            long r7 = (long) r7
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            r11 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r9 = java.lang.Math.pow(r11, r9)
            long r9 = java.lang.Math.round(r9)
            long r7 = r7 * r9
            long r5 = r5 + r7
            r7 = r16
            long r7 = (long) r7
            r9 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r9 = java.lang.Math.pow(r11, r9)
            long r9 = java.lang.Math.round(r9)
            long r7 = r7 * r9
            long r5 = r5 + r7
            long r7 = (long) r3
            r9 = 4618441417868443648(0x4018000000000000, double:6.0)
            double r9 = java.lang.Math.pow(r11, r9)
            long r9 = java.lang.Math.round(r9)
            long r7 = r7 * r9
            long r5 = r5 + r7
            r2.ServerMultiSuccess = r5
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x08f9
            com.umlaut.crowd.internal.g1 r2 = r1.f
            java.lang.String r2 = r2.DnsServer
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x08f9
            com.umlaut.crowd.internal.g1 r2 = r1.f
            android.content.Context r3 = r1.a
            java.lang.String r3 = com.umlaut.crowd.internal.h2.a((android.content.Context) r3)
            r2.DnsServer = r3
        L_0x08f9:
            com.umlaut.crowd.internal.g1 r2 = r1.f
            java.lang.String r2 = r2.AirportCode
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x090d
            com.umlaut.crowd.internal.g1 r2 = r1.f
            java.lang.String r3 = r2.ServerIp
            java.lang.String r3 = com.umlaut.crowd.internal.f9.b(r3)
            r2.AirportCode = r3
        L_0x090d:
            com.umlaut.crowd.internal.g1 r2 = r1.f
            com.umlaut.crowd.internal.e4 r3 = r2.IspInfo
            boolean r3 = r3.SuccessfulIspLookup
            if (r3 != 0) goto L_0x0928
            android.content.Context r3 = r1.a
            com.umlaut.crowd.internal.g3 r3 = com.umlaut.crowd.internal.g3.a((android.content.Context) r3)
            com.umlaut.crowd.internal.g1 r5 = r1.f
            com.umlaut.crowd.internal.DRI r6 = r5.RadioInfo
            com.umlaut.crowd.internal.DWI r5 = r5.WifiInfo
            r7 = 0
            com.umlaut.crowd.internal.e4 r3 = r3.a(r6, r5, r7)
            r2.IspInfo = r3
        L_0x0928:
            com.umlaut.crowd.internal.g1 r2 = r1.f
            com.umlaut.crowd.internal.e4 r3 = r2.IspInfo
            boolean r3 = r3.SuccessfulIspLookup
            if (r3 != 0) goto L_0x0950
            if (r4 == 0) goto L_0x0950
            com.umlaut.crowd.internal.DRI r2 = r2.RadioInfo
            com.umlaut.crowd.enums.ConnectionTypes r2 = r2.ConnectionType
            boolean r2 = com.umlaut.crowd.internal.g3.a((com.umlaut.crowd.enums.ConnectionTypes) r2)
            if (r2 == 0) goto L_0x0950
            com.umlaut.crowd.internal.g1 r2 = r1.f
            android.content.Context r3 = r1.a
            com.umlaut.crowd.internal.g3 r3 = com.umlaut.crowd.internal.g3.a((android.content.Context) r3)
            com.umlaut.crowd.internal.g1 r4 = r1.f
            com.umlaut.crowd.internal.DRI r5 = r4.RadioInfo
            com.umlaut.crowd.internal.DWI r4 = r4.WifiInfo
            com.umlaut.crowd.internal.e4 r3 = r3.a((com.umlaut.crowd.internal.DRI) r5, (com.umlaut.crowd.internal.DWI) r4)
            r2.IspInfo = r3
        L_0x0950:
            com.umlaut.crowd.internal.g1 r2 = r1.f
            com.umlaut.crowd.internal.q4 r2 = r2.LocationInfo
            com.umlaut.crowd.internal.s4 r2 = r2.LocationProvider
            com.umlaut.crowd.internal.s4 r3 = com.umlaut.crowd.internal.s4.Unknown
            if (r2 != r3) goto L_0x096e
            com.umlaut.crowd.IC r2 = com.umlaut.crowd.InsightCore.getInsightConfig()
            boolean r2 = r2.z()
            if (r2 != 0) goto L_0x096e
            com.umlaut.crowd.internal.g1 r2 = r1.f
            com.umlaut.crowd.internal.CLC r3 = r1.b
            com.umlaut.crowd.internal.q4 r3 = r3.getLastLocationInfo()
            r2.LocationInfo = r3
        L_0x096e:
            int r2 = r29.size()
            if (r2 <= 0) goto L_0x0979
            r9 = r29
            r1.a((java.util.List<com.umlaut.crowd.internal.CC>) r9)
        L_0x0979:
            com.umlaut.crowd.IC r2 = com.umlaut.crowd.InsightCore.getInsightConfig()
            boolean r2 = r2.s0()
            if (r2 == 0) goto L_0x0998
            com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.InsightCore.getWifiController()
            java.util.ArrayList r2 = r2.b()
            com.umlaut.crowd.internal.g1 r3 = r1.f
            r14 = 0
            com.umlaut.crowd.internal.c1[] r4 = new com.umlaut.crowd.internal.c1[r14]
            java.lang.Object[] r2 = r2.toArray(r4)
            com.umlaut.crowd.internal.c1[] r2 = (com.umlaut.crowd.internal.c1[]) r2
            r3.ConnectedDevicesInfo = r2
        L_0x0998:
            com.umlaut.crowd.internal.g1 r2 = r1.f
            return r2
        L_0x099b:
            r0 = move-exception
            r8 = r9
            goto L_0x0a12
        L_0x099f:
            r0 = move-exception
            r31 = r9
            r9 = r8
            r8 = r31
            r13 = r33
            r23 = r5
            r20 = r15
            goto L_0x09f8
        L_0x09ac:
            r0 = move-exception
            r15 = r13
            r26 = r14
            r31 = r9
            r9 = r8
            r8 = r31
            r13 = r33
            r23 = r5
            goto L_0x09c5
        L_0x09ba:
            r0 = move-exception
            r15 = r13
            r26 = r14
            r31 = r9
            r9 = r8
            r8 = r31
            r13 = r33
        L_0x09c5:
            r20 = r15
            r12 = r16
            r5 = r22
            goto L_0x0a25
        L_0x09cd:
            r0 = move-exception
            r22 = r5
            r15 = r13
            r26 = r14
            r31 = r9
            r9 = r8
            r8 = r31
            r13 = r33
            r20 = r15
            goto L_0x0a0b
        L_0x09dd:
            r22 = r5
            r26 = r14
            r14 = 0
            r31 = r9
            r9 = r8
            r8 = r31
            r12 = -1
            r15.DurationDNS = r12     // Catch:{ Exception -> 0x09f5, all -> 0x09f3 }
            java.util.concurrent.TimeoutException r5 = new java.util.concurrent.TimeoutException     // Catch:{ Exception -> 0x09f5, all -> 0x09f3 }
            java.lang.String r10 = "DNS Timeout"
            r5.<init>(r10)     // Catch:{ Exception -> 0x09f5, all -> 0x09f3 }
            throw r5     // Catch:{ Exception -> 0x09f5, all -> 0x09f3 }
        L_0x09f3:
            r0 = move-exception
            goto L_0x0a12
        L_0x09f5:
            r0 = move-exception
            r13 = r33
        L_0x09f8:
            r12 = r16
            r5 = r22
            r14 = r26
            goto L_0x0a25
        L_0x09ff:
            r0 = move-exception
            r22 = r5
            r26 = r14
            r31 = r9
            r9 = r8
            r8 = r31
            r13 = r33
        L_0x0a0b:
            r12 = r16
            goto L_0x0a25
        L_0x0a0e:
            r0 = move-exception
            r8 = r9
            r26 = r14
        L_0x0a12:
            r1 = r0
            r5 = r26
            goto L_0x0acd
        L_0x0a17:
            r0 = move-exception
            r22 = r5
            r16 = r12
            r33 = r13
            r26 = r14
            r31 = r9
            r9 = r8
            r8 = r31
        L_0x0a25:
            r15 = r27
            r10 = 0
            r26 = r6
            goto L_0x0a8b
        L_0x0a2c:
            r0 = move-exception
            r14 = 0
            r31 = r9
            r9 = r8
            r8 = r31
            r6 = r0
            r12 = r10
            goto L_0x0a51
        L_0x0a36:
            r0 = move-exception
            goto L_0x0a41
        L_0x0a38:
            r0 = move-exception
            r13 = r33
            goto L_0x0a41
        L_0x0a3c:
            r0 = move-exception
            r13 = r33
            r27 = r15
        L_0x0a41:
            r14 = 0
            goto L_0x0a4b
        L_0x0a43:
            r0 = move-exception
            r24 = r13
            r27 = r15
            r14 = 0
            r13 = r33
        L_0x0a4b:
            r31 = r9
            r9 = r8
            r8 = r31
            r6 = r0
        L_0x0a51:
            r17 = 0
        L_0x0a53:
            r14 = r17
            r26 = r22
            r15 = r27
            goto L_0x0a72
        L_0x0a5a:
            r0 = move-exception
            r23 = r6
            r24 = r13
            r27 = r15
            goto L_0x0a67
        L_0x0a62:
            r0 = move-exception
            r23 = r6
            r24 = r13
        L_0x0a67:
            r14 = 0
            r13 = r33
            r31 = r9
            r9 = r8
            r8 = r31
            r6 = r0
            r26 = r21
        L_0x0a72:
            r10 = 0
            goto L_0x0a8c
        L_0x0a74:
            r0 = move-exception
            r8 = r9
            r14 = 0
            r1 = r0
        L_0x0a78:
            r5 = 0
            goto L_0x0acd
        L_0x0a7a:
            r0 = move-exception
            r23 = r6
            r10 = 0
            r6 = r33
            r31 = r9
            r9 = r8
            r8 = r31
            r24 = r13
            r26 = r21
            r14 = 0
            r13 = r6
        L_0x0a8b:
            r6 = r0
        L_0x0a8c:
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0aca }
            java.lang.String r6 = r1.a((java.lang.String) r6)     // Catch:{ all -> 0x0aca }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0aca }
            r10.<init>()     // Catch:{ all -> 0x0aca }
            r21 = r2
            com.umlaut.crowd.internal.g1 r2 = r1.f     // Catch:{ all -> 0x0aca }
            java.lang.String r1 = r2.ErrorReason     // Catch:{ all -> 0x0aca }
            r10.append(r1)     // Catch:{ all -> 0x0aca }
            r10.append(r6)     // Catch:{ all -> 0x0aca }
            r10.append(r11)     // Catch:{ all -> 0x0aca }
            java.lang.String r1 = r10.toString()     // Catch:{ all -> 0x0aca }
            r2.ErrorReason = r1     // Catch:{ all -> 0x0aca }
            if (r14 == 0) goto L_0x0ab3
            r8.add(r4)
        L_0x0ab3:
            r1 = 1
            int r5 = r5 + r1
            r1 = r32
            r33 = r13
            r10 = r20
            r2 = r21
            r6 = r23
            r13 = r24
            r11 = r26
            r31 = r9
            r9 = r8
            r8 = r31
            goto L_0x02e5
        L_0x0aca:
            r0 = move-exception
            r1 = r0
            r5 = r14
        L_0x0acd:
            if (r5 == 0) goto L_0x0ad2
            r8.add(r4)
        L_0x0ad2:
            throw r1
        L_0x0ad3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CT.a(com.umlaut.crowd.internal.a):com.umlaut.crowd.internal.g1");
    }

    private void b() {
        OCTL octl = this.e;
        if (octl != null) {
            octl.onConnectivityTestStart();
        }
        InsightCore.OnConnectivityTestListener onConnectivityTestListener = InsightCore.getOnConnectivityTestListener();
        this.h = onConnectivityTestListener;
        if (onConnectivityTestListener != null) {
            onConnectivityTestListener.onConnectivityTestStart();
        }
        w4.a(v4.ConnectivityTest, u4.ConnectivityTestStart, (Map<String, String>) null);
        c();
        v.a((Object) this, w2.CT);
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.umlaut.crowd.internal.g1 r14) {
        /*
            r13 = this;
            com.umlaut.crowd.internal.v.a((java.lang.Object) r13)
            com.umlaut.crowd.IS r0 = r13.c
            long r1 = android.os.SystemClock.elapsedRealtime()
            r0.f((long) r1)
            r13.d()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 1
            r2 = 0
            if (r14 == 0) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Executed"
            r0.put(r4, r3)
            if (r14 == 0) goto L_0x0045
            long r3 = r14.DurationDNS
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0030
            r3 = 1
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "DNS"
            r0.put(r4, r3)
            boolean r3 = r14.Success
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Successful"
            r0.put(r4, r3)
        L_0x0045:
            com.umlaut.crowd.internal.v4 r3 = com.umlaut.crowd.internal.v4.ConnectivityTest
            com.umlaut.crowd.internal.u4 r4 = com.umlaut.crowd.internal.u4.ConnectivityTestEnd
            com.umlaut.crowd.internal.w4.a(r3, r4, r0)
            r0 = 0
            if (r14 != 0) goto L_0x005e
            com.umlaut.crowd.InsightCore$OnConnectivityTestListener r14 = r13.h
            if (r14 == 0) goto L_0x0056
            r14.onConnectivityTestEnd(r0)
        L_0x0056:
            com.umlaut.crowd.internal.OCTL r14 = r13.e
            if (r14 == 0) goto L_0x005d
            r14.a()
        L_0x005d:
            return
        L_0x005e:
            boolean r3 = r14 instanceof com.umlaut.crowd.internal.e1     // Catch:{ Exception -> 0x0076 }
            if (r3 == 0) goto L_0x006c
            com.umlaut.crowd.internal.u1 r3 = com.umlaut.crowd.InsightCore.getDatabaseHelper()     // Catch:{ Exception -> 0x0076 }
            com.umlaut.crowd.internal.w2 r4 = com.umlaut.crowd.internal.w2.CTDB     // Catch:{ Exception -> 0x0076 }
            r3.a((com.umlaut.crowd.internal.w2) r4, (com.umlaut.crowd.internal.RBR) r14)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0091
        L_0x006c:
            com.umlaut.crowd.internal.u1 r3 = com.umlaut.crowd.InsightCore.getDatabaseHelper()     // Catch:{ Exception -> 0x0076 }
            com.umlaut.crowd.internal.w2 r4 = com.umlaut.crowd.internal.w2.CT     // Catch:{ Exception -> 0x0076 }
            r3.a((com.umlaut.crowd.internal.w2) r4, (com.umlaut.crowd.internal.RBR) r14)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0091
        L_0x0076:
            r3 = move-exception
            java.lang.String r4 = w
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Error while storing JSON: "
            r5.<init>(r6)
            java.lang.String r6 = r3.getMessage()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5)
            r3.printStackTrace()
        L_0x0091:
            boolean r3 = r13.p
            if (r3 == 0) goto L_0x009c
            com.umlaut.crowd.database.StatsDatabase r3 = com.umlaut.crowd.InsightCore.getStatsDatabase()
            r3.a((com.umlaut.crowd.internal.g1) r14)
        L_0x009c:
            com.umlaut.crowd.IC r3 = com.umlaut.crowd.InsightCore.getInsightConfig()
            boolean r3 = r3.o1()
            if (r3 == 0) goto L_0x00ad
            com.umlaut.crowd.database.StatsDatabase r3 = com.umlaut.crowd.InsightCore.getStatsDatabase()
            r3.b((com.umlaut.crowd.internal.g1) r14)
        L_0x00ad:
            com.umlaut.crowd.IS r3 = r13.c
            boolean r3 = r3.n()
            if (r3 == 0) goto L_0x0132
            java.lang.String r3 = r14.ServerIp
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x011c
            com.umlaut.crowd.internal.v r2 = new com.umlaut.crowd.internal.v
            android.content.Context r3 = r13.a
            r2.<init>(r13, r3)
            r13.g = r2
            r2.a((boolean) r1)
            com.umlaut.crowd.internal.v r2 = r13.g
            java.lang.String r3 = r14.CtId
            r2.i((java.lang.String) r3)
            com.umlaut.crowd.internal.v r2 = r13.g
            java.lang.String r3 = r14.AirportCode
            r2.c((java.lang.String) r3)
            com.umlaut.crowd.internal.v r2 = r13.g
            java.lang.String r3 = r14.ServerHostname
            r2.d((java.lang.String) r3)
            com.umlaut.crowd.internal.v r2 = r13.g
            com.umlaut.crowd.internal.ub r3 = r14.TimeInfo
            long r3 = r3.TimestampMillis
            long r5 = r14.DurationDNS
            long r3 = r3 + r5
            long r5 = r14.DurationTcpConnect
            long r3 = r3 + r5
            long r5 = r14.DurationHttpReceive
            long r3 = r3 + r5
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.g((java.lang.String) r3)
            com.umlaut.crowd.internal.v r2 = r13.g
            com.umlaut.crowd.IC r3 = com.umlaut.crowd.InsightCore.getInsightConfig()
            com.umlaut.crowd.internal.CLC$ProviderMode r3 = r3.M0()
            r2.a((com.umlaut.crowd.internal.CLC.ProviderMode) r3)
            com.umlaut.crowd.internal.v r4 = r13.g
            java.lang.String r5 = r14.ServerIp
            com.umlaut.crowd.internal.a r12 = r14.Trigger
            r6 = 10
            r7 = 200(0xc8, float:2.8E-43)
            r8 = 30000(0x7530, float:4.2039E-41)
            r9 = 56
            r10 = 1
            r11 = 1
            r4.a((java.lang.String) r5, (int) r6, (int) r7, (int) r8, (int) r9, (boolean) r10, (boolean) r11, (com.umlaut.crowd.internal.a) r12)
            com.umlaut.crowd.internal.v4 r2 = com.umlaut.crowd.internal.v4.LatencyTest
            com.umlaut.crowd.internal.u4 r3 = com.umlaut.crowd.internal.u4.LatencyTestStart
            com.umlaut.crowd.internal.w4.a(r2, r3, r0)
            goto L_0x0154
        L_0x011c:
            boolean r0 = r13.t
            if (r0 == 0) goto L_0x0153
            com.umlaut.crowd.IS r0 = com.umlaut.crowd.InsightCore.getInsightSettings()
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0153
            com.umlaut.crowd.internal.nd r0 = com.umlaut.crowd.InsightCore.getUploadManager()
            r0.uploadFiles(r2)
            goto L_0x0153
        L_0x0132:
            com.umlaut.crowd.IS r0 = r13.c
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x0153
            boolean r0 = r14.Success
            if (r0 != 0) goto L_0x0142
            boolean r0 = r13.t
            if (r0 == 0) goto L_0x0153
        L_0x0142:
            com.umlaut.crowd.IS r0 = com.umlaut.crowd.InsightCore.getInsightSettings()
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0153
            com.umlaut.crowd.internal.nd r0 = com.umlaut.crowd.InsightCore.getUploadManager()
            r0.uploadFiles(r2)
        L_0x0153:
            r1 = 0
        L_0x0154:
            com.umlaut.crowd.InsightCore$OnConnectivityTestListener r0 = r13.h
            if (r0 == 0) goto L_0x015b
            r0.onConnectivityTestEnd(r14)
        L_0x015b:
            if (r1 != 0) goto L_0x0164
            com.umlaut.crowd.internal.OCTL r14 = r13.e
            if (r14 == 0) goto L_0x0164
            r14.a()
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CT.a(com.umlaut.crowd.internal.g1):void");
    }

    private List<CC> a(String[] strArr, r1 r1Var) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Set<String> g2 = InsightCore.getInsightSettings().g();
        LinkedList<CC> linkedList3 = new LinkedList<>();
        if (g2 != null) {
            for (String fromJson : g2) {
                CC cc = (CC) JsonUtils.fromJson(fromJson, CC.class);
                if (cc != null) {
                    linkedList3.add(cc);
                }
            }
        }
        for (String str : strArr) {
            CC cc2 = new CC();
            cc2.address = str;
            linkedList2.add(cc2);
        }
        for (CC cc3 : linkedList3) {
            for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                if (((CC) linkedList2.get(i2)).address.equals(cc3.address)) {
                    linkedList2.set(i2, cc3);
                }
            }
        }
        switch (f.a[r1Var.ordinal()]) {
            case 1:
                return linkedList2;
            case 2:
                Collections.shuffle(linkedList2, new Random(System.nanoTime()));
                return new LinkedList(linkedList2);
            case 3:
                Collections.sort(linkedList2, new b());
                return new LinkedList(linkedList2);
            case 4:
                Collections.sort(linkedList2, new c());
                return new LinkedList(linkedList2);
            case 5:
                Collections.sort(linkedList2, new d());
                return new LinkedList(linkedList2);
            case 6:
                Collections.sort(linkedList2, new e());
                return new LinkedList(linkedList2);
            default:
                return linkedList;
        }
    }

    private void a(List<CC> list) {
        HashSet hashSet = new HashSet();
        for (CC cc : list) {
            hashSet.add(cc.toString());
        }
        InsightCore.getInsightSettings().a((Set<String>) hashSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e A[SYNTHETIC, Splitter:B:25:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005b A[SYNTHETIC, Splitter:B:31:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a() {
        /*
            r4 = this;
            java.lang.String r0 = "ping -W 3 -c 1 -s 56 127.0.0.1"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0048 }
            java.lang.Process r0 = r2.exec(r0)     // Catch:{ IOException -> 0x0048 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0048 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0048 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0048 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0048 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0048 }
            r2.readLine()     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            if (r0 == 0) goto L_0x003d
            int r1 = r0.length()     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            if (r1 <= 0) goto L_0x003d
            java.lang.String r1 = " "
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            int r0 = r0.length     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            r1 = 8
            if (r0 != r1) goto L_0x003d
            r2.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003b:
            r0 = 1
            return r0
        L_0x003d:
            r2.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0041:
            r0 = move-exception
            goto L_0x0059
        L_0x0043:
            r0 = move-exception
            r1 = r2
            goto L_0x0049
        L_0x0046:
            r0 = move-exception
            goto L_0x0058
        L_0x0048:
            r0 = move-exception
        L_0x0049:
            r0.printStackTrace()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0056:
            r0 = 0
            return r0
        L_0x0058:
            r2 = r1
        L_0x0059:
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0063:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CT.a():boolean");
    }

    private String a(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replaceAll("(?:[0-9]{1,3}\\.){3}[0-9]{1,3}", "XXX").replaceAll("([A-Fa-f0-9]{1,4}::?){1,7}[A-Fa-f0-9]{1,4}", "XXX");
    }
}
