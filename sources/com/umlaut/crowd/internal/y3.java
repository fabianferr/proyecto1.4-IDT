package com.umlaut.crowd.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.service.InsightJobService;
import com.umlaut.crowd.service.InsightService;
import com.umlaut.crowd.service.InsightWorker;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class y3 {
    private static final boolean d = false;
    private static final String e = "y3";
    public static final int f = -1752597227;
    public static int g = 60000;
    /* access modifiers changed from: private */
    public Context a;
    private JobScheduler b;
    /* access modifiers changed from: private */
    public AtomicBoolean c = new AtomicBoolean(false);

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (f.b(y3.this.a)) {
                y3.this.a(false);
            } else if (InsightCore.getInsightConfig().l1()) {
                y3.this.a(true);
            } else if (!InsightCore.getInsightConfig().L1() || !f.c(y3.this.a)) {
                y3.this.b();
            } else {
                y3.this.e();
                y3.this.c();
            }
            y3.this.c.set(false);
        }
    }

    public y3(Context context) {
        this.a = context;
        if (Build.VERSION.SDK_INT >= 21 && !f.b(context)) {
            this.b = (JobScheduler) context.getSystemService("jobscheduler");
        }
        g = InsightCore.getInsightConfig().F0();
    }

    private void f() {
        this.a.stopService(new Intent(this.a, InsightService.class));
    }

    private void g() {
        WorkManager.getInstance(this.a).cancelAllWorkByTag(InsightWorker.c);
    }

    /* access modifiers changed from: private */
    public void b() {
        int i = f;
        JobInfo build = new JobInfo.Builder(i, new ComponentName(this.a, InsightJobService.class)).setPersisted(true).setMinimumLatency((long) g).build();
        JobInfo pendingJob = this.b.getPendingJob(i);
        if (pendingJob == null || !pendingJob.getService().equals(build.getService())) {
            try {
                this.b.schedule(build);
            } catch (Exception e2) {
                String str = e;
                Log.d(str, "startInsightJob: " + e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        WorkManager.getInstance(this.a).enqueueUniqueWork(InsightWorker.c, ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(InsightWorker.class).addTag(InsightWorker.c)).build());
    }

    /* access modifiers changed from: private */
    public void e() {
        JobScheduler jobScheduler = this.b;
        if (jobScheduler == null) {
            Log.d(e, "mJobService == null");
        } else {
            jobScheduler.cancel(f);
        }
    }

    public void d() {
        if (f.b(this.a)) {
            f();
        } else if (!InsightCore.getInsightConfig().L1() || !f.c(this.a)) {
            e();
        } else {
            g();
        }
    }

    public void a() {
        if (this.c.compareAndSet(false, true)) {
            ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        Intent intent = new Intent(this.a, InsightService.class);
        if (!z || Build.VERSION.SDK_INT < 26) {
            this.a.startService(intent);
        } else {
            this.a.startForegroundService(intent);
        }
    }
}
