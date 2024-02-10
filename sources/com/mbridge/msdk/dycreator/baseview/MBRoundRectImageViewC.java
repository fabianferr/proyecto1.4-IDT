package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.mbridge.msdk.foundation.tools.aa;

public class MBRoundRectImageViewC extends MBImageView {
    private Paint a = new Paint();

    public MBRoundRectImageViewC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                super.onDraw(canvas);
                return;
            }
            Bitmap a2 = a(((BitmapDrawable) drawable).getBitmap());
            if (a2 != null) {
                if (!a2.isRecycled()) {
                    Bitmap a3 = a(a2, 30);
                    if (a3 != null) {
                        if (!a3.isRecycled()) {
                            Rect rect = new Rect(0, 0, a3.getWidth(), a3.getHeight());
                            this.a.reset();
                            canvas.drawBitmap(a3, rect, rect, this.a);
                            return;
                        }
                    }
                    super.onDraw(canvas);
                    return;
                }
            }
            super.onDraw(canvas);
        } catch (Exception e) {
            aa.d("MBRoundRectImageViewC", e.getMessage());
        }
    }

    private Bitmap a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                int width = getWidth();
                int height = getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(((float) width) / ((float) bitmap.getWidth()), ((float) height) / ((float) bitmap.getHeight()));
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e) {
                aa.d("MBRoundRectImageViewC", e.getMessage());
            }
        }
        return bitmap;
    }

    private Bitmap a(Bitmap bitmap, int i) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setShader(bitmapShader);
                float f = (float) i;
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), f, f, paint);
                return createBitmap;
            } catch (Exception e) {
                aa.d("MBRoundRectImageViewC", e.getMessage());
            }
        }
        return bitmap;
    }
}
