package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.webview.c;

public class ProgressBar extends View implements c {
    Runnable a = new Runnable() {
        public final void run() {
            ProgressBar.this.invalidate();
        }
    };
    private Rect b = new Rect();
    private float c;
    private float d = 0.95f;
    private long e;
    private float f;
    private boolean g;
    private float h;
    private float i;
    private float j;
    private long k;
    private int l;
    private int m;
    private int n;
    private int o;
    private long p = 25;
    private Drawable q;
    private Drawable r;
    private Drawable s;
    private Drawable t;
    private boolean u = false;
    private c.a v;
    private Handler w = new Handler(Looper.getMainLooper());
    private boolean x;
    private boolean y = false;

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public ProgressBar(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r12.x != false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r12.x != false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r12.x != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r12.x != false) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r13) {
        /*
            r12 = this;
            boolean r0 = r12.u
            r1 = 1
            if (r0 != 0) goto L_0x0007
            r12.u = r1
        L_0x0007:
            long r2 = java.lang.System.currentTimeMillis()
            boolean r0 = r12.y
            if (r0 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0016
        L_0x0012:
            long r4 = r12.e
            long r4 = r2 - r4
        L_0x0016:
            float r0 = (float) r4
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r0 = r0 / r6
            float r0 = java.lang.Math.abs(r0)
            r12.f = r0
            r12.e = r2
            long r2 = r12.k
            long r2 = r2 + r4
            r12.k = r2
            boolean r4 = r12.g
            r5 = 1045220557(0x3e4ccccd, float:0.2)
            r6 = 1028443341(0x3d4ccccd, float:0.05)
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 1053609165(0x3ecccccd, float:0.4)
            if (r4 != 0) goto L_0x005b
            r9 = 2000(0x7d0, double:9.88E-321)
            int r11 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x0057
            int r2 = r12.n
            if (r2 != r1) goto L_0x0045
            boolean r1 = r12.x
            if (r1 == 0) goto L_0x0061
            goto L_0x005f
        L_0x0045:
            int r2 = r12.m
            if (r2 != r1) goto L_0x0052
            boolean r1 = r12.x
            if (r1 == 0) goto L_0x004e
            goto L_0x0061
        L_0x004e:
            r8 = 1045220557(0x3e4ccccd, float:0.2)
            goto L_0x0061
        L_0x0052:
            boolean r1 = r12.x
            if (r1 == 0) goto L_0x0057
            goto L_0x004e
        L_0x0057:
            r8 = 1028443341(0x3d4ccccd, float:0.05)
            goto L_0x0061
        L_0x005b:
            boolean r1 = r12.x
            if (r1 == 0) goto L_0x0061
        L_0x005f:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0061:
            r12.j = r8
            float r1 = r12.i
            float r8 = r8 * r0
            float r1 = r1 + r8
            r12.i = r1
            if (r4 != 0) goto L_0x0074
            float r0 = r12.d
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            r12.i = r0
        L_0x0074:
            android.graphics.Rect r0 = r12.b
            float r1 = r12.i
            float r2 = r12.c
            float r1 = r1 * r2
            int r1 = (int) r1
            r0.right = r1
            android.os.Handler r0 = r12.w
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            android.os.Handler r0 = r12.w
            java.lang.Runnable r1 = r12.a
            long r2 = r12.p
            r0.postDelayed(r1, r2)
            super.draw(r13)
            float r0 = r12.f
            boolean r1 = r12.g
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x00d2
            float r1 = r12.h
            float r4 = r12.c
            r8 = 1056964608(0x3f000000, float:0.5)
            float r9 = r4 * r8
            float r9 = r1 / r9
            float r7 = r7 - r9
            r9 = 1132396544(0x437f0000, float:255.0)
            float r7 = r7 * r9
            int r7 = (int) r7
            if (r7 >= 0) goto L_0x00ac
            r7 = 0
        L_0x00ac:
            float r4 = r4 * r8
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b5
            r12.setVisible(r3)
        L_0x00b5:
            android.graphics.drawable.Drawable r1 = r12.r
            if (r1 == 0) goto L_0x00bc
            r1.setAlpha(r7)
        L_0x00bc:
            android.graphics.drawable.Drawable r1 = r12.s
            if (r1 == 0) goto L_0x00c3
            r1.setAlpha(r7)
        L_0x00c3:
            android.graphics.drawable.Drawable r1 = r12.q
            if (r1 == 0) goto L_0x00ca
            r1.setAlpha(r7)
        L_0x00ca:
            r13.save()
            float r1 = r12.h
            r13.translate(r1, r2)
        L_0x00d2:
            android.graphics.drawable.Drawable r1 = r12.r
            if (r1 == 0) goto L_0x00fa
            android.graphics.drawable.Drawable r1 = r12.q
            if (r1 == 0) goto L_0x00fa
            android.graphics.Rect r1 = r12.b
            int r1 = r1.width()
            float r1 = (float) r1
            android.graphics.drawable.Drawable r4 = r12.q
            int r4 = r4.getIntrinsicWidth()
            float r4 = (float) r4
            float r4 = r4 * r6
            float r1 = r1 - r4
            int r1 = (int) r1
            android.graphics.drawable.Drawable r4 = r12.r
            int r6 = r4.getIntrinsicHeight()
            r4.setBounds(r3, r3, r1, r6)
            android.graphics.drawable.Drawable r1 = r12.r
            r1.draw(r13)
        L_0x00fa:
            boolean r1 = r12.g
            if (r1 == 0) goto L_0x0123
            android.graphics.drawable.Drawable r1 = r12.s
            if (r1 == 0) goto L_0x0123
            android.graphics.drawable.Drawable r4 = r12.q
            if (r4 == 0) goto L_0x0123
            int r1 = r1.getIntrinsicWidth()
            android.graphics.drawable.Drawable r4 = r12.s
            int r6 = r4.getIntrinsicHeight()
            r4.setBounds(r3, r3, r1, r6)
            r13.save()
            int r1 = -r1
            float r1 = (float) r1
            r13.translate(r1, r2)
            android.graphics.drawable.Drawable r1 = r12.s
            r1.draw(r13)
            r13.restore()
        L_0x0123:
            android.graphics.drawable.Drawable r1 = r12.q
            if (r1 == 0) goto L_0x0141
            r13.save()
            android.graphics.Rect r1 = r12.b
            int r1 = r1.width()
            int r3 = r12.getWidth()
            int r1 = r1 - r3
            float r1 = (float) r1
            r13.translate(r1, r2)
            android.graphics.drawable.Drawable r1 = r12.q
            r1.draw(r13)
            r13.restore()
        L_0x0141:
            boolean r1 = r12.g
            if (r1 != 0) goto L_0x018d
            float r1 = r12.i
            float r3 = r12.d
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            r3 = 925353388(0x3727c5ac, float:1.0E-5)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x018d
            android.graphics.drawable.Drawable r1 = r12.t
            if (r1 == 0) goto L_0x018d
            int r3 = r12.l
            float r3 = (float) r3
            float r0 = r0 * r5
            float r4 = r12.c
            float r0 = r0 * r4
            float r3 = r3 + r0
            int r0 = (int) r3
            r12.l = r0
            int r1 = r1.getIntrinsicWidth()
            int r0 = r0 + r1
            android.graphics.Rect r1 = r12.b
            int r1 = r1.width()
            if (r0 < r1) goto L_0x017c
            android.graphics.drawable.Drawable r0 = r12.t
            int r0 = r0.getIntrinsicWidth()
            int r0 = -r0
            r12.l = r0
        L_0x017c:
            r13.save()
            int r0 = r12.l
            float r0 = (float) r0
            r13.translate(r0, r2)
            android.graphics.drawable.Drawable r0 = r12.t
            r0.draw(r13)
            r13.restore()
        L_0x018d:
            boolean r0 = r12.g
            if (r0 == 0) goto L_0x0194
            r13.restore()
        L_0x0194:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.ProgressBar.draw(android.graphics.Canvas):void");
    }

    public void onThemeChange() {
        if (this.u) {
            initResource(true);
        }
    }

    public void initResource(boolean z) {
        if (z || (this.t == null && this.q == null && this.r == null && this.s == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", b.d().b()));
            this.t = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.t.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", b.d().b()));
            this.q = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.q.getIntrinsicHeight());
            }
            this.r = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", b.d().b()));
            this.s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", b.d().b()));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Drawable drawable = this.t;
        if (drawable != null) {
            double intrinsicWidth = (double) drawable.getIntrinsicWidth();
            Double.isNaN(intrinsicWidth);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * 1.5d), getHeight());
        }
        Drawable drawable2 = this.q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void startEndAnimation() {
        if (!this.g) {
            this.g = true;
            this.h = 0.0f;
        }
    }

    public void setProgress(float f2, boolean z) {
        if (z && f2 >= 1.0f) {
            startEndAnimation();
        }
    }

    public void setVisible(boolean z) {
        if (z) {
            this.x = true;
            this.e = System.currentTimeMillis();
            this.f = 0.0f;
            this.k = 0;
            this.g = false;
            this.h = 0.0f;
            this.i = 0.0f;
            this.c = (float) getMeasuredWidth();
            this.y = false;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            Drawable drawable = this.t;
            if (drawable != null) {
                this.l = -drawable.getIntrinsicWidth();
            } else {
                this.l = 0;
            }
            Drawable drawable2 = this.r;
            if (drawable2 != null) {
                drawable2.setAlpha(255);
            }
            Drawable drawable3 = this.s;
            if (drawable3 != null) {
                drawable3.setAlpha(255);
            }
            Drawable drawable4 = this.q;
            if (drawable4 != null) {
                drawable4.setAlpha(255);
            }
            setVisibility(0);
            invalidate();
            return;
        }
        setVisibility(4);
    }

    public float getProgress() {
        return this.i;
    }

    public void setProgressBarListener(c.a aVar) {
        this.v = aVar;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            c.a aVar = this.v;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        c.a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }

    public void setProgressState(int i2) {
        if (i2 == 5) {
            this.m = 1;
            this.n = 0;
            this.o = 0;
            this.k = 0;
        } else if (i2 == 6) {
            this.n = 1;
            if (this.o == 1) {
                startEndAnimation();
            }
            this.k = 0;
        } else if (i2 == 7) {
            startEndAnimation();
        } else if (i2 == 8) {
            this.o = 1;
            if (this.n == 1) {
                startEndAnimation();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.c = (float) getMeasuredWidth();
    }

    public void setPaused(boolean z) {
        this.y = z;
        if (!z) {
            this.e = System.currentTimeMillis();
        }
    }
}
