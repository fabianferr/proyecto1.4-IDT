package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.database.dao.GameMetricDAO;
import com.cellrebel.sdk.workers.SendGameMetricsWorker;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendGameMetricsWorker$a$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ GameMetricDAO f$1;

    public /* synthetic */ SendGameMetricsWorker$a$$ExternalSyntheticLambda0(List list, GameMetricDAO gameMetricDAO) {
        this.f$0 = list;
        this.f$1 = gameMetricDAO;
    }

    public final Object call() {
        return SendGameMetricsWorker.a.a(this.f$0, this.f$1);
    }
}
