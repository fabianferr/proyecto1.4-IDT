package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzi extends zzp {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzi(zzm zzm, GoogleApiClient googleApiClient, String str, String str2, zzbu zzbu) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) throws RemoteException {
        try {
            zzw.zzL(this.zza, this.zzb, (zzbu) null, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
