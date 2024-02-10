package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagl extends zzadk {
    final zzagp zza;
    zzadm zzb = zzb();
    final /* synthetic */ zzagr zzc;

    zzagl(zzagr zzagr) {
        this.zzc = zzagr;
        this.zza = new zzagp(zzagr, (zzago) null);
    }

    private final zzadm zzb() {
        zzagp zzagp = this.zza;
        if (zzagp.hasNext()) {
            return zzagp.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzadm zzadm = this.zzb;
        if (zzadm != null) {
            byte zza2 = zzadm.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
