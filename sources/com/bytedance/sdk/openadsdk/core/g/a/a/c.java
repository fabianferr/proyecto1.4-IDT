package com.bytedance.sdk.openadsdk.core.g.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.g.c.d;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: LinearParser */
public class c {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r2.equals("Icons") == false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(org.xmlpull.v1.XmlPullParser r8, com.bytedance.sdk.openadsdk.core.g.a r9, int r10, double r11) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r8.next()
            r3 = 3
            if (r2 != r3) goto L_0x0017
            java.lang.String r2 = r8.getName()
            java.lang.String r4 = "Linear"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            return
        L_0x0017:
            int r2 = r8.getEventType()
            r4 = 2
            if (r2 == r4) goto L_0x001f
            goto L_0x0002
        L_0x001f:
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = r9.g()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x002e
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r8)
        L_0x002e:
            java.lang.String r2 = r8.getName()
            r2.hashCode()
            int r5 = r2.hashCode()
            r6 = 1
            r7 = -1
            switch(r5) {
                case -2049897434: goto L_0x006a;
                case -1927368268: goto L_0x005f;
                case -385055469: goto L_0x0054;
                case 70476538: goto L_0x004b;
                case 611554000: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            r3 = -1
            goto L_0x0074
        L_0x0040:
            java.lang.String r3 = "TrackingEvents"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0049
            goto L_0x003e
        L_0x0049:
            r3 = 4
            goto L_0x0074
        L_0x004b:
            java.lang.String r4 = "Icons"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0074
            goto L_0x003e
        L_0x0054:
            java.lang.String r3 = "MediaFiles"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x005d
            goto L_0x003e
        L_0x005d:
            r3 = 2
            goto L_0x0074
        L_0x005f:
            java.lang.String r3 = "Duration"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0068
            goto L_0x003e
        L_0x0068:
            r3 = 1
            goto L_0x0074
        L_0x006a:
            java.lang.String r3 = "VideoClicks"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0073
            goto L_0x003e
        L_0x0073:
            r3 = 0
        L_0x0074:
            switch(r3) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x009b;
                case 2: goto L_0x0095;
                case 3: goto L_0x0084;
                case 4: goto L_0x007b;
                default: goto L_0x0077;
            }
        L_0x0077:
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r8)
            goto L_0x0002
        L_0x007b:
            com.bytedance.sdk.openadsdk.core.g.d r2 = r9.a()
            a((org.xmlpull.v1.XmlPullParser) r8, (com.bytedance.sdk.openadsdk.core.g.d) r2)
            goto L_0x0002
        L_0x0084:
            com.bytedance.sdk.openadsdk.core.g.b r2 = a(r8)
            if (r2 == 0) goto L_0x0002
            com.bytedance.sdk.openadsdk.core.g.b r3 = r9.b()
            if (r3 != 0) goto L_0x0002
            r9.a((com.bytedance.sdk.openadsdk.core.g.b) r2)
            goto L_0x0002
        L_0x0095:
            a((org.xmlpull.v1.XmlPullParser) r8, (int) r10, (double) r11, (com.bytedance.sdk.openadsdk.core.g.a) r9)
            r1 = 1
            goto L_0x0002
        L_0x009b:
            double r2 = b(r8)
            r9.a((double) r2)
            goto L_0x0002
        L_0x00a4:
            a((org.xmlpull.v1.XmlPullParser) r8, (com.bytedance.sdk.openadsdk.core.g.a) r9)
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.a.a.c.a(org.xmlpull.v1.XmlPullParser, com.bytedance.sdk.openadsdk.core.g.a, int, double):void");
    }

    private static String a(XmlPullParser xmlPullParser, int i, double d, a aVar) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        a aVar2 = aVar;
        double d2 = Double.NEGATIVE_INFINITY;
        String str = null;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("MediaFiles")) {
                break;
            } else if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("MediaFile")) {
                String attributeValue = xmlPullParser2.getAttributeValue(e.g, "type");
                int b = e.b(xmlPullParser2.getAttributeValue(e.g, ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                int b2 = e.b(xmlPullParser2.getAttributeValue(e.g, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                int b3 = e.b(xmlPullParser2.getAttributeValue(e.g, "bitrate"));
                String b4 = e.b(xmlPullParser2, "MediaFile");
                if (b > 0 && b2 > 0 && d.a.contains(attributeValue) && !TextUtils.isEmpty(b4)) {
                    double a = d.a(i, d, b, b2, b3, attributeValue);
                    if (a > d2) {
                        str = b4;
                        i2 = b;
                        d2 = a;
                        i3 = b2;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            aVar2.d(str);
            aVar2.a(i2);
            aVar2.b(i3);
        }
        return str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013b, code lost:
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0144, code lost:
        if (r22.next() != 3) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014e, code lost:
        if (r22.getName().equals("IconClicks") != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0151, code lost:
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015b, code lost:
        if (r22.getEventType() == 2) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0168, code lost:
        if (r22.getName().equals("IconClickThrough") == false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016a, code lost:
        r20 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b(r0, "IconClickThrough");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0179, code lost:
        if (r22.getName().equals("IconClickTracking") == false) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x017b, code lost:
        r5.add(new com.bytedance.sdk.openadsdk.core.g.b.c.a(com.bytedance.sdk.openadsdk.core.g.a.a.e.b(r0, "IconClickTracking")).a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01df, code lost:
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f6, code lost:
        r13 = r2;
        r15 = r5;
        r2 = r18;
        r5 = 3;
        r6 = 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bytedance.sdk.openadsdk.core.g.b a(org.xmlpull.v1.XmlPullParser r22) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r22
            r2 = 0
        L_0x0003:
            int r3 = r22.getEventType()
            java.lang.String r4 = "Icons"
            r5 = 3
            if (r3 != r5) goto L_0x0018
            java.lang.String r3 = r22.getName()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            return r2
        L_0x0018:
            r22.next()
            int r3 = r22.getEventType()
            r6 = 2
            if (r3 == r6) goto L_0x0024
            goto L_0x0204
        L_0x0024:
            java.lang.String r3 = r22.getName()
            java.lang.String r7 = "Icon"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x0204
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r8 = "width"
            java.lang.String r3 = r0.getAttributeValue(r3, r8)
            int r9 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b(r3)
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r8 = "height"
            java.lang.String r3 = r0.getAttributeValue(r3, r8)
            int r10 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b(r3)
            if (r9 <= 0) goto L_0x01fe
            r3 = 300(0x12c, float:4.2E-43)
            if (r9 > r3) goto L_0x01fe
            if (r10 <= 0) goto L_0x01fe
            if (r10 <= r3) goto L_0x0054
            goto L_0x01fe
        L_0x0054:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r8 = "offset"
            java.lang.String r3 = r0.getAttributeValue(r3, r8)
            int r3 = com.bytedance.sdk.openadsdk.core.g.b.a.a((java.lang.String) r3)
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r11 = "duration"
            java.lang.String r8 = r0.getAttributeValue(r8, r11)
            int r8 = com.bytedance.sdk.openadsdk.core.g.b.a.a((java.lang.String) r8)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r11 = 0
            r20 = 0
        L_0x0079:
            int r12 = r22.next()
            if (r12 != r5) goto L_0x00bb
            java.lang.String r12 = r22.getName()
            boolean r12 = r12.equals(r7)
            if (r12 != 0) goto L_0x008a
            goto L_0x00bb
        L_0x008a:
            if (r11 == 0) goto L_0x0003
            if (r2 == 0) goto L_0x0098
            java.lang.String r6 = r2.f()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0003
        L_0x0098:
            com.bytedance.sdk.openadsdk.core.g.b r2 = new com.bytedance.sdk.openadsdk.core.g.b
            long r6 = (long) r3
            r16 = r6
            long r5 = (long) r8
            com.bytedance.sdk.openadsdk.core.g.c.a$a r3 = r11.b
            com.bytedance.sdk.openadsdk.core.g.c.a$b r7 = r11.c
            java.lang.String r14 = r11.a
            r8 = r2
            r11 = r16
            r19 = r13
            r17 = r14
            r13 = r5
            r5 = r15
            r15 = r3
            r16 = r7
            r18 = r5
            r8.<init>(r9, r10, r11, r13, r15, r16, r17, r18, r19, r20)
            r3 = 3
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a(r0, r4, r3)
            goto L_0x0003
        L_0x00bb:
            r19 = r13
            r5 = r15
            int r12 = r22.getEventType()
            if (r12 == r6) goto L_0x00c9
            r15 = r5
            r13 = r19
            r5 = 3
            goto L_0x0079
        L_0x00c9:
            java.lang.String r12 = r22.getName()
            r12.hashCode()
            int r13 = r12.hashCode()
            java.lang.String r14 = "HTMLResource"
            java.lang.String r15 = "IconClicks"
            java.lang.String r1 = "StaticResource"
            java.lang.String r6 = "IFrameResource"
            r18 = r2
            java.lang.String r2 = "IconViewTracking"
            r21 = -1
            switch(r13) {
                case -1044238411: goto L_0x0110;
                case -375340334: goto L_0x0105;
                case 676623548: goto L_0x00fb;
                case 1030746596: goto L_0x00f1;
                case 1928285401: goto L_0x00e6;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            goto L_0x011a
        L_0x00e6:
            boolean r12 = r12.equals(r14)
            if (r12 != 0) goto L_0x00ed
            goto L_0x011a
        L_0x00ed:
            r12 = 4
            r21 = 4
            goto L_0x011a
        L_0x00f1:
            boolean r12 = r12.equals(r15)
            if (r12 != 0) goto L_0x00f8
            goto L_0x011a
        L_0x00f8:
            r21 = 3
            goto L_0x011a
        L_0x00fb:
            boolean r12 = r12.equals(r1)
            if (r12 != 0) goto L_0x0102
            goto L_0x011a
        L_0x0102:
            r21 = 2
            goto L_0x011a
        L_0x0105:
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x010c
            goto L_0x011a
        L_0x010c:
            r12 = 1
            r21 = 1
            goto L_0x011a
        L_0x0110:
            boolean r12 = r12.equals(r2)
            if (r12 != 0) goto L_0x0117
            goto L_0x011a
        L_0x0117:
            r12 = 0
            r21 = 0
        L_0x011a:
            switch(r21) {
                case 0: goto L_0x01e2;
                case 1: goto L_0x01c9;
                case 2: goto L_0x018c;
                case 3: goto L_0x013f;
                case 4: goto L_0x0121;
                default: goto L_0x011d;
            }
        L_0x011d:
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r22)
            goto L_0x013b
        L_0x0121:
            if (r11 == 0) goto L_0x012d
            com.bytedance.sdk.openadsdk.core.g.c.a$b r1 = r11.c
            com.bytedance.sdk.openadsdk.core.g.c.a$b r2 = com.bytedance.sdk.openadsdk.core.g.c.a.b.IFRAME_RESOURCE
            if (r1 == r2) goto L_0x012d
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r22)
            goto L_0x013b
        L_0x012d:
            com.bytedance.sdk.openadsdk.core.g.a.a.e$a r1 = new com.bytedance.sdk.openadsdk.core.g.a.a.e$a
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r14)
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            com.bytedance.sdk.openadsdk.core.g.c.a$b r11 = com.bytedance.sdk.openadsdk.core.g.c.a.b.HTML_RESOURCE
            r1.<init>(r2, r6, r11)
            r11 = r1
        L_0x013b:
            r2 = r19
            r12 = 3
            goto L_0x0153
        L_0x013f:
            int r1 = r22.next()
            r12 = 3
            if (r1 != r12) goto L_0x0156
            java.lang.String r1 = r22.getName()
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0151
            goto L_0x0156
        L_0x0151:
            r2 = r19
        L_0x0153:
            r13 = 2
            goto L_0x01f6
        L_0x0156:
            int r1 = r22.getEventType()
            r13 = 2
            if (r1 == r13) goto L_0x015e
            goto L_0x013f
        L_0x015e:
            java.lang.String r1 = r22.getName()
            java.lang.String r2 = "IconClickThrough"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x016f
            java.lang.String r20 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r2)
            goto L_0x013f
        L_0x016f:
            java.lang.String r1 = r22.getName()
            java.lang.String r2 = "IconClickTracking"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x013f
            com.bytedance.sdk.openadsdk.core.g.b.c$a r1 = new com.bytedance.sdk.openadsdk.core.g.b.c$a
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r2)
            r1.<init>(r2)
            com.bytedance.sdk.openadsdk.core.g.b.c r1 = r1.a()
            r5.add(r1)
            goto L_0x013f
        L_0x018c:
            r12 = 3
            r13 = 2
            com.bytedance.sdk.openadsdk.core.g.c.a$a r2 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r6 = "creativeType"
            java.lang.String r2 = r0.getAttributeValue(r2, r6)
            java.lang.String r2 = r2.toLowerCase()
            java.util.Set<java.lang.String> r6 = com.bytedance.sdk.openadsdk.core.g.c.a.a
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L_0x01af
            java.util.Set<java.lang.String> r6 = com.bytedance.sdk.openadsdk.core.g.c.a.b
            boolean r6 = r6.contains(r2)
            if (r6 == 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            r1 = 0
            goto L_0x01b3
        L_0x01af:
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r1)
        L_0x01b3:
            java.util.Set<java.lang.String> r6 = com.bytedance.sdk.openadsdk.core.g.c.a.a
            boolean r2 = r6.contains(r2)
            if (r2 == 0) goto L_0x01be
            com.bytedance.sdk.openadsdk.core.g.c.a$a r2 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.IMAGE
            goto L_0x01c0
        L_0x01be:
            com.bytedance.sdk.openadsdk.core.g.c.a$a r2 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.JAVASCRIPT
        L_0x01c0:
            com.bytedance.sdk.openadsdk.core.g.a.a.e$a r6 = new com.bytedance.sdk.openadsdk.core.g.a.a.e$a
            com.bytedance.sdk.openadsdk.core.g.c.a$b r11 = com.bytedance.sdk.openadsdk.core.g.c.a.b.STATIC_RESOURCE
            r6.<init>(r1, r2, r11)
            r11 = r6
            goto L_0x01df
        L_0x01c9:
            r12 = 3
            r13 = 2
            if (r11 == 0) goto L_0x01d1
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r22)
            goto L_0x01df
        L_0x01d1:
            com.bytedance.sdk.openadsdk.core.g.a.a.e$a r1 = new com.bytedance.sdk.openadsdk.core.g.a.a.e$a
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r6)
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            com.bytedance.sdk.openadsdk.core.g.c.a$b r11 = com.bytedance.sdk.openadsdk.core.g.c.a.b.IFRAME_RESOURCE
            r1.<init>(r2, r6, r11)
            r11 = r1
        L_0x01df:
            r2 = r19
            goto L_0x01f6
        L_0x01e2:
            r12 = 3
            r13 = 2
            com.bytedance.sdk.openadsdk.core.g.b.c$a r1 = new com.bytedance.sdk.openadsdk.core.g.b.c$a
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r2)
            r1.<init>(r2)
            com.bytedance.sdk.openadsdk.core.g.b.c r1 = r1.a()
            r2 = r19
            r2.add(r1)
        L_0x01f6:
            r13 = r2
            r15 = r5
            r2 = r18
            r5 = 3
            r6 = 2
            goto L_0x0079
        L_0x01fe:
            r18 = r2
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r22)
            goto L_0x0206
        L_0x0204:
            r18 = r2
        L_0x0206:
            r2 = r18
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.a.a.c.a(org.xmlpull.v1.XmlPullParser):com.bytedance.sdk.openadsdk.core.g.b");
    }

    public static double b(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String[] split = e.b(xmlPullParser, "Duration").split(CertificateUtil.DELIMITER);
        if (split.length != 3) {
            return 0.0d;
        }
        try {
            return (double) (((float) ((Integer.parseInt(split[0].trim()) * 60 * 60) + (Integer.parseInt(split[1].trim()) * 60))) + Float.parseFloat(split[2].trim()));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00af, code lost:
        if (r0.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_UNMUTE) == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(org.xmlpull.v1.XmlPullParser r7, com.bytedance.sdk.openadsdk.core.g.d r8) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
        L_0x0000:
            int r0 = r7.next()
            r1 = 3
            if (r0 != r1) goto L_0x0015
            java.lang.String r0 = r7.getName()
            java.lang.String r2 = "TrackingEvents"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            return
        L_0x0015:
            int r0 = r7.getEventType()
            r2 = 2
            if (r0 == r2) goto L_0x001d
            goto L_0x0000
        L_0x001d:
            java.lang.String r0 = r7.getName()
            java.lang.String r3 = "Tracking"
            boolean r0 = r3.equals(r0)
            r4 = 4
            if (r0 == 0) goto L_0x0143
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r5 = "event"
            java.lang.String r0 = r7.getAttributeValue(r0, r5)
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L_0x003c
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a(r7, r3, r1)
            goto L_0x0000
        L_0x003c:
            r0.hashCode()
            int r5 = r0.hashCode()
            r6 = -1
            switch(r5) {
                case -1638835128: goto L_0x00c8;
                case -1337830390: goto L_0x00bd;
                case -934426579: goto L_0x00b2;
                case -840405966: goto L_0x00a9;
                case -599445191: goto L_0x009e;
                case 3363353: goto L_0x0093;
                case 3532159: goto L_0x0088;
                case 94756344: goto L_0x007d;
                case 106440182: goto L_0x0071;
                case 109757538: goto L_0x0064;
                case 560220243: goto L_0x0057;
                case 1778167540: goto L_0x004a;
                default: goto L_0x0047;
            }
        L_0x0047:
            r1 = -1
            goto L_0x00d3
        L_0x004a:
            java.lang.String r1 = "creativeView"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0053
            goto L_0x0047
        L_0x0053:
            r1 = 11
            goto L_0x00d3
        L_0x0057:
            java.lang.String r1 = "firstQuartile"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0060
            goto L_0x0047
        L_0x0060:
            r1 = 10
            goto L_0x00d3
        L_0x0064:
            java.lang.String r1 = "start"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006d
            goto L_0x0047
        L_0x006d:
            r1 = 9
            goto L_0x00d3
        L_0x0071:
            java.lang.String r1 = "pause"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007a
            goto L_0x0047
        L_0x007a:
            r1 = 8
            goto L_0x00d3
        L_0x007d:
            java.lang.String r1 = "close"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0086
            goto L_0x0047
        L_0x0086:
            r1 = 7
            goto L_0x00d3
        L_0x0088:
            java.lang.String r1 = "skip"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0091
            goto L_0x0047
        L_0x0091:
            r1 = 6
            goto L_0x00d3
        L_0x0093:
            java.lang.String r1 = "mute"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009c
            goto L_0x0047
        L_0x009c:
            r1 = 5
            goto L_0x00d3
        L_0x009e:
            java.lang.String r1 = "complete"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a7
            goto L_0x0047
        L_0x00a7:
            r1 = 4
            goto L_0x00d3
        L_0x00a9:
            java.lang.String r2 = "unmute"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00d3
            goto L_0x0047
        L_0x00b2:
            java.lang.String r1 = "resume"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00bb
            goto L_0x0047
        L_0x00bb:
            r1 = 2
            goto L_0x00d3
        L_0x00bd:
            java.lang.String r1 = "thirdQuartile"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c6
            goto L_0x0047
        L_0x00c6:
            r1 = 1
            goto L_0x00d3
        L_0x00c8:
            java.lang.String r1 = "midpoint"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d2
            goto L_0x0047
        L_0x00d2:
            r1 = 0
        L_0x00d3:
            switch(r1) {
                case 0: goto L_0x0138;
                case 1: goto L_0x012d;
                case 2: goto L_0x0124;
                case 3: goto L_0x011b;
                case 4: goto L_0x0112;
                case 5: goto L_0x0109;
                case 6: goto L_0x0100;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ee;
                case 9: goto L_0x00e3;
                case 10: goto L_0x00d8;
                case 11: goto L_0x00e3;
                default: goto L_0x00d6;
            }
        L_0x00d6:
            goto L_0x0000
        L_0x00d8:
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r7, (java.lang.String) r3)
            r1 = 1048576000(0x3e800000, float:0.25)
            r8.a((java.lang.String) r0, (float) r1)
            goto L_0x0000
        L_0x00e3:
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r7, (java.lang.String) r3)
            r1 = 0
            r8.a((java.lang.String) r0, (long) r1)
            goto L_0x0000
        L_0x00ee:
            java.util.List r0 = c(r7)
            r8.b((java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c>) r0)
            goto L_0x0000
        L_0x00f7:
            java.util.List r0 = c(r7)
            r8.e((java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c>) r0)
            goto L_0x0000
        L_0x0100:
            java.util.List r0 = c(r7)
            r8.f((java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c>) r0)
            goto L_0x0000
        L_0x0109:
            java.util.List r0 = c(r7)
            r8.k(r0)
            goto L_0x0000
        L_0x0112:
            java.util.List r0 = c(r7)
            r8.d((java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c>) r0)
            goto L_0x0000
        L_0x011b:
            java.util.List r0 = c(r7)
            r8.l(r0)
            goto L_0x0000
        L_0x0124:
            java.util.List r0 = c(r7)
            r8.c((java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c>) r0)
            goto L_0x0000
        L_0x012d:
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r7, (java.lang.String) r3)
            r1 = 1061158912(0x3f400000, float:0.75)
            r8.a((java.lang.String) r0, (float) r1)
            goto L_0x0000
        L_0x0138:
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r7, (java.lang.String) r3)
            r1 = 1056964608(0x3f000000, float:0.5)
            r8.a((java.lang.String) r0, (float) r1)
            goto L_0x0000
        L_0x0143:
            int r0 = r7.getEventType()
            if (r0 != r4) goto L_0x014e
            r7.nextTag()
            goto L_0x0000
        L_0x014e:
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r7)
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.a.a.c.a(org.xmlpull.v1.XmlPullParser, com.bytedance.sdk.openadsdk.core.g.d):void");
    }

    private static void a(XmlPullParser xmlPullParser, a aVar) throws IOException, XmlPullParserException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("VideoClicks")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ClickThrough")) {
                    aVar.c(e.b(xmlPullParser, "ClickThrough"));
                } else if (!name.equals("ClickTracking")) {
                    e.a(xmlPullParser);
                } else {
                    aVar.a().g(e.a(xmlPullParser, "ClickTracking"));
                }
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.g.b.c> c(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return e.a(xmlPullParser, "Tracking");
    }
}
