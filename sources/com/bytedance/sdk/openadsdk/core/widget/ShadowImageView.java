package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;

public class ShadowImageView extends PAGImageView {
    private Paint a;
    private RectF b;

    public ShadowImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setColor(Color.parseColor("#99333333"));
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(0.0f);
        this.b = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b.right != ((float) getMeasuredWidth()) || this.b.bottom != ((float) getMeasuredHeight())) {
            this.b.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.b.bottom / 2.0f, this.a);
        super.onDraw(canvas);
    }
}
