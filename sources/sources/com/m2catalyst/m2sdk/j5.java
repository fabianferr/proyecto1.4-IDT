package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.database.daos.BadSignalsDao;
import com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class j5 extends Lambda implements Function2<Scope, ParametersHolder, BadSignalsRepository> {
    public static final j5 a = new j5();

    public j5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        BadSignalsRepository badSignalsRepository = new BadSignalsRepository((BadSignalsDao) scope.get(Reflection.getOrCreateKotlinClass(BadSignalsDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        badSignalsRepository.setTesting$m2sdk_release(true);
        return badSignalsRepository;
    }
}
