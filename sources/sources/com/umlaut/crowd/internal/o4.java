package com.umlaut.crowd.internal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class o4 extends f4 implements AutoCloseable {
    private static final Charset l = Charset.forName("UTF-8");
    private boolean e = false;
    private OutputStream f;
    private char g;
    protected boolean h = false;
    private boolean i = false;
    private boolean j = true;
    private boolean k = true;

    public o4(OutputStream outputStream) throws g4 {
        this.f = outputStream;
        a('d');
        this.c = 'i';
    }

    private void a(char[] cArr, int i2) throws g4 {
        if (i2 > 0) {
            a(String.valueOf(cArr, 0, i2));
        }
    }

    private o4 c(String str) throws g4 {
        if ((l() & 3813) != 0) {
            if (this.e) {
                a((byte) 44);
            }
            a(str);
            this.c = 'v';
            this.e = true;
            return this;
        }
        throw new g4("Misplaced value. Try to write tokentype " + n4.JSON_TOKEN_VALUE + " expected was one token of these: " + n4.b(l()));
    }

    private int l() {
        char c = this.c;
        if (c == 'i') {
            return 5;
        }
        if (c == 'o') {
            return 24;
        }
        if (c == 'k') {
            return 3813;
        }
        if ((c & 'v') == 0) {
            return c == 'a' ? 3813 : 0;
        }
        char h2 = h();
        if (h2 == 'o') {
            return 24;
        }
        if (h2 == 'a') {
            return 3815;
        }
        return 0;
    }

    public o4 b(String str) throws g4 {
        if ((l() & 16) == 0) {
            throw new g4("Misplaced endObject. Try to write tokentype " + n4.JSON_TOKEN_OBJECT_END + " expected was one token of these: " + n4.b(l()));
        } else if (str == null || str.length() <= 0) {
            throw new g4("ObjectKey has to be at least one Character long");
        } else {
            if (this.e) {
                a((byte) 44);
            }
            a((byte) 34);
            a(str, true);
            a("\":");
            this.c = 'k';
            this.e = false;
            return this;
        }
    }

    public void close() throws IOException {
        if (!this.h) {
            this.f.flush();
            this.f.close();
            this.h = true;
        }
    }

    public void d(boolean z) {
        this.i = z;
    }

    public void e(boolean z) {
        this.k = z;
    }

    public void f(boolean z) {
        this.j = z;
    }

    public /* bridge */ /* synthetic */ i4 g() {
        return super.g();
    }

    public o4 j() throws g4 {
        if ((l() & 2) != 0) {
            a((byte) 93);
            char i2 = i();
            if (i2 == 'a') {
                this.c = 'v';
                this.e = true;
                return this;
            }
            throw new g4("Internal Error: Exspected Array to be closed, but on top is: " + i2);
        }
        throw new g4("Misplaced arrayend. Try to write tokentype " + n4.JSON_TOKEN_ARRAY_END + " expected was one token of these: " + n4.b(l()));
    }

    public o4 k() throws g4 {
        if ((l() & 8) != 0) {
            a((byte) 125);
            char i2 = i();
            if (i2 == 'o') {
                this.c = 'v';
                this.e = true;
                return this;
            }
            throw new g4("Internal Error: Exspected Object to be closed, but on top is: " + i2);
        }
        throw new g4("Misplaced endObject. Try to write tokentype " + n4.JSON_TOKEN_OBJECT_END + " expected was one token of these: " + n4.b(l()));
    }

    public List<n4> m() {
        return n4.b(l());
    }

    public boolean n() {
        return this.i;
    }

    public o4 o() throws g4 {
        if ((l() & 1) != 0) {
            if (this.e) {
                a((byte) 44);
            }
            a((byte) 91);
            a('a');
            this.c = 'a';
            this.e = false;
            return this;
        }
        throw new g4("Misplaced arraystart. Try to write tokentype " + n4.JSON_TOKEN_ARRAY_START + " expected was one token of these: " + n4.b(l()));
    }

    public o4 p() throws g4 {
        if ((l() & 4) != 0) {
            if (this.e) {
                a((byte) 44);
            }
            a((byte) 123);
            a('o');
            this.c = 'o';
            this.e = false;
            return this;
        }
        throw new g4("Misplaced Objectstart. Try to write tokentype " + n4.JSON_TOKEN_OBJECT_START + " expected was one token of these: " + n4.b(l()));
    }

    public o4 q() throws g4 {
        return c(AbstractJsonLexerKt.NULL);
    }

    private void a(String str) throws g4 {
        try {
            this.f.write(str.getBytes(l));
        } catch (IOException e2) {
            throw new g4("Error on writing to Stream", e2);
        }
    }

    public o4 d(String str) throws g4 {
        if ((l() & 3813) != 0) {
            if (this.e) {
                a((byte) 44);
            }
            a((byte) 34);
            a(str, true);
            a((byte) 34);
            this.e = true;
            this.c = 'v';
            return this;
        }
        throw new g4("Misplaced Stringvalue. Try to write tokentype " + n4.JSON_TOKEN_VALUE_STRING + " expected was one token of these: " + n4.b(l()));
    }

    public o4 g(boolean z) throws g4 {
        return c(Boolean.toString(z));
    }

    private void a(byte b) throws g4 {
        try {
            this.f.write(b);
        } catch (IOException e2) {
            throw new g4("Error on writing to Stream", e2);
        }
    }

    public o4 a(byte[] bArr) throws g4 {
        return a((InputStream) new ByteArrayInputStream(bArr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0083, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00bf, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.umlaut.crowd.internal.o4 a(java.io.InputStream r12) throws com.umlaut.crowd.internal.g4 {
        /*
            r11 = this;
            int r0 = r11.l()
            r0 = r0 & 3813(0xee5, float:5.343E-42)
            if (r0 == 0) goto L_0x00c7
            boolean r0 = r11.e
            if (r0 == 0) goto L_0x0011
            r0 = 44
            r11.a((byte) r0)
        L_0x0011:
            boolean r0 = r11.i
            r1 = 32767(0x7fff, float:4.5916E-41)
            java.lang.String r2 = "Cannot get data"
            r3 = -1
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x008b
            r0 = 98
            r11.a((byte) r0)
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0084 }
            r0.<init>(r12)     // Catch:{ IOException -> 0x0084 }
            byte[] r12 = new byte[r1]     // Catch:{ all -> 0x0078 }
            int r1 = r0.read(r12)     // Catch:{ all -> 0x0078 }
            boolean r6 = r11.i     // Catch:{ all -> 0x0078 }
            if (r6 == 0) goto L_0x0070
            if (r1 != r3) goto L_0x003d
            java.io.OutputStream r12 = r11.f     // Catch:{ all -> 0x0078 }
            r12.write(r5)     // Catch:{ all -> 0x0078 }
            java.io.OutputStream r12 = r11.f     // Catch:{ all -> 0x0078 }
            r12.write(r5)     // Catch:{ all -> 0x0078 }
            goto L_0x005d
        L_0x003d:
            byte[] r6 = new byte[r4]     // Catch:{ all -> 0x0078 }
        L_0x003f:
            byte r7 = (byte) r1     // Catch:{ all -> 0x0078 }
            int r8 = r1 >> 8
            byte r8 = (byte) r8     // Catch:{ all -> 0x0078 }
            int r9 = r0.read(r6)     // Catch:{ all -> 0x0078 }
            if (r9 == r3) goto L_0x004c
            r8 = r8 | 128(0x80, float:1.794E-43)
            byte r8 = (byte) r8     // Catch:{ all -> 0x0078 }
        L_0x004c:
            java.io.OutputStream r10 = r11.f     // Catch:{ all -> 0x0078 }
            r10.write(r8)     // Catch:{ all -> 0x0078 }
            java.io.OutputStream r8 = r11.f     // Catch:{ all -> 0x0078 }
            r8.write(r7)     // Catch:{ all -> 0x0078 }
            java.io.OutputStream r7 = r11.f     // Catch:{ all -> 0x0078 }
            r7.write(r12, r5, r1)     // Catch:{ all -> 0x0078 }
            if (r9 != r3) goto L_0x0061
        L_0x005d:
            r0.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x00ad
        L_0x0061:
            byte r1 = r6[r5]     // Catch:{ all -> 0x0078 }
            r12[r5] = r1     // Catch:{ all -> 0x0078 }
            int r1 = r0.read(r6, r4, r5)     // Catch:{ all -> 0x0078 }
            if (r1 == r3) goto L_0x006e
            int r1 = r1 + 1
            goto L_0x003f
        L_0x006e:
            r1 = 1
            goto L_0x003f
        L_0x0070:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "Currently not supported"
            r12.<init>(r1)     // Catch:{ all -> 0x0078 }
            throw r12     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x007a }
        L_0x007a:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            r12.addSuppressed(r0)     // Catch:{ IOException -> 0x0084 }
        L_0x0083:
            throw r1     // Catch:{ IOException -> 0x0084 }
        L_0x0084:
            r12 = move-exception
            com.umlaut.crowd.internal.g4 r0 = new com.umlaut.crowd.internal.g4
            r0.<init>(r2, r12)
            throw r0
        L_0x008b:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00c0 }
            r0.<init>(r12)     // Catch:{ IOException -> 0x00c0 }
            byte[] r12 = new byte[r1]     // Catch:{ all -> 0x00b4 }
            r11.o()     // Catch:{ all -> 0x00b4 }
        L_0x0095:
            int r1 = r0.read(r12)     // Catch:{ all -> 0x00b4 }
            if (r1 == r3) goto L_0x00a7
            r6 = 0
        L_0x009c:
            if (r6 >= r1) goto L_0x0095
            byte r7 = r12[r6]     // Catch:{ all -> 0x00b4 }
            long r7 = (long) r7     // Catch:{ all -> 0x00b4 }
            r11.a((long) r7)     // Catch:{ all -> 0x00b4 }
            int r6 = r6 + 1
            goto L_0x009c
        L_0x00a7:
            r11.j()     // Catch:{ all -> 0x00b4 }
            r0.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00ad:
            r12 = 118(0x76, float:1.65E-43)
            r11.c = r12
            r11.e = r4
            return r11
        L_0x00b4:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00b6 }
        L_0x00b6:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x00bb }
            goto L_0x00bf
        L_0x00bb:
            r0 = move-exception
            r12.addSuppressed(r0)     // Catch:{ IOException -> 0x00c0 }
        L_0x00bf:
            throw r1     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            r12 = move-exception
            com.umlaut.crowd.internal.g4 r0 = new com.umlaut.crowd.internal.g4
            r0.<init>(r2, r12)
            throw r0
        L_0x00c7:
            com.umlaut.crowd.internal.g4 r12 = new com.umlaut.crowd.internal.g4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Misplaced value. Try to write tokentype "
            r0.<init>(r1)
            com.umlaut.crowd.internal.n4 r1 = com.umlaut.crowd.internal.n4.JSON_TOKEN_VALUE
            r0.append(r1)
            java.lang.String r1 = " expected was one token of these: "
            r0.append(r1)
            int r1 = r11.l()
            java.util.List r1 = com.umlaut.crowd.internal.n4.b(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            goto L_0x00ee
        L_0x00ed:
            throw r12
        L_0x00ee:
            goto L_0x00ed
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.o4.a(java.io.InputStream):com.umlaut.crowd.internal.o4");
    }

    public void c(boolean z) throws IOException {
        if (z) {
            close();
        } else if (h() == 'd') {
            this.f.flush();
            this.h = true;
        } else {
            throw new IOException("Cannot close stream: Format of JSON is not finished");
        }
    }

    public void b(k4 k4Var) throws g4 {
        int i2 = 0;
        do {
            k4Var.B();
            int i3 = k4Var.m;
            if (i3 != 1) {
                if (i3 == 2) {
                    k4Var.k();
                    j();
                } else if (i3 == 4) {
                    k4Var.H();
                    p();
                } else if (i3 == 8) {
                    k4Var.l();
                    k();
                } else if (i3 != 16) {
                    if (i3 == 32) {
                        a(k4Var.u());
                        continue;
                    } else if (i3 == 64) {
                        a(k4Var.w());
                        continue;
                    } else if (i3 == 128) {
                        a(k4Var.y());
                        continue;
                    } else if (i3 == 512) {
                        g(k4Var.t());
                        continue;
                    } else if (i3 == 1024) {
                        k4Var.x();
                        q();
                        continue;
                    } else if (i3 == 2048) {
                        a(k4Var.s());
                        continue;
                    } else {
                        throw new g4("Unsupported Type: " + n4.a(k4Var.m));
                    }
                } else if (i2 > 0) {
                    b(k4Var.q());
                    continue;
                } else {
                    throw new g4("Unsupported Type: " + n4.a(k4Var.m));
                }
                i2--;
                continue;
            } else {
                k4Var.G();
                o();
            }
            i2++;
            continue;
        } while (i2 != 0);
    }

    public o4 a(long j2) throws g4 {
        return c(Long.toString(j2, 10));
    }

    public o4 a(double d) throws g4 {
        if (Double.isInfinite(d)) {
            throw new g4("Invalid number given: Infinitive is not allowed in JSON");
        } else if (!Double.isNaN(d)) {
            return c(Double.toString(d));
        } else {
            throw new g4("Invalid number given: NaN is not allowed in JSON");
        }
    }

    public o4 a(float f2) throws g4 {
        if (Float.isInfinite(f2)) {
            throw new g4("Invalid number given: Infinitive is not allowed in JSON");
        } else if (!Float.isNaN(f2)) {
            return c(Float.toString(f2));
        } else {
            throw new g4("Invalid number given: NaN is not allowed in JSON");
        }
    }

    public o4 a(Reader reader) throws g4 {
        int read;
        if ((l() & 3813) != 0) {
            if (this.e) {
                a((byte) 44);
            }
            a((byte) 34);
            char[] cArr = new char[512];
            do {
                try {
                    read = reader.read(cArr);
                    if (read > 0) {
                        a(String.valueOf(cArr, 0, read), true);
                    }
                } catch (IOException e2) {
                    throw new g4("Error while reading from Reader:" + e2.getMessage(), e2);
                }
            } while (read != -1);
            a((byte) 34);
            this.e = true;
            this.c = 'v';
            try {
                reader.close();
                return this;
            } catch (IOException e3) {
                throw new g4("Failed to close Reader: " + e3.getMessage(), e3);
            }
        } else {
            throw new g4("Misplaced Stringvalue. Try to write tokentype " + n4.JSON_TOKEN_VALUE_STRING + " expected was one token of these: " + n4.b(l()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fe A[Catch:{ IOException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0103 A[Catch:{ IOException -> 0x0110 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.OutputStream a(java.lang.String r9, boolean r10) throws com.umlaut.crowd.internal.g4 {
        /*
            r8 = this;
            r0 = 0
            if (r10 == 0) goto L_0x0005
            r8.g = r0
        L_0x0005:
            r10 = 512(0x200, float:7.175E-43)
            char[] r1 = new char[r10]
            r2 = 0
            r3 = 0
        L_0x000b:
            int r4 = r9.length()     // Catch:{ IOException -> 0x0110 }
            if (r2 >= r4) goto L_0x010a
            char r4 = r9.charAt(r2)     // Catch:{ IOException -> 0x0110 }
            r5 = 12
            r6 = 92
            if (r4 == r5) goto L_0x00e9
            r5 = 13
            if (r4 == r5) goto L_0x00d6
            r5 = 34
            if (r4 == r5) goto L_0x00c5
            r5 = 47
            if (r4 == r5) goto L_0x00ad
            if (r4 == r6) goto L_0x00c5
            switch(r4) {
                case 8: goto L_0x0099;
                case 9: goto L_0x0086;
                case 10: goto L_0x0073;
                default: goto L_0x002c;
            }     // Catch:{ IOException -> 0x0110 }
        L_0x002c:
            r5 = 32
            if (r4 < r5) goto L_0x0047
            r5 = 128(0x80, float:1.794E-43)
            if (r4 < r5) goto L_0x0038
            r5 = 160(0xa0, float:2.24E-43)
            if (r4 < r5) goto L_0x0047
        L_0x0038:
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r4 < r5) goto L_0x0041
            r5 = 8448(0x2100, float:1.1838E-41)
            if (r4 >= r5) goto L_0x0041
            goto L_0x0047
        L_0x0041:
            int r5 = r3 + 1
            r1[r3] = r4     // Catch:{ IOException -> 0x0110 }
            goto L_0x00fc
        L_0x0047:
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            java.io.OutputStream r3 = r8.f     // Catch:{ IOException -> 0x0110 }
            r3.write(r6)     // Catch:{ IOException -> 0x0110 }
            java.io.OutputStream r3 = r8.f     // Catch:{ IOException -> 0x0110 }
            r5 = 117(0x75, float:1.64E-43)
            r3.write(r5)     // Catch:{ IOException -> 0x0110 }
            java.lang.String r3 = java.lang.Integer.toHexString(r4)     // Catch:{ IOException -> 0x0110 }
            java.io.OutputStream r5 = r8.f     // Catch:{ IOException -> 0x0110 }
            java.lang.String r6 = "0000"
            java.nio.charset.Charset r7 = l     // Catch:{ IOException -> 0x0110 }
            byte[] r6 = r6.getBytes(r7)     // Catch:{ IOException -> 0x0110 }
            int r7 = r3.length()     // Catch:{ IOException -> 0x0110 }
            int r7 = 4 - r7
            r5.write(r6, r0, r7)     // Catch:{ IOException -> 0x0110 }
            r8.a((java.lang.String) r3)     // Catch:{ IOException -> 0x0110 }
            r5 = 0
            goto L_0x00fc
        L_0x0073:
            int r5 = r3 + 2
            if (r5 < r10) goto L_0x007b
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
        L_0x007b:
            int r5 = r3 + 1
            r1[r3] = r6     // Catch:{ IOException -> 0x0110 }
            int r3 = r5 + 1
            r6 = 110(0x6e, float:1.54E-43)
            r1[r5] = r6     // Catch:{ IOException -> 0x0110 }
            goto L_0x00ab
        L_0x0086:
            int r5 = r3 + 2
            if (r5 < r10) goto L_0x008e
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
        L_0x008e:
            int r5 = r3 + 1
            r1[r3] = r6     // Catch:{ IOException -> 0x0110 }
            int r3 = r5 + 1
            r6 = 116(0x74, float:1.63E-43)
            r1[r5] = r6     // Catch:{ IOException -> 0x0110 }
            goto L_0x00ab
        L_0x0099:
            int r5 = r3 + 2
            if (r5 < r10) goto L_0x00a1
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
        L_0x00a1:
            int r5 = r3 + 1
            r1[r3] = r6     // Catch:{ IOException -> 0x0110 }
            int r3 = r5 + 1
            r6 = 98
            r1[r5] = r6     // Catch:{ IOException -> 0x0110 }
        L_0x00ab:
            r5 = r3
            goto L_0x00fc
        L_0x00ad:
            int r5 = r3 + 2
            if (r5 < r10) goto L_0x00b5
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
        L_0x00b5:
            char r5 = r8.g     // Catch:{ IOException -> 0x0110 }
            r7 = 60
            if (r5 != r7) goto L_0x00c0
            int r5 = r3 + 1
            r1[r3] = r6     // Catch:{ IOException -> 0x0110 }
            r3 = r5
        L_0x00c0:
            int r5 = r3 + 1
            r1[r3] = r4     // Catch:{ IOException -> 0x0110 }
            goto L_0x00fc
        L_0x00c5:
            int r5 = r3 + 2
            if (r5 < r10) goto L_0x00cd
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
        L_0x00cd:
            int r5 = r3 + 1
            r1[r3] = r6     // Catch:{ IOException -> 0x0110 }
            int r3 = r5 + 1
            r1[r5] = r4     // Catch:{ IOException -> 0x0110 }
            goto L_0x00ab
        L_0x00d6:
            int r5 = r3 + 2
            if (r5 < r10) goto L_0x00de
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
        L_0x00de:
            int r5 = r3 + 1
            r1[r3] = r6     // Catch:{ IOException -> 0x0110 }
            int r3 = r5 + 1
            r6 = 114(0x72, float:1.6E-43)
            r1[r5] = r6     // Catch:{ IOException -> 0x0110 }
            goto L_0x00ab
        L_0x00e9:
            int r5 = r3 + 2
            if (r5 < r10) goto L_0x00f1
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
        L_0x00f1:
            int r5 = r3 + 1
            r1[r3] = r6     // Catch:{ IOException -> 0x0110 }
            int r3 = r5 + 1
            r6 = 102(0x66, float:1.43E-43)
            r1[r5] = r6     // Catch:{ IOException -> 0x0110 }
            goto L_0x00ab
        L_0x00fc:
            if (r5 < r10) goto L_0x0103
            r8.a((char[]) r1, (int) r5)     // Catch:{ IOException -> 0x0110 }
            r3 = 0
            goto L_0x0104
        L_0x0103:
            r3 = r5
        L_0x0104:
            r8.g = r4     // Catch:{ IOException -> 0x0110 }
            int r2 = r2 + 1
            goto L_0x000b
        L_0x010a:
            r8.a((char[]) r1, (int) r3)     // Catch:{ IOException -> 0x0110 }
            java.io.OutputStream r9 = r8.f
            return r9
        L_0x0110:
            r9 = move-exception
            com.umlaut.crowd.internal.g4 r10 = new com.umlaut.crowd.internal.g4
            java.lang.String r0 = "Error on writing to stream "
            r10.<init>(r0, r9)
            goto L_0x011a
        L_0x0119:
            throw r10
        L_0x011a:
            goto L_0x0119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.o4.a(java.lang.String, boolean):java.io.OutputStream");
    }

    public o4 a(Object obj) throws g4 {
        if (obj == null) {
            return q();
        }
        return a(obj, obj.getClass(), false);
    }

    public o4 a(Object obj, boolean z) throws g4 {
        if (obj == null) {
            return q();
        }
        return a(obj, obj.getClass(), z);
    }

    public o4 a(Object obj, Class<?> cls) throws g4 {
        if (obj == null) {
            return q();
        }
        return a(obj, cls, false);
    }

    public o4 a(Object obj, Class<?> cls, boolean z) throws g4 {
        if (obj == null) {
            return q();
        }
        if (cls == null) {
            throw new g4("No classfile specified");
        } else if (!cls.isAssignableFrom(obj.getClass())) {
            throw new g4("Cannot handle Object as " + cls.getName());
        } else if (cls.equals(Byte.class)) {
            return a((long) ((Byte) obj).byteValue());
        } else {
            if (cls.equals(Short.class)) {
                return a((long) ((Short) obj).shortValue());
            }
            if (cls.equals(Integer.class)) {
                return a((long) ((Integer) obj).intValue());
            }
            if (cls.equals(Long.class)) {
                return a(((Long) obj).longValue());
            }
            if (cls.equals(Float.class)) {
                return a(((Float) obj).floatValue());
            }
            if (cls.equals(Double.class)) {
                return a(((Double) obj).doubleValue());
            }
            if (cls.equals(Boolean.class)) {
                return g(((Boolean) obj).booleanValue());
            }
            if (cls.equals(Character.class)) {
                return a((long) ((Character) obj).charValue());
            }
            if (cls.equals(String.class)) {
                return d((String) obj);
            }
            if (cls.isEnum()) {
                return d(obj.toString());
            }
            if (!cls.isArray()) {
                o4 p = p();
                boolean isAssignableFrom = h4.class.isAssignableFrom(cls);
                if (isAssignableFrom) {
                    int i2 = this.b;
                    ((h4) obj).a(this);
                    if (this.b != i2) {
                        throw new g4("Object was not serilized completely. There may be opened subobjects or arrays.");
                    }
                } else {
                    for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        for (Field field : cls2.getDeclaredFields()) {
                            if (field.getName().charAt(0) != '$') {
                                boolean isAccessible = field.isAccessible();
                                boolean z2 = true;
                                field.setAccessible(true);
                                try {
                                    if (this.k) {
                                        if (!Modifier.isStatic(field.getModifiers()) || !Modifier.isFinal(field.getModifiers())) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            field.setAccessible(isAccessible);
                                        }
                                    }
                                    if (!this.j || !Modifier.isTransient(field.getModifiers())) {
                                        Object obj2 = field.get(obj);
                                        if (obj2 != null) {
                                            p = p.b(field.getName());
                                            a(obj2);
                                        } else if (!z) {
                                            p = p.b(field.getName());
                                            q();
                                        }
                                    }
                                    field.setAccessible(isAccessible);
                                } catch (IllegalAccessException | IllegalArgumentException e2) {
                                    throw new g4("Cannot write Objectvalue \"" + field.getName() + "\" because of " + e2.getMessage(), e2);
                                } catch (Throwable th) {
                                    field.setAccessible(isAccessible);
                                    throw th;
                                }
                            }
                        }
                    }
                }
                return p.k();
            } else if (cls.equals(byte[].class)) {
                return a((byte[]) obj);
            } else {
                o();
                for (int i3 = 0; i3 < Array.getLength(obj); i3++) {
                    a(Array.get(obj, i3));
                }
                j();
                return this;
            }
        }
    }

    @Deprecated
    public void a(k4 k4Var) throws g4 {
        int i2 = 0;
        while (true) {
            k4Var.B();
            int i3 = k4Var.m;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 4) {
                        k4Var.H();
                        p();
                    } else if (i3 != 8) {
                        if (i3 == 16) {
                            b(k4Var.q());
                        } else if (i3 == 32) {
                            a(k4Var.u());
                        } else if (i3 == 64) {
                            a(k4Var.w());
                        } else if (i3 == 128) {
                            a(k4Var.y());
                        } else if (i3 == 512) {
                            g(k4Var.t());
                        } else if (i3 == 1024) {
                            k4Var.x();
                            q();
                        } else if (i3 == 2048) {
                            a(k4Var.s());
                        } else {
                            throw new g4("Unsupported Type: " + n4.a(k4Var.m));
                        }
                    } else if (i2 != 0) {
                        k4Var.l();
                        k();
                    } else {
                        return;
                    }
                } else if (i2 != 0) {
                    k4Var.k();
                    j();
                } else {
                    return;
                }
                i2--;
            } else {
                k4Var.G();
                o();
            }
            i2++;
        }
    }
}
