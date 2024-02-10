package com.cellrebel.sdk.ping;

import java.net.InetAddress;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class PingStats {
    private final InetAddress a;
    private final long b;
    private final long c;
    private final float d;
    private final float e;
    private final float f;

    public String toString() {
        return "PingStats{ia=" + this.a + ", noPings=" + this.b + ", packetsLost=" + this.c + ", averageTimeTaken=" + this.d + ", minTimeTaken=" + this.e + ", maxTimeTaken=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
