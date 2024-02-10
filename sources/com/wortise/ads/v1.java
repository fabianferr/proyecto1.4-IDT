package com.wortise.ads;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001b\u0010\u0005\u001a\u00020\u00008FX\u0002¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/wortise/ads/u1;", "consentService$delegate", "Lkotlin/Lazy;", "a", "()Lcom/wortise/ads/u1;", "consentService", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: ConsentService.kt */
public final class v1 {
    private static final Lazy a = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/u1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ConsentService.kt */
    static final class a extends Lambda implements Function0<u1> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final u1 invoke() {
            return (u1) v.a.a(Reflection.getOrCreateKotlinClass(u1.class));
        }
    }

    public static final u1 a() {
        return (u1) a.getValue();
    }
}
