package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzdm implements zzar {
    final /* synthetic */ RemoteMediaPlayer zza;
    private GoogleApiClient zzb;
    private long zzc = 0;

    public zzdm(RemoteMediaPlayer remoteMediaPlayer) {
        this.zza = remoteMediaPlayer;
    }

    public final long zza() {
        long j = this.zzc + 1;
        this.zzc = j;
        return j;
    }

    public final void zzb(String str, String str2, long j, String str3) {
        if (this.zzb != null) {
            Cast.CastApi.sendMessage(this.zzb, str, str2).setResultCallback(new zzdl(this, j));
            return;
        }
        throw new IllegalStateException("No GoogleApiClient available");
    }

    public final void zzc(GoogleApiClient googleApiClient) {
        this.zzb = googleApiClient;
    }
}
