package com.google.android.gms.cast.framework.media.widget;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzb {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzb(int i, int i2, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzb) && this.zza == ((zzb) obj).zza;
    }

    public final int hashCode() {
        return Integer.valueOf(this.zza).hashCode();
    }
}
