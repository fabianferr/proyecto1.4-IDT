package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.NDTRepository;
import com.m2catalyst.m2sdk.database.daos.NDTDao;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class h5 extends Lambda implements Function2<Scope, ParametersHolder, NDTRepository> {
    public static final h5 a = new h5();

    public h5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        NDTRepository nDTRepository = new NDTRepository((NDTDao) scope.get(Reflection.getOrCreateKotlinClass(NDTDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        nDTRepository.setTesting$m2sdk_release(true);
        return nDTRepository;
    }
}
