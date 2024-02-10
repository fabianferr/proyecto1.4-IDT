package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.f;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.i;
import com.bytedance.sdk.openadsdk.utils.ad;

/* compiled from: ViewGestureDetector */
public class o extends GestureDetector {
    private final a a;
    private final f b;

    public o(Context context) {
        this(context, new a());
    }

    public o(Context context, a aVar) {
        super(context, aVar);
        this.a = aVar;
        this.b = new f();
        setIsLongpressEnabled(false);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.a.a();
    }

    public boolean b() {
        return this.a.b();
    }

    public i a(Context context, View view, View view2) {
        if (this.b == null) {
            return new i.a().a();
        }
        return new i.a().f(this.b.a).e(this.b.b).d(this.b.c).c(this.b.d).b(this.b.e).a(this.b.f).b(ad.a(view)).a(ad.a(view2)).c(ad.c(view)).d(ad.c(view2)).d(this.b.g).e(this.b.h).f(this.b.i).a(this.b.l).b(h.b().a() ? 1 : 2).a("vessel").a(ad.e(context)).c(ad.g(context)).b(ad.f(context)).a();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    /* compiled from: ViewGestureDetector */
    static class a extends GestureDetector.SimpleOnGestureListener {
        boolean a = false;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a = false;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.a;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }
}
