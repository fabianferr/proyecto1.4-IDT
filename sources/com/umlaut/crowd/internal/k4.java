package com.umlaut.crowd.internal;

import com.ironsource.sdk.c.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class k4 extends f4 implements AutoCloseable {
    protected static final int n = 1024;
    private static final Charset o = Charset.forName("UTF-8");
    protected boolean e = false;
    protected long f;
    protected double g;
    protected float h;
    protected InputStream i;
    protected byte[] j;
    protected int k;
    protected int l;
    protected int m = 0;

    class a extends Reader {
        private boolean a = true;
        private boolean b = false;
        private boolean c = false;

        a() {
        }

        public void close() throws IOException {
            if (!this.c) {
                if (this.a || !this.b) {
                    String str = "";
                    while (str != null) {
                        try {
                            str = k4.this.a(255, this.a);
                            this.a = false;
                        } catch (g4 e) {
                            throw new IOException("cannot read quoted String: " + e.getMessage(), e);
                        }
                    }
                }
                k4 k4Var = k4.this;
                k4Var.m = 0;
                k4Var.c = 'v';
                this.c = true;
            }
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.c) {
                return -1;
            }
            if (cArr.length >= i + i2) {
                try {
                    String a2 = k4.this.a(i2, this.a);
                    if (a2 == null) {
                        this.b = true;
                        return -1;
                    }
                    this.a = false;
                    System.arraycopy(a2.toCharArray(), 0, cArr, i, a2.length());
                    return a2.length();
                } catch (g4 e) {
                    throw new IOException("cannot read quoted String: " + e.getMessage(), e);
                }
            } else {
                throw new IOException("offset + len is higher than the size of chararray");
            }
        }
    }

    class c extends InputStream {
        boolean a = false;

        c() {
        }

        public int read() throws IOException {
            try {
                if (this.a) {
                    return -1;
                }
                k4.this.B();
                k4 k4Var = k4.this;
                if (k4Var.m != 2) {
                    return (int) (k4Var.w() & 255);
                }
                k4Var.k();
                this.a = true;
                return -1;
            } catch (g4 e) {
                this.a = true;
                throw new IOException("Cannot read bytes: " + e.getMessage(), e);
            }
        }
    }

    public k4(InputStream inputStream) throws g4 {
        this.c = 'i';
        this.i = inputStream;
        this.l = 0;
        this.k = 0;
        this.j = new byte[1024];
        a('d');
        this.c = 'i';
    }

    private void D() throws g4 {
        boolean z;
        StringBuilder sb = new StringBuilder();
        byte A = A();
        if (A == 45) {
            a((byte) 45);
            sb.append("-");
            A();
        } else if (A < 48 && A > 57) {
            throw new g4("Cannot parse Number");
        }
        boolean z2 = true;
        a(sb, true);
        byte A2 = A();
        if (A2 == 46) {
            a(A2);
            sb.append(".");
            a(sb, false);
            A2 = A();
            z = true;
        } else {
            z = false;
        }
        if (A2 == 101 || A2 == 69) {
            a(A2);
            sb.append(e.a);
            byte A3 = A();
            if (A3 == 45 || A3 == 43) {
                a(A3);
                sb.append((char) A3);
            }
            a(sb, false);
        } else {
            z2 = false;
        }
        String sb2 = sb.toString();
        if (z) {
            this.g = Double.parseDouble(sb2);
            this.h = Float.parseFloat(sb2);
            this.m = 32;
        } else if (!z2) {
            this.f = Long.parseLong(sb2);
            this.m = 64;
        } else {
            throw new g4("Exponent for longs are (currently) not supported!");
        }
    }

    /* access modifiers changed from: protected */
    public byte A() throws g4 {
        F();
        if (this.l >= this.k) {
            m();
        }
        return this.j[this.l];
    }

    /* access modifiers changed from: protected */
    public void B() throws g4 {
        char c2;
        char c3;
        if (this.m == 0) {
            F();
            byte A = A();
            char h2 = h();
            if (A != 34) {
                if (A != 44) {
                    if (A == 91) {
                        char c4 = this.c;
                        if (c4 == 'i' || h2 == 'a' || (c4 == 'k' && h2 == 'o')) {
                            this.m = 1;
                            return;
                        }
                    } else if (A != 93) {
                        if (A == 123) {
                            char c5 = this.c;
                            if (c5 == 'i' || h2 == 'a' || (c5 == 'k' && h2 == 'o')) {
                                this.m = 4;
                                return;
                            }
                        } else if (A == 125) {
                            if (h2 == 'o' && ((c3 = this.c) == 'v' || c3 == 'o')) {
                                this.m = 8;
                                return;
                            }
                        }
                    } else if (h2 == 'a' && ((c2 = this.c) == 'v' || c2 == 'a')) {
                        this.m = 2;
                        return;
                    }
                } else if (this.c == 'v' && (h2 == 'a' || h2 == 'o')) {
                    a((byte) 44);
                    this.c = 'v';
                    if (h2 == 'a') {
                        B();
                        return;
                    } else if (h2 == 'o') {
                        this.m = 16;
                        return;
                    } else {
                        return;
                    }
                }
                this.m = 0;
            } else if (this.c == 'o') {
                this.m = 16;
                return;
            }
            if (h2 == 'a' || (h2 == 'o' && this.c == 'k')) {
                if (A == 34) {
                    this.m = 128;
                    return;
                } else if (A != 98) {
                    if (A != 102) {
                        if (A == 110) {
                            this.m = 1024;
                            return;
                        } else if (A != 116) {
                            if (A == 45 || (A >= 48 && A <= 57)) {
                                D();
                                return;
                            }
                        }
                    }
                    this.m = 512;
                    return;
                } else {
                    this.m = 2048;
                    return;
                }
            }
            this.m = 0;
        }
    }

    /* access modifiers changed from: protected */
    public char C() throws g4 {
        int i2;
        int i3;
        byte j2 = j();
        if (j2 == 98) {
            return 8;
        }
        if (j2 == 102) {
            return 12;
        }
        if (j2 == 110) {
            return 10;
        }
        if (j2 == 114) {
            return 13;
        }
        if (j2 == 116) {
            return 9;
        }
        if (j2 != 117) {
            return (char) j2;
        }
        byte[] a2 = a(4);
        char c2 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte b2 = a2[i4];
            char c3 = (char) (c2 << 4);
            if (b2 < 48 || b2 > 57) {
                if (b2 >= 97 && b2 <= 102) {
                    i2 = b2 - 97;
                } else if (b2 < 65 || b2 > 70) {
                    throw new NumberFormatException("\\u" + new String(a2) + " wrong character: " + b2);
                } else {
                    i2 = b2 - 65;
                }
                i3 = i2 + 10;
            } else {
                i3 = b2 - 48;
            }
            c2 = (char) (c3 + i3);
        }
        return c2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0057, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0058, code lost:
        if (r9 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0062, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E() throws com.umlaut.crowd.internal.g4 {
        /*
            r11 = this;
            r11.B()
            int r0 = r11.m
            r1 = 2048(0x800, float:2.87E-42)
            r2 = 1024(0x400, float:1.435E-42)
            r3 = 512(0x200, float:7.175E-43)
            r4 = 128(0x80, float:1.794E-43)
            r5 = 64
            r6 = 32
            r7 = 4
            r8 = 1
            if (r0 == r8) goto L_0x0025
            if (r0 == r7) goto L_0x0025
            if (r0 == r6) goto L_0x0025
            if (r0 == r5) goto L_0x0025
            if (r0 == r4) goto L_0x0025
            if (r0 == r3) goto L_0x0025
            if (r0 == r2) goto L_0x0025
            if (r0 == r1) goto L_0x0025
            r0 = 0
            goto L_0x0026
        L_0x0025:
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x00ca
            int r0 = r11.b
        L_0x002a:
            int r9 = r11.m
            if (r9 == r8) goto L_0x00bd
            r10 = 2
            if (r9 == r10) goto L_0x00b9
            if (r9 == r7) goto L_0x00b5
            r10 = 8
            if (r9 == r10) goto L_0x00b1
            r10 = 16
            if (r9 == r10) goto L_0x00ad
            if (r9 == r6) goto L_0x00a9
            if (r9 == r5) goto L_0x00a5
            if (r9 == r4) goto L_0x0084
            if (r9 == r3) goto L_0x0080
            if (r9 == r2) goto L_0x007c
            if (r9 == r1) goto L_0x0049
            goto L_0x00c0
        L_0x0049:
            java.io.InputStream r9 = r11.s()     // Catch:{ IOException -> 0x0063 }
            r9.close()     // Catch:{ all -> 0x0055 }
            r9.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x00c0
        L_0x0055:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r1 = move-exception
            if (r9 == 0) goto L_0x0062
            r9.close()     // Catch:{ all -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch:{ IOException -> 0x0063 }
        L_0x0062:
            throw r1     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            r0 = move-exception
            com.umlaut.crowd.internal.g4 r1 = new com.umlaut.crowd.internal.g4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error while skipping ByteStream:"
            r2.<init>(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x007c:
            r11.x()
            goto L_0x00c0
        L_0x0080:
            r11.t()
            goto L_0x00c0
        L_0x0084:
            java.io.Reader r9 = r11.y()
            r9.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x00c0
        L_0x008c:
            r0 = move-exception
            com.umlaut.crowd.internal.g4 r1 = new com.umlaut.crowd.internal.g4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error on skipping Tokenvalue: "
            r2.<init>(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00a5:
            r11.w()
            goto L_0x00c0
        L_0x00a9:
            r11.u()
            goto L_0x00c0
        L_0x00ad:
            r11.q()
            goto L_0x00c0
        L_0x00b1:
            r11.l()
            goto L_0x00c0
        L_0x00b5:
            r11.H()
            goto L_0x00c0
        L_0x00b9:
            r11.k()
            goto L_0x00c0
        L_0x00bd:
            r11.G()
        L_0x00c0:
            int r9 = r11.b
            if (r0 != r9) goto L_0x00c5
            return
        L_0x00c5:
            r11.B()
            goto L_0x002a
        L_0x00ca:
            com.umlaut.crowd.internal.g4 r0 = new com.umlaut.crowd.internal.g4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Misplaced value. Read token "
            r1.<init>(r2)
            int r2 = r11.m
            com.umlaut.crowd.internal.n4 r2 = com.umlaut.crowd.internal.n4.a(r2)
            r1.append(r2)
            java.lang.String r2 = " which is not a value"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto L_0x00ea
        L_0x00e9:
            throw r0
        L_0x00ea:
            goto L_0x00e9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.k4.E():void");
    }

    /* access modifiers changed from: protected */
    public void F() throws g4 {
        while (true) {
            int i2 = this.l;
            if (i2 < this.k) {
                byte b2 = this.j[i2];
                if (b2 == 32 || b2 == 9 || b2 == 13 || b2 == 10) {
                    this.l = i2 + 1;
                } else {
                    return;
                }
            } else {
                m();
            }
        }
    }

    public k4 G() throws g4 {
        B();
        if (this.m == 1) {
            a((byte) 91);
            a('a');
            this.c = 'a';
            this.m = 0;
            return this;
        }
        throw new g4("Misplaced array. Try to read token " + n4.a(1) + " but read token " + n4.a(this.m));
    }

    public k4 H() throws g4 {
        B();
        if (this.m == 4) {
            a((byte) 123);
            a('o');
            this.c = 'o';
            this.m = 0;
            return this;
        }
        throw new g4("Misplaced object. Try to read token " + n4.a(4) + " but read token " + n4.a(this.m));
    }

    public n4 I() throws g4 {
        B();
        return n4.a(this.m);
    }

    /* access modifiers changed from: protected */
    public void a(byte b2) throws g4 {
        if (b(b2)) {
            this.l++;
            return;
        }
        throw new g4("Illegal State Exception: Expected char was '" + b2 + "\"");
    }

    public void b(int i2) throws g4 {
        if (this.c == 'i') {
            this.j = new byte[i2];
            return;
        }
        throw new g4("Buffersize has to be set before starting reading");
    }

    public void c(boolean z) throws IOException {
        if (z) {
            close();
        } else {
            this.e = true;
        }
    }

    public void close() throws IOException {
        if (!this.e) {
            this.i.close();
            this.e = true;
        }
    }

    public String d(boolean z) throws g4 {
        B();
        int i2 = this.m;
        if (i2 == 128) {
            String a2 = a(-1, true);
            this.m = 0;
            this.c = 'v';
            return a2;
        }
        if (!z) {
            if (i2 == 32) {
                return Double.toString(u());
            }
            if (i2 == 64) {
                return Long.toString(w());
            }
            if (i2 == 512) {
                return Boolean.toString(t());
            }
            if (i2 == 1024) {
                x();
                return AbstractJsonLexerKt.NULL;
            }
        }
        throw new g4("Misplaced value. Try to read token " + n4.a(128) + " but read token " + n4.a(this.m));
    }

    public /* bridge */ /* synthetic */ i4 g() {
        return super.g();
    }

    /* access modifiers changed from: protected */
    public byte j() throws g4 {
        while (true) {
            int i2 = this.l;
            if (i2 < this.k) {
                byte b2 = this.j[i2];
                this.l = i2 + 1;
                return b2;
            }
            m();
        }
    }

    public k4 k() throws g4 {
        B();
        if (this.m == 2) {
            i();
            a((byte) 93);
            this.c = 'v';
            this.m = 0;
            return this;
        }
        throw new g4("Misplaced endarray. Try to read token " + n4.a(2) + " but read token " + n4.a(this.m));
    }

    public k4 l() throws g4 {
        B();
        if (this.m == 8) {
            i();
            a((byte) 125);
            this.m = 0;
            this.c = 'v';
            return this;
        }
        throw new g4("Misplaced endObject. Try to read token " + n4.a(8) + " but read token " + n4.a(this.m));
    }

    /* access modifiers changed from: protected */
    public void m() throws g4 {
        int i2;
        int i3;
        try {
            int i4 = this.l;
            if (i4 == 0 && (i3 = this.k) != 0) {
                this.l = i3;
            } else if (i4 > 0 && i4 < (i2 = this.k)) {
                int i5 = i2 - i4;
                for (int i6 = 0; i6 < i5; i6++) {
                    byte[] bArr = this.j;
                    bArr[i6] = bArr[this.l + i6];
                }
                this.l = i5;
            } else if (i4 >= this.k) {
                this.l = 0;
            }
            InputStream inputStream = this.i;
            byte[] bArr2 = this.j;
            int i7 = this.l;
            int read = inputStream.read(bArr2, i7, bArr2.length - i7);
            if (read != -1) {
                int i8 = this.l;
                this.k = read + i8;
                if (this.c == 'i' && i8 == 0) {
                    byte[] bArr3 = this.j;
                    if (bArr3[0] == -17 && bArr3[1] == -69 && bArr3[2] == -65) {
                        this.l = 3;
                        return;
                    }
                }
                this.l = 0;
                return;
            }
            throw new g4("Unexpected END of transmission");
        } catch (IOException e2) {
            throw new g4("I/O Error on filling the buffer", e2);
        }
    }

    /* access modifiers changed from: protected */
    public byte n() throws g4 {
        if (this.l >= this.k) {
            m();
        }
        byte[] bArr = this.j;
        int i2 = this.l;
        byte b2 = bArr[i2];
        this.l = i2 + 1;
        return b2;
    }

    public byte[] o() {
        int i2 = this.k;
        int i3 = this.l;
        int i4 = i2 - i3;
        byte[] bArr = new byte[i4];
        if (i4 > 0) {
            System.arraycopy(this.j, i3, bArr, 0, i4);
        }
        return bArr;
    }

    public boolean p() throws g4 {
        B();
        if (this.c == 'd') {
            return true;
        }
        int i2 = this.m;
        return (i2 == 2 || i2 == 8) ? false : true;
    }

    public String q() throws g4 {
        B();
        if (this.m == 16) {
            this.c = 'k';
            this.m = 0;
            String a2 = a(-1, true);
            a((byte) 58);
            return a2;
        }
        throw new g4("Misplaced nextKey. Try to read token " + n4.a(16) + " but read token " + n4.a(this.m));
    }

    public byte[] r() throws g4 {
        InputStream s = s();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[32767];
        while (true) {
            try {
                int read = s.read(bArr, 0, 32767);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                } else if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e2) {
                throw new g4("Error while reading..." + e2.getMessage(), e2);
            }
        }
    }

    public InputStream s() throws g4 {
        B();
        int i2 = this.m;
        if (i2 == 2048) {
            a((byte) 98);
            this.m = 256;
            this.c = 'r';
            return new b();
        } else if (i2 == 1) {
            G();
            return new c();
        } else {
            throw new g4("Misplaced Binary value. Try to read token " + n4.a(2048) + " but read token " + n4.a(this.m));
        }
    }

    public boolean t() throws g4 {
        B();
        if (this.m == 512) {
            byte[] a2 = a(4);
            byte b2 = a2[0];
            if (b2 == 116) {
                if (a2[1] == 114 && a2[2] == 117 && a2[3] == 101) {
                    this.m = 0;
                    this.c = 'v';
                    return true;
                }
            } else if (b2 == 102 && a2[1] == 97 && a2[2] == 108 && a2[3] == 115 && a((byte) 101, false)) {
                a((byte) 101);
                this.m = 0;
                this.c = 'v';
                return false;
            }
        }
        throw new g4("Misplaced Boolean value. Try to read token " + n4.a(512) + " but read token " + n4.a(this.m));
    }

    public double u() throws g4 {
        B();
        int i2 = this.m;
        if (i2 == 32) {
            this.m = 0;
            this.c = 'v';
            return this.g;
        } else if (i2 == 64) {
            this.m = 0;
            this.c = 'v';
            return (double) this.f;
        } else {
            throw new g4("Misplaced LongValue. Try to read token " + n4.a(32) + " but read token " + n4.a(this.m));
        }
    }

    public float v() throws g4 {
        B();
        int i2 = this.m;
        if (i2 == 32) {
            this.m = 0;
            this.c = 'v';
            return this.h;
        } else if (i2 == 64) {
            this.m = 0;
            this.c = 'v';
            return (float) this.f;
        } else {
            throw new g4("Misplaced LongValue. Try to read token " + n4.a(32) + " but read token " + n4.a(this.m));
        }
    }

    public long w() throws g4 {
        B();
        if (this.m == 64) {
            this.m = 0;
            this.c = 'v';
            return this.f;
        }
        throw new g4("Misplaced LongValue. Try to read token " + n4.a(64) + " but read token " + n4.a(this.m));
    }

    public void x() throws g4 {
        byte b2;
        B();
        if (this.m == 1024) {
            byte[] a2 = a(4);
            if (a2[0] == 110 && a2[1] == 117 && (b2 = a2[2]) == 108 && b2 == 108) {
                this.m = 0;
                this.c = 'v';
                return;
            }
        }
        throw new g4("Misplaced Boolean value. Try to read token " + n4.a(512) + " but read token " + n4.a(this.m));
    }

    public Reader y() throws g4 {
        B();
        if (this.m == 128) {
            this.m = 256;
            this.c = 'r';
            return new a();
        }
        throw new g4("Misplaced value. Try to read token " + n4.a(128) + " but read token " + n4.a(this.m));
    }

    public String z() throws g4 {
        return d(false);
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, int i2) throws g4 {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.l >= this.k) {
                m();
            }
            byte[] bArr2 = this.j;
            int i4 = this.l;
            this.l = i4 + 1;
            bArr[i3] = bArr2[i4];
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(byte b2) throws g4 {
        return a(b2, true);
    }

    public Object b(Class<?> cls) throws g4 {
        return a(cls, false);
    }

    /* access modifiers changed from: protected */
    public boolean a(byte b2, boolean z) throws g4 {
        if (z) {
            F();
        }
        if (this.l >= this.k) {
            m();
        }
        return this.j[this.l] == b2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.StringBuilder r8, boolean r9) throws com.umlaut.crowd.internal.g4 {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            r3 = 1
        L_0x0004:
            byte r4 = r7.A()
            r5 = 48
            if (r4 < r5) goto L_0x002b
            r6 = 57
            if (r4 > r6) goto L_0x002b
            if (r3 == 0) goto L_0x001f
            if (r2 == 0) goto L_0x001f
            if (r9 != 0) goto L_0x0017
            goto L_0x001f
        L_0x0017:
            com.umlaut.crowd.internal.g4 r8 = new com.umlaut.crowd.internal.g4
            java.lang.String r9 = "parsed Number starts with 0, what is not allowed"
            r8.<init>(r9)
            throw r8
        L_0x001f:
            if (r4 == r5) goto L_0x0022
            r3 = 0
        L_0x0022:
            char r2 = (char) r4
            r8.append(r2)
            r7.a((byte) r4)
            r2 = 1
            goto L_0x0004
        L_0x002b:
            if (r2 == 0) goto L_0x002e
            return
        L_0x002e:
            com.umlaut.crowd.internal.g4 r8 = new com.umlaut.crowd.internal.g4
            java.lang.String r9 = "Cannot parse Number"
            r8.<init>(r9)
            goto L_0x0037
        L_0x0036:
            throw r8
        L_0x0037:
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.k4.a(java.lang.StringBuilder, boolean):void");
    }

    class b extends InputStream {
        int a = 0;
        int b = 0;
        byte[] c = null;
        boolean d = true;
        boolean e = false;

        b() {
        }

        private void g() {
            k4 k4Var = k4.this;
            k4Var.m = 0;
            k4Var.c = 'v';
            this.e = true;
        }

        private void h() throws g4 {
            byte n = k4.this.n();
            byte n2 = k4.this.n();
            this.d = (n & 128) != 0;
            int i = (n2 & 255) + ((((byte) (n & Byte.MAX_VALUE)) & 255) << 8);
            this.a = i;
            byte[] bArr = this.c;
            if (bArr == null || bArr.length < i) {
                this.c = new byte[i];
            }
            this.b = 0;
            k4.this.a(this.c, i);
        }

        public void close() throws IOException {
            if (!this.e) {
                while (this.d) {
                    try {
                        h();
                    } catch (g4 e2) {
                        throw new IOException("Error closing stream: " + e2.getMessage());
                    }
                }
                this.b = this.c.length;
                g();
            }
        }

        public int read() throws IOException {
            if (this.e) {
                return -1;
            }
            try {
                int i = this.b;
                if (i < this.a) {
                    byte[] bArr = this.c;
                    this.b = i + 1;
                    return bArr[i] & 255;
                } else if (!this.d) {
                    g();
                    return -1;
                } else {
                    h();
                    byte[] bArr2 = this.c;
                    if (bArr2.length == 0) {
                        g();
                        return -1;
                    }
                    this.b = 1;
                    return bArr2[0] & 255;
                }
            } catch (g4 e2) {
                throw new IOException("Error on getting data: " + e2.getMessage());
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.e) {
                return -1;
            }
            int i3 = 0;
            if (i2 == 0) {
                return 0;
            }
            do {
                try {
                    int i4 = this.b;
                    int i5 = this.a;
                    if (i4 < i5) {
                        int i6 = i5 - i4;
                        int i7 = i2 - i3;
                        if (i7 <= i6) {
                            i6 = i7;
                        }
                        System.arraycopy(this.c, i4, bArr, i + i3, i6);
                        i3 += i6;
                        this.b += i6;
                    }
                    if (i3 == i2) {
                        return i2;
                    }
                    if (!this.d) {
                        g();
                        return i3;
                    }
                    h();
                } catch (g4 e2) {
                    throw new IOException("Error on getting data: " + e2.getMessage());
                }
            } while (this.c.length != 0);
            g();
            return i3;
        }
    }

    public Object a(Class<?> cls, boolean z) throws g4 {
        Object obj;
        Object obj2;
        B();
        if (this.m == 1024) {
            return null;
        }
        if (cls.isArray()) {
            if (cls.equals(byte[].class)) {
                return r();
            }
            G();
            ArrayList arrayList = new ArrayList();
            while (p()) {
                B();
                if (this.m == 1024) {
                    x();
                    obj2 = null;
                } else {
                    obj2 = a(cls.getComponentType(), z);
                }
                arrayList.add(obj2);
            }
            Object newInstance = Array.newInstance(cls.getComponentType(), arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Array.set(newInstance, i2, arrayList.get(i2));
            }
            k();
            return newInstance;
        } else if (cls.equals(Byte.class) || cls.equals(Byte.TYPE)) {
            return Byte.valueOf((byte) ((int) w()));
        } else {
            if (cls.equals(Short.class) || cls.equals(Short.TYPE)) {
                return Short.valueOf((short) ((int) w()));
            }
            if (cls.equals(Integer.class) || cls.equals(Integer.TYPE)) {
                return Integer.valueOf((int) w());
            }
            if (cls.equals(Long.class) || cls.equals(Long.TYPE)) {
                return Long.valueOf(w());
            }
            if (cls.equals(Float.class) || cls.equals(Float.TYPE)) {
                return Float.valueOf(v());
            }
            if (cls.equals(Double.class) || cls.equals(Double.TYPE)) {
                return Double.valueOf(u());
            }
            if (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) {
                return Boolean.valueOf(t());
            }
            if (cls.equals(Character.class) || cls.equals(Character.TYPE)) {
                return Character.valueOf((char) ((int) w()));
            }
            if (cls.equals(String.class)) {
                return z();
            }
            if (cls.isEnum()) {
                return a(cls);
            }
            H();
            try {
                Object newInstance2 = cls.newInstance();
                if (h4.class.isAssignableFrom(cls)) {
                    int i3 = this.b;
                    ((h4) newInstance2).a(this);
                    B();
                    if (this.b != i3 || this.m != 8) {
                        throw new g4("Reader method in " + cls.getCanonicalName() + " is invalid: Not all data was read.");
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    Class<?> cls2 = cls;
                    while (cls2 != null && !cls2.equals(Object.class)) {
                        for (Field field : cls2.getDeclaredFields()) {
                            hashMap.put(field.getName(), field);
                        }
                        cls2 = cls2.getSuperclass();
                    }
                    while (p()) {
                        String q = q();
                        if (hashMap.containsKey(q)) {
                            Field field2 = (Field) hashMap.get(q);
                            boolean isAccessible = field2.isAccessible();
                            field2.setAccessible(true);
                            Class<?> type = field2.getType();
                            B();
                            if (this.m == 1024) {
                                x();
                                obj = null;
                            } else {
                                obj = a(type, z);
                            }
                            field2.set(newInstance2, obj);
                            field2.setAccessible(isAccessible);
                        } else if (z) {
                            E();
                        } else {
                            throw new g4("Unknown property \"" + q + "\" for class \"" + cls.getCanonicalName() + "\"");
                        }
                    }
                }
                l();
                return newInstance2;
            } catch (IllegalAccessException | InstantiationException e2) {
                throw new g4("Cannot create new Object : " + e2.getMessage(), e2);
            }
        }
    }

    private Enum<?> a(Class<?> cls) throws g4 {
        String z = z();
        for (Object obj : cls.getEnumConstants()) {
            if (obj.toString().equals(z)) {
                return (Enum) obj;
            }
        }
        throw new g4("Misplaced Enum value. Try to read token " + n4.a(128) + " but read token " + n4.a(this.m));
    }

    /* access modifiers changed from: protected */
    public String a(int i2, boolean z) throws g4 {
        int i3;
        if (z) {
            a((byte) 34);
        } else if (A() == 34) {
            a((byte) 34);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            int i5 = this.l;
            while (i5 < this.k) {
                byte[] bArr = this.j;
                byte b2 = bArr[i5];
                i5++;
                if ((b2 & 128) == 0) {
                    i4++;
                    if (b2 == 34) {
                        int i6 = this.l;
                        sb.append(new String(bArr, i6, (i5 - i6) - 1, o));
                        this.l = i5;
                        if (i2 != -1) {
                            this.l = i5 - 1;
                        }
                        return sb.toString();
                    }
                    if (b2 == 92) {
                        int i7 = this.l;
                        sb.append(new String(bArr, i7, (i5 - i7) - 1, o));
                        this.l = i5;
                        sb.append(C());
                        i5 = this.l;
                    }
                    if (i4 == i2) {
                        break;
                    }
                }
            }
            if (i5 - this.l > 0) {
                byte b3 = this.j[i5 - 1];
                if ((b3 & 128) != 0) {
                    i3 = 1;
                    while ((b3 & 192) != 192 && i3 < 5) {
                        b3 = this.j[(i5 - i3) - 1];
                        i3++;
                    }
                    if (i3 >= 5) {
                        throw new g4("NON-UTF8 character accessed!");
                    }
                } else {
                    i3 = 0;
                }
                byte[] bArr2 = this.j;
                int i8 = this.l;
                sb.append(new String(bArr2, i8, (i5 - i8) - i3, o));
                if (i3 > 0) {
                    this.l = this.k - i3;
                } else {
                    this.l = i5;
                }
            }
            if (i2 != -1 && i2 <= i4) {
                return sb.toString();
            }
            m();
        }
    }

    /* access modifiers changed from: protected */
    public byte[] a(int i2) throws g4 {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (true) {
            int i4 = this.l;
            if (i4 < this.k) {
                byte b2 = this.j[i4];
                this.l = i4 + 1;
                int i5 = i3 + 1;
                bArr[i3] = b2;
                if (i5 == i2) {
                    return bArr;
                }
                i3 = i5;
            } else {
                m();
            }
        }
    }
}
