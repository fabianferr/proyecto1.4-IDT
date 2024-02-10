package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserDownloadButton;
import com.bytedance.sdk.openadsdk.common.LandingPageBrowserNewBottomBar;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.common.PangleViewStub;
import com.bytedance.sdk.openadsdk.common.g;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.ShadowTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.a.e;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import org.json.JSONObject;

public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity implements d {
    /* access modifiers changed from: private */
    public LandingPageLoadingLayout P;
    /* access modifiers changed from: private */
    public View Q;
    /* access modifiers changed from: private */
    public View R;
    /* access modifiers changed from: private */
    public boolean S;
    /* access modifiers changed from: private */
    public TextView T;
    private TextView U;
    /* access modifiers changed from: private */
    public long V;
    /* access modifiers changed from: private */
    public boolean W = false;
    /* access modifiers changed from: private */
    public boolean X;
    /* access modifiers changed from: private */
    public g Y;
    /* access modifiers changed from: private */
    public LinearLayout Z;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!l.e() || this.o == null || this.a == null) {
            finish();
            return;
        }
        this.X = o.d().v();
        this.a.setWebViewClient(new e(this.e, this.i, this.g, this.K, true) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoLandingPageLink2Activity.this.Q != null && !TTVideoLandingPageLink2Activity.this.S) {
                        TTVideoLandingPageLink2Activity.this.Q.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.Z != null) {
                        TTVideoLandingPageLink2Activity.this.Z.setVisibility(0);
                    }
                    boolean unused = TTVideoLandingPageLink2Activity.this.W = true;
                    TTVideoLandingPageLink2Activity.this.m();
                    c.a(TTVideoLandingPageLink2Activity.this.o, TTVideoLandingPageLink2Activity.this.D, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.V, true);
                } catch (Throwable unused2) {
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                long unused = TTVideoLandingPageLink2Activity.this.V = System.currentTimeMillis();
            }
        });
        this.a.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.i, this.K) {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoLandingPageLink2Activity.this.X && TTVideoLandingPageLink2Activity.this.Y != null && i == 100) {
                    TTVideoLandingPageLink2Activity.this.Y.a(webView);
                }
                if (TTVideoLandingPageLink2Activity.this.P != null) {
                    TTVideoLandingPageLink2Activity.this.P.a(i);
                }
            }
        });
        TextView textView = (TextView) findViewById(i.bt);
        if (!(textView == null || this.o.i() == null)) {
            textView.setText(this.o.i().c());
        }
        l.c().postDelayed(new Runnable() {
            public void run() {
                try {
                    boolean unused = TTVideoLandingPageLink2Activity.this.S = true;
                    if (TTVideoLandingPageLink2Activity.this.P != null) {
                        TTVideoLandingPageLink2Activity.this.P.b();
                    }
                    TTVideoLandingPageLink2Activity.this.R.setVisibility(0);
                    if (!TTVideoLandingPageLink2Activity.this.W) {
                        c.a(TTVideoLandingPageLink2Activity.this.o, TTVideoLandingPageLink2Activity.this.D, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.V, false);
                    }
                } catch (Exception unused2) {
                }
            }
        }, (this.o == null || this.o.i() == null) ? 10000 : this.o.i().a() * 1000);
    }

    /* access modifiers changed from: protected */
    public View a() {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setBackgroundColor(-1);
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this);
        pAGLinearLayout.addView(pAGFrameLayout, new LinearLayout.LayoutParams(-1, ad.b((Context) this, 220.0f)));
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(this);
        pAGFrameLayout2.setId(i.H);
        pAGFrameLayout.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(this);
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setPadding(0, ad.b((Context) this, 20.0f), 0, 0);
        pAGFrameLayout.addView(pAGLinearLayout2, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        pAGLinearLayout2.addView(view, layoutParams);
        ShadowTextView shadowTextView = new ShadowTextView(this);
        shadowTextView.setId(520093713);
        shadowTextView.setGravity(17);
        shadowTextView.setText(s.b(this, "tt_reward_feedback"));
        shadowTextView.setTextColor(-1);
        shadowTextView.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, ad.b((Context) this, 28.0f));
        int b = ad.b((Context) this, 16.0f);
        layoutParams2.rightMargin = b;
        layoutParams2.leftMargin = b;
        pAGLinearLayout2.addView(shadowTextView, layoutParams2);
        ShadowImageView shadowImageView = new ShadowImageView(this);
        shadowImageView.setId(i.I);
        shadowImageView.setPadding(ad.b((Context) this, 7.0f), ad.b((Context) this, 7.0f), ad.b((Context) this, 7.0f), ad.b((Context) this, 7.0f));
        shadowImageView.setImageResource(s.d(this, "tt_video_close_drawable"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ad.b((Context) this, 28.0f), ad.b((Context) this, 28.0f));
        layoutParams3.rightMargin = ad.b((Context) this, 12.0f);
        pAGLinearLayout2.addView(shadowImageView, layoutParams3);
        PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(this);
        pAGRelativeLayout.setVisibility(8);
        pAGRelativeLayout.setId(i.J);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = ad.b((Context) this, 10.0f);
        pAGLinearLayout.addView(pAGRelativeLayout, layoutParams4);
        CornerIV cornerIV = new CornerIV(this);
        cornerIV.setId(i.K);
        cornerIV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        cornerIV.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ad.b((Context) this, 44.0f), ad.b((Context) this, 44.0f));
        layoutParams5.addRule(9);
        layoutParams5.leftMargin = ad.b((Context) this, 5.0f);
        pAGRelativeLayout.addView(cornerIV, layoutParams5);
        PAGTextView pAGTextView = new PAGTextView(this);
        pAGTextView.setId(i.L);
        pAGTextView.setBackgroundResource(s.d(this, "tt_circle_solid_mian"));
        pAGTextView.setGravity(17);
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 19.0f);
        pAGTextView.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(ad.b((Context) this, 44.0f), ad.b((Context) this, 44.0f));
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = ad.b((Context) this, 5.0f);
        pAGRelativeLayout.addView(pAGTextView, layoutParams6);
        PAGTextView pAGTextView2 = new PAGTextView(this);
        pAGTextView2.setId(i.M);
        pAGTextView2.setMaxLines(1);
        pAGTextView2.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView2.setTextColor(Color.parseColor("#e5000000"));
        pAGTextView2.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = ad.b((Context) this, 5.0f);
        layoutParams7.rightMargin = ad.b((Context) this, 80.0f);
        layoutParams7.addRule(1, i.L);
        pAGRelativeLayout.addView(pAGTextView2, layoutParams7);
        PAGTextView pAGTextView3 = new PAGTextView(this);
        pAGTextView3.setId(i.N);
        pAGTextView3.setClickable(true);
        pAGTextView3.setMaxLines(1);
        pAGTextView3.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView3.setFocusable(true);
        pAGTextView3.setGravity(17);
        pAGTextView3.setText(s.b(this, "tt_video_mobile_go_detail"));
        pAGTextView3.setTextColor(-1);
        pAGTextView3.setTextSize(2, 14.0f);
        pAGTextView3.setPadding(ad.b((Context) this, 2.0f), ad.b((Context) this, 2.0f), ad.b((Context) this, 2.0f), ad.b((Context) this, 2.0f));
        pAGTextView3.setBackgroundResource(s.d(this, "tt_ad_cover_btn_begin_bg"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(ad.b((Context) this, 90.0f), ad.b((Context) this, 36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = ad.b((Context) this, 5.0f);
        pAGRelativeLayout.addView(pAGTextView3, layoutParams8);
        PAGFrameLayout pAGFrameLayout3 = new PAGFrameLayout(this);
        pAGLinearLayout.addView(pAGFrameLayout3, new LinearLayout.LayoutParams(-1, -1));
        SSWebView sSWebView = new SSWebView(this);
        sSWebView.setId(i.O);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.topMargin = ad.b((Context) this, 2.0f);
        pAGFrameLayout3.addView(sSWebView, layoutParams9);
        PAGRelativeLayout pAGRelativeLayout2 = new PAGRelativeLayout(this);
        pAGRelativeLayout2.setId(i.P);
        pAGRelativeLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
        pAGFrameLayout3.addView(pAGRelativeLayout2, new FrameLayout.LayoutParams(-1, -1));
        LandingPageLoadingLayout landingPageLoadingLayout = new LandingPageLoadingLayout(this);
        landingPageLoadingLayout.setId(i.Q);
        pAGRelativeLayout2.addView(landingPageLoadingLayout, new RelativeLayout.LayoutParams(-1, -1));
        PAGLinearLayout pAGLinearLayout3 = new PAGLinearLayout(this);
        pAGLinearLayout3.setId(i.G);
        pAGLinearLayout3.setOrientation(1);
        pAGLinearLayout3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(13);
        pAGRelativeLayout2.addView(pAGLinearLayout3, layoutParams10);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(this);
        tTRoundRectImageView.setId(i.R);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(ad.b((Context) this, 80.0f), ad.b((Context) this, 80.0f));
        layoutParams11.gravity = 17;
        pAGLinearLayout3.addView(tTRoundRectImageView, layoutParams11);
        PAGTextView pAGTextView4 = new PAGTextView(this);
        pAGTextView4.setId(i.S);
        pAGTextView4.setTextColor(Color.parseColor("#161823"));
        pAGTextView4.setTextSize(0, (float) ad.b((Context) this, 24.0f));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.gravity = 17;
        layoutParams12.topMargin = ad.b((Context) this, 12.0f);
        pAGLinearLayout3.addView(pAGTextView4, layoutParams12);
        PAGTextView pAGTextView5 = new PAGTextView(this);
        pAGTextView5.setId(i.T);
        pAGTextView5.setTextColor(Color.parseColor("#80161823"));
        pAGTextView5.setTextSize(0, (float) ad.b((Context) this, 16.0f));
        pAGTextView5.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 17;
        int b2 = ad.b((Context) this, 60.0f);
        layoutParams13.rightMargin = b2;
        layoutParams13.leftMargin = b2;
        layoutParams13.topMargin = ad.b((Context) this, 8.0f);
        pAGLinearLayout3.addView(pAGTextView5, layoutParams13);
        PAGTextView pAGTextView6 = new PAGTextView(this);
        pAGTextView6.setId(i.U);
        pAGTextView6.setGravity(17);
        pAGTextView6.setTextColor(-1);
        pAGTextView6.setText(s.b(this, "tt_video_mobile_go_detail"));
        pAGTextView6.setBackgroundResource(s.d(this, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(ad.b((Context) this, 255.0f), ad.b((Context) this, 44.0f));
        layoutParams14.gravity = 17;
        layoutParams14.topMargin = ad.b((Context) this, 32.0f);
        pAGLinearLayout3.addView(pAGTextView6, layoutParams14);
        PAGTextView pAGTextView7 = new PAGTextView(this);
        pAGTextView7.setId(i.V);
        pAGTextView7.setBackgroundResource(s.d(this, "tt_ad_logo_new"));
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(ad.b((Context) this, 32.0f), ad.b((Context) this, 14.0f));
        layoutParams15.addRule(12);
        layoutParams15.leftMargin = ad.b((Context) this, 16.0f);
        layoutParams15.bottomMargin = ad.b((Context) this, 20.0f);
        pAGRelativeLayout2.addView(pAGTextView7, layoutParams15);
        PangleViewStub pangleViewStub = new PangleViewStub(this, new PangleViewStub.a() {
            public View a(Context context) {
                return new LandingPageBrowserDownloadButton(context);
            }
        });
        pangleViewStub.setId(i.W);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-1, ad.b((Context) this, 48.0f));
        layoutParams16.gravity = 81;
        pAGFrameLayout3.addView(pangleViewStub, layoutParams16);
        PangleViewStub pangleViewStub2 = new PangleViewStub(this, new PangleViewStub.a() {
            public View a(Context context) {
                return new LandingPageBrowserNewBottomBar(context);
            }
        });
        pangleViewStub2.setId(i.X);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, ad.b((Context) this, 44.0f));
        layoutParams17.gravity = 80;
        pAGFrameLayout3.addView(pangleViewStub2, layoutParams17);
        return pAGLinearLayout;
    }

    /* access modifiers changed from: protected */
    public void c() {
        super.c();
        TextView textView = (TextView) findViewById(520093713);
        if (textView != null) {
            textView.setText(s.a(o.a(), "tt_reward_feedback"));
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTDelegateActivity.a(TTVideoLandingPageLink2Activity.this.o, "");
                }
            });
        }
        this.T = (TextView) findViewById(520093714);
        this.P = (LandingPageLoadingLayout) findViewById(i.Q);
        this.Q = findViewById(i.P);
        this.R = findViewById(i.G);
        TextView textView2 = (TextView) findViewById(i.S);
        TextView textView3 = (TextView) findViewById(i.T);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(i.R);
        this.U = (TextView) findViewById(i.U);
        if (this.o.N() != null && !TextUtils.isEmpty(this.o.N().a())) {
            com.bytedance.sdk.openadsdk.k.c.a().a(this.o.N(), (ImageView) tTRoundRectImageView, this.o);
        }
        textView2.setText(this.o.L());
        textView3.setText(this.o.W());
        ((TextView) findViewById(i.V)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(TTVideoLandingPageLink2Activity.this.e, TTVideoLandingPageLink2Activity.this.o, TTVideoLandingPageLink2Activity.this.D);
            }
        });
        boolean v = o.d().v();
        this.X = v;
        if (v) {
            ((PangleViewStub) findViewById(i.X)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) findViewById(i.ah);
            this.Z = linearLayout;
            linearLayout.setVisibility(8);
            this.Y = new g(this, this.Z, this.a, this.o, "landingpage_split_screen");
            if (this.a.getWebView() != null) {
                this.a.getWebView().setOnTouchListener(new View.OnTouchListener() {
                    float a = 0.0f;

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            this.a = motionEvent.getY();
                        }
                        if (TTVideoLandingPageLink2Activity.this.K != null) {
                            TTVideoLandingPageLink2Activity.this.K.a(motionEvent.getActionMasked());
                        }
                        if (motionEvent.getAction() == 2) {
                            float y = motionEvent.getY();
                            float f = this.a;
                            if (y - f > 8.0f) {
                                if (TTVideoLandingPageLink2Activity.this.Y != null) {
                                    TTVideoLandingPageLink2Activity.this.Y.a();
                                }
                                return false;
                            } else if (y - f < -8.0f && TTVideoLandingPageLink2Activity.this.Y != null) {
                                TTVideoLandingPageLink2Activity.this.Y.b();
                            }
                        }
                        return false;
                    }
                });
            }
        } else if (this.a.getWebView() != null) {
            this.a.getWebView().setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTVideoLandingPageLink2Activity.this.K == null) {
                        return false;
                    }
                    TTVideoLandingPageLink2Activity.this.K.a(motionEvent.getActionMasked());
                    return false;
                }
            });
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.P;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.o, this.D);
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        c.a(this.o, "landingpage_split_screen", "click_video", (JSONObject) null);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LandingPageLoadingLayout landingPageLoadingLayout = this.P;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a();
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (e()) {
            super.d();
            if (this.m != null) {
                if (this.m.getNativeVideoController() != null) {
                    this.m.getNativeVideoController().a(false);
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.m.getNativeVideoController()).g(false);
                    this.k.setClickable(true);
                    this.k.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 0) {
                                return false;
                            }
                            TTVideoLandingPageLink2Activity.this.l();
                            return false;
                        }
                    });
                }
                this.m.getNativeVideoController().a((c.a) new c.a() {
                    public void a() {
                    }

                    public void a(long j, int i) {
                    }

                    public void b(long j, int i) {
                    }

                    public void a(long j, long j2) {
                        if (TTVideoLandingPageLink2Activity.this.T != null) {
                            int max = (int) Math.max(0, (j2 - j) / 1000);
                            TTVideoLandingPageLink2Activity.this.T.setText(String.valueOf(max));
                            if (max <= 0) {
                                TTVideoLandingPageLink2Activity.this.T.setVisibility(8);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.bytedance.sdk.openadsdk.k.c.a().a(this.o.Q().get(0), imageView, this.o);
            this.k.setVisibility(0);
            this.k.removeAllViews();
            this.k.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.b.c.b(TTVideoLandingPageLink2Activity.this.o, "landingpage_split_screen");
                }
            });
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return this.l == 5 || this.l == 15 || this.l == 50;
    }

    public void i() {
        super.i();
        if (this.o != null) {
            this.o.e(true);
        }
        TextView textView = this.U;
        if (textView != null) {
            textView.setText(b());
            this.U.setClickable(true);
            this.U.setOnClickListener(this.O);
            this.U.setOnTouchListener(this.O);
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        LandingPageLoadingLayout landingPageLoadingLayout = this.P;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m();
        if (!this.S && this.K != null && this.a != null && this.P.getVisibility() == 8) {
            this.K.a(this.a);
        }
        super.onDestroy();
    }
}
