package com.cellrebel.sdk.workers;

import android.os.Handler;
import com.cellrebel.sdk.database.dao.DataUsageMetricDAO;
import com.cellrebel.sdk.workers.SendDataUsageMetricsWorker;
import java.util.List;
import java.util.concurrent.Callable;
import retrofit2.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendDataUsageMetricsWorker$b$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ SendDataUsageMetricsWorker.b f$0;
    public final /* synthetic */ Handler f$1;
    public final /* synthetic */ Response f$2;
    public final /* synthetic */ DataUsageMetricDAO f$3;
    public final /* synthetic */ List f$4;

    public /* synthetic */ SendDataUsageMetricsWorker$b$$ExternalSyntheticLambda1(SendDataUsageMetricsWorker.b bVar, Handler handler, Response response, DataUsageMetricDAO dataUsageMetricDAO, List list) {
        this.f$0 = bVar;
        this.f$1 = handler;
        this.f$2 = response;
        this.f$3 = dataUsageMetricDAO;
        this.f$4 = list;
    }

    public final Object call() {
        return this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
