package org.koin.dsl;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jg\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\r0\fj\b\u0012\u0004\u0012\u0002H\u000e`\u000f\"\u0006\b\u0000\u0010\u000e\u0018\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032)\b\b\u0010\u0011\u001a#\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u000e0\u0012j\b\u0012\u0004\u0012\u0002H\u000e`\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000Jg\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\r0\fj\b\u0012\u0004\u0012\u0002H\u000e`\u000f\"\u0006\b\u0000\u0010\u000e\u0018\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032)\b\b\u0010\u0011\u001a#\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u000e0\u0012j\b\u0012\u0004\u0012\u0002H\u000e`\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000Jg\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\r0\fj\b\u0012\u0004\u0012\u0002H\u000e`\u000f\"\u0006\b\u0000\u0010\u000e\u0018\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032)\b\b\u0010\u0011\u001a#\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002H\u000e0\u0012j\b\u0012\u0004\u0012\u0002H\u000e`\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"Lorg/koin/dsl/ScopeDSL;", "", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "module", "Lorg/koin/core/module/Module;", "(Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/module/Module;)V", "getModule", "()Lorg/koin/core/module/Module;", "getScopeQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "factory", "Lkotlin/Pair;", "Lorg/koin/core/instance/InstanceFactory;", "T", "Lorg/koin/core/module/KoinDefinition;", "qualifier", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scoped", "single", "koin-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScopeDSL.kt */
public final class ScopeDSL {
    private final Module module;
    private final Qualifier scopeQualifier;

    public ScopeDSL(Qualifier qualifier, Module module2) {
        Intrinsics.checkNotNullParameter(qualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(module2, "module");
        this.scopeQualifier = qualifier;
        this.module = module2;
    }

    public final Module getModule() {
        return this.module;
    }

    public final Qualifier getScopeQualifier() {
        return this.scopeQualifier;
    }

    public static /* synthetic */ Pair single$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 function2, int i, Object obj) {
        Intrinsics.checkNotNullParameter(function2, "definition");
        throw new IllegalStateException("Scoped definition is deprecated and has been replaced with Single scope definitions".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Can't use Single in a scope. Use Scoped instead")
    public final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> single(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "definition");
        throw new IllegalStateException("Scoped definition is deprecated and has been replaced with Single scope definitions".toString());
    }

    public static /* synthetic */ Pair scoped$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(function2, "definition");
        Qualifier scopeQualifier2 = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> scoped(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "definition");
        Qualifier scopeQualifier2 = getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList));
        getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(getModule(), scopedInstanceFactory);
    }

    public static /* synthetic */ Pair factory$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(function2, "definition");
        Module module2 = scopeDSL.getModule();
        Qualifier scopeQualifier2 = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function2, kind, emptyList));
        module2.indexPrimaryType(factoryInstanceFactory);
        return new Pair(module2, factoryInstanceFactory);
    }

    public final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "definition");
        Module module2 = getModule();
        Qualifier scopeQualifier2 = getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier2, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList));
        module2.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module2, factoryInstanceFactory);
    }
}
