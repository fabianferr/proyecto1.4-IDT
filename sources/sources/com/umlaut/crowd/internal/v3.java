package com.umlaut.crowd.internal;

import android.content.Context;
import java.util.concurrent.CountDownLatch;

public class v3 extends x6 {
    public static final String i = "v3";
    private static final boolean j = false;
    private final int h;

    class a implements Runnable {
        private int a;
        final /* synthetic */ CountDownLatch b;

        a(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        public void run() {
            if (v3.this.g) {
                while (this.b.getCount() > 0) {
                    this.b.countDown();
                }
            } else if (this.a < v3.this.d) {
                w6 d = v3.this.b;
                int i = this.a;
                int i2 = i + 1;
                this.a = i2;
                d.a(i, ((long) (i2 - 1)) * ((long) v3.this.e));
                this.b.countDown();
            }
        }
    }

    class b implements w6 {
        final /* synthetic */ e a;

        b(e eVar) {
            this.a = eVar;
        }

        public void a() {
        }

        public void a(int i, long j, long j2) {
            v3.this.b.b(i, j, -1);
        }

        public void b(int i, long j, long j2) {
            v3.this.b.b(i, j, j2);
            if (v3.this.g) {
                this.a.b();
            }
        }

        public void a(int i, long j) {
            v3.this.b.a(i, j);
            if (v3.this.g) {
                this.a.b();
            }
        }
    }

    public v3(Context context, w6 w6Var, String str, int i2, int i3, int i4, int i5) {
        this.a = context;
        this.b = w6Var;
        this.c = str;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.h = i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f4, code lost:
        r30 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f6, code lost:
        r31 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0232, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0233, code lost:
        r8 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x023b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x023c, code lost:
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0260, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0261, code lost:
        r30 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0265, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0266, code lost:
        r30 = r8;
        r31 = r9;
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02a7, code lost:
        r7.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        r20.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02b4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02b5, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02b9, code lost:
        if (r8 != null) goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02f0, code lost:
        r7.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
        r20.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02fd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02fe, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0304, code lost:
        r8.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0141, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0232 A[ExcHandler: all (th java.lang.Throwable), PHI: r30 
      PHI: (r30v16 java.lang.Process) = (r30v10 java.lang.Process), (r30v21 java.lang.Process), (r30v24 java.lang.Process), (r30v24 java.lang.Process) binds: [B:80:0x0190, B:97:0x01c8, B:88:0x01af, B:89:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:88:0x01af] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0260 A[ExcHandler: all (th java.lang.Throwable), PHI: r8 
      PHI: (r8v23 java.lang.Process) = (r8v21 java.lang.Process), (r8v21 java.lang.Process), (r8v27 java.lang.Process), (r8v27 java.lang.Process) binds: [B:43:0x0133, B:54:0x0147, B:72:0x016f, B:80:0x0190] A[DONT_GENERATE, DONT_INLINE], Splitter:B:43:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0265 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:43:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02b0 A[SYNTHETIC, Splitter:B:148:0x02b0] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02f9 A[SYNTHETIC, Splitter:B:166:0x02f9] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0141 A[ExcHandler: all (th java.lang.Throwable), PHI: r8 
      PHI: (r8v35 java.lang.Process) = (r8v27 java.lang.Process), (r8v27 java.lang.Process), (r8v21 java.lang.Process), (r8v21 java.lang.Process) binds: [B:60:0x0154, B:61:?, B:47:0x013b, B:48:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:47:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0147 A[SYNTHETIC, Splitter:B:54:0x0147] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.umlaut.crowd.internal.p4 r33) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            java.lang.String r3 = "time="
            java.lang.String r4 = "icmp_seq="
            com.umlaut.crowd.internal.d4 r0 = r2.IpVersion
            com.umlaut.crowd.internal.d4 r5 = com.umlaut.crowd.internal.d4.IPv6
            java.lang.String r6 = "ping6"
            if (r0 != r5) goto L_0x0013
            r5 = r6
            goto L_0x0016
        L_0x0013:
            java.lang.String r0 = "ping"
            r5 = r0
        L_0x0016:
            java.lang.String r0 = r1.c     // Catch:{ UnknownHostException -> 0x001e }
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r0)     // Catch:{ UnknownHostException -> 0x001e }
            r9 = r0
            goto L_0x0023
        L_0x001e:
            r0 = move-exception
            r0.printStackTrace()
            r9 = 0
        L_0x0023:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r8 = " -i "
            r0.append(r8)
            int r8 = r1.e
            double r10 = (double) r8
            r12 = 4652007308841189376(0x408f400000000000, double:1000.0)
            java.lang.Double.isNaN(r10)
            double r10 = r10 / r12
            r0.append(r10)
            java.lang.String r8 = " -W "
            r0.append(r8)
            int r8 = r1.f
            double r10 = (double) r8
            java.lang.Double.isNaN(r10)
            double r10 = r10 / r12
            r0.append(r10)
            java.lang.String r8 = " -c "
            r0.append(r8)
            int r8 = r1.d
            r0.append(r8)
            java.lang.String r8 = " -s "
            r0.append(r8)
            int r8 = r1.h
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            boolean r0 = r5.equals(r6)
            r5 = 21
            java.lang.String r6 = ""
            r10 = 0
            if (r0 == 0) goto L_0x00e2
            android.content.Context r0 = r1.a     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r11 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r11)     // Catch:{ Exception -> 0x00d8 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Exception -> 0x00d8 }
            if (r0 == 0) goto L_0x00ba
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d8 }
            r12 = 23
            if (r11 < r12) goto L_0x0092
            android.net.Network r11 = r0.getActiveNetwork()     // Catch:{ Exception -> 0x00d8 }
            android.net.LinkProperties r0 = r0.getLinkProperties(r11)     // Catch:{ Exception -> 0x00d8 }
            if (r0 == 0) goto L_0x00ba
            java.lang.String r0 = r0.getInterfaceName()     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00bb
        L_0x0092:
            if (r11 < r5) goto L_0x00ba
            android.net.Network[] r11 = r0.getAllNetworks()     // Catch:{ Exception -> 0x00d8 }
            int r12 = r11.length     // Catch:{ Exception -> 0x00d8 }
            r13 = r6
            r14 = 0
        L_0x009b:
            if (r14 >= r12) goto L_0x00b8
            r15 = r11[r14]     // Catch:{ Exception -> 0x00d8 }
            android.net.NetworkInfo r16 = r0.getNetworkInfo(r15)     // Catch:{ Exception -> 0x00d8 }
            if (r16 == 0) goto L_0x00b5
            boolean r16 = r16.isConnected()     // Catch:{ Exception -> 0x00d8 }
            if (r16 == 0) goto L_0x00b5
            android.net.LinkProperties r15 = r0.getLinkProperties(r15)     // Catch:{ Exception -> 0x00d8 }
            if (r15 == 0) goto L_0x00b5
            java.lang.String r13 = r15.getInterfaceName()     // Catch:{ Exception -> 0x00d8 }
        L_0x00b5:
            int r14 = r14 + 1
            goto L_0x009b
        L_0x00b8:
            r0 = r13
            goto L_0x00bb
        L_0x00ba:
            r0 = r6
        L_0x00bb:
            if (r0 == 0) goto L_0x00e2
            boolean r11 = r0.isEmpty()     // Catch:{ Exception -> 0x00d8 }
            if (r11 != 0) goto L_0x00e2
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
            r11.<init>()     // Catch:{ Exception -> 0x00d8 }
            r11.append(r8)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r12 = " -I "
            r11.append(r12)     // Catch:{ Exception -> 0x00d8 }
            r11.append(r0)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00e2
        L_0x00d8:
            r0 = move-exception
            java.lang.String r11 = i
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r11, r0)
        L_0x00e2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " "
            r0.append(r8)
            java.lang.String r11 = r1.c
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.umlaut.crowd.internal.w6 r11 = r1.b
            r11.a()
            java.util.concurrent.CountDownLatch r11 = new java.util.concurrent.CountDownLatch
            int r12 = r1.d
            r11.<init>(r12)
            java.util.concurrent.ScheduledExecutorService r12 = java.util.concurrent.Executors.newSingleThreadScheduledExecutor()
            com.umlaut.crowd.internal.v3$a r14 = new com.umlaut.crowd.internal.v3$a
            r14.<init>(r11)
            int r13 = r1.e
            r21 = r8
            long r7 = (long) r13
            java.util.concurrent.TimeUnit r19 = java.util.concurrent.TimeUnit.MILLISECONDS
            r15 = 0
            r13 = r12
            r17 = r7
            java.util.concurrent.ScheduledFuture r7 = r13.scheduleAtFixedRate(r14, r15, r17, r19)
            java.lang.Runtime r8 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0281, all -> 0x027a }
            java.lang.Process r8 = r8.exec(r0)     // Catch:{ Exception -> 0x0281, all -> 0x027a }
            java.io.BufferedReader r13 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0274, all -> 0x0270 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0274, all -> 0x0270 }
            java.io.InputStream r14 = r8.getInputStream()     // Catch:{ Exception -> 0x0274, all -> 0x0270 }
            r0.<init>(r14)     // Catch:{ Exception -> 0x0274, all -> 0x0270 }
            r13.<init>(r0)     // Catch:{ Exception -> 0x0274, all -> 0x0270 }
            java.lang.String r0 = r13.readLine()     // Catch:{ Exception -> 0x0265, all -> 0x0260 }
            if (r0 != 0) goto L_0x0144
            if (r9 == 0) goto L_0x0144
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0265, all -> 0x0141 }
            if (r0 < r5) goto L_0x0144
            r5 = 1
            goto L_0x0145
        L_0x0141:
            r0 = move-exception
            goto L_0x02eb
        L_0x0144:
            r5 = 0
        L_0x0145:
            if (r5 != 0) goto L_0x0243
            long r16 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            r0 = 0
        L_0x014c:
            int r14 = r1.d     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            if (r0 >= r14) goto L_0x0228
            boolean r14 = r1.g     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            if (r14 == 0) goto L_0x016f
            r13.close()     // Catch:{ Exception -> 0x016c, all -> 0x0141 }
            if (r7 == 0) goto L_0x015c
            r7.cancel(r10)
        L_0x015c:
            r12.shutdown()
            r13.close()     // Catch:{ IOException -> 0x0163 }
            goto L_0x0168
        L_0x0163:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0168:
            r8.destroy()
            return r10
        L_0x016c:
            r0 = move-exception
            goto L_0x023e
        L_0x016f:
            java.lang.String r14 = r13.readLine()     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            long r18 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            long r18 = r18 - r16
            r20 = -1
            if (r14 == 0) goto L_0x0200
            int r22 = r14.length()     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            if (r22 <= 0) goto L_0x0200
            r10 = r21
            java.lang.String[] r14 = r14.split(r10)     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            int r15 = r14.length     // Catch:{ Exception -> 0x023b, all -> 0x0260 }
            r28 = r5
            r5 = 8
            if (r15 < r5) goto L_0x01f9
            int r5 = r14.length     // Catch:{ Exception -> 0x01f3, all -> 0x0260 }
            r15 = 0
        L_0x0192:
            if (r15 >= r5) goto L_0x01e8
            r22 = r5
            r5 = r14[r15]     // Catch:{ Exception -> 0x01f3, all -> 0x0260 }
            boolean r23 = r5.startsWith(r4)     // Catch:{ Exception -> 0x01f3, all -> 0x0260 }
            if (r23 == 0) goto L_0x01c2
            java.lang.String r5 = r5.replace(r4, r6)     // Catch:{ NumberFormatException -> 0x01bb }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x01bb }
            r21 = 1
            int r5 = r5 + -1
            r29 = r4
            long r4 = (long) r5
            r30 = r8
            int r8 = r1.e     // Catch:{ NumberFormatException -> 0x01bf, Exception -> 0x01b9, all -> 0x0232 }
            r31 = r9
            long r8 = (long) r8
            long r4 = r4 * r8
            r18 = r4
            goto L_0x01dd
        L_0x01b9:
            r0 = move-exception
            goto L_0x01f6
        L_0x01bb:
            r29 = r4
            r30 = r8
        L_0x01bf:
            r31 = r9
            goto L_0x01dd
        L_0x01c2:
            r29 = r4
            r30 = r8
            r31 = r9
            boolean r4 = r5.startsWith(r3)     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            if (r4 == 0) goto L_0x01dd
            java.lang.String r4 = r5.replace(r3, r6)     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            double r4 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            long r4 = java.lang.Math.round(r4)     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            int r5 = (int) r4     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            r20 = r5
        L_0x01dd:
            int r15 = r15 + 1
            r5 = r22
            r4 = r29
            r8 = r30
            r9 = r31
            goto L_0x0192
        L_0x01e8:
            r29 = r4
            r30 = r8
            r31 = r9
            r24 = r18
            r4 = r20
            goto L_0x020d
        L_0x01f3:
            r0 = move-exception
            r30 = r8
        L_0x01f6:
            r31 = r9
            goto L_0x0238
        L_0x01f9:
            r29 = r4
            r30 = r8
            r31 = r9
            goto L_0x020a
        L_0x0200:
            r29 = r4
            r28 = r5
            r30 = r8
            r31 = r9
            r10 = r21
        L_0x020a:
            r24 = r18
            r4 = -1
        L_0x020d:
            com.umlaut.crowd.internal.w6 r5 = r1.b     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            long r8 = (long) r4     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            r22 = r5
            r23 = r0
            r26 = r8
            r22.b(r23, r24, r26)     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            int r0 = r0 + 1
            r21 = r10
            r5 = r28
            r4 = r29
            r8 = r30
            r9 = r31
            r10 = 0
            goto L_0x014c
        L_0x0228:
            r28 = r5
            r30 = r8
            r31 = r9
            r11.await()     // Catch:{ Exception -> 0x0237, all -> 0x0232 }
            goto L_0x0249
        L_0x0232:
            r0 = move-exception
            r8 = r30
            goto L_0x02eb
        L_0x0237:
            r0 = move-exception
        L_0x0238:
            r5 = r28
            goto L_0x026b
        L_0x023b:
            r0 = move-exception
            r28 = r5
        L_0x023e:
            r30 = r8
            r31 = r9
            goto L_0x026b
        L_0x0243:
            r28 = r5
            r30 = r8
            r31 = r9
        L_0x0249:
            if (r7 == 0) goto L_0x024f
            r3 = 0
            r7.cancel(r3)
        L_0x024f:
            r12.shutdown()
            r13.close()     // Catch:{ IOException -> 0x0256 }
            goto L_0x025b
        L_0x0256:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x025b:
            r5 = r28
            r8 = r30
            goto L_0x02bb
        L_0x0260:
            r0 = move-exception
            r30 = r8
            goto L_0x02eb
        L_0x0265:
            r0 = move-exception
            r30 = r8
            r31 = r9
            r5 = 0
        L_0x026b:
            r20 = r13
            r8 = r30
            goto L_0x0288
        L_0x0270:
            r0 = move-exception
            r30 = r8
            goto L_0x027c
        L_0x0274:
            r0 = move-exception
            r30 = r8
            r31 = r9
            goto L_0x0285
        L_0x027a:
            r0 = move-exception
            r8 = 0
        L_0x027c:
            r2 = r0
            r20 = 0
            goto L_0x02ee
        L_0x0281:
            r0 = move-exception
            r31 = r9
            r8 = 0
        L_0x0285:
            r5 = 0
            r20 = 0
        L_0x0288:
            java.lang.String r3 = i     // Catch:{ all -> 0x02e8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e8 }
            r4.<init>()     // Catch:{ all -> 0x02e8 }
            java.lang.String r6 = "IcmpTestAsyncTask: "
            r4.append(r6)     // Catch:{ all -> 0x02e8 }
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x02e8 }
            r4.append(r6)     // Catch:{ all -> 0x02e8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02e8 }
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x02e8 }
            r0.printStackTrace()     // Catch:{ all -> 0x02e8 }
            if (r7 == 0) goto L_0x02ab
            r3 = 0
            r7.cancel(r3)
        L_0x02ab:
            r12.shutdown()
            if (r20 == 0) goto L_0x02b9
            r20.close()     // Catch:{ IOException -> 0x02b4 }
            goto L_0x02b9
        L_0x02b4:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x02b9:
            if (r8 == 0) goto L_0x02be
        L_0x02bb:
            r8.destroy()
        L_0x02be:
            if (r5 == 0) goto L_0x02e6
            com.umlaut.crowd.internal.m5 r0 = r2.MeasurementType
            com.umlaut.crowd.internal.m5 r3 = com.umlaut.crowd.internal.m5.IPING
            if (r0 != r3) goto L_0x02ca
            com.umlaut.crowd.internal.m5 r0 = com.umlaut.crowd.internal.m5.APIIPING
            r2.MeasurementType = r0
        L_0x02ca:
            com.umlaut.crowd.internal.e r0 = new com.umlaut.crowd.internal.e
            int r10 = r1.d
            int r11 = r1.e
            int r12 = r1.f
            int r13 = r1.h
            r14 = 0
            r8 = r0
            r9 = r31
            r8.<init>(r9, r10, r11, r12, r13, r14)
            com.umlaut.crowd.internal.v3$b r2 = new com.umlaut.crowd.internal.v3$b
            r2.<init>(r0)
            r0.a((com.umlaut.crowd.internal.w6) r2)
            r0.c()
        L_0x02e6:
            r2 = 1
            return r2
        L_0x02e8:
            r0 = move-exception
            r13 = r20
        L_0x02eb:
            r2 = r0
            r20 = r13
        L_0x02ee:
            if (r7 == 0) goto L_0x02f4
            r3 = 0
            r7.cancel(r3)
        L_0x02f4:
            r12.shutdown()
            if (r20 == 0) goto L_0x0302
            r20.close()     // Catch:{ IOException -> 0x02fd }
            goto L_0x0302
        L_0x02fd:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x0302:
            if (r8 == 0) goto L_0x0307
            r8.destroy()
        L_0x0307:
            goto L_0x0309
        L_0x0308:
            throw r2
        L_0x0309:
            goto L_0x0308
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v3.a(com.umlaut.crowd.internal.p4):boolean");
    }

    public void a() {
        this.g = true;
    }
}
