package com.m2catalyst.m2sdk;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CollectionModules.kt */
public final class j0 extends Lambda implements Function2<Scope, ParametersHolder, q> {
    public static final j0 a = new j0();

    public j0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new q(CollectionsKt.listOf((i) scope.get(Reflection.getOrCreateKotlinClass(j.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(k.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(l.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(m.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(n.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(o.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(p.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(s.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (i) scope.get(Reflection.getOrCreateKotlinClass(u.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null)));
    }
}
