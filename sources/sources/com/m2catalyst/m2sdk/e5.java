package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.database.daos.LocationDao;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class e5 extends Lambda implements Function2<Scope, ParametersHolder, LocationRepository> {
    public static final e5 a = new e5();

    public e5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        LocationRepository locationRepository = new LocationRepository((LocationDao) scope.get(Reflection.getOrCreateKotlinClass(LocationDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (u1) scope.get(Reflection.getOrCreateKotlinClass(u1.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        locationRepository.setTesting$m2sdk_release(true);
        return locationRepository;
    }
}
