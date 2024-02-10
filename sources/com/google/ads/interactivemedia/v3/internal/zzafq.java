package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzafq implements zzafx {
    private final zzafx[] zza;

    zzafq(zzafx... zzafxArr) {
        this.zza = zzafxArr;
    }

    public final zzafw zzb(Class cls) {
        zzafx[] zzafxArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzafx zzafx = zzafxArr[i];
            if (zzafx.zzc(cls)) {
                return zzafx.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        zzafx[] zzafxArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzafxArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
