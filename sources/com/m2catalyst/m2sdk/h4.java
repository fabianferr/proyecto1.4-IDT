package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient;
import com.m2catalyst.m2sdk.speed_test.SpeedTestNDTApiClient;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.dsl.ModuleDSLKt;

/* compiled from: NetworkModules.kt */
public final class h4 {
    public static final Module a = ModuleDSLKt.module$default(false, b.a, 1, (Object) null);
    public static final Module b = ModuleDSLKt.module$default(false, a.a, 1, (Object) null);

    /* compiled from: NetworkModules.kt */
    public static final class a extends Lambda implements Function1<Module, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            b4 b4Var = b4.a;
            FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(MonitorStatsLoggerApiClient.class), (Qualifier) null, b4Var, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory);
            new Pair(module, factoryInstanceFactory);
            c4 c4Var = c4.a;
            FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(u1.class), (Qualifier) null, c4Var, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory2);
            new Pair(module, factoryInstanceFactory2);
            d4 d4Var = d4.a;
            FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(v1.class), (Qualifier) null, d4Var, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory3);
            new Pair(module, factoryInstanceFactory3);
            e4 e4Var = e4.a;
            FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(z1.class), (Qualifier) null, e4Var, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory4);
            new Pair(module, factoryInstanceFactory4);
            f4 f4Var = f4.a;
            FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(b2.class), (Qualifier) null, f4Var, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory5);
            new Pair(module, factoryInstanceFactory5);
            g4 g4Var = g4.a;
            FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(SpeedTestNDTApiClient.class), (Qualifier) null, g4Var, Kind.Factory, CollectionsKt.emptyList()));
            module.indexPrimaryType(factoryInstanceFactory6);
            new Pair(module, factoryInstanceFactory6);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NetworkModules.kt */
    public static final class b extends Lambda implements Function1<Module, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            i4 i4Var = i4.a;
            SingleInstanceFactory a2 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(a4.class), (Qualifier) null, i4Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a2);
            }
            new Pair(module, a2);
            return Unit.INSTANCE;
        }
    }
}
