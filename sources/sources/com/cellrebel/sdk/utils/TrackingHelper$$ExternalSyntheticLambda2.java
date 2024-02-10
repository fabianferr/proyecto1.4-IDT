package com.cellrebel.sdk.utils;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingHelper$$ExternalSyntheticLambda2 implements OnSuccessListener {
    public final /* synthetic */ TrackingHelper f$0;
    public final /* synthetic */ LocationCallback f$1;
    public final /* synthetic */ LocationRequest f$2;

    public /* synthetic */ TrackingHelper$$ExternalSyntheticLambda2(TrackingHelper trackingHelper, LocationCallback locationCallback, LocationRequest locationRequest) {
        this.f$0 = trackingHelper;
        this.f$1 = locationCallback;
        this.f$2 = locationRequest;
    }

    public final void onSuccess(Object obj) {
        this.f$0.a(this.f$1, this.f$2, (LocationSettingsResponse) obj);
    }
}
