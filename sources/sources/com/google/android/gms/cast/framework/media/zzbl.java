package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzbl implements RemoteMediaClient.MediaChannelResult {
    private final Status zza;
    private final JSONObject zzb;
    private final MediaError zzc;

    zzbl(Status status, JSONObject jSONObject, MediaError mediaError) {
        this.zza = status;
        this.zzb = jSONObject;
        this.zzc = mediaError;
    }

    public final JSONObject getCustomData() {
        return this.zzb;
    }

    public final MediaError getMediaError() {
        return this.zzc;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
