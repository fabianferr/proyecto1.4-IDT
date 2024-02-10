package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzcl implements Runnable {
    final /* synthetic */ zzcm zza;
    private final WebView zzb;

    zzcl(zzcm zzcm) {
        this.zza = zzcm;
        this.zzb = zzcm.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
