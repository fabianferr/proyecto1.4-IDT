package com.vungle.ads.internal.load;

import com.vungle.ads.internal.downloader.DownloadRequest;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseAdLoader$assetDownloadListener$1$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ BaseAdLoader$assetDownloadListener$1 f$1;
    public final /* synthetic */ DownloadRequest f$2;
    public final /* synthetic */ BaseAdLoader f$3;

    public /* synthetic */ BaseAdLoader$assetDownloadListener$1$$ExternalSyntheticLambda1(File file, BaseAdLoader$assetDownloadListener$1 baseAdLoader$assetDownloadListener$1, DownloadRequest downloadRequest, BaseAdLoader baseAdLoader) {
        this.f$0 = file;
        this.f$1 = baseAdLoader$assetDownloadListener$1;
        this.f$2 = downloadRequest;
        this.f$3 = baseAdLoader;
    }

    public final void run() {
        BaseAdLoader$assetDownloadListener$1.m2298onSuccess$lambda2(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
