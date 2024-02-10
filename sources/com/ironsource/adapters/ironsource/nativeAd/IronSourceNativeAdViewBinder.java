package com.ironsource.adapters.ironsource.nativeAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdOptionsPosition;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.k.b;
import com.ironsource.sdk.k.c;
import com.ironsource.sdk.k.d;
import com.ironsource.sdk.k.e;
import com.ironsource.sdk.mediation.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdViewBinder;", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "nativeAd", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface;", "nativeAdProperties", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/NativeAdProperties;", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface;Lcom/ironsource/mediationsdk/adunit/adapter/utility/NativeAdProperties;)V", "<set-?>", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer;", "networkNativeAdView", "getNetworkNativeAdView", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer;", "getPrivacyIconLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "setNativeAdView", "", "nativeAdView", "Landroid/view/View;", "ironsourceadapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IronSourceNativeAdViewBinder extends AdapterNativeAdViewBinder {
    private final d nativeAd;
    private final NativeAdProperties nativeAdProperties;
    private b networkNativeAdView;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdOptionsPosition.values().length];
            iArr[AdOptionsPosition.TOP_LEFT.ordinal()] = 1;
            iArr[AdOptionsPosition.TOP_RIGHT.ordinal()] = 2;
            iArr[AdOptionsPosition.BOTTOM_LEFT.ordinal()] = 3;
            iArr[AdOptionsPosition.BOTTOM_RIGHT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IronSourceNativeAdViewBinder(d dVar, NativeAdProperties nativeAdProperties2) {
        Intrinsics.checkNotNullParameter(dVar, "nativeAd");
        Intrinsics.checkNotNullParameter(nativeAdProperties2, "nativeAdProperties");
        this.nativeAd = dVar;
        this.nativeAdProperties = nativeAdProperties2;
    }

    private final FrameLayout.LayoutParams getPrivacyIconLayoutParams() {
        int i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.nativeAdProperties.getAdOptionsPosition().ordinal()];
        if (i2 == 1) {
            i = 51;
        } else if (i2 == 2) {
            i = 53;
        } else if (i2 == 3) {
            i = 83;
        } else if (i2 == 4) {
            i = 85;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        layoutParams.gravity = i;
        return layoutParams;
    }

    public final b getNetworkNativeAdView() {
        return this.networkNativeAdView;
    }

    public final void setNativeAdView(View view) {
        if (view == null) {
            IronLog.INTERNAL.error("nativeAdView is null");
        } else if (this.nativeAd.a() == null) {
            IronLog.INTERNAL.error("nativeAd.adData is null");
        } else {
            LevelPlayMediaView mediaView = getNativeAdViewHolder().getMediaView();
            if (mediaView != null) {
                c a = this.nativeAd.a();
                Intrinsics.checkNotNull(a);
                WebView webView = a.f;
                if (webView != null) {
                    mediaView.addView(webView, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            c a2 = this.nativeAd.a();
            Intrinsics.checkNotNull(a2);
            View view2 = a2.g;
            view2.setId(R.id.privacy_icon_button);
            view2.setLayoutParams(getPrivacyIconLayoutParams());
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            b bVar = new b(context);
            bVar.addView(view);
            bVar.addView(view2);
            this.networkNativeAdView = bVar;
            b networkNativeAdView2 = getNetworkNativeAdView();
            Intrinsics.checkNotNull(networkNativeAdView2);
            this.nativeAd.a(new e(networkNativeAdView2, getNativeAdViewHolder().getTitleView(), getNativeAdViewHolder().getAdvertiserView(), getNativeAdViewHolder().getIconView(), getNativeAdViewHolder().getBodyView(), getNativeAdViewHolder().getMediaView(), getNativeAdViewHolder().getCallToActionView(), view2));
        }
    }
}
