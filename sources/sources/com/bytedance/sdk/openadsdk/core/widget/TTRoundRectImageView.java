package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;

public class TTRoundRectImageView extends PAGImageView {
    private final Paint a;
    private int b;
    private int c;
    private final Matrix d;
    private final RectF e;
    private BitmapShader f;

    public TTRoundRectImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 25;
        this.c = 25;
        this.e = new RectF();
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        this.d = new Matrix();
    }

    public void setXRound(int i) {
        this.b = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.c = i;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e.set(0.0f, 0.0f, (float) i, (float) i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap a2;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.f == null && (a2 = a(drawable)) != null) {
            this.f = new BitmapShader(a2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            float f2 = 1.0f;
            if (!(a2.getWidth() == getWidth() && a2.getHeight() == getHeight())) {
                f2 = Math.max((((float) getWidth()) * 1.0f) / ((float) a2.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a2.getHeight()));
            }
            this.d.setScale(f2, f2);
            this.f.setLocalMatrix(this.d);
        }
        BitmapShader bitmapShader = this.f;
        if (bitmapShader != null) {
            this.a.setShader(bitmapShader);
            canvas.drawRoundRect(this.e, (float) this.b, (float) this.c, this.a);
            return;
        }
        super.onDraw(canvas);
    }

    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        this.f = null;
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }
}
