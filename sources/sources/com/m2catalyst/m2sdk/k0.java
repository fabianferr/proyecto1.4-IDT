package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: CollectionModules.kt */
public final class k0 extends Lambda implements Function2<Scope, ParametersHolder, e2> {
    public static final k0 a = new k0();

    public k0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter((Scope) obj, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new e2();
    }
}
