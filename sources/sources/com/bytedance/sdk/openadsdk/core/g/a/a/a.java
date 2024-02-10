package com.bytedance.sdk.openadsdk.core.g.a.a;

/* compiled from: CompanionAdsParser */
public class a {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0273, code lost:
        r9 = r2;
        r10 = r12;
        r11 = r13;
        r12 = r19;
        r15 = r20;
        r13 = 3;
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017d, code lost:
        r13 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017f, code lost:
        r12 = r2;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x022f, code lost:
        r2 = r15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bytedance.sdk.openadsdk.core.g.c a(android.content.Context r25, org.xmlpull.v1.XmlPullParser r26) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r0 = r25
            r1 = r26
            r2 = 0
            if (r0 != 0) goto L_0x000b
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r26)
            return r2
        L_0x000b:
            android.content.res.Resources r3 = r25.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            int r4 = r3.widthPixels
            int r5 = r3.heightPixels
            float r4 = (float) r4
            float r6 = r3.density
            float r4 = r4 / r6
            int r4 = (int) r4
            float r5 = (float) r5
            float r3 = r3.density
            float r5 = r5 / r3
            int r3 = (int) r5
            r5 = 1
            r12 = r2
        L_0x0023:
            int r6 = r26.getEventType()
            r13 = 3
            if (r6 != r13) goto L_0x0038
            java.lang.String r6 = r26.getName()
            java.lang.String r7 = "CompanionAds"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            return r12
        L_0x0038:
            r26.next()
            int r6 = r26.getEventType()
            r14 = 2
            if (r6 == r14) goto L_0x0044
            goto L_0x0285
        L_0x0044:
            java.lang.String r6 = r26.getName()
            java.lang.String r15 = "Companion"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x0285
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r7 = "width"
            java.lang.String r6 = r1.getAttributeValue(r6, r7)
            int r11 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b(r6)
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r7 = "height"
            java.lang.String r6 = r1.getAttributeValue(r6, r7)
            int r10 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b(r6)
            r6 = 300(0x12c, float:4.2E-43)
            if (r11 < r6) goto L_0x027f
            r6 = 250(0xfa, float:3.5E-43)
            if (r10 >= r6) goto L_0x0072
            goto L_0x027f
        L_0x0072:
            com.bytedance.sdk.openadsdk.core.g.a.a.e$a r9 = new com.bytedance.sdk.openadsdk.core.g.a.a.e$a
            r9.<init>()
        L_0x0077:
            int r6 = r26.getEventType()
            if (r6 != r13) goto L_0x00bf
            java.lang.String r6 = r26.getName()
            boolean r6 = r6.equals(r15)
            if (r6 != 0) goto L_0x0088
            goto L_0x00bf
        L_0x0088:
            java.lang.String r6 = r9.a
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0023
            float r6 = r9.g
            int r6 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x0023
            com.bytedance.sdk.openadsdk.core.g.c r5 = new com.bytedance.sdk.openadsdk.core.g.c
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = r9.b
            com.bytedance.sdk.openadsdk.core.g.c.a$b r7 = r9.c
            java.lang.String r8 = r9.a
            java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c> r12 = r9.e
            java.util.List<com.bytedance.sdk.openadsdk.core.g.b.c> r13 = r9.f
            java.lang.String r14 = r9.d
            r16 = r5
            r17 = r11
            r18 = r10
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r12
            r23 = r13
            r24 = r14
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            float r6 = r9.g
            r12 = r5
            r5 = r6
            goto L_0x0023
        L_0x00bf:
            r26.next()
            int r6 = r26.getEventType()
            if (r6 == r14) goto L_0x00c9
            goto L_0x0077
        L_0x00c9:
            java.lang.String r6 = r26.getName()
            r6.hashCode()
            int r7 = r6.hashCode()
            java.lang.String r8 = "CompanionClickTracking"
            java.lang.String r2 = "TrackingEvents"
            java.lang.String r14 = "CompanionClickThrough"
            java.lang.String r13 = "HTMLResource"
            r19 = r12
            java.lang.String r12 = "StaticResource"
            r20 = r15
            java.lang.String r15 = "IFrameResource"
            r21 = -1
            switch(r7) {
                case -375340334: goto L_0x011f;
                case -348198615: goto L_0x0114;
                case 611554000: goto L_0x010a;
                case 676623548: goto L_0x0100;
                case 1877773523: goto L_0x00f5;
                case 1928285401: goto L_0x00ea;
                default: goto L_0x00e9;
            }
        L_0x00e9:
            goto L_0x0129
        L_0x00ea:
            boolean r6 = r6.equals(r13)
            if (r6 != 0) goto L_0x00f1
            goto L_0x0129
        L_0x00f1:
            r6 = 5
            r21 = 5
            goto L_0x0129
        L_0x00f5:
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x00fc
            goto L_0x0129
        L_0x00fc:
            r6 = 4
            r21 = 4
            goto L_0x0129
        L_0x0100:
            boolean r6 = r6.equals(r12)
            if (r6 != 0) goto L_0x0107
            goto L_0x0129
        L_0x0107:
            r21 = 3
            goto L_0x0129
        L_0x010a:
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0111
            goto L_0x0129
        L_0x0111:
            r21 = 2
            goto L_0x0129
        L_0x0114:
            boolean r6 = r6.equals(r14)
            if (r6 != 0) goto L_0x011b
            goto L_0x0129
        L_0x011b:
            r6 = 1
            r21 = 1
            goto L_0x0129
        L_0x011f:
            boolean r6 = r6.equals(r15)
            if (r6 != 0) goto L_0x0126
            goto L_0x0129
        L_0x0126:
            r6 = 0
            r21 = 0
        L_0x0129:
            switch(r21) {
                case 0: goto L_0x0234;
                case 1: goto L_0x0225;
                case 2: goto L_0x01f5;
                case 3: goto L_0x0185;
                case 4: goto L_0x0173;
                case 5: goto L_0x0134;
                default: goto L_0x012c;
            }
        L_0x012c:
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r26)
            r2 = r9
            r12 = r10
            r13 = r11
            goto L_0x0230
        L_0x0134:
            com.bytedance.sdk.openadsdk.core.g.c.a$b r2 = com.bytedance.sdk.openadsdk.core.g.c.a.b.HTML_RESOURCE
            android.graphics.Point r2 = com.bytedance.sdk.openadsdk.core.g.c.a.a(r0, r11, r10, r2)
            int r8 = r2.x
            int r2 = r2.y
            com.bytedance.sdk.openadsdk.core.g.c.a$b r12 = com.bytedance.sdk.openadsdk.core.g.c.a.b.HTML_RESOURCE
            com.bytedance.sdk.openadsdk.core.g.c.a$a r14 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            r6 = r4
            r7 = r3
            r15 = r9
            r9 = r2
            r2 = r10
            r10 = r12
            r12 = r11
            r11 = r14
            float r6 = com.bytedance.sdk.openadsdk.core.g.c.a(r6, r7, r8, r9, r10, r11)
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r13)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x016d
            float r8 = r15.g
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x016d
            int r8 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0163
            goto L_0x016d
        L_0x0163:
            r15.g = r6
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            com.bytedance.sdk.openadsdk.core.g.c.a$b r8 = com.bytedance.sdk.openadsdk.core.g.c.a.b.HTML_RESOURCE
            r15.a(r7, r6, r8)
            goto L_0x017d
        L_0x016d:
            r6 = 3
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a(r1, r13, r6)
            r13 = r12
            goto L_0x017f
        L_0x0173:
            r15 = r9
            r2 = r10
            r12 = r11
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r8)
            r15.a(r6)
        L_0x017d:
            r13 = r12
            r6 = 3
        L_0x017f:
            r17 = 2
            r12 = r2
            r2 = r15
            goto L_0x0273
        L_0x0185:
            r15 = r9
            r2 = r10
            r13 = r11
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.a.a.e.g
            java.lang.String r7 = "creativeType"
            java.lang.String r6 = r1.getAttributeValue(r6, r7)
            java.lang.String r14 = r6.toLowerCase()
            java.util.Set<java.lang.String> r6 = com.bytedance.sdk.openadsdk.core.g.c.a.a
            boolean r6 = r6.contains(r14)
            if (r6 == 0) goto L_0x01a1
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.IMAGE
            goto L_0x01a3
        L_0x01a1:
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.JAVASCRIPT
        L_0x01a3:
            r10 = r6
            com.bytedance.sdk.openadsdk.core.g.c.a$b r6 = com.bytedance.sdk.openadsdk.core.g.c.a.b.STATIC_RESOURCE
            android.graphics.Point r6 = com.bytedance.sdk.openadsdk.core.g.c.a.a(r0, r13, r2, r6)
            int r8 = r6.x
            int r9 = r6.y
            com.bytedance.sdk.openadsdk.core.g.c.a$b r11 = com.bytedance.sdk.openadsdk.core.g.c.a.b.STATIC_RESOURCE
            r6 = r4
            r7 = r3
            r21 = r10
            r10 = r11
            r11 = r21
            float r6 = com.bytedance.sdk.openadsdk.core.g.c.a(r6, r7, r8, r9, r10, r11)
            java.util.Set<java.lang.String> r7 = com.bytedance.sdk.openadsdk.core.g.c.a.a
            boolean r7 = r7.contains(r14)
            if (r7 != 0) goto L_0x01ce
            java.util.Set<java.lang.String> r7 = com.bytedance.sdk.openadsdk.core.g.c.a.b
            boolean r7 = r7.contains(r14)
            if (r7 == 0) goto L_0x01cc
            goto L_0x01ce
        L_0x01cc:
            r7 = 0
            goto L_0x01d2
        L_0x01ce:
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r12)
        L_0x01d2:
            float r8 = r15.g
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x01ee
            int r8 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x01ee
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x01e3
            goto L_0x01ee
        L_0x01e3:
            r15.g = r6
            com.bytedance.sdk.openadsdk.core.g.c.a$b r6 = com.bytedance.sdk.openadsdk.core.g.c.a.b.STATIC_RESOURCE
            r8 = r21
            r15.a(r7, r8, r6)
            r12 = r2
            goto L_0x022f
        L_0x01ee:
            r6 = 3
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a(r1, r12, r6)
            r12 = r2
            r2 = r15
            goto L_0x0231
        L_0x01f5:
            r15 = r9
            r12 = r10
            r13 = r11
        L_0x01f8:
            r6 = 3
            int r7 = r26.next()
            if (r7 != r6) goto L_0x0209
            java.lang.String r6 = r26.getName()
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x022f
        L_0x0209:
            int r6 = r26.getEventType()
            r11 = 2
            if (r6 == r11) goto L_0x0211
            goto L_0x01f8
        L_0x0211:
            java.lang.String r6 = r26.getName()
            java.lang.String r7 = "Tracking"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x01f8
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r7)
            r15.b(r6)
            goto L_0x01f8
        L_0x0225:
            r15 = r9
            r12 = r10
            r13 = r11
            r11 = 2
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r14)
            r15.d = r2
        L_0x022f:
            r2 = r15
        L_0x0230:
            r6 = 3
        L_0x0231:
            r17 = 2
            goto L_0x0273
        L_0x0234:
            r2 = r9
            r12 = r10
            r13 = r11
            r11 = 2
            com.bytedance.sdk.openadsdk.core.g.c.a$b r6 = com.bytedance.sdk.openadsdk.core.g.c.a.b.HTML_RESOURCE
            android.graphics.Point r6 = com.bytedance.sdk.openadsdk.core.g.c.a.a(r0, r13, r12, r6)
            int r8 = r6.x
            int r9 = r6.y
            com.bytedance.sdk.openadsdk.core.g.c.a$b r10 = com.bytedance.sdk.openadsdk.core.g.c.a.b.IFRAME_RESOURCE
            com.bytedance.sdk.openadsdk.core.g.c.a$a r14 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            r6 = r4
            r7 = r3
            r17 = 2
            r11 = r14
            float r6 = com.bytedance.sdk.openadsdk.core.g.c.a(r6, r7, r8, r9, r10, r11)
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r15)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x026f
            float r8 = r2.g
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x026f
            int r8 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0264
            goto L_0x026f
        L_0x0264:
            r2.g = r6
            com.bytedance.sdk.openadsdk.core.g.c.a$a r6 = com.bytedance.sdk.openadsdk.core.g.c.a.C0066a.NONE
            com.bytedance.sdk.openadsdk.core.g.c.a$b r8 = com.bytedance.sdk.openadsdk.core.g.c.a.b.IFRAME_RESOURCE
            r2.a(r7, r6, r8)
            r6 = 3
            goto L_0x0273
        L_0x026f:
            r6 = 3
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a(r1, r15, r6)
        L_0x0273:
            r9 = r2
            r10 = r12
            r11 = r13
            r12 = r19
            r15 = r20
            r2 = 0
            r13 = 3
            r14 = 2
            goto L_0x0077
        L_0x027f:
            r19 = r12
            com.bytedance.sdk.openadsdk.core.g.a.a.e.a((org.xmlpull.v1.XmlPullParser) r26)
            goto L_0x0287
        L_0x0285:
            r19 = r12
        L_0x0287:
            r12 = r19
            r2 = 0
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.g.a.a.a.a(android.content.Context, org.xmlpull.v1.XmlPullParser):com.bytedance.sdk.openadsdk.core.g.c");
    }
}
