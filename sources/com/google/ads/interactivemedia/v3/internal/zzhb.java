package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.impl.data.zzbe;
import com.google.ads.interactivemedia.v3.impl.data.zzbf;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final /* synthetic */ class zzhb implements Runnable {
    public final /* synthetic */ zzhc zza;
    public final /* synthetic */ zzvq zzb;
    public final /* synthetic */ zzbe zzc;
    public final /* synthetic */ zzbf zzd;

    public /* synthetic */ zzhb(zzhc zzhc, zzvq zzvq, zzbe zzbe, zzbf zzbf) {
        this.zza = zzhc;
        this.zzb = zzvq;
        this.zzc = zzbe;
        this.zzd = zzbf;
    }

    public final void run() {
        zzhc zzhc = this.zza;
        zzvq zzvq = this.zzb;
        zzbe zzbe = this.zzc;
        zzbf zzbf = this.zzd;
        try {
            zzvd.zzb(zzvq, Exception.class);
        } catch (Exception e) {
            String valueOf = String.valueOf(zzbe);
            String valueOf2 = String.valueOf(zzbf);
            zzhd.zzb("Exception in " + valueOf + "." + valueOf2, e);
            zzhc.zzb(zzbe, zzbf, e);
        }
    }
}
