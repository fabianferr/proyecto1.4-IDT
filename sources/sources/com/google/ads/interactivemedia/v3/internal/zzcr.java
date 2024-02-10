package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzcr {
    private final zzbz zza;
    private final ArrayList zzb;

    public zzcr(zzbz zzbz, String str) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = zzbz;
        arrayList.add(str);
    }

    public final zzbz zza() {
        return this.zza;
    }

    public final ArrayList zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        this.zzb.add(str);
    }
}
