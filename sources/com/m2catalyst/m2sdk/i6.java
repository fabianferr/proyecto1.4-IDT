package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.speed_test.SpeedTestManager;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: SpeedTestModule.kt */
public final class i6 {
    public static final Module a = ModuleDSLKt.module$default(false, a.a, 1, (Object) null);

    /* compiled from: SpeedTestModule.kt */
    public static final class a extends Lambda implements Function1<Module, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            g6 g6Var = g6.a;
            SingleInstanceFactory a2 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ThroughputConfigUtil.class), (Qualifier) null, g6Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a2);
            }
            new Pair(module, a2);
            h6 h6Var = h6.a;
            SingleInstanceFactory a3 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SpeedTestManager.class), (Qualifier) null, h6Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a3);
            }
            new Pair(module, a3);
            return Unit.INSTANCE;
        }
    }
}
