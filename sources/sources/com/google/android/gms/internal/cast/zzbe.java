package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouteSelector;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzbe implements Runnable {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ MediaRouteSelector zzb;

    public /* synthetic */ zzbe(zzbf zzbf, MediaRouteSelector mediaRouteSelector) {
        this.zza = zzbf;
        this.zzb = mediaRouteSelector;
    }

    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
