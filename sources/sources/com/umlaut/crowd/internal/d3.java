package com.umlaut.crowd.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class d3 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final String g = "d3";
    private static final boolean h = false;
    private Application a;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> b;
    /* access modifiers changed from: private */
    public AtomicInteger c;
    /* access modifiers changed from: private */
    public int d = 0;
    /* access modifiers changed from: private */
    public boolean e = false;
    private final Runnable f = new a();

    class a implements Runnable {
        a() {
        }

        public void run() {
            d3.this.c();
            if (d3.this.d == 0 && !d3.this.e) {
                d3.this.b.cancel(false);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (d3.this.c.get() == 1) {
                InsightCore.getRadioController().r();
                if (InsightCore.getConnectivityTestEnabled() && InsightCore.getInsightConfig().w0()) {
                    d3.this.c();
                    d3.this.f();
                }
                if (InsightCore.getCoverageMapperServiceEnabled() && InsightCore.getInsightConfig().z0()) {
                    InsightCore.getNirManager().e();
                }
            }
        }
    }

    public d3(Context context) {
        this.a = (Application) context.getApplicationContext();
        this.c = new AtomicInteger(-1);
    }

    private void h() {
        ScheduledFuture<?> scheduledFuture = this.b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.b = null;
        }
    }

    public void g() {
        this.a.unregisterActivityLifecycleCallbacks(this);
        this.a.unregisterComponentCallbacks(this);
        this.c.set(-1);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity.isTaskRoot() && this.d < 0) {
            this.d = 0;
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        int i = this.d + 1;
        this.d = i;
        if (i == 1 && !this.e) {
            a();
        }
    }

    public void onActivityStopped(Activity activity) {
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.e = isChangingConfigurations;
        int i = this.d - 1;
        this.d = i;
        if (i == 0 && !isChangingConfigurations) {
            b();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
    }

    private void a() {
        this.c.set(1);
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new b());
    }

    private void b() {
        this.c.set(0);
        InsightCore.getNirManager().j();
        h();
    }

    /* access modifiers changed from: private */
    public void c() {
        new f1(this.a).e();
    }

    /* access modifiers changed from: private */
    public void f() {
        h();
        long y0 = InsightCore.getInsightConfig().y0();
        if (y0 > 0) {
            this.b = ThreadManager.getInstance().getSingleThreadScheduledExecutor().scheduleWithFixedDelay(this.f, y0, y0, TimeUnit.MILLISECONDS);
        }
    }

    public int d() {
        return this.c.get();
    }

    public void e() {
        this.c.set(0);
        this.a.registerActivityLifecycleCallbacks(this);
        this.a.registerComponentCallbacks(this);
    }
}
