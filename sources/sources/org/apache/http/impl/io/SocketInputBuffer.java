package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import org.apache.http.io.EofSensor;
import org.apache.http.params.HttpParams;

public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private static final Class SOCKET_TIMEOUT_CLASS = SocketTimeoutExceptionClass();
    private boolean eof;
    private final Socket socket;

    private static Class SocketTimeoutExceptionClass() {
        try {
            return Class.forName("java.net.SocketTimeoutException");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static boolean isSocketTimeoutException(InterruptedIOException interruptedIOException) {
        Class cls = SOCKET_TIMEOUT_CLASS;
        if (cls != null) {
            return cls.isInstance(interruptedIOException);
        }
        return true;
    }

    public SocketInputBuffer(Socket socket2, int i, HttpParams httpParams) throws IOException {
        if (socket2 != null) {
            this.socket = socket2;
            this.eof = false;
            i = i < 0 ? socket2.getReceiveBufferSize() : i;
            init(socket2.getInputStream(), i < 1024 ? 1024 : i, httpParams);
            return;
        }
        throw new IllegalArgumentException("Socket may not be null");
    }

    /* access modifiers changed from: protected */
    public int fillBuffer() throws IOException {
        int fillBuffer = super.fillBuffer();
        this.eof = fillBuffer == -1;
        return fillBuffer;
    }

    public boolean isDataAvailable(int i) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (!hasBufferedData) {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(i);
                fillBuffer();
                hasBufferedData = hasBufferedData();
            } catch (InterruptedIOException e) {
                if (!isSocketTimeoutException(e)) {
                    throw e;
                }
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
                throw th;
            }
            this.socket.setSoTimeout(soTimeout);
        }
        return hasBufferedData;
    }

    public boolean isEof() {
        return this.eof;
    }
}
