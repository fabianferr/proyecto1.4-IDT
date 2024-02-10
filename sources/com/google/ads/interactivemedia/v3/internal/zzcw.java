package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzcw implements Runnable {
    zzcw() {
    }

    public final void run() {
        if (zzcz.zzc != null) {
            zzcz.zzc.post(zzcz.zzd);
            zzcz.zzc.postDelayed(zzcz.zze, 200);
        }
    }
}
