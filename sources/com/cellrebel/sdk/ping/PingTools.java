package com.cellrebel.sdk.ping;

import java.net.InetAddress;

public class PingTools {
    private PingTools() {
    }

    public static PingResult a(InetAddress inetAddress, PingOptions pingOptions) {
        return PingNative.a(inetAddress, pingOptions);
    }

    public static PingResult b(InetAddress inetAddress, PingOptions pingOptions) {
        PingResult pingResult;
        String str;
        try {
            return a(inetAddress, pingOptions);
        } catch (InterruptedException unused) {
            pingResult = new PingResult(inetAddress);
            pingResult.b = false;
            str = "Interrupted";
            pingResult.c = str;
            return pingResult;
        } catch (Exception | OutOfMemoryError unused2) {
            pingResult = new PingResult(inetAddress);
            pingResult.b = false;
            str = "Native ping not available";
            pingResult.c = str;
            return pingResult;
        }
    }
}
