package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.RatioFrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.google.android.material.badge.BadgeDrawable;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.List;

public class VastBannerBackupView extends BackupView implements c.C0035c, c.d {
    public boolean a = true;
    private NativeExpressView m;
    private com.com.bytedance.overseas.sdk.a.c n;
    /* access modifiers changed from: private */
    public NativeVideoTsView o;
    /* access modifiers changed from: private */
    public ShadowImageView p;
    private String q;
    /* access modifiers changed from: private */
    public long r;
    /* access modifiers changed from: private */
    public PAGBannerAdWrapperListener s;

    public void a_() {
    }

    public void d_() {
    }

    public void e_() {
    }

    public void g_() {
    }

    public VastBannerBackupView(Context context) {
        super(context);
        this.b = context;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, m mVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, mVar);
            NativeVideoTsView nativeVideoTsView = this.o;
            if (nativeVideoTsView != null && (nativeVideoTsView.getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c)) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.o.getNativeVideoController()).G();
            }
        }
    }

    public void setClosedListenerKey(String str) {
        this.q = str;
    }

    public void a(q qVar, NativeExpressView nativeExpressView, com.com.bytedance.overseas.sdk.a.c cVar) {
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.c = qVar;
        this.m = nativeExpressView;
        this.n = cVar;
        this.f = "banner_ad";
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        f();
    }

    private void f() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.m a2 = BannerExpressBackupView.a(this.m.getExpectExpressWidth(), this.m.getExpectExpressHeight());
        if (this.m.getExpectExpressWidth() <= 0 || this.m.getExpectExpressHeight() <= 0) {
            this.g = ad.c(this.b);
            this.h = Float.valueOf(((float) this.g) / a2.b).intValue();
        } else {
            this.g = ad.b(this.b, (float) this.m.getExpectExpressWidth());
            this.h = ad.b(this.b, (float) this.m.getExpectExpressHeight());
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
        g();
    }

    private void g() {
        if (this.c != null) {
            int ad = this.c.ad();
            a h = h();
            if (h != null && h.a != null) {
                addView(h.a);
                ShadowImageView shadowImageView = h.d;
                TTBackUpAdImageView tTBackUpAdImageView = h.e;
                PAGImageView pAGImageView = h.f;
                if (pAGImageView != null && this.c.h()) {
                    ad.a((View) pAGImageView, 0);
                    com.bytedance.sdk.openadsdk.k.c.a().a((int) ad.a(o.a(), 11.0f, true), (ImageView) pAGImageView, this.c);
                }
                this.p = h.c;
                NativeVideoTsView videoView = getVideoView();
                if (videoView instanceof NativeVideoTsView) {
                    NativeVideoTsView nativeVideoTsView = videoView;
                    this.o = videoView;
                    videoView.setVideoAdLoadListener(this);
                    this.o.setVideoAdInteractionListener(this);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Pair(shadowImageView, FriendlyObstructionPurpose.CLOSE_AD));
                    arrayList.add(new Pair(tTBackUpAdImageView, FriendlyObstructionPurpose.OTHER));
                    arrayList.add(new Pair(pAGImageView, FriendlyObstructionPurpose.OTHER));
                    arrayList.add(new Pair(this.p, FriendlyObstructionPurpose.VIDEO_CONTROLS));
                    this.o.a((List<Pair<View, FriendlyObstructionPurpose>>) arrayList);
                    this.o.setAdCreativeClickListener(new NativeVideoTsView.a() {
                        public void a(View view, int i) {
                            if (VastBannerBackupView.this.s != null) {
                                VastBannerBackupView.this.s.onAdClicked(view, i);
                            }
                        }
                    });
                }
                if (tTBackUpAdImageView != null) {
                    tTBackUpAdImageView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            TTWebsiteActivity.a(VastBannerBackupView.this.b, VastBannerBackupView.this.c, VastBannerBackupView.this.f);
                        }
                    });
                }
                if (shadowImageView != null) {
                    shadowImageView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            VastBannerBackupView.this.a();
                        }
                    });
                    NativeExpressView nativeExpressView = this.m;
                    if (nativeExpressView != null) {
                        if (nativeExpressView.getClickListener() != null) {
                            this.m.getClickListener().b((View) shadowImageView);
                        }
                        if (this.m.getClickCreativeListener() != null) {
                            this.m.getClickCreativeListener().b((View) shadowImageView);
                        }
                    }
                }
                ShadowImageView shadowImageView2 = this.p;
                if (shadowImageView2 != null) {
                    shadowImageView2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            int i;
                            if (VastBannerBackupView.this.o != null) {
                                boolean z = !VastBannerBackupView.this.o.i();
                                VastBannerBackupView vastBannerBackupView = VastBannerBackupView.this;
                                if (z) {
                                    i = s.d(vastBannerBackupView.getContext(), "tt_mute_wrapper");
                                } else {
                                    i = s.d(vastBannerBackupView.getContext(), "tt_unmute_wrapper");
                                }
                                VastBannerBackupView.this.o.setIsQuiet(z);
                                VastBannerBackupView.this.p.setImageResource(i);
                                if (VastBannerBackupView.this.c != null && VastBannerBackupView.this.c.au() != null && VastBannerBackupView.this.c.au().a() != null) {
                                    if (z) {
                                        VastBannerBackupView.this.c.au().a().h(VastBannerBackupView.this.r);
                                    } else {
                                        VastBannerBackupView.this.c.au().a().i(VastBannerBackupView.this.r);
                                    }
                                }
                            }
                        }
                    });
                }
                RatioFrameLayout ratioFrameLayout = h.b;
                if (!(this.c == null || this.c.au() == null || ratioFrameLayout == null)) {
                    int l = this.c.au().l();
                    float m2 = (float) this.c.au().m();
                    if (l > 0 && m2 > 0.0f) {
                        ratioFrameLayout.setRatio(((float) l) / m2);
                    } else if (ad == 15) {
                        ratioFrameLayout.setRatio(0.5625f);
                    } else if (ad == 5) {
                        ratioFrameLayout.setRatio(1.7777778f);
                    } else {
                        ratioFrameLayout.setRatio(1.0f);
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (!(videoView == null || ratioFrameLayout == null)) {
                    ratioFrameLayout.addView(videoView, layoutParams);
                    videoView.setTag(520093762, true);
                }
                a(videoView, true);
                a(this, true);
                a((View) ratioFrameLayout);
            }
        }
    }

    private a h() {
        a aVar = new a();
        aVar.a = new FrameLayout(this.b);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        aVar.a.setLayoutParams(layoutParams);
        aVar.b = new RatioFrameLayout(this.b);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        aVar.b.setLayoutParams(layoutParams2);
        aVar.a.addView(aVar.b);
        int b = ad.b(this.b, 20.0f);
        int b2 = ad.b(this.b, 5.0f);
        aVar.c = new ShadowImageView(this.b);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(b, b);
        layoutParams3.setMargins(b2, b2, b2, b2);
        aVar.c.setScaleType(ImageView.ScaleType.CENTER);
        aVar.c.setImageDrawable(s.c(this.b, "tt_mute_wrapper"));
        aVar.c.setBackground(s.c(this.b, "tt_mute_btn_bg"));
        aVar.c.setLayoutParams(layoutParams3);
        aVar.a.addView(aVar.c);
        aVar.d = new ShadowImageView(this.b);
        aVar.d.setId(520093697);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(b, b);
        layoutParams4.gravity = GravityCompat.END;
        int b3 = ad.b(this.b, 7.0f);
        int b4 = ad.b(this.b, 3.0f);
        layoutParams4.setMargins(b3, b3, b3, b3);
        aVar.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        aVar.d.setPadding(b4, b4, b4, b4);
        aVar.d.setImageDrawable(s.c(this.b, "tt_pangle_ad_close_drawable"));
        aVar.d.setBackground(s.c(this.b, "tt_mute_btn_bg"));
        aVar.d.setLayoutParams(layoutParams4);
        aVar.a.addView(aVar.d);
        aVar.e = new TTBackUpAdImageView(this.b);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams5.setMargins(b2, b2, b2, b2);
        aVar.e.setLayoutParams(layoutParams5);
        aVar.a.addView(aVar.e);
        aVar.f = new PAGImageView(this.b);
        int b5 = ad.b(this.b, 11.0f);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(b5, b5);
        layoutParams6.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams6.rightMargin = b2;
        layoutParams6.bottomMargin = b2;
        aVar.f.setVisibility(8);
        aVar.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
        aVar.f.setLayoutParams(layoutParams6);
        aVar.a.addView(aVar.f);
        return aVar;
    }

    public void a() {
        if (this.e != null) {
            this.e.show();
        } else if (this.d != null) {
            this.d.a();
        } else {
            TTDelegateActivity.a(this.c, this.q);
        }
    }

    public void a(int i, int i2) {
        ShadowImageView shadowImageView = this.p;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(8);
        }
    }

    public void a(long j, long j2) {
        this.r = j;
    }

    public void f_() {
        ShadowImageView shadowImageView = this.p;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(8);
        }
    }

    public long getVideoProgress() {
        return this.r;
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.s = pAGBannerAdWrapperListener;
    }

    private static class a {
        public FrameLayout a;
        public RatioFrameLayout b;
        public ShadowImageView c;
        public ShadowImageView d;
        public TTBackUpAdImageView e;
        public PAGImageView f;

        private a() {
        }
    }
}
