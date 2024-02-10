package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzym extends zzxi {
    final /* synthetic */ boolean zza;
    final /* synthetic */ boolean zzb = true;
    final /* synthetic */ zzwm zzc;
    final /* synthetic */ zzact zzd;
    final /* synthetic */ zzyn zze;
    private zzxi zzf;

    zzym(zzyn zzyn, boolean z, boolean z2, zzwm zzwm, zzact zzact) {
        this.zze = zzyn;
        this.zza = z;
        this.zzc = zzwm;
        this.zzd = zzact;
    }

    private final zzxi zza() {
        zzxi zzxi = this.zzf;
        if (zzxi != null) {
            return zzxi;
        }
        zzxi zzb2 = this.zzc.zzb(this.zze, this.zzd);
        this.zzf = zzb2;
        return zzb2;
    }

    public final Object read(zzacv zzacv) throws IOException {
        if (!this.zza) {
            return zza().read(zzacv);
        }
        zzacv.zzp();
        return null;
    }

    public final void write(zzacx zzacx, Object obj) throws IOException {
        zzacx.zzf();
    }
}
