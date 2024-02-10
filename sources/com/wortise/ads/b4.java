package com.wortise.ads;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/Interceptor;", "httpLogger", "Lokhttp3/Interceptor;", "a", "()Lokhttp3/Interceptor;", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: HttpLogger.kt */
public final class b4 {
    private static final Interceptor a;

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new b4$$ExternalSyntheticLambda0());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        a = httpLoggingInterceptor;
    }

    public static final Interceptor a() {
        return a;
    }

    /* access modifiers changed from: private */
    public static final void a(String str) {
        Intrinsics.checkNotNullExpressionValue(str, "it");
        WortiseLog.v$default(str, (Throwable) null, 2, (Object) null);
    }
}
