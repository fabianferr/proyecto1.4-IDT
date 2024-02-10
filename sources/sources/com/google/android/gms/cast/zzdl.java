package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzdl implements ResultCallback {
    final /* synthetic */ zzdm zza;
    private final long zzb;

    zzdl(zzdm zzdm, long j) {
        this.zza = zzdm;
        this.zzb = j;
    }

    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        if (!status.isSuccess()) {
            this.zza.zza.zzb.zzP(this.zzb, status.getStatusCode());
        }
    }
}
