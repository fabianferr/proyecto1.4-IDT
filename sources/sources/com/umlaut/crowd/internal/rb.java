package com.umlaut.crowd.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public class rb {
    r9[] a = null;

    public void a() {
        for (r9 close : this.a) {
            try {
                close.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public r9[] a(String str, sa saVar, int i, int i2, int i3, boolean z) throws IOException, u9, NoSuchAlgorithmException, KeyManagementException {
        r9 r9Var;
        r9 r9Var2;
        int i4 = i;
        int i5 = i2;
        f3 f3Var = new f3();
        this.a = new r9[i4];
        b9 b9Var = new b9();
        int i6 = i4;
        int i7 = 0;
        while (i7 < i4) {
            try {
                SocketChannel open = SocketChannel.open();
                open.configureBlocking(false);
                if (open.connect(new InetSocketAddress(str, i3))) {
                    i6--;
                }
                if (z) {
                    r9Var2 = y8.a(open);
                } else {
                    th = new s9(open);
                }
                r9Var2.a(b9Var, 8);
                this.a[i7] = r9Var2;
                i7++;
            } catch (Throwable th) {
                try {
                    b9Var.close();
                } catch (Throwable th2) {
                    r9Var.addSuppressed(th2);
                }
                throw r9Var;
            } finally {
                r9Var = th;
            }
        }
        long j = (long) i5;
        long currentTimeMillis = System.currentTimeMillis() + j;
        do {
            long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                currentTimeMillis2 = 1;
            }
            if (b9Var.b(currentTimeMillis2) < i4) {
                if (System.currentTimeMillis() > currentTimeMillis) {
                    throw new IOException("Not all sockets could be connected");
                }
            }
            Iterator<a9> it = b9Var.k().iterator();
            while (it.hasNext()) {
                a9 next = it.next();
                r9 c = next.c();
                if (next.g()) {
                    if (c.c().finishConnect()) {
                        i6--;
                    } else {
                        throw new IOException("Could not finish connecting a socket");
                    }
                }
                next.a(4);
                it.remove();
            }
        } while (i6 != 0);
        int length = this.a.length;
        long currentTimeMillis3 = System.currentTimeMillis() + j;
        s7 s7Var = new s7();
        s7Var.test = ua.a(saVar);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        f3Var.a((OutputStream) byteArrayOutputStream, (s5) s7Var);
        do {
            long currentTimeMillis4 = currentTimeMillis3 - System.currentTimeMillis();
            if (currentTimeMillis4 <= 0) {
                currentTimeMillis4 = 1;
            }
            b9Var.b(currentTimeMillis4);
            if (System.currentTimeMillis() < currentTimeMillis3) {
                Iterator<a9> it2 = b9Var.k().iterator();
                while (it2.hasNext()) {
                    a9 next2 = it2.next();
                    r9 c2 = next2.c();
                    if (next2.j()) {
                        ByteBuffer byteBuffer = (ByteBuffer) next2.a();
                        if (byteBuffer == null) {
                            byteBuffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                            next2.a((Object) byteBuffer);
                        }
                        if (byteBuffer.hasRemaining()) {
                            c2.write(byteBuffer);
                        }
                        it2.remove();
                        if (byteBuffer.remaining() == 0) {
                            next2.b();
                            length--;
                        }
                    }
                }
            } else {
                throw new IOException("Not all sockets respond");
            }
        } while (length != 0);
        b9Var.close();
        int i8 = 0;
        while (i8 < i4) {
            r9 r9Var3 = this.a[i8];
            r9Var3.c().configureBlocking(true);
            r9Var3.c().socket().setSoTimeout(i5);
            u5 b = f3Var.b(Channels.newInputStream(r9Var3));
            int i9 = i8 - 1;
            if (b.c().equals(v5.MESSAGETYPE_BINARY)) {
                if (((v7) b).successfull) {
                    i9++;
                } else {
                    throw new IOException("Server rejected");
                }
            } else if (b.c().equals(v5.MESSAGETYPE_QUIT)) {
                throw new IOException("Server quits");
            }
            r9Var3.c().configureBlocking(false);
            i8 = i9 + 1;
        }
        b9Var.close();
        return this.a;
    }
}
