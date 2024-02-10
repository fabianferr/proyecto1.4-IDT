package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzadi extends zzadk {
    final /* synthetic */ zzadr zza;
    private int zzb = 0;
    private final int zzc;

    zzadi(zzadr zzadr) {
        this.zza = zzadr;
        this.zzc = zzadr.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
