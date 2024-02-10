package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.io.IOException;
import java.io.Reader;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class yb {
    static final char[] e = {AbstractJsonLexerKt.COMMA, '(', ')', AbstractJsonLexerKt.BEGIN_LIST, AbstractJsonLexerKt.END_LIST, '\"'};
    Reader a = null;
    int b = 0;
    StringBuilder c = new StringBuilder();
    int d = 0;

    public yb(Reader reader) {
        this.a = reader;
    }

    private wb a() throws IOException, xb {
        int i = this.d;
        int i2 = this.b;
        if (i2 != 0) {
            this.b = 0;
            i--;
        } else {
            i2 = this.a.read();
            this.d++;
        }
        while (true) {
            if (i2 != 9 && i2 != 32) {
                break;
            }
            i2 = this.a.read();
            this.d++;
            i++;
        }
        if (i2 == -1) {
            return null;
        }
        if (!a(i2)) {
            this.c.setLength(0);
            this.c.append((char) i2);
            a(false);
            String sb = this.c.toString();
            this.c.setLength(0);
            int i3 = this.b == 0 ? this.d : this.d - 1;
            if (sb.matches("-?\\d+")) {
                return new wb(wb.a.TOKEN_INTEGER, sb, i, i3);
            }
            if (sb.matches("-?\\d+(\\.\\d+)?")) {
                return new wb(wb.a.TOKEN_NUMBER, sb, i, i3);
            }
            return new wb(wb.a.TOKEN_STRING, sb, i, i3);
        } else if (i2 == 40) {
            return new wb(wb.a.TOKEN_BRACKET_OPEN, "(", i, this.d);
        } else {
            if (i2 == 41) {
                return new wb(wb.a.TOKEN_BRACKET_CLOSE, ")", i, this.d);
            }
            if (i2 == 91) {
                return new wb(wb.a.TOKEN_SQUAREBRACKET_OPEN, "[", i, this.d);
            }
            if (i2 == 93) {
                return new wb(wb.a.TOKEN_SQUAREBRACKET_CLOSE, "]", i, this.d);
            }
            if (i2 == 34) {
                this.c.setLength(0);
                a(true);
                String sb2 = this.c.toString();
                this.c.setLength(0);
                return new wb(wb.a.TOKEN_QUOTED_STRING, sb2, i, this.b == 0 ? this.d : this.d - 1);
            } else if (i2 == 44) {
                return new wb(wb.a.TOKEN_COMMA, ",", i, this.d);
            } else {
                throw new xb(this.d, "Unimplemented Syntax Character '" + i2 + "'");
            }
        }
    }

    public wb b() throws IOException, xb {
        wb a2;
        wb wbVar = null;
        while (true) {
            wb wbVar2 = wbVar;
            while (true) {
                a2 = a();
                if (a2 != null) {
                    if (wbVar2 == null) {
                        break;
                    }
                    wbVar2.a(a2);
                    a2.b(wbVar2);
                    wbVar2 = a2;
                } else {
                    return wbVar;
                }
            }
            wbVar = a2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r2 != 34) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r6.c.append("\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r2 != 116) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r6.c.append("\t");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r2 != 110) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r6.c.append("\n");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r2 != 114) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        r6.c.append("\r");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 != 102) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        r6.c.append("\f");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        throw new com.umlaut.crowd.internal.xb(r6.d, "Only special characters can be escaped. Trying to escape character '" + r2 + "'");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r2 != 92) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r6.c.append("\\");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r7) throws java.io.IOException, com.umlaut.crowd.internal.xb {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            java.io.Reader r2 = r6.a
            int r2 = r2.read()
            r3 = -1
            if (r2 == r3) goto L_0x00b8
            int r3 = r6.d
            r4 = 1
            int r3 = r3 + r4
            r6.d = r3
            if (r7 == 0) goto L_0x0088
            r3 = 34
            r5 = 92
            if (r1 == 0) goto L_0x0078
            if (r2 != r5) goto L_0x0023
            java.lang.StringBuilder r1 = r6.c
            java.lang.String r2 = "\\"
            r1.append(r2)
            goto L_0x0001
        L_0x0023:
            if (r2 != r3) goto L_0x002d
            java.lang.StringBuilder r1 = r6.c
            java.lang.String r2 = "\""
            r1.append(r2)
            goto L_0x0001
        L_0x002d:
            r1 = 116(0x74, float:1.63E-43)
            if (r2 != r1) goto L_0x0039
            java.lang.StringBuilder r1 = r6.c
            java.lang.String r2 = "\t"
            r1.append(r2)
            goto L_0x0001
        L_0x0039:
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 != r1) goto L_0x0045
            java.lang.StringBuilder r1 = r6.c
            java.lang.String r2 = "\n"
            r1.append(r2)
            goto L_0x0001
        L_0x0045:
            r1 = 114(0x72, float:1.6E-43)
            if (r2 != r1) goto L_0x0051
            java.lang.StringBuilder r1 = r6.c
            java.lang.String r2 = "\r"
            r1.append(r2)
            goto L_0x0001
        L_0x0051:
            r1 = 102(0x66, float:1.43E-43)
            if (r2 != r1) goto L_0x005d
            java.lang.StringBuilder r1 = r6.c
            java.lang.String r2 = "\f"
            r1.append(r2)
            goto L_0x0001
        L_0x005d:
            com.umlaut.crowd.internal.xb r7 = new com.umlaut.crowd.internal.xb
            int r0 = r6.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Only special characters can be escaped. Trying to escape character '"
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.<init>(r0, r1)
            throw r7
        L_0x0078:
            if (r2 != r5) goto L_0x007c
            r1 = 1
            goto L_0x0002
        L_0x007c:
            if (r2 != r3) goto L_0x0080
            r7 = 0
            goto L_0x00b8
        L_0x0080:
            java.lang.StringBuilder r3 = r6.c
            char r2 = (char) r2
            r3.append(r2)
            goto L_0x0002
        L_0x0088:
            r3 = 31
            if (r2 <= r3) goto L_0x00a2
            boolean r3 = r6.a((int) r2)
            if (r3 != 0) goto L_0x009f
            r3 = 32
            if (r2 != r3) goto L_0x0097
            goto L_0x009f
        L_0x0097:
            java.lang.StringBuilder r3 = r6.c
            char r2 = (char) r2
            r3.append(r2)
            goto L_0x0002
        L_0x009f:
            r6.b = r2
            goto L_0x00b8
        L_0x00a2:
            com.umlaut.crowd.internal.xb r7 = new com.umlaut.crowd.internal.xb
            int r0 = r6.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "only printable characters are supported, got "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.<init>(r0, r1)
            throw r7
        L_0x00b8:
            if (r7 != 0) goto L_0x00c7
            if (r1 != 0) goto L_0x00bd
            return
        L_0x00bd:
            com.umlaut.crowd.internal.xb r7 = new com.umlaut.crowd.internal.xb
            int r0 = r6.d
            java.lang.String r1 = "There is no escaped character"
            r7.<init>(r0, r1)
            throw r7
        L_0x00c7:
            com.umlaut.crowd.internal.xb r7 = new com.umlaut.crowd.internal.xb
            int r0 = r6.d
            java.lang.String r1 = "Quoted String is not closed"
            r7.<init>(r0, r1)
            goto L_0x00d2
        L_0x00d1:
            throw r7
        L_0x00d2:
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.yb.a(boolean):void");
    }

    private boolean a(int i) {
        for (char c2 : e) {
            if (i == c2) {
                return true;
            }
        }
        return false;
    }
}
