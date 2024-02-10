package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzyl {
    private final Map zza;
    private final List zzb;

    public zzyl(Map map, boolean z, List list) {
        this.zza = map;
        this.zzb = list;
    }

    static String zzb(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(String.valueOf(cls.getName()));
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(String.valueOf(cls.getName()));
        }
        return null;
    }

    public final String toString() {
        return this.zza.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0191 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.ads.interactivemedia.v3.internal.zzyz zza(com.google.ads.interactivemedia.v3.internal.zzact r11) {
        /*
            r10 = this;
            java.lang.reflect.Type r0 = r11.zzd()
            java.lang.Class r11 = r11.zzc()
            java.util.Map r1 = r10.zza
            java.lang.Object r1 = r1.get(r0)
            com.google.ads.interactivemedia.v3.internal.zzwo r1 = (com.google.ads.interactivemedia.v3.internal.zzwo) r1
            if (r1 == 0) goto L_0x0018
            com.google.ads.interactivemedia.v3.internal.zzyc r11 = new com.google.ads.interactivemedia.v3.internal.zzyc
            r11.<init>(r10, r1, r0)
            return r11
        L_0x0018:
            java.util.Map r1 = r10.zza
            java.lang.Object r1 = r1.get(r11)
            com.google.ads.interactivemedia.v3.internal.zzwo r1 = (com.google.ads.interactivemedia.v3.internal.zzwo) r1
            if (r1 != 0) goto L_0x0192
            java.lang.Class<java.util.EnumSet> r1 = java.util.EnumSet.class
            boolean r1 = r1.isAssignableFrom(r11)
            r2 = 0
            if (r1 == 0) goto L_0x0031
            com.google.ads.interactivemedia.v3.internal.zzyg r1 = new com.google.ads.interactivemedia.v3.internal.zzyg
            r1.<init>(r0)
            goto L_0x003c
        L_0x0031:
            java.lang.Class<java.util.EnumMap> r1 = java.util.EnumMap.class
            if (r11 != r1) goto L_0x003b
            com.google.ads.interactivemedia.v3.internal.zzyh r1 = new com.google.ads.interactivemedia.v3.internal.zzyh
            r1.<init>(r0)
            goto L_0x003c
        L_0x003b:
            r1 = r2
        L_0x003c:
            if (r1 == 0) goto L_0x003f
            return r1
        L_0x003f:
            java.util.List r1 = r10.zzb
            int r1 = com.google.ads.interactivemedia.v3.internal.zzze.zze(r1, r11)
            int r3 = r11.getModifiers()
            boolean r3 = java.lang.reflect.Modifier.isAbstract(r3)
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0054
        L_0x0051:
            r6 = r2
            goto L_0x00c8
        L_0x0054:
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x00c6 }
            java.lang.reflect.Constructor r3 = r11.getDeclaredConstructor(r3)     // Catch:{ NoSuchMethodException -> 0x00c6 }
            if (r1 == r5) goto L_0x008f
            com.google.ads.interactivemedia.v3.internal.zzzd r6 = com.google.ads.interactivemedia.v3.internal.zzzd.zzb
            boolean r6 = r6.zza(r3, r2)
            if (r6 == 0) goto L_0x0072
            r6 = 4
            if (r1 != r6) goto L_0x008f
            int r6 = r3.getModifiers()
            boolean r6 = java.lang.reflect.Modifier.isPublic(r6)
            if (r6 == 0) goto L_0x0072
            goto L_0x008f
        L_0x0072:
            java.lang.String r3 = java.lang.String.valueOf(r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Unable to invoke no-args constructor of "
            r6.<init>(r7)
            r6.append(r3)
            java.lang.String r3 = "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter."
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            com.google.ads.interactivemedia.v3.internal.zzyi r6 = new com.google.ads.interactivemedia.v3.internal.zzyi
            r6.<init>(r3)
            goto L_0x00c8
        L_0x008f:
            if (r1 != r5) goto L_0x00c0
            int r6 = com.google.ads.interactivemedia.v3.internal.zzacg.zza
            r3.setAccessible(r5)     // Catch:{ Exception -> 0x0098 }
            r6 = r2
            goto L_0x00b7
        L_0x0098:
            r6 = move-exception
            java.lang.String r7 = com.google.ads.interactivemedia.v3.internal.zzacg.zzc(r3)
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Failed making constructor '"
            r8.<init>(r9)
            r8.append(r7)
            java.lang.String r7 = "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: "
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
        L_0x00b7:
            if (r6 == 0) goto L_0x00c0
            com.google.ads.interactivemedia.v3.internal.zzyj r3 = new com.google.ads.interactivemedia.v3.internal.zzyj
            r3.<init>(r6)
            r6 = r3
            goto L_0x00c8
        L_0x00c0:
            com.google.ads.interactivemedia.v3.internal.zzyk r6 = new com.google.ads.interactivemedia.v3.internal.zzyk
            r6.<init>(r3)
            goto L_0x00c8
        L_0x00c6:
            goto L_0x0051
        L_0x00c8:
            if (r6 != 0) goto L_0x0191
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r11)
            if (r3 == 0) goto L_0x0104
            java.lang.Class<java.util.SortedSet> r0 = java.util.SortedSet.class
            boolean r0 = r0.isAssignableFrom(r11)
            if (r0 == 0) goto L_0x00e1
            com.google.ads.interactivemedia.v3.internal.zzxs r2 = new com.google.ads.interactivemedia.v3.internal.zzxs
            r2.<init>()
            goto L_0x015d
        L_0x00e1:
            java.lang.Class<java.util.Set> r0 = java.util.Set.class
            boolean r0 = r0.isAssignableFrom(r11)
            if (r0 == 0) goto L_0x00f0
            com.google.ads.interactivemedia.v3.internal.zzxt r2 = new com.google.ads.interactivemedia.v3.internal.zzxt
            r2.<init>()
            goto L_0x015d
        L_0x00f0:
            java.lang.Class<java.util.Queue> r0 = java.util.Queue.class
            boolean r0 = r0.isAssignableFrom(r11)
            if (r0 == 0) goto L_0x00fe
            com.google.ads.interactivemedia.v3.internal.zzxu r2 = new com.google.ads.interactivemedia.v3.internal.zzxu
            r2.<init>()
            goto L_0x015d
        L_0x00fe:
            com.google.ads.interactivemedia.v3.internal.zzxv r2 = new com.google.ads.interactivemedia.v3.internal.zzxv
            r2.<init>()
            goto L_0x015d
        L_0x0104:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r11)
            if (r3 == 0) goto L_0x015d
            java.lang.Class<java.util.concurrent.ConcurrentNavigableMap> r2 = java.util.concurrent.ConcurrentNavigableMap.class
            boolean r2 = r2.isAssignableFrom(r11)
            if (r2 == 0) goto L_0x011a
            com.google.ads.interactivemedia.v3.internal.zzxw r2 = new com.google.ads.interactivemedia.v3.internal.zzxw
            r2.<init>()
            goto L_0x015d
        L_0x011a:
            java.lang.Class<java.util.concurrent.ConcurrentMap> r2 = java.util.concurrent.ConcurrentMap.class
            boolean r2 = r2.isAssignableFrom(r11)
            if (r2 == 0) goto L_0x0128
            com.google.ads.interactivemedia.v3.internal.zzxx r2 = new com.google.ads.interactivemedia.v3.internal.zzxx
            r2.<init>()
            goto L_0x015d
        L_0x0128:
            java.lang.Class<java.util.SortedMap> r2 = java.util.SortedMap.class
            boolean r2 = r2.isAssignableFrom(r11)
            if (r2 == 0) goto L_0x0136
            com.google.ads.interactivemedia.v3.internal.zzxy r2 = new com.google.ads.interactivemedia.v3.internal.zzxy
            r2.<init>()
            goto L_0x015d
        L_0x0136:
            boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x0158
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type[] r0 = r0.getActualTypeArguments()
            r0 = r0[r4]
            com.google.ads.interactivemedia.v3.internal.zzact r0 = com.google.ads.interactivemedia.v3.internal.zzact.zzb(r0)
            java.lang.Class r0 = r0.zzc()
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            boolean r0 = r2.isAssignableFrom(r0)
            if (r0 != 0) goto L_0x0158
            com.google.ads.interactivemedia.v3.internal.zzxz r2 = new com.google.ads.interactivemedia.v3.internal.zzxz
            r2.<init>()
            goto L_0x015d
        L_0x0158:
            com.google.ads.interactivemedia.v3.internal.zzya r2 = new com.google.ads.interactivemedia.v3.internal.zzya
            r2.<init>()
        L_0x015d:
            if (r2 == 0) goto L_0x0160
            return r2
        L_0x0160:
            java.lang.String r0 = zzb(r11)
            if (r0 == 0) goto L_0x016c
            com.google.ads.interactivemedia.v3.internal.zzye r11 = new com.google.ads.interactivemedia.v3.internal.zzye
            r11.<init>(r10, r0)
            return r11
        L_0x016c:
            if (r1 != r5) goto L_0x0174
            com.google.ads.interactivemedia.v3.internal.zzyb r0 = new com.google.ads.interactivemedia.v3.internal.zzyb
            r0.<init>(r10, r11)
            return r0
        L_0x0174:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to create instance of "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r11 = "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection."
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.google.ads.interactivemedia.v3.internal.zzyf r0 = new com.google.ads.interactivemedia.v3.internal.zzyf
            r0.<init>(r10, r11)
            return r0
        L_0x0191:
            return r6
        L_0x0192:
            com.google.ads.interactivemedia.v3.internal.zzyd r11 = new com.google.ads.interactivemedia.v3.internal.zzyd
            r11.<init>(r10, r1, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzyl.zza(com.google.ads.interactivemedia.v3.internal.zzact):com.google.ads.interactivemedia.v3.internal.zzyz");
    }
}
