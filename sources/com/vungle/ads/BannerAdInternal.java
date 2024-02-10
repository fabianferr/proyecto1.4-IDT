package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0010¢\u0006\u0002\b\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vungle/ads/BannerAdInternal;", "Lcom/vungle/ads/internal/AdInternal;", "context", "Landroid/content/Context;", "adSize", "Lcom/vungle/ads/BannerAdSize;", "(Landroid/content/Context;Lcom/vungle/ads/BannerAdSize;)V", "adLoadedAndUpdateConfigure", "", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "adLoadedAndUpdateConfigure$vungle_ads_release", "getAdSizeForAdRequest", "", "isBannerAdSize", "", "isBannerAdSize$vungle_ads_release", "isValidAdSize", "isValidAdTypeForPlacement", "placement", "Lcom/vungle/ads/internal/model/Placement;", "wrapCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallbackWrapper;", "adPlayCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "wrapCallback$vungle_ads_release", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BannerAd.kt */
public final class BannerAdInternal extends AdInternal {
    private final BannerAdSize adSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerAdInternal(Context context, BannerAdSize bannerAdSize) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bannerAdSize, "adSize");
        this.adSize = bannerAdSize;
    }

    public final AdPlayCallbackWrapper wrapCallback$vungle_ads_release(AdPlayCallback adPlayCallback) {
        Intrinsics.checkNotNullParameter(adPlayCallback, "adPlayCallback");
        return new BannerAdInternal$wrapCallback$1(adPlayCallback, this);
    }

    public boolean isValidAdTypeForPlacement(Placement placement) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        return placement.isBanner();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) com.vungle.ads.BannerAdSize.VUNGLE_MREC.getSizeName()) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) com.vungle.ads.BannerAdSize.VUNGLE_MREC.getSizeName()) != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValidAdSize(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "adSize"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r9.isBannerAdSize$vungle_ads_release(r10)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002c
            com.vungle.ads.internal.model.Placement r3 = r9.getPlacement()
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.isMREC()
            if (r3 != r1) goto L_0x001b
            r3 = 1
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            if (r3 == 0) goto L_0x002c
            com.vungle.ads.BannerAdSize r3 = com.vungle.ads.BannerAdSize.VUNGLE_MREC
            java.lang.String r3 = r3.getSizeName()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x002c
        L_0x002a:
            r0 = 0
            goto L_0x004b
        L_0x002c:
            if (r0 == 0) goto L_0x004b
            com.vungle.ads.internal.model.Placement r3 = r9.getPlacement()
            if (r3 == 0) goto L_0x003b
            boolean r3 = r3.isBannerNonMREC()
            if (r3 != r1) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            if (r1 == 0) goto L_0x004b
            com.vungle.ads.BannerAdSize r1 = com.vungle.ads.BannerAdSize.VUNGLE_MREC
            java.lang.String r1 = r1.getSizeName()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x004b
            goto L_0x002a
        L_0x004b:
            if (r0 != 0) goto L_0x0084
            com.vungle.ads.AnalyticsClient r1 = com.vungle.ads.AnalyticsClient.INSTANCE
            r2 = 500(0x1f4, float:7.0E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalidate size "
            r3.<init>(r4)
            r3.append(r10)
            java.lang.String r10 = " for banner ad"
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            com.vungle.ads.internal.model.Placement r10 = r9.getPlacement()
            r4 = 0
            if (r10 == 0) goto L_0x0070
            java.lang.String r10 = r10.getReferenceId()
            goto L_0x0071
        L_0x0070:
            r10 = r4
        L_0x0071:
            r5 = 0
            com.vungle.ads.internal.model.AdPayload r6 = r9.getAdvertisement()
            if (r6 == 0) goto L_0x007c
            java.lang.String r4 = r6.eventId()
        L_0x007c:
            r6 = r4
            r7 = 8
            r8 = 0
            r4 = r10
            com.vungle.ads.AnalyticsClient.logError$vungle_ads_release$default((com.vungle.ads.AnalyticsClient) r1, (int) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (int) r7, (java.lang.Object) r8)
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.BannerAdInternal.isValidAdSize(java.lang.String):boolean");
    }

    public String getAdSizeForAdRequest() {
        return this.adSize.getSizeName();
    }

    public void adLoadedAndUpdateConfigure$vungle_ads_release(AdPayload adPayload) {
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        super.adLoadedAndUpdateConfigure$vungle_ads_release(adPayload);
        adPayload.setAdSize(this.adSize);
    }

    public final boolean isBannerAdSize$vungle_ads_release(String str) {
        Intrinsics.checkNotNullParameter(str, "adSize");
        return Intrinsics.areEqual((Object) str, (Object) BannerAdSize.BANNER.getSizeName()) || Intrinsics.areEqual((Object) str, (Object) BannerAdSize.BANNER_LEADERBOARD.getSizeName()) || Intrinsics.areEqual((Object) str, (Object) BannerAdSize.BANNER_SHORT.getSizeName()) || Intrinsics.areEqual((Object) str, (Object) BannerAdSize.VUNGLE_MREC.getSizeName());
    }
}
