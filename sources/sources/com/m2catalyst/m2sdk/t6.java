package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.testing.business.DataQualityValidator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: TestingModule.kt */
public final class t6 extends Lambda implements Function2<Scope, ParametersHolder, DataQualityValidator> {
    public static final t6 a = new t6();

    public t6() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new DataQualityValidator((q) scope.get(Reflection.getOrCreateKotlinClass(q.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
