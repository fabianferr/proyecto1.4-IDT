package com.bytedance.sdk.openadsdk.core.g.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g.a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: InLineParser */
public class b {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ac, code lost:
        if (r11.getEventType() != 3) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b6, code lost:
        if ("Extensions".equals(r11.getName()) != false) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b8, code lost:
        r11.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bf, code lost:
        if (r11.getEventType() == 2) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ca, code lost:
        if ("AdVerifications".equals(r11.getName()) == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cc, code lost:
        r0.a(com.bytedance.sdk.openadsdk.core.g.a.a.d.a(r11));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bytedance.sdk.openadsdk.core.g.a a(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11, java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c> r12, int r13, double r14) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            r1 = 2
            java.lang.String r2 = "InLine"
            r11.require(r1, r0, r2)
            com.bytedance.sdk.openadsdk.core.g.a r0 = new com.bytedance.sdk.openadsdk.core.g.a
            r0.<init>()
        L_0x000d:
            int r3 = r11.next()
            r9 = 3
            if (r3 != r9) goto L_0x0027
            java.lang.String r3 = r11.getName()
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            com.bytedance.sdk.openadsdk.core.g.d r10 = r0.a()
            r10.j(r12)
            return r0
        L_0x0027:
            int r3 = r11.getEventType()
            if (r3 == r1) goto L_0x002e
            goto L_0x000d
        L_0x002e:
            java.lang.String r3 = r11.getName()
            r3.hashCode()
            int r4 = r3.hashCode()
            java.lang.String r5 = "Extensions"
            java.lang.String r6 = "AdVerifications"
            r7 = -1
            switch(r4) {
                case -2077435339: goto L_0x0082;
                case -1692490108: goto L_0x0077;
                case -56677412: goto L_0x006c;
                case 67232232: goto L_0x0061;
                case 184043572: goto L_0x0058;
                case 501930965: goto L_0x004d;
                case 2114088489: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x008a
        L_0x0042:
            java.lang.String r4 = "Impression"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x004b
            goto L_0x008a
        L_0x004b:
            r7 = 6
            goto L_0x008a
        L_0x004d:
            java.lang.String r4 = "AdTitle"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0056
            goto L_0x008a
        L_0x0056:
            r7 = 5
            goto L_0x008a
        L_0x0058:
            boolean r4 = r3.equals(r5)
            if (r4 != 0) goto L_0x005f
            goto L_0x008a
        L_0x005f:
            r7 = 4
            goto L_0x008a
        L_0x0061:
            java.lang.String r4 = "Error"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x006a
            goto L_0x008a
        L_0x006a:
            r7 = 3
            goto L_0x008a
        L_0x006c:
            java.lang.String r4 = "Description"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0075
            goto L_0x008a
        L_0x0075:
            r7 = 2
            goto L_0x008a
        L_0x0077:
            java.lang.String r4 = "Creatives"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0080
            goto L_0x008a
        L_0x0080:
            r7 = 1
            goto L_0x008a
        L_0x0082:
            boolean r4 = r3.equals(r6)
            if (r4 != 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r7 = 0
        L_0x008a:
            switch(r7) {
                case 0: goto L_0x0121;
                case 1: goto L_0x00e6;
                case 2: goto L_0x00dd;
                case 3: goto L_0x00d4;
                case 4: goto L_0x00a8;
                case 5: goto L_0x009f;
                case 6: goto L_0x0092;
                default: goto L_0x008d;
            }
        L_0x008d:
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11)
            goto L_0x000d
        L_0x0092:
            com.bytedance.sdk.openadsdk.core.g.d r4 = r0.a()
            java.util.List r3 = com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r4.a((java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c>) r3)
            goto L_0x000d
        L_0x009f:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r0.a((java.lang.String) r3)
            goto L_0x000d
        L_0x00a8:
            int r3 = r11.getEventType()
            if (r3 != r9) goto L_0x00b8
            java.lang.String r3 = r11.getName()
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x000d
        L_0x00b8:
            r11.next()
            int r3 = r11.getEventType()
            if (r3 == r1) goto L_0x00c2
            goto L_0x00a8
        L_0x00c2:
            java.lang.String r3 = r11.getName()
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x00a8
            java.util.Set r3 = com.bytedance.sdk.openadsdk.core.g.a.a.d.a(r11)
            r0.a((java.util.Set<com.bytedance.sdk.openadsdk.core.g.j>) r3)
            goto L_0x00a8
        L_0x00d4:
            java.util.List r3 = com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r12.addAll(r3)
            goto L_0x000d
        L_0x00dd:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r0.b((java.lang.String) r3)
            goto L_0x000d
        L_0x00e6:
            java.lang.String r3 = r0.g()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00fb
            com.bytedance.sdk.openadsdk.core.g.c r3 = r0.c()
            if (r3 == 0) goto L_0x00fb
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11)
            goto L_0x000d
        L_0x00fb:
            int r3 = r11.next()
            if (r3 == r9) goto L_0x000d
            int r3 = r11.getEventType()
            if (r3 == r1) goto L_0x0108
            goto L_0x00fb
        L_0x0108:
            java.lang.String r3 = r11.getName()
            java.lang.String r4 = "Creative"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x011d
            r3 = r10
            r4 = r11
            r5 = r0
            r6 = r13
            r7 = r14
            a((android.content.Context) r3, (org.xmlpull.v1.XmlPullParser) r4, (com.bytedance.sdk.openadsdk.core.g.a) r5, (int) r6, (double) r7)
            goto L_0x00fb
        L_0x011d:
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11)
            goto L_0x00fb
        L_0x0121:
            java.util.Set r3 = com.bytedance.sdk.openadsdk.core.g.a.a.d.a(r11)
            r0.a((java.util.Set<com.bytedance.sdk.openadsdk.core.g.j>) r3)
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.a.a.b.a(android.content.Context, org.xmlpull.v1.XmlPullParser, java.util.List, int, double):com.bytedance.sdk.openadsdk.core.g.a");
    }

    public static void a(Context context, XmlPullParser xmlPullParser, a aVar, int i, double d) throws IOException, XmlPullParserException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(aVar.g())) {
                    c.a(xmlPullParser, aVar, i, d);
                } else if (!"CompanionAds".equals(xmlPullParser.getName()) || aVar.c() != null) {
                    e.a(xmlPullParser);
                } else {
                    aVar.a(a.a(context, xmlPullParser));
                }
            }
        }
    }
}
