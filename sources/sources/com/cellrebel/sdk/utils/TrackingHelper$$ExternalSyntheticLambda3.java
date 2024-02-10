package com.cellrebel.sdk.utils;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingHelper$$ExternalSyntheticLambda3 implements OnFailureListener {
    public final /* synthetic */ TrackingHelper f$0;
    public final /* synthetic */ LocationCallback f$1;

    public /* synthetic */ TrackingHelper$$ExternalSyntheticLambda3(TrackingHelper trackingHelper, LocationCallback locationCallback) {
        this.f$0 = trackingHelper;
        this.f$1 = locationCallback;
    }

    public final void onFailure(Exception exc) {
        this.f$0.b(this.f$1, exc);
    }
}
