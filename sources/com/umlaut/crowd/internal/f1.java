package com.umlaut.crowd.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.service.ConnectivityJobService;
import com.umlaut.crowd.service.ConnectivityService;
import com.umlaut.crowd.service.ConnectivityWorker;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class f1 {
    private static final boolean d = false;
    private static final String e = "f1";
    public static final int f = 770123876;
    public static final int g = -1895963570;
    /* access modifiers changed from: private */
    public final Context a;
    private final long b;
    private JobScheduler c;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (InsightCore.getInsightConfig().L1() && f.c(f1.this.a)) {
                f1.this.i();
                f1.this.g();
            } else if (f.b(f1.this.a)) {
                f1.this.c();
            } else {
                f1.this.b();
            }
        }
    }

    public f1(Context context) {
        this.a = context;
        IC insightConfig = InsightCore.getInsightConfig();
        if (InsightCore.getConnectivityTestEnabled() || !InsightCore.getConnectivityKeepaliveEnabled()) {
            this.b = insightConfig.V();
        } else {
            this.b = insightConfig.J();
        }
        if (Build.VERSION.SDK_INT >= 21 && !f.b(context)) {
            this.c = (JobScheduler) context.getSystemService("jobscheduler");
        }
    }

    private void f() {
        WorkManager.getInstance(this.a).enqueueUniqueWork(ConnectivityWorker.e, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(ConnectivityWorker.class).addTag(ConnectivityWorker.e)).build());
    }

    /* access modifiers changed from: private */
    public void g() {
        ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.KEEP;
        try {
            for (WorkInfo tags : (List) WorkManager.getInstance(this.a).getWorkInfosByTag(ConnectivityWorker.d).get()) {
                for (String next : tags.getTags()) {
                    if (!next.equals(ConnectivityWorker.d) && !next.equals(ConnectivityWorker.class.getCanonicalName())) {
                        existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.REPLACE;
                    }
                }
            }
        } catch (Exception unused) {
        }
        WorkManager instance = WorkManager.getInstance(this.a);
        instance.enqueueUniquePeriodicWork(ConnectivityWorker.d, existingPeriodicWorkPolicy, (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) ConnectivityWorker.class, this.b, TimeUnit.MILLISECONDS).addTag(ConnectivityWorker.d)).build());
    }

    /* access modifiers changed from: private */
    public void i() {
        JobScheduler jobScheduler = this.c;
        if (jobScheduler == null) {
            Log.d(e, "mJobService == null");
        } else {
            jobScheduler.cancel(f);
        }
    }

    private void j() {
        this.a.stopService(new Intent(this.a, ConnectivityService.class));
    }

    private void k() {
        WorkManager.getInstance(this.a).cancelAllWorkByTag(ConnectivityWorker.d);
    }

    public void h() {
        if (InsightCore.getInsightConfig().L1() && f.c(this.a)) {
            k();
        } else if (f.b(this.a)) {
            j();
        } else {
            i();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        int i = f;
        JobInfo build = new JobInfo.Builder(i, new ComponentName(this.a, ConnectivityJobService.class)).setPersisted(true).setPeriodic(this.b).build();
        JobInfo pendingJob = this.c.getPendingJob(i);
        if (pendingJob == null || !pendingJob.getService().equals(build.getService()) || pendingJob.getIntervalMillis() != this.b) {
            this.c.schedule(build);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        this.a.startService(new Intent(this.a, ConnectivityService.class));
    }

    private void d() {
        JobInfo jobInfo;
        if (f.b(this.a)) {
            Intent intent = new Intent(this.a, ConnectivityService.class);
            intent.setAction(ConnectivityService.r);
            this.a.startService(intent);
            return;
        }
        int i = g;
        JobInfo build = new JobInfo.Builder(i, new ComponentName(this.a, ConnectivityJobService.class)).setMinimumLatency(1000).build();
        if (Build.VERSION.SDK_INT < 24) {
            Iterator<JobInfo> it = this.c.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    jobInfo = null;
                    break;
                }
                JobInfo next = it.next();
                if (next.getId() == g) {
                    jobInfo = next;
                    break;
                }
            }
        } else {
            jobInfo = this.c.getPendingJob(i);
        }
        if (jobInfo == null || !jobInfo.getService().equals(build.getService())) {
            this.c.schedule(build);
        }
    }

    public void a() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
    }

    public void e() {
        if (!InsightCore.getInsightConfig().L1() || !f.c(this.a)) {
            d();
        } else {
            f();
        }
    }
}
