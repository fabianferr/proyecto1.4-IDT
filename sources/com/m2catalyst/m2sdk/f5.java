package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: RespositoriesModules.kt */
public final class f5 extends Lambda implements Function2<Scope, ParametersHolder, DeviceRepository> {
    public static final f5 a = new f5();

    public f5() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        Intrinsics.checkNotNullParameter(scope, "$this$single");
        Intrinsics.checkNotNullParameter((ParametersHolder) obj2, "it");
        DeviceRepository deviceRepository = new DeviceRepository((z1) scope.get(Reflection.getOrCreateKotlinClass(z1.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null), (Context) scope.get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
        deviceRepository.setTesting$m2sdk_release(true);
        return deviceRepository;
    }
}
