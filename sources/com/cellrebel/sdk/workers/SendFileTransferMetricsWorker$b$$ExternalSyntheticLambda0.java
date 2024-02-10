package com.cellrebel.sdk.workers;

import android.os.Handler;
import com.cellrebel.sdk.database.dao.FileTransferMetricDAO;
import com.cellrebel.sdk.workers.SendFileTransferMetricsWorker;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendFileTransferMetricsWorker$b$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ SendFileTransferMetricsWorker.b f$0;
    public final /* synthetic */ Handler f$1;
    public final /* synthetic */ Throwable f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ FileTransferMetricDAO f$4;

    public /* synthetic */ SendFileTransferMetricsWorker$b$$ExternalSyntheticLambda0(SendFileTransferMetricsWorker.b bVar, Handler handler, Throwable th, List list, FileTransferMetricDAO fileTransferMetricDAO) {
        this.f$0 = bVar;
        this.f$1 = handler;
        this.f$2 = th;
        this.f$3 = list;
        this.f$4 = fileTransferMetricDAO;
    }

    public final Object call() {
        return this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
