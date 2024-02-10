package com.google.ads.interactivemedia.v3.internal;

import sun.misc.Unsafe;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzahq extends zzahs {
    zzahq(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzaht.zzb) {
            zzaht.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzaht.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j, byte b) {
        if (zzaht.zzb) {
            zzaht.zzD(obj, j, b);
        } else {
            zzaht.zzE(obj, j, b);
        }
    }

    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzg(Object obj, long j) {
        if (zzaht.zzb) {
            return zzaht.zzt(obj, j);
        }
        return zzaht.zzu(obj, j);
    }
}
