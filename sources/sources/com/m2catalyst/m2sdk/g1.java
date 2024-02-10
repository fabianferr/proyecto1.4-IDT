package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.database.SDKDatabase;
import com.m2catalyst.m2sdk.database.daos.NDTDao;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: DataModules.kt */
public final class g1 extends Lambda implements Function2<Scope, ParametersHolder, NDTDao> {
    public static final g1 a = new g1();

    public g1() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return ((SDKDatabase) scope.get(Reflection.getOrCreateKotlinClass(SDKDatabase.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null)).networkDiagnosticsDao();
    }
}
