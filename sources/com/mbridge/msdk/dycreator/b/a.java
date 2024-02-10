package com.mbridge.msdk.dycreator.b;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: DyError */
public final class a {
    private int a;
    private String b;

    public a(b bVar) {
        if (bVar != null) {
            this.a = bVar.a();
            this.b = bVar.b();
        }
    }

    public a(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public final String toString() {
        return "DyError{errorCode=" + this.a + AbstractJsonLexerKt.END_OBJ;
    }
}
