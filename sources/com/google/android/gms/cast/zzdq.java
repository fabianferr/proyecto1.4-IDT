package com.google.android.gms.cast;

import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzdq implements RemoteMediaPlayer.MediaChannelResult {
    private final Status zza;
    private final JSONObject zzb;

    zzdq(Status status, JSONObject jSONObject) {
        this.zza = status;
        this.zzb = jSONObject;
    }

    public final JSONObject getCustomData() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
