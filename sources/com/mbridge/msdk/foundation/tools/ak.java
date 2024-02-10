package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: StringUtils */
public final class ak {
    public static boolean a(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || AbstractJsonLexerKt.NULL.equals(str);
    }

    public static boolean b(String str) {
        return str != null && !TextUtils.isEmpty(str.trim()) && !AbstractJsonLexerKt.NULL.equals(str);
    }
}
