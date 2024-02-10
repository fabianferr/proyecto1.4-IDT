package com.umlaut.crowd.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.speedtest.SpeedtestEngineError;
import com.umlaut.crowd.speedtest.SpeedtestEngineStatus;
import com.umlaut.crowd.threads.ThreadManager;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class bc {
    private static final String q = "bc";
    private static final boolean r = false;
    /* access modifiers changed from: private */
    public Context a;
    /* access modifiers changed from: private */
    public boolean b;
    /* access modifiers changed from: private */
    public int c;
    /* access modifiers changed from: private */
    public String d;
    /* access modifiers changed from: private */
    public String e;
    /* access modifiers changed from: private */
    public boolean f;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public d l;
    /* access modifiers changed from: private */
    public ac m;
    /* access modifiers changed from: private */
    public final HashMap<Object, w2> n;
    /* access modifiers changed from: private */
    public x o;
    /* access modifiers changed from: private */
    public CLC p;

    class a implements Runnable {
        final /* synthetic */ a a;

        /* renamed from: com.umlaut.crowd.internal.bc$a$a  reason: collision with other inner class name */
        class C0175a implements w6 {
            final /* synthetic */ c a;

            C0175a(c cVar) {
                this.a = cVar;
            }

            public void a() {
            }

            public void a(int i, long j) {
            }

            public void a(int i, long j, long j2) {
                c cVar = this.a;
                cVar.d = true;
                cVar.c.add(Long.valueOf(j2));
            }

            public void b(int i, long j, long j2) {
                c cVar = this.a;
                boolean z = j2 <= 0;
                cVar.d = z;
                if (!z) {
                    cVar.c.add(Long.valueOf(j2));
                    this.a.a = bc.this.e;
                }
            }
        }

        a(a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Process} */
        /* JADX WARNING: type inference failed for: r6v1 */
        /* JADX WARNING: type inference failed for: r6v2 */
        /* JADX WARNING: type inference failed for: r6v4, types: [java.io.BufferedReader] */
        /* JADX WARNING: type inference failed for: r6v6 */
        /* JADX WARNING: type inference failed for: r6v7 */
        /* JADX WARNING: type inference failed for: r6v8 */
        /* JADX WARNING: type inference failed for: r6v10 */
        /* JADX WARNING: type inference failed for: r6v16 */
        /* JADX WARNING: type inference failed for: r6v17 */
        /* JADX WARNING: type inference failed for: r6v18 */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0237, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x023a, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x023b, code lost:
            r6 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x023d, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x023e, code lost:
            r6 = r5;
            r5 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0245, code lost:
            r0 = e;
            r6 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0246, code lost:
            r17 = r6;
            r6 = r5;
            r5 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x02a5, code lost:
            r6.destroy();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x02ae, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x02af, code lost:
            r4 = r0;
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x02bf, code lost:
            r5.destroy();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x02c9, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0237 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:21:0x01be] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0245 A[ExcHandler: Exception (e java.lang.Exception), PHI: r5 r6 
          PHI: (r5v22 java.lang.Process) = (r5v15 java.lang.Process), (r5v23 java.lang.Process), (r5v23 java.lang.Process) binds: [B:48:0x0261, B:19:0x01b0, B:20:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v7 ?) = (r6v1 ?), (r6v1 ?), (r6v18 ?) binds: [B:19:0x01b0, B:20:?, B:48:0x0261] A[DONT_GENERATE, DONT_INLINE], Splitter:B:19:0x01b0] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x02a5  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x02aa A[SYNTHETIC, Splitter:B:74:0x02aa] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x02bf  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x02c4 A[SYNTHETIC, Splitter:B:85:0x02c4] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r18 = this;
                r1 = r18
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r2 = new com.umlaut.crowd.internal.ac
                com.umlaut.crowd.IC r3 = com.umlaut.crowd.InsightCore.getInsightConfig()
                java.lang.String r3 = r3.f1()
                java.lang.String r4 = com.umlaut.crowd.InsightCore.getGUID()
                r2.<init>(r3, r4)
                com.umlaut.crowd.internal.ac unused = r0.m = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.a r2 = r1.a
                r0.Trigger = r2
                com.umlaut.crowd.IC r0 = com.umlaut.crowd.InsightCore.getInsightConfig()
                boolean r0 = r0.w1()
                if (r0 == 0) goto L_0x003c
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.l7 r2 = com.umlaut.crowd.InsightCore.getRadioController()
                com.umlaut.crowd.internal.z0[] r2 = r2.d()
                r0.CellInfoOnStart = r2
            L_0x003c:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.ee r2 = com.umlaut.crowd.InsightCore.getWifiController()
                com.umlaut.crowd.internal.DWI r2 = r2.getWifiInfo()
                r0.WifiInfoOnStart = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.l7 r2 = com.umlaut.crowd.InsightCore.getRadioController()
                com.umlaut.crowd.internal.DRI r2 = r2.getRadioInfoForDefaultDataSim()
                r0.RadioInfoOnStart = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                android.content.Context r2 = r2.a
                com.umlaut.crowd.internal.g3 r2 = com.umlaut.crowd.internal.g3.a((android.content.Context) r2)
                com.umlaut.crowd.internal.bc r3 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r3 = r3.m
                com.umlaut.crowd.internal.DRI r3 = r3.RadioInfoOnStart
                com.umlaut.crowd.internal.bc r4 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r4 = r4.m
                com.umlaut.crowd.internal.DWI r4 = r4.WifiInfoOnStart
                com.umlaut.crowd.internal.bc r5 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r5 = r5.m
                com.umlaut.crowd.internal.DRI r5 = r5.RadioInfoOnStart
                com.umlaut.crowd.enums.ConnectionTypes r5 = r5.ConnectionType
                boolean r5 = com.umlaut.crowd.internal.g3.a((com.umlaut.crowd.enums.ConnectionTypes) r5)
                com.umlaut.crowd.internal.e4 r2 = r2.a(r3, r4, r5)
                r0.IspInfo = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                java.lang.String r2 = r2.d
                r0.Server = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                android.content.Context r2 = r2.a
                com.umlaut.crowd.internal.a2 r2 = com.umlaut.crowd.internal.CDC.getDeviceInfo(r2)
                r0.DeviceInfo = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.m5 r2 = com.umlaut.crowd.internal.m5.TRACEROUTE
                r0.MeasurementType = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.x r2 = r2.o
                com.umlaut.crowd.internal.z r2 = r2.a()
                r0.BatteryInfoOnStart = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                android.content.Context r2 = r2.a
                com.umlaut.crowd.internal.n5 r2 = com.umlaut.crowd.internal.CDC.d((android.content.Context) r2)
                r0.MemoryInfoOnStart = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.nc r2 = com.umlaut.crowd.internal.CDC.f()
                r0.TrafficInfoOnStart = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.ub r2 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()
                r0.TimeInfoOnStart = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.d3 r2 = com.umlaut.crowd.InsightCore.getForegroundTestManager()
                int r2 = r2.d()
                r0.IsAppInForeground = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r2 = r2.m
                com.umlaut.crowd.internal.ub r2 = r2.TimeInfoOnStart
                com.umlaut.crowd.internal.bc r3 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r3 = r3.m
                java.lang.String r3 = r3.GUID
                java.lang.String r2 = com.umlaut.crowd.internal.k3.a((com.umlaut.crowd.internal.ub) r2, (java.lang.String) r3)
                r0.TrcId = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                java.lang.String r2 = r2.d
                java.lang.String r2 = com.umlaut.crowd.internal.f9.c(r2)
                r0.Rdns = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.CLC r2 = r2.p
                com.umlaut.crowd.internal.q4 r2 = r2.getLastLocationInfo()
                r0.LocationInfoOnStart = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                java.lang.String r2 = r0.d
                r0.a((java.lang.String) r2)
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                boolean r2 = r2.b
                if (r2 == 0) goto L_0x0160
                com.umlaut.crowd.internal.d4 r2 = com.umlaut.crowd.internal.d4.IPv6
                goto L_0x0162
            L_0x0160:
                com.umlaut.crowd.internal.d4 r2 = com.umlaut.crowd.internal.d4.IPv4
            L_0x0162:
                r0.IpVersion = r2
                java.util.LinkedList r2 = new java.util.LinkedList
                r2.<init>()
                r3 = 1
                r0 = 1
            L_0x016b:
                r4 = 0
                r5 = 0
                if (r0 == 0) goto L_0x02ce
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this
                boolean r7 = r7.j
                if (r7 == 0) goto L_0x018b
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.bc$d r0 = r0.l
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.ABORTED
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK
                r0.onTestStatusChanged(r2, r3, r5)
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                r0.c()
                return
            L_0x018b:
                com.umlaut.crowd.internal.bc r5 = com.umlaut.crowd.internal.bc.this
                int r6 = r5.c
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this
                java.lang.String r7 = r7.e
                r8 = -1082130432(0xffffffffbf800000, float:-1.0)
                java.lang.String r5 = r5.a(r6, r3, r8, r7)
                r6 = 0
                com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                boolean r7 = r7.l()     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                if (r7 == 0) goto L_0x024c
                java.lang.Runtime r7 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                java.lang.Process r5 = r7.exec(r5)     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0245, all -> 0x023d }
                java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0245, all -> 0x023d }
                java.io.InputStream r9 = r5.getInputStream()     // Catch:{ Exception -> 0x0245, all -> 0x023d }
                r8.<init>(r9)     // Catch:{ Exception -> 0x0245, all -> 0x023d }
                r7.<init>(r8)     // Catch:{ Exception -> 0x0245, all -> 0x023d }
                r7.readLine()     // Catch:{ Exception -> 0x023a, all -> 0x0237 }
                java.lang.String r8 = r7.readLine()     // Catch:{ Exception -> 0x023a, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r9 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x023a, all -> 0x0237 }
                com.umlaut.crowd.internal.bc$c r9 = r9.c((java.lang.String) r8)     // Catch:{ Exception -> 0x023a, all -> 0x0237 }
                if (r8 != 0) goto L_0x01dd
                com.umlaut.crowd.internal.bc r8 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x023a, all -> 0x0237 }
                java.lang.String r8 = r8.e     // Catch:{ Exception -> 0x023a, all -> 0x0237 }
                if (r8 == 0) goto L_0x01dd
                int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x023a, all -> 0x0237 }
                r10 = 21
                if (r8 < r10) goto L_0x01dd
                r8 = 1
                goto L_0x01de
            L_0x01dd:
                r8 = 0
            L_0x01de:
                if (r8 == 0) goto L_0x0235
                com.umlaut.crowd.internal.bc$c r8 = new com.umlaut.crowd.internal.bc$c     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r10 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r8.<init>(r10, r6)     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r6 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                int r6 = r6.c     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r8.b = r6     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r6 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                java.lang.String r6 = r6.e     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                java.net.InetAddress r11 = java.net.InetAddress.getByName(r6)     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.e r6 = new com.umlaut.crowd.internal.e     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r10 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                int r12 = r10.h     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r10 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                int r10 = r10.i     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r13 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                int r13 = r13.h     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                int r13 = r10 / r13
                com.umlaut.crowd.internal.bc r10 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                int r14 = r10.i     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r15 = 56
                r16 = 1
                r10 = r6
                r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc r10 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                int r10 = r10.c     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r6.a((int) r10)     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                com.umlaut.crowd.internal.bc$a$a r10 = new com.umlaut.crowd.internal.bc$a$a     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r10.<init>(r8)     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r6.a((com.umlaut.crowd.internal.w6) r10)     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r6.c()     // Catch:{ Exception -> 0x0234, all -> 0x0237 }
                r6 = r7
                r9 = r8
                goto L_0x025e
            L_0x0234:
            L_0x0235:
                r6 = r7
                goto L_0x025e
            L_0x0237:
                r0 = move-exception
                goto L_0x0299
            L_0x023a:
                r0 = move-exception
                r6 = r7
                goto L_0x0246
            L_0x023d:
                r0 = move-exception
                r17 = r6
                r6 = r5
                r5 = r17
                goto L_0x02ba
            L_0x0245:
                r0 = move-exception
            L_0x0246:
                r17 = r6
                r6 = r5
                r5 = r17
                goto L_0x02a0
            L_0x024c:
                com.umlaut.crowd.internal.bc$c r9 = new com.umlaut.crowd.internal.bc$c     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                com.umlaut.crowd.internal.bc r5 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                r9.<init>(r5, r6)     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                com.umlaut.crowd.internal.bc r5 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                int r5 = r5.c     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                r9.b = r5     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                r9.d = r3     // Catch:{ Exception -> 0x029e, all -> 0x029b }
                r5 = r6
            L_0x025e:
                if (r9 != 0) goto L_0x0261
                goto L_0x0282
            L_0x0261:
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                r7.a((com.umlaut.crowd.internal.bc.c) r9)     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                r2.add(r9)     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                com.umlaut.crowd.internal.bc.d(r7)     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                boolean r7 = r9.d     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                if (r7 == 0) goto L_0x0282
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                int r7 = r7.c     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                com.umlaut.crowd.internal.bc r8 = com.umlaut.crowd.internal.bc.this     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                int r8 = r8.g     // Catch:{ Exception -> 0x0245, all -> 0x0297 }
                if (r7 <= r8) goto L_0x0281
                goto L_0x0282
            L_0x0281:
                r4 = r0
            L_0x0282:
                if (r5 == 0) goto L_0x0287
                r5.destroy()
            L_0x0287:
                if (r6 == 0) goto L_0x0294
                r6.close()     // Catch:{ IOException -> 0x028d }
                goto L_0x0294
            L_0x028d:
                r0 = move-exception
                r17 = r4
                r4 = r0
                r0 = r17
                goto L_0x02b1
            L_0x0294:
                r0 = r4
                goto L_0x016b
            L_0x0297:
                r0 = move-exception
                r7 = r6
            L_0x0299:
                r2 = r0
                goto L_0x02bd
            L_0x029b:
                r0 = move-exception
                r5 = r6
                goto L_0x02ba
            L_0x029e:
                r0 = move-exception
                r5 = r6
            L_0x02a0:
                r0.printStackTrace()     // Catch:{ all -> 0x02b9 }
                if (r6 == 0) goto L_0x02a8
                r6.destroy()
            L_0x02a8:
                if (r5 == 0) goto L_0x02b6
                r5.close()     // Catch:{ IOException -> 0x02ae }
                goto L_0x02b6
            L_0x02ae:
                r0 = move-exception
                r4 = r0
                r0 = 0
            L_0x02b1:
                r4.printStackTrace()
                goto L_0x016b
            L_0x02b6:
                r0 = 0
                goto L_0x016b
            L_0x02b9:
                r0 = move-exception
            L_0x02ba:
                r2 = r0
                r7 = r5
                r5 = r6
            L_0x02bd:
                if (r5 == 0) goto L_0x02c2
                r5.destroy()
            L_0x02c2:
                if (r7 == 0) goto L_0x02cd
                r7.close()     // Catch:{ IOException -> 0x02c8 }
                goto L_0x02cd
            L_0x02c8:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
            L_0x02cd:
                throw r2
            L_0x02ce:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                int r7 = r2.size()
                int unused = r0.k = r7
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.bc$d r0 = r0.l
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r7 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.TRACEROUTE
                com.umlaut.crowd.speedtest.SpeedtestEngineError r8 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK
                r0.onTestStatusChanged(r7, r8, r5)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r7 = r2.iterator()
            L_0x02ed:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x03a3
                java.lang.Object r8 = r7.next()
                com.umlaut.crowd.internal.bc$c r8 = (com.umlaut.crowd.internal.bc.c) r8
                com.umlaut.crowd.internal.bc r9 = com.umlaut.crowd.internal.bc.this
                boolean r9 = r9.j
                if (r9 == 0) goto L_0x0314
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.bc$d r0 = r0.l
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.ABORTED
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK
                r0.onTestStatusChanged(r2, r3, r5)
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                r0.c()
                return
            L_0x0314:
                com.umlaut.crowd.internal.y7 r9 = new com.umlaut.crowd.internal.y7
                r9.<init>()
                com.umlaut.crowd.internal.q4 r10 = r8.h
                r9.LocationInfo = r10
                com.umlaut.crowd.internal.ub r10 = r8.g
                r9.TimeInfo = r10
                com.umlaut.crowd.internal.DRI r10 = r8.e
                r9.RadioInfo = r10
                com.umlaut.crowd.internal.DWI r10 = r8.f
                r9.WifiInfo = r10
                int r10 = r8.b
                r9.Hop = r10
                com.umlaut.crowd.internal.bc r10 = com.umlaut.crowd.internal.bc.this
                int r10 = r10.h
                r9.Pings = r10
                boolean r10 = r8.d
                r9.IsIntermediate = r10
                java.util.ArrayList<java.lang.Long> r10 = r8.c
                int r10 = r10.size()
                if (r10 <= 0) goto L_0x0370
                java.util.ArrayList<java.lang.Long> r10 = r8.c
                int r10 = r10.size()
                r9.SuccessfulPings = r10
                java.util.ArrayList<java.lang.Long> r10 = r8.c
                long r10 = com.umlaut.crowd.internal.v9.d(r10)
                int r10 = com.umlaut.crowd.internal.i1.a((long) r10)
                double r10 = (double) r10
                r9.Latency = r10
                java.util.ArrayList<java.lang.Long> r10 = r8.c
                long r10 = com.umlaut.crowd.internal.v9.e(r10)
                int r10 = com.umlaut.crowd.internal.i1.a((long) r10)
                double r10 = (double) r10
                r9.LatencyMin = r10
                java.util.ArrayList<java.lang.Long> r10 = r8.c
                long r10 = com.umlaut.crowd.internal.v9.c(r10)
                int r10 = com.umlaut.crowd.internal.i1.a((long) r10)
                double r10 = (double) r10
                r9.LatencyMax = r10
            L_0x0370:
                java.lang.String r10 = r8.a
                r9.Ip = r10
                int r11 = r8.b
                r12 = 3
                if (r11 >= r12) goto L_0x0389
                int r10 = r10.length()
                if (r10 <= 0) goto L_0x0389
                java.lang.String r10 = r9.Ip
                r11 = 10
                java.lang.String r10 = com.umlaut.crowd.internal.a4.a(r10, r3, r11)
                r9.Ip = r10
            L_0x0389:
                int r10 = r8.b
                r11 = 2
                if (r10 <= r11) goto L_0x039e
                java.lang.String r10 = r8.a
                int r10 = r10.length()
                if (r10 <= 0) goto L_0x039e
                java.lang.String r8 = r8.a
                java.lang.String r8 = com.umlaut.crowd.internal.f9.c(r8)
                r9.Host = r8
            L_0x039e:
                r0.add(r9)
                goto L_0x02ed
            L_0x03a3:
                boolean r7 = com.umlaut.crowd.InsightCore.isInitialized()
                if (r7 != 0) goto L_0x03aa
                return
            L_0x03aa:
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r7 = r7.m
                int r8 = r0.size()
                com.umlaut.crowd.internal.y7[] r8 = new com.umlaut.crowd.internal.y7[r8]
                java.lang.Object[] r0 = r0.toArray(r8)
                com.umlaut.crowd.internal.y7[] r0 = (com.umlaut.crowd.internal.y7[]) r0
                r7.Route = r0
                com.umlaut.crowd.IC r0 = com.umlaut.crowd.InsightCore.getInsightConfig()
                boolean r0 = r0.w1()
                if (r0 == 0) goto L_0x03d8
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()
                com.umlaut.crowd.internal.z0[] r7 = r7.d()
                r0.CellInfoOnEnd = r7
            L_0x03d8:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.x r7 = r7.o
                com.umlaut.crowd.internal.z r7 = r7.a()
                r0.BatteryInfoOnEnd = r7
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this
                android.content.Context r7 = r7.a
                com.umlaut.crowd.internal.n5 r7 = com.umlaut.crowd.internal.CDC.d((android.content.Context) r7)
                r0.MemoryInfoOnEnd = r7
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.nc r7 = com.umlaut.crowd.internal.CDC.f()
                r0.TrafficInfoOnEnd = r7
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.ub r7 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()
                r0.TimeInfoOnEnd = r7
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.ee r7 = com.umlaut.crowd.InsightCore.getWifiController()
                com.umlaut.crowd.internal.DWI r7 = r7.getWifiInfo()
                r0.WifiInfoOnEnd = r7
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.l7 r7 = com.umlaut.crowd.InsightCore.getRadioController()
                com.umlaut.crowd.internal.DRI r7 = r7.getRadioInfoForDefaultDataSim()
                r0.RadioInfoOnEnd = r7
                boolean r0 = r2.isEmpty()
                if (r0 != 0) goto L_0x044c
                java.lang.Object r0 = r2.getLast()
                com.umlaut.crowd.internal.bc$c r0 = (com.umlaut.crowd.internal.bc.c) r0
                boolean r0 = r0.d
                if (r0 != 0) goto L_0x044c
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                r0.Success = r3
            L_0x044c:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.e4 r0 = r0.IspInfo
                boolean r0 = r0.SuccessfulIspLookup
                if (r0 != 0) goto L_0x047e
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                android.content.Context r2 = r2.a
                com.umlaut.crowd.internal.g3 r2 = com.umlaut.crowd.internal.g3.a((android.content.Context) r2)
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r7 = r7.m
                com.umlaut.crowd.internal.DRI r7 = r7.RadioInfoOnStart
                com.umlaut.crowd.internal.bc r8 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r8 = r8.m
                com.umlaut.crowd.internal.DWI r8 = r8.WifiInfoOnStart
                com.umlaut.crowd.internal.e4 r2 = r2.a(r7, r8, r4)
                r0.IspInfo = r2
            L_0x047e:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                com.umlaut.crowd.internal.bc r2 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.CLC r2 = r2.p
                com.umlaut.crowd.internal.q4 r2 = r2.getLastLocationInfo()
                r0.LocationInfoOnEnd = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r2 = r0.m
                r0.a((com.umlaut.crowd.internal.ac) r2)
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                java.util.ArrayList r2 = new java.util.ArrayList
                com.umlaut.crowd.internal.bc r7 = com.umlaut.crowd.internal.bc.this
                java.util.HashMap r7 = r7.n
                java.util.Collection r7 = r7.values()
                r2.<init>(r7)
                r7 = 44
                java.lang.String r2 = com.umlaut.crowd.internal.aa.a(r2, r7, r3)
                r0.TestsInProgress = r2
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.v.a((java.lang.Object) r0)
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                boolean r0 = r0.j
                if (r0 != 0) goto L_0x04e9
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.ac r0 = r0.m
                boolean r0 = r0.Success
                if (r0 == 0) goto L_0x04db
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.bc$d r0 = r0.l
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.END
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK
                r0.onTestStatusChanged(r2, r3, r5)
                goto L_0x04f6
            L_0x04db:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.bc$d r0 = r0.l
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.ERROR
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK
                r0.onTestStatusChanged(r2, r3, r5)
                goto L_0x04f6
            L_0x04e9:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                com.umlaut.crowd.internal.bc$d r0 = r0.l
                com.umlaut.crowd.speedtest.SpeedtestEngineStatus r2 = com.umlaut.crowd.speedtest.SpeedtestEngineStatus.ABORTED
                com.umlaut.crowd.speedtest.SpeedtestEngineError r3 = com.umlaut.crowd.speedtest.SpeedtestEngineError.OK
                r0.onTestStatusChanged(r2, r3, r5)
            L_0x04f6:
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                boolean unused = r0.f = r4
                com.umlaut.crowd.internal.bc r0 = com.umlaut.crowd.internal.bc.this
                r0.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.bc.a.run():void");
        }
    }

    static /* synthetic */ class b {
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
                com.umlaut.crowd.enums.NetworkGenerations[] r0 = com.umlaut.crowd.enums.NetworkGenerations.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen2     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5NSA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Gen5SA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.enums.NetworkGenerations r1 = com.umlaut.crowd.enums.NetworkGenerations.Unknown     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.bc.b.<clinit>():void");
        }
    }

    public interface d {
        void onTestStatusChanged(SpeedtestEngineStatus speedtestEngineStatus, SpeedtestEngineError speedtestEngineError, long j);

        void onTracerouteProgress(float f, String str, int i, int i2);
    }

    public bc(Context context, d dVar) {
        this.b = false;
        this.c = 1;
        this.d = "";
        this.e = "";
        this.n = new HashMap<>();
        this.a = context;
        this.o = new x(context);
        this.p = new CLC(context);
        this.l = dVar;
        this.g = InsightCore.getInsightConfig().z1();
        this.h = InsightCore.getInsightConfig().x1();
        this.i = InsightCore.getInsightConfig().y1();
    }

    static /* synthetic */ int d(bc bcVar) {
        int i2 = bcVar.c;
        bcVar.c = i2 + 1;
        return i2;
    }

    public void c(int i2) {
        this.i = i2;
    }

    public void d() {
        this.p.stopListening();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.g = InsightCore.getInsightConfig().z1();
        this.h = InsightCore.getInsightConfig().x1();
        this.i = InsightCore.getInsightConfig().y1();
    }

    public void b(int i2) {
        this.h = i2;
    }

    public ac b() {
        return this.m;
    }

    private String b(String str) {
        if (str.endsWith(CertificateUtil.DELIMITER)) {
            return str.substring(0, str.length() - 1).replace("(", "").replace(")", "");
        }
        return str.contains("(") ? str.substring(0, str.indexOf("(")) : str;
    }

    /* access modifiers changed from: private */
    public c c(String str) {
        if (str == null) {
            return null;
        }
        c cVar = new c(this, (a) null);
        cVar.b = this.c;
        cVar.d = true;
        if (!str.isEmpty()) {
            String[] split = str.trim().split(" +");
            if (str.contains("exceeded")) {
                if (split.length > 6) {
                    cVar.a = b(split[split.length - 6]);
                }
            } else if (str.startsWith("From")) {
                if (split.length > 2 && split[2].endsWith(CertificateUtil.DELIMITER)) {
                    cVar.a = b(split[2]);
                } else if (split.length > 1 && split[1].endsWith(CertificateUtil.DELIMITER)) {
                    cVar.a = b(split[1]);
                }
            } else if ((split.length == 8 || split.length == 9) && split[split.length - 2].contains("time")) {
                cVar.a = b(split[split.length - 5]);
                cVar.d = false;
            }
        }
        return cVar;
    }

    public void a(CLC.ProviderMode providerMode) {
        this.p.startListening(providerMode);
    }

    public void a(int i2) {
        this.g = i2;
    }

    private class c {
        String a;
        int b;
        ArrayList<Long> c;
        boolean d;
        DRI e;
        DWI f;
        ub g;
        q4 h;

        private c() {
            this.a = "";
            this.b = -1;
            this.c = new ArrayList<>();
            this.d = true;
            this.e = new DRI();
            this.f = new DWI();
            this.g = new ub();
            this.h = new q4();
        }

        /* synthetic */ c(bc bcVar, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            InetAddress inetAddress = f2.a().a(str, this.i, true).d()[0];
            this.e = inetAddress.getHostAddress();
            if (inetAddress instanceof Inet6Address) {
                this.b = true;
            }
        } catch (UnknownHostException e2) {
            this.e = str;
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public String a(int i2, int i3, float f2, String str) {
        LinkProperties linkProperties;
        String str2 = this.b ? "ping6" : "ping";
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(" -c ");
        sb.append(i3);
        sb.append(" -W ");
        double d2 = (double) this.i;
        Double.isNaN(d2);
        sb.append(d2 / 1000.0d);
        sb.append(" -s 56");
        String sb2 = sb.toString();
        if (i2 > 0) {
            sb2 = sb2 + " -t " + i2;
        }
        if (f2 > 0.0f) {
            sb2 = sb2 + " -i " + f2;
        }
        if (str2.equals("ping6")) {
            String str3 = "";
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                if (connectivityManager != null) {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 23 && this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != -1) {
                        LinkProperties linkProperties2 = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
                        if (linkProperties2 != null) {
                            str3 = linkProperties2.getInterfaceName();
                        }
                    } else if (i4 >= 21) {
                        for (Network network : connectivityManager.getAllNetworks()) {
                            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                            if (!(networkInfo == null || !networkInfo.isConnected() || (linkProperties = connectivityManager.getLinkProperties(network)) == null)) {
                                str3 = linkProperties.getInterfaceName();
                            }
                        }
                    }
                }
                if (str3 != null && !str3.isEmpty()) {
                    sb2 = sb2 + " -I " + str3;
                }
            } catch (Exception e2) {
                Log.e(q, e2.toString());
            }
        }
        return sb2 + " " + str;
    }

    public bc(Context context, d dVar, CLC clc) {
        this(context, dVar);
        if (this.p == null) {
            this.p = new CLC(context);
        } else {
            this.p = clc;
        }
    }

    public void a() {
        this.j = true;
    }

    public void a(String str, a aVar) {
        if (!this.f) {
            this.l.onTestStatusChanged(SpeedtestEngineStatus.INIT_TRACEROUTE, SpeedtestEngineError.OK, 0);
            v.a((Object) this, w2.TRC);
            this.j = false;
            this.f = true;
            this.d = str;
            this.c = 1;
            ThreadManager.getInstance().getCachedThreadPool().execute(new a(aVar));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc A[Catch:{ Exception -> 0x00ed, all -> 0x00eb }, LOOP:1: B:31:0x00c6->B:33:0x00cc, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011d A[SYNTHETIC, Splitter:B:54:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012f A[SYNTHETIC, Splitter:B:63:0x012f] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.umlaut.crowd.internal.bc.c r11) {
        /*
            r10 = this;
            com.umlaut.crowd.internal.ub r0 = com.umlaut.crowd.timeserver.TimeServer.getTimeInfo()
            r11.g = r0
            com.umlaut.crowd.internal.CLC r0 = r10.p
            com.umlaut.crowd.internal.q4 r0 = r0.getLastLocationInfo()
            r11.h = r0
            com.umlaut.crowd.internal.l7 r0 = com.umlaut.crowd.InsightCore.getRadioController()
            com.umlaut.crowd.internal.DRI r0 = r0.getRadioInfoForDefaultDataSim()
            r11.e = r0
            com.umlaut.crowd.internal.ee r0 = com.umlaut.crowd.InsightCore.getWifiController()
            com.umlaut.crowd.internal.DWI r0 = r0.getWifiInfo()
            r11.f = r0
            java.lang.String r0 = r11.a
            boolean r0 = r0.isEmpty()
            r1 = -1
            if (r0 == 0) goto L_0x003a
            com.umlaut.crowd.internal.bc$d r0 = r10.l
            int r2 = r11.b
            float r3 = (float) r2
            int r4 = r10.k
            float r4 = (float) r4
            float r3 = r3 / r4
            java.lang.String r11 = r11.a
            r0.onTracerouteProgress(r3, r11, r2, r1)
            return
        L_0x003a:
            int r0 = r10.h
            java.lang.String r2 = r11.a
            r3 = 1045220557(0x3e4ccccd, float:0.2)
            java.lang.String r0 = r10.a(r1, r0, r3, r2)
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00f8, all -> 0x00f5 }
            java.lang.Process r0 = r3.exec(r0)     // Catch:{ Exception -> 0x00f8, all -> 0x00f5 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            java.io.InputStream r5 = r0.getInputStream()     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r3.readLine()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            r2 = 0
        L_0x0060:
            int r4 = r10.h     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            if (r2 >= r4) goto L_0x00e4
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            if (r4 == 0) goto L_0x00a9
            int r5 = r4.length()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            if (r5 <= 0) goto L_0x00a9
            java.lang.String r5 = " "
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            int r5 = r4.length     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            r6 = 8
            if (r5 == r6) goto L_0x0083
            int r5 = r4.length     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            r6 = 9
            if (r5 != r6) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r5 = -1
            goto L_0x0086
        L_0x0083:
            int r5 = r4.length     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            int r5 = r5 + -2
        L_0x0086:
            r6 = 6
            if (r5 == r6) goto L_0x008c
            r6 = 7
            if (r5 != r6) goto L_0x00a9
        L_0x008c:
            r4 = r4[r5]     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.lang.String r5 = "time="
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            double r4 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            long r4 = java.lang.Math.round(r4)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.util.ArrayList<java.lang.Long> r6 = r11.c     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            r6.add(r7)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            goto L_0x00ab
        L_0x00a9:
            r4 = -1
        L_0x00ab:
            com.umlaut.crowd.internal.bc$d r6 = r10.l     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            int r7 = r11.b     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            float r8 = (float) r7     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            int r9 = r10.k     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            float r9 = (float) r9     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            float r8 = r8 / r9
            java.lang.String r9 = r11.a     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            int r5 = (int) r4     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            r6.onTracerouteProgress(r8, r9, r7, r5)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.util.HashMap r4 = com.umlaut.crowd.internal.v.c()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.util.Set r4 = r4.entrySet()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
        L_0x00c6:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            if (r5 == 0) goto L_0x00e0
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.util.HashMap<java.lang.Object, com.umlaut.crowd.internal.w2> r6 = r10.n     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.lang.Object r7 = r5.getKey()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            r6.put(r7, r5)     // Catch:{ Exception -> 0x00ed, all -> 0x00eb }
            goto L_0x00c6
        L_0x00e0:
            int r2 = r2 + 1
            goto L_0x0060
        L_0x00e4:
            r0.destroy()
            r3.close()     // Catch:{ IOException -> 0x0121 }
            goto L_0x0125
        L_0x00eb:
            r11 = move-exception
            goto L_0x0128
        L_0x00ed:
            r11 = move-exception
            goto L_0x00fb
        L_0x00ef:
            r11 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0127
        L_0x00f3:
            r11 = move-exception
            goto L_0x00fa
        L_0x00f5:
            r11 = move-exception
            r3 = r2
            goto L_0x0127
        L_0x00f8:
            r11 = move-exception
            r0 = r2
        L_0x00fa:
            r3 = r2
        L_0x00fb:
            r2 = r0
            java.lang.String r0 = q     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r1.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = "pingHop: "
            r1.append(r4)     // Catch:{ all -> 0x0126 }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0126 }
            r1.append(r11)     // Catch:{ all -> 0x0126 }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x0126 }
            android.util.Log.e(r0, r11)     // Catch:{ all -> 0x0126 }
            if (r2 == 0) goto L_0x011b
            r2.destroy()
        L_0x011b:
            if (r3 == 0) goto L_0x0125
            r3.close()     // Catch:{ IOException -> 0x0121 }
            goto L_0x0125
        L_0x0121:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0125:
            return
        L_0x0126:
            r11 = move-exception
        L_0x0127:
            r0 = r2
        L_0x0128:
            if (r0 == 0) goto L_0x012d
            r0.destroy()
        L_0x012d:
            if (r3 == 0) goto L_0x0137
            r3.close()     // Catch:{ IOException -> 0x0133 }
            goto L_0x0137
        L_0x0133:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0137:
            goto L_0x0139
        L_0x0138:
            throw r11
        L_0x0139:
            goto L_0x0138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.bc.a(com.umlaut.crowd.internal.bc$c):void");
    }

    /* access modifiers changed from: private */
    public void a(ac acVar) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (y7 y7Var : acVar.Route) {
            DRI dri = y7Var.RadioInfo;
            ConnectionTypes connectionTypes = dri.ConnectionType;
            if (connectionTypes != ConnectionTypes.Unknown) {
                if (connectionTypes == ConnectionTypes.Mobile) {
                    int i10 = b.a[l7.a(dri.NetworkType, dri.NrState, dri.DisplayNetworkType).ordinal()];
                    if (i10 == 1) {
                        i9++;
                    } else if (i10 == 2) {
                        i8++;
                    } else if (i10 == 3) {
                        i7++;
                    } else if (i10 == 4) {
                        i6++;
                    } else if (i10 == 5) {
                        i5++;
                    }
                } else {
                    i4++;
                }
                i2++;
            }
            i3++;
            i2++;
        }
        if (i2 > 0) {
            double d2 = (double) i9;
            double d3 = (double) i2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            acVar.RatShare2G = d2 / d3;
            double d4 = (double) i8;
            Double.isNaN(d4);
            Double.isNaN(d3);
            acVar.RatShare3G = d4 / d3;
            double d5 = (double) i7;
            Double.isNaN(d5);
            Double.isNaN(d3);
            acVar.RatShare4G = d5 / d3;
            double d6 = (double) i6;
            Double.isNaN(d6);
            Double.isNaN(d3);
            acVar.RatShare4G5G = d6 / d3;
            double d7 = (double) i5;
            Double.isNaN(d7);
            Double.isNaN(d3);
            acVar.RatShare5GSA = d7 / d3;
            double d8 = (double) i4;
            Double.isNaN(d8);
            Double.isNaN(d3);
            acVar.RatShareWiFi = d8 / d3;
            double d9 = (double) i3;
            Double.isNaN(d9);
            Double.isNaN(d3);
            acVar.RatShareUnknown = d9 / d3;
        }
    }
}
