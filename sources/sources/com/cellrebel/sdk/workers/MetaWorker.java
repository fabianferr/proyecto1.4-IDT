package com.cellrebel.sdk.workers;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.cellrebel.sdk.utils.FileLoggingTree;
import com.cellrebel.sdk.utils.PreferencesManager;

public class MetaWorker extends Worker {
    final MetaHelp a = new MetaHelp(getApplicationContext());

    public MetaWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        if (PreferencesManager.m().n()) {
            return this.a.a(getInputData().getBoolean("isAppOpen", false), getInputData().getBoolean("isClosed", false), false, false, false, false);
        }
        Log.d("CellRebelSDK", "Background measurements canceled");
        return ListenableWorker.Result.success();
    }

    public void onStopped() {
        super.onStopped();
        String str = this.a.a;
        if (MetaHelp.l == null) {
            MetaHelp.l = new FileLoggingTree(getApplicationContext());
        }
        MetaHelp metaHelp = this.a;
        metaHelp.b = true;
        String str2 = metaHelp.a;
        CollectPageLoadMetricsWorker collectPageLoadMetricsWorker = this.a.e;
        if (collectPageLoadMetricsWorker != null) {
            collectPageLoadMetricsWorker.a(true);
        }
        CollectVideoMetricsWorker collectVideoMetricsWorker = this.a.i;
        if (collectVideoMetricsWorker != null) {
            collectVideoMetricsWorker.a(true);
        }
        CollectFileTransferMetricsWorker collectFileTransferMetricsWorker = this.a.h;
        if (collectFileTransferMetricsWorker != null) {
            collectFileTransferMetricsWorker.a(true);
        }
        CollectGameWorker collectGameWorker = this.a.f;
        if (collectGameWorker != null) {
            collectGameWorker.a(true);
        }
        CollectLoadedLatencyWorker collectLoadedLatencyWorker = this.a.g;
        if (collectLoadedLatencyWorker != null) {
            collectLoadedLatencyWorker.a(true);
        }
    }
}
