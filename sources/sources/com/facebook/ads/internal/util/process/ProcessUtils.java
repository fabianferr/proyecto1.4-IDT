package com.facebook.ads.internal.util.process;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import java.lang.reflect.Field;

public final class ProcessUtils {
    private static String sProcessName;

    private ProcessUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return getProcessNameAPI28();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        r2 = r2.getApplicationContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        if ((r2 instanceof android.app.Application) == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        r2 = getProcessNameViaReflection((android.app.Application) r2);
        r0 = com.facebook.ads.internal.util.process.ProcessUtils.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        sProcessName = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProcessName(android.content.Context r2) {
        /*
            java.lang.Class<com.facebook.ads.internal.util.process.ProcessUtils> r0 = com.facebook.ads.internal.util.process.ProcessUtils.class
            monitor-enter(r0)
            java.lang.String r1 = sProcessName     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x0015
            java.lang.String r2 = getProcessNameAPI28()
            return r2
        L_0x0015:
            android.content.Context r2 = r2.getApplicationContext()
            boolean r0 = r2 instanceof android.app.Application
            if (r0 == 0) goto L_0x002d
            android.app.Application r2 = (android.app.Application) r2
            java.lang.String r2 = getProcessNameViaReflection(r2)
            java.lang.Class<com.facebook.ads.internal.util.process.ProcessUtils> r0 = com.facebook.ads.internal.util.process.ProcessUtils.class
            monitor-enter(r0)
            sProcessName = r2     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return r2
        L_0x002a:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r2
        L_0x002d:
            r2 = 0
            return r2
        L_0x002f:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.process.ProcessUtils.getProcessName(android.content.Context):java.lang.String");
    }

    private static String getProcessNameAPI28() {
        try {
            Class[] clsArr = null;
            Object[] objArr = null;
            return (String) Application.class.getMethod("getProcessName", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getProcessNameViaReflection(Application application) {
        try {
            Field field = application.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(application);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Class[] clsArr = null;
            Object[] objArr = null;
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", (Class[]) null).invoke(obj2, (Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getProcessSpecificName(String str, Context context) {
        String packageName = context.getPackageName();
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(processName) || packageName.equals(processName)) {
            return str;
        }
        if (processName.contains(CertificateUtil.DELIMITER)) {
            processName = processName.split(CertificateUtil.DELIMITER)[1];
        }
        return str + "_" + processName;
    }
}
