package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zztb extends zztd {
    private zztb() {
        super((zztc) null);
    }

    /* synthetic */ zztb(zzta zzta) {
        super((zztc) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        ((zzsp) zzvb.zzf(obj, j)).zzb();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, Object obj2, long j) {
        zzsp zzsp = (zzsp) zzvb.zzf(obj, j);
        zzsp zzsp2 = (zzsp) zzvb.zzf(obj2, j);
        int size = zzsp.size();
        int size2 = zzsp2.size();
        if (size > 0 && size2 > 0) {
            if (!zzsp.zzc()) {
                zzsp = zzsp.zzg(size2 + size);
            }
            zzsp.addAll(zzsp2);
        }
        if (size > 0) {
            zzsp2 = zzsp;
        }
        zzvb.zzs(obj, j, zzsp2);
    }
}
