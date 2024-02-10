package com.wortise.ads;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/a4;", "Lokhttp3/Interceptor;", "Lokhttp3/Request;", "request", "a", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HttpInterceptor.kt */
public final class a4 implements Interceptor {
    public static final a4 a = new a4();

    private a4() {
    }

    private final Request a(Request request) {
        String a2 = p2.a.a();
        if (a2 == null) {
            return request;
        }
        Request build = request.newBuilder().addHeader("User-Agent", a2).build();
        Intrinsics.checkNotNullExpressionValue(build, "request.newBuilder()\n   …\n                .build()");
        return build;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Intrinsics.checkNotNullExpressionValue(request, "chain.request()");
        Response proceed = chain.proceed(a(request));
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(parseRequest(chain.request()))");
        return proceed;
    }
}
