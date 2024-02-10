package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository;
import com.m2catalyst.m2sdk.database.daos.NoSignalMNSIDao;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class k5 extends Lambda implements Function2<Scope, ParametersHolder, NoSignalMNSIRepository> {
    public static final k5 a = new k5();

    public k5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        NoSignalMNSIRepository noSignalMNSIRepository = new NoSignalMNSIRepository((NoSignalMNSIDao) scope.get(Reflection.getOrCreateKotlinClass(NoSignalMNSIDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        noSignalMNSIRepository.setTesting$m2sdk_release(true);
        return noSignalMNSIRepository;
    }
}
