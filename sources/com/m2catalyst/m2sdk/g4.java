package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: NetworkModules.kt */
public final class g4 extends Lambda implements Function2<Scope, ParametersHolder, SpeedTestNDTApiClient> {
    public static final g4 a = new g4();

    public g4() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new SpeedTestNDTApiClient((a4) scope.get(Reflection.getOrCreateKotlinClass(a4.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
