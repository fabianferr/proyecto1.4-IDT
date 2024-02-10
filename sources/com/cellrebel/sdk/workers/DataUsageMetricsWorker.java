package com.cellrebel.sdk.workers;

public class DataUsageMetricsWorker extends BaseMetricsWorker {
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x011a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r34) {
        /*
            r33 = this;
            r0 = r34
            com.cellrebel.sdk.utils.FileLoggingTree r1 = com.cellrebel.sdk.workers.MetaHelp.l
            if (r1 != 0) goto L_0x000d
            com.cellrebel.sdk.utils.FileLoggingTree r1 = new com.cellrebel.sdk.utils.FileLoggingTree
            r1.<init>(r0)
            com.cellrebel.sdk.workers.MetaHelp.l = r1
        L_0x000d:
            com.cellrebel.sdk.utils.SettingsManager r1 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            com.cellrebel.sdk.networking.beans.response.Settings r1 = r1.c()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            if (r1 != 0) goto L_0x0018
            return
        L_0x0018:
            boolean r2 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            if (r2 == 0) goto L_0x0026
            java.lang.Boolean r2 = r1.dataUsage()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            if (r2 != 0) goto L_0x0036
        L_0x0026:
            boolean r2 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            if (r2 != 0) goto L_0x0126
            java.lang.Boolean r2 = r1.dataUsageBackgroundMeasurement()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            if (r2 != 0) goto L_0x0036
            goto L_0x0126
        L_0x0036:
            long r2 = android.net.TrafficStats.getTotalTxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r4 = android.net.TrafficStats.getTotalRxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r17 = android.net.TrafficStats.getMobileTxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r19 = android.net.TrafficStats.getMobileRxBytes()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r6 = -1
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0119
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0119
            int r8 = (r19 > r6 ? 1 : (r19 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0119
            int r8 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x005a
            goto L_0x0119
        L_0x005a:
            boolean r6 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            if (r6 != 0) goto L_0x0068
            java.lang.Boolean r1 = r1.backgroundLocationEnabled()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            if (r1 == 0) goto L_0x0070
        L_0x0068:
            com.cellrebel.sdk.workers.LocationWorker r1 = new com.cellrebel.sdk.workers.LocationWorker     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r1.a((android.content.Context) r0)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
        L_0x0070:
            long r2 = r2 - r17
            long r4 = r4 - r19
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r21 = r1.i()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r23 = r1.d()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r25 = r1.e()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r27 = r1.x()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r29 = r1.y()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r31 = r6 - r21
            com.cellrebel.sdk.utils.PreferencesManager r6 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r15 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r7 = r2
            r9 = r4
            r11 = r17
            r13 = r19
            r6.a(r7, r9, r11, r13, r15)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r8 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r6 = r6 - r8
            r8 = 0
            int r1 = (r21 > r6 ? 1 : (r21 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ce
            long r31 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r23 = r8
            r25 = r23
            r27 = r25
            r29 = r27
        L_0x00ce:
            long r19 = r19 - r23
            long r17 = r17 - r25
            long r4 = r4 - r27
            long r2 = r2 - r29
            int r1 = (r19 > r8 ? 1 : (r19 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x011a
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x011a
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x011a
            int r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x011a
            int r1 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x011a
            com.cellrebel.sdk.networking.beans.request.DataUsageMetric r1 = new com.cellrebel.sdk.networking.beans.request.DataUsageMetric     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r6 = 1024(0x400, double:5.06E-321)
            long r8 = r19 / r6
            r1.cellularReceivedUsage(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r8 = r17 / r6
            r1.cellularSentUsage(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r4 = r4 / r6
            r1.wiFiReceivedUsage(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r2 = r2 / r6
            r1.wiFiSentUsage(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r2 = 60000(0xea60, double:2.9644E-319)
            long r4 = r31 / r2
            r1.timePeriod(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            long r31 = r31 / r2
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r0, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            com.cellrebel.sdk.workers.SendDataUsageMetricsWorker r1 = new com.cellrebel.sdk.workers.SendDataUsageMetricsWorker     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            r1.a((android.content.Context) r0)     // Catch:{ Exception | OutOfMemoryError -> 0x011a }
            goto L_0x011a
        L_0x0119:
            return
        L_0x011a:
            com.cellrebel.sdk.utils.Storage r0 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
            r0.f(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x0126 }
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.DataUsageMetricsWorker.a(android.content.Context):void");
    }
}
