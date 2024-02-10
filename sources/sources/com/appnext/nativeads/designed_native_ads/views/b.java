package com.appnext.nativeads.designed_native_ads.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class b extends FrameLayout {
    /* access modifiers changed from: private */
    public a fW;
    private ViewTreeObserver.OnScrollChangedListener fn;

    public interface a {
        void f(int i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fn = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (b.this.fW != null) {
                    b.this.fW.f(b.this.getVisiblePercent());
                }
            }
        };
    }

    public b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.fn = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (b.this.fW != null) {
                    b.this.fW.f(b.this.getVisiblePercent());
                }
            }
        };
    }

    public void register(a aVar) {
        this.fW = aVar;
        if (aVar != null) {
            this.fW.f(getVisiblePercent());
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            try {
                a aVar = this.fW;
                if (aVar != null) {
                    aVar.f(getVisiblePercent());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            try {
                a aVar = this.fW;
                if (aVar != null) {
                    aVar.f(getVisiblePercent());
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("DesignedNativeAdViewContainerImpl$onVisibilityChanged", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a aVar = this.fW;
        if (aVar != null) {
            aVar.f(getVisiblePercent());
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        a aVar = this.fW;
        if (aVar != null) {
            aVar.f(getVisiblePercent());
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            try {
                a aVar = this.fW;
                if (aVar != null) {
                    aVar.f(getVisiblePercent());
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("DesignedNativeAdViewContainerImpl$setVisibility", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bringToFront();
        getViewTreeObserver().addOnScrollChangedListener(this.fn);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getViewTreeObserver().removeOnScrollChangedListener(this.fn);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdViewContainerImpl$onDetachedFromWindow", th);
        }
    }

    /* access modifiers changed from: private */
    public int getVisiblePercent() {
        try {
            if (!isViewPartiallyVisible(this)) {
                return 0;
            }
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            double width = (double) (rect.width() * rect.height());
            double width2 = (double) (getWidth() * getHeight());
            Double.isNaN(width);
            Double.isNaN(width2);
            return (int) ((width * 100.0d) / width2);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdViewContainerImpl$getVisiblePercent", th);
            return 0;
        }
    }

    private boolean isViewPartiallyVisible(View view) {
        try {
            if (getParent() == null || !view.isAttachedToWindow()) {
                return false;
            }
            Rect rect = new Rect();
            ((ViewGroup) getParent()).getHitRect(rect);
            return view.getGlobalVisibleRect(rect);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdViewContainerImpl$isViewPartiallyVisible", th);
            return false;
        }
    }
}
