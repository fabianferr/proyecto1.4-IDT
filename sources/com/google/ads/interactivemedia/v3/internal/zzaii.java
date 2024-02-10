package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaii {
    private final Object zza;
    private final int zzb;

    zzaii(Object obj) {
        this.zzb = System.identityHashCode(obj);
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaii)) {
            return false;
        }
        zzaii zzaii = (zzaii) obj;
        if (this.zzb == zzaii.zzb && this.zza == zzaii.zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb;
    }
}
