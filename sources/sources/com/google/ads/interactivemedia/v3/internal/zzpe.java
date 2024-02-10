package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzpe extends zzpa {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzpe(String str, boolean z, boolean z2, zzpd zzpd) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpa) {
            zzpa zzpa = (zzpa) obj;
            return this.zza.equals(zzpa.zzb()) && this.zzb == zzpa.zzd() && this.zzc == zzpa.zzc();
        }
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() ^ 1000003;
        int i = 1237;
        int i2 = true != this.zzb ? 1237 : 1231;
        if (true == this.zzc) {
            i = 1231;
        }
        return (((hashCode * 1000003) ^ i2) * 1000003) ^ i;
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return "AdShield2Options{clientVersion=" + str + ", shouldGetAdvertisingId=" + z + ", isGooglePlayServicesAvailable=" + z2 + "}";
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
