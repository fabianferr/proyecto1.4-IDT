package com.mbridge.msdk.foundation.same.report;

import com.mbridge.msdk.e.a.a.a;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SocketStack */
public final class t extends a {
    private static final AtomicInteger b = new AtomicInteger(1);
    private final byte a;

    public t(byte b2) {
        this.a = b2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074 A[Catch:{ all -> 0x013e }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096 A[Catch:{ all -> 0x013e }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098 A[Catch:{ all -> 0x013e }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0 A[Catch:{ all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d2 A[Catch:{ all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3 A[ADDED_TO_REGION, Catch:{ all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0102 A[SYNTHETIC, Splitter:B:50:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0119 A[SYNTHETIC, Splitter:B:54:0x0119] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.e.a.a.f a(com.mbridge.msdk.e.a.m<?> r12, java.util.Map<java.lang.String, java.lang.String> r13) throws java.io.IOException {
        /*
            r11 = this;
            boolean r13 = com.mbridge.msdk.e.a.a
            if (r13 == 0) goto L_0x0027
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "SocketStack executeRequest "
            r13.<init>(r0)
            java.lang.String r0 = r12.h()
            r13.append(r0)
            java.lang.String r0 = ":"
            r13.append(r0)
            int r0 = r12.e()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "TrackManager_Volley"
            android.util.Log.d(r0, r13)
        L_0x0027:
            r13 = 0
            java.net.Socket r0 = new java.net.Socket     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = r12.h()     // Catch:{ all -> 0x0154 }
            int r2 = r12.e()     // Catch:{ all -> 0x0154 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0154 }
            int r1 = r12.r()     // Catch:{ all -> 0x014e }
            r0.setSoTimeout(r1)     // Catch:{ all -> 0x014e }
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ all -> 0x014e }
            if (r1 == 0) goto L_0x0146
            r2 = 8
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x0143 }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ all -> 0x0143 }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x013e }
            r3.order(r4)     // Catch:{ all -> 0x013e }
            byte r4 = r11.a     // Catch:{ all -> 0x013e }
            r3.put(r4)     // Catch:{ all -> 0x013e }
            byte[] r12 = r12.n()     // Catch:{ all -> 0x013e }
            r4 = 1
            if (r12 == 0) goto L_0x0064
            int r5 = r12.length     // Catch:{ all -> 0x013e }
            if (r5 != 0) goto L_0x005f
            goto L_0x0064
        L_0x005f:
            r5 = 3
            r3.put(r5)     // Catch:{ all -> 0x013e }
            goto L_0x0067
        L_0x0064:
            r3.put(r4)     // Catch:{ all -> 0x013e }
        L_0x0067:
            java.util.concurrent.atomic.AtomicInteger r5 = b     // Catch:{ all -> 0x013e }
            int r5 = r5.getAndIncrement()     // Catch:{ all -> 0x013e }
            short r5 = (short) r5     // Catch:{ all -> 0x013e }
            r3.putShort(r5)     // Catch:{ all -> 0x013e }
            r5 = 0
            if (r12 == 0) goto L_0x00a7
            int r6 = r12.length     // Catch:{ all -> 0x013e }
            if (r6 != 0) goto L_0x0078
            goto L_0x00a7
        L_0x0078:
            if (r12 == 0) goto L_0x0093
            int r6 = r12.length     // Catch:{ all -> 0x013e }
            if (r6 != 0) goto L_0x007e
            goto L_0x0093
        L_0x007e:
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x013e }
            r6.<init>()     // Catch:{ all -> 0x013e }
            java.util.zip.GZIPOutputStream r7 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x013e }
            r7.<init>(r6)     // Catch:{ all -> 0x013e }
            r7.write(r12)     // Catch:{ all -> 0x013e }
            r7.close()     // Catch:{ all -> 0x013e }
            byte[] r12 = r6.toByteArray()     // Catch:{ all -> 0x013e }
            goto L_0x0094
        L_0x0093:
            r12 = r13
        L_0x0094:
            if (r12 != 0) goto L_0x0098
            r6 = 0
            goto L_0x0099
        L_0x0098:
            int r6 = r12.length     // Catch:{ all -> 0x013e }
        L_0x0099:
            r3.putInt(r6)     // Catch:{ all -> 0x013e }
            byte[] r6 = r3.array()     // Catch:{ all -> 0x013e }
            r1.write(r6)     // Catch:{ all -> 0x013e }
            r1.write(r12)     // Catch:{ all -> 0x013e }
            goto L_0x00b1
        L_0x00a7:
            r3.putInt(r5)     // Catch:{ all -> 0x013e }
            byte[] r12 = r3.array()     // Catch:{ all -> 0x013e }
            r1.write(r12)     // Catch:{ all -> 0x013e }
        L_0x00b1:
            r1.flush()     // Catch:{ all -> 0x013e }
            java.io.InputStream r12 = r0.getInputStream()     // Catch:{ all -> 0x013e }
            byte[] r6 = new byte[r2]     // Catch:{ all -> 0x013e }
            r12.read(r6, r5, r2)     // Catch:{ all -> 0x013e }
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r6)     // Catch:{ all -> 0x013e }
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x0139 }
            r12.order(r2)     // Catch:{ all -> 0x0139 }
            r2 = 4
            int r2 = r12.getInt(r2)     // Catch:{ all -> 0x0139 }
            byte r6 = r6[r4]     // Catch:{ all -> 0x0139 }
            r7 = 2
            if (r6 != r7) goto L_0x00d2
            r6 = 1
            goto L_0x00d3
        L_0x00d2:
            r6 = 0
        L_0x00d3:
            byte[] r7 = new byte[r2]     // Catch:{ all -> 0x0139 }
            java.io.DataInputStream r8 = new java.io.DataInputStream     // Catch:{ all -> 0x0139 }
            java.io.InputStream r9 = r0.getInputStream()     // Catch:{ all -> 0x0139 }
            r8.<init>(r9)     // Catch:{ all -> 0x0139 }
            r8.readFully(r7)     // Catch:{ all -> 0x0139 }
            if (r6 == 0) goto L_0x00fe
            if (r2 != 0) goto L_0x00fe
            com.mbridge.msdk.e.a.a.f r4 = new com.mbridge.msdk.e.a.a.f     // Catch:{ all -> 0x0139 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0139 }
            r5.<init>()     // Catch:{ all -> 0x0139 }
            r6 = 204(0xcc, float:2.86E-43)
            r4.<init>(r6, r5, r2, r13)     // Catch:{ all -> 0x0139 }
        L_0x00f1:
            a((java.io.OutputStream) r1)
            a((java.net.Socket) r0)
            r11.a((java.nio.ByteBuffer) r3)
            r11.a((java.nio.ByteBuffer) r12)
            return r4
        L_0x00fe:
            r6 = 500(0x1f4, float:7.0E-43)
            if (r2 >= r4) goto L_0x0119
            com.mbridge.msdk.e.a.a.f r2 = new com.mbridge.msdk.e.a.a.f     // Catch:{ all -> 0x0139 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0139 }
            r4.<init>()     // Catch:{ all -> 0x0139 }
            r2.<init>(r6, r4, r5, r13)     // Catch:{ all -> 0x0139 }
        L_0x010c:
            a((java.io.OutputStream) r1)
            a((java.net.Socket) r0)
            r11.a((java.nio.ByteBuffer) r3)
            r11.a((java.nio.ByteBuffer) r12)
            return r2
        L_0x0119:
            byte r7 = r7[r5]     // Catch:{ all -> 0x0139 }
            if (r7 != r4) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r4 = 0
        L_0x011f:
            if (r4 == 0) goto L_0x012e
            com.mbridge.msdk.e.a.a.f r4 = new com.mbridge.msdk.e.a.a.f     // Catch:{ all -> 0x0139 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0139 }
            r5.<init>()     // Catch:{ all -> 0x0139 }
            r6 = 200(0xc8, float:2.8E-43)
            r4.<init>(r6, r5, r2, r13)     // Catch:{ all -> 0x0139 }
            goto L_0x00f1
        L_0x012e:
            com.mbridge.msdk.e.a.a.f r2 = new com.mbridge.msdk.e.a.a.f     // Catch:{ all -> 0x0139 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0139 }
            r4.<init>()     // Catch:{ all -> 0x0139 }
            r2.<init>(r6, r4, r5, r13)     // Catch:{ all -> 0x0139 }
            goto L_0x010c
        L_0x0139:
            r13 = move-exception
            r10 = r0
            r0 = r12
            r12 = r13
            goto L_0x0141
        L_0x013e:
            r12 = move-exception
            r10 = r0
            r0 = r13
        L_0x0141:
            r13 = r10
            goto L_0x0158
        L_0x0143:
            r12 = move-exception
            r3 = r13
            goto L_0x0151
        L_0x0146:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ all -> 0x0143 }
            java.lang.String r2 = "create outputStream exception"
            r12.<init>(r2)     // Catch:{ all -> 0x0143 }
            throw r12     // Catch:{ all -> 0x0143 }
        L_0x014e:
            r12 = move-exception
            r1 = r13
            r3 = r1
        L_0x0151:
            r13 = r0
            r0 = r3
            goto L_0x0158
        L_0x0154:
            r12 = move-exception
            r0 = r13
            r1 = r0
            r3 = r1
        L_0x0158:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x015e }
            r2.<init>(r12)     // Catch:{ all -> 0x015e }
            throw r2     // Catch:{ all -> 0x015e }
        L_0x015e:
            r12 = move-exception
            a((java.io.OutputStream) r1)
            a((java.net.Socket) r13)
            r11.a((java.nio.ByteBuffer) r3)
            r11.a((java.nio.ByteBuffer) r0)
            goto L_0x016d
        L_0x016c:
            throw r12
        L_0x016d:
            goto L_0x016c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.t.a(com.mbridge.msdk.e.a.m, java.util.Map):com.mbridge.msdk.e.a.a.f");
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }
}
