package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.database.SDKDatabase;
import com.m2catalyst.m2sdk.database.daos.MNSIDao;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: DataModules.kt */
public final class f1 extends Lambda implements Function2<Scope, ParametersHolder, MNSIDao> {
    public static final f1 a = new f1();

    public f1() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return ((SDKDatabase) scope.get(Reflection.getOrCreateKotlinClass(SDKDatabase.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null)).mobileSignalNetworkDao();
    }
}
