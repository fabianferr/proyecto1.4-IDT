package com.umlaut.crowd.utils;

import com.umlaut.crowd.internal.g4;
import com.umlaut.crowd.internal.k4;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class JsonUtils {
    public static <T> T fromJson(String str, Class<T> cls) {
        return fromJson(str, cls, false);
    }

    public static String toJson(Object obj) {
        return toJson(obj, obj.getClass());
    }

    public static <T> T fromJson(String str, Class<T> cls, boolean z) {
        if (!(str == null || str.length() == 0)) {
            try {
                k4 k4Var = new k4(new ByteArrayInputStream(str.getBytes("UTF-8")));
                T a = k4Var.a((Class<?>) cls, z);
                k4Var.close();
                if (a == null || !cls.equals(a.getClass())) {
                    return null;
                }
                return a;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (g4 e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x001f A[SYNTHETIC, Splitter:B:15:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0038 A[SYNTHETIC, Splitter:B:26:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toJson(java.lang.Object r3, java.lang.Class<?> r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            com.umlaut.crowd.internal.o4 r2 = new com.umlaut.crowd.internal.o4     // Catch:{ g4 -> 0x0019 }
            r2.<init>(r0)     // Catch:{ g4 -> 0x0019 }
            r2.a((java.lang.Object) r3, (java.lang.Class<?>) r4)     // Catch:{ g4 -> 0x0014, all -> 0x0012 }
            r2.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0012:
            r3 = move-exception
            goto L_0x0036
        L_0x0014:
            r3 = move-exception
            r1 = r2
            goto L_0x001a
        L_0x0017:
            r3 = move-exception
            goto L_0x0035
        L_0x0019:
            r3 = move-exception
        L_0x001a:
            r3.printStackTrace()     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0027
            r1.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0027:
            java.lang.String r3 = "UTF-8"
            java.lang.String r3 = r0.toString(r3)     // Catch:{ UnsupportedEncodingException -> 0x002e }
            goto L_0x0034
        L_0x002e:
            r3 = move-exception
            r3.printStackTrace()
            java.lang.String r3 = ""
        L_0x0034:
            return r3
        L_0x0035:
            r2 = r1
        L_0x0036:
            if (r2 == 0) goto L_0x0040
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0040:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.utils.JsonUtils.toJson(java.lang.Object, java.lang.Class):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033 A[SYNTHETIC, Splitter:B:21:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004c A[SYNTHETIC, Splitter:B:32:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toJson(com.umlaut.crowd.internal.w2 r3, com.umlaut.crowd.internal.RBR r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            com.umlaut.crowd.internal.o4 r2 = new com.umlaut.crowd.internal.o4     // Catch:{ g4 -> 0x002d }
            r2.<init>(r0)     // Catch:{ g4 -> 0x002d }
            com.umlaut.crowd.internal.w2 r1 = com.umlaut.crowd.internal.w2.NF     // Catch:{ g4 -> 0x0028, all -> 0x0026 }
            if (r3 != r1) goto L_0x0015
            java.lang.Class<com.umlaut.crowd.internal.f6> r3 = com.umlaut.crowd.internal.f6.class
            r2.a((java.lang.Object) r4, (java.lang.Class<?>) r3)     // Catch:{ g4 -> 0x0028, all -> 0x0026 }
            goto L_0x0022
        L_0x0015:
            com.umlaut.crowd.internal.w2 r1 = com.umlaut.crowd.internal.w2.NFST     // Catch:{ g4 -> 0x0028, all -> 0x0026 }
            if (r3 != r1) goto L_0x001f
            java.lang.Class<com.umlaut.crowd.internal.g6> r3 = com.umlaut.crowd.internal.g6.class
            r2.a((java.lang.Object) r4, (java.lang.Class<?>) r3)     // Catch:{ g4 -> 0x0028, all -> 0x0026 }
            goto L_0x0022
        L_0x001f:
            r2.a((java.lang.Object) r4)     // Catch:{ g4 -> 0x0028, all -> 0x0026 }
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0026:
            r3 = move-exception
            goto L_0x004a
        L_0x0028:
            r3 = move-exception
            r1 = r2
            goto L_0x002e
        L_0x002b:
            r3 = move-exception
            goto L_0x0049
        L_0x002d:
            r3 = move-exception
        L_0x002e:
            r3.printStackTrace()     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003b:
            java.lang.String r3 = "UTF-8"
            java.lang.String r3 = r0.toString(r3)     // Catch:{ UnsupportedEncodingException -> 0x0042 }
            goto L_0x0048
        L_0x0042:
            r3 = move-exception
            r3.printStackTrace()
            java.lang.String r3 = ""
        L_0x0048:
            return r3
        L_0x0049:
            r2 = r1
        L_0x004a:
            if (r2 == 0) goto L_0x0054
            r2.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0054:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.utils.JsonUtils.toJson(com.umlaut.crowd.internal.w2, com.umlaut.crowd.internal.RBR):java.lang.String");
    }
}
