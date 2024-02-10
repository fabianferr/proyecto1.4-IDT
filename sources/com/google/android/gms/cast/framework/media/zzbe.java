package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzbe implements OnFailureListener {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzbe(zzbf zzbf, long j) {
        this.zza = zzbf;
        this.zzb = j;
    }

    public final void onFailure(Exception exc) {
        this.zza.zza.zze.zzP(this.zzb, exc instanceof ApiException ? ((ApiException) exc).getStatusCode() : 13);
    }
}
