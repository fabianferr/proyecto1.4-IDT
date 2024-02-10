package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.a;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class x {
    private static final AtomicBoolean b = new AtomicBoolean();
    final m a;
    private final AtomicBoolean c = new AtomicBoolean();
    private final AtomicBoolean d = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicInteger e = new AtomicInteger();
    private Date f;
    private Date g;

    x(final m mVar) {
        this.a = mVar;
        final Application application = (Application) mVar.L();
        application.registerActivityLifecycleCallbacks(new a() {
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                x.this.e();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                x.this.e.set(i);
                if (i == 20) {
                    x.this.f();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (Utils.isCurrentProcessInForeground()) {
                        x.this.e();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    x.this.f();
                }
            }
        }, intentFilter);
        if (((Boolean) mVar.a(b.cq)).booleanValue() && b.compareAndSet(false, true)) {
            final Intent intent = new Intent(application, AppKilledService.class);
            application.startService(intent);
            mVar.aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    application.stopService(intent);
                    mVar.aj().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.d.compareAndSet(true, false)) {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.d.compareAndSet(false, true)) {
            g();
        }
    }

    private void g() {
        if (u.a()) {
            this.a.A().b("SessionTracker", "Application Paused");
        }
        this.a.aj().sendBroadcastSync(new Intent("com.applovin.application_paused"), (Map<String, Object>) null);
        if (!this.c.get()) {
            boolean booleanValue = ((Boolean) this.a.a(b.dm)).booleanValue();
            long millis = TimeUnit.MINUTES.toMillis(((Long) this.a.a(b.f0do)).longValue());
            if (this.f == null || System.currentTimeMillis() - this.f.getTime() >= millis) {
                ((EventServiceImpl) this.a.w()).trackEvent("paused");
                if (booleanValue) {
                    this.f = new Date();
                }
            }
            if (!booleanValue) {
                this.f = new Date();
            }
        }
    }

    private void h() {
        if (u.a()) {
            this.a.A().b("SessionTracker", "Application Resumed");
        }
        boolean booleanValue = ((Boolean) this.a.a(b.dm)).booleanValue();
        long longValue = ((Long) this.a.a(b.dn)).longValue();
        this.a.aj().sendBroadcastSync(new Intent("com.applovin.application_resumed"), (Map<String, Object>) null);
        if (!this.c.getAndSet(false)) {
            long millis = TimeUnit.MINUTES.toMillis(longValue);
            if (this.g == null || System.currentTimeMillis() - this.g.getTime() >= millis) {
                ((EventServiceImpl) this.a.w()).trackEvent("resumed");
                if (booleanValue) {
                    this.g = new Date();
                }
            }
            if (!booleanValue) {
                this.g = new Date();
            }
            this.a.T().a(f.m);
        }
    }

    public boolean a() {
        return this.d.get();
    }

    public int b() {
        return this.e.get();
    }

    public void c() {
        this.c.set(true);
    }

    public void d() {
        this.c.set(false);
    }
}
