package com.cellrebel.sdk.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.cellrebel.sdk.database.ConnectionTimePassive;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.dao.ConnectionTimePassiveDAO;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.ConnectionMetric;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.utils.FileLoggingTree;
import com.cellrebel.sdk.utils.TrackingHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CollectConnectionMetricsWorker extends Worker {
    private volatile CountDownLatch a = new CountDownLatch(1);
    private final ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();
    private int c;
    private BaseMetricsWorker d = new BaseMetricsWorker();

    static /* synthetic */ class a {
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
                com.cellrebel.sdk.database.ConnectionType[] r0 = com.cellrebel.sdk.database.ConnectionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.TWO_G     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.THREE_G     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.FOUR_G     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.FOUR_G_CA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.WIFI     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.cellrebel.sdk.database.ConnectionType r1 = com.cellrebel.sdk.database.ConnectionType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectConnectionMetricsWorker.a.<clinit>():void");
        }
    }

    public CollectConnectionMetricsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private void a(Context context) {
        try {
            if (DatabaseClient.a() != null) {
                ConnectionMetric connectionMetric = new ConnectionMetric();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                for (ConnectionTimePassive next : DatabaseClient.a().d().getAll()) {
                    switch (a.a[next.a().ordinal()]) {
                        case 1:
                            i = (int) (((long) i) + next.b());
                            break;
                        case 2:
                            i2 = (int) (((long) i2) + next.b());
                            break;
                        case 3:
                        case 4:
                            i5 = (int) (((long) i5) + next.b());
                            break;
                        case 5:
                            i4 = (int) (((long) i4) + next.b());
                            break;
                        case 6:
                            i3 = (int) (((long) i3) + next.b());
                            break;
                    }
                }
                connectionMetric.connectionTimePassive2g(i);
                connectionMetric.connectionTimePassive3g(i2);
                connectionMetric.connectionTimePassive4g(i5);
                connectionMetric.connectionTimePassiveWifi(i4);
                connectionMetric.noConnectionTimePassive(i3);
                connectionMetric.totalTimePassive(i + i2 + i5 + i4);
                BaseMetricsWorker.a(context, (BaseMetric) connectionMetric);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(TrackingHelper trackingHelper, Settings settings, ConnectionTimePassiveDAO connectionTimePassiveDAO) {
        try {
            ConnectionType a2 = trackingHelper.a(getApplicationContext());
            ConnectionTimePassive connectionTimePassive = new ConnectionTimePassive();
            connectionTimePassive.a(a2);
            connectionTimePassive.a((long) settings.connectionMeasurementFrequency().intValue());
            connectionTimePassiveDAO.a(connectionTimePassive);
            int i = this.c - 1;
            this.c = i;
            if (i == 0) {
                this.a.countDown();
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ExcHandler: Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:7:0x002a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.ListenableWorker.Result doWork() {
        /*
            r12 = this;
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()
            if (r0 != 0) goto L_0x000b
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()
            return r0
        L_0x000b:
            com.cellrebel.sdk.database.SDKRoomDatabase r0 = com.cellrebel.sdk.database.DatabaseClient.a()
            com.cellrebel.sdk.database.dao.ConnectionTimeActiveDAO r0 = r0.c()
            com.cellrebel.sdk.database.SDKRoomDatabase r1 = com.cellrebel.sdk.database.DatabaseClient.a()
            com.cellrebel.sdk.database.dao.ConnectionTimePassiveDAO r1 = r1.d()
            com.cellrebel.sdk.utils.FileLoggingTree r2 = com.cellrebel.sdk.workers.MetaHelp.l
            if (r2 != 0) goto L_0x002a
            com.cellrebel.sdk.utils.FileLoggingTree r2 = new com.cellrebel.sdk.utils.FileLoggingTree
            android.content.Context r3 = r12.getApplicationContext()
            r2.<init>(r3)
            com.cellrebel.sdk.workers.MetaHelp.l = r2
        L_0x002a:
            com.cellrebel.sdk.utils.SettingsManager r2 = com.cellrebel.sdk.utils.SettingsManager.b()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r2.c()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            if (r2 != 0) goto L_0x0039
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            return r0
        L_0x0039:
            java.lang.Boolean r3 = r2.connectionMeasurements()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            if (r3 != 0) goto L_0x0048
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            return r0
        L_0x0048:
            com.cellrebel.sdk.utils.Storage r3 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            long r3 = r3.d()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            long r3 = r3 - r5
            long r3 = java.lang.Math.abs(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            java.lang.Integer r5 = r2.connectionMeasurementPeriodicity()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            int r5 = r5.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            int r5 = r5 * 45
            long r5 = (long) r5     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0071
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            return r0
        L_0x0071:
            com.cellrebel.sdk.workers.BaseMetricsWorker r3 = r12.d     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            android.content.Context r4 = r12.getApplicationContext()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r3.a((android.content.Context) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            com.cellrebel.sdk.utils.TrackingHelper r3 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r4 = 0
            r3.a = r4     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            com.cellrebel.sdk.utils.TrackingHelper r3 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            com.cellrebel.sdk.database.ConnectionType r4 = com.cellrebel.sdk.database.ConnectionType.UNKNOWN     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r3.b = r4     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            java.lang.Integer r3 = r2.connectionMeasurementFrequency()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            if (r3 == 0) goto L_0x0099
            java.lang.Integer r3 = r2.connectionMeasurementFrequency()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            int r3 = r3.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            goto L_0x009b
        L_0x0099:
            r3 = 30
        L_0x009b:
            r4 = 180(0xb4, float:2.52E-43)
            int r4 = r4 / r3
            r12.c = r4     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            android.content.Context r4 = r12.getApplicationContext()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            java.lang.String r5 = "phone"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            com.cellrebel.sdk.utils.TrackingHelper r4 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            com.cellrebel.sdk.workers.CollectConnectionMetricsWorker$$ExternalSyntheticLambda0 r6 = new com.cellrebel.sdk.workers.CollectConnectionMetricsWorker$$ExternalSyntheticLambda0     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r6.<init>(r12, r4, r2, r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            java.util.concurrent.ScheduledExecutorService r5 = r12.b     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r7 = 0
            int r3 = r3 * 1000
            long r9 = (long) r3     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            java.util.concurrent.ScheduledFuture r2 = r5.scheduleAtFixedRate(r6, r7, r9, r11)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            java.util.concurrent.CountDownLatch r3 = r12.a     // Catch:{ InterruptedException -> 0x00c7, Exception | OutOfMemoryError -> 0x00e3 }
            r3.await()     // Catch:{ InterruptedException -> 0x00c7, Exception | OutOfMemoryError -> 0x00e3 }
        L_0x00c7:
            r3 = 1
            r2.cancel(r3)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            android.content.Context r2 = r12.getApplicationContext()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r12.a(r2)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r0.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r1.a()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            com.cellrebel.sdk.utils.Storage r0 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
            r0.c(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x00e3 }
        L_0x00e3:
            androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectConnectionMetricsWorker.doWork():androidx.work.ListenableWorker$Result");
    }

    public void onStopped() {
        super.onStopped();
        if (MetaHelp.l == null) {
            MetaHelp.l = new FileLoggingTree(getApplicationContext());
        }
    }
}
