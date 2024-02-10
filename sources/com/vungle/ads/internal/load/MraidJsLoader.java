package com.vungle.ads.internal.load;

import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/vungle/ads/internal/load/MraidJsLoader;", "", "()V", "MRAID_AVAILABLE", "", "MRAID_DOWNLOADED", "MRAID_DOWNLOAD_FAILED", "MRAID_INVALID_ENDPOINT", "TAG", "", "downloadJs", "", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;", "downloadListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "downloadState", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MraidJsLoader.kt */
public final class MraidJsLoader {
    public static final MraidJsLoader INSTANCE = new MraidJsLoader();
    public static final int MRAID_AVAILABLE = 13;
    public static final int MRAID_DOWNLOADED = 10;
    public static final int MRAID_DOWNLOAD_FAILED = 12;
    public static final int MRAID_INVALID_ENDPOINT = 11;
    private static final String TAG = "MraidJsLoader";

    private MraidJsLoader() {
    }

    public final void downloadJs(PathProvider pathProvider, Downloader downloader, Function1<? super Integer, Unit> function1) {
        PathProvider pathProvider2 = pathProvider;
        Downloader downloader2 = downloader;
        Function1<? super Integer, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(pathProvider2, "pathProvider");
        Intrinsics.checkNotNullParameter(downloader2, "downloader");
        Intrinsics.checkNotNullParameter(function12, "downloadListener");
        String mraidEndpoint = ConfigManager.INSTANCE.getMraidEndpoint();
        CharSequence charSequence = mraidEndpoint;
        if (charSequence == null || charSequence.length() == 0) {
            function12.invoke(11);
            return;
        }
        File file = new File(pathProvider2.getJsAssetDir(ConfigManager.INSTANCE.getMraidJsVersion()), Constants.MRAID_JS_FILE_NAME);
        if (file.exists()) {
            function12.invoke(13);
            return;
        }
        File jsDir = pathProvider.getJsDir();
        FileUtility.deleteContents(jsDir);
        DownloadRequest.Priority priority = DownloadRequest.Priority.HIGH;
        downloader2.download(new DownloadRequest(priority, mraidEndpoint + "/mraid.min.js", file.getAbsolutePath(), (String) null, false, false, (String) null, (String) null, (String) null, 448, (DefaultConstructorMarker) null), new MraidJsLoader$downloadJs$1(jsDir, function12, file));
    }
}
