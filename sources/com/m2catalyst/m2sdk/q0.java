package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.WifiRepository;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CollectionModules.kt */
public final class q0 extends Lambda implements Function2<Scope, ParametersHolder, c7> {
    public static final q0 a = new q0();

    public q0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new c7((Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (g2) scope.get(Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (z3) scope.get(Reflection.getOrCreateKotlinClass(z3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (WifiRepository) scope.get(Reflection.getOrCreateKotlinClass(WifiRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (z5) scope.get(Reflection.getOrCreateKotlinClass(z5.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
