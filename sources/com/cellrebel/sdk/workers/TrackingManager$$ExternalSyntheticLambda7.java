package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.workers.TrackingManager;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingManager$$ExternalSyntheticLambda7 implements Callable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ TrackingManager.OnCompleteListener f$1;

    public /* synthetic */ TrackingManager$$ExternalSyntheticLambda7(Context context, TrackingManager.OnCompleteListener onCompleteListener) {
        this.f$0 = context;
        this.f$1 = onCompleteListener;
    }

    public final Object call() {
        return TrackingManager.b(this.f$0, this.f$1);
    }
}
