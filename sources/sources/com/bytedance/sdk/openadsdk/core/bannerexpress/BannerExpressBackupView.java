package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.RatioFrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.concurrent.atomic.AtomicInteger;

public class BannerExpressBackupView extends BackupView {
    public static m[] a = {new m(1, 6.4f, 320, 50), new m(4, 1.2f, 300, 250)};
    private static final AtomicInteger m = new AtomicInteger(1);
    private a n;
    private NativeExpressView o;
    private String p;
    /* access modifiers changed from: private */
    public PAGBannerAdWrapperListener q;

    public void setClosedListenerKey(String str) {
        this.p = str;
    }

    public BannerExpressBackupView(Context context) {
        super(context);
        this.b = context;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, com.bytedance.sdk.openadsdk.core.model.m mVar) {
        a aVar;
        if (this.o != null) {
            if ((i == 1 || i == 2) && (aVar = this.n) != null) {
                ImageView imageView = aVar.j;
                if (i == 1) {
                    this.o.getClickListener().b((View) imageView);
                } else {
                    this.o.getClickCreativeListener().b((View) imageView);
                }
            }
            this.o.a(view, i, mVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(q qVar, NativeExpressView nativeExpressView, c cVar) {
        setBackgroundColor(-1);
        this.c = qVar;
        this.o = nativeExpressView;
        this.f = "banner_ad";
        this.o.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void b() {
        m a2 = a(this.o.getExpectExpressWidth(), this.o.getExpectExpressHeight());
        if (this.o.getExpectExpressWidth() <= 0 || this.o.getExpectExpressHeight() <= 0) {
            this.g = ad.c(this.b);
            this.h = Float.valueOf(((float) this.g) / a2.b).intValue();
        } else {
            this.g = ad.b(this.b, (float) this.o.getExpectExpressWidth());
            this.h = ad.b(this.b, (float) this.o.getExpectExpressHeight());
        }
        if (this.g > 0 && this.g > ad.c(this.b)) {
            float c = ((float) ad.c(this.b)) / ((float) this.g);
            this.g = ad.c(this.b);
            this.h = Float.valueOf(((float) this.h) * c).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.g, this.h);
        }
        layoutParams.width = this.g;
        layoutParams.height = this.h;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (a2.a == 1) {
            c();
        } else if (a2.a == 4) {
            d();
        } else {
            d();
        }
    }

    private void a(ImageView imageView) {
        com.bytedance.sdk.openadsdk.k.c.a().a(this.c.Q().get(0), imageView, this.c);
    }

    private void c() {
        float b = (((float) this.h) * 1.0f) / ((float) ad.b(this.b, 50.0f));
        if ((((float) this.h) * 1.0f) / ((float) this.g) > 0.21875f) {
            b = (((float) this.g) * 1.0f) / ((float) ad.b(this.b, 320.0f));
        }
        a e = e();
        this.n = e;
        ImageView imageView = e.j;
        ImageView imageView2 = this.n.d;
        TextView textView = this.n.e;
        TextView textView2 = this.n.f;
        TTRatingBar2 tTRatingBar2 = this.n.g;
        TextView textView3 = this.n.i;
        textView.setTextSize(2, ((float) ad.a(this.b, textView.getTextSize())) * b);
        textView2.setTextSize(2, ((float) ad.a(this.b, textView2.getTextSize())) * b);
        textView3.setTextSize(2, ((float) ad.a(this.b, textView3.getTextSize())) * b);
        View view = this.n.h;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTWebsiteActivity.a(BannerExpressBackupView.this.b, BannerExpressBackupView.this.c, BannerExpressBackupView.this.f);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (((float) ad.b(this.b, 45.0f)) * b);
            layoutParams.height = (int) (((float) ad.b(this.b, 45.0f)) * b);
        }
        if (this.c.N() != null && !TextUtils.isEmpty(this.c.N().a())) {
            com.bytedance.sdk.openadsdk.k.c.a().a(this.c.N().a(), this.c.N().b(), this.c.N().c(), imageView2, this.c);
        }
        textView.setText(getTitle());
        if (!TextUtils.isEmpty(this.c.X())) {
            textView3.setText(this.c.X());
        } else {
            textView3.setVisibility(8);
        }
        ad.a(textView2, tTRatingBar2, this.c);
        a(imageView2, true);
        imageView2.setTag(520093762, true);
        a(this, true);
        a(textView3, true);
    }

    private void d() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        if (this.c != null) {
            int ad = this.c.ad();
            float b = (((float) this.h) * 1.0f) / ((float) ad.b(this.b, 250.0f));
            if (this.c.K() == null) {
                a f = f();
                this.n = f;
                ImageView imageView = f.j;
                RatioImageView ratioImageView = this.n.a;
                ImageView imageView2 = this.n.d;
                TextView textView5 = this.n.e;
                TextView textView6 = this.n.b;
                TextView textView7 = this.n.c;
                TextView textView8 = this.n.i;
                ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = (int) (((float) ad.b(this.b, 45.0f)) * b);
                    layoutParams.height = (int) (((float) ad.b(this.b, 45.0f)) * b);
                }
                textView5.setTextSize(2, ((float) ad.a(this.b, textView5.getTextSize())) * b);
                textView6.setTextSize(2, ((float) ad.a(this.b, textView6.getTextSize())) * b);
                textView7.setTextSize(2, ((float) ad.a(this.b, textView7.getTextSize())) * b);
                textView8.setTextSize(2, ((float) ad.a(this.b, textView8.getTextSize())) * b);
                try {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView5.getLayoutParams();
                    float f2 = b - 1.0f;
                    if (f2 > 0.0f) {
                        layoutParams2.topMargin = ad.b(this.b, f2 * 8.0f);
                    }
                    ((LinearLayout.LayoutParams) textView8.getLayoutParams()).setMargins(0, (int) (((float) ad.b(this.b, 16.0f)) * b), 0, 0);
                } catch (Throwable unused) {
                }
                View view = this.n.h;
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            TTWebsiteActivity.a(BannerExpressBackupView.this.b, BannerExpressBackupView.this.c, BannerExpressBackupView.this.f);
                        }
                    });
                }
                if (ad == 33) {
                    ratioImageView.setRatio(1.0f);
                } else {
                    if (ratioImageView.getParent() instanceof FrameLayout) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((FrameLayout) ratioImageView.getParent()).getLayoutParams();
                        LinearLayout.LayoutParams layoutParams4 = layoutParams3;
                        layoutParams3.weight = 2.5f;
                    }
                    ratioImageView.setRatio(1.91f);
                }
                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BannerExpressBackupView.this.a();
                    }
                });
                int b2 = ad.b(this.b, 15.0f);
                ad.a(imageView, b2, b2, b2, b2);
                a((ImageView) ratioImageView);
                if (this.c.N() == null || TextUtils.isEmpty(this.c.N().a())) {
                    textView = textView8;
                    textView4 = textView7;
                    textView3 = textView6;
                    textView2 = textView5;
                } else {
                    com.bytedance.sdk.openadsdk.k.c a2 = com.bytedance.sdk.openadsdk.k.c.a();
                    String a3 = this.c.N().a();
                    int b3 = this.c.N().b();
                    textView = textView8;
                    com.bytedance.sdk.openadsdk.k.c cVar = a2;
                    textView4 = textView7;
                    String str = a3;
                    textView3 = textView6;
                    int i = b3;
                    textView2 = textView5;
                    cVar.a(str, i, this.c.N().c(), imageView2, this.c);
                }
                textView4.setText(getNameOrSource());
                textView2.setText(getNameOrSource());
                textView3.setText(getDescription());
                if (!TextUtils.isEmpty(this.c.X())) {
                    textView.setText(this.c.X());
                } else {
                    textView.setVisibility(8);
                }
                a(ratioImageView, true);
                ratioImageView.setTag(520093762, true);
                a(this, true);
                a(textView, true);
                return;
            }
            a g = g();
            this.n = g;
            ImageView imageView3 = g.j;
            TextView textView9 = this.n.e;
            TextView textView10 = this.n.b;
            TextView textView11 = this.n.i;
            RatioFrameLayout a4 = this.n.k;
            textView9.setTextSize(2, ((float) ad.a(this.b, textView9.getTextSize())) * b);
            textView10.setTextSize(2, ((float) ad.a(this.b, textView10.getTextSize())) * b);
            textView11.setTextSize(2, ((float) ad.a(this.b, textView11.getTextSize())) * b);
            View view2 = this.n.h;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TTWebsiteActivity.a(BannerExpressBackupView.this.b, BannerExpressBackupView.this.c, BannerExpressBackupView.this.f);
                    }
                });
            }
            if (ad == 15) {
                a4.setRatio(0.5625f);
            } else if (ad == 5) {
                a4.setRatio(1.7777778f);
            } else {
                a4.setRatio(1.0f);
            }
            a4.removeAllViews();
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -1);
            NativeVideoTsView videoView = getVideoView();
            if (videoView != null) {
                NativeExpressView nativeExpressView = this.o;
                if (nativeExpressView instanceof NativeExpressVideoView) {
                    videoView.setVideoAdInteractionListener((NativeExpressVideoView) nativeExpressView);
                }
                a4.addView(videoView, layoutParams5);
                videoView.setAdCreativeClickListener(new NativeVideoTsView.a() {
                    public void a(View view, int i) {
                        if (BannerExpressBackupView.this.q != null) {
                            BannerExpressBackupView.this.q.onAdClicked(view, i);
                        }
                    }
                });
                f clickCreativeListener = this.o.getClickCreativeListener();
                if (clickCreativeListener != null) {
                    clickCreativeListener.a(videoView.getNativeVideoController());
                }
            }
            textView9.setText(getNameOrSource());
            textView10.setText(getDescription());
            if (!TextUtils.isEmpty(this.c.X())) {
                textView11.setText(this.c.X());
            } else {
                textView11.setVisibility(8);
            }
            imageView3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BannerExpressBackupView.this.a();
                }
            });
            int b4 = ad.b(this.b, 15.0f);
            ad.a(imageView3, b4, b4, b4, b4);
            a(videoView, true);
            if (videoView != null) {
                videoView.setTag(520093762, true);
            }
            a(this, true);
            a(textView11, true);
            a((View) a4);
        }
    }

    public static m a(int i, int i2) {
        try {
            m mVar = a[0];
            double d = (double) i2;
            double d2 = (double) i;
            Double.isNaN(d2);
            return d >= Math.floor((d2 * 450.0d) / 600.0d) ? a[1] : mVar;
        } catch (Throwable unused) {
            return a[0];
        }
    }

    public void a() {
        if (this.e != null) {
            this.e.show();
        } else if (this.d != null) {
            this.d.a();
        } else {
            TTDelegateActivity.a(this.c, this.p);
        }
    }

    private a e() {
        int b = ad.b(this.b, 45.0f);
        int b2 = ad.b(this.b, 25.0f);
        double d = (double) b2;
        Double.isNaN(d);
        int b3 = ad.b(this.b, 10.0f);
        int b4 = ad.b(this.b, 2.0f);
        int b5 = ad.b(this.b, 3.0f);
        ad.b(this.b, 11.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        addView(relativeLayout, -1, -1);
        ImageView imageView = new ImageView(this.b);
        imageView.setId(520093738);
        TextView textView = new TextView(this.b);
        textView.setId(520093730);
        TextView textView2 = new TextView(this.b);
        textView2.setId(520093731);
        TTRatingBar2 tTRatingBar2 = new TTRatingBar2(this.b, (AttributeSet) null);
        tTRatingBar2.setId(520093735);
        TTBackUpAdImageView tTBackUpAdImageView = new TTBackUpAdImageView(this.b);
        tTBackUpAdImageView.setId(520093739);
        TextView textView3 = new TextView(this.b);
        textView3.setId(520093703);
        ImageView imageView2 = new ImageView(this.b);
        imageView2.setId(520093697);
        TextView textView4 = textView3;
        TTBackUpAdImageView tTBackUpAdImageView2 = tTBackUpAdImageView;
        TTRatingBar2 tTRatingBar22 = tTRatingBar2;
        a aVar = r10;
        TextView textView5 = textView;
        int i = (int) (d / 5.0d);
        ImageView imageView3 = imageView;
        a aVar2 = new a(imageView, textView, textView2, tTRatingBar22, tTBackUpAdImageView2, textView4, imageView2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b, b);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        imageView3.setLayoutParams(layoutParams);
        imageView3.setBackgroundColor(s.h(this.b, "tt_white"));
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, b2);
        layoutParams2.setMarginStart(b3);
        layoutParams2.addRule(16, textView4.getId());
        layoutParams2.addRule(17, imageView3.getId());
        textView5.setTextDirection(5);
        layoutParams2.leftMargin = b3;
        layoutParams2.addRule(0, textView4.getId());
        layoutParams2.addRule(1, imageView3.getId());
        textView5.setEllipsize(TextUtils.TruncateAt.END);
        textView5.setGravity(80);
        textView5.setMaxLines(1);
        textView5.setTextColor(Color.parseColor("#FF333333"));
        textView5.setTextSize(12.0f);
        textView5.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView5);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, b2);
        layoutParams3.addRule(3, textView5.getId());
        layoutParams3.setMarginStart(b3);
        layoutParams3.addRule(17, imageView3.getId());
        layoutParams3.leftMargin = b3;
        layoutParams3.topMargin = b4;
        layoutParams3.addRule(1, imageView3.getId());
        TextView textView6 = textView2;
        textView6.setEllipsize(TextUtils.TruncateAt.END);
        textView6.setMaxLines(1);
        textView6.setTextColor(Color.parseColor("#FF333333"));
        textView6.setTextSize(12.0f);
        textView6.setTypeface(Typeface.defaultFromStyle(1));
        textView6.setLayoutParams(layoutParams3);
        relativeLayout.addView(textView6);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = b4;
        layoutParams4.addRule(3, textView5.getId());
        layoutParams4.addRule(6, textView6.getId());
        layoutParams4.setMarginStart(b4);
        layoutParams4.addRule(17, textView6.getId());
        layoutParams4.addRule(16, textView4.getId());
        layoutParams4.leftMargin = b4;
        layoutParams4.addRule(1, textView6.getId());
        layoutParams4.addRule(0, textView4.getId());
        TTRatingBar2 tTRatingBar23 = tTRatingBar22;
        tTRatingBar23.setLayoutParams(layoutParams4);
        relativeLayout.addView(tTRatingBar23);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(21);
        layoutParams5.setMarginEnd(b5);
        layoutParams5.addRule(11);
        layoutParams5.addRule(12);
        layoutParams5.topMargin = b5;
        layoutParams5.rightMargin = b5;
        TTBackUpAdImageView tTBackUpAdImageView3 = tTBackUpAdImageView2;
        tTBackUpAdImageView3.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTBackUpAdImageView3);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.setMarginEnd(b2);
        layoutParams6.addRule(21);
        layoutParams6.rightMargin = b2;
        TextView textView7 = textView4;
        textView7.setBackgroundResource(s.d(this.b, "tt_backup_btn_1"));
        textView7.setEllipsize(TextUtils.TruncateAt.END);
        textView7.setGravity(17);
        textView7.setMaxLines(1);
        int i2 = i;
        textView7.setPadding(b3, i2, b3, i2);
        textView7.setText(s.a(this.b, "tt_video_download_apk"));
        textView7.setTextColor(Color.parseColor("#f0f0f0"));
        textView7.setTextSize(10.0f);
        textView7.setLayoutParams(layoutParams6);
        relativeLayout.addView(textView7);
        int i3 = b5 * 5;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams7.addRule(21);
        layoutParams7.setMarginEnd(b5);
        layoutParams7.addRule(11);
        layoutParams7.topMargin = b5;
        layoutParams7.rightMargin = b5;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageResource(s.d(this.b, "tt_dislike_icon"));
        imageView2.setLayoutParams(layoutParams7);
        relativeLayout.addView(imageView2);
        return aVar;
    }

    private a f() {
        float b = (float) ad.b(this.b, 5.0f);
        float b2 = (float) ad.b(this.b, 8.0f);
        float b3 = (float) ad.b(this.b, 18.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        int i = (int) b2;
        relativeLayout.setPadding(i, i, i, i);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        TextView textView = new TextView(this.b);
        textView.setId(520093730);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.setMarginEnd((int) b3);
        textView.setTextDirection(5);
        int i2 = (int) b3;
        layoutParams2.rightMargin = i2;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(8388611);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(14.0f);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(this.b);
        textView2.setId(520093733);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.addRule(3, textView.getId());
        layoutParams3.topMargin = (int) (b2 / 2.0f);
        layoutParams3.setMarginEnd(i2);
        textView2.setTextDirection(5);
        layoutParams3.rightMargin = i2;
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(8388611);
        textView2.setMaxLines(2);
        textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
        textView2.setTextSize(12.0f);
        textView2.setLayoutParams(layoutParams3);
        relativeLayout.addView(textView2);
        ImageView imageView = new ImageView(this.b);
        imageView.setId(520093697);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        int b4 = (int) ((float) ad.b(this.b, 15.0f));
        layoutParams4.width = b4;
        layoutParams4.height = b4;
        layoutParams4.addRule(21);
        layoutParams4.addRule(11);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(s.d(this.b, "tt_titlebar_close_press_for_dark"));
        imageView.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutDirection(3);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(3, textView2.getId());
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        relativeLayout.addView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this.b);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.weight = 1.0f;
        frameLayout.setLayoutParams(layoutParams6);
        linearLayout.addView(frameLayout);
        RatioImageView ratioImageView = new RatioImageView(this.b);
        ratioImageView.setId(520093736);
        ratioImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        frameLayout.addView(ratioImageView, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout2 = new LinearLayout(this.b);
        linearLayout2.setId(520093737);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
        layoutParams7.weight = 1.0f;
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams7);
        linearLayout.addView(linearLayout2);
        ImageView imageView2 = new ImageView(this.b);
        imageView2.setId(520093738);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        int b5 = (int) ((float) ad.b(this.b, 45.0f));
        layoutParams8.width = b5;
        layoutParams8.height = b5;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setLayoutParams(layoutParams8);
        linearLayout2.addView(imageView2);
        TextView textView3 = new TextView(this.b);
        textView3.setId(520093730);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.topMargin = (int) ((float) ad.b(this.b, 7.0f));
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setGravity(17);
        textView3.setMaxLines(1);
        textView3.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView3.setTextSize(12.0f);
        textView3.setLayoutParams(layoutParams9);
        linearLayout2.addView(textView3);
        TextView textView4 = new TextView(this.b);
        textView4.setId(520093703);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.topMargin = (int) (b2 * 2.0f);
        textView4.setBackgroundResource(s.d(this.b, "tt_backup_btn_1"));
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        textView4.setMaxLines(1);
        int i3 = (int) (b * 2.0f);
        int i4 = (int) b;
        textView4.setPadding(i3, i4, i3, i4);
        textView4.setText(s.a(this.b, "tt_video_download_apk"));
        textView4.setTextColor(s.h(this.b, "tt_white"));
        textView4.setTextSize(10.0f);
        textView4.setLayoutParams(layoutParams10);
        linearLayout2.addView(textView4);
        TTBackUpAdImageView tTBackUpAdImageView = new TTBackUpAdImageView(this.b);
        tTBackUpAdImageView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(12);
        tTBackUpAdImageView.setLayoutParams(layoutParams11);
        relativeLayout.addView(tTBackUpAdImageView);
        return new a(imageView2, textView, tTBackUpAdImageView, textView4, imageView, textView3, textView2, ratioImageView);
    }

    private a g() {
        float b = (float) ad.b(this.b, 5.0f);
        float b2 = (float) ad.b(this.b, 18.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        int b3 = (int) ((float) ad.b(this.b, 8.0f));
        relativeLayout.setPadding(b3, b3, b3, b3);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        TextView textView = new TextView(this.b);
        textView.setId(520093730);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.width = -1;
        layoutParams2.setMarginEnd((int) b2);
        textView.setTextDirection(5);
        layoutParams2.rightMargin = (int) b2;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(8388611);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(14.0f);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        ImageView imageView = new ImageView(this.b);
        imageView.setId(520093697);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        int b4 = (int) ((float) ad.b(this.b, 15.0f));
        layoutParams3.width = b4;
        layoutParams3.height = b4;
        layoutParams3.addRule(21);
        layoutParams3.addRule(11);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(s.d(this.b, "tt_titlebar_close_press_for_dark"));
        imageView.setLayoutParams(layoutParams3);
        relativeLayout.addView(imageView);
        TextView textView2 = new TextView(this.b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        textView2.setId(520093703);
        layoutParams4.addRule(11);
        layoutParams4.addRule(21);
        layoutParams4.addRule(12);
        layoutParams4.topMargin = b3;
        textView2.setBackgroundResource(s.d(this.b, "tt_backup_btn_1"));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        int i = (int) (2.0f * b);
        int i2 = (int) b;
        textView2.setPadding(i, i2, i, i2);
        textView2.setText(s.a(this.b, "tt_video_download_apk"));
        textView2.setTextColor(s.h(this.b, "tt_white"));
        textView2.setTextSize(10.0f);
        textView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView2);
        TextView textView3 = new TextView(this.b);
        textView3.setId(520093733);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(4, textView2.getId());
        layoutParams5.addRule(20);
        layoutParams5.addRule(16, textView2.getId());
        textView3.setTextDirection(5);
        layoutParams5.addRule(12);
        layoutParams5.rightMargin = (int) ((float) ad.b(this.b, 4.0f));
        layoutParams5.addRule(0, textView2.getId());
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setGravity(8388611);
        textView3.setMaxLines(1);
        textView3.setTextColor(Color.parseColor("#FFAEAEAE"));
        textView3.setTextSize(12.0f);
        textView3.setLayoutParams(layoutParams5);
        relativeLayout.addView(textView3);
        FrameLayout frameLayout = new FrameLayout(this.b);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(2, textView2.getId());
        layoutParams6.addRule(3, textView.getId());
        layoutParams6.topMargin = b3;
        frameLayout.setLayoutParams(layoutParams6);
        relativeLayout.addView(frameLayout);
        RatioFrameLayout ratioFrameLayout = new RatioFrameLayout(this.b);
        ratioFrameLayout.setId(520093736);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams7.gravity = 17;
        ratioFrameLayout.setLayoutParams(layoutParams7);
        frameLayout.addView(ratioFrameLayout);
        TTBackUpAdImageView tTBackUpAdImageView = new TTBackUpAdImageView(this.b);
        tTBackUpAdImageView.setId(520093739);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, textView2.getId());
        tTBackUpAdImageView.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTBackUpAdImageView);
        return new a(textView, tTBackUpAdImageView, textView2, imageView, textView3, ratioFrameLayout);
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.q = pAGBannerAdWrapperListener;
    }

    private static class a {
        public RatioImageView a;
        public TextView b;
        public TextView c;
        ImageView d;
        TextView e;
        TextView f;
        TTRatingBar2 g;
        View h;
        TextView i;
        ImageView j;
        /* access modifiers changed from: private */
        public RatioFrameLayout k;

        a(ImageView imageView, TextView textView, TextView textView2, TTRatingBar2 tTRatingBar2, View view, TextView textView3, ImageView imageView2) {
            this.d = imageView;
            this.e = textView;
            this.f = textView2;
            this.g = tTRatingBar2;
            this.h = view;
            this.i = textView3;
            this.j = imageView2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        a(ImageView imageView, TextView textView, View view, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, RatioImageView ratioImageView) {
            this(imageView, textView, (TextView) null, (TTRatingBar2) null, view, textView2, imageView2);
            this.c = textView3;
            this.b = textView4;
            this.a = ratioImageView;
        }

        a(TextView textView, View view, TextView textView2, ImageView imageView, TextView textView3, RatioFrameLayout ratioFrameLayout) {
            this((ImageView) null, textView, (TextView) null, (TTRatingBar2) null, view, textView2, imageView);
            this.b = textView3;
            this.k = ratioFrameLayout;
        }
    }
}
