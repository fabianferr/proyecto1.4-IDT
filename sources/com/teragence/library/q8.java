package com.teragence.library;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class q8 extends s8 {
    public q8(String str, int i) {
        super(str, i);
    }

    private InputStream a(InputStream inputStream) {
        try {
            return (GZIPInputStream) inputStream;
        } catch (ClassCastException unused) {
            return new GZIPInputStream(inputStream);
        }
    }

    private InputStream a(InputStream inputStream, int i, File file) {
        OutputStream outputStream;
        if (file != null) {
            outputStream = new FileOutputStream(file);
        } else {
            if (i <= 0) {
                i = 262144;
            }
            outputStream = new ByteArrayOutputStream(i);
        }
        byte[] bArr = new byte[256];
        while (true) {
            int read = inputStream.read(bArr, 0, 256);
            if (read == -1) {
                break;
            }
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        if (outputStream instanceof ByteArrayOutputStream) {
            bArr = ((ByteArrayOutputStream) outputStream).toByteArray();
        }
        new String(bArr);
        inputStream.close();
        return file != null ? new FileInputStream(file) : new ByteArrayInputStream(bArr);
    }

    public r8 a() {
        throw null;
    }

    public List a(String str, y7 y7Var, List list) {
        return a(str, y7Var, list, (File) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(java.lang.String r17, com.teragence.library.y7 r18, java.util.List r19, java.io.File r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r18
            r0 = r19
            r3 = r20
            if (r17 != 0) goto L_0x000d
            java.lang.String r4 = "\"\""
            goto L_0x000f
        L_0x000d:
            r4 = r17
        L_0x000f:
            java.lang.String r5 = "UTF-8"
            byte[] r5 = r1.a((com.teragence.library.y7) r2, (java.lang.String) r5)
            boolean r6 = r1.d
            if (r6 == 0) goto L_0x001e
            java.lang.String r6 = new java.lang.String
            r6.<init>(r5)
        L_0x001e:
            com.teragence.library.r8 r6 = r16.a()
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = "ksoap2-android/2.6.0+;version=3.6.4"
            r6.a(r7, r8)
            int r7 = r2.e
            r8 = 120(0x78, float:1.68E-43)
            if (r7 == r8) goto L_0x0034
            java.lang.String r7 = "SOAPAction"
            r6.a(r7, r4)
        L_0x0034:
            int r4 = r2.e
            java.lang.String r7 = "Content-Type"
            if (r4 != r8) goto L_0x003d
            java.lang.String r4 = "application/soap+xml;charset=utf-8"
            goto L_0x0040
        L_0x003d:
            java.lang.String r4 = "text/xml;charset=utf-8"
        L_0x0040:
            r6.a(r7, r4)
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r8 = "gzip"
            r6.a(r4, r8)
            r4 = 0
            if (r0 == 0) goto L_0x0068
            r9 = 0
        L_0x004e:
            int r10 = r19.size()
            if (r9 >= r10) goto L_0x0068
            java.lang.Object r10 = r0.get(r9)
            com.teragence.library.x7 r10 = (com.teragence.library.x7) r10
            java.lang.String r11 = r10.a()
            java.lang.String r10 = r10.b()
            r6.a(r11, r10)
            int r9 = r9 + 1
            goto L_0x004e
        L_0x0068:
            java.lang.String r0 = "POST"
            r6.a((java.lang.String) r0)
            r1.a((byte[]) r5, (com.teragence.library.r8) r6, (com.teragence.library.y7) r2)
            int r0 = r6.e()
            java.util.List r10 = r6.a()     // Catch:{ IOException -> 0x0121 }
            r11 = 0
            r12 = 0
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x007c:
            int r14 = r10.size()     // Catch:{ IOException -> 0x011d }
            if (r4 >= r14) goto L_0x00df
            java.lang.Object r14 = r10.get(r4)     // Catch:{ IOException -> 0x011d }
            com.teragence.library.x7 r14 = (com.teragence.library.x7) r14     // Catch:{ IOException -> 0x011d }
            java.lang.String r15 = r14.a()     // Catch:{ IOException -> 0x011d }
            if (r15 != 0) goto L_0x008f
            goto L_0x00dc
        L_0x008f:
            java.lang.String r15 = r14.a()     // Catch:{ IOException -> 0x011d }
            java.lang.String r5 = "content-length"
            boolean r5 = r15.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x011d }
            if (r5 == 0) goto L_0x00ac
            java.lang.String r5 = r14.b()     // Catch:{ IOException -> 0x011d }
            if (r5 == 0) goto L_0x00ac
            java.lang.String r5 = r14.b()     // Catch:{ NumberFormatException -> 0x00aa }
            int r13 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x00aa }
            goto L_0x00ac
        L_0x00aa:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            java.lang.String r5 = r14.a()     // Catch:{ IOException -> 0x011d }
            boolean r5 = r5.equalsIgnoreCase(r7)     // Catch:{ IOException -> 0x011d }
            r15 = 1
            if (r5 == 0) goto L_0x00c5
            java.lang.String r5 = r14.b()     // Catch:{ IOException -> 0x011d }
            java.lang.String r9 = "xml"
            boolean r5 = r5.contains(r9)     // Catch:{ IOException -> 0x011d }
            if (r5 == 0) goto L_0x00c5
            r12 = 1
        L_0x00c5:
            java.lang.String r5 = r14.a()     // Catch:{ IOException -> 0x011d }
            java.lang.String r9 = "Content-Encoding"
            boolean r5 = r5.equalsIgnoreCase(r9)     // Catch:{ IOException -> 0x011d }
            if (r5 == 0) goto L_0x00dc
            java.lang.String r5 = r14.b()     // Catch:{ IOException -> 0x011d }
            boolean r5 = r5.equalsIgnoreCase(r8)     // Catch:{ IOException -> 0x011d }
            if (r5 == 0) goto L_0x00dc
            r11 = 1
        L_0x00dc:
            int r4 = r4 + 1
            goto L_0x007c
        L_0x00df:
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 == r4) goto L_0x00ff
            r4 = 202(0xca, float:2.83E-43)
            if (r0 != r4) goto L_0x00e8
            goto L_0x00ff
        L_0x00e8:
            com.teragence.library.p8 r4 = new com.teragence.library.p8     // Catch:{ IOException -> 0x011d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011d }
            r5.<init>()     // Catch:{ IOException -> 0x011d }
            java.lang.String r7 = "HTTP request failed, HTTP status: "
            r5.append(r7)     // Catch:{ IOException -> 0x011d }
            r5.append(r0)     // Catch:{ IOException -> 0x011d }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x011d }
            r4.<init>(r5, r0, r10)     // Catch:{ IOException -> 0x011d }
            throw r4     // Catch:{ IOException -> 0x011d }
        L_0x00ff:
            if (r13 <= 0) goto L_0x011b
            if (r11 == 0) goto L_0x0111
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x011d }
            java.io.InputStream r4 = r6.f()     // Catch:{ IOException -> 0x011d }
            r0.<init>(r4, r13)     // Catch:{ IOException -> 0x011d }
            java.io.InputStream r9 = r1.a(r0)     // Catch:{ IOException -> 0x011d }
            goto L_0x0157
        L_0x0111:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x011d }
            java.io.InputStream r4 = r6.f()     // Catch:{ IOException -> 0x011d }
            r0.<init>(r4, r13)     // Catch:{ IOException -> 0x011d }
            goto L_0x0158
        L_0x011b:
            r9 = 0
            goto L_0x0157
        L_0x011d:
            r0 = move-exception
            r4 = r11
            r5 = r13
            goto L_0x0126
        L_0x0121:
            r0 = move-exception
            r5 = 8192(0x2000, float:1.14794E-41)
            r10 = 0
            r12 = 0
        L_0x0126:
            if (r5 <= 0) goto L_0x0142
            if (r4 == 0) goto L_0x0138
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream
            java.io.InputStream r7 = r6.b()
            r4.<init>(r7, r5)
            java.io.InputStream r9 = r1.a(r4)
            goto L_0x0143
        L_0x0138:
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream
            java.io.InputStream r4 = r6.b()
            r9.<init>(r4, r5)
            goto L_0x0143
        L_0x0142:
            r9 = 0
        L_0x0143:
            boolean r4 = r0 instanceof com.teragence.library.p8
            if (r4 == 0) goto L_0x0156
            if (r12 != 0) goto L_0x0156
            boolean r2 = r1.d
            if (r2 == 0) goto L_0x0152
            if (r9 == 0) goto L_0x0152
            r1.a((java.io.InputStream) r9, (int) r5, (java.io.File) r3)
        L_0x0152:
            r6.c()
            throw r0
        L_0x0156:
            r13 = r5
        L_0x0157:
            r0 = r9
        L_0x0158:
            boolean r4 = r1.d
            if (r4 == 0) goto L_0x0160
            java.io.InputStream r0 = r1.a((java.io.InputStream) r0, (int) r13, (java.io.File) r3)
        L_0x0160:
            if (r0 == 0) goto L_0x0165
            r1.a((com.teragence.library.y7) r2, (java.io.InputStream) r0, (java.util.List) r10)
        L_0x0165:
            r6.c()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.q8.a(java.lang.String, com.teragence.library.y7, java.util.List, java.io.File):java.util.List");
    }

    /* access modifiers changed from: protected */
    public void a(y7 y7Var, InputStream inputStream, List list) {
        a(y7Var, inputStream);
    }

    public void a(String str, y7 y7Var) {
        a(str, y7Var, (List) null);
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, r8 r8Var, y7 y7Var) {
        r8Var.a("Content-Length", "" + bArr.length);
        r8Var.a(bArr.length);
        OutputStream d = r8Var.d();
        d.write(bArr, 0, bArr.length);
        d.flush();
        d.close();
    }
}
