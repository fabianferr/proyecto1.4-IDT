package com.umlaut.crowd.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;

public interface r9 extends ByteChannel, Channel, AutoCloseable {
    a9 a(b9 b9Var, int i) throws IOException;

    a9 a(b9 b9Var, int i, Object obj) throws IOException;

    boolean a();

    boolean a(boolean z) throws IOException;

    int b(boolean z) throws IOException;

    ByteBuffer b();

    SocketChannel c();

    boolean d() throws IOException;

    void e();

    void f();
}
