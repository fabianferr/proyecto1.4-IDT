package com.google.ads.interactivemedia.v3.internal;

import java.util.Set;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaig {
    private static final ThreadLocal zza = new ThreadLocal();
    private int zzb = 17;

    public zzaig() {
    }

    public zzaig(int i, int i2) {
    }

    public static int zza(Object obj, String... strArr) {
        zzaig zzaig = new zzaig(17, 37);
        Class cls = obj.getClass();
        zze(obj, cls, zzaig, false, strArr);
        while (cls.getSuperclass() != null && cls != null) {
            cls = cls.getSuperclass();
            zze(obj, cls, zzaig, false, strArr);
        }
        return zzaig.zzb;
    }

    static Set zzb() {
        return (Set) zza.get();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zze(java.lang.Object r4, java.lang.Class r5, com.google.ads.interactivemedia.v3.internal.zzaig r6, boolean r7, java.lang.String[] r8) {
        /*
            java.util.Set r7 = zzb()
            if (r7 == 0) goto L_0x0013
            com.google.ads.interactivemedia.v3.internal.zzaii r0 = new com.google.ads.interactivemedia.v3.internal.zzaii
            r0.<init>(r4)
            boolean r7 = r7.contains(r0)
            if (r7 != 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            return
        L_0x0013:
            java.util.Set r7 = zzb()     // Catch:{ all -> 0x0082 }
            if (r7 != 0) goto L_0x0023
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ all -> 0x0082 }
            r7.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.ThreadLocal r0 = zza     // Catch:{ all -> 0x0082 }
            r0.set(r7)     // Catch:{ all -> 0x0082 }
        L_0x0023:
            com.google.ads.interactivemedia.v3.internal.zzaii r0 = new com.google.ads.interactivemedia.v3.internal.zzaii     // Catch:{ all -> 0x0082 }
            r0.<init>(r4)     // Catch:{ all -> 0x0082 }
            r7.add(r0)     // Catch:{ all -> 0x0082 }
            java.lang.reflect.Field[] r5 = r5.getDeclaredFields()     // Catch:{ all -> 0x0082 }
            r7 = 1
            java.lang.reflect.AccessibleObject.setAccessible(r5, r7)     // Catch:{ all -> 0x0082 }
            int r7 = r5.length     // Catch:{ all -> 0x0082 }
            r0 = 0
        L_0x0035:
            if (r0 >= r7) goto L_0x007e
            r1 = r5[r0]     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x0082 }
            boolean r2 = com.google.ads.interactivemedia.v3.internal.zzaic.zza(r8, r2)     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x007b
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "$"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x007b
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x0082 }
            boolean r2 = java.lang.reflect.Modifier.isTransient(r2)     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x007b
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x0082 }
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x007b
            java.lang.Class<com.google.ads.interactivemedia.v3.internal.zzaih> r2 = com.google.ads.interactivemedia.v3.internal.zzaih.class
            boolean r2 = r1.isAnnotationPresent(r2)     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x007b
            java.lang.Object r1 = r1.get(r4)     // Catch:{ IllegalAccessException -> 0x0073 }
            r6.zzd(r1)     // Catch:{ IllegalAccessException -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            java.lang.InternalError r5 = new java.lang.InternalError     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = "Unexpected IllegalAccessException"
            r5.<init>(r6)     // Catch:{ all -> 0x0082 }
            throw r5     // Catch:{ all -> 0x0082 }
        L_0x007b:
            int r0 = r0 + 1
            goto L_0x0035
        L_0x007e:
            zzf(r4)
            return
        L_0x0082:
            r5 = move-exception
            zzf(r4)
            goto L_0x0088
        L_0x0087:
            throw r5
        L_0x0088:
            goto L_0x0087
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaig.zze(java.lang.Object, java.lang.Class, com.google.ads.interactivemedia.v3.internal.zzaig, boolean, java.lang.String[]):void");
    }

    private static void zzf(Object obj) {
        Set zzb2 = zzb();
        if (zzb2 != null) {
            zzb2.remove(new zzaii(obj));
            if (zzb2.isEmpty()) {
                zza.remove();
            }
        }
    }

    public final int hashCode() {
        return this.zzb;
    }

    public final zzaig zzc(long j) {
        this.zzb = (this.zzb * 37) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public final zzaig zzd(Object obj) {
        if (obj == null) {
            this.zzb *= 37;
        } else if (obj.getClass().isArray()) {
            int i = 0;
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length = jArr.length;
                while (i < length) {
                    zzc(jArr[i]);
                    i++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length2 = iArr.length;
                while (i < length2) {
                    this.zzb = (this.zzb * 37) + iArr[i];
                    i++;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length3 = sArr.length;
                while (i < length3) {
                    this.zzb = (this.zzb * 37) + sArr[i];
                    i++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                int length4 = cArr.length;
                while (i < length4) {
                    this.zzb = (this.zzb * 37) + cArr[i];
                    i++;
                }
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length5 = bArr.length;
                while (i < length5) {
                    this.zzb = (this.zzb * 37) + bArr[i];
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length6 = dArr.length;
                while (i < length6) {
                    zzc(Double.doubleToLongBits(dArr[i]));
                    i++;
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int length7 = fArr.length;
                while (i < length7) {
                    this.zzb = (this.zzb * 37) + Float.floatToIntBits(fArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length8 = zArr.length;
                while (i < length8) {
                    this.zzb = (this.zzb * 37) + (zArr[i] ^ true ? 1 : 0);
                    i++;
                }
            } else {
                Object[] objArr = (Object[]) obj;
                int length9 = objArr.length;
                while (i < length9) {
                    zzd(objArr[i]);
                    i++;
                }
            }
        } else {
            this.zzb = (this.zzb * 37) + obj.hashCode();
        }
        return this;
    }
}
