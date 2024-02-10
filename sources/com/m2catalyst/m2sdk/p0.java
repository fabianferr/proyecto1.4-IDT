package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CollectionModules.kt */
public final class p0 extends Lambda implements Function2<Scope, ParametersHolder, c2> {
    public static final p0 a = new p0();

    public p0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new d2((q3) scope.get(Reflection.getOrCreateKotlinClass(q3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
