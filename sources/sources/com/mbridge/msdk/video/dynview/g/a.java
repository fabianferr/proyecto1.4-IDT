package com.mbridge.msdk.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* compiled from: BackgroundDrawable */
public final class a extends ShapeDrawable {
    private int a;
    private float b;
    private float c;
    private int d;
    private int e;
    private Bitmap f;
    private Bitmap g;
    private boolean h;
    private Paint i;
    private Matrix j;

    /* compiled from: BackgroundDrawable */
    public interface b {
        b a(Bitmap bitmap);

        b a(boolean z);

        b b(float f);

        b b(Bitmap bitmap);
    }

    public final int getOpacity() {
        return -3;
    }

    private a(C0156a aVar) {
        super(aVar.a);
        this.h = false;
        this.f = aVar.b;
        this.g = aVar.c;
        this.h = aVar.d;
        this.a = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.b = aVar.h;
        this.c = aVar.i;
        Paint paint = new Paint();
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.i.setAntiAlias(true);
        this.j = new Matrix();
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.a == 1) {
            float f2 = this.c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (((float) this.d) + f2) - ((float) this.e));
            path.lineTo(this.b, (f2 - ((float) this.d)) - ((float) this.e));
            path.lineTo(this.b, 0.0f);
            if (this.h) {
                try {
                    a(canvas, path);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, ((float) this.d) + f2 + ((float) this.e));
            path2.lineTo(0.0f, this.c);
            path2.lineTo(this.b, this.c);
            path2.lineTo(this.b, (f2 - ((float) this.d)) + ((float) this.e));
            if (this.h) {
                try {
                    a(canvas, path2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } else {
                Bitmap bitmap2 = this.g;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    try {
                        a(canvas, path2, this.g);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        } else {
            float f3 = this.b / 2.0f;
            Path path3 = new Path();
            path3.moveTo(0.0f, 0.0f);
            path3.lineTo(0.0f, this.c);
            path3.lineTo((f3 - ((float) this.d)) - ((float) this.e), this.c);
            path3.lineTo((((float) this.d) + f3) - ((float) this.e), 0.0f);
            if (this.h) {
                try {
                    a(canvas, path3);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } else {
                Bitmap bitmap3 = this.f;
                if (bitmap3 != null && !bitmap3.isRecycled()) {
                    try {
                        a(canvas, path3, this.f);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
            }
            Path path4 = new Path();
            path4.moveTo(((float) this.d) + f3 + ((float) this.e), 0.0f);
            path4.lineTo(this.b, 0.0f);
            path4.lineTo(this.b, this.c);
            path4.lineTo((f3 - ((float) this.d)) + ((float) this.e), this.c);
            if (this.h) {
                try {
                    a(canvas, path4);
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            } else {
                Bitmap bitmap4 = this.g;
                if (bitmap4 != null && !bitmap4.isRecycled()) {
                    try {
                        a(canvas, path4, this.g);
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
            }
        }
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas != null && path != null && bitmap != null && !bitmap.isRecycled()) {
            if (!(bitmap.getWidth() == 0 || bitmap.getHeight() == 0)) {
                float max = Math.max(this.b / ((float) bitmap.getWidth()), this.c / ((float) bitmap.getHeight()));
                if (this.j == null) {
                    this.j = new Matrix();
                }
                this.j.reset();
                this.j.preScale(max, max);
            }
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            bitmapShader.setLocalMatrix(this.j);
            this.i.setShader(bitmapShader);
            canvas.drawPath(path, this.i);
        }
    }

    private void a(Canvas canvas, Path path) {
        this.i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.i);
    }

    public static C0156a a() {
        return new C0156a();
    }

    /* renamed from: com.mbridge.msdk.video.dynview.g.a$a  reason: collision with other inner class name */
    /* compiled from: BackgroundDrawable */
    public static class C0156a implements b {
        /* access modifiers changed from: private */
        public RectShape a;
        /* access modifiers changed from: private */
        public Bitmap b;
        /* access modifiers changed from: private */
        public Bitmap c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public int e;
        /* access modifiers changed from: private */
        public int f;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */
        public float h;
        /* access modifiers changed from: private */
        public float i;

        private C0156a() {
            this.f = 100;
            this.g = 10;
            this.a = new RectShape();
        }

        public final b a(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public final b b(Bitmap bitmap) {
            this.c = bitmap;
            return this;
        }

        public final b a(boolean z) {
            this.d = z;
            return this;
        }

        public final b a(int i2) {
            this.e = i2;
            return this;
        }

        public final b a(float f2) {
            this.h = f2;
            return this;
        }

        public final b b(float f2) {
            this.i = f2;
            return this;
        }

        public final a a() {
            return new a(this);
        }
    }
}
