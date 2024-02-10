package com.vungle.ads.internal.load;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareInternalUtility;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.AssetDownloadError;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"com/vungle/ads/internal/load/BaseAdLoader$assetDownloadListener$1", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "onError", "", "error", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$DownloadError;", "downloadRequest", "Lcom/vungle/ads/internal/downloader/DownloadRequest;", "onProgress", "progress", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$Progress;", "onSuccess", "file", "Ljava/io/File;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAdLoader.kt */
public final class BaseAdLoader$assetDownloadListener$1 implements AssetDownloadListener {
    final /* synthetic */ BaseAdLoader this$0;

    BaseAdLoader$assetDownloadListener$1(BaseAdLoader baseAdLoader) {
        this.this$0 = baseAdLoader;
    }

    public void onError(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest) {
        StringBuilder sb = new StringBuilder("onError called! ");
        sb.append(downloadError != null ? Integer.valueOf(downloadError.getReason()) : null);
        Log.d("BaseAdLoader", sb.toString());
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new BaseAdLoader$assetDownloadListener$1$$ExternalSyntheticLambda0(downloadRequest, this.this$0, downloadError));
    }

    /* access modifiers changed from: private */
    /* renamed from: onError$lambda-0  reason: not valid java name */
    public static final void m2297onError$lambda0(DownloadRequest downloadRequest, BaseAdLoader baseAdLoader, AssetDownloadListener.DownloadError downloadError) {
        Intrinsics.checkNotNullParameter(baseAdLoader, "this$0");
        if (downloadRequest != null) {
            String cookieString = downloadRequest.getCookieString();
            AdAsset adAsset = null;
            for (AdAsset adAsset2 : baseAdLoader.adAssets) {
                if (TextUtils.equals(adAsset2.getIdentifier(), cookieString)) {
                    adAsset = adAsset2;
                }
            }
            if (adAsset != null) {
                baseAdLoader.errors.add(downloadError);
            } else {
                baseAdLoader.errors.add(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), AssetDownloadListener.DownloadError.ErrorReason.Companion.getREQUEST_ERROR()));
            }
        } else {
            baseAdLoader.errors.add(new AssetDownloadListener.DownloadError(-1, new RuntimeException("error in request"), AssetDownloadListener.DownloadError.ErrorReason.Companion.getINTERNAL_ERROR()));
        }
        if (baseAdLoader.downloadCount.decrementAndGet() <= 0) {
            baseAdLoader.onAdLoadFailed(new AssetDownloadError());
        }
    }

    public void onProgress(AssetDownloadListener.Progress progress, DownloadRequest downloadRequest) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(downloadRequest, "downloadRequest");
        Log.d("BaseAdLoader", "progress: " + progress.getProgressPercent() + ", download url: " + downloadRequest.getUrl());
    }

    public void onSuccess(File file, DownloadRequest downloadRequest) {
        Intrinsics.checkNotNullParameter(file, ShareInternalUtility.STAGING_PARAM);
        Intrinsics.checkNotNullParameter(downloadRequest, "downloadRequest");
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new BaseAdLoader$assetDownloadListener$1$$ExternalSyntheticLambda1(file, this, downloadRequest, this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-2  reason: not valid java name */
    public static final void m2298onSuccess$lambda2(File file, BaseAdLoader$assetDownloadListener$1 baseAdLoader$assetDownloadListener$1, DownloadRequest downloadRequest, BaseAdLoader baseAdLoader) {
        AdAsset adAsset;
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(baseAdLoader$assetDownloadListener$1, "this$0");
        Intrinsics.checkNotNullParameter(downloadRequest, "$downloadRequest");
        Intrinsics.checkNotNullParameter(baseAdLoader, "this$1");
        if (!file.exists()) {
            baseAdLoader$assetDownloadListener$1.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), AssetDownloadListener.DownloadError.ErrorReason.Companion.getFILE_NOT_FOUND_ERROR()), downloadRequest);
            return;
        }
        String str = null;
        if (downloadRequest.isTemplate()) {
            downloadRequest.stopRecord();
            baseAdLoader.templateSizeMetric.setValue(Long.valueOf(file.length()));
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            SingleValueMetric access$getTemplateSizeMetric$p = baseAdLoader.templateSizeMetric;
            String referenceId = baseAdLoader.getAdRequest().getPlacement().getReferenceId();
            AdPayload advertisement$vungle_ads_release = baseAdLoader.getAdvertisement$vungle_ads_release();
            String creativeId = advertisement$vungle_ads_release != null ? advertisement$vungle_ads_release.getCreativeId() : null;
            AdPayload advertisement$vungle_ads_release2 = baseAdLoader.getAdvertisement$vungle_ads_release();
            analyticsClient.logMetric$vungle_ads_release(access$getTemplateSizeMetric$p, referenceId, creativeId, advertisement$vungle_ads_release2 != null ? advertisement$vungle_ads_release2.eventId() : null, downloadRequest.getUrl());
        } else if (downloadRequest.isMainVideo()) {
            baseAdLoader.mainVideoSizeMetric.setValue(Long.valueOf(file.length()));
            AnalyticsClient analyticsClient2 = AnalyticsClient.INSTANCE;
            SingleValueMetric access$getMainVideoSizeMetric$p = baseAdLoader.mainVideoSizeMetric;
            String referenceId2 = baseAdLoader.getAdRequest().getPlacement().getReferenceId();
            AdPayload advertisement$vungle_ads_release3 = baseAdLoader.getAdvertisement$vungle_ads_release();
            String creativeId2 = advertisement$vungle_ads_release3 != null ? advertisement$vungle_ads_release3.getCreativeId() : null;
            AdPayload advertisement$vungle_ads_release4 = baseAdLoader.getAdvertisement$vungle_ads_release();
            analyticsClient2.logMetric$vungle_ads_release(access$getMainVideoSizeMetric$p, referenceId2, creativeId2, advertisement$vungle_ads_release4 != null ? advertisement$vungle_ads_release4.eventId() : null, downloadRequest.getUrl());
        }
        String cookieString = downloadRequest.getCookieString();
        Iterator it = baseAdLoader.adAssets.iterator();
        while (true) {
            if (!it.hasNext()) {
                adAsset = null;
                break;
            }
            adAsset = (AdAsset) it.next();
            if (TextUtils.equals(adAsset.getIdentifier(), cookieString)) {
                break;
            }
        }
        if (adAsset == null) {
            baseAdLoader$assetDownloadListener$1.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), AssetDownloadListener.DownloadError.ErrorReason.Companion.getREQUEST_ERROR()), downloadRequest);
            return;
        }
        adAsset.setFileType(baseAdLoader.isZip(file) ? AdAsset.FileType.ZIP : AdAsset.FileType.ASSET);
        adAsset.setFileSize(file.length());
        adAsset.setStatus(AdAsset.Status.DOWNLOAD_SUCCESS);
        if (baseAdLoader.isZip(file)) {
            boolean unused = baseAdLoader.injectOMIfNeeded(baseAdLoader.getAdvertisement$vungle_ads_release());
            if (!baseAdLoader.processTemplate(adAsset, baseAdLoader.getAdvertisement$vungle_ads_release())) {
                baseAdLoader.errors.add(new AssetDownloadListener.DownloadError(-1, new AssetDownloadError(), AssetDownloadListener.DownloadError.ErrorReason.Companion.getINTERNAL_ERROR()));
            }
        }
        if (baseAdLoader.downloadCount.decrementAndGet() > 0) {
            return;
        }
        if (baseAdLoader.errors.isEmpty()) {
            AdRequest adRequest = baseAdLoader.getAdRequest();
            AdPayload advertisement$vungle_ads_release5 = baseAdLoader.getAdvertisement$vungle_ads_release();
            if (advertisement$vungle_ads_release5 != null) {
                str = advertisement$vungle_ads_release5.eventId();
            }
            baseAdLoader.onDownloadCompleted(adRequest, str);
            return;
        }
        baseAdLoader.onAdLoadFailed(new AssetDownloadError());
    }
}
