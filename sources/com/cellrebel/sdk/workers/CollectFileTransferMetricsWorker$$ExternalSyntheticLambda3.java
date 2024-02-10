package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.networking.beans.request.FileTransferMetric;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectFileTransferMetricsWorker$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ CollectFileTransferMetricsWorker f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ FileTransferMetric f$2;

    public /* synthetic */ CollectFileTransferMetricsWorker$$ExternalSyntheticLambda3(CollectFileTransferMetricsWorker collectFileTransferMetricsWorker, int i, FileTransferMetric fileTransferMetric) {
        this.f$0 = collectFileTransferMetricsWorker;
        this.f$1 = i;
        this.f$2 = fileTransferMetric;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2);
    }
}
