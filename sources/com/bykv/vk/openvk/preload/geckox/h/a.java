package com.bykv.vk.openvk.preload.geckox.h;

import android.util.Log;
import com.bykv.vk.openvk.preload.geckox.c.b;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: DefaultLogger */
final class a implements c {
    a() {
    }

    public final void a(String str, Object... objArr) {
        if (objArr == null) {
            Log.d(str, AbstractJsonLexerKt.NULL);
            return;
        }
        try {
            Log.d(str, b.a().a.a((Object) objArr));
        } catch (Throwable unused) {
        }
    }

    public final void a(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    public final void b(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
