package com.vungle.ads.internal.presenter;

import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.model.Placement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vungle/ads/internal/presenter/AdEventListener;", "", "playAdCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallback;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "(Lcom/vungle/ads/internal/presenter/AdPlayCallback;Lcom/vungle/ads/internal/model/Placement;)V", "adRewarded", "", "onError", "", "error", "Lcom/vungle/ads/VungleError;", "placementId", "", "onNext", "s", "value", "id", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdEventListener.kt */
public class AdEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AdEventListener";
    private boolean adRewarded;
    private Placement placement;
    private final AdPlayCallback playAdCallback;

    public AdEventListener(AdPlayCallback adPlayCallback, Placement placement2) {
        this.playAdCallback = adPlayCallback;
        this.placement = placement2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/presenter/AdEventListener$Companion;", "", "()V", "TAG", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdEventListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void onNext(String str, String str2, String str3) {
        AdPlayCallback adPlayCallback;
        AdPlayCallback adPlayCallback2;
        AdPlayCallback adPlayCallback3;
        AdPlayCallback adPlayCallback4;
        Intrinsics.checkNotNullParameter(str, CmcdHeadersFactory.STREAMING_FORMAT_SS);
        Log.d(TAG, "s=" + str + ", value=" + str2 + ", id=" + str3);
        switch (str.hashCode()) {
            case -1912374177:
                if (str.equals(MRAIDPresenter.SUCCESSFUL_VIEW)) {
                    Placement placement2 = this.placement;
                    boolean z = false;
                    if (placement2 != null && placement2.isIncentivized()) {
                        z = true;
                    }
                    if (z && !this.adRewarded) {
                        this.adRewarded = true;
                        AdPlayCallback adPlayCallback5 = this.playAdCallback;
                        if (adPlayCallback5 != null) {
                            adPlayCallback5.onAdRewarded(str3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case -1627831289:
                if (str.equals("adViewed") && (adPlayCallback = this.playAdCallback) != null) {
                    adPlayCallback.onAdImpression(str3);
                    return;
                }
                return;
            case 100571:
                if (str.equals("end") && (adPlayCallback2 = this.playAdCallback) != null) {
                    adPlayCallback2.onAdEnd(str3);
                    return;
                }
                return;
            case 3417674:
                if (str.equals("open")) {
                    if (Intrinsics.areEqual((Object) str2, (Object) "adClick")) {
                        AdPlayCallback adPlayCallback6 = this.playAdCallback;
                        if (adPlayCallback6 != null) {
                            adPlayCallback6.onAdClick(str3);
                            return;
                        }
                        return;
                    } else if (Intrinsics.areEqual((Object) str2, (Object) "adLeftApplication") && (adPlayCallback3 = this.playAdCallback) != null) {
                        adPlayCallback3.onAdLeftApplication(str3);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 109757538:
                if (str.equals("start") && (adPlayCallback4 = this.playAdCallback) != null) {
                    adPlayCallback4.onAdStart(str3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void onError(VungleError vungleError, String str) {
        Intrinsics.checkNotNullParameter(vungleError, "error");
        AdPlayCallback adPlayCallback = this.playAdCallback;
        if (adPlayCallback != null) {
            adPlayCallback.onFailure(vungleError);
            Log.e(TAG, "AdEventListener#PlayAdCallback " + str, vungleError);
        }
    }
}
