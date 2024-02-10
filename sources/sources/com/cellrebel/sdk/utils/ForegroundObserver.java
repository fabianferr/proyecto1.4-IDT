package com.cellrebel.sdk.utils;

import android.app.KeyguardManager;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.C;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.ApiClient;
import com.cellrebel.sdk.networking.UrlProvider;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.workers.TrackingManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import retrofit2.Response;

public class ForegroundObserver implements DefaultLifecycleObserver {
    /* access modifiers changed from: private */
    public Context a;

    class a extends TimerTask {
        final /* synthetic */ KeyguardManager a;
        final /* synthetic */ CountDownLatch b;
        final /* synthetic */ Timer c;
        final /* synthetic */ long d;

        a(KeyguardManager keyguardManager, CountDownLatch countDownLatch, Timer timer, long j) {
            this.a = keyguardManager;
            this.b = countDownLatch;
            this.c = timer;
            this.d = j;
        }

        public void run() {
            if (!this.a.inKeyguardRestrictedInputMode() || System.currentTimeMillis() - this.d > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                this.b.countDown();
                this.c.cancel();
            }
        }
    }

    class b extends TimerTask {
        final /* synthetic */ CountDownLatch a;
        final /* synthetic */ Timer b;
        final /* synthetic */ long c;

        b(CountDownLatch countDownLatch, Timer timer, long j) {
            this.a = countDownLatch;
            this.b = timer;
            this.c = j;
        }

        public void run() {
            if (PreferencesManager.m().o() || System.currentTimeMillis() - this.c > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                this.a.countDown();
                this.b.cancel();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            TrackingManager.startTracking(ForegroundObserver.this.a);
        }
    }

    public ForegroundObserver(Context context) {
        this.a = context;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String a() {
        Settings c2 = SettingsManager.b().c();
        if (c2 == null || c2.backgroundLocationEnabled().booleanValue()) {
            return null;
        }
        TrackingHelper.a().e();
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (com.cellrebel.sdk.utils.Utils.a(r6.coverageForegroundPeriodicity().intValue(), com.cellrebel.sdk.utils.Storage.J().k()) != false) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f A[Catch:{ Exception | OutOfMemoryError -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.lang.String a(boolean r5, com.cellrebel.sdk.networking.beans.response.Settings r6) {
        /*
            r4 = this;
            android.os.Looper.prepare()
            com.cellrebel.sdk.utils.TrackingHelper r0 = com.cellrebel.sdk.utils.TrackingHelper.a()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.content.Context r1 = r4.a     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r0.A(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            com.cellrebel.sdk.utils.TelephonyHelper r0 = com.cellrebel.sdk.utils.TelephonyHelper.b()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.content.Context r1 = r4.a     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r0.c(r1)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x003a
            java.lang.Boolean r5 = r6.coverageMeasurement()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r5 == 0) goto L_0x005c
            java.lang.Integer r5 = r6.wifiCoverageForegroundPeriodicity()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            int r5 = r5.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            com.cellrebel.sdk.utils.Storage r6 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            long r2 = r6.l()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            boolean r5 = com.cellrebel.sdk.utils.Utils.a((int) r5, (long) r2)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r5 == 0) goto L_0x005c
            goto L_0x005a
        L_0x003a:
            java.lang.Boolean r5 = r6.coverageMeasurement()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r5 == 0) goto L_0x005c
            java.lang.Integer r5 = r6.coverageForegroundPeriodicity()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            int r5 = r5.intValue()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            com.cellrebel.sdk.utils.Storage r6 = com.cellrebel.sdk.utils.Storage.J()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            long r2 = r6.k()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            boolean r5 = com.cellrebel.sdk.utils.Utils.a((int) r5, (long) r2)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            if (r5 == 0) goto L_0x005c
        L_0x005a:
            r5 = 1
            goto L_0x005d
        L_0x005c:
            r5 = 0
        L_0x005d:
            if (r5 == 0) goto L_0x009c
            com.cellrebel.sdk.workers.CollectCoverageMetricsWorker r5 = new com.cellrebel.sdk.workers.CollectCoverageMetricsWorker     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r5.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r1     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r5.c = r1     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r5.d = r0     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r6.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r6.append(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            com.cellrebel.sdk.utils.PreferencesManager r0 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.content.Context r1 = r4.a     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.String r0 = r0.a((android.content.Context) r1)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r6.append(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            java.lang.String r6 = com.cellrebel.sdk.utils.Utils.b((java.lang.String) r6)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r5.j = r6     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.content.Context r6 = r4.a     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r5.a(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            com.cellrebel.sdk.workers.SendCoverageMetricsWorker r5 = new com.cellrebel.sdk.workers.SendCoverageMetricsWorker     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r5.<init>()     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            android.content.Context r6 = r4.a     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
            r5.a(r6)     // Catch:{ Exception | OutOfMemoryError -> 0x009c }
        L_0x009c:
            android.os.Looper.loop()
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.ForegroundObserver.a(boolean, com.cellrebel.sdk.networking.beans.response.Settings):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014d, code lost:
        if (com.cellrebel.sdk.utils.Utils.a(r21.wifiGameForegroundPeriodicity().intValue(), com.cellrebel.sdk.utils.Storage.J().s()) != false) goto L_0x0218;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0216, code lost:
        if (com.cellrebel.sdk.utils.Utils.a(r21.foregroundGamePeriodicity().intValue(), com.cellrebel.sdk.utils.Storage.J().r()) != false) goto L_0x0218;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ java.lang.String a(boolean r20, com.cellrebel.sdk.networking.beans.response.Settings r21, com.cellrebel.sdk.utils.Storage r22, long r23) {
        /*
            r19 = this;
            r7 = r19
            android.content.Context r0 = r7.a
            java.lang.String r1 = "keyguard"
            java.lang.Object r0 = r0.getSystemService(r1)
            r8 = r0
            android.app.KeyguardManager r8 = (android.app.KeyguardManager) r8
            boolean r0 = r8.inKeyguardRestrictedInputMode()
            r9 = 0
            r10 = 1
            r11 = 0
            if (r0 == 0) goto L_0x0044
            java.util.concurrent.CountDownLatch r12 = new java.util.concurrent.CountDownLatch
            r12.<init>(r10)
            long r5 = java.lang.System.currentTimeMillis()
            java.util.Timer r13 = new java.util.Timer
            r13.<init>()
            com.cellrebel.sdk.utils.ForegroundObserver$a r14 = new com.cellrebel.sdk.utils.ForegroundObserver$a
            r0 = r14
            r1 = r19
            r2 = r8
            r3 = r12
            r4 = r13
            r0.<init>(r2, r3, r4, r5)
            long r0 = (long) r11
            r2 = 100
            long r2 = (long) r2
            r15 = r0
            r17 = r2
            r13.schedule(r14, r15, r17)
            r12.await()     // Catch:{ InterruptedException -> 0x0043 }
            boolean r0 = r8.inKeyguardRestrictedInputMode()     // Catch:{ InterruptedException -> 0x0043 }
            if (r0 == 0) goto L_0x0044
            return r9
        L_0x0043:
        L_0x0044:
            com.cellrebel.sdk.utils.PreferencesManager r0 = com.cellrebel.sdk.utils.PreferencesManager.m()
            boolean r0 = r0.o()
            if (r0 != 0) goto L_0x007e
            java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch
            r6.<init>(r10)
            long r4 = java.lang.System.currentTimeMillis()
            java.util.Timer r12 = new java.util.Timer
            r12.<init>()
            com.cellrebel.sdk.utils.ForegroundObserver$b r13 = new com.cellrebel.sdk.utils.ForegroundObserver$b
            r0 = r13
            r1 = r19
            r2 = r6
            r3 = r12
            r0.<init>(r2, r3, r4)
            long r14 = (long) r11
            r0 = 500(0x1f4, float:7.0E-43)
            long r0 = (long) r0
            r16 = r0
            r12.schedule(r13, r14, r16)
            r6.await()     // Catch:{ InterruptedException -> 0x007d }
            com.cellrebel.sdk.utils.PreferencesManager r0 = com.cellrebel.sdk.utils.PreferencesManager.m()     // Catch:{ InterruptedException -> 0x007d }
            boolean r0 = r0.o()     // Catch:{ InterruptedException -> 0x007d }
            if (r0 != 0) goto L_0x007e
            return r9
        L_0x007d:
        L_0x007e:
            java.lang.Boolean r0 = r21.isPageLoadMeasurement()
            boolean r0 = r0.booleanValue()
            if (r20 == 0) goto L_0x0151
            if (r0 == 0) goto L_0x00a2
            java.lang.Integer r0 = r21.wifiPageLoadForegroundPeriodicity()
            int r0 = r0.intValue()
            com.cellrebel.sdk.utils.Storage r1 = com.cellrebel.sdk.utils.Storage.J()
            long r1 = r1.y()
            boolean r0 = com.cellrebel.sdk.utils.Utils.a((int) r0, (long) r1)
            if (r0 == 0) goto L_0x00a2
            r0 = 1
            goto L_0x00a3
        L_0x00a2:
            r0 = 0
        L_0x00a3:
            java.lang.Boolean r1 = r21.fileMeasurement()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00c5
            java.lang.Integer r1 = r21.wifiFileTransferForegroundPeriodicity()
            int r1 = r1.intValue()
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()
            long r2 = r2.q()
            boolean r1 = com.cellrebel.sdk.utils.Utils.a((int) r1, (long) r2)
            if (r1 == 0) goto L_0x00c5
            r1 = 1
            goto L_0x00c6
        L_0x00c5:
            r1 = 0
        L_0x00c6:
            java.lang.Boolean r2 = r21.cdnFileMeasurements()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00e8
            java.lang.Integer r2 = r21.wifiCdnFileDownloadForegroundPeriodicity()
            int r2 = r2.intValue()
            com.cellrebel.sdk.utils.Storage r3 = com.cellrebel.sdk.utils.Storage.J()
            long r3 = r3.j()
            boolean r2 = com.cellrebel.sdk.utils.Utils.a((int) r2, (long) r3)
            if (r2 == 0) goto L_0x00e8
            r2 = 1
            goto L_0x00e9
        L_0x00e8:
            r2 = 0
        L_0x00e9:
            java.lang.Boolean r3 = r21.videoActiveMeasurement()
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x010b
            java.lang.Integer r3 = r21.wifiVideoForegroundPeriodicity()
            int r3 = r3.intValue()
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()
            long r4 = r4.H()
            boolean r3 = com.cellrebel.sdk.utils.Utils.a((int) r3, (long) r4)
            if (r3 == 0) goto L_0x010b
            r3 = 1
            goto L_0x010c
        L_0x010b:
            r3 = 0
        L_0x010c:
            java.lang.Boolean r4 = r21.coverageMeasurement()
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x012e
            java.lang.Integer r4 = r21.wifiCoverageForegroundPeriodicity()
            int r4 = r4.intValue()
            com.cellrebel.sdk.utils.Storage r5 = com.cellrebel.sdk.utils.Storage.J()
            long r5 = r5.l()
            boolean r4 = com.cellrebel.sdk.utils.Utils.a((int) r4, (long) r5)
            if (r4 == 0) goto L_0x012e
            r4 = 1
            goto L_0x012f
        L_0x012e:
            r4 = 0
        L_0x012f:
            java.lang.Boolean r5 = r21.foregroundGameMeasurement()
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x021a
            java.lang.Integer r5 = r21.wifiGameForegroundPeriodicity()
            int r5 = r5.intValue()
            com.cellrebel.sdk.utils.Storage r6 = com.cellrebel.sdk.utils.Storage.J()
            long r12 = r6.s()
            boolean r5 = com.cellrebel.sdk.utils.Utils.a((int) r5, (long) r12)
            if (r5 == 0) goto L_0x021a
            goto L_0x0218
        L_0x0151:
            if (r0 == 0) goto L_0x016b
            java.lang.Integer r0 = r21.pageLoadForegroundPeriodicityMeasurement()
            int r0 = r0.intValue()
            com.cellrebel.sdk.utils.Storage r1 = com.cellrebel.sdk.utils.Storage.J()
            long r1 = r1.x()
            boolean r0 = com.cellrebel.sdk.utils.Utils.a((int) r0, (long) r1)
            if (r0 == 0) goto L_0x016b
            r0 = 1
            goto L_0x016c
        L_0x016b:
            r0 = 0
        L_0x016c:
            java.lang.Boolean r1 = r21.fileMeasurement()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x018e
            java.lang.Integer r1 = r21.fileTransferForegroundPeriodicityTimer()
            int r1 = r1.intValue()
            com.cellrebel.sdk.utils.Storage r2 = com.cellrebel.sdk.utils.Storage.J()
            long r2 = r2.p()
            boolean r1 = com.cellrebel.sdk.utils.Utils.a((int) r1, (long) r2)
            if (r1 == 0) goto L_0x018e
            r1 = 1
            goto L_0x018f
        L_0x018e:
            r1 = 0
        L_0x018f:
            java.lang.Boolean r2 = r21.cdnFileMeasurements()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x01b1
            java.lang.Integer r2 = r21.cdnFileDownloadForegroundPeriodicity()
            int r2 = r2.intValue()
            com.cellrebel.sdk.utils.Storage r3 = com.cellrebel.sdk.utils.Storage.J()
            long r3 = r3.i()
            boolean r2 = com.cellrebel.sdk.utils.Utils.a((int) r2, (long) r3)
            if (r2 == 0) goto L_0x01b1
            r2 = 1
            goto L_0x01b2
        L_0x01b1:
            r2 = 0
        L_0x01b2:
            java.lang.Boolean r3 = r21.videoActiveMeasurement()
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x01d4
            java.lang.Integer r3 = r21.videoForegroundPeriodicityMeasurement()
            int r3 = r3.intValue()
            com.cellrebel.sdk.utils.Storage r4 = com.cellrebel.sdk.utils.Storage.J()
            long r4 = r4.G()
            boolean r3 = com.cellrebel.sdk.utils.Utils.a((int) r3, (long) r4)
            if (r3 == 0) goto L_0x01d4
            r3 = 1
            goto L_0x01d5
        L_0x01d4:
            r3 = 0
        L_0x01d5:
            java.lang.Boolean r4 = r21.coverageMeasurement()
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01f7
            java.lang.Integer r4 = r21.coverageForegroundPeriodicity()
            int r4 = r4.intValue()
            com.cellrebel.sdk.utils.Storage r5 = com.cellrebel.sdk.utils.Storage.J()
            long r5 = r5.k()
            boolean r4 = com.cellrebel.sdk.utils.Utils.a((int) r4, (long) r5)
            if (r4 == 0) goto L_0x01f7
            r4 = 1
            goto L_0x01f8
        L_0x01f7:
            r4 = 0
        L_0x01f8:
            java.lang.Boolean r5 = r21.foregroundGameMeasurement()
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x021a
            java.lang.Integer r5 = r21.foregroundGamePeriodicity()
            int r5 = r5.intValue()
            com.cellrebel.sdk.utils.Storage r6 = com.cellrebel.sdk.utils.Storage.J()
            long r12 = r6.r()
            boolean r5 = com.cellrebel.sdk.utils.Utils.a((int) r5, (long) r12)
            if (r5 == 0) goto L_0x021a
        L_0x0218:
            r5 = 1
            goto L_0x021b
        L_0x021a:
            r5 = 0
        L_0x021b:
            if (r0 != 0) goto L_0x0228
            if (r1 != 0) goto L_0x0228
            if (r2 != 0) goto L_0x0228
            if (r3 != 0) goto L_0x0228
            if (r4 != 0) goto L_0x0228
            if (r5 != 0) goto L_0x0228
            return r9
        L_0x0228:
            androidx.work.Data$Builder r0 = new androidx.work.Data$Builder
            r0.<init>()
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            long r1 = r1.getTime()
            java.lang.String r3 = "timestamp"
            androidx.work.Data$Builder r0 = r0.putLong(r3, r1)
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            boolean r1 = r1.o()
            java.lang.String r2 = "isAfterCall"
            androidx.work.Data$Builder r0 = r0.putBoolean(r2, r1)
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            boolean r1 = r1.q()
            java.lang.String r2 = "isOnCall"
            androidx.work.Data$Builder r0 = r0.putBoolean(r2, r1)
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            boolean r1 = r1.r()
            java.lang.String r2 = "isRinging"
            androidx.work.Data$Builder r0 = r0.putBoolean(r2, r1)
            androidx.work.Data r0 = r0.build()
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            r1.a((boolean) r11, (boolean) r11, (boolean) r11)
            androidx.work.OneTimeWorkRequest$Builder r1 = new androidx.work.OneTimeWorkRequest$Builder
            java.lang.Class<com.cellrebel.sdk.workers.ForegroundWorker> r2 = com.cellrebel.sdk.workers.ForegroundWorker.class
            r1.<init>(r2)
            java.lang.String r2 = "CR_FOREGROUND_MEASUREMENT_WORKER_TAG"
            androidx.work.WorkRequest$Builder r1 = r1.addTag(r2)
            androidx.work.OneTimeWorkRequest$Builder r1 = (androidx.work.OneTimeWorkRequest.Builder) r1
            androidx.work.WorkRequest$Builder r0 = r1.setInputData(r0)
            androidx.work.OneTimeWorkRequest$Builder r0 = (androidx.work.OneTimeWorkRequest.Builder) r0
            androidx.work.Constraints r1 = androidx.work.Constraints.NONE
            androidx.work.WorkRequest$Builder r0 = r0.setConstraints(r1)
            androidx.work.OneTimeWorkRequest$Builder r0 = (androidx.work.OneTimeWorkRequest.Builder) r0
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
            r2 = 10
            androidx.work.WorkRequest$Builder r0 = r0.setInitialDelay(r2, r1)
            androidx.work.OneTimeWorkRequest$Builder r0 = (androidx.work.OneTimeWorkRequest.Builder) r0
            androidx.work.WorkRequest r0 = r0.build()
            androidx.work.OneTimeWorkRequest r0 = (androidx.work.OneTimeWorkRequest) r0
            android.content.Context r1 = r7.a
            androidx.work.WorkManager r1 = androidx.work.WorkManager.getInstance(r1)
            androidx.work.ExistingWorkPolicy r2 = androidx.work.ExistingWorkPolicy.KEEP
            java.lang.String r3 = "CR_FOREGROUND_WORKER"
            r1.enqueueUniqueWork((java.lang.String) r3, (androidx.work.ExistingWorkPolicy) r2, (androidx.work.OneTimeWorkRequest) r0)
            java.lang.Integer r0 = r21.dataUsageForegroundPeriodicity()
            int r0 = r0.intValue()
            long r0 = (long) r0
            java.lang.Integer r2 = r21.wifiDataUsageForegroundPeriodicity()
            int r2 = r2.intValue()
            long r2 = (long) r2
            long r4 = r22.m()
            long r11 = r22.n()
            java.lang.Boolean r6 = r21.dataUsage()
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0326
            r13 = 1000(0x3e8, double:4.94E-321)
            r15 = 60
            if (r20 == 0) goto L_0x02e0
            long r11 = r23 - r11
            long r2 = r2 * r15
            long r2 = r2 * r13
            int r6 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x02e0
            goto L_0x0326
        L_0x02e0:
            if (r20 != 0) goto L_0x02ed
            long r2 = r23 - r4
            long r0 = r0 * r15
            long r0 = r0 * r13
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x02ed
            goto L_0x0326
        L_0x02ed:
            com.cellrebel.sdk.workers.DataUsageMetricsWorker r0 = new com.cellrebel.sdk.workers.DataUsageMetricsWorker
            r0.<init>()
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            boolean r1 = r1.o()
            r0.d = r1
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            boolean r1 = r1.r()
            r0.f = r1
            com.cellrebel.sdk.utils.PreferencesManager r1 = com.cellrebel.sdk.utils.PreferencesManager.m()
            boolean r1 = r1.q()
            r0.e = r1
            com.cellrebel.sdk.workers.BaseMetricsWorker.h = r10
            android.content.Context r1 = r7.a
            r0.a(r1)
            boolean r0 = com.cellrebel.sdk.utils.Utils.e()
            if (r0 == 0) goto L_0x0326
            if (r20 == 0) goto L_0x0323
            r22.m(r23)
            goto L_0x0326
        L_0x0323:
            r22.l(r23)
        L_0x0326:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.ForegroundObserver.a(boolean, com.cellrebel.sdk.networking.beans.response.Settings, com.cellrebel.sdk.utils.Storage, long):java.lang.String");
    }

    private void a(int i) {
        Executors.newSingleThreadScheduledExecutor().schedule(new c(), (long) i, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String b() {
        boolean z;
        try {
            boolean r = PreferencesManager.m().r();
            boolean q = PreferencesManager.m().q();
            boolean o = PreferencesManager.m().o();
            if (r || q || o) {
                Storage J = Storage.J();
                if (J == null) {
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Settings c2 = SettingsManager.b().c();
                if (c2 == null && PreferencesManager.m().a(this.a) != null) {
                    Response<Settings> execute = ApiClient.a().d(UrlProvider.b((Settings) null)).execute();
                    if (!execute.isSuccessful() || execute.body() == null) {
                        return null;
                    }
                    c2 = execute.body();
                    SettingsManager.b().a(c2);
                    J.L(currentTimeMillis);
                }
                if (c2 == null) {
                    return null;
                }
                if (!c2.isForegroundListenerEnabled().booleanValue()) {
                    return null;
                }
                boolean z2 = TrackingHelper.a().a(this.a) == ConnectionType.WIFI;
                long t = J.t();
                long u = J.u();
                long b2 = J.b();
                long intValue = (long) c2.foregroundPeriodicity().intValue();
                long intValue2 = (long) c2.wifiForegroundTimer().intValue();
                if (z2) {
                    long j = currentTimeMillis - u;
                    if (j < intValue2 * 60 * 1000) {
                        Log.d("CellRebelSDK", "WiFi measurements skipped, next measurement in " + (intValue2 - ((j / 60) / 1000)) + " minutes");
                        return null;
                    }
                }
                if (!z2) {
                    long j2 = currentTimeMillis - t;
                    if (j2 < intValue * 60 * 1000) {
                        Log.d("CellRebelSDK", "Measurements skipped, next measurement in " + (intValue - ((j2 / 60) / 1000)) + " minutes");
                        return null;
                    }
                }
                if (currentTimeMillis - b2 < 300000) {
                    Log.d("CellRebelSDK", "Measurements skipped, next measurement in 5 minutes");
                    return null;
                } else if (z2 && currentTimeMillis - u < 60000) {
                    Log.d("CellRebelSDK", "WiFi measurements skipped");
                    return null;
                } else if (z2 || currentTimeMillis - t >= 60000) {
                    ThreadPoolProvider.a().b(new ForegroundObserver$$ExternalSyntheticLambda1(this, z2, c2));
                    ThreadPoolProvider.a().b(new ForegroundObserver$$ExternalSyntheticLambda2(this, z2, c2, J, currentTimeMillis));
                    return null;
                } else {
                    Log.d("CellRebelSDK", "Cellular measurements skipped");
                    return null;
                }
            } else {
                Settings c3 = SettingsManager.b().c();
                if (c3 == null) {
                    return null;
                }
                int intValue3 = c3.foregroundMeasurementPeriodicity().intValue();
                if (c3.isMeasurementsAutoStartEnabled().booleanValue()) {
                    a(c3.measurementsAutoStartDelay().intValue());
                } else if (intValue3 > 0) {
                    Storage J2 = Storage.J();
                    if (J2 == null) {
                        return null;
                    }
                    boolean z3 = TrackingHelper.a().a(this.a) == ConnectionType.WIFI;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long t2 = J2.t();
                    long u2 = J2.u();
                    if (z3) {
                        z = z3;
                        if (currentTimeMillis2 - u2 < ((long) intValue3) * 60 * 1000) {
                            Log.d("CellRebelSDK", "WiFi measurements skipped");
                            return null;
                        }
                    } else {
                        z = z3;
                    }
                    if (z || currentTimeMillis2 - t2 >= ((long) intValue3) * 60 * 1000) {
                        PreferencesManager.m().z();
                        a(5);
                        return null;
                    }
                    Log.d("CellRebelSDK", "Cellular measurements skipped");
                    return null;
                }
                return null;
            }
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String c() {
        Settings c2 = SettingsManager.b().c();
        if (c2 == null || c2.backgroundLocationEnabled().booleanValue()) {
            return null;
        }
        TrackingHelper.a().e();
        return null;
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
        try {
            if (DatabaseClient.a() != null) {
                ThreadPoolProvider.a().a(new ForegroundObserver$$ExternalSyntheticLambda4());
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
        if (DatabaseClient.a() != null) {
            ThreadPoolProvider.a().a(new ForegroundObserver$$ExternalSyntheticLambda3(this));
        }
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
        try {
            if (DatabaseClient.a() != null) {
                ThreadPoolProvider.a().a(new ForegroundObserver$$ExternalSyntheticLambda0());
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }
}
