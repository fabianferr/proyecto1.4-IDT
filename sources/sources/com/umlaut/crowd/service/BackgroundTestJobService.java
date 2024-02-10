package com.umlaut.crowd.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.umlaut.crowd.internal.BT;
import com.umlaut.crowd.internal.OBTSL;
import com.umlaut.crowd.threads.ThreadManager;

public class BackgroundTestJobService extends JobService {
    private static final String a = "BackgroundTestJobService";
    private static final boolean b = false;
    public static final int c = 3;

    class a implements OBTSL {
        a() {
        }

        public void a() {
        }

        public void b() {
        }
    }

    class b implements Runnable {
        final /* synthetic */ BT a;
        final /* synthetic */ JobParameters b;

        b(BT bt, JobParameters jobParameters) {
            this.a = bt;
            this.b = jobParameters;
        }

        public void run() {
            this.a.c();
            BackgroundTestJobService.this.jobFinished(this.b, false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onStartJob(JobParameters jobParameters) {
        BT bt = new BT(getApplicationContext());
        bt.a((OBTSL) new a());
        ThreadManager.getInstance().getCachedThreadPool().execute(new b(bt, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
