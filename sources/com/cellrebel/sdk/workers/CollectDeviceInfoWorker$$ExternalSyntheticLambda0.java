package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.networking.beans.request.DeviceInfoMetric;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectDeviceInfoWorker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DeviceInfoMetric f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ CollectDeviceInfoWorker$$ExternalSyntheticLambda0(DeviceInfoMetric deviceInfoMetric, Context context) {
        this.f$0 = deviceInfoMetric;
        this.f$1 = context;
    }

    public final void run() {
        CollectDeviceInfoWorker.a(this.f$0, this.f$1);
    }
}
