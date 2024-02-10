package com.cellrebel.sdk.workers;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.cellrebel.sdk.database.ConnectionType;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.utils.FileLoggingTree;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.Storage;
import com.cellrebel.sdk.utils.TrackingHelper;
import com.cellrebel.sdk.utils.Utils;

public class ForegroundWorker extends Worker {
    final MetaHelp a = new MetaHelp(getApplicationContext());

    public ForegroundWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        String str;
        StringBuilder sb;
        Context context = TrackingManager.getContext();
        if (context != null) {
            String packageName = context.getPackageName();
            if (PreferencesManager.m().p() && !packageName.equals("com.cellrebel.mobile") && !packageName.equals("com.cellrebel.ping")) {
                str = "Measurements disabled, call TrackingManager.startTracking to start";
                Log.d("CellRebelSDK", str);
                return ListenableWorker.Result.success();
            }
        }
        Storage J = Storage.J();
        Settings c = SettingsManager.b().c();
        if (J == null || c == null) {
            return ListenableWorker.Result.success();
        } else if (!c.isForegroundListenerEnabled().booleanValue()) {
            return ListenableWorker.Result.success();
        } else {
            boolean z = TrackingHelper.a().a(context) == ConnectionType.WIFI;
            long t = J.t();
            long u = J.u();
            long b = J.b();
            long currentTimeMillis = System.currentTimeMillis();
            long intValue = (long) c.foregroundPeriodicity().intValue();
            long intValue2 = (long) c.wifiForegroundTimer().intValue();
            if (z) {
                long j = currentTimeMillis - u;
                if (j < intValue2 * 60 * 1000) {
                    sb = new StringBuilder("WiFi measurements skipped, next measurement in ");
                    sb.append(intValue2 - ((j / 60) / 1000));
                    sb.append(" minutes");
                    str = sb.toString();
                    Log.d("CellRebelSDK", str);
                    return ListenableWorker.Result.success();
                }
            }
            if (!z) {
                long j2 = currentTimeMillis - t;
                if (j2 < intValue * 60 * 1000) {
                    sb = new StringBuilder("Measurements skipped, next measurement in ");
                    sb.append(intValue - ((j2 / 60) / 1000));
                    sb.append(" minutes");
                    str = sb.toString();
                    Log.d("CellRebelSDK", str);
                    return ListenableWorker.Result.success();
                }
            }
            if (currentTimeMillis - b < 300000) {
                str = "Measurements skipped, next measurement in 5 minutes";
            } else if (z && currentTimeMillis - u < 60000) {
                str = "WiFi measurements skipped";
            } else if (z || currentTimeMillis - t >= 60000) {
                if (Utils.e()) {
                    if (z) {
                        J.t(currentTimeMillis);
                    } else {
                        J.s(currentTimeMillis);
                    }
                }
                MetaHelp metaHelp = this.a;
                metaHelp.b = false;
                return metaHelp.a(getInputData().getBoolean("isAppOpen", true), getInputData().getBoolean("isClosed", false), getInputData().getBoolean("isAfterCall", false), getInputData().getBoolean("isOnCall", false), getInputData().getBoolean("isRinging", false), getInputData().getBoolean("isFromObserver", false));
            } else {
                str = "Cellular measurements skipped";
            }
            Log.d("CellRebelSDK", str);
            return ListenableWorker.Result.success();
        }
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
    }
}
