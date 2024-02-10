package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DexLoadErrorReporter {
    private static final String LOGGING_URL = "https://www.facebook.com/adnw_logging/";
    public static final double SAMPLING = 0.1d;
    private static final AtomicBoolean sAlreadyReported = new AtomicBoolean();

    public static void reportDexLoadingIssue(final Context context, final String str, double d) {
        AtomicBoolean atomicBoolean = sAlreadyReported;
        if (!atomicBoolean.get() && Math.random() < d) {
            atomicBoolean.set(true);
            new Thread() {
                /* JADX INFO: finally extract failed */
                /* JADX WARNING: Removed duplicated region for block: B:50:0x0182 A[SYNTHETIC, Splitter:B:50:0x0182] */
                /* JADX WARNING: Removed duplicated region for block: B:55:0x018d A[SYNTHETIC, Splitter:B:55:0x018d] */
                /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r23 = this;
                        r1 = r23
                        java.lang.String r0 = "data"
                        java.lang.String r2 = "0"
                        java.lang.String r3 = "attempt"
                        java.lang.String r4 = "UTF-8"
                        java.lang.String r5 = "Can't close connection."
                        java.lang.String r6 = "FBAudienceNetwork"
                        java.lang.String r7 = "payload="
                        java.lang.String r8 = ""
                        super.run()
                        java.net.URL r10 = new java.net.URL     // Catch:{ all -> 0x0174 }
                        java.lang.String r11 = "https://www.facebook.com/adnw_logging/"
                        r10.<init>(r11)     // Catch:{ all -> 0x0174 }
                        java.net.URLConnection r10 = r10.openConnection()     // Catch:{ all -> 0x0174 }
                        java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ all -> 0x0174 }
                        java.lang.String r11 = "POST"
                        r10.setRequestMethod(r11)     // Catch:{ all -> 0x016f }
                        java.lang.String r11 = "Content-Type"
                        java.lang.String r12 = "application/x-www-form-urlencoded;charset=UTF-8"
                        r10.setRequestProperty(r11, r12)     // Catch:{ all -> 0x016f }
                        java.lang.String r11 = "Accept"
                        java.lang.String r12 = "application/json"
                        r10.setRequestProperty(r11, r12)     // Catch:{ all -> 0x016f }
                        java.lang.String r11 = "Accept-Charset"
                        r10.setRequestProperty(r11, r4)     // Catch:{ all -> 0x016f }
                        java.lang.String r11 = "user-agent"
                        java.lang.String r12 = "[FBAN/AudienceNetworkForAndroid;FBSN/Android]"
                        r10.setRequestProperty(r11, r12)     // Catch:{ all -> 0x016f }
                        r11 = 1
                        r10.setDoOutput(r11)     // Catch:{ all -> 0x016f }
                        r10.setDoInput(r11)     // Catch:{ all -> 0x016f }
                        r10.connect()     // Catch:{ all -> 0x016f }
                        java.util.UUID r11 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x016f }
                        java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x016f }
                        org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x016f }
                        r12.<init>()     // Catch:{ all -> 0x016f }
                        r12.put(r3, r2)     // Catch:{ all -> 0x016f }
                        android.content.Context r13 = r4     // Catch:{ all -> 0x016f }
                        com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.addEnvFields(r13, r12, r11)     // Catch:{ all -> 0x016f }
                        org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x016f }
                        r13.<init>()     // Catch:{ all -> 0x016f }
                        java.lang.String r14 = "subtype"
                        java.lang.String r15 = "generic"
                        r13.put(r14, r15)     // Catch:{ all -> 0x016f }
                        java.lang.String r14 = "subtype_code"
                        java.lang.String r15 = "1320"
                        r13.put(r14, r15)     // Catch:{ all -> 0x016f }
                        java.lang.String r14 = "caught_exception"
                        java.lang.String r15 = "1"
                        r13.put(r14, r15)     // Catch:{ all -> 0x016f }
                        java.lang.String r14 = "stacktrace"
                        java.lang.String r15 = r5     // Catch:{ all -> 0x016f }
                        r13.put(r14, r15)     // Catch:{ all -> 0x016f }
                        org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x016f }
                        r14.<init>()     // Catch:{ all -> 0x016f }
                        java.lang.String r15 = "id"
                        java.util.UUID r16 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x016f }
                        java.lang.String r9 = r16.toString()     // Catch:{ all -> 0x016f }
                        r14.put(r15, r9)     // Catch:{ all -> 0x016f }
                        java.lang.String r9 = "type"
                        java.lang.String r15 = "debug"
                        r14.put(r9, r15)     // Catch:{ all -> 0x016f }
                        java.lang.String r9 = "session_time"
                        java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x016f }
                        r15.<init>(r8)     // Catch:{ all -> 0x016f }
                        long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016f }
                        r20 = 1000(0x3e8, double:4.94E-321)
                        r16 = r5
                        r22 = r6
                        long r5 = r18 / r20
                        r15.append(r5)     // Catch:{ all -> 0x0169 }
                        java.lang.String r5 = r15.toString()     // Catch:{ all -> 0x0169 }
                        r14.put(r9, r5)     // Catch:{ all -> 0x0169 }
                        java.lang.String r5 = "time"
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
                        r6.<init>(r8)     // Catch:{ all -> 0x0169 }
                        long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0169 }
                        long r8 = r8 / r20
                        r6.append(r8)     // Catch:{ all -> 0x0169 }
                        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0169 }
                        r14.put(r5, r6)     // Catch:{ all -> 0x0169 }
                        java.lang.String r5 = "session_id"
                        r14.put(r5, r11)     // Catch:{ all -> 0x0169 }
                        r14.put(r0, r13)     // Catch:{ all -> 0x0169 }
                        r14.put(r3, r2)     // Catch:{ all -> 0x0169 }
                        android.content.Context r2 = r4     // Catch:{ all -> 0x0169 }
                        com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.addEnvFields(r2, r13, r11)     // Catch:{ all -> 0x0169 }
                        org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x0169 }
                        r2.<init>()     // Catch:{ all -> 0x0169 }
                        r2.put(r14)     // Catch:{ all -> 0x0169 }
                        org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0169 }
                        r3.<init>()     // Catch:{ all -> 0x0169 }
                        r3.put(r0, r12)     // Catch:{ all -> 0x0169 }
                        java.lang.String r0 = "events"
                        r3.put(r0, r2)     // Catch:{ all -> 0x0169 }
                        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0169 }
                        java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ all -> 0x0169 }
                        java.io.OutputStream r3 = r10.getOutputStream()     // Catch:{ all -> 0x0169 }
                        r2.<init>(r3)     // Catch:{ all -> 0x0169 }
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0162 }
                        r3.<init>(r7)     // Catch:{ all -> 0x0162 }
                        java.lang.String r0 = java.net.URLEncoder.encode(r0, r4)     // Catch:{ all -> 0x0162 }
                        r3.append(r0)     // Catch:{ all -> 0x0162 }
                        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0162 }
                        r2.writeBytes(r0)     // Catch:{ all -> 0x0162 }
                        r2.flush()     // Catch:{ all -> 0x0162 }
                        r0 = 16384(0x4000, float:2.2959E-41)
                        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0162 }
                        java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0162 }
                        r3.<init>()     // Catch:{ all -> 0x0162 }
                        java.io.InputStream r9 = r10.getInputStream()     // Catch:{ all -> 0x0162 }
                    L_0x0123:
                        int r4 = r9.read(r0)     // Catch:{ all -> 0x0159 }
                        r5 = -1
                        if (r4 == r5) goto L_0x0137
                        r5 = 0
                        r3.write(r0, r5, r4)     // Catch:{ all -> 0x012f }
                        goto L_0x0123
                    L_0x012f:
                        r0 = move-exception
                        r17 = r9
                        r4 = r16
                        r3 = r22
                        goto L_0x0160
                    L_0x0137:
                        r3.flush()     // Catch:{ all -> 0x0159 }
                        r2.close()     // Catch:{ Exception -> 0x0142 }
                        r4 = r16
                        r3 = r22
                        goto L_0x014b
                    L_0x0142:
                        r0 = move-exception
                        r2 = r0
                        r4 = r16
                        r3 = r22
                        android.util.Log.e(r3, r4, r2)
                    L_0x014b:
                        if (r9 == 0) goto L_0x0156
                        r9.close()     // Catch:{ Exception -> 0x0151 }
                        goto L_0x0156
                    L_0x0151:
                        r0 = move-exception
                        r2 = r0
                        android.util.Log.e(r3, r4, r2)
                    L_0x0156:
                        if (r10 == 0) goto L_0x019b
                        goto L_0x0198
                    L_0x0159:
                        r0 = move-exception
                        r4 = r16
                        r3 = r22
                        r17 = r9
                    L_0x0160:
                        r9 = r2
                        goto L_0x017b
                    L_0x0162:
                        r0 = move-exception
                        r4 = r16
                        r3 = r22
                        r9 = r2
                        goto L_0x0179
                    L_0x0169:
                        r0 = move-exception
                        r4 = r16
                        r3 = r22
                        goto L_0x0172
                    L_0x016f:
                        r0 = move-exception
                        r4 = r5
                        r3 = r6
                    L_0x0172:
                        r9 = 0
                        goto L_0x0179
                    L_0x0174:
                        r0 = move-exception
                        r4 = r5
                        r3 = r6
                        r9 = 0
                        r10 = 0
                    L_0x0179:
                        r17 = 0
                    L_0x017b:
                        java.lang.String r2 = "Can't send error."
                        android.util.Log.e(r3, r2, r0)     // Catch:{ all -> 0x019c }
                        if (r9 == 0) goto L_0x018b
                        r9.close()     // Catch:{ Exception -> 0x0186 }
                        goto L_0x018b
                    L_0x0186:
                        r0 = move-exception
                        r2 = r0
                        android.util.Log.e(r3, r4, r2)
                    L_0x018b:
                        if (r17 == 0) goto L_0x0196
                        r17.close()     // Catch:{ Exception -> 0x0191 }
                        goto L_0x0196
                    L_0x0191:
                        r0 = move-exception
                        r2 = r0
                        android.util.Log.e(r3, r4, r2)
                    L_0x0196:
                        if (r10 == 0) goto L_0x019b
                    L_0x0198:
                        r10.disconnect()
                    L_0x019b:
                        return
                    L_0x019c:
                        r0 = move-exception
                        r2 = r0
                        if (r9 == 0) goto L_0x01a9
                        r9.close()     // Catch:{ Exception -> 0x01a4 }
                        goto L_0x01a9
                    L_0x01a4:
                        r0 = move-exception
                        r5 = r0
                        android.util.Log.e(r3, r4, r5)
                    L_0x01a9:
                        if (r17 == 0) goto L_0x01b4
                        r17.close()     // Catch:{ Exception -> 0x01af }
                        goto L_0x01b4
                    L_0x01af:
                        r0 = move-exception
                        r5 = r0
                        android.util.Log.e(r3, r4, r5)
                    L_0x01b4:
                        if (r10 == 0) goto L_0x01b9
                        r10.disconnect()
                    L_0x01b9:
                        goto L_0x01bb
                    L_0x01ba:
                        throw r2
                    L_0x01bb:
                        goto L_0x01ba
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.AnonymousClass1.run():void");
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    public static void addEnvFields(Context context, JSONObject jSONObject, String str) throws JSONException, PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        jSONObject.put("APPBUILD", context.getPackageManager().getPackageInfo(packageName, 0).versionCode);
        jSONObject.put("APPNAME", context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(packageName, 0)));
        jSONObject.put("APPVERS", context.getPackageManager().getPackageInfo(packageName, 0).versionName);
        jSONObject.put("OSVERS", Build.VERSION.RELEASE);
        jSONObject.put("SDK", "android");
        jSONObject.put("SESSION_ID", str);
        jSONObject.put("MODEL", Build.MODEL);
        jSONObject.put("BUNDLE", packageName);
        jSONObject.put("SDK_VERSION", BuildConfigApi.getVersionName(context));
        jSONObject.put("OS", "Android");
    }
}
