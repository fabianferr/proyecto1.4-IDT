package com.vungle.ads.internal.load;

import android.util.Log;
import com.facebook.share.internal.ShareInternalUtility;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.MraidJsError;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.util.FileUtility;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"com/vungle/ads/internal/load/MraidJsLoader$downloadJs$1", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "onError", "", "error", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$DownloadError;", "downloadRequest", "Lcom/vungle/ads/internal/downloader/DownloadRequest;", "onProgress", "progress", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$Progress;", "onSuccess", "file", "Ljava/io/File;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MraidJsLoader.kt */
public final class MraidJsLoader$downloadJs$1 implements AssetDownloadListener {
    final /* synthetic */ Function1<Integer, Unit> $downloadListener;
    final /* synthetic */ File $jsPath;
    final /* synthetic */ File $mraidJsFile;

    public void onProgress(AssetDownloadListener.Progress progress, DownloadRequest downloadRequest) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(downloadRequest, "downloadRequest");
    }

    MraidJsLoader$downloadJs$1(File file, Function1<? super Integer, Unit> function1, File file2) {
        this.$jsPath = file;
        this.$downloadListener = function1;
        this.$mraidJsFile = file2;
    }

    public void onError(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest) {
        StringBuilder sb = new StringBuilder("download mraid js error: ");
        Throwable th = null;
        sb.append(downloadError != null ? Integer.valueOf(downloadError.getServerCode()) : null);
        sb.append(AbstractJsonLexerKt.COLON);
        if (downloadError != null) {
            th = downloadError.getCause();
        }
        sb.append(th);
        String sb2 = sb.toString();
        Log.d("MraidJsLoader", sb2);
        new MraidJsError(sb2).logErrorNoReturnValue$vungle_ads_release();
        FileUtility.deleteContents(this.$jsPath);
        this.$downloadListener.invoke(12);
    }

    public void onSuccess(File file, DownloadRequest downloadRequest) {
        Intrinsics.checkNotNullParameter(file, ShareInternalUtility.STAGING_PARAM);
        Intrinsics.checkNotNullParameter(downloadRequest, "downloadRequest");
        if (!this.$mraidJsFile.exists() || this.$mraidJsFile.length() <= 0) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 131, "Mraid js downloaded but write failure: " + this.$mraidJsFile.getAbsolutePath(), (String) null, (String) null, (String) null, 28, (Object) null);
            FileUtility.deleteContents(this.$jsPath);
            this.$downloadListener.invoke(12);
            return;
        }
        this.$downloadListener.invoke(10);
    }
}
