package com.cellrebel.sdk.workers;

import android.content.Context;
import android.os.PowerManager;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.TraceRouteMetric;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.utils.Utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;

public class CollectTraceRouteWorker extends BaseMetricsWorker {
    String j;
    int k = 10;
    int l = 60;
    int m = 1;
    boolean n = true;
    int o = 1;
    String p;
    String q;
    long r;
    String s;
    String t;
    private CountDownLatch u = new CountDownLatch(1);

    public CollectTraceRouteWorker(String str, int i, int i2) {
        this.j = str;
        this.k = i;
        this.l = i2;
    }

    static String a(String str) {
        String[] split = str.replaceAll("[\\t\\n\\r]+", " ").split(" ");
        String str2 = split[8];
        String substring = str2.substring(0, str2.length() - 1);
        if (substring.equals("byte")) {
            String str3 = split[10];
            substring = str3.substring(0, str3.length() - 1);
        }
        return split[7].equals("---") ? "" : substring;
    }

    public static String a(String str, int i, int i2, int i3) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(String.format("ping -n -c %d -t %d -s %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str})).getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            sb.append(readLine + "\n");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            this.u.countDown();
        } catch (Exception unused) {
        }
    }

    static String b(String str) {
        String[] split = str.replaceAll("[\\t\\n\\r]+", " ").split(" ");
        return (split[13].equals("packets") || split[13].equals("exceeded")) ? "*" : split[13].substring(5);
    }

    private void b(Context context) {
        int i;
        TraceRouteMetric traceRouteMetric = new TraceRouteMetric();
        traceRouteMetric.measurementSequenceId = this.t;
        Boolean valueOf = Boolean.valueOf(Utils.e());
        String.valueOf(System.currentTimeMillis() / 1000);
        traceRouteMetric.traceroute = this.q;
        traceRouteMetric.serverUrl = this.j;
        traceRouteMetric.numberOfHops = this.k;
        traceRouteMetric.packetSize = this.l;
        traceRouteMetric.serverIp = this.s;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (!TrackingHelper.a().c()) {
            i = 500;
        } else if (!valueOf.booleanValue()) {
            i = 501;
        } else {
            Utils.a(traceRouteMetric, BaseMetricsWorker.h, this.c, powerManager, this.b, this.d, this.e, this.f, this.g);
            this.u = new CountDownLatch(1);
            traceRouteMetric.toString();
            BaseMetricsWorker.a(context, (BaseMetric) traceRouteMetric, (Runnable) new CollectTraceRouteWorker$$ExternalSyntheticLambda0(this));
            this.u.await();
        }
        traceRouteMetric.stateDuringMeasurement(i);
        this.u = new CountDownLatch(1);
        traceRouteMetric.toString();
        BaseMetricsWorker.a(context, (BaseMetric) traceRouteMetric, (Runnable) new CollectTraceRouteWorker$$ExternalSyntheticLambda0(this));
        try {
            this.u.await();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:26|27|28|29|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00dc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011b A[Catch:{ Exception -> 0x01a9 }, LOOP:1: B:36:0x011b->B:42:0x016e, LOOP_START, PHI: r14 
      PHI: (r14v2 int) = (r14v1 int), (r14v3 int) binds: [B:35:0x0119, B:42:0x016e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a3 A[Catch:{ Exception -> 0x01b0 }, LOOP:0: B:14:0x0094->B:49:0x01a3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0189 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "       "
            java.lang.String r2 = "TraceRouteWorker"
            java.lang.String r3 = "ERROR"
            java.lang.String r4 = ""
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r6 = java.lang.System.currentTimeMillis()
            r1.r = r6
            java.lang.String r6 = "traceroute to %s (%s), %d hops max, %d byte packets\n"
            boolean r7 = r1.n     // Catch:{ Exception -> 0x01bb }
            r8 = 4
            r9 = 3
            r10 = 2
            r11 = 0
            r12 = 1
            if (r7 == 0) goto L_0x0057
            java.lang.String r7 = r1.j     // Catch:{ UnknownHostException -> 0x0039 }
            java.net.InetAddress r7 = java.net.InetAddress.getByName(r7)     // Catch:{ UnknownHostException -> 0x0039 }
            java.lang.String r7 = r7.getHostAddress()     // Catch:{ UnknownHostException -> 0x0039 }
            r1.s = r7     // Catch:{ UnknownHostException -> 0x0039 }
            java.lang.String r7 = r1.j     // Catch:{ UnknownHostException -> 0x0039 }
            java.net.InetAddress r7 = java.net.InetAddress.getByName(r7)     // Catch:{ UnknownHostException -> 0x0039 }
            java.lang.String r7 = r7.getHostName()     // Catch:{ UnknownHostException -> 0x0039 }
            java.lang.String r13 = r1.s     // Catch:{ UnknownHostException -> 0x0039 }
            goto L_0x003c
        L_0x0039:
            java.lang.String r7 = r1.j     // Catch:{ Exception -> 0x01bb }
            r13 = r7
        L_0x003c:
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01bb }
            r8[r11] = r7     // Catch:{ Exception -> 0x01bb }
            r8[r12] = r13     // Catch:{ Exception -> 0x01bb }
            int r7 = r1.k     // Catch:{ Exception -> 0x01bb }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x01bb }
            r8[r10] = r7     // Catch:{ Exception -> 0x01bb }
            int r7 = r1.l     // Catch:{ Exception -> 0x01bb }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x01bb }
            r8[r9] = r7     // Catch:{ Exception -> 0x01bb }
            java.lang.String r6 = java.lang.String.format(r6, r8)     // Catch:{ Exception -> 0x01bb }
            goto L_0x0073
        L_0x0057:
            java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01bb }
            java.lang.String r8 = r1.j     // Catch:{ Exception -> 0x01bb }
            r7[r11] = r8     // Catch:{ Exception -> 0x01bb }
            r7[r12] = r8     // Catch:{ Exception -> 0x01bb }
            int r8 = r1.k     // Catch:{ Exception -> 0x01bb }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x01bb }
            r7[r10] = r8     // Catch:{ Exception -> 0x01bb }
            int r8 = r1.l     // Catch:{ Exception -> 0x01bb }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x01bb }
            r7[r9] = r8     // Catch:{ Exception -> 0x01bb }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ Exception -> 0x01bb }
        L_0x0073:
            java.lang.String r7 = "TraceRouteWorker line "
            android.util.Log.e(r7, r6)     // Catch:{ Exception -> 0x01bb }
            r5.append(r6)     // Catch:{ Exception -> 0x01bb }
            int r6 = r1.k     // Catch:{ Exception -> 0x01b0 }
            int r7 = r1.o     // Catch:{ Exception -> 0x01b0 }
            int[] r8 = new int[r10]     // Catch:{ Exception -> 0x01b0 }
            r8[r12] = r7     // Catch:{ Exception -> 0x01b0 }
            r8[r11] = r6     // Catch:{ Exception -> 0x01b0 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r8)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String[][] r7 = (java.lang.String[][]) r7     // Catch:{ Exception -> 0x01b0 }
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ Exception -> 0x01b0 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x01b0 }
            int r13 = r1.m     // Catch:{ Exception -> 0x01b0 }
            int r13 = r13 - r12
        L_0x0094:
            int r14 = r1.k     // Catch:{ Exception -> 0x01b0 }
            if (r13 >= r14) goto L_0x01ac
            int r14 = r1.o     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r15 = r1.s     // Catch:{ Exception -> 0x01b0 }
            int r10 = r13 + 1
            int r9 = r1.l     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = a(r15, r12, r10, r9)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = a((java.lang.String) r9)     // Catch:{ Exception -> 0x01b0 }
            r8[r13] = r9     // Catch:{ Exception -> 0x01b0 }
            boolean r9 = r9.equals(r4)     // Catch:{ Exception -> 0x01b0 }
            if (r9 == 0) goto L_0x00b3
            java.lang.String r9 = " %d  "
            goto L_0x00b5
        L_0x00b3:
            java.lang.String r9 = " %d  %s (%s)"
        L_0x00b5:
            r15 = r8[r13]     // Catch:{ Exception -> 0x01b0 }
            boolean r15 = r15.equals(r4)     // Catch:{ Exception -> 0x01b0 }
            if (r15 == 0) goto L_0x00cb
            java.lang.Object[] r15 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x01b0 }
            java.lang.Integer r18 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x01b0 }
            r15[r11] = r18     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = java.lang.String.format(r9, r15)     // Catch:{ Exception -> 0x01b0 }
        L_0x00c9:
            r12 = 2
            goto L_0x0110
        L_0x00cb:
            boolean r15 = r1.n     // Catch:{ Exception -> 0x01b0 }
            if (r15 == 0) goto L_0x00fa
            r15 = r8[r13]     // Catch:{ UnknownHostException -> 0x00dc }
            java.net.InetAddress r15 = java.net.InetAddress.getByName(r15)     // Catch:{ UnknownHostException -> 0x00dc }
            java.lang.String r15 = r15.getHostName()     // Catch:{ UnknownHostException -> 0x00dc }
            r6[r13] = r15     // Catch:{ UnknownHostException -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r15 = r8[r13]     // Catch:{ Exception -> 0x01b0 }
            r6[r13] = r15     // Catch:{ Exception -> 0x01b0 }
        L_0x00e0:
            r15 = 3
            java.lang.Object[] r12 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01b0 }
            java.lang.Integer r18 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x01b0 }
            r12[r11] = r18     // Catch:{ Exception -> 0x01b0 }
            r18 = r6[r13]     // Catch:{ Exception -> 0x01b0 }
            r17 = 1
            r12[r17] = r18     // Catch:{ Exception -> 0x01b0 }
            r18 = r8[r13]     // Catch:{ Exception -> 0x01b0 }
            r16 = 2
            r12[r16] = r18     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = java.lang.String.format(r9, r12)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x00c9
        L_0x00fa:
            r15 = 3
            java.lang.String r9 = " %d  %s (%<s)"
            r12 = 2
            java.lang.Object[] r15 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x01b0 }
            java.lang.Integer r18 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x01b0 }
            r15[r11] = r18     // Catch:{ Exception -> 0x01b0 }
            r18 = r8[r13]     // Catch:{ Exception -> 0x01b0 }
            r17 = 1
            r15[r17] = r18     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = java.lang.String.format(r9, r15)     // Catch:{ Exception -> 0x01b0 }
        L_0x0110:
            r5.append(r9)     // Catch:{ Exception -> 0x01b0 }
            r9 = r8[r13]     // Catch:{ Exception -> 0x01a9 }
            boolean r9 = r9.equals(r4)     // Catch:{ Exception -> 0x01a9 }
            if (r9 != 0) goto L_0x0173
        L_0x011b:
            if (r14 == 0) goto L_0x0173
            r9 = r8[r13]     // Catch:{ Exception -> 0x01a9 }
            int r15 = r1.l     // Catch:{ Exception -> 0x01a9 }
            r11 = 30
            r12 = 1
            java.lang.String r9 = a(r9, r12, r11, r15)     // Catch:{ Exception -> 0x01a9 }
            r11 = r7[r13]     // Catch:{ Exception -> 0x01a9 }
            int r15 = r14 + -1
            java.lang.String r9 = b((java.lang.String) r9)     // Catch:{ Exception -> 0x01a9 }
            r11[r15] = r9     // Catch:{ Exception -> 0x01a9 }
            r9 = r7[r13]     // Catch:{ Exception -> 0x01a9 }
            r9 = r9[r15]     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r11 = "*"
            boolean r9 = r9.equals(r11)     // Catch:{ Exception -> 0x01a9 }
            if (r9 == 0) goto L_0x0151
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a9 }
            r9.<init>()     // Catch:{ Exception -> 0x01a9 }
            r9.append(r0)     // Catch:{ Exception -> 0x01a9 }
            r11 = r7[r13]     // Catch:{ Exception -> 0x01a9 }
            r11 = r11[r15]     // Catch:{ Exception -> 0x01a9 }
            r9.append(r11)     // Catch:{ Exception -> 0x01a9 }
            r9.append(r0)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0167
        L_0x0151:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a9 }
            r9.<init>()     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r11 = "  "
            r9.append(r11)     // Catch:{ Exception -> 0x01a9 }
            r11 = r7[r13]     // Catch:{ Exception -> 0x01a9 }
            r11 = r11[r15]     // Catch:{ Exception -> 0x01a9 }
            r9.append(r11)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r11 = " ms"
            r9.append(r11)     // Catch:{ Exception -> 0x01a9 }
        L_0x0167:
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01a9 }
            r5.append(r9)     // Catch:{ Exception -> 0x01a9 }
            int r14 = r14 + -1
            r11 = 0
            r12 = 2
            goto L_0x011b
        L_0x0173:
            r12 = 1
            java.lang.String r9 = "\n"
            r5.append(r9)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = r5.toString()     // Catch:{ Exception -> 0x01b0 }
            r1.q = r9     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r9 = r1.s     // Catch:{ Exception -> 0x01b0 }
            r11 = r8[r13]     // Catch:{ Exception -> 0x01b0 }
            boolean r11 = r11.equals(r9)     // Catch:{ Exception -> 0x01b0 }
            if (r11 == 0) goto L_0x01a3
            r1.p = r4     // Catch:{ Exception -> 0x01b0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b0 }
            r0.<init>()     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r4 = "lastAddressCheck"
            r0.append(r4)     // Catch:{ Exception -> 0x01b0 }
            r0.append(r9)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01b0 }
            android.util.Log.e(r2, r0)     // Catch:{ Exception -> 0x01b0 }
            r19.b((android.content.Context) r20)     // Catch:{ Exception -> 0x01b0 }
            return
        L_0x01a3:
            r13 = r10
            r9 = 3
            r10 = 2
            r11 = 0
            goto L_0x0094
        L_0x01a9:
            r1.p = r3     // Catch:{ Exception -> 0x01b0 }
            return
        L_0x01ac:
            r19.b((android.content.Context) r20)     // Catch:{ Exception -> 0x01b0 }
            return
        L_0x01b0:
            r0 = move-exception
            r1.p = r3
            java.lang.String r0 = r0.getMessage()
        L_0x01b7:
            android.util.Log.e(r2, r0)
            return
        L_0x01bb:
            r0 = move-exception
            r1.p = r3
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = "TraceRouteWorker error"
            goto L_0x01b7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectTraceRouteWorker.a(android.content.Context):void");
    }
}
