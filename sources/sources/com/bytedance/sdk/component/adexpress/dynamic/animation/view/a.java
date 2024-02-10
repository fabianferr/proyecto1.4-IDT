package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;

/* compiled from: AnimationWrapper */
public class a {
    Paint a;
    Path b = new Path();
    Path c = new Path();
    private int d;
    private int e;
    private int f;

    public a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0160 A[SYNTHETIC, Splitter:B:39:0x0160] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r24, com.bytedance.sdk.component.adexpress.dynamic.animation.view.b r25, android.view.View r26) {
        /*
            r23 = this;
            r0 = r23
            r7 = r24
            r8 = r26
            float r1 = r25.getRippleValue()
            r2 = 3
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r11 = 1
            r12 = 2
            r13 = 0
            int r1 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x0092
            com.bytedance.sdk.component.adexpress.a.a.a r1 = com.bytedance.sdk.component.adexpress.a.a.a.a()
            com.bytedance.sdk.component.adexpress.a.a.c r1 = r1.c()
            if (r1 == 0) goto L_0x006e
            java.lang.String r1 = ""
            int r3 = com.bytedance.sdk.component.adexpress.dynamic.a.e     // Catch:{ Exception -> 0x002f }
            java.lang.Object r3 = r8.getTag(r3)     // Catch:{ Exception -> 0x002f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x002f }
            float[] r1 = com.bytedance.sdk.component.adexpress.dynamic.b.g.b(r3)     // Catch:{ Exception -> 0x002e }
            goto L_0x0035
        L_0x002e:
            r1 = r3
        L_0x002f:
            r3 = 0
            r22 = r3
            r3 = r1
            r1 = r22
        L_0x0035:
            java.lang.String r4 = "#"
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L_0x004e
            android.graphics.Paint r1 = r0.a
            int r3 = android.graphics.Color.parseColor(r3)
            r1.setColor(r3)
            android.graphics.Paint r1 = r0.a
            r3 = 90
            r1.setAlpha(r3)
            goto L_0x006e
        L_0x004e:
            if (r1 == 0) goto L_0x006e
            r3 = r1[r2]
            float r4 = r25.getRippleValue()
            float r4 = r9 - r4
            float r3 = r3 * r4
            r4 = r1[r10]
            r5 = 1132462080(0x43800000, float:256.0)
            float r4 = r4 / r5
            r6 = r1[r11]
            float r6 = r6 / r5
            r1 = r1[r12]
            float r1 = r1 / r5
            int r1 = com.bytedance.sdk.component.adexpress.c.e.a(r3, r4, r6, r1)
            android.graphics.Paint r3 = r0.a
            r3.setColor(r1)
        L_0x006e:
            android.view.ViewParent r1 = r26.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r3 = r1
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r1.setClipChildren(r11)
            int r1 = r0.d
            float r3 = (float) r1
            int r4 = r0.e
            float r5 = (float) r4
            int r1 = java.lang.Math.min(r1, r4)
            int r1 = r1 * 2
            float r1 = (float) r1
            float r4 = r25.getRippleValue()
            float r1 = r1 * r4
            android.graphics.Paint r4 = r0.a
            r7.drawCircle(r3, r5, r1, r4)
        L_0x0092:
            float r1 = r25.getShineValue()
            int r1 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x0158
            android.view.ViewParent r1 = r26.getParent()
            if (r1 == 0) goto L_0x00ac
            android.view.ViewParent r1 = r26.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r3 = r1
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r1.setClipChildren(r11)
        L_0x00ac:
            android.view.ViewParent r1 = r26.getParent()
            android.view.ViewParent r1 = r1.getParent()
            if (r1 == 0) goto L_0x00c6
            android.view.ViewParent r1 = r26.getParent()
            android.view.ViewParent r1 = r1.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r3 = r1
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r1.setClipChildren(r11)
        L_0x00c6:
            android.graphics.Path r1 = r0.b
            r1.reset()
            int r1 = com.bytedance.sdk.component.adexpress.dynamic.a.b     // Catch:{ Exception -> 0x00d8 }
            java.lang.Object r1 = r8.getTag(r1)     // Catch:{ Exception -> 0x00d8 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x00d8 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00da
        L_0x00d8:
            r1 = 0
        L_0x00da:
            if (r1 < 0) goto L_0x0158
            int r3 = r0.d
            int r3 = r3 * 4
            int r4 = r1 * 2
            int r3 = r3 + r4
            int r4 = r0.e
            int r4 = r4 * 2
            int r3 = r3 + r4
            float r3 = (float) r3
            float r4 = r25.getShineValue()
            float r3 = r3 * r4
            int r3 = (int) r3
            int r4 = r0.e
            int r4 = r4 * 2
            int r4 = r4 + r1
            int r3 = r3 - r4
            android.graphics.LinearGradient r4 = new android.graphics.LinearGradient
            float r5 = (float) r3
            r16 = 0
            int r6 = r0.e
            int r14 = r1 + r6
            int r14 = r14 / r12
            int r14 = r14 + r3
            float r15 = (float) r14
            int r6 = r6 / r12
            float r6 = (float) r6
            int[] r2 = new int[r2]
            java.lang.String r14 = "#20ffffff"
            int r14 = android.graphics.Color.parseColor(r14)
            r2[r10] = r14
            java.lang.String r14 = "#60ffffff"
            int r14 = android.graphics.Color.parseColor(r14)
            r2[r11] = r14
            java.lang.String r14 = "#65ffffff"
            int r14 = android.graphics.Color.parseColor(r14)
            r2[r12] = r14
            r20 = 0
            android.graphics.Shader$TileMode r21 = android.graphics.Shader.TileMode.MIRROR
            r14 = r4
            r17 = r15
            r15 = r5
            r18 = r6
            r19 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            android.graphics.Paint r2 = r0.a
            r2.setShader(r4)
            android.graphics.Paint r2 = r0.a
            int r4 = r0.d
            int r4 = r4 * 2
            float r4 = (float) r4
            r2.setStrokeWidth(r4)
            android.graphics.Path r2 = r0.c
            if (r2 == 0) goto L_0x0145
            android.graphics.Region$Op r4 = android.graphics.Region.Op.INTERSECT
            r7.clipPath(r2, r4)
        L_0x0145:
            r4 = 0
            int r3 = r3 + r1
            int r1 = r0.e
            int r3 = r3 + r1
            float r6 = (float) r3
            float r14 = (float) r1
            android.graphics.Paint r15 = r0.a
            r1 = r24
            r2 = r5
            r3 = r4
            r4 = r6
            r5 = r14
            r6 = r15
            r1.drawLine(r2, r3, r4, r5, r6)
        L_0x0158:
            float r1 = r25.getMarqueeValue()
            int r1 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x01f7
            int r1 = com.bytedance.sdk.component.adexpress.dynamic.a.c     // Catch:{ Exception -> 0x016d }
            java.lang.Object r1 = r8.getTag(r1)     // Catch:{ Exception -> 0x016d }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x016d }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x016d }
            goto L_0x016f
        L_0x016d:
            r1 = 0
        L_0x016f:
            if (r1 < 0) goto L_0x01f7
            android.graphics.Path r2 = r0.b
            r2.reset()
            android.graphics.Path r2 = r0.b
            r2.moveTo(r13, r13)
            android.graphics.Path r2 = r0.b
            int r3 = r0.d
            int r3 = r3 * 2
            float r3 = (float) r3
            r2.lineTo(r3, r13)
            android.graphics.Path r2 = r0.b
            int r3 = r0.d
            int r3 = r3 * 2
            float r3 = (float) r3
            int r4 = r0.e
            int r4 = r4 * 2
            float r4 = (float) r4
            r2.lineTo(r3, r4)
            android.graphics.Path r2 = r0.b
            int r3 = r0.e
            int r3 = r3 * 2
            float r3 = (float) r3
            r2.lineTo(r13, r3)
            android.graphics.Path r2 = r0.b
            r2.lineTo(r13, r13)
            android.graphics.LinearGradient r2 = new android.graphics.LinearGradient
            r15 = 0
            r16 = 0
            int r3 = r0.d
            int r3 = r3 * 2
            float r3 = (float) r3
            int r4 = r0.e
            int r4 = r4 * 2
            float r4 = (float) r4
            int[] r5 = new int[r12]
            float r6 = r25.getMarqueeValue()
            r8 = -947912704(0xffffffffc7800000, float:-65536.0)
            float r6 = r6 * r8
            int r6 = (int) r6
            r5[r10] = r6
            float r6 = r25.getMarqueeValue()
            float r9 = r9 - r6
            float r9 = r9 * r8
            int r6 = (int) r9
            r5[r11] = r6
            r20 = 0
            android.graphics.Shader$TileMode r21 = android.graphics.Shader.TileMode.CLAMP
            r14 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            android.graphics.Paint r3 = r0.a
            r3.setShader(r2)
            android.graphics.Paint r2 = r0.a
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r2.setColor(r3)
            android.graphics.Paint r2 = r0.a
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r2.setStyle(r3)
            android.graphics.Paint r2 = r0.a
            float r1 = (float) r1
            r2.setStrokeWidth(r1)
            android.graphics.Path r1 = r0.b
            android.graphics.Paint r2 = r0.a
            r7.drawPath(r1, r2)
        L_0x01f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.view.a.a(android.graphics.Canvas, com.bytedance.sdk.component.adexpress.dynamic.animation.view.b, android.view.View):void");
    }

    public void a(View view, float f2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (((float) this.f) * f2);
        view.setTranslationX((float) ((this.f - layoutParams.width) / 2));
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((float) ((-(this.f - layoutParams.width)) / 2));
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r6, int r7, int r8) {
        /*
            r5 = this;
            int r0 = r7 / 2
            r5.d = r0
            int r0 = r8 / 2
            r5.e = r0
            java.lang.String r0 = ""
            int r1 = r5.f
            if (r1 != 0) goto L_0x001e
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            int r1 = r1.width
            if (r1 <= 0) goto L_0x001e
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            int r1 = r1.width
            r5.f = r1
        L_0x001e:
            r1 = 0
            int r2 = com.bytedance.sdk.component.adexpress.dynamic.a.d     // Catch:{ Exception -> 0x003f }
            java.lang.Object r2 = r6.getTag(r2)     // Catch:{ Exception -> 0x003f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x003f }
            android.graphics.RectF r0 = new android.graphics.RectF     // Catch:{ Exception -> 0x003c }
            float r7 = (float) r7     // Catch:{ Exception -> 0x003c }
            float r3 = (float) r8     // Catch:{ Exception -> 0x003c }
            r0.<init>(r1, r1, r7, r3)     // Catch:{ Exception -> 0x003c }
            android.graphics.Path r7 = r5.c     // Catch:{ Exception -> 0x003c }
            int r3 = r8 / 2
            float r3 = (float) r3     // Catch:{ Exception -> 0x003c }
            int r8 = r8 / 2
            float r8 = (float) r8     // Catch:{ Exception -> 0x003c }
            android.graphics.Path$Direction r4 = android.graphics.Path.Direction.CW     // Catch:{ Exception -> 0x003c }
            r7.addRoundRect(r0, r3, r8, r4)     // Catch:{ Exception -> 0x003c }
            goto L_0x0041
        L_0x003c:
            r0 = r2
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            r2 = r0
        L_0x0041:
            java.lang.String r7 = "right"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0058
            int r7 = r5.d
            int r7 = r7 * 2
            float r7 = (float) r7
            r6.setPivotX(r7)
            int r7 = r5.e
            float r7 = (float) r7
            r6.setPivotY(r7)
            goto L_0x0076
        L_0x0058:
            java.lang.String r7 = "left"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x006a
            r6.setPivotX(r1)
            int r7 = r5.e
            float r7 = (float) r7
            r6.setPivotY(r7)
            goto L_0x0076
        L_0x006a:
            int r7 = r5.d
            float r7 = (float) r7
            r6.setPivotX(r7)
            int r7 = r5.e
            float r7 = (float) r7
            r6.setPivotY(r7)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.view.a.a(android.view.View, int, int):void");
    }
}
