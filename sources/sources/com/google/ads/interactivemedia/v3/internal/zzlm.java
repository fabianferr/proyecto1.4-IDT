package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzlm implements Callable {
    private final zzkt zza;
    private final zzaf zzb;

    public zzlm(zzkt zzkt, zzaf zzaf) {
        this.zza = zzkt;
        this.zzb = zzaf;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzbc zzc = this.zza.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                zzaf zzaf = this.zzb;
                byte[] zzav = zzc.zzav();
                zzaf.zzaj(zzav, 0, zzav.length, zzaef.zza());
            }
            return null;
        } catch (zzafc | NullPointerException unused) {
            return null;
        }
    }
}
