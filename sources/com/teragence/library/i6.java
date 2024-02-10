package com.teragence.library;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

class i6 {
    static String a(l5[] l5VarArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l5VarArr.length; i++) {
            boolean z = true;
            if (i != l5VarArr.length - 1) {
                z = false;
            }
            l5 l5Var = l5VarArr[i];
            sb.append(l5Var.a);
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append(l5Var.b);
            if (!z) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
        }
        return sb.toString();
    }
}
