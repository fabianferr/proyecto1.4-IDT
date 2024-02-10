package com.vungle.ads.internal.downloader;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AssetDownloader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AssetDownloader f$0;
    public final /* synthetic */ DownloadRequest f$1;
    public final /* synthetic */ AssetDownloadListener f$2;

    public /* synthetic */ AssetDownloader$$ExternalSyntheticLambda0(AssetDownloader assetDownloader, DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        this.f$0 = assetDownloader;
        this.f$1 = downloadRequest;
        this.f$2 = assetDownloadListener;
    }

    public final void run() {
        AssetDownloader.m2295download$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
