package com.umlaut.crowd.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

public class x8 implements r9 {
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    private SocketChannel a;
    private w8 b;
    private SSLEngine c;
    private int d = 0;
    private ByteBuffer e;
    private ByteBuffer f;
    private ByteBuffer g;
    private ByteBuffer h = ByteBuffer.allocate(0);
    private boolean i;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0063 */
        static {
            /*
                javax.net.ssl.SSLEngineResult$HandshakeStatus[] r0 = javax.net.ssl.SSLEngineResult.HandshakeStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                javax.net.ssl.SSLEngineResult$HandshakeStatus r2 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x003e }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                javax.net.ssl.SSLEngineResult$Status[] r4 = javax.net.ssl.SSLEngineResult.Status.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                a = r4
                javax.net.ssl.SSLEngineResult$Status r5 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ NoSuchFieldError -> 0x004f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0059 }
                javax.net.ssl.SSLEngineResult$Status r4 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0063 }
                javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006d }
                javax.net.ssl.SSLEngineResult$Status r1 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.x8.a.<clinit>():void");
        }
    }

    public x8(SocketChannel socketChannel) {
        this.a = socketChannel;
    }

    private boolean d(boolean z) throws IOException {
        if (this.d != 0) {
            if (this.f.hasRemaining()) {
                do {
                    this.a.write(this.f);
                    if (!this.f.hasRemaining()) {
                        break;
                    }
                } while (z);
                if (this.f.hasRemaining()) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("SSL Settings were not provided");
    }

    /* JADX INFO: finally extract failed */
    private int e(boolean z) throws IOException {
        int i2 = 0;
        if (!z && this.g.hasRemaining()) {
            return 0;
        }
        this.e.compact();
        try {
            int read = this.a.read(this.e);
            if (read == -1) {
                close();
            }
            if (read == -1 && !this.e.hasRemaining()) {
                return -1;
            }
            this.e.flip();
            if (!this.e.hasRemaining()) {
                return 0;
            }
            while (this.e.hasRemaining()) {
                this.g.compact();
                try {
                    SSLEngineResult unwrap = this.c.unwrap(this.e, this.g);
                    this.g.flip();
                    int bytesProduced = unwrap.bytesProduced();
                    i2 += bytesProduced;
                    if (unwrap.getHandshakeStatus().equals(SSLEngineResult.HandshakeStatus.FINISHED)) {
                        this.d = 2;
                    } else if (unwrap.getHandshakeStatus().equals(SSLEngineResult.HandshakeStatus.NEED_TASK)) {
                        return i2;
                    }
                    int i3 = a.a[unwrap.getStatus().ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    close();
                                    return -1;
                                }
                                throw new IOException("Engine reports problem: " + unwrap.getStatus());
                            } else if (unwrap.bytesConsumed() != 0) {
                                return i2;
                            } else {
                                int remaining = this.e.remaining();
                                this.e.compact();
                                try {
                                    int read2 = this.a.read(this.e);
                                    if (read2 == -1) {
                                        close();
                                    }
                                    if (read2 != -1 || this.e.hasRemaining()) {
                                        this.e.flip();
                                        if (remaining >= this.e.remaining() && (i2 > 0 || !this.a.isBlocking())) {
                                            return i2;
                                        }
                                    } else {
                                        this.e.flip();
                                        return -1;
                                    }
                                } catch (Throwable th) {
                                    this.e.flip();
                                    throw th;
                                }
                            }
                        } else if (!i()) {
                            return i2;
                        }
                    } else if (bytesProduced == 0 && !this.a.isBlocking()) {
                        return i2;
                    }
                } catch (Throwable th2) {
                    this.g.flip();
                    throw th2;
                }
            }
            return i2;
        } finally {
            this.e.flip();
        }
    }

    private void g() throws SSLException {
        if (this.d == 0) {
            SSLEngine createSSLEngine = this.b.a().createSSLEngine();
            this.c = createSSLEngine;
            createSSLEngine.setUseClientMode(this.b.c());
            this.c.setNeedClientAuth(this.b.b());
            this.c.setWantClientAuth(this.b.d());
            ByteBuffer byteBuffer = this.h;
            this.e = byteBuffer;
            this.f = byteBuffer;
            this.g = byteBuffer;
            i();
            this.d = 1;
            this.c.beginHandshake();
            return;
        }
        throw new IllegalArgumentException("SSL already initialized!");
    }

    public static x8 h() throws IOException {
        return new x8(SocketChannel.open());
    }

    private boolean i() {
        boolean z;
        int packetBufferSize = this.c.getSession().getPacketBufferSize();
        int applicationBufferSize = this.c.getSession().getApplicationBufferSize();
        if (this.e.capacity() < packetBufferSize) {
            ByteBuffer allocate = ByteBuffer.allocate(packetBufferSize);
            allocate.put(this.e);
            this.e = allocate;
            allocate.flip();
            z = true;
        } else {
            z = false;
        }
        if (this.f.capacity() < packetBufferSize) {
            ByteBuffer allocate2 = ByteBuffer.allocate(packetBufferSize);
            allocate2.put(this.f);
            this.f = allocate2;
            allocate2.flip();
            z = true;
        }
        if (this.g.capacity() >= applicationBufferSize) {
            return z;
        }
        ByteBuffer allocate3 = ByteBuffer.allocate(packetBufferSize);
        allocate3.put(this.g);
        this.g = allocate3;
        allocate3.flip();
        return true;
    }

    public void a(w8 w8Var) throws SSLException {
        if (this.b == null) {
            this.b = w8Var;
            g();
            return;
        }
        throw new IllegalArgumentException("SSL Parameters already set");
    }

    public ByteBuffer b() {
        return this.g;
    }

    public SocketChannel c() {
        return this.a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:4|5|6|11|12|13|14|15|16|(2:18|19)|23|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0016 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001b */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC, Splitter:B:18:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r2 = this;
            boolean r0 = r2.i
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r2)
            r0 = 1
            r2.d(r0)     // Catch:{ IOException -> 0x000d }
            goto L_0x0011
        L_0x000b:
            r0 = move-exception
            goto L_0x002b
        L_0x000d:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x000b }
        L_0x0011:
            javax.net.ssl.SSLEngine r1 = r2.c     // Catch:{ Exception -> 0x0016 }
            r1.closeInbound()     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            javax.net.ssl.SSLEngine r1 = r2.c     // Catch:{ Exception -> 0x001b }
            r1.closeOutbound()     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            java.nio.channels.SocketChannel r1 = r2.a     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x0027
            r1.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x000b }
        L_0x0027:
            r2.i = r0     // Catch:{ all -> 0x000b }
            monitor-exit(r2)     // Catch:{ all -> 0x000b }
            return
        L_0x002b:
            monitor-exit(r2)     // Catch:{ all -> 0x000b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.x8.close():void");
    }

    public void f() {
        this.f.limit(0);
    }

    public boolean isOpen() {
        return this.a.isOpen();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.i && !this.g.hasRemaining()) {
            return -1;
        }
        int i2 = 0;
        if (!a() && !d()) {
            return 0;
        }
        if (this.g.hasRemaining()) {
            i2 = a(this.g, byteBuffer);
        }
        if (this.g.hasRemaining() || !byteBuffer.hasRemaining()) {
            return i2;
        }
        if (!this.a.isBlocking()) {
            while (true) {
                int b2 = b(true);
                if (b2 != -1) {
                    i2 += a(this.g, byteBuffer);
                    if (b2 == 0) {
                        return i2;
                    }
                    if (this.g.hasRemaining() && !byteBuffer.hasRemaining()) {
                        return i2;
                    }
                } else if (i2 > 0) {
                    return i2;
                } else {
                    return -1;
                }
            }
        } else if (i2 != 0) {
            return i2;
        } else {
            if (b(true) == -1) {
                return -1;
            }
            return i2 + a(this.g, byteBuffer);
        }
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!c().isConnected()) {
            throw new IOException("not connected");
        } else if (!a() && !d()) {
            return 0;
        } else {
            if (this.d == 2) {
                return a(byteBuffer);
            }
            throw new IllegalStateException("Handshaking is not completed");
        }
    }

    private void c(boolean z) {
        while (true) {
            Runnable delegatedTask = this.c.getDelegatedTask();
            if (delegatedTask != null) {
                if (z) {
                    new Thread(delegatedTask).start();
                } else {
                    delegatedTask.run();
                }
            } else {
                return;
            }
        }
    }

    public int b(boolean z) throws IOException {
        if (this.g.hasRemaining()) {
            return this.g.remaining();
        }
        if (this.i) {
            return -1;
        }
        if ((!a() && !d()) || !z) {
            return 0;
        }
        int e2 = e(false);
        if (e2 == -1) {
            close();
        }
        return e2;
    }

    public static x8 a(s9 s9Var, w8 w8Var) throws SSLException {
        x8 x8Var = new x8(s9Var.c());
        s9Var.a = true;
        x8Var.a(w8Var);
        return x8Var;
    }

    private int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int min = Math.min(byteBuffer.remaining(), byteBuffer2.remaining());
        byte[] bArr = new byte[min];
        this.g.get(bArr);
        byteBuffer2.put(bArr);
        return min;
    }

    public boolean d() throws IOException {
        synchronized (this) {
            if (a()) {
                return true;
            }
            int i2 = 0;
            while (!this.i && this.d != 2) {
                int i3 = a.b[this.c.getHandshakeStatus().ordinal()];
                if (i3 != 4) {
                    if (i3 == 5) {
                        c(false);
                    }
                } else if (this.a.isBlocking() || this.e.remaining() == i2 || i2 == 0) {
                    i2 = this.e.remaining();
                } else {
                    boolean a2 = a();
                    return a2;
                }
                a(this.c.getHandshakeStatus());
            }
            boolean a3 = a();
            return a3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.nio.ByteBuffer r7) throws java.io.IOException {
        /*
            r6 = this;
            java.nio.channels.SocketChannel r0 = r6.c()
            boolean r0 = r0.isBlocking()
            boolean r0 = r6.d(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            r0 = 0
        L_0x0011:
            java.nio.ByteBuffer r2 = r6.f
            r2.clear()
            javax.net.ssl.SSLEngine r2 = r6.c
            java.nio.ByteBuffer r3 = r6.f
            javax.net.ssl.SSLEngineResult r2 = r2.wrap(r7, r3)
            javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = r2.getHandshakeStatus()
            javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED
            boolean r3 = r3.equals(r4)
            r4 = 2
            if (r3 == 0) goto L_0x002d
            r6.d = r4
        L_0x002d:
            java.nio.ByteBuffer r3 = r6.f
            r3.flip()
            int r3 = r2.bytesConsumed()
            int r0 = r0 + r3
            int[] r3 = com.umlaut.crowd.internal.x8.a.a
            javax.net.ssl.SSLEngineResult$Status r5 = r2.getStatus()
            int r5 = r5.ordinal()
            r3 = r3[r5]
            r5 = 1
            if (r3 == r5) goto L_0x007a
            if (r3 == r4) goto L_0x006b
            r7 = 3
            if (r3 == r7) goto L_0x006a
            r7 = 4
            if (r3 == r7) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r6.close()
        L_0x0052:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Engine reports problem: "
            r0.<init>(r1)
            javax.net.ssl.SSLEngineResult$Status r1 = r2.getStatus()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x006a:
            return r0
        L_0x006b:
            boolean r2 = r6.i()
            if (r2 == 0) goto L_0x0072
            goto L_0x007d
        L_0x0072:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r0 = "Error in SSL Wrapping (BUFFER_OVERFLOW)"
            r7.<init>(r0)
            throw r7
        L_0x007a:
            r6.d(r1)
        L_0x007d:
            java.nio.channels.SocketChannel r2 = r6.c()
            boolean r2 = r2.isBlocking()
            boolean r2 = r6.d(r2)
            if (r2 == 0) goto L_0x0091
            boolean r2 = r7.hasRemaining()
            if (r2 != 0) goto L_0x0011
        L_0x0091:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.x8.a(java.nio.ByteBuffer):int");
    }

    public x8(s9 s9Var) {
        this.a = s9Var.c();
    }

    private void a(SSLEngineResult.HandshakeStatus handshakeStatus) throws IOException {
        if (this.d == 1) {
            int i2 = a.b[handshakeStatus.ordinal()];
            if (i2 == 1 || i2 == 2) {
                this.d = 2;
            } else if (i2 == 3) {
                a(this.h);
            } else if (i2 == 4) {
                e(true);
            } else if (i2 == 5) {
                c(true);
            } else {
                throw new IllegalStateException("Invalid SSL handshake status: " + handshakeStatus);
            }
        } else {
            throw new IllegalStateException("No SSL Parameters provided or  already handshaked");
        }
    }

    public boolean a() {
        return this.d == 2;
    }

    public boolean a(boolean z) throws IOException {
        return d(z);
    }

    public a9 a(b9 b9Var, int i2) throws IOException {
        a9 a9Var = new a9(b9Var, this.a.register(b9Var.g(), i2), this);
        b9Var.b(a9Var);
        return a9Var;
    }

    public a9 a(b9 b9Var, int i2, Object obj) throws IOException {
        a9 a2 = a(b9Var, i2);
        a2.a(obj);
        return a2;
    }

    public void e() {
        this.g.limit(0);
    }
}
