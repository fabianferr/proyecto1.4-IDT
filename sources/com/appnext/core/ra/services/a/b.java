package com.appnext.core.ra.services.a;

import android.content.Context;
import android.os.Bundle;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;
import com.appnext.core.ra.b.a;
import com.appnext.core.ra.services.RecentAppsWorkManagerService;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class b extends a {
    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024 A[Catch:{ all -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.getContext()     // Catch:{ all -> 0x003d }
            androidx.work.WorkManager r1 = androidx.work.WorkManager.getInstance(r1)     // Catch:{ all -> 0x003d }
            com.google.common.util.concurrent.ListenableFuture r5 = r1.getWorkInfosByTag(r5)     // Catch:{ all -> 0x003d }
            java.lang.Object r1 = r5.get()     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x0014:
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x003d }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x003d }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x003d }
        L_0x001e:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x003d }
            androidx.work.WorkInfo r1 = (androidx.work.WorkInfo) r1     // Catch:{ all -> 0x003d }
            androidx.work.WorkInfo$State r2 = r1.getState()     // Catch:{ all -> 0x003d }
            androidx.work.WorkInfo$State r3 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ all -> 0x003d }
            if (r2 == r3) goto L_0x003a
            androidx.work.WorkInfo$State r1 = r1.getState()     // Catch:{ all -> 0x003d }
            androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.ENQUEUED     // Catch:{ all -> 0x003d }
            if (r1 != r2) goto L_0x001e
        L_0x003a:
            r5 = 1
            return r5
        L_0x003c:
            return r0
        L_0x003d:
            r5 = move-exception
            java.lang.String r1 = "RecentAppsWorkManagerLogic$isRAServicesScheduled"
            com.appnext.base.a.a(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.ra.services.a.b.A(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        try {
            Data a = a(aVar.aq());
            String name = aVar.au().name();
            if (aVar.av() == 0) {
                WorkManager.getInstance(getContext()).enqueueUniqueWork(name, ExistingWorkPolicy.APPEND, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(RecentAppsWorkManagerService.class).setInputData(a)).setInputData(a)).addTag(name)).build());
                return;
            }
            long av = aVar.av();
            if (aVar.av() < 0 || (aVar.av() > 0 && aVar.av() < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS)) {
                av = 900000;
            }
            Constraints.Builder builder = new Constraints.Builder();
            builder.setRequiredNetworkType(NetworkType.CONNECTED);
            PeriodicWorkRequest.Builder builder2 = (PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) RecentAppsWorkManagerService.class, av, TimeUnit.MILLISECONDS).setConstraints(builder.build())).setInputData(a)).addTag(name);
            if (aVar.aw() > 0) {
                builder2.setInitialDelay(Math.max(aVar.aw(), 60000), TimeUnit.MILLISECONDS);
            }
            WorkManager.getInstance(getContext()).enqueueUniquePeriodicWork(name, ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) builder2.build());
        } catch (Throwable th) {
            com.appnext.base.a.a("RecentAppsWorkManagerLogic$scheduleEvent", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void c(List<a> list) {
        try {
            int size = list.size();
            WorkContinuation workContinuation = null;
            for (int i = 0; i < size; i++) {
                a aVar = list.get(i);
                Data a = a(aVar.aq());
                OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(RecentAppsWorkManagerService.class).setInputData(a)).setInputData(a)).addTag(aVar.au().name())).build();
                if (i == 0) {
                    workContinuation = WorkManager.getInstance(getContext()).beginWith(oneTimeWorkRequest);
                } else {
                    workContinuation = workContinuation.then(oneTimeWorkRequest);
                }
            }
            if (workContinuation != null) {
                workContinuation.enqueue();
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("RecentAppsWorkManagerLogic$scheduleEventsOrdered", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void B(String str) {
        WorkManager.getInstance(getContext()).cancelUniqueWork(str);
    }

    private static Data a(Bundle bundle) {
        try {
            return new Data.Builder().putInt(NativeProtocol.WEB_DIALOG_ACTION, bundle.getInt(NativeProtocol.WEB_DIALOG_ACTION)).putString("more_data", bundle.getString("more_data")).build();
        } catch (Throwable th) {
            com.appnext.base.a.a("RecentAppsWorkManagerLogic$createDataFromBundle", th);
            return null;
        }
    }
}
