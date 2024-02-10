package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzip extends zziq<zzjb.zzf> {
    zzip() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzkk zzkk) {
        return zzkk instanceof zzjb.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zziu<zzjb.zzf> zza(Object obj) {
        return ((zzjb.zzc) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final zziu<zzjb.zzf> zzb(Object obj) {
        return ((zzjb.zzc) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Throwable, com.google.android.gms.internal.vision.zzjh] */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v32 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r1v37 */
    /* JADX WARNING: type inference failed for: r1v38 */
    /* JADX WARNING: type inference failed for: r1v39 */
    /* JADX WARNING: type inference failed for: r1v40 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e3, code lost:
        if (r3 != 18) goto L_0x00f2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <UT, UB> UB zza(com.google.android.gms.internal.vision.zzld r3, java.lang.Object r4, com.google.android.gms.internal.vision.zzio r5, com.google.android.gms.internal.vision.zziu<com.google.android.gms.internal.vision.zzjb.zzf> r6, UB r7, com.google.android.gms.internal.vision.zzlu<UT, UB> r8) throws java.io.IOException {
        /*
            r2 = this;
            com.google.android.gms.internal.vision.zzjb$zze r4 = (com.google.android.gms.internal.vision.zzjb.zze) r4
            com.google.android.gms.internal.vision.zzjb$zzf r8 = r4.zzd
            int r8 = r8.zzb
            com.google.android.gms.internal.vision.zzjb$zzf r8 = r4.zzd
            boolean r8 = r8.zzd
            com.google.android.gms.internal.vision.zzjb$zzf r8 = r4.zzd
            com.google.android.gms.internal.vision.zzml r8 = r8.zzc
            com.google.android.gms.internal.vision.zzml r0 = com.google.android.gms.internal.vision.zzml.ENUM
            r1 = 0
            if (r8 == r0) goto L_0x00f8
            int[] r8 = com.google.android.gms.internal.vision.zzis.zza
            com.google.android.gms.internal.vision.zzjb$zzf r0 = r4.zzd
            com.google.android.gms.internal.vision.zzml r0 = r0.zzc
            int r0 = r0.ordinal()
            r8 = r8[r0]
            switch(r8) {
                case 1: goto L_0x00bd;
                case 2: goto L_0x00b4;
                case 3: goto L_0x00ab;
                case 4: goto L_0x00a2;
                case 5: goto L_0x0099;
                case 6: goto L_0x0090;
                case 7: goto L_0x0087;
                case 8: goto L_0x007e;
                case 9: goto L_0x0075;
                case 10: goto L_0x006c;
                case 11: goto L_0x0063;
                case 12: goto L_0x005a;
                case 13: goto L_0x0050;
                case 14: goto L_0x0048;
                case 15: goto L_0x0042;
                case 16: goto L_0x003c;
                case 17: goto L_0x0030;
                case 18: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x00c5
        L_0x0024:
            com.google.android.gms.internal.vision.zzkk r8 = r4.zzc
            java.lang.Class r8 = r8.getClass()
            java.lang.Object r1 = r3.zza(r8, (com.google.android.gms.internal.vision.zzio) r5)
            goto L_0x00c5
        L_0x0030:
            com.google.android.gms.internal.vision.zzkk r8 = r4.zzc
            java.lang.Class r8 = r8.getClass()
            java.lang.Object r1 = r3.zzb(r8, (com.google.android.gms.internal.vision.zzio) r5)
            goto L_0x00c5
        L_0x003c:
            java.lang.String r1 = r3.zzl()
            goto L_0x00c5
        L_0x0042:
            com.google.android.gms.internal.vision.zzht r1 = r3.zzn()
            goto L_0x00c5
        L_0x0048:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Shouldn't reach here."
            r3.<init>(r4)
            throw r3
        L_0x0050:
            long r0 = r3.zzt()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x00c5
        L_0x005a:
            int r3 = r3.zzs()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x00c5
        L_0x0063:
            long r0 = r3.zzr()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x00c5
        L_0x006c:
            int r3 = r3.zzq()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x00c5
        L_0x0075:
            int r3 = r3.zzo()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x00c5
        L_0x007e:
            boolean r3 = r3.zzk()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
            goto L_0x00c5
        L_0x0087:
            int r3 = r3.zzj()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x00c5
        L_0x0090:
            long r0 = r3.zzi()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x00c5
        L_0x0099:
            int r3 = r3.zzh()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x00c5
        L_0x00a2:
            long r0 = r3.zzf()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x00c5
        L_0x00ab:
            long r0 = r3.zzg()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L_0x00c5
        L_0x00b4:
            float r3 = r3.zze()
            java.lang.Float r1 = java.lang.Float.valueOf(r3)
            goto L_0x00c5
        L_0x00bd:
            double r0 = r3.zzd()
            java.lang.Double r1 = java.lang.Double.valueOf(r0)
        L_0x00c5:
            com.google.android.gms.internal.vision.zzjb$zzf r3 = r4.zzd
            boolean r3 = r3.zzd
            if (r3 == 0) goto L_0x00d1
            com.google.android.gms.internal.vision.zzjb$zzf r3 = r4.zzd
            r6.zzb(r3, r1)
            goto L_0x00f7
        L_0x00d1:
            int[] r3 = com.google.android.gms.internal.vision.zzis.zza
            com.google.android.gms.internal.vision.zzjb$zzf r5 = r4.zzd
            com.google.android.gms.internal.vision.zzml r5 = r5.zzc
            int r5 = r5.ordinal()
            r3 = r3[r5]
            r5 = 17
            if (r3 == r5) goto L_0x00e6
            r5 = 18
            if (r3 == r5) goto L_0x00e6
            goto L_0x00f2
        L_0x00e6:
            com.google.android.gms.internal.vision.zzjb$zzf r3 = r4.zzd
            java.lang.Object r3 = r6.zza(r3)
            if (r3 == 0) goto L_0x00f2
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r3, (java.lang.Object) r1)
        L_0x00f2:
            com.google.android.gms.internal.vision.zzjb$zzf r3 = r4.zzd
            r6.zza(r3, (java.lang.Object) r1)
        L_0x00f7:
            return r7
        L_0x00f8:
            int r3 = r3.zzh()
            r1.zza(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzip.zza(com.google.android.gms.internal.vision.zzld, java.lang.Object, com.google.android.gms.internal.vision.zzio, com.google.android.gms.internal.vision.zziu, java.lang.Object, com.google.android.gms.internal.vision.zzlu):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzjb.zzf) entry.getKey()).zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzmr zzmr, Map.Entry<?, ?> entry) throws IOException {
        zzjb.zzf zzf = (zzjb.zzf) entry.getKey();
        if (zzf.zzd) {
            switch (zzis.zza[zzf.zzc.ordinal()]) {
                case 1:
                    zzle.zza(zzf.zzb, (List<Double>) (List) entry.getValue(), zzmr, false);
                    return;
                case 2:
                    zzle.zzb(zzf.zzb, (List<Float>) (List) entry.getValue(), zzmr, false);
                    return;
                case 3:
                    zzle.zzc(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 4:
                    zzle.zzd(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 5:
                    zzle.zzh(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 6:
                    zzle.zzf(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 7:
                    zzle.zzk(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 8:
                    zzle.zzn(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 9:
                    zzle.zzi(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 10:
                    zzle.zzl(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 11:
                    zzle.zzg(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 12:
                    zzle.zzj(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 13:
                    zzle.zze(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 14:
                    zzle.zzh(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 15:
                    zzle.zzb(zzf.zzb, (List<zzht>) (List) entry.getValue(), zzmr);
                    return;
                case 16:
                    zzle.zza(zzf.zzb, (List<String>) (List) entry.getValue(), zzmr);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzle.zzb(zzf.zzb, (List<?>) (List) entry.getValue(), zzmr, (zzlc) zzky.zza().zza(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzle.zza(zzf.zzb, (List<?>) (List) entry.getValue(), zzmr, (zzlc) zzky.zza().zza(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zzis.zza[zzf.zzc.ordinal()]) {
                case 1:
                    zzmr.zza(zzf.zzb, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    zzmr.zza(zzf.zzb, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    zzmr.zza(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzmr.zzc(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    zzmr.zzc(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    zzmr.zzd(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    zzmr.zzd(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    zzmr.zza(zzf.zzb, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    zzmr.zze(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    zzmr.zza(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    zzmr.zzb(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    zzmr.zzf(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzmr.zze(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    zzmr.zzc(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzmr.zza(zzf.zzb, (zzht) entry.getValue());
                    return;
                case 16:
                    zzmr.zza(zzf.zzb, (String) entry.getValue());
                    return;
                case 17:
                    zzmr.zzb(zzf.zzb, (Object) entry.getValue(), (zzlc) zzky.zza().zza(entry.getValue().getClass()));
                    return;
                case 18:
                    zzmr.zza(zzf.zzb, (Object) entry.getValue(), (zzlc) zzky.zza().zza(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzio zzio, zzkk zzkk, int i) {
        return zzio.zza(zzkk, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzld zzld, Object obj, zzio zzio, zziu<zzjb.zzf> zziu) throws IOException {
        zzjb.zze zze = (zzjb.zze) obj;
        zziu.zza(zze.zzd, (Object) zzld.zza(zze.zzc.getClass(), zzio));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzht zzht, Object obj, zzio zzio, zziu<zzjb.zzf> zziu) throws IOException {
        byte[] bArr;
        zzjb.zze zze = (zzjb.zze) obj;
        zzkk zze2 = zze.zzc.zzq().zze();
        int zza = zzht.zza();
        if (zza == 0) {
            bArr = zzjf.zzb;
        } else {
            byte[] bArr2 = new byte[zza];
            zzht.zza(bArr2, 0, 0, zza);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzho zzho = new zzho(wrap, true);
            zzky.zza().zza(zze2).zza(zze2, zzho, zzio);
            zziu.zza(zze.zzd, (Object) zze2);
            if (zzho.zza() != Integer.MAX_VALUE) {
                throw zzjk.zze();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
