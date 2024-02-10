package com.vungle.ads.internal.downloader;

import com.vungle.ads.internal.task.PriorityRunnable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"com/vungle/ads/internal/downloader/AssetDownloader$download$1", "Lcom/vungle/ads/internal/task/PriorityRunnable;", "priority", "", "getPriority", "()I", "run", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AssetDownloader.kt */
public final class AssetDownloader$download$1 extends PriorityRunnable {
    final /* synthetic */ AssetDownloadListener $downloadListener;
    final /* synthetic */ DownloadRequest $downloadRequest;
    final /* synthetic */ AssetDownloader this$0;

    AssetDownloader$download$1(AssetDownloader assetDownloader, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        this.this$0 = assetDownloader;
        this.$downloadRequest = downloadRequest;
        this.$downloadListener = assetDownloadListener;
    }

    public void run() {
        this.this$0.launchRequest(this.$downloadRequest, this.$downloadListener);
    }

    public int getPriority() {
        return this.$downloadRequest.getPriority();
    }
}
