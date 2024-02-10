package com.wortise.ads;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wortise.ads.gson.BundleTypeAdapterFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001b\u0010\u0005\u001a\u00020\u00008FX\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/google/gson/Gson;", "GSON$delegate", "Lkotlin/Lazy;", "a", "()Lcom/google/gson/Gson;", "GSON", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: JsonParser.kt */
public final class r4 {
    private static final Lazy a = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: JsonParser.kt */
    static final class a extends Lambda implements Function0<Gson> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Gson invoke() {
            return new GsonBuilder().registerTypeAdapterFactory(new BundleTypeAdapterFactory()).setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        }
    }

    public static final Gson a() {
        Object value = a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-GSON>(...)");
        return (Gson) value;
    }
}
