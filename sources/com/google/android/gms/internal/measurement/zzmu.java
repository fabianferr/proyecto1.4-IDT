package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzmu extends zzmw {
    zzmu(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzk(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzmx.zzb) {
            zzmx.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzmx.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j, byte b) {
        if (zzmx.zzb) {
            zzmx.zzD(obj, j, b);
        } else {
            zzmx.zzE(obj, j, b);
        }
    }

    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzf(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzg(Object obj, long j) {
        if (zzmx.zzb) {
            return zzmx.zzt(obj, j);
        }
        return zzmx.zzu(obj, j);
    }
}
