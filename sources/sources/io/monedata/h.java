package io.monedata;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006R#\u0010\f\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u000bR#\u0010\u0011\u001a\n \b*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/monedata/h;", "", "T", "Lkotlin/reflect/KClass;", "clazz", "a", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "CLIENT$delegate", "Lkotlin/Lazy;", "()Lokhttp3/OkHttpClient;", "CLIENT", "Lretrofit2/Retrofit;", "RETROFIT$delegate", "b", "()Lretrofit2/Retrofit;", "RETROFIT", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class h {
    public static final h a = new h();
    private static final Lazy b = LazyKt.lazy(a.a);
    private static final Lazy c = LazyKt.lazy(b.a);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "a", "()Lokhttp3/OkHttpClient;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<OkHttpClient> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            return new OkHttpClient.Builder().addInterceptor(i.a).addInterceptor(j.a()).build();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "a", "()Lretrofit2/Retrofit;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<Retrofit> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final Retrofit invoke() {
            return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(t0.a())).baseUrl("https://api.monedata.io").client(h.a.a()).build();
        }
    }

    private h() {
    }

    /* access modifiers changed from: private */
    public final OkHttpClient a() {
        return (OkHttpClient) b.getValue();
    }

    private final Retrofit b() {
        return (Retrofit) c.getValue();
    }

    public final <T> T a(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        T create = b().create(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkNotNullExpressionValue(create, "RETROFIT.create(clazz.java)");
        return create;
    }
}
