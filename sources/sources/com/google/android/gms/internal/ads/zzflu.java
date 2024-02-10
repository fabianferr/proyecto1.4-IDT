package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzflu implements Runnable {
    final /* synthetic */ zzflv zza;
    private final WebView zzb;

    zzflu(zzflv zzflv) {
        this.zza = zzflv;
        this.zzb = zzflv.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
