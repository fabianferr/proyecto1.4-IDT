package com.cellrebel.sdk.workers;

import android.os.Handler;
import com.cellrebel.sdk.workers.SentDeviceInfoWorker;
import java.util.List;
import java.util.concurrent.Callable;
import retrofit2.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentDeviceInfoWorker$a$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ SentDeviceInfoWorker.a f$0;
    public final /* synthetic */ Handler f$1;
    public final /* synthetic */ Response f$2;
    public final /* synthetic */ List f$3;

    public /* synthetic */ SentDeviceInfoWorker$a$$ExternalSyntheticLambda0(SentDeviceInfoWorker.a aVar, Handler handler, Response response, List list) {
        this.f$0 = aVar;
        this.f$1 = handler;
        this.f$2 = response;
        this.f$3 = list;
    }

    public final Object call() {
        return this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
