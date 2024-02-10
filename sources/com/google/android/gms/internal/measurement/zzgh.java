package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzgh extends zzke implements zzlm {
    /* access modifiers changed from: private */
    public static final zzgh zza;
    /* access modifiers changed from: private */
    public zzkk zze = zzbB();
    /* access modifiers changed from: private */
    public zzkk zzf = zzbB();
    /* access modifiers changed from: private */
    public zzkl zzg = zzbD();
    /* access modifiers changed from: private */
    public zzkl zzh = zzbD();

    static {
        zzgh zzgh = new zzgh();
        zza = zzgh;
        zzke.zzbJ(zzgh.class, zzgh);
    }

    private zzgh() {
    }

    public static zzgg zzf() {
        return (zzgg) zza.zzbx();
    }

    public static zzgh zzh() {
        return zza;
    }

    static /* synthetic */ void zzo(zzgh zzgh, Iterable iterable) {
        zzkk zzkk = zzgh.zze;
        if (!zzkk.zzc()) {
            zzgh.zze = zzke.zzbC(zzkk);
        }
        zzin.zzbt(iterable, zzgh.zze);
    }

    static /* synthetic */ void zzq(zzgh zzgh, Iterable iterable) {
        zzkk zzkk = zzgh.zzf;
        if (!zzkk.zzc()) {
            zzgh.zzf = zzke.zzbC(zzkk);
        }
        zzin.zzbt(iterable, zzgh.zzf);
    }

    static /* synthetic */ void zzs(zzgh zzgh, Iterable iterable) {
        zzgh.zzy();
        zzin.zzbt(iterable, zzgh.zzg);
    }

    static /* synthetic */ void zzu(zzgh zzgh, int i) {
        zzgh.zzy();
        zzgh.zzg.remove(i);
    }

    static /* synthetic */ void zzv(zzgh zzgh, Iterable iterable) {
        zzgh.zzz();
        zzin.zzbt(iterable, zzgh.zzh);
    }

    static /* synthetic */ void zzx(zzgh zzgh, int i) {
        zzgh.zzz();
        zzgh.zzh.remove(i);
    }

    private final void zzy() {
        zzkl zzkl = this.zzg;
        if (!zzkl.zzc()) {
            this.zzg = zzke.zzbE(zzkl);
        }
    }

    private final void zzz() {
        zzkl zzkl = this.zzh;
        if (!zzkl.zzc()) {
            this.zzh = zzke.zzbE(zzkl);
        }
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfq zze(int i) {
        return (zzfq) this.zzg.get(i);
    }

    public final zzgj zzi(int i) {
        return (zzgj) this.zzh.get(i);
    }

    public final List zzj() {
        return this.zzg;
    }

    public final List zzk() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbI(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzfq.class, "zzh", zzgj.class});
        } else if (i2 == 3) {
            return new zzgh();
        } else {
            if (i2 == 4) {
                return new zzgg((zzfj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final List zzm() {
        return this.zzh;
    }

    public final List zzn() {
        return this.zze;
    }
}
