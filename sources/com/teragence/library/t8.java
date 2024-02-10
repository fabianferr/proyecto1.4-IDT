package com.teragence.library;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.internal.security.CertificateUtil;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.Typography;

public class t8 implements x8 {
    private int[] A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private Object b;
    private boolean c;
    private boolean d;
    private Hashtable e;
    private int f;
    private String[] g = new String[16];
    private String[] h = new String[8];
    private int[] i = new int[4];
    private Reader j;
    private char[] k;
    private int l;
    private int m;
    private int n;
    private int o;
    private char[] p;
    private int q;
    private int r;
    private boolean s;
    private String t;
    private String u;
    private String v;
    private boolean w;
    private int x;
    private String[] y;
    private String z;

    public t8() {
        int i2 = 128;
        this.p = new char[128];
        this.y = new String[16];
        this.A = new int[2];
        this.k = new char[(Runtime.getRuntime().freeMemory() >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? 8192 : i2)];
    }

    private final void a(char c2) {
        int t2 = t();
        if (t2 != c2) {
            b("expected: '" + c2 + "' actual: '" + ((char) t2) + "'");
        }
    }

    private final void a(int i2, boolean z2) {
        int i3 = i(0);
        int i4 = 0;
        while (i3 != -1 && i3 != i2) {
            int i5 = 32;
            if (i2 != 32 || (i3 > 32 && i3 != 62)) {
                if (i3 != 38) {
                    if (i3 == 10 && this.r == 2) {
                        t();
                    } else {
                        i5 = t();
                    }
                    j(i5);
                } else if (z2) {
                    s();
                } else {
                    return;
                }
                if (i3 == 62 && i4 >= 2 && i2 != 93) {
                    b("Illegal: ]]>");
                }
                i4 = i3 == 93 ? i4 + 1 : 0;
                i3 = i(0);
            } else {
                return;
            }
        }
    }

    private final void a(boolean z2) {
        int i2 = 1;
        boolean z3 = false;
        while (true) {
            int t2 = t();
            if (t2 != -1) {
                if (t2 == 39) {
                    z3 = !z3;
                } else if (t2 != 60) {
                    if (t2 == 62 && !z3 && i2 - 1 == 0) {
                        return;
                    }
                } else if (!z3) {
                    i2++;
                }
                if (z2) {
                    j(t2);
                }
            } else {
                b("Unexpected EOF");
                return;
            }
        }
    }

    private final boolean a(String str, boolean z2, String str2) {
        if (!str.startsWith("http://xmlpull.org/v1/doc/")) {
            return false;
        }
        return str.substring(z2 ? 42 : 40).equals(str2);
    }

    private final String[] a(String[] strArr, int i2) {
        if (strArr.length >= i2) {
            return strArr;
        }
        String[] strArr2 = new String[(i2 + 16)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final int b(boolean z2) {
        String str;
        int i2;
        int i3;
        String str2;
        t();
        int t2 = t();
        if (t2 == 63) {
            if ((i(0) == 120 || i(0) == 88) && (i(1) == 109 || i(1) == 77)) {
                if (z2) {
                    j(i(0));
                    j(i(1));
                }
                t();
                t();
                if ((i(0) == 108 || i(0) == 76) && i(1) <= 32) {
                    if (this.n != 1 || this.o > 4) {
                        b("PI must not start with xml");
                    }
                    c(true);
                    int i4 = 2;
                    if (this.x < 1 || !"version".equals(this.y[2])) {
                        b("version expected");
                    }
                    String[] strArr = this.y;
                    String str3 = strArr[3];
                    if (1 >= this.x || !"encoding".equals(strArr[6])) {
                        i4 = 1;
                    } else {
                        String str4 = this.y[7];
                    }
                    if (i4 < this.x) {
                        int i5 = i4 * 4;
                        if ("standalone".equals(this.y[i5 + 2])) {
                            String str5 = this.y[i5 + 3];
                            if ("yes".equals(str5)) {
                                new Boolean(true);
                            } else if ("no".equals(str5)) {
                                new Boolean(false);
                            } else {
                                b("illegal standalone value: " + str5);
                            }
                            i4++;
                        }
                    }
                    if (i4 != this.x) {
                        b("illegal xmldecl");
                    }
                    this.s = true;
                    this.q = 0;
                    return 998;
                }
            }
            str2 = "";
            i3 = 63;
            i2 = 8;
        } else if (t2 != 33) {
            str = "illegal: <" + t2;
            b(str);
            return 9;
        } else if (i(0) == 45) {
            str2 = "--";
            i3 = 45;
            i2 = 9;
        } else if (i(0) == 91) {
            str2 = "[CDATA[";
            z2 = true;
            i3 = 93;
            i2 = 5;
        } else {
            str2 = "DOCTYPE";
            i3 = -1;
            i2 = 10;
        }
        for (int i6 = 0; i6 < str2.length(); i6++) {
            a(str2.charAt(i6));
        }
        if (i2 == 10) {
            a(z2);
        } else {
            int i7 = 0;
            while (true) {
                int t3 = t();
                if (t3 == -1) {
                    str = "Unexpected EOF";
                    break;
                }
                if (z2) {
                    j(t3);
                }
                if ((i3 == 63 || t3 == i3) && i(0) == i3 && i(1) == 62) {
                    if (i3 == 45 && i7 == 45 && !this.d) {
                        b("illegal comment delimiter: --->");
                    }
                    t();
                    t();
                    if (z2 && i3 != 63) {
                        this.q--;
                    }
                } else {
                    i7 = t3;
                }
            }
            b(str);
            return 9;
        }
        return i2;
    }

    private final void b(String str) {
        if (!this.d) {
            c(str);
            throw null;
        } else if (this.z == null) {
            this.z = "ERR: " + str;
        }
    }

    private final void c(String str) {
        if (str.length() >= 100) {
            str = str.substring(0, 100) + "\n";
        }
        throw new y8(str, this, (Throwable) null);
    }

    private final void c(boolean z2) {
        if (!z2) {
            t();
        }
        this.v = u();
        this.x = 0;
        while (true) {
            v();
            int i2 = i(0);
            if (!z2) {
                if (i2 != 47) {
                    if (i2 == 62 && !z2) {
                        t();
                        break;
                    }
                } else {
                    this.w = true;
                    t();
                    v();
                    a((char) Typography.greater);
                    break;
                }
            } else if (i2 == 63) {
                t();
                a((char) Typography.greater);
                return;
            }
            if (i2 == -1) {
                b("Unexpected EOF");
                return;
            }
            String u2 = u();
            if (u2.length() == 0) {
                b("attr name expected");
                break;
            }
            int i3 = this.x;
            this.x = i3 + 1;
            int i4 = i3 << 2;
            String[] a = a(this.y, i4 + 4);
            this.y = a;
            int i5 = i4 + 1;
            a[i4] = "";
            int i6 = i5 + 1;
            a[i5] = null;
            int i7 = i6 + 1;
            a[i6] = u2;
            v();
            if (i(0) != 61) {
                if (!this.d) {
                    b("Attr.value missing f. " + u2);
                }
                this.y[i7] = u2;
            } else {
                a('=');
                v();
                int i8 = i(0);
                if (i8 == 39 || i8 == 34) {
                    t();
                } else {
                    if (!this.d) {
                        b("attr value delimiter missing!");
                    }
                    i8 = 32;
                }
                int i9 = this.q;
                a(i8, true);
                this.y[i7] = h(i9);
                this.q = i9;
                if (i8 != 32) {
                    t();
                }
            }
        }
        int i10 = this.f;
        this.f = i10 + 1;
        int i11 = i10 << 2;
        String[] a2 = a(this.g, i11 + 4);
        this.g = a2;
        a2[i11 + 3] = this.v;
        int i12 = this.f;
        int[] iArr = this.i;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[(i12 + 4)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.i = iArr2;
        }
        int[] iArr3 = this.i;
        int i13 = this.f;
        iArr3[i13] = iArr3[i13 - 1];
        if (this.c) {
            o();
        } else {
            this.t = "";
        }
        String[] strArr = this.g;
        strArr[i11] = this.t;
        strArr[i11 + 1] = this.u;
        strArr[i11 + 2] = this.v;
    }

    private final String h(int i2) {
        return new String(this.p, i2, this.q - i2);
    }

    private final int i(int i2) {
        int i3;
        while (i2 >= this.B) {
            char[] cArr = this.k;
            if (cArr.length <= 1) {
                i3 = this.j.read();
            } else {
                int i4 = this.l;
                if (i4 < this.m) {
                    this.l = i4 + 1;
                    i3 = cArr[i4];
                } else {
                    int read = this.j.read(cArr, 0, cArr.length);
                    this.m = read;
                    char c2 = read <= 0 ? 65535 : this.k[0];
                    this.l = 1;
                    i3 = c2;
                }
            }
            if (i3 == 13) {
                this.C = true;
                int[] iArr = this.A;
                int i5 = this.B;
                this.B = i5 + 1;
                iArr[i5] = 10;
            } else {
                if (i3 != 10) {
                    int[] iArr2 = this.A;
                    int i6 = this.B;
                    this.B = i6 + 1;
                    iArr2[i6] = i3;
                } else if (!this.C) {
                    int[] iArr3 = this.A;
                    int i7 = this.B;
                    this.B = i7 + 1;
                    iArr3[i7] = 10;
                }
                this.C = false;
            }
        }
        return this.A[i2];
    }

    private final void j(int i2) {
        this.s &= i2 <= 32;
        int i3 = this.q;
        char[] cArr = this.p;
        if (i3 == cArr.length) {
            char[] cArr2 = new char[(((i3 * 4) / 3) + 4)];
            System.arraycopy(cArr, 0, cArr2, 0, i3);
            this.p = cArr2;
        }
        char[] cArr3 = this.p;
        int i4 = this.q;
        this.q = i4 + 1;
        cArr3[i4] = (char) i2;
    }

    private final boolean o() {
        int i2;
        String str;
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            i2 = this.x << 2;
            if (i3 >= i2) {
                break;
            }
            String str2 = this.y[i3 + 2];
            int indexOf = str2.indexOf(58);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                str = str2.substring(indexOf + 1);
                str2 = substring;
            } else if (str2.equals("xmlns")) {
                str = null;
            } else {
                i3 += 4;
            }
            if (!str2.equals("xmlns")) {
                z2 = true;
            } else {
                int[] iArr = this.i;
                int i4 = this.f;
                int i5 = iArr[i4];
                iArr[i4] = i5 + 1;
                int i6 = i5 << 1;
                String[] a = a(this.h, i6 + 2);
                this.h = a;
                a[i6] = str;
                String[] strArr = this.y;
                int i7 = i3 + 3;
                a[i6 + 1] = strArr[i7];
                if (str != null && strArr[i7].equals("")) {
                    b("illegal empty namespace");
                }
                String[] strArr2 = this.y;
                int i8 = this.x - 1;
                this.x = i8;
                System.arraycopy(strArr2, i3 + 4, strArr2, i3, (i8 << 2) - i3);
                i3 -= 4;
            }
            i3 += 4;
        }
        if (z2) {
            int i9 = i2 - 4;
            while (i9 >= 0) {
                int i10 = i9 + 2;
                String str3 = this.y[i10];
                int indexOf2 = str3.indexOf(58);
                if (indexOf2 != 0 || this.d) {
                    if (indexOf2 != -1) {
                        String substring2 = str3.substring(0, indexOf2);
                        String substring3 = str3.substring(indexOf2 + 1);
                        String a2 = a(substring2);
                        if (a2 != null || this.d) {
                            String[] strArr3 = this.y;
                            strArr3[i9] = a2;
                            strArr3[i9 + 1] = substring2;
                            strArr3[i10] = substring3;
                        } else {
                            throw new RuntimeException("Undefined Prefix: " + substring2 + " in " + this);
                        }
                    }
                    i9 -= 4;
                } else {
                    throw new RuntimeException("illegal attribute name: " + str3 + " at " + this);
                }
            }
        }
        int indexOf3 = this.v.indexOf(58);
        if (indexOf3 == 0) {
            b("illegal tag name: " + this.v);
        }
        if (indexOf3 != -1) {
            this.u = this.v.substring(0, indexOf3);
            this.v = this.v.substring(indexOf3 + 1);
        }
        String a3 = a(this.u);
        this.t = a3;
        if (a3 == null) {
            if (this.u != null) {
                b("undefined prefix: " + this.u);
            }
            this.t = "";
        }
        return z2;
    }

    private final void p() {
        int b2;
        if (this.j != null) {
            if (this.r == 3) {
                this.f--;
            }
            do {
                this.x = -1;
                if (this.w) {
                    this.w = false;
                    this.r = 3;
                    return;
                } else if (this.z != null) {
                    for (int i2 = 0; i2 < this.z.length(); i2++) {
                        j(this.z.charAt(i2));
                    }
                    this.z = null;
                    this.r = 9;
                    return;
                } else {
                    this.u = null;
                    this.v = null;
                    this.t = null;
                    int r2 = r();
                    this.r = r2;
                    if (r2 == 1) {
                        return;
                    }
                    if (r2 == 2) {
                        c(false);
                        return;
                    } else if (r2 == 3) {
                        q();
                        return;
                    } else if (r2 == 4) {
                        a(60, !this.E);
                        if (this.f == 0 && this.s) {
                            this.r = 7;
                            return;
                        }
                        return;
                    } else if (r2 != 6) {
                        b2 = b(this.E);
                        this.r = b2;
                    } else {
                        s();
                        return;
                    }
                }
            } while (b2 == 998);
            return;
        }
        c("No Input specified");
        throw null;
    }

    private final void q() {
        t();
        t();
        this.v = u();
        v();
        a((char) Typography.greater);
        int i2 = this.f;
        int i3 = (i2 - 1) << 2;
        if (i2 == 0) {
            b("element stack empty");
            this.r = 9;
        } else if (!this.d) {
            int i4 = i3 + 3;
            if (!this.v.equals(this.g[i4])) {
                b("expected: /" + this.g[i4] + " read: " + this.v);
            }
            String[] strArr = this.g;
            this.t = strArr[i3];
            this.u = strArr[i3 + 1];
            this.v = strArr[i3 + 2];
        }
    }

    private final int r() {
        int i2 = i(0);
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 38) {
            return 6;
        }
        if (i2 != 60) {
            return 4;
        }
        int i3 = i(1);
        if (i3 == 33) {
            return 999;
        }
        if (i3 != 47) {
            return i3 != 63 ? 2 : 999;
        }
        return 3;
    }

    private final void s() {
        j(t());
        int i2 = this.q;
        while (true) {
            int i3 = i(0);
            boolean z2 = true;
            if (i3 == 59) {
                t();
                String h2 = h(i2);
                this.q = i2 - 1;
                if (this.E && this.r == 6) {
                    this.v = h2;
                }
                if (h2.charAt(0) == '#') {
                    j(h2.charAt(1) == 'x' ? Integer.parseInt(h2.substring(2), 16) : Integer.parseInt(h2.substring(1)));
                    return;
                }
                String str = (String) this.e.get(h2);
                if (str != null) {
                    z2 = false;
                }
                this.D = z2;
                if (!z2) {
                    for (int i4 = 0; i4 < str.length(); i4++) {
                        j(str.charAt(i4));
                    }
                    return;
                } else if (!this.E) {
                    b("unresolved: &" + h2 + ";");
                    return;
                } else {
                    return;
                }
            } else if (i3 >= 128 || ((i3 >= 48 && i3 <= 57) || ((i3 >= 97 && i3 <= 122) || ((i3 >= 65 && i3 <= 90) || i3 == 95 || i3 == 45 || i3 == 35)))) {
                j(t());
            } else {
                if (!this.d) {
                    b("unterminated entity ref");
                }
                PrintStream printStream = System.out;
                printStream.println("broken entitiy: " + h(i2 - 1));
                return;
            }
        }
    }

    private final int t() {
        int i2;
        if (this.B == 0) {
            i2 = i(0);
        } else {
            int[] iArr = this.A;
            int i3 = iArr[0];
            iArr[0] = iArr[1];
            i2 = i3;
        }
        this.B--;
        this.o++;
        if (i2 == 10) {
            this.n++;
            this.o = 1;
        }
        return i2;
    }

    private final String u() {
        int i2 = this.q;
        int i3 = i(0);
        if ((i3 < 97 || i3 > 122) && ((i3 < 65 || i3 > 90) && i3 != 95 && i3 != 58 && i3 < 192 && !this.d)) {
            b("name expected");
        }
        while (true) {
            j(t());
            int i4 = i(0);
            if ((i4 < 97 || i4 > 122) && ((i4 < 65 || i4 > 90) && !((i4 >= 48 && i4 <= 57) || i4 == 95 || i4 == 45 || i4 == 58 || i4 == 46 || i4 >= 183))) {
                String h2 = h(i2);
                this.q = i2;
                return h2;
            }
        }
    }

    private final void v() {
        while (true) {
            int i2 = i(0);
            if (i2 <= 32 && i2 != -1) {
                t();
            } else {
                return;
            }
        }
    }

    public int a() {
        return this.x;
    }

    public String a(int i2) {
        return this.h[(i2 << 1) + 1];
    }

    public String a(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int c2 = (c(this.f) << 1) - 2; c2 >= 0; c2 -= 2) {
            String[] strArr = this.h;
            if (str == null) {
                if (strArr[c2] == null) {
                    return strArr[c2 + 1];
                }
            } else if (str.equals(strArr[c2])) {
                return this.h[c2 + 1];
            }
        }
        return null;
    }

    public String a(String str, String str2) {
        for (int i2 = (this.x << 2) - 4; i2 >= 0; i2 -= 4) {
            if (this.y[i2 + 2].equals(str2) && (str == null || this.y[i2].equals(str))) {
                return this.y[i2 + 3];
            }
        }
        return null;
    }

    public void a(int i2, String str, String str2) {
        if (i2 != this.r || ((str != null && !str.equals(k())) || (str2 != null && !str2.equals(n())))) {
            c("expected: " + x8.a[i2] + " {" + str + "}" + str2);
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3 = r14.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r3 != -1) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r7 = r13.k;
        r8 = r13.m;
        r10 = r8 + 1;
        r13.m = r10;
        r7[r8] = (char) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r3 != 62) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r3 = new java.lang.String(r7, 0, r10);
        r7 = r3.indexOf("encoding");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r7 == -1) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r3.charAt(r7) == '\"') goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r3.charAt(r7) == '\'') goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0076, code lost:
        r15 = r7 + 1;
        r15 = r3.substring(r15, r3.indexOf(r3.charAt(r7), r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        r13.m = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        r13.m = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        r3 = -65536 & r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00af, code lost:
        if (r3 != -16842752) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
        r15 = r13.k;
        r15[0] = (char) ((r15[2] << 8) | r15[3]);
        r15 = org.apache.commons.codec.CharEncoding.UTF_16BE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c1, code lost:
        if (r3 != -131072) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c3, code lost:
        r15 = r13.k;
        r15[0] = (char) ((r15[3] << 8) | r15[2]);
        r15 = "UTF-16LE";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d6, code lost:
        if ((r2 & androidx.core.view.InputDeviceCompat.SOURCE_ANY) != -272908544) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d8, code lost:
        r15 = r13.k;
        r15[0] = r15[3];
        r15 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00df, code lost:
        r13.m = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.io.InputStream r14, java.lang.String r15) {
        /*
            r13 = this;
            r0 = 0
            r13.l = r0
            r13.m = r0
            if (r14 == 0) goto L_0x010b
            java.lang.String r1 = "UTF-8"
            if (r15 != 0) goto L_0x00e1
            r2 = 0
        L_0x000c:
            int r3 = r13.m     // Catch:{ Exception -> 0x00f2 }
            r4 = 4
            r5 = -1
            if (r3 >= r4) goto L_0x0028
            int r3 = r14.read()     // Catch:{ Exception -> 0x00f2 }
            if (r3 != r5) goto L_0x0019
            goto L_0x0028
        L_0x0019:
            int r2 = r2 << 8
            r2 = r2 | r3
            char[] r4 = r13.k     // Catch:{ Exception -> 0x00f2 }
            int r5 = r13.m     // Catch:{ Exception -> 0x00f2 }
            int r6 = r5 + 1
            r13.m = r6     // Catch:{ Exception -> 0x00f2 }
            char r3 = (char) r3     // Catch:{ Exception -> 0x00f2 }
            r4[r5] = r3     // Catch:{ Exception -> 0x00f2 }
            goto L_0x000c
        L_0x0028:
            int r3 = r13.m     // Catch:{ Exception -> 0x00f2 }
            if (r3 != r4) goto L_0x00e1
            r3 = 63
            java.lang.String r4 = "UTF-16LE"
            java.lang.String r6 = "UTF-16BE"
            java.lang.String r7 = "UTF-32BE"
            java.lang.String r8 = "UTF-32LE"
            r9 = 2
            r10 = 60
            r11 = 1
            switch(r2) {
                case -131072: goto L_0x00a5;
                case 60: goto L_0x009f;
                case 65279: goto L_0x009d;
                case 3932223: goto L_0x0093;
                case 1006632960: goto L_0x008d;
                case 1006649088: goto L_0x0085;
                case 1010792557: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x00a9
        L_0x003f:
            int r3 = r14.read()     // Catch:{ Exception -> 0x00f2 }
            if (r3 != r5) goto L_0x0047
            goto L_0x00a9
        L_0x0047:
            char[] r7 = r13.k     // Catch:{ Exception -> 0x00f2 }
            int r8 = r13.m     // Catch:{ Exception -> 0x00f2 }
            int r10 = r8 + 1
            r13.m = r10     // Catch:{ Exception -> 0x00f2 }
            char r12 = (char) r3     // Catch:{ Exception -> 0x00f2 }
            r7[r8] = r12     // Catch:{ Exception -> 0x00f2 }
            r8 = 62
            if (r3 != r8) goto L_0x003f
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x00f2 }
            r3.<init>(r7, r0, r10)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r7 = "encoding"
            int r7 = r3.indexOf(r7)     // Catch:{ Exception -> 0x00f2 }
            if (r7 == r5) goto L_0x00a9
        L_0x0063:
            char r15 = r3.charAt(r7)     // Catch:{ Exception -> 0x00f2 }
            r5 = 34
            if (r15 == r5) goto L_0x0076
            char r15 = r3.charAt(r7)     // Catch:{ Exception -> 0x00f2 }
            r5 = 39
            if (r15 == r5) goto L_0x0076
            int r7 = r7 + 1
            goto L_0x0063
        L_0x0076:
            int r15 = r7 + 1
            char r5 = r3.charAt(r7)     // Catch:{ Exception -> 0x00f2 }
            int r5 = r3.indexOf(r5, r15)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r15 = r3.substring(r15, r5)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00a9
        L_0x0085:
            char[] r15 = r13.k     // Catch:{ Exception -> 0x00f2 }
            r15[r0] = r10     // Catch:{ Exception -> 0x00f2 }
            r15[r11] = r3     // Catch:{ Exception -> 0x00f2 }
            r15 = r4
            goto L_0x009a
        L_0x008d:
            char[] r15 = r13.k     // Catch:{ Exception -> 0x00f2 }
            r15[r0] = r10     // Catch:{ Exception -> 0x00f2 }
            r15 = r8
            goto L_0x00df
        L_0x0093:
            char[] r15 = r13.k     // Catch:{ Exception -> 0x00f2 }
            r15[r0] = r10     // Catch:{ Exception -> 0x00f2 }
            r15[r11] = r3     // Catch:{ Exception -> 0x00f2 }
            r15 = r6
        L_0x009a:
            r13.m = r9     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00e1
        L_0x009d:
            r15 = r7
            goto L_0x00a6
        L_0x009f:
            char[] r15 = r13.k     // Catch:{ Exception -> 0x00f2 }
            r15[r0] = r10     // Catch:{ Exception -> 0x00f2 }
            r15 = r7
            goto L_0x00df
        L_0x00a5:
            r15 = r8
        L_0x00a6:
            r13.m = r0     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00e1
        L_0x00a9:
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r3 = r3 & r2
            r5 = -16842752(0xfffffffffeff0000, float:-1.6947657E38)
            r7 = 3
            if (r3 != r5) goto L_0x00bf
            char[] r15 = r13.k     // Catch:{ Exception -> 0x00f2 }
            char r2 = r15[r9]     // Catch:{ Exception -> 0x00f2 }
            int r2 = r2 << 8
            char r3 = r15[r7]     // Catch:{ Exception -> 0x00f2 }
            r2 = r2 | r3
            char r2 = (char) r2     // Catch:{ Exception -> 0x00f2 }
            r15[r0] = r2     // Catch:{ Exception -> 0x00f2 }
            r15 = r6
            goto L_0x00df
        L_0x00bf:
            r5 = -131072(0xfffffffffffe0000, float:NaN)
            if (r3 != r5) goto L_0x00d1
            char[] r15 = r13.k     // Catch:{ Exception -> 0x00f2 }
            char r2 = r15[r7]     // Catch:{ Exception -> 0x00f2 }
            int r2 = r2 << 8
            char r3 = r15[r9]     // Catch:{ Exception -> 0x00f2 }
            r2 = r2 | r3
            char r2 = (char) r2     // Catch:{ Exception -> 0x00f2 }
            r15[r0] = r2     // Catch:{ Exception -> 0x00f2 }
            r15 = r4
            goto L_0x00df
        L_0x00d1:
            r2 = r2 & -256(0xffffffffffffff00, float:NaN)
            r3 = -272908544(0xffffffffefbbbf00, float:-1.162092E29)
            if (r2 != r3) goto L_0x00e1
            char[] r15 = r13.k     // Catch:{ Exception -> 0x00f2 }
            char r2 = r15[r7]     // Catch:{ Exception -> 0x00f2 }
            r15[r0] = r2     // Catch:{ Exception -> 0x00f2 }
            r15 = r1
        L_0x00df:
            r13.m = r11     // Catch:{ Exception -> 0x00f2 }
        L_0x00e1:
            if (r15 != 0) goto L_0x00e4
            goto L_0x00e5
        L_0x00e4:
            r1 = r15
        L_0x00e5:
            int r15 = r13.m     // Catch:{ Exception -> 0x00f2 }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00f2 }
            r0.<init>(r14, r1)     // Catch:{ Exception -> 0x00f2 }
            r13.a((java.io.Reader) r0)     // Catch:{ Exception -> 0x00f2 }
            r13.m = r15     // Catch:{ Exception -> 0x00f2 }
            return
        L_0x00f2:
            r14 = move-exception
            com.teragence.library.y8 r15 = new com.teragence.library.y8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid stream or encoding: "
            r0.<init>(r1)
            java.lang.String r1 = r14.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0, r13, r14)
            throw r15
        L_0x010b:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            r14.<init>()
            goto L_0x0112
        L_0x0111:
            throw r14
        L_0x0112:
            goto L_0x0111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.t8.a(java.io.InputStream, java.lang.String):void");
    }

    public void a(Reader reader) {
        this.j = reader;
        this.n = 1;
        this.o = 0;
        this.r = 0;
        this.v = null;
        this.t = null;
        this.w = false;
        this.x = -1;
        if (reader != null) {
            this.l = 0;
            this.m = 0;
            this.B = 0;
            this.f = 0;
            Hashtable hashtable = new Hashtable();
            this.e = hashtable;
            hashtable.put("amp", "&");
            this.e.put("apos", "'");
            this.e.put("gt", ">");
            this.e.put("lt", "<");
            this.e.put("quot", "\"");
        }
    }

    public void a(String str, boolean z2) {
        if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(str)) {
            this.c = z2;
        } else if (a(str, false, "relaxed")) {
            this.d = z2;
        } else {
            c("unsupported feature: " + str);
            throw null;
        }
    }

    public int b() {
        return this.o;
    }

    public String b(int i2) {
        if (i2 < this.x) {
            return this.y[(i2 << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public int c() {
        return this.f;
    }

    public int c(int i2) {
        if (i2 <= this.f) {
            return this.i[i2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String d() {
        String str;
        if (this.r == 2) {
            h();
            if (this.r == 4) {
                str = j();
                h();
            } else {
                str = "";
            }
            if (this.r == 3) {
                return str;
            }
            c("END_TAG expected");
            throw null;
        }
        c("precondition: START_TAG");
        throw null;
    }

    public String d(int i2) {
        return this.h[i2 << 1];
    }

    public int e() {
        this.s = true;
        this.q = 0;
        this.E = true;
        p();
        return this.r;
    }

    public String e(int i2) {
        return "CDATA";
    }

    public String f() {
        String j2;
        int i2 = this.r;
        String[] strArr = x8.a;
        StringBuffer stringBuffer = new StringBuffer(i2 < strArr.length ? strArr[i2] : "unknown");
        stringBuffer.append(' ');
        int i3 = this.r;
        if (i3 == 2 || i3 == 3) {
            if (this.w) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append(Typography.less);
            if (this.r == 3) {
                stringBuffer.append('/');
            }
            if (this.u != null) {
                stringBuffer.append("{" + this.t + "}" + this.u + CertificateUtil.DELIMITER);
            }
            stringBuffer.append(this.v);
            int i4 = this.x << 2;
            for (int i5 = 0; i5 < i4; i5 += 4) {
                stringBuffer.append(' ');
                int i6 = i5 + 1;
                if (this.y[i6] != null) {
                    stringBuffer.append("{" + this.y[i5] + "}" + this.y[i6] + CertificateUtil.DELIMITER);
                }
                stringBuffer.append(this.y[i5 + 2] + "='" + this.y[i5 + 3] + "'");
            }
            stringBuffer.append(Typography.greater);
        } else if (i3 != 7) {
            if (i3 != 4) {
                j2 = j();
            } else if (this.s) {
                j2 = "(whitespace)";
            } else {
                j2 = j();
                if (j2.length() > 16) {
                    j2 = j2.substring(0, 16) + "...";
                }
            }
            stringBuffer.append(j2);
        }
        stringBuffer.append("@" + this.n + CertificateUtil.DELIMITER + this.o);
        if (this.b != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.b);
        } else if (this.j != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.j.toString());
        }
        return stringBuffer.toString();
    }

    public String f(int i2) {
        if (i2 < this.x) {
            return this.y[(i2 << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    public String g(int i2) {
        if (i2 < this.x) {
            return this.y[i2 << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean g() {
        if (this.r == 2) {
            return this.w;
        }
        c("Wrong event type");
        throw null;
    }

    public int h() {
        this.q = 0;
        this.s = true;
        this.E = false;
        int i2 = 9999;
        while (true) {
            p();
            int i3 = this.r;
            if (i3 < i2) {
                i2 = i3;
            }
            if (i2 > 6 || (i2 >= 4 && r() >= 4)) {
            }
        }
        this.r = i2;
        if (i2 > 4) {
            this.r = 4;
        }
        return this.r;
    }

    public int i() {
        h();
        if (this.r == 4 && this.s) {
            h();
        }
        int i2 = this.r;
        if (i2 == 3 || i2 == 2) {
            return i2;
        }
        c("unexpected type");
        throw null;
    }

    public String j() {
        int i2 = this.r;
        if (i2 < 4 || (i2 == 6 && this.D)) {
            return null;
        }
        return h(0);
    }

    public String k() {
        return this.t;
    }

    public int l() {
        return this.r;
    }

    public int m() {
        return this.n;
    }

    public String n() {
        return this.v;
    }
}
