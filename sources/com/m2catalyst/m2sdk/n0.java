package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository;
import com.m2catalyst.m2sdk.speed_test.SpeedTestManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CollectionModules.kt */
public final class n0 extends Lambda implements Function2<Scope, ParametersHolder, q3> {
    public static final n0 a = new n0();

    public n0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new q3((Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (MNSIRepository) scope.get(Reflection.getOrCreateKotlinClass(MNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (NoSignalMNSIRepository) scope.get(Reflection.getOrCreateKotlinClass(NoSignalMNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (q) scope.get(Reflection.getOrCreateKotlinClass(q.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (LocationRepository) scope.get(Reflection.getOrCreateKotlinClass(LocationRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (g2) scope.get(Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (z3) scope.get(Reflection.getOrCreateKotlinClass(z3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (SpeedTestManager) scope.get(Reflection.getOrCreateKotlinClass(SpeedTestManager.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
