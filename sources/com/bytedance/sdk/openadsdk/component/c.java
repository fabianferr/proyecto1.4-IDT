package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.a.b;
import com.bytedance.sdk.openadsdk.component.f;
import com.bytedance.sdk.openadsdk.component.view.ButtonFlash;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenBaseLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenHtmlLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenIconOnlyLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenOneLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenThreeLayout;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenTwoLayout;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.j;
import java.lang.ref.WeakReference;

/* compiled from: AppOpenAdNativeManager */
public class c {
    private static String w = "Skip";
    protected final Activity a;
    protected final q b;
    protected final boolean c;
    protected final FrameLayout d;
    protected final a e;
    protected final int f;
    protected int g;
    protected FrameLayout h;
    protected final com.bytedance.sdk.openadsdk.component.h.a i;
    private RelativeLayout j;
    private ImageView k;
    private TextView l;
    private ButtonFlash m;
    private ImageView n;
    private TTRoundRectImageView o;
    private PAGTextView p;
    private PAGTextView q;
    private float r;
    private float s;
    private final com.bytedance.sdk.openadsdk.component.view.a t = new com.bytedance.sdk.openadsdk.component.view.a();
    private TextView u;
    private TextView v;
    /* access modifiers changed from: private */
    public boolean x = false;
    private boolean y;
    private com.bytedance.sdk.openadsdk.component.h.c z;

    public int d() {
        return -1;
    }

    public c(Activity activity, q qVar, FrameLayout frameLayout, a aVar, int i2, boolean z2, com.bytedance.sdk.openadsdk.component.h.a aVar2) {
        this.a = activity;
        this.b = qVar;
        this.d = frameLayout;
        this.g = i2;
        this.c = z2;
        this.e = aVar;
        this.f = qVar.aZ();
        this.i = aVar2;
    }

    public void a(ViewGroup viewGroup) {
        try {
            w = s.a(o.a(), "tt_txt_skip");
        } catch (Throwable th) {
            l.e("AppOpenAdNativeManager", th.getMessage());
        }
        PAGAppOpenBaseLayout pAGAppOpenTwoLayout = new PAGAppOpenTwoLayout(this.a);
        int l2 = this.b.l();
        l.b("AppOpenAdNativeManager", "attachExpressView: splashLayoutId=" + l2);
        if (this.b.br()) {
            pAGAppOpenTwoLayout = new PAGAppOpenIconOnlyLayout(this.a);
        } else if (l2 == 1) {
            pAGAppOpenTwoLayout = new PAGAppOpenOneLayout(this.a);
        } else if (l2 == 3) {
            pAGAppOpenTwoLayout = new PAGAppOpenThreeLayout(this.a);
        } else if (l2 == 4) {
            pAGAppOpenTwoLayout = new PAGAppOpenHtmlLayout(this.a, this.b);
        }
        if (this.b.l() == 3 && this.g != 2) {
            this.g = 2;
            this.e.f();
        }
        this.j = pAGAppOpenTwoLayout;
        viewGroup.addView(pAGAppOpenTwoLayout);
        this.n = pAGAppOpenTwoLayout.getBackImage();
        this.h = pAGAppOpenTwoLayout.getVideoContainer();
        this.k = pAGAppOpenTwoLayout.getImageView();
        this.m = pAGAppOpenTwoLayout.getClickButton();
        this.l = pAGAppOpenTwoLayout.getAdLogo();
        if (this.b.br()) {
            this.o = pAGAppOpenTwoLayout.getIconOnlyView();
            this.p = pAGAppOpenTwoLayout.getTitle();
            this.q = pAGAppOpenTwoLayout.getContent();
        }
        if (pAGAppOpenTwoLayout.getDspAdChoice() != null) {
            pAGAppOpenTwoLayout.getDspAdChoice().a(14, this.b);
        }
        if (!this.b.av()) {
            this.t.a(pAGAppOpenTwoLayout, this.b, this.s, this.r, this.c);
        }
        this.u = pAGAppOpenTwoLayout.getTopDisLike();
        this.v = pAGAppOpenTwoLayout.getTopSkip();
        if (pAGAppOpenTwoLayout instanceof PAGAppOpenHtmlLayout) {
            ((PAGAppOpenHtmlLayout) pAGAppOpenTwoLayout).setRenderListener(new PAGAppOpenHtmlLayout.a() {
                public void a() {
                }

                public void b() {
                }

                public void a(View view, int i) {
                    c.this.e.e();
                }
            });
        }
    }

    public void a() {
        this.l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(c.this.a, c.this.b, "open_ad");
                } catch (Throwable th) {
                    l.e("AppOpenAdNativeManager", th.getMessage());
                }
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (c.this.e != null) {
                    c.this.e.b(view);
                }
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (c.this.e != null && c.this.x) {
                    c.this.e.a(view);
                }
            }
        });
        if (!this.b.av()) {
            com.bytedance.sdk.openadsdk.component.a.a a2 = b.a(this.b, this.a, this.i);
            a2.a((b.a) new b.a() {
                public void a(View view, int i) {
                    c.this.e.e();
                }
            });
            a2.a((a.C0061a) this.z);
            if (this.b.k() == 1) {
                this.j.setOnClickListener(a2);
                this.j.setOnTouchListener(a2);
            }
            this.m.setOnClickListener(a2);
            this.m.setOnTouchListener(a2);
        }
    }

    public void b() {
        this.y = com.bytedance.sdk.openadsdk.core.settings.o.ai().v(String.valueOf(this.f));
        if (!this.b.av()) {
            f();
        } else {
            this.e.c();
        }
    }

    private void f() {
        this.t.a();
        this.m.setText(this.b.X());
        if (this.b.br()) {
            g();
        } else if (this.c) {
            b(0);
            a(8);
            if (a(this.h)) {
                this.e.c();
            } else {
                this.e.d();
            }
            f.a(this.b, (f.d) new a(this.a), 25);
        } else {
            b(8);
            a(0);
            h();
            this.e.c();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.h.c cVar = new com.bytedance.sdk.openadsdk.component.h.c(this.a);
        this.z = cVar;
        cVar.a(frameLayout, this.b);
        this.z.a((c.a) this.e);
        try {
            return this.z.a();
        } catch (Throwable th) {
            l.d("AppOpenAdNativeManager", "open_ad", "ttAppOpenAd playVideo error: " + th.getMessage());
            return false;
        }
    }

    private void b(int i2) {
        ad.a((View) this.h, i2);
    }

    private void g() {
        PAGTextView pAGTextView = this.p;
        if (pAGTextView != null) {
            pAGTextView.setText(this.b.V());
        }
        PAGTextView pAGTextView2 = this.q;
        if (pAGTextView2 != null) {
            pAGTextView2.setText(this.b.W());
        }
        if (!(this.o == null || this.b.N() == null || TextUtils.isEmpty(this.b.N().a()))) {
            com.bytedance.sdk.openadsdk.k.c.a().a(this.b.N().a(), this.b.N().b(), this.b.N().c(), this.o, this.b);
        }
        this.e.c();
    }

    private void h() {
        n nVar = this.b.Q().get(0);
        j.a(new com.bytedance.sdk.openadsdk.k.a(nVar.a(), nVar.g()), nVar.b(), nVar.c(), new j.a() {
            public void a() {
            }

            public void b() {
            }

            public void a(com.bytedance.sdk.openadsdk.k.a.b bVar) {
                if (bVar.d()) {
                    c.this.a(bVar);
                    if (bVar.b() != null) {
                        c.this.a(bVar.a());
                    }
                }
            }
        }, com.bytedance.sdk.openadsdk.component.g.a.b(TextUtils.isEmpty(nVar.g()) ? e.a(nVar.a()) : nVar.g()).getParent(), 25);
    }

    /* access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.n.setImageDrawable(new BitmapDrawable(o.a().getResources(), bitmap));
            } catch (Throwable unused) {
                l.d("AppOpenAdNativeManager", "open_ad", "bindBackGroundImage error");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.k.a.b bVar) {
        if (bVar.b() != null) {
            this.k.setImageBitmap(bVar.b());
        } else if (this.b.Q() != null && this.b.Q().get(0) != null) {
            Drawable a2 = j.a(bVar.c(), this.b.Q().get(0).b());
            this.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.k.setImageDrawable(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        ad.a((View) this.k, i2);
    }

    /* compiled from: AppOpenAdNativeManager */
    public class a implements f.d {
        WeakReference<Activity> a;

        public void a() {
        }

        a(Activity activity) {
            this.a = new WeakReference<>(activity);
        }

        public void a(Bitmap bitmap) {
            if (this.a.get() != null && !((Activity) this.a.get()).isFinishing()) {
                c.this.a(bitmap);
            }
        }
    }

    public void a(float f2, float f3) {
        this.s = f2;
        this.r = f3;
    }

    public void a(int i2, int i3, boolean z2) {
        if (this.v != null) {
            String valueOf = String.valueOf(i2);
            if (z2) {
                this.x = z2;
                if (this.y) {
                    valueOf = w;
                } else {
                    valueOf = valueOf + " | " + w;
                }
            }
            this.v.setText(valueOf);
        }
    }

    public com.bytedance.sdk.openadsdk.component.h.c e() {
        return this.z;
    }

    public void c() {
        ButtonFlash buttonFlash = this.m;
        if (buttonFlash != null) {
            buttonFlash.a();
        }
        com.bytedance.sdk.openadsdk.component.h.c cVar = this.z;
        if (cVar != null) {
            cVar.f();
        }
    }
}
