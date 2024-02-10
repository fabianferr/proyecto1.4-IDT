package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzsq {
    Object[] zza;
    int zzb;
    zzsp zzc;

    public zzsq() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzsj.zza(length, i2));
        }
    }

    public final zzsq zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzrv.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.ads.interactivemedia.v3.internal.zzsq zzb(java.lang.Iterable r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 == 0) goto L_0x000e
            int r0 = r2.zzb
            int r1 = r3.size()
            int r0 = r0 + r1
            r2.zzd(r0)
        L_0x000e:
            java.util.Iterator r3 = r3.iterator()
        L_0x0012:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            r2.zza(r1, r0)
            goto L_0x0012
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzsq.zzb(java.lang.Iterable):com.google.ads.interactivemedia.v3.internal.zzsq");
    }

    public final zzsr zzc() {
        zzsp zzsp = this.zzc;
        if (zzsp == null) {
            zztn zzj = zztn.zzj(this.zzb, this.zza, this);
            zzsp zzsp2 = this.zzc;
            if (zzsp2 == null) {
                return zzj;
            }
            throw zzsp2.zza();
        }
        throw zzsp.zza();
    }

    zzsq(int i) {
        this.zza = new Object[(i + i)];
        this.zzb = 0;
    }
}
