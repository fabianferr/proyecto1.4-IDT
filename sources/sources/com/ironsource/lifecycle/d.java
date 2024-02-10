package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.lifecycle.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d implements Application.ActivityLifecycleCallbacks {
    static AtomicBoolean a = new AtomicBoolean(false);
    private static d i = new d();
    int b = 0;
    int c = 0;
    boolean d = true;
    boolean e = true;
    int f = e.a;
    Runnable g = new Runnable() {
        public final void run() {
            d.a(d.this);
            d.this.c();
        }
    };
    private String h = "IronsourceLifecycleManager";
    /* access modifiers changed from: private */
    public List<c> j = new CopyOnWriteArrayList();
    private b.a k = new b.a() {
        public final void a(Activity activity) {
            d dVar = d.this;
            dVar.b++;
            if (dVar.b == 1 && dVar.e) {
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
                    public final void run() {
                        for (c a2 : d.this.j) {
                            a2.a();
                        }
                    }
                });
                dVar.e = false;
                dVar.f = e.b;
            }
        }

        public final void b(Activity activity) {
            d dVar = d.this;
            dVar.c++;
            if (dVar.c != 1) {
                return;
            }
            if (dVar.d) {
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
                    public final void run() {
                        Iterator it = d.this.j.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                });
                dVar.d = false;
                dVar.f = e.c;
                return;
            }
            IronSourceThreadManager.INSTANCE.removeUiThreadTask(dVar.g);
        }
    };

    public static d a() {
        return i;
    }

    static /* synthetic */ void a(d dVar) {
        if (dVar.c == 0) {
            dVar.d = true;
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
                public final void run() {
                    Iterator it = d.this.j.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
            dVar.f = e.d;
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.b == 0 && this.d) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new Runnable() {
                public final void run() {
                    for (c b : d.this.j) {
                        b.b();
                    }
                }
            });
            this.e = true;
            this.f = e.e;
        }
    }

    public final void a(c cVar) {
        if (IronsourceLifecycleProvider.a() && cVar != null && !this.j.contains(cVar)) {
            this.j.add(cVar);
        }
    }

    public final void b(c cVar) {
        if (this.j.contains(cVar)) {
            this.j.remove(cVar);
        }
    }

    public final boolean b() {
        return this.f == e.e;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        b.b(activity);
        b a2 = b.a(activity);
        if (a2 != null) {
            a2.a = this.k;
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 == 0) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(this.g, 700);
        }
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.b--;
        c();
    }
}
