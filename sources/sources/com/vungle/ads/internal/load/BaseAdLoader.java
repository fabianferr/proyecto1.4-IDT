package com.vungle.ads.internal.load;

import android.content.Context;
import android.util.Log;
import android.webkit.URLUtil;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.AssetDownloadError;
import com.vungle.ads.InternalError;
import com.vungle.ads.NativeAdInternal;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.HackMraid;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.UnzipUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 `2\u00020\u0001:\u0002`aB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u00108\u001a\u000209J\u0010\u0010:\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0013H\u0002J,\u0010?\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010>\u001a\u00020\u0013H\u0002J\u0012\u0010F\u001a\u0004\u0018\u00010=2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u001bH\u0002J\u000e\u0010J\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010K\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010L\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010M\u001a\u00020\u00152\u0006\u0010N\u001a\u00020\u0013H\u0002J\u0010\u0010O\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0013H\u0002J\u0012\u0010P\u001a\u00020\u00152\b\u0010C\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010Q\u001a\u00020\u00152\u0006\u0010R\u001a\u00020=H\u0016J\u000e\u0010S\u001a\u0002092\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020VJ\b\u0010W\u001a\u000209H&J\b\u0010X\u001a\u000209H\u0002J\u001a\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020\u000f2\b\u0010[\u001a\u0004\u0018\u00010BH\u0017J\u001a\u0010\\\u001a\u00020\u00152\u0006\u0010N\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010]\u001a\u000209H$J\u0018\u0010^\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020=H\u0002J\u0012\u0010_\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u001bH\u0002R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R2\u0010*\u001a&\u0012\f\u0012\n ,*\u0004\u0018\u00010+0+ ,*\u0012\u0012\f\u0012\n ,*\u0004\u0018\u00010+0+\u0018\u00010-0\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006b"}, d2 = {"Lcom/vungle/ads/internal/load/BaseAdLoader;", "", "context", "Landroid/content/Context;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "adRequest", "Lcom/vungle/ads/internal/load/AdRequest;", "(Landroid/content/Context;Lcom/vungle/ads/internal/network/VungleApiClient;Lcom/vungle/ads/internal/executor/Executors;Lcom/vungle/ads/internal/omsdk/OMInjector;Lcom/vungle/ads/internal/downloader/Downloader;Lcom/vungle/ads/internal/util/PathProvider;Lcom/vungle/ads/internal/load/AdRequest;)V", "adAssets", "", "Lcom/vungle/ads/internal/model/AdAsset;", "adLoadOptimizationEnabled", "", "adLoaderCallback", "Lcom/vungle/ads/internal/load/AdLoaderCallback;", "getAdRequest", "()Lcom/vungle/ads/internal/load/AdRequest;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "getAdvertisement$vungle_ads_release", "()Lcom/vungle/ads/internal/model/AdPayload;", "setAdvertisement$vungle_ads_release", "(Lcom/vungle/ads/internal/model/AdPayload;)V", "assetDownloadDurationMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "assetDownloadListener", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "getAssetDownloadListener", "()Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "getContext", "()Landroid/content/Context;", "downloadCount", "Ljava/util/concurrent/atomic/AtomicLong;", "errors", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$DownloadError;", "kotlin.jvm.PlatformType", "", "mainVideoSizeMetric", "Lcom/vungle/ads/SingleValueMetric;", "notifySuccess", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "getSdkExecutors", "()Lcom/vungle/ads/internal/executor/Executors;", "templateSizeMetric", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "cancel", "", "downloadAssets", "fileIsValid", "file", "Ljava/io/File;", "adAsset", "getAsset", "destinationDir", "key", "", "url", "getAssetPriority", "Lcom/vungle/ads/internal/downloader/DownloadRequest$Priority;", "getDestinationDir", "getErrorInfo", "Lcom/vungle/ads/internal/load/BaseAdLoader$ErrorInfo;", "adPayload", "handleAdMetaData", "injectOMIfNeeded", "isAdLoadOptimizationEnabled", "isMainVideo", "asset", "isTemplateUrl", "isUrlValid", "isZip", "downloadedFile", "loadAd", "onAdLoadFailed", "error", "Lcom/vungle/ads/VungleError;", "onAdLoadReady", "onAdReady", "onDownloadCompleted", "request", "advertisementId", "processTemplate", "requestAd", "unzipFile", "validateAdMetadata", "Companion", "ErrorInfo", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAdLoader.kt */
public abstract class BaseAdLoader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DOWNLOADED_FILE_NOT_FOUND = "Downloaded file not found!";
    private static final String TAG = "BaseAdLoader";
    /* access modifiers changed from: private */
    public final List<AdAsset> adAssets = new ArrayList();
    private final boolean adLoadOptimizationEnabled = ConfigManager.INSTANCE.adLoadOptimizationEnabled();
    private AdLoaderCallback adLoaderCallback;
    private final AdRequest adRequest;
    private AdPayload advertisement;
    private TimeIntervalMetric assetDownloadDurationMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.ASSET_DOWNLOAD_DURATION_MS);
    private final Context context;
    /* access modifiers changed from: private */
    public final AtomicLong downloadCount = new AtomicLong(0);
    private final Downloader downloader;
    /* access modifiers changed from: private */
    public final List<AssetDownloadListener.DownloadError> errors = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public SingleValueMetric mainVideoSizeMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.ASSET_FILE_SIZE);
    private boolean notifySuccess;
    private final OMInjector omInjector;
    private final PathProvider pathProvider;
    private final Executors sdkExecutors;
    /* access modifiers changed from: private */
    public SingleValueMetric templateSizeMetric = new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.TEMPLATE_ZIP_SIZE);
    private final VungleApiClient vungleApiClient;

    public abstract void onAdLoadReady();

    /* access modifiers changed from: protected */
    public abstract void requestAd();

    public BaseAdLoader(Context context2, VungleApiClient vungleApiClient2, Executors executors, OMInjector oMInjector, Downloader downloader2, PathProvider pathProvider2, AdRequest adRequest2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(vungleApiClient2, "vungleApiClient");
        Intrinsics.checkNotNullParameter(executors, "sdkExecutors");
        Intrinsics.checkNotNullParameter(oMInjector, "omInjector");
        Intrinsics.checkNotNullParameter(downloader2, "downloader");
        Intrinsics.checkNotNullParameter(pathProvider2, "pathProvider");
        Intrinsics.checkNotNullParameter(adRequest2, "adRequest");
        this.context = context2;
        this.vungleApiClient = vungleApiClient2;
        this.sdkExecutors = executors;
        this.omInjector = oMInjector;
        this.downloader = downloader2;
        this.pathProvider = pathProvider2;
        this.adRequest = adRequest2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final Executors getSdkExecutors() {
        return this.sdkExecutors;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public final AdRequest getAdRequest() {
        return this.adRequest;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/load/BaseAdLoader$Companion;", "", "()V", "DOWNLOADED_FILE_NOT_FOUND", "", "TAG", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BaseAdLoader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final AdPayload getAdvertisement$vungle_ads_release() {
        return this.advertisement;
    }

    public final void setAdvertisement$vungle_ads_release(AdPayload adPayload) {
        this.advertisement = adPayload;
    }

    private final AssetDownloadListener getAssetDownloadListener() {
        return new BaseAdLoader$assetDownloadListener$1(this);
    }

    public final void loadAd(AdLoaderCallback adLoaderCallback2) {
        Intrinsics.checkNotNullParameter(adLoaderCallback2, "adLoaderCallback");
        this.adLoaderCallback = adLoaderCallback2;
        this.sdkExecutors.getBackgroundExecutor().execute(new BaseAdLoader$$ExternalSyntheticLambda0(this, adLoaderCallback2));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAd$lambda-0  reason: not valid java name */
    public static final void m2296loadAd$lambda0(BaseAdLoader baseAdLoader, AdLoaderCallback adLoaderCallback2) {
        Intrinsics.checkNotNullParameter(baseAdLoader, "this$0");
        Intrinsics.checkNotNullParameter(adLoaderCallback2, "$adLoaderCallback");
        MraidJsLoader.INSTANCE.downloadJs(baseAdLoader.pathProvider, baseAdLoader.downloader, new BaseAdLoader$loadAd$1$1(baseAdLoader, adLoaderCallback2));
    }

    public final void cancel() {
        this.downloader.cancelAll();
    }

    private final void downloadAssets(AdPayload adPayload) {
        this.assetDownloadDurationMetric.markStart();
        this.downloadCount.set((long) this.adAssets.size());
        for (AdAsset next : this.adAssets) {
            DownloadRequest downloadRequest = new DownloadRequest(getAssetPriority(next), next.getServerPath(), next.getLocalPath(), next.getIdentifier(), isTemplateUrl(next), isMainVideo(next), this.adRequest.getPlacement().getReferenceId(), adPayload.getCreativeId(), adPayload.eventId());
            if (downloadRequest.isTemplate()) {
                downloadRequest.startRecord();
            }
            this.downloader.download(downloadRequest, getAssetDownloadListener());
        }
    }

    public final void onAdLoadFailed(VungleError vungleError) {
        Intrinsics.checkNotNullParameter(vungleError, "error");
        AdLoaderCallback adLoaderCallback2 = this.adLoaderCallback;
        if (adLoaderCallback2 != null) {
            adLoaderCallback2.onFailure(vungleError);
        }
    }

    private final void onAdReady() {
        String localPath;
        AdPayload adPayload = this.advertisement;
        if (adPayload != null) {
            File destinationDir = getDestinationDir(adPayload);
            if (destinationDir != null) {
                List arrayList = new ArrayList();
                for (AdAsset adAsset : this.adAssets) {
                    if (adAsset.getStatus() == AdAsset.Status.DOWNLOAD_SUCCESS && (localPath = adAsset.getLocalPath()) != null) {
                        arrayList.add(localPath);
                    }
                }
                adPayload.setMraidAssetDir(destinationDir, arrayList);
            }
            if (!this.notifySuccess) {
                onAdLoadReady();
                AdLoaderCallback adLoaderCallback2 = this.adLoaderCallback;
                if (adLoaderCallback2 != null) {
                    adLoaderCallback2.onSuccess(adPayload);
                }
                this.notifySuccess = true;
            }
        }
    }

    private final boolean isUrlValid(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str);
        }
        return false;
    }

    private final boolean fileIsValid(File file, AdAsset adAsset) {
        return file.exists() && file.length() == adAsset.getFileSize();
    }

    public boolean isZip(File file) {
        Intrinsics.checkNotNullParameter(file, "downloadedFile");
        return Intrinsics.areEqual((Object) file.getName(), (Object) "template");
    }

    private final boolean isTemplateUrl(AdAsset adAsset) {
        return adAsset.getFileType() == AdAsset.FileType.ZIP;
    }

    private final boolean isMainVideo(AdAsset adAsset) {
        AdPayload adPayload = this.advertisement;
        return Intrinsics.areEqual((Object) adPayload != null ? adPayload.getMainVideoUrl() : null, (Object) adAsset.getServerPath());
    }

    private final AdAsset getAsset(AdPayload adPayload, File file, String str, String str2) {
        String str3 = file.getPath() + File.separator + str;
        boolean z = false;
        AdAsset.FileType fileType = StringsKt.endsWith$default(str3, "template", false, 2, (Object) null) ? AdAsset.FileType.ZIP : AdAsset.FileType.ASSET;
        String eventId = adPayload.eventId();
        CharSequence charSequence = eventId;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            return null;
        }
        AdAsset adAsset = new AdAsset(eventId, str2, str3);
        adAsset.setStatus(AdAsset.Status.NEW);
        adAsset.setFileType(fileType);
        return adAsset;
    }

    private final boolean unzipFile(AdPayload adPayload, File file) {
        List arrayList = new ArrayList();
        for (AdAsset next : this.adAssets) {
            if (next.getFileType() == AdAsset.FileType.ASSET && next.getLocalPath() != null) {
                arrayList.add(next.getLocalPath());
            }
        }
        File destinationDir = getDestinationDir(adPayload);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            throw new IOException("Unable to access Destination Directory");
        }
        try {
            UnzipUtility unzipUtility = UnzipUtility.INSTANCE;
            String path = file.getPath();
            String path2 = destinationDir.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "destinationDir.path");
            unzipUtility.unzip(path, path2, new BaseAdLoader$unzipFile$1(arrayList));
            if (!new File(destinationDir.getPath() + File.separator + "index.html").exists()) {
                AnalyticsClient.INSTANCE.logError$vungle_ads_release(115, "Failed to retrieve indexFileUrl from the Ad.", this.adRequest.getPlacement().getReferenceId(), adPayload.getCreativeId(), adPayload.eventId());
                return false;
            }
            if (Intrinsics.areEqual((Object) file.getName(), (Object) "template")) {
                File file2 = new File(destinationDir.getPath() + File.separator + "mraid.js");
                if (file2.exists() || file2.createNewFile()) {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2, true)));
                    HackMraid.INSTANCE.apply(this.pathProvider, printWriter);
                    printWriter.close();
                } else {
                    throw new IOException("mraid.js can not be created");
                }
            }
            FileUtility.printDirectoryTree(destinationDir);
            FileUtility.delete(file);
            return true;
        } catch (Exception e) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            analyticsClient.logError$vungle_ads_release(109, "Unzip failed: " + e.getMessage(), this.adRequest.getPlacement().getReferenceId(), adPayload.getCreativeId(), adPayload.eventId());
            return false;
        }
    }

    private final File getDestinationDir(AdPayload adPayload) {
        return this.pathProvider.getDownloadsDirForAd(adPayload.eventId());
    }

    /* access modifiers changed from: private */
    public final boolean injectOMIfNeeded(AdPayload adPayload) {
        if (adPayload == null) {
            return false;
        }
        if (!adPayload.omEnabled()) {
            return true;
        }
        try {
            File destinationDir = getDestinationDir(adPayload);
            if (destinationDir != null) {
                if (destinationDir.isDirectory()) {
                    this.omInjector.injectJsFiles(destinationDir);
                    return true;
                }
            }
            onAdLoadFailed(new AssetDownloadError());
            return false;
        } catch (IOException unused) {
            onAdLoadFailed(new AssetDownloadError());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final boolean processTemplate(AdAsset adAsset, AdPayload adPayload) {
        if (adPayload == null || adAsset.getStatus() != AdAsset.Status.DOWNLOAD_SUCCESS) {
            return false;
        }
        CharSequence localPath = adAsset.getLocalPath();
        if (localPath == null || localPath.length() == 0) {
            return false;
        }
        File file = new File(adAsset.getLocalPath());
        if (!fileIsValid(file, adAsset)) {
            return false;
        }
        if (adAsset.getFileType() == AdAsset.FileType.ZIP && !unzipFile(adPayload, file)) {
            return false;
        }
        if (isAdLoadOptimizationEnabled(adPayload)) {
            onAdReady();
        }
        return true;
    }

    private final boolean isAdLoadOptimizationEnabled(AdPayload adPayload) {
        return this.adLoadOptimizationEnabled && adPayload != null && Intrinsics.areEqual((Object) adPayload.getAdType(), (Object) AdPayload.TYPE_VUNGLE_MRAID);
    }

    public void onDownloadCompleted(AdRequest adRequest2, String str) {
        Intrinsics.checkNotNullParameter(adRequest2, "request");
        Log.d(TAG, "download completed " + adRequest2);
        AdPayload adPayload = this.advertisement;
        if (adPayload != null) {
            adPayload.setAssetFullyDownloaded();
        }
        onAdReady();
        this.assetDownloadDurationMetric.markEnd();
        AdPayload adPayload2 = this.advertisement;
        String str2 = null;
        String placementId = adPayload2 != null ? adPayload2.placementId() : null;
        AdPayload adPayload3 = this.advertisement;
        String creativeId = adPayload3 != null ? adPayload3.getCreativeId() : null;
        AdPayload adPayload4 = this.advertisement;
        if (adPayload4 != null) {
            str2 = adPayload4.eventId();
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.assetDownloadDurationMetric, placementId, creativeId, str2, (String) null, 16, (Object) null);
    }

    public final void handleAdMetaData(AdPayload adPayload) {
        List<String> loadAdUrls;
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        this.advertisement = adPayload;
        ErrorInfo validateAdMetadata = validateAdMetadata(adPayload);
        if (validateAdMetadata != null) {
            AnalyticsClient.INSTANCE.logError$vungle_ads_release(validateAdMetadata.getReason(), validateAdMetadata.getDescription(), this.adRequest.getPlacement().getReferenceId(), adPayload.getCreativeId(), adPayload.eventId());
            onAdLoadFailed(new InternalError(validateAdMetadata.getReason(), validateAdMetadata.getDescriptionExternal()));
            return;
        }
        Set<Map.Entry<String, String>> entrySet = adPayload.getDownloadableUrls().entrySet();
        File destinationDir = getDestinationDir(adPayload);
        if (destinationDir == null || !destinationDir.isDirectory() || entrySet.isEmpty()) {
            onAdLoadFailed(new AssetDownloadError());
            return;
        }
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        if (!(adUnit == null || (loadAdUrls = adUnit.getLoadAdUrls()) == null)) {
            TpatSender tpatSender = new TpatSender(this.vungleApiClient, adPayload.placementId(), adPayload.getCreativeId(), adPayload.eventId(), this.sdkExecutors.getIoExecutor(), this.pathProvider);
            for (String pingUrl : loadAdUrls) {
                tpatSender.pingUrl(pingUrl, this.sdkExecutors.getJobExecutor());
            }
        }
        for (Map.Entry next : entrySet) {
            AdAsset asset = getAsset(adPayload, destinationDir, (String) next.getKey(), (String) next.getValue());
            if (asset != null) {
                this.adAssets.add(asset);
            }
        }
        downloadAssets(adPayload);
    }

    private final DownloadRequest.Priority getAssetPriority(AdAsset adAsset) {
        if (!this.adLoadOptimizationEnabled) {
            return DownloadRequest.Priority.CRITICAL;
        }
        CharSequence localPath = adAsset.getLocalPath();
        if ((localPath == null || localPath.length() == 0) || !StringsKt.endsWith$default(adAsset.getLocalPath(), "template", false, 2, (Object) null)) {
            return DownloadRequest.Priority.HIGHEST;
        }
        return DownloadRequest.Priority.CRITICAL;
    }

    private final ErrorInfo validateAdMetadata(AdPayload adPayload) {
        AdPayload.AdUnit adUnit = adPayload.adUnit();
        if ((adUnit != null ? adUnit.getSleep() : null) != null) {
            return getErrorInfo(adPayload);
        }
        String referenceId = this.adRequest.getPlacement().getReferenceId();
        AdPayload adPayload2 = this.advertisement;
        if (!Intrinsics.areEqual((Object) referenceId, (Object) adPayload2 != null ? adPayload2.placementId() : null)) {
            return new ErrorInfo(215, "The ad response is missing placement reference id.", (String) null, false, 12, (DefaultConstructorMarker) null);
        }
        Iterable supportedTemplateTypes = this.adRequest.getPlacement().getSupportedTemplateTypes();
        AdPayload adPayload3 = this.advertisement;
        if (!CollectionsKt.contains(supportedTemplateTypes, adPayload3 != null ? adPayload3.templateType() : null)) {
            return new ErrorInfo(216, "The ad response has an unexpected template type.", (String) null, false, 12, (DefaultConstructorMarker) null);
        }
        AdPayload.AdUnit adUnit2 = adPayload.adUnit();
        AdPayload.TemplateSettings templateSettings = adUnit2 != null ? adUnit2.getTemplateSettings() : null;
        if (templateSettings == null) {
            return new ErrorInfo(113, "Missing assets URLs", (String) null, false, 12, (DefaultConstructorMarker) null);
        }
        Map<String, AdPayload.CacheableReplacement> cacheableReplacements = templateSettings.getCacheableReplacements();
        if (!adPayload.isNativeTemplateType()) {
            AdPayload.AdUnit adUnit3 = adPayload.adUnit();
            String templateURL = adUnit3 != null ? adUnit3.getTemplateURL() : null;
            CharSequence charSequence = templateURL;
            if (charSequence == null || charSequence.length() == 0) {
                return new ErrorInfo(105, "Failed to prepare URL for template download.", (String) null, false, 12, (DefaultConstructorMarker) null);
            }
            if (!isUrlValid(templateURL)) {
                return new ErrorInfo(112, "Failed to load template asset.", (String) null, false, 12, (DefaultConstructorMarker) null);
            }
        } else if (cacheableReplacements != null) {
            AdPayload.CacheableReplacement cacheableReplacement = cacheableReplacements.get(NativeAdInternal.TOKEN_MAIN_IMAGE);
            if ((cacheableReplacement != null ? cacheableReplacement.getUrl() : null) == null) {
                return new ErrorInfo(600, "Unable to load main image.", (String) null, false, 12, (DefaultConstructorMarker) null);
            }
            AdPayload.CacheableReplacement cacheableReplacement2 = cacheableReplacements.get(NativeAdInternal.TOKEN_VUNGLE_PRIVACY_ICON_URL);
            if ((cacheableReplacement2 != null ? cacheableReplacement2.getUrl() : null) == null) {
                return new ErrorInfo(600, "Unable to load privacy image.", (String) null, false, 12, (DefaultConstructorMarker) null);
            }
        }
        if (adPayload.hasExpired()) {
            return new ErrorInfo(304, "The ad markup has expired for playback.", (String) null, false, 12, (DefaultConstructorMarker) null);
        }
        CharSequence eventId = adPayload.eventId();
        if (eventId == null || eventId.length() == 0) {
            return new ErrorInfo(200, "Event id is invalid.", (String) null, false, 12, (DefaultConstructorMarker) null);
        }
        if (cacheableReplacements != null) {
            for (Map.Entry<String, AdPayload.CacheableReplacement> value : cacheableReplacements.entrySet()) {
                String url = ((AdPayload.CacheableReplacement) value.getValue()).getUrl();
                CharSequence charSequence2 = url;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    return new ErrorInfo(111, "Invalid asset URL " + url, (String) null, false, 12, (DefaultConstructorMarker) null);
                } else if (!isUrlValid(url)) {
                    return new ErrorInfo(112, "Invalid asset URL " + url, (String) null, false, 12, (DefaultConstructorMarker) null);
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getErrorCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.vungle.ads.internal.load.BaseAdLoader.ErrorInfo getErrorInfo(com.vungle.ads.internal.model.AdPayload r12) {
        /*
            r11 = this;
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = r12.adUnit()
            if (r0 == 0) goto L_0x0012
            java.lang.Integer r0 = r0.getErrorCode()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.intValue()
            r2 = r0
            goto L_0x0016
        L_0x0012:
            r0 = 212(0xd4, float:2.97E-43)
            r2 = 212(0xd4, float:2.97E-43)
        L_0x0016:
            com.vungle.ads.internal.model.AdPayload$AdUnit r0 = r12.adUnit()
            r1 = 0
            if (r0 == 0) goto L_0x0022
            java.lang.Integer r0 = r0.getSleep()
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            com.vungle.ads.internal.model.AdPayload$AdUnit r12 = r12.adUnit()
            if (r12 == 0) goto L_0x002d
            java.lang.String r1 = r12.getInfo()
        L_0x002d:
            r12 = 10001(0x2711, float:1.4014E-41)
            java.lang.String r3 = "Response error: "
            if (r2 == r12) goto L_0x006a
            r12 = 10002(0x2712, float:1.4016E-41)
            if (r2 == r12) goto L_0x006a
            r12 = 20001(0x4e21, float:2.8027E-41)
            if (r2 == r12) goto L_0x006a
            r12 = 30001(0x7531, float:4.204E-41)
            if (r2 == r12) goto L_0x006a
            r12 = 30002(0x7532, float:4.2042E-41)
            if (r2 == r12) goto L_0x006a
            com.vungle.ads.internal.load.BaseAdLoader$ErrorInfo r12 = new com.vungle.ads.internal.load.BaseAdLoader$ErrorInfo
            r5 = 212(0xd4, float:2.97E-43)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r6 = r2.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Request failed with error: 212, "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r7 = r0.toString()
            r8 = 0
            r9 = 8
            r10 = 0
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r12
        L_0x006a:
            com.vungle.ads.internal.load.BaseAdLoader$ErrorInfo r12 = new com.vungle.ads.internal.load.BaseAdLoader$ErrorInfo
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r0)
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Request failed with error: "
            r0.<init>(r4)
            r0.append(r2)
            java.lang.String r4 = ", "
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r5 = 0
            r6 = 8
            r7 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.load.BaseAdLoader.getErrorInfo(com.vungle.ads.internal.model.AdPayload):com.vungle.ads.internal.load.BaseAdLoader$ErrorInfo");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/vungle/ads/internal/load/BaseAdLoader$ErrorInfo;", "", "reason", "", "description", "", "descriptionExternal", "errorIsTerminal", "", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getDescription", "()Ljava/lang/String;", "getDescriptionExternal", "getErrorIsTerminal", "()Z", "getReason", "()I", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BaseAdLoader.kt */
    public static final class ErrorInfo {
        private final String description;
        private final String descriptionExternal;
        private final boolean errorIsTerminal;
        private final int reason;

        public ErrorInfo(int i, String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "description");
            Intrinsics.checkNotNullParameter(str2, "descriptionExternal");
            this.reason = i;
            this.description = str;
            this.descriptionExternal = str2;
            this.errorIsTerminal = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ErrorInfo(int i, String str, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? str : str2, (i2 & 8) != 0 ? false : z);
        }

        public final int getReason() {
            return this.reason;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getDescriptionExternal() {
            return this.descriptionExternal;
        }

        public final boolean getErrorIsTerminal() {
            return this.errorIsTerminal;
        }
    }
}
