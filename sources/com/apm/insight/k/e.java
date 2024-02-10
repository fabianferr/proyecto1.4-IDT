package com.apm.insight.k;

import android.text.TextUtils;
import com.apm.insight.Npth;
import com.apm.insight.i;
import com.apm.insight.l.k;
import com.apm.insight.l.q;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public static boolean a = false;
    private static h b;

    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        
        final int d;

        private a(int i) {
            this.d = i;
        }
    }

    public enum b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5),
        MOBILE_5G(6),
        WIFI_24GHZ(7),
        WIFI_5GHZ(8),
        MOBILE_3G_H(9),
        MOBILE_3G_HP(10);
        
        final int l;

        private b(int i) {
            this.l = i;
        }
    }

    public static l a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) {
        String str3;
        StringBuilder sb;
        String str4;
        if (Npth.isStopUpload()) {
            return new l(201);
        }
        if (str == null) {
            return new l(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (a.GZIP == aVar && length > 128) {
            bArr = b(bArr);
            str3 = "gzip";
        } else if (a.DEFLATER != aVar || length <= 128) {
            str3 = null;
        } else {
            bArr = a(bArr);
            str3 = "deflate";
        }
        String str5 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new l(202);
        }
        if (!z) {
            return a(str, bArr2, str2, str5, "POST", true, false);
        }
        byte[] a2 = i.i().getEncryptImpl().a(bArr2);
        if (a2 != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                str4 = "?";
                if (!str.endsWith(str4)) {
                    sb = new StringBuilder();
                }
                str = str + "tt_data=a";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = a2;
            } else {
                str4 = "&";
                if (!str.endsWith(str4)) {
                    sb = new StringBuilder();
                }
                str = str + "tt_data=a";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = a2;
            }
            sb.append(str);
            sb.append(str4);
            str = sb.toString();
            str = str + "tt_data=a";
            str2 = "application/octet-stream;tt-data=a";
            bArr2 = a2;
        }
        return a(str, bArr2, str2, str5, "POST", true, true);
    }

    public static l a(String str, String str2) {
        return a(str, str2, b());
    }

    public static l a(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    return a(2097152, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z);
                }
            }
            return new l(201);
        } catch (Throwable th) {
            q.b(th);
            return new l(207, th);
        }
    }

    public static l a(String str, String str2, File... fileArr) {
        return b(str, str2, fileArr);
    }

    private static l a(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        return b(str, bArr, str2, str3, str4, z, z2);
    }

    private static String a(String str, Map map) {
        if (TextUtils.isDigitsOnly(str) || map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    if (!sb.toString().endsWith("?")) {
                        sb.append("&");
                    }
                    sb.append(d(entry.getKey().toString(), "UTF-8"));
                    sb.append("=");
                    sb.append(d(entry.getValue().toString(), "UTF-8"));
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(h hVar) {
        b = hVar;
    }

    public static boolean a() {
        return true;
    }

    public static boolean a(String str, String str2, String str3, String str4, List<String> list) {
        if (Npth.isStopUpload()) {
            return false;
        }
        try {
            j jVar = new j(str, "UTF-8", false);
            jVar.a("aid", str2);
            jVar.a("device_id", str3);
            jVar.a("os", "Android");
            jVar.a("process_name", str4);
            for (String file : list) {
                File file2 = new File(file);
                if (file2.exists()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("logtype", "alog");
                    hashMap.put("scene", "Crash");
                    jVar.a(file2.getName(), file2, (Map<String, String>) hashMap);
                }
            }
            try {
                return new JSONObject(jVar.a()).optInt("errno", -1) == 200;
            } catch (JSONException unused) {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    k.a((Closeable) byteArrayOutputStream);
                }
            }
        }
    }

    public static byte[] a(String str, Map<String, String> map, byte[] bArr) {
        try {
            return a(2097152, a(str, (Map) map), bArr, a.GZIP, "application/json; charset=utf-8", false).b();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static l b(String str, String str2) {
        return a(str, str2, a());
    }

    public static l b(String str, String str2, File... fileArr) {
        if (Npth.isStopUpload()) {
            return new l(201);
        }
        try {
            j jVar = new j(c(str, "have_dump=true&encrypt=true"), "UTF-8", true);
            jVar.a("json", str2, true);
            jVar.a(ShareInternalUtility.STAGING_PARAM, fileArr);
            try {
                return new l(0, new JSONObject(jVar.a()));
            } catch (JSONException e) {
                return new l(0, (Throwable) e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new l(207);
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|(2:4|5)|6|7|(3:9|10|11)(1:12)|(1:14)|(1:16)|17|(4:19|(6:23|24|25|26|27|28)|35|(8:37|38|39|(6:41|42|43|44|45|46)(1:52)|53|(2:55|56)|57|59)(5:62|63|(2:65|66)|67|69))(3:70|71|72)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A[Catch:{ all -> 0x0053, all -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[Catch:{ all -> 0x0053, all -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[Catch:{ all -> 0x0053, all -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[Catch:{ all -> 0x0053, all -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00b8 A[SYNTHETIC, Splitter:B:70:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00d3 A[SYNTHETIC, Splitter:B:80:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.apm.insight.k.l b(java.lang.String r4, byte[] r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, boolean r10) {
        /*
            java.lang.String r10 = "gzip"
            java.lang.String r0 = "http response code "
            r1 = 0
            com.apm.insight.k.h r2 = b     // Catch:{ all -> 0x00c5 }
            if (r2 == 0) goto L_0x000d
            java.lang.String r4 = r2.a(r4, r5)     // Catch:{ all -> 0x000d }
        L_0x000d:
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x00c5 }
            r2.<init>(r4)     // Catch:{ all -> 0x00c5 }
            java.net.URLConnection r4 = r2.openConnection()     // Catch:{ all -> 0x00c5 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x00c5 }
            if (r9 == 0) goto L_0x001f
            r9 = 1
            r4.setDoOutput(r9)     // Catch:{ all -> 0x00c0 }
            goto L_0x0023
        L_0x001f:
            r9 = 0
            r4.setDoOutput(r9)     // Catch:{ all -> 0x00c0 }
        L_0x0023:
            if (r6 == 0) goto L_0x002a
            java.lang.String r9 = "Content-Type"
            r4.setRequestProperty(r9, r6)     // Catch:{ all -> 0x00c0 }
        L_0x002a:
            if (r7 == 0) goto L_0x0031
            java.lang.String r6 = "Content-Encoding"
            r4.setRequestProperty(r6, r7)     // Catch:{ all -> 0x00c0 }
        L_0x0031:
            java.lang.String r6 = "Accept-Encoding"
            r4.setRequestProperty(r6, r10)     // Catch:{ all -> 0x00c0 }
            if (r8 == 0) goto L_0x00b8
            r4.setRequestMethod(r8)     // Catch:{ all -> 0x00c0 }
            if (r5 == 0) goto L_0x005b
            int r6 = r5.length     // Catch:{ all -> 0x00c0 }
            if (r6 <= 0) goto L_0x005b
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ all -> 0x0055 }
            java.io.OutputStream r7 = r4.getOutputStream()     // Catch:{ all -> 0x0055 }
            r6.<init>(r7)     // Catch:{ all -> 0x0055 }
            r6.write(r5)     // Catch:{ all -> 0x0053 }
            r6.flush()     // Catch:{ all -> 0x0053 }
            com.apm.insight.l.k.a((java.io.Closeable) r6)     // Catch:{ all -> 0x00c0 }
            goto L_0x005b
        L_0x0053:
            r5 = move-exception
            goto L_0x0057
        L_0x0055:
            r5 = move-exception
            r6 = r1
        L_0x0057:
            com.apm.insight.l.k.a((java.io.Closeable) r6)     // Catch:{ all -> 0x00c0 }
            throw r5     // Catch:{ all -> 0x00c0 }
        L_0x005b:
            int r5 = r4.getResponseCode()     // Catch:{ all -> 0x00c0 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 != r6) goto L_0x009c
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = r4.getContentEncoding()     // Catch:{ all -> 0x0097 }
            boolean r6 = r10.equalsIgnoreCase(r6)     // Catch:{ all -> 0x0097 }
            if (r6 == 0) goto L_0x0086
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0081 }
            r6.<init>(r5)     // Catch:{ all -> 0x0081 }
            byte[] r7 = a((java.io.InputStream) r6)     // Catch:{ all -> 0x007e }
            com.apm.insight.l.k.a((java.io.Closeable) r6)     // Catch:{ all -> 0x0097 }
            goto L_0x008a
        L_0x007e:
            r7 = move-exception
            r1 = r6
            goto L_0x0082
        L_0x0081:
            r7 = move-exception
        L_0x0082:
            com.apm.insight.l.k.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0097 }
            throw r7     // Catch:{ all -> 0x0097 }
        L_0x0086:
            byte[] r7 = a((java.io.InputStream) r5)     // Catch:{ all -> 0x0097 }
        L_0x008a:
            com.apm.insight.k.l r6 = c(r7)     // Catch:{ all -> 0x0097 }
            if (r4 == 0) goto L_0x0093
            r4.disconnect()     // Catch:{ Exception -> 0x0093 }
        L_0x0093:
            com.apm.insight.l.k.a((java.io.Closeable) r5)
            return r6
        L_0x0097:
            r6 = move-exception
            r1 = r4
            r4 = r5
            r5 = r6
            goto L_0x00c7
        L_0x009c:
            com.apm.insight.k.l r6 = new com.apm.insight.k.l     // Catch:{ all -> 0x00c0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            r7.<init>(r0)     // Catch:{ all -> 0x00c0 }
            r7.append(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00c0 }
            r7 = 206(0xce, float:2.89E-43)
            r6.<init>((int) r7, (java.lang.String) r5)     // Catch:{ all -> 0x00c0 }
            if (r4 == 0) goto L_0x00b4
            r4.disconnect()     // Catch:{ Exception -> 0x00b4 }
        L_0x00b4:
            com.apm.insight.l.k.a((java.io.Closeable) r1)
            return r6
        L_0x00b8:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "request method is not null"
            r5.<init>(r6)     // Catch:{ all -> 0x00c0 }
            throw r5     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r5 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
            goto L_0x00c7
        L_0x00c5:
            r5 = move-exception
            r4 = r1
        L_0x00c7:
            com.apm.insight.l.q.a((java.lang.Throwable) r5)     // Catch:{ all -> 0x00da }
            com.apm.insight.k.l r6 = new com.apm.insight.k.l     // Catch:{ all -> 0x00da }
            r7 = 207(0xcf, float:2.9E-43)
            r6.<init>((int) r7, (java.lang.Throwable) r5)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00d6
            r1.disconnect()     // Catch:{ Exception -> 0x00d6 }
        L_0x00d6:
            com.apm.insight.l.k.a((java.io.Closeable) r4)
            return r6
        L_0x00da:
            r5 = move-exception
            if (r1 == 0) goto L_0x00e0
            r1.disconnect()     // Catch:{ Exception -> 0x00e0 }
        L_0x00e0:
            com.apm.insight.l.k.a((java.io.Closeable) r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.e.b(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.apm.insight.k.l");
    }

    public static boolean b() {
        return true;
    }

    private static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    private static l c(byte[] bArr) {
        return new l(204, bArr);
    }

    public static String c() {
        return i.i().getJavaCrashUploadUrl();
    }

    private static String c(String str, String str2) {
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str + "?";
                }
            } else if (!str.endsWith("&")) {
                str = str + "&";
            }
            return str + str2;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String d() {
        return i.i().getAlogUploadUrl();
    }

    private static String d(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String e() {
        return i.i().getLaunchCrashUploadUrl();
    }

    public static String f() {
        return i.i().getExceptionUploadUrl();
    }

    public static String g() {
        return i.i().getNativeCrashUploadUrl();
    }
}
