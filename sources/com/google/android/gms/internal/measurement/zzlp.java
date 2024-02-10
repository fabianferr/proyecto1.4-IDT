package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzlp implements zzlw {
    private final zzll zza;
    private final zzmn zzb;
    private final boolean zzc;
    private final zzjr zzd;

    private zzlp(zzmn zzmn, zzjr zzjr, zzll zzll) {
        this.zzb = zzmn;
        this.zzc = zzjr.zzc(zzll);
        this.zzd = zzjr;
        this.zza = zzll;
    }

    static zzlp zzc(zzmn zzmn, zzjr zzjr, zzll zzll) {
        return new zzlp(zzmn, zzjr, zzll);
    }

    public final int zza(Object obj) {
        zzmn zzmn = this.zzb;
        int zzb2 = zzmn.zzb(zzmn.zzc(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        return this.zza.zzbF().zzaG();
    }

    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzly.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzly.zzE(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zziq zziq) throws IOException {
        zzke zzke = (zzke) obj;
        if (zzke.zzc == zzmo.zzc()) {
            zzke.zzc = zzmo.zze();
        }
        zzkb zzkb = (zzkb) obj;
        throw null;
    }

    public final void zzi(Object obj, zznf zznf) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
