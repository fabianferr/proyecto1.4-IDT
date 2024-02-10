package com.wortise.ads.rewarded;

import android.content.Context;
import com.wortise.ads.AdError;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdType;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.a6;
import com.wortise.ads.events.modules.c;
import com.wortise.ads.fullscreen.FullscreenAd;
import com.wortise.ads.rewarded.models.Reward;
import com.wortise.ads.rewarded.modules.BaseRewardedModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/wortise/ads/rewarded/RewardedAd;", "Lcom/wortise/ads/fullscreen/FullscreenAd;", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule;", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;", "context", "Landroid/content/Context;", "adUnitId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "listener", "Lcom/wortise/ads/rewarded/RewardedAd$Listener;", "getListener", "()Lcom/wortise/ads/rewarded/RewardedAd$Listener;", "setListener", "(Lcom/wortise/ads/rewarded/RewardedAd$Listener;)V", "createModule", "response", "Lcom/wortise/ads/AdResponse;", "onAdClicked", "", "onAdCompleted", "reward", "Lcom/wortise/ads/rewarded/models/Reward;", "onAdDismissed", "onAdFailed", "error", "Lcom/wortise/ads/AdError;", "onAdLoaded", "onAdShown", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RewardedAd.kt */
public final class RewardedAd extends FullscreenAd<BaseRewardedModule> implements BaseRewardedModule.Listener {
    private Listener listener;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/rewarded/RewardedAd$Listener;", "", "onRewardedClicked", "", "ad", "Lcom/wortise/ads/rewarded/RewardedAd;", "onRewardedCompleted", "reward", "Lcom/wortise/ads/rewarded/models/Reward;", "onRewardedDismissed", "onRewardedFailed", "error", "Lcom/wortise/ads/AdError;", "onRewardedLoaded", "onRewardedShown", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: RewardedAd.kt */
    public interface Listener {
        void onRewardedClicked(RewardedAd rewardedAd);

        void onRewardedCompleted(RewardedAd rewardedAd, Reward reward);

        void onRewardedDismissed(RewardedAd rewardedAd);

        void onRewardedFailed(RewardedAd rewardedAd, AdError adError);

        void onRewardedLoaded(RewardedAd rewardedAd);

        void onRewardedShown(RewardedAd rewardedAd);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RewardedAd(Context context, String str) {
        super(context, str, AdType.REWARDED);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
    }

    public final Listener getListener() {
        return this.listener;
    }

    public void onAdClicked() {
        super.onAdClicked();
        if (!isDestroyed()) {
            WortiseLog.i$default("Rewarded ad clicked", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onRewardedClicked(this);
            }
        }
    }

    public void onAdCompleted(Reward reward) {
        Intrinsics.checkNotNullParameter(reward, c.EXTRA_REWARD);
        if (!isDestroyed()) {
            WortiseLog.i$default("Rewarded ad completed", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onRewardedCompleted(this, reward);
            }
        }
    }

    public void onAdDismissed() {
        super.onAdDismissed();
        if (!isDestroyed()) {
            WortiseLog.i$default("Rewarded ad dismissed", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onRewardedDismissed(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAdFailed(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        super.onAdFailed(adError);
        if (!isDestroyed()) {
            WortiseLog.i$default("Rewarded ad load failed for ad unit " + getAdUnitId() + ": " + adError.name(), (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onRewardedFailed(this, adError);
            }
        }
    }

    public void onAdLoaded() {
        super.onAdLoaded();
        if (!isDestroyed()) {
            WortiseLog.i$default(Intrinsics.stringPlus("Rewarded ad loaded for ad unit ", getAdUnitId()), (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onRewardedLoaded(this);
            }
        }
    }

    public void onAdShown() {
        super.onAdShown();
        if (!isDestroyed()) {
            WortiseLog.i$default("Rewarded ad shown", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onRewardedShown(this);
            }
        }
    }

    public final void setListener(Listener listener2) {
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public BaseRewardedModule createModule(AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "response");
        return a6.a.a(getContext(), adResponse, this);
    }
}
