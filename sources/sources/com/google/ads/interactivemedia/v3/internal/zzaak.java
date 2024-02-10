package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaak implements zzxj {
    private final zzact zza;
    private final boolean zzb;
    private final zzwy zzc;
    private final zzwq zzd;

    zzaak(Object obj, zzact zzact, boolean z, Class cls) {
        zzwq zzwq = null;
        zzwy zzwy = obj instanceof zzwy ? (zzwy) obj : null;
        this.zzc = zzwy;
        zzwq = obj instanceof zzwq ? (zzwq) obj : zzwq;
        this.zzd = zzwq;
        boolean z2 = true;
        if (zzwy == null && zzwq == null) {
            z2 = false;
        }
        zzxm.zza(z2);
        this.zza = zzact;
        this.zzb = z;
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        if (this.zza.equals(zzact) || (this.zzb && this.zza.zzd() == zzact.zzc())) {
            return new zzaal(this.zzc, this.zzd, zzwm, zzact, this, true);
        }
        return null;
    }
}
