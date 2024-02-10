package com.applovin.impl.mediation.b.a;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class c {
    /* access modifiers changed from: private */
    public final WeakHashMap<View, Integer> a = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public final Object b = new Object();
    private final Handler c = new Handler();
    /* access modifiers changed from: private */
    public boolean d = false;
    private final WeakReference<View> e;
    private final ViewTreeObserver.OnPreDrawListener f;
    /* access modifiers changed from: private */
    public a g;

    public interface a {
        void a(int i, int i2);
    }

    public c(View view) {
        this.e = new WeakReference<>(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            AnonymousClass1 r0 = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    c.this.b();
                    return true;
                }
            };
            this.f = r0;
            viewTreeObserver.addOnPreDrawListener(r0);
            return;
        }
        this.f = null;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!this.d) {
            this.d = true;
            this.c.postDelayed(new Runnable() {
                public void run() {
                    synchronized (c.this.b) {
                        boolean unused = c.this.d = false;
                        int i = -1;
                        int i2 = -1;
                        for (Map.Entry entry : c.this.a.entrySet()) {
                            if (c.this.b((View) entry.getKey())) {
                                Integer num = (Integer) entry.getValue();
                                if (i == -1 && i2 == -1) {
                                    i = num.intValue();
                                    i2 = num.intValue();
                                } else {
                                    i = Math.min(i, ((Integer) entry.getValue()).intValue());
                                    i2 = Math.max(i2, ((Integer) entry.getValue()).intValue());
                                }
                            }
                        }
                        if (c.this.g != null) {
                            c.this.g.a(i, i2);
                        }
                    }
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    public boolean b(View view) {
        return (view == null || view.getVisibility() != 0 || view.getParent() == null) ? false : true;
    }

    public void a() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.g = null;
        View view = (View) this.e.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onPreDrawListener = this.f) != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            this.e.clear();
        }
    }

    public void a(View view) {
        synchronized (this.b) {
            this.a.remove(view);
        }
    }

    public void a(View view, int i) {
        synchronized (this.b) {
            this.a.put(view, Integer.valueOf(i));
            b();
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }
}
