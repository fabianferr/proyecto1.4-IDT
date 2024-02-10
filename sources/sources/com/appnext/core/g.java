package com.appnext.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.appnext.base.a;
import com.appnext.base.a.a.a;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.StringWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;

public final class g {
    private static double cT = -1.0d;
    private static String cU = "";
    private static String cV = "";
    private static String cW = "";

    static {
        CookieHandler.setDefault(new CookieManager());
    }

    public static String b(Context context, boolean z) {
        String str;
        if (context == null || context.getApplicationContext() == null) {
            return "";
        }
        try {
            str = AdsIDHelper.a(context.getApplicationContext(), z);
        } catch (Throwable th) {
            th.getMessage();
            if (!TextUtils.isEmpty(cV)) {
                return cV;
            }
            return "";
        }
        cV = str;
        return str;
    }

    public static String V() {
        try {
            return URLEncoder.encode("android " + Build.VERSION.SDK_INT + " " + Build.MANUFACTURER + " " + Build.MODEL, "UTF-8");
        } catch (Throwable th) {
            a.a("AppnextHelperClass$getDevice", th);
            return "android";
        }
    }

    public static String a(Context context, String str, HashMap<String, String> hashMap) throws IOException {
        return a(context, str, hashMap, true, 16000);
    }

    public static String a(Context context, String str, HashMap<String, String> hashMap, boolean z, int i) throws IOException {
        return new String(a(context, str, hashMap, z, i, a.C0025a.HashMap), "UTF-8");
    }

    public static String a(Context context, String str, ArrayList<Pair<String, String>> arrayList, int i) throws IOException {
        return new String(a(context, str, arrayList, true, 16000, a.C0025a.ArrayList), "UTF-8");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r9, java.lang.String r10, java.lang.Object r11, boolean r12, int r13, com.appnext.base.a.a.a.C0025a r14) throws java.io.IOException {
        /*
            java.net.URL r0 = new java.net.URL
            r0.<init>(r10)
            r10 = 0
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ all -> 0x0120 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x0120 }
            r0.setReadTimeout(r13)     // Catch:{ all -> 0x011e }
            r0.setConnectTimeout(r13)     // Catch:{ all -> 0x011e }
            java.lang.String r1 = "Accept-Encoding"
            java.lang.String r2 = "gzip"
            r0.setRequestProperty(r1, r2)     // Catch:{ all -> 0x011e }
            java.lang.String r1 = "User-Agent"
            com.appnext.core.q r2 = com.appnext.core.q.ad()     // Catch:{ all -> 0x011e }
            java.lang.String r2 = r2.j(r9)     // Catch:{ all -> 0x011e }
            r0.setRequestProperty(r1, r2)     // Catch:{ all -> 0x011e }
            java.lang.String r1 = "UTF-8"
            if (r11 == 0) goto L_0x00c5
            r2 = 1
            r0.setDoOutput(r2)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = "POST"
            r0.setRequestMethod(r2)     // Catch:{ all -> 0x011e }
            com.appnext.base.a.a.a$a r2 = com.appnext.base.a.a.a.C0025a.JSONObject     // Catch:{ all -> 0x011e }
            if (r14 == r2) goto L_0x003b
            com.appnext.base.a.a.a$a r2 = com.appnext.base.a.a.a.C0025a.JSONArray     // Catch:{ all -> 0x011e }
            if (r14 != r2) goto L_0x0045
        L_0x003b:
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/json"
            r0.setRequestProperty(r2, r3)     // Catch:{ all -> 0x011e }
            r11.toString()     // Catch:{ all -> 0x011e }
        L_0x0045:
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ all -> 0x011e }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ all -> 0x011e }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x011e }
            r4.<init>(r2, r1)     // Catch:{ all -> 0x011e }
            r3.<init>(r4)     // Catch:{ all -> 0x011e }
            com.appnext.base.a.a.a$a r4 = com.appnext.base.a.a.a.C0025a.JSONArray     // Catch:{ all -> 0x011e }
            if (r14 != r4) goto L_0x0062
            r4 = r11
            org.json.JSONArray r4 = (org.json.JSONArray) r4     // Catch:{ all -> 0x011e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x011e }
            r3.write(r4)     // Catch:{ all -> 0x011e }
            goto L_0x00bc
        L_0x0062:
            com.appnext.base.a.a.a$a r4 = com.appnext.base.a.a.a.C0025a.JSONObject     // Catch:{ all -> 0x011e }
            if (r14 != r4) goto L_0x0071
            r4 = r11
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ all -> 0x011e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x011e }
            r3.write(r4)     // Catch:{ all -> 0x011e }
            goto L_0x00bc
        L_0x0071:
            com.appnext.base.a.a.a$a r4 = com.appnext.base.a.a.a.C0025a.HashMap     // Catch:{ all -> 0x011e }
            if (r14 != r4) goto L_0x00ae
            r4 = r11
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ all -> 0x011e }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x011e }
            r5.<init>()     // Catch:{ all -> 0x011e }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x011e }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x011e }
        L_0x0085:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x011e }
            if (r6 == 0) goto L_0x00a6
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x011e }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x011e }
            android.util.Pair r7 = new android.util.Pair     // Catch:{ all -> 0x011e }
            java.lang.Object r8 = r6.getKey()     // Catch:{ all -> 0x011e }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x011e }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x011e }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x011e }
            r7.<init>(r8, r6)     // Catch:{ all -> 0x011e }
            r5.add(r7)     // Catch:{ all -> 0x011e }
            goto L_0x0085
        L_0x00a6:
            java.lang.String r4 = a((java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) r5, (boolean) r12)     // Catch:{ all -> 0x011e }
            r3.write(r4)     // Catch:{ all -> 0x011e }
            goto L_0x00bc
        L_0x00ae:
            com.appnext.base.a.a.a$a r4 = com.appnext.base.a.a.a.C0025a.ArrayList     // Catch:{ all -> 0x011e }
            if (r14 != r4) goto L_0x00bc
            r4 = r11
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x011e }
            java.lang.String r4 = a((java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) r4, (boolean) r12)     // Catch:{ all -> 0x011e }
            r3.write(r4)     // Catch:{ all -> 0x011e }
        L_0x00bc:
            r3.flush()     // Catch:{ all -> 0x011e }
            r3.close()     // Catch:{ all -> 0x011e }
            r2.close()     // Catch:{ all -> 0x011e }
        L_0x00c5:
            int r2 = r0.getResponseCode()     // Catch:{ all -> 0x011e }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L_0x00e4
            java.io.InputStream r10 = r0.getInputStream()     // Catch:{ all -> 0x011e }
            java.io.InputStream r9 = a((java.io.InputStream) r10)     // Catch:{ all -> 0x011e }
            byte[] r9 = b((java.io.InputStream) r9)     // Catch:{ all -> 0x011e }
            if (r10 == 0) goto L_0x00de
            r10.close()
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            r0.disconnect()
        L_0x00e3:
            return r9
        L_0x00e4:
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x0109
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L_0x0109
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 != r3) goto L_0x00f1
            goto L_0x0109
        L_0x00f1:
            java.lang.String r9 = ""
            java.io.InputStream r10 = r0.getErrorStream()     // Catch:{ all -> 0x011e }
            if (r10 == 0) goto L_0x0103
            byte[] r9 = b((java.io.InputStream) r10)     // Catch:{ all -> 0x011e }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x011e }
            r11.<init>(r9, r1)     // Catch:{ all -> 0x011e }
            r9 = r11
        L_0x0103:
            java.net.HttpRetryException r11 = new java.net.HttpRetryException     // Catch:{ all -> 0x011e }
            r11.<init>(r9, r2)     // Catch:{ all -> 0x011e }
            throw r11     // Catch:{ all -> 0x011e }
        L_0x0109:
            java.lang.String r1 = "Location"
            java.lang.String r3 = r0.getHeaderField(r1)     // Catch:{ all -> 0x011e }
            r2 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            byte[] r9 = a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x011e }
            if (r0 == 0) goto L_0x011d
            r0.disconnect()
        L_0x011d:
            return r9
        L_0x011e:
            r9 = move-exception
            goto L_0x0122
        L_0x0120:
            r9 = move-exception
            r0 = r10
        L_0x0122:
            if (r10 == 0) goto L_0x0127
            r10.close()
        L_0x0127:
            if (r0 == 0) goto L_0x012c
            r0.disconnect()
        L_0x012c:
            goto L_0x012e
        L_0x012d:
            throw r9
        L_0x012e:
            goto L_0x012d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.g.a(android.content.Context, java.lang.String, java.lang.Object, boolean, int, com.appnext.base.a.a.a$a):byte[]");
    }

    public static InputStream a(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 2);
        byte[] bArr = new byte[2];
        try {
            pushbackInputStream.unread(bArr, 0, pushbackInputStream.read(bArr));
            return (bArr[0] == 31 && bArr[1] == -117) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
        } catch (Throwable unused) {
            return inputStream;
        }
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap p(java.lang.String r3) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x002e }
            r1.<init>(r3)     // Catch:{ all -> 0x002e }
            java.net.URLConnection r3 = r1.openConnection()     // Catch:{ all -> 0x002e }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ all -> 0x002e }
            r1 = 1
            r3.setDoInput(r1)     // Catch:{ all -> 0x002c }
            r3.connect()     // Catch:{ all -> 0x002c }
            java.io.InputStream r1 = r3.getInputStream()     // Catch:{ all -> 0x002c }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ all -> 0x002c }
            r1.close()     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x0026
            if (r3 == 0) goto L_0x0025
            r3.disconnect()
        L_0x0025:
            return r0
        L_0x0026:
            if (r3 == 0) goto L_0x002b
            r3.disconnect()
        L_0x002b:
            return r2
        L_0x002c:
            r1 = move-exception
            goto L_0x0030
        L_0x002e:
            r1 = move-exception
            r3 = r0
        L_0x0030:
            java.lang.String r2 = "AppnextHelperClass$getBitmapFromURL"
            com.appnext.base.a.a(r2, r1)     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x003a
            r3.disconnect()
        L_0x003a:
            return r0
        L_0x003b:
            r0 = move-exception
            if (r3 == 0) goto L_0x0041
            r3.disconnect()
        L_0x0041:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.g.p(java.lang.String):android.graphics.Bitmap");
    }

    private static String a(List<Pair<String, String>> list, boolean z) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (Pair next : list) {
            try {
                if (next.first != null) {
                    if (next.second != null) {
                        StringBuilder sb2 = new StringBuilder();
                        if (z2) {
                            z2 = false;
                        } else {
                            sb2.append("&");
                        }
                        if (z) {
                            sb2.append(URLEncoder.encode(URLDecoder.decode((String) next.first, "UTF-8"), "UTF-8"));
                            sb2.append("=");
                            sb2.append(URLEncoder.encode(URLDecoder.decode((String) next.second, "UTF-8"), "UTF-8"));
                        } else {
                            sb2.append(URLEncoder.encode((String) next.first, "UTF-8"));
                            sb2.append("=");
                            sb2.append(URLEncoder.encode((String) next.second, "UTF-8"));
                        }
                        String str = (String) next.first;
                        String str2 = (String) next.second;
                        sb.append(sb2);
                    }
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("AppnextHelperClass$getPostDataString", th);
            }
        }
        return sb.toString();
    }

    public static int a(Context context, float f) {
        return (int) (f * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        String str10 = str6;
        try {
            if (TextUtils.isEmpty(str6)) {
                return;
            }
            if (str10.equals("video_started") || str10.equals("video_ended")) {
                final String str11 = str5;
                final String str12 = str6;
                final String str13 = str;
                final String str14 = str2;
                final String str15 = str3;
                final String str16 = str4;
                final String str17 = str7;
                final String str18 = str8;
                final String str19 = str9;
                final Context context2 = context;
                n.aa().a(new Runnable() {
                    public final void run() {
                        String str;
                        String str2 = "";
                        try {
                            str = URLEncoder.encode(str11.replace(" ", "_"), "UTF-8");
                        } catch (Throwable unused) {
                            str = str2;
                        }
                        try {
                            str2 = URLEncoder.encode(str12.replace(" ", "_"), "UTF-8");
                        } catch (Throwable unused2) {
                        }
                        Object[] objArr = new Object[10];
                        objArr[0] = str13;
                        objArr[1] = str14;
                        objArr[2] = StatisticData.ERROR_CODE_NOT_FOUND;
                        objArr[3] = str15;
                        objArr[4] = str;
                        objArr[5] = str16;
                        objArr[6] = str2;
                        objArr[7] = str17;
                        String str3 = "0";
                        objArr[8] = TextUtils.isEmpty(str18) ? str3 : str18;
                        if (!TextUtils.isEmpty(str19)) {
                            str3 = str19;
                        }
                        objArr[9] = str3;
                        try {
                            g.a(context2, String.format("https://admin.appnext.com/tp12.aspx?tid=%s&vid=%s&osid=%s&auid=%s&session_id=%s&pid=%s&ref=%s&ads_type=%s&bid=%s&cid=%s", objArr), (HashMap<String, String>) null);
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextHelperClass$report", th);
        }
    }

    public static void a(Ad ad, AppnextAd appnextAd, String str, String str2, SettingsManager settingsManager) {
        final AppnextAd appnextAd2 = appnextAd;
        final SettingsManager settingsManager2 = settingsManager;
        final Ad ad2 = ad;
        final String str3 = str2;
        final String str4 = str;
        n.aa().a(new Runnable() {
            public final void run() {
                try {
                    if (AppnextAd.this == null) {
                        return;
                    }
                    if (Boolean.parseBoolean(settingsManager2.t("stp_flag"))) {
                        ArrayList arrayList = new ArrayList();
                        StringBuilder sb = new StringBuilder();
                        sb.append(System.currentTimeMillis());
                        arrayList.add(new Pair("client_date", sb.toString()));
                        arrayList.add(new Pair("did", g.b(ad2.getContext(), true)));
                        arrayList.add(new Pair("session_id", AppnextAd.this.getSession()));
                        arrayList.add(new Pair(ScarConstants.TOKEN_ID_KEY, ad2.getTID()));
                        arrayList.add(new Pair("vid", ad2.getVID()));
                        arrayList.add(new Pair(JsonStorageKeyNames.AUID_ID_KEY, ad2.getAUID()));
                        arrayList.add(new Pair("osid", StatisticData.ERROR_CODE_NOT_FOUND));
                        arrayList.add(new Pair("tem_id", str3));
                        arrayList.add(new Pair("pid", ad2.getPlacementID()));
                        arrayList.add(new Pair("banner_id", AppnextAd.this.getBannerID()));
                        arrayList.add(new Pair("cm_id", AppnextAd.this.getCampaignID()));
                        arrayList.add(new Pair("event_name", str4));
                        arrayList.add(new Pair("package_id", ad2.getContext().getPackageName()));
                        g.a(ad2.context, "https://global.appnext.com/stp.aspx", arrayList, 16000);
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("AppnextHelperClass$tpReport", th);
                }
            }
        });
    }

    public static boolean b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 128);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String e(String str, String str2) {
        String cookie = android.webkit.CookieManager.getInstance().getCookie(str);
        if (cookie == null) {
            return "";
        }
        String str3 = "";
        for (String str4 : cookie.split(";")) {
            if (str4.contains(str2)) {
                String[] split = str4.split("=");
                if (split.length <= 1) {
                    return "";
                }
                str3 = split[1];
            }
        }
        return str3;
    }

    public static String c(Context context) {
        if (context == null || context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "-";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() != 0) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int q(java.lang.String r6) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r6 = r6.toLowerCase(r0)
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = -1
            switch(r0) {
                case 1653: goto L_0x0039;
                case 1684: goto L_0x002e;
                case 1715: goto L_0x0023;
                case 3649301: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            r6 = -1
            goto L_0x0043
        L_0x0017:
            java.lang.String r0 = "wifi"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0021
            goto L_0x0015
        L_0x0021:
            r6 = 3
            goto L_0x0043
        L_0x0023:
            java.lang.String r0 = "4g"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x002c
            goto L_0x0015
        L_0x002c:
            r6 = 2
            goto L_0x0043
        L_0x002e:
            java.lang.String r0 = "3g"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0037
            goto L_0x0015
        L_0x0037:
            r6 = 1
            goto L_0x0043
        L_0x0039:
            java.lang.String r0 = "2g"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0042
            goto L_0x0015
        L_0x0042:
            r6 = 0
        L_0x0043:
            switch(r6) {
                case 0: goto L_0x004a;
                case 1: goto L_0x0049;
                case 2: goto L_0x0048;
                case 3: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            return r5
        L_0x0047:
            return r1
        L_0x0048:
            return r2
        L_0x0049:
            return r3
        L_0x004a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.g.q(java.lang.String):int");
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String obj = stringWriter.toString();
        return obj.length() > 512 ? obj.substring(0, 512) : obj;
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
            return false;
        }
        return true;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(cW)) {
            synchronized ("2.7.0.473") {
                if (TextUtils.isEmpty(cW)) {
                    cW = e(context);
                }
            }
        }
        return cW;
    }

    private static String r(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length << 1);
            for (int i = 0; i < length; i++) {
                sb.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(digest[i] & Ascii.SI, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            com.appnext.base.a.a("AppnextHelperClass$md5", e);
            return c(32);
        }
    }

    private static String c(int i) {
        char[] charArray = "0123456789abcdef".toCharArray();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 32; i2++) {
            sb.append(charArray[random.nextInt(charArray.length)]);
        }
        return sb.toString();
    }

    public static String b(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring.contains("?")) {
            substring = substring.substring(0, substring.indexOf("?"));
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("rnd");
            if (queryParameter == null || queryParameter.equals("")) {
                return substring;
            }
            return substring.substring(0, substring.lastIndexOf(46)) + "_" + queryParameter + substring.substring(substring.lastIndexOf(46));
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextHelperClass$extractFileNameFromPath", th);
            return substring;
        }
    }

    public static String e(AppnextAd appnextAd) {
        String str;
        StringBuilder sb = new StringBuilder("https://www.appnext.com/privacy_policy/index.html?z=");
        sb.append(new Random().nextInt(10));
        sb.append(appnextAd.getZoneID());
        sb.append(new Random().nextInt(10));
        if (appnextAd.isGdpr()) {
            str = "&edda=1&geo=" + appnextAd.getCountry();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public static boolean f(Context context) {
        try {
            if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
                a(context, "http://www.appnext.com/myid.html", (HashMap<String, String>) null);
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            throw new IOException();
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextHelperClass$checkConnection", th);
            return false;
        }
    }

    public static String W() {
        String[] split = "2.7.0.473".split("\\.");
        if (split.length < 4) {
            return "2.7.0.473";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(split[i]);
            if (i < 2) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                a(a);
            }
        }
        file.delete();
    }

    public static String f(String str, String str2) {
        try {
            String[] split = str.split("&");
            HashMap hashMap = new HashMap();
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                String str3 = split3[0];
                String str4 = "";
                if (split3.length == 2) {
                    str4 = split3[1];
                }
                hashMap.put(str3, str4);
            }
            return (String) hashMap.get(str2);
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextHelperClass$getQueryMap", th);
            return null;
        }
    }

    public static boolean g(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static String e(Context context) {
        String b = b(context, true);
        if (TextUtils.isEmpty(b)) {
            return c(32);
        }
        return r(b + "_" + (System.currentTimeMillis() / 1000));
    }
}
