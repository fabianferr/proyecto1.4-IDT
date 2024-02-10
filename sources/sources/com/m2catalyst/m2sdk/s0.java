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

/* compiled from: CollectionModules.kt */
public final class s0 {
    public static final Module a = ModuleDSLKt.module$default(false, a.a, 1, (Object) null);

    /* compiled from: CollectionModules.kt */
    public static final class a extends Lambda implements Function1<Module, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Module module = (Module) obj;
            Intrinsics.checkNotNullParameter(module, "$this$module");
            i0 i0Var = i0.a;
            SingleInstanceFactory a2 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(v3.class), (Qualifier) null, i0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a2);
            }
            new Pair(module, a2);
            k0 k0Var = k0.a;
            SingleInstanceFactory a3 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(e2.class), (Qualifier) null, k0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a3);
            }
            new Pair(module, a3);
            l0 l0Var = l0.a;
            SingleInstanceFactory a4 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(d7.class), (Qualifier) null, l0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a4);
            }
            new Pair(module, a4);
            m0 m0Var = m0.a;
            SingleInstanceFactory a5 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(w.class), (Qualifier) null, m0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a5);
            }
            new Pair(module, a5);
            n0 n0Var = n0.a;
            SingleInstanceFactory a6 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(q3.class), (Qualifier) null, n0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a6);
            }
            new Pair(module, a6);
            o0 o0Var = o0.a;
            SingleInstanceFactory a7 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, o0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a7);
            }
            new Pair(module, a7);
            p0 p0Var = p0.a;
            SingleInstanceFactory a8 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(c2.class), (Qualifier) null, p0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a8);
            }
            new Pair(module, a8);
            q0 q0Var = q0.a;
            SingleInstanceFactory a9 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(c7.class), (Qualifier) null, q0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a9);
            }
            new Pair(module, a9);
            r0 r0Var = r0.a;
            SingleInstanceFactory a10 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(v6.class), (Qualifier) null, r0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a10);
            }
            new Pair(module, a10);
            y yVar = y.a;
            SingleInstanceFactory a11 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(z3.class), (Qualifier) null, yVar, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a11);
            }
            new Pair(module, a11);
            z zVar = z.a;
            SingleInstanceFactory a12 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(j.class), (Qualifier) null, zVar, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a12);
            }
            new Pair(module, a12);
            a0 a0Var = a0.a;
            SingleInstanceFactory a13 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(k.class), (Qualifier) null, a0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a13);
            }
            new Pair(module, a13);
            b0 b0Var = b0.a;
            SingleInstanceFactory a14 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(l.class), (Qualifier) null, b0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a14);
            }
            new Pair(module, a14);
            c0 c0Var = c0.a;
            SingleInstanceFactory a15 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(m.class), (Qualifier) null, c0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a15);
            }
            new Pair(module, a15);
            d0 d0Var = d0.a;
            SingleInstanceFactory a16 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(n.class), (Qualifier) null, d0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a16);
            }
            new Pair(module, a16);
            e0 e0Var = e0.a;
            SingleInstanceFactory a17 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(o.class), (Qualifier) null, e0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a17);
            }
            new Pair(module, a17);
            f0 f0Var = f0.a;
            SingleInstanceFactory a18 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(p.class), (Qualifier) null, f0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a18);
            }
            new Pair(module, a18);
            g0 g0Var = g0.a;
            SingleInstanceFactory a19 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(s.class), (Qualifier) null, g0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a19);
            }
            new Pair(module, a19);
            h0 h0Var = h0.a;
            SingleInstanceFactory a20 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(u.class), (Qualifier) null, h0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a20);
            }
            new Pair(module, a20);
            j0 j0Var = j0.a;
            SingleInstanceFactory a21 = x.a(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(q.class), (Qualifier) null, j0Var, Kind.Singleton, CollectionsKt.emptyList()), module);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(a21);
            }
            new Pair(module, a21);
            return Unit.INSTANCE;
        }
    }
}
