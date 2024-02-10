package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.business.repositories.NDTRepository;
import com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient;
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
public final class g6 extends Lambda implements Function2<Scope, ParametersHolder, ThroughputConfigUtil> {
    public static final g6 a = new g6();

    public g6() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new ThroughputConfigUtil((NDTRepository) scope.get(Reflection.getOrCreateKotlinClass(NDTRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (MNSIRepository) scope.get(Reflection.getOrCreateKotlinClass(MNSIRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (SpeedTestNDTApiClient) scope.get(Reflection.getOrCreateKotlinClass(SpeedTestNDTApiClient.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (g2) scope.get(Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
