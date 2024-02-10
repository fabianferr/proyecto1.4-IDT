package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzayz extends zzazd {
    private final AtomicReference zza;

    public zzayz() {
        this((zzaze) null);
    }

    protected static boolean zza(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    private static int zzh(int i, int i2) {
        if (i == -1) {
            return i2 != -1 ? -1 : 0;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* access modifiers changed from: protected */
    public final zzayx[] zzb(zzatc[] zzatcArr, zzayt[] zzaytArr, int[][][] iArr) throws zzasi {
        zzaza zzaza;
        zzaza zzaza2;
        int[] iArr2;
        ArrayList arrayList;
        zzays zzays;
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3 = 2;
        zzayx[] zzayxArr = new zzayx[2];
        zzayy zzayy = (zzayy) this.zza.get();
        int i4 = 0;
        boolean z3 = false;
        while (true) {
            int i5 = -1;
            int i6 = 1;
            if (i4 >= i3) {
                break;
            }
            if (zzatcArr[i4].zzc() == i3) {
                if (!z3) {
                    zzatc zzatc = zzatcArr[i4];
                    zzayt zzayt = zzaytArr[i4];
                    int[][] iArr3 = iArr[i4];
                    int i7 = zzayy.zzd;
                    int i8 = zzayy.zze;
                    int i9 = zzayy.zzf;
                    boolean z4 = zzayy.zzc;
                    boolean z5 = zzayy.zzb;
                    int i10 = zzayy.zzi;
                    int i11 = zzayy.zzj;
                    boolean z6 = zzayy.zzk;
                    boolean z7 = zzayy.zzg;
                    boolean z8 = zzayy.zzh;
                    int i12 = -1;
                    int i13 = 0;
                    zzays zzays2 = null;
                    int i14 = 0;
                    int i15 = 0;
                    while (i13 < zzayt.zzb) {
                        zzays zzb = zzayt.zzb(i13);
                        int i16 = zzb.zza;
                        ArrayList arrayList2 = new ArrayList(i6);
                        int i17 = 0;
                        while (true) {
                            int i18 = zzb.zza;
                            if (i17 > 0) {
                                break;
                            }
                            arrayList2.add(Integer.valueOf(i17));
                            i17++;
                        }
                        int[] iArr4 = iArr3[i13];
                        int i19 = 0;
                        while (true) {
                            int i20 = zzb.zza;
                            if (i19 > 0) {
                                break;
                            }
                            zzayt zzayt2 = zzayt;
                            if (zza(iArr4[i19], true)) {
                                zzasw zzb2 = zzb.zzb(i19);
                                if (arrayList2.contains(Integer.valueOf(i19))) {
                                    int i21 = zzb2.zzj;
                                    int i22 = zzb2.zzk;
                                    int i23 = zzb2.zzb;
                                    zzays = zzb;
                                    z2 = true;
                                    z = true;
                                } else {
                                    zzays = zzb;
                                    z2 = true;
                                    z = false;
                                }
                                if (z2 != z) {
                                    arrayList = arrayList2;
                                    i = 1;
                                } else {
                                    arrayList = arrayList2;
                                    i = 2;
                                }
                                iArr2 = iArr4;
                                boolean zza2 = zza(iArr4[i19], false);
                                if (zza2) {
                                    i += 1000;
                                }
                                boolean z9 = i > i15;
                                if (i == i15) {
                                    if (zzb2.zza() != i12) {
                                        i2 = zzh(zzb2.zza(), i12);
                                    } else {
                                        i2 = zzh(zzb2.zzb, i5);
                                    }
                                    z9 = !zza2 || !z ? i2 < 0 : i2 > 0;
                                }
                                if (z9) {
                                    i5 = zzb2.zzb;
                                    i12 = zzb2.zza();
                                    i15 = i;
                                    i14 = i19;
                                    zzays2 = zzays;
                                }
                            } else {
                                zzays = zzb;
                                iArr2 = iArr4;
                                arrayList = arrayList2;
                            }
                            i19++;
                            zzayt = zzayt2;
                            zzb = zzays;
                            arrayList2 = arrayList;
                            iArr4 = iArr2;
                        }
                        zzayt zzayt3 = zzayt;
                        i13++;
                        i6 = 1;
                    }
                    if (zzays2 == null) {
                        zzaza2 = null;
                    } else {
                        zzaza2 = new zzaza(zzays2, i14, 0, (Object) null);
                    }
                    zzayxArr[i4] = zzaza2;
                    z3 = zzaza2 != null;
                }
                int i24 = zzaytArr[i4].zzb;
            }
            i4++;
            i3 = 2;
        }
        int i25 = 0;
        boolean z10 = false;
        while (i25 < i3) {
            if (zzatcArr[i25].zzc() == 1 && !z10) {
                zzayt zzayt4 = zzaytArr[i25];
                int[][] iArr5 = iArr[i25];
                String str = zzayy.zza;
                boolean z11 = zzayy.zzh;
                boolean z12 = zzayy.zzb;
                int i26 = 0;
                int i27 = 0;
                int i28 = -1;
                int i29 = -1;
                while (i26 < zzayt4.zzb) {
                    zzays zzb3 = zzayt4.zzb(i26);
                    int[] iArr6 = iArr5[i26];
                    int i30 = i29;
                    int i31 = i28;
                    int i32 = i27;
                    int i33 = 0;
                    while (true) {
                        int i34 = zzb3.zza;
                        if (i33 > 0) {
                            break;
                        }
                        if (zza(iArr6[i33], true)) {
                            zzasw zzb4 = zzb3.zzb(i33);
                            int i35 = iArr6[i33];
                            int i36 = 1 != (zzb4.zzx & 1) ? 1 : 2;
                            if (zza(i35, false)) {
                                i36 += 1000;
                            }
                            if (i36 > i32) {
                                i31 = i26;
                                i30 = i33;
                                i32 = i36;
                            }
                        }
                        i33++;
                    }
                    i26++;
                    i27 = i32;
                    i28 = i31;
                    i29 = i30;
                }
                if (i28 == -1) {
                    zzaza = null;
                } else {
                    zzaza = new zzaza(zzayt4.zzb(i28), i29, 0, (Object) null);
                }
                zzayxArr[i25] = zzaza;
                z10 = zzaza != null;
            }
            i25++;
            i3 = 2;
        }
        return zzayxArr;
    }

    public zzayz(zzaze zzaze) {
        this.zza = new AtomicReference(new zzayy());
    }
}
