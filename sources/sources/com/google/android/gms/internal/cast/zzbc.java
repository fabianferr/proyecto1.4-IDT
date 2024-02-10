package com.google.android.gms.internal.cast;

import androidx.mediarouter.media.MediaRouteSelector;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzbc implements Runnable {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ MediaRouteSelector zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzbc(zzbf zzbf, MediaRouteSelector mediaRouteSelector, int i) {
        this.zza = zzbf;
        this.zzb = mediaRouteSelector;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
