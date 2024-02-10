package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzau extends zzbk {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(RemoteMediaClient remoteMediaClient, boolean z, int i, int i2, int i3) {
        super(remoteMediaClient, true);
        this.zzd = remoteMediaClient;
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzd.zze.zzt(zzb(), this.zza, this.zzb, this.zzc);
    }
}
