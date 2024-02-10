package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaal<T> extends zzaah<T> {
    final zzwm zza;
    private final zzwy zzb;
    private final zzwq zzc;
    private final zzact zzd;
    private final zzxj zze;
    private final zzaaj zzf = new zzaaj(this, (zzaai) null);
    private final boolean zzg;
    private volatile zzxi zzh;

    public zzaal(zzwy zzwy, zzwq zzwq, zzwm zzwm, zzact zzact, zzxj zzxj, boolean z) {
        this.zzb = zzwy;
        this.zzc = zzwq;
        this.zza = zzwm;
        this.zzd = zzact;
        this.zze = zzxj;
        this.zzg = z;
    }

    public static zzxj zzb(zzact zzact, Object obj) {
        return new zzaak(obj, zzact, zzact.zzd() == zzact.zzc(), (Class) null);
    }

    private final zzxi zzc() {
        zzxi zzxi = this.zzh;
        if (zzxi != null) {
            return zzxi;
        }
        zzxi zzb2 = this.zza.zzb(this.zze, this.zzd);
        this.zzh = zzb2;
        return zzb2;
    }

    public final T read(zzacv zzacv) throws IOException {
        if (this.zzc == null) {
            return zzc().read(zzacv);
        }
        zzwr zza2 = zzzf.zza(zzacv);
        if (this.zzg && (zza2 instanceof zzwt)) {
            return null;
        }
        zzwq zzwq = this.zzc;
        this.zzd.zzd();
        return zzwq.zza();
    }

    public final void write(zzacx zzacx, T t) throws IOException {
        zzwy zzwy = this.zzb;
        if (zzwy == null) {
            zzc().write(zzacx, t);
        } else if (!this.zzg || t != null) {
            ((zzabg) zzaby.zzV).write(zzacx, zzwy.zza(t, this.zzd.zzd(), this.zzf));
        } else {
            zzacx.zzf();
        }
    }

    public final zzxi zza() {
        return this.zzb != null ? this : zzc();
    }
}
