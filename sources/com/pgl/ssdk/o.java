package com.pgl.ssdk;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class o {
    private static final Map a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        hashMap.put(Integer.class, Integer.TYPE);
        hashMap.put(Float.class, Float.TYPE);
        hashMap.put(Long.class, Long.TYPE);
        hashMap.put(Double.class, Double.TYPE);
        Class cls = Boolean.TYPE;
        hashMap.put(cls, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(cls2, cls2);
        Class cls3 = Character.TYPE;
        hashMap.put(cls3, cls3);
        Class cls4 = Short.TYPE;
        hashMap.put(cls4, cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(cls5, cls5);
        Class cls6 = Float.TYPE;
        hashMap.put(cls6, cls6);
        Class cls7 = Long.TYPE;
        hashMap.put(cls7, cls7);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    public static void a(Class cls, String str, Object... objArr) {
        Class[] clsArr;
        Object[] objArr2;
        if (objArr == null || objArr.length <= 0) {
            clsArr = null;
        } else {
            clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                n nVar = objArr[i];
                if (nVar == null || !(nVar instanceof n)) {
                    clsArr[i] = nVar == null ? null : nVar.getClass();
                } else {
                    clsArr[i] = nVar.a;
                }
            }
        }
        Method a2 = a(cls, str, clsArr);
        if (objArr == null || objArr.length <= 0) {
            objArr2 = null;
        } else {
            objArr2 = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                n nVar2 = objArr[i2];
                if (nVar2 == null || !(nVar2 instanceof n)) {
                    objArr2[i2] = nVar2;
                } else {
                    objArr2[i2] = nVar2.b;
                }
            }
        }
        a2.invoke((Object) null, objArr2);
    }

    public static void a(String str, String str2, Object... objArr) {
        try {
            a((Class) Class.forName(str), str2, objArr);
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r13.length != 0) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r6.length == 0) goto L_0x0060;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0068 A[EDGE_INSN: B:44:0x0068->B:32:0x0068 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0064 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method a(java.lang.Class r11, java.lang.String r12, java.lang.Class... r13) {
        /*
            java.lang.reflect.Method[] r0 = r11.getDeclaredMethods()
            if (r12 == 0) goto L_0x0083
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0009:
            r4 = 1
            if (r3 >= r1) goto L_0x0067
            r5 = r0[r3]
            java.lang.String r6 = r5.getName()
            boolean r6 = r6.equals(r12)
            if (r6 == 0) goto L_0x0064
            java.lang.Class[] r6 = r5.getParameterTypes()
            if (r6 != 0) goto L_0x0024
            if (r13 == 0) goto L_0x0060
            int r6 = r13.length
            if (r6 != 0) goto L_0x005b
            goto L_0x0060
        L_0x0024:
            if (r13 != 0) goto L_0x002a
            int r6 = r6.length
            if (r6 != 0) goto L_0x005b
            goto L_0x0060
        L_0x002a:
            int r7 = r6.length
            int r8 = r13.length
            if (r7 == r8) goto L_0x002f
            goto L_0x005b
        L_0x002f:
            r7 = 0
        L_0x0030:
            int r8 = r6.length
            if (r7 >= r8) goto L_0x0060
            r8 = r6[r7]
            r9 = r13[r7]
            boolean r8 = r8.isAssignableFrom(r9)
            if (r8 != 0) goto L_0x005d
            java.util.Map r8 = a
            r9 = r6[r7]
            boolean r9 = r8.containsKey(r9)
            if (r9 == 0) goto L_0x005b
            r9 = r6[r7]
            java.lang.Object r9 = r8.get(r9)
            java.lang.Class r9 = (java.lang.Class) r9
            r10 = r13[r7]
            java.lang.Object r8 = r8.get(r10)
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x005d
        L_0x005b:
            r6 = 0
            goto L_0x0061
        L_0x005d:
            int r7 = r7 + 1
            goto L_0x0030
        L_0x0060:
            r6 = 1
        L_0x0061:
            if (r6 == 0) goto L_0x0064
            goto L_0x0068
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x0009
        L_0x0067:
            r5 = 0
        L_0x0068:
            if (r5 != 0) goto L_0x007f
            java.lang.Class r0 = r11.getSuperclass()
            if (r0 == 0) goto L_0x0079
            java.lang.Class r11 = r11.getSuperclass()
            java.lang.reflect.Method r11 = a((java.lang.Class) r11, (java.lang.String) r12, (java.lang.Class[]) r13)
            return r11
        L_0x0079:
            java.lang.NoSuchMethodException r11 = new java.lang.NoSuchMethodException
            r11.<init>()
            throw r11
        L_0x007f:
            r5.setAccessible(r4)
            return r5
        L_0x0083:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r12 = "Method name must not be null."
            r11.<init>(r12)
            goto L_0x008c
        L_0x008b:
            throw r11
        L_0x008c:
            goto L_0x008b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.o.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
