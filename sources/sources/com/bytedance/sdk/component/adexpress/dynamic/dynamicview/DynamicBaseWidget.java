package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.a;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.s;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class DynamicBaseWidget extends FrameLayout implements b, d, e {
    private static final View.OnTouchListener u = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener v = new View.OnClickListener() {
        public void onClick(View view) {
        }
    };
    private float a;
    private float b;
    protected float c;
    protected float d;
    protected float e;
    protected float f;
    protected int g = ((int) e.a(this.k, this.e));
    protected int h = ((int) e.a(this.k, this.f));
    protected int i = ((int) e.a(this.k, this.c));
    protected int j = ((int) e.a(this.k, this.d));
    protected Context k;
    protected g l;
    protected h m;
    protected DynamicRootView n;
    protected View o;
    protected boolean p;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.a.b q;
    a r;
    private float s;
    private float t;

    public float getShineValue() {
        return this.b;
    }

    public void setShineValue(float f2) {
        this.b = f2;
        postInvalidate();
    }

    public float getRippleValue() {
        return this.a;
    }

    public void setRippleValue(float f2) {
        this.a = f2;
        postInvalidate();
    }

    public float getMarqueeValue() {
        return this.s;
    }

    public void setMarqueeValue(float f2) {
        this.s = f2;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.t;
    }

    public void setStretchValue(float f2) {
        this.t = f2;
        this.r.a(this, f2);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context);
        this.k = context;
        this.n = dynamicRootView;
        this.m = hVar;
        this.c = hVar.f();
        this.d = hVar.g();
        this.e = hVar.h();
        this.f = hVar.i();
        g gVar = new g(hVar.j());
        this.l = gVar;
        if (gVar.r() > 0) {
            this.g += this.l.r() * 2;
            this.h += this.l.r() * 2;
            this.i -= this.l.r();
            this.j -= this.l.r();
            List<h> k2 = hVar.k();
            if (k2 != null) {
                for (h next : k2) {
                    next.c(next.f() + ((float) e.b(this.k, (float) this.l.r())));
                    next.d(next.g() + ((float) e.b(this.k, (float) this.l.r())));
                    next.a((float) e.b(this.k, (float) this.l.r()));
                    next.b((float) e.b(this.k, (float) this.l.r()));
                }
            }
        }
        this.p = this.l.n() > 0.0d;
        this.r = new a();
    }

    public void setShouldInvisible(boolean z) {
        this.p = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.p;
    }

    public boolean c() {
        i();
        f();
        d();
        return true;
    }

    public void a(int i2) {
        g gVar = this.l;
        if (gVar != null && gVar.a(i2)) {
            i();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (getChildAt(i3) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).a(i2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        View.OnClickListener onClickListener;
        View.OnTouchListener onTouchListener;
        View view = this.o;
        if (view == null) {
            view = this;
        }
        if (e()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = u;
            onClickListener = v;
        }
        if (!(onTouchListener == null || onClickListener == null)) {
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
        }
        a(view);
        b(view);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (double) this.m.h());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (double) this.m.i());
            if (d.b()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.a.t, this.l.G());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.a.u, this.m.j().b());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.a.v, this.m.c());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.a.w, jSONObject.toString());
                return;
            }
            view.setTag(s.e(getContext(), "tt_id_click_tag"), this.l.G());
            view.setTag(s.e(getContext(), "tt_id_click_area_type"), this.m.j().b());
            view.setTag(s.e(getContext(), "tt_id_click_area_id"), this.m.c());
            view.setTag(s.e(getContext(), "tt_id_area_rect_info"), jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void b(View view) {
        f e2;
        h hVar = this.m;
        if (hVar != null && (e2 = hVar.j().e()) != null) {
            view.setTag(s.e(getContext(), "tt_id_open_landing_page"), Boolean.valueOf(e2.aC()));
        }
    }

    public boolean e() {
        g gVar = this.l;
        return (gVar == null || gVar.x() == 0) ? false : true;
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
        layoutParams.topMargin = this.j;
        layoutParams.leftMargin = this.i;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.l.x();
    }

    public String getImageObjectFit() {
        return this.l.S();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.d.a getDynamicClickListener() {
        return this.n.getDynamicClickListener();
    }

    /* access modifiers changed from: protected */
    public Drawable getBackgroundDrawable() {
        return a(false, "");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:2|3|(1:8)(1:7)|9|10|11|(1:15)|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00d3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable a(boolean r16, java.lang.String r17) {
        /*
            r15 = this;
            r0 = r15
            java.lang.String r1 = ","
            java.lang.String r2 = "%"
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            java.lang.String r3 = r3.F()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 3
            r5 = 7
            r6 = 2
            r7 = 0
            r8 = 1
            if (r3 != 0) goto L_0x00f8
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r3 = r3.F()     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r9 = "("
            int r9 = r3.indexOf(r9)     // Catch:{ Exception -> 0x00f0 }
            int r9 = r9 + r8
            int r10 = r3.length()     // Catch:{ Exception -> 0x00f0 }
            int r10 = r10 - r8
            java.lang.String r3 = r3.substring(r9, r10)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r9 = "rgba"
            boolean r9 = r3.contains(r9)     // Catch:{ Exception -> 0x00f0 }
            if (r9 == 0) goto L_0x0080
            boolean r9 = r3.contains(r2)     // Catch:{ Exception -> 0x00f0 }
            if (r9 == 0) goto L_0x0080
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00f0 }
            int r10 = r3.indexOf(r1)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r10 = r3.substring(r7, r10)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r10 = r10.trim()     // Catch:{ Exception -> 0x00f0 }
            r9[r7] = r10     // Catch:{ Exception -> 0x00f0 }
            int r1 = r3.indexOf(r1)     // Catch:{ Exception -> 0x00f0 }
            int r1 = r1 + r8
            int r10 = r3.indexOf(r2)     // Catch:{ Exception -> 0x00f0 }
            int r10 = r10 + r8
            java.lang.String r1 = r3.substring(r1, r10)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x00f0 }
            r9[r8] = r1     // Catch:{ Exception -> 0x00f0 }
            int r1 = r3.indexOf(r2)     // Catch:{ Exception -> 0x00f0 }
            int r1 = r1 + r6
            java.lang.String r1 = r3.substring(r1)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x00f0 }
            r9[r6] = r1     // Catch:{ Exception -> 0x00f0 }
            int[] r1 = new int[r6]     // Catch:{ Exception -> 0x00f0 }
            r2 = r9[r8]     // Catch:{ Exception -> 0x00f0 }
            int r2 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00f0 }
            r1[r7] = r2     // Catch:{ Exception -> 0x00f0 }
            r2 = r9[r6]     // Catch:{ Exception -> 0x00f0 }
            int r2 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00f0 }
            r1[r8] = r2     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00a0
        L_0x0080:
            java.lang.String r1 = ", "
            java.lang.String[] r9 = r3.split(r1)     // Catch:{ Exception -> 0x00f0 }
            int[] r1 = new int[r6]     // Catch:{ Exception -> 0x00f0 }
            r2 = r9[r8]     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r2 = r2.substring(r7, r5)     // Catch:{ Exception -> 0x00f0 }
            int r2 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00f0 }
            r1[r7] = r2     // Catch:{ Exception -> 0x00f0 }
            r2 = r9[r6]     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r2 = r2.substring(r7, r5)     // Catch:{ Exception -> 0x00f0 }
            int r2 = com.bytedance.sdk.component.adexpress.dynamic.b.g.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00f0 }
            r1[r8] = r2     // Catch:{ Exception -> 0x00f0 }
        L_0x00a0:
            java.lang.String r2 = "linear-gradient("
            int r2 = r3.indexOf(r2)     // Catch:{ Exception -> 0x00d3 }
            int r2 = r2 + r8
            java.lang.String r10 = "deg"
            int r10 = r3.indexOf(r10)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r2 = r3.substring(r2, r10)     // Catch:{ Exception -> 0x00d3 }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x00d3 }
            r10 = 4642120500284227584(0x406c200000000000, double:225.0)
            int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00d3
            r10 = 4644249154795601920(0x4073b00000000000, double:315.0)
            int r12 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d3
            int r2 = r1.length     // Catch:{ Exception -> 0x00d3 }
            int r2 = r2 - r8
            r2 = r1[r2]     // Catch:{ Exception -> 0x00d3 }
            int r3 = r1.length     // Catch:{ Exception -> 0x00d3 }
            int r3 = r3 - r8
            r10 = r1[r7]     // Catch:{ Exception -> 0x00d3 }
            r1[r3] = r10     // Catch:{ Exception -> 0x00d3 }
            r1[r7] = r2     // Catch:{ Exception -> 0x00d3 }
        L_0x00d3:
            r2 = r9[r7]     // Catch:{ Exception -> 0x00f0 }
            android.graphics.drawable.GradientDrawable$Orientation r2 = r15.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00f0 }
            android.graphics.drawable.GradientDrawable r1 = r15.a((android.graphics.drawable.GradientDrawable.Orientation) r2, (int[]) r1)     // Catch:{ Exception -> 0x00f0 }
            r1.setShape(r7)     // Catch:{ Exception -> 0x00f0 }
            android.content.Context r2 = r0.k     // Catch:{ Exception -> 0x00f0 }
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l     // Catch:{ Exception -> 0x00f0 }
            float r3 = r3.o()     // Catch:{ Exception -> 0x00f0 }
            float r2 = com.bytedance.sdk.component.adexpress.c.e.a(r2, r3)     // Catch:{ Exception -> 0x00f0 }
            r1.setCornerRadius(r2)     // Catch:{ Exception -> 0x00f0 }
            return r1
        L_0x00f0:
            android.graphics.drawable.Drawable r1 = r15.getMutilBackgroundDrawable()
            if (r1 == 0) goto L_0x00f8
            return r1
        L_0x00f8:
            android.graphics.drawable.GradientDrawable r1 = r15.getDrawable()
            r1.setShape(r7)
            android.content.Context r2 = r0.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            float r3 = r3.o()
            float r2 = com.bytedance.sdk.component.adexpress.c.e.a(r2, r3)
            r1.setCornerRadius(r2)
            r3 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0173
            android.content.Context r3 = r0.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r10 = r0.l
            int r10 = r10.A()
            float r10 = (float) r10
            float r3 = com.bytedance.sdk.component.adexpress.c.e.a(r3, r10)
            android.content.Context r10 = r0.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r11 = r0.l
            int r11 = r11.B()
            float r11 = (float) r11
            float r10 = com.bytedance.sdk.component.adexpress.c.e.a(r10, r11)
            android.content.Context r11 = r0.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r12 = r0.l
            int r12 = r12.C()
            float r12 = (float) r12
            float r11 = com.bytedance.sdk.component.adexpress.c.e.a(r11, r12)
            android.content.Context r12 = r0.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r13 = r0.l
            int r13 = r13.D()
            float r13 = (float) r13
            float r12 = com.bytedance.sdk.component.adexpress.c.e.a(r12, r13)
            r13 = 8
            float[] r13 = new float[r13]
            int r14 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r14 <= 0) goto L_0x0155
            r13[r7] = r3
            r13[r8] = r3
        L_0x0155:
            int r3 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x015d
            r13[r6] = r10
            r13[r4] = r10
        L_0x015d:
            int r3 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0167
            r3 = 4
            r13[r3] = r11
            r3 = 5
            r13[r3] = r11
        L_0x0167:
            int r3 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0170
            r3 = 6
            r13[r3] = r12
            r13[r5] = r12
        L_0x0170:
            r1.setCornerRadii(r13)
        L_0x0173:
            if (r16 == 0) goto L_0x017a
            int r3 = android.graphics.Color.parseColor(r17)
            goto L_0x0180
        L_0x017a:
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            int r3 = r3.y()
        L_0x0180:
            r1.setColor(r3)
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            float r3 = r3.q()
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x01a4
            android.content.Context r2 = r0.k
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            float r3 = r3.q()
            float r2 = com.bytedance.sdk.component.adexpress.c.e.a(r2, r3)
            int r2 = (int) r2
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            int r3 = r3.p()
            r1.setStroke(r2, r3)
            goto L_0x01e2
        L_0x01a4:
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            int r3 = r3.r()
            if (r3 <= 0) goto L_0x01e2
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            int r3 = r3.r()
            com.bytedance.sdk.component.adexpress.dynamic.b.g r4 = r0.l
            int r4 = r4.p()
            r1.setStroke(r3, r4)
            r3 = 50
            r1.setAlpha(r3)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r3 = r0.m
            com.bytedance.sdk.component.adexpress.dynamic.b.e r3 = r3.j()
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "video-vd"
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L_0x01e2
            r1 = 0
            r15.setLayerType(r8, r1)
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c r1 = new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
            int r2 = (int) r2
            com.bytedance.sdk.component.adexpress.dynamic.b.g r3 = r0.l
            int r3 = r3.r()
            r1.<init>(r2, r3)
        L_0x01e2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.a(boolean, java.lang.String):android.graphics.drawable.Drawable");
    }

    /* access modifiers changed from: protected */
    public b a(Bitmap bitmap) {
        return new a(bitmap, (b) null);
    }

    /* access modifiers changed from: protected */
    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(a(b(this.l.F().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] a(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (str.contains("linear-gradient")) {
                String[] split = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = split.length - 1;
                int[] iArr = new int[length];
                int i3 = 0;
                while (i3 < length) {
                    int i4 = i3 + 1;
                    iArr[i3] = g.a(split[i4].substring(0, 7));
                    i3 = i4;
                }
                GradientDrawable a2 = a(a(split[0]), iArr);
                a2.setShape(0);
                a2.setCornerRadius(e.a(this.k, this.l.o()));
                drawableArr[(list.size() - 1) - i2] = a2;
            }
        }
        return drawableArr;
    }

    private List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) == '(') {
                i2++;
                z = true;
            } else if (str.charAt(i4) == ')' && i2 - 1 == 0 && z) {
                int i5 = i4 + 1;
                arrayList.add(str.substring(i3, i5));
                i3 = i5;
                z = false;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    /* access modifiers changed from: protected */
    public GradientDrawable a(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length != 1) {
            return new GradientDrawable(orientation, iArr);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(iArr[0]);
        return gradientDrawable;
    }

    /* access modifiers changed from: protected */
    public GradientDrawable.Orientation a(String str) {
        try {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (parseFloat <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (parseFloat <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (parseFloat <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.r.a(canvas, (b) this, (View) this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a aVar = this.r;
        View view = this.o;
        if (view == null) {
            view = this;
        }
        aVar.a(view, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public void g() {
        if (!h()) {
            View view = this.o;
            if (view == null) {
                view = this;
            }
            com.bytedance.sdk.component.adexpress.dynamic.animation.a.b bVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.a.b(view, this.m.j().e().ar());
            this.q = bVar;
            bVar.a();
        }
    }

    public void b() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.a.b bVar = this.q;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        h hVar = this.m;
        return hVar == null || hVar.j() == null || this.m.j().e() == null || this.m.j().e().ar() == null;
    }

    public int getDynamicWidth() {
        return this.g;
    }

    public int getDynamicHeight() {
        return this.h;
    }

    public f getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.b.e j2;
        h hVar = this.m;
        if (hVar == null || (j2 = hVar.j()) == null) {
            return null;
        }
        return j2.e();
    }
}
