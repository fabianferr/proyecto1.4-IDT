package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.WifiRepository;
import com.m2catalyst.m2sdk.database.daos.WifiDao;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class l5 extends Lambda implements Function2<Scope, ParametersHolder, WifiRepository> {
    public static final l5 a = new l5();

    public l5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        WifiRepository wifiRepository = new WifiRepository((WifiDao) scope.get(Reflection.getOrCreateKotlinClass(WifiDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        wifiRepository.setTesting$m2sdk_release(true);
        return wifiRepository;
    }
}
