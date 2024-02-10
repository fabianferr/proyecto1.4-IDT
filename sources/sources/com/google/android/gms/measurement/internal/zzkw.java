package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzgc;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
final class zzkw {
    zzgc zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzkz zze;

    /* synthetic */ zzkw(zzkz zzkz, zzkv zzkv) {
        this.zze = zzkz;
    }

    private static final long zzb(zzfs zzfs) {
        return ((zzfs.zzd() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, zzfs zzfs) {
        Preconditions.checkNotNull(zzfs);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (!this.zzc.isEmpty() && zzb((zzfs) this.zzc.get(0)) != zzb(zzfs)) {
            return false;
        }
        long zzbw = this.zzd + ((long) zzfs.zzbw());
        this.zze.zzg();
        if (zzbw >= ((long) Math.max(0, ((Integer) zzeb.zzh.zza((Object) null)).intValue()))) {
            return false;
        }
        this.zzd = zzbw;
        this.zzc.add(zzfs);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        this.zze.zzg();
        if (size >= Math.max(1, ((Integer) zzeb.zzi.zza((Object) null)).intValue())) {
            return false;
        }
        return true;
    }
}
