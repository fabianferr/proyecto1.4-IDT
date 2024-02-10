package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzrd extends zzrf {
    final /* synthetic */ zzrm zza;
    private int zzb = 0;
    private final int zzc;

    zzrd(zzrm zzrm) {
        this.zza = zzrm;
        this.zzc = zzrm.zzd();
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
