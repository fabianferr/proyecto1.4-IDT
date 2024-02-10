package com.umlaut.crowd.internal;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class s9 implements r9 {
    boolean a = false;
    boolean b = false;
    private SocketChannel c;
    private ByteBuffer d;

    public s9(SocketChannel socketChannel) throws SocketException {
        this.c = socketChannel;
        ByteBuffer allocate = ByteBuffer.allocate(socketChannel.socket().getReceiveBufferSize());
        this.d = allocate;
        allocate.limit(0);
    }

    public boolean a() {
        return true;
    }

    public boolean a(SocketAddress socketAddress) throws IOException {
        return this.c.connect(socketAddress);
    }

    public boolean a(boolean z) {
        return true;
    }

    public ByteBuffer b() {
        return this.d;
    }

    public SocketChannel c() {
        return this.c;
    }

    public void close() throws IOException {
        this.b = true;
        SocketChannel socketChannel = this.c;
        if (socketChannel != null) {
            socketChannel.close();
        }
    }

    public boolean d() throws IOException {
        return true;
    }

    public void e() {
        this.d.limit(0);
    }

    public void f() {
    }

    public boolean g() throws IOException {
        return this.c.finishConnect();
    }

    public Socket h() {
        return this.c.socket();
    }

    public boolean isOpen() {
        return this.c.isOpen();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        int i;
        int i2 = 0;
        if (this.d.hasRemaining()) {
            int min = Math.min(this.d.remaining(), byteBuffer.remaining());
            byte[] bArr = new byte[min];
            this.d.get(bArr);
            byteBuffer.put(bArr);
            i = min + 0;
        } else {
            i = 0;
        }
        if (this.b) {
            return -1;
        }
        if (this.d.hasRemaining() || !byteBuffer.hasRemaining()) {
            return i;
        }
        if (!this.a) {
            int read = this.c.read(byteBuffer);
            if (read == -1) {
                this.b = true;
            } else {
                i2 = read;
            }
            return i + i2;
        }
        throw new IllegalStateException("The Channel is in illegal state! R/W are locked");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!c().isOpen()) {
            throw new IOException("not connected");
        } else if (!this.a) {
            return this.c.write(byteBuffer);
        } else {
            throw new IllegalStateException("The Channel is in illegal state! R/W are locked");
        }
    }

    public a9 a(b9 b9Var, int i) throws IOException {
        a9 a9Var = new a9(b9Var, this.c.register(b9Var.g(), i), this);
        b9Var.b(a9Var);
        return a9Var;
    }

    public int b(boolean z) throws IOException {
        if (this.d.hasRemaining()) {
            return this.d.remaining();
        }
        this.d.compact();
        if (z) {
            try {
                if (!this.b && this.c.read(this.d) == -1) {
                    this.b = true;
                    return -1;
                }
            } finally {
                this.d.flip();
            }
        }
        this.d.flip();
        if (this.d.hasRemaining()) {
            return this.d.remaining();
        }
        if (!this.b) {
            return 0;
        }
        this.d.limit(0);
        this.b = true;
        return -1;
    }

    public a9 a(b9 b9Var, int i, Object obj) throws IOException {
        a9 a2 = a(b9Var, i);
        a2.a(obj);
        return a2;
    }
}
