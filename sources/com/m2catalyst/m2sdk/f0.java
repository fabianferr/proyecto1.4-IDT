package com.m2catalyst.m2sdk;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CollectionModules.kt */
public final class f0 extends Lambda implements Function2<Scope, ParametersHolder, p> {
    public static final f0 a = new f0();

    public f0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new p((Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
