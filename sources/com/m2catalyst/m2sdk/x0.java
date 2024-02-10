package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.logger.CrashCollector;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: CrashModule.kt */
public final class x0 extends Lambda implements Function2<Scope, ParametersHolder, CrashCollector> {
    public static final x0 a = new x0();

    public x0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter((Scope) obj, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new CrashCollector();
    }
}
