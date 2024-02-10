package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric;
import com.cellrebel.sdk.tti.models.TimeToInteractionResult;
import com.cellrebel.sdk.utils.ThreadPoolProvider;
import com.cellrebel.sdk.utils.TrackingHelper;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CollectTtiMetricsWorker extends BaseMetricsWorker {
    private static final String x = "CollectTtiMetricsWorker";
    String j;
    private ConnectionType k;
    private int l;
    private volatile CountDownLatch m = new CountDownLatch(1);
    private final ScheduledExecutorService n = Executors.newSingleThreadScheduledExecutor();
    private int o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private final int v;
    private final int w;

    public CollectTtiMetricsWorker(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.o = i;
        this.p = i2;
        this.q = i3;
        this.r = i4;
        this.s = i5;
        this.t = i6;
        this.u = i7;
        this.v = i8;
        this.w = i9;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|(1:3)|4|5|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.lang.String a(com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric r2) {
        /*
            r1 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0011 }
            if (r0 == 0) goto L_0x0011
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()     // Catch:{ Exception | OutOfMemoryError -> 0x0011 }
            com.cellrebel.sdk.database.dao.TtiDAO r0 = r0.t()     // Catch:{ Exception | OutOfMemoryError -> 0x0011 }
            r0.a((com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric) r2)     // Catch:{ Exception | OutOfMemoryError -> 0x0011 }
        L_0x0011:
            java.util.concurrent.CountDownLatch r2 = r1.m     // Catch:{ Exception | OutOfMemoryError -> 0x0016 }
            r2.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x0016 }
        L_0x0016:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectTtiMetricsWorker.a(com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric):java.lang.String");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Context context) {
        ConnectionType a = TrackingHelper.a().a(context);
        if (a != this.k) {
            this.l++;
        }
        this.k = a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(TimeToInteractionMetric timeToInteractionMetric) {
        try {
            ThreadPoolProvider.a().a(new CollectTtiMetricsWorker$$ExternalSyntheticLambda2(this, timeToInteractionMetric));
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    private String d(List<TimeToInteractionResult.ErrorType> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).ordinal());
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(1:4)(2:5|(1:7)(3:8|9|(2:11|12)(2:13|(1:15)(1:(1:20)(1:19)))))|21|22|23|24|25|26|27|29|(1:(1:31))) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0189 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x018d */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A[SYNTHETIC, Splitter:B:26:0x018d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r13) {
        /*
            r12 = this;
            super.a((android.content.Context) r13)
            com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric r9 = new com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r13)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r12.k = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.accessTechStart = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.workers.CollectTtiMetricsWorker$$ExternalSyntheticLambda0 r2 = new com.cellrebel.sdk.workers.CollectTtiMetricsWorker$$ExternalSyntheticLambda0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r2.<init>(r12, r13)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.util.concurrent.ScheduledExecutorService r1 = r12.n     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r3 = 0
            r5 = 500(0x1f4, double:2.47E-321)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.util.concurrent.ScheduledFuture r10 = r1.scheduleAtFixedRate(r2, r3, r5, r7)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.utils.SettingsManager r0 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.networking.beans.response.Settings r0 = r0.c()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r0 = com.cellrebel.sdk.networking.UrlProvider.b(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r1 = new com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r1.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r1.setServerListUrl(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = "CellRebelSDK"
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setAppName(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = com.cellrebel.sdk.utils.Utils.d(r13)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setAppVersion(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = r1.t()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setDeviceModel(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = r1.a((android.content.Context) r13)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setDeviceId(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.p     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setDownloadFileSize(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.q     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setUploadFileSize(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.w     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setUploadStatsTimeout(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.v     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setUploadStatsInterval(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.u     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setPingsPerServer(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.t     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setPingTimeout(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.s     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setServerSelectionTimeout(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r12.o     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig$Builder r0 = r0.setTimeout(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionConfig r0 = r0.build()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.database.LatencyRepository r1 = new com.cellrebel.sdk.database.LatencyRepository     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r2 = r12.j     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r3 = "SpeedTest"
            r1.<init>(r13, r2, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.TimeToInteractionMeasurer r2 = new com.cellrebel.sdk.tti.TimeToInteractionMeasurer     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r2.<init>(r0, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.tti.models.TimeToInteractionResult r0 = r2.d()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = r12.j     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.measurementSequenceId = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = r0.serverIp     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.serverIp = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r0.serverId     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.serverId = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r0.serverPort     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.serverPort = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = r0.serverVersion     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.serverVersion = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = r0.serverBuild     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.serverBuild = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r1 = r0.latency     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.latency = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            long r1 = r0.downloadTime     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r2 = (int) r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.downloadTime = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            long r1 = r0.downloadTimeToFirstByte     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r2 = (int) r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.downloadTimeToFirstByte = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            long r1 = r0.bytesDownloaded     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r2 = (int) r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.bytesDownloaded = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            long r1 = r0.uploadTime     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r2 = (int) r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.uploadTime = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            long r1 = r0.uploadTimeToFirstByte     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r2 = (int) r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.uploadTimeToFirstByte = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            long r1 = r0.bytesUploaded     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r2 = (int) r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.bytesUploaded = r1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.util.List<com.cellrebel.sdk.tti.models.TimeToInteractionResult$ErrorType> r0 = r0.errors     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r0 = r12.d(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.errorTypes = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.database.ConnectionType r0 = r0.a((android.content.Context) r13)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r12.k = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.accessTechEnd = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            int r0 = r12.l     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r9.accessTechNumChanges = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r0 = r0.c()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r11 = 1
            if (r0 != 0) goto L_0x0136
            r0 = 500(0x1f4, float:7.0E-43)
            r9.stateDuringMeasurement = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r12.a = r11     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            goto L_0x017c
        L_0x0136:
            boolean r0 = r12.b     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            if (r0 == 0) goto L_0x013f
            r0 = 100
            r9.stateDuringMeasurement = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            goto L_0x017c
        L_0x013f:
            boolean r0 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.lang.String r1 = "power"
            if (r0 == 0) goto L_0x015f
            java.lang.Object r0 = r13.getSystemService(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r3 = r0
            android.os.PowerManager r3 = (android.os.PowerManager) r3     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r1 = com.cellrebel.sdk.workers.BaseMetricsWorker.h     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r2 = r12.c     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r4 = r12.b     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r5 = r12.d     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r6 = r12.e     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r7 = r12.f     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r8 = r12.g     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r0 = r9
            com.cellrebel.sdk.utils.Utils.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            goto L_0x017c
        L_0x015f:
            java.lang.Object r0 = r13.getSystemService(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            boolean r1 = r12.c     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            if (r1 == 0) goto L_0x016e
            r0 = 200(0xc8, float:2.8E-43)
            r9.stateDuringMeasurement = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            goto L_0x017c
        L_0x016e:
            if (r0 == 0) goto L_0x0179
            boolean r0 = r0.isScreenOn()     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            if (r0 == 0) goto L_0x0179
            r9.stateDuringMeasurement = r11     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            goto L_0x017c
        L_0x0179:
            r0 = 2
            r9.stateDuringMeasurement = r0     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
        L_0x017c:
            com.cellrebel.sdk.workers.CollectTtiMetricsWorker$$ExternalSyntheticLambda1 r0 = new com.cellrebel.sdk.workers.CollectTtiMetricsWorker$$ExternalSyntheticLambda1     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            r0.<init>(r12, r9)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r13, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r9, (java.lang.Runnable) r0)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            java.util.concurrent.CountDownLatch r13 = r12.m     // Catch:{ InterruptedException -> 0x0189, Exception | OutOfMemoryError -> 0x018d }
            r13.await()     // Catch:{ InterruptedException -> 0x0189, Exception | OutOfMemoryError -> 0x018d }
        L_0x0189:
            r10.cancel(r11)     // Catch:{ Exception | OutOfMemoryError -> 0x018d }
            goto L_0x0192
        L_0x018d:
            java.util.concurrent.CountDownLatch r13 = r12.m     // Catch:{ Exception | OutOfMemoryError -> 0x0192 }
            r13.countDown()     // Catch:{ Exception | OutOfMemoryError -> 0x0192 }
        L_0x0192:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectTtiMetricsWorker.a(android.content.Context):void");
    }
}
