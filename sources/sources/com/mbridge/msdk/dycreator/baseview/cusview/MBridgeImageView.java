package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.aa;

public class MBridgeImageView extends ImageView {
    private Xfermode a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float[] k;
    private float[] l;
    private RectF m;
    private RectF n;
    private boolean o;
    private boolean p;
    private Path q;
    private Paint r;

    public MBridgeImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MBridgeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBridgeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.q = new Path();
        this.r = new Paint();
        this.k = new float[8];
        this.l = new float[8];
        this.n = new RectF();
        this.m = new RectF();
        this.a = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        super.onSizeChanged(i2, i3, i4, i5);
        this.b = i2;
        this.c = i3;
        int i9 = 0;
        if (this.p) {
            try {
                if (!(this.k == null || this.l == null)) {
                    while (true) {
                        i6 = 2;
                        if (i9 >= 2) {
                            break;
                        }
                        float[] fArr = this.k;
                        int i10 = this.e;
                        fArr[i9] = (float) i10;
                        this.l[i9] = ((float) i10) - (((float) this.i) / 2.0f);
                        i9++;
                    }
                    while (true) {
                        i7 = 4;
                        if (i6 >= 4) {
                            break;
                        }
                        float[] fArr2 = this.k;
                        int i11 = this.f;
                        fArr2[i6] = (float) i11;
                        this.l[i6] = ((float) i11) - (((float) this.i) / 2.0f);
                        i6++;
                    }
                    while (true) {
                        if (i7 >= 6) {
                            break;
                        }
                        float[] fArr3 = this.k;
                        int i12 = this.g;
                        fArr3[i7] = (float) i12;
                        this.l[i7] = ((float) i12) - (((float) this.i) / 2.0f);
                        i7++;
                    }
                    for (i8 = 6; i8 < 8; i8++) {
                        float[] fArr4 = this.k;
                        int i13 = this.h;
                        fArr4[i8] = (float) i13;
                        this.l[i8] = ((float) i13) - (((float) this.i) / 2.0f);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.k != null && this.l != null) {
            while (true) {
                try {
                    float[] fArr5 = this.k;
                    if (i9 >= fArr5.length) {
                        break;
                    }
                    int i14 = this.d;
                    fArr5[i9] = (float) i14;
                    this.l[i9] = ((float) i14) - (((float) this.i) / 2.0f);
                    i9++;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        RectF rectF = this.n;
        if (rectF != null) {
            int i15 = this.i;
            rectF.set(((float) i15) / 2.0f, ((float) i15) / 2.0f, ((float) this.b) - (((float) i15) / 2.0f), ((float) this.c) - (((float) i15) / 2.0f));
        }
        RectF rectF2 = this.m;
        if (rectF2 != null) {
            rectF2.set(0.0f, 0.0f, (float) this.b, (float) this.c);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            try {
                canvas.saveLayer(this.m, (Paint) null, 31);
                int i2 = this.b;
                int i3 = this.i;
                int i4 = this.c;
                canvas.scale((((float) (i2 - (i3 * 2))) * 1.0f) / ((float) i2), (((float) (i4 - (i3 * 2))) * 1.0f) / ((float) i4), ((float) i2) / 2.0f, ((float) i4) / 2.0f);
                super.onDraw(canvas);
                Paint paint = this.r;
                if (paint != null) {
                    paint.reset();
                    this.r.setAntiAlias(true);
                    this.r.setStyle(Paint.Style.FILL);
                    this.r.setXfermode(this.a);
                }
                Path path = this.q;
                if (path != null) {
                    path.reset();
                    this.q.addRoundRect(this.m, this.l, Path.Direction.CCW);
                }
                canvas.drawPath(this.q, this.r);
                Paint paint2 = this.r;
                if (paint2 != null) {
                    paint2.setXfermode((Xfermode) null);
                }
                canvas.restore();
                if (this.o) {
                    int i5 = this.i;
                    int i6 = this.j;
                    RectF rectF = this.n;
                    float[] fArr = this.k;
                    try {
                        Path path2 = this.q;
                        if (path2 != null) {
                            path2.reset();
                        }
                        Paint paint3 = this.r;
                        if (paint3 != null) {
                            paint3.setStrokeWidth((float) i5);
                            this.r.setColor(i6);
                            this.r.setStyle(Paint.Style.STROKE);
                        }
                        Path path3 = this.q;
                        if (path3 != null) {
                            path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                        }
                        if (canvas != null) {
                            canvas.drawPath(this.q, this.r);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                aa.a("MBridgeImageView", e3.getMessage());
            }
        }
    }

    public void setCornerRadius(int i2) {
        this.d = i2;
    }

    public void setBorder(int i2, int i3, int i4) {
        this.o = true;
        this.i = i3;
        this.j = i4;
        this.d = i2;
    }

    public void setCustomBorder(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.o = true;
        this.p = true;
        this.i = i6;
        this.j = i7;
        this.e = i2;
        this.g = i4;
        this.f = i3;
        this.h = i5;
    }
}
