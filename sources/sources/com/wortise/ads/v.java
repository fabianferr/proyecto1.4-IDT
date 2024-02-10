package com.wortise.ads;

import androidx.core.app.NotificationCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\nR#\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/wortise/ads/v;", "", "T", "Lkotlin/reflect/KClass;", "service", "a", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Lokhttp3/OkHttpClient;", "CLIENT$delegate", "Lkotlin/Lazy;", "()Lokhttp3/OkHttpClient;", "CLIENT", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "RETROFIT$delegate", "b", "()Lretrofit2/Retrofit;", "RETROFIT", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ApiFactory.kt */
public final class v {
    public static final v a = new v();
    private static final Lazy b = LazyKt.lazy(a.a);
    private static final Lazy c = LazyKt.lazy(b.a);

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lokhttp3/OkHttpClient;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ApiFactory.kt */
    static final class a extends Lambda implements Function0<OkHttpClient> {
        public static final a a = new a();

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.wortise.ads.v$a$a  reason: collision with other inner class name */
        /* compiled from: ApiFactory.kt */
        static final class C0200a extends Lambda implements Function1<OkHttpClient.Builder, Unit> {
            public static final C0200a a = new C0200a();

            C0200a() {
                super(1);
            }

            public final void a(OkHttpClient.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "$this$create");
                builder.addInterceptor(s3.a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((OkHttpClient.Builder) obj);
                return Unit.INSTANCE;
            }
        }

        a() {
            super(0);
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            return j5.a.a(C0200a.a);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ApiFactory.kt */
    static final class b extends Lambda implements Function0<Retrofit> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final Retrofit invoke() {
            return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(r4.a())).baseUrl("https://api.wortise.com/").client(v.a.a()).build();
        }
    }

    private v() {
    }

    private final Retrofit b() {
        return (Retrofit) c.getValue();
    }

    /* access modifiers changed from: private */
    public final OkHttpClient a() {
        return (OkHttpClient) b.getValue();
    }

    public final <T> T a(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, NotificationCompat.CATEGORY_SERVICE);
        T create = b().create(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkNotNullExpressionValue(create, "RETROFIT.create(service.java)");
        return create;
    }
}
