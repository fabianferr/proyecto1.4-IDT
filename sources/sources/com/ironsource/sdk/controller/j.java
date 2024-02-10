package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.cast.MediaTrack;
import com.ironsource.environment.h;
import com.ironsource.sdk.controller.A;
import com.ironsource.sdk.i.a;
import com.ironsource.sdk.j.f;

public final class j extends FrameLayout implements f {
    Context a;
    A b;

    public j(Context context) {
        super(context);
        this.a = context;
        setClickable(true);
    }

    static /* synthetic */ ViewGroup a(j jVar) {
        Activity activity = (Activity) jVar.a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int identifier;
        try {
            Context context = this.a;
            if (context == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
                return 0;
            }
            return this.a.getResources().getDimensionPixelSize(identifier);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        Activity activity = (Activity) this.a;
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (h.o(activity) != 1) {
                if (rect.right - rect2.right > 0) {
                    return rect.right - rect2.right;
                }
                return 0;
            } else if (rect.bottom - rect2.bottom > 0) {
                return rect.bottom - rect2.bottom;
            } else {
                return 0;
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.j();
        this.b.a(true, MediaTrack.ROLE_MAIN);
    }

    public final boolean onBackButtonPressed() {
        new a();
        return a.a((Activity) this.a);
    }

    public final void onCloseRequested() {
        ((Activity) this.a).runOnUiThread(new Runnable() {
            public final void run() {
                ViewGroup a2 = j.a(j.this);
                if (a2 != null) {
                    a2.removeView(j.this);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.i();
        this.b.a(false, MediaTrack.ROLE_MAIN);
        A a2 = this.b;
        if (a2 != null) {
            a2.j = A.g.Gone;
            this.b.l = null;
            this.b.v = null;
        }
        removeAllViews();
    }

    public final void onOrientationChanged(String str, int i) {
    }
}
