package com.appnext.nativeads.designed_native_ads.views.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.SettingsManager;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.nativeads.R;
import com.appnext.nativeads.designed_native_ads.AppnextDesignedNativeAdData;
import com.appnext.nativeads.designed_native_ads.DesignNativeAd;
import com.appnext.nativeads.designed_native_ads.DesignNativeAdsRequest;
import com.appnext.nativeads.designed_native_ads.a;
import com.appnext.nativeads.designed_native_ads.c;
import com.appnext.nativeads.designed_native_ads.d;
import com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide;
import java.util.HashMap;
import java.util.List;

public abstract class a extends LinearLayout implements a.C0027a {
    private Context aM;
    private String fG;
    private com.appnext.nativeads.designed_native_ads.a fZ;
    /* access modifiers changed from: private */
    public d ga;
    private ImageView gb;
    private ViewGroup gc;
    private ViewGroup gd;
    private int ge;
    /* access modifiers changed from: private */
    public C0029a gf;
    private int mBackgroundColor;

    /* renamed from: com.appnext.nativeads.designed_native_ads.views.a.a$a  reason: collision with other inner class name */
    public interface C0029a {
        void onAdClicked(AppnextDesignedNativeAdData appnextDesignedNativeAdData);

        void onAdsLoadedSuccessfully();

        void onError(AppnextError appnextError);
    }

    public interface b {
        void aM();
    }

    /* access modifiers changed from: protected */
    public abstract void a(boolean z);

    /* access modifiers changed from: protected */
    public abstract void f(List<DesignNativeAd> list);

    /* access modifiers changed from: protected */
    public abstract int getContentResource();

    /* access modifiers changed from: protected */
    public abstract void setIconTitleTextColor(int i);

    /* access modifiers changed from: protected */
    public abstract void setTitleText(String str);

    /* access modifiers changed from: protected */
    public abstract void setTitleTextColorForAdUnit(int i);

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aM = context;
        try {
            setVisibility(8);
            inflate(this.aM, R.layout.design_native_ads_layout, this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            setSuggestedAppsBackgroundColor(-1);
            ((FrameLayout) findViewById(R.id.design_native_ads_container)).addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(getContentResource(), (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1));
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$buildView", th);
        }
    }

    public final void a(String str, final b bVar) {
        com.appnext.nativeads.designed_native_ads.a aVar = new com.appnext.nativeads.designed_native_ads.a();
        this.fZ = aVar;
        aVar.a(this);
        c.aG().a(getContext().getApplicationContext(), str, new SettingsManager.ConfigCallback() {
            public final void loaded(HashMap<String, Object> hashMap) {
                try {
                    a.this.aN();
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.aM();
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("DesignedNativeAdView$init", th);
                }
            }

            public final void error(String str) {
                try {
                    a.this.aN();
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.aM();
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("DesignedNativeAdView$init", th);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void aN() {
        try {
            setTitle(c.aG().t("title"));
            setTitleTextColor(Color.parseColor(c.aG().t("title_text_color")));
            setAmountOfApps(Integer.parseInt(c.aG().t("amount_of_icons")));
            a(Boolean.parseBoolean(c.aG().t("present_titles")));
            setIconAppTitleTextColor(Color.parseColor(c.aG().t("app_title_text_color")));
            setLocalDirection(Boolean.parseBoolean(c.aG().t("local_direction")));
            setSuggestedBackgroundColor(Color.parseColor(c.aG().t("background_color")));
            setTransparency(Integer.parseInt(c.aG().t("transparency")));
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$initParameters", th);
        }
    }

    public final void a(String str, DesignNativeAdsRequest designNativeAdsRequest, C0029a aVar) {
        try {
            this.gf = aVar;
            this.fG = str;
            this.fZ.a(this.aM, str, designNativeAdsRequest, this.ge);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$load", th);
        }
    }

    private void setSuggestedAppsBackgroundColor(int i) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(30.0f);
            setBackground(gradientDrawable);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$setSuggestedAppsBackgroundColor", th);
        }
    }

    private void setPrivacyIcon(final AppnextAd appnextAd) {
        this.gc.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(g.e(appnextAd)));
                    intent.setFlags(268435456);
                    a.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    com.appnext.base.a.a("DesignedNativeAdView$buildView", th);
                }
            }
        });
        if (i.a(appnextAd, (SettingsManager) c.aG())) {
            i.a(getContext(), this.gb);
        } else {
            this.gb.setImageResource(R.drawable.apnxt_na_i_icon_dark);
        }
    }

    public final void d(List<DesignNativeAd> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    setVisibility(0);
                    setPrivacyIcon(list.get(0));
                    this.ga = new d(this.aM, list, this.fG);
                    f(list);
                    C0029a aVar = this.gf;
                    if (aVar != null) {
                        aVar.onAdsLoadedSuccessfully();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("DesignedNativeAdView$onLoaded", th);
                return;
            }
        }
        setVisibility(8);
        C0029a aVar2 = this.gf;
        if (aVar2 != null) {
            aVar2.onError(new AppnextError(AppnextError.INTERNAL_ERROR));
        }
    }

    public final void onError(AppnextError appnextError) {
        try {
            setVisibility(8);
            C0029a aVar = this.gf;
            if (aVar != null) {
                aVar.onError(appnextError);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$onError", th);
        }
    }

    public void setAmountOfApps(int i) {
        this.ge = i;
    }

    public int getAmountOfApps() {
        return this.ge;
    }

    public void setPresentTitles(boolean z) {
        a(z);
    }

    public void setTitleTextColor(int i) {
        setTitleTextColorForAdUnit(i);
    }

    public void setTitle(String str) {
        setTitleText(str);
    }

    public void setLocalDirection(boolean z) {
        if (z) {
            try {
                setLayoutDirection(3);
            } catch (Throwable th) {
                com.appnext.base.a.a("DesignedNativeAdView$setLocalDirection", th);
            }
        } else {
            setLayoutDirection(0);
        }
    }

    public void setIconAppTitleTextColor(int i) {
        setIconTitleTextColor(i);
    }

    public void setSuggestedBackgroundColor(int i) {
        this.mBackgroundColor = i;
        setSuggestedAppsBackgroundColor(i);
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setTransparency(int i) {
        try {
            float min = (float) Math.min(100, i);
            if (min < 0.0f) {
                min = 0.0f;
            }
            setAlpha(min / 100.0f);
        } catch (Throwable th) {
            com.appnext.base.a.a("DesignedNativeAdView$setTransparency", th);
        }
    }

    /* renamed from: com.appnext.nativeads.designed_native_ads.views.a.a$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] fY;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide[] r0 = com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                fY = r0
                com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide r1 = com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide.Right     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = fY     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide r1 = com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide.Left     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnext.nativeads.designed_native_ads.views.a.a.AnonymousClass5.<clinit>():void");
        }
    }

    public void setPrivacyIconSide(AppnextSuggestedAppsImageSide appnextSuggestedAppsImageSide) {
        int i = AnonymousClass5.fY[appnextSuggestedAppsImageSide.ordinal()];
        if (i == 1) {
            this.gb = (ImageView) findViewById(R.id.privacy_icon_right);
            this.gc = (ViewGroup) findViewById(R.id.privacy_icon_container_right);
            this.gd = (ViewGroup) findViewById(R.id.privacy_icon_container_left);
        } else if (i == 2) {
            this.gb = (ImageView) findViewById(R.id.privacy_icon_left);
            this.gc = (ViewGroup) findViewById(R.id.privacy_icon_container_left);
            this.gd = (ViewGroup) findViewById(R.id.privacy_icon_container_right);
        }
        this.gc.setVisibility(0);
        this.gd.setVisibility(4);
    }
}
