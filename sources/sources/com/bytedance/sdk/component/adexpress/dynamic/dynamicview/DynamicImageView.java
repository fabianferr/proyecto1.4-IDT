package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.c.e;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.utils.s;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicImageView extends DynamicBaseWidgetImp {
    private String a;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        if (this.l.o() > 0.0f) {
            this.o = new TTRoundRectImageView(context);
            ((TTRoundRectImageView) this.o).setXRound((int) e.a(context, this.l.o()));
            ((TTRoundRectImageView) this.o).setYRound((int) e.a(context, this.l.o()));
        } else if (h() || !"arrowButton".equals(hVar.j().b())) {
            this.o = new ImageView(context);
        } else {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.l);
            this.o = animationImageView;
        }
        this.a = getImageKey();
        this.o.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(hVar.j().b())) {
            if (this.l.b() > 0 || this.l.a() > 0) {
                this.g = Math.min(this.g, this.h);
                this.h = Math.min(this.g, this.h);
                this.i = (int) (((float) this.i) + e.a(context, ((float) (this.l.b() + (this.l.a() / 2))) + 0.5f));
            } else {
                this.g = Math.max(this.g, this.h);
                this.h = Math.max(this.g, this.h);
            }
            this.l.a((float) (this.g / 2));
        }
        addView(this.o, new FrameLayout.LayoutParams(this.g, this.h));
    }

    public boolean i() {
        super.i();
        if ("arrowButton".equals(this.m.j().b())) {
            ((ImageView) this.o).setImageResource(s.d(this.k, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.o).getDrawable() != null) {
                ((ImageView) this.o).getDrawable().setAutoMirrored(true);
            }
            this.o.setPadding(0, 0, 0, 0);
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.o.setBackgroundColor(this.l.y());
        String c = this.m.j().c();
        if ("user".equals(c)) {
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.o).setColorFilter(this.l.g());
            ((ImageView) this.o).setImageDrawable(s.c(getContext(), "tt_user"));
            ((ImageView) this.o).setPadding(this.g / 10, this.h / 5, this.g / 10, 0);
        } else if (c != null && c.startsWith("@")) {
            try {
                ((ImageView) this.o).setImageResource(Integer.parseInt(c.substring(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        j a2 = a.a().e().a(this.l.k()).a(this.a);
        String n = this.n.getRenderRequest().n();
        if (!TextUtils.isEmpty(n)) {
            a2.b(n);
        }
        if (!d.b()) {
            a2.a((ImageView) this.o);
        }
        if (a()) {
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.FIT_CENTER);
            a.a().e().a(this.l.k()).a(u.BITMAP).a((com.bytedance.sdk.component.d.h) new com.bytedance.sdk.component.d.h() {
                public Bitmap a(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.c.a.a(DynamicImageView.this.k, bitmap, 25);
                }
            }).a((o) new o<Bitmap>() {
                public void a(int i, String str, Throwable th) {
                }

                public void a(k<Bitmap> kVar) {
                    Bitmap b = kVar.b();
                    if (b != null && kVar.c() != null) {
                        DynamicImageView.this.o.setBackground(new BitmapDrawable(DynamicImageView.this.getResources(), b));
                    }
                }
            });
        } else {
            if (d.b()) {
                a2.a((ImageView) this.o);
            }
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.o instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return true;
    }

    private boolean a() {
        String l = this.l.l();
        if (this.l.t()) {
            return true;
        }
        if (TextUtils.isEmpty(l)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(l);
            if (Math.abs((((float) this.g) / (((float) this.h) * 1.0f)) - (((float) jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) / (((float) jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) * 1.0f))) <= 0.01f) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getImageKey() {
        Map<String, String> k = this.n.getRenderRequest().k();
        if (k == null || k.size() <= 0) {
            return null;
        }
        return k.get(this.l.k());
    }
}
