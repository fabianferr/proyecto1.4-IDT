package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NDTRepository;
import com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.WifiRepository;
import com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SDKComponentsModules.kt */
public final class p5 extends Lambda implements Function2<Scope, ParametersHolder, v0> {
    public static final p5 a = new p5();

    public p5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new v0((LocationRepository) scope.get(Reflection.getOrCreateKotlinClass(LocationRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (MNSIRepository) scope.get(Reflection.getOrCreateKotlinClass(MNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (NoSignalMNSIRepository) scope.get(Reflection.getOrCreateKotlinClass(NoSignalMNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (WifiRepository) scope.get(Reflection.getOrCreateKotlinClass(WifiRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (NDTRepository) scope.get(Reflection.getOrCreateKotlinClass(NDTRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (BadSignalsRepository) scope.get(Reflection.getOrCreateKotlinClass(BadSignalsRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (DeviceRepository) scope.get(Reflection.getOrCreateKotlinClass(DeviceRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
