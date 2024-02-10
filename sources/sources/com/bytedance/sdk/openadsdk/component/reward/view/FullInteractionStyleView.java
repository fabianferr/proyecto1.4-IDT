package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.k.c;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle001001Layout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle002003HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle002003Layout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle003002HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle003002Layout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle009016HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle009016VLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle016009HLayout;
import com.bytedance.sdk.openadsdk.layout.TTInteractionStyle016009VLayout;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.com.bytedance.overseas.sdk.a.b;
import java.util.List;

public class FullInteractionStyleView extends BackupView {
    private float a;
    private boolean m;
    private int n;
    private int o;
    private int p = 1;
    private View q;
    private View r;
    private FrameLayout s;
    private e t;

    /* access modifiers changed from: protected */
    public void a(View view, int i, m mVar) {
    }

    public View getInteractionStyleRootView() {
        return this;
    }

    public FullInteractionStyleView(Context context, String str) {
        super(context, str);
        this.b = context;
    }

    public void a(q qVar, float f, int i, int i2, int i3) {
        this.a = f;
        this.p = i;
        this.c = qVar;
        this.f = "fullscreen_interstitial_ad";
        this.n = i2;
        this.o = i3;
        a(this.i);
        b();
    }

    private void b() {
        this.g = ad.b(this.b, (float) this.n);
        this.h = ad.b(this.b, (float) this.o);
        int i = (int) (this.a * 1000.0f);
        if (this.p == 1) {
            if (i == 666) {
                e();
            } else if (i == 1000) {
                c();
            } else if (i == 1500) {
                k();
            } else if (i != 1777) {
                a(0.562f);
                l();
            } else {
                m();
            }
        } else if (i == 562) {
            i();
        } else if (i == 666) {
            g();
        } else if (i == 1000) {
            c();
        } else if (i != 1500) {
            a(1.777f);
            j();
        } else {
            h();
        }
    }

    private void c() {
        TTInteractionStyle001001Layout tTInteractionStyle001001Layout = new TTInteractionStyle001001Layout(this.b);
        this.q = tTInteractionStyle001001Layout;
        b((View) tTInteractionStyle001001Layout);
        d();
        f();
    }

    private void b(View view) {
        if (view.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(view);
        }
    }

    private void d() {
        this.s = (FrameLayout) this.q.findViewById(i.aA);
        ImageView imageView = (ImageView) this.q.findViewById(i.az);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) this.q.findViewById(i.as);
        TextView textView = (TextView) this.q.findViewById(i.ax);
        TextView textView2 = (TextView) this.q.findViewById(i.at);
        ImageView imageView2 = (ImageView) this.q.findViewById(520093739);
        if (!TextUtils.isEmpty(this.c.X())) {
            textView2.setText(this.c.X());
        }
        a(this.s, imageView);
        if (this.c.N() != null && !TextUtils.isEmpty(this.c.N().a())) {
            c.a().a(this.c.N().a(), this.c.N().b(), this.c.N().c(), tTRoundRectImageView, this.c);
        }
        textView.setText(getTitle());
        c((View) this.s);
        c((View) imageView);
        c((View) tTRoundRectImageView);
        c((View) textView);
        c((View) textView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(FullInteractionStyleView.this.b, FullInteractionStyleView.this.c, FullInteractionStyleView.this.f);
                } catch (Throwable th) {
                    l.e("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void e() {
        TTInteractionStyle002003Layout tTInteractionStyle002003Layout = new TTInteractionStyle002003Layout(this.b);
        this.q = tTInteractionStyle002003Layout;
        b((View) tTInteractionStyle002003Layout);
        d();
        f();
    }

    private void f() {
        TextView textView = (TextView) this.q.findViewById(i.ay);
        if (textView != null) {
            textView.setText(getDescription());
            c((View) textView);
        }
    }

    private void g() {
        TTInteractionStyle002003HLayout tTInteractionStyle002003HLayout = new TTInteractionStyle002003HLayout(this.b);
        this.q = tTInteractionStyle002003HLayout;
        b((View) tTInteractionStyle002003HLayout);
        d();
        f();
    }

    private void h() {
        TTInteractionStyle003002HLayout tTInteractionStyle003002HLayout = new TTInteractionStyle003002HLayout(this.b);
        this.q = tTInteractionStyle003002HLayout;
        b((View) tTInteractionStyle003002HLayout);
        d();
    }

    private void i() {
        TTInteractionStyle009016HLayout tTInteractionStyle009016HLayout = new TTInteractionStyle009016HLayout(this.b);
        this.q = tTInteractionStyle009016HLayout;
        b((View) tTInteractionStyle009016HLayout);
        d();
        f();
    }

    private void j() {
        TTInteractionStyle016009HLayout tTInteractionStyle016009HLayout = new TTInteractionStyle016009HLayout(this.b);
        this.q = tTInteractionStyle016009HLayout;
        b((View) tTInteractionStyle016009HLayout);
        d();
    }

    private void k() {
        TTInteractionStyle003002Layout tTInteractionStyle003002Layout = new TTInteractionStyle003002Layout(this.b);
        this.q = tTInteractionStyle003002Layout;
        b((View) tTInteractionStyle003002Layout);
        this.s = (FrameLayout) this.q.findViewById(i.aA);
        ImageView imageView = (ImageView) this.q.findViewById(i.aB);
        TextView textView = (TextView) this.q.findViewById(i.aC);
        a(this.s, imageView);
        textView.setText(getDescription());
        c((View) this.s);
        c((View) imageView);
        c((View) textView);
        ((ImageView) this.q.findViewById(520093739)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(FullInteractionStyleView.this.b, FullInteractionStyleView.this.c, FullInteractionStyleView.this.f);
                } catch (Throwable th) {
                    l.e("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void a(FrameLayout frameLayout, ImageView imageView) {
        if (this.c != null) {
            boolean c = q.c(this.c);
            if (this.c.K() == null || !c) {
                a(imageView);
                ad.a((View) imageView, 0);
                ad.a((View) frameLayout, 8);
                return;
            }
            ad.a((View) imageView, 8);
            ad.a((View) frameLayout, 0);
        }
    }

    private void a(ImageView imageView) {
        List<n> Q;
        n nVar;
        if (this.c != null && (Q = this.c.Q()) != null && Q.size() > 0 && (nVar = Q.get(0)) != null) {
            d.a(nVar).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.f.c.a(this.c, nVar.a(), imageView));
        }
    }

    private void l() {
        TTInteractionStyle009016VLayout tTInteractionStyle009016VLayout = new TTInteractionStyle009016VLayout(this.b);
        this.q = tTInteractionStyle009016VLayout;
        b((View) tTInteractionStyle009016VLayout);
        d();
    }

    private void m() {
        TTInteractionStyle016009VLayout tTInteractionStyle016009VLayout = new TTInteractionStyle016009VLayout(this.b);
        this.q = tTInteractionStyle016009VLayout;
        b((View) tTInteractionStyle016009VLayout);
        d();
        f();
    }

    private void c(View view) {
        if (view != null) {
            a aVar = this.t;
            if (aVar == null) {
                aVar = new a(this.b, this.c, this.f, ac.a(this.f));
                aVar.a(a(this.c, this.b));
            }
            view.setOnTouchListener(aVar);
            view.setOnClickListener(aVar);
        }
    }

    private com.com.bytedance.overseas.sdk.a.c a(q qVar, Context context) {
        if (qVar != null && qVar.M() == 4) {
            return new b(context, qVar, this.f);
        }
        return null;
    }

    public void setIsMute(boolean z) {
        this.m = z;
        View view = this.r;
        if (view != null && (view instanceof NativeVideoTsView)) {
            ((NativeVideoTsView) view).setIsQuiet(z);
        }
    }

    public FrameLayout getVideoContainer() {
        return this.s;
    }

    public void setDownloadListener(e eVar) {
        this.t = eVar;
    }

    private float getHeightDp() {
        return (float) ad.c(this.b, (float) ad.i(this.b));
    }

    private float getWidthDp() {
        return (float) ad.c(this.b, (float) ad.j(this.b));
    }

    private void a(float f) {
        float f2;
        float f3;
        int i;
        int i2;
        int i3;
        float heightDp = getHeightDp();
        float widthDp = getWidthDp();
        if (this.p == 2) {
            f2 = Math.max(heightDp, widthDp);
            f3 = Math.min(heightDp, widthDp);
        } else {
            f2 = Math.min(heightDp, widthDp);
            f3 = Math.max(heightDp, widthDp);
        }
        if (this.p != 2 && ad.c((Activity) this.b)) {
            f3 -= (float) ad.c(this.b, ad.a());
        }
        int i4 = 20;
        if (this.p != 2) {
            if (!(f == 0.0f || f == 100.0f)) {
                float f4 = (float) 20;
                i = (int) Math.max((f3 - (((f2 - f4) - f4) / f)) / 2.0f, 0.0f);
                i4 = i;
                i3 = 20;
                i2 = 20;
                int b = ad.b(this.b, (float) i4);
                int b2 = ad.b(this.b, (float) i);
                ((Activity) this.b).getWindow().getDecorView().setPadding(ad.b(this.b, (float) i3), b, ad.b(this.b, (float) i2), b2);
            }
        } else if (!(f == 0.0f || f == 100.0f)) {
            float f5 = (float) 20;
            i3 = (int) Math.max((f2 - (((f3 - f5) - f5) * f)) / 2.0f, 0.0f);
            i2 = i3;
            i = 20;
            int b3 = ad.b(this.b, (float) i4);
            int b22 = ad.b(this.b, (float) i);
            ((Activity) this.b).getWindow().getDecorView().setPadding(ad.b(this.b, (float) i3), b3, ad.b(this.b, (float) i2), b22);
        }
        i4 = 0;
        i = 0;
        i3 = 0;
        i2 = 0;
        int b32 = ad.b(this.b, (float) i4);
        int b222 = ad.b(this.b, (float) i);
        ((Activity) this.b).getWindow().getDecorView().setPadding(ad.b(this.b, (float) i3), b32, ad.b(this.b, (float) i2), b222);
    }
}
