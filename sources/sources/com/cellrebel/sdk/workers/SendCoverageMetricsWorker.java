package com.cellrebel.sdk.workers;

public class SendCoverageMetricsWorker extends BaseMetricsWorker {
    public int j = 15;
    public int k = 0;

    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x014d, code lost:
        if (r0.hasNext() != false) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x014f, code lost:
        r0.next().isSending(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0159, code lost:
        r11.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0145 */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r11) {
        /*
            r10 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r11 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r11 != 0) goto L_0x0007
            return
        L_0x0007:
            com.cellrebel.sdk.utils.Storage r11 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            long r0 = r11.e()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.database.SDKRoomDatabase r11 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.database.dao.CoverageMetricDAO r11 = r11.e()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            long r0 = r0 - r2
            long r0 = java.lang.Math.abs(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            int r2 = r10.j     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            int r2 = r2 * 60
            long r2 = (long) r2     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            int r4 = r10.k     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            long r4 = (long) r4     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            long r2 = r2 - r4
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0032
            return
        L_0x0032:
            com.cellrebel.sdk.utils.Storage r0 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r0.d(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r0.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.List r1 = r11.b()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            int r2 = r1.size()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r2 != 0) goto L_0x004d
            return
        L_0x004d:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r2.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r3 = 0
            java.lang.Object r4 = r1.get(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.beans.request.CoverageMetric r4 = (com.cellrebel.sdk.networking.beans.request.CoverageMetric) r4     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r2.add(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.Iterator r4 = r1.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
        L_0x0060:
            boolean r5 = r4.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r5 == 0) goto L_0x00ca
            java.lang.Object r5 = r4.next()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.beans.request.CoverageMetric r5 = (com.cellrebel.sdk.networking.beans.request.CoverageMetric) r5     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r6 = 1
            r5.isSending(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            int r7 = r2.size()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            int r7 = r7 - r6
            java.lang.Object r6 = r2.get(r7)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.beans.request.CoverageMetric r6 = (com.cellrebel.sdk.networking.beans.request.CoverageMetric) r6     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.String r7 = r5.simMNC     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.String r8 = r6.simMNC     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r7 == 0) goto L_0x00b3
            java.util.List<com.cellrebel.sdk.networking.beans.request.CellInfoMetric> r7 = r6.cellInfoMetrics     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r7 != 0) goto L_0x009e
            java.lang.String r5 = r5.cellInfoMetricsJSON     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.workers.SendCoverageMetricsWorker$1 r7 = new com.cellrebel.sdk.workers.SendCoverageMetricsWorker$1     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r7.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.Object r5 = r0.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r7)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r9 = r6
            r6 = r5
            r5 = r9
            goto L_0x00c7
        L_0x009e:
            java.lang.String r5 = r5.cellInfoMetricsJSON     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.workers.SendCoverageMetricsWorker$2 r6 = new com.cellrebel.sdk.workers.SendCoverageMetricsWorker$2     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r6.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.reflect.Type r6 = r6.getType()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.Object r5 = r0.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r6)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r7.addAll(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            goto L_0x0060
        L_0x00b3:
            r2.add(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.String r6 = r5.cellInfoMetricsJSON     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.workers.SendCoverageMetricsWorker$3 r7 = new com.cellrebel.sdk.workers.SendCoverageMetricsWorker$3     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r7.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.lang.Object r6 = r0.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r7)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
        L_0x00c7:
            r5.cellInfoMetrics = r6     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            goto L_0x0060
        L_0x00ca:
            r11.a((java.util.List<com.cellrebel.sdk.networking.beans.request.CoverageMetric>) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r0.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
        L_0x00d6:
            boolean r4 = r2.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r4 == 0) goto L_0x00ee
            java.lang.Object r4 = r2.next()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.beans.request.CoverageMetric r4 = (com.cellrebel.sdk.networking.beans.request.CoverageMetric) r4     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            java.util.List<com.cellrebel.sdk.networking.beans.request.CellInfoMetric> r5 = r4.cellInfoMetrics     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            boolean r5 = r5.isEmpty()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r5 != 0) goto L_0x00d6
            r0.add(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            goto L_0x00d6
        L_0x00ee:
            boolean r2 = r0.isEmpty()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r2 == 0) goto L_0x00f8
            r11.a()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            return
        L_0x00f8:
            r0.toString()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.ApiService r4 = com.cellrebel.sdk.networking.ApiClient.a()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            java.lang.String r2 = com.cellrebel.sdk.networking.UrlProvider.a(r2)     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            retrofit2.Call r0 = r4.m(r0, r2)     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            retrofit2.Response r0 = r0.execute()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            boolean r2 = r0.isSuccessful()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            if (r2 == 0) goto L_0x011d
            r11.a()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            goto L_0x015c
        L_0x011d:
            r0.toString()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            okhttp3.ResponseBody r2 = r0.errorBody()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            if (r2 == 0) goto L_0x012d
            okhttp3.ResponseBody r0 = r0.errorBody()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            r0.string()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
        L_0x012d:
            java.util.Iterator r0 = r1.iterator()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
        L_0x0131:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            if (r2 == 0) goto L_0x0141
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.beans.request.CoverageMetric r2 = (com.cellrebel.sdk.networking.beans.request.CoverageMetric) r2     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            r2.isSending(r3)     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            goto L_0x0131
        L_0x0141:
            r11.a((java.util.List<com.cellrebel.sdk.networking.beans.request.CoverageMetric>) r1)     // Catch:{ IOException -> 0x0145, Exception | OutOfMemoryError -> 0x015c }
            goto L_0x015c
        L_0x0145:
            java.util.Iterator r0 = r1.iterator()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
        L_0x0149:
            boolean r2 = r0.hasNext()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            if (r2 == 0) goto L_0x0159
            java.lang.Object r2 = r0.next()     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            com.cellrebel.sdk.networking.beans.request.CoverageMetric r2 = (com.cellrebel.sdk.networking.beans.request.CoverageMetric) r2     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            r2.isSending(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
            goto L_0x0149
        L_0x0159:
            r11.a((java.util.List<com.cellrebel.sdk.networking.beans.request.CoverageMetric>) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x015c }
        L_0x015c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.SendCoverageMetricsWorker.a(android.content.Context):void");
    }
}
