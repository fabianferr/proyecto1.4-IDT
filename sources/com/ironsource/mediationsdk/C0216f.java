package com.ironsource.mediationsdk;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.f  reason: case insensitive filesystem */
public final class C0216f {
    public C0217g a;
    private final String b = "1";
    private final String c = "102";
    private final String d = "102";
    private final String e = "GenericNotifications";
    private IronSource.AD_UNIT f;
    private String g;
    private c h;
    private C0214d i;
    private ISBannerSize j;

    /* renamed from: com.ironsource.mediationsdk.f$a */
    public static class a implements Runnable {
        protected C0215e.a a;
        protected int b;
        protected String c;
        protected int d;
        protected String e = "other";
        protected String f = "";
        protected int g = 0;
        private WeakReference<C0214d> h;
        private long i;
        private int j;
        private final URL k;
        private final JSONObject l;
        private final boolean m;
        private final int n;
        private final long o;
        private final boolean p;
        private final boolean q;
        private final int r;

        public a(C0214d dVar, URL url, JSONObject jSONObject, boolean z, int i2, long j2, boolean z2, boolean z3, int i3) {
            this.h = new WeakReference<>(dVar);
            this.k = url;
            this.l = jSONObject;
            this.m = z;
            this.n = i2;
            this.o = j2;
            this.p = z2;
            this.q = z3;
            this.r = i3;
        }

        private static String a(HttpURLConnection httpURLConnection) {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        /* JADX WARNING: type inference failed for: r0v22, types: [java.net.URLConnection] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x024a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a() {
            /*
                r17 = this;
                r1 = r17
                java.lang.String r2 = "decompression error"
                java.lang.String r3 = "decryption error"
                java.lang.String r4 = "other"
                java.util.Date r0 = new java.util.Date
                r0.<init>()
                long r5 = r0.getTime()
                r1.i = r5
                r5 = 0
                int r0 = r1.g     // Catch:{ Exception -> 0x0297 }
                r6 = 1015(0x3f7, float:1.422E-42)
                r7 = 1
                if (r0 != r6) goto L_0x001d
                r0 = 1
                goto L_0x001f
            L_0x001d:
                int r0 = r1.r     // Catch:{ Exception -> 0x0297 }
            L_0x001f:
                r1.j = r0     // Catch:{ Exception -> 0x0297 }
                r1.d = r5
                r0 = 0
                r8 = r0
            L_0x0025:
                int r0 = r1.d
                int r9 = r1.n
                if (r0 >= r9) goto L_0x028c
                java.util.Date r0 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                r0.<init>()     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                long r9 = r0.getTime()     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.lang.String r11 = "Auction Handler: auction trial "
                r0.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                int r11 = r1.d     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                int r11 = r11 + r7
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.lang.String r11 = " out of "
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                int r11 = r1.n     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.lang.String r11 = " max trials"
                r0.append(r11)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.lang.String r0 = r0.toString()     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                com.ironsource.mediationsdk.logger.IronSourceLoggerManager r11 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r12 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                r11.log(r12, r0, r5)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                com.ironsource.mediationsdk.utils.IronSourceUtils.sendAutomationLog(r0)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.net.URL r0 = r1.k     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                long r11 = r1.o     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                int r12 = (int) r11     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                r11 = r0
                java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.lang.String r0 = "POST"
                r11.setRequestMethod(r0)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r13 = "application/json; charset=utf-8"
                r11.setRequestProperty(r0, r13)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                r11.setReadTimeout(r12)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                r11.setDoInput(r7)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                r11.setDoOutput(r7)     // Catch:{ SocketTimeoutException -> 0x025b, all -> 0x0234 }
                org.json.JSONObject r8 = r1.l     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                boolean r12 = r1.p     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.io.OutputStream r13 = r11.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.io.OutputStreamWriter r14 = new java.io.OutputStreamWriter     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r14.<init>(r13, r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.io.BufferedWriter r15 = new java.io.BufferedWriter     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r15.<init>(r14)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r16 = ""
                int r0 = r1.j     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r5 = 2
                if (r0 != r5) goto L_0x00c7
                com.ironsource.mediationsdk.utils.e r0 = com.ironsource.mediationsdk.utils.e.a()     // Catch:{ JSONException -> 0x00a5 }
                java.lang.String r16 = r0.d()     // Catch:{ JSONException -> 0x00a5 }
                goto L_0x00c7
            L_0x00a5:
                r0 = move-exception
                java.lang.String r5 = r0.getLocalizedMessage()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r1.f = r5     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r1.g = r6     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r1.j = r7     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r7 = "get encrypted session key exception "
                r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r6.append(r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = r6.toString()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r5.error(r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
            L_0x00c7:
                java.lang.String r0 = r8.toString()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r5 = r17.b()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                if (r12 == 0) goto L_0x00dd
                com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r7 = "compressing and encrypting auction request"
                r6.verbose(r7)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.compressAndEncrypt(r5, r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                goto L_0x00e1
            L_0x00dd:
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.encode(r5, r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
            L_0x00e1:
                int r5 = r1.j     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r6 = 2
                if (r5 != r6) goto L_0x00f6
                java.lang.String r5 = "{\"sk\" : \"%1$s\", \"ct\" : \"%2$s\"}"
                java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r6 = 0
                r7[r6] = r16     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r6 = 1
                r7[r6] = r0     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = java.lang.String.format(r5, r7)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                goto L_0x0103
            L_0x00f6:
                java.lang.String r5 = "{\"request\" : \"%1$s\"}"
                r6 = 1
                java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r6 = 0
                r7[r6] = r0     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = java.lang.String.format(r5, r7)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
            L_0x0103:
                r15.write(r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r15.flush()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r15.close()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r14.close()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r13.close()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                int r0 = r11.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r5 = 200(0xc8, float:2.8E-43)
                if (r0 == r5) goto L_0x015d
                r5 = 204(0xcc, float:2.86E-43)
                if (r0 == r5) goto L_0x015d
                r5 = 1001(0x3e9, float:1.403E-42)
                r1.b = r5     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r6 = "Auction response code not valid, error code response from server - "
                r5.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r5.append(r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = r5.toString()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r1.c = r0     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r5 = r1.c     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r0.error(r5)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r11.disconnect()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                int r0 = r1.d     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                int r5 = r1.n     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r6 = 1
                int r5 = r5 - r6
                if (r0 >= r5) goto L_0x015a
                long r5 = r1.o     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.util.Date r0 = new java.util.Date     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                long r7 = r0.getTime()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                long r7 = r7 - r9
                long r5 = r5 - r7
                r7 = 0
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 <= 0) goto L_0x015a
                android.os.SystemClock.sleep(r5)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
            L_0x015a:
                r8 = r11
                goto L_0x0280
            L_0x015d:
                java.lang.String r0 = a(r11)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                boolean r5 = r1.m     // Catch:{ JSONException -> 0x01d6 }
                boolean r6 = r1.q     // Catch:{ JSONException -> 0x01d6 }
                boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x01d6 }
                if (r7 != 0) goto L_0x01ce
                org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d6 }
                r7.<init>(r0)     // Catch:{ JSONException -> 0x01d6 }
                if (r5 == 0) goto L_0x01b6
                java.lang.String r0 = r17.b()     // Catch:{ JSONException -> 0x01d6 }
                int r5 = r1.j     // Catch:{ JSONException -> 0x01d6 }
                r8 = 2
                if (r5 != r8) goto L_0x017e
                java.lang.String r5 = "ct"
                goto L_0x0180
            L_0x017e:
                java.lang.String r5 = "response"
            L_0x0180:
                java.lang.String r5 = r7.getString(r5)     // Catch:{ JSONException -> 0x01d6 }
                if (r6 == 0) goto L_0x019f
                com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ JSONException -> 0x01d6 }
                java.lang.String r7 = "decrypting and decompressing auction response"
                r6.verbose(r7)     // Catch:{ JSONException -> 0x01d6 }
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.decryptAndDecompress(r0, r5)     // Catch:{ JSONException -> 0x01d6 }
                if (r0 == 0) goto L_0x0199
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d6 }
                r5.<init>(r0)     // Catch:{ JSONException -> 0x01d6 }
                goto L_0x01ae
            L_0x0199:
                org.json.JSONException r0 = new org.json.JSONException     // Catch:{ JSONException -> 0x01d6 }
                r0.<init>(r2)     // Catch:{ JSONException -> 0x01d6 }
                throw r0     // Catch:{ JSONException -> 0x01d6 }
            L_0x019f:
                java.lang.String r0 = com.ironsource.mediationsdk.utils.IronSourceAES.decode(r0, r5)     // Catch:{ JSONException -> 0x01d6 }
                boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x01d6 }
                if (r5 != 0) goto L_0x01b0
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d6 }
                r5.<init>(r0)     // Catch:{ JSONException -> 0x01d6 }
            L_0x01ae:
                r7 = r5
                goto L_0x01b6
            L_0x01b0:
                org.json.JSONException r0 = new org.json.JSONException     // Catch:{ JSONException -> 0x01d6 }
                r0.<init>(r3)     // Catch:{ JSONException -> 0x01d6 }
                throw r0     // Catch:{ JSONException -> 0x01d6 }
            L_0x01b6:
                com.ironsource.mediationsdk.C0215e.a()     // Catch:{ JSONException -> 0x01d6 }
                com.ironsource.mediationsdk.e$a r0 = com.ironsource.mediationsdk.C0215e.a((org.json.JSONObject) r7)     // Catch:{ JSONException -> 0x01d6 }
                r1.a = r0     // Catch:{ JSONException -> 0x01d6 }
                int r0 = r0.f     // Catch:{ JSONException -> 0x01d6 }
                r1.b = r0     // Catch:{ JSONException -> 0x01d6 }
                com.ironsource.mediationsdk.e$a r0 = r1.a     // Catch:{ JSONException -> 0x01d6 }
                java.lang.String r0 = r0.g     // Catch:{ JSONException -> 0x01d6 }
                r1.c = r0     // Catch:{ JSONException -> 0x01d6 }
                r11.disconnect()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r2 = 1
                return r2
            L_0x01ce:
                org.json.JSONException r0 = new org.json.JSONException     // Catch:{ JSONException -> 0x01d6 }
                java.lang.String r5 = "empty response"
                r0.<init>(r5)     // Catch:{ JSONException -> 0x01d6 }
                throw r0     // Catch:{ JSONException -> 0x01d6 }
            L_0x01d6:
                r0 = move-exception
                java.lang.String r5 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                if (r5 == 0) goto L_0x01f0
                java.lang.String r5 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                boolean r5 = r5.equalsIgnoreCase(r3)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                if (r5 == 0) goto L_0x01f0
                r5 = 1003(0x3eb, float:1.406E-42)
                r1.b = r5     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r5 = "Auction decryption error"
            L_0x01ed:
                r1.c = r5     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                goto L_0x020e
            L_0x01f0:
                java.lang.String r5 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                if (r5 == 0) goto L_0x0207
                java.lang.String r5 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                if (r5 == 0) goto L_0x0207
                r5 = 1008(0x3f0, float:1.413E-42)
                r1.b = r5     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r5 = "Auction decompression error"
                goto L_0x01ed
            L_0x0207:
                r5 = 1002(0x3ea, float:1.404E-42)
                r1.b = r5     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r5 = "Auction parsing error"
                goto L_0x01ed
            L_0x020e:
                java.lang.String r5 = "parsing"
                r1.e = r5     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r7 = "Auction handle response exception "
                r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r6.append(r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                java.lang.String r0 = r6.toString()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r5.error(r0)     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r11.disconnect()     // Catch:{ SocketTimeoutException -> 0x0231, all -> 0x022e }
                r2 = 0
                return r2
            L_0x022e:
                r0 = move-exception
                r8 = r11
                goto L_0x0235
            L_0x0231:
                r0 = move-exception
                r8 = r11
                goto L_0x025c
            L_0x0234:
                r0 = move-exception
            L_0x0235:
                com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r5 = "getting exception "
                r3.<init>(r5)
                r3.append(r0)
                java.lang.String r3 = r3.toString()
                r2.error(r3)
                if (r8 == 0) goto L_0x024d
                r8.disconnect()
            L_0x024d:
                r2 = 1000(0x3e8, float:1.401E-42)
                r1.b = r2
                java.lang.String r0 = r0.getMessage()
                r1.c = r0
                r1.e = r4
                r2 = 0
                return r2
            L_0x025b:
                r0 = move-exception
            L_0x025c:
                if (r8 == 0) goto L_0x0261
                r8.disconnect()
            L_0x0261:
                r5 = 1006(0x3ee, float:1.41E-42)
                r1.b = r5
                java.lang.String r5 = "Connection timed out"
                r1.c = r5
                com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Auction socket timeout exception "
                r6.<init>(r7)
                java.lang.String r0 = r0.getMessage()
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                r5.error(r0)
            L_0x0280:
                int r0 = r1.d
                r5 = 1
                int r0 = r0 + r5
                r1.d = r0
                r5 = 0
                r6 = 1015(0x3f7, float:1.422E-42)
                r7 = 1
                goto L_0x0025
            L_0x028c:
                r5 = 1
                int r9 = r9 - r5
                r1.d = r9
                java.lang.String r0 = "trials_fail"
                r1.e = r0
                r2 = 0
                return r2
            L_0x0297:
                r0 = move-exception
                r2 = 0
                r3 = 1007(0x3ef, float:1.411E-42)
                r1.b = r3
                java.lang.String r3 = r0.getMessage()
                r1.c = r3
                r1.d = r2
                r1.e = r4
                com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "Auction request exception "
                r4.<init>(r5)
                java.lang.String r0 = r0.getMessage()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3.error(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0216f.a.a():boolean");
        }

        private String b() {
            return this.j == 2 ? e.a().c() : e.a().b();
        }

        /* access modifiers changed from: protected */
        public void a(boolean z, C0214d dVar, long j2) {
            if (z) {
                dVar.a(this.a.b, this.a.a, this.a.c, this.a.d, this.a.e, this.d + 1, j2, this.g, this.f);
                return;
            }
            dVar.a(this.b, this.c, this.d + 1, this.e, j2);
        }

        public void run() {
            boolean a2 = a();
            C0214d dVar = (C0214d) this.h.get();
            if (dVar != null) {
                a(a2, dVar, new Date().getTime() - this.i);
            }
        }
    }

    @Deprecated
    public C0216f(IronSource.AD_UNIT ad_unit, c cVar, C0214d dVar) {
        this.f = ad_unit;
        this.h = cVar;
        this.i = dVar;
        this.g = IronSourceUtils.getSessionId();
    }

    public C0216f(C0217g gVar) {
        this.a = gVar;
    }

    private JSONObject a(Context context, Map<String, Object> map, List<String> list, C0218h hVar, int i2, boolean z, IronSourceSegment ironSourceSegment) {
        boolean z2 = z;
        IronSourceSegment ironSourceSegment2 = ironSourceSegment;
        new JSONObject();
        if (z.a().f.c.f().c().d) {
            C0221k kVar = new C0221k(this.f);
            kVar.a(map);
            kVar.a(list);
            kVar.a(hVar);
            kVar.a(i2);
            kVar.a(this.j);
            kVar.a(ironSourceSegment2);
            kVar.b(z2);
            return C0215e.a().a(kVar);
        }
        Map<String, Object> map2 = map;
        List<String> list2 = list;
        C0218h hVar2 = hVar;
        int i3 = i2;
        JSONObject a2 = C0215e.a().a(context, map, list, hVar, i2, this.g, this.h, this.j, ironSourceSegment2 != null ? ironSourceSegment.toJson() : null, false, false);
        a2.put("adUnit", this.f.toString());
        a2.put("doNotEncryptResponse", z2 ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return a2;
    }

    public static void a(com.ironsource.mediationsdk.adunit.a.a aVar, int i2, com.ironsource.mediationsdk.adunit.a.a aVar2) {
        for (String a2 : aVar.i()) {
            String a3 = C0215e.a().a(a2, i2, aVar, "", "", "");
            C0215e.a();
            C0215e.a("reportLoadSuccess", aVar.a(), a3);
        }
        if (aVar2 != null) {
            for (String a4 : aVar2.i()) {
                String a5 = C0215e.a().a(a4, i2, aVar, "", "102", "");
                C0215e.a();
                C0215e.a("reportLoadSuccess", "GenericNotifications", a5);
            }
        }
    }

    public static void a(com.ironsource.mediationsdk.adunit.a.a aVar, int i2, com.ironsource.mediationsdk.adunit.a.a aVar2, String str) {
        for (String a2 : aVar.g()) {
            String a3 = C0215e.a().a(a2, i2, aVar, "", "", str);
            C0215e.a();
            C0215e.a("reportImpression", aVar.a(), a3);
        }
        if (aVar2 != null) {
            for (String a4 : aVar2.g()) {
                String a5 = C0215e.a().a(a4, i2, aVar, "", "102", str);
                C0215e.a();
                C0215e.a("reportImpression", "GenericNotifications", a5);
            }
        }
    }

    public static void a(ArrayList<String> arrayList, ConcurrentHashMap<String, com.ironsource.mediationsdk.adunit.a.a> concurrentHashMap, int i2, com.ironsource.mediationsdk.adunit.a.a aVar, com.ironsource.mediationsdk.adunit.a.a aVar2) {
        int f2 = aVar2.f();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!next.equals(aVar2.a())) {
                com.ironsource.mediationsdk.adunit.a.a aVar3 = concurrentHashMap.get(next);
                int f3 = aVar3.f();
                String d2 = aVar3.d();
                String str = f3 < f2 ? "1" : "102";
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("instance=" + aVar3.a() + ", instancePriceOrder= " + f3 + ", loseReasonCode=" + str + ", winnerInstance=" + aVar2.a() + ", winnerInstancePriceOrder=" + f2);
                for (String a2 : aVar3.h()) {
                    String a3 = C0215e.a().a(a2, i2, aVar2, d2, str, "");
                    C0215e.a();
                    C0215e.a("reportAuctionLose", aVar3.a(), a3);
                }
            } else {
                ConcurrentHashMap<String, com.ironsource.mediationsdk.adunit.a.a> concurrentHashMap2 = concurrentHashMap;
            }
        }
        if (aVar != null) {
            for (String a4 : aVar.h()) {
                String a5 = C0215e.a().a(a4, i2, aVar2, "", "102", "");
                C0215e.a();
                C0215e.a("reportAuctionLose", "GenericNotifications", a5);
            }
        }
    }

    public final void a(Context context, C0221k kVar, C0214d dVar) {
        try {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.a.a(context, kVar, dVar));
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("execute auction exception " + e2.getMessage());
            if (dVar != null) {
                dVar.a(1000, e2.getMessage(), 0, "other", 0);
            }
        }
    }

    @Deprecated
    public final void a(Context context, Map<String, Object> map, List<String> list, C0218h hVar, int i2, IronSourceSegment ironSourceSegment) {
        try {
            boolean isEncryptedResponse = IronSourceUtils.isEncryptedResponse();
            JSONObject a2 = a(context, map, list, hVar, i2, isEncryptedResponse, ironSourceSegment);
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(this.i, new URL(this.h.a(false)), a2, isEncryptedResponse, this.h.c, this.h.f, this.h.l, this.h.m, this.h.n));
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("execute auction exception " + e2.getMessage());
            this.i.a(1000, e2.getMessage(), 0, "other", 0);
        }
    }

    @Deprecated
    public final void a(Context context, Map<String, Object> map, List<String> list, C0218h hVar, int i2, IronSourceSegment ironSourceSegment, ISBannerSize iSBannerSize) {
        this.j = iSBannerSize;
        a(context, map, list, hVar, i2, ironSourceSegment);
    }

    public final void a(CopyOnWriteArrayList<O> copyOnWriteArrayList, ConcurrentHashMap<String, com.ironsource.mediationsdk.adunit.a.a> concurrentHashMap, int i2, com.ironsource.mediationsdk.adunit.a.a aVar, com.ironsource.mediationsdk.adunit.a.a aVar2) {
        ArrayList arrayList = new ArrayList();
        Iterator<O> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().n());
        }
        a((ArrayList<String>) arrayList, concurrentHashMap, i2, aVar, aVar2);
    }
}
