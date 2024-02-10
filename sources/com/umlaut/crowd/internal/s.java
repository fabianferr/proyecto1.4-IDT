package com.umlaut.crowd.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.service.BackgroundTestJobService;
import com.umlaut.crowd.service.BackgroundTestWorker;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class s {
    private static final String c = "s";
    private static final boolean d = false;
    private static final int e = -924207987;
    private static final int f = 1414323525;
    /* access modifiers changed from: private */
    public final Context a;
    private JobScheduler b;

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (!InsightCore.getInsightConfig().L1() || !f.c(s.this.a)) {
                s.this.b();
                return;
            }
            s.this.g();
            s.this.e();
        }
    }

    public s(Context context) {
        this.a = context;
        if (Build.VERSION.SDK_INT >= 21) {
            this.b = (JobScheduler) context.getSystemService("jobscheduler");
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.KEEP;
        try {
            for (WorkInfo tags : (List) WorkManager.getInstance(this.a).getWorkInfosByTag(BackgroundTestWorker.c).get()) {
                for (String next : tags.getTags()) {
                    if (!next.equals(BackgroundTestWorker.c) && !next.equals(BackgroundTestWorker.class.getCanonicalName())) {
                        existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.REPLACE;
                    }
                }
            }
        } catch (Exception unused) {
        }
        long o = InsightCore.getInsightConfig().o();
        boolean l = InsightCore.getInsightConfig().l();
        int m = InsightCore.getInsightConfig().m();
        NetworkType networkType = NetworkType.CONNECTED;
        if (m == 2) {
            networkType = NetworkType.UNMETERED;
        }
        WorkManager instance = WorkManager.getInstance(this.a);
        instance.enqueueUniquePeriodicWork(BackgroundTestWorker.c, existingPeriodicWorkPolicy, (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) BackgroundTestWorker.class, o, TimeUnit.MILLISECONDS).setConstraints(new Constraints.Builder().setRequiresBatteryNotLow(true).setRequiresCharging(l).setRequiredNetworkType(networkType).build())).addTag(BackgroundTestWorker.c)).build());
    }

    /* access modifiers changed from: private */
    public void g() {
        JobScheduler jobScheduler = this.b;
        if (jobScheduler == null) {
            Log.d(c, "mJobService == null");
        } else {
            jobScheduler.cancel(e);
        }
    }

    private void h() {
        WorkManager.getInstance(this.a).cancelAllWorkByTag(BackgroundTestWorker.c);
    }

    public void f() {
        if (!InsightCore.getInsightConfig().L1() || !f.c(this.a)) {
            g();
        } else {
            h();
        }
    }

    public void startOneTimeBackgroundTest() {
        if (!InsightCore.getInsightConfig().L1() || !f.c(this.a)) {
            c();
        } else {
            d();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        JobInfo jobInfo;
        if (this.b == null) {
            Log.d(c, "mJobService == null");
            return;
        }
        long o = InsightCore.getInsightConfig().o();
        boolean l = InsightCore.getInsightConfig().l();
        int i = 2;
        if (InsightCore.getInsightConfig().m() != 2) {
            i = 1;
        }
        int i2 = e;
        JobInfo.Builder requiresCharging = new JobInfo.Builder(i2, new ComponentName(this.a, BackgroundTestJobService.class)).setPersisted(true).setPeriodic(o).setRequiredNetworkType(i).setRequiresCharging(l);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            requiresCharging.setRequiresBatteryNotLow(true);
        }
        JobInfo build = requiresCharging.build();
        if (i3 < 24) {
            Iterator<JobInfo> it = this.b.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    jobInfo = null;
                    break;
                }
                JobInfo next = it.next();
                if (next.getId() == e) {
                    jobInfo = next;
                    break;
                }
            }
        } else {
            jobInfo = this.b.getPendingJob(i2);
        }
        if (jobInfo == null || !jobInfo.getService().equals(build.getService()) || jobInfo.getIntervalMillis() != build.getIntervalMillis() || jobInfo.isRequireCharging() != build.isRequireCharging() || jobInfo.isRequireDeviceIdle() != build.isRequireDeviceIdle()) {
            try {
                this.b.schedule(build);
            } catch (Exception e2) {
                String str = c;
                Log.e(str, "startBackgroundTestJob:" + e2.toString());
            }
        }
    }

    private void c() {
        JobInfo jobInfo;
        if (this.b == null) {
            Log.d(c, "mJobService == null");
            return;
        }
        int i = f;
        JobInfo build = new JobInfo.Builder(i, new ComponentName(this.a, BackgroundTestJobService.class)).setMinimumLatency(1000).build();
        if (Build.VERSION.SDK_INT < 24) {
            Iterator<JobInfo> it = this.b.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    jobInfo = null;
                    break;
                }
                JobInfo next = it.next();
                if (next.getId() == f) {
                    jobInfo = next;
                    break;
                }
            }
        } else {
            jobInfo = this.b.getPendingJob(i);
        }
        if (jobInfo == null || !jobInfo.getService().equals(build.getService())) {
            this.b.schedule(build);
        }
    }

    private void d() {
        WorkManager.getInstance(this.a).enqueueUniqueWork(BackgroundTestWorker.d, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(BackgroundTestWorker.class).addTag(BackgroundTestWorker.d)).build());
    }

    public void a() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
    }
}
