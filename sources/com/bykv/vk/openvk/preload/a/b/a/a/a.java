package com.bykv.vk.openvk.preload.a.b.a.a;

import java.util.TimeZone;

/* compiled from: ISO8601Utils */
public final class a {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cf A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01af }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a7 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date a(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            r1 = r17
            r2 = r18
            int r0 = r18.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r3 = r0 + 4
            int r0 = a((java.lang.String) r1, (int) r0, (int) r3)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r4 = 45
            boolean r5 = a((java.lang.String) r1, (int) r3, (char) r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r5 == 0) goto L_0x0018
            int r3 = r3 + 1
        L_0x0018:
            int r5 = r3 + 2
            int r3 = a((java.lang.String) r1, (int) r3, (int) r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            boolean r6 = a((java.lang.String) r1, (int) r5, (char) r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r6 == 0) goto L_0x0026
            int r5 = r5 + 1
        L_0x0026:
            int r6 = r5 + 2
            int r5 = a((java.lang.String) r1, (int) r5, (int) r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r7 = 84
            boolean r7 = a((java.lang.String) r1, (int) r6, (char) r7)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r8 = 1
            if (r7 != 0) goto L_0x0049
            int r9 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r9 > r6) goto L_0x0049
            java.util.GregorianCalendar r4 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r3 = r3 - r8
            r4.<init>(r0, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.util.Date r0 = r4.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            return r0
        L_0x0049:
            r9 = 43
            r10 = 90
            r12 = 2
            if (r7 == 0) goto L_0x00c5
            int r6 = r6 + 1
            int r7 = r6 + 2
            int r6 = a((java.lang.String) r1, (int) r6, (int) r7)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r13 = 58
            boolean r14 = a((java.lang.String) r1, (int) r7, (char) r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r14 == 0) goto L_0x0062
            int r7 = r7 + 1
        L_0x0062:
            int r14 = r7 + 2
            int r7 = a((java.lang.String) r1, (int) r7, (int) r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            boolean r13 = a((java.lang.String) r1, (int) r14, (char) r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r13 == 0) goto L_0x0070
            int r14 = r14 + 1
        L_0x0070:
            int r13 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r13 <= r14) goto L_0x00c0
            char r13 = r1.charAt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r13 == r10) goto L_0x00c0
            if (r13 == r9) goto L_0x00c0
            if (r13 == r4) goto L_0x00c0
            int r13 = r14 + 2
            int r14 = a((java.lang.String) r1, (int) r14, (int) r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r15 = 59
            if (r14 <= r15) goto L_0x0090
            r15 = 63
            if (r14 >= r15) goto L_0x0090
            r14 = 59
        L_0x0090:
            r15 = 46
            boolean r15 = a((java.lang.String) r1, (int) r13, (char) r15)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r15 == 0) goto L_0x00bb
            int r13 = r13 + 1
            int r15 = r13 + 1
            int r15 = a((java.lang.String) r1, (int) r15)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r11 = r13 + 3
            int r11 = java.lang.Math.min(r15, r11)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r16 = a((java.lang.String) r1, (int) r13, (int) r11)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r11 = r11 - r13
            if (r11 == r8) goto L_0x00b3
            if (r11 == r12) goto L_0x00b0
            goto L_0x00b5
        L_0x00b0:
            int r16 = r16 * 10
            goto L_0x00b5
        L_0x00b3:
            int r16 = r16 * 100
        L_0x00b5:
            r11 = r7
            r13 = r16
            r7 = r6
            r6 = r15
            goto L_0x00c9
        L_0x00bb:
            r11 = r7
            r7 = r6
            r6 = r13
            r13 = 0
            goto L_0x00c9
        L_0x00c0:
            r11 = r7
            r13 = 0
            r7 = r6
            r6 = r14
            goto L_0x00c8
        L_0x00c5:
            r7 = 0
            r11 = 0
            r13 = 0
        L_0x00c8:
            r14 = 0
        L_0x00c9:
            int r15 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r15 <= r6) goto L_0x01a7
            char r15 = r1.charAt(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r12 = 5
            if (r15 != r10) goto L_0x00db
            java.util.TimeZone r4 = a     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r6 = r6 + r8
            goto L_0x0176
        L_0x00db:
            if (r15 == r9) goto L_0x00f9
            if (r15 != r4) goto L_0x00e0
            goto L_0x00f9
        L_0x00e0:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r4 = "Invalid time zone indicator '"
            r3.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r3.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
        L_0x00f9:
            java.lang.String r4 = r1.substring(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r9 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r9 < r12) goto L_0x0104
            goto L_0x0115
        L_0x0104:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r9.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r4 = "00"
            r9.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r4 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
        L_0x0115:
            int r9 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r6 = r6 + r9
            java.lang.String r9 = "+0000"
            boolean r9 = r9.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r9 != 0) goto L_0x0174
            java.lang.String r9 = "+00:00"
            boolean r9 = r9.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r9 == 0) goto L_0x012b
            goto L_0x0174
        L_0x012b:
            java.lang.String r9 = "GMT"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r4 = r9.concat(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.util.TimeZone r9 = java.util.TimeZone.getTimeZone(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r10 = r9.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            boolean r15 = r10.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r15 != 0) goto L_0x0172
            java.lang.String r15 = ":"
            java.lang.String r12 = ""
            java.lang.String r10 = r10.replace(r15, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            boolean r10 = r10.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            if (r10 == 0) goto L_0x0152
            goto L_0x0172
        L_0x0152:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r3.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r4 = " given, resolves to "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r4 = r9.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
        L_0x0172:
            r4 = r9
            goto L_0x0176
        L_0x0174:
            java.util.TimeZone r4 = a     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
        L_0x0176:
            java.util.GregorianCalendar r9 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r9.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r4 = 0
            r9.setLenient(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r9.set(r8, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            int r3 = r3 - r8
            r0 = 2
            r9.set(r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r0 = 5
            r9.set(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r0 = 11
            r9.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r0 = 12
            r9.set(r0, r11)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r0 = 13
            r9.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r0 = 14
            r9.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.util.Date r0 = r9.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            return r0
        L_0x01a7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01b3, NumberFormatException -> 0x01b1, IllegalArgumentException -> 0x01af }
        L_0x01af:
            r0 = move-exception
            goto L_0x01b4
        L_0x01b1:
            r0 = move-exception
            goto L_0x01b4
        L_0x01b3:
            r0 = move-exception
        L_0x01b4:
            if (r1 != 0) goto L_0x01b8
            r1 = 0
            goto L_0x01cb
        L_0x01b8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "\""
            r3.<init>(r4)
            r3.append(r1)
            r1 = 34
            r3.append(r1)
            java.lang.String r1 = r3.toString()
        L_0x01cb:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01d7
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x01f2
        L_0x01d7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x01f2:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed to parse date ["
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r18.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.a.a.a.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
