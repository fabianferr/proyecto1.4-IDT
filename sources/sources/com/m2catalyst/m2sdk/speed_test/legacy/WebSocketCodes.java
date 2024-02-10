package com.m2catalyst.m2sdk.speed_test.legacy;

import android.util.SparseArray;

/* compiled from: NetworkDiagnosticTools */
class WebSocketCodes {
    private static SparseArray<WebSocketCode> webSocketCodes;

    public static void initializeCodes() {
        SparseArray<WebSocketCode> sparseArray = new SparseArray<>();
        webSocketCodes = sparseArray;
        sparseArray.put(1000, new WebSocketCode(1000, "Normal Closure", "Normal closure; the connection successfully completed whatever purpose for which it was created."));
        webSocketCodes.put(1001, new WebSocketCode(1001, "Going Away", "The endpoint is going away, either because of a server failure or because the browser is navigating away from the page that opened the connection."));
        webSocketCodes.put(1002, new WebSocketCode(1002, "Protocol Error", "The endpoint is terminating the connection due to a protocol error."));
        webSocketCodes.put(1003, new WebSocketCode(1003, "Unsupported Data", "The connection is being terminated because the endpoint received data of a type it cannot accept (for example, a text-only endpoint received binary data)."));
        webSocketCodes.put(1005, new WebSocketCode(1005, "No Status Received", "Reserved.  Indicates that no status code was provided even though one was expected."));
        webSocketCodes.put(1006, new WebSocketCode(1006, "Abnormal Closure", "Reserved. Used to indicate that a connection was closed abnormally (that is, with no close frame being sent) when a status code is expected."));
        webSocketCodes.put(1007, new WebSocketCode(1007, "Invalid frame payload data", "The endpoint is terminating the connection because a message was received that contained inconsistent data (e.g., non-UTF-8 data within a text message)."));
        webSocketCodes.put(1008, new WebSocketCode(1008, "Policy Violation", "The endpoint is terminating the connection because it received a message that violates its policy. This is a generic status code, used when codes 1003 and 1009 are not suitable."));
        webSocketCodes.put(1009, new WebSocketCode(1009, "Message too big", "The endpoint is terminating the connection because a data frame was received that is too large."));
        webSocketCodes.put(1010, new WebSocketCode(1010, "Missing Extension", "The client is terminating the connection because it expected the server to negotiate one or more extension, but the server didn't."));
        webSocketCodes.put(1011, new WebSocketCode(1011, "Internal Error", "The server is terminating the connection because it encountered an unexpected condition that prevented it from fulfilling the request."));
        webSocketCodes.put(1012, new WebSocketCode(1012, "Service Restart", "The server is terminating the connection because it is restarting. [Ref]"));
        webSocketCodes.put(1013, new WebSocketCode(1013, "Try Again Later", "The server is terminating the connection due to a temporary condition, e.g. it is overloaded and is casting off some of its clients. [Ref]"));
        webSocketCodes.put(1014, new WebSocketCode(1014, "Bad Gateway", "The server was acting as a gateway or proxy and received an invalid response from the upstream server. This is similar to 502 HTTP Status Code."));
        webSocketCodes.put(1015, new WebSocketCode(1015, "TLS Handshake", "Reserved. Indicates that the connection was closed due to a failure to perform a TLS handshake (e.g., the server certificate can't be verified)."));
    }

    public static WebSocketCode lookupWebSocketCode(int i) {
        if (webSocketCodes == null) {
            initializeCodes();
        }
        WebSocketCode webSocketCode = webSocketCodes.get(i);
        return webSocketCode == null ? new WebSocketCode(i, "UNKNOWN CODE", "Unknown Code") : webSocketCode;
    }
}
