package com.startapp;

import com.startapp.common.parser.JSONStreamException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class e4 {
    public static Map<String, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("int[]", Integer.class);
        a.put("long[]", Long.class);
        a.put("double[]", Double.class);
        a.put("float[]", Float.class);
        a.put("bool[]", Boolean.class);
        a.put("char[]", Character.class);
        a.put("byte[]", Byte.class);
        a.put("void[]", Void.class);
        a.put("short[]", Short.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:96:0x027d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0285, code lost:
        throw new com.startapp.common.parser.JSONStreamException("Unknown error occurred ", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0132 A[Catch:{ Exception -> 0x0286, all -> 0x027d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0171 A[Catch:{ Exception -> 0x0286, all -> 0x027d }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x027d A[ExcHandler: all (r0v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:42:0x00d9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.Class<T> r19, org.json.JSONObject r20) throws com.startapp.common.parser.JSONStreamException {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "Problem instantiating object class "
            java.lang.Class<com.startapp.c9> r3 = com.startapp.c9.class
            java.lang.annotation.Annotation r3 = r0.getAnnotation(r3)     // Catch:{ Exception -> 0x028e }
            com.startapp.c9 r3 = (com.startapp.c9) r3     // Catch:{ Exception -> 0x028e }
            java.lang.Class<java.net.HttpCookie> r4 = java.net.HttpCookie.class
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x028e }
            java.lang.String r5 = "."
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0034
            java.lang.reflect.Constructor[] r2 = r19.getDeclaredConstructors()     // Catch:{ Exception -> 0x028e }
            r2 = r2[r7]     // Catch:{ Exception -> 0x028e }
            r2.setAccessible(r6)     // Catch:{ Exception -> 0x028e }
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x028e }
            java.lang.String r9 = "name"
            r4[r7] = r9     // Catch:{ Exception -> 0x028e }
            java.lang.String r9 = "value"
            r4[r6] = r9     // Catch:{ Exception -> 0x028e }
            java.lang.Object r2 = r2.newInstance(r4)     // Catch:{ Exception -> 0x028e }
            goto L_0x009a
        L_0x0034:
            boolean r4 = r19.isPrimitive()     // Catch:{ Exception -> 0x028e }
            if (r4 == 0) goto L_0x003f
            java.lang.Object r0 = r19.newInstance()     // Catch:{ Exception -> 0x028e }
            return r0
        L_0x003f:
            java.lang.Class<com.startapp.c9> r4 = com.startapp.c9.class
            java.lang.annotation.Annotation r4 = r0.getAnnotation(r4)     // Catch:{ Exception -> 0x028e }
            if (r4 == 0) goto L_0x008b
            boolean r4 = r3.extendsClass()     // Catch:{ Exception -> 0x028e }
            if (r4 == 0) goto L_0x004e
            goto L_0x008b
        L_0x004e:
            boolean r4 = r3.extendsClass()     // Catch:{ Exception -> 0x028e }
            if (r4 != 0) goto L_0x0089
            java.lang.String r0 = r3.decider()     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            java.lang.String r3 = r3.packageName()     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            r4.append(r3)     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            r4.append(r0)     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            java.lang.String r0 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            java.lang.Object r0 = a(r0, (org.json.JSONObject) r1)     // Catch:{ ClassNotFoundException -> 0x0082, JSONException -> 0x007b }
            return r0
        L_0x007b:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException     // Catch:{ Exception -> 0x028e }
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x028e }
            throw r1     // Catch:{ Exception -> 0x028e }
        L_0x0082:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException     // Catch:{ Exception -> 0x028e }
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x028e }
            throw r1     // Catch:{ Exception -> 0x028e }
        L_0x0089:
            r2 = 0
            goto L_0x009a
        L_0x008b:
            java.lang.Class[] r2 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x028e }
            java.lang.reflect.Constructor r2 = r0.getDeclaredConstructor(r2)     // Catch:{ Exception -> 0x028e }
            r2.setAccessible(r6)     // Catch:{ Exception -> 0x028e }
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x028e }
            java.lang.Object r2 = r2.newInstance(r4)     // Catch:{ Exception -> 0x028e }
        L_0x009a:
            java.lang.reflect.Field[] r4 = r19.getDeclaredFields()
            if (r3 == 0) goto L_0x00bb
            boolean r3 = r3.extendsClass()
            if (r3 == 0) goto L_0x00bb
            int r3 = r4.length
            java.lang.Class r0 = r19.getSuperclass()
            java.lang.reflect.Field[] r0 = r0.getDeclaredFields()
            int r9 = r0.length
            int r10 = r3 + r9
            java.lang.reflect.Field[] r10 = new java.lang.reflect.Field[r10]
            java.lang.System.arraycopy(r4, r7, r10, r7, r3)
            java.lang.System.arraycopy(r0, r7, r10, r3, r9)
            r4 = r10
        L_0x00bb:
            int r0 = r4.length
            r3 = 0
        L_0x00bd:
            if (r3 >= r0) goto L_0x028d
            r9 = r4[r3]
            int r10 = r9.getModifiers()
            java.lang.Class<com.startapp.e9> r11 = com.startapp.e9.class
            boolean r12 = java.lang.reflect.Modifier.isStatic(r10)
            if (r12 != 0) goto L_0x0286
            boolean r10 = java.lang.reflect.Modifier.isTransient(r10)
            if (r10 == 0) goto L_0x00d5
            goto L_0x0286
        L_0x00d5:
            java.lang.String r10 = com.startapp.h4.a(r9)
            boolean r12 = r1.has(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r12 == 0) goto L_0x0286
            r9.setAccessible(r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.annotation.Annotation[] r12 = r9.getDeclaredAnnotations()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            int r12 = r12.length     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r12 <= 0) goto L_0x011f
            java.lang.annotation.Annotation[] r12 = r9.getDeclaredAnnotations()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r12 = r12[r7]     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r13 = r12.annotationType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class<com.startapp.d9> r14 = com.startapp.d9.class
            boolean r13 = r13.equals(r14)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r13 == 0) goto L_0x011f
            com.startapp.d9 r12 = (com.startapp.d9) r12     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r11 = r12.type()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r13 = r12.key()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r14 = r12.value()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            boolean r15 = r12.complex()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r16 = r12.innerValue()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r12 = r12.parser()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r6 = r16
            r17 = 1
            r18 = r12
            r12 = r11
            r11 = r18
            goto L_0x0126
        L_0x011f:
            r6 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x0126:
            java.lang.Class r7 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class<com.startapp.c9> r8 = com.startapp.c9.class
            java.lang.annotation.Annotation r7 = r7.getAnnotation(r8)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r7 == 0) goto L_0x0171
            java.lang.Class r6 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class<com.startapp.c9> r7 = com.startapp.c9.class
            java.lang.annotation.Annotation r6 = r6.getAnnotation(r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            com.startapp.c9 r6 = (com.startapp.c9) r6     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            org.json.JSONObject r7 = r1.getJSONObject(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.String r8 = r6.decider()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.String r7 = r7.getString(r8)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.String r6 = r6.packageName()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r8.<init>()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r8.append(r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r8.append(r5)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r8.append(r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            org.json.JSONObject r7 = r1.getJSONObject(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Object r6 = a(r6, (org.json.JSONObject) r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x0171:
            java.lang.Class<com.startapp.e9> r7 = com.startapp.e9.class
            if (r11 == r7) goto L_0x018c
            java.lang.Object r6 = r11.newInstance()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            com.startapp.e9 r6 = (com.startapp.e9) r6     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r7 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Object r8 = r1.opt(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Object r6 = r6.parse(r7, r8)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x018c:
            if (r15 == 0) goto L_0x019f
            java.lang.Class r6 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            org.json.JSONObject r7 = r1.getJSONObject(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Object r6 = a(r6, (org.json.JSONObject) r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x019f:
            if (r17 == 0) goto L_0x021e
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            boolean r7 = r7.isAssignableFrom(r12)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r7 != 0) goto L_0x01b1
            java.lang.Class<java.util.Collection> r7 = java.util.Collection.class
            boolean r7 = r7.isAssignableFrom(r12)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r7 == 0) goto L_0x021e
        L_0x01b1:
            java.lang.Class<java.util.HashMap> r7 = java.util.HashMap.class
            boolean r7 = r12.equals(r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r7 == 0) goto L_0x01ca
            org.json.JSONObject r7 = r1.getJSONObject(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.util.Iterator r8 = r7.keys()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.util.Map r6 = a(r13, r14, r6, r7, r8)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x01ca:
            java.lang.Class<java.util.ArrayList> r6 = java.util.ArrayList.class
            boolean r6 = r12.equals(r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r6 == 0) goto L_0x01df
            org.json.JSONArray r6 = r1.getJSONArray(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.util.List r6 = a((java.lang.Class) r14, (org.json.JSONArray) r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x01df:
            java.lang.Class<java.util.HashSet> r6 = java.util.HashSet.class
            boolean r6 = r12.equals(r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r6 == 0) goto L_0x01f4
            org.json.JSONArray r6 = r1.getJSONArray(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.util.Set r6 = b(r14, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x01f4:
            java.lang.Class<java.util.EnumSet> r6 = java.util.EnumSet.class
            boolean r6 = r12.equals(r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r6 == 0) goto L_0x0286
            org.json.JSONArray r6 = r1.getJSONArray(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r7.<init>()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r8 = 0
        L_0x0206:
            int r10 = r6.length()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r8 >= r10) goto L_0x021a
            java.lang.String r10 = r6.getString(r8)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Enum r10 = java.lang.Enum.valueOf(r14, r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r7.add(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            int r8 = r8 + 1
            goto L_0x0206
        L_0x021a:
            r9.set(r2, r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x021e:
            java.lang.Class r6 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            boolean r6 = r6.isEnum()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r6 == 0) goto L_0x0236
            java.lang.Object r6 = r1.get(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Enum r6 = java.lang.Enum.valueOf(r12, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x0236:
            java.lang.Class r6 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            boolean r6 = r6.isPrimitive()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r6 == 0) goto L_0x0250
            java.lang.Object r6 = r1.get(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r7 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Object r6 = a(r1, r9, r6, r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x0250:
            java.lang.Class r6 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            boolean r6 = r6.isArray()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            if (r6 == 0) goto L_0x0262
            java.lang.Object r6 = a(r1, r12, r9)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            goto L_0x0286
        L_0x0262:
            java.lang.Object r6 = r1.get(r10)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Class r7 = r9.getType()     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            java.lang.Object r6 = a((java.lang.Object) r6, (java.lang.Class<?>) r7)     // Catch:{ Exception -> 0x0286, all -> 0x027d }
            r7 = 0
            boolean r8 = r6.equals(r7)     // Catch:{ Exception -> 0x0287, all -> 0x027d }
            if (r8 == 0) goto L_0x0279
            r9.set(r2, r7)     // Catch:{ Exception -> 0x0287, all -> 0x027d }
            goto L_0x0287
        L_0x0279:
            r9.set(r2, r6)     // Catch:{ Exception -> 0x0287, all -> 0x027d }
            goto L_0x0287
        L_0x027d:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException
            java.lang.String r2 = "Unknown error occurred "
            r1.<init>(r2, r0)
            throw r1
        L_0x0286:
            r7 = 0
        L_0x0287:
            int r3 = r3 + 1
            r6 = 1
            r7 = 0
            goto L_0x00bd
        L_0x028d:
            return r2
        L_0x028e:
            r0 = move-exception
            com.startapp.common.parser.JSONStreamException r1 = new com.startapp.common.parser.JSONStreamException
            java.lang.String r2 = "Can't deserialize the object. Failed to instantiate object."
            r1.<init>(r2, r0)
            goto L_0x0298
        L_0x0297:
            throw r1
        L_0x0298:
            goto L_0x0297
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.e4.a(java.lang.Class, org.json.JSONObject):java.lang.Object");
    }

    public static <V> Set<V> b(Class<V> cls, JSONArray jSONArray) throws JSONException, JSONStreamException {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                hashSet.add(jSONArray.get(i));
            } else {
                hashSet.add(a(cls, optJSONObject));
            }
        }
        return hashSet;
    }

    public static <T> Object a(JSONObject jSONObject, Class<T> cls, Field field) throws JSONStreamException, JSONException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, IllegalArgumentException, NoSuchFieldException {
        Object obj;
        if (cls != null) {
            JSONArray jSONArray = jSONObject.getJSONArray(h4.a(field));
            int length = jSONArray.length();
            Object newInstance = Array.newInstance(cls, length);
            for (int i = 0; i < length; i++) {
                Array.set(newInstance, i, a(cls, jSONArray.getJSONObject(i)));
            }
            return (Object[]) newInstance;
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray(h4.a(field));
        int length2 = jSONArray2.length();
        Class<?> type = field.getType();
        Class cls2 = (Class) ((HashMap) a).get(type.getSimpleName());
        Object newInstance2 = Array.newInstance((Class) cls2.getField("TYPE").get((Object) null), length2);
        for (int i2 = 0; i2 < length2; i2++) {
            String string = jSONArray2.getString(i2);
            Class<String> cls3 = String.class;
            if (cls2.equals(Character.class)) {
                cls3 = Character.TYPE;
            }
            Constructor constructor = cls2.getConstructor(new Class[]{cls3});
            if (cls2.equals(Character.class)) {
                obj = constructor.newInstance(new Object[]{Character.valueOf(string.charAt(0))});
            } else {
                obj = constructor.newInstance(new Object[]{string});
            }
            Array.set(newInstance2, i2, obj);
        }
        return newInstance2;
    }

    public static <K, V> Map a(Class cls, Class cls2, Class cls3, JSONObject jSONObject, Iterator it) throws JSONException, JSONStreamException {
        HashMap hashMap = new HashMap();
        while (it.hasNext()) {
            Object next = it.next();
            Object cast = cls.equals(Integer.class) ? cls.cast(Integer.valueOf(Integer.parseInt((String) next))) : next;
            if (cls.isEnum()) {
                cast = Enum.valueOf(cls, cast.toString());
            }
            String str = (String) next;
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                if (optJSONArray != null) {
                    hashMap.put(cast, b(cls3, optJSONArray));
                } else if (cls2.isEnum()) {
                    hashMap.put(cast, Enum.valueOf(cls2, (String) jSONObject.get(str)));
                } else {
                    hashMap.put(cast, jSONObject.get(str));
                }
            } else {
                hashMap.put(cast, a(cls2, optJSONObject));
            }
        }
        return hashMap;
    }

    public static <V> List a(Class cls, JSONArray jSONArray) throws JSONException, JSONStreamException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                arrayList.add(jSONArray.get(i));
            } else {
                arrayList.add(a(cls, optJSONObject));
            }
        }
        return arrayList;
    }

    public static Object a(Object obj, Class<?> cls) {
        if (obj.getClass().equals(cls)) {
            return obj;
        }
        if (!cls.equals(Integer.class)) {
            return (!cls.equals(Long.class) || !obj.getClass().equals(Integer.class)) ? obj : Long.valueOf(((Integer) obj).longValue());
        }
        if (obj.getClass().equals(Double.class)) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (obj.getClass().equals(Long.class)) {
            return Integer.valueOf(((Long) obj).intValue());
        }
        return obj;
    }

    public static Object a(JSONObject jSONObject, Field field, Object obj, Class<?> cls) throws JSONException {
        if (obj.getClass().equals(cls)) {
            return obj;
        }
        if (obj.getClass().equals(String.class)) {
            if (cls.equals(Integer.TYPE)) {
                return Integer.valueOf(jSONObject.getInt(h4.a(field)));
            }
            return obj;
        } else if (cls.equals(Integer.TYPE)) {
            return Integer.valueOf(((Number) obj).intValue());
        } else {
            if (cls.equals(Float.TYPE)) {
                return Float.valueOf(((Number) obj).floatValue());
            }
            if (cls.equals(Long.TYPE)) {
                return Long.valueOf(((Number) obj).longValue());
            }
            return cls.equals(Double.TYPE) ? Double.valueOf(((Number) obj).doubleValue()) : obj;
        }
    }
}
