package com.mbridge.msdk.dycreator.e;

/* compiled from: AttributeUtil */
public final class a {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0144, code lost:
        if (r4.length <= 2) goto L_0x015e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01f9 A[Catch:{ Exception -> 0x06e5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01fe A[Catch:{ Exception -> 0x06e5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.view.View r20, android.util.AttributeSet r21) {
        /*
            r1 = r20
            r2 = r21
            java.lang.String r3 = "AttributeUtil"
            if (r1 == 0) goto L_0x06ed
            if (r2 != 0) goto L_0x000c
            goto L_0x06ed
        L_0x000c:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.util.HashMap r4 = r0.c()     // Catch:{ Exception -> 0x06e5 }
            if (r4 == 0) goto L_0x06e4
            boolean r0 = r4.isEmpty()     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x001e
            goto L_0x06e4
        L_0x001e:
            int r5 = r21.getAttributeCount()     // Catch:{ Exception -> 0x06e5 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0027:
            if (r7 >= r5) goto L_0x06ed
            java.lang.String r0 = r2.getAttributeName(r7)     // Catch:{ Exception -> 0x06e5 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x06e5 }
            r12 = r0
            com.mbridge.msdk.dycreator.a.c r12 = (com.mbridge.msdk.dycreator.a.c) r12     // Catch:{ Exception -> 0x06e5 }
            if (r12 != 0) goto L_0x003d
            r18 = r4
            r19 = r5
            r4 = 0
            goto L_0x06dc
        L_0x003d:
            int[] r0 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x06e5 }
            int r13 = r12.ordinal()     // Catch:{ Exception -> 0x06e5 }
            r0 = r0[r13]     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r13 = "drawable"
            java.lang.String r6 = "@drawable/"
            java.lang.String r15 = "@+id/"
            java.lang.String r16 = ""
            switch(r0) {
                case 1: goto L_0x01bb;
                case 2: goto L_0x0127;
                case 3: goto L_0x00f7;
                case 4: goto L_0x00c6;
                case 5: goto L_0x00b6;
                case 6: goto L_0x00a1;
                case 7: goto L_0x0091;
                case 8: goto L_0x0081;
                case 9: goto L_0x0071;
                case 10: goto L_0x0061;
                case 11: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x00b0
        L_0x0051:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r14 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            int r0 = r0.b(r14)     // Catch:{ Exception -> 0x06e5 }
            r1.setPadding(r8, r11, r0, r10)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b0
        L_0x0061:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r14 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            int r0 = r0.b(r14)     // Catch:{ Exception -> 0x06e5 }
            r1.setPadding(r0, r11, r9, r10)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b0
        L_0x0071:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r9 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            int r9 = r0.b(r9)     // Catch:{ Exception -> 0x06e5 }
            r1.setPadding(r8, r11, r9, r10)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b0
        L_0x0081:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r8 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            int r8 = r0.b(r8)     // Catch:{ Exception -> 0x06e5 }
            r1.setPadding(r8, r11, r9, r10)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b0
        L_0x0091:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r10 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            int r10 = r0.b(r10)     // Catch:{ Exception -> 0x06e5 }
            r1.setPadding(r8, r11, r9, r10)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b0
        L_0x00a1:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r11 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            int r11 = r0.b(r11)     // Catch:{ Exception -> 0x06e5 }
            r1.setPadding(r8, r11, r9, r10)     // Catch:{ Exception -> 0x06e5 }
        L_0x00b0:
            r18 = r4
        L_0x00b2:
            r19 = r5
            goto L_0x01f5
        L_0x00b6:
            com.mbridge.msdk.dycreator.a.b r0 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r14 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            int r0 = r0.b(r14)     // Catch:{ Exception -> 0x06e5 }
            r1.setPadding(r0, r0, r0, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b0
        L_0x00c6:
            java.lang.String r0 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            boolean r14 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ec }
            if (r14 != 0) goto L_0x00b0
            java.util.HashMap<java.lang.String, java.lang.String> r14 = com.mbridge.msdk.dycreator.e.b.a     // Catch:{ Exception -> 0x00ec }
            r18 = r4
            r4 = 8
            java.lang.String r0 = r0.substring(r4)     // Catch:{ Exception -> 0x00ea }
            java.lang.Object r0 = r14.get(r0)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00ea }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ea }
            if (r4 != 0) goto L_0x00b2
            r1.setContentDescription(r0)     // Catch:{ Exception -> 0x00ea }
            goto L_0x00b2
        L_0x00ea:
            r0 = move-exception
            goto L_0x00ef
        L_0x00ec:
            r0 = move-exception
            r18 = r4
        L_0x00ef:
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b2
        L_0x00f7:
            r18 = r4
            java.lang.String r0 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x011e }
            if (r4 != 0) goto L_0x00b2
            java.lang.String r4 = "invisible"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0110
            r4 = 4
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x00b2
        L_0x0110:
            java.lang.String r4 = "gone"
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x011e }
            if (r0 == 0) goto L_0x00b2
            r4 = 8
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x00b2
        L_0x011e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x00b2
        L_0x0127:
            r18 = r4
            java.lang.String r0 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r4 = "#"
            boolean r4 = r0.startsWith(r4)     // Catch:{ Exception -> 0x01b0 }
            if (r4 == 0) goto L_0x016b
            java.lang.String r4 = "-"
            java.lang.String[] r4 = r0.split(r4)     // Catch:{ Exception -> 0x013c }
            goto L_0x013e
        L_0x013c:
            r4 = 0
        L_0x013e:
            if (r4 == 0) goto L_0x0147
            int r14 = r4.length     // Catch:{ Exception -> 0x01b0 }
            r19 = r5
            r5 = 2
            if (r14 > r5) goto L_0x0149
            goto L_0x015e
        L_0x0147:
            r19 = r5
        L_0x0149:
            if (r4 == 0) goto L_0x01f5
            int r5 = r4.length     // Catch:{ Exception -> 0x01ae }
            r14 = 3
            if (r5 != r14) goto L_0x01f5
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x01ae }
            android.graphics.drawable.GradientDrawable r4 = r5.a((java.lang.String[]) r4)     // Catch:{ Exception -> 0x01ae }
            if (r4 == 0) goto L_0x015e
            r1.setBackground(r4)     // Catch:{ Exception -> 0x01ae }
            goto L_0x01f5
        L_0x015e:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x01ae }
            int r0 = r4.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01ae }
            r1.setBackgroundColor(r0)     // Catch:{ Exception -> 0x01ae }
            goto L_0x01f5
        L_0x016b:
            r19 = r5
            java.lang.String r4 = "@color/"
            boolean r4 = r0.startsWith(r4)     // Catch:{ Exception -> 0x01ae }
            if (r4 == 0) goto L_0x0182
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x01ae }
            int r0 = r4.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01ae }
            r1.setBackgroundColor(r0)     // Catch:{ Exception -> 0x01ae }
            goto L_0x01f5
        L_0x0182:
            boolean r4 = r0.startsWith(r6)     // Catch:{ Exception -> 0x01ae }
            if (r4 == 0) goto L_0x01f5
            r4 = 10
            java.lang.String r0 = r0.substring(r4)     // Catch:{ Exception -> 0x01ae }
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x01ae }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x01ae }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x01ae }
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x01ae }
            android.content.Context r5 = r5.g()     // Catch:{ Exception -> 0x01ae }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x01ae }
            int r0 = r4.getIdentifier(r0, r13, r5)     // Catch:{ Exception -> 0x01ae }
            r1.setBackgroundResource(r0)     // Catch:{ Exception -> 0x01ae }
            goto L_0x01f5
        L_0x01ae:
            r0 = move-exception
            goto L_0x01b3
        L_0x01b0:
            r0 = move-exception
            r19 = r5
        L_0x01b3:
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01f5
        L_0x01bb:
            r18 = r4
            r19 = r5
            java.lang.String r0 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06e5 }
            boolean r4 = r0.startsWith(r15)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x01cf
            r4 = 5
            java.lang.String r0 = r0.substring(r4)     // Catch:{ Exception -> 0x01ed }
            goto L_0x01df
        L_0x01cf:
            java.lang.String r4 = "@id/"
            boolean r4 = r0.startsWith(r4)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x01dd
            r4 = 4
            java.lang.String r0 = r0.substring(r4)     // Catch:{ Exception -> 0x01ed }
            goto L_0x01df
        L_0x01dd:
            r0 = r16
        L_0x01df:
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01ed }
            if (r4 != 0) goto L_0x01f5
            int r0 = r0.hashCode()     // Catch:{ Exception -> 0x01ed }
            r1.setId(r0)     // Catch:{ Exception -> 0x01ed }
            goto L_0x01f5
        L_0x01ed:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
        L_0x01f5:
            boolean r0 = r1 instanceof android.widget.EditText     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x01fe
            r17 = r8
        L_0x01fb:
            r4 = 0
            goto L_0x06da
        L_0x01fe:
            boolean r0 = r1 instanceof android.widget.Button     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r4 = "R.style."
            java.lang.String r5 = "/"
            java.lang.String r14 = "bold"
            r17 = r8
            r8 = 1
            if (r0 == 0) goto L_0x0300
            r0 = r1
            android.widget.Button r0 = (android.widget.Button) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r6 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x02f6 }
            int r12 = r12.ordinal()     // Catch:{ Exception -> 0x02f6 }
            r6 = r6[r12]     // Catch:{ Exception -> 0x02f6 }
            switch(r6) {
                case 13: goto L_0x02e5;
                case 14: goto L_0x02c0;
                case 15: goto L_0x02b6;
                case 16: goto L_0x02ac;
                case 17: goto L_0x029b;
                case 18: goto L_0x0283;
                case 19: goto L_0x0270;
                case 20: goto L_0x0240;
                case 21: goto L_0x021e;
                case 22: goto L_0x021a;
                default: goto L_0x0219;
            }     // Catch:{ Exception -> 0x02f6 }
        L_0x0219:
            goto L_0x01fb
        L_0x021a:
            r0.setGravity(r8)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x021e:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x02f6 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02f6 }
            if (r5 != 0) goto L_0x01fb
            java.util.HashMap<java.lang.String, java.lang.String> r5 = com.mbridge.msdk.dycreator.e.b.a     // Catch:{ Exception -> 0x02f6 }
            r6 = 8
            java.lang.String r4 = r4.substring(r6)     // Catch:{ Exception -> 0x02f6 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x02f6 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x02f6 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02f6 }
            if (r5 != 0) goto L_0x01fb
            r0.setTag(r4)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x0240:
            java.lang.String r6 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x02f6 }
            int r5 = r6.indexOf(r5)     // Catch:{ Exception -> 0x02f6 }
            int r5 = r5 + r8
            java.lang.String r5 = r6.substring(r5)     // Catch:{ Exception -> 0x02f6 }
            com.mbridge.msdk.dycreator.a.b r6 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x02f6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f6 }
            r8.<init>()     // Catch:{ Exception -> 0x02f6 }
            r8.append(r4)     // Catch:{ Exception -> 0x02f6 }
            r8.append(r5)     // Catch:{ Exception -> 0x02f6 }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x02f6 }
            int r4 = r6.d(r4)     // Catch:{ Exception -> 0x02f6 }
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x02f6 }
            android.content.Context r5 = r5.g()     // Catch:{ Exception -> 0x02f6 }
            r0.setTextAppearance(r5, r4)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x0270:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x02f6 }
            boolean r4 = r14.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x02f6 }
            if (r4 == 0) goto L_0x01fb
            android.graphics.Typeface r4 = android.graphics.Typeface.defaultFromStyle(r8)     // Catch:{ Exception -> 0x02f6 }
            r0.setTypeface(r4)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x0283:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x02f6 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02f6 }
            if (r5 != 0) goto L_0x01fb
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x02f6 }
            int r4 = r5.b(r4)     // Catch:{ Exception -> 0x02f6 }
            float r4 = (float) r4     // Catch:{ Exception -> 0x02f6 }
            r0.setTextSize(r4)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x029b:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x02f6 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x02f6 }
            int r4 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x02f6 }
            r0.setTextColor(r4)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x02ac:
            r4 = 0
            boolean r5 = r2.getAttributeBooleanValue(r7, r4)     // Catch:{ Exception -> 0x02f6 }
            r0.setHorizontallyScrolling(r5)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x02b6:
            r4 = 0
            boolean r5 = r2.getAttributeBooleanValue(r7, r4)     // Catch:{ Exception -> 0x02f6 }
            r0.setHorizontalFadingEdgeEnabled(r5)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x02c0:
            r4 = 0
            boolean r5 = r2.getAttributeBooleanValue(r7, r4)     // Catch:{ Exception -> 0x02f6 }
            if (r5 == 0) goto L_0x01fb
            r0.setFocusable(r8)     // Catch:{ Exception -> 0x02f6 }
            r0.setFocusableInTouchMode(r8)     // Catch:{ Exception -> 0x02f6 }
            r0.setSingleLine(r8)     // Catch:{ Exception -> 0x02f6 }
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.MARQUEE     // Catch:{ Exception -> 0x02f6 }
            r0.setEllipsize(r4)     // Catch:{ Exception -> 0x02f6 }
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.setMarqueeRepeatLimit(r4)     // Catch:{ Exception -> 0x02f6 }
            r0.setSingleLine()     // Catch:{ Exception -> 0x02f6 }
            r0.setHorizontallyScrolling(r8)     // Catch:{ Exception -> 0x02f6 }
            r0.requestFocus()     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x02e5:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x02f6 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x02f6 }
            java.lang.String r4 = r4.e(r5)     // Catch:{ Exception -> 0x02f6 }
            r0.setText(r4)     // Catch:{ Exception -> 0x02f6 }
            goto L_0x01fb
        L_0x02f6:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x0300:
            boolean r0 = r1 instanceof android.widget.TextView     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x048d
            r0 = r1
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r15 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x0483 }
            int r12 = r12.ordinal()     // Catch:{ Exception -> 0x0483 }
            r12 = r15[r12]     // Catch:{ Exception -> 0x0483 }
            switch(r12) {
                case 13: goto L_0x045b;
                case 14: goto L_0x041a;
                case 15: goto L_0x0410;
                case 16: goto L_0x0406;
                case 17: goto L_0x03f5;
                case 18: goto L_0x03dd;
                case 19: goto L_0x03ca;
                case 20: goto L_0x03a5;
                case 21: goto L_0x037e;
                case 22: goto L_0x036d;
                default: goto L_0x0312;
            }     // Catch:{ Exception -> 0x0483 }
        L_0x0312:
            switch(r12) {
                case 28: goto L_0x0363;
                case 29: goto L_0x035a;
                case 30: goto L_0x0328;
                case 31: goto L_0x0317;
                default: goto L_0x0315;
            }     // Catch:{ Exception -> 0x0483 }
        L_0x0315:
            goto L_0x01fb
        L_0x0317:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0483 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            int r4 = r4.b(r5)     // Catch:{ Exception -> 0x0483 }
            r0.setCompoundDrawablePadding(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x0328:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            boolean r5 = r4.startsWith(r6)     // Catch:{ Exception -> 0x0483 }
            if (r5 == 0) goto L_0x0338
            r5 = 10
            java.lang.String r16 = r4.substring(r5)     // Catch:{ Exception -> 0x0483 }
        L_0x0338:
            r4 = r16
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0483 }
            if (r5 != 0) goto L_0x01fb
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0483 }
            android.content.Context r5 = r5.g()     // Catch:{ Exception -> 0x0483 }
            int r4 = com.mbridge.msdk.foundation.tools.t.a(r5, r4, r13)     // Catch:{ Exception -> 0x0483 }
            android.content.res.Resources r5 = r0.getResources()     // Catch:{ Exception -> 0x0483 }
            android.graphics.drawable.Drawable r4 = r5.getDrawable(r4)     // Catch:{ Exception -> 0x0483 }
            r5 = 0
            r0.setCompoundDrawables(r4, r5, r5, r5)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x035a:
            int r4 = r2.getAttributeIntValue(r7, r8)     // Catch:{ Exception -> 0x0483 }
            r0.setLines(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x0363:
            r4 = 0
            boolean r5 = r2.getAttributeBooleanValue(r7, r4)     // Catch:{ Exception -> 0x0483 }
            r0.setSingleLine(r5)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x036d:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0483 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            int r4 = r4.c(r5)     // Catch:{ Exception -> 0x0483 }
            r0.setGravity(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x037e:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0483 }
            if (r5 == 0) goto L_0x038a
            goto L_0x01fb
        L_0x038a:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = com.mbridge.msdk.dycreator.e.b.a     // Catch:{ Exception -> 0x0483 }
            r6 = 8
            java.lang.String r4 = r4.substring(r6)     // Catch:{ Exception -> 0x0483 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x0483 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0483 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0483 }
            if (r5 == 0) goto L_0x03a0
            goto L_0x01fb
        L_0x03a0:
            r0.setTag(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x03a5:
            java.lang.String r0 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            int r5 = r0.indexOf(r5)     // Catch:{ Exception -> 0x0483 }
            int r5 = r5 + r8
            java.lang.String r0 = r0.substring(r5)     // Catch:{ Exception -> 0x0483 }
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0483 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0483 }
            r6.<init>()     // Catch:{ Exception -> 0x0483 }
            r6.append(r4)     // Catch:{ Exception -> 0x0483 }
            r6.append(r0)     // Catch:{ Exception -> 0x0483 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x0483 }
            r5.d(r0)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x03ca:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            boolean r4 = r14.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0483 }
            if (r4 == 0) goto L_0x01fb
            android.graphics.Typeface r4 = android.graphics.Typeface.defaultFromStyle(r8)     // Catch:{ Exception -> 0x0483 }
            r0.setTypeface(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x03dd:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0483 }
            if (r5 != 0) goto L_0x01fb
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0483 }
            int r4 = r5.b(r4)     // Catch:{ Exception -> 0x0483 }
            float r4 = (float) r4     // Catch:{ Exception -> 0x0483 }
            r0.setTextSize(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x03f5:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0483 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            int r4 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0483 }
            r0.setTextColor(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x0406:
            r4 = 0
            boolean r5 = r2.getAttributeBooleanValue(r7, r4)     // Catch:{ Exception -> 0x0483 }
            r0.setHorizontallyScrolling(r5)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x0410:
            r4 = 0
            boolean r5 = r2.getAttributeBooleanValue(r7, r4)     // Catch:{ Exception -> 0x0483 }
            r0.setHorizontalFadingEdgeEnabled(r5)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x041a:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0483 }
            if (r5 != 0) goto L_0x01fb
            java.lang.String r5 = "end"
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0483 }
            if (r5 == 0) goto L_0x0431
            android.text.TextUtils$TruncateAt r5 = android.text.TextUtils.TruncateAt.END     // Catch:{ Exception -> 0x0483 }
            r0.setEllipsize(r5)     // Catch:{ Exception -> 0x0483 }
        L_0x0431:
            java.lang.String r5 = "start"
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0483 }
            if (r5 == 0) goto L_0x043f
            android.text.TextUtils$TruncateAt r5 = android.text.TextUtils.TruncateAt.START     // Catch:{ Exception -> 0x0483 }
            r0.setEllipsize(r5)     // Catch:{ Exception -> 0x0483 }
        L_0x043f:
            java.lang.String r5 = "middle"
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0483 }
            if (r5 == 0) goto L_0x044c
            android.text.TextUtils$TruncateAt r5 = android.text.TextUtils.TruncateAt.MIDDLE     // Catch:{ Exception -> 0x0483 }
            r0.setEllipsize(r5)     // Catch:{ Exception -> 0x0483 }
        L_0x044c:
            java.lang.String r5 = "marquee"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0483 }
            if (r4 == 0) goto L_0x01fb
            android.text.TextUtils$TruncateAt r4 = android.text.TextUtils.TruncateAt.MARQUEE     // Catch:{ Exception -> 0x0483 }
            r0.setEllipsize(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x045b:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0483 }
            if (r5 != 0) goto L_0x01fb
            java.lang.String r5 = "@string/"
            boolean r5 = r4.startsWith(r5)     // Catch:{ Exception -> 0x0483 }
            if (r5 == 0) goto L_0x047e
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0483 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0483 }
            java.lang.String r4 = r4.e(r5)     // Catch:{ Exception -> 0x0483 }
            r0.setText(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x047e:
            r0.setText(r4)     // Catch:{ Exception -> 0x0483 }
            goto L_0x01fb
        L_0x0483:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x048d:
            boolean r0 = r1 instanceof android.widget.ImageView     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x04f4
            r0 = r1
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r4 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x04ea }
            int r5 = r12.ordinal()     // Catch:{ Exception -> 0x04ea }
            r4 = r4[r5]     // Catch:{ Exception -> 0x04ea }
            r5 = 32
            if (r4 == r5) goto L_0x04dd
            r5 = 33
            if (r4 == r5) goto L_0x04a6
            goto L_0x01fb
        L_0x04a6:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x04ea }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x04ea }
            if (r5 != 0) goto L_0x01fb
            java.lang.String r5 = "fitXY"
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x04ea }
            if (r5 == 0) goto L_0x04bf
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ Exception -> 0x04ea }
            r0.setScaleType(r4)     // Catch:{ Exception -> 0x04ea }
            goto L_0x01fb
        L_0x04bf:
            java.lang.String r5 = "centerInside"
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x04ea }
            if (r5 == 0) goto L_0x04ce
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ Exception -> 0x04ea }
            r0.setScaleType(r4)     // Catch:{ Exception -> 0x04ea }
            goto L_0x01fb
        L_0x04ce:
            java.lang.String r5 = "centerCrop"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x04ea }
            if (r4 == 0) goto L_0x01fb
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ Exception -> 0x04ea }
            r0.setScaleType(r4)     // Catch:{ Exception -> 0x04ea }
            goto L_0x01fb
        L_0x04dd:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x04ea }
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x04ea }
            r5.a((java.lang.String) r4, (android.widget.ImageView) r0)     // Catch:{ Exception -> 0x04ea }
            goto L_0x01fb
        L_0x04ea:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x04f4:
            boolean r0 = r1 instanceof android.widget.ListView     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r4 = "false"
            if (r0 == 0) goto L_0x058d
            r0 = r1
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r5 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x0583 }
            int r6 = r12.ordinal()     // Catch:{ Exception -> 0x0583 }
            r5 = r5[r6]     // Catch:{ Exception -> 0x0583 }
            r6 = 25
            if (r5 == r6) goto L_0x0575
            r6 = 26
            if (r5 == r6) goto L_0x0564
            switch(r5) {
                case 34: goto L_0x054c;
                case 35: goto L_0x0529;
                case 36: goto L_0x0512;
                default: goto L_0x0510;
            }     // Catch:{ Exception -> 0x0583 }
        L_0x0510:
            goto L_0x01fb
        L_0x0512:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0583 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0583 }
            if (r5 != 0) goto L_0x01fb
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0583 }
            int r4 = r5.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0583 }
            r0.setSelector(r4)     // Catch:{ Exception -> 0x0583 }
            goto L_0x01fb
        L_0x0529:
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0583 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0583 }
            if (r6 != 0) goto L_0x01fb
            java.lang.String r6 = "none"
            boolean r6 = r5.equals(r6)     // Catch:{ Exception -> 0x0583 }
            if (r6 == 0) goto L_0x0540
            r6 = 0
            r0.setVerticalScrollBarEnabled(r6)     // Catch:{ Exception -> 0x0583 }
            goto L_0x0541
        L_0x0540:
            r6 = 0
        L_0x0541:
            boolean r4 = r5.equals(r4)     // Catch:{ Exception -> 0x0583 }
            if (r4 == 0) goto L_0x01fb
            r0.setScrollbarFadingEnabled(r6)     // Catch:{ Exception -> 0x0583 }
            goto L_0x01fb
        L_0x054c:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0583 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0583 }
            if (r5 != 0) goto L_0x01fb
            java.lang.String r5 = "@null"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Exception -> 0x0583 }
            if (r4 == 0) goto L_0x01fb
            r4 = 0
            r0.setDivider(r4)     // Catch:{ Exception -> 0x0583 }
            goto L_0x01fb
        L_0x0564:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0583 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0583 }
            int r4 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0583 }
            r0.setCacheColorHint(r4)     // Catch:{ Exception -> 0x0583 }
            goto L_0x01fb
        L_0x0575:
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0583 }
            boolean r4 = r5.equals(r4)     // Catch:{ Exception -> 0x0583 }
            r4 = r4 ^ r8
            r0.setMotionEventSplittingEnabled(r4)     // Catch:{ Exception -> 0x0583 }
            goto L_0x01fb
        L_0x0583:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x058d:
            boolean r0 = r1 instanceof android.widget.GridView     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x062a
            r0 = r1
            android.widget.GridView r0 = (android.widget.GridView) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r5 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x0620 }
            int r6 = r12.ordinal()     // Catch:{ Exception -> 0x0620 }
            r5 = r5[r6]     // Catch:{ Exception -> 0x0620 }
            if (r5 == r8) goto L_0x0608
            switch(r5) {
                case 23: goto L_0x05ea;
                case 24: goto L_0x05e0;
                case 25: goto L_0x05d2;
                case 26: goto L_0x05c1;
                case 27: goto L_0x05a3;
                default: goto L_0x05a1;
            }     // Catch:{ Exception -> 0x0620 }
        L_0x05a1:
            goto L_0x01fb
        L_0x05a3:
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0620 }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x0620 }
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0620 }
            java.lang.String r6 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0620 }
            int r5 = r5.b(r6)     // Catch:{ Exception -> 0x0620 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0620 }
            int r4 = com.mbridge.msdk.dycreator.e.e.a(r4, r5)     // Catch:{ Exception -> 0x0620 }
            r0.setHorizontalSpacing(r4)     // Catch:{ Exception -> 0x0620 }
            goto L_0x01fb
        L_0x05c1:
            com.mbridge.msdk.dycreator.a.b r4 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0620 }
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0620 }
            int r4 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0620 }
            r0.setCacheColorHint(r4)     // Catch:{ Exception -> 0x0620 }
            goto L_0x01fb
        L_0x05d2:
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0620 }
            boolean r4 = r5.equals(r4)     // Catch:{ Exception -> 0x0620 }
            r4 = r4 ^ r8
            r0.setMotionEventSplittingEnabled(r4)     // Catch:{ Exception -> 0x0620 }
            goto L_0x01fb
        L_0x05e0:
            r4 = 2
            int r4 = r2.getAttributeIntValue(r7, r4)     // Catch:{ Exception -> 0x0620 }
            r0.setNumColumns(r4)     // Catch:{ Exception -> 0x0620 }
            goto L_0x01fb
        L_0x05ea:
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0620 }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x0620 }
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x0620 }
            java.lang.String r6 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0620 }
            int r5 = r5.b(r6)     // Catch:{ Exception -> 0x0620 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0620 }
            int r4 = com.mbridge.msdk.dycreator.e.e.a(r4, r5)     // Catch:{ Exception -> 0x0620 }
            r0.setVerticalSpacing(r4)     // Catch:{ Exception -> 0x0620 }
            goto L_0x01fb
        L_0x0608:
            java.lang.String r4 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x0620 }
            boolean r5 = r4.startsWith(r15)     // Catch:{ Exception -> 0x0620 }
            if (r5 == 0) goto L_0x01fb
            r5 = 5
            java.lang.String r4 = r4.substring(r5)     // Catch:{ Exception -> 0x0620 }
            int r4 = r4.hashCode()     // Catch:{ Exception -> 0x0620 }
            r0.setId(r4)     // Catch:{ Exception -> 0x0620 }
            goto L_0x01fb
        L_0x0620:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x062a:
            boolean r0 = r1 instanceof android.widget.ScrollView     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x0633
            r0 = r1
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x0633:
            boolean r0 = r1 instanceof com.mbridge.msdk.playercommon.PlayerView     // Catch:{ Exception -> 0x06e5 }
            java.lang.String r4 = "horizontal"
            r5 = 12
            if (r0 == 0) goto L_0x0669
            r0 = r1
            com.mbridge.msdk.playercommon.PlayerView r0 = (com.mbridge.msdk.playercommon.PlayerView) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r6 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x065f }
            int r12 = r12.ordinal()     // Catch:{ Exception -> 0x065f }
            r6 = r6[r12]     // Catch:{ Exception -> 0x065f }
            if (r6 == r5) goto L_0x064a
            goto L_0x01fb
        L_0x064a:
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x065f }
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x065f }
            if (r4 == 0) goto L_0x065a
            r4 = 0
            r0.setOrientation(r4)     // Catch:{ Exception -> 0x065f }
            goto L_0x01fb
        L_0x065a:
            r0.setOrientation(r8)     // Catch:{ Exception -> 0x065f }
            goto L_0x01fb
        L_0x065f:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x0669:
            boolean r0 = r1 instanceof com.mbridge.msdk.dycreator.baseview.MBHorizontalScrollView     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x0672
            r0 = r1
            com.mbridge.msdk.dycreator.baseview.MBHorizontalScrollView r0 = (com.mbridge.msdk.dycreator.baseview.MBHorizontalScrollView) r0     // Catch:{ Exception -> 0x06e5 }
            goto L_0x01fb
        L_0x0672:
            boolean r0 = r1 instanceof android.widget.LinearLayout     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x06a5
            r0 = r1
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r6 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x069b }
            int r12 = r12.ordinal()     // Catch:{ Exception -> 0x069b }
            r6 = r6[r12]     // Catch:{ Exception -> 0x069b }
            if (r6 == r5) goto L_0x0685
            goto L_0x01fb
        L_0x0685:
            java.lang.String r5 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x069b }
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x069b }
            if (r4 == 0) goto L_0x0694
            r4 = 0
            r0.setOrientation(r4)     // Catch:{ Exception -> 0x0699 }
            goto L_0x06da
        L_0x0694:
            r4 = 0
            r0.setOrientation(r8)     // Catch:{ Exception -> 0x0699 }
            goto L_0x06da
        L_0x0699:
            r0 = move-exception
            goto L_0x069d
        L_0x069b:
            r0 = move-exception
            r4 = 0
        L_0x069d:
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x06da
        L_0x06a5:
            r4 = 0
            boolean r0 = r1 instanceof android.widget.RelativeLayout     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x06d3
            r0 = r1
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x06e5 }
            int[] r5 = com.mbridge.msdk.dycreator.e.a.AnonymousClass1.a     // Catch:{ Exception -> 0x06ca }
            int r6 = r12.ordinal()     // Catch:{ Exception -> 0x06ca }
            r5 = r5[r6]     // Catch:{ Exception -> 0x06ca }
            r6 = 22
            if (r5 == r6) goto L_0x06ba
            goto L_0x06da
        L_0x06ba:
            com.mbridge.msdk.dycreator.a.b r5 = com.mbridge.msdk.dycreator.a.b.a()     // Catch:{ Exception -> 0x06ca }
            java.lang.String r6 = r2.getAttributeValue(r7)     // Catch:{ Exception -> 0x06ca }
            int r5 = r5.c(r6)     // Catch:{ Exception -> 0x06ca }
            r0.setGravity(r5)     // Catch:{ Exception -> 0x06ca }
            goto L_0x06da
        L_0x06ca:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)     // Catch:{ Exception -> 0x06e5 }
            goto L_0x06da
        L_0x06d3:
            boolean r0 = r1 instanceof android.widget.FrameLayout     // Catch:{ Exception -> 0x06e5 }
            if (r0 == 0) goto L_0x06da
            r0 = r1
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0     // Catch:{ Exception -> 0x06e5 }
        L_0x06da:
            r8 = r17
        L_0x06dc:
            int r7 = r7 + 1
            r4 = r18
            r5 = r19
            goto L_0x0027
        L_0x06e4:
            return
        L_0x06e5:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r3, r0)
        L_0x06ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.e.a.a(android.view.View, android.util.AttributeSet):void");
    }
}
