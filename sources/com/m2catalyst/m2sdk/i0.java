package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: CollectionModules.kt */
public final class i0 extends Lambda implements Function2<Scope, ParametersHolder, v3> {
    public static final i0 a = new i0();

    public i0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter((Scope) obj, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new v3();
    }
}
