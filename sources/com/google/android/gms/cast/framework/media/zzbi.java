package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.internal.zzap;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzbi implements zzat {
    final /* synthetic */ zzbk zza;

    zzbi(zzbk zzbk) {
        this.zza = zzbk;
    }

    public final void zza(long j, int i, Object obj) {
        MediaError mediaError = null;
        if (true != (obj instanceof zzap)) {
            obj = null;
        }
        try {
            zzbk zzbk = this.zza;
            Status status = new Status(i);
            JSONObject jSONObject = obj != null ? ((zzap) obj).zza : null;
            if (obj != null) {
                mediaError = ((zzap) obj).zzb;
            }
            zzbk.setResult(new zzbl(status, jSONObject, mediaError));
        } catch (IllegalStateException e) {
            RemoteMediaClient.zzb.e(e, "Result already set when calling onRequestCompleted", new Object[0]);
        }
    }

    public final void zzb(long j) {
        try {
            zzbk zzbk = this.zza;
            zzbk.setResult(new zzbj(zzbk, new Status(2103)));
        } catch (IllegalStateException e) {
            RemoteMediaClient.zzb.e(e, "Result already set when calling onRequestReplaced", new Object[0]);
        }
    }
}
