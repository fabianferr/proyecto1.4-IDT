package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
class zzrj extends zzri {
    protected final byte[] zza;

    zzrj(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrm) || zzd() != ((zzrm) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzrj)) {
            return obj.equals(this);
        }
        zzrj zzrj = (zzrj) obj;
        int zzk = zzk();
        int zzk2 = zzrj.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzrj.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd > zzrj.zzd()) {
            int zzd3 = zzrj.zzd();
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd3);
        } else if (!(zzrj instanceof zzrj)) {
            return zzrj.zzf(0, zzd).equals(zzf(0, zzd));
        } else {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzrj.zza;
            zzrj.zzc();
            int i = 0;
            int i2 = 0;
            while (i < zzd) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public final int zze(int i, int i2, int i3) {
        return zzsq.zzb(i, this.zza, 0, i3);
    }

    public final zzrm zzf(int i, int i2) {
        zzj(0, i2, zzd());
        if (i2 == 0) {
            return zzrm.zzb;
        }
        return new zzrg(this.zza, 0, i2);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzrc zzrc) throws IOException {
        ((zzrr) zzrc).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zzvf.zze(this.zza, 0, zzd());
    }
}
