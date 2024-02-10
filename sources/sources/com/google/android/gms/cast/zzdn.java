package com.google.android.gms.cast;

import android.util.Log;
import com.google.android.gms.cast.internal.zzap;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzdn implements zzat {
    final /* synthetic */ zzdp zza;

    zzdn(zzdp zzdp) {
        this.zza = zzdp;
    }

    public final void zza(long j, int i, Object obj) {
        JSONObject jSONObject = null;
        if (true != (obj instanceof zzap)) {
            obj = null;
        }
        try {
            zzdp zzdp = this.zza;
            Status status = new Status(i);
            if (obj != null) {
                jSONObject = ((zzap) obj).zza;
            }
            zzdp.setResult(new zzdq(status, jSONObject));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestCompleted", e);
        }
    }

    public final void zzb(long j) {
        try {
            zzdp zzdp = this.zza;
            zzdp.setResult(new zzdo(zzdp, new Status(2103)));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestReplaced", e);
        }
    }
}
