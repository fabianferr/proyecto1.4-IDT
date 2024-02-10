package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.networking.beans.request.AuthRequestModel;
import com.cellrebel.sdk.workers.TrackingManager;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingManager$$ExternalSyntheticLambda5 implements Callable {
    public final /* synthetic */ AuthRequestModel f$0;
    public final /* synthetic */ TrackingManager.OnCompleteListener f$1;
    public final /* synthetic */ Context f$2;

    public /* synthetic */ TrackingManager$$ExternalSyntheticLambda5(AuthRequestModel authRequestModel, TrackingManager.OnCompleteListener onCompleteListener, Context context) {
        this.f$0 = authRequestModel;
        this.f$1 = onCompleteListener;
        this.f$2 = context;
    }

    public final Object call() {
        return TrackingManager.a(this.f$0, this.f$1, this.f$2);
    }
}
