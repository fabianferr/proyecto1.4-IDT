package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzaw extends zzbk {
    final /* synthetic */ String zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaw(RemoteMediaClient remoteMediaClient, boolean z, String str, List list) {
        super(remoteMediaClient, true);
        this.zzb = remoteMediaClient;
        this.zza = str;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzb.zze.zzs(this.zza, (List) null);
    }
}
