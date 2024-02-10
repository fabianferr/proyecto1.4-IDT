package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
class zzado extends zzadn {
    protected final byte[] zza;

    zzado(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzadr) || zzd() != ((zzadr) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzado)) {
            return obj.equals(this);
        }
        zzado zzado = (zzado) obj;
        int zzq = zzq();
        int zzq2 = zzado.zzq();
        if (zzq == 0 || zzq2 == 0 || zzq == zzq2) {
            return zzg(zzado, 0, zzd());
        }
        return false;
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
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(zzadr zzadr, int i, int i2) {
        if (i2 <= zzadr.zzd()) {
            int i3 = i + i2;
            if (i3 > zzadr.zzd()) {
                int zzd = zzadr.zzd();
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzd);
            } else if (!(zzadr instanceof zzado)) {
                return zzadr.zzk(i, i3).equals(zzk(0, i2));
            } else {
                zzado zzado = (zzado) zzadr;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzado.zza;
                int zzc = zzc() + i2;
                int zzc2 = zzc();
                int zzc3 = zzado.zzc() + i;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
        } else {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + i2 + zzd2);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzi(int i, int i2, int i3) {
        return zzafa.zzb(i, this.zza, zzc() + i2, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzahy.zzf(i, this.zza, zzc, i3 + zzc);
    }

    public final zzadr zzk(int i, int i2) {
        int zzp = zzp(i, i2, zzd());
        if (zzp == 0) {
            return zzadr.zzb;
        }
        return new zzadl(this.zza, zzc() + i, zzp);
    }

    public final zzadv zzl() {
        return zzadv.zzu(this.zza, zzc(), zzd(), true);
    }

    /* access modifiers changed from: protected */
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzn(zzadh zzadh) throws IOException {
        ((zzadx) zzadh).zzc(this.zza, zzc(), zzd());
    }

    public final boolean zzo() {
        int zzc = zzc();
        return zzahy.zzi(this.zza, zzc, zzd() + zzc);
    }
}
