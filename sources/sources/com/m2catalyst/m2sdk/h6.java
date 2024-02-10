package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.speed_test.SpeedTestManager;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SpeedTestModule.kt */
public final class h6 extends Lambda implements Function2<Scope, ParametersHolder, SpeedTestManager> {
    public static final h6 a = new h6();

    public h6() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new SpeedTestManager((Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (ThroughputConfigUtil) scope.get(Reflection.getOrCreateKotlinClass(ThroughputConfigUtil.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
