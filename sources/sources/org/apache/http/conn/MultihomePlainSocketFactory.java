package org.apache.http.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

@Deprecated
public final class MultihomePlainSocketFactory implements SocketFactory {
    private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();

    public static MultihomePlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    private MultihomePlainSocketFactory() {
    }

    public Socket createSocket() {
        return new Socket();
    }

    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Target host may not be null.");
        } else if (httpParams != null) {
            if (socket == null) {
                socket = createSocket();
            }
            if (inetAddress != null || i2 > 0) {
                if (i2 < 0) {
                    i2 = 0;
                }
                socket.bind(new InetSocketAddress(inetAddress, i2));
            }
            int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
            InetAddress[] allByName = InetAddress.getAllByName(str);
            ArrayList<InetAddress> arrayList = new ArrayList<>(allByName.length);
            arrayList.addAll(Arrays.asList(allByName));
            Collections.shuffle(arrayList);
            IOException iOException = null;
            for (InetAddress inetAddress2 : arrayList) {
                try {
                    socket.connect(new InetSocketAddress(inetAddress2, i), connectionTimeout);
                    break;
                } catch (SocketTimeoutException unused) {
                    throw new ConnectTimeoutException("Connect to " + inetAddress2 + " timed out");
                } catch (IOException e) {
                    iOException = e;
                    socket = new Socket();
                }
            }
            if (iOException == null) {
                return socket;
            }
            throw iOException;
        } else {
            throw new IllegalArgumentException("Parameters may not be null.");
        }
    }

    public final boolean isSecure(Socket socket) throws IllegalArgumentException {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null.");
        } else if (socket.getClass() != Socket.class) {
            throw new IllegalArgumentException("Socket not created by this factory.");
        } else if (!socket.isClosed()) {
            return false;
        } else {
            throw new IllegalArgumentException("Socket is closed.");
        }
    }
}
