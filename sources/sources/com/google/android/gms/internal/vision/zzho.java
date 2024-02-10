package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzho extends zzhm {
    private final boolean zza = true;
    private final byte[] zzb;
    private int zzc;
    private final int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public zzho(ByteBuffer byteBuffer, boolean z) {
        super((zzhp) null);
        this.zzb = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.zzc = arrayOffset;
        this.zzd = arrayOffset;
        this.zze = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean zzu() {
        return this.zzc == this.zze;
    }

    public final int zza() throws IOException {
        if (zzu()) {
            return Integer.MAX_VALUE;
        }
        int zzv = zzv();
        this.zzf = zzv;
        if (zzv == this.zzg) {
            return Integer.MAX_VALUE;
        }
        return zzv >>> 3;
    }

    public final int zzb() {
        return this.zzf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[LOOP:0: B:18:0x002e->B:21:0x003b, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzu()
            r1 = 0
            if (r0 != 0) goto L_0x0085
            int r0 = r7.zzf
            int r2 = r7.zzg
            if (r0 != r2) goto L_0x000f
            goto L_0x0085
        L_0x000f:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L_0x0059
            if (r3 == r4) goto L_0x0053
            r1 = 2
            if (r3 == r1) goto L_0x004b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L_0x0029
            r0 = 5
            if (r3 != r0) goto L_0x0024
            r7.zza((int) r1)
            return r4
        L_0x0024:
            com.google.android.gms.internal.vision.zzjn r0 = com.google.android.gms.internal.vision.zzjk.zzf()
            throw r0
        L_0x0029:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zzg = r0
        L_0x002e:
            int r0 = r7.zza()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x003d
            boolean r0 = r7.zzc()
            if (r0 != 0) goto L_0x002e
        L_0x003d:
            int r0 = r7.zzf
            int r1 = r7.zzg
            if (r0 != r1) goto L_0x0046
            r7.zzg = r2
            return r4
        L_0x0046:
            com.google.android.gms.internal.vision.zzjk r0 = com.google.android.gms.internal.vision.zzjk.zzg()
            throw r0
        L_0x004b:
            int r0 = r7.zzv()
            r7.zza((int) r0)
            return r4
        L_0x0053:
            r0 = 8
            r7.zza((int) r0)
            return r4
        L_0x0059:
            int r0 = r7.zze
            int r2 = r7.zzc
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L_0x0074
            byte[] r0 = r7.zzb
            r5 = 0
        L_0x0065:
            if (r5 >= r3) goto L_0x0074
            int r6 = r2 + 1
            byte r2 = r0[r2]
            if (r2 < 0) goto L_0x0070
            r7.zzc = r6
            goto L_0x007f
        L_0x0070:
            int r5 = r5 + 1
            r2 = r6
            goto L_0x0065
        L_0x0074:
            if (r1 >= r3) goto L_0x0080
            byte r0 = r7.zzy()
            if (r0 >= 0) goto L_0x007f
            int r1 = r1 + 1
            goto L_0x0074
        L_0x007f:
            return r4
        L_0x0080:
            com.google.android.gms.internal.vision.zzjk r0 = com.google.android.gms.internal.vision.zzjk.zzc()
            throw r0
        L_0x0085:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzho.zzc():boolean");
    }

    public final double zzd() throws IOException {
        zzc(1);
        return Double.longBitsToDouble(zzaa());
    }

    public final float zze() throws IOException {
        zzc(5);
        return Float.intBitsToFloat(zzz());
    }

    public final long zzf() throws IOException {
        zzc(0);
        return zzw();
    }

    public final long zzg() throws IOException {
        zzc(0);
        return zzw();
    }

    public final int zzh() throws IOException {
        zzc(0);
        return zzv();
    }

    public final long zzi() throws IOException {
        zzc(1);
        return zzaa();
    }

    public final int zzj() throws IOException {
        zzc(5);
        return zzz();
    }

    public final boolean zzk() throws IOException {
        zzc(0);
        if (zzv() != 0) {
            return true;
        }
        return false;
    }

    public final String zzl() throws IOException {
        return zza(false);
    }

    public final String zzm() throws IOException {
        return zza(true);
    }

    private final String zza(boolean z) throws IOException {
        zzc(2);
        int zzv = zzv();
        if (zzv == 0) {
            return "";
        }
        zzb(zzv);
        if (z) {
            byte[] bArr = this.zzb;
            int i = this.zzc;
            if (!zzmd.zza(bArr, i, i + zzv)) {
                throw zzjk.zzh();
            }
        }
        String str = new String(this.zzb, this.zzc, zzv, zzjf.zza);
        this.zzc += zzv;
        return str;
    }

    public final <T> T zza(Class<T> cls, zzio zzio) throws IOException {
        zzc(2);
        return zzc(zzky.zza().zza(cls), zzio);
    }

    public final <T> T zza(zzlc<T> zzlc, zzio zzio) throws IOException {
        zzc(2);
        return zzc(zzlc, zzio);
    }

    private final <T> T zzc(zzlc<T> zzlc, zzio zzio) throws IOException {
        int zzv = zzv();
        zzb(zzv);
        int i = this.zze;
        int i2 = this.zzc + zzv;
        this.zze = i2;
        try {
            T zza2 = zzlc.zza();
            zzlc.zza(zza2, this, zzio);
            zzlc.zzc(zza2);
            if (this.zzc == i2) {
                return zza2;
            }
            throw zzjk.zzg();
        } finally {
            this.zze = i;
        }
    }

    public final <T> T zzb(Class<T> cls, zzio zzio) throws IOException {
        zzc(3);
        return zzd(zzky.zza().zza(cls), zzio);
    }

    public final <T> T zzb(zzlc<T> zzlc, zzio zzio) throws IOException {
        zzc(3);
        return zzd(zzlc, zzio);
    }

    private final <T> T zzd(zzlc<T> zzlc, zzio zzio) throws IOException {
        int i = this.zzg;
        this.zzg = ((this.zzf >>> 3) << 3) | 4;
        try {
            T zza2 = zzlc.zza();
            zzlc.zza(zza2, this, zzio);
            zzlc.zzc(zza2);
            if (this.zzf == this.zzg) {
                return zza2;
            }
            throw zzjk.zzg();
        } finally {
            this.zzg = i;
        }
    }

    public final zzht zzn() throws IOException {
        zzht zzht;
        zzc(2);
        int zzv = zzv();
        if (zzv == 0) {
            return zzht.zza;
        }
        zzb(zzv);
        if (this.zza) {
            zzht = zzht.zzb(this.zzb, this.zzc, zzv);
        } else {
            zzht = zzht.zza(this.zzb, this.zzc, zzv);
        }
        this.zzc += zzv;
        return zzht;
    }

    public final int zzo() throws IOException {
        zzc(0);
        return zzv();
    }

    public final int zzp() throws IOException {
        zzc(0);
        return zzv();
    }

    public final int zzq() throws IOException {
        zzc(5);
        return zzz();
    }

    public final long zzr() throws IOException {
        zzc(1);
        return zzaa();
    }

    public final int zzs() throws IOException {
        zzc(0);
        return zzif.zze(zzv());
    }

    public final long zzt() throws IOException {
        zzc(0);
        return zzif.zza(zzw());
    }

    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzin) {
            zzin zzin = (zzin) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzin.zza(zzd());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = zzv();
                zzd(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzin.zza(Double.longBitsToDouble(zzac()));
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 1) {
                do {
                    list.add(Double.valueOf(zzd()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i5 == 2) {
                int zzv2 = zzv();
                zzd(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzac())));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int zzv = zzv();
                zze(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzja.zza(Float.intBitsToFloat(zzab()));
                }
            } else if (i3 == 5) {
                do {
                    zzja.zza(zze());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 2) {
                int zzv2 = zzv();
                zze(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzab())));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Float.valueOf(zze()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjy.zza(zzf());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjy.zza(zzw());
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzf()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Long.valueOf(zzw()));
                }
                zzf(zzv2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjy.zza(zzg());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjy.zza(zzw());
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzg()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Long.valueOf(zzw()));
                }
                zzf(zzv2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzh());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzv());
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzh()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
                zzf(zzv2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzjy.zza(zzi());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = zzv();
                zzd(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjy.zza(zzac());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzi()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i5 == 2) {
                int zzv2 = zzv();
                zzd(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Long.valueOf(zzac()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int zzv = zzv();
                zze(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjd.zzc(zzab());
                }
            } else if (i3 == 5) {
                do {
                    zzjd.zzc(zzj());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 2) {
                int zzv2 = zzv();
                zze(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Integer.valueOf(zzab()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzj()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhr) {
            zzhr zzhr = (zzhr) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzhr.zza(zzk());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzhr.zza(zzv() != 0);
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Boolean.valueOf(zzk()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Boolean.valueOf(zzv() != 0));
                }
                zzf(zzv2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzj(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.zzf & 7) != 2) {
            throw zzjk.zzf();
        } else if (!(list instanceof zzjv) || z) {
            do {
                list.add(zza(z));
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
        } else {
            zzjv zzjv = (zzjv) list;
            do {
                zzjv.zza(zzn());
                if (!zzu()) {
                    i2 = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
        }
    }

    public final <T> void zza(List<T> list, zzlc<T> zzlc, zzio zzio) throws IOException {
        int i;
        int i2 = this.zzf;
        if ((i2 & 7) == 2) {
            do {
                list.add(zzc(zzlc, zzio));
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == i2);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    public final <T> void zzb(List<T> list, zzlc<T> zzlc, zzio zzio) throws IOException {
        int i;
        int i2 = this.zzf;
        if ((i2 & 7) == 3) {
            do {
                list.add(zzd(zzlc, zzio));
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == i2);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    public final void zzk(List<zzht> list) throws IOException {
        int i;
        if ((this.zzf & 7) == 2) {
            do {
                list.add(zzn());
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzo());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzv());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzo()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzp());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzv());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzp()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzn(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int zzv = zzv();
                zze(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjd.zzc(zzab());
                }
            } else if (i3 == 5) {
                do {
                    zzjd.zzc(zzq());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 2) {
                int zzv2 = zzv();
                zze(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Integer.valueOf(zzab()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzq()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzo(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzjy.zza(zzr());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = zzv();
                zzd(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjy.zza(zzac());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzr()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i5 == 2) {
                int zzv2 = zzv();
                zzd(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Long.valueOf(zzac()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzp(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzs());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzif.zze(zzv()));
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzs()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzif.zze(zzv())));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    public final void zzq(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjy.zza(zzt());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjy.zza(zzif.zza(zzw()));
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzt()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Long.valueOf(zzif.zza(zzw())));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(2:20|36)(3:31|21|22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (zzc() != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        throw new com.google.android.gms.internal.vision.zzjk("Unable to parse map entry.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.zzkf<K, V> r9, com.google.android.gms.internal.vision.zzio r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzc((int) r0)
            int r1 = r7.zzv()
            r7.zzb((int) r1)
            int r2 = r7.zze
            int r3 = r7.zzc
            int r3 = r3 + r1
            r7.zze = r3
            K r1 = r9.zzb     // Catch:{ all -> 0x005b }
            V r3 = r9.zzd     // Catch:{ all -> 0x005b }
        L_0x0016:
            int r4 = r7.zza()     // Catch:{ all -> 0x005b }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0055
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0040
            if (r4 == r0) goto L_0x0033
            boolean r4 = r7.zzc()     // Catch:{ zzjn -> 0x0048 }
            if (r4 == 0) goto L_0x002d
            goto L_0x0016
        L_0x002d:
            com.google.android.gms.internal.vision.zzjk r4 = new com.google.android.gms.internal.vision.zzjk     // Catch:{ zzjn -> 0x0048 }
            r4.<init>(r6)     // Catch:{ zzjn -> 0x0048 }
            throw r4     // Catch:{ zzjn -> 0x0048 }
        L_0x0033:
            com.google.android.gms.internal.vision.zzml r4 = r9.zzc     // Catch:{ zzjn -> 0x0048 }
            V r5 = r9.zzd     // Catch:{ zzjn -> 0x0048 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzjn -> 0x0048 }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.vision.zzml) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzio) r10)     // Catch:{ zzjn -> 0x0048 }
            goto L_0x0016
        L_0x0040:
            com.google.android.gms.internal.vision.zzml r4 = r9.zza     // Catch:{ zzjn -> 0x0048 }
            r5 = 0
            java.lang.Object r1 = r7.zza((com.google.android.gms.internal.vision.zzml) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzio) r5)     // Catch:{ zzjn -> 0x0048 }
            goto L_0x0016
        L_0x0048:
            boolean r4 = r7.zzc()     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x004f
            goto L_0x0016
        L_0x004f:
            com.google.android.gms.internal.vision.zzjk r8 = new com.google.android.gms.internal.vision.zzjk     // Catch:{ all -> 0x005b }
            r8.<init>(r6)     // Catch:{ all -> 0x005b }
            throw r8     // Catch:{ all -> 0x005b }
        L_0x0055:
            r8.put(r1, r3)     // Catch:{ all -> 0x005b }
            r7.zze = r2
            return
        L_0x005b:
            r8 = move-exception
            r7.zze = r2
            goto L_0x0060
        L_0x005f:
            throw r8
        L_0x0060:
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzho.zza(java.util.Map, com.google.android.gms.internal.vision.zzkf, com.google.android.gms.internal.vision.zzio):void");
    }

    private final Object zza(zzml zzml, Class<?> cls, zzio zzio) throws IOException {
        switch (zzhp.zza[zzml.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                return zza(cls, zzio);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zza(true);
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzv() throws IOException {
        byte b;
        int i = this.zzc;
        int i2 = this.zze;
        if (i2 != i) {
            byte[] bArr = this.zzb;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzc = i3;
                return b2;
            } else if (i2 - i3 < 9) {
                return (int) zzx();
            } else {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ Byte.MIN_VALUE;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << Ascii.SO);
                    if (b4 >= 0) {
                        b = b4 ^ 16256;
                    } else {
                        i4 = i5 + 1;
                        byte b5 = b4 ^ (bArr[i5] << Ascii.NAK);
                        if (b5 < 0) {
                            b = b5 ^ -2080896;
                        } else {
                            i5 = i4 + 1;
                            byte b6 = bArr[i4];
                            b = (b5 ^ (b6 << Ascii.FS)) ^ 266354560;
                            if (b6 < 0) {
                                i4 = i5 + 1;
                                if (bArr[i5] < 0) {
                                    i5 = i4 + 1;
                                    if (bArr[i4] < 0) {
                                        i4 = i5 + 1;
                                        if (bArr[i5] < 0) {
                                            i5 = i4 + 1;
                                            if (bArr[i4] < 0) {
                                                i4 = i5 + 1;
                                                if (bArr[i5] < 0) {
                                                    throw zzjk.zzc();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = i5;
                }
                this.zzc = i4;
                return b;
            }
        } else {
            throw zzjk.zza();
        }
    }

    private final long zzw() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        long j4;
        byte b;
        int i2 = this.zzc;
        int i3 = this.zze;
        if (i3 != i2) {
            byte[] bArr = this.zzb;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.zzc = i4;
                return (long) b2;
            } else if (i3 - i4 < 9) {
                return zzx();
            } else {
                int i5 = i4 + 1;
                byte b3 = b2 ^ (bArr[i4] << 7);
                if (b3 < 0) {
                    b = b3 ^ Byte.MIN_VALUE;
                } else {
                    int i6 = i5 + 1;
                    byte b4 = b3 ^ (bArr[i5] << Ascii.SO);
                    if (b4 >= 0) {
                        i = i6;
                        j = (long) (b4 ^ 16256);
                    } else {
                        i5 = i6 + 1;
                        byte b5 = b4 ^ (bArr[i6] << Ascii.NAK);
                        if (b5 < 0) {
                            b = b5 ^ -2080896;
                        } else {
                            long j5 = (long) b5;
                            int i7 = i5 + 1;
                            long j6 = j5 ^ (((long) bArr[i5]) << 28);
                            if (j6 >= 0) {
                                j4 = 266354560;
                            } else {
                                i = i7 + 1;
                                long j7 = j6 ^ (((long) bArr[i7]) << 35);
                                if (j7 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i + 1;
                                    j6 = j7 ^ (((long) bArr[i]) << 42);
                                    if (j6 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i = i7 + 1;
                                        j7 = j6 ^ (((long) bArr[i7]) << 49);
                                        if (j7 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            int i8 = i + 1;
                                            j2 = (j7 ^ (((long) bArr[i]) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                i = i8 + 1;
                                                if (((long) bArr[i8]) < 0) {
                                                    throw zzjk.zzc();
                                                }
                                            } else {
                                                i = i8;
                                            }
                                            j = j2;
                                        }
                                    }
                                }
                                j2 = j7 ^ j3;
                                j = j2;
                            }
                            j = j4 ^ j6;
                            i = i7;
                        }
                    }
                    this.zzc = i;
                    return j;
                }
                j = (long) b;
                this.zzc = i;
                return j;
            }
        } else {
            throw zzjk.zza();
        }
    }

    private final long zzx() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzy = zzy();
            j |= ((long) (zzy & Byte.MAX_VALUE)) << i;
            if ((zzy & 128) == 0) {
                return j;
            }
        }
        throw zzjk.zzc();
    }

    private final byte zzy() throws IOException {
        int i = this.zzc;
        if (i != this.zze) {
            byte[] bArr = this.zzb;
            this.zzc = i + 1;
            return bArr[i];
        }
        throw zzjk.zza();
    }

    private final int zzz() throws IOException {
        zzb(4);
        return zzab();
    }

    private final long zzaa() throws IOException {
        zzb(8);
        return zzac();
    }

    private final int zzab() {
        int i = this.zzc;
        byte[] bArr = this.zzb;
        this.zzc = i + 4;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    private final long zzac() {
        int i = this.zzc;
        byte[] bArr = this.zzb;
        this.zzc = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zza(int i) throws IOException {
        zzb(i);
        this.zzc += i;
    }

    private final void zzb(int i) throws IOException {
        if (i < 0 || i > this.zze - this.zzc) {
            throw zzjk.zza();
        }
    }

    private final void zzc(int i) throws IOException {
        if ((this.zzf & 7) != i) {
            throw zzjk.zzf();
        }
    }

    private final void zzd(int i) throws IOException {
        zzb(i);
        if ((i & 7) != 0) {
            throw zzjk.zzg();
        }
    }

    private final void zze(int i) throws IOException {
        zzb(i);
        if ((i & 3) != 0) {
            throw zzjk.zzg();
        }
    }

    private final void zzf(int i) throws IOException {
        if (this.zzc != i) {
            throw zzjk.zza();
        }
    }
}
