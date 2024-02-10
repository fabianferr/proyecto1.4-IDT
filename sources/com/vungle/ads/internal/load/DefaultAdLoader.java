package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.AdFailedToDownloadError;
import com.vungle.ads.AdRetryActiveError;
import com.vungle.ads.InternalError;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.util.PathProvider;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002¨\u0006\u001d"}, d2 = {"Lcom/vungle/ads/internal/load/DefaultAdLoader;", "Lcom/vungle/ads/internal/load/BaseAdLoader;", "context", "Landroid/content/Context;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "adRequest", "Lcom/vungle/ads/internal/load/AdRequest;", "(Landroid/content/Context;Lcom/vungle/ads/internal/network/VungleApiClient;Lcom/vungle/ads/internal/executor/Executors;Lcom/vungle/ads/internal/omsdk/OMInjector;Lcom/vungle/ads/internal/downloader/Downloader;Lcom/vungle/ads/internal/util/PathProvider;Lcom/vungle/ads/internal/load/AdRequest;)V", "fetchAdMetadata", "", "adSize", "", "placement", "Lcom/vungle/ads/internal/model/Placement;", "onAdLoadReady", "requestAd", "retrofitToVungleError", "Lcom/vungle/ads/VungleError;", "throwable", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DefaultAdLoader.kt */
public final class DefaultAdLoader extends BaseAdLoader {
    public void onAdLoadReady() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultAdLoader(Context context, VungleApiClient vungleApiClient, Executors executors, OMInjector oMInjector, Downloader downloader, PathProvider pathProvider, AdRequest adRequest) {
        super(context, vungleApiClient, executors, oMInjector, downloader, pathProvider, adRequest);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vungleApiClient, "vungleApiClient");
        Intrinsics.checkNotNullParameter(executors, "sdkExecutors");
        Intrinsics.checkNotNullParameter(oMInjector, "omInjector");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
    }

    /* access modifiers changed from: protected */
    public void requestAd() {
        fetchAdMetadata(getAdRequest().getRequestAdSize(), getAdRequest().getPlacement());
    }

    private final void fetchAdMetadata(String str, Placement placement) {
        if (getVungleApiClient().checkIsRetryAfterActive(placement.getReferenceId())) {
            onAdLoadFailed(new AdRetryActiveError().logError$vungle_ads_release());
            return;
        }
        Call<AdPayload> requestAd = getVungleApiClient().requestAd(placement.getReferenceId(), str, placement.getHeaderBidding());
        if (requestAd == null) {
            onAdLoadFailed(new AdFailedToDownloadError());
        } else {
            requestAd.enqueue(new DefaultAdLoader$fetchAdMetadata$1(this, placement));
        }
    }

    /* access modifiers changed from: private */
    public final VungleError retrofitToVungleError(Throwable th) {
        if (th instanceof UnknownHostException) {
            return new AdFailedToDownloadError();
        }
        if (th instanceof SocketTimeoutException) {
            return new InternalError(VungleError.NETWORK_TIMEOUT, (String) null, 2, (DefaultConstructorMarker) null);
        }
        if (th instanceof IOException) {
            return new InternalError(VungleError.NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null);
        }
        return new AdFailedToDownloadError();
    }
}
