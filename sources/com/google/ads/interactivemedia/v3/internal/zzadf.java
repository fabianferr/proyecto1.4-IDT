package com.google.ads.interactivemedia.v3.internal;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzadf {
    static int zza(byte[] bArr, int i, zzade zzade) throws zzafc {
        int zzj = zzj(bArr, i, zzade);
        int i2 = zzade.zza;
        if (i2 < 0) {
            throw zzafc.zzf();
        } else if (i2 > bArr.length - zzj) {
            throw zzafc.zzi();
        } else if (i2 == 0) {
            zzade.zzc = zzadr.zzb;
            return zzj;
        } else {
            zzade.zzc = zzadr.zzs(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zzc(zzags zzags, byte[] bArr, int i, int i2, int i3, zzade zzade) throws IOException {
        Object zze = zzags.zze();
        int zzn = zzn(zze, zzags, bArr, i, i2, i3, zzade);
        zzags.zzf(zze);
        zzade.zzc = zze;
        return zzn;
    }

    static int zzd(zzags zzags, byte[] bArr, int i, int i2, zzade zzade) throws IOException {
        Object zze = zzags.zze();
        int zzo = zzo(zze, zzags, bArr, i, i2, zzade);
        zzags.zzf(zze);
        zzade.zzc = zze;
        return zzo;
    }

    static int zze(zzags zzags, int i, byte[] bArr, int i2, int i3, zzaez zzaez, zzade zzade) throws IOException {
        int zzd = zzd(zzags, bArr, i2, i3, zzade);
        zzaez.add(zzade.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzade);
            if (i != zzade.zza) {
                break;
            }
            zzd = zzd(zzags, bArr, zzj, i3, zzade);
            zzaez.add(zzade.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzaez zzaez, zzade zzade) throws IOException {
        zzaeu zzaeu = (zzaeu) zzaez;
        int zzj = zzj(bArr, i, zzade);
        int i2 = zzade.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzade);
            zzaeu.zzg(zzade.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzafc.zzi();
    }

    static int zzg(byte[] bArr, int i, zzade zzade) throws zzafc {
        int zzj = zzj(bArr, i, zzade);
        int i2 = zzade.zza;
        if (i2 < 0) {
            throw zzafc.zzf();
        } else if (i2 == 0) {
            zzade.zzc = "";
            return zzj;
        } else {
            zzade.zzc = new String(bArr, zzj, i2, zzafa.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzade zzade) throws zzafc {
        int zzj = zzj(bArr, i, zzade);
        int i2 = zzade.zza;
        if (i2 < 0) {
            throw zzafc.zzf();
        } else if (i2 == 0) {
            zzade.zzc = "";
            return zzj;
        } else {
            zzade.zzc = zzahy.zzg(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzahk zzahk, zzade zzade) throws zzafc {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzade);
                zzahk.zzj(i, Long.valueOf(zzade.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzahk.zzj(i, Long.valueOf(zzp(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzade);
                int i5 = zzade.zza;
                if (i5 < 0) {
                    throw zzafc.zzf();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzahk.zzj(i, zzadr.zzb);
                    } else {
                        zzahk.zzj(i, zzadr.zzs(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzafc.zzi();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzahk zzf = zzahk.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzade);
                    int i8 = zzade.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzj2;
                        break;
                    }
                    int zzi = zzi(i7, bArr, zzj2, i3, zzf, zzade);
                    i7 = i8;
                    i2 = zzi;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzafc.zzg();
                }
                zzahk.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzahk.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzafc.zzc();
            }
        } else {
            throw zzafc.zzc();
        }
    }

    static int zzj(byte[] bArr, int i, zzade zzade) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzade);
        }
        zzade.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzade zzade) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzade.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzade.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzade.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzade.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzade.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzaez zzaez, zzade zzade) {
        zzaeu zzaeu = (zzaeu) zzaez;
        int zzj = zzj(bArr, i2, zzade);
        zzaeu.zzg(zzade.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzade);
            if (i != zzade.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzade);
            zzaeu.zzg(zzade.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzade zzade) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzade.zzb = j;
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
            byte b3 = b2;
            i3 = i5;
            b = b3;
        }
        zzade.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzags zzags, byte[] bArr, int i, int i2, int i3, zzade zzade) throws IOException {
        int zzc = ((zzagc) zzags).zzc(obj, bArr, i, i2, i3, zzade);
        zzade.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzo(java.lang.Object r6, com.google.ads.interactivemedia.v3.internal.zzags r7, byte[] r8, int r9, int r10, com.google.ads.interactivemedia.v3.internal.zzade r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.ads.interactivemedia.v3.internal.zzafc r6 = com.google.ads.interactivemedia.v3.internal.zzafc.zzi()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzadf.zzo(java.lang.Object, com.google.ads.interactivemedia.v3.internal.zzags, byte[], int, int, com.google.ads.interactivemedia.v3.internal.zzade):int");
    }

    static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
