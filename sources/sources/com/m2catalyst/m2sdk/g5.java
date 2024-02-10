package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.repositories.ApiKeyRepository;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class g5 extends Lambda implements Function2<Scope, ParametersHolder, ApiKeyRepository> {
    public static final g5 a = new g5();

    public g5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$factory");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        ApiKeyRepository apiKeyRepository = new ApiKeyRepository((b2) scope.get(Reflection.getOrCreateKotlinClass(b2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        apiKeyRepository.setTesting$m2sdk_release(true);
        return apiKeyRepository;
    }
}
