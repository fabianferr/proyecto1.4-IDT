package com.cellrebel.sdk.workers;

public class SendCellInfoMetricsWorker extends BaseMetricsWorker {
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x008f */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r6) {
        /*
            r5 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r6 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            com.cellrebel.sdk.database.SDKRoomDatabase r6 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            com.cellrebel.sdk.database.dao.CellInfoDAO r6 = r6.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            java.util.List r0 = r6.getAll()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            int r2 = r0.size()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            if (r2 != 0) goto L_0x001f
            return
        L_0x001f:
            java.util.Iterator r2 = r0.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
        L_0x0023:
            boolean r3 = r2.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r2.next()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            com.cellrebel.sdk.networking.beans.request.CellInfoMetric r3 = (com.cellrebel.sdk.networking.beans.request.CellInfoMetric) r3     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            java.lang.String r4 = r3.mobileClientId     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            if (r4 != 0) goto L_0x0036
            r1.add(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
        L_0x0036:
            r4 = 1
            r3.isSending(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            goto L_0x0023
        L_0x003b:
            r6.a((java.util.List<com.cellrebel.sdk.networking.beans.request.CellInfoMetric>) r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            r0.removeAll(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            r0.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            r1 = 0
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            com.cellrebel.sdk.networking.ApiService r3 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            java.lang.String r2 = com.cellrebel.sdk.networking.UrlProvider.a(r2)     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            retrofit2.Call r2 = r3.i(r0, r2)     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            retrofit2.Response r2 = r2.execute()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            boolean r3 = r2.isSuccessful()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            if (r3 == 0) goto L_0x0067
            r6.a()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            goto L_0x00a6
        L_0x0067:
            r2.toString()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            okhttp3.ResponseBody r3 = r2.errorBody()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            if (r3 == 0) goto L_0x0077
            okhttp3.ResponseBody r2 = r2.errorBody()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            r2.string()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
        L_0x0077:
            java.util.Iterator r2 = r0.iterator()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
        L_0x007b:
            boolean r3 = r2.hasNext()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            if (r3 == 0) goto L_0x008b
            java.lang.Object r3 = r2.next()     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            com.cellrebel.sdk.networking.beans.request.CellInfoMetric r3 = (com.cellrebel.sdk.networking.beans.request.CellInfoMetric) r3     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            r3.isSending(r1)     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            goto L_0x007b
        L_0x008b:
            r6.a((java.util.List<com.cellrebel.sdk.networking.beans.request.CellInfoMetric>) r0)     // Catch:{ IOException -> 0x008f, Exception | OutOfMemoryError -> 0x00a6 }
            goto L_0x00a6
        L_0x008f:
            java.util.Iterator r2 = r0.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
        L_0x0093:
            boolean r3 = r2.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            if (r3 == 0) goto L_0x00a3
            java.lang.Object r3 = r2.next()     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            com.cellrebel.sdk.networking.beans.request.CellInfoMetric r3 = (com.cellrebel.sdk.networking.beans.request.CellInfoMetric) r3     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            r3.isSending(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
            goto L_0x0093
        L_0x00a3:
            r6.a((java.util.List<com.cellrebel.sdk.networking.beans.request.CellInfoMetric>) r0)     // Catch:{ Exception | OutOfMemoryError -> 0x00a6 }
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SendCellInfoMetricsWorker.a(android.content.Context):void");
    }
}
