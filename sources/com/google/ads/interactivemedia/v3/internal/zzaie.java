package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaie {
    private static final ThreadLocal zza = new ThreadLocal();
    private boolean zzb = true;
    private final List zzc;
    private String[] zzd = null;

    public zzaie() {
        ArrayList arrayList = new ArrayList();
        this.zzc = arrayList;
        arrayList.add(String.class);
    }

    static Set zza() {
        return (Set) zza.get();
    }

    static zzail zze(Object obj, Object obj2) {
        return new zzaij(new zzaii(obj), new zzaii(obj2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r5.isInstance(r3) == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r6.isInstance(r2) == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzf(java.lang.Object r2, java.lang.Object r3, boolean r4, java.lang.Class r5, boolean r6, java.lang.String... r7) {
        /*
            if (r2 != r3) goto L_0x0004
            r2 = 1
            return r2
        L_0x0004:
            com.google.ads.interactivemedia.v3.internal.zzaie r4 = new com.google.ads.interactivemedia.v3.internal.zzaie
            r4.<init>()
            r4.zzd = r7
            boolean r5 = r4.zzb
            if (r5 != 0) goto L_0x0010
            goto L_0x006e
        L_0x0010:
            if (r2 == r3) goto L_0x006e
            java.lang.Class r5 = r2.getClass()
            java.lang.Class r6 = r3.getClass()
            boolean r7 = r5.isInstance(r3)
            r0 = 0
            if (r7 == 0) goto L_0x0028
            boolean r7 = r6.isInstance(r2)
            if (r7 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0028:
            boolean r7 = r6.isInstance(r2)
            if (r7 == 0) goto L_0x006c
            boolean r7 = r5.isInstance(r3)
            if (r7 != 0) goto L_0x0036
        L_0x0034:
            r7 = r5
            goto L_0x0037
        L_0x0036:
            r7 = r6
        L_0x0037:
            boolean r1 = r7.isArray()     // Catch:{ IllegalArgumentException -> 0x006c }
            if (r1 == 0) goto L_0x0041
            r4.zzd(r2, r3)     // Catch:{ IllegalArgumentException -> 0x006c }
            goto L_0x006e
        L_0x0041:
            java.util.List r1 = r4.zzc     // Catch:{ IllegalArgumentException -> 0x006c }
            boolean r5 = r1.contains(r5)     // Catch:{ IllegalArgumentException -> 0x006c }
            if (r5 != 0) goto L_0x0065
            java.util.List r5 = r4.zzc     // Catch:{ IllegalArgumentException -> 0x006c }
            boolean r5 = r5.contains(r6)     // Catch:{ IllegalArgumentException -> 0x006c }
            if (r5 == 0) goto L_0x0052
            goto L_0x0065
        L_0x0052:
            r4.zzg(r2, r3, r7)     // Catch:{ IllegalArgumentException -> 0x006c }
        L_0x0055:
            java.lang.Class r5 = r7.getSuperclass()     // Catch:{ IllegalArgumentException -> 0x006c }
            if (r5 == 0) goto L_0x006e
            if (r7 == 0) goto L_0x006e
            java.lang.Class r7 = r7.getSuperclass()     // Catch:{ IllegalArgumentException -> 0x006c }
            r4.zzg(r2, r3, r7)     // Catch:{ IllegalArgumentException -> 0x006c }
            goto L_0x0055
        L_0x0065:
            boolean r2 = r2.equals(r3)     // Catch:{ IllegalArgumentException -> 0x006c }
            r4.zzb = r2     // Catch:{ IllegalArgumentException -> 0x006c }
            goto L_0x006e
        L_0x006c:
            r4.zzb = r0
        L_0x006e:
            boolean r2 = r4.zzb
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaie.zzf(java.lang.Object, java.lang.Object, boolean, java.lang.Class, boolean, java.lang.String[]):boolean");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x008d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzg(java.lang.Object r6, java.lang.Object r7, java.lang.Class r8) {
        /*
            r5 = this;
            java.util.Set r0 = zza()
            com.google.ads.interactivemedia.v3.internal.zzail r1 = zze(r6, r7)
            r2 = r1
            com.google.ads.interactivemedia.v3.internal.zzaij r2 = (com.google.ads.interactivemedia.v3.internal.zzaij) r2
            java.lang.Object r3 = r2.zzb
            java.lang.Object r2 = r2.zza
            com.google.ads.interactivemedia.v3.internal.zzaij r4 = new com.google.ads.interactivemedia.v3.internal.zzaij
            r4.<init>(r3, r2)
            if (r0 == 0) goto L_0x0024
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x0023
            boolean r0 = r0.contains(r4)
            if (r0 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            return
        L_0x0024:
            java.util.Set r0 = zza()     // Catch:{ all -> 0x009c }
            if (r0 != 0) goto L_0x0034
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x009c }
            r0.<init>()     // Catch:{ all -> 0x009c }
            java.lang.ThreadLocal r1 = zza     // Catch:{ all -> 0x009c }
            r1.set(r0)     // Catch:{ all -> 0x009c }
        L_0x0034:
            com.google.ads.interactivemedia.v3.internal.zzail r1 = zze(r6, r7)     // Catch:{ all -> 0x009c }
            r0.add(r1)     // Catch:{ all -> 0x009c }
            java.lang.reflect.Field[] r8 = r8.getDeclaredFields()     // Catch:{ all -> 0x009c }
            r0 = 1
            java.lang.reflect.AccessibleObject.setAccessible(r8, r0)     // Catch:{ all -> 0x009c }
            r0 = 0
        L_0x0044:
            int r1 = r8.length     // Catch:{ all -> 0x009c }
            if (r0 >= r1) goto L_0x0098
            boolean r1 = r5.zzb     // Catch:{ all -> 0x009c }
            if (r1 == 0) goto L_0x0098
            r1 = r8[r0]     // Catch:{ all -> 0x009c }
            java.lang.String[] r2 = r5.zzd     // Catch:{ all -> 0x009c }
            java.lang.String r3 = r1.getName()     // Catch:{ all -> 0x009c }
            boolean r2 = com.google.ads.interactivemedia.v3.internal.zzaic.zza(r2, r3)     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0095
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x009c }
            java.lang.String r3 = "$"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0095
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x009c }
            boolean r2 = java.lang.reflect.Modifier.isTransient(r2)     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0095
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x009c }
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0095
            java.lang.Class<com.google.ads.interactivemedia.v3.internal.zzaif> r2 = com.google.ads.interactivemedia.v3.internal.zzaif.class
            boolean r2 = r1.isAnnotationPresent(r2)     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0095
            java.lang.Object r2 = r1.get(r6)     // Catch:{ IllegalAccessException -> 0x008d }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ IllegalAccessException -> 0x008d }
            r5.zzd(r2, r1)     // Catch:{ IllegalAccessException -> 0x008d }
            goto L_0x0095
        L_0x008d:
            java.lang.InternalError r8 = new java.lang.InternalError     // Catch:{ all -> 0x009c }
            java.lang.String r0 = "Unexpected IllegalAccessException"
            r8.<init>(r0)     // Catch:{ all -> 0x009c }
            throw r8     // Catch:{ all -> 0x009c }
        L_0x0095:
            int r0 = r0 + 1
            goto L_0x0044
        L_0x0098:
            zzh(r6, r7)
            return
        L_0x009c:
            r8 = move-exception
            zzh(r6, r7)
            goto L_0x00a2
        L_0x00a1:
            throw r8
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaie.zzg(java.lang.Object, java.lang.Object, java.lang.Class):void");
    }

    private static void zzh(Object obj, Object obj2) {
        Set zza2 = zza();
        if (zza2 != null) {
            zza2.remove(zze(obj, obj2));
            if (zza2.isEmpty()) {
                zza.remove();
            }
        }
    }

    public final zzaie zzb(int i, int i2) {
        if (!this.zzb) {
            return this;
        }
        this.zzb = i == i2;
        return this;
    }

    public final zzaie zzc(long j, long j2) {
        if (!this.zzb) {
            return this;
        }
        this.zzb = j == j2;
        return this;
    }

    public final zzaie zzd(Object obj, Object obj2) {
        if (!this.zzb || obj == obj2) {
            return this;
        }
        int i = 0;
        if (obj == null || obj2 == null) {
            this.zzb = false;
            return this;
        }
        if (!obj.getClass().isArray()) {
            this.zzb = obj.equals(obj2);
        } else if (obj.getClass() != obj2.getClass()) {
            this.zzb = false;
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            long[] jArr2 = (long[]) obj2;
            if (this.zzb && jArr != jArr2) {
                if (jArr.length != jArr2.length) {
                    this.zzb = false;
                } else {
                    while (i < jArr.length && this.zzb) {
                        zzc(jArr[i], jArr2[i]);
                        i++;
                    }
                }
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int[] iArr2 = (int[]) obj2;
            if (this.zzb && iArr != iArr2) {
                if (iArr.length != iArr2.length) {
                    this.zzb = false;
                } else {
                    while (i < iArr.length && this.zzb) {
                        zzb(iArr[i], iArr2[i]);
                        i++;
                    }
                }
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            short[] sArr2 = (short[]) obj2;
            if (this.zzb && sArr != sArr2) {
                if (sArr.length != sArr2.length) {
                    this.zzb = false;
                } else {
                    for (int i2 = 0; i2 < sArr.length && this.zzb; i2++) {
                        this.zzb = sArr[i2] == sArr2[i2];
                    }
                }
            }
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            char[] cArr2 = (char[]) obj2;
            if (this.zzb && cArr != cArr2) {
                if (cArr.length != cArr2.length) {
                    this.zzb = false;
                } else {
                    for (int i3 = 0; i3 < cArr.length && this.zzb; i3++) {
                        this.zzb = cArr[i3] == cArr2[i3];
                    }
                }
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = (byte[]) obj2;
            if (this.zzb && bArr != bArr2) {
                if (bArr.length != bArr2.length) {
                    this.zzb = false;
                } else {
                    for (int i4 = 0; i4 < bArr.length && this.zzb; i4++) {
                        this.zzb = bArr[i4] == bArr2[i4];
                    }
                }
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            double[] dArr2 = (double[]) obj2;
            if (this.zzb && dArr != dArr2) {
                if (dArr.length != dArr2.length) {
                    this.zzb = false;
                } else {
                    while (i < dArr.length && this.zzb) {
                        zzc(Double.doubleToLongBits(dArr[i]), Double.doubleToLongBits(dArr2[i]));
                        i++;
                    }
                }
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            float[] fArr2 = (float[]) obj2;
            if (this.zzb && fArr != fArr2) {
                if (fArr.length != fArr2.length) {
                    this.zzb = false;
                } else {
                    while (i < fArr.length && this.zzb) {
                        zzb(Float.floatToIntBits(fArr[i]), Float.floatToIntBits(fArr2[i]));
                        i++;
                    }
                }
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            boolean[] zArr2 = (boolean[]) obj2;
            if (this.zzb && zArr != zArr2) {
                if (zArr.length != zArr2.length) {
                    this.zzb = false;
                } else {
                    for (int i5 = 0; i5 < zArr.length && this.zzb; i5++) {
                        this.zzb = zArr[i5] == zArr2[i5];
                    }
                }
            }
        } else {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) obj2;
            if (this.zzb && objArr != objArr2) {
                if (objArr.length != objArr2.length) {
                    this.zzb = false;
                } else {
                    while (i < objArr.length && this.zzb) {
                        zzd(objArr[i], objArr2[i]);
                        i++;
                    }
                }
            }
        }
        return this;
    }
}
