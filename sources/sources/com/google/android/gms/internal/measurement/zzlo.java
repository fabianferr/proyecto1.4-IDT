package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzlo<T> implements zzlw<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzll zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkz zzm;
    private final zzmn zzn;
    private final zzjr zzo;
    private final zzlq zzp;
    private final zzlg zzq;

    private zzlo(int[] iArr, Object[] objArr, int i, int i2, zzll zzll, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzlq zzlq, zzkz zzkz, zzmn zzmn, zzjr zzjr, zzlg zzlg, byte[] bArr) {
        zzll zzll2 = zzll;
        zzjr zzjr2 = zzjr;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzjr2 != null && zzjr2.zzc(zzll)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzlq;
        this.zzm = zzkz;
        this.zzn = zzmn;
        this.zzo = zzjr2;
        this.zzg = zzll2;
        this.zzq = zzlg;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzmx.zzf(obj, j)).longValue();
    }

    private final zzki zzD(int i) {
        int i2 = i / 3;
        return (zzki) this.zzd[i2 + i2 + 1];
    }

    private final zzlw zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzlw zzlw = (zzlw) this.zzd[i3];
        if (zzlw != null) {
            return zzlw;
        }
        zzlw zzb2 = zzlt.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long zzB = (long) (zzB(i) & 1048575);
        if (zzO(obj2, i)) {
            Object zzf2 = zzmx.zzf(obj, zzB);
            Object zzf3 = zzmx.zzf(obj2, zzB);
            if (zzf2 != null && zzf3 != null) {
                zzmx.zzs(obj, zzB, zzkm.zzg(zzf2, zzf3));
                zzJ(obj, i);
            } else if (zzf3 != null) {
                zzmx.zzs(obj, zzB, zzf3);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int zzB = zzB(i);
        int i2 = this.zzc[i];
        long j = (long) (zzB & 1048575);
        if (zzR(obj2, i2, i)) {
            Object zzf2 = zzR(obj, i2, i) ? zzmx.zzf(obj, j) : null;
            Object zzf3 = zzmx.zzf(obj2, j);
            if (zzf2 != null && zzf3 != null) {
                zzmx.zzs(obj, j, zzkm.zzg(zzf2, zzf3));
                zzK(obj, i2, i);
            } else if (zzf3 != null) {
                zzmx.zzs(obj, j, zzf3);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (1048575 & zzy);
        if (j != 1048575) {
            zzmx.zzq(obj, j, (1 << (zzy >>> 20)) | zzmx.zzc(obj, j));
        }
    }

    private final void zzK(Object obj, int i, int i2) {
        zzmx.zzq(obj, (long) (zzy(i2) & 1048575), i);
    }

    private final void zzL(Object obj, zznf zznf) throws IOException {
        int i;
        Object obj2 = obj;
        zznf zznf2 = zznf;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i2 = 1048575;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1048575;
            while (i3 < length) {
                int zzB = zzB(i3);
                int[] iArr = this.zzc;
                int i6 = iArr[i3];
                int zzA = zzA(zzB);
                if (zzA <= 17) {
                    int i7 = iArr[i3 + 2];
                    int i8 = i7 & i2;
                    if (i8 != i5) {
                        i4 = unsafe.getInt(obj2, (long) i8);
                        i5 = i8;
                    }
                    i = 1 << (i7 >>> 20);
                } else {
                    i = 0;
                }
                long j = (long) (zzB & i2);
                switch (zzA) {
                    case 0:
                        if ((i4 & i) == 0) {
                            break;
                        } else {
                            zznf2.zzf(i6, zzmx.zza(obj2, j));
                            continue;
                        }
                    case 1:
                        if ((i4 & i) != 0) {
                            zznf2.zzo(i6, zzmx.zzb(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i4 & i) != 0) {
                            zznf2.zzt(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i4 & i) != 0) {
                            zznf2.zzJ(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i4 & i) != 0) {
                            zznf2.zzr(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i4 & i) != 0) {
                            zznf2.zzm(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i4 & i) != 0) {
                            zznf2.zzk(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i4 & i) != 0) {
                            zznf2.zzb(i6, zzmx.zzw(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i4 & i) != 0) {
                            zzT(i6, unsafe.getObject(obj2, j), zznf2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i4 & i) != 0) {
                            zznf2.zzv(i6, unsafe.getObject(obj2, j), zzE(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i4 & i) != 0) {
                            zznf2.zzd(i6, (zzjd) unsafe.getObject(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i4 & i) != 0) {
                            zznf2.zzH(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i4 & i) != 0) {
                            zznf2.zzi(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i4 & i) != 0) {
                            zznf2.zzw(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i4 & i) != 0) {
                            zznf2.zzy(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i4 & i) != 0) {
                            zznf2.zzA(i6, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i4 & i) != 0) {
                            zznf2.zzC(i6, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i4 & i) != 0) {
                            zznf2.zzq(i6, unsafe.getObject(obj2, j), zzE(i3));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzly.zzJ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 19:
                        zzly.zzN(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 20:
                        zzly.zzQ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 21:
                        zzly.zzY(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 22:
                        zzly.zzP(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 23:
                        zzly.zzM(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 24:
                        zzly.zzL(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 25:
                        zzly.zzH(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        continue;
                    case 26:
                        zzly.zzW(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2);
                        break;
                    case 27:
                        zzly.zzR(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, zzE(i3));
                        break;
                    case 28:
                        zzly.zzI(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2);
                        break;
                    case 29:
                        zzly.zzX(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        break;
                    case 30:
                        zzly.zzK(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        break;
                    case 31:
                        zzly.zzS(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        break;
                    case 32:
                        zzly.zzT(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        break;
                    case 33:
                        zzly.zzU(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        break;
                    case 34:
                        zzly.zzV(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, false);
                        break;
                    case 35:
                        zzly.zzJ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 36:
                        zzly.zzN(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 37:
                        zzly.zzQ(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 38:
                        zzly.zzY(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 39:
                        zzly.zzP(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 40:
                        zzly.zzM(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 41:
                        zzly.zzL(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 42:
                        zzly.zzH(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 43:
                        zzly.zzX(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 44:
                        zzly.zzK(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 45:
                        zzly.zzS(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 46:
                        zzly.zzT(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 47:
                        zzly.zzU(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 48:
                        zzly.zzV(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, true);
                        break;
                    case 49:
                        zzly.zzO(this.zzc[i3], (List) unsafe.getObject(obj2, j), zznf2, zzE(i3));
                        break;
                    case 50:
                        zzM(zznf2, i6, unsafe.getObject(obj2, j), i3);
                        break;
                    case 51:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzf(i6, zzn(obj2, j));
                            break;
                        }
                        break;
                    case 52:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzo(i6, zzo(obj2, j));
                            break;
                        }
                        break;
                    case 53:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzt(i6, zzC(obj2, j));
                            break;
                        }
                        break;
                    case 54:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzJ(i6, zzC(obj2, j));
                            break;
                        }
                        break;
                    case 55:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzr(i6, zzr(obj2, j));
                            break;
                        }
                        break;
                    case 56:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzm(i6, zzC(obj2, j));
                            break;
                        }
                        break;
                    case 57:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzk(i6, zzr(obj2, j));
                            break;
                        }
                        break;
                    case 58:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzb(i6, zzS(obj2, j));
                            break;
                        }
                        break;
                    case 59:
                        if (zzR(obj2, i6, i3)) {
                            zzT(i6, unsafe.getObject(obj2, j), zznf2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzv(i6, unsafe.getObject(obj2, j), zzE(i3));
                            break;
                        }
                        break;
                    case 61:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzd(i6, (zzjd) unsafe.getObject(obj2, j));
                            break;
                        }
                        break;
                    case 62:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzH(i6, zzr(obj2, j));
                            break;
                        }
                        break;
                    case 63:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzi(i6, zzr(obj2, j));
                            break;
                        }
                        break;
                    case 64:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzw(i6, zzr(obj2, j));
                            break;
                        }
                        break;
                    case 65:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzy(i6, zzC(obj2, j));
                            break;
                        }
                        break;
                    case 66:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzA(i6, zzr(obj2, j));
                            break;
                        }
                        break;
                    case 67:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzC(i6, zzC(obj2, j));
                            break;
                        }
                        break;
                    case 68:
                        if (zzR(obj2, i6, i3)) {
                            zznf2.zzq(i6, unsafe.getObject(obj2, j), zzE(i3));
                            break;
                        }
                        break;
                }
                i3 += 3;
                i2 = 1048575;
            }
            zzmn zzmn = this.zzn;
            zzmn.zzi(zzmn.zzc(obj2), zznf2);
            return;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    private final void zzM(zznf zznf, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzle zzle = (zzle) zzF(i2);
            throw null;
        }
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        return zzO(obj, i) == zzO(obj2, i);
    }

    private final boolean zzO(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (zzy & 1048575);
        if (j != 1048575) {
            return (zzmx.zzc(obj, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i);
        long j2 = (long) (zzB & 1048575);
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmx.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmx.zzb(obj, j2)) != 0;
            case 2:
                return zzmx.zzd(obj, j2) != 0;
            case 3:
                return zzmx.zzd(obj, j2) != 0;
            case 4:
                return zzmx.zzc(obj, j2) != 0;
            case 5:
                return zzmx.zzd(obj, j2) != 0;
            case 6:
                return zzmx.zzc(obj, j2) != 0;
            case 7:
                return zzmx.zzw(obj, j2);
            case 8:
                Object zzf2 = zzmx.zzf(obj, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzjd) {
                    return !zzjd.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmx.zzf(obj, j2) != null;
            case 10:
                return !zzjd.zzb.equals(zzmx.zzf(obj, j2));
            case 11:
                return zzmx.zzc(obj, j2) != 0;
            case 12:
                return zzmx.zzc(obj, j2) != 0;
            case 13:
                return zzmx.zzc(obj, j2) != 0;
            case 14:
                return zzmx.zzd(obj, j2) != 0;
            case 15:
                return zzmx.zzc(obj, j2) != 0;
            case 16:
                return zzmx.zzd(obj, j2) != 0;
            case 17:
                return zzmx.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzP(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzQ(Object obj, int i, zzlw zzlw) {
        return zzlw.zzk(zzmx.zzf(obj, (long) (i & 1048575)));
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzmx.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzmx.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zznf zznf) throws IOException {
        if (obj instanceof String) {
            zznf.zzF(i, (String) obj);
        } else {
            zznf.zzd(i, (zzjd) obj);
        }
    }

    static zzmo zzd(Object obj) {
        zzke zzke = (zzke) obj;
        zzmo zzmo = zzke.zzc;
        if (zzmo != zzmo.zzc()) {
            return zzmo;
        }
        zzmo zze2 = zzmo.zze();
        zzke.zzc = zze2;
        return zze2;
    }

    static zzlo zzl(Class cls, zzli zzli, zzlq zzlq, zzkz zzkz, zzmn zzmn, zzjr zzjr, zzlg zzlg) {
        if (zzli instanceof zzlv) {
            return zzm((zzlv) zzli, zzlq, zzkz, zzmn, zzjr, zzlg);
        }
        zzmk zzmk = (zzmk) zzli;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.zzlo zzm(com.google.android.gms.internal.measurement.zzlv r34, com.google.android.gms.internal.measurement.zzlq r35, com.google.android.gms.internal.measurement.zzkz r36, com.google.android.gms.internal.measurement.zzmn r37, com.google.android.gms.internal.measurement.zzjr r38, com.google.android.gms.internal.measurement.zzlg r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.measurement.zzll r18 = r34.zza()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r1) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0193:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a5
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0193
        L_0x01a5:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ad
        L_0x01ab:
            r3 = r24
        L_0x01ad:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01da
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d4
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bb
        L_0x01d4:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r1
            r1 = r24
        L_0x01de:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0222
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0226
        L_0x0222:
            r32 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzG(r2, r12)
            r17[r1] = r12
        L_0x0268:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r1 = r1 + 1
            r7 = r17[r1]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzG(r2, r7)
            r17[r1] = r7
        L_0x0283:
            r1 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r30 = r0
            r0 = r6
            r7 = r8
            r29 = r11
            r25 = 1
            r8 = r1
            r1 = 0
            goto L_0x0391
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzG(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x0354
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r1 = r1 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r1 = r1 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r1 / 32
            int r7 = r7 + r26
            r11 = r17[r7]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzG(r2, r11)
            r17[r7] = r11
        L_0x036f:
            r0 = r6
            long r6 = r15.objectFieldOffset(r11)
            int r7 = (int) r6
            int r1 = r1 % 32
            goto L_0x0381
        L_0x0378:
            r30 = r0
            r0 = r6
            r27 = r1
            r1 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0381:
            r6 = 18
            if (r5 < r6) goto L_0x038f
            r6 = 49
            if (r5 > r6) goto L_0x038f
            int r6 = r23 + 1
            r13[r23] = r8
            r23 = r6
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r6 = r9 + 1
            r31[r9] = r4
            int r4 = r6 + 1
            r9 = r3 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03a6
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r3 = 0
        L_0x03a7:
            r3 = r3 | r9
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r8
            r31[r6] = r3
            int r9 = r4 + 1
            int r1 = r1 << 20
            r1 = r1 | r7
            r31[r4] = r1
            r6 = r0
            r8 = r14
            r14 = r24
            r4 = r27
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.measurement.zzlo r0 = new com.google.android.gms.internal.measurement.zzlo
            r4 = r0
            com.google.android.gms.internal.measurement.zzll r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzm(com.google.android.gms.internal.measurement.zzlv, com.google.android.gms.internal.measurement.zzlq, com.google.android.gms.internal.measurement.zzkz, com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzjr, com.google.android.gms.internal.measurement.zzlg):com.google.android.gms.internal.measurement.zzlo");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzmx.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzmx.zzf(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x030b, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030c, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x030d, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x037c, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0487, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0502, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0503, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x052c, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x053a, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0549, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x054d, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f0, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019d, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ad, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01bd, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = zzb
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
        L_0x000e:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0554
            int r9 = r15.zzB(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzA(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0037
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r4
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0038
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r9 = r9 & r4
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x053e;
                case 1: goto L_0x052f;
                case 2: goto L_0x0519;
                case 3: goto L_0x0505;
                case 4: goto L_0x04ef;
                case 5: goto L_0x04e3;
                case 6: goto L_0x04d7;
                case 7: goto L_0x04c9;
                case 8: goto L_0x049e;
                case 9: goto L_0x048b;
                case 10: goto L_0x046e;
                case 11: goto L_0x0459;
                case 12: goto L_0x0444;
                case 13: goto L_0x0437;
                case 14: goto L_0x042a;
                case 15: goto L_0x0410;
                case 16: goto L_0x03f6;
                case 17: goto L_0x03e2;
                case 18: goto L_0x03d4;
                case 19: goto L_0x03c8;
                case 20: goto L_0x03bc;
                case 21: goto L_0x03b0;
                case 22: goto L_0x03a4;
                case 23: goto L_0x0398;
                case 24: goto L_0x038c;
                case 25: goto L_0x0380;
                case 26: goto L_0x0372;
                case 27: goto L_0x0363;
                case 28: goto L_0x0358;
                case 29: goto L_0x034c;
                case 30: goto L_0x0340;
                case 31: goto L_0x0334;
                case 32: goto L_0x0328;
                case 33: goto L_0x031c;
                case 34: goto L_0x0310;
                case 35: goto L_0x02f7;
                case 36: goto L_0x02e2;
                case 37: goto L_0x02cd;
                case 38: goto L_0x02b8;
                case 39: goto L_0x02a3;
                case 40: goto L_0x028e;
                case 41: goto L_0x0278;
                case 42: goto L_0x0262;
                case 43: goto L_0x024c;
                case 44: goto L_0x0236;
                case 45: goto L_0x0220;
                case 46: goto L_0x020a;
                case 47: goto L_0x01f4;
                case 48: goto L_0x01de;
                case 49: goto L_0x01ce;
                case 50: goto L_0x01c1;
                case 51: goto L_0x01b1;
                case 52: goto L_0x01a1;
                case 53: goto L_0x0189;
                case 54: goto L_0x0174;
                case 55: goto L_0x015e;
                case 56: goto L_0x0151;
                case 57: goto L_0x0144;
                case 58: goto L_0x0135;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f4;
                case 61: goto L_0x00d6;
                case 62: goto L_0x00c0;
                case 63: goto L_0x00aa;
                case 64: goto L_0x009c;
                case 65: goto L_0x008e;
                case 66: goto L_0x0073;
                case 67: goto L_0x0057;
                case 68: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x037d
        L_0x0041:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzll r3 = (com.google.android.gms.internal.measurement.zzll) r3
            com.google.android.gms.internal.measurement.zzlw r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzu(r11, r3, r4)
            goto L_0x037c
        L_0x0057:
            boolean r10 = r15.zzR(r1, r11, r5)
            if (r10 == 0) goto L_0x037d
            long r3 = zzC(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjl.zzA(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x037d
        L_0x0073:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030c
        L_0x008e:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x01bd
        L_0x009c:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x01ad
        L_0x00aa:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzv(r3)
            goto L_0x030c
        L_0x00c0:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030c
        L_0x00d6:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzjd r3 = (com.google.android.gms.internal.measurement.zzjd) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
        L_0x00f0:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x030d
        L_0x00f4:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlw r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzly.zzo(r11, r3, r4)
            goto L_0x037c
        L_0x0108:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r4 == 0) goto L_0x0127
            com.google.android.gms.internal.measurement.zzjd r3 = (com.google.android.gms.internal.measurement.zzjd) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x00f0
        L_0x0127:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzy(r3)
            goto L_0x030c
        L_0x0135:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            int r3 = r3 + r14
            goto L_0x037c
        L_0x0144:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x01ad
        L_0x0151:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x01bd
        L_0x015e:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzv(r3)
            goto L_0x030c
        L_0x0174:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzB(r3)
            goto L_0x019d
        L_0x0189:
            boolean r9 = r15.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037d
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzB(r3)
        L_0x019d:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x037d
        L_0x01a1:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
        L_0x01ad:
            int r3 = r3 + 4
            goto L_0x037c
        L_0x01b1:
            boolean r3 = r15.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
        L_0x01bd:
            int r3 = r3 + 8
            goto L_0x037c
        L_0x01c1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r15.zzF(r5)
            com.google.android.gms.internal.measurement.zzlg.zza(r11, r3, r4)
            goto L_0x037d
        L_0x01ce:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlw r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzly.zzj(r11, r3, r4)
            goto L_0x037c
        L_0x01de:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzt(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x01f4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzr(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x020a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzi(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x0220:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzg(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x0236:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zze(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x024c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzw(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x0262:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzb(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x0278:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzg(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x028e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzi(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x02a3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzl(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x02b8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzy(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x02cd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzn(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x02e2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzg(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x030b
        L_0x02f7:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzi(r3)
            if (r3 <= 0) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
        L_0x030b:
            int r4 = r4 + r9
        L_0x030c:
            int r4 = r4 + r3
        L_0x030d:
            int r6 = r6 + r4
            goto L_0x037d
        L_0x0310:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.zzly.zzs(r11, r3, r9)
            goto L_0x037c
        L_0x031c:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzq(r11, r3, r9)
            goto L_0x037c
        L_0x0328:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzh(r11, r3, r9)
            goto L_0x037c
        L_0x0334:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzf(r11, r3, r9)
            goto L_0x037c
        L_0x0340:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzd(r11, r3, r9)
            goto L_0x037c
        L_0x034c:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzv(r11, r3, r9)
            goto L_0x037c
        L_0x0358:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzc(r11, r3)
            goto L_0x037c
        L_0x0363:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlw r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzly.zzp(r11, r3, r4)
            goto L_0x037c
        L_0x0372:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzu(r11, r3)
        L_0x037c:
            int r6 = r6 + r3
        L_0x037d:
            r12 = 0
            goto L_0x054d
        L_0x0380:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.zzly.zza(r11, r3, r12)
            goto L_0x03df
        L_0x038c:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzf(r11, r3, r12)
            goto L_0x03df
        L_0x0398:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzh(r11, r3, r12)
            goto L_0x03df
        L_0x03a4:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzk(r11, r3, r12)
            goto L_0x03df
        L_0x03b0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzx(r11, r3, r12)
            goto L_0x03df
        L_0x03bc:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzm(r11, r3, r12)
            goto L_0x03df
        L_0x03c8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzf(r11, r3, r12)
            goto L_0x03df
        L_0x03d4:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzly.zzh(r11, r3, r12)
        L_0x03df:
            int r6 = r6 + r3
            goto L_0x054d
        L_0x03e2:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzll r3 = (com.google.android.gms.internal.measurement.zzll) r3
            com.google.android.gms.internal.measurement.zzlw r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzu(r11, r3, r4)
            goto L_0x03df
        L_0x03f6:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x054d
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjl.zzA(r10)
            long r13 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r13
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x054d
        L_0x0410:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x0502
        L_0x042a:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x0549
        L_0x0437:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x053a
        L_0x0444:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzv(r3)
            goto L_0x0502
        L_0x0459:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x0502
        L_0x046e:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzjd r3 = (com.google.android.gms.internal.measurement.zzjd) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
        L_0x0487:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x0503
        L_0x048b:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlw r4 = r15.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzly.zzo(r11, r3, r4)
            goto L_0x03df
        L_0x049e:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r4 == 0) goto L_0x04bc
            com.google.android.gms.internal.measurement.zzjd r3 = (com.google.android.gms.internal.measurement.zzjd) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x0487
        L_0x04bc:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzy(r3)
            goto L_0x0502
        L_0x04c9:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            int r3 = r3 + r14
            goto L_0x03df
        L_0x04d7:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x053a
        L_0x04e3:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
            goto L_0x0549
        L_0x04ef:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzv(r3)
        L_0x0502:
            int r4 = r4 + r3
        L_0x0503:
            int r6 = r6 + r4
            goto L_0x054d
        L_0x0505:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzB(r3)
            goto L_0x052c
        L_0x0519:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054d
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjl.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzB(r3)
        L_0x052c:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x054d
        L_0x052f:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
        L_0x053a:
            int r3 = r3 + 4
            goto L_0x03df
        L_0x053e:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054d
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjl.zzA(r3)
        L_0x0549:
            int r3 = r3 + 8
            goto L_0x03df
        L_0x054d:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x0554:
            com.google.android.gms.internal.measurement.zzmn r2 = r0.zzn
            java.lang.Object r3 = r2.zzc(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x0564
            return r6
        L_0x0564:
            com.google.android.gms.internal.measurement.zzjr r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            goto L_0x056c
        L_0x056b:
            throw r1
        L_0x056c:
            goto L_0x056b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzp(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzB(r2)
            int r5 = zzA(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzjw r4 = com.google.android.gms.internal.measurement.zzjw.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzjw r4 = com.google.android.gms.internal.measurement.zzjw.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzll r4 = (com.google.android.gms.internal.measurement.zzll) r4
            com.google.android.gms.internal.measurement.zzlw r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzR(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzC(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlw r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzly.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.lang.Object r5 = r11.zzF(r2)
            com.google.android.gms.internal.measurement.zzlg.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlw r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzly.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlw r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzly.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzly.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzll r4 = (com.google.android.gms.internal.measurement.zzll) r4
            com.google.android.gms.internal.measurement.zzlw r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzO(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.measurement.zzmx.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmx.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmx.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmx.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlw r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzly.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjd
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzjd r4 = (com.google.android.gms.internal.measurement.zzjd) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmx.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjl.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmx.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmx.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjl.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjl.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.measurement.zzmn r0 = r11.zzn
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzq(java.lang.Object):int");
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzmx.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zziq zziq) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzlf) object).zze()) {
            zzlf zzb2 = zzlf.zza().zzb();
            zzlg.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzle zzle = (zzle) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zziq zziq) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zziq zziq2 = zziq;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzir.zzn(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzir.zzb(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzir.zzm(bArr2, i9, zziq2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zziq2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzir.zzj(bArr2, i9, zziq2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zziq2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzir.zzn(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzir.zzb(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzir.zzm(bArr2, i9, zziq2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zziq2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzir.zzj(bArr2, i9, zziq2);
                    int i14 = zziq2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zznc.zzf(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i14, zzkm.zzb));
                        zzj3 += i14;
                    } else {
                        throw zzko.zzc();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd2 = zzir.zzd(zzE(i13), bArr2, i9, i2, zziq2);
                    Object object = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j2, zziq2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkm.zzg(object, zziq2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzd2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzir.zza(bArr2, i9, zziq2);
                    unsafe.putObject(obj2, j2, zziq2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzir.zzj(bArr2, i9, zziq2);
                    int i15 = zziq2.zza;
                    zzki zzD = zzD(i13);
                    if (zzD == null || zzD.zza(i15)) {
                        unsafe.putObject(obj2, j2, Integer.valueOf(i15));
                        unsafe.putInt(obj2, j3, i11);
                    } else {
                        zzd(obj).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzir.zzj(bArr2, i9, zziq2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzjh.zzb(zziq2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzir.zzm(bArr2, i9, zziq2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzjh.zzc(zziq2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc2 = zzir.zzc(zzE(i13), bArr, i, i2, (i10 & -8) | 4, zziq);
                    Object object2 = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j2, zziq2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkm.zzg(object2, zziq2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzc2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02d0, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0300, code lost:
        if (r0 != r14) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0322, code lost:
        if (r0 != r14) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0101, code lost:
        r6 = r6 | r22;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01a9, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e2, code lost:
        r6 = r6 | r22;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x021b, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x021d, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0220, code lost:
        r2 = r8;
        r28 = r9;
        r24 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b5, code lost:
        if (r0 != r32) goto L_0x02b7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzu(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.measurement.zziq r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            sun.misc.Unsafe r9 = zzb
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x034b
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.measurement.zzir.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002f
        L_0x002c:
            r17 = r0
            r4 = r3
        L_0x002f:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzx(r5, r2)
            goto L_0x0040
        L_0x003c:
            int r0 = r15.zzw(r5)
        L_0x0040:
            r2 = r0
            if (r2 != r8) goto L_0x004e
            r2 = r4
            r21 = r5
            r28 = r9
            r18 = -1
            r24 = 0
            goto L_0x0325
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r8 = zzA(r1)
            r32 = r5
            r5 = r1 & r10
            long r10 = (long) r5
            r5 = 17
            r20 = r10
            if (r8 > r5) goto L_0x0229
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r11 = 1
            int r22 = r11 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x0080
            if (r7 == r5) goto L_0x0078
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
        L_0x0078:
            if (r0 == r5) goto L_0x007f
            long r6 = (long) r0
            int r6 = r9.getInt(r14, r6)
        L_0x007f:
            r7 = r0
        L_0x0080:
            r0 = 5
            switch(r8) {
                case 0: goto L_0x0202;
                case 1: goto L_0x01e7;
                case 2: goto L_0x01c4;
                case 3: goto L_0x01c4;
                case 4: goto L_0x01ac;
                case 5: goto L_0x018c;
                case 6: goto L_0x0175;
                case 7: goto L_0x0155;
                case 8: goto L_0x0131;
                case 9: goto L_0x0106;
                case 10: goto L_0x00eb;
                case 11: goto L_0x01ac;
                case 12: goto L_0x00d5;
                case 13: goto L_0x0175;
                case 14: goto L_0x018c;
                case 15: goto L_0x00bb;
                case 16: goto L_0x008f;
                default: goto L_0x0084;
            }
        L_0x0084:
            r21 = r32
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0220
        L_0x008f:
            if (r3 != 0) goto L_0x00b1
            r11 = r34
            r0 = r20
            int r8 = com.google.android.gms.internal.measurement.zzir.zzm(r12, r4, r11)
            long r3 = r11.zzb
            long r19 = com.google.android.gms.internal.measurement.zzjh.zzc(r3)
            r3 = r0
            r0 = r9
            r1 = r30
            r10 = r2
            r2 = r3
            r21 = r32
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x01e2
        L_0x00b1:
            r21 = r32
            r11 = r34
            r10 = r2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x01a9
        L_0x00bb:
            r11 = r34
            r10 = r2
            r0 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x01a9
            int r2 = com.google.android.gms.internal.measurement.zzir.zzj(r12, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzjh.zzb(r3)
            r9.putInt(r14, r0, r3)
            goto L_0x0101
        L_0x00d5:
            r11 = r34
            r10 = r2
            r0 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x01a9
            int r2 = com.google.android.gms.internal.measurement.zzir.zzj(r12, r4, r11)
            int r3 = r11.zza
            r9.putInt(r14, r0, r3)
            goto L_0x0101
        L_0x00eb:
            r11 = r34
            r10 = r2
            r0 = r20
            r2 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r2) goto L_0x01a9
            int r2 = com.google.android.gms.internal.measurement.zzir.zza(r12, r4, r11)
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
        L_0x0101:
            r6 = r6 | r22
            r0 = r2
            goto L_0x026c
        L_0x0106:
            r11 = r34
            r10 = r2
            r0 = r20
            r2 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r2) goto L_0x01a9
            com.google.android.gms.internal.measurement.zzlw r2 = r15.zzE(r10)
            int r2 = com.google.android.gms.internal.measurement.zzir.zzd(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x0127
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
            goto L_0x0101
        L_0x0127:
            java.lang.Object r4 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkm.zzg(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x0101
        L_0x0131:
            r11 = r34
            r10 = r2
            r25 = r20
            r0 = 2
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x01a9
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0148
            int r0 = com.google.android.gms.internal.measurement.zzir.zzg(r12, r4, r11)
            goto L_0x014c
        L_0x0148:
            int r0 = com.google.android.gms.internal.measurement.zzir.zzh(r12, r4, r11)
        L_0x014c:
            java.lang.Object r1 = r11.zzc
            r2 = r25
            r9.putObject(r14, r2, r1)
            goto L_0x021d
        L_0x0155:
            r11 = r34
            r10 = r2
            r1 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x01a9
            int r0 = com.google.android.gms.internal.measurement.zzir.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r19 = 0
            int r5 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x016f
            r3 = 1
            goto L_0x0170
        L_0x016f:
            r3 = 0
        L_0x0170:
            com.google.android.gms.internal.measurement.zzmx.zzm(r14, r1, r3)
            goto L_0x021d
        L_0x0175:
            r11 = r34
            r10 = r2
            r1 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x01a9
            int r0 = com.google.android.gms.internal.measurement.zzir.zzb(r12, r4)
            r9.putInt(r14, r1, r0)
            int r0 = r4 + 4
            goto L_0x021d
        L_0x018c:
            r11 = r34
            r10 = r2
            r1 = r20
            r0 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x01a9
            long r19 = com.google.android.gms.internal.measurement.zzir.zzn(r12, r4)
            r0 = r9
            r2 = r1
            r1 = r30
            r8 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x021b
        L_0x01a9:
            r8 = r4
            goto L_0x0220
        L_0x01ac:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x0220
            int r0 = com.google.android.gms.internal.measurement.zzir.zzj(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r4, r1)
            goto L_0x021d
        L_0x01c4:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != 0) goto L_0x0220
            int r8 = com.google.android.gms.internal.measurement.zzir.zzm(r12, r8, r11)
            long r2 = r11.zzb
            r0 = r9
            r1 = r30
            r19 = r2
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x01e2:
            r6 = r6 | r22
            r0 = r8
            goto L_0x026c
        L_0x01e7:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x0220
            int r0 = com.google.android.gms.internal.measurement.zzir.zzb(r12, r8)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmx.zzp(r14, r4, r0)
            int r0 = r8 + 4
            goto L_0x021d
        L_0x0202:
            r11 = r34
            r10 = r2
            r8 = r4
            r4 = r20
            r0 = 1
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            if (r3 != r0) goto L_0x0220
            long r0 = com.google.android.gms.internal.measurement.zzir.zzn(r12, r8)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmx.zzo(r14, r4, r0)
        L_0x021b:
            int r0 = r8 + 8
        L_0x021d:
            r6 = r6 | r22
            goto L_0x026c
        L_0x0220:
            r2 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x0325
        L_0x0229:
            r11 = r34
            r10 = r2
            r2 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            r0 = 27
            if (r8 != r0) goto L_0x027d
            r0 = 2
            if (r3 != r0) goto L_0x0271
            java.lang.Object r0 = r9.getObject(r14, r4)
            com.google.android.gms.internal.measurement.zzkl r0 = (com.google.android.gms.internal.measurement.zzkl) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0258
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0250
            r1 = 10
            goto L_0x0251
        L_0x0250:
            int r1 = r1 + r1
        L_0x0251:
            com.google.android.gms.internal.measurement.zzkl r0 = r0.zzd(r1)
            r9.putObject(r14, r4, r0)
        L_0x0258:
            r5 = r0
            com.google.android.gms.internal.measurement.zzlw r0 = r15.zzE(r10)
            r1 = r17
            r3 = r2
            r2 = r31
            r4 = r33
            r8 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzir.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x026c:
            r2 = r10
            r1 = r21
            goto L_0x0345
        L_0x0271:
            r14 = r2
            r23 = r6
            r15 = r7
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x0303
        L_0x027d:
            r0 = 49
            if (r8 > r0) goto L_0x02d2
            long r0 = (long) r1
            r19 = r0
            r0 = r29
            r1 = r30
            r32 = r2
            r2 = r31
            r22 = r3
            r3 = r32
            r25 = r4
            r4 = r33
            r5 = r17
            r15 = r6
            r6 = r21
            r23 = r15
            r15 = r7
            r7 = r22
            r27 = r8
            r18 = -1
            r8 = r10
            r28 = r9
            r24 = r10
            r9 = r19
            r11 = r27
            r12 = r25
            r14 = r34
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r32
            if (r0 == r14) goto L_0x02d0
        L_0x02b7:
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r7 = r15
            r1 = r21
            r6 = r23
            r2 = r24
            r9 = r28
            r8 = -1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r29
            goto L_0x001a
        L_0x02d0:
            r2 = r0
            goto L_0x0304
        L_0x02d2:
            r14 = r2
            r22 = r3
            r25 = r4
            r23 = r6
            r15 = r7
            r27 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x0308
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x0303
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r24
            r6 = r25
            r8 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x02d0
            goto L_0x02b7
        L_0x0303:
            r2 = r14
        L_0x0304:
            r7 = r15
            r6 = r23
            goto L_0x0325
        L_0x0308:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r17
            r6 = r21
            r10 = r25
            r12 = r24
            r13 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x02d0
            goto L_0x02b7
        L_0x0325:
            com.google.android.gms.internal.measurement.zzmo r4 = zzd(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzir.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r1 = r21
            r2 = r24
            r9 = r28
        L_0x0345:
            r8 = -1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x001a
        L_0x034b:
            r23 = r6
            r15 = r7
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r15 == r1) goto L_0x035f
            long r1 = (long) r15
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x035f:
            r1 = r33
            if (r0 != r1) goto L_0x0364
            return r0
        L_0x0364:
            com.google.android.gms.internal.measurement.zzko r0 = com.google.android.gms.internal.measurement.zzko.zze()
            goto L_0x036a
        L_0x0369:
            throw r0
        L_0x036a:
            goto L_0x0369
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zziq):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x044f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zziq r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzkl r12 = (com.google.android.gms.internal.measurement.zzkl) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.measurement.zzkl r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.measurement.zzlw r1 = r15.zzE(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzir.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.measurement.zzla r12 = (com.google.android.gms.internal.measurement.zzla) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjh.zzc(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzla r12 = (com.google.android.gms.internal.measurement.zzla) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjh.zzc(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjh.zzc(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.measurement.zzkf r12 = (com.google.android.gms.internal.measurement.zzkf) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjh.zzb(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkf r12 = (com.google.android.gms.internal.measurement.zzkf) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjh.zzb(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjh.zzb(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.measurement.zzir.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzir.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.measurement.zzke r1 = (com.google.android.gms.internal.measurement.zzke) r1
            com.google.android.gms.internal.measurement.zzmo r3 = r1.zzc
            com.google.android.gms.internal.measurement.zzmo r4 = com.google.android.gms.internal.measurement.zzmo.zzc()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.measurement.zzki r4 = r15.zzD(r8)
            com.google.android.gms.internal.measurement.zzmn r5 = r0.zzn
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzly.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.measurement.zzmo r3 = (com.google.android.gms.internal.measurement.zzmo) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.measurement.zzjd r4 = com.google.android.gms.internal.measurement.zzjd.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.measurement.zzjd r6 = com.google.android.gms.internal.measurement.zzjd.zzl(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.measurement.zzjd r4 = com.google.android.gms.internal.measurement.zzjd.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.measurement.zzjd r6 = com.google.android.gms.internal.measurement.zzjd.zzl(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzd()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzd()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.measurement.zzlw r1 = r15.zzE(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.measurement.zzir.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x01fa
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f5
            if (r6 != 0) goto L_0x01c2
            r12.add(r1)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkm.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
        L_0x01cc:
            int r4 = r4 + r6
        L_0x01cd:
            if (r4 >= r5) goto L_0x044f
            int r6 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x044f
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f0
            if (r6 != 0) goto L_0x01e5
            r12.add(r1)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkm.zzb
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzd()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzd()
            throw r1
        L_0x01fa:
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0255
            if (r6 != 0) goto L_0x0208
            r12.add(r1)
            goto L_0x021b
        L_0x0208:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zznc.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkm.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
        L_0x021a:
            r4 = r8
        L_0x021b:
            if (r4 >= r5) goto L_0x044f
            int r6 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x044f
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024b
            if (r6 != 0) goto L_0x0233
            r12.add(r1)
            goto L_0x021b
        L_0x0233:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zznc.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkm.zzb
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzc()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzd()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzc()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzd()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.measurement.zzis r12 = (com.google.android.gms.internal.measurement.zzis) r12
            int r2 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0274
            r5 = 1
            goto L_0x0275
        L_0x0274:
            r5 = 0
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzis r12 = (com.google.android.gms.internal.measurement.zzis) r12
            int r4 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = 1
            goto L_0x0294
        L_0x0293:
            r6 = 0
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.measurement.zzkf r12 = (com.google.android.gms.internal.measurement.zzkf) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.measurement.zzir.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkf r12 = (com.google.android.gms.internal.measurement.zzkf) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzb(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.measurement.zzir.zzb(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.measurement.zzla r12 = (com.google.android.gms.internal.measurement.zzla) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.measurement.zzir.zzn(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzla r12 = (com.google.android.gms.internal.measurement.zzla) r12
            long r8 = com.google.android.gms.internal.measurement.zzir.zzn(r17, r18)
            r12.zzg(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.measurement.zzir.zzn(r3, r4)
            r12.zzg(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.measurement.zzir.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.measurement.zzir.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.measurement.zzla r12 = (com.google.android.gms.internal.measurement.zzla) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzla r12 = (com.google.android.gms.internal.measurement.zzla) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.measurement.zzir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.measurement.zzjx r12 = (com.google.android.gms.internal.measurement.zzjx) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.measurement.zzir.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjx r12 = (com.google.android.gms.internal.measurement.zzjx) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.measurement.zzir.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.measurement.zzjn r12 = (com.google.android.gms.internal.measurement.zzjn) r12
            int r1 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.measurement.zzir.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zzf()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjn r12 = (com.google.android.gms.internal.measurement.zzjn) r12
            long r8 = com.google.android.gms.internal.measurement.zzir.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.measurement.zzir.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.measurement.zzir.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzir.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zziq):int");
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzB(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzA(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzS(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzo(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmx.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmx.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmx.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmx.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmx.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmx.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmx.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzmx.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmx.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmx.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmx.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmx.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmx.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzmx.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzmx.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkm.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzmn r0 = r8.zzn
            java.lang.Object r0 = r0.zzc(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.measurement.zzjr r0 = r8.zzo
            r0.zza(r9)
            r9 = 0
            goto L_0x0245
        L_0x0244:
            throw r9
        L_0x0245:
            goto L_0x0244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v89, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0368, code lost:
        if (r0 != r15) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0384, code lost:
        r2 = r0;
        r7 = r18;
        r6 = r25;
        r0 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03b4, code lost:
        if (r0 != r15) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x03d9, code lost:
        if (r0 != r15) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0166, code lost:
        r5 = r6 | r24;
        r0 = r2;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016a, code lost:
        r1 = r11;
        r6 = r25;
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0203, code lost:
        r5 = r6 | r24;
        r2 = r32;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0208, code lost:
        r1 = r11;
        r6 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x020b, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0233, code lost:
        r13 = r4;
        r18 = r11;
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02a9, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02ab, code lost:
        r5 = r6 | r24;
        r2 = r32;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b1, code lost:
        r3 = r13;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02c4, code lost:
        r24 = r32;
        r0 = r34;
        r21 = r6;
        r28 = r10;
        r2 = r11;
        r19 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x041f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zziq r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            r17 = 0
            if (r0 >= r13) goto L_0x0444
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.measurement.zzir.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x003a
            int r3 = r3 / r7
            int r2 = r15.zzx(r0, r3)
            goto L_0x003e
        L_0x003a:
            int r2 = r15.zzw(r0)
        L_0x003e:
            r3 = -1
            if (r2 != r3) goto L_0x0050
            r24 = r0
            r2 = r1
            r7 = r4
            r21 = r5
            r28 = r10
            r0 = r11
            r19 = 0
            r20 = -1
            goto L_0x03dc
        L_0x0050:
            int[] r3 = r15.zzc
            int r20 = r2 + 1
            r7 = r3[r20]
            int r11 = zzA(r7)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r18
            r21 = r1
            long r0 = (long) r0
            r22 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02d1
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x0089
            r18 = r4
            if (r6 == r3) goto L_0x0081
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x0081:
            long r3 = (long) r0
            int r5 = r10.getInt(r14, r3)
            r25 = r0
            goto L_0x008d
        L_0x0089:
            r18 = r4
            r25 = r6
        L_0x008d:
            r6 = r5
            r0 = 5
            switch(r11) {
                case 0: goto L_0x028f;
                case 1: goto L_0x0273;
                case 2: goto L_0x0251;
                case 3: goto L_0x0251;
                case 4: goto L_0x0239;
                case 5: goto L_0x020f;
                case 6: goto L_0x01ea;
                case 7: goto L_0x01c7;
                case 8: goto L_0x01a2;
                case 9: goto L_0x0171;
                case 10: goto L_0x014c;
                case 11: goto L_0x0239;
                case 12: goto L_0x0115;
                case 13: goto L_0x01ea;
                case 14: goto L_0x020f;
                case 15: goto L_0x00f6;
                case 16: goto L_0x00c0;
                default: goto L_0x0092;
            }
        L_0x0092:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r0 = 3
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02c4
            com.google.android.gms.internal.measurement.zzlw r0 = r15.zzE(r13)
            int r1 = r32 << 3
            r4 = r1 | 4
            r1 = r31
            r7 = r2
            r2 = r11
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzir.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x02b6
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r7, r1)
            goto L_0x02ab
        L_0x00c0:
            if (r8 != 0) goto L_0x00ea
            r3 = r21
            int r7 = com.google.android.gms.internal.measurement.zzir.zzm(r12, r3, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjh.zzc(r0)
            r11 = r20
            r0 = r10
            r1 = r30
            r8 = r2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r2 = r22
            r32 = r11
            r11 = r18
            r0.putLong(r1, r2, r4)
            r5 = r6 | r24
            r2 = r32
            r0 = r7
            r3 = r8
            goto L_0x0208
        L_0x00ea:
            r32 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r13 = r2
            r11 = r21
            goto L_0x02c4
        L_0x00f6:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0233
            int r0 = com.google.android.gms.internal.measurement.zzir.zzj(r12, r3, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzjh.zzb(r1)
            r7 = r22
            r10.putInt(r14, r7, r1)
            goto L_0x0203
        L_0x0115:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0233
            int r2 = com.google.android.gms.internal.measurement.zzir.zzj(r12, r3, r9)
            int r3 = r9.zza
            com.google.android.gms.internal.measurement.zzki r5 = r15.zzD(r4)
            if (r5 == 0) goto L_0x0148
            boolean r5 = r5.zza(r3)
            if (r5 == 0) goto L_0x0138
            goto L_0x0148
        L_0x0138:
            com.google.android.gms.internal.measurement.zzmo r0 = zzd(r30)
            long r7 = (long) r3
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0.zzh(r11, r1)
            r0 = r2
            r3 = r4
            r5 = r6
            goto L_0x016a
        L_0x0148:
            r10.putInt(r14, r0, r3)
            goto L_0x0166
        L_0x014c:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r2 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x0233
            int r2 = com.google.android.gms.internal.measurement.zzir.zza(r12, r3, r9)
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
        L_0x0166:
            r5 = r6 | r24
            r0 = r2
            r3 = r4
        L_0x016a:
            r1 = r11
            r6 = r25
            r2 = r32
            goto L_0x020b
        L_0x0171:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r2 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x0233
            com.google.android.gms.internal.measurement.zzlw r2 = r15.zzE(r4)
            int r2 = com.google.android.gms.internal.measurement.zzir.zzd(r2, r12, r3, r13, r9)
            r3 = r6 & r24
            if (r3 != 0) goto L_0x0194
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0166
        L_0x0194:
            java.lang.Object r3 = r10.getObject(r14, r0)
            java.lang.Object r5 = r9.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkm.zzg(r3, r5)
            r10.putObject(r14, r0, r3)
            goto L_0x0166
        L_0x01a2:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r0 = r22
            r2 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x0233
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x01bd
            int r2 = com.google.android.gms.internal.measurement.zzir.zzg(r12, r3, r9)
            goto L_0x01c1
        L_0x01bd:
            int r2 = com.google.android.gms.internal.measurement.zzir.zzh(r12, r3, r9)
        L_0x01c1:
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0166
        L_0x01c7:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r1 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0233
            int r0 = com.google.android.gms.internal.measurement.zzir.zzm(r12, r3, r9)
            long r7 = r9.zzb
            r21 = 0
            int r3 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x01e5
            r3 = 1
            goto L_0x01e6
        L_0x01e5:
            r3 = 0
        L_0x01e6:
            com.google.android.gms.internal.measurement.zzmx.zzm(r14, r1, r3)
            goto L_0x0203
        L_0x01ea:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r1 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0233
            int r0 = com.google.android.gms.internal.measurement.zzir.zzb(r12, r3)
            r10.putInt(r14, r1, r0)
            int r0 = r3 + 4
        L_0x0203:
            r5 = r6 | r24
            r2 = r32
            r3 = r4
        L_0x0208:
            r1 = r11
            r6 = r25
        L_0x020b:
            r11 = r34
            goto L_0x0019
        L_0x020f:
            r4 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r1 = r22
            r0 = 1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0233
            long r7 = com.google.android.gms.internal.measurement.zzir.zzn(r12, r3)
            r0 = r10
            r5 = r3
            r2 = r1
            r1 = r30
            r13 = r4
            r18 = r11
            r11 = r5
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x02a9
        L_0x0233:
            r13 = r4
            r18 = r11
            r11 = r3
            goto L_0x02c4
        L_0x0239:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x02c4
            int r0 = com.google.android.gms.internal.measurement.zzir.zzj(r12, r11, r9)
            int r1 = r9.zza
            r10.putInt(r14, r2, r1)
            goto L_0x02ab
        L_0x0251:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x02c4
            int r7 = com.google.android.gms.internal.measurement.zzir.zzm(r12, r11, r9)
            long r4 = r9.zzb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r5 = r6 | r24
            r2 = r32
            r11 = r34
            r0 = r7
            goto L_0x02b1
        L_0x0273:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02c4
            int r0 = com.google.android.gms.internal.measurement.zzir.zzb(r12, r11)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmx.zzp(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x02ab
        L_0x028f:
            r13 = r2
            r32 = r20
            r11 = r21
            r2 = r22
            r0 = 1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x02c4
            long r0 = com.google.android.gms.internal.measurement.zzir.zzn(r12, r11)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmx.zzo(r14, r2, r0)
        L_0x02a9:
            int r0 = r11 + 8
        L_0x02ab:
            r5 = r6 | r24
            r2 = r32
            r11 = r34
        L_0x02b1:
            r3 = r13
            r1 = r18
            goto L_0x0322
        L_0x02b6:
            java.lang.Object r1 = r10.getObject(r14, r7)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkm.zzg(r1, r2)
            r10.putObject(r14, r7, r1)
            goto L_0x02ab
        L_0x02c4:
            r24 = r32
            r0 = r34
            r21 = r6
            r28 = r10
            r2 = r11
            r19 = r13
            goto L_0x03ba
        L_0x02d1:
            r13 = r2
            r18 = r4
            r3 = r11
            r4 = r20
            r11 = r21
            r1 = r22
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r0 = 27
            if (r3 != r0) goto L_0x0335
            r0 = 2
            if (r8 != r0) goto L_0x0328
            java.lang.Object r0 = r10.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzkl r0 = (com.google.android.gms.internal.measurement.zzkl) r0
            boolean r3 = r0.zzc()
            if (r3 != 0) goto L_0x0304
            int r3 = r0.size()
            if (r3 != 0) goto L_0x02fc
            r3 = 10
            goto L_0x02fd
        L_0x02fc:
            int r3 = r3 + r3
        L_0x02fd:
            com.google.android.gms.internal.measurement.zzkl r0 = r0.zzd(r3)
            r10.putObject(r14, r1, r0)
        L_0x0304:
            r7 = r0
            com.google.android.gms.internal.measurement.zzlw r0 = r15.zzE(r13)
            r1 = r18
            r2 = r31
            r3 = r11
            r8 = r4
            r4 = r33
            r21 = r5
            r5 = r7
            r25 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzir.zze(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r2 = r8
            r3 = r13
            r5 = r21
        L_0x0322:
            r6 = r25
            r13 = r33
            goto L_0x0019
        L_0x0328:
            r21 = r5
            r25 = r6
            r24 = r4
            r28 = r10
            r15 = r11
            r19 = r13
            goto L_0x03b7
        L_0x0335:
            r21 = r5
            r25 = r6
            r5 = r4
            r0 = 49
            if (r3 > r0) goto L_0x038d
            long r6 = (long) r7
            r0 = r29
            r22 = r1
            r1 = r30
            r2 = r31
            r4 = r3
            r3 = r11
            r32 = r4
            r4 = r33
            r24 = r5
            r5 = r18
            r26 = r6
            r6 = r24
            r7 = r8
            r8 = r13
            r28 = r10
            r9 = r26
            r15 = r11
            r11 = r32
            r19 = r13
            r12 = r22
            r14 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0384
        L_0x036a:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r18
            r3 = r19
            r5 = r21
            r2 = r24
            r6 = r25
        L_0x0380:
            r10 = r28
            goto L_0x0019
        L_0x0384:
            r2 = r0
            r7 = r18
            r6 = r25
            r0 = r34
            goto L_0x03dc
        L_0x038d:
            r22 = r1
            r32 = r3
            r24 = r5
            r28 = r10
            r15 = r11
            r19 = r13
            r0 = 50
            r9 = r32
            if (r9 != r0) goto L_0x03bf
            r0 = 2
            if (r8 != r0) goto L_0x03b7
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r22
            r8 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0384
            goto L_0x036a
        L_0x03b7:
            r0 = r34
            r2 = r15
        L_0x03ba:
            r7 = r18
            r6 = r25
            goto L_0x03dc
        L_0x03bf:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r24
            r10 = r7
            r7 = r8
            r8 = r10
            r10 = r22
            r12 = r19
            r13 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0384
            goto L_0x036a
        L_0x03dc:
            if (r7 != r0) goto L_0x03eb
            if (r0 == 0) goto L_0x03eb
            r8 = r29
            r12 = r30
            r9 = r0
            r0 = r2
            r1 = r7
            r5 = r21
            goto L_0x044d
        L_0x03eb:
            r8 = r29
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x041f
            r10 = r35
            com.google.android.gms.internal.measurement.zzjq r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzjq r1 = com.google.android.gms.internal.measurement.zzjq.zza
            if (r0 == r1) goto L_0x041c
            com.google.android.gms.internal.measurement.zzll r1 = r8.zzg
            r11 = r24
            com.google.android.gms.internal.measurement.zzkc r0 = r0.zzb(r1, r11)
            if (r0 != 0) goto L_0x0416
            com.google.android.gms.internal.measurement.zzmo r4 = zzd(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzir.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r30
            goto L_0x0434
        L_0x0416:
            r12 = r30
            r0 = r12
            com.google.android.gms.internal.measurement.zzkb r0 = (com.google.android.gms.internal.measurement.zzkb) r0
            throw r17
        L_0x041c:
            r12 = r30
            goto L_0x0423
        L_0x041f:
            r12 = r30
            r10 = r35
        L_0x0423:
            r11 = r24
            com.google.android.gms.internal.measurement.zzmo r4 = zzd(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzir.zzi(r0, r1, r2, r3, r4, r5)
        L_0x0434:
            r13 = r33
            r1 = r7
            r15 = r8
            r2 = r11
            r14 = r12
            r3 = r19
            r5 = r21
            r12 = r31
            r11 = r9
            r9 = r10
            goto L_0x0380
        L_0x0444:
            r21 = r5
            r25 = r6
            r28 = r10
            r9 = r11
            r12 = r14
            r8 = r15
        L_0x044d:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x0458
            long r3 = (long) r6
            r6 = r28
            r6.putInt(r12, r3, r5)
        L_0x0458:
            int r3 = r8.zzk
        L_0x045a:
            int r4 = r8.zzl
            if (r3 >= r4) goto L_0x0485
            int[] r4 = r8.zzj
            r4 = r4[r3]
            int[] r5 = r8.zzc
            r5 = r5[r4]
            int r5 = r8.zzB(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzmx.zzf(r12, r5)
            if (r5 != 0) goto L_0x0473
            goto L_0x0479
        L_0x0473:
            com.google.android.gms.internal.measurement.zzki r6 = r8.zzD(r4)
            if (r6 != 0) goto L_0x047c
        L_0x0479:
            int r3 = r3 + 1
            goto L_0x045a
        L_0x047c:
            com.google.android.gms.internal.measurement.zzlf r5 = (com.google.android.gms.internal.measurement.zzlf) r5
            java.lang.Object r0 = r8.zzF(r4)
            com.google.android.gms.internal.measurement.zzle r0 = (com.google.android.gms.internal.measurement.zzle) r0
            throw r17
        L_0x0485:
            if (r9 != 0) goto L_0x0491
            r2 = r33
            if (r0 != r2) goto L_0x048c
            goto L_0x0497
        L_0x048c:
            com.google.android.gms.internal.measurement.zzko r0 = com.google.android.gms.internal.measurement.zzko.zze()
            throw r0
        L_0x0491:
            r2 = r33
            if (r0 > r2) goto L_0x0498
            if (r1 != r9) goto L_0x0498
        L_0x0497:
            return r0
        L_0x0498:
            com.google.android.gms.internal.measurement.zzko r0 = com.google.android.gms.internal.measurement.zzko.zze()
            goto L_0x049e
        L_0x049d:
            throw r0
        L_0x049e:
            goto L_0x049d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zziq):int");
    }

    public final Object zze() {
        return ((zzke) this.zzg).zzl(4, (Object) null, (Object) null);
    }

    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long zzB = (long) (zzB(this.zzj[i2]) & 1048575);
            Object zzf2 = zzmx.zzf(obj, zzB);
            if (zzf2 != null) {
                ((zzlf) zzf2).zzc();
                zzmx.zzs(obj, zzB, zzf2);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, (long) this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zziq zziq) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zziq);
        } else {
            zzc(obj, bArr, i, i2, 0, zziq);
        }
    }

    public final void zzi(Object obj, zznf zznf) throws IOException {
        if (!this.zzi) {
            zzL(obj, zznf);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzf(i2, zzmx.zza(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzo(i2, zzmx.zzb(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzt(i2, zzmx.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzJ(i2, zzmx.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzr(i2, zzmx.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzm(i2, zzmx.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzk(i2, zzmx.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzb(i2, zzmx.zzw(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zzT(i2, zzmx.zzf(obj, (long) (zzB & 1048575)), zznf);
                            break;
                        }
                    case 9:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzv(i2, zzmx.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 10:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzd(i2, (zzjd) zzmx.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzH(i2, zzmx.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzi(i2, zzmx.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzw(i2, zzmx.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzy(i2, zzmx.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzA(i2, zzmx.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzC(i2, zzmx.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznf.zzq(i2, zzmx.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 18:
                        zzly.zzJ(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 19:
                        zzly.zzN(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 20:
                        zzly.zzQ(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 21:
                        zzly.zzY(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 22:
                        zzly.zzP(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 23:
                        zzly.zzM(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 24:
                        zzly.zzL(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 25:
                        zzly.zzH(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 26:
                        zzly.zzW(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf);
                        break;
                    case 27:
                        zzly.zzR(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, zzE(i));
                        break;
                    case 28:
                        zzly.zzI(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf);
                        break;
                    case 29:
                        zzly.zzX(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 30:
                        zzly.zzK(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 31:
                        zzly.zzS(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 32:
                        zzly.zzT(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 33:
                        zzly.zzU(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 34:
                        zzly.zzV(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, false);
                        break;
                    case 35:
                        zzly.zzJ(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 36:
                        zzly.zzN(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 37:
                        zzly.zzQ(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 38:
                        zzly.zzY(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 39:
                        zzly.zzP(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 40:
                        zzly.zzM(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 41:
                        zzly.zzL(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 42:
                        zzly.zzH(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 43:
                        zzly.zzX(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 44:
                        zzly.zzK(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 45:
                        zzly.zzS(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 46:
                        zzly.zzT(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 47:
                        zzly.zzU(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 48:
                        zzly.zzV(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, true);
                        break;
                    case 49:
                        zzly.zzO(i2, (List) zzmx.zzf(obj, (long) (zzB & 1048575)), zznf, zzE(i));
                        break;
                    case 50:
                        zzM(zznf, i2, zzmx.zzf(obj, (long) (zzB & 1048575)), i);
                        break;
                    case 51:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzf(i2, zzn(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzo(i2, zzo(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzt(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzJ(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzr(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzm(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzk(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzb(i2, zzS(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zzT(i2, zzmx.zzf(obj, (long) (zzB & 1048575)), zznf);
                            break;
                        }
                    case 60:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzv(i2, zzmx.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 61:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzd(i2, (zzjd) zzmx.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzH(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzi(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzw(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzy(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzA(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzC(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznf.zzq(i2, zzmx.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                }
            }
            zzmn zzmn = this.zzn;
            zzmn.zzi(zzmn.zzc(obj), zznf);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (zzB & 1048575);
            switch (zzA(zzB)) {
                case 0:
                    if (zzN(obj, obj2, i) && Double.doubleToLongBits(zzmx.zza(obj, j)) == Double.doubleToLongBits(zzmx.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzN(obj, obj2, i) && Float.floatToIntBits(zzmx.zzb(obj, j)) == Float.floatToIntBits(zzmx.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzN(obj, obj2, i) && zzmx.zzw(obj, j) == zzmx.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzN(obj, obj2, i) && zzmx.zzc(obj, j) == zzmx.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzN(obj, obj2, i) && zzmx.zzd(obj, j) == zzmx.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzN(obj, obj2, i) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j));
                    break;
                case 50:
                    z = zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzy = (long) (zzy(i) & 1048575);
                    if (zzmx.zzc(obj, zzy) == zzmx.zzc(obj2, zzy) && zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzB) != 0 && !zzP(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzR(obj2, i7, i6) && !zzQ(obj2, zzB, zzE(i6))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzlf) zzmx.zzf(obj2, (long) (zzB & 1048575))).isEmpty()) {
                            zzle zzle = (zzle) zzF(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzmx.zzf(obj2, (long) (zzB & 1048575));
                if (!list.isEmpty()) {
                    zzlw zzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzE.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzP(obj, i6, i2, i, i10) && !zzQ(obj2, zzB, zzE(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (1048575 & zzB);
            int i2 = this.zzc[i];
            switch (zzA(zzB)) {
                case 0:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzo(obj, j, zzmx.zza(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 1:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzp(obj, j, zzmx.zzb(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 2:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 3:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 4:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 5:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 6:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 7:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzm(obj, j, zzmx.zzw(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 8:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 11:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 12:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 13:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 14:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 15:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 16:
                    if (!zzO(obj2, i)) {
                        break;
                    } else {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzly.zzaa(this.zzq, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzR(obj2, i2, i)) {
                        break;
                    } else {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzR(obj2, i2, i)) {
                        break;
                    } else {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzly.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzly.zzE(this.zzo, obj, obj2);
        }
    }
}
