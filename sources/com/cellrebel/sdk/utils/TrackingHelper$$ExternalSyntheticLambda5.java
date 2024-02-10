package com.cellrebel.sdk.utils;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingHelper$$ExternalSyntheticLambda5 implements OnFailureListener {
    public final /* synthetic */ LocationCallback f$0;

    public /* synthetic */ TrackingHelper$$ExternalSyntheticLambda5(LocationCallback locationCallback) {
        this.f$0 = locationCallback;
    }

    public final void onFailure(Exception exc) {
        TrackingHelper.a(this.f$0, exc);
    }
}
