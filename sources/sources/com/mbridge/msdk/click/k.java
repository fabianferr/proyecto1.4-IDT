package com.mbridge.msdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.click.entity.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* compiled from: SocketSpider */
public final class k {
    private static volatile AtomicInteger a = new AtomicInteger(1);
    private e b;
    private String c;
    private int d = 9377;

    public k() {
        e b2 = f.a().b(b.d().h());
        this.b = b2;
        if (b2 == null) {
            this.b = f.a().b();
        }
    }

    public final a a(String str, CampaignEx campaignEx, boolean z, boolean z2) {
        a aVar = new a();
        aVar.g = str;
        if (TextUtils.isEmpty(str)) {
            aVar.h = "request url can not null.";
            return aVar;
        }
        String replace = str.replace(" ", "%20");
        JSONObject b2 = b(replace, campaignEx, z, z2);
        if (b2.length() == 0) {
            aVar.h = "request content generation failed.";
            return aVar;
        } else if (TextUtils.isEmpty(b2.optString(ShareConstants.MEDIA_URI))) {
            aVar.h = "request url parse error.";
            return aVar;
        } else {
            if (campaignEx != null) {
                int trackingTcpPort = campaignEx.getTrackingTcpPort();
                if (trackingTcpPort == 0) {
                    trackingTcpPort = 9377;
                }
                this.d = trackingTcpPort;
            }
            if (!TextUtils.isEmpty(this.c)) {
                return a(replace, b2.toString());
            }
            aVar.h = "request url parse error.";
            return aVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d9 A[SYNTHETIC, Splitter:B:94:0x01d9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.click.entity.a a(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.String r2 = " length : "
            java.lang.String r3 = "SocketSpider"
            java.lang.String r4 = "Socket Response : header : "
            java.lang.String r5 = "Socket Request : header : "
            java.lang.String r6 = "Socket exception: "
            com.mbridge.msdk.click.entity.a r7 = new com.mbridge.msdk.click.entity.a
            r7.<init>()
            java.net.Socket r9 = new java.net.Socket     // Catch:{ all -> 0x01bb }
            java.lang.String r10 = r1.c     // Catch:{ all -> 0x01bb }
            int r11 = r1.d     // Catch:{ all -> 0x01bb }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x01bb }
            r10 = 15000(0x3a98, float:2.102E-41)
            r9.setSoTimeout(r10)     // Catch:{ all -> 0x01b8 }
            java.io.OutputStream r10 = r9.getOutputStream()     // Catch:{ all -> 0x01b8 }
            r11 = 8
            byte[] r12 = new byte[r11]     // Catch:{ all -> 0x01b5 }
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r12)     // Catch:{ all -> 0x01b5 }
            java.nio.ByteOrder r13 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x01b5 }
            r12.order(r13)     // Catch:{ all -> 0x01b5 }
            r13 = 2
            r12.put(r13)     // Catch:{ all -> 0x01b5 }
            r14 = 3
            r12.put(r14)     // Catch:{ all -> 0x01b5 }
            java.util.concurrent.atomic.AtomicInteger r15 = a     // Catch:{ all -> 0x01b5 }
            int r15 = r15.getAndIncrement()     // Catch:{ all -> 0x01b5 }
            short r15 = (short) r15     // Catch:{ all -> 0x01b5 }
            r12.putShort(r15)     // Catch:{ all -> 0x01b5 }
            boolean r15 = android.text.TextUtils.isEmpty(r18)     // Catch:{ all -> 0x01b5 }
            r8 = 0
            if (r15 == 0) goto L_0x0057
            r12.putInt(r8)     // Catch:{ all -> 0x01b5 }
            byte[] r15 = r12.array()     // Catch:{ all -> 0x01b5 }
            r10.write(r15)     // Catch:{ all -> 0x01b5 }
            r14 = 0
            goto L_0x0085
        L_0x0057:
            boolean r15 = android.text.TextUtils.isEmpty(r18)     // Catch:{ all -> 0x01b5 }
            if (r15 == 0) goto L_0x005f
            r13 = 0
            goto L_0x0077
        L_0x005f:
            java.io.ByteArrayOutputStream r15 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x01b5 }
            r15.<init>()     // Catch:{ all -> 0x01b5 }
            java.util.zip.GZIPOutputStream r13 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x01b5 }
            r13.<init>(r15)     // Catch:{ all -> 0x01b5 }
            byte[] r14 = r18.getBytes()     // Catch:{ all -> 0x01b5 }
            r13.write(r14)     // Catch:{ all -> 0x01b5 }
            r13.close()     // Catch:{ all -> 0x01b5 }
            byte[] r13 = r15.toByteArray()     // Catch:{ all -> 0x01b5 }
        L_0x0077:
            int r14 = r13.length     // Catch:{ all -> 0x01b5 }
            r12.putInt(r14)     // Catch:{ all -> 0x01b5 }
            byte[] r15 = r12.array()     // Catch:{ all -> 0x01b5 }
            r10.write(r15)     // Catch:{ all -> 0x01b5 }
            r10.write(r13)     // Catch:{ all -> 0x01b5 }
        L_0x0085:
            r10.flush()     // Catch:{ all -> 0x01b5 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r13.<init>(r5)     // Catch:{ all -> 0x01b5 }
            byte[] r5 = r12.array()     // Catch:{ all -> 0x01b5 }
            java.lang.String r5 = java.util.Arrays.toString(r5)     // Catch:{ all -> 0x01b5 }
            r13.append(r5)     // Catch:{ all -> 0x01b5 }
            r13.append(r2)     // Catch:{ all -> 0x01b5 }
            r13.append(r14)     // Catch:{ all -> 0x01b5 }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x01b5 }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x01b5 }
            java.io.InputStream r5 = r9.getInputStream()     // Catch:{ all -> 0x01b5 }
            byte[] r12 = new byte[r11]     // Catch:{ all -> 0x01b5 }
            r5.read(r12, r8, r11)     // Catch:{ all -> 0x01b5 }
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.wrap(r12)     // Catch:{ all -> 0x01b5 }
            java.nio.ByteOrder r14 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x01b5 }
            r13.order(r14)     // Catch:{ all -> 0x01b5 }
            r14 = 4
            int r13 = r13.getInt(r14)     // Catch:{ all -> 0x01b5 }
            r14 = 1
            byte r15 = r12[r14]     // Catch:{ all -> 0x01b5 }
            r14 = 3
            if (r15 != r14) goto L_0x00c4
            r14 = 1
            goto L_0x00c5
        L_0x00c4:
            r14 = 0
        L_0x00c5:
            r11 = 2
            if (r15 != r11) goto L_0x00ca
            r11 = 1
            goto L_0x00cb
        L_0x00ca:
            r11 = 0
        L_0x00cb:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b5 }
            r15.<init>(r4)     // Catch:{ all -> 0x01b5 }
            java.lang.String r4 = java.util.Arrays.toString(r12)     // Catch:{ all -> 0x01b5 }
            r15.append(r4)     // Catch:{ all -> 0x01b5 }
            r15.append(r2)     // Catch:{ all -> 0x01b5 }
            r15.append(r13)     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = " isGzip : "
            r15.append(r2)     // Catch:{ all -> 0x01b5 }
            r15.append(r14)     // Catch:{ all -> 0x01b5 }
            java.lang.String r2 = r15.toString()     // Catch:{ all -> 0x01b5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r2)     // Catch:{ all -> 0x01b5 }
            byte[] r2 = new byte[r13]     // Catch:{ all -> 0x01b5 }
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ all -> 0x01b5 }
            java.io.InputStream r12 = r9.getInputStream()     // Catch:{ all -> 0x01b5 }
            r4.<init>(r12)     // Catch:{ all -> 0x01b5 }
            r4.readFully(r2)     // Catch:{ all -> 0x01b5 }
            if (r14 != 0) goto L_0x010f
            r4 = 2
            if (r13 <= r4) goto L_0x010f
            byte r4 = r2[r8]     // Catch:{ all -> 0x01b5 }
            r12 = 8
            int r4 = r4 << r12
            r12 = 1
            byte r15 = r2[r12]     // Catch:{ all -> 0x01b5 }
            r12 = r15 & 255(0xff, float:3.57E-43)
            r4 = r4 | r12
            r12 = 8075(0x1f8b, float:1.1315E-41)
            if (r4 != r12) goto L_0x010f
            r14 = 1
        L_0x010f:
            r4 = 200(0xc8, float:2.8E-43)
            if (r11 == 0) goto L_0x012d
            if (r13 != 0) goto L_0x012d
            r7.f = r4     // Catch:{ all -> 0x01b5 }
            r7.g = r0     // Catch:{ all -> 0x01b5 }
            r7.e = r8     // Catch:{ all -> 0x01b5 }
            r9.close()     // Catch:{ Exception -> 0x0124 }
            if (r10 == 0) goto L_0x012c
            r10.close()     // Catch:{ Exception -> 0x0124 }
            goto L_0x012c
        L_0x0124:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
        L_0x012c:
            return r7
        L_0x012d:
            r11 = 1
            if (r13 >= r11) goto L_0x0148
            r7.f = r4     // Catch:{ all -> 0x01b5 }
            r7.g = r0     // Catch:{ all -> 0x01b5 }
            r7.e = r8     // Catch:{ all -> 0x01b5 }
            r9.close()     // Catch:{ Exception -> 0x013f }
            if (r10 == 0) goto L_0x0147
            r10.close()     // Catch:{ Exception -> 0x013f }
            goto L_0x0147
        L_0x013f:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
        L_0x0147:
            return r7
        L_0x0148:
            if (r14 == 0) goto L_0x014f
            java.lang.String r2 = r1.a(r2)     // Catch:{ all -> 0x019b }
            goto L_0x0155
        L_0x014f:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x019b }
            r11.<init>(r2)     // Catch:{ all -> 0x019b }
            r2 = r11
        L_0x0155:
            boolean r11 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x019b }
            if (r11 != 0) goto L_0x01a9
            r7.f = r4     // Catch:{ all -> 0x019b }
            r7.g = r0     // Catch:{ all -> 0x019b }
            r7.e = r8     // Catch:{ all -> 0x019b }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0181 }
            r0.<init>(r2)     // Catch:{ all -> 0x0181 }
            java.lang.String r2 = "data"
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch:{ all -> 0x0181 }
            if (r0 == 0) goto L_0x0189
            java.lang.String r2 = "location"
            java.lang.String r0 = r0.optString(r2)     // Catch:{ all -> 0x0181 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0181 }
            if (r2 != 0) goto L_0x0189
            r2 = 302(0x12e, float:4.23E-43)
            r7.f = r2     // Catch:{ all -> 0x0181 }
            r7.a = r0     // Catch:{ all -> 0x0181 }
            goto L_0x0189
        L_0x0181:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x019b }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ all -> 0x019b }
        L_0x0189:
            r9.close()     // Catch:{ Exception -> 0x0192 }
            if (r10 == 0) goto L_0x019a
            r10.close()     // Catch:{ Exception -> 0x0192 }
            goto L_0x019a
        L_0x0192:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
        L_0x019a:
            return r7
        L_0x019b:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x01b5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r2)     // Catch:{ all -> 0x01b5 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01b5 }
            r7.h = r0     // Catch:{ all -> 0x01b5 }
        L_0x01a9:
            r5.close()     // Catch:{ all -> 0x01b5 }
            r9.close()     // Catch:{ Exception -> 0x01e2 }
            if (r10 == 0) goto L_0x01ea
            r10.close()     // Catch:{ Exception -> 0x01e2 }
            goto L_0x01ea
        L_0x01b5:
            r0 = move-exception
            r8 = r9
            goto L_0x01be
        L_0x01b8:
            r0 = move-exception
            r8 = r9
            goto L_0x01bd
        L_0x01bb:
            r0 = move-exception
            r8 = 0
        L_0x01bd:
            r10 = 0
        L_0x01be:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01eb }
            r2.<init>(r6)     // Catch:{ all -> 0x01eb }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x01eb }
            r2.append(r4)     // Catch:{ all -> 0x01eb }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01eb }
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x01eb }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01eb }
            r7.h = r0     // Catch:{ all -> 0x01eb }
            if (r8 == 0) goto L_0x01ea
            r8.close()     // Catch:{ Exception -> 0x01e2 }
            if (r10 == 0) goto L_0x01ea
            r10.close()     // Catch:{ Exception -> 0x01e2 }
            goto L_0x01ea
        L_0x01e2:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
        L_0x01ea:
            return r7
        L_0x01eb:
            r0 = move-exception
            r2 = r0
            if (r8 == 0) goto L_0x0200
            r8.close()     // Catch:{ Exception -> 0x01f8 }
            if (r10 == 0) goto L_0x0200
            r10.close()     // Catch:{ Exception -> 0x01f8 }
            goto L_0x0200
        L_0x01f8:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
        L_0x0200:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.k.a(java.lang.String, java.lang.String):com.mbridge.msdk.click.entity.a");
    }

    private JSONObject b(String str, CampaignEx campaignEx, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                String encodedQuery = parse.getEncodedQuery();
                this.c = host;
                jSONObject.put(ShareConstants.MEDIA_URI, "https://" + host + path);
                jSONObject.put("data", encodedQuery);
            }
        } catch (Throwable th) {
            aa.d("SocketSpider", th.getMessage());
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!z && !z2) {
                jSONObject2.put("User-Agent", w.l());
            }
            if (campaignEx != null) {
                if (z && campaignEx.getcUA() == 1) {
                    jSONObject2.put("User-Agent", w.l());
                }
                if (z2 && campaignEx.getImpUA() == 1) {
                    jSONObject2.put("User-Agent", w.l());
                }
            } else {
                jSONObject2.put("User-Agent", w.l());
            }
            jSONObject2.put("Accept-Encoding", "gzip");
            if (this.b.V() && !TextUtils.isEmpty(str)) {
                jSONObject2.put("referer", str);
            }
            jSONObject.put("header", jSONObject2);
        } catch (Throwable th2) {
            aa.d("SocketSpider", th2.getMessage());
        }
        return jSONObject;
    }

    private String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read > 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }
}
