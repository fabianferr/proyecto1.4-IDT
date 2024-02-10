package com.umlaut.crowd.service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CT;
import com.umlaut.crowd.internal.OCTL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectivityWorker extends Worker {
    private static final boolean b = false;
    private static final String c = "ConnectivityWorker";
    public static final String d = "ConnectivityWorkerPeriodic";
    public static final String e = "ConnectivityWorkerOnce";
    private static final int f = 50000;
    /* access modifiers changed from: private */
    public static final AtomicBoolean g = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final CountDownLatch a = new CountDownLatch(1);

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (ConnectivityWorker.g.get()) {
                ConnectivityWorker.this.a.countDown();
            }
        }
    }

    class b implements OCTL {
        final /* synthetic */ Handler a;

        b(Handler handler) {
            this.a = handler;
        }

        public void a() {
            this.a.removeCallbacksAndMessages((Object) null);
            if (ConnectivityWorker.g.get()) {
                ConnectivityWorker.this.a.countDown();
            }
        }

        public void onConnectivityTestStart() {
        }
    }

    public ConnectivityWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        if (!InsightCore.isInitialized()) {
            Log.i(c, "doWork: InsightCore not initialized");
            return ListenableWorker.Result.retry();
        }
        AtomicBoolean atomicBoolean = g;
        if (!atomicBoolean.compareAndSet(false, true)) {
            return ListenableWorker.Result.failure();
        }
        if (InsightCore.getInsightConfig().w0()) {
            IS insightSettings = InsightCore.getInsightSettings();
            if (insightSettings == null) {
                atomicBoolean.set(false);
                return ListenableWorker.Result.failure();
            }
            long w = insightSettings.w();
            if (w > SystemClock.elapsedRealtime()) {
                insightSettings.f(0);
                w = 0;
            }
            long min = Math.min(InsightCore.getInsightConfig().x0(), InsightCore.getInsightConfig().y0());
            if (w > 0 && SystemClock.elapsedRealtime() - w < min && min < InsightCore.getInsightConfig().V()) {
                atomicBoolean.set(false);
                return ListenableWorker.Result.failure();
            }
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new a(), 50000);
        CT ct = new CT(getApplicationContext());
        ct.a((OCTL) new b(handler));
        com.umlaut.crowd.internal.a aVar = com.umlaut.crowd.internal.a.Periodic;
        if (getTags().contains(e)) {
            aVar = com.umlaut.crowd.internal.a.PeriodicForeground;
        }
        ct.b(aVar);
        try {
            this.a.await();
        } catch (InterruptedException e2) {
            Log.d(c, e2.toString());
        }
        g.set(false);
        return ListenableWorker.Result.success();
    }
}
