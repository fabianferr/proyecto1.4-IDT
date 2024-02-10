package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.webkit.WebView;

public class TTCornersWebView extends WebView {
    private int a;
    private int b;
    private int c;
    private int d;
    private final float[] e;

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a = getMeasuredWidth();
        this.b = getMeasuredHeight();
    }

    public void onDraw(Canvas canvas) {
        this.c = getScrollX();
        this.d = getScrollY();
        Path path = new Path();
        int i = this.d;
        path.addRoundRect(new RectF(0.0f, (float) i, (float) (this.c + this.a), (float) (i + this.b)), this.e, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
