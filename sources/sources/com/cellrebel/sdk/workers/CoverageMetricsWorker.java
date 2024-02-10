package com.cellrebel.sdk.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.utils.Utils;
import java.util.UUID;

public class CoverageMetricsWorker extends Worker {
    public CoverageMetricsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        CollectCoverageMetricsWorker collectCoverageMetricsWorker = new CollectCoverageMetricsWorker();
        collectCoverageMetricsWorker.j = Utils.b(UUID.randomUUID() + PreferencesManager.m().a(getApplicationContext()));
        collectCoverageMetricsWorker.a(getApplicationContext());
        return ListenableWorker.Result.success();
    }
}
