package com.vungle.ads;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.ImpressionTracker;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.presenter.AdEventListener;
import com.vungle.ads.internal.presenter.NativeAdPresenter;
import com.vungle.ads.internal.presenter.NativePresenterDelegate;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.WatermarkView;
import com.vungle.ads.internal.ui.view.MediaView;
import com.vungle.ads.internal.util.ImageLoader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0019\u0018\u0000 V2\u00020\u0001:\u0002UVB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u00104\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b6J\u001c\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010;\u001a\u00020\u0005J\u0006\u0010<\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020\u0005J\r\u0010>\u001a\u0004\u0018\u00010?¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u0005J\u0006\u0010B\u001a\u00020\u0005J\r\u0010C\u001a\u00020\u0005H\u0000¢\u0006\u0002\bDJ\b\u0010E\u001a\u00020\u0005H\u0002J\r\u0010F\u001a\u00020\u0005H\u0000¢\u0006\u0002\bGJ\r\u0010H\u001a\u00020\u0005H\u0000¢\u0006\u0002\bIJ\u0006\u0010J\u001a\u00020KJ\u0015\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bOJ\u0006\u0010P\u001a\u000208J0\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\u0006\u0010T\u001a\u000208R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.R\u001c\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/vungle/ads/NativeAd;", "Lcom/vungle/ads/BaseAd;", "context", "Landroid/content/Context;", "placementId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "adConfig", "Lcom/vungle/ads/AdConfig;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/AdConfig;)V", "adContentView", "Lcom/vungle/ads/internal/ui/view/MediaView;", "adIconView", "Landroid/widget/ImageView;", "adOptionsPosition", "", "getAdOptionsPosition$annotations", "()V", "getAdOptionsPosition", "()I", "setAdOptionsPosition", "(I)V", "adOptionsView", "Lcom/vungle/ads/NativeAdOptionsView;", "adPlayCallback", "com/vungle/ads/NativeAd$adPlayCallback$1", "Lcom/vungle/ads/NativeAd$adPlayCallback$1;", "adRootView", "Landroid/widget/FrameLayout;", "clickableViews", "", "Landroid/view/View;", "executors", "Lcom/vungle/ads/internal/executor/Executors;", "getExecutors", "()Lcom/vungle/ads/internal/executor/Executors;", "executors$delegate", "Lkotlin/Lazy;", "imageLoader", "Lcom/vungle/ads/internal/util/ImageLoader;", "getImageLoader", "()Lcom/vungle/ads/internal/util/ImageLoader;", "imageLoader$delegate", "impressionTracker", "Lcom/vungle/ads/internal/ImpressionTracker;", "getImpressionTracker", "()Lcom/vungle/ads/internal/ImpressionTracker;", "impressionTracker$delegate", "nativeAdAssetMap", "", "presenter", "Lcom/vungle/ads/internal/presenter/NativeAdPresenter;", "constructAdInternal", "Lcom/vungle/ads/NativeAdInternal;", "constructAdInternal$vungle_ads_release", "displayImage", "", "path", "imageView", "getAdBodyText", "getAdCallToActionText", "getAdSponsoredText", "getAdStarRating", "", "()Ljava/lang/Double;", "getAdTitle", "getAppIcon", "getCtaUrl", "getCtaUrl$vungle_ads_release", "getMainImagePath", "getPrivacyIconUrl", "getPrivacyIconUrl$vungle_ads_release", "getPrivacyUrl", "getPrivacyUrl$vungle_ads_release", "hasCallToAction", "", "onAdLoaded", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "onAdLoaded$vungle_ads_release", "performCTA", "registerViewForInteraction", "rootView", "mediaView", "unregisterView", "AdOptionsPosition", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeAd.kt */
public final class NativeAd extends BaseAd {
    public static final int BOTTOM_LEFT = 2;
    public static final int BOTTOM_RIGHT = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 1;
    private MediaView adContentView;
    private ImageView adIconView;
    private int adOptionsPosition;
    private NativeAdOptionsView adOptionsView;
    private final NativeAd$adPlayCallback$1 adPlayCallback;
    private FrameLayout adRootView;
    private Collection<? extends View> clickableViews;
    private final Lazy executors$delegate;
    private final Lazy imageLoader$delegate;
    private final Lazy impressionTracker$delegate;
    private Map<String, String> nativeAdAssetMap;
    private NativeAdPresenter presenter;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/vungle/ads/NativeAd$AdOptionsPosition;", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: NativeAd.kt */
    public @interface AdOptionsPosition {
    }

    @AdOptionsPosition
    public static /* synthetic */ void getAdOptionsPosition$annotations() {
    }

    private NativeAd(Context context, String str, AdConfig adConfig) {
        super(context, str, adConfig);
        this.imageLoader$delegate = LazyKt.lazy(new NativeAd$imageLoader$2(this));
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.executors$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new NativeAd$special$$inlined$inject$1(context));
        this.impressionTracker$delegate = LazyKt.lazy(new NativeAd$impressionTracker$2(context));
        this.adOptionsPosition = 1;
        this.adOptionsView = new NativeAdOptionsView(context);
        this.adPlayCallback = new NativeAd$adPlayCallback$1(this, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NativeAd(Context context, String str) {
        this(context, str, new AdConfig());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "placementId");
        if (context instanceof Application) {
            throw new InternalError(-1000, "Activity context is required to create NativeAd instance.");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vungle/ads/NativeAd$Companion;", "", "()V", "BOTTOM_LEFT", "", "BOTTOM_RIGHT", "TOP_LEFT", "TOP_RIGHT", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NativeAd.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public NativeAdInternal constructAdInternal$vungle_ads_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NativeAdInternal(context);
    }

    private final ImageLoader getImageLoader() {
        return (ImageLoader) this.imageLoader$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Executors getExecutors() {
        return (Executors) this.executors$delegate.getValue();
    }

    private final ImpressionTracker getImpressionTracker() {
        return (ImpressionTracker) this.impressionTracker$delegate.getValue();
    }

    public final int getAdOptionsPosition() {
        return this.adOptionsPosition;
    }

    public final void setAdOptionsPosition(int i) {
        this.adOptionsPosition = i;
    }

    public void onAdLoaded$vungle_ads_release(AdPayload adPayload) {
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        super.onAdLoaded$vungle_ads_release(adPayload);
        this.nativeAdAssetMap = adPayload.getMRAIDArgsInMap();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_APP_ICON);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAppIcon() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "APP_ICON"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getAppIcon():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_APP_NAME);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAdTitle() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "APP_NAME"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getAdTitle():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_APP_DESCRIPTION);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAdBodyText() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "APP_DESCRIPTION"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getAdBodyText():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_CTA_BUTTON_TEXT);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAdCallToActionText() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "CTA_BUTTON_TEXT"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getAdCallToActionText():java.lang.String");
    }

    public final Double getAdStarRating() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        if (map == null || (str = map.get(NativeAdInternal.TOKEN_APP_RATING_VALUE)) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Double.valueOf(str);
        } catch (Exception unused) {
            Double d = null;
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_SPONSORED_BY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAdSponsoredText() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "SPONSORED_BY"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getAdSponsoredText():java.lang.String");
    }

    public final boolean hasCallToAction() {
        return getCtaUrl$vungle_ads_release().length() > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_VUNGLE_PRIVACY_ICON_URL);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPrivacyIconUrl$vungle_ads_release() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "VUNGLE_PRIVACY_ICON_URL"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getPrivacyIconUrl$vungle_ads_release():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_VUNGLE_PRIVACY_URL);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPrivacyUrl$vungle_ads_release() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "VUNGLE_PRIVACY_URL"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getPrivacyUrl$vungle_ads_release():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_CTA_BUTTON_URL);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getCtaUrl$vungle_ads_release() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "CTA_BUTTON_URL"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getCtaUrl$vungle_ads_release():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(com.vungle.ads.NativeAdInternal.TOKEN_MAIN_IMAGE);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getMainImagePath() {
        /*
            r2 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r2.nativeAdAssetMap
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "MAIN_IMAGE"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            java.lang.String r0 = ""
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.NativeAd.getMainImagePath():java.lang.String");
    }

    public final void unregisterView() {
        if (getAdInternal().getAdState() != AdInternal.AdState.FINISHED) {
            Collection<? extends View> collection = this.clickableViews;
            if (collection != null) {
                for (View onClickListener : collection) {
                    onClickListener.setOnClickListener((View.OnClickListener) null);
                }
            }
            Map<String, String> map = this.nativeAdAssetMap;
            if (map != null) {
                map.clear();
            }
            getImpressionTracker().destroy();
            MediaView mediaView = this.adContentView;
            if (mediaView != null) {
                mediaView.destroy();
            }
            this.adOptionsView.destroy();
            NativeAdPresenter nativeAdPresenter = this.presenter;
            if (nativeAdPresenter != null) {
                nativeAdPresenter.detach();
            }
        }
    }

    public final void registerViewForInteraction(FrameLayout frameLayout, MediaView mediaView, ImageView imageView, Collection<? extends View> collection) {
        String str;
        Intrinsics.checkNotNullParameter(frameLayout, "rootView");
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.PLAY_AD_API), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
        VungleError canPlayAd = getAdInternal().canPlayAd(true);
        if (canPlayAd != null) {
            if (getAdInternal().isErrorTerminal$vungle_ads_release(canPlayAd.getCode())) {
                getAdInternal().setAdState(AdInternal.AdState.ERROR);
                Map<String, String> map = this.nativeAdAssetMap;
                if (map != null) {
                    map.clear();
                }
            }
            BaseAdListener adListener = getAdListener();
            if (adListener != null) {
                adListener.onAdFailedToPlay(this, canPlayAd);
                return;
            }
            return;
        }
        getResponseToShowMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric$vungle_ads_release(), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
        getShowToDisplayMetric$vungle_ads_release().markStart();
        this.adRootView = frameLayout;
        this.adContentView = mediaView;
        this.adIconView = imageView;
        this.clickableViews = collection;
        Context context = getContext();
        AdInternal adInternal = getAdInternal();
        Intrinsics.checkNotNull(adInternal, "null cannot be cast to non-null type com.vungle.ads.internal.presenter.NativePresenterDelegate");
        this.presenter = new NativeAdPresenter(context, (NativePresenterDelegate) adInternal, getAdInternal().getAdvertisement(), getExecutors().getJobExecutor());
        Map<String, String> map2 = this.nativeAdAssetMap;
        if (map2 == null || (str = map2.get(NativeAdInternal.TOKEN_OM_SDK_DATA)) == null) {
            str = "";
        }
        NativeAdPresenter nativeAdPresenter = this.presenter;
        if (nativeAdPresenter != null) {
            nativeAdPresenter.initOMTracker(str);
        }
        NativeAdPresenter nativeAdPresenter2 = this.presenter;
        if (nativeAdPresenter2 != null) {
            nativeAdPresenter2.startTracking(frameLayout);
        }
        NativeAdPresenter nativeAdPresenter3 = this.presenter;
        if (nativeAdPresenter3 != null) {
            nativeAdPresenter3.setEventListener(new AdEventListener(this.adPlayCallback, getAdInternal().getPlacement()));
        }
        this.adOptionsView.setOnClickListener(new NativeAd$$ExternalSyntheticLambda0(this));
        if (collection == null) {
            collection = CollectionsKt.listOf(mediaView);
        }
        for (View onClickListener : collection) {
            onClickListener.setOnClickListener(new NativeAd$$ExternalSyntheticLambda1(this));
        }
        this.adOptionsView.renderTo(frameLayout, this.adOptionsPosition);
        getImpressionTracker().addView(frameLayout, new NativeAd$$ExternalSyntheticLambda2(this));
        displayImage(getMainImagePath(), mediaView.getMainImage$vungle_ads_release());
        displayImage(getAppIcon(), imageView);
        displayImage(getPrivacyIconUrl$vungle_ads_release(), this.adOptionsView.getPrivacyIcon$vungle_ads_release());
        String watermark$vungle_ads_release = getAdConfig().getWatermark$vungle_ads_release();
        if (watermark$vungle_ads_release != null) {
            Context context2 = frameLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
            WatermarkView watermarkView = new WatermarkView(context2, watermark$vungle_ads_release);
            frameLayout.addView(watermarkView);
            watermarkView.bringToFront();
        }
        NativeAdPresenter nativeAdPresenter4 = this.presenter;
        if (nativeAdPresenter4 != null) {
            nativeAdPresenter4.prepare();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerViewForInteraction$lambda-1  reason: not valid java name */
    public static final void m2261registerViewForInteraction$lambda1(NativeAd nativeAd, View view) {
        Intrinsics.checkNotNullParameter(nativeAd, "this$0");
        NativeAdPresenter nativeAdPresenter = nativeAd.presenter;
        if (nativeAdPresenter != null) {
            nativeAdPresenter.processCommand("openPrivacy", nativeAd.getPrivacyUrl$vungle_ads_release());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerViewForInteraction$lambda-3$lambda-2  reason: not valid java name */
    public static final void m2262registerViewForInteraction$lambda3$lambda2(NativeAd nativeAd, View view) {
        Intrinsics.checkNotNullParameter(nativeAd, "this$0");
        NativeAdPresenter nativeAdPresenter = nativeAd.presenter;
        if (nativeAdPresenter != null) {
            nativeAdPresenter.processCommand(NativeAdPresenter.DOWNLOAD, nativeAd.getCtaUrl$vungle_ads_release());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerViewForInteraction$lambda-4  reason: not valid java name */
    public static final void m2263registerViewForInteraction$lambda4(NativeAd nativeAd, View view) {
        Intrinsics.checkNotNullParameter(nativeAd, "this$0");
        NativeAdPresenter nativeAdPresenter = nativeAd.presenter;
        if (nativeAdPresenter != null) {
            NativeAdPresenter.processCommand$default(nativeAdPresenter, "videoViewed", (String) null, 2, (Object) null);
        }
        NativeAdPresenter nativeAdPresenter2 = nativeAd.presenter;
        if (nativeAdPresenter2 != null) {
            nativeAdPresenter2.processCommand("tpat", Constants.CHECKPOINT_0);
        }
        NativeAdPresenter nativeAdPresenter3 = nativeAd.presenter;
        if (nativeAdPresenter3 != null) {
            nativeAdPresenter3.onImpression();
        }
    }

    public final void performCTA() {
        NativeAdPresenter nativeAdPresenter = this.presenter;
        if (nativeAdPresenter != null) {
            nativeAdPresenter.processCommand(NativeAdPresenter.DOWNLOAD, getCtaUrl$vungle_ads_release());
        }
    }

    private final void displayImage(String str, ImageView imageView) {
        getImageLoader().displayImage(str, new NativeAd$displayImage$1(imageView));
    }
}
