package com.vungle.ads.internal.load;

import android.content.Context;
import com.vungle.ads.AdMarkupInvalidError;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.util.PathProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0018\u0010\u0014\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002¨\u0006\u0018"}, d2 = {"Lcom/vungle/ads/internal/load/RealtimeAdLoader;", "Lcom/vungle/ads/internal/load/BaseAdLoader;", "context", "Landroid/content/Context;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "adRequest", "Lcom/vungle/ads/internal/load/AdRequest;", "(Landroid/content/Context;Lcom/vungle/ads/internal/network/VungleApiClient;Lcom/vungle/ads/internal/executor/Executors;Lcom/vungle/ads/internal/omsdk/OMInjector;Lcom/vungle/ads/internal/downloader/Downloader;Lcom/vungle/ads/internal/util/PathProvider;Lcom/vungle/ads/internal/load/AdRequest;)V", "onAdLoadReady", "", "requestAd", "sendWinNotification", "notifications", "", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RealtimeAdLoader.kt */
public final class RealtimeAdLoader extends BaseAdLoader {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealtimeAdLoader(Context context, VungleApiClient vungleApiClient, Executors executors, OMInjector oMInjector, Downloader downloader, PathProvider pathProvider, AdRequest adRequest) {
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
        BidPayload adMarkup = getAdRequest().getAdMarkup();
        if (adMarkup == null) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 208, "Unable to create data object from payload string.", getAdRequest().getPlacement().getReferenceId(), (String) null, (String) null, 24, (Object) null);
            onAdLoadFailed(new AdMarkupInvalidError());
            return;
        }
        AdPayload adPayload = adMarkup.getAdPayload();
        Integer version = adMarkup.getVersion();
        if (version == null || version.intValue() != 2 || adPayload == null) {
            AnalyticsClient.logError$vungle_ads_release$default(AnalyticsClient.INSTANCE, 213, "The ad response did not contain valid ad markup.", getAdRequest().getPlacement().getReferenceId(), (String) null, adMarkup.getEventId(), 8, (Object) null);
            onAdLoadFailed(new AdMarkupInvalidError());
            return;
        }
        handleAdMetaData(adPayload);
    }

    public void onAdLoadReady() {
        AdPayload advertisement$vungle_ads_release = getAdvertisement$vungle_ads_release();
        sendWinNotification(advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getWinNotifications() : null);
    }

    private final void sendWinNotification(List<String> list) {
        boolean z = false;
        if (list != null && list.isEmpty()) {
            z = true;
        }
        if (!z) {
            VungleApiClient vungleApiClient = getVungleApiClient();
            String referenceId = getAdRequest().getPlacement().getReferenceId();
            AdPayload advertisement$vungle_ads_release = getAdvertisement$vungle_ads_release();
            String creativeId = advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getCreativeId() : null;
            AdPayload advertisement$vungle_ads_release2 = getAdvertisement$vungle_ads_release();
            TpatSender tpatSender = new TpatSender(vungleApiClient, referenceId, creativeId, advertisement$vungle_ads_release2 != null ? advertisement$vungle_ads_release2.eventId() : null, getSdkExecutors().getIoExecutor(), getPathProvider());
            if (list != null) {
                for (String sendWinNotification : list) {
                    tpatSender.sendWinNotification(sendWinNotification, getSdkExecutors().getJobExecutor());
                }
            }
        }
    }
}
