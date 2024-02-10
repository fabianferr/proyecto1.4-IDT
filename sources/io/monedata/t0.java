package io.monedata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001b\u0010\u0005\u001a\u00020\u00008@X\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/google/gson/Gson;", "GSON$delegate", "Lkotlin/Lazy;", "a", "()Lcom/google/gson/Gson;", "GSON", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class t0 {
    private static final Lazy a = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "a", "()Lcom/google/gson/Gson;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<Gson> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Gson invoke() {
            return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        }
    }

    public static final Gson a() {
        Object value = a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-GSON>(...)");
        return (Gson) value;
    }
}
