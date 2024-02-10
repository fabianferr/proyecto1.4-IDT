package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzts<T> implements zzua<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzvb.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final zztp zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int[] zzh;
    private final int zzi;
    private final zztd zzj;
    private final zzur zzk;
    private final zzrx zzl;
    private final zztu zzm;
    private final zztk zzn;

    private zzts(int[] iArr, Object[] objArr, int i, int i2, zztp zztp, boolean z, boolean z2, int[] iArr2, int i3, int i4, zztu zztu, zztd zztd, zzur zzur, zzrx zzrx, zztk zztk) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzg = z;
        boolean z3 = false;
        if (zzrx != null && zzrx.zzc(zztp)) {
            z3 = true;
        }
        this.zzf = z3;
        this.zzh = iArr2;
        this.zzi = i3;
        this.zzm = zztu;
        this.zzj = zztd;
        this.zzk = zzur;
        this.zzl = zzrx;
        this.zze = zztp;
        this.zzn = zztk;
    }

    private final boolean zzA(Object obj, int i) {
        int zzn2 = zzn(i);
        long j = (long) (zzn2 & 1048575);
        if (j == 1048575) {
            int zzp = zzp(i);
            long j2 = (long) (zzp & 1048575);
            switch (zzo(zzp)) {
                case 0:
                    return Double.doubleToRawLongBits(zzvb.zza(obj, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzvb.zzb(obj, j2)) != 0;
                case 2:
                    return zzvb.zzd(obj, j2) != 0;
                case 3:
                    return zzvb.zzd(obj, j2) != 0;
                case 4:
                    return zzvb.zzc(obj, j2) != 0;
                case 5:
                    return zzvb.zzd(obj, j2) != 0;
                case 6:
                    return zzvb.zzc(obj, j2) != 0;
                case 7:
                    return zzvb.zzw(obj, j2);
                case 8:
                    Object zzf2 = zzvb.zzf(obj, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzrm) {
                        return !zzrm.zzb.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzvb.zzf(obj, j2) != null;
                case 10:
                    return !zzrm.zzb.equals(zzvb.zzf(obj, j2));
                case 11:
                    return zzvb.zzc(obj, j2) != 0;
                case 12:
                    return zzvb.zzc(obj, j2) != 0;
                case 13:
                    return zzvb.zzc(obj, j2) != 0;
                case 14:
                    return zzvb.zzd(obj, j2) != 0;
                case 15:
                    return zzvb.zzc(obj, j2) != 0;
                case 16:
                    return zzvb.zzd(obj, j2) != 0;
                case 17:
                    return zzvb.zzf(obj, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzvb.zzc(obj, j) & (1 << (zzn2 >>> 20))) != 0;
        }
    }

    private final boolean zzB(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzA(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzC(Object obj, int i, zzua zzua) {
        return zzua.zzh(zzvb.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzD(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzsh) {
            return ((zzsh) obj).zzJ();
        }
        return true;
    }

    private final boolean zzE(Object obj, int i, int i2) {
        return zzvb.zzc(obj, (long) (zzn(i2) & 1048575)) == i;
    }

    private static boolean zzF(Object obj, long j) {
        return ((Boolean) zzvb.zzf(obj, j)).booleanValue();
    }

    private static final void zzG(int i, Object obj, zzvi zzvi) throws IOException {
        if (obj instanceof String) {
            zzvi.zzD(i, (String) obj);
        } else {
            zzvi.zzd(i, (zzrm) obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x036e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.cast.zzts zzi(java.lang.Class r31, com.google.android.gms.internal.cast.zztm r32, com.google.android.gms.internal.cast.zztu r33, com.google.android.gms.internal.cast.zztd r34, com.google.android.gms.internal.cast.zzur r35, com.google.android.gms.internal.cast.zzrx r36, com.google.android.gms.internal.cast.zztk r37) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof com.google.android.gms.internal.cast.zztz
            if (r1 == 0) goto L_0x03d8
            com.google.android.gms.internal.cast.zztz r0 = (com.google.android.gms.internal.cast.zztz) r0
            int r1 = r0.zzc()
            java.lang.String r2 = r0.zzd()
            int r3 = r2.length()
            r4 = 0
            char r5 = r2.charAt(r4)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0029
            r5 = 1
        L_0x001f:
            int r8 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x002a
            r5 = r8
            goto L_0x001f
        L_0x0029:
            r8 = 1
        L_0x002a:
            int r5 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0049
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0036:
            int r11 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x0046
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r10
            r8 = r8 | r5
            int r10 = r10 + 13
            r5 = r11
            goto L_0x0036
        L_0x0046:
            int r5 = r5 << r10
            r8 = r8 | r5
            r5 = r11
        L_0x0049:
            if (r8 != 0) goto L_0x0058
            int[] r8 = zza
            r18 = r8
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r19 = 0
            goto L_0x016e
        L_0x0058:
            int r8 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x0077
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0064:
            int r11 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0074
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r5 = r5 | r8
            int r10 = r10 + 13
            r8 = r11
            goto L_0x0064
        L_0x0074:
            int r8 = r8 << r10
            r5 = r5 | r8
            r8 = r11
        L_0x0077:
            int r10 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0096
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x0083:
            int r12 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r6) goto L_0x0093
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r8 = r8 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x0083
        L_0x0093:
            int r10 = r10 << r11
            r8 = r8 | r10
            r10 = r12
        L_0x0096:
            int r11 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r6) goto L_0x00b5
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a2:
            int r13 = r11 + 1
            char r11 = r2.charAt(r11)
            if (r11 < r6) goto L_0x00b2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00a2
        L_0x00b2:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00b5:
            int r12 = r11 + 1
            char r11 = r2.charAt(r11)
            if (r11 < r6) goto L_0x00d4
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c1:
            int r14 = r12 + 1
            char r12 = r2.charAt(r12)
            if (r12 < r6) goto L_0x00d1
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00c1
        L_0x00d1:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00d4:
            int r13 = r12 + 1
            char r12 = r2.charAt(r12)
            if (r12 < r6) goto L_0x00f3
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e0:
            int r15 = r13 + 1
            char r13 = r2.charAt(r13)
            if (r13 < r6) goto L_0x00f0
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00e0
        L_0x00f0:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f3:
            int r14 = r13 + 1
            char r13 = r2.charAt(r13)
            if (r13 < r6) goto L_0x0114
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00ff:
            int r16 = r14 + 1
            char r14 = r2.charAt(r14)
            if (r14 < r6) goto L_0x0110
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x00ff
        L_0x0110:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0114:
            int r15 = r14 + 1
            char r14 = r2.charAt(r14)
            if (r14 < r6) goto L_0x0137
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0120:
            int r17 = r15 + 1
            char r15 = r2.charAt(r15)
            if (r15 < r6) goto L_0x0132
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0120
        L_0x0132:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0137:
            int r16 = r15 + 1
            char r15 = r2.charAt(r15)
            if (r15 < r6) goto L_0x015c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r4 = r16
            r16 = 13
        L_0x0145:
            int r17 = r4 + 1
            char r4 = r2.charAt(r4)
            if (r4 < r6) goto L_0x0157
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r16
            r15 = r15 | r4
            int r16 = r16 + 13
            r4 = r17
            goto L_0x0145
        L_0x0157:
            int r4 = r4 << r16
            r15 = r15 | r4
            r16 = r17
        L_0x015c:
            int r4 = r15 + r13
            int r4 = r4 + r14
            int r14 = r5 + r5
            int r14 = r14 + r8
            int[] r8 = new int[r4]
            r4 = r5
            r18 = r8
            r8 = r10
            r10 = r14
            r19 = r15
            r5 = r16
            r14 = r11
        L_0x016e:
            sun.misc.Unsafe r11 = zzb
            java.lang.Object[] r15 = r0.zze()
            com.google.android.gms.internal.cast.zztp r16 = r0.zza()
            java.lang.Class r9 = r16.getClass()
            int r20 = r19 + r13
            int r13 = r12 + r12
            int r12 = r12 * 3
            int[] r12 = new int[r12]
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r21 = r19
            r22 = r20
            r16 = 0
            r17 = 0
        L_0x018e:
            r7 = 2
            if (r1 != r7) goto L_0x0193
            r7 = 1
            goto L_0x0194
        L_0x0193:
            r7 = 0
        L_0x0194:
            if (r5 >= r3) goto L_0x03b7
            int r24 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x01c3
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r6 = r24
            r24 = 13
        L_0x01a4:
            int r26 = r6 + 1
            char r6 = r2.charAt(r6)
            r27 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r1) goto L_0x01bd
            r1 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r5 = r5 | r1
            int r24 = r24 + 13
            r6 = r26
            r1 = r27
            goto L_0x01a4
        L_0x01bd:
            int r1 = r6 << r24
            r5 = r5 | r1
            r1 = r26
            goto L_0x01c7
        L_0x01c3:
            r27 = r1
            r1 = r24
        L_0x01c7:
            int r6 = r1 + 1
            char r1 = r2.charAt(r1)
            r24 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r3) goto L_0x01f2
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x01d8:
            int r28 = r6 + 1
            char r6 = r2.charAt(r6)
            if (r6 < r3) goto L_0x01ed
            r3 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r26
            r1 = r1 | r3
            int r26 = r26 + 13
            r6 = r28
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01d8
        L_0x01ed:
            int r3 = r6 << r26
            r1 = r1 | r3
            r6 = r28
        L_0x01f2:
            r3 = r1 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x01fc
            int r3 = r16 + 1
            r18[r16] = r17
            r16 = r3
        L_0x01fc:
            r3 = r1 & 255(0xff, float:3.57E-43)
            r26 = r14
            r14 = 51
            if (r3 < r14) goto L_0x029b
            int r14 = r6 + 1
            char r6 = r2.charAt(r6)
            r28 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r14) goto L_0x0236
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r14 = r28
            r28 = 13
        L_0x0217:
            int r29 = r14 + 1
            char r14 = r2.charAt(r14)
            r30 = r8
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r8) goto L_0x0230
            r8 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r28
            r6 = r6 | r8
            int r28 = r28 + 13
            r14 = r29
            r8 = r30
            goto L_0x0217
        L_0x0230:
            int r8 = r14 << r28
            r6 = r6 | r8
            r14 = r29
            goto L_0x023a
        L_0x0236:
            r30 = r8
            r14 = r28
        L_0x023a:
            int r8 = r3 + -51
            r28 = r14
            r14 = 9
            if (r8 == r14) goto L_0x0259
            r14 = 17
            if (r8 != r14) goto L_0x0247
            goto L_0x0259
        L_0x0247:
            r14 = 12
            if (r8 != r14) goto L_0x0265
            if (r7 != 0) goto L_0x0265
            int r7 = r17 / 3
            int r7 = r7 + r7
            r8 = 1
            int r7 = r7 + r8
            int r8 = r10 + 1
            r10 = r15[r10]
            r13[r7] = r10
            goto L_0x0264
        L_0x0259:
            int r7 = r17 / 3
            int r7 = r7 + r7
            r8 = 1
            int r7 = r7 + r8
            int r8 = r10 + 1
            r10 = r15[r10]
            r13[r7] = r10
        L_0x0264:
            r10 = r8
        L_0x0265:
            int r6 = r6 + r6
            r7 = r15[r6]
            boolean r8 = r7 instanceof java.lang.reflect.Field
            if (r8 == 0) goto L_0x026f
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0277
        L_0x026f:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzt(r9, r7)
            r15[r6] = r7
        L_0x0277:
            long r7 = r11.objectFieldOffset(r7)
            int r8 = (int) r7
            int r6 = r6 + 1
            r7 = r15[r6]
            boolean r14 = r7 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0287
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x028f
        L_0x0287:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzt(r9, r7)
            r15[r6] = r7
        L_0x028f:
            long r6 = r11.objectFieldOffset(r7)
            int r7 = (int) r6
            r23 = r15
            r25 = r28
            r6 = 0
            goto L_0x0382
        L_0x029b:
            r30 = r8
            int r8 = r10 + 1
            r10 = r15[r10]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zzt(r9, r10)
            r14 = 9
            if (r3 == r14) goto L_0x030b
            r14 = 17
            if (r3 != r14) goto L_0x02b0
            goto L_0x030b
        L_0x02b0:
            r14 = 27
            if (r3 == r14) goto L_0x02fd
            r14 = 49
            if (r3 != r14) goto L_0x02b9
            goto L_0x02fd
        L_0x02b9:
            r14 = 12
            if (r3 == r14) goto L_0x02ed
            r14 = 30
            if (r3 == r14) goto L_0x02ed
            r14 = 44
            if (r3 != r14) goto L_0x02c6
            goto L_0x02ed
        L_0x02c6:
            r7 = 50
            if (r3 != r7) goto L_0x02fb
            int r7 = r21 + 1
            r18[r21] = r17
            int r14 = r17 / 3
            int r21 = r8 + 1
            r8 = r15[r8]
            int r14 = r14 + r14
            r13[r14] = r8
            r8 = r1 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02e6
            int r14 = r14 + 1
            int r8 = r21 + 1
            r21 = r15[r21]
            r13[r14] = r21
            r21 = r7
            goto L_0x0316
        L_0x02e6:
            r23 = r15
            r8 = r21
            r21 = r7
            goto L_0x0318
        L_0x02ed:
            if (r7 != 0) goto L_0x02fb
            int r7 = r17 / 3
            int r7 = r7 + r7
            r14 = 1
            int r7 = r7 + r14
            int r23 = r8 + 1
            r8 = r15[r8]
            r13[r7] = r8
            goto L_0x0308
        L_0x02fb:
            r14 = 1
            goto L_0x0316
        L_0x02fd:
            r14 = 1
            int r7 = r17 / 3
            int r7 = r7 + r7
            int r7 = r7 + r14
            int r23 = r8 + 1
            r8 = r15[r8]
            r13[r7] = r8
        L_0x0308:
            r8 = r23
            goto L_0x0316
        L_0x030b:
            r14 = 1
            int r7 = r17 / 3
            int r7 = r7 + r7
            int r7 = r7 + r14
            java.lang.Class r23 = r10.getType()
            r13[r7] = r23
        L_0x0316:
            r23 = r15
        L_0x0318:
            long r14 = r11.objectFieldOffset(r10)
            int r7 = (int) r14
            r10 = r1 & 4096(0x1000, float:5.74E-42)
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r15 = 4096(0x1000, float:5.74E-42)
            if (r10 != r15) goto L_0x036e
            r10 = 17
            if (r3 > r10) goto L_0x036e
            int r10 = r6 + 1
            char r6 = r2.charAt(r6)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r15) goto L_0x034d
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x0339:
            int r25 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r15) goto L_0x034a
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r14
            r6 = r6 | r10
            int r14 = r14 + 13
            r10 = r25
            goto L_0x0339
        L_0x034a:
            int r10 = r10 << r14
            r6 = r6 | r10
            goto L_0x034f
        L_0x034d:
            r25 = r10
        L_0x034f:
            int r10 = r4 + r4
            int r14 = r6 / 32
            int r10 = r10 + r14
            r14 = r23[r10]
            boolean r15 = r14 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x035d
            java.lang.reflect.Field r14 = (java.lang.reflect.Field) r14
            goto L_0x0365
        L_0x035d:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.reflect.Field r14 = zzt(r9, r14)
            r23[r10] = r14
        L_0x0365:
            long r14 = r11.objectFieldOffset(r14)
            int r10 = (int) r14
            int r6 = r6 % 32
            r14 = r10
            goto L_0x0371
        L_0x036e:
            r25 = r6
            r6 = 0
        L_0x0371:
            r10 = 18
            if (r3 < r10) goto L_0x037f
            r10 = 49
            if (r3 > r10) goto L_0x037f
            int r10 = r22 + 1
            r18[r22] = r7
            r22 = r10
        L_0x037f:
            r10 = r8
            r8 = r7
            r7 = r14
        L_0x0382:
            int r14 = r17 + 1
            r12[r17] = r5
            int r5 = r14 + 1
            r15 = r1 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x038f
            r15 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0390
        L_0x038f:
            r15 = 0
        L_0x0390:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0397
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0398
        L_0x0397:
            r1 = 0
        L_0x0398:
            int r3 = r3 << 20
            r1 = r1 | r15
            r1 = r1 | r3
            r1 = r1 | r8
            r12[r14] = r1
            int r17 = r5 + 1
            int r1 = r6 << 20
            r1 = r1 | r7
            r12[r5] = r1
            r15 = r23
            r3 = r24
            r5 = r25
            r14 = r26
            r1 = r27
            r8 = r30
            r6 = 55296(0xd800, float:7.7486E-41)
            goto L_0x018e
        L_0x03b7:
            r30 = r8
            r26 = r14
            com.google.android.gms.internal.cast.zzts r1 = new com.google.android.gms.internal.cast.zzts
            com.google.android.gms.internal.cast.zztp r15 = r0.zza()
            r17 = 0
            r10 = r1
            r11 = r12
            r12 = r13
            r13 = r30
            r16 = r7
            r21 = r33
            r22 = r34
            r23 = r35
            r24 = r36
            r25 = r37
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        L_0x03d8:
            com.google.android.gms.internal.cast.zzuo r0 = (com.google.android.gms.internal.cast.zzuo) r0
            r0 = 0
            goto L_0x03dd
        L_0x03dc:
            throw r0
        L_0x03dd:
            goto L_0x03dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzi(java.lang.Class, com.google.android.gms.internal.cast.zztm, com.google.android.gms.internal.cast.zztu, com.google.android.gms.internal.cast.zztd, com.google.android.gms.internal.cast.zzur, com.google.android.gms.internal.cast.zzrx, com.google.android.gms.internal.cast.zztk):com.google.android.gms.internal.cast.zzts");
    }

    private static double zzj(Object obj, long j) {
        return ((Double) zzvb.zzf(obj, j)).doubleValue();
    }

    private static float zzk(Object obj, long j) {
        return ((Float) zzvb.zzf(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x032e, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x039f, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04ad, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0560, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x056f, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0573, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f3, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b1, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c1, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzl(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = zzb
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 0
        L_0x000e:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x057a
            int r9 = r15.zzp(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzo(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0037
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r4
            int r10 = r10 >>> 20
            if (r13 == r7) goto L_0x0034
            long r7 = (long) r13
            int r8 = r2.getInt(r1, r7)
            r7 = r13
        L_0x0034:
            int r10 = r14 << r10
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r9 = r9 & r4
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x0564;
                case 1: goto L_0x0555;
                case 2: goto L_0x053f;
                case 3: goto L_0x052b;
                case 4: goto L_0x0517;
                case 5: goto L_0x050b;
                case 6: goto L_0x04ff;
                case 7: goto L_0x04f1;
                case 8: goto L_0x04c3;
                case 9: goto L_0x04b0;
                case 10: goto L_0x0491;
                case 11: goto L_0x047c;
                case 12: goto L_0x0467;
                case 13: goto L_0x045a;
                case 14: goto L_0x044d;
                case 15: goto L_0x0433;
                case 16: goto L_0x0419;
                case 17: goto L_0x0405;
                case 18: goto L_0x03f7;
                case 19: goto L_0x03eb;
                case 20: goto L_0x03df;
                case 21: goto L_0x03d3;
                case 22: goto L_0x03c7;
                case 23: goto L_0x03bb;
                case 24: goto L_0x03af;
                case 25: goto L_0x03a3;
                case 26: goto L_0x0395;
                case 27: goto L_0x0386;
                case 28: goto L_0x037b;
                case 29: goto L_0x036f;
                case 30: goto L_0x0363;
                case 31: goto L_0x0357;
                case 32: goto L_0x034b;
                case 33: goto L_0x033f;
                case 34: goto L_0x0333;
                case 35: goto L_0x0318;
                case 36: goto L_0x0301;
                case 37: goto L_0x02ea;
                case 38: goto L_0x02d3;
                case 39: goto L_0x02bc;
                case 40: goto L_0x02a4;
                case 41: goto L_0x028c;
                case 42: goto L_0x0272;
                case 43: goto L_0x025a;
                case 44: goto L_0x0242;
                case 45: goto L_0x022a;
                case 46: goto L_0x0212;
                case 47: goto L_0x01fa;
                case 48: goto L_0x01e2;
                case 49: goto L_0x01d2;
                case 50: goto L_0x01c5;
                case 51: goto L_0x01b5;
                case 52: goto L_0x01a5;
                case 53: goto L_0x018f;
                case 54: goto L_0x0179;
                case 55: goto L_0x0163;
                case 56: goto L_0x0156;
                case 57: goto L_0x0149;
                case 58: goto L_0x013a;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f6;
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
            goto L_0x03a0
        L_0x0041:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.cast.zztp r3 = (com.google.android.gms.internal.cast.zztp) r3
            com.google.android.gms.internal.cast.zzua r4 = r15.zzr(r5)
            int r3 = com.google.android.gms.internal.cast.zzru.zzt(r11, r3, r4)
            goto L_0x039f
        L_0x0057:
            boolean r10 = r15.zzE(r1, r11, r5)
            if (r10 == 0) goto L_0x03a0
            long r3 = zzq(r1, r3)
            int r10 = r11 << 3
            long r11 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r10)
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.cast.zzru.zzy(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x03a0
        L_0x0073:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzm(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x032f
        L_0x008e:
            boolean r3 = r15.zzE(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x01c1
        L_0x009c:
            boolean r3 = r15.zzE(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x01b1
        L_0x00aa:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzm(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzu(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032f
        L_0x00c0:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzm(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032f
        L_0x00d6:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.cast.zzrm r3 = (com.google.android.gms.internal.cast.zzrm) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r4)
        L_0x00f3:
            int r3 = r3 + r9
            goto L_0x039f
        L_0x00f6:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.cast.zzua r4 = r15.zzr(r5)
            int r3 = com.google.android.gms.internal.cast.zzuc.zzn(r11, r3, r4)
            goto L_0x039f
        L_0x010a:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.cast.zzrm
            if (r4 == 0) goto L_0x012c
            com.google.android.gms.internal.cast.zzrm r3 = (com.google.android.gms.internal.cast.zzrm) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x00f3
        L_0x012c:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzw(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032f
        L_0x013a:
            boolean r3 = r15.zzE(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r3 = r3 + r14
            goto L_0x039f
        L_0x0149:
            boolean r3 = r15.zzE(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x01b1
        L_0x0156:
            boolean r3 = r15.zzE(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x01c1
        L_0x0163:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            int r3 = zzm(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzu(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032f
        L_0x0179:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            long r3 = zzq(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzy(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r9)
            goto L_0x032f
        L_0x018f:
            boolean r9 = r15.zzE(r1, r11, r5)
            if (r9 == 0) goto L_0x03a0
            long r3 = zzq(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzy(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r9)
            goto L_0x032f
        L_0x01a5:
            boolean r3 = r15.zzE(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
        L_0x01b1:
            int r3 = r3 + 4
            goto L_0x039f
        L_0x01b5:
            boolean r3 = r15.zzE(r1, r11, r5)
            if (r3 == 0) goto L_0x03a0
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
        L_0x01c1:
            int r3 = r3 + 8
            goto L_0x039f
        L_0x01c5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r15.zzs(r5)
            com.google.android.gms.internal.cast.zztk.zza(r11, r3, r4)
            goto L_0x03a0
        L_0x01d2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.cast.zzua r4 = r15.zzr(r5)
            int r3 = com.google.android.gms.internal.cast.zzuc.zzi(r11, r3, r4)
            goto L_0x039f
        L_0x01e2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzs(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x01fa:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzq(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x0212:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzh(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x022a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzf(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x0242:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzd(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x025a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzv(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x0272:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r4 = com.google.android.gms.internal.cast.zzuc.zza
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x028c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzf(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x02a4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzh(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x02bc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzk(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x02d3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzx(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x02ea:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzm(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x0301:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzf(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x032e
        L_0x0318:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzh(r3)
            if (r3 <= 0) goto L_0x03a0
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
        L_0x032e:
            int r4 = r4 + r9
        L_0x032f:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x03a0
        L_0x0333:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.cast.zzuc.zzr(r11, r3, r9)
            goto L_0x039f
        L_0x033f:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzp(r11, r3, r9)
            goto L_0x039f
        L_0x034b:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzg(r11, r3, r9)
            goto L_0x039f
        L_0x0357:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zze(r11, r3, r9)
            goto L_0x039f
        L_0x0363:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzc(r11, r3, r9)
            goto L_0x039f
        L_0x036f:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzu(r11, r3, r9)
            goto L_0x039f
        L_0x037b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzb(r11, r3)
            goto L_0x039f
        L_0x0386:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.cast.zzua r4 = r15.zzr(r5)
            int r3 = com.google.android.gms.internal.cast.zzuc.zzo(r11, r3, r4)
            goto L_0x039f
        L_0x0395:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzt(r11, r3)
        L_0x039f:
            int r6 = r6 + r3
        L_0x03a0:
            r12 = 0
            goto L_0x0573
        L_0x03a3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.cast.zzuc.zza(r11, r3, r12)
            goto L_0x0402
        L_0x03af:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zze(r11, r3, r12)
            goto L_0x0402
        L_0x03bb:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzg(r11, r3, r12)
            goto L_0x0402
        L_0x03c7:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzj(r11, r3, r12)
            goto L_0x0402
        L_0x03d3:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzw(r11, r3, r12)
            goto L_0x0402
        L_0x03df:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzl(r11, r3, r12)
            goto L_0x0402
        L_0x03eb:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zze(r11, r3, r12)
            goto L_0x0402
        L_0x03f7:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.cast.zzuc.zzg(r11, r3, r12)
        L_0x0402:
            int r6 = r6 + r3
            goto L_0x0573
        L_0x0405:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.cast.zztp r3 = (com.google.android.gms.internal.cast.zztp) r3
            com.google.android.gms.internal.cast.zzua r4 = r15.zzr(r5)
            int r3 = com.google.android.gms.internal.cast.zzru.zzt(r11, r3, r4)
            goto L_0x0402
        L_0x0419:
            r12 = 0
            r10 = r10 & r8
            if (r10 == 0) goto L_0x0573
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            long r13 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r10)
            long r3 = r3 ^ r13
            int r3 = com.google.android.gms.internal.cast.zzru.zzy(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x0573
        L_0x0433:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x0552
        L_0x044d:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x056f
        L_0x045a:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x0560
        L_0x0467:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzu(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x0552
        L_0x047c:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x0552
        L_0x0491:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.cast.zzrm r3 = (com.google.android.gms.internal.cast.zzrm) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r4)
        L_0x04ad:
            int r3 = r3 + r9
            goto L_0x0402
        L_0x04b0:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.cast.zzua r4 = r15.zzr(r5)
            int r3 = com.google.android.gms.internal.cast.zzuc.zzn(r11, r3, r4)
            goto L_0x0402
        L_0x04c3:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.cast.zzrm
            if (r4 == 0) goto L_0x04e4
            com.google.android.gms.internal.cast.zzrm r3 = (com.google.android.gms.internal.cast.zzrm) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.cast.zzru.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x04ad
        L_0x04e4:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzw(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x0552
        L_0x04f1:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            int r3 = r3 + r14
            goto L_0x0402
        L_0x04ff:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x0560
        L_0x050b:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
            goto L_0x056f
        L_0x0517:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzu(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x0552
        L_0x052b:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzy(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r9)
            goto L_0x0552
        L_0x053f:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0573
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzy(r3)
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r9)
        L_0x0552:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x0573
        L_0x0555:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
        L_0x0560:
            int r3 = r3 + 4
            goto L_0x0402
        L_0x0564:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0573
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.cast.zzru.zzx(r3)
        L_0x056f:
            int r3 = r3 + 8
            goto L_0x0402
        L_0x0573:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x057a:
            com.google.android.gms.internal.cast.zzur r2 = r0.zzk
            java.lang.Object r3 = r2.zzc(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzf
            if (r2 != 0) goto L_0x058a
            return r6
        L_0x058a:
            com.google.android.gms.internal.cast.zzrx r2 = r0.zzl
            r2.zza(r1)
            r1 = 0
            goto L_0x0592
        L_0x0591:
            throw r1
        L_0x0592:
            goto L_0x0591
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzl(java.lang.Object):int");
    }

    private static int zzm(Object obj, long j) {
        return ((Integer) zzvb.zzf(obj, j)).intValue();
    }

    private final int zzn(int i) {
        return this.zzc[i + 2];
    }

    private static int zzo(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzp(int i) {
        return this.zzc[i + 1];
    }

    private static long zzq(Object obj, long j) {
        return ((Long) zzvb.zzf(obj, j)).longValue();
    }

    private final zzua zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzua zzua = (zzua) this.zzd[i3];
        if (zzua != null) {
            return zzua;
        }
        zzua zzb2 = zztx.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzt(Class cls, String str) {
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

    private final void zzu(Object obj, Object obj2, int i) {
        if (zzA(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzp = (long) (zzp(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzp);
            if (object != null) {
                zzua zzr = zzr(i);
                if (!zzA(obj, i)) {
                    if (!zzD(object)) {
                        unsafe.putObject(obj, zzp, object);
                    } else {
                        Object zzc2 = zzr.zzc();
                        zzr.zze(zzc2, object);
                        unsafe.putObject(obj, zzp, zzc2);
                    }
                    zzw(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzp);
                if (!zzD(object2)) {
                    Object zzc3 = zzr.zzc();
                    zzr.zze(zzc3, object2);
                    unsafe.putObject(obj, zzp, zzc3);
                    object2 = zzc3;
                }
                zzr.zze(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzv(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzE(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzp = (long) (zzp(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzp);
            if (object != null) {
                zzua zzr = zzr(i);
                if (!zzE(obj, i2, i)) {
                    if (!zzD(object)) {
                        unsafe.putObject(obj, zzp, object);
                    } else {
                        Object zzc2 = zzr.zzc();
                        zzr.zze(zzc2, object);
                        unsafe.putObject(obj, zzp, zzc2);
                    }
                    zzx(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzp);
                if (!zzD(object2)) {
                    Object zzc3 = zzr.zzc();
                    zzr.zze(zzc3, object2);
                    unsafe.putObject(obj, zzp, zzc3);
                    object2 = zzc3;
                }
                zzr.zze(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzw(Object obj, int i) {
        int zzn2 = zzn(i);
        long j = (long) (1048575 & zzn2);
        if (j != 1048575) {
            zzvb.zzq(obj, j, (1 << (zzn2 >>> 20)) | zzvb.zzc(obj, j));
        }
    }

    private final void zzx(Object obj, int i, int i2) {
        zzvb.zzq(obj, (long) (zzn(i2) & 1048575), i);
    }

    private final void zzy(zzvi zzvi, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzti zzti = (zzti) zzs(i2);
            throw null;
        }
    }

    private final boolean zzz(Object obj, Object obj2, int i) {
        return zzA(obj, i) == zzA(obj2, i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0325, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x041e, code lost:
        r4 = r4 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04a0, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04f2, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x055d, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x056d, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0571, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzg
            if (r0 == 0) goto L_0x0581
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0009:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0575
            int r4 = r11.zzp(r2)
            int r5 = zzo(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            com.google.android.gms.internal.cast.zzsc r7 = com.google.android.gms.internal.cast.zzsc.DOUBLE_LIST_PACKED
            int r7 = r7.zza()
            if (r5 < r7) goto L_0x0034
            com.google.android.gms.internal.cast.zzsc r7 = com.google.android.gms.internal.cast.zzsc.SINT64_LIST_PACKED
            int r7 = r7.zza()
            if (r5 > r7) goto L_0x0034
            int[] r7 = r11.zzc
            int r8 = r2 + 2
            r7 = r7[r8]
        L_0x0034:
            long r7 = (long) r4
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0561;
                case 1: goto L_0x0551;
                case 2: goto L_0x053a;
                case 3: goto L_0x0525;
                case 4: goto L_0x0510;
                case 5: goto L_0x0503;
                case 6: goto L_0x04f6;
                case 7: goto L_0x04e6;
                case 8: goto L_0x04b7;
                case 9: goto L_0x04a3;
                case 10: goto L_0x0483;
                case 11: goto L_0x046d;
                case 12: goto L_0x0457;
                case 13: goto L_0x0449;
                case 14: goto L_0x043b;
                case 15: goto L_0x0420;
                case 16: goto L_0x0405;
                case 17: goto L_0x03f0;
                case 18: goto L_0x03e3;
                case 19: goto L_0x03d8;
                case 20: goto L_0x03cd;
                case 21: goto L_0x03c2;
                case 22: goto L_0x03b7;
                case 23: goto L_0x03ac;
                case 24: goto L_0x03a1;
                case 25: goto L_0x0396;
                case 26: goto L_0x038b;
                case 27: goto L_0x037c;
                case 28: goto L_0x0370;
                case 29: goto L_0x0364;
                case 30: goto L_0x0358;
                case 31: goto L_0x034c;
                case 32: goto L_0x0340;
                case 33: goto L_0x0334;
                case 34: goto L_0x0328;
                case 35: goto L_0x030f;
                case 36: goto L_0x02f8;
                case 37: goto L_0x02e1;
                case 38: goto L_0x02ca;
                case 39: goto L_0x02b3;
                case 40: goto L_0x029b;
                case 41: goto L_0x0283;
                case 42: goto L_0x0269;
                case 43: goto L_0x0251;
                case 44: goto L_0x0239;
                case 45: goto L_0x0221;
                case 46: goto L_0x0209;
                case 47: goto L_0x01f1;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c9;
                case 50: goto L_0x01bc;
                case 51: goto L_0x01ae;
                case 52: goto L_0x01a0;
                case 53: goto L_0x018a;
                case 54: goto L_0x0174;
                case 55: goto L_0x015e;
                case 56: goto L_0x0150;
                case 57: goto L_0x0142;
                case 58: goto L_0x0134;
                case 59: goto L_0x0103;
                case 60: goto L_0x00ef;
                case 61: goto L_0x00d0;
                case 62: goto L_0x00ba;
                case 63: goto L_0x00a4;
                case 64: goto L_0x0096;
                case 65: goto L_0x0088;
                case 66: goto L_0x006d;
                case 67: goto L_0x0052;
                case 68: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0571
        L_0x003c:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            com.google.android.gms.internal.cast.zztp r4 = (com.google.android.gms.internal.cast.zztp) r4
            com.google.android.gms.internal.cast.zzua r5 = r11.zzr(r2)
            int r4 = com.google.android.gms.internal.cast.zzru.zzt(r6, r4, r5)
            goto L_0x03ed
        L_0x0052:
            boolean r5 = r11.zzE(r12, r6, r2)
            if (r5 == 0) goto L_0x0571
            long r7 = zzq(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            long r6 = r6 ^ r9
            int r5 = com.google.android.gms.internal.cast.zzru.zzy(r6)
            goto L_0x041e
        L_0x006d:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = zzm(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x054e
        L_0x0088:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x056d
        L_0x0096:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x055d
        L_0x00a4:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = zzm(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzu(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x00ba:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = zzm(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x00d0:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzrm r4 = (com.google.android.gms.internal.cast.zzrm) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x04a0
        L_0x00ef:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzua r5 = r11.zzr(r2)
            int r4 = com.google.android.gms.internal.cast.zzuc.zzn(r6, r4, r5)
            goto L_0x03ed
        L_0x0103:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.cast.zzrm
            if (r5 == 0) goto L_0x0126
            com.google.android.gms.internal.cast.zzrm r4 = (com.google.android.gms.internal.cast.zzrm) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x04a0
        L_0x0126:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzw(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x0134:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x04f2
        L_0x0142:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x055d
        L_0x0150:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x056d
        L_0x015e:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = zzm(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzu(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x0174:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            long r4 = zzq(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzy(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r6)
            goto L_0x054e
        L_0x018a:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            long r4 = zzq(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzy(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r6)
            goto L_0x054e
        L_0x01a0:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x055d
        L_0x01ae:
            boolean r4 = r11.zzE(r12, r6, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x056d
        L_0x01bc:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.lang.Object r5 = r11.zzs(r2)
            com.google.android.gms.internal.cast.zztk.zza(r6, r4, r5)
            goto L_0x0571
        L_0x01c9:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.cast.zzua r5 = r11.zzr(r2)
            int r4 = com.google.android.gms.internal.cast.zzuc.zzi(r6, r4, r5)
            goto L_0x03ed
        L_0x01d9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzs(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x01f1:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzq(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x0209:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzh(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x0221:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzf(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x0239:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzd(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x0251:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzv(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r5 = com.google.android.gms.internal.cast.zzuc.zza
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x0283:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzf(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x029b:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzh(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x02b3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzk(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x02ca:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzx(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x02e1:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzm(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x02f8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzf(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x0325
        L_0x030f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzh(r4)
            if (r4 <= 0) goto L_0x0571
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
        L_0x0325:
            int r5 = r5 + r6
            goto L_0x054e
        L_0x0328:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzr(r6, r4, r1)
            goto L_0x03ed
        L_0x0334:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzp(r6, r4, r1)
            goto L_0x03ed
        L_0x0340:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzg(r6, r4, r1)
            goto L_0x03ed
        L_0x034c:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zze(r6, r4, r1)
            goto L_0x03ed
        L_0x0358:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzc(r6, r4, r1)
            goto L_0x03ed
        L_0x0364:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzu(r6, r4, r1)
            goto L_0x03ed
        L_0x0370:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzb(r6, r4)
            goto L_0x03ed
        L_0x037c:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.cast.zzua r5 = r11.zzr(r2)
            int r4 = com.google.android.gms.internal.cast.zzuc.zzo(r6, r4, r5)
            goto L_0x03ed
        L_0x038b:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzt(r6, r4)
            goto L_0x03ed
        L_0x0396:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zza(r6, r4, r1)
            goto L_0x03ed
        L_0x03a1:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zze(r6, r4, r1)
            goto L_0x03ed
        L_0x03ac:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzg(r6, r4, r1)
            goto L_0x03ed
        L_0x03b7:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzj(r6, r4, r1)
            goto L_0x03ed
        L_0x03c2:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzw(r6, r4, r1)
            goto L_0x03ed
        L_0x03cd:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzl(r6, r4, r1)
            goto L_0x03ed
        L_0x03d8:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zze(r6, r4, r1)
            goto L_0x03ed
        L_0x03e3:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzuc.zzg(r6, r4, r1)
        L_0x03ed:
            int r3 = r3 + r4
            goto L_0x0571
        L_0x03f0:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            com.google.android.gms.internal.cast.zztp r4 = (com.google.android.gms.internal.cast.zztp) r4
            com.google.android.gms.internal.cast.zzua r5 = r11.zzr(r2)
            int r4 = com.google.android.gms.internal.cast.zzru.zzt(r6, r4, r5)
            goto L_0x03ed
        L_0x0405:
            boolean r5 = r11.zzA(r12, r2)
            if (r5 == 0) goto L_0x0571
            long r7 = com.google.android.gms.internal.cast.zzvb.zzd(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            long r6 = r6 ^ r9
            int r5 = com.google.android.gms.internal.cast.zzru.zzy(r6)
        L_0x041e:
            int r4 = r4 + r5
            goto L_0x03ed
        L_0x0420:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = com.google.android.gms.internal.cast.zzvb.zzc(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x054e
        L_0x043b:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x056d
        L_0x0449:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x055d
        L_0x0457:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = com.google.android.gms.internal.cast.zzvb.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzu(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x046d:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = com.google.android.gms.internal.cast.zzvb.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x0483:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzrm r4 = (com.google.android.gms.internal.cast.zzrm) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r5)
        L_0x04a0:
            int r4 = r4 + r6
            goto L_0x03ed
        L_0x04a3:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzua r5 = r11.zzr(r2)
            int r4 = com.google.android.gms.internal.cast.zzuc.zzn(r6, r4, r5)
            goto L_0x03ed
        L_0x04b7:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzvb.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.cast.zzrm
            if (r5 == 0) goto L_0x04d9
            com.google.android.gms.internal.cast.zzrm r4 = (com.google.android.gms.internal.cast.zzrm) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzru.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x04a0
        L_0x04d9:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzw(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x04e6:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
        L_0x04f2:
            int r4 = r4 + 1
            goto L_0x03ed
        L_0x04f6:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x055d
        L_0x0503:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
            goto L_0x056d
        L_0x0510:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = com.google.android.gms.internal.cast.zzvb.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzu(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r5)
            goto L_0x054e
        L_0x0525:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            long r4 = com.google.android.gms.internal.cast.zzvb.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzy(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r6)
            goto L_0x054e
        L_0x053a:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            long r4 = com.google.android.gms.internal.cast.zzvb.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzy(r4)
            int r5 = com.google.android.gms.internal.cast.zzru.zzx(r6)
        L_0x054e:
            int r5 = r5 + r4
            int r3 = r3 + r5
            goto L_0x0571
        L_0x0551:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
        L_0x055d:
            int r4 = r4 + 4
            goto L_0x03ed
        L_0x0561:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0571
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzru.zzx(r4)
        L_0x056d:
            int r4 = r4 + 8
            goto L_0x03ed
        L_0x0571:
            int r2 = r2 + 3
            goto L_0x0009
        L_0x0575:
            com.google.android.gms.internal.cast.zzur r0 = r11.zzk
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            goto L_0x0585
        L_0x0581:
            int r3 = r11.zzl(r12)
        L_0x0585:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0201, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x020f, code lost:
        r2 = r2 + ((int) (r3 ^ (r3 >>> 32)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0214, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0218
            int r3 = r9.zzp(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzo(r3)
            long r5 = (long) r5
            r7 = 37
            r8 = 32
            switch(r3) {
                case 0: goto L_0x0203;
                case 1: goto L_0x01f7;
                case 2: goto L_0x01ee;
                case 3: goto L_0x01e5;
                case 4: goto L_0x01de;
                case 5: goto L_0x01d5;
                case 6: goto L_0x01ce;
                case 7: goto L_0x01c3;
                case 8: goto L_0x01b6;
                case 9: goto L_0x01a8;
                case 10: goto L_0x019d;
                case 11: goto L_0x0196;
                case 12: goto L_0x018e;
                case 13: goto L_0x0186;
                case 14: goto L_0x017c;
                case 15: goto L_0x0174;
                case 16: goto L_0x016a;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0214
        L_0x0021:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0033:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzq(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x0043:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzm(r10, r5)
            goto L_0x0201
        L_0x0051:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzq(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x0061:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzm(r10, r5)
            goto L_0x0201
        L_0x006f:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzm(r10, r5)
            goto L_0x0201
        L_0x007d:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzm(r10, r5)
            goto L_0x0201
        L_0x008b:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x009d:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00af:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x00c3:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            boolean r3 = zzF(r10, r5)
            int r3 = com.google.android.gms.internal.cast.zzsq.zza(r3)
            goto L_0x0201
        L_0x00d5:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzm(r10, r5)
            goto L_0x0201
        L_0x00e3:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzq(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x00f3:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            int r3 = zzm(r10, r5)
            goto L_0x0201
        L_0x0101:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzq(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x0111:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            long r3 = zzq(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x0121:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            float r3 = zzk(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0201
        L_0x0133:
            boolean r3 = r9.zzE(r10, r4, r1)
            if (r3 == 0) goto L_0x0214
            int r2 = r2 * 53
            double r3 = zzj(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x0147:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x0153:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x015f:
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
            goto L_0x01b2
        L_0x016a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzvb.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x0174:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzvb.zzc(r10, r5)
            goto L_0x0201
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzvb.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzvb.zzc(r10, r5)
            goto L_0x0201
        L_0x018e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzvb.zzc(r10, r5)
            goto L_0x0201
        L_0x0196:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzvb.zzc(r10, r5)
            goto L_0x0201
        L_0x019d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01a8:
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b2
            int r7 = r3.hashCode()
        L_0x01b2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0214
        L_0x01b6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzvb.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0201
        L_0x01c3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.cast.zzvb.zzw(r10, r5)
            int r3 = com.google.android.gms.internal.cast.zzsq.zza(r3)
            goto L_0x0201
        L_0x01ce:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzvb.zzc(r10, r5)
            goto L_0x0201
        L_0x01d5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzvb.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzvb.zzc(r10, r5)
            goto L_0x0201
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzvb.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x01ee:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzvb.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
            goto L_0x020f
        L_0x01f7:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.cast.zzvb.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
        L_0x0201:
            int r2 = r2 + r3
            goto L_0x0214
        L_0x0203:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.cast.zzvb.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.cast.zzsq.zzd
        L_0x020f:
            long r5 = r3 >>> r8
            long r3 = r3 ^ r5
            int r4 = (int) r3
            int r2 = r2 + r4
        L_0x0214:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0218:
            int r2 = r2 * 53
            com.google.android.gms.internal.cast.zzur r0 = r9.zzk
            java.lang.Object r0 = r0.zzc(r10)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r9.zzf
            if (r0 != 0) goto L_0x022a
            return r2
        L_0x022a:
            com.google.android.gms.internal.cast.zzrx r0 = r9.zzl
            r0.zza(r10)
            r10 = 0
            goto L_0x0232
        L_0x0231:
            throw r10
        L_0x0232:
            goto L_0x0231
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzts.zzb(java.lang.Object):int");
    }

    public final Object zzc() {
        return ((zzsh) this.zze).zzw();
    }

    public final void zzd(Object obj) {
        if (zzD(obj)) {
            if (obj instanceof zzsh) {
                zzsh zzsh = (zzsh) obj;
                zzsh.zzH(Integer.MAX_VALUE);
                zzsh.zza = 0;
                zzsh.zzF();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzp = zzp(i);
                int i2 = 1048575 & zzp;
                int zzo = zzo(zzp);
                long j = (long) i2;
                if (zzo != 9) {
                    if (zzo == 60 || zzo == 68) {
                        if (zzE(obj, this.zzc[i], i)) {
                            zzr(i).zzd(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzo) {
                            case 17:
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
                                this.zzj.zza(obj, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zztj) object).zzb();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzA(obj, i)) {
                    zzr(i).zzd(zzb.getObject(obj, j));
                }
            }
            this.zzk.zze(obj);
            if (this.zzf) {
                this.zzl.zzb(obj);
            }
        }
    }

    public final void zze(Object obj, Object obj2) {
        if (zzD(obj)) {
            obj2.getClass();
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzp = zzp(i);
                int i2 = this.zzc[i];
                long j = (long) (1048575 & zzp);
                switch (zzo(zzp)) {
                    case 0:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzo(obj, j, zzvb.zza(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzp(obj, j, zzvb.zzb(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzr(obj, j, zzvb.zzd(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzr(obj, j, zzvb.zzd(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzq(obj, j, zzvb.zzc(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzr(obj, j, zzvb.zzd(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzq(obj, j, zzvb.zzc(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzm(obj, j, zzvb.zzw(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzs(obj, j, zzvb.zzf(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 9:
                        zzu(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzs(obj, j, zzvb.zzf(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzq(obj, j, zzvb.zzc(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzq(obj, j, zzvb.zzc(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzq(obj, j, zzvb.zzc(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzr(obj, j, zzvb.zzd(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzq(obj, j, zzvb.zzc(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzA(obj2, i)) {
                            break;
                        } else {
                            zzvb.zzr(obj, j, zzvb.zzd(obj2, j));
                            zzw(obj, i);
                            break;
                        }
                    case 17:
                        zzu(obj, obj2, i);
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
                        this.zzj.zzb(obj, obj2, j);
                        break;
                    case 50:
                        int i3 = zzuc.zza;
                        zztj zztj = (zztj) zzvb.zzf(obj, j);
                        zztj zztj2 = (zztj) zzvb.zzf(obj2, j);
                        if (!zztj2.isEmpty()) {
                            if (!zztj.zzd()) {
                                zztj = zztj.zza();
                            }
                            zztj.zzc(zztj2);
                        }
                        zzvb.zzs(obj, j, zztj);
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
                        if (!zzE(obj2, i2, i)) {
                            break;
                        } else {
                            zzvb.zzs(obj, j, zzvb.zzf(obj2, j));
                            zzx(obj, i2, i);
                            break;
                        }
                    case 60:
                        zzv(obj, obj2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzE(obj2, i2, i)) {
                            break;
                        } else {
                            zzvb.zzs(obj, j, zzvb.zzf(obj2, j));
                            zzx(obj, i2, i);
                            break;
                        }
                    case 68:
                        zzv(obj, obj2, i);
                        break;
                }
            }
            zzuc.zzB(this.zzk, obj, obj2);
            if (this.zzf) {
                this.zzl.zza(obj2);
                throw null;
            }
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
    }

    public final boolean zzg(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzp = zzp(i);
            long j = (long) (zzp & 1048575);
            switch (zzo(zzp)) {
                case 0:
                    if (zzz(obj, obj2, i) && Double.doubleToLongBits(zzvb.zza(obj, j)) == Double.doubleToLongBits(zzvb.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzz(obj, obj2, i) && Float.floatToIntBits(zzvb.zzb(obj, j)) == Float.floatToIntBits(zzvb.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzz(obj, obj2, i) && zzvb.zzw(obj, j) == zzvb.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzz(obj, obj2, i) && zzvb.zzc(obj, j) == zzvb.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzz(obj, obj2, i) && zzvb.zzd(obj, j) == zzvb.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzz(obj, obj2, i) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
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
                    z = zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j));
                    break;
                case 50:
                    z = zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j));
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
                    long zzn2 = (long) (zzn(i) & 1048575);
                    if (zzvb.zzc(obj, zzn2) == zzvb.zzc(obj2, zzn2) && zzuc.zzV(zzvb.zzf(obj, j), zzvb.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzk.zzc(obj).equals(this.zzk.zzc(obj2))) {
            return false;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzl.zza(obj);
        this.zzl.zza(obj2);
        throw null;
    }

    public final boolean zzh(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzi) {
            int i6 = this.zzh[i5];
            int i7 = this.zzc[i6];
            int zzp = zzp(i6);
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
            if ((268435456 & zzp) != 0 && !zzB(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzo = zzo(zzp);
            if (zzo != 9 && zzo != 17) {
                if (zzo != 27) {
                    if (zzo == 60 || zzo == 68) {
                        if (zzE(obj2, i7, i6) && !zzC(obj2, zzp, zzr(i6))) {
                            return false;
                        }
                    } else if (zzo != 49) {
                        if (zzo == 50 && !((zztj) zzvb.zzf(obj2, (long) (zzp & 1048575))).isEmpty()) {
                            zzti zzti = (zzti) zzs(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzvb.zzf(obj2, (long) (zzp & 1048575));
                if (!list.isEmpty()) {
                    zzua zzr = zzr(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzr.zzh(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzB(obj, i6, i2, i, i10) && !zzC(obj2, zzp, zzr(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzl.zza(obj2);
        throw null;
    }

    public final void zzf(Object obj, zzvi zzvi) throws IOException {
        int i;
        Object obj2 = obj;
        zzvi zzvi2 = zzvi;
        int i2 = 1048575;
        if (this.zzg) {
            if (!this.zzf) {
                int length = this.zzc.length;
                for (int i3 = 0; i3 < length; i3 += 3) {
                    int zzp = zzp(i3);
                    int i4 = this.zzc[i3];
                    switch (zzo(zzp)) {
                        case 0:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzf(i4, zzvb.zza(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 1:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzn(i4, zzvb.zzb(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 2:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzs(i4, zzvb.zzd(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 3:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzH(i4, zzvb.zzd(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 4:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzq(i4, zzvb.zzc(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 5:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzl(i4, zzvb.zzd(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 6:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzj(i4, zzvb.zzc(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 7:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzb(i4, zzvb.zzw(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 8:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzG(i4, zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2);
                                break;
                            }
                        case 9:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzu(i4, zzvb.zzf(obj2, (long) (zzp & 1048575)), zzr(i3));
                                break;
                            }
                        case 10:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzd(i4, (zzrm) zzvb.zzf(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 11:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzF(i4, zzvb.zzc(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 12:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzh(i4, zzvb.zzc(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 13:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzv(i4, zzvb.zzc(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 14:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzx(i4, zzvb.zzd(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 15:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzz(i4, zzvb.zzc(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 16:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzB(i4, zzvb.zzd(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 17:
                            if (!zzA(obj2, i3)) {
                                break;
                            } else {
                                zzvi2.zzp(i4, zzvb.zzf(obj2, (long) (zzp & 1048575)), zzr(i3));
                                break;
                            }
                        case 18:
                            zzuc.zzF(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 19:
                            zzuc.zzJ(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 20:
                            zzuc.zzM(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 21:
                            zzuc.zzU(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 22:
                            zzuc.zzL(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 23:
                            zzuc.zzI(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 24:
                            zzuc.zzH(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 25:
                            zzuc.zzD(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 26:
                            zzuc.zzS(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2);
                            break;
                        case 27:
                            zzuc.zzN(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, zzr(i3));
                            break;
                        case 28:
                            zzuc.zzE(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2);
                            break;
                        case 29:
                            zzuc.zzT(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 30:
                            zzuc.zzG(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 31:
                            zzuc.zzO(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 32:
                            zzuc.zzP(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 33:
                            zzuc.zzQ(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 34:
                            zzuc.zzR(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, false);
                            break;
                        case 35:
                            zzuc.zzF(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 36:
                            zzuc.zzJ(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 37:
                            zzuc.zzM(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 38:
                            zzuc.zzU(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 39:
                            zzuc.zzL(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 40:
                            zzuc.zzI(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 41:
                            zzuc.zzH(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 42:
                            zzuc.zzD(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 43:
                            zzuc.zzT(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 44:
                            zzuc.zzG(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 45:
                            zzuc.zzO(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 46:
                            zzuc.zzP(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 47:
                            zzuc.zzQ(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 48:
                            zzuc.zzR(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, true);
                            break;
                        case 49:
                            zzuc.zzK(i4, (List) zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2, zzr(i3));
                            break;
                        case 50:
                            zzy(zzvi2, i4, zzvb.zzf(obj2, (long) (zzp & 1048575)), i3);
                            break;
                        case 51:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzf(i4, zzj(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 52:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzn(i4, zzk(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 53:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzs(i4, zzq(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 54:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzH(i4, zzq(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 55:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzq(i4, zzm(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 56:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzl(i4, zzq(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 57:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzj(i4, zzm(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 58:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzb(i4, zzF(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 59:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzG(i4, zzvb.zzf(obj2, (long) (zzp & 1048575)), zzvi2);
                                break;
                            }
                        case 60:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzu(i4, zzvb.zzf(obj2, (long) (zzp & 1048575)), zzr(i3));
                                break;
                            }
                        case 61:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzd(i4, (zzrm) zzvb.zzf(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 62:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzF(i4, zzm(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 63:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzh(i4, zzm(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 64:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzv(i4, zzm(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 65:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzx(i4, zzq(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 66:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzz(i4, zzm(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 67:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzB(i4, zzq(obj2, (long) (zzp & 1048575)));
                                break;
                            }
                        case 68:
                            if (!zzE(obj2, i4, i3)) {
                                break;
                            } else {
                                zzvi2.zzp(i4, zzvb.zzf(obj2, (long) (zzp & 1048575)), zzr(i3));
                                break;
                            }
                    }
                }
                zzur zzur = this.zzk;
                zzur.zzg(zzur.zzc(obj2), zzvi2);
                return;
            }
            this.zzl.zza(obj2);
            throw null;
        } else if (!this.zzf) {
            int length2 = this.zzc.length;
            Unsafe unsafe = zzb;
            int i5 = 0;
            int i6 = 1048575;
            int i7 = 0;
            while (i5 < length2) {
                int zzp2 = zzp(i5);
                int[] iArr = this.zzc;
                int i8 = iArr[i5];
                int zzo = zzo(zzp2);
                if (zzo <= 17) {
                    int i9 = iArr[i5 + 2];
                    int i10 = i9 & i2;
                    if (i10 != i6) {
                        i7 = unsafe.getInt(obj2, (long) i10);
                        i6 = i10;
                    }
                    i = 1 << (i9 >>> 20);
                } else {
                    i = 0;
                }
                long j = (long) (zzp2 & i2);
                switch (zzo) {
                    case 0:
                        if ((i7 & i) == 0) {
                            break;
                        } else {
                            zzvi2.zzf(i8, zzvb.zza(obj2, j));
                            continue;
                        }
                    case 1:
                        if ((i7 & i) != 0) {
                            zzvi2.zzn(i8, zzvb.zzb(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i7 & i) != 0) {
                            zzvi2.zzs(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i7 & i) != 0) {
                            zzvi2.zzH(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i7 & i) != 0) {
                            zzvi2.zzq(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i7 & i) != 0) {
                            zzvi2.zzl(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i7 & i) != 0) {
                            zzvi2.zzj(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i7 & i) != 0) {
                            zzvi2.zzb(i8, zzvb.zzw(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i7 & i) != 0) {
                            zzG(i8, unsafe.getObject(obj2, j), zzvi2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i7 & i) != 0) {
                            zzvi2.zzu(i8, unsafe.getObject(obj2, j), zzr(i5));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i7 & i) != 0) {
                            zzvi2.zzd(i8, (zzrm) unsafe.getObject(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i7 & i) != 0) {
                            zzvi2.zzF(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i7 & i) != 0) {
                            zzvi2.zzh(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i7 & i) != 0) {
                            zzvi2.zzv(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i7 & i) != 0) {
                            zzvi2.zzx(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i7 & i) != 0) {
                            zzvi2.zzz(i8, unsafe.getInt(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i7 & i) != 0) {
                            zzvi2.zzB(i8, unsafe.getLong(obj2, j));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i7 & i) != 0) {
                            zzvi2.zzp(i8, unsafe.getObject(obj2, j), zzr(i5));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzuc.zzF(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 19:
                        zzuc.zzJ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 20:
                        zzuc.zzM(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 21:
                        zzuc.zzU(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 22:
                        zzuc.zzL(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 23:
                        zzuc.zzI(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 24:
                        zzuc.zzH(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 25:
                        zzuc.zzD(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        continue;
                    case 26:
                        zzuc.zzS(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2);
                        break;
                    case 27:
                        zzuc.zzN(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, zzr(i5));
                        break;
                    case 28:
                        zzuc.zzE(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2);
                        break;
                    case 29:
                        zzuc.zzT(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        break;
                    case 30:
                        zzuc.zzG(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        break;
                    case 31:
                        zzuc.zzO(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        break;
                    case 32:
                        zzuc.zzP(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        break;
                    case 33:
                        zzuc.zzQ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        break;
                    case 34:
                        zzuc.zzR(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, false);
                        break;
                    case 35:
                        zzuc.zzF(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 36:
                        zzuc.zzJ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 37:
                        zzuc.zzM(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 38:
                        zzuc.zzU(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 39:
                        zzuc.zzL(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 40:
                        zzuc.zzI(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 41:
                        zzuc.zzH(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 42:
                        zzuc.zzD(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 43:
                        zzuc.zzT(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 44:
                        zzuc.zzG(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 45:
                        zzuc.zzO(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 46:
                        zzuc.zzP(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 47:
                        zzuc.zzQ(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 48:
                        zzuc.zzR(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, true);
                        break;
                    case 49:
                        zzuc.zzK(this.zzc[i5], (List) unsafe.getObject(obj2, j), zzvi2, zzr(i5));
                        break;
                    case 50:
                        zzy(zzvi2, i8, unsafe.getObject(obj2, j), i5);
                        break;
                    case 51:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzf(i8, zzj(obj2, j));
                            break;
                        }
                        break;
                    case 52:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzn(i8, zzk(obj2, j));
                            break;
                        }
                        break;
                    case 53:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzs(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 54:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzH(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 55:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzq(i8, zzm(obj2, j));
                            break;
                        }
                        break;
                    case 56:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzl(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 57:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzj(i8, zzm(obj2, j));
                            break;
                        }
                        break;
                    case 58:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzb(i8, zzF(obj2, j));
                            break;
                        }
                        break;
                    case 59:
                        if (zzE(obj2, i8, i5)) {
                            zzG(i8, unsafe.getObject(obj2, j), zzvi2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzu(i8, unsafe.getObject(obj2, j), zzr(i5));
                            break;
                        }
                        break;
                    case 61:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzd(i8, (zzrm) unsafe.getObject(obj2, j));
                            break;
                        }
                        break;
                    case 62:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzF(i8, zzm(obj2, j));
                            break;
                        }
                        break;
                    case 63:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzh(i8, zzm(obj2, j));
                            break;
                        }
                        break;
                    case 64:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzv(i8, zzm(obj2, j));
                            break;
                        }
                        break;
                    case 65:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzx(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 66:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzz(i8, zzm(obj2, j));
                            break;
                        }
                        break;
                    case 67:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzB(i8, zzq(obj2, j));
                            break;
                        }
                        break;
                    case 68:
                        if (zzE(obj2, i8, i5)) {
                            zzvi2.zzp(i8, unsafe.getObject(obj2, j), zzr(i5));
                            break;
                        }
                        break;
                }
                i5 += 3;
                i2 = 1048575;
            }
            zzur zzur2 = this.zzk;
            zzur2.zzg(zzur2.zzc(obj2), zzvi2);
        } else {
            this.zzl.zza(obj2);
            throw null;
        }
    }
}
