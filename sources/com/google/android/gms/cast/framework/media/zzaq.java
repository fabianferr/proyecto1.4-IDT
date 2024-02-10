package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzaq extends zzbk {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaq(RemoteMediaClient remoteMediaClient, int i, long j, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = i;
        this.zzb = j;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzd.zze.zzA(zzb(), this.zza, this.zzb, (MediaQueueItem[]) null, 0, (Boolean) null, (Integer) null, this.zzc);
    }
}
