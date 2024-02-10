package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.u;
import java.util.ArrayList;
import org.json.JSONArray;

public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String b = "";
    private Runnable a;
    protected InteractViewContainer s;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        String b2 = hVar.j().b();
        if ("logo-union".equals(b2)) {
            dynamicRootView.setLogoUnionHeight(this.h - ((int) e.a(context, (float) (this.l.b() + this.l.a()))));
        } else if ("scoreCountWithIcon".equals(b2)) {
            dynamicRootView.setScoreCountWithIcon(this.h - ((int) e.a(context, (float) (this.l.b() + this.l.a()))));
        }
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.g, this.h);
    }

    public boolean i() {
        Drawable backgroundDrawable;
        final View view = this.o == null ? this : this.o;
        setContentDescription(this.m.a(this.l.x()));
        String u = this.l.u();
        if (this.l.t()) {
            final int s2 = this.l.s();
            a.a().e().a(this.l.b).a(u.BITMAP).a((com.bytedance.sdk.component.d.h) new com.bytedance.sdk.component.d.h() {
                public Bitmap a(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.c.a.a(DynamicBaseWidgetImp.this.k, bitmap, s2);
                }
            }).a((o) new o<Bitmap>() {
                public void a(int i, String str, Throwable th) {
                }

                public void a(k<Bitmap> kVar) {
                    Bitmap b2 = kVar.b();
                    if (b2 != null && kVar.c() != null) {
                        view.setBackground(DynamicBaseWidgetImp.this.a(b2));
                    }
                }
            });
        } else if (!TextUtils.isEmpty(u)) {
            if (!u.startsWith("http:")) {
                u = com.bytedance.sdk.component.adexpress.dynamic.c.h.b(u);
            }
            j a2 = a.a().e().a(u).a(u.BITMAP);
            a(a2);
            a2.a((o) new o<Bitmap>() {
                public void a(int i, String str, Throwable th) {
                }

                public void a(k<Bitmap> kVar) {
                    view.setBackground(new BitmapDrawable(kVar.b()));
                    if (DynamicBaseWidgetImp.this.m != null && DynamicBaseWidgetImp.this.m.j() != null && 6 == DynamicBaseWidgetImp.this.m.j().a() && view.getBackground() != null) {
                        view.getBackground().setAutoMirrored(true);
                    }
                }
            });
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.l.z() > 0.0d) {
            postDelayed(new Runnable() {
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.l.E() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable a2 = dynamicBaseWidgetImp.b(dynamicBaseWidgetImp.n.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.l.E())));
                            if (a2 == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                a2 = dynamicBaseWidgetImp2.a(true, dynamicBaseWidgetImp2.n.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.l.E())));
                            }
                            if (a2 != null) {
                                view.setBackground(a2);
                                return;
                            }
                            View view = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view.setBackground(dynamicBaseWidgetImp3.a(true, dynamicBaseWidgetImp3.n.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.l.z() * 1000.0d));
        }
        if (this.o != null) {
            this.o.setPadding((int) e.a(this.k, (float) this.l.c()), (int) e.a(this.k, (float) this.l.b()), (int) e.a(this.k, (float) this.l.d()), (int) e.a(this.k, (float) this.l.a()));
        }
        if (this.p || this.l.n() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public Drawable b(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    str2 = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = g.a(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable a2 = a(a(str2), iArr);
            a2.setShape(0);
            a2.setCornerRadius(e.a(this.k, this.l.o()));
            return a2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(j jVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            jVar.a(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            b = com.bytedance.sdk.component.utils.u.a();
        } catch (Throwable unused) {
            b = Build.MODEL;
        }
        if (TextUtils.isEmpty(b)) {
            b = Build.MODEL;
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        final View view = this.o == null ? this : this.o;
        double t = this.m.j().e().t();
        if (t < 90.0d && t > 0.0d) {
            com.bytedance.sdk.component.utils.h.b().postDelayed(new Runnable() {
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (t * 1000.0d));
        }
        double s2 = this.m.j().e().s();
        if (s2 > 0.0d) {
            com.bytedance.sdk.component.utils.h.b().postDelayed(new Runnable() {
                public void run() {
                    if (DynamicBaseWidgetImp.this.m.j().e().ar() == null) {
                        view.setVisibility(0);
                        DynamicBaseWidgetImp.this.setVisibility(0);
                    }
                }
            }, (long) (s2 * 1000.0d));
        }
        if (!TextUtils.isEmpty(this.l.K())) {
            a();
        }
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.a);
    }

    private void a() {
        int O = this.l.O();
        int P = this.l.P();
        AnonymousClass7 r2 = new Runnable() {
            public void run() {
                if (DynamicBaseWidgetImp.this.n == null || DynamicBaseWidgetImp.this.n.getRenderRequest() == null) {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    Context context = DynamicBaseWidgetImp.this.k;
                    DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp.s = new InteractViewContainer(context, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.l);
                } else {
                    m renderRequest = DynamicBaseWidgetImp.this.n.getRenderRequest();
                    int o = renderRequest.o();
                    int p = renderRequest.p();
                    int q = renderRequest.q();
                    int r = renderRequest.r();
                    DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                    Context context2 = DynamicBaseWidgetImp.this.k;
                    DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp3.s = new InteractViewContainer(context2, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.l, o, p, q, r);
                }
                DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp5.b((View) dynamicBaseWidgetImp5.s);
                if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                    ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                }
                DynamicBaseWidgetImp.this.setClipChildren(false);
                DynamicBaseWidgetImp.this.s.setTag(2);
                DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp6.addView(dynamicBaseWidgetImp6.s, new FrameLayout.LayoutParams(-1, -1));
                DynamicBaseWidgetImp.this.s.b();
            }
        };
        this.a = r2;
        postDelayed(r2, ((long) O) * 1000);
        if (!this.l.Q() && P < Integer.MAX_VALUE && O < P) {
            postDelayed(new Runnable() {
                public void run() {
                    if (DynamicBaseWidgetImp.this.s != null) {
                        DynamicBaseWidgetImp.this.s.c();
                        DynamicBaseWidgetImp.this.s.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.removeView(dynamicBaseWidgetImp.s);
                    }
                }
            }, ((long) P) * 1000);
        }
    }
}
