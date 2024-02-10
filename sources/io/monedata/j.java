package io.monedata;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/Interceptor;", "apiLogger", "Lokhttp3/Interceptor;", "a", "()Lokhttp3/Interceptor;", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class j {
    private static final Interceptor a;

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new j$$ExternalSyntheticLambda0());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        a = httpLoggingInterceptor;
    }

    public static final Interceptor a() {
        return a;
    }

    /* access modifiers changed from: private */
    public static final void a(String str) {
        MonedataLog monedataLog = MonedataLog.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(str, "it");
        MonedataLog.v$default(monedataLog, str, (Throwable) null, 2, (Object) null);
    }
}
