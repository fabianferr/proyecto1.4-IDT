package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class z {
    /* access modifiers changed from: private */
    public final u a;
    private final Object b = new Object();
    private final Rect c = new Rect();
    private final Handler d;
    private final Runnable e;
    private final ViewTreeObserver.OnPreDrawListener f;
    /* access modifiers changed from: private */
    public final WeakReference<View> g;
    private final long h;
    private WeakReference<ViewTreeObserver> i = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<View> j = new WeakReference<>((Object) null);
    private int k;
    private float l;
    private float m;
    private long n;
    private long o = Long.MIN_VALUE;

    public interface a {
        void onLogVisibilityImpression();
    }

    public z(final View view, m mVar, a aVar) {
        this.a = mVar.A();
        this.h = ((Long) mVar.a(b.bU)).longValue();
        this.d = new Handler(Looper.getMainLooper());
        this.g = new WeakReference<>(view);
        final WeakReference weakReference = new WeakReference(aVar);
        this.e = new Runnable() {
            public void run() {
                View view = (View) z.this.g.get();
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                View view2 = (View) z.this.j.get();
                if (viewGroup != null && view2 != null) {
                    if (z.this.b(viewGroup, view2)) {
                        if (u.a()) {
                            z.this.a.b("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
                        }
                        z.this.a();
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.onLogVisibilityImpression();
                            return;
                        }
                        return;
                    }
                    z.this.b();
                }
            }
        };
        this.f = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                z.this.b();
                z.this.b(view);
                return true;
            }
        };
    }

    private void a(View view) {
        View rootView = Utils.getRootView((View) this.g.get());
        if (rootView == null) {
            rootView = Utils.getRootView(view);
        }
        if (rootView != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                this.i = new WeakReference<>(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(this.f);
            } else if (u.a()) {
                this.a.d("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            }
        } else if (u.a()) {
            this.a.b("VisibilityTracker", "Unable to set view tree observer due to no root view.");
        }
    }

    private boolean a(View view, View view2) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.c)) {
            return false;
        }
        long pxToDp = (long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.c.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.c.height()));
        if (pxToDp < ((long) this.k)) {
            return false;
        }
        if ((((float) pxToDp) / ((float) ((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getWidth()) * AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getHeight()))))) * 100.0f < this.l) {
            return false;
        }
        return (((float) ((long) (this.c.width() * this.c.height()))) / ((float) ((long) (view2.getWidth() * view2.getHeight())))) * 100.0f >= this.m;
    }

    /* access modifiers changed from: private */
    public void b() {
        this.d.postDelayed(this.e, this.h);
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f);
        } else if (view != null) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnPreDrawListener(this.f);
            }
        }
        this.i.clear();
    }

    /* access modifiers changed from: private */
    public boolean b(View view, View view2) {
        if (!a(view, view2)) {
            return false;
        }
        if (this.o == Long.MIN_VALUE) {
            this.o = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.o >= this.n;
    }

    public void a() {
        synchronized (this.b) {
            this.d.removeMessages(0);
            b((View) this.g.get());
            this.o = Long.MIN_VALUE;
            this.j.clear();
        }
    }

    public void a(e eVar) {
        WeakReference<View> weakReference;
        synchronized (this.b) {
            if (u.a()) {
                this.a.b("VisibilityTracker", "Tracking Visibility...");
            }
            a();
            if (eVar instanceof com.applovin.impl.mediation.a.b) {
                weakReference = new WeakReference<>(((com.applovin.impl.mediation.a.b) eVar).w());
            } else if (eVar instanceof d) {
                weakReference = new WeakReference<>(((d) eVar).u());
            } else {
                return;
            }
            this.j = weakReference;
            this.k = eVar.F();
            this.l = eVar.G();
            this.m = eVar.H();
            this.n = eVar.J();
            a((View) this.j.get());
        }
    }
}
