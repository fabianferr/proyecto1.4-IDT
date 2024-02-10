package com.google.android.gms.cast.framework.media.internal;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzu extends RemoteMediaClient.Callback {
    final /* synthetic */ zzv zza;

    /* synthetic */ zzu(zzv zzv, zzt zzt) {
        this.zza = zzv;
    }

    public final void onAdBreakStatusUpdated() {
        this.zza.zzl(false);
    }

    public final void onMetadataUpdated() {
        this.zza.zzl(false);
    }

    public final void onPreloadStatusUpdated() {
        this.zza.zzl(false);
    }

    public final void onQueueStatusUpdated() {
        this.zza.zzl(false);
    }

    public final void onStatusUpdated() {
        this.zza.zzl(false);
    }
}
