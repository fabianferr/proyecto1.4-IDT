package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzkq {
    private final zzaa zza;
    private final SparseArray zzb;

    public zzkq(zzaa zzaa, SparseArray sparseArray) {
        this.zza = zzaa;
        SparseArray sparseArray2 = new SparseArray(zzaa.zzb());
        for (int i = 0; i < zzaa.zzb(); i++) {
            int zza2 = zzaa.zza(i);
            zzkp zzkp = (zzkp) sparseArray.get(zza2);
            zzkp.getClass();
            sparseArray2.append(zza2, zzkp);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzkp zzc(int i) {
        zzkp zzkp = (zzkp) this.zzb.get(i);
        zzkp.getClass();
        return zzkp;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}
