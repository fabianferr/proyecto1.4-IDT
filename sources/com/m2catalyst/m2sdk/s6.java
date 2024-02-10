package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: TestingModule.kt */
public final class s6 extends Lambda implements Function2<Scope, ParametersHolder, m3> {
    public static final s6 a = new s6();

    public s6() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter((Scope) obj, "$this$viewModel");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new m3();
    }
}
