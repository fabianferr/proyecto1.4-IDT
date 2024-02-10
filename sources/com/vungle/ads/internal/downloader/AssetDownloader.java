package com.vungle.ads.internal.downloader;

import android.util.Log;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InternalError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\"\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0002J\"\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010%\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017H\u0002J\u0012\u0010)\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u001a\u0010,\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/vungle/ads/internal/downloader/AssetDownloader;", "Lcom/vungle/ads/internal/downloader/Downloader;", "downloadExecutor", "Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "(Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;Lcom/vungle/ads/internal/util/PathProvider;)V", "okHttpClient", "Lokhttp3/OkHttpClient;", "progressStep", "", "transitioning", "", "Lcom/vungle/ads/internal/downloader/DownloadRequest;", "cancel", "", "request", "cancelAll", "checkSpaceAvailable", "", "decodeGzipIfNeeded", "Lokhttp3/ResponseBody;", "networkResponse", "Lokhttp3/Response;", "deliverError", "downloadRequest", "downloadListener", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "downloadError", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$DownloadError;", "deliverProgress", "copy", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$Progress;", "listener", "deliverSuccess", "file", "Ljava/io/File;", "download", "getContentLength", "", "response", "isValidUrl", "httpUrl", "", "launchRequest", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AssetDownloader.kt */
public final class AssetDownloader implements Downloader {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DOWNLOAD_CHUNK_SIZE = 2048;
    private static final String GZIP = "gzip";
    private static final String IDENTITY = "identity";
    private static final long MAX_PERCENT = 100;
    private static final int MINIMUM_SPACE_REQUIRED_MB = 20971520;
    private static final int PROGRESS_STEP = 5;
    private static final String TAG = "AssetDownloader";
    private static final int TIMEOUT = 30;
    private final VungleThreadPoolExecutor downloadExecutor;
    private OkHttpClient okHttpClient;
    private final PathProvider pathProvider;
    private final int progressStep = 5;
    private final List<DownloadRequest> transitioning = new ArrayList();

    public AssetDownloader(VungleThreadPoolExecutor vungleThreadPoolExecutor, PathProvider pathProvider2) {
        Intrinsics.checkNotNullParameter(vungleThreadPoolExecutor, "downloadExecutor");
        Intrinsics.checkNotNullParameter(pathProvider2, "pathProvider");
        this.downloadExecutor = vungleThreadPoolExecutor;
        this.pathProvider = pathProvider2;
        OkHttpClient.Builder followSslRedirects = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).cache((Cache) null).followRedirects(true).followSslRedirects(true);
        if (ConfigManager.INSTANCE.isCleverCacheEnabled()) {
            long cleverCacheDiskSize = ConfigManager.INSTANCE.getCleverCacheDiskSize();
            int cleverCacheDiskPercentage = ConfigManager.INSTANCE.getCleverCacheDiskPercentage();
            String absolutePath = pathProvider2.getCleverCacheDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "pathProvider.getCleverCacheDir().absolutePath");
            long min = Math.min(cleverCacheDiskSize, (pathProvider2.getAvailableBytes(absolutePath) * ((long) cleverCacheDiskPercentage)) / ((long) 100));
            if (min > 0) {
                followSslRedirects.cache(new Cache(pathProvider2.getCleverCacheDir(), min));
            } else {
                Log.w(TAG, "cache disk capacity size <=0, no clever cache active.");
            }
        }
        this.okHttpClient = followSslRedirects.build();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vungle/ads/internal/downloader/AssetDownloader$Companion;", "", "()V", "CONTENT_ENCODING", "", "CONTENT_TYPE", "DOWNLOAD_CHUNK_SIZE", "", "GZIP", "IDENTITY", "MAX_PERCENT", "", "MINIMUM_SPACE_REQUIRED_MB", "PROGRESS_STEP", "TAG", "TIMEOUT", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AssetDownloader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void download(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        if (downloadRequest != null) {
            this.transitioning.add(downloadRequest);
            this.downloadExecutor.execute(new AssetDownloader$download$1(this, downloadRequest, assetDownloadListener), new AssetDownloader$$ExternalSyntheticLambda0(this, downloadRequest, assetDownloadListener));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: download$lambda-0  reason: not valid java name */
    public static final void m2295download$lambda0(AssetDownloader assetDownloader, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        Intrinsics.checkNotNullParameter(assetDownloader, "this$0");
        assetDownloader.deliverError(downloadRequest, assetDownloadListener, new AssetDownloadListener.DownloadError(-1, new InternalError(3001, (String) null, 2, (DefaultConstructorMarker) null), AssetDownloadListener.DownloadError.ErrorReason.Companion.getINTERNAL_ERROR()));
    }

    private final void deliverError(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener, AssetDownloadListener.DownloadError downloadError) {
        if (assetDownloadListener != null) {
            assetDownloadListener.onError(downloadError, downloadRequest);
        }
    }

    public void cancel(DownloadRequest downloadRequest) {
        if (downloadRequest != null && !downloadRequest.isCancelled()) {
            downloadRequest.cancel();
        }
    }

    public void cancelAll() {
        for (DownloadRequest cancel : this.transitioning) {
            cancel(cancel);
        }
        this.transitioning.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v1, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v2, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v3, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v6, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v4, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v5, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v6, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v7, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v8, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v14, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v9, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v10, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v11, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v12, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v17, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v14, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v19, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v18, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v21, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v20, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v22, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v22, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v23, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v24, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v24, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v25, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v26, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v28, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v27, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v29, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v29, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v30, resolved type: okio.BufferedSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v30, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: okhttp3.Call} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v33, resolved type: okhttp3.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v27, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v29, resolved type: okhttp3.Response} */
    /* JADX WARNING: type inference failed for: r7v9, types: [okhttp3.ResponseBody] */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r17v10 */
    /* JADX WARNING: type inference failed for: r17v11 */
    /* JADX WARNING: type inference failed for: r17v25 */
    /* JADX WARNING: type inference failed for: r17v27 */
    /* JADX WARNING: type inference failed for: r17v31 */
    /* JADX WARNING: type inference failed for: r17v32 */
    /* JADX WARNING: type inference failed for: r27v32 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0463, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0464, code lost:
        r2 = r39;
        r3 = r40;
        r14 = r5;
        r5 = r4;
        r4 = r26;
        r27 = r10;
        r17 = r12;
        r18 = r13;
        r15 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0474, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0475, code lost:
        r2 = r39;
        r3 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:?, code lost:
        com.vungle.ads.AnalyticsClient.logError$vungle_ads_release$default(com.vungle.ads.AnalyticsClient.INSTANCE, 112, "Failed to load asset: " + r39.getUrl(), (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, 28, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0572, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0573, code lost:
        r15 = r14;
        r12 = r16;
        r18 = null;
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x057c, code lost:
        if ((r0 instanceof java.net.UnknownHostException) == false) goto L_0x057e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0580, code lost:
        if ((r0 instanceof java.io.IOException) != false) goto L_0x0589;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0590, code lost:
        r9 = r9;
        r18 = null;
        r15 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:?, code lost:
        r9 = new com.vungle.ads.AssetFailedStatusCodeError(r7, (java.lang.Integer) null, r39.getPlacementId(), 2, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r9.logErrorNoReturnValue$vungle_ads_release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x05bc, code lost:
        r12 = r16.body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x05c1, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x05d2, code lost:
        r19.cancel();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x05f5, code lost:
        deliverProgress(r6, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x05ff, code lost:
        if (r0 == com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion.getDONE()) goto L_0x0601;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0601, code lost:
        deliverSuccess(r8, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x060b, code lost:
        if (r0 == com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion.getSTARTED()) goto L_0x060d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x060d, code lost:
        deliverError(r2, r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0617, code lost:
        if (r0 == com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion.getERROR()) goto L_0x0619;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0619, code lost:
        deliverError(r2, r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x061d, code lost:
        android.util.Log.w(r15, r5 + r6.getStatus());
        deliverError(r2, r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x063f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0474 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:116:0x028b] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x054b A[SYNTHETIC, Splitter:B:261:0x054b] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x057a A[SYNTHETIC, Splitter:B:265:0x057a] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x05bc  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x05c1  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x05f5  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0649  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x065e  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0681  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x06be  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void launchRequest(com.vungle.ads.internal.downloader.DownloadRequest r39, com.vungle.ads.internal.downloader.AssetDownloadListener r40) {
        /*
            r38 = this;
            r1 = r38
            r2 = r39
            r3 = r40
            java.lang.String r4 = "status:"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "launch request in thread:"
            r0.<init>(r5)
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            long r5 = r5.getId()
            r0.append(r5)
            java.lang.String r5 = " request: "
            r0.append(r5)
            java.lang.String r5 = r39.getUrl()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "AssetDownloader"
            android.util.Log.d(r5, r0)
            boolean r0 = r39.isCancelled()
            if (r0 == 0) goto L_0x0062
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Request "
            r0.<init>(r4)
            java.lang.String r4 = r39.getUrl()
            r0.append(r4)
            java.lang.String r4 = " is cancelled before starting"
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress r0 = new com.vungle.ads.internal.downloader.AssetDownloadListener$Progress
            r0.<init>()
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getCANCELLED()
            r0.setStatus(r4)
            r1.deliverProgress(r0, r2, r3)
            return
        L_0x0062:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress r6 = new com.vungle.ads.internal.downloader.AssetDownloadListener$Progress
            r6.<init>()
            long r7 = java.lang.System.currentTimeMillis()
            r6.setTimestampDownloadStart(r7)
            java.lang.String r7 = r39.getUrl()
            java.lang.String r0 = r39.getPath()
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0084
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r8 = 0
            goto L_0x0085
        L_0x0084:
            r8 = 1
        L_0x0085:
            r13 = -1
            if (r8 != 0) goto L_0x06c3
            boolean r8 = r1.isValidUrl(r7)
            if (r8 != 0) goto L_0x0090
            goto L_0x06c3
        L_0x0090:
            r8 = r0
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x009e
            int r8 = r8.length()
            if (r8 != 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r8 = 0
            goto L_0x009f
        L_0x009e:
            r8 = 1
        L_0x009f:
            if (r8 == 0) goto L_0x00b7
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r0 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError
            com.vungle.ads.AssetDownloadError r4 = new com.vungle.ads.AssetDownloadError
            r4.<init>()
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r5 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion
            int r5 = r5.getFILE_NOT_FOUND_ERROR()
            r0.<init>(r13, r4, r5)
            r1.deliverError(r2, r3, r0)
            return
        L_0x00b7:
            boolean r8 = r38.checkSpaceAvailable()
            r12 = 0
            if (r8 != 0) goto L_0x00d7
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r0 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError
            com.vungle.ads.InternalError r4 = new com.vungle.ads.InternalError
            r5 = 10019(0x2723, float:1.404E-41)
            r6 = 2
            r4.<init>(r5, r12, r6, r12)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r5 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion
            int r5 = r5.getDISK_ERROR()
            r0.<init>(r13, r4, r5)
            r1.deliverError(r2, r3, r0)
            return
        L_0x00d7:
            java.io.File r8 = new java.io.File
            r8.<init>(r0)
            r11 = r12
            r0 = 0
        L_0x00de:
            if (r0 != 0) goto L_0x06c2
            java.io.File r0 = r8.getParentFile()     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            if (r0 == 0) goto L_0x010d
            boolean r9 = r0.exists()     // Catch:{ Exception -> 0x00fe, all -> 0x00f0 }
            if (r9 != 0) goto L_0x010d
            r0.mkdirs()     // Catch:{ Exception -> 0x00fe, all -> 0x00f0 }
            goto L_0x010d
        L_0x00f0:
            r0 = move-exception
            r15 = r5
            r17 = r12
            r18 = r17
            r19 = r18
            r27 = r19
        L_0x00fa:
            r5 = r4
            r4 = r11
            goto L_0x0647
        L_0x00fe:
            r0 = move-exception
            r14 = r5
            r16 = r12
            r17 = r16
            r19 = r17
            r27 = r19
            r15 = 1
        L_0x0109:
            r5 = r4
            r4 = r11
            goto L_0x0540
        L_0x010d:
            boolean r0 = r8.exists()     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            r16 = 0
            if (r0 == 0) goto L_0x011a
            long r9 = r8.length()     // Catch:{ Exception -> 0x00fe, all -> 0x00f0 }
            goto L_0x011c
        L_0x011a:
            r9 = r16
        L_0x011c:
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            r0.<init>()     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            okhttp3.Request$Builder r0 = r0.url((java.lang.String) r7)     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            okhttp3.OkHttpClient r12 = r1.okHttpClient     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            okhttp3.Request r0 = r0.build()     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            okhttp3.Call r19 = r12.newCall(r0)     // Catch:{ Exception -> 0x0533, all -> 0x0523 }
            okhttp3.Response r12 = r19.execute()     // Catch:{ Exception -> 0x0519, all -> 0x050e }
            long r20 = r1.getContentLength(r12)     // Catch:{ Exception -> 0x0505, all -> 0x04fe }
            int r0 = r12.code()     // Catch:{ Exception -> 0x0505, all -> 0x04fe }
            boolean r22 = r12.isSuccessful()     // Catch:{ Exception -> 0x0505, all -> 0x04fe }
            if (r22 == 0) goto L_0x04cd
            okhttp3.Response r0 = r12.cacheResponse()     // Catch:{ Exception -> 0x0505, all -> 0x04fe }
            if (r0 == 0) goto L_0x0195
            com.vungle.ads.AnalyticsClient r0 = com.vungle.ads.AnalyticsClient.INSTANCE     // Catch:{ Exception -> 0x0184, all -> 0x0174 }
            com.vungle.ads.SingleValueMetric r13 = new com.vungle.ads.SingleValueMetric     // Catch:{ Exception -> 0x0184, all -> 0x0174 }
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r14 = com.vungle.ads.internal.protos.Sdk.SDKMetric.SDKMetricType.CACHED_ASSETS_USED     // Catch:{ Exception -> 0x0184, all -> 0x0174 }
            r13.<init>(r14)     // Catch:{ Exception -> 0x0184, all -> 0x0174 }
            java.lang.String r14 = r39.getPlacementId()     // Catch:{ Exception -> 0x0184, all -> 0x0174 }
            java.lang.String r24 = r39.getCreativeId()     // Catch:{ Exception -> 0x0184, all -> 0x0174 }
            java.lang.String r25 = r39.getEventId()     // Catch:{ Exception -> 0x0184, all -> 0x0174 }
            r2 = r9
            r9 = r0
            r10 = r13
            r13 = r11
            r11 = r14
            r18 = r12
            r14 = 0
            r12 = r24
            r26 = r13
            r13 = r25
            r15 = 1
            r14 = r7
            r9.logMetric$vungle_ads_release((com.vungle.ads.SingleValueMetric) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            goto L_0x019b
        L_0x0174:
            r0 = move-exception
            r18 = r12
            r2 = r39
            r3 = r40
            r15 = r5
            r17 = 0
            r18 = 0
            r27 = 0
            goto L_0x00fa
        L_0x0184:
            r0 = move-exception
            r18 = r12
            r15 = 1
            r2 = r39
            r3 = r40
            r14 = r5
            r16 = r18
            r17 = 0
            r27 = 0
            goto L_0x0109
        L_0x0195:
            r2 = r9
            r26 = r11
            r18 = r12
            r15 = 1
        L_0x019b:
            okhttp3.Headers r0 = r18.headers()     // Catch:{ Exception -> 0x04c1, all -> 0x04b5 }
            java.lang.String r9 = "Content-Encoding"
            java.lang.String r0 = r0.get(r9)     // Catch:{ Exception -> 0x04c1, all -> 0x04b5 }
            if (r0 == 0) goto L_0x0207
            java.lang.String r9 = "gzip"
            boolean r9 = kotlin.text.StringsKt.equals(r9, r0, r15)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            if (r9 != 0) goto L_0x0207
            java.lang.String r9 = "identity"
            boolean r9 = kotlin.text.StringsKt.equals(r9, r0, r15)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            if (r9 == 0) goto L_0x01b8
            goto L_0x0207
        L_0x01b8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            r2.<init>()     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            java.lang.String r3 = "loadAd: Unknown Content-Encoding "
            r2.append(r3)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            r2.append(r0)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            android.util.Log.w(r5, r2)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            r3.<init>()     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            java.lang.String r9 = "Unknown Content-Encoding "
            r3.append(r9)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            r3.append(r0)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
            throw r2     // Catch:{ Exception -> 0x01f6, all -> 0x01e3 }
        L_0x01e3:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r15 = r5
            r12 = r18
        L_0x01eb:
            r17 = 0
            r18 = 0
            r27 = 0
            r5 = r4
        L_0x01f2:
            r4 = r26
            goto L_0x0647
        L_0x01f6:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r16 = r18
        L_0x01fe:
            r17 = 0
            r27 = 0
        L_0x0202:
            r5 = r4
            r4 = r26
            goto L_0x0540
        L_0x0207:
            r9 = r18
            okhttp3.ResponseBody r0 = r1.decodeGzipIfNeeded(r9)     // Catch:{ Exception -> 0x04ae, all -> 0x04a7 }
            if (r0 == 0) goto L_0x0226
            okio.BufferedSource r10 = r0.source()     // Catch:{ Exception -> 0x021d, all -> 0x0215 }
            r12 = r10
            goto L_0x0227
        L_0x0215:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r15 = r5
            r12 = r9
            goto L_0x01eb
        L_0x021d:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r16 = r9
            goto L_0x01fe
        L_0x0226:
            r12 = 0
        L_0x0227:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            r10.<init>()     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            java.lang.String r11 = "Start download from bytes:"
            r10.append(r11)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            r10.append(r2)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            java.lang.String r11 = ", url: "
            r10.append(r11)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            r10.append(r7)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            android.util.Log.d(r5, r10)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            long r20 = r20 + r2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            r10.<init>()     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            java.lang.String r11 = "final offset = "
            r10.append(r11)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            r10.append(r2)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            android.util.Log.d(r5, r10)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            int r10 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r10 != 0) goto L_0x0281
            r13 = 0
            r14 = 0
            okio.Sink r10 = okio.Okio__JvmOkioKt.sink$default(r8, r14, r15, r13)     // Catch:{ Exception -> 0x0274, all -> 0x0264 }
            goto L_0x0287
        L_0x0264:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r15 = r5
            r17 = r12
            r18 = r13
            r27 = r18
        L_0x0270:
            r5 = r4
            r12 = r9
            goto L_0x01f2
        L_0x0274:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r16 = r9
            r17 = r12
            r27 = r13
            goto L_0x0202
        L_0x0281:
            r13 = 0
            r14 = 0
            okio.Sink r10 = okio.Okio.appendingSink(r8)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
        L_0x0287:
            okio.BufferedSink r10 = okio.Okio.buffer((okio.Sink) r10)     // Catch:{ Exception -> 0x0498, all -> 0x0485 }
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r11 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x0474, all -> 0x0463 }
            int r11 = r11.getSTARTED()     // Catch:{ Exception -> 0x0474, all -> 0x0463 }
            r6.setStatus(r11)     // Catch:{ Exception -> 0x0474, all -> 0x0463 }
            if (r0 == 0) goto L_0x02b8
            long r22 = r0.contentLength()     // Catch:{ Exception -> 0x02aa, all -> 0x029d }
            r13 = r22
            goto L_0x02ba
        L_0x029d:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r15 = r5
            r27 = r10
            r17 = r12
            r18 = r13
            goto L_0x0270
        L_0x02aa:
            r0 = move-exception
            r2 = r39
            r3 = r40
        L_0x02af:
            r14 = r5
            r16 = r9
            r27 = r10
            r17 = r12
            goto L_0x0202
        L_0x02b8:
            r13 = r16
        L_0x02ba:
            r6.setSizeBytes(r13)     // Catch:{ Exception -> 0x0474, all -> 0x0452 }
            r6.setStartBytes(r2)     // Catch:{ Exception -> 0x0474, all -> 0x0452 }
            r13 = r2
            r2 = r39
            r3 = r40
            r1.deliverProgress(r6, r2, r3)     // Catch:{ Exception -> 0x0450, all -> 0x044e }
            r23 = r16
            r0 = 0
        L_0x02cb:
            if (r12 == 0) goto L_0x0300
            okio.Buffer r11 = r10.getBuffer()     // Catch:{ Exception -> 0x02fe, all -> 0x02f4 }
            r25 = r4
            r27 = r5
            r4 = 2048(0x800, double:1.0118E-320)
            long r4 = r12.read(r11, r4)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            goto L_0x0306
        L_0x02dc:
            r0 = move-exception
            r17 = r12
            r5 = r25
            r4 = r26
            goto L_0x043d
        L_0x02e5:
            r0 = move-exception
            r16 = r9
            r17 = r12
            r5 = r25
            r4 = r26
            r14 = r27
            r27 = r10
            goto L_0x0540
        L_0x02f4:
            r0 = move-exception
            r15 = r5
            r27 = r10
            r17 = r12
            r18 = 0
            goto L_0x0270
        L_0x02fe:
            r0 = move-exception
            goto L_0x02af
        L_0x0300:
            r25 = r4
            r27 = r5
            r4 = -1
        L_0x0306:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0446, all -> 0x0436 }
            int r11 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x0390
            boolean r11 = r8.exists()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            if (r11 == 0) goto L_0x0366
            boolean r11 = r39.isCancelled()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            if (r11 == 0) goto L_0x0322
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r0 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r0 = r0.getCANCELLED()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r6.setStatus(r0)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            goto L_0x0390
        L_0x0322:
            r10.emit()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            long r23 = r23 + r4
            long r4 = r13 + r23
            r28 = 100
            int r11 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x0334
            long r4 = r4 * r28
            long r4 = r4 / r20
            int r0 = (int) r4     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
        L_0x0334:
            int r4 = r6.getProgressPercent()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r5 = r1.progressStep     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r4 = r4 + r5
            if (r4 > r0) goto L_0x0360
            int r4 = r6.getProgressPercent()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r5 = r1.progressStep     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r11 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1))
            if (r11 > 0) goto L_0x0360
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r4 = r4.getIN_PROGRESS()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r6.setStatus(r4)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r4 = r6.getProgressPercent()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r5 = r1.progressStep     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r4 = r4 + r5
            r6.setProgressPercent(r4)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r1.deliverProgress(r6, r2, r3)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            goto L_0x0334
        L_0x0360:
            r4 = r25
            r5 = r27
            goto L_0x02cb
        L_0x0366:
            com.vungle.ads.AnalyticsClient r30 = com.vungle.ads.AnalyticsClient.INSTANCE     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r31 = 114(0x72, float:1.6E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r0.<init>()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            java.lang.String r4 = "Asset save error "
            r0.append(r4)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r0.append(r7)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            java.lang.String r32 = r0.toString()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 28
            r37 = 0
            com.vungle.ads.AnalyticsClient.logError$vungle_ads_release$default((com.vungle.ads.AnalyticsClient) r30, (int) r31, (java.lang.String) r32, (java.lang.String) r33, (java.lang.String) r34, (java.lang.String) r35, (int) r36, (java.lang.Object) r37)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            com.vungle.ads.internal.downloader.Downloader$RequestException r0 = new com.vungle.ads.internal.downloader.Downloader$RequestException     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            java.lang.String r4 = "File is not existing"
            r0.<init>(r4)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            throw r0     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
        L_0x0390:
            r10.flush()     // Catch:{ Exception -> 0x0446, all -> 0x0436 }
            int r0 = r6.getStatus()     // Catch:{ Exception -> 0x0446, all -> 0x0436 }
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x0446, all -> 0x0436 }
            int r4 = r4.getIN_PROGRESS()     // Catch:{ Exception -> 0x0446, all -> 0x0436 }
            if (r0 != r4) goto L_0x03a8
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r0 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            int r0 = r0.getDONE()     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
            r6.setStatus(r0)     // Catch:{ Exception -> 0x02e5, all -> 0x02dc }
        L_0x03a8:
            if (r9 == 0) goto L_0x03af
            okhttp3.ResponseBody r0 = r9.body()
            goto L_0x03b0
        L_0x03af:
            r0 = 0
        L_0x03b0:
            if (r0 == 0) goto L_0x03bd
            okhttp3.ResponseBody r0 = r9.body()
            if (r0 == 0) goto L_0x03bd
            r0.close()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x03bd:
            if (r19 == 0) goto L_0x03c4
            r19.cancel()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x03c4:
            com.vungle.ads.internal.util.FileUtility r0 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            java.io.Closeable r10 = (java.io.Closeable) r10
            r0.closeQuietly(r10)
            com.vungle.ads.internal.util.FileUtility r0 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            java.io.Closeable r12 = (java.io.Closeable) r12
            r0.closeQuietly(r12)
            int r0 = r6.getStatus()
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getCANCELLED()
            if (r0 != r4) goto L_0x03e8
            r1.deliverProgress(r6, r2, r3)
        L_0x03e1:
            r5 = r25
            r4 = r26
        L_0x03e5:
            r14 = r27
            goto L_0x042e
        L_0x03e8:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getDONE()
            if (r0 != r4) goto L_0x03f4
            r1.deliverSuccess(r8, r2, r3)
            goto L_0x03e1
        L_0x03f4:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getSTARTED()
            if (r0 != r4) goto L_0x0406
            r4 = r26
            if (r4 == 0) goto L_0x0403
            r1.deliverError(r2, r3, r4)
        L_0x0403:
            r5 = r25
            goto L_0x03e5
        L_0x0406:
            r4 = r26
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r5 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r5 = r5.getERROR()
            if (r0 != r5) goto L_0x0414
            r1.deliverError(r2, r3, r4)
            goto L_0x0403
        L_0x0414:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r5 = r25
            r0.<init>(r5)
            int r9 = r6.getStatus()
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r14 = r27
            android.util.Log.w(r14, r0)
            r1.deliverError(r2, r3, r4)
        L_0x042e:
            r15 = r14
            r11 = -1
            r18 = 0
            r22 = 0
            goto L_0x0634
        L_0x0436:
            r0 = move-exception
            r5 = r25
            r4 = r26
            r17 = r12
        L_0x043d:
            r15 = r27
            r18 = 0
            r12 = r9
            r27 = r10
            goto L_0x0647
        L_0x0446:
            r0 = move-exception
            r5 = r25
            r4 = r26
            r14 = r27
            goto L_0x047d
        L_0x044e:
            r0 = move-exception
            goto L_0x0457
        L_0x0450:
            r0 = move-exception
            goto L_0x0479
        L_0x0452:
            r0 = move-exception
            r2 = r39
            r3 = r40
        L_0x0457:
            r14 = r5
            r5 = r4
            r4 = r26
            r27 = r10
            r17 = r12
            r15 = r14
            r18 = 0
            goto L_0x0495
        L_0x0463:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r5 = r4
            r4 = r26
            r27 = r10
            r17 = r12
            r18 = r13
            r15 = r14
            goto L_0x0495
        L_0x0474:
            r0 = move-exception
            r2 = r39
            r3 = r40
        L_0x0479:
            r14 = r5
            r5 = r4
            r4 = r26
        L_0x047d:
            r16 = r9
            r27 = r10
            r17 = r12
            goto L_0x0540
        L_0x0485:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r5 = r4
            r4 = r26
            r17 = r12
            r15 = r14
            r18 = 0
            r27 = 0
        L_0x0495:
            r12 = r9
            goto L_0x0647
        L_0x0498:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r5 = r4
            r4 = r26
            r16 = r9
            r17 = r12
            goto L_0x053e
        L_0x04a7:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            goto L_0x04bd
        L_0x04ae:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            goto L_0x04c9
        L_0x04b5:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r9 = r18
        L_0x04bd:
            r5 = r4
            r4 = r26
            goto L_0x04fa
        L_0x04c1:
            r0 = move-exception
            r2 = r39
            r3 = r40
            r14 = r5
            r9 = r18
        L_0x04c9:
            r5 = r4
            r4 = r26
            goto L_0x050b
        L_0x04cd:
            r14 = r5
            r9 = r12
            r15 = 1
            r5 = r4
            r4 = r11
            com.vungle.ads.AssetFailedStatusCodeError r10 = new com.vungle.ads.AssetFailedStatusCodeError     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            java.lang.String r12 = r39.getPlacementId()     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            r10.<init>(r7, r11, r12)     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            r10.logErrorNoReturnValue$vungle_ads_release()     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            com.vungle.ads.internal.downloader.Downloader$RequestException r10 = new com.vungle.ads.internal.downloader.Downloader$RequestException     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            r11.<init>()     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            java.lang.String r12 = "Code: "
            r11.append(r12)     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            r11.append(r0)     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
            throw r10     // Catch:{ Exception -> 0x04fc, all -> 0x04f9 }
        L_0x04f9:
            r0 = move-exception
        L_0x04fa:
            r12 = r9
            goto L_0x0503
        L_0x04fc:
            r0 = move-exception
            goto L_0x050b
        L_0x04fe:
            r0 = move-exception
            r14 = r5
            r9 = r12
            r5 = r4
            r4 = r11
        L_0x0503:
            r15 = r14
            goto L_0x0514
        L_0x0505:
            r0 = move-exception
            r14 = r5
            r9 = r12
            r15 = 1
            r5 = r4
            r4 = r11
        L_0x050b:
            r16 = r9
            goto L_0x0520
        L_0x050e:
            r0 = move-exception
            r14 = r5
            r5 = r4
            r4 = r11
            r15 = r14
            r12 = 0
        L_0x0514:
            r17 = 0
            r18 = 0
            goto L_0x052f
        L_0x0519:
            r0 = move-exception
            r14 = r5
            r15 = 1
            r5 = r4
            r4 = r11
            r16 = 0
        L_0x0520:
            r17 = 0
            goto L_0x053e
        L_0x0523:
            r0 = move-exception
            r14 = r5
            r5 = r4
            r4 = r11
            r15 = r14
            r12 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x052f:
            r27 = 0
            goto L_0x0647
        L_0x0533:
            r0 = move-exception
            r14 = r5
            r15 = 1
            r5 = r4
            r4 = r11
            r16 = 0
            r17 = 0
            r19 = 0
        L_0x053e:
            r27 = 0
        L_0x0540:
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0641 }
            android.util.Log.e(r14, r9)     // Catch:{ all -> 0x0641 }
            boolean r9 = r0 instanceof java.net.ProtocolException     // Catch:{ all -> 0x0641 }
            if (r9 == 0) goto L_0x057a
            com.vungle.ads.AnalyticsClient r28 = com.vungle.ads.AnalyticsClient.INSTANCE     // Catch:{ all -> 0x0572 }
            r29 = 112(0x70, float:1.57E-43)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0572 }
            r9.<init>()     // Catch:{ all -> 0x0572 }
            java.lang.String r10 = "Failed to load asset: "
            r9.append(r10)     // Catch:{ all -> 0x0572 }
            java.lang.String r10 = r39.getUrl()     // Catch:{ all -> 0x0572 }
            r9.append(r10)     // Catch:{ all -> 0x0572 }
            java.lang.String r30 = r9.toString()     // Catch:{ all -> 0x0572 }
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 28
            r35 = 0
            com.vungle.ads.AnalyticsClient.logError$vungle_ads_release$default((com.vungle.ads.AnalyticsClient) r28, (int) r29, (java.lang.String) r30, (java.lang.String) r31, (java.lang.String) r32, (java.lang.String) r33, (int) r34, (java.lang.Object) r35)     // Catch:{ all -> 0x0572 }
            goto L_0x0583
        L_0x0572:
            r0 = move-exception
            r15 = r14
            r12 = r16
            r18 = 0
            goto L_0x0647
        L_0x057a:
            boolean r9 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x0641 }
            if (r9 != 0) goto L_0x0589
            boolean r9 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x0572 }
            if (r9 == 0) goto L_0x0583
            goto L_0x0589
        L_0x0583:
            r15 = r14
            r18 = 0
            r22 = 0
            goto L_0x05a3
        L_0x0589:
            com.vungle.ads.AssetFailedStatusCodeError r20 = new com.vungle.ads.AssetFailedStatusCodeError     // Catch:{ all -> 0x0641 }
            r11 = 0
            java.lang.String r12 = r39.getPlacementId()     // Catch:{ all -> 0x0641 }
            r13 = 2
            r21 = 0
            r9 = r20
            r10 = r7
            r18 = 0
            r15 = r14
            r22 = 0
            r14 = r21
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x063f }
            r20.logErrorNoReturnValue$vungle_ads_release()     // Catch:{ all -> 0x063f }
        L_0x05a3:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r9 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion     // Catch:{ all -> 0x063f }
            int r9 = r9.getERROR()     // Catch:{ all -> 0x063f }
            r6.setStatus(r9)     // Catch:{ all -> 0x063f }
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r9 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x063f }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x063f }
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r10 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion     // Catch:{ all -> 0x063f }
            int r10 = r10.getREQUEST_ERROR()     // Catch:{ all -> 0x063f }
            r11 = -1
            r9.<init>(r11, r0, r10)     // Catch:{ all -> 0x063f }
            if (r16 == 0) goto L_0x05c1
            okhttp3.ResponseBody r12 = r16.body()
            goto L_0x05c3
        L_0x05c1:
            r12 = r18
        L_0x05c3:
            if (r12 == 0) goto L_0x05d0
            okhttp3.ResponseBody r0 = r16.body()
            if (r0 == 0) goto L_0x05d0
            r0.close()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x05d0:
            if (r19 == 0) goto L_0x05d7
            r19.cancel()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x05d7:
            com.vungle.ads.internal.util.FileUtility r0 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            r4 = r27
            java.io.Closeable r4 = (java.io.Closeable) r4
            r0.closeQuietly(r4)
            com.vungle.ads.internal.util.FileUtility r0 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            r4 = r17
            java.io.Closeable r4 = (java.io.Closeable) r4
            r0.closeQuietly(r4)
            int r0 = r6.getStatus()
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getCANCELLED()
            if (r0 != r4) goto L_0x05f9
            r1.deliverProgress(r6, r2, r3)
            goto L_0x0633
        L_0x05f9:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getDONE()
            if (r0 != r4) goto L_0x0605
            r1.deliverSuccess(r8, r2, r3)
            goto L_0x0633
        L_0x0605:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getSTARTED()
            if (r0 != r4) goto L_0x0611
            r1.deliverError(r2, r3, r9)
            goto L_0x0633
        L_0x0611:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r4 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r4 = r4.getERROR()
            if (r0 != r4) goto L_0x061d
            r1.deliverError(r2, r3, r9)
            goto L_0x0633
        L_0x061d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            int r4 = r6.getStatus()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r15, r0)
            r1.deliverError(r2, r3, r9)
        L_0x0633:
            r4 = r9
        L_0x0634:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r11 = r4
            r4 = r5
            r5 = r15
            r12 = r18
            r0 = 1
            r13 = -1
            goto L_0x00de
        L_0x063f:
            r0 = move-exception
            goto L_0x0645
        L_0x0641:
            r0 = move-exception
            r15 = r14
            r18 = 0
        L_0x0645:
            r12 = r16
        L_0x0647:
            if (r12 == 0) goto L_0x064f
            okhttp3.ResponseBody r7 = r12.body()
            r18 = r7
        L_0x064f:
            if (r18 == 0) goto L_0x065c
            okhttp3.ResponseBody r7 = r12.body()
            if (r7 == 0) goto L_0x065c
            r7.close()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x065c:
            if (r19 == 0) goto L_0x0663
            r19.cancel()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x0663:
            com.vungle.ads.internal.util.FileUtility r7 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            r9 = r27
            java.io.Closeable r9 = (java.io.Closeable) r9
            r7.closeQuietly(r9)
            com.vungle.ads.internal.util.FileUtility r7 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            r9 = r17
            java.io.Closeable r9 = (java.io.Closeable) r9
            r7.closeQuietly(r9)
            int r7 = r6.getStatus()
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r9 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r9 = r9.getCANCELLED()
            if (r7 == r9) goto L_0x06be
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r9 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r9 = r9.getDONE()
            if (r7 == r9) goto L_0x06ba
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r8 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r8 = r8.getSTARTED()
            if (r7 != r8) goto L_0x0697
            if (r4 == 0) goto L_0x06c1
            r1.deliverError(r2, r3, r4)
            goto L_0x06c1
        L_0x0697:
            com.vungle.ads.internal.downloader.AssetDownloadListener$Progress$ProgressStatus$Companion r8 = com.vungle.ads.internal.downloader.AssetDownloadListener.Progress.ProgressStatus.Companion
            int r8 = r8.getERROR()
            if (r7 != r8) goto L_0x06a3
            r1.deliverError(r2, r3, r4)
            goto L_0x06c1
        L_0x06a3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r5)
            int r5 = r6.getStatus()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            android.util.Log.w(r15, r5)
            r1.deliverError(r2, r3, r4)
            goto L_0x06c1
        L_0x06ba:
            r1.deliverSuccess(r8, r2, r3)
            goto L_0x06c1
        L_0x06be:
            r1.deliverProgress(r6, r2, r3)
        L_0x06c1:
            throw r0
        L_0x06c2:
            return
        L_0x06c3:
            r11 = -1
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError r0 = new com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError
            com.vungle.ads.AssetDownloadError r4 = new com.vungle.ads.AssetDownloadError
            r4.<init>()
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            com.vungle.ads.internal.downloader.AssetDownloadListener$DownloadError$ErrorReason$Companion r5 = com.vungle.ads.internal.downloader.AssetDownloadListener.DownloadError.ErrorReason.Companion
            int r5 = r5.getINTERNAL_ERROR()
            r0.<init>(r11, r4, r5)
            r1.deliverError(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.downloader.AssetDownloader.launchRequest(com.vungle.ads.internal.downloader.DownloadRequest, com.vungle.ads.internal.downloader.AssetDownloadListener):void");
    }

    private final ResponseBody decodeGzipIfNeeded(Response response) {
        ResponseBody body = response.body();
        if (!StringsKt.equals(GZIP, Response.header$default(response, "Content-Encoding", (String) null, 2, (Object) null), true) || body == null) {
            return body;
        }
        return new RealResponseBody(Response.header$default(response, "Content-Type", (String) null, 2, (Object) null), -1, Okio.buffer((Source) new GzipSource(body.source())));
    }

    private final long getContentLength(Response response) {
        String str = response.headers().get("Content-Length");
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            Response networkResponse = response.networkResponse();
            str = null;
            if (networkResponse != null) {
                str = Response.header$default(networkResponse, "Content-Length", (String) null, 2, (Object) null);
            }
        }
        CharSequence charSequence2 = str;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private final void deliverSuccess(File file, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        Log.d(TAG, "On success " + downloadRequest);
        if (assetDownloadListener != null) {
            assetDownloadListener.onSuccess(file, downloadRequest);
        }
    }

    private final void deliverProgress(AssetDownloadListener.Progress progress, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        Log.d(TAG, "On progress " + downloadRequest);
        if (assetDownloadListener != null) {
            assetDownloadListener.onProgress(progress, downloadRequest);
        }
    }

    private final boolean checkSpaceAvailable() {
        PathProvider pathProvider2 = this.pathProvider;
        String absolutePath = pathProvider2.getVungleDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "pathProvider.getVungleDir().absolutePath");
        long availableBytes = pathProvider2.getAvailableBytes(absolutePath);
        if (availableBytes >= 20971520) {
            return true;
        }
        AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
        AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 126, "Insufficient space " + availableBytes, (String) null, (String) null, (String) null, 28, (Object) null);
        return false;
    }

    private final boolean isValidUrl(String str) {
        CharSequence charSequence = str;
        return !(charSequence == null || charSequence.length() == 0) && HttpUrl.Companion.parse(str) != null;
    }
}
