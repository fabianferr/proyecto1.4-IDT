package io.monedata;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001b\u0010\u0005\u001a\u00020\u00008@X\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/monedata/k;", "apiService$delegate", "Lkotlin/Lazy;", "a", "()Lio/monedata/k;", "apiService", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class l {
    private static final Lazy a = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/monedata/k;", "a", "()Lio/monedata/k;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<k> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final k invoke() {
            return (k) h.a.a(Reflection.getOrCreateKotlinClass(k.class));
        }
    }

    public static final k a() {
        return (k) a.getValue();
    }
}
