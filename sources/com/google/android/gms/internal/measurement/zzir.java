package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzir {
    static int zza(byte[] bArr, int i, zziq zziq) throws zzko {
        int zzj = zzj(bArr, i, zziq);
        int i2 = zziq.zza;
        if (i2 < 0) {
            throw zzko.zzd();
        } else if (i2 > bArr.length - zzj) {
            throw zzko.zzf();
        } else if (i2 == 0) {
            zziq.zzc = zzjd.zzb;
            return zzj;
        } else {
            zziq.zzc = zzjd.zzl(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zzc(zzlw zzlw, byte[] bArr, int i, int i2, int i3, zziq zziq) throws IOException {
        zzlo zzlo = (zzlo) zzlw;
        Object zze = zzlo.zze();
        int zzc = zzlo.zzc(zze, bArr, i, i2, i3, zziq);
        zzlo.zzf(zze);
        zziq.zzc = zze;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(com.google.android.gms.internal.measurement.zzlw r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.zziq r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zze()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzh(r1, r2, r3, r4, r5)
            r6.zzf(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.zzko r6 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzir.zzd(com.google.android.gms.internal.measurement.zzlw, byte[], int, int, com.google.android.gms.internal.measurement.zziq):int");
    }

    static int zze(zzlw zzlw, int i, byte[] bArr, int i2, int i3, zzkl zzkl, zziq zziq) throws IOException {
        int zzd = zzd(zzlw, bArr, i2, i3, zziq);
        zzkl.add(zziq.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zziq);
            if (i != zziq.zza) {
                break;
            }
            zzd = zzd(zzlw, bArr, zzj, i3, zziq);
            zzkl.add(zziq.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzkl zzkl, zziq zziq) throws IOException {
        zzkf zzkf = (zzkf) zzkl;
        int zzj = zzj(bArr, i, zziq);
        int i2 = zziq.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zziq);
            zzkf.zzh(zziq.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzko.zzf();
    }

    static int zzg(byte[] bArr, int i, zziq zziq) throws zzko {
        int zzj = zzj(bArr, i, zziq);
        int i2 = zziq.zza;
        if (i2 < 0) {
            throw zzko.zzd();
        } else if (i2 == 0) {
            zziq.zzc = "";
            return zzj;
        } else {
            zziq.zzc = new String(bArr, zzj, i2, zzkm.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zziq zziq) throws zzko {
        int zzj = zzj(bArr, i, zziq);
        int i2 = zziq.zza;
        if (i2 < 0) {
            throw zzko.zzd();
        } else if (i2 == 0) {
            zziq.zzc = "";
            return zzj;
        } else {
            zziq.zzc = zznc.zzd(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzmo zzmo, zziq zziq) throws zzko {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zziq);
                zzmo.zzh(i, Long.valueOf(zziq.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzmo.zzh(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zziq);
                int i5 = zziq.zza;
                if (i5 < 0) {
                    throw zzko.zzd();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzmo.zzh(i, zzjd.zzb);
                    } else {
                        zzmo.zzh(i, zzjd.zzl(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzko.zzf();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzmo zze = zzmo.zze();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zziq);
                    int i8 = zziq.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zzj2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzi(i8, bArr, zzj2, i3, zze, zziq);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzko.zze();
                }
                zzmo.zzh(i, zze);
                return i2;
            } else if (i4 == 5) {
                zzmo.zzh(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzko.zzb();
            }
        } else {
            throw zzko.zzb();
        }
    }

    static int zzj(byte[] bArr, int i, zziq zziq) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zziq);
        }
        zziq.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zziq zziq) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zziq.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zziq.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zziq.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zziq.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zziq.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzkl zzkl, zziq zziq) {
        zzkf zzkf = (zzkf) zzkl;
        int zzj = zzj(bArr, i2, zziq);
        zzkf.zzh(zziq.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zziq);
            if (i != zziq.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zziq);
            zzkf.zzh(zziq.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zziq zziq) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zziq.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zziq.zzb = j2;
        return i3;
    }

    static long zzn(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
