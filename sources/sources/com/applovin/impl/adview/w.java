package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.i;

public final class w extends i {
    private static final Paint c = new Paint(1);
    private static final Paint d = new Paint(1);
    private static final Paint e = new Paint(1);

    public w(Context context) {
        super(context);
        c.setColor(-1);
        d.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint = e;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.a * 10.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleOffset() {
        return this.a * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.a * 3.0f;
    }

    public i.a getStyle() {
        return i.a.WHITE_ON_BLACK;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = e;
        paint.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        Paint paint2 = paint;
        canvas2.drawLine(f, crossOffset, f2, size, paint2);
        canvas2.drawLine(f, size, f2, crossOffset, paint2);
    }
}
