package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EmptyView extends View implements x.a {
    private boolean a;
    private boolean b;
    /* access modifiers changed from: private */
    public a c;
    /* access modifiers changed from: private */
    public View d;
    private List<View> e;
    private List<View> f;
    private boolean g;
    private int h;
    private final Handler i = new x(l.b().getLooper(), this);
    private final AtomicBoolean j = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnGlobalLayoutListener k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public boolean m = false;
    private final Runnable n = new Runnable() {
        public void run() {
            if (!EmptyView.this.l) {
                if (EmptyView.this.c != null) {
                    EmptyView.this.c.a(EmptyView.this.d);
                }
                boolean unused = EmptyView.this.l = true;
            }
        }
    };

    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public EmptyView(Context context, View view) {
        super(o.a());
        this.d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.k = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!EmptyView.this.m) {
                    EmptyView.this.e();
                    EmptyView.this.d();
                }
            }
        };
    }

    private void a(final boolean z) {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        h.b().post(new Runnable() {
            public void run() {
                ViewTreeObserver viewTreeObserver;
                if (!(EmptyView.this.k == null || (viewTreeObserver = viewTreeObserver) == null)) {
                    try {
                        viewTreeObserver.removeOnGlobalLayoutListener(EmptyView.this.k);
                    } catch (Exception unused) {
                    }
                }
                if (z) {
                    ViewTreeObserver.OnGlobalLayoutListener unused2 = EmptyView.this.k = null;
                }
            }
        });
    }

    private void b() {
        a aVar;
        if (this.j.getAndSet(false) && (aVar = this.c) != null) {
            aVar.a();
        }
    }

    private void c() {
        a aVar;
        if (!this.j.getAndSet(true) && (aVar = this.c) != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.b && !this.a) {
            this.a = true;
            this.i.sendEmptyMessage(1);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.a) {
            this.i.removeCallbacksAndMessages((Object) null);
            this.a = false;
        }
    }

    private boolean f() {
        View view = this.d;
        if (view instanceof NativeExpressView) {
            return ((NativeExpressView) view).p();
        }
        return true;
    }

    public void a() {
        a(this.e, (c) null);
        a(this.f, (c) null);
    }

    public void a(Message message) {
        if (message.what == 1 && this.a) {
            if (!f() || !y.a(this.d, 20, this.h)) {
                this.i.sendEmptyMessageDelayed(1, 1000);
                return;
            }
            e();
            this.m = true;
            l.c().post(this.n);
            a(true);
        }
    }

    public void a(List<View> list, c cVar) {
        if (j.b(list)) {
            for (View next : list) {
                if (next != null) {
                    next.setOnClickListener(cVar);
                    next.setOnTouchListener(cVar);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g = false;
        b();
        if (this.k != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.k);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.g = true;
        c();
        a(false);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setAdType(int i2) {
        this.h = i2;
    }

    public void setCallback(a aVar) {
        this.c = aVar;
    }

    public void setNeedCheckingShow(boolean z) {
        this.b = z;
        if (!z && this.a) {
            e();
        } else if (z && !this.a) {
            d();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.e = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.f = list;
    }
}
