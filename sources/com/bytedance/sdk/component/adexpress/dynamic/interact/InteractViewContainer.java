package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.a;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.b;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.c;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.d;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.e;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.f;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.utils.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public class InteractViewContainer extends FrameLayout implements g {
    private Context a;
    private DynamicBaseWidget b;
    private g c;
    private View d;
    private f e;
    private String f;
    /* access modifiers changed from: private */
    public RippleView g;
    private View.OnTouchListener h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private DynamicBrushMaskView n;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        super(context);
        this.a = context;
        this.b = dynamicBaseWidget;
        this.c = gVar;
        f();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, int i2, int i3, int i4, int i5) {
        super(context);
        this.a = context;
        this.b = dynamicBaseWidget;
        this.c = gVar;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        f();
    }

    private void f() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.f = this.c.K();
        this.i = this.c.M();
        f a2 = h.a(this.a, this.b, this.c, this.j, this.k, this.l, this.m);
        this.e = a2;
        if (a2 != null) {
            this.d = a2.d();
            if (TextUtils.equals(this.f, "6")) {
                if (!this.c.V() || TextUtils.isEmpty(this.c.W())) {
                    this.g = new RippleView(this.a, Color.parseColor("#99000000"));
                } else {
                    this.g = new RippleView(this.a, g.a(this.c.W()));
                }
                FrameLayout frameLayout = new FrameLayout(this.a);
                frameLayout.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() {
                    public void run() {
                        InteractViewContainer.this.g.b();
                    }
                });
            }
            if (TextUtils.equals(this.f, "20")) {
                this.n = (DynamicBrushMaskView) this.e.d();
            }
            addView(this.e.d());
            a(this.e.d());
            setVisibility(0);
        }
    }

    private void a(ViewGroup viewGroup) {
        if (this.d != null) {
            String str = this.f;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals(CampaignEx.CLICKMODE_ON)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 56:
                    if (str.equals("8")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 57:
                    if (str.equals("9")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals("10")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1568:
                    if (str.equals("11")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 1569:
                    if (str.equals("12")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 1570:
                    if (str.equals("13")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case 1571:
                    if (str.equals("14")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 1573:
                    if (str.equals("16")) {
                        c2 = 12;
                        break;
                    }
                    break;
                case 1574:
                    if (str.equals("17")) {
                        c2 = 13;
                        break;
                    }
                    break;
                case 1575:
                    if (str.equals("18")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 1598:
                    if (str.equals("20")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case 1600:
                    if (str.equals("22")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case 1602:
                    if (str.equals("24")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case 1607:
                    if (str.equals("29")) {
                        c2 = 18;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.h = new d(this, this.i);
                    setBackgroundColor(Color.parseColor("#80000000"));
                    break;
                case 1:
                case 4:
                    setBackgroundColor(Color.parseColor("#80000000"));
                    this.h = new b(this, this);
                    break;
                case 2:
                    if (!this.c.V() || TextUtils.isEmpty(this.c.W())) {
                        setBackgroundColor(Color.parseColor("#80000000"));
                    } else {
                        setBackgroundColor(g.a(this.c.W()));
                    }
                    this.h = new c(this);
                    break;
                case 3:
                    if (!this.c.V() || TextUtils.isEmpty(this.c.W())) {
                        setBackgroundColor(Color.parseColor("#80000000"));
                    }
                    this.h = new e(this);
                    break;
                case 5:
                case 8:
                    this.b.setClipChildren(false);
                    this.b.setClipChildren(false);
                    ViewGroup viewGroup2 = (ViewGroup) this.b.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.setClipChildren(false);
                        viewGroup2.setClipToPadding(false);
                    }
                    this.h = new e(this);
                    break;
                case 6:
                case 13:
                    this.d.setTag(2);
                    break;
                case 7:
                case 10:
                case 17:
                    this.h = new d(this, this.i);
                    break;
                case 9:
                    this.h = new c(this);
                    break;
                case 11:
                    this.h = new b(this, this);
                    break;
                case 12:
                    View view = this.d;
                    if (!(view == null || !(view instanceof ShakeAnimationView) || ((ShakeAnimationView) view).getShakeLayout() == null)) {
                        ((ShakeAnimationView) this.d).getShakeLayout().setTag(2);
                    }
                    this.d.setTag(2);
                    break;
                case 14:
                    View view2 = this.d;
                    if (!(view2 == null || !(view2 instanceof WriggleGuideAnimationView) || ((WriggleGuideAnimationView) view2).getWriggleLayout() == null)) {
                        ((WriggleGuideAnimationView) this.d).getWriggleLayout().setTag(2);
                    }
                    this.d.setTag(2);
                    break;
                case 15:
                    this.h = new a(this, this.i, viewGroup);
                    break;
                case 16:
                    if (!com.bytedance.sdk.component.adexpress.d.b()) {
                        this.h = new f(this, this.i, viewGroup);
                        break;
                    } else {
                        this.h = new d(this, this.i);
                        break;
                    }
                case 18:
                    View view3 = this.d;
                    if (!(view3 == null || !(view3 instanceof ClickSlideUpShakeView) || ((ClickSlideUpShakeView) view3).getShakeView() == null)) {
                        ((ClickSlideUpShakeView) this.d).getShakeView().setTag(2);
                    }
                    this.h = new d(this, this.i);
                    break;
            }
            View.OnTouchListener onTouchListener = this.h;
            if (onTouchListener != null) {
                setOnTouchListener(onTouchListener);
            }
            if (g()) {
                setOnClickListener((View.OnClickListener) this.b.getDynamicClickListener());
            }
        }
    }

    private boolean g() {
        if (!this.c.U() && !TextUtils.equals("9", this.f) && !TextUtils.equals("16", this.f) && !TextUtils.equals("17", this.f) && !TextUtils.equals("18", this.f) && !TextUtils.equals("20", this.f) && !TextUtils.equals("29", this.f) && !TextUtils.equals("10", this.f)) {
            return true;
        }
        return false;
    }

    public void b() {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a();
        }
    }

    public void c() {
        f fVar = this.e;
        if (fVar != null) {
            fVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            f fVar = this.e;
            if (fVar != null) {
                fVar.b();
            }
        } catch (Exception e2) {
            l.d(e2.getMessage());
        }
    }

    public void d() {
        if (this.d != null && TextUtils.equals(this.f, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).c();
            }
        }
    }

    public void e() {
        if (this.d != null && TextUtils.equals(this.f, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).d();
            }
        }
    }

    public void a() {
        if (TextUtils.equals(this.f, "6")) {
            RippleView rippleView = this.g;
            if (rippleView != null) {
                rippleView.c();
                postDelayed(new Runnable() {
                    public void run() {
                        InteractViewContainer.this.h();
                    }
                }, 300);
            }
        } else if (TextUtils.equals(this.f, "20")) {
            DynamicBrushMaskView dynamicBrushMaskView = this.n;
            if (dynamicBrushMaskView != null) {
                dynamicBrushMaskView.b();
                postDelayed(new Runnable() {
                    public void run() {
                        InteractViewContainer.this.h();
                    }
                }, 400);
            }
        } else {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.h != null) {
            setOnClickListener((View.OnClickListener) this.b.getDynamicClickListener());
            performClick();
            setVisibility(8);
        }
    }
}
