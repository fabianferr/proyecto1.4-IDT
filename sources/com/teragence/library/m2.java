package com.teragence.library;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.teragence.client.service.MetricsJobService;
import com.teragence.client.service.d;

public class m2 implements l2 {
    private final Context a;
    private final int b;

    public m2(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    public void a() {
        ((JobScheduler) this.a.getSystemService("jobscheduler")).cancel(this.b);
    }

    public void a(int i) {
        ((JobScheduler) this.a.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(this.b, new ComponentName(this.a, MetricsJobService.class)).setPeriodic((long) i).setExtras(new d(NotificationCompat.CATEGORY_ALARM).a("PARAMS_KEY")).build());
    }

    public void b(int i) {
        a();
        a(i);
    }
}
