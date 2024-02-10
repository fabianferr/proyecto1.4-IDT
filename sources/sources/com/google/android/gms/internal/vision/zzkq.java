package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzkq<T> implements zzlc<T> {
    private final zzkk zza;
    private final zzlu<?, ?> zzb;
    private final boolean zzc;
    private final zziq<?> zzd;

    private zzkq(zzlu<?, ?> zzlu, zziq<?> zziq, zzkk zzkk) {
        this.zzb = zzlu;
        this.zzc = zziq.zza(zzkk);
        this.zzd = zziq;
        this.zza = zzkk;
    }

    static <T> zzkq<T> zza(zzlu<?, ?> zzlu, zziq<?> zziq, zzkk zzkk) {
        return new zzkq<>(zzlu, zziq, zzkk);
    }

    public final T zza() {
        return this.zza.zzq().zze();
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final void zzb(T t, T t2) {
        zzle.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzle.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzmr zzmr) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zziw zziw = (zziw) next.getKey();
            if (zziw.zzc() != zzmo.MESSAGE || zziw.zzd() || zziw.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzjr) {
                zzmr.zza(zziw.zza(), (Object) ((zzjr) next).zza().zzc());
            } else {
                zzmr.zza(zziw.zza(), next.getValue());
            }
        }
        zzlu<?, ?> zzlu = this.zzb;
        zzlu.zzb(zzlu.zzb(t), zzmr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.android.gms.internal.vision.zzjb$zze} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.vision.zzhn r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.vision.zzjb r0 = (com.google.android.gms.internal.vision.zzjb) r0
            com.google.android.gms.internal.vision.zzlx r1 = r0.zzb
            com.google.android.gms.internal.vision.zzlx r2 = com.google.android.gms.internal.vision.zzlx.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.vision.zzlx r1 = com.google.android.gms.internal.vision.zzlx.zzb()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.vision.zzjb$zzc r11 = (com.google.android.gms.internal.vision.zzjb.zzc) r11
            com.google.android.gms.internal.vision.zziu r11 = r11.zza()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00c9
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r12, r13, r15)
            int r13 = r15.zza
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L_0x0065
            r3 = r13 & 7
            if (r3 != r5) goto L_0x0060
            com.google.android.gms.internal.vision.zziq<?> r2 = r10.zzd
            com.google.android.gms.internal.vision.zzio r3 = r15.zzd
            com.google.android.gms.internal.vision.zzkk r5 = r10.zza
            int r6 = r13 >>> 3
            java.lang.Object r2 = r2.zza(r3, r5, r6)
            r8 = r2
            com.google.android.gms.internal.vision.zzjb$zze r8 = (com.google.android.gms.internal.vision.zzjb.zze) r8
            if (r8 == 0) goto L_0x0055
            com.google.android.gms.internal.vision.zzky r13 = com.google.android.gms.internal.vision.zzky.zza()
            com.google.android.gms.internal.vision.zzkk r2 = r8.zzc
            java.lang.Class r2 = r2.getClass()
            com.google.android.gms.internal.vision.zzlc r13 = r13.zza(r2)
            int r13 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r13, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.zzhn) r15)
            com.google.android.gms.internal.vision.zzjb$zzf r2 = r8.zzd
            java.lang.Object r3 = r15.zzc
            r11.zza(r2, (java.lang.Object) r3)
            goto L_0x005e
        L_0x0055:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.vision.zzhl.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzlx) r6, (com.google.android.gms.internal.vision.zzhn) r7)
        L_0x005e:
            r2 = r8
            goto L_0x0019
        L_0x0060:
            int r13 = com.google.android.gms.internal.vision.zzhl.zza((int) r13, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.zzhn) r15)
            goto L_0x0019
        L_0x0065:
            r13 = 0
            r3 = r0
        L_0x0067:
            if (r4 >= r14) goto L_0x00be
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r12, r4, r15)
            int r6 = r15.zza
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto L_0x00a0
            r9 = 3
            if (r7 == r9) goto L_0x0079
            goto L_0x00b5
        L_0x0079:
            if (r2 == 0) goto L_0x0095
            com.google.android.gms.internal.vision.zzky r6 = com.google.android.gms.internal.vision.zzky.zza()
            com.google.android.gms.internal.vision.zzkk r7 = r2.zzc
            java.lang.Class r7 = r7.getClass()
            com.google.android.gms.internal.vision.zzlc r6 = r6.zza(r7)
            int r4 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r6, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.zzhn) r15)
            com.google.android.gms.internal.vision.zzjb$zzf r6 = r2.zzd
            java.lang.Object r7 = r15.zzc
            r11.zza(r6, (java.lang.Object) r7)
            goto L_0x0067
        L_0x0095:
            if (r8 != r5) goto L_0x00b5
            int r4 = com.google.android.gms.internal.vision.zzhl.zze(r12, r4, r15)
            java.lang.Object r3 = r15.zzc
            com.google.android.gms.internal.vision.zzht r3 = (com.google.android.gms.internal.vision.zzht) r3
            goto L_0x0067
        L_0x00a0:
            if (r8 != 0) goto L_0x00b5
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r12, r4, r15)
            int r13 = r15.zza
            com.google.android.gms.internal.vision.zziq<?> r2 = r10.zzd
            com.google.android.gms.internal.vision.zzio r6 = r15.zzd
            com.google.android.gms.internal.vision.zzkk r7 = r10.zza
            java.lang.Object r2 = r2.zza(r6, r7, r13)
            com.google.android.gms.internal.vision.zzjb$zze r2 = (com.google.android.gms.internal.vision.zzjb.zze) r2
            goto L_0x0067
        L_0x00b5:
            r7 = 12
            if (r6 == r7) goto L_0x00be
            int r4 = com.google.android.gms.internal.vision.zzhl.zza((int) r6, (byte[]) r12, (int) r4, (int) r14, (com.google.android.gms.internal.vision.zzhn) r15)
            goto L_0x0067
        L_0x00be:
            if (r3 == 0) goto L_0x00c6
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.zza((int) r13, (java.lang.Object) r3)
        L_0x00c6:
            r13 = r4
            goto L_0x0019
        L_0x00c9:
            if (r13 != r14) goto L_0x00cc
            return
        L_0x00cc:
            com.google.android.gms.internal.vision.zzjk r11 = com.google.android.gms.internal.vision.zzjk.zzg()
            goto L_0x00d2
        L_0x00d1:
            throw r11
        L_0x00d2:
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzkq.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzhn):void");
    }

    public final void zza(T t, zzld zzld, zzio zzio) throws IOException {
        boolean z;
        zzlu<?, ?> zzlu = this.zzb;
        zziq<?> zziq = this.zzd;
        Object zzc2 = zzlu.zzc(t);
        zziu<?> zzb2 = zziq.zzb(t);
        do {
            try {
                if (zzld.zza() == Integer.MAX_VALUE) {
                    zzlu.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzld.zzb();
                if (zzb3 == 11) {
                    Object obj = null;
                    zzht zzht = null;
                    int i = 0;
                    while (zzld.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzld.zzb();
                        if (zzb4 == 16) {
                            i = zzld.zzo();
                            obj = zziq.zza(zzio, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zziq.zza(zzld, obj, zzio, zzb2);
                            } else {
                                zzht = zzld.zzn();
                            }
                        } else if (!zzld.zzc()) {
                            break;
                        }
                    }
                    if (zzld.zzb() != 12) {
                        throw zzjk.zze();
                    } else if (zzht != null) {
                        if (obj != null) {
                            zziq.zza(zzht, obj, zzio, zzb2);
                        } else {
                            zzlu.zza(zzc2, i, zzht);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zziq.zza(zzio, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zziq.zza(zzld, zza2, zzio, zzb2);
                    } else {
                        z = zzlu.zza(zzc2, zzld);
                        continue;
                    }
                } else {
                    z = zzld.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzlu.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    public final int zzb(T t) {
        zzlu<?, ?> zzlu = this.zzb;
        int zze = zzlu.zze(zzlu.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }
}
