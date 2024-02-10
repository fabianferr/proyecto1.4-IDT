package com.teragence.client.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.MutableContextWrapper;
import androidx.core.app.NotificationCompat;
import com.teragence.client.i;
import com.teragence.library.e2;
import com.teragence.library.h2;
import com.teragence.library.i2;
import com.teragence.library.k2;
import com.teragence.library.m2;
import com.teragence.library.n2;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MetricsJobService extends JobService {
    private static final MutableContextWrapper b = new MutableContextWrapper((Context) null);
    private static f c;
    private static Deque<k2.d> d;

    class a implements h2.a {
        final /* synthetic */ JobParameters a;

        a(JobParameters jobParameters) {
            this.a = jobParameters;
        }

        public void a() {
            MetricsJobService.this.a();
            MetricsJobService.this.jobFinished(this.a, false);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        Deque<k2.d> deque = d;
        if (deque != null && deque.size() > 0) {
            k2.d poll = d.poll();
            if (poll != null) {
                poll.a();
            }
            d.clear();
        }
    }

    private void a(g gVar) {
        if (!getSharedPreferences("MySP", 0).getBoolean("manuallyStopped", false)) {
            d = new ConcurrentLinkedDeque();
            MutableContextWrapper mutableContextWrapper = b;
            h hVar = new h(new c(new j(new n(new i(mutableContextWrapper, new k2(new n2(new m2(mutableContextWrapper, 29061987)), d)), gVar), mutableContextWrapper)));
            c = hVar;
            hVar.a();
            return;
        }
        i.a("MetricsJobService", "onStartJob: SDK manually stopped. Do not schedule.");
    }

    private g b() {
        return new b(new m(getSharedPreferences("MetricsServiceStats", 0)), b);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        try {
            String string = jobParameters.getExtras().getString("PARAMS_KEY", "none");
            i.a("MetricsJobService#" + hashCode(), "onStartJob() called with: params = [" + jobParameters + "], jobId = " + jobParameters.getJobId() + ", command = " + string);
            b.setBaseContext(this);
            if (string.equals("COMMAND_START")) {
                if (c == null) {
                    a(b());
                }
            } else if (string.equals(NotificationCompat.CATEGORY_ALARM)) {
                i.a("MetricsJobService", "onStartJob: COMMAND_ALARM");
                if (c == null) {
                    g b2 = b();
                    if (b2.a()) {
                        a(b2);
                    }
                }
                if (c != null) {
                    if (!getSharedPreferences("MySP", 0).getBoolean("manuallyStopped", false)) {
                        c.a(new i2(new e2(new h2(this, new a(jobParameters)))));
                        return true;
                    }
                    f fVar = c;
                    if (fVar != null) {
                        fVar.b();
                        c = null;
                    }
                    i.a("MetricsJobService", "onStartJob: Stop service, manually stopped SDK.");
                }
            } else if (string.equals("COMMAND_FINISH")) {
                i.a("MetricsJobService", "onStartJob: COMMAND_FINISH");
                f fVar2 = c;
                if (fVar2 != null) {
                    fVar2.b();
                    c = null;
                }
            }
            a();
            jobFinished(jobParameters, false);
            return false;
        } catch (Exception e) {
            i.b("MetricsJobService", e.getMessage());
            return false;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        i.a("MetricsJobService#" + hashCode(), "onStopJob() called with: params = [" + jobParameters + "], jobId = " + jobParameters.getJobId());
        return true;
    }
}
