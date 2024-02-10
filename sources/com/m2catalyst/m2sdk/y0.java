package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.CrashRepository;
import com.m2catalyst.m2sdk.database.daos.CrashDao;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: CrashModule.kt */
public final class y0 extends Lambda implements Function2<Scope, ParametersHolder, CrashRepository> {
    public static final y0 a = new y0();

    public y0() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new CrashRepository((CrashDao) scope.get(Reflection.getOrCreateKotlinClass(CrashDao.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
