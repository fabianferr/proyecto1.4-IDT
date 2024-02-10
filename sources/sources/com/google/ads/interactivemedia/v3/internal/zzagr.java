package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagr extends zzadr {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    /* access modifiers changed from: private */
    public final zzadr zzd;
    /* access modifiers changed from: private */
    public final zzadr zze;
    private final int zzf;
    private final int zzg;

    private zzagr(zzadr zzadr, zzadr zzadr2) {
        this.zzd = zzadr;
        this.zze = zzadr2;
        int zzd2 = zzadr.zzd();
        this.zzf = zzd2;
        this.zzc = zzd2 + zzadr2.zzd();
        this.zzg = Math.max(zzadr.zzf(), zzadr2.zzf()) + 1;
    }

    private static zzadr zzA(zzadr zzadr, zzadr zzadr2) {
        int zzd2 = zzadr.zzd();
        int zzd3 = zzadr2.zzd();
        byte[] bArr = new byte[(zzd2 + zzd3)];
        zzadr.zzw(bArr, 0, 0, zzd2);
        zzadr2.zzw(bArr, 0, zzd2, zzd3);
        return new zzado(bArr);
    }

    static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    static zzadr zzz(zzadr zzadr, zzadr zzadr2) {
        if (zzadr2.zzd() == 0) {
            return zzadr;
        }
        if (zzadr.zzd() == 0) {
            return zzadr2;
        }
        int zzd2 = zzadr.zzd() + zzadr2.zzd();
        if (zzd2 < 128) {
            return zzA(zzadr, zzadr2);
        }
        if (zzadr instanceof zzagr) {
            zzagr zzagr = (zzagr) zzadr;
            if (zzagr.zze.zzd() + zzadr2.zzd() < 128) {
                return new zzagr(zzagr.zzd, zzA(zzagr.zze, zzadr2));
            } else if (zzagr.zzd.zzf() > zzagr.zze.zzf() && zzagr.zzg > zzadr2.zzf()) {
                return new zzagr(zzagr.zzd, new zzagr(zzagr.zze, zzadr2));
            }
        }
        if (zzd2 >= zzc(Math.max(zzadr.zzf(), zzadr2.zzf()) + 1)) {
            return new zzagr(zzadr, zzadr2);
        }
        return zzagn.zza(new zzagn((zzagm) null), zzadr, zzadr2);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzadr)) {
            return false;
        }
        zzadr zzadr = (zzadr) obj;
        if (this.zzc != zzadr.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int zzq = zzq();
        int zzq2 = zzadr.zzq();
        if (zzq != 0 && zzq2 != 0 && zzq != zzq2) {
            return false;
        }
        zzagp zzagp = new zzagp(this, (zzago) null);
        zzadn zza2 = zzagp.next();
        zzagp zzagp2 = new zzagp(zzadr, (zzago) null);
        zzadn zza3 = zzagp2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int zzd2 = zza2.zzd() - i;
            int zzd3 = zza3.zzd() - i2;
            int min = Math.min(zzd2, zzd3);
            if (i == 0) {
                z = zza2.zzg(zza3, i2, min);
            } else {
                z = zza3.zzg(zza2, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zzc;
            if (i3 < i4) {
                if (min == zzd2) {
                    zza2 = zzagp.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == zzd3) {
                    zza3 = zzagp2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzagl(this);
    }

    public final byte zza(int i) {
        zzv(i, this.zzc);
        return zzb(i);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i) {
        int i2 = this.zzf;
        if (i < i2) {
            return this.zzd.zzb(i);
        }
        return this.zze.zzb(i - i2);
    }

    public final int zzd() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zze.zze(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    /* access modifiers changed from: protected */
    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    /* access modifiers changed from: protected */
    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    public final zzadr zzk(int i, int i2) {
        int zzp = zzp(i, i2, this.zzc);
        if (zzp == 0) {
            return zzadr.zzb;
        }
        if (zzp == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzk(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzk(i - i3, i2 - i3);
        }
        zzadr zzadr = this.zzd;
        return new zzagr(zzadr.zzk(i, zzadr.zzd()), this.zze.zzk(0, i2 - this.zzf));
    }

    public final zzadv zzl() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final String zzm(Charset charset) {
        return new String(zzx(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzn(zzadh zzadh) throws IOException {
        this.zzd.zzn(zzadh);
        this.zze.zzn(zzadh);
    }

    public final boolean zzo() {
        int zzj = this.zzd.zzj(0, 0, this.zzf);
        zzadr zzadr = this.zze;
        if (zzadr.zzj(zzj, 0, zzadr.zzd()) == 0) {
            return true;
        }
        return false;
    }

    public final zzadm zzr() {
        return new zzagl(this);
    }
}
