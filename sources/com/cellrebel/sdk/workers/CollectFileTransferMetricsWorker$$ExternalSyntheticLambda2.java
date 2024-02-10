package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.networking.RequestEventListener;
import com.cellrebel.sdk.networking.beans.request.FileTransferMetric;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectFileTransferMetricsWorker$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ CollectFileTransferMetricsWorker f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ RequestEventListener f$2;
    public final /* synthetic */ FileTransferMetric f$3;
    public final /* synthetic */ Context f$4;

    public /* synthetic */ CollectFileTransferMetricsWorker$$ExternalSyntheticLambda2(CollectFileTransferMetricsWorker collectFileTransferMetricsWorker, int i, RequestEventListener requestEventListener, FileTransferMetric fileTransferMetric, Context context) {
        this.f$0 = collectFileTransferMetricsWorker;
        this.f$1 = i;
        this.f$2 = requestEventListener;
        this.f$3 = fileTransferMetric;
        this.f$4 = context;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
