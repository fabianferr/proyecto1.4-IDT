package com.cellrebel.sdk.utils;

import android.location.Location;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingHelper$$ExternalSyntheticLambda0 implements OnSuccessListener {
    public final /* synthetic */ TrackingHelper f$0;

    public /* synthetic */ TrackingHelper$$ExternalSyntheticLambda0(TrackingHelper trackingHelper) {
        this.f$0 = trackingHelper;
    }

    public final void onSuccess(Object obj) {
        this.f$0.a((Location) obj);
    }
}
