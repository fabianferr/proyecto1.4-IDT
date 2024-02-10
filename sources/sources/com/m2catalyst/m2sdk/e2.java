package com.m2catalyst.m2sdk;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: LocationCollectionOrchestrator.kt */
public final class e2 implements KoinComponent {
    public final Lazy a = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));

    /* compiled from: KoinComponent.kt */
    public static final class a extends Lambda implements Function0<g2> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.g2] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.g2] */
        public final g2 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }
}
