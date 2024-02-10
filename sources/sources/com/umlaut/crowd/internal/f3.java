package com.umlaut.crowd.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class f3 {
    private static int c(InputStream inputStream) throws u9, IOException {
        int read = inputStream.read();
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            if (read == -1) {
                return -1;
            }
            i = (i << 7) + (read & 127);
            if ((read & 128) == 0) {
                break;
            }
            read = inputStream.read();
        }
        if ((read & 128) == 0) {
            return i;
        }
        throw new u9("Length is too high!");
    }

    public u5 b(InputStream inputStream) throws u9, IOException {
        return (u5) a(inputStream, false);
    }

    private void a(int i, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[5];
        int i2 = 0;
        while (i2 < 5) {
            bArr[i2] = (byte) (i & 127);
            if (i == 0) {
                while (true) {
                    i2--;
                    if (i2 > 0) {
                        outputStream.write(bArr[i2] | 128);
                    } else {
                        outputStream.write(bArr[0] & Byte.MAX_VALUE);
                        return;
                    }
                }
            } else {
                i >>= 7;
                i2++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0059, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object a(java.io.InputStream r8, boolean r9) throws com.umlaut.crowd.internal.u9, java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "Unknown Messagetype:"
            monitor-enter(r8)
            int r1 = c(r8)     // Catch:{ g4 -> 0x0076 }
            r2 = -1
            if (r1 != r2) goto L_0x000d
            monitor-exit(r8)     // Catch:{ all -> 0x0074 }
            r8 = 0
            return r8
        L_0x000d:
            int r3 = c(r8)     // Catch:{ g4 -> 0x0076 }
            com.umlaut.crowd.internal.v5 r4 = com.umlaut.crowd.internal.v5.a(r3)     // Catch:{ g4 -> 0x0076 }
            if (r4 == 0) goto L_0x0062
            byte[] r0 = new byte[r1]     // Catch:{ g4 -> 0x0076 }
            r3 = 0
            r5 = 0
        L_0x001b:
            int r6 = r1 + -1
            if (r3 >= r6) goto L_0x0029
            int r5 = r1 - r3
            int r5 = r8.read(r0, r3, r5)     // Catch:{ g4 -> 0x0076 }
            if (r5 == r2) goto L_0x0029
            int r3 = r3 + r5
            goto L_0x001b
        L_0x0029:
            if (r5 == r2) goto L_0x005a
            com.umlaut.crowd.internal.k4 r1 = new com.umlaut.crowd.internal.k4     // Catch:{ g4 -> 0x0076 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ g4 -> 0x0076 }
            r2.<init>(r0)     // Catch:{ g4 -> 0x0076 }
            r1.<init>(r2)     // Catch:{ g4 -> 0x0076 }
            r0 = 1
            if (r9 == 0) goto L_0x0041
            java.lang.Class r9 = r4.b()     // Catch:{ all -> 0x004e }
            java.lang.Object r9 = r1.a((java.lang.Class<?>) r9, (boolean) r0)     // Catch:{ all -> 0x004e }
            goto L_0x0049
        L_0x0041:
            java.lang.Class r9 = r4.c()     // Catch:{ all -> 0x004e }
            java.lang.Object r9 = r1.a((java.lang.Class<?>) r9, (boolean) r0)     // Catch:{ all -> 0x004e }
        L_0x0049:
            r1.close()     // Catch:{ g4 -> 0x0076 }
            monitor-exit(r8)     // Catch:{ all -> 0x0074 }
            return r9
        L_0x004e:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r1 = move-exception
            r9.addSuppressed(r1)     // Catch:{ g4 -> 0x0076 }
        L_0x0059:
            throw r0     // Catch:{ g4 -> 0x0076 }
        L_0x005a:
            com.umlaut.crowd.internal.u9 r9 = new com.umlaut.crowd.internal.u9     // Catch:{ g4 -> 0x0076 }
            java.lang.String r0 = "Cannot read Request: end of transmission"
            r9.<init>(r0)     // Catch:{ g4 -> 0x0076 }
            throw r9     // Catch:{ g4 -> 0x0076 }
        L_0x0062:
            com.umlaut.crowd.internal.u9 r9 = new com.umlaut.crowd.internal.u9     // Catch:{ g4 -> 0x0076 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ g4 -> 0x0076 }
            r1.<init>(r0)     // Catch:{ g4 -> 0x0076 }
            r1.append(r3)     // Catch:{ g4 -> 0x0076 }
            java.lang.String r0 = r1.toString()     // Catch:{ g4 -> 0x0076 }
            r9.<init>(r0)     // Catch:{ g4 -> 0x0076 }
            throw r9     // Catch:{ g4 -> 0x0076 }
        L_0x0074:
            r9 = move-exception
            goto L_0x0092
        L_0x0076:
            r9 = move-exception
            com.umlaut.crowd.internal.u9 r0 = new com.umlaut.crowd.internal.u9     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Error while parsing..."
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r9.getMessage()     // Catch:{ all -> 0x0074 }
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            r0.<init>(r1, r9)     // Catch:{ all -> 0x0074 }
            throw r0     // Catch:{ all -> 0x0074 }
        L_0x0092:
            monitor-exit(r8)     // Catch:{ all -> 0x0074 }
            goto L_0x0095
        L_0x0094:
            throw r9
        L_0x0095:
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.f3.a(java.io.InputStream, boolean):java.lang.Object");
    }

    public s5 a(InputStream inputStream) throws u9, IOException {
        return (s5) a(inputStream, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.OutputStream r4, com.umlaut.crowd.internal.t5 r5) throws com.umlaut.crowd.internal.u9, java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "Error while writing..."
            monitor-enter(r4)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0050 }
            r1.<init>()     // Catch:{ all -> 0x0050 }
            com.umlaut.crowd.internal.o4 r2 = new com.umlaut.crowd.internal.o4     // Catch:{ IOException -> 0x0039, g4 -> 0x0037 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0039, g4 -> 0x0037 }
            r2.a((java.lang.Object) r5)     // Catch:{ all -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x0039, g4 -> 0x0037 }
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x0050 }
            int r1 = r0.length     // Catch:{ all -> 0x0050 }
            r3.a((int) r1, (java.io.OutputStream) r4)     // Catch:{ all -> 0x0050 }
            com.umlaut.crowd.internal.v5 r5 = r5.c()     // Catch:{ all -> 0x0050 }
            int r5 = r5.a()     // Catch:{ all -> 0x0050 }
            r3.a((int) r5, (java.io.OutputStream) r4)     // Catch:{ all -> 0x0050 }
            r4.write(r0)     // Catch:{ all -> 0x0050 }
            monitor-exit(r4)     // Catch:{ all -> 0x0050 }
            return
        L_0x002b:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x002d }
        L_0x002d:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r2 = move-exception
            r5.addSuppressed(r2)     // Catch:{ IOException -> 0x0039, g4 -> 0x0037 }
        L_0x0036:
            throw r1     // Catch:{ IOException -> 0x0039, g4 -> 0x0037 }
        L_0x0037:
            r5 = move-exception
            goto L_0x003a
        L_0x0039:
            r5 = move-exception
        L_0x003a:
            com.umlaut.crowd.internal.u9 r1 = new com.umlaut.crowd.internal.u9     // Catch:{ all -> 0x0050 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            r2.<init>(r0)     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = r5.getMessage()     // Catch:{ all -> 0x0050 }
            r2.append(r0)     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0050 }
            r1.<init>(r0, r5)     // Catch:{ all -> 0x0050 }
            throw r1     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0050 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.f3.a(java.io.OutputStream, com.umlaut.crowd.internal.t5):void");
    }

    public void a(OutputStream outputStream, u5 u5Var) throws u9, IOException {
        a(outputStream, (t5) u5Var);
    }

    public void a(OutputStream outputStream, s5 s5Var) throws u9, IOException {
        a(outputStream, (t5) s5Var);
    }
}
