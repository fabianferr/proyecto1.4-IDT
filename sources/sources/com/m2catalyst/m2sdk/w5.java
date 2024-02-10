package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: SDKManagersModules.kt */
public final class w5 extends Lambda implements Function2<Scope, ParametersHolder, d5> {
    public static final w5 a = new w5();

    public w5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter((Scope) obj, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new d5();
    }
}
