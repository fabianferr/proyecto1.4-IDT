package com.m2catalyst.m2sdk;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: DataModules.kt */
public final class m1 extends Lambda implements Function2<Scope, ParametersHolder, SharedPreferences> {
    public static final m1 a = new m1();

    public m1() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        SharedPreferences sharedPreferences = ((Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null)).getSharedPreferences("sdk-settings", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "get<Context>().getShared…s\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
