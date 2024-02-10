package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzo implements Cast.ApplicationConnectionResult {
    final /* synthetic */ Status zza;

    zzo(zzp zzp, Status status) {
        this.zza = status;
    }

    public final ApplicationMetadata getApplicationMetadata() {
        return null;
    }

    public final String getApplicationStatus() {
        return null;
    }

    public final String getSessionId() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public final boolean getWasLaunched() {
        return false;
    }
}
