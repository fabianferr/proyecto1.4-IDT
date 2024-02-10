package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlowLightView extends View {
    Rect a;
    Rect b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int[] i;
    private Bitmap j;
    private Paint k;
    private Xfermode l;
    private PorterDuff.Mode m = PorterDuff.Mode.DST_IN;
    private LinearGradient n;
    private final List<a> o = new ArrayList();

    public FlowLightView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.c = s.d(getContext(), "tt_splash_unlock_image_arrow");
        this.d = Color.parseColor("#00ffffff");
        this.e = Color.parseColor("#ffffffff");
        int parseColor = Color.parseColor("#00ffffff");
        this.f = parseColor;
        this.g = 10;
        this.h = 40;
        this.i = new int[]{this.d, this.e, parseColor};
        setLayerType(1, (Paint) null);
        this.k = new Paint(1);
        this.j = BitmapFactory.decodeResource(getResources(), this.c);
        this.l = new PorterDuffXfermode(this.m);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.j, this.a, this.b, this.k);
        canvas.save();
        Iterator<a> it = this.o.iterator();
        while (it.hasNext()) {
            a next = it.next();
            this.n = new LinearGradient((float) next.b, 0.0f, (float) (next.b + this.h), (float) this.g, this.i, (float[]) null, Shader.TileMode.CLAMP);
            this.k.setColor(-1);
            this.k.setShader(this.n);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.k);
            this.k.setShader((Shader) null);
            next.a();
            if (next.b > getWidth()) {
                it.remove();
            }
        }
        this.k.setXfermode(this.l);
        canvas.drawBitmap(this.j, this.a, this.b, this.k);
        this.k.setXfermode((Xfermode) null);
        canvas.restore();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.j != null) {
            this.a = new Rect(0, 0, this.j.getWidth(), this.j.getHeight());
            this.b = new Rect(0, 0, getWidth(), getHeight());
        }
    }

    public void a(int i2) {
        this.o.add(new a(i2));
        postInvalidate();
    }

    public static class a {
        private final int a;
        /* access modifiers changed from: private */
        public int b = 0;

        public a(int i) {
            this.a = i;
        }

        public void a() {
            this.b += this.a;
        }
    }
}
