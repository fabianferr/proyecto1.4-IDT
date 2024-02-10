package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzo implements ResultCallback {
    public final /* synthetic */ MediaQueue zza;

    public /* synthetic */ zzo(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    public final void onResult(Result result) {
        this.zza.zzm((RemoteMediaClient.MediaChannelResult) result);
    }
}
