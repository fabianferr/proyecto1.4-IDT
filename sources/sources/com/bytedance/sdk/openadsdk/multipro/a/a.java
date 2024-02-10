package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DBMultiAdapter */
public class a {
    public static g a;
    private static final ConcurrentHashMap<String, Object> b = new ConcurrentHashMap<>();

    public static g a(Context context) {
        if (context == null) {
            try {
                o.a();
            } catch (Throwable unused) {
                ac.h("binder error");
            }
        }
        if (a == null) {
            if (b.c()) {
                a = f.a(com.bytedance.sdk.openadsdk.multipro.aidl.a.a().a(5));
            } else {
                a = f.b();
            }
        }
        return a;
    }

    private static String a() {
        return d.b + "/t_db/ttopensdk.db/";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(1:15)|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3, java.lang.String r4, android.content.ContentValues r5) {
        /*
            if (r5 == 0) goto L_0x0047
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0009
            goto L_0x0047
        L_0x0009:
            java.lang.Object r0 = a((java.lang.String) r4)
            monitor-enter(r0)
            boolean r1 = com.bytedance.sdk.openadsdk.multipro.b.c()     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0022
            com.bytedance.sdk.openadsdk.core.e r3 = com.bytedance.sdk.openadsdk.core.e.a(r3)     // Catch:{ all -> 0x0042 }
            com.bytedance.sdk.openadsdk.core.f$c r3 = r3.a()     // Catch:{ all -> 0x0042 }
            r1 = 0
            r3.a((java.lang.String) r4, (java.lang.String) r1, (android.content.ContentValues) r5)     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x0022:
            com.bytedance.sdk.component.e.a.g r3 = a((android.content.Context) r3)     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0042
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r1.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = a()     // Catch:{ all -> 0x0042 }
            r1.append(r2)     // Catch:{ all -> 0x0042 }
            r1.append(r4)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0042 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ all -> 0x0042 }
            r3.a(r4, r5)     // Catch:{ all -> 0x0042 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r3
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.a.a(android.content.Context, java.lang.String, android.content.ContentValues):void");
    }

    public static int a(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (a(str)) {
            try {
                if (!b.c()) {
                    int a2 = e.a(context).a().a(str, str2, strArr);
                    return a2;
                }
                g a3 = a(context);
                if (a3 != null) {
                    int a4 = a3.a(Uri.parse(a() + str), str2, strArr);
                    return a4;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (a(str)) {
            try {
                if (!b.c()) {
                    int a2 = e.a(context).a().a(str, contentValues, str2, strArr);
                    return a2;
                }
                g a3 = a(context);
                if (a3 != null) {
                    int a4 = a3.a(Uri.parse(a() + str), contentValues, str2, strArr);
                    return a4;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Map<String, List<String>> a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (a(str)) {
            try {
                if (!b.c()) {
                    Map<String, List<String>> a2 = a(e.a(context).a().a(str, strArr, str2, strArr2, str3, str4, str5));
                    return a2;
                }
                g a3 = a(context);
                if (a3 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a());
                    String str6 = str;
                    sb.append(str);
                    Map<String, List<String>> a4 = a3.a(Uri.parse(sb.toString()), strArr, str2, strArr2, str5);
                    return a4;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r6 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r6 == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r6.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> a(android.database.Cursor r6) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r6 == 0) goto L_0x0048
            java.lang.String[] r1 = r6.getColumnNames()     // Catch:{ all -> 0x0042 }
        L_0x000b:
            int r2 = r6.getCount()     // Catch:{ all -> 0x0042 }
            if (r2 <= 0) goto L_0x003f
            boolean r2 = r6.moveToNext()     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x003f
            int r2 = r1.length     // Catch:{ all -> 0x0042 }
            r3 = 0
        L_0x0019:
            if (r3 >= r2) goto L_0x000b
            r4 = r1[r3]     // Catch:{ all -> 0x0042 }
            boolean r5 = r0.containsKey(r4)     // Catch:{ all -> 0x0042 }
            if (r5 != 0) goto L_0x002b
            java.util.LinkedList r5 = new java.util.LinkedList     // Catch:{ all -> 0x0042 }
            r5.<init>()     // Catch:{ all -> 0x0042 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0042 }
        L_0x002b:
            java.lang.Object r5 = r0.get(r4)     // Catch:{ all -> 0x0042 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0042 }
            int r4 = r6.getColumnIndex(r4)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = r6.getString(r4)     // Catch:{ all -> 0x0042 }
            r5.add(r4)     // Catch:{ all -> 0x0042 }
            int r3 = r3 + 1
            goto L_0x0019
        L_0x003f:
            if (r6 == 0) goto L_0x0048
            goto L_0x0045
        L_0x0042:
            if (r6 == 0) goto L_0x0048
        L_0x0045:
            r6.close()
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.a.a.a(android.database.Cursor):java.util.Map");
    }

    private static Object a(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap = b;
        Object obj = concurrentHashMap.get(str);
        if (obj == null) {
            synchronized (a.class) {
                obj = concurrentHashMap.get(str);
                if (obj == null) {
                    obj = new Object();
                    concurrentHashMap.put(str, obj);
                }
            }
        }
        return obj;
    }
}
