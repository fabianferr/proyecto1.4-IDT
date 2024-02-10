package com.applovin.mediation.nativeAds;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.impl.mediation.a.d;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.ads.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;

public class MaxNativeAdView extends FrameLayout {
    public static final String MEDIUM_TEMPLATE_1 = "medium_template_1";
    private final View a;
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final ImageView e;
    private final FrameLayout f;
    private final ViewGroup g;
    private final FrameLayout h;
    private final ViewGroup i;
    private final FrameLayout j;
    private final Button k;
    private b l;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, (String) null, activity);
        String str = null;
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        super(context);
        View inflate;
        boolean z = maxNativeAdViewBinder.templateType != null;
        MaxAdFormat format = maxNativeAd != null ? maxNativeAd.getFormat() : MaxAdFormat.NATIVE;
        if (maxNativeAdViewBinder.mainView != null) {
            inflate = maxNativeAdViewBinder.mainView;
        } else {
            inflate = LayoutInflater.from(context).inflate(z ? a(maxNativeAdViewBinder.templateType, format) : maxNativeAdViewBinder.layoutResourceId, this, false);
        }
        this.a = inflate;
        addView(this.a);
        this.b = (TextView) findViewById(maxNativeAdViewBinder.titleTextViewId);
        this.c = (TextView) findViewById(maxNativeAdViewBinder.advertiserTextViewId);
        this.d = (TextView) findViewById(maxNativeAdViewBinder.bodyTextViewId);
        this.e = (ImageView) findViewById(maxNativeAdViewBinder.iconImageViewId);
        this.f = (FrameLayout) findViewById(maxNativeAdViewBinder.iconContentViewId);
        this.g = (ViewGroup) findViewById(maxNativeAdViewBinder.optionsContentViewGroupId);
        this.h = (FrameLayout) findViewById(maxNativeAdViewBinder.optionsContentFrameLayoutId);
        this.i = (ViewGroup) findViewById(maxNativeAdViewBinder.mediaContentViewGroupId);
        this.j = (FrameLayout) findViewById(maxNativeAdViewBinder.mediaContentFrameLayoutId);
        this.k = (Button) findViewById(maxNativeAdViewBinder.callToActionButtonId);
        if (maxNativeAd != null) {
            a(maxNativeAd);
        }
    }

    @Deprecated
    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        this(maxNativeAd, str, activity.getApplicationContext());
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Context context) {
        this(maxNativeAd, new MaxNativeAdViewBinder.Builder(-1).setTemplateType(str).setTitleTextViewId(R.id.native_title_text_view).setAdvertiserTextViewId(R.id.native_advertiser_text_view).setBodyTextViewId(R.id.native_body_text_view).setIconImageViewId(R.id.native_icon_image_view).setIconContentViewId(R.id.native_icon_view).setOptionsContentViewGroupId(R.id.options_view).setOptionsContentFrameLayoutId(R.id.options_view).setMediaContentViewGroupId(R.id.native_media_content_view).setMediaContentFrameLayoutId(R.id.native_media_content_view).setCallToActionButtonId(R.id.native_cta_button).build(), context);
    }

    public MaxNativeAdView(MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this((MaxNativeAd) null, maxNativeAdViewBinder, context);
    }

    public MaxNativeAdView(String str, Context context) {
        this((MaxNativeAd) null, str, context);
    }

    private int a(String str, MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.NATIVE) {
            if ("small_template_1".equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_small_template_1;
            }
            if (MEDIUM_TEMPLATE_1.equalsIgnoreCase(str)) {
                return R.layout.max_native_ad_medium_template_1;
            }
            throw new IllegalArgumentException("Attempting to render MAX native ad with invalid format: " + str);
        } else if (maxAdFormat == MaxAdFormat.BANNER) {
            return "vertical_banner_template".equals(str) ? R.layout.max_native_ad_vertical_banner_view : ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) ? R.layout.max_native_ad_media_banner_view : "vertical_media_banner_template".equals(str) ? R.layout.max_native_ad_vertical_media_banner_view : R.layout.max_native_ad_banner_view;
        } else {
            if (maxAdFormat == MaxAdFormat.LEADER) {
                return "vertical_leader_template".equals(str) ? R.layout.max_native_ad_vertical_leader_view : R.layout.max_native_ad_leader_view;
            }
            if (maxAdFormat == MaxAdFormat.MREC) {
                return R.layout.max_native_ad_mrec_view;
            }
            throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
        }
    }

    private void a() {
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.inner_parent_layout);
        if (viewGroup != null) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                final WeakReference weakReference = new WeakReference(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                            m mVar = AppLovinSdk.getInstance(MaxNativeAdView.this.getContext()).coreSdk;
                            if (u.a()) {
                                mVar.A().d("MaxNativeAdView", "Failed to remove onPreDrawListener since the view tree observer is not alive.");
                            }
                        } else {
                            viewTreeObserver.removeOnPreDrawListener(this);
                        }
                        weakReference.clear();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                        layoutParams.height = ((View) viewGroup.getParent()).getWidth();
                        viewGroup.setLayoutParams(layoutParams);
                        return true;
                    }
                });
            }
        }
    }

    private void a(MaxNativeAd maxNativeAd) {
        this.b.setText(maxNativeAd.getTitle());
        if (this.c != null) {
            if (StringUtils.isValidString(maxNativeAd.getAdvertiser())) {
                this.c.setText(maxNativeAd.getAdvertiser());
            } else {
                this.c.setVisibility(8);
            }
        }
        if (this.d != null) {
            if (StringUtils.isValidString(maxNativeAd.getBody())) {
                this.d.setText(maxNativeAd.getBody());
            } else {
                this.d.setVisibility(4);
            }
        }
        if (this.k != null) {
            if (StringUtils.isValidString(maxNativeAd.getCallToAction())) {
                this.k.setText(maxNativeAd.getCallToAction());
            } else {
                this.k.setVisibility(4);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        View iconView = maxNativeAd.getIconView();
        FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            if (icon == null || this.e == null) {
                if (iconView != null) {
                    iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.f.removeAllViews();
                    this.f.addView(iconView);
                } else {
                    frameLayout.setVisibility(8);
                }
            } else if (icon.getDrawable() != null) {
                this.e.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() == null || !StringUtils.isValidString(icon.getUri().toString())) {
                this.f.setVisibility(8);
            } else {
                this.e.setImageURI(icon.getUri());
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        FrameLayout frameLayout2 = this.h;
        if (frameLayout2 != null && optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.h.addView(optionsView);
            this.h.bringToFront();
        } else if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        View mediaView = maxNativeAd.getMediaView();
        if (this.j != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.j.addView(mediaView);
            } else if (maxNativeAd.getFormat() == MaxAdFormat.LEADER) {
                this.j.setVisibility(8);
            }
        }
        a();
        postDelayed(new Runnable() {
            public void run() {
                MaxNativeAdView.this.setSelected(true);
            }
        }, 2000);
    }

    private void b(MaxNativeAd maxNativeAd) {
        if (this.b != null) {
            if (StringUtils.isValidString(maxNativeAd.getTitle())) {
                this.b.setText(maxNativeAd.getTitle());
            } else {
                this.b.setText((CharSequence) null);
            }
        }
        String body = maxNativeAd.getBody();
        if (this.d != null) {
            if (StringUtils.isValidString(body)) {
                this.d.setText(body);
            } else {
                this.d.setText((CharSequence) null);
            }
        }
        String advertiser = maxNativeAd.getAdvertiser();
        if (this.c != null) {
            if (StringUtils.isValidString(advertiser)) {
                this.c.setText(advertiser);
            } else {
                this.c.setText((CharSequence) null);
            }
        }
        String callToAction = maxNativeAd.getCallToAction();
        if (this.k != null) {
            if (StringUtils.isValidString(callToAction)) {
                this.k.setText(callToAction);
            } else {
                this.k.setText((CharSequence) null);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        ImageView imageView = this.e;
        if (imageView != null) {
            if (icon == null) {
                imageView.setImageDrawable((Drawable) null);
            } else if (icon.getDrawable() != null) {
                this.e.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() != null) {
                this.e.setImageURI(icon.getUri());
            } else {
                this.e.setImageDrawable((Drawable) null);
            }
        }
        View mediaView = maxNativeAd.getMediaView();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            if (mediaView != null) {
                ViewParent parent = mediaView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeAllViews();
                }
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.i.addView(mediaView);
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        ViewGroup viewGroup2 = this.g;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            if (optionsView != null) {
                ViewParent parent2 = optionsView.getParent();
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeAllViews();
                }
                optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.g.addView(optionsView);
                this.g.bringToFront();
            }
        }
    }

    public b getAdViewTracker() {
        return this.l;
    }

    public TextView getAdvertiserTextView() {
        return this.c;
    }

    public TextView getBodyTextView() {
        return this.d;
    }

    public Button getCallToActionButton() {
        return this.k;
    }

    @Deprecated
    public FrameLayout getIconContentView() {
        return this.f;
    }

    public ImageView getIconImageView() {
        return this.e;
    }

    public View getMainView() {
        return this.a;
    }

    @Deprecated
    public FrameLayout getMediaContentView() {
        return this.j;
    }

    public ViewGroup getMediaContentViewGroup() {
        ViewGroup viewGroup = this.i;
        return viewGroup != null ? viewGroup : this.j;
    }

    @Deprecated
    public FrameLayout getOptionsContentView() {
        return this.h;
    }

    public ViewGroup getOptionsContentViewGroup() {
        ViewGroup viewGroup = this.g;
        return viewGroup != null ? viewGroup : this.h;
    }

    public TextView getTitleTextView() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.l;
        if (bVar != null) {
            bVar.b();
        }
        if (!isHardwareAccelerated() && u.a()) {
            u.h("MaxNativeAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
        }
    }

    public void recycle() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.a();
            this.l = null;
        }
        View view = this.a;
        if (view != null && view.getParent() != this) {
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                removeView(viewGroup);
            }
            addView(this.a);
        }
    }

    public void render(d dVar, a.C0011a aVar, m mVar) {
        recycle();
        if (!dVar.y().get() || !dVar.x().get()) {
            this.l = new b(dVar, aVar, mVar);
        }
        MaxNativeAd nativeAd = dVar.getNativeAd();
        if (StringUtils.isValidString(dVar.v())) {
            if (u.a()) {
                mVar.A().b("MaxNativeAdView", "Rendering template ad view");
            }
            a(nativeAd);
            return;
        }
        if (u.a()) {
            mVar.A().b("MaxNativeAdView", "Rendering custom ad view");
        }
        b(nativeAd);
    }
}
