package com.teragence.library;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class u8 implements z8 {
    private Writer a;
    private boolean b;
    private int c;
    private int d;
    private String[] e = new String[12];
    private int[] f = new int[4];
    private String[] g = new String[8];
    private boolean[] h = new boolean[4];
    private boolean i;

    private final String a(String str, boolean z, boolean z2) {
        int i2 = this.f[this.d + 1] * 2;
        while (true) {
            i2 -= 2;
            String str2 = null;
            String str3 = "";
            if (i2 >= 0) {
                if (this.g[i2 + 1].equals(str) && (z || !this.g[i2].equals(str3))) {
                    String str4 = this.g[i2];
                    int i3 = i2 + 2;
                    while (true) {
                        if (i3 >= this.f[this.d + 1] * 2) {
                            str2 = str4;
                            break;
                        } else if (this.g[i3].equals(str4)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (str2 != null) {
                        return str2;
                    }
                }
            } else if (!z2) {
                return null;
            } else {
                if (!str3.equals(str)) {
                    do {
                        StringBuilder sb = new StringBuilder("n");
                        int i4 = this.c;
                        this.c = i4 + 1;
                        sb.append(i4);
                        String sb2 = sb.toString();
                        int i5 = (this.f[this.d + 1] * 2) - 2;
                        while (true) {
                            if (i5 < 0) {
                                str3 = sb2;
                                continue;
                                break;
                            } else if (sb2.equals(this.g[i5])) {
                                str3 = null;
                                continue;
                                break;
                            } else {
                                i5 -= 2;
                            }
                        }
                    } while (str3 == null);
                } else {
                    boolean z3 = this.b;
                    this.b = false;
                    a(str3, str);
                    this.b = z3;
                }
                boolean z32 = this.b;
                this.b = false;
                a(str3, str);
                this.b = z32;
                return str3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (r1 != '\'') goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            int r1 = r6.length()
            if (r0 >= r1) goto L_0x0093
            char r1 = r6.charAt(r0)
            r2 = 9
            java.lang.String r3 = "&#"
            if (r1 == r2) goto L_0x0070
            r2 = 10
            if (r1 == r2) goto L_0x0070
            r2 = 13
            if (r1 == r2) goto L_0x0070
            r2 = 34
            if (r1 == r2) goto L_0x0040
            r4 = 60
            if (r1 == r4) goto L_0x0038
            r4 = 62
            if (r1 == r4) goto L_0x0033
            r4 = 38
            if (r1 == r4) goto L_0x002e
            r4 = 39
            if (r1 == r4) goto L_0x0040
            goto L_0x004f
        L_0x002e:
            java.io.Writer r1 = r5.a
            java.lang.String r2 = "&amp;"
            goto L_0x003c
        L_0x0033:
            java.io.Writer r1 = r5.a
            java.lang.String r2 = "&gt;"
            goto L_0x003c
        L_0x0038:
            java.io.Writer r1 = r5.a
            java.lang.String r2 = "&lt;"
        L_0x003c:
            r1.write(r2)
            goto L_0x008f
        L_0x0040:
            if (r1 != r7) goto L_0x004f
            java.io.Writer r3 = r5.a
            if (r1 != r2) goto L_0x0049
            java.lang.String r1 = "&quot;"
            goto L_0x004b
        L_0x0049:
            java.lang.String r1 = "&apos;"
        L_0x004b:
            r3.write(r1)
            goto L_0x008f
        L_0x004f:
            r2 = 32
            if (r1 < r2) goto L_0x0060
            r2 = 64
            if (r1 == r2) goto L_0x0060
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 < r2) goto L_0x0073
            boolean r2 = r5.i
            if (r2 == 0) goto L_0x0060
            goto L_0x0073
        L_0x0060:
            java.io.Writer r2 = r5.a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r1)
            java.lang.String r1 = ";"
            r4.append(r1)
            goto L_0x0088
        L_0x0070:
            r2 = -1
            if (r7 != r2) goto L_0x0079
        L_0x0073:
            java.io.Writer r2 = r5.a
            r2.write(r1)
            goto L_0x008f
        L_0x0079:
            java.io.Writer r2 = r5.a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r1)
            r1 = 59
            r4.append(r1)
        L_0x0088:
            java.lang.String r1 = r4.toString()
            r2.write(r1)
        L_0x008f:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.u8.a(java.lang.String, int):void");
    }

    private final void a(boolean z) {
        if (this.b) {
            int i2 = this.d + 1;
            this.d = i2;
            this.b = false;
            boolean[] zArr = this.h;
            if (zArr.length <= i2) {
                boolean[] zArr2 = new boolean[(i2 + 4)];
                System.arraycopy(zArr, 0, zArr2, 0, i2);
                this.h = zArr2;
            }
            boolean[] zArr3 = this.h;
            int i3 = this.d;
            int i4 = i3 - 1;
            zArr3[i3] = zArr3[i4];
            int i5 = this.f[i4];
            while (true) {
                int[] iArr = this.f;
                int i6 = this.d;
                if (i5 < iArr[i6]) {
                    this.a.write(32);
                    this.a.write("xmlns");
                    int i7 = i5 * 2;
                    if (!"".equals(this.g[i7])) {
                        this.a.write(58);
                        this.a.write(this.g[i7]);
                    } else if ("".equals(c()) && !"".equals(this.g[i7 + 1])) {
                        throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                    }
                    this.a.write("=\"");
                    a(this.g[i7 + 1], 34);
                    this.a.write(34);
                    i5++;
                } else {
                    int i8 = i6 + 1;
                    if (iArr.length <= i8) {
                        int[] iArr2 = new int[(i6 + 8)];
                        System.arraycopy(iArr, 0, iArr2, 0, i8);
                        this.f = iArr2;
                    }
                    int[] iArr3 = this.f;
                    int i9 = this.d;
                    iArr3[i9 + 1] = iArr3[i9];
                    this.a.write(z ? " />" : ">");
                    return;
                }
            }
        }
    }

    public z8 a(String str, String str2, String str3) {
        if (this.b) {
            if (str == null) {
                str = "";
            }
            String a2 = "".equals(str) ? "" : a(str, false, true);
            this.a.write(32);
            if (!"".equals(a2)) {
                this.a.write(a2);
                this.a.write(58);
            }
            this.a.write(str2);
            this.a.write(61);
            int i2 = 34;
            if (str3.indexOf(34) != -1) {
                i2 = 39;
            }
            this.a.write(i2);
            a(str3, i2);
            this.a.write(i2);
            return this;
        }
        throw new IllegalStateException("illegal position for attribute");
    }

    public String a(String str, boolean z) {
        try {
            return a(str, false, z);
        } catch (IOException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public void a() {
        a(false);
        this.a.flush();
    }

    public void a(OutputStream outputStream, String str) {
        OutputStreamWriter outputStreamWriter;
        if (outputStream != null) {
            if (str != null) {
                outputStreamWriter = new OutputStreamWriter(outputStream, str);
            }
            a((Writer) outputStreamWriter);
            if (str != null && str.toLowerCase().startsWith("utf")) {
                this.i = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void a(Writer writer) {
        this.a = writer;
        int[] iArr = this.f;
        iArr[0] = 2;
        iArr[1] = 2;
        String[] strArr = this.g;
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "xml";
        strArr[3] = "http://www.w3.org/XML/1998/namespace";
        this.b = false;
        this.c = 0;
        this.d = 0;
        this.i = false;
    }

    public void a(String str) {
        a(false);
        this.a.write("<?");
        this.a.write(str);
        this.a.write("?>");
    }

    public void a(String str, String str2) {
        a(false);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!str.equals(a(str2, true, false))) {
            int[] iArr = this.f;
            int i2 = this.d + 1;
            int i3 = iArr[i2];
            iArr[i2] = i3 + 1;
            int i4 = i3 << 1;
            String[] strArr = this.g;
            int i5 = i4 + 1;
            if (strArr.length < i5) {
                String[] strArr2 = new String[(strArr.length + 16)];
                System.arraycopy(strArr, 0, strArr2, 0, i4);
                this.g = strArr2;
            }
            String[] strArr3 = this.g;
            strArr3[i4] = str;
            strArr3[i5] = str2;
        }
    }

    public int b() {
        return this.b ? this.d + 1 : this.d;
    }

    public z8 b(String str) {
        a(false);
        this.h[this.d] = false;
        a(str, -1);
        return this;
    }

    public z8 b(String str, String str2) {
        a(false);
        if (this.h[this.d]) {
            this.a.write("\r\n");
            for (int i2 = 0; i2 < this.d; i2++) {
                this.a.write("  ");
            }
        }
        int i3 = this.d * 3;
        String[] strArr = this.e;
        if (strArr.length < i3 + 3) {
            String[] strArr2 = new String[(strArr.length + 12)];
            System.arraycopy(strArr, 0, strArr2, 0, i3);
            this.e = strArr2;
        }
        String a2 = str == null ? "" : a(str, true, true);
        if ("".equals(str)) {
            int i4 = this.f[this.d];
            while (i4 < this.f[this.d + 1]) {
                int i5 = i4 * 2;
                if (!"".equals(this.g[i5]) || "".equals(this.g[i5 + 1])) {
                    i4++;
                } else {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        String[] strArr3 = this.e;
        int i6 = i3 + 1;
        strArr3[i3] = str;
        strArr3[i6] = a2;
        strArr3[i6 + 1] = str2;
        this.a.write(60);
        if (!"".equals(a2)) {
            this.a.write(a2);
            this.a.write(58);
        }
        this.a.write(str2);
        this.b = true;
        return this;
    }

    public z8 c(String str, String str2) {
        if (!this.b) {
            this.d--;
        }
        if ((str != null || this.e[this.d * 3] == null) && ((str == null || str.equals(this.e[this.d * 3])) && this.e[(this.d * 3) + 2].equals(str2))) {
            if (this.b) {
                a(true);
                this.d--;
            } else {
                if (this.h[this.d + 1]) {
                    this.a.write("\r\n");
                    for (int i2 = 0; i2 < this.d; i2++) {
                        this.a.write("  ");
                    }
                }
                this.a.write("</");
                String str3 = this.e[(this.d * 3) + 1];
                if (!"".equals(str3)) {
                    this.a.write(str3);
                    this.a.write(58);
                }
                this.a.write(str2);
                this.a.write(62);
            }
            int[] iArr = this.f;
            int i3 = this.d;
            iArr[i3 + 1] = iArr[i3];
            return this;
        }
        throw new IllegalArgumentException("</{" + str + "}" + str2 + "> does not match start");
    }

    public String c() {
        if (b() == 0) {
            return null;
        }
        return this.e[(b() * 3) - 3];
    }

    public void c(String str) {
        this.a.write("<!DOCTYPE");
        this.a.write(str);
        this.a.write(">");
    }

    public void d(String str) {
        a(false);
        this.a.write("<!--");
        this.a.write(str);
        this.a.write("-->");
    }

    public void e(String str) {
        a(false);
        this.a.write("<![CDATA[");
        this.a.write(str);
        this.a.write("]]>");
    }

    public void f(String str) {
        b(str);
    }

    public void g(String str) {
        a(false);
        this.a.write(38);
        this.a.write(str);
        this.a.write(59);
    }
}
