package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
class LayeredSchemeSocketFactoryAdaptor extends SchemeSocketFactoryAdaptor implements LayeredSchemeSocketFactory {
    private final LayeredSocketFactory factory;

    LayeredSchemeSocketFactoryAdaptor(LayeredSocketFactory layeredSocketFactory) {
        super(layeredSocketFactory);
        this.factory = layeredSocketFactory;
    }

    public Socket createLayeredSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.factory.createSocket(socket, str, i, z);
    }
}
