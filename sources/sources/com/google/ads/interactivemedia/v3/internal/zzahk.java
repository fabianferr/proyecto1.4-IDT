package com.google.ads.interactivemedia.v3.internal;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzahk {
    private static final zzahk zza = new zzahk(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzahk() {
        this(0, new int[8], new Object[8], true);
    }

    private zzahk(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzahk zzc() {
        return zza;
    }

    static zzahk zze(zzahk zzahk, zzahk zzahk2) {
        int i = zzahk.zzb + zzahk2.zzb;
        int[] copyOf = Arrays.copyOf(zzahk.zzc, i);
        System.arraycopy(zzahk2.zzc, 0, copyOf, zzahk.zzb, zzahk2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzahk.zzd, i);
        System.arraycopy(zzahk2.zzd, 0, copyOf2, zzahk.zzb, zzahk2.zzb);
        return new zzahk(i, copyOf, copyOf2, true);
    }

    static zzahk zzf() {
        return new zzahk(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzahk)) {
            return false;
        }
        zzahk zzahk = (zzahk) obj;
        int i = this.zzb;
        if (i == zzahk.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzahk.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzahk.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 * 31) + i4;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return (i6 * 31) + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzaea.zzx(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = zzaea.zzb;
                    int zzd2 = ((zzadr) this.zzd[i6]).zzd();
                    i = zzaea.zzx(i8 << 3) + zzaea.zzx(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int i11 = i8 << 3;
                    int i12 = zzaea.zzb;
                    i2 = ((zzahk) this.zzd[i6]).zza();
                    int zzx = zzaea.zzx(i11);
                    i3 = zzx + zzx;
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzaea.zzx(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzafc.zza());
                }
                i5 += i;
            } else {
                int i13 = i8 << 3;
                i2 = zzaea.zzy(((Long) this.zzd[i6]).longValue());
                i3 = zzaea.zzx(i13);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = zzaea.zzb;
            int zzd2 = ((zzadr) this.zzd[i3]).zzd();
            int zzx = zzaea.zzx(zzd2) + zzd2;
            int zzx2 = zzaea.zzx(16);
            int zzx3 = zzaea.zzx(this.zzc[i3] >>> 3);
            int zzx4 = zzaea.zzx(8);
            i2 += zzx4 + zzx4 + zzx2 + zzx3 + zzaea.zzx(24) + zzx;
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final zzahk zzd(zzahk zzahk) {
        if (zzahk.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzahk.zzb;
        zzl(i);
        System.arraycopy(zzahk.zzc, 0, this.zzc, this.zzb, zzahk.zzb);
        System.arraycopy(zzahk.zzd, 0, this.zzd, this.zzb, zzahk.zzb);
        this.zzb = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzagb.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzaib zzaib) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzaib.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzaib.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzaib.zzd(i4, (zzadr) obj);
                } else if (i3 == 3) {
                    zzaib.zzE(i4);
                    ((zzahk) obj).zzk(zzaib);
                    zzaib.zzh(i4);
                } else if (i3 == 5) {
                    zzaib.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzafc.zza());
                }
            }
        }
    }
}
