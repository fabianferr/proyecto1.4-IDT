package com.bytedance.sdk.openadsdk.multipro;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTMultiInitHelper */
public class c {
    private static boolean a = true;
    private static final AtomicBoolean b = new AtomicBoolean(false);

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = a
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            java.util.concurrent.atomic.AtomicBoolean r0 = b
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x004d }
            r1 = 28
            if (r0 < r1) goto L_0x0055
            boolean r0 = com.bytedance.sdk.component.utils.q.a(r3)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0023
            b(r3)     // Catch:{ all -> 0x004d }
            goto L_0x0055
        L_0x0023:
            java.lang.String r0 = com.bytedance.sdk.component.utils.q.b(r3)     // Catch:{ all -> 0x004d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0045
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            r1.<init>()     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            r1.append(r3)     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            int r3 = android.os.Process.myPid()     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            r1.append(r3)     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            java.lang.String r3 = r1.toString()     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            r0 = r3
        L_0x0045:
            android.webkit.WebView.setDataDirectorySuffix(r0)     // Catch:{ IllegalStateException -> 0x0049, Exception -> 0x0055 }
            goto L_0x0055
        L_0x0049:
            a((java.lang.String) r0)     // Catch:{ all -> 0x004d }
            goto L_0x0055
        L_0x004d:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.bytedance.sdk.component.utils.l.d(r3)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.c.a(android.content.Context):void");
    }

    public static void a() {
        a = false;
    }

    private static void a(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke((Object) null, new Object[]{"android.webkit.WebViewFactory"});
            Field field = (Field) declaredMethod2.invoke(cls, new Object[]{"sDataDirectorySuffix"});
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.nio.channels.FileLock} */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|17|36|37|(0)|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0095, code lost:
        com.bytedance.sdk.component.utils.l.b("checkWebViewDataLock try close exclusiveFileChannel : " + r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ae, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00af, code lost:
        r1 = new java.lang.StringBuilder("checkWebViewDataLock try close accessFile : ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c3, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c4, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cc, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cd, code lost:
        com.bytedance.sdk.component.utils.l.b("checkWebViewDataLock try close exclusiveFileChannel : " + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e7, code lost:
        com.bytedance.sdk.component.utils.l.b("checkWebViewDataLock try close accessFile : " + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x008b */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0090 A[SYNTHETIC, Splitter:B:39:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00aa A[SYNTHETIC, Splitter:B:44:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c8 A[SYNTHETIC, Splitter:B:52:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e2 A[SYNTHETIC, Splitter:B:57:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r5) {
        /*
            java.lang.String r0 = "checkWebViewDataLock try close accessFile : "
            java.lang.String r1 = "checkWebViewDataLock try close exclusiveFileChannel : "
            java.lang.String r2 = b()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x0011
            java.lang.String r2 = "webview"
            goto L_0x001f
        L_0x0011:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "webview_"
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x001f:
            r3 = 0
            java.io.File r5 = r5.getDir(r2, r3)
            java.lang.String r5 = r5.getPath()
            java.io.File r2 = new java.io.File
            java.lang.String r3 = "webview_data.lock"
            r2.<init>(r5, r3)
            java.lang.String r5 = "TTAD.TTMultiInitHelper"
            java.lang.String r3 = r2.getAbsolutePath()
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r5, (java.lang.String) r3)
            boolean r5 = r2.exists()
            if (r5 != 0) goto L_0x003f
            return
        L_0x003f:
            r5 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x008a, all -> 0x0085 }
            java.lang.String r4 = "rw"
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x008a, all -> 0x0085 }
            java.nio.channels.FileChannel r4 = r3.getChannel()     // Catch:{ Exception -> 0x008b }
            if (r4 == 0) goto L_0x0057
            java.nio.channels.FileLock r5 = r4.tryLock()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            goto L_0x0057
        L_0x0052:
            r5 = move-exception
            goto L_0x00c6
        L_0x0055:
            r5 = r4
            goto L_0x008b
        L_0x0057:
            if (r5 == 0) goto L_0x005d
            r5.close()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            goto L_0x0060
        L_0x005d:
            a((java.io.File) r2)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
        L_0x0060:
            if (r4 == 0) goto L_0x007a
            r4.close()     // Catch:{ all -> 0x0066 }
            goto L_0x007a
        L_0x0066:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r5 = r5.getMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.bytedance.sdk.component.utils.l.b(r5)
        L_0x007a:
            r3.close()     // Catch:{ all -> 0x007e }
            goto L_0x00c2
        L_0x007e:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            goto L_0x00b4
        L_0x0085:
            r2 = move-exception
            r3 = r5
            r4 = r3
        L_0x0088:
            r5 = r2
            goto L_0x00c6
        L_0x008a:
            r3 = r5
        L_0x008b:
            a((java.io.File) r2)     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x00a8
            r5.close()     // Catch:{ all -> 0x0094 }
            goto L_0x00a8
        L_0x0094:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r5 = r5.getMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.bytedance.sdk.component.utils.l.b(r5)
        L_0x00a8:
            if (r3 == 0) goto L_0x00c2
            r3.close()     // Catch:{ all -> 0x00ae }
            goto L_0x00c2
        L_0x00ae:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
        L_0x00b4:
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.bytedance.sdk.component.utils.l.b(r5)
        L_0x00c2:
            return
        L_0x00c3:
            r2 = move-exception
            r4 = r5
            goto L_0x0088
        L_0x00c6:
            if (r4 == 0) goto L_0x00e0
            r4.close()     // Catch:{ all -> 0x00cc }
            goto L_0x00e0
        L_0x00cc:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = r2.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.bytedance.sdk.component.utils.l.b(r1)
        L_0x00e0:
            if (r3 == 0) goto L_0x00fa
            r3.close()     // Catch:{ all -> 0x00e6 }
            goto L_0x00fa
        L_0x00e6:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = r1.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.bytedance.sdk.component.utils.l.b(r0)
        L_0x00fa:
            goto L_0x00fc
        L_0x00fb:
            throw r5
        L_0x00fc:
            goto L_0x00fb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.c.b(android.content.Context):void");
    }

    private static void a(File file) {
        a(file, file.exists() ? file.delete() : false);
    }

    private static void a(File file, boolean z) {
        if (z && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                l.e("TTAD.TTMultiInitHelper", e.getMessage());
            }
        }
    }

    private static String b() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke((Object) null, new Object[]{"android.webkit.WebViewFactory"});
            return (String) ((Field) declaredMethod2.invoke(cls, new Object[]{"sDataDirectorySuffix"})).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
