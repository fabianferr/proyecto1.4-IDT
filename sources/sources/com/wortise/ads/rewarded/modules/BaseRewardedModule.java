package com.wortise.ads.rewarded.modules;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdResponse;
import com.wortise.ads.events.modules.c;
import com.wortise.ads.fullscreen.modules.BaseFullscreenModule;
import com.wortise.ads.rewarded.models.Reward;
import com.wortise.ads.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/rewarded/modules/BaseRewardedModule;", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;", "context", "Landroid/content/Context;", "adResponse", "Lcom/wortise/ads/AdResponse;", "listener", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;)V", "deliverComplete", "", "reward", "Lcom/wortise/ads/rewarded/models/Reward;", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BaseRewardedModule.kt */
public abstract class BaseRewardedModule extends BaseFullscreenModule<Listener> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;", "onAdCompleted", "", "reward", "Lcom/wortise/ads/rewarded/models/Reward;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BaseRewardedModule.kt */
    public interface Listener extends BaseFullscreenModule.Listener {
        void onAdCompleted(Reward reward);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseRewardedModule(Context context, AdResponse adResponse, Listener listener) {
        super(context, adResponse, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    /* access modifiers changed from: protected */
    public final void deliverComplete(Reward reward) {
        Intrinsics.checkNotNullParameter(reward, c.EXTRA_REWARD);
        if (!isDestroyed()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(c.EXTRA_REWARD, reward);
            s2.a.b(getContext(), getAdResponse(), bundle);
            ((Listener) getListener()).onAdCompleted(reward);
        }
    }
}
