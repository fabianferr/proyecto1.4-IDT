package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.impl.data.zzbj;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzfw implements zzuz {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgc zzb;

    zzfw(zzgc zzgc, String str) {
        this.zzb = zzgc;
        this.zza = str;
    }

    public final void zza(Throwable th) {
        zzhd.zzb("Failure to make Native-layer network request", th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzb.zzp(new zzff(zzfd.nativeXhr, zzfe.nativeResponse, this.zza, (zzbj) obj));
    }
}
