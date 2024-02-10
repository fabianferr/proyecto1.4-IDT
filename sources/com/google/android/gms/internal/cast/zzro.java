package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzro extends zzrq {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze = Integer.MAX_VALUE;

    /* synthetic */ zzro(byte[] bArr, int i, int i2, boolean z, zzrn zzrn) {
        super((zzrp) null);
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i) throws zzss {
        int i2 = this.zze;
        this.zze = 0;
        int i3 = this.zzc + this.zzd;
        this.zzc = i3;
        if (i3 > 0) {
            this.zzd = i3;
            this.zzc = i3 - i3;
        } else {
            this.zzd = 0;
        }
        return i2;
    }
}
