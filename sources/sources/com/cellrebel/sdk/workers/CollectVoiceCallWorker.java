package com.cellrebel.sdk.workers;

import java.util.concurrent.CountDownLatch;

public class CollectVoiceCallWorker extends BaseMetricsWorker {
    public int j;
    public int k;
    private CountDownLatch l = new CountDownLatch(1);

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        try {
            this.l.countDown();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r11) {
        /*
            r10 = this;
            com.cellrebel.sdk.networking.beans.request.VoiceCallMetric r9 = new com.cellrebel.sdk.networking.beans.request.VoiceCallMetric     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r9.<init>()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r0 = com.cellrebel.sdk.utils.Utils.e()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.lang.String r1 = "power"
            java.lang.Object r1 = r11.getSystemService(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r3 = r1
            android.os.PowerManager r3 = (android.os.PowerManager) r3     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            com.cellrebel.sdk.utils.TrackingHelper r1 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r1 = r1.c()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            if (r1 != 0) goto L_0x0030
            r0 = 500(0x1f4, float:7.0E-43)
            r9.stateDuringMeasurement(r0)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            goto L_0x004e
        L_0x0030:
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            if (r0 != 0) goto L_0x003c
            r0 = 501(0x1f5, float:7.02E-43)
            r9.stateDuringMeasurement(r0)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            goto L_0x004e
        L_0x003c:
            boolean r1 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r2 = r10.c     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r4 = r10.b     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r5 = r10.d     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r6 = r10.e     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r7 = r10.f     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            boolean r8 = r10.g     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r0 = r9
            com.cellrebel.sdk.utils.Utils.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        L_0x004e:
            int r0 = r10.j     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r9.callStartTime = r0     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            int r0 = r10.k     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r9.callEndTime = r0     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r1 = 1
            r0.<init>(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r10.l = r0     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            com.cellrebel.sdk.workers.CollectVoiceCallWorker$$ExternalSyntheticLambda0 r0 = new com.cellrebel.sdk.workers.CollectVoiceCallWorker$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r11, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r9, (java.lang.Runnable) r0)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.util.concurrent.CountDownLatch r11 = r10.l     // Catch:{ InterruptedException -> 0x006b }
            r11.await()     // Catch:{ InterruptedException -> 0x006b }
        L_0x006b:
            r9.toString()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r11 = move-exception
            throw r11
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectVoiceCallWorker.a(android.content.Context):void");
    }
}
