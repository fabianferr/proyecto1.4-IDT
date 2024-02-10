package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzko extends zzhz {
    public Long zza;
    public Long zzb;

    public zzko() {
    }

    /* access modifiers changed from: protected */
    public final HashMap zzb() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        return hashMap;
    }

    public zzko(String str) {
        HashMap zza2 = zza(str);
        if (zza2 != null) {
            this.zza = (Long) zza2.get(0);
            this.zzb = (Long) zza2.get(1);
        }
    }
}
