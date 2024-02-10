package com.vungle.ads.internal.load;

import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DownloadRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseAdLoader$assetDownloadListener$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DownloadRequest f$0;
    public final /* synthetic */ BaseAdLoader f$1;
    public final /* synthetic */ AssetDownloadListener.DownloadError f$2;

    public /* synthetic */ BaseAdLoader$assetDownloadListener$1$$ExternalSyntheticLambda0(DownloadRequest downloadRequest, BaseAdLoader baseAdLoader, AssetDownloadListener.DownloadError downloadError) {
        this.f$0 = downloadRequest;
        this.f$1 = baseAdLoader;
        this.f$2 = downloadError;
    }

    public final void run() {
        BaseAdLoader$assetDownloadListener$1.m2297onError$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
