package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzzt implements zzxj {
    private final zzyl zza;

    public zzzt(zzyl zzyl) {
        this.zza = zzyl;
    }

    /* JADX WARNING: type inference failed for: r7v13, types: [com.google.ads.interactivemedia.v3.internal.zzxi] */
    /* JADX WARNING: type inference failed for: r7v14, types: [com.google.ads.interactivemedia.v3.internal.zzxi] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final com.google.ads.interactivemedia.v3.internal.zzxi zzb(com.google.ads.interactivemedia.v3.internal.zzyl r7, com.google.ads.interactivemedia.v3.internal.zzwm r8, com.google.ads.interactivemedia.v3.internal.zzact r9, com.google.ads.interactivemedia.v3.internal.zzxk r10) {
        /*
            java.lang.Class r0 = r10.zza()
            com.google.ads.interactivemedia.v3.internal.zzact r0 = com.google.ads.interactivemedia.v3.internal.zzact.zza(r0)
            com.google.ads.interactivemedia.v3.internal.zzyz r7 = r7.zza(r0)
            java.lang.Object r7 = r7.zza()
            boolean r6 = r10.zzb()
            boolean r10 = r7 instanceof com.google.ads.interactivemedia.v3.internal.zzxi
            if (r10 == 0) goto L_0x001b
            com.google.ads.interactivemedia.v3.internal.zzxi r7 = (com.google.ads.interactivemedia.v3.internal.zzxi) r7
            goto L_0x0075
        L_0x001b:
            boolean r10 = r7 instanceof com.google.ads.interactivemedia.v3.internal.zzxj
            if (r10 == 0) goto L_0x0026
            com.google.ads.interactivemedia.v3.internal.zzxj r7 = (com.google.ads.interactivemedia.v3.internal.zzxj) r7
            com.google.ads.interactivemedia.v3.internal.zzxi r7 = r7.zza(r8, r9)
            goto L_0x0075
        L_0x0026:
            boolean r10 = r7 instanceof com.google.ads.interactivemedia.v3.internal.zzwy
            r0 = 0
            if (r10 != 0) goto L_0x005e
            boolean r10 = r7 instanceof com.google.ads.interactivemedia.v3.internal.zzwq
            if (r10 == 0) goto L_0x0031
            r1 = r0
            goto L_0x0062
        L_0x0031:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getName()
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            r10.<init>(r0)
            r10.append(r7)
            java.lang.String r7 = " as a @JsonAdapter for "
            r10.append(r7)
            r10.append(r9)
            java.lang.String r7 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            r8.<init>(r7)
            throw r8
        L_0x005e:
            r10 = r7
            com.google.ads.interactivemedia.v3.internal.zzwy r10 = (com.google.ads.interactivemedia.v3.internal.zzwy) r10
            r1 = r10
        L_0x0062:
            boolean r10 = r7 instanceof com.google.ads.interactivemedia.v3.internal.zzwq
            if (r10 == 0) goto L_0x006a
            com.google.ads.interactivemedia.v3.internal.zzwq r7 = (com.google.ads.interactivemedia.v3.internal.zzwq) r7
            r2 = r7
            goto L_0x006b
        L_0x006a:
            r2 = r0
        L_0x006b:
            com.google.ads.interactivemedia.v3.internal.zzaal r7 = new com.google.ads.interactivemedia.v3.internal.zzaal
            r5 = 0
            r0 = r7
            r3 = r8
            r4 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = 0
        L_0x0075:
            if (r7 == 0) goto L_0x007d
            if (r6 == 0) goto L_0x007d
            com.google.ads.interactivemedia.v3.internal.zzxi r7 = r7.nullSafe()
        L_0x007d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzzt.zzb(com.google.ads.interactivemedia.v3.internal.zzyl, com.google.ads.interactivemedia.v3.internal.zzwm, com.google.ads.interactivemedia.v3.internal.zzact, com.google.ads.interactivemedia.v3.internal.zzxk):com.google.ads.interactivemedia.v3.internal.zzxi");
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        zzxk zzxk = (zzxk) zzact.zzc().getAnnotation(zzxk.class);
        if (zzxk == null) {
            return null;
        }
        return zzb(this.zza, zzwm, zzact, zzxk);
    }
}
