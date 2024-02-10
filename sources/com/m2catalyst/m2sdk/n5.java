package com.m2catalyst.m2sdk;

import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.scope.Scope;

/* compiled from: SDKComponentsModules.kt */
public final class n5 extends Lambda implements Function2<Scope, ParametersHolder, z5> {
    public static final n5 a = new n5();

    public n5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new z5((SharedPreferences) scope.get(Reflection.getOrCreateKotlinClass(SharedPreferences.class), QualifierKt.named("sdk_preferences"), (Function0<? extends ParametersHolder>) null));
    }
}
