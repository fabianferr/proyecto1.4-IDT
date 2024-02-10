package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzuz extends zzva {
    zzuz(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzvb.zzb) {
            zzvb.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzvb.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j, byte b) {
        if (zzvb.zzb) {
            zzvb.zzD(obj, j, b);
        } else {
            zzvb.zzE(obj, j, b);
        }
    }

    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzg(Object obj, long j) {
        if (zzvb.zzb) {
            return zzvb.zzt(obj, j);
        }
        return zzvb.zzu(obj, j);
    }
}
