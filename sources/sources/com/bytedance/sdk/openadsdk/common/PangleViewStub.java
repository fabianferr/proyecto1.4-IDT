package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

public class PangleViewStub extends View {
    private final a a;
    private View b;

    public interface a {
        View a(Context context);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public PangleViewStub(Context context, a aVar) {
        super(context);
        this.a = aVar;
        a();
    }

    private void a() {
        setVisibility(8);
        setWillNotDraw(true);
    }

    public void setVisibility(int i) {
        View view = this.b;
        if (view != null) {
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            b();
        }
    }

    private View b() {
        a aVar;
        if (this.b == null && (aVar = this.a) != null) {
            this.b = aVar.a(getContext());
            a(this.b, (ViewGroup) getParent());
        }
        return this.b;
    }

    private void a(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }
}
