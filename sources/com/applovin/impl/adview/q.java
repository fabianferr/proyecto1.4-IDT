package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.i;

public final class q extends i {
    private static final Paint c = new Paint(1);
    private static final Paint d = new Paint(1);

    public q(Context context) {
        super(context);
        c.setARGB(80, 0, 0, 0);
        Paint paint = d;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(int i) {
        setViewScale(((float) i) / 30.0f);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.a * 8.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.a * 2.0f;
    }

    public i.a getStyle() {
        return i.a.WHITE_ON_TRANSPARENT;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, c);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = d;
        paint.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        Paint paint2 = paint;
        canvas2.drawLine(f, crossOffset, f2, size, paint2);
        canvas2.drawLine(f, size, f2, crossOffset, paint2);
    }
}
