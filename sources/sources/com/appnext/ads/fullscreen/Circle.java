package com.appnext.ads.fullscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.appnext.base.a;
import com.appnext.core.g;

public class Circle extends View {
    private Paint a;
    private RectF b;
    private float c;

    public Circle(Context context) {
        super(context);
        init(context);
    }

    public Circle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            canvas.drawArc(this.b, 180.0f, this.c, false, this.a);
        } catch (Throwable th) {
            a.a("Circle$onDraw", th);
        }
    }

    public float getAngle() {
        return this.c;
    }

    public void setAngle(float f) {
        this.c = f;
    }

    private void init(Context context) {
        try {
            float a2 = (float) g.a(context, 5.0f);
            Paint paint = new Paint();
            this.a = paint;
            paint.setAntiAlias(true);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(a2);
            this.a.setColor(-1);
            this.a.setShadowLayer(2.0f, 2.0f, 2.0f, Color.argb(128, 0, 0, 0));
            setLayerType(1, this.a);
            this.b = new RectF(a2, a2, ((float) g.a(context, 20.0f)) + a2, ((float) g.a(context, 20.0f)) + a2);
            this.c = 360.0f;
        } catch (Throwable th) {
            a.a("Circle$init", th);
        }
    }
}
