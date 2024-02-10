package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzaag implements zzxj {
    private final zzyl zza;
    private final zzwf zzb;
    private final zzyn zzc;
    private final zzzt zzd;
    private final List zze;

    public zzaag(zzyl zzyl, zzwf zzwf, zzyn zzyn, zzzt zzzt, List list) {
        this.zza = zzyl;
        this.zzb = zzwf;
        this.zzc = zzyn;
        this.zzd = zzzt;
        this.zze = list;
    }

    static /* bridge */ /* synthetic */ void zzb(Object obj, AccessibleObject accessibleObject) {
        if (true == Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!zzze.zza(accessibleObject, obj)) {
            throw new zzws(zzacg.zze(accessibleObject, true).concat(" is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.google.ads.interactivemedia.v3.internal.zzaad} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x021d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x020a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Map zzc(com.google.ads.interactivemedia.v3.internal.zzwm r38, com.google.ads.interactivemedia.v3.internal.zzact r39, java.lang.Class r40, boolean r41, boolean r42) {
        /*
            r37 = this;
            r14 = r37
            r15 = r38
            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
            r13.<init>()
            boolean r0 = r40.isInterface()
            if (r0 != 0) goto L_0x027e
            r16 = r39
            r12 = r40
            r0 = r41
        L_0x0015:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            if (r12 == r1) goto L_0x027c
            java.lang.reflect.Field[] r11 = r12.getDeclaredFields()
            r10 = 1
            r9 = 0
            r8 = r40
            if (r12 == r8) goto L_0x0061
            int r1 = r11.length
            if (r1 <= 0) goto L_0x0061
            java.util.List r0 = r14.zze
            int r0 = com.google.ads.interactivemedia.v3.internal.zzze.zze(r0, r12)
            r1 = 4
            if (r0 == r1) goto L_0x0038
            r1 = 3
            if (r0 != r1) goto L_0x0035
            r17 = 1
            goto L_0x0063
        L_0x0035:
            r17 = 0
            goto L_0x0063
        L_0x0038:
            com.google.ads.interactivemedia.v3.internal.zzws r0 = new com.google.ads.interactivemedia.v3.internal.zzws
            java.lang.String r1 = java.lang.String.valueOf(r12)
            java.lang.String r2 = java.lang.String.valueOf(r40)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "ReflectionAccessFilter does not permit using reflection for "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " (supertype of "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = "). Register a TypeAdapter for this type or adjust the access filter."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0061:
            r17 = r0
        L_0x0063:
            int r7 = r11.length
            r6 = 0
        L_0x0065:
            if (r6 >= r7) goto L_0x025b
            r5 = r11[r6]
            boolean r0 = r14.zzd(r5, r10)
            boolean r1 = r14.zzd(r5, r9)
            if (r0 != 0) goto L_0x0085
            if (r1 != 0) goto L_0x0084
            r31 = r6
            r32 = r7
            r35 = r11
            r39 = r12
            r15 = r13
            r33 = 0
            r34 = 1
            goto L_0x020a
        L_0x0084:
            r1 = 1
        L_0x0085:
            r18 = 0
            if (r42 == 0) goto L_0x00d4
            int r2 = r5.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)
            if (r2 == 0) goto L_0x0098
            r20 = r18
            r19 = 0
            goto L_0x00d8
        L_0x0098:
            java.lang.reflect.Method r2 = com.google.ads.interactivemedia.v3.internal.zzacg.zzg(r12, r5)
            if (r17 != 0) goto L_0x00a1
            com.google.ads.interactivemedia.v3.internal.zzacg.zzh(r2)
        L_0x00a1:
            java.lang.Class<com.google.ads.interactivemedia.v3.internal.zzxl> r3 = com.google.ads.interactivemedia.v3.internal.zzxl.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)
            if (r3 == 0) goto L_0x00cf
            java.lang.Class<com.google.ads.interactivemedia.v3.internal.zzxl> r3 = com.google.ads.interactivemedia.v3.internal.zzxl.class
            java.lang.annotation.Annotation r3 = r5.getAnnotation(r3)
            if (r3 == 0) goto L_0x00b2
            goto L_0x00cf
        L_0x00b2:
            java.lang.String r0 = com.google.ads.interactivemedia.v3.internal.zzacg.zze(r2, r9)
            com.google.ads.interactivemedia.v3.internal.zzws r1 = new com.google.ads.interactivemedia.v3.internal.zzws
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "@SerializedName on "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = " is not supported"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x00cf:
            r19 = r1
            r20 = r2
            goto L_0x00d8
        L_0x00d4:
            r19 = r1
            r20 = r18
        L_0x00d8:
            if (r17 != 0) goto L_0x00df
            if (r20 != 0) goto L_0x00df
            com.google.ads.interactivemedia.v3.internal.zzacg.zzh(r5)
        L_0x00df:
            java.lang.reflect.Type r1 = r16.zzd()
            java.lang.reflect.Type r2 = r5.getGenericType()
            java.lang.reflect.Type r21 = com.google.ads.interactivemedia.v3.internal.zzxr.zze(r1, r12, r2)
            java.lang.Class<com.google.ads.interactivemedia.v3.internal.zzxl> r1 = com.google.ads.interactivemedia.v3.internal.zzxl.class
            java.lang.annotation.Annotation r1 = r5.getAnnotation(r1)
            com.google.ads.interactivemedia.v3.internal.zzxl r1 = (com.google.ads.interactivemedia.v3.internal.zzxl) r1
            if (r1 != 0) goto L_0x0110
            com.google.ads.interactivemedia.v3.internal.zzwf r1 = r14.zzb
            java.lang.Enum r1 = (java.lang.Enum) r1
            int r1 = r1.ordinal()
            switch(r1) {
                case 0: goto L_0x0107;
                case 1: goto L_0x0106;
                case 2: goto L_0x0105;
                case 3: goto L_0x0104;
                case 4: goto L_0x0103;
                case 5: goto L_0x0102;
                case 6: goto L_0x0101;
                default: goto L_0x0100;
            }
        L_0x0100:
            throw r18
        L_0x0101:
            throw r18
        L_0x0102:
            throw r18
        L_0x0103:
            throw r18
        L_0x0104:
            throw r18
        L_0x0105:
            throw r18
        L_0x0106:
            throw r18
        L_0x0107:
            java.lang.String r1 = r5.getName()
            java.util.List r1 = java.util.Collections.singletonList(r1)
            goto L_0x011f
        L_0x0110:
            java.lang.String r2 = r1.zza()
            java.lang.String[] r1 = r1.zzb()
            int r3 = r1.length
            if (r3 != 0) goto L_0x0121
            java.util.List r1 = java.util.Collections.singletonList(r2)
        L_0x011f:
            r4 = r1
            goto L_0x012e
        L_0x0121:
            int r3 = r3 + 1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
            r4.add(r2)
            java.util.Collections.addAll(r4, r1)
        L_0x012e:
            int r3 = r4.size()
            r1 = r18
            r2 = 0
        L_0x0135:
            if (r2 >= r3) goto L_0x01f7
            java.lang.Object r22 = r4.get(r2)
            r23 = r13
            r13 = r22
            java.lang.String r13 = (java.lang.String) r13
            if (r2 == 0) goto L_0x0146
            r22 = 0
            goto L_0x0148
        L_0x0146:
            r22 = 1
        L_0x0148:
            r22 = r22 & r0
            com.google.ads.interactivemedia.v3.internal.zzact r0 = com.google.ads.interactivemedia.v3.internal.zzact.zzb(r21)
            java.lang.Class r9 = r0.zzc()
            boolean r10 = r9 instanceof java.lang.Class
            if (r10 == 0) goto L_0x015f
            boolean r9 = r9.isPrimitive()
            if (r9 == 0) goto L_0x015f
            r24 = 1
            goto L_0x0161
        L_0x015f:
            r24 = 0
        L_0x0161:
            int r9 = r5.getModifiers()
            boolean r10 = java.lang.reflect.Modifier.isStatic(r9)
            if (r10 == 0) goto L_0x0174
            boolean r9 = java.lang.reflect.Modifier.isFinal(r9)
            if (r9 == 0) goto L_0x0174
            r25 = 1
            goto L_0x0176
        L_0x0174:
            r25 = 0
        L_0x0176:
            java.lang.Class<com.google.ads.interactivemedia.v3.internal.zzxk> r9 = com.google.ads.interactivemedia.v3.internal.zzxk.class
            java.lang.annotation.Annotation r9 = r5.getAnnotation(r9)
            com.google.ads.interactivemedia.v3.internal.zzxk r9 = (com.google.ads.interactivemedia.v3.internal.zzxk) r9
            if (r9 == 0) goto L_0x0187
            com.google.ads.interactivemedia.v3.internal.zzyl r10 = r14.zza
            com.google.ads.interactivemedia.v3.internal.zzxi r9 = com.google.ads.interactivemedia.v3.internal.zzzt.zzb(r10, r15, r0, r9)
            goto L_0x0189
        L_0x0187:
            r9 = r18
        L_0x0189:
            if (r9 == 0) goto L_0x018d
            r10 = 1
            goto L_0x018e
        L_0x018d:
            r10 = 0
        L_0x018e:
            if (r9 != 0) goto L_0x0194
            com.google.ads.interactivemedia.v3.internal.zzxi r9 = r15.zza(r0)
        L_0x0194:
            com.google.ads.interactivemedia.v3.internal.zzaab r14 = new com.google.ads.interactivemedia.v3.internal.zzaab
            r26 = r0
            r0 = r14
            r15 = r1
            r1 = r37
            r27 = r2
            r2 = r13
            r28 = r3
            r3 = r5
            r29 = r4
            r4 = r22
            r30 = r5
            r5 = r19
            r31 = r6
            r6 = r17
            r32 = r7
            r7 = r20
            r8 = r10
            r33 = 0
            r34 = 1
            r10 = r38
            r35 = r11
            r11 = r26
            r39 = r12
            r12 = r24
            r36 = r13
            r41 = r15
            r15 = r23
            r13 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = r36
            java.lang.Object r0 = r15.put(r0, r14)
            r1 = r0
            com.google.ads.interactivemedia.v3.internal.zzaad r1 = (com.google.ads.interactivemedia.v3.internal.zzaad) r1
            if (r41 != 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r1 = r41
        L_0x01da:
            int r2 = r27 + 1
            r14 = r37
            r12 = r39
            r8 = r40
            r13 = r15
            r0 = r22
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r11 = r35
            r9 = 0
            r10 = 1
            r15 = r38
            goto L_0x0135
        L_0x01f7:
            r41 = r1
            r30 = r5
            r31 = r6
            r32 = r7
            r35 = r11
            r39 = r12
            r15 = r13
            r33 = 0
            r34 = 1
            if (r41 != 0) goto L_0x021d
        L_0x020a:
            int r6 = r31 + 1
            r14 = r37
            r12 = r39
            r8 = r40
            r13 = r15
            r7 = r32
            r11 = r35
            r9 = 0
            r10 = 1
            r15 = r38
            goto L_0x0065
        L_0x021d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r40.getName()
            r2 = r41
            java.lang.String r3 = r2.zzi
            java.lang.reflect.Field r2 = r2.zzj
            java.lang.String r2 = com.google.ads.interactivemedia.v3.internal.zzacg.zzd(r2)
            java.lang.String r4 = com.google.ads.interactivemedia.v3.internal.zzacg.zzd(r30)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Class "
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = " declares multiple JSON fields named '"
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = "'; conflict is caused by fields "
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = " and "
            r5.append(r1)
            r5.append(r4)
            java.lang.String r1 = r5.toString()
            r0.<init>(r1)
            throw r0
        L_0x025b:
            r39 = r12
            r15 = r13
            java.lang.reflect.Type r0 = r16.zzd()
            java.lang.reflect.Type r1 = r39.getGenericSuperclass()
            r2 = r39
            java.lang.reflect.Type r0 = com.google.ads.interactivemedia.v3.internal.zzxr.zze(r0, r2, r1)
            com.google.ads.interactivemedia.v3.internal.zzact r16 = com.google.ads.interactivemedia.v3.internal.zzact.zzb(r0)
            java.lang.Class r12 = r16.zzc()
            r14 = r37
            r0 = r17
            r15 = r38
            goto L_0x0015
        L_0x027c:
            r15 = r13
            return r15
        L_0x027e:
            r15 = r13
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaag.zzc(com.google.ads.interactivemedia.v3.internal.zzwm, com.google.ads.interactivemedia.v3.internal.zzact, java.lang.Class, boolean, boolean):java.util.Map");
    }

    private final boolean zzd(Field field, boolean z) {
        return !this.zzc.zzc(field.getType(), z) && !this.zzc.zzd(field, z);
    }

    public final zzxi zza(zzwm zzwm, zzact zzact) {
        Class zzc2 = zzact.zzc();
        if (!Object.class.isAssignableFrom(zzc2)) {
            return null;
        }
        int zze2 = zzze.zze(this.zze, zzc2);
        if (zze2 != 4) {
            boolean z = zze2 == 3;
            if (zzacg.zzi(zzc2)) {
                return new zzaaf(zzc2, zzc(zzwm, zzact, zzc2, z, true), z);
            }
            return new zzaae(this.zza.zza(zzact), zzc(zzwm, zzact, zzc2, z, false));
        }
        String valueOf = String.valueOf(zzc2);
        throw new zzws("ReflectionAccessFilter does not permit using reflection for " + valueOf + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
