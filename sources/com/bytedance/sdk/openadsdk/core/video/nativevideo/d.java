package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.a.e.a;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: NativeVideoDetailLayout */
public class d extends e {
    private TextView G;
    private ImageView H;
    private View I;
    private TextView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private View N;
    private ImageView O;
    private TextView P;
    private View Q;
    private SeekBar R;
    private TextView S;
    private TextView T;
    private ImageView U;
    private final x V = new x(this);
    /* access modifiers changed from: private */
    public boolean W = false;
    private boolean X = false;
    private int Y = 0;
    private int Z = 0;
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private final Rect ad = new Rect();
    private ColorStateList ae;
    private float af;
    private final Rect ag = new Rect();
    private int ah = 0;
    private final int ai;
    private final int aj;
    private final com.bytedance.sdk.openadsdk.core.widget.d ak;
    private final View.OnTouchListener al = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 2) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            } else if (actionMasked == 3) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    };
    private float am;
    private ColorStateList an;
    private float ao;
    private final Rect ap = new Rect();
    private float aq;
    private ColorStateList ar;
    private float as;
    private final Rect at = new Rect();
    private final Rect au = new Rect();

    public d(Context context, ViewGroup viewGroup, boolean z, int i, q qVar, c cVar, boolean z2) {
        super(context, viewGroup, z, i, qVar, cVar, z2);
        this.x = o.a().getApplicationContext();
        d(z2);
        this.a = viewGroup;
        this.s = z;
        com.bytedance.sdk.openadsdk.core.widget.d dVar = new com.bytedance.sdk.openadsdk.core.widget.d(this);
        this.ak = dVar;
        dVar.a(this.s);
        DisplayMetrics displayMetrics = this.x.getResources().getDisplayMetrics();
        this.ai = displayMetrics.widthPixels;
        this.aj = displayMetrics.heightPixels;
        this.v = i;
        this.C = cVar;
        this.w = qVar;
        d(8);
        a(context, (View) this.a);
        d();
        l();
    }

    /* access modifiers changed from: protected */
    public void a(Context context, View view) {
        super.a(context, view);
        this.G = (TextView) view.findViewById(i.aZ);
        this.H = (ImageView) view.findViewById(i.aN);
        this.I = view.findViewById(i.aP);
        this.M = (ImageView) view.findViewById(i.aQ);
        this.J = (TextView) view.findViewById(i.aO);
        this.K = (TextView) view.findViewById(i.aR);
        this.L = (TextView) view.findViewById(i.aT);
        this.N = view.findViewById(i.aK);
        this.O = (ImageView) view.findViewById(i.aL);
        TextView textView = (TextView) view.findViewById(i.aM);
        this.P = textView;
        textView.setText(s.a(context, "tt_video_retry_des_txt"));
        this.R = (SeekBar) view.findViewById(i.aW);
        this.S = (TextView) view.findViewById(i.aX);
        this.T = (TextView) view.findViewById(i.aV);
        this.Q = view.findViewById(i.aU);
        this.U = (ImageView) view.findViewById(i.aY);
        this.g = view.findViewById(i.aD);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.ak.a((View) this.a);
        int i = 8;
        ad.a((View) this.H, (this.s || (this.v & 1) == 1) ? 8 : 0);
        this.H.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.p()) {
                    d.this.z.c(d.this, view);
                }
            }
        });
        TextView textView = this.G;
        if (!this.s || (this.v & 2) == 2) {
            i = 0;
        }
        ad.a((View) textView, i);
        this.G.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.p()) {
                    d.this.z.d(d.this, view);
                }
            }
        });
        this.M.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.p()) {
                    d.this.z.e(d.this, view);
                }
            }
        });
        this.O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.this.b(false, true);
                d.this.h();
                d.this.g();
                if (d.this.p()) {
                    d.this.z.f(d.this, view);
                }
            }
        });
        this.U.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.p()) {
                    d.this.z.b((b) d.this, view);
                }
            }
        });
        this.R.setThumbOffset(0);
        this.R.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!d.this.W && d.this.x != null) {
                    seekBar.setThumb(s.c(o.a(), "tt_seek_thumb_normal"));
                }
                if (d.this.p()) {
                    seekBar.setThumbOffset(0);
                    d.this.z.a((b) d.this, seekBar.getProgress());
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!d.this.W && d.this.x != null) {
                    seekBar.setThumb(s.c(o.a(), "tt_seek_thumb_press"));
                }
                if (d.this.p()) {
                    seekBar.setThumbOffset(0);
                    d.this.z.b((b) d.this, seekBar.getProgress());
                }
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (d.this.p()) {
                    d.this.z.a(d.this, i, z);
                }
            }
        });
        this.R.setOnTouchListener(this.al);
    }

    public void e() {
        this.V.removeMessages(1);
        this.V.sendMessageDelayed(this.V.obtainMessage(1), 2000);
    }

    public void f() {
        this.V.removeMessages(1);
    }

    public void b(boolean z) {
        int i = j() ? this.aj : this.o;
        int i2 = j() ? this.ai : this.p;
        if (this.r > 0 && this.q > 0 && i > 0) {
            if (!u() && !j() && (this.v & 8) != 8) {
                i2 = this.x.getResources().getDimensionPixelSize(s.g(this.x, "tt_video_container_maxheight"));
            }
            int i3 = (int) (((float) this.r) * ((((float) i) * 1.0f) / ((float) this.q)));
            if (i3 > i2) {
                i = (int) (((float) this.q) * ((((float) i2) * 1.0f) / ((float) this.r)));
            } else {
                i2 = i3;
            }
            if (!z && !j()) {
                i = this.o;
                i2 = this.p;
            }
            this.b.a(i, i2);
        }
    }

    public void a(String str) {
        TextView textView = this.J;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.K;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public void a(int i) {
        View view = this.Q;
        if (view == null || view.getVisibility() != 0) {
            this.R.setProgress(i);
        }
    }

    public void a(long j, long j2) {
        this.S.setText(a.a(j2));
        this.T.setText(a.a(j));
        this.R.setProgress(a.a(j, j2));
    }

    public void g() {
        ad.f(this.d);
        ad.f(this.e);
        ad.e(this.N);
        if (!(this.f == null || this.w == null || this.w.K() == null || this.w.K().j() == null)) {
            ad.f((View) this.f);
            com.bytedance.sdk.openadsdk.k.c.a().a(this.w.K().j(), this.w.K().c(), this.w.K().b(), this.f, this.w);
        }
        if (this.c.getVisibility() == 0) {
            ad.a((View) this.c, 8);
        }
    }

    public void a() {
        a(false, this.s);
        s();
    }

    public void a(long j) {
        this.T.setText(a.a(j));
    }

    public void a(q qVar, WeakReference<Context> weakReference, boolean z) {
        String str;
        String str2;
        if (qVar != null) {
            a((View) this.a, o.a());
            a(false, this.s);
            ad.a(this.h, 0);
            ad.a((View) this.i, 0);
            ad.a(this.j, 0);
            if (!(this.i == null || this.w == null || this.w.K() == null || this.w.K().j() == null)) {
                com.bytedance.sdk.openadsdk.k.c.a().a(this.w.K().j(), this.w.K().c(), this.w.K().b(), this.i, this.w);
            }
            if (!TextUtils.isEmpty(qVar.L())) {
                str = qVar.L();
            } else if (!TextUtils.isEmpty(qVar.V())) {
                str = qVar.V();
            } else {
                str = !TextUtils.isEmpty(qVar.W()) ? qVar.W() : "";
            }
            if (this.w != null && this.w.N() != null && this.w.N().a() != null) {
                ad.a((View) this.k, 0);
                ad.a((View) this.l, 4);
                if (this.k != null) {
                    com.bytedance.sdk.openadsdk.k.c.a().a(this.w.N(), (ImageView) this.k, qVar);
                    this.k.setOnClickListener(this.D);
                    this.k.setOnTouchListener(this.D);
                }
            } else if (!TextUtils.isEmpty(str)) {
                ad.a((View) this.k, 4);
                ad.a((View) this.l, 0);
                if (this.l != null) {
                    this.l.setText(str.substring(0, 1));
                    this.l.setOnClickListener(this.D);
                    this.l.setOnTouchListener(this.D);
                }
            }
            if (this.m != null && !TextUtils.isEmpty(str)) {
                this.m.setText(str);
            }
            ad.a((View) this.m, 0);
            ad.a((View) this.n, 0);
            int M2 = qVar.M();
            if (M2 != 4) {
                str2 = M2 != 5 ? s.a(this.x, "tt_video_mobile_go_detail") : s.a(this.x, "tt_video_dial_phone");
            } else {
                str2 = s.a(this.x, "tt_video_download_apk");
            }
            if (this.n != null) {
                this.n.setText(str2);
                this.n.setOnClickListener(this.D);
                this.n.setOnTouchListener(this.D);
            }
        }
    }

    public void h() {
        ad.e(this.d);
        ad.e(this.N);
    }

    public void i() {
        this.R.setProgress(0);
        this.R.setSecondaryProgress(0);
        this.S.setText(s.b(this.x, "tt_00_00"));
        this.T.setText(s.b(this.x, "tt_00_00"));
        d(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        if (this.f != null) {
            this.f.setImageDrawable((Drawable) null);
        }
        d(8);
        ad.a(this.Q, 8);
        ad.a(this.h, 8);
        ad.a((View) this.i, 8);
        ad.a(this.j, 8);
        ad.a((View) this.k, 8);
        ad.a((View) this.l, 8);
        ad.a((View) this.m, 8);
        if (this.y != null) {
            this.y.a(true);
        }
    }

    public boolean j() {
        return this.W;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null && (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.W = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            this.Z = marginLayoutParams.leftMargin;
            this.Y = marginLayoutParams.topMargin;
            this.aa = marginLayoutParams.width;
            this.ab = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.ac = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ad.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ad.b(viewGroup, 0, 0, 0, 0);
            }
            b(true);
            this.U.setImageDrawable(s.c(this.x, "tt_shrink_video"));
            this.R.setThumb(s.c(this.x, "tt_seek_thumb_fullscreen_selector"));
            this.R.setThumbOffset(0);
            a.a((View) this.a, false);
            e(this.W);
            ad.a(this.I, 8);
            if (!this.s) {
                ad.a((View) this.H, 8);
                ad.a((View) this.G, 8);
            } else if ((this.v & 1) == 1) {
                ad.a((View) this.H, 8);
            }
        }
    }

    public void b(ViewGroup viewGroup) {
        l.e("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup != null && this.a != null && (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.W = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            marginLayoutParams.width = this.aa;
            marginLayoutParams.height = this.ab;
            marginLayoutParams.leftMargin = this.Z;
            marginLayoutParams.topMargin = this.Y;
            this.a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(3, this.ac);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ad.b(viewGroup, this.ad.left, this.ad.top, this.ad.right, this.ad.bottom);
            }
            b(true);
            this.U.setImageDrawable(s.c(this.x, "tt_enlarge_video"));
            this.R.setThumb(s.c(this.x, "tt_seek_thumb_normal"));
            this.R.setThumbOffset(0);
            a.a((View) this.a, true);
            e(this.W);
            ad.a(this.I, 8);
            if ((this.v & 2) == 2) {
                ad.a((View) this.G, 0);
            }
        }
    }

    private void e(boolean z) {
        if (z) {
            y();
        } else {
            z();
        }
    }

    private void y() {
        DisplayMetrics displayMetrics = this.x.getResources().getDisplayMetrics();
        TextView textView = this.T;
        if (textView != null) {
            this.am = textView.getTextSize();
            this.T.setTextSize(2, 14.0f);
            ColorStateList textColors = this.T.getTextColors();
            this.an = textColors;
            if (textColors != null) {
                this.T.setTextColor(s.h(this.x, "tt_ssxinzi15"));
            }
            this.ao = this.T.getAlpha();
            this.T.setAlpha(0.85f);
            this.T.setShadowLayer(0.0f, (float) ad.b(this.x, 0.5f), (float) ad.b(this.x, 0.5f), s.h(this.x, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ap.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                ad.b(this.T, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.ap.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.ap.bottom);
            }
        }
        TextView textView2 = this.S;
        if (textView2 != null) {
            this.aq = textView2.getTextSize();
            this.S.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.S.getTextColors();
            this.ar = textColors2;
            if (textColors2 != null) {
                this.S.setTextColor(s.h(this.x, "tt_ssxinzi15"));
            }
            this.as = this.S.getAlpha();
            this.S.setAlpha(0.85f);
            this.S.setShadowLayer(0.0f, (float) ad.b(this.x, 0.5f), (float) ad.b(this.x, 0.5f), s.h(this.x, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.S.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.at.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ad.b(this.S, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.at.top, this.at.right, this.at.bottom);
            }
        }
        ImageView imageView = this.U;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.au.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ad.b(this.U, this.au.left, this.au.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.au.bottom);
            }
        }
        ImageView imageView2 = this.U;
        if (imageView2 != null) {
            imageView2.setImageDrawable(s.c(this.x, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.K;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.ae = textColors3;
            if (textColors3 != null) {
                this.K.setTextColor(s.h(this.x, "tt_ssxinzi15"));
            }
            this.af = this.K.getAlpha();
            this.K.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.K.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.ag.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                ad.b(this.K, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.at.top, this.at.right, this.at.bottom);
            }
        }
        View view = this.I;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.ah = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.I.setLayoutParams(layoutParams5);
            this.I.setBackgroundResource(s.d(this.x, "tt_shadow_fullscreen_top"));
        }
        b(false, true);
    }

    private void z() {
        TextView textView = this.T;
        if (textView != null) {
            textView.setTextSize(0, this.am);
            ColorStateList colorStateList = this.an;
            if (colorStateList != null) {
                this.T.setTextColor(colorStateList);
            }
            this.T.setAlpha(this.ao);
            this.T.setShadowLayer((float) ad.b(this.x, 1.0f), 0.0f, 0.0f, s.h(this.x, "tt_video_shadow_color"));
            ad.b(this.T, this.ap.left, this.ap.top, this.ap.right, this.ap.bottom);
        }
        TextView textView2 = this.S;
        if (textView2 != null) {
            textView2.setTextSize(0, this.aq);
            ColorStateList colorStateList2 = this.ar;
            if (colorStateList2 != null) {
                this.S.setTextColor(colorStateList2);
            }
            this.S.setAlpha(this.as);
            this.S.setShadowLayer((float) ad.b(this.x, 1.0f), 0.0f, 0.0f, s.h(this.x, "tt_video_shadow_color"));
            ad.b(this.S, this.at.left, this.at.top, this.at.right, this.at.bottom);
        }
        ImageView imageView = this.U;
        if (imageView != null) {
            ad.b(imageView, this.au.left, this.au.top, this.au.right, this.au.bottom);
        }
        ImageView imageView2 = this.U;
        if (imageView2 != null) {
            imageView2.setImageDrawable(s.c(this.x, "tt_enlarge_video"));
        }
        TextView textView3 = this.K;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.ae;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.K.setAlpha(this.af);
            ad.b(this.K, this.at.left, this.at.top, this.at.right, this.at.bottom);
        }
        View view = this.I;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.ah;
            this.I.setLayoutParams(layoutParams);
            this.I.setBackgroundResource(s.d(this.x, "tt_video_black_desc_gradient"));
        }
        b(false, true);
    }

    public void a(Message message) {
        if (message.what == 1) {
            k();
        }
    }

    public void a(boolean z, boolean z2, boolean z3) {
        ad.a(this.Q, 0);
        int i = 8;
        if (this.W) {
            ad.a(this.I, 0);
            ad.a((View) this.K, 0);
        } else if (z3) {
            ad.a(this.I, 8);
        }
        ad.a((View) this.c, (!z || this.d.getVisibility() == 0) ? 8 : 0);
        if (!this.s && !this.W) {
            if ((this.v & 1) != 1 && !z3) {
                ad.a((View) this.H, 0);
            }
            TextView textView = this.G;
            if (!z3) {
                i = 0;
            }
            ad.a((View) textView, i);
        }
        ad.a((View) this.S, 0);
        ad.a((View) this.T, 0);
        ad.a((View) this.R, 0);
    }

    public void a(boolean z, boolean z2) {
        ad.a(this.Q, 8);
        ad.a(this.I, 8);
        ad.a((View) this.c, 8);
        if (!this.s && !this.W) {
            ad.a((View) this.H, 8);
            if ((this.v & 2) != 2) {
                ad.a((View) this.G, 8);
            }
        } else if ((this.v & 1) == 1) {
            ad.a((View) this.H, 8);
        }
        if (z2) {
            ad.a((View) this.H, 8);
            ad.a((View) this.G, 8);
        }
        c(false);
    }

    public void k() {
        a(true, false);
    }

    public boolean b(int i) {
        SeekBar seekBar = this.R;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    public void c(boolean z) {
        if (this.J != null) {
            int i = 8;
            if (this.s) {
                ad.a((View) this.J, 8);
                return;
            }
            TextView textView = this.J;
            if (z) {
                i = 0;
            }
            ad.a((View) textView, i);
        }
    }

    public void a(View view, boolean z) {
        if (j()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.w != null && !TextUtils.isEmpty(this.w.V())) {
                a(this.w.V());
            }
            this.L.setText(format);
        } else {
            a("");
            this.L.setText("");
        }
        if (!this.A) {
            boolean z2 = false;
            c(this.s && !this.W);
            if (p()) {
                a aVar = this.z;
                if (this.d.getVisibility() != 0) {
                    z2 = true;
                }
                aVar.a(this, view, true, z2);
            }
        }
    }
}
