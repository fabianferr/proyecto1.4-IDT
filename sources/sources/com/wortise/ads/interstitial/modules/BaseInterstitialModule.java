package com.wortise.ads.interstitial.modules;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdResponse;
import com.wortise.ads.fullscreen.modules.BaseFullscreenModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule;", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule$Listener;", "context", "Landroid/content/Context;", "adResponse", "Lcom/wortise/ads/AdResponse;", "listener", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule$Listener;)V", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BaseInterstitialModule.kt */
public abstract class BaseInterstitialModule extends BaseFullscreenModule<Listener> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule$Listener;", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BaseInterstitialModule.kt */
    public interface Listener extends BaseFullscreenModule.Listener {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseInterstitialModule(Context context, AdResponse adResponse, Listener listener) {
        super(context, adResponse, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }
}
