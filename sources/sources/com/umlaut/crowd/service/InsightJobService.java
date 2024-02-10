package com.umlaut.crowd.service;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.util.Log;
import com.umlaut.crowd.internal.y3;
import com.umlaut.crowd.threads.ThreadManager;

public class InsightJobService extends JobService {
    private static final boolean a = false;
    private static final String b = "InsightJobService";

    class a implements Runnable {
        a() {
        }

        public void run() {
            InsightJobService.this.a();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onStartJob(JobParameters jobParameters) {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    /* access modifiers changed from: private */
    public void a() {
        JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            try {
                jobScheduler.schedule(new JobInfo.Builder(y3.f, new ComponentName(getApplicationContext(), InsightJobService.class)).setPersisted(true).setMinimumLatency((long) y3.g).build());
            } catch (Exception e) {
                String str = b;
                Log.e(str, "rescheduleJob:" + e.toString());
            }
        }
    }
}
