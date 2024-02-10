package com.bykv.vk.openvk.preload.a.d;

import com.bykv.vk.openvk.preload.a.b.a.e;
import com.bykv.vk.openvk.preload.a.b.f;
import com.bykv.vk.openvk.preload.a.p;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.internal._BufferKt;

/* compiled from: JsonReader */
public class a implements Closeable {
    public boolean a = false;
    int b = 0;
    private final Reader c;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private long i;
    private int j;
    private String k;
    private int[] l;
    private int m;
    private String[] n;
    private int[] o;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        this.m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        this.c = reader;
    }

    public void a() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 3) {
            a(1);
            this.o[this.m - 1] = 0;
            this.b = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + r());
    }

    public void b() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 4) {
            int i3 = this.m - 1;
            this.m = i3;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.b = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + r());
    }

    public void c() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 1) {
            a(3);
            this.b = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + r());
    }

    public void d() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 2) {
            int i3 = this.m - 1;
            this.m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.b = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + r());
    }

    public boolean e() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public b f() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public final int q() throws IOException {
        int a2;
        int[] iArr = this.l;
        int i2 = this.m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int a3 = a(true);
            if (a3 != 44) {
                if (a3 == 59) {
                    u();
                } else if (a3 == 93) {
                    this.b = 4;
                    return 4;
                } else {
                    throw b("Unterminated array");
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5 && (a2 = a(true)) != 44) {
                if (a2 == 59) {
                    u();
                } else if (a2 == 125) {
                    this.b = 2;
                    return 2;
                } else {
                    throw b("Unterminated object");
                }
            }
            int a4 = a(true);
            if (a4 == 34) {
                this.b = 13;
                return 13;
            } else if (a4 == 39) {
                u();
                this.b = 12;
                return 12;
            } else if (a4 != 125) {
                u();
                this.e--;
                if (a((char) a4)) {
                    this.b = 14;
                    return 14;
                }
                throw b("Expected name");
            } else if (i3 != 5) {
                this.b = 2;
                return 2;
            } else {
                throw b("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int a5 = a(true);
            if (a5 != 58) {
                if (a5 == 61) {
                    u();
                    if (this.e < this.f || b(1)) {
                        char[] cArr = this.d;
                        int i4 = this.e;
                        if (cArr[i4] == '>') {
                            this.e = i4 + 1;
                        }
                    }
                } else {
                    throw b("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.a) {
                x();
            }
            this.l[this.m - 1] = 7;
        } else if (i3 == 7) {
            if (a(false) == -1) {
                this.b = 17;
                return 17;
            }
            u();
            this.e--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int a6 = a(true);
        if (a6 == 34) {
            this.b = 9;
            return 9;
        } else if (a6 != 39) {
            if (!(a6 == 44 || a6 == 59)) {
                if (a6 == 91) {
                    this.b = 3;
                    return 3;
                } else if (a6 != 93) {
                    if (a6 != 123) {
                        this.e--;
                        int g2 = g();
                        if (g2 != 0) {
                            return g2;
                        }
                        int s = s();
                        if (s != 0) {
                            return s;
                        }
                        if (a(this.d[this.e])) {
                            u();
                            this.b = 10;
                            return 10;
                        }
                        throw b("Expected value");
                    }
                    this.b = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.b = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                u();
                this.e--;
                this.b = 7;
                return 7;
            }
            throw b("Unexpected value");
        } else {
            u();
            this.b = 8;
            return 8;
        }
    }

    private int g() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.d[this.e];
        if (c2 == 't' || c2 == 'T') {
            str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str = "TRUE";
            i2 = 5;
        } else if (c2 == 'f' || c2 == 'F') {
            str2 = "false";
            str = "FALSE";
            i2 = 6;
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            str2 = AbstractJsonLexerKt.NULL;
            str = "NULL";
            i2 = 7;
        }
        int length = str2.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.e + i3 >= this.f && !b(i3 + 1)) {
                return 0;
            }
            char c3 = this.d[this.e + i3];
            if (c3 != str2.charAt(i3) && c3 != str.charAt(i3)) {
                return 0;
            }
        }
        if ((this.e + length < this.f || b(length + 1)) && a(this.d[this.e + length])) {
            return 0;
        }
        this.e += length;
        this.b = i2;
        return i2;
    }

    private int s() throws IOException {
        char c2;
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = this.f;
        int i4 = 0;
        int i5 = 0;
        char c3 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i3) {
                if (i5 != cArr.length) {
                    if (!b(i5 + 1)) {
                        break;
                    }
                    i2 = this.e;
                    i3 = this.f;
                } else {
                    return i4;
                }
            }
            c2 = cArr[i2 + i5];
            if (c2 == '+') {
                i4 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i4 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i5++;
            } else {
                if (c2 == '-') {
                    i4 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z2 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i4 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 >= '0' && c2 <= '9') {
                    if (c3 == 1 || c3 == 0) {
                        j2 = (long) (-(c2 - '0'));
                        i4 = 0;
                        c3 = 2;
                    } else {
                        if (c3 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                            z &= j2 > _BufferKt.OVERFLOW_ZONE || (j2 == _BufferKt.OVERFLOW_ZONE && j3 < j2);
                            j2 = j3;
                        } else if (c3 == 3) {
                            i4 = 0;
                            c3 = 4;
                        } else if (c3 == 5 || c3 == 6) {
                            i4 = 0;
                            c3 = 7;
                        }
                        i4 = 0;
                    }
                }
                i5++;
            }
            c3 = 6;
            i5++;
        }
        if (a(c2)) {
            return 0;
        }
        if (c3 == 2 && z && ((j2 != Long.MIN_VALUE || z2) && (j2 != 0 || !z2))) {
            if (!z2) {
                j2 = -j2;
            }
            this.i = j2;
            this.e += i5;
            this.b = 15;
            return 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.j = i5;
            this.b = 16;
            return 16;
        }
    }

    private boolean a(char c2) throws IOException {
        if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        u();
        return false;
    }

    public String h() throws IOException {
        String str;
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 14) {
            str = t();
        } else if (i2 == 12) {
            str = b('\'');
        } else if (i2 == 13) {
            str = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + r());
        }
        this.b = 0;
        this.n[this.m - 1] = str;
        return str;
    }

    public String i() throws IOException {
        String str;
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 10) {
            str = t();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b('\"');
        } else if (i2 == 11) {
            str = this.k;
            this.k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.i);
        } else if (i2 == 16) {
            str = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + r());
        }
        this.b = 0;
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public boolean j() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 5) {
            this.b = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.b = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + r());
        }
    }

    public void k() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 7) {
            this.b = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + r());
    }

    public double l() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 15) {
            this.b = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.i;
        }
        if (i2 == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i2 == 8 || i2 == 9) {
            this.k = b(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.k = t();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + r());
        }
        this.b = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (this.a || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.k = null;
            this.b = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + r());
    }

    public long m() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 15) {
            this.b = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.i;
        }
        if (i2 == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = t();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.b = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + r());
        }
        this.b = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.k = null;
            this.b = 0;
            int[] iArr3 = this.o;
            int i5 = this.m - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.k + r());
    }

    private String b(char c2) throws IOException {
        char[] cArr = this.d;
        StringBuilder sb = null;
        while (true) {
            int i2 = this.e;
            int i3 = this.f;
            int i4 = i2;
            while (true) {
                if (i4 < i3) {
                    int i5 = i4 + 1;
                    char c3 = cArr[i4];
                    if (c3 == c2) {
                        this.e = i5;
                        int i6 = (i5 - i2) - 1;
                        if (sb == null) {
                            return new String(cArr, i2, i6);
                        }
                        sb.append(cArr, i2, i6);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.e = i5;
                        int i7 = (i5 - i2) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                        }
                        sb.append(cArr, i2, i7);
                        sb.append(w());
                    } else {
                        if (c3 == 10) {
                            this.g++;
                            this.h = i5;
                        }
                        i4 = i5;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i4 - i2) * 2, 16));
                    }
                    sb.append(cArr, i2, i4 - i2);
                    this.e = i4;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        u();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String t() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.e
            int r4 = r3 + r2
            int r5 = r6.f
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.u()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.d
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.b((int) r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r1 = r2
            goto L_0x007e
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L_0x006b:
            char[] r3 = r6.d
            int r4 = r6.e
            r0.append(r3, r4, r2)
            int r3 = r6.e
            int r3 = r3 + r2
            r6.e = r3
            r2 = 1
            boolean r2 = r6.b((int) r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.d
            int r3 = r6.e
            r0.<init>(r2, r3, r1)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.d
            int r3 = r6.e
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L_0x0095:
            int r2 = r6.e
            int r2 = r2 + r1
            r6.e = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.a.t():java.lang.String");
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.d;
        while (true) {
            int i2 = this.e;
            int i3 = this.f;
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.e = i4;
                        return;
                    } else if (c3 == '\\') {
                        this.e = i4;
                        w();
                        break;
                    } else {
                        if (c3 == 10) {
                            this.g++;
                            this.h = i4;
                        }
                        i2 = i4;
                    }
                } else {
                    this.e = i2;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    public int n() throws IOException {
        int i2 = this.b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 15) {
            long j2 = this.i;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.b = 0;
                int[] iArr = this.o;
                int i4 = this.m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.i + r());
        }
        if (i2 == 16) {
            this.k = new String(this.d, this.e, this.j);
            this.e += this.j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = t();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.b = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + r());
        }
        this.b = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.k = null;
            this.b = 0;
            int[] iArr3 = this.o;
            int i7 = this.m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.k + r());
    }

    public void close() throws IOException {
        this.b = 0;
        this.l[0] = 8;
        this.m = 1;
        this.c.close();
    }

    public void o() throws IOException {
        int i2;
        int i3 = 0;
        do {
            int i4 = this.b;
            if (i4 == 0) {
                i4 = q();
            }
            if (i4 == 3) {
                a(1);
            } else if (i4 == 1) {
                a(3);
            } else {
                if (i4 == 4) {
                    this.m--;
                } else if (i4 == 2) {
                    this.m--;
                } else if (i4 == 14 || i4 == 10) {
                    while (true) {
                        i2 = 0;
                        while (true) {
                            int i5 = this.e;
                            if (i5 + i2 < this.f) {
                                char c2 = this.d[i5 + i2];
                                if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                                    if (c2 != '#') {
                                        if (c2 != ',') {
                                            if (!(c2 == '/' || c2 == '=')) {
                                                if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                                    if (c2 != ';') {
                                                        switch (c2) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.e = i5 + i2;
                                if (!b(1)) {
                                }
                            }
                        }
                    }
                    u();
                    this.e += i2;
                    this.b = 0;
                } else if (i4 == 8 || i4 == 12) {
                    c('\'');
                    this.b = 0;
                } else if (i4 == 9 || i4 == 13) {
                    c('\"');
                    this.b = 0;
                } else {
                    if (i4 == 16) {
                        this.e += this.j;
                    }
                    this.b = 0;
                }
                i3--;
                this.b = 0;
            }
            i3++;
            this.b = 0;
        } while (i3 != 0);
        int[] iArr = this.o;
        int i6 = this.m;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.n[i6 - 1] = AbstractJsonLexerKt.NULL;
    }

    private void a(int i2) {
        int i3 = this.m;
        int[] iArr = this.l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr2[i5] = i2;
    }

    private boolean b(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.d;
        int i5 = this.h;
        int i6 = this.e;
        this.h = i5 - i6;
        int i7 = this.f;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.c;
            int i9 = this.f;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f + read;
            this.f = i3;
            if (this.g == 0 && (i4 = this.h) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.e++;
                this.h = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    private int a(boolean z) throws IOException {
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = this.f;
        while (true) {
            if (i2 == i3) {
                this.e = i2;
                if (b(1)) {
                    i2 = this.e;
                    i3 = this.f;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + r());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == 10) {
                this.g++;
                this.h = i4;
            } else if (!(c2 == ' ' || c2 == 13 || c2 == 9)) {
                if (c2 == '/') {
                    this.e = i4;
                    if (i4 == i3) {
                        this.e = i4 - 1;
                        boolean b2 = b(2);
                        this.e++;
                        if (!b2) {
                            return c2;
                        }
                    }
                    u();
                    int i5 = this.e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.e = i5 + 1;
                        if (a("*/")) {
                            i2 = this.e + 2;
                            i3 = this.f;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.e = i5 + 1;
                        v();
                        i2 = this.e;
                        i3 = this.f;
                    }
                } else if (c2 == '#') {
                    this.e = i4;
                    u();
                    v();
                    i2 = this.e;
                    i3 = this.f;
                } else {
                    this.e = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void u() throws IOException {
        if (!this.a) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void v() throws IOException {
        char c2;
        do {
            if (this.e < this.f || b(1)) {
                char[] cArr = this.d;
                int i2 = this.e;
                int i3 = i2 + 1;
                this.e = i3;
                c2 = cArr[i2];
                if (c2 == 10) {
                    this.g++;
                    this.h = i3;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i2 = 0;
            if (this.e + length > this.f && !b(length)) {
                return false;
            }
            char[] cArr = this.d;
            int i3 = this.e;
            if (cArr[i3] == 10) {
                this.g++;
                this.h = i3 + 1;
            } else {
                while (i2 < length) {
                    if (this.d[this.e + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                return true;
            }
            this.e++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + r();
    }

    /* access modifiers changed from: package-private */
    public final String r() {
        return " at line " + (this.g + 1) + " column " + ((this.e - this.h) + 1) + " path " + p();
    }

    public String p() {
        StringBuilder sb = new StringBuilder("$");
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(this.o[i3]);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String str = this.n[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    private char w() throws IOException {
        int i2;
        int i3;
        if (this.e != this.f || b(1)) {
            char[] cArr = this.d;
            int i4 = this.e;
            int i5 = i4 + 1;
            this.e = i5;
            char c2 = cArr[i4];
            if (c2 == 10) {
                this.g++;
                this.h = i5;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 != 'u') {
                    throw b("Invalid escape sequence");
                } else if (i5 + 4 <= this.f || b(4)) {
                    int i6 = this.e;
                    int i7 = i6 + 4;
                    char c3 = 0;
                    while (i6 < i7) {
                        char c4 = this.d[i6];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i2 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u".concat(new String(this.d, this.e, 4)));
                            } else {
                                i2 = c4 - 'A';
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = c4 - '0';
                        }
                        c3 = (char) (c5 + i3);
                        i6++;
                    }
                    this.e += 4;
                    return c3;
                } else {
                    throw b("Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw b("Unterminated escape sequence");
    }

    private IOException b(String str) throws IOException {
        throw new d(str + r());
    }

    private void x() throws IOException {
        a(true);
        int i2 = this.e - 1;
        this.e = i2;
        if (i2 + 5 <= this.f || b(5)) {
            char[] cArr = this.d;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == 10) {
                this.e += 5;
            }
        }
    }

    static {
        f.a = new f() {
            public final void a(a aVar) throws IOException {
                if (aVar instanceof e) {
                    e eVar = (e) aVar;
                    eVar.a(b.NAME);
                    Map.Entry entry = (Map.Entry) ((Iterator) eVar.g()).next();
                    eVar.a(entry.getValue());
                    eVar.a((Object) new p((String) entry.getKey()));
                    return;
                }
                int i = aVar.b;
                if (i == 0) {
                    i = aVar.q();
                }
                if (i == 13) {
                    aVar.b = 9;
                } else if (i == 12) {
                    aVar.b = 8;
                } else if (i == 14) {
                    aVar.b = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.r());
                }
            }
        };
    }
}
