package com.ironsource.sdk.utils.a;

import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ironsource/sdk/utils/loaders/DefaultConnectionFactory;", "Lcom/ironsource/sdk/utils/loaders/ConnectionFactoryInterface;", "()V", "createConnection", "Ljava/io/InputStream;", "url", "", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class b implements a {
    public static final b a = new b();

    private b() {
    }

    public final InputStream a(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        InputStream openStream = new URL(str).openStream();
        Intrinsics.checkNotNullExpressionValue(openStream, "URL(url).openStream()");
        return openStream;
    }
}
