package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.component.utils.s;
import java.util.ArrayList;
import java.util.List;

public class WriggleGuideView extends View {
    private int a;
    private int b;
    private Bitmap c;
    private Bitmap d;
    private Paint e;
    private int f;
    private final List<Object> g;
    private boolean h;
    private boolean i;
    private a j;

    public interface a {
        void a();
    }

    public WriggleGuideView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 0;
        this.b = 0;
        this.f = 0;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        this.h = true;
        this.i = false;
        setLayerType(1, (Paint) null);
        this.e = new Paint();
        this.e = new Paint(1);
        arrayList.clear();
    }

    private Bitmap a(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), s.d(getContext(), "tt_wriggle_union"));
        if (decodeResource != null) {
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(0.0f, 0.0f, (float) i2, (float) i3), this.e);
        }
        return createBitmap;
    }

    private Bitmap b(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), s.d(getContext(), "tt_wriggle_union_white"));
        if (decodeResource != null) {
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(0.0f, 0.0f, (float) i2, (float) i3), paint);
        }
        return createBitmap;
    }

    private Bitmap c(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle((float) (i2 / 2), 10.0f, (float) this.f, paint);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            this.a = getWidth();
            int height = getHeight();
            this.b = height;
            this.c = a(this.a, height);
            this.d = b(this.a, this.b);
            this.h = false;
        }
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.e);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (Paint) null, 31);
        canvas.drawBitmap(this.d, 0.0f, 0.0f, this.e);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(c(this.a, this.b), 0.0f, 0.0f, this.e);
        this.e.setXfermode((Xfermode) null);
        canvas.restoreToCount(saveLayer);
        if (this.i) {
            this.f += 5;
            invalidate();
            if (this.f >= this.a) {
                a aVar = this.j;
                if (aVar != null) {
                    aVar.a();
                }
                this.i = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null) {
            this.j = null;
        }
    }
}
