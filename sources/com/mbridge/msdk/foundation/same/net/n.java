package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.f.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

/* compiled from: SocketManager */
public final class n {
    /* access modifiers changed from: private */
    public static volatile AtomicInteger a = new AtomicInteger(1);
    private ExecutorService b;

    /* compiled from: SocketManager */
    private static final class b {
        /* access modifiers changed from: private */
        public static n a = new n();
    }

    private n() {
        this.b = new ThreadPoolExecutor(5, 10, 5, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("SocketThreadPool");
                return newThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static n a() {
        return b.a;
    }

    public final void a(String str, int i, String str2, boolean z, e eVar) {
        final a aVar = new a(str, i, str2, z, eVar);
        this.b.execute(new Runnable() {
            public final void run() {
                aVar.a();
            }
        });
    }

    /* compiled from: SocketManager */
    public class a {
        private String b;
        private ByteBuffer c;
        private OutputStream d;
        private boolean e;
        private e f;
        private Socket g;
        private String h;
        private int i;

        a(String str, int i2, String str2, boolean z, e eVar) {
            this.h = str;
            this.i = i2;
            this.b = str2;
            this.e = z;
            this.f = eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x008b A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0091 A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00b3 A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00c5 A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x014d A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x014f A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0153 A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0155 A[Catch:{ all -> 0x027c, all -> 0x02a6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x019d  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x01b6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r16 = this;
                r1 = r16
                java.lang.String r0 = " length : "
                java.lang.String r2 = "SocketManager"
                java.lang.String r3 = "Socket Response length : "
                java.lang.String r4 = "Socket Response : header : "
                java.lang.String r5 = "Socket Request : header : "
                java.lang.String r6 = "Socket connect : "
                java.lang.String r7 = "Socket exception: "
                java.net.Socket r9 = new java.net.Socket     // Catch:{ all -> 0x02a6 }
                java.lang.String r10 = r1.h     // Catch:{ all -> 0x02a6 }
                int r11 = r1.i     // Catch:{ all -> 0x02a6 }
                r9.<init>(r10, r11)     // Catch:{ all -> 0x02a6 }
                r1.g = r9     // Catch:{ all -> 0x02a6 }
                r10 = 15000(0x3a98, float:2.102E-41)
                r9.setSoTimeout(r10)     // Catch:{ all -> 0x02a6 }
                java.lang.String r9 = r1.h     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.same.net.g.d r10 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ all -> 0x02a6 }
                java.lang.String r10 = r10.h     // Catch:{ all -> 0x02a6 }
                boolean r9 = r9.contains(r10)     // Catch:{ all -> 0x02a6 }
                r10 = 0
                r11 = 1
                if (r9 != 0) goto L_0x0041
                java.lang.String r9 = r1.h     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.same.net.g.d r12 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ all -> 0x02a6 }
                java.lang.String r12 = r12.i     // Catch:{ all -> 0x02a6 }
                boolean r9 = r9.contains(r12)     // Catch:{ all -> 0x02a6 }
                if (r9 == 0) goto L_0x003f
                goto L_0x0041
            L_0x003f:
                r9 = 0
                goto L_0x0042
            L_0x0041:
                r9 = 1
            L_0x0042:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a6 }
                r12.<init>(r6)     // Catch:{ all -> 0x02a6 }
                java.lang.String r6 = r1.h     // Catch:{ all -> 0x02a6 }
                r12.append(r6)     // Catch:{ all -> 0x02a6 }
                java.lang.String r6 = " : "
                r12.append(r6)     // Catch:{ all -> 0x02a6 }
                int r6 = r1.i     // Catch:{ all -> 0x02a6 }
                r12.append(r6)     // Catch:{ all -> 0x02a6 }
                java.lang.String r6 = " isAnalytics : "
                r12.append(r6)     // Catch:{ all -> 0x02a6 }
                r12.append(r9)     // Catch:{ all -> 0x02a6 }
                java.lang.String r6 = r12.toString()     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.tools.aa.d(r2, r6)     // Catch:{ all -> 0x02a6 }
                java.net.Socket r6 = r1.g     // Catch:{ all -> 0x02a6 }
                java.io.OutputStream r6 = r6.getOutputStream()     // Catch:{ all -> 0x02a6 }
                r1.d = r6     // Catch:{ all -> 0x02a6 }
                r6 = 8
                byte[] r12 = new byte[r6]     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r12)     // Catch:{ all -> 0x02a6 }
                r1.c = r12     // Catch:{ all -> 0x02a6 }
                java.nio.ByteOrder r13 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x02a6 }
                r12.order(r13)     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r12 = r1.c     // Catch:{ all -> 0x02a6 }
                r13 = 2
                r12.put(r13)     // Catch:{ all -> 0x02a6 }
                java.lang.String r12 = r1.b     // Catch:{ all -> 0x02a6 }
                boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x02a6 }
                r14 = 3
                if (r12 == 0) goto L_0x0091
                java.nio.ByteBuffer r12 = r1.c     // Catch:{ all -> 0x02a6 }
                r12.put(r11)     // Catch:{ all -> 0x02a6 }
                goto L_0x009d
            L_0x0091:
                java.nio.ByteBuffer r12 = r1.c     // Catch:{ all -> 0x02a6 }
                boolean r15 = r1.e     // Catch:{ all -> 0x02a6 }
                if (r15 == 0) goto L_0x0099
                r15 = 3
                goto L_0x009a
            L_0x0099:
                r15 = 2
            L_0x009a:
                r12.put(r15)     // Catch:{ all -> 0x02a6 }
            L_0x009d:
                java.nio.ByteBuffer r12 = r1.c     // Catch:{ all -> 0x02a6 }
                java.util.concurrent.atomic.AtomicInteger r15 = com.mbridge.msdk.foundation.same.net.n.a     // Catch:{ all -> 0x02a6 }
                int r15 = r15.getAndIncrement()     // Catch:{ all -> 0x02a6 }
                short r15 = (short) r15     // Catch:{ all -> 0x02a6 }
                r12.putShort(r15)     // Catch:{ all -> 0x02a6 }
                java.lang.String r12 = r1.b     // Catch:{ all -> 0x02a6 }
                boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x02a6 }
                if (r12 == 0) goto L_0x00c5
                java.nio.ByteBuffer r12 = r1.c     // Catch:{ all -> 0x02a6 }
                r12.putInt(r10)     // Catch:{ all -> 0x02a6 }
                java.io.OutputStream r12 = r1.d     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r15 = r1.c     // Catch:{ all -> 0x02a6 }
                byte[] r15 = r15.array()     // Catch:{ all -> 0x02a6 }
                r12.write(r15)     // Catch:{ all -> 0x02a6 }
                r12 = 0
                goto L_0x0108
            L_0x00c5:
                boolean r12 = r1.e     // Catch:{ all -> 0x02a6 }
                if (r12 == 0) goto L_0x00ec
                java.lang.String r12 = r1.b     // Catch:{ all -> 0x02a6 }
                boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x02a6 }
                if (r15 == 0) goto L_0x00d3
                r8 = 0
                goto L_0x00f2
            L_0x00d3:
                java.io.ByteArrayOutputStream r15 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x02a6 }
                r15.<init>()     // Catch:{ all -> 0x02a6 }
                java.util.zip.GZIPOutputStream r8 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x02a6 }
                r8.<init>(r15)     // Catch:{ all -> 0x02a6 }
                byte[] r12 = r12.getBytes()     // Catch:{ all -> 0x02a6 }
                r8.write(r12)     // Catch:{ all -> 0x02a6 }
                r8.close()     // Catch:{ all -> 0x02a6 }
                byte[] r8 = r15.toByteArray()     // Catch:{ all -> 0x02a6 }
                goto L_0x00f2
            L_0x00ec:
                java.lang.String r8 = r1.b     // Catch:{ all -> 0x02a6 }
                byte[] r8 = r8.getBytes()     // Catch:{ all -> 0x02a6 }
            L_0x00f2:
                int r12 = r8.length     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r15 = r1.c     // Catch:{ all -> 0x02a6 }
                r15.putInt(r12)     // Catch:{ all -> 0x02a6 }
                java.io.OutputStream r15 = r1.d     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r13 = r1.c     // Catch:{ all -> 0x02a6 }
                byte[] r13 = r13.array()     // Catch:{ all -> 0x02a6 }
                r15.write(r13)     // Catch:{ all -> 0x02a6 }
                java.io.OutputStream r13 = r1.d     // Catch:{ all -> 0x02a6 }
                r13.write(r8)     // Catch:{ all -> 0x02a6 }
            L_0x0108:
                java.io.OutputStream r8 = r1.d     // Catch:{ all -> 0x02a6 }
                r8.flush()     // Catch:{ all -> 0x02a6 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a6 }
                r8.<init>(r5)     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r5 = r1.c     // Catch:{ all -> 0x02a6 }
                byte[] r5 = r5.array()     // Catch:{ all -> 0x02a6 }
                java.lang.String r5 = java.util.Arrays.toString(r5)     // Catch:{ all -> 0x02a6 }
                r8.append(r5)     // Catch:{ all -> 0x02a6 }
                r8.append(r0)     // Catch:{ all -> 0x02a6 }
                r8.append(r12)     // Catch:{ all -> 0x02a6 }
                java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r2, (java.lang.String) r5)     // Catch:{ all -> 0x02a6 }
                java.net.Socket r5 = r1.g     // Catch:{ all -> 0x02a6 }
                java.io.InputStream r5 = r5.getInputStream()     // Catch:{ all -> 0x02a6 }
                byte[] r8 = new byte[r6]     // Catch:{ all -> 0x02a6 }
                r5.read(r8, r10, r6)     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r12 = java.nio.ByteBuffer.wrap(r8)     // Catch:{ all -> 0x02a6 }
                r1.c = r12     // Catch:{ all -> 0x02a6 }
                java.nio.ByteOrder r13 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x02a6 }
                r12.order(r13)     // Catch:{ all -> 0x02a6 }
                java.nio.ByteBuffer r12 = r1.c     // Catch:{ all -> 0x02a6 }
                r13 = 4
                int r12 = r12.getInt(r13)     // Catch:{ all -> 0x02a6 }
                byte r13 = r8[r11]     // Catch:{ all -> 0x02a6 }
                if (r13 != r14) goto L_0x014f
                r14 = 1
                goto L_0x0150
            L_0x014f:
                r14 = 0
            L_0x0150:
                r15 = 2
                if (r13 != r15) goto L_0x0155
                r13 = 1
                goto L_0x0156
            L_0x0155:
                r13 = 0
            L_0x0156:
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a6 }
                r15.<init>(r4)     // Catch:{ all -> 0x02a6 }
                java.lang.String r4 = java.util.Arrays.toString(r8)     // Catch:{ all -> 0x02a6 }
                r15.append(r4)     // Catch:{ all -> 0x02a6 }
                r15.append(r0)     // Catch:{ all -> 0x02a6 }
                r15.append(r12)     // Catch:{ all -> 0x02a6 }
                java.lang.String r0 = " isGzip : "
                r15.append(r0)     // Catch:{ all -> 0x02a6 }
                r15.append(r14)     // Catch:{ all -> 0x02a6 }
                java.lang.String r0 = r15.toString()     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)     // Catch:{ all -> 0x02a6 }
                byte[] r0 = new byte[r12]     // Catch:{ all -> 0x02a6 }
                java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ all -> 0x02a6 }
                java.net.Socket r8 = r1.g     // Catch:{ all -> 0x02a6 }
                java.io.InputStream r8 = r8.getInputStream()     // Catch:{ all -> 0x02a6 }
                r4.<init>(r8)     // Catch:{ all -> 0x02a6 }
                r4.readFully(r0)     // Catch:{ all -> 0x02a6 }
                if (r14 != 0) goto L_0x0199
                r4 = 2
                if (r12 <= r4) goto L_0x0199
                byte r4 = r0[r10]     // Catch:{ all -> 0x02a6 }
                int r4 = r4 << r6
                byte r6 = r0[r11]     // Catch:{ all -> 0x02a6 }
                r6 = r6 & 255(0xff, float:3.57E-43)
                r4 = r4 | r6
                r6 = 8075(0x1f8b, float:1.1315E-41)
                if (r4 != r6) goto L_0x0199
                r14 = 1
            L_0x0199:
                com.mbridge.msdk.foundation.same.net.e r4 = r1.f     // Catch:{ all -> 0x02a6 }
                if (r4 != 0) goto L_0x01b6
                java.net.Socket r0 = r1.g
                if (r0 == 0) goto L_0x01b5
                r0.close()     // Catch:{ IOException -> 0x01ad }
                r3 = 0
                r1.c = r3     // Catch:{ IOException -> 0x01ad }
                java.io.OutputStream r0 = r1.d     // Catch:{ IOException -> 0x01ad }
                r0.close()     // Catch:{ IOException -> 0x01ad }
                goto L_0x01b5
            L_0x01ad:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
            L_0x01b5:
                return
            L_0x01b6:
                if (r13 == 0) goto L_0x01e1
                if (r12 != 0) goto L_0x01e1
                com.mbridge.msdk.foundation.same.net.f.c r0 = new com.mbridge.msdk.foundation.same.net.f.c     // Catch:{ all -> 0x02a6 }
                r3 = 204(0xcc, float:2.86E-43)
                r5 = 0
                r0.<init>(r3, r5, r5)     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.same.net.l r0 = com.mbridge.msdk.foundation.same.net.l.a(r5, r0)     // Catch:{ all -> 0x02a6 }
                r4.onSuccess(r0)     // Catch:{ all -> 0x02a6 }
                java.net.Socket r0 = r1.g
                if (r0 == 0) goto L_0x01e0
                r0.close()     // Catch:{ IOException -> 0x01d8 }
                r1.c = r5     // Catch:{ IOException -> 0x01d8 }
                java.io.OutputStream r0 = r1.d     // Catch:{ IOException -> 0x01d8 }
                r0.close()     // Catch:{ IOException -> 0x01d8 }
                goto L_0x01e0
            L_0x01d8:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
            L_0x01e0:
                return
            L_0x01e1:
                if (r12 >= r11) goto L_0x0201
                java.lang.String r0 = "The response data less than 1"
                r1.a(r0)     // Catch:{ all -> 0x02a6 }
                java.net.Socket r0 = r1.g
                if (r0 == 0) goto L_0x0200
                r0.close()     // Catch:{ IOException -> 0x01f8 }
                r3 = 0
                r1.c = r3     // Catch:{ IOException -> 0x01f8 }
                java.io.OutputStream r0 = r1.d     // Catch:{ IOException -> 0x01f8 }
                r0.close()     // Catch:{ IOException -> 0x01f8 }
                goto L_0x0200
            L_0x01f8:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
            L_0x0200:
                return
            L_0x0201:
                r6 = 200(0xc8, float:2.8E-43)
                if (r9 == 0) goto L_0x0235
                byte r0 = r0[r10]     // Catch:{ all -> 0x02a6 }
                if (r0 != r11) goto L_0x0217
                com.mbridge.msdk.foundation.same.net.f.c r0 = new com.mbridge.msdk.foundation.same.net.f.c     // Catch:{ all -> 0x02a6 }
                r3 = 0
                r0.<init>(r6, r3, r3)     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.same.net.l r0 = com.mbridge.msdk.foundation.same.net.l.a(r3, r0)     // Catch:{ all -> 0x02a6 }
                r4.onSuccess(r0)     // Catch:{ all -> 0x02a6 }
                goto L_0x021c
            L_0x0217:
                java.lang.String r0 = "The server returns fail"
                r1.a(r0)     // Catch:{ all -> 0x02a6 }
            L_0x021c:
                java.net.Socket r0 = r1.g
                if (r0 == 0) goto L_0x0234
                r0.close()     // Catch:{ IOException -> 0x022c }
                r3 = 0
                r1.c = r3     // Catch:{ IOException -> 0x022c }
                java.io.OutputStream r0 = r1.d     // Catch:{ IOException -> 0x022c }
                r0.close()     // Catch:{ IOException -> 0x022c }
                goto L_0x0234
            L_0x022c:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
            L_0x0234:
                return
            L_0x0235:
                if (r14 == 0) goto L_0x023e
                com.mbridge.msdk.foundation.same.net.n r4 = com.mbridge.msdk.foundation.same.net.n.this     // Catch:{ all -> 0x027c }
                java.lang.String r0 = r4.a(r0)     // Catch:{ all -> 0x027c }
                goto L_0x0244
            L_0x023e:
                java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x027c }
                r4.<init>(r0)     // Catch:{ all -> 0x027c }
                r0 = r4
            L_0x0244:
                boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x027c }
                if (r4 != 0) goto L_0x0250
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x027c }
                r4.<init>(r0)     // Catch:{ all -> 0x027c }
                goto L_0x0251
            L_0x0250:
                r4 = 0
            L_0x0251:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x027c }
                r8.<init>(r3)     // Catch:{ all -> 0x027c }
                r8.append(r12)     // Catch:{ all -> 0x027c }
                java.lang.String r3 = " "
                r8.append(r3)     // Catch:{ all -> 0x027c }
                int r0 = r0.length()     // Catch:{ all -> 0x027c }
                r8.append(r0)     // Catch:{ all -> 0x027c }
                java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x027c }
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)     // Catch:{ all -> 0x027c }
                com.mbridge.msdk.foundation.same.net.e r0 = r1.f     // Catch:{ all -> 0x027c }
                com.mbridge.msdk.foundation.same.net.f.c r3 = new com.mbridge.msdk.foundation.same.net.f.c     // Catch:{ all -> 0x027c }
                r8 = 0
                r3.<init>(r6, r8, r8)     // Catch:{ all -> 0x027c }
                com.mbridge.msdk.foundation.same.net.l r3 = com.mbridge.msdk.foundation.same.net.l.a(r4, r3)     // Catch:{ all -> 0x027c }
                r0.onSuccess(r3)     // Catch:{ all -> 0x027c }
                goto L_0x0293
            L_0x027c:
                r0 = move-exception
                java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x02a6 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02a6 }
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)     // Catch:{ all -> 0x02a6 }
                boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x02a6 }
                if (r0 == 0) goto L_0x0290
                java.lang.String r3 = "The JSON data is illegal"
            L_0x0290:
                r1.a(r3)     // Catch:{ all -> 0x02a6 }
            L_0x0293:
                r5.close()     // Catch:{ all -> 0x02a6 }
                java.net.Socket r0 = r1.g
                if (r0 == 0) goto L_0x02d5
                r0.close()     // Catch:{ IOException -> 0x02cd }
                r3 = 0
                r1.c = r3     // Catch:{ IOException -> 0x02cd }
                java.io.OutputStream r0 = r1.d     // Catch:{ IOException -> 0x02cd }
                r0.close()     // Catch:{ IOException -> 0x02cd }
                goto L_0x02d5
            L_0x02a6:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02d6 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d6 }
                r3.<init>(r7)     // Catch:{ all -> 0x02d6 }
                r3.append(r0)     // Catch:{ all -> 0x02d6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02d6 }
                com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x02d6 }
                r1.a(r0)     // Catch:{ all -> 0x02d6 }
                java.net.Socket r0 = r1.g
                if (r0 == 0) goto L_0x02d5
                r0.close()     // Catch:{ IOException -> 0x02cd }
                r3 = 0
                r1.c = r3     // Catch:{ IOException -> 0x02cd }
                java.io.OutputStream r0 = r1.d     // Catch:{ IOException -> 0x02cd }
                r0.close()     // Catch:{ IOException -> 0x02cd }
                goto L_0x02d5
            L_0x02cd:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
            L_0x02d5:
                return
            L_0x02d6:
                r0 = move-exception
                r3 = r0
                java.net.Socket r0 = r1.g
                if (r0 == 0) goto L_0x02f0
                r0.close()     // Catch:{ IOException -> 0x02e8 }
                r4 = 0
                r1.c = r4     // Catch:{ IOException -> 0x02e8 }
                java.io.OutputStream r0 = r1.d     // Catch:{ IOException -> 0x02e8 }
                r0.close()     // Catch:{ IOException -> 0x02e8 }
                goto L_0x02f0
            L_0x02e8:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.aa.d(r2, r0)
            L_0x02f0:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.n.a.a():void");
        }

        private void a(String str) {
            if (this.f != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.f.onError(new com.mbridge.msdk.foundation.same.net.b.a(13, new c(404, str.getBytes(), (List<com.mbridge.msdk.foundation.same.net.d.b>) null)));
            }
        }
    }

    public final String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read > 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }
}
