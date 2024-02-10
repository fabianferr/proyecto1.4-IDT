package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* compiled from: DynamicShadowDrawable */
public class c extends Drawable {
    private Paint a;
    private int b;
    private int c;
    private RectF d;

    public int getOpacity() {
        return -3;
    }

    public c(int i, int i2) {
        this.c = i;
        this.b = i2;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(0);
        this.a.setAntiAlias(true);
        this.a.setShadowLayer((float) i2, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.b;
        this.d = new RectF((float) (i + i5), (float) (i2 + i5), (float) (i3 - i5), (float) (i4 - i5));
    }

    public void draw(Canvas canvas) {
        RectF rectF = this.d;
        int i = this.c;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.a);
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
