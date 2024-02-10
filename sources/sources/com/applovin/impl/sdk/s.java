package com.applovin.impl.sdk;

import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.d.b;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class s {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public final AtomicBoolean b = new AtomicBoolean();
    /* access modifiers changed from: private */
    public long c;
    private final Object d = new Object();
    /* access modifiers changed from: private */
    public final AtomicBoolean e = new AtomicBoolean();
    /* access modifiers changed from: private */
    public long f;
    private Object g;

    s(m mVar) {
        this.a = mVar;
    }

    public void a(final Object obj) {
        if (!c.a(obj) && this.b.compareAndSet(false, true)) {
            this.g = obj;
            this.c = System.currentTimeMillis();
            if (u.a()) {
                u A = this.a.A();
                A.b("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.c);
            }
            this.a.aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final long longValue = ((Long) this.a.a(b.ch)).longValue();
            if (longValue >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (s.this.b.get() && System.currentTimeMillis() - s.this.c >= longValue) {
                            if (u.a()) {
                                s.this.a.A().b("FullScreenAdTracker", "Resetting \"display\" state...");
                            }
                            s.this.b(obj);
                        }
                    }
                }, longValue);
            }
        }
    }

    public void a(boolean z) {
        synchronized (this.d) {
            this.e.set(z);
            if (z) {
                this.f = System.currentTimeMillis();
                if (u.a()) {
                    u A = this.a.A();
                    A.b("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f);
                }
                final long longValue = ((Long) this.a.a(b.cg)).longValue();
                if (longValue >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            if (s.this.a() && System.currentTimeMillis() - s.this.f >= longValue) {
                                if (u.a()) {
                                    s.this.a.A().b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                }
                                s.this.e.set(false);
                            }
                        }
                    }, longValue);
                }
            } else {
                this.f = 0;
                if (u.a()) {
                    u A2 = this.a.A();
                    A2.b("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                }
            }
        }
    }

    public boolean a() {
        return this.e.get();
    }

    public void b(Object obj) {
        if (!c.a(obj) && this.b.compareAndSet(true, false)) {
            this.g = null;
            if (u.a()) {
                u A = this.a.A();
                A.b("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            this.a.aj().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public boolean b() {
        return this.b.get();
    }

    public Object c() {
        return this.g;
    }
}
