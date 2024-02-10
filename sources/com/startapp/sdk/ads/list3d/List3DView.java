package com.startapp.sdk.ads.list3d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import com.startapp.a0;
import com.startapp.b2;
import com.startapp.p4;
import com.startapp.q4;
import java.util.LinkedList;

/* compiled from: Sta */
public class List3DView extends AdapterView<Adapter> {
    public Adapter a;
    public int b = 0;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public VelocityTracker k;
    public b2 l;
    public Runnable m;
    public final LinkedList<View> n = new LinkedList<>();
    public Runnable o;
    public Rect p;
    public Camera q;
    public Matrix r;
    public Paint s;
    public int t = Integer.MIN_VALUE;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;

    public List3DView(Context context, AttributeSet attributeSet, String str, String str2) {
        super(context, (AttributeSet) null);
    }

    public final boolean a() {
        int i2 = a0.a;
        return true;
    }

    public int b(int i2, int i3) {
        if (this.p == null) {
            this.p = new Rect();
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            getChildAt(i4).getHitRect(this.p);
            if (this.p.contains(i2, i3)) {
                return i4;
            }
        }
        return -1;
    }

    public final int c(View view) {
        return (int) ((((float) view.getMeasuredHeight()) * 0.35000002f) / 2.0f);
    }

    public int d(View view) {
        return view.getTop() - c(view);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return super.drawChild(canvas, view, j2);
        }
        int top = view.getTop();
        int left = view.getLeft();
        int width = view.getWidth() / 2;
        int height = view.getHeight() / 2;
        float height2 = (float) (getHeight() / 2);
        float f2 = (((float) (top + height)) - height2) / height2;
        float cos = (float) (1.0d - ((1.0d - Math.cos((double) f2)) * 0.15000000596046448d));
        float f3 = (((float) this.h) - (f2 * 20.0f)) % 90.0f;
        if (f3 < 0.0f) {
            f3 += 90.0f;
        }
        float f4 = f3;
        if (f4 < 45.0f) {
            Canvas canvas2 = canvas;
            Bitmap bitmap = drawingCache;
            int i2 = top;
            int i3 = left;
            int i4 = width;
            int i5 = height;
            float f5 = cos;
            a(canvas2, bitmap, i2, i3, i4, i5, f5, f4 - 90.0f);
            a(canvas2, bitmap, i2, i3, i4, i5, f5, f4);
            return false;
        }
        Canvas canvas3 = canvas;
        Bitmap bitmap2 = drawingCache;
        int i6 = top;
        int i7 = left;
        int i8 = width;
        int i9 = height;
        float f6 = cos;
        a(canvas3, bitmap2, i6, i7, i8, i9, f6, f4);
        a(canvas3, bitmap2, i6, i7, i8, i9, f6, f4 - 90.0f);
        return false;
    }

    public Adapter getAdapter() {
        return this.a;
    }

    public View getSelectedView() {
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.m);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.u && this.a != null) {
            if (getChildCount() == 0) {
                if (this.w) {
                    this.f = getHeight() / 3;
                }
                this.j = -1;
                a(this.f, 0);
            } else {
                int d2 = (this.f + this.g) - d(getChildAt(0));
                int childCount = getChildCount();
                if (this.j != this.a.getCount() - 1 && childCount > 1) {
                    View childAt = getChildAt(0);
                    while (childAt != null && a(childAt) + d2 < 0) {
                        removeViewInLayout(childAt);
                        childCount--;
                        this.n.addLast(childAt);
                        this.i++;
                        this.g = b(childAt) + this.g;
                        childAt = childCount > 1 ? getChildAt(0) : null;
                    }
                }
                if (this.i != 0 && childCount > 1) {
                    View childAt2 = getChildAt(childCount - 1);
                    while (childAt2 != null && d(childAt2) + d2 > getHeight()) {
                        removeViewInLayout(childAt2);
                        childCount--;
                        this.n.addLast(childAt2);
                        this.j--;
                        childAt2 = childCount > 1 ? getChildAt(childCount - 1) : null;
                    }
                }
                a(a(getChildAt(getChildCount() - 1)), d2);
                int d3 = d(getChildAt(0));
                while (d3 + d2 > 0 && (i6 = this.i) > 0) {
                    int i7 = i6 - 1;
                    this.i = i7;
                    View view = this.a.getView(i7, this.n.size() != 0 ? this.n.removeFirst() : null, this);
                    a(view, 1);
                    int b2 = b(view);
                    d3 -= b2;
                    this.g -= b2;
                }
            }
            int i8 = this.f + this.g;
            float width = ((float) getWidth()) * 0.0f;
            float height = 1.0f / (((float) getHeight()) * 0.9f);
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt3 = getChildAt(i9);
                double d4 = (double) width;
                double d5 = (double) height;
                Double.isNaN(d5);
                double d6 = (double) i8;
                Double.isNaN(d6);
                double sin = Math.sin(d5 * 6.283185307179586d * d6);
                Double.isNaN(d4);
                int i10 = (int) (sin * d4);
                int measuredWidth = childAt3.getMeasuredWidth();
                int measuredHeight = childAt3.getMeasuredHeight();
                int width2 = ((getWidth() - measuredWidth) / 2) + i10;
                int c2 = c(childAt3);
                int i11 = i8 + c2;
                childAt3.layout(width2, i11, measuredWidth + width2, i11 + measuredHeight);
                i8 += (c2 * 2) + measuredHeight;
            }
            if (this.w && !this.x) {
                this.x = true;
                dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 0, 0.0f, 0.0f, 0));
                postDelayed(new p4(this), 5);
            }
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r1 <= (r0 + 10)) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r6.getChildCount()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r7.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x0097
            r1 = 0
            r3 = 2
            if (r0 == r2) goto L_0x0059
            if (r0 == r3) goto L_0x001a
            r6.a((float) r1)
            goto L_0x00f3
        L_0x001a:
            int r0 = r6.b
            if (r0 != r2) goto L_0x0043
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            int r4 = r6.c
            int r5 = r4 + -10
            if (r0 < r5) goto L_0x003c
            int r4 = r4 + 10
            if (r0 > r4) goto L_0x003c
            int r0 = r6.d
            int r4 = r0 + -10
            if (r1 < r4) goto L_0x003c
            int r0 = r0 + 10
            if (r1 <= r0) goto L_0x0043
        L_0x003c:
            java.lang.Runnable r0 = r6.o
            r6.removeCallbacks(r0)
            r6.b = r3
        L_0x0043:
            int r0 = r6.b
            if (r0 != r3) goto L_0x00f3
            android.view.VelocityTracker r0 = r6.k
            r0.addMovement(r7)
            float r7 = r7.getY()
            int r7 = (int) r7
            int r0 = r6.d
            int r7 = r7 - r0
            r6.a((int) r7)
            goto L_0x00f3
        L_0x0059:
            int r0 = r6.b
            if (r0 != r2) goto L_0x007f
            float r0 = r7.getX()
            int r0 = (int) r0
            float r7 = r7.getY()
            int r7 = (int) r7
            int r7 = r6.b(r0, r7)
            r0 = -1
            if (r7 == r0) goto L_0x0093
            android.view.View r0 = r6.getChildAt(r7)
            int r3 = r6.i
            int r3 = r3 + r7
            android.widget.Adapter r7 = r6.a
            long r4 = r7.getItemId(r3)
            r6.performItemClick(r0, r3, r4)
            goto L_0x0093
        L_0x007f:
            if (r0 != r3) goto L_0x0093
            android.view.VelocityTracker r0 = r6.k
            r0.addMovement(r7)
            android.view.VelocityTracker r7 = r6.k
            r0 = 1000(0x3e8, float:1.401E-42)
            r7.computeCurrentVelocity(r0)
            android.view.VelocityTracker r7 = r6.k
            float r1 = r7.getYVelocity()
        L_0x0093:
            r6.a((float) r1)
            goto L_0x00f3
        L_0x0097:
            boolean r0 = r6.a()
            if (r0 == 0) goto L_0x00b3
            int r0 = com.startapp.a0.a
            android.view.ViewPropertyAnimator r0 = r6.animate()
            r3 = 1065353216(0x3f800000, float:1.0)
            android.view.ViewPropertyAnimator r0 = r0.alpha(r3)
            r3 = 1500(0x5dc, double:7.41E-321)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r3)
            r3 = 0
            r0.setListener(r3)
        L_0x00b3:
            java.lang.Runnable r0 = r6.m
            r6.removeCallbacks(r0)
            float r0 = r7.getX()
            int r0 = (int) r0
            r6.c = r0
            float r0 = r7.getY()
            int r0 = (int) r0
            r6.d = r0
            android.view.View r0 = r6.getChildAt(r1)
            int r0 = r6.d(r0)
            int r1 = r6.g
            int r0 = r0 - r1
            r6.e = r0
            java.lang.Runnable r0 = r6.o
            if (r0 != 0) goto L_0x00de
            com.startapp.r4 r0 = new com.startapp.r4
            r0.<init>(r6)
            r6.o = r0
        L_0x00de:
            java.lang.Runnable r0 = r6.o
            int r1 = android.view.ViewConfiguration.getLongPressTimeout()
            long r3 = (long) r1
            r6.postDelayed(r0, r3)
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.k = r0
            r0.addMovement(r7)
            r6.b = r2
        L_0x00f3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.list3d.List3DView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(Adapter adapter) {
        if (a() && this.v) {
            int i2 = a0.a;
            setAlpha(0.0f);
        }
        this.a = adapter;
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setDynamics(b2 b2Var) {
        b2 b2Var2 = this.l;
        if (b2Var2 != null) {
            float f2 = b2Var2.a;
            float f3 = b2Var2.b;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            b2Var.b = f3;
            b2Var.a = f2;
            b2Var.e = currentAnimationTimeMillis;
        }
        this.l = b2Var;
    }

    public void setFade(boolean z) {
        this.v = z;
    }

    public void setHint(boolean z) {
        this.w = z;
    }

    public void setSelection(int i2) {
        throw new UnsupportedOperationException();
    }

    public void setStarted() {
        this.u = true;
    }

    public void setTag(String str) {
    }

    public final void a(Canvas canvas, Bitmap bitmap, int i2, int i3, int i4, int i5, float f2, float f3) {
        if (this.q == null) {
            this.q = new Camera();
        }
        this.q.save();
        this.q.translate(0.0f, 0.0f, (float) i5);
        this.q.rotateX(f3);
        float f4 = (float) (-i5);
        this.q.translate(0.0f, 0.0f, f4);
        if (this.r == null) {
            this.r = new Matrix();
        }
        this.q.getMatrix(this.r);
        this.q.restore();
        this.r.preTranslate((float) (-i4), f4);
        this.r.postScale(f2, f2);
        this.r.postTranslate((float) (i3 + i4), (float) (i2 + i5));
        if (this.s == null) {
            Paint paint = new Paint();
            this.s = paint;
            paint.setAntiAlias(true);
            this.s.setFilterBitmap(true);
        }
        Paint paint2 = this.s;
        double d2 = (double) f3;
        Double.isNaN(d2);
        double cos = Math.cos((d2 * 3.141592653589793d) / 180.0d);
        int i6 = ((int) (cos * 200.0d)) + 55;
        int pow = (int) (Math.pow(cos, 200.0d) * 70.0d);
        if (i6 > 255) {
            i6 = 255;
        }
        if (pow > 255) {
            pow = 255;
        }
        paint2.setColorFilter(new LightingColorFilter(Color.rgb(i6, i6, i6), Color.rgb(pow, pow, pow)));
        canvas.drawBitmap(bitmap, this.r, this.s);
    }

    public final int b(View view) {
        return (c(view) * 2) + view.getMeasuredHeight();
    }

    public final void a(float f2) {
        VelocityTracker velocityTracker = this.k;
        if (velocityTracker != null) {
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.k = null;
            removeCallbacks(this.o);
            if (this.m == null) {
                this.m = new q4(this);
            }
            b2 b2Var = this.l;
            if (b2Var != null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                b2Var.b = f2;
                b2Var.a = (float) this.f;
                b2Var.e = currentAnimationTimeMillis;
                post(this.m);
            }
            this.b = 0;
        }
    }

    public void a(int i2) {
        int i3;
        int i4 = this.e + i2;
        this.f = i4;
        int height = (-(i4 * 270)) / getHeight();
        this.h = height;
        int i5 = height % 90;
        if (i5 < 45) {
            i3 = (getHeight() * (-(height - i5))) / 270;
        } else {
            i3 = (getHeight() * (-((height + 90) - i5))) / 270;
        }
        if (this.t == Integer.MIN_VALUE && this.j == this.a.getCount() - 1 && a(getChildAt(getChildCount() - 1)) < getHeight()) {
            this.t = i3;
        }
        if (i3 > 0) {
            i3 = 0;
        } else {
            int i6 = this.t;
            if (i3 < i6) {
                i3 = i6;
            }
        }
        b2 b2Var = this.l;
        float f2 = (float) i3;
        b2Var.c = f2;
        b2Var.d = f2;
        requestLayout();
    }

    public final void a(int i2, int i3) {
        while (i2 + i3 < getHeight() && this.j < this.a.getCount() - 1) {
            int i4 = this.j + 1;
            this.j = i4;
            View view = this.a.getView(i4, this.n.size() != 0 ? this.n.removeFirst() : null, this);
            a(view, 0);
            i2 += b(view);
        }
    }

    public final void a(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i3 = i2 == 1 ? 0 : -1;
        view.setDrawingCacheEnabled(true);
        addViewInLayout(view, i3, layoutParams, true);
        view.measure(((int) (((float) getWidth()) * 0.85f)) | 1073741824, 0);
    }

    public final int a(View view) {
        return c(view) + view.getBottom();
    }
}
