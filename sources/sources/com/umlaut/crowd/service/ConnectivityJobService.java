package com.umlaut.crowd.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CT;
import com.umlaut.crowd.internal.OCTL;
import com.umlaut.crowd.internal.f1;
import com.umlaut.crowd.threads.ThreadManager;

public class ConnectivityJobService extends JobService {
    private static final boolean c = false;
    private static final String d = "ConnectivityJobService";
    private static final int e = 50000;
    /* access modifiers changed from: private */
    public static int f = -1;
    /* access modifiers changed from: private */
    public boolean a;
    /* access modifiers changed from: private */
    public CT b = null;

    class a implements Runnable {
        final /* synthetic */ JobParameters a;

        a(JobParameters jobParameters) {
            this.a = jobParameters;
        }

        public void run() {
            if (!ConnectivityJobService.this.a) {
                ConnectivityJobService.this.jobFinished(this.a, false);
            }
        }
    }

    class b implements OCTL {
        final /* synthetic */ Handler a;
        final /* synthetic */ JobParameters b;

        b(Handler handler, JobParameters jobParameters) {
            this.a = handler;
            this.b = jobParameters;
        }

        public void a() {
            this.a.removeCallbacksAndMessages((Object) null);
            if (!ConnectivityJobService.this.a) {
                ConnectivityJobService.this.jobFinished(this.b, false);
            }
        }

        public void onConnectivityTestStart() {
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ConnectivityJobService.this.b.b(ConnectivityJobService.f == f1.g ? com.umlaut.crowd.internal.a.PeriodicForeground : com.umlaut.crowd.internal.a.Periodic);
        }
    }

    public void onDestroy() {
        try {
            this.a = true;
            f = -1;
            super.onDestroy();
        } catch (Exception e2) {
            String str = d;
            Log.e(str, "onDestroy: " + e2.toString());
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        if (!InsightCore.isInitialized()) {
            Log.i(d, "onStartJob: InsightCore not initialized");
            return false;
        } else if (f != -1) {
            return false;
        } else {
            f = jobParameters.getJobId();
            if (InsightCore.getInsightConfig().w0()) {
                IS insightSettings = InsightCore.getInsightSettings();
                if (insightSettings == null) {
                    return false;
                }
                long w = insightSettings.w();
                if (w > SystemClock.elapsedRealtime()) {
                    insightSettings.f(0);
                    w = 0;
                }
                long min = Math.min(InsightCore.getInsightConfig().x0(), InsightCore.getInsightConfig().y0());
                if (w > 0 && SystemClock.elapsedRealtime() - w < min && min < InsightCore.getInsightConfig().V()) {
                    return false;
                }
            }
            this.a = false;
            Handler handler = new Handler();
            handler.postDelayed(new a(jobParameters), 50000);
            if (this.b != null) {
                this.b = null;
            }
            CT ct = new CT(getApplicationContext());
            this.b = ct;
            ct.a((OCTL) new b(handler, jobParameters));
            ThreadManager.getInstance().getCachedThreadPool().execute(new c());
            return true;
        }
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
