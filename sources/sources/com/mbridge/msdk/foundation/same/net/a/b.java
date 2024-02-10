package com.mbridge.msdk.foundation.same.net.a;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: CronetResponse */
public final class b {
    private int a;
    private com.mbridge.msdk.foundation.same.net.f.b b;
    private Exception c;

    public final int a() {
        return this.a;
    }

    public final com.mbridge.msdk.foundation.same.net.f.b b() {
        return this.b;
    }

    public final Exception c() {
        return this.c;
    }

    public final String toString() {
        return "CronetResponse{status=" + this.a + ", httpResponse=" + this.b + ", exception=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
