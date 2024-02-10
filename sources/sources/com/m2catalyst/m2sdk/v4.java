package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.core.setup.ZombieInitializationSDKReceiver;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

/* compiled from: ReceiverModule.kt */
public final class v4 extends Lambda implements Function2<Scope, ParametersHolder, ZombieInitializationSDKReceiver> {
    public static final v4 a = new v4();

    public v4() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter((Scope) obj, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        return new ZombieInitializationSDKReceiver();
    }
}
