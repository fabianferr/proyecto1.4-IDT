package com.startapp.sdk.ads.video.vast;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.startapp.p9;
import com.startapp.sdk.ads.video.vast.VASTResource;
import com.startapp.sdk.omsdk.VerificationDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: Sta */
public class c {
    public static final List<String> i = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});
    public final int a;
    public final float b;
    public a c;
    public VASTErrorCodes d;
    public int e;
    public int f = 10;
    public final Set<a> g = new HashSet();
    public final String h;

    /* compiled from: Sta */
    public interface a {
    }

    /* compiled from: Sta */
    public interface b {
    }

    public c(DisplayMetrics displayMetrics, String str) {
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        f2 = f2 <= 0.0f ? 1.0f : f2;
        float f3 = (float) i2;
        this.b = f3 / ((float) i3);
        this.a = (int) (f3 / f2);
        this.h = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.startapp.p9} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.util.List, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v23, types: [java.util.List, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r4v42 */
    /* JADX WARNING: type inference failed for: r4v43 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x005a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.startapp.m9 a(java.lang.String r21, java.util.List<java.lang.String> r22, com.startapp.sdk.ads.video.vast.c.b r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            if (r3 == 0) goto L_0x0014
            r4 = r3
            com.startapp.sdk.ads.video.vast.b r4 = (com.startapp.sdk.ads.video.vast.b) r4
            if (r1 == 0) goto L_0x0014
            org.json.JSONArray r4 = r4.c
            r4.put(r1)
        L_0x0014:
            r4 = 0
            com.startapp.p9 r5 = new com.startapp.p9     // Catch:{ Exception -> 0x0341 }
            r5.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x0341 }
            boolean r1 = r5.b
            java.lang.String r6 = "Error"
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r5.f(r6)
            goto L_0x0026
        L_0x0025:
            r1 = r4
        L_0x0026:
            if (r1 == 0) goto L_0x0035
            boolean r1 = r5.b
            if (r1 == 0) goto L_0x0031
            java.lang.String r1 = r5.f(r6)
            goto L_0x0032
        L_0x0031:
            r1 = r4
        L_0x0032:
            r2.add(r1)
        L_0x0035:
            java.lang.String r1 = "Ad"
            java.util.List r1 = r5.a(r1, r4, r4)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            boolean r5 = r1.isEmpty()
            if (r5 == 0) goto L_0x0056
            int r5 = r22.size()
            if (r5 <= 0) goto L_0x0056
            int r1 = r0.e
            if (r1 <= 0) goto L_0x0050
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r1 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.WrapperNoReponse
            goto L_0x0052
        L_0x0050:
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r1 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.FileNotFound
        L_0x0052:
            r0.a((java.util.List<java.lang.String>) r2, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r1)
            return r4
        L_0x0056:
            java.util.Iterator r1 = r1.iterator()
        L_0x005a:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x033f
            java.lang.Object r5 = r1.next()
            com.startapp.p9 r5 = (com.startapp.p9) r5
            java.lang.String r7 = "sequence"
            java.lang.String r7 = r5.a(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            r9 = 2
            if (r8 == 0) goto L_0x0074
            goto L_0x007e
        L_0x0074:
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x007d }
            if (r7 >= r9) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            r7 = 0
            goto L_0x007f
        L_0x007d:
        L_0x007e:
            r7 = 1
        L_0x007f:
            if (r7 != 0) goto L_0x0082
            goto L_0x005a
        L_0x0082:
            java.lang.String r7 = "InLine"
            com.startapp.p9 r7 = r5.b(r7, r4, r4)
            java.lang.String r8 = "Impression"
            if (r7 == 0) goto L_0x0241
            java.util.List r12 = r7.c()
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x0096:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x022d
            java.lang.Object r13 = r12.next()
            com.startapp.p9 r13 = (com.startapp.p9) r13
            java.lang.String r14 = "MediaFile"
            java.lang.String r15 = "MediaFiles"
            java.util.List r14 = r13.a(r14, r15, r4, r4)
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.util.Iterator r14 = r14.iterator()
            r15 = -8388608(0xffffffffff800000, float:-Infinity)
            r10 = r4
        L_0x00b3:
            boolean r16 = r14.hasNext()
            java.lang.String r11 = "height"
            java.lang.String r4 = "width"
            if (r16 == 0) goto L_0x01cd
            java.lang.Object r16 = r14.next()
            r9 = r16
            com.startapp.p9 r9 = (com.startapp.p9) r9
            r16 = r1
            java.lang.String r1 = "type"
            java.lang.String r1 = r9.a(r1)
            java.lang.String r18 = r9.d()
            r19 = r12
            java.util.List<java.lang.String> r12 = i
            boolean r12 = r12.contains(r1)
            if (r12 == 0) goto L_0x01be
            if (r18 != 0) goto L_0x00e1
            goto L_0x01be
        L_0x00e1:
            java.lang.Integer r4 = r9.b(r4)
            java.lang.Integer r11 = r9.b(r11)
            java.lang.String r12 = "bitrate"
            java.lang.Integer r12 = r9.b(r12)
            if (r12 == 0) goto L_0x00f4
            r17 = 2
            goto L_0x011c
        L_0x00f4:
            java.lang.String r12 = "minBitrate"
            java.lang.Integer r12 = r9.b(r12)
            java.lang.String r3 = "maxBitrate"
            java.lang.Integer r3 = r9.b(r3)
            if (r12 == 0) goto L_0x0116
            if (r3 == 0) goto L_0x0116
            int r12 = r12.intValue()
            int r3 = r3.intValue()
            int r3 = r3 + r12
            r17 = 2
            int r3 = r3 / 2
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            goto L_0x011c
        L_0x0116:
            r17 = 2
            if (r12 == 0) goto L_0x011b
            goto L_0x011c
        L_0x011b:
            r12 = r3
        L_0x011c:
            if (r4 == 0) goto L_0x01c3
            int r3 = r4.intValue()
            if (r3 <= 0) goto L_0x01c3
            if (r11 == 0) goto L_0x01c3
            int r3 = r11.intValue()
            if (r3 > 0) goto L_0x012e
            goto L_0x01c3
        L_0x012e:
            int r3 = r4.intValue()
            int r4 = r11.intValue()
            float r11 = (float) r3
            float r4 = (float) r4
            float r11 = r11 / r4
            float r4 = r0.b
            float r4 = r4 - r11
            float r4 = java.lang.Math.abs(r4)
            int r11 = r0.a
            int r3 = r11 - r3
            int r3 = r3 / r11
            int r3 = java.lang.Math.abs(r3)
            float r3 = (float) r3
            float r4 = r4 + r3
            if (r12 == 0) goto L_0x0159
            int r3 = r12.intValue()
            if (r3 >= 0) goto L_0x0154
            goto L_0x0159
        L_0x0154:
            int r3 = r12.intValue()
            goto L_0x015a
        L_0x0159:
            r3 = 0
        L_0x015a:
            r11 = 700(0x2bc, float:9.81E-43)
            if (r11 > r3) goto L_0x0164
            r11 = 1500(0x5dc, float:2.102E-42)
            if (r3 > r11) goto L_0x0164
            r3 = 0
            goto L_0x017d
        L_0x0164:
            int r11 = 700 - r3
            int r11 = java.lang.Math.abs(r11)
            float r11 = (float) r11
            r12 = 1143930880(0x442f0000, float:700.0)
            float r11 = r11 / r12
            int r3 = 1500 - r3
            int r3 = java.lang.Math.abs(r3)
            float r3 = (float) r3
            r12 = 1153138688(0x44bb8000, float:1500.0)
            float r3 = r3 / r12
            float r3 = java.lang.Math.min(r11, r3)
        L_0x017d:
            if (r1 != 0) goto L_0x0181
            java.lang.String r1 = ""
        L_0x0181:
            int r11 = r1.hashCode()
            r12 = -1664118616(0xffffffff9ccf90a8, float:-1.3735504E-21)
            if (r11 == r12) goto L_0x019b
            r12 = 1331848029(0x4f62635d, float:3.79816269E9)
            if (r11 == r12) goto L_0x0190
            goto L_0x01a6
        L_0x0190:
            java.lang.String r11 = "video/mp4"
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x01a6
            r1 = 0
            goto L_0x01a7
        L_0x019b:
            java.lang.String r11 = "video/3gpp"
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x01a6
            r1 = 1
            goto L_0x01a7
        L_0x01a6:
            r1 = -1
        L_0x01a7:
            r11 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x01ae
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01b0
        L_0x01ae:
            r1 = 1069547520(0x3fc00000, float:1.5)
        L_0x01b0:
            float r4 = r4 + r11
            float r4 = r4 + r3
            float r11 = r11 / r4
            float r1 = r1 * r11
            int r3 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x01c3
            r3 = r23
            r15 = r1
            r10 = r9
            goto L_0x01c5
        L_0x01be:
            r17 = 2
            r14.remove()
        L_0x01c3:
            r3 = r23
        L_0x01c5:
            r1 = r16
            r12 = r19
            r4 = 0
            r9 = 2
            goto L_0x00b3
        L_0x01cd:
            r16 = r1
            r19 = r12
            r17 = 2
            if (r10 == 0) goto L_0x0223
            java.lang.String r1 = r10.d()
            if (r1 != 0) goto L_0x01dc
            goto L_0x0223
        L_0x01dc:
            com.startapp.m9 r1 = new com.startapp.m9
            r1.<init>()
            java.util.List r3 = r7.c(r8)
            java.util.List<java.lang.String> r9 = r1.b
            r9.addAll(r3)
            r0.a((com.startapp.p9) r13, (com.startapp.m9) r1)
            java.lang.String r3 = "ClickThrough"
            java.lang.String r9 = "VideoClicks"
            java.lang.String r3 = r13.a(r3, r9)
            r1.s = r3
            java.lang.String r3 = r10.d()
            r1.p = r3
            java.lang.Integer r3 = r10.b(r4)
            r1.q = r3
            java.lang.Integer r3 = r10.b(r11)
            r1.r = r3
            java.util.Set<com.startapp.sdk.ads.video.vast.a> r3 = r0.g
            java.util.List r4 = r7.a()
            java.util.Set r4 = r0.a((java.util.List<com.startapp.p9>) r4)
            r3.addAll(r4)
            java.util.List r3 = r7.c(r6)
            r2.addAll(r3)
            java.util.List<java.lang.String> r3 = r1.a
            r3.addAll(r2)
            goto L_0x0235
        L_0x0223:
            r3 = r23
            r1 = r16
            r12 = r19
            r4 = 0
            r9 = 2
            goto L_0x0096
        L_0x022d:
            r16 = r1
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r1 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.FileNotFound
            r0.a((java.util.List<java.lang.String>) r2, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r1)
            r1 = 0
        L_0x0235:
            if (r1 == 0) goto L_0x0243
            java.util.List r2 = a((com.startapp.p9) r7)
            java.util.List<com.startapp.sdk.omsdk.VerificationDetails> r3 = r1.t
            r3.addAll(r2)
            return r1
        L_0x0241:
            r16 = r1
        L_0x0243:
            java.lang.String r1 = "Wrapper"
            r3 = 0
            com.startapp.p9 r1 = r5.b(r1, r3, r3)
            if (r1 == 0) goto L_0x0338
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            java.util.List r4 = r1.c(r6)
            r3.addAll(r4)
            java.lang.String r4 = "VASTAdTagURI"
            java.lang.String r4 = r1.f(r4)
            if (r4 != 0) goto L_0x0262
        L_0x0260:
            r4 = 0
            goto L_0x027f
        L_0x0262:
            java.lang.String r4 = r0.a((java.lang.String) r4)     // Catch:{ SocketTimeoutException -> 0x0273, Exception -> 0x0267 }
            goto L_0x027f
        L_0x0267:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0260
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r4 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.WrapperNoReponse
            r0.a((java.util.List<java.lang.String>) r3, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r4)
            goto L_0x0260
        L_0x0273:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0260
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r4 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.WrapperTimeout
            r0.a((java.util.List<java.lang.String>) r3, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r4)
            goto L_0x0260
        L_0x027f:
            if (r4 != 0) goto L_0x0283
            goto L_0x0338
        L_0x0283:
            r5 = r23
            com.startapp.m9 r3 = r0.a(r4, r3, r5)
            if (r3 != 0) goto L_0x028e
            r3 = r5
            goto L_0x033a
        L_0x028e:
            java.util.List r2 = r1.c(r8)
            java.util.List<java.lang.String> r4 = r3.b
            r4.addAll(r2)
            java.util.List r2 = r1.c()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x02a1:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x02b1
            java.lang.Object r4 = r2.next()
            com.startapp.p9 r4 = (com.startapp.p9) r4
            r0.a((com.startapp.p9) r4, (com.startapp.m9) r3)
            goto L_0x02a1
        L_0x02b1:
            java.util.Set<com.startapp.sdk.ads.video.vast.a> r2 = r0.g
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02c7
            java.util.Set<com.startapp.sdk.ads.video.vast.a> r2 = r0.g
            java.util.List r4 = r1.a()
            java.util.Set r4 = r0.a((java.util.List<com.startapp.p9>) r4)
            r2.addAll(r4)
            goto L_0x032e
        L_0x02c7:
            java.util.Set<com.startapp.sdk.ads.video.vast.a> r2 = r0.g
            java.util.Iterator r2 = r2.iterator()
        L_0x02cd:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x032e
            java.lang.Object r4 = r2.next()
            com.startapp.sdk.ads.video.vast.a r4 = (com.startapp.sdk.ads.video.vast.a) r4
            java.util.List r5 = r1.a()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x02e3:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x02cd
            java.lang.Object r6 = r5.next()
            com.startapp.p9 r6 = (com.startapp.p9) r6
            java.lang.String r7 = "StaticResource"
            java.lang.String r7 = r6.f(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0316
            java.lang.String r7 = "IFrameResource"
            java.lang.String r7 = r6.f(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0316
            java.lang.String r7 = "HTMLResource"
            java.lang.String r7 = r6.f(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0314
            goto L_0x0316
        L_0x0314:
            r7 = 0
            goto L_0x0317
        L_0x0316:
            r7 = 1
        L_0x0317:
            if (r7 != 0) goto L_0x02e3
            java.lang.String r7 = "CompanionClickTracking"
            java.util.List r7 = r6.c(r7)
            java.util.List<java.lang.String> r8 = r4.e
            r8.addAll(r7)
            java.util.List r6 = r6.b()
            java.util.List<java.lang.String> r7 = r4.f
            r7.addAll(r6)
            goto L_0x02e3
        L_0x032e:
            java.util.List r1 = a((com.startapp.p9) r1)
            java.util.List<com.startapp.sdk.omsdk.VerificationDetails> r2 = r3.t
            r2.addAll(r1)
            return r3
        L_0x0338:
            r3 = r23
        L_0x033a:
            r1 = r16
            r4 = 0
            goto L_0x005a
        L_0x033f:
            r1 = r4
            return r1
        L_0x0341:
            r1 = r4
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r3 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.XMLParsingError
            r0.a((java.util.List<java.lang.String>) r2, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.vast.c.a(java.lang.String, java.util.List, com.startapp.sdk.ads.video.vast.c$b):com.startapp.m9");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.e
            int r1 = r3.f
            r2 = 0
            if (r0 >= r1) goto L_0x0042
            int r0 = r0 + 1
            r3.e = r0
            java.lang.String r0 = r3.h     // Catch:{ all -> 0x0036 }
            java.net.HttpURLConnection r4 = com.startapp.i7.a(r4, r0)     // Catch:{ all -> 0x0036 }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0033 }
            java.io.InputStream r1 = r4.getInputStream()     // Catch:{ all -> 0x0033 }
            r0.<init>(r1)     // Catch:{ all -> 0x0033 }
            java.util.Scanner r1 = new java.util.Scanner     // Catch:{ all -> 0x0030 }
            r1.<init>(r0)     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "\\A"
            java.util.Scanner r1 = r1.useDelimiter(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r1.next()     // Catch:{ all -> 0x0030 }
            com.startapp.k9.a((java.io.Closeable) r0)
            r4.disconnect()
            return r1
        L_0x0030:
            r1 = move-exception
            r2 = r0
            goto L_0x0039
        L_0x0033:
            r0 = move-exception
            r1 = r0
            goto L_0x0039
        L_0x0036:
            r4 = move-exception
            r1 = r4
            r4 = r2
        L_0x0039:
            com.startapp.k9.a((java.io.Closeable) r2)
            if (r4 == 0) goto L_0x0041
            r4.disconnect()
        L_0x0041:
            throw r1
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.vast.c.a(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: com.startapp.n9} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: com.startapp.n9} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: com.startapp.n9} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: com.startapp.n9} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: com.startapp.n9} */
    /* JADX WARNING: type inference failed for: r3v25, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.startapp.p9 r24, com.startapp.m9 r25) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            r24.getClass()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "start"
            java.util.List r3 = r0.d(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0019:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x003d
            java.lang.Object r4 = r3.next()
            com.startapp.p9 r4 = (com.startapp.p9) r4
            java.lang.String r4 = r4.d()
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x0019
            com.startapp.q9 r6 = new com.startapp.q9
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.<init>(r4, r5)
            r2.add(r6)
            goto L_0x0019
        L_0x003d:
            java.lang.String r3 = "progress"
            java.util.List r4 = r0.d(r3)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0049:
            boolean r6 = r4.hasNext()
            java.lang.String r7 = "offset"
            if (r6 == 0) goto L_0x008b
            java.lang.Object r6 = r4.next()
            com.startapp.p9 r6 = (com.startapp.p9) r6
            java.lang.String r7 = r6.a(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x0062
            goto L_0x0049
        L_0x0062:
            java.lang.String r7 = r7.trim()
            boolean r8 = com.startapp.q9.a(r7)
            if (r8 == 0) goto L_0x0049
            java.lang.String r6 = r6.d()
            java.lang.Integer r7 = com.startapp.q9.b(r7)
            if (r7 == 0) goto L_0x0049
            int r8 = r7.intValue()
            if (r8 < 0) goto L_0x0049
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0049
            com.startapp.q9 r8 = new com.startapp.q9
            r8.<init>(r6, r7)
            r2.add(r8)
            goto L_0x0049
        L_0x008b:
            java.lang.String r4 = "creativeView"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0097:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00ba
            java.lang.Object r6 = r4.next()
            com.startapp.p9 r6 = (com.startapp.p9) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0097
            com.startapp.q9 r8 = new com.startapp.q9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x0097
        L_0x00ba:
            java.util.List<com.startapp.q9<java.lang.Integer>> r4 = r1.c
            r4.addAll(r2)
            java.util.List<com.startapp.q9<java.lang.Integer>> r2 = r1.c
            java.util.Collections.sort(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r4 = "firstQuartile"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00d5:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00fa
            java.lang.Object r6 = r4.next()
            com.startapp.p9 r6 = (com.startapp.p9) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x00d5
            com.startapp.q9 r8 = new com.startapp.q9
            r9 = 1048576000(0x3e800000, float:0.25)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x00d5
        L_0x00fa:
            java.lang.String r4 = "midpoint"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0106:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x012b
            java.lang.Object r6 = r4.next()
            com.startapp.p9 r6 = (com.startapp.p9) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0106
            com.startapp.q9 r8 = new com.startapp.q9
            r9 = 1056964608(0x3f000000, float:0.5)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x0106
        L_0x012b:
            java.lang.String r4 = "thirdQuartile"
            java.util.List r4 = r0.d(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0138:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x015d
            java.lang.Object r6 = r4.next()
            com.startapp.p9 r6 = (com.startapp.p9) r6
            java.lang.String r6 = r6.d()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x0138
            com.startapp.q9 r8 = new com.startapp.q9
            r9 = 1061158912(0x3f400000, float:0.75)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.<init>(r6, r9)
            r2.add(r8)
            goto L_0x0138
        L_0x015d:
            java.util.List r3 = r0.d(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0167:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01bb
            java.lang.Object r4 = r3.next()
            com.startapp.p9 r4 = (com.startapp.p9) r4
            java.lang.String r6 = r4.a(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 == 0) goto L_0x017e
            goto L_0x0167
        L_0x017e:
            java.lang.String r6 = r6.trim()
            java.util.regex.Pattern r8 = com.startapp.q9.d
            java.util.regex.Matcher r8 = r8.matcher(r6)
            boolean r8 = r8.matches()
            if (r8 == 0) goto L_0x0167
            java.lang.String r4 = r4.d()
            java.lang.String r8 = "%"
            java.lang.String r9 = ""
            java.lang.String r6 = r6.replace(r8, r9)     // Catch:{ NumberFormatException -> 0x01b9 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x01b9 }
            r8 = 1120403456(0x42c80000, float:100.0)
            float r6 = r6 / r8
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x0167
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ NumberFormatException -> 0x01b9 }
            if (r8 != 0) goto L_0x0167
            com.startapp.q9 r8 = new com.startapp.q9     // Catch:{ NumberFormatException -> 0x01b9 }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ NumberFormatException -> 0x01b9 }
            r8.<init>(r4, r6)     // Catch:{ NumberFormatException -> 0x01b9 }
            r2.add(r8)     // Catch:{ NumberFormatException -> 0x01b9 }
            goto L_0x0167
        L_0x01b9:
            goto L_0x0167
        L_0x01bb:
            java.util.List<com.startapp.q9<java.lang.Float>> r3 = r1.d
            r3.addAll(r2)
            java.util.List<com.startapp.q9<java.lang.Float>> r2 = r1.d
            java.util.Collections.sort(r2)
            java.lang.String r2 = "pause"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.e
            r3.addAll(r2)
            java.lang.String r2 = "resume"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.f
            r3.addAll(r2)
            java.lang.String r2 = "complete"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.g
            r3.addAll(r2)
            java.lang.String r2 = "close"
            java.util.List r2 = r0.e(r2)
            java.lang.String r3 = "closeLinear"
            java.util.List r3 = r0.e(r3)
            r4 = r2
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r4.addAll(r3)
            java.util.List<java.lang.String> r3 = r1.h
            r3.addAll(r2)
            java.lang.String r2 = "skip"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.k
            r3.addAll(r2)
            java.lang.String r2 = "ClickTracking"
            java.lang.String r3 = "VideoClicks"
            java.util.List r2 = r0.b(r2, r3)
            java.util.List<java.lang.String> r3 = r1.l
            r3.addAll(r2)
            java.lang.String r2 = "mute"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.i
            r3.addAll(r2)
            java.lang.String r2 = "unmute"
            java.util.List r2 = r0.e(r2)
            java.util.List<java.lang.String> r3 = r1.j
            r3.addAll(r2)
            java.lang.Integer r2 = r1.m
            r3 = 0
            if (r2 != 0) goto L_0x025d
            java.lang.String r2 = "skipoffset"
            java.lang.String r2 = r0.a(r2)
            if (r2 != 0) goto L_0x023c
            goto L_0x025a
        L_0x023c:
            java.lang.String r4 = r2.trim()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0247
            goto L_0x025a
        L_0x0247:
            boolean r4 = com.startapp.q9.a(r2)
            if (r4 == 0) goto L_0x025a
            java.lang.Integer r2 = com.startapp.q9.b(r2)
            if (r2 == 0) goto L_0x025a
            int r4 = r2.intValue()
            if (r4 < 0) goto L_0x025a
            goto L_0x025b
        L_0x025a:
            r2 = r3
        L_0x025b:
            r1.m = r2
        L_0x025d:
            com.startapp.n9 r2 = r1.n
            if (r2 != 0) goto L_0x032f
            java.lang.String r2 = "Icon"
            java.lang.String r4 = "Icons"
            java.util.List r0 = r0.a(r2, r4, r3, r3)
            com.startapp.sdk.ads.video.vast.VASTResource$Type[] r2 = com.startapp.sdk.ads.video.vast.VASTResource.Type.values()
            int r4 = r2.length
        L_0x026e:
            if (r5 >= r4) goto L_0x032d
            r6 = r2[r5]
            com.startapp.sdk.ads.video.vast.VASTResource$Type r8 = com.startapp.sdk.ads.video.vast.VASTResource.Type.IFRAME_RESOURCE
            if (r6 == r8) goto L_0x0329
            com.startapp.sdk.ads.video.vast.VASTResource$Type r8 = com.startapp.sdk.ads.video.vast.VASTResource.Type.HTML_RESOURCE
            if (r6 != r8) goto L_0x027c
            goto L_0x0329
        L_0x027c:
            r8 = r0
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x0283:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0329
            java.lang.Object r9 = r8.next()
            com.startapp.p9 r9 = (com.startapp.p9) r9
            java.lang.String r10 = "assetWidth"
            java.lang.Integer r10 = r9.b(r10)
            if (r10 == 0) goto L_0x0298
            goto L_0x029f
        L_0x0298:
            java.lang.String r10 = "width"
            java.lang.Integer r10 = r9.b(r10)
        L_0x029f:
            java.lang.String r11 = "assetHeight"
            java.lang.Integer r11 = r9.b(r11)
            if (r11 == 0) goto L_0x02a8
            goto L_0x02ae
        L_0x02a8:
            java.lang.String r11 = "height"
            java.lang.Integer r11 = r9.b(r11)
        L_0x02ae:
            if (r10 == 0) goto L_0x0283
            int r12 = r10.intValue()
            if (r12 <= 0) goto L_0x0283
            int r12 = r10.intValue()
            r13 = 300(0x12c, float:4.2E-43)
            if (r12 > r13) goto L_0x0283
            if (r11 == 0) goto L_0x0283
            int r12 = r11.intValue()
            if (r12 <= 0) goto L_0x0283
            int r12 = r11.intValue()
            if (r12 <= r13) goto L_0x02cd
            goto L_0x0283
        L_0x02cd:
            int r12 = r10.intValue()
            int r13 = r11.intValue()
            com.startapp.sdk.ads.video.vast.VASTResource r19 = com.startapp.sdk.ads.video.vast.VASTResource.a(r9, r6, r12, r13)
            if (r19 != 0) goto L_0x02dc
            goto L_0x0283
        L_0x02dc:
            com.startapp.n9 r0 = new com.startapp.n9
            int r15 = r10.intValue()
            int r16 = r11.intValue()
            java.lang.String r2 = r9.a(r7)
            if (r2 == 0) goto L_0x02f9
            boolean r4 = com.startapp.q9.a(r2)
            if (r4 == 0) goto L_0x02f9
            java.lang.Integer r2 = com.startapp.q9.b(r2)
            r17 = r2
            goto L_0x02fb
        L_0x02f9:
            r17 = r3
        L_0x02fb:
            java.lang.String r2 = "duration"
            java.lang.String r2 = r9.a(r2)
            if (r2 == 0) goto L_0x030d
            boolean r4 = com.startapp.q9.a(r2)
            if (r4 == 0) goto L_0x030d
            java.lang.Integer r3 = com.startapp.q9.b(r2)
        L_0x030d:
            r18 = r3
            java.lang.String r2 = "IconClickTracking"
            java.lang.String r3 = "IconClicks"
            java.util.List r20 = r9.b(r2, r3)
            java.lang.String r2 = "IconClickThrough"
            java.lang.String r21 = r9.a(r2, r3)
            java.lang.String r2 = "IconViewTracking"
            java.util.List r22 = r9.c(r2)
            r14 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            r3 = r0
            goto L_0x032d
        L_0x0329:
            int r5 = r5 + 1
            goto L_0x026e
        L_0x032d:
            r1.n = r3
        L_0x032f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.vast.c.a(com.startapp.p9, com.startapp.m9):void");
    }

    public final void a(List<String> list, VASTErrorCodes vASTErrorCodes) {
        this.d = vASTErrorCodes;
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        a aVar = this.c;
        if (aVar != null) {
            com.startapp.sdk.ads.video.b.a(com.startapp.sdk.ads.video.b.this, vASTErrorCodes, (List) arrayList);
        }
    }

    public final Set<a> a(List<p9> list) {
        HashSet hashSet = new HashSet();
        for (VASTResource.Type type : VASTResource.Type.values()) {
            for (p9 next : list) {
                Integer b2 = next.b("assetWidth");
                if (b2 == null) {
                    b2 = next.b(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                }
                Integer b3 = next.b("assetHeight");
                if (b3 == null) {
                    b3 = next.b(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                }
                if (b2 != null && b2.intValue() >= 300 && b3 != null && b3.intValue() >= 250) {
                    int intValue = b2.intValue();
                    int intValue2 = b3.intValue();
                    Point point = new Point(intValue, intValue2);
                    int i2 = this.a;
                    float f2 = (float) i2;
                    int i3 = (int) (f2 / this.b);
                    if (intValue > i2 || intValue2 > i3) {
                        if (type == VASTResource.Type.HTML_RESOURCE) {
                            point.x = Math.min(i2, intValue);
                            point.y = Math.min(i3, intValue2);
                        } else {
                            float f3 = (float) intValue;
                            float f4 = f3 / f2;
                            float f5 = (float) intValue2;
                            float f6 = f5 / ((float) i3);
                            if (f4 > f6) {
                                point.x = i2;
                                point.y = (int) (f5 / f4);
                            } else {
                                point.x = (int) (f3 / f6);
                                point.y = i3;
                            }
                        }
                    }
                    VASTResource a2 = VASTResource.a(next, type, point.x, point.y);
                    if (a2 != null) {
                        hashSet.add(new a(point.x, point.y, a2, next.f("CompanionClickThrough"), next.c("CompanionClickTracking"), next.b()));
                    }
                }
            }
        }
        return hashSet;
    }

    public static List<VerificationDetails> a(p9 p9Var) {
        String f2;
        String f3;
        String str;
        List<p9> a2 = p9Var.a("Verification", "AdVerifications", (String) null, (List<String>) null);
        Iterator it = ((ArrayList) p9Var.a("Extension", "Extensions", "type", Collections.singletonList("AdVerifications"))).iterator();
        while (it.hasNext()) {
            ((ArrayList) a2).addAll(((p9) it.next()).a("Verification", "AdVerifications", (String) null, (List<String>) null));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) a2).iterator();
        while (it2.hasNext()) {
            p9 p9Var2 = (p9) it2.next();
            String a3 = p9Var2.a("vendor");
            if (!(a3 == null || (f2 = p9Var2.f("JavaScriptResource")) == null || (f3 = p9Var2.f("VerificationParameters")) == null)) {
                p9 b2 = p9Var2.b("JavaScriptResource", "apiFramework", (List<String>) null);
                if (b2 == null) {
                    str = null;
                } else {
                    str = b2.a("apiFramework");
                }
                if (str != null && str.equalsIgnoreCase(CampaignEx.KEY_OMID)) {
                    arrayList.add(new VerificationDetails(a3, f2, f3));
                }
            }
        }
        return arrayList;
    }
}
