package com.wortise.ads;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\b\u001a\u00020\u00072\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/j5;", "", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lokhttp3/OkHttpClient;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: OkHttpFactory.kt */
public final class j5 {
    public static final j5 a = new j5();

    private j5() {
    }

    public final OkHttpClient a(Function1<? super OkHttpClient.Builder, Unit> function1) {
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(a4.a).addInterceptor(b4.a());
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(addInterceptor, "this");
            function1.invoke(addInterceptor);
        }
        OkHttpClient build = addInterceptor.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .a…) }\n            .build ()");
        return build;
    }
}
