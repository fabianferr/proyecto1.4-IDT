package com.cellrebel.sdk.workers;

public class SendWifiInfoMetricsWorker extends BaseMetricsWorker {
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        if (r1.hasNext() != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        r1.next().isSending(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        com.cellrebel.sdk.database.DatabaseClient.a().x().a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r4) {
        /*
            r3 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r4 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            if (r4 != 0) goto L_0x0007
            return
        L_0x0007:
            com.cellrebel.sdk.database.SDKRoomDatabase r4 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.database.dao.WifiInfoMetricDAO r4 = r4.x()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            java.util.List r4 = r4.b()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            int r0 = r4.size()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            if (r0 != 0) goto L_0x001a
            return
        L_0x001a:
            java.util.Iterator r0 = r4.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
        L_0x001e:
            boolean r1 = r0.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r0.next()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.networking.beans.request.WifiInfoMetric r1 = (com.cellrebel.sdk.networking.beans.request.WifiInfoMetric) r1     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            r2 = 1
            r1.isSending(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            goto L_0x001e
        L_0x002f:
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.database.dao.WifiInfoMetricDAO r0 = r0.x()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            r0.a((java.util.List<com.cellrebel.sdk.networking.beans.request.WifiInfoMetric>) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            r0 = 0
            com.cellrebel.sdk.utils.SettingsManager r1 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.networking.beans.response.Settings r1 = r1.c()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.networking.ApiService r2 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            java.lang.String r1 = com.cellrebel.sdk.networking.UrlProvider.a(r1)     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            retrofit2.Call r1 = r2.l(r4, r1)     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            retrofit2.Response r1 = r1.execute()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            boolean r2 = r1.isSuccessful()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            if (r2 == 0) goto L_0x0065
            com.cellrebel.sdk.database.SDKRoomDatabase r1 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.database.dao.WifiInfoMetricDAO r1 = r1.x()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            r1.a()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            goto L_0x00b1
        L_0x0065:
            okhttp3.ResponseBody r2 = r1.errorBody()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            if (r2 == 0) goto L_0x0072
            okhttp3.ResponseBody r1 = r1.errorBody()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            r1.string()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
        L_0x0072:
            java.util.Iterator r1 = r4.iterator()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
        L_0x0076:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            if (r2 == 0) goto L_0x0086
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.networking.beans.request.WifiInfoMetric r2 = (com.cellrebel.sdk.networking.beans.request.WifiInfoMetric) r2     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            r2.isSending(r0)     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            goto L_0x0076
        L_0x0086:
            com.cellrebel.sdk.database.SDKRoomDatabase r1 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.database.dao.WifiInfoMetricDAO r1 = r1.x()     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            r1.a((java.util.List<com.cellrebel.sdk.networking.beans.request.WifiInfoMetric>) r4)     // Catch:{ IOException -> 0x0092, Exception | OutOfMemoryError -> 0x00b1 }
            goto L_0x00b1
        L_0x0092:
            java.util.Iterator r1 = r4.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
        L_0x0096:
            boolean r2 = r1.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r1.next()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.networking.beans.request.WifiInfoMetric r2 = (com.cellrebel.sdk.networking.beans.request.WifiInfoMetric) r2     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            r2.isSending(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            goto L_0x0096
        L_0x00a6:
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            com.cellrebel.sdk.database.dao.WifiInfoMetricDAO r0 = r0.x()     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
            r0.a((java.util.List<com.cellrebel.sdk.networking.beans.request.WifiInfoMetric>) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00b1 }
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SendWifiInfoMetricsWorker.a(android.content.Context):void");
    }
}
