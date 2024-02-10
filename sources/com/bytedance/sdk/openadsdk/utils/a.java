package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.g.f;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ActivityLifecycleListener */
public class a implements Application.ActivityLifecycleCallbacks {
    public static boolean a = false;
    public static long b;
    public static long c;
    private final AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final C0074a e = new C0074a();
    private final c f = new c();
    private final b g = new b();
    private int h = 0;
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.a>> i = new CopyOnWriteArrayList<>();
    private HandlerThread j = null;
    private Handler k = null;
    private volatile WeakReference<Activity> l;
    private StringBuilder m = new StringBuilder();
    private boolean n;

    public a() {
        d();
    }

    private void a(Runnable runnable) {
        if (!this.j.isAlive()) {
            d();
        }
        this.k.post(runnable);
    }

    private void d() {
        HandlerThread handlerThread = new HandlerThread("lifecycle", 10);
        this.j = handlerThread;
        handlerThread.start();
        this.k = new Handler(this.j.getLooper());
    }

    /* access modifiers changed from: private */
    public void e() {
        com.bytedance.sdk.openadsdk.b.a.a.a();
    }

    public void a(com.bytedance.sdk.component.adexpress.a aVar) {
        this.i.add(new WeakReference(aVar));
    }

    public boolean a() {
        return this.d.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r0 = (r0 = (android.app.Activity) r1.l.get()).getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(boolean r2) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.app.Activity> r0 = r1.l
            if (r0 != 0) goto L_0x0005
            return r2
        L_0x0005:
            java.lang.ref.WeakReference<android.app.Activity> r0 = r1.l
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 != 0) goto L_0x0010
            return r2
        L_0x0010:
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto L_0x0017
            return r2
        L_0x0017:
            android.view.View r2 = r0.getDecorView()
            boolean r2 = r2.hasWindowFocus()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.a.a(boolean):boolean");
    }

    public void b() {
        this.n = true;
        this.m = new StringBuilder();
    }

    public boolean b(com.bytedance.sdk.component.adexpress.a aVar) {
        return this.i.remove(new WeakReference(aVar));
    }

    public String c() {
        this.n = false;
        String sb = this.m.toString();
        this.m = new StringBuilder();
        return sb;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.n) {
            StringBuilder sb = this.m;
            sb.append("onCreated/");
            sb.append(activity.getLocalClassName());
            sb.append("/");
            sb.append(System.currentTimeMillis());
            sb.append(";");
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.i != null && this.i.size() > 0) {
            Iterator<WeakReference<com.bytedance.sdk.component.adexpress.a>> it = this.i.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (!(next == null || next.get() == null)) {
                    try {
                        ((com.bytedance.sdk.component.adexpress.a) next.get()).a(activity);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (this.l != null && this.l.get() == activity) {
            this.l = null;
        }
        if (this.n) {
            StringBuilder sb = this.m;
            sb.append("onDestroyed/");
            sb.append(activity.getLocalClassName());
            sb.append("/");
            sb.append(System.currentTimeMillis());
            sb.append(";");
        }
    }

    public void onActivityPaused(Activity activity) {
        int i2 = this.h - 1;
        this.h = i2;
        if (i2 < 0) {
            this.h = 0;
        }
        if (ApmHelper.isIsInit()) {
            a((Runnable) this.g);
        }
        if (this.n) {
            StringBuilder sb = this.m;
            sb.append("onPaused/");
            sb.append(activity.getLocalClassName());
            sb.append("/");
            sb.append(System.currentTimeMillis());
            sb.append(";");
        }
    }

    public void onActivityResumed(Activity activity) {
        a((Runnable) this.f);
        if (!a) {
            b = System.currentTimeMillis();
            a = true;
        }
        this.l = new WeakReference<>(activity);
        if (this.n) {
            StringBuilder sb = this.m;
            sb.append("onResumed/");
            sb.append(activity.getLocalClassName());
            sb.append("/");
            sb.append(System.currentTimeMillis());
            sb.append(";");
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.h++;
        this.d.set(false);
        if (this.n) {
            StringBuilder sb = this.m;
            sb.append("onStarted/");
            sb.append(activity.getLocalClassName());
            sb.append("/");
            sb.append(System.currentTimeMillis());
            sb.append(";");
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.h <= 0) {
            this.d.set(true);
        }
        if (a()) {
            a = false;
            l.b.set(false);
            c = System.currentTimeMillis();
        }
        a((Runnable) new d(b, c, a()));
        if (this.n) {
            StringBuilder sb = this.m;
            sb.append("onStopped/");
            sb.append(activity.getLocalClassName());
            sb.append("/");
            sb.append(System.currentTimeMillis());
            sb.append(";");
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.utils.a$a  reason: collision with other inner class name */
    /* compiled from: ActivityLifecycleListener */
    static class C0074a implements Runnable {
        C0074a() {
        }

        public void run() {
            f.d().execute(new h("reportPvFromBackGround") {
                public void run() {
                    ApmHelper.reportPvFromBackGround();
                }
            });
        }
    }

    /* compiled from: ActivityLifecycleListener */
    class c implements Runnable {
        c() {
        }

        public void run() {
            l.b().removeMessages(1001);
            if (o.a() != null) {
                com.bytedance.sdk.openadsdk.core.f.a.b();
            }
        }
    }

    /* compiled from: ActivityLifecycleListener */
    class b implements Runnable {
        b() {
        }

        public void run() {
            if (ApmHelper.isIsInit()) {
                Handler b = l.b();
                Message obtain = Message.obtain(b, a.this.e);
                obtain.what = 1001;
                b.sendMessageDelayed(obtain, 30000);
            }
        }
    }

    /* compiled from: ActivityLifecycleListener */
    public class d implements Runnable {
        private long b;
        private long c;
        private boolean d;

        public d(long j, long j2, boolean z) {
            this.b = j;
            this.c = j2;
            this.d = z;
        }

        public void run() {
            if (this.d) {
                com.bytedance.sdk.openadsdk.j.b.a().a(this.b / 1000, this.c / 1000);
            }
            a.this.e();
        }
    }
}
