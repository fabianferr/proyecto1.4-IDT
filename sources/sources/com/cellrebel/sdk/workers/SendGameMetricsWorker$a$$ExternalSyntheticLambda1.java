package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.database.dao.GameMetricDAO;
import com.cellrebel.sdk.workers.SendGameMetricsWorker;
import java.util.List;
import java.util.concurrent.Callable;
import retrofit2.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendGameMetricsWorker$a$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ Response f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ GameMetricDAO f$2;

    public /* synthetic */ SendGameMetricsWorker$a$$ExternalSyntheticLambda1(Response response, List list, GameMetricDAO gameMetricDAO) {
        this.f$0 = response;
        this.f$1 = list;
        this.f$2 = gameMetricDAO;
    }

    public final Object call() {
        return SendGameMetricsWorker.a.a(this.f$0, this.f$1, this.f$2);
    }
}
