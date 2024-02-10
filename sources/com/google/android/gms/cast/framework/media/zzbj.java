package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzbj implements RemoteMediaClient.MediaChannelResult {
    final /* synthetic */ Status zza;

    zzbj(zzbk zzbk, Status status) {
        this.zza = status;
    }

    public final JSONObject getCustomData() {
        return null;
    }

    public final MediaError getMediaError() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
