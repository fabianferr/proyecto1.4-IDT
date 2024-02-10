package com.teragence.client;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import com.teragence.client.service.MetricsJobService;
import com.teragence.client.service.MetricsService;
import com.teragence.client.service.d;

public class SdkControls {
    private SdkControls() {
    }

    public static void initialize(Context context) {
        if (!context.getSharedPreferences("MySP", 0).getBoolean("manuallyStopped", false)) {
            startBackgroundWork(context);
        }
    }

    public static void startBackgroundWork(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MySP", 0);
        if (sharedPreferences.getBoolean("manuallyStopped", false)) {
            sharedPreferences.edit().putBoolean("manuallyStopped", false).apply();
        }
        if (Build.VERSION.SDK_INT < 21) {
            context.startService(new Intent(context, MetricsService.class));
        } else {
            ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(0, new ComponentName(context, MetricsJobService.class)).setExtras(new d("COMMAND_START").a("PARAMS_KEY")).setOverrideDeadline(0).build());
        }
    }

    public static void stopBackgroundWork(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MySP", 0);
        if (!sharedPreferences.getBoolean("manuallyStopped", false)) {
            sharedPreferences.edit().putBoolean("manuallyStopped", true).apply();
        }
        d dVar = new d("COMMAND_FINISH");
        if (Build.VERSION.SDK_INT < 21) {
            context.startService(dVar.a(context, MetricsService.class));
        } else {
            ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(0, new ComponentName(context, MetricsJobService.class)).setExtras(dVar.a("PARAMS_KEY")).setMinimumLatency(0).build());
        }
    }
}
