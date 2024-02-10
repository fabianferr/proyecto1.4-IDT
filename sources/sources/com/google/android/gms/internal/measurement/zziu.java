package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zziu extends zziw {
    final /* synthetic */ zzjd zza;
    private int zzb = 0;
    private final int zzc;

    zziu(zzjd zzjd) {
        this.zza = zzjd;
        this.zzc = zzjd.zzd();
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
