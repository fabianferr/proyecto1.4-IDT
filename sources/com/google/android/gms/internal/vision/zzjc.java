package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzjc implements zzkl {
    private static final zzjc zza = new zzjc();

    private zzjc() {
    }

    public static zzjc zza() {
        return zza;
    }

    public final boolean zza(Class<?> cls) {
        return zzjb.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.vision.zzki zzb(java.lang.Class<?> r5) {
        /*
            r4 = this;
            java.lang.Class<com.google.android.gms.internal.vision.zzjb> r0 = com.google.android.gms.internal.vision.zzjb.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 != 0) goto L_0x0028
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.getName()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r1 = r5.length()
            java.lang.String r2 = "Unsupported message type: "
            if (r1 == 0) goto L_0x001f
            java.lang.String r5 = r2.concat(r5)
            goto L_0x0024
        L_0x001f:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r2)
        L_0x0024:
            r0.<init>(r5)
            throw r0
        L_0x0028:
            java.lang.Class<com.google.android.gms.internal.vision.zzjb> r0 = com.google.android.gms.internal.vision.zzjb.class
            java.lang.Class r0 = r5.asSubclass(r0)     // Catch:{ Exception -> 0x003c }
            com.google.android.gms.internal.vision.zzjb r0 = com.google.android.gms.internal.vision.zzjb.zza(r0)     // Catch:{ Exception -> 0x003c }
            int r1 = com.google.android.gms.internal.vision.zzjb.zzg.zzc     // Catch:{ Exception -> 0x003c }
            r2 = 0
            java.lang.Object r0 = r0.zza((int) r1, (java.lang.Object) r2, (java.lang.Object) r2)     // Catch:{ Exception -> 0x003c }
            com.google.android.gms.internal.vision.zzki r0 = (com.google.android.gms.internal.vision.zzki) r0     // Catch:{ Exception -> 0x003c }
            return r0
        L_0x003c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r5 = r5.getName()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r2 = r5.length()
            java.lang.String r3 = "Unable to get message info for "
            if (r2 == 0) goto L_0x0054
            java.lang.String r5 = r3.concat(r5)
            goto L_0x0059
        L_0x0054:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
        L_0x0059:
            r1.<init>(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjc.zzb(java.lang.Class):com.google.android.gms.internal.vision.zzki");
    }
}
