package com.startapp.sdk.jobs;

import android.content.Context;
import android.os.Bundle;
import com.startapp.l7;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.jobs.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class f implements l7 {
    public final WeakReference<Context> a;
    public final Map<Integer, Future<?>> b = new HashMap();
    public final ScheduledExecutorService c = Executors.newScheduledThreadPool(1, ComponentLocator.b("scheduler"));

    /* compiled from: Sta */
    public class a extends a {
        public final /* synthetic */ JobRequest a;
        public final /* synthetic */ long b;

        public a(JobRequest jobRequest, long j) {
            this.a = jobRequest;
            this.b = j;
        }

        public void a(b bVar) {
            f fVar = f.this;
            int a2 = JobRequest.a(this.a.a);
            long j = this.b;
            synchronized (fVar) {
                fVar.b.put(Integer.valueOf(a2), fVar.c.scheduleAtFixedRate(bVar, j, j, TimeUnit.MILLISECONDS));
            }
        }
    }

    /* compiled from: Sta */
    public class b implements b.a {
        public b(f fVar, JobRequest jobRequest) {
        }

        public void a(b bVar, boolean z) {
        }
    }

    /* compiled from: Sta */
    public class c extends a {
        public final /* synthetic */ JobRequest a;
        public final /* synthetic */ long b;

        public c(JobRequest jobRequest, long j) {
            this.a = jobRequest;
            this.b = j;
        }

        public void a(b bVar) {
            f fVar = f.this;
            int a2 = JobRequest.a(this.a.a);
            long j = this.b;
            synchronized (fVar) {
                fVar.b.put(Integer.valueOf(a2), fVar.c.schedule(bVar, j, TimeUnit.MILLISECONDS));
            }
        }
    }

    /* compiled from: Sta */
    public class d implements b.a {
        public final /* synthetic */ JobRequest a;
        public final /* synthetic */ long b;

        public d(JobRequest jobRequest, long j) {
            this.a = jobRequest;
            this.b = j;
        }

        public void a(b bVar, boolean z) {
            if (z) {
                f fVar = f.this;
                int a2 = JobRequest.a(this.a.a);
                long j = this.b;
                synchronized (fVar) {
                    fVar.b.put(Integer.valueOf(a2), fVar.c.schedule(bVar, j, TimeUnit.MILLISECONDS));
                }
                return;
            }
            synchronized (this) {
                f.this.b.remove(Integer.valueOf(JobRequest.a(this.a.a)));
            }
        }
    }

    public f(Context context) {
        this.a = new WeakReference<>(context);
    }

    public boolean a(JobRequest jobRequest, long j) {
        Context context = (Context) this.a.get();
        if (context == null) {
            return false;
        }
        return new a(jobRequest, j).a(context, jobRequest.a, new b(this, jobRequest), (Bundle) null);
    }

    public boolean a(JobRequest jobRequest, Long l, Long l2) {
        Context context = (Context) this.a.get();
        if (context == null) {
            return false;
        }
        long longValue = l != null ? l.longValue() : 0;
        return new c(jobRequest, longValue).a(context, jobRequest.a, new d(jobRequest, longValue), (Bundle) null);
    }

    public synchronized boolean a(int i) {
        Future future = this.b.get(Integer.valueOf(i));
        if (future == null) {
            return false;
        }
        this.b.remove(Integer.valueOf(i));
        return future.cancel(true);
    }
}
