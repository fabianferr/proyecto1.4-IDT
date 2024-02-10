package com.m2catalyst.m2sdk;

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

/* compiled from: SDKComponentsModules.kt */
public final class q5 {
    public static final Module a = ModuleDSLKt.module$default(false, a.a, 1, (Object) null);

    /* compiled from: SDKComponentsModules.kt */
    public static final class a extends Lambda implements Function1<Module, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            n5 n5Var = n5.a;
            SingleInstanceFactory a2 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(z5.class), (Qualifier) null, n5Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a2);
            }
            new Pair(module, a2);
            o5 o5Var = o5.a;
            SingleInstanceFactory a3 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(y2.class), (Qualifier) null, o5Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a3);
            }
            new Pair(module, a3);
            p5 p5Var = p5.a;
            SingleInstanceFactory a4 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(v0.class), (Qualifier) null, p5Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a4);
            }
            new Pair(module, a4);
            return Unit.INSTANCE;
        }
    }
}
