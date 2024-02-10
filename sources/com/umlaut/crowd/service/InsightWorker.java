package com.umlaut.crowd.service;

import android.content.Context;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.umlaut.crowd.internal.y3;
import java.util.concurrent.TimeUnit;

public class InsightWorker extends Worker {
    private static final boolean a = false;
    private static final String b = "InsightWorker";
    public static final String c = "InsightWorker";

    public InsightWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        WorkManager.getInstance(getApplicationContext()).enqueueUniqueWork("InsightWorker", ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(InsightWorker.class).addTag("InsightWorker")).setInitialDelay((long) y3.g, TimeUnit.MILLISECONDS)).build());
        return ListenableWorker.Result.success();
    }
}
