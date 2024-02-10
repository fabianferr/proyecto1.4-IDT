package com.appnext.core.crashes;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CrashesReportWorkManagerService extends Worker {
    public static void a(Context context, String str, String str2) {
        try {
            Data build = new Data.Builder().putString("methodName", str).putString("exception", str2).build();
            Constraints.Builder builder = new Constraints.Builder();
            builder.setRequiredNetworkType(NetworkType.CONNECTED);
            Constraints build2 = builder.build();
            WorkManager.getInstance(context).enqueueUniqueWork("CrashesReportWorkManagerService", ExistingWorkPolicy.APPEND, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(CrashesReportWorkManagerService.class).setInputData(build)).setInputData(build)).addTag("CrashesReportWorkManagerService")).setConstraints(build2)).build());
        } catch (Throwable unused) {
        }
    }

    public CrashesReportWorkManagerService(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        try {
            Data inputData = getInputData();
            if (inputData == null) {
                return ListenableWorker.Result.success();
            }
            new a(getApplicationContext(), inputData.getString("methodName"), inputData.getString("exception")).af();
            return ListenableWorker.Result.success();
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
