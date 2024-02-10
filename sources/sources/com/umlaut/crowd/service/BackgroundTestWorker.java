package com.umlaut.crowd.service;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.umlaut.crowd.internal.BT;
import com.umlaut.crowd.internal.OBTSL;

public class BackgroundTestWorker extends Worker {
    private static final boolean a = false;
    private static final String b = "BackgroundTestWorker";
    public static final String c = "BackgroundTestWorkerPeriodic";
    public static final String d = "BackgroundTestWorkerOnce";

    class a implements OBTSL {
        a() {
        }

        public void a() {
        }

        public void b() {
        }
    }

    public BackgroundTestWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        BT bt = new BT(getApplicationContext());
        bt.a((OBTSL) new a());
        bt.c();
        return ListenableWorker.Result.success();
    }
}
