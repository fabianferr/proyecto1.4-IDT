package com.ironsource.adapters.facebook.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import com.ironsource.mediationsdk.ads.nativead.internal.NativeAdViewHolder;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.List;

public class FacebookNativeAdViewBinder extends AdapterNativeAdViewBinder {
    private final AdOptionsPosition mAdOptionsPosition;
    private final NativeAd mNativeAd;
    private NativeAdLayout mNativeAdLayout;

    public FacebookNativeAdViewBinder(NativeAd nativeAd, AdOptionsPosition adOptionsPosition) {
        this.mNativeAd = nativeAd;
        this.mAdOptionsPosition = adOptionsPosition;
    }

    public void setNativeAdView(View view) {
        if (view == null) {
            IronLog.INTERNAL.error("nativeAdView is null");
            return;
        }
        Context context = view.getContext();
        this.mNativeAdLayout = new NativeAdLayout(context);
        ArrayList arrayList = new ArrayList();
        NativeAdViewHolder nativeAdViewHolder = getNativeAdViewHolder();
        arrayList.add(nativeAdViewHolder.getTitleView());
        arrayList.add(nativeAdViewHolder.getAdvertiserView());
        arrayList.add(nativeAdViewHolder.getIconView());
        arrayList.add(nativeAdViewHolder.getBodyView());
        LevelPlayMediaView mediaView = nativeAdViewHolder.getMediaView();
        MediaView mediaView2 = new MediaView(context);
        if (mediaView != null) {
            mediaView.addView(mediaView2);
        }
        arrayList.add(nativeAdViewHolder.getCallToActionView());
        this.mNativeAdLayout.addView(view);
        arrayList.add(view);
        this.mNativeAdLayout.addView((View) new AdOptionsView(context, this.mNativeAd, this.mNativeAdLayout), (ViewGroup.LayoutParams) getAdOptionsLayoutParams());
        this.mNativeAd.registerViewForInteraction(view, mediaView2, (List<View>) arrayList);
    }

    /* renamed from: com.ironsource.adapters.facebook.nativead.FacebookNativeAdViewBinder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$mediationsdk$adunit$adapter$utility$AdOptionsPosition;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition[] r0 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$ironsource$mediationsdk$adunit$adapter$utility$AdOptionsPosition = r0
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$ironsource$mediationsdk$adunit$adapter$utility$AdOptionsPosition     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$ironsource$mediationsdk$adunit$adapter$utility$AdOptionsPosition     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition r1 = com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.facebook.nativead.FacebookNativeAdViewBinder.AnonymousClass1.<clinit>():void");
        }
    }

    private FrameLayout.LayoutParams getAdOptionsLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$adunit$adapter$utility$AdOptionsPosition[this.mAdOptionsPosition.ordinal()];
        if (i == 1) {
            layoutParams.gravity = 51;
        } else if (i == 2) {
            layoutParams.gravity = 53;
        } else if (i != 3) {
            layoutParams.gravity = 85;
        } else {
            layoutParams.gravity = 83;
        }
        return layoutParams;
    }

    public ViewGroup getNetworkNativeAdView() {
        return this.mNativeAdLayout;
    }
}
