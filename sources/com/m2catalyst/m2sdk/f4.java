package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: NetworkModules.kt */
public final class f4 extends Lambda implements Function2<Scope, ParametersHolder, b2> {
    public static final f4 a = new f4();

    public f4() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new b2((a4) scope.get(Reflection.getOrCreateKotlinClass(a4.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
