package io.monedata;

import android.os.Build;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lio/monedata/i;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "", "userAgent$delegate", "Lkotlin/Lazy;", "a", "()Ljava/lang/String;", "userAgent", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class i implements Interceptor {
    public static final i a = new i();
    private static final Lazy b = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<String> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Monedata/1.7.1 Android/" + Build.VERSION.RELEASE;
        }
    }

    private i() {
    }

    private final String a() {
        return (String) b.getValue();
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request().newBuilder().addHeader("User-Agent", a()).addHeader("X-Platform", "android").addHeader("X-Version", "1.7.1").build());
        Intrinsics.checkNotNullExpressionValue(proceed, "chain.proceed(request)");
        return proceed;
    }
}
