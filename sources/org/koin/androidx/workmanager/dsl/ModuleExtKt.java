package org.koin.androidx.workmanager.dsl;

import androidx.work.ListenableWorker;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.DefinitionBindingKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\b\u001aa\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00040\tj\b\u0012\u0004\u0012\u0002H\u0004`\f¢\u0006\u0002\b\rH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"worker", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "T", "Landroidx/work/ListenableWorker;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "koin-androidx-workmanager_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ModuleExt.kt */
public final class ModuleExtKt {
    @Deprecated(message = "API is deprecated in favor of workerOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T extends ListenableWorker> Pair<Module, InstanceFactory<?>> worker(Module module, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, ModuleExtKt$worker$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return DefinitionBindingKt.bind(new Pair(module, factoryInstanceFactory), Reflection.getOrCreateKotlinClass(ListenableWorker.class));
    }

    public static final /* synthetic */ <T extends ListenableWorker> Pair<Module, InstanceFactory<?>> worker(Module module, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return DefinitionBindingKt.bind(new Pair(module, factoryInstanceFactory), Reflection.getOrCreateKotlinClass(ListenableWorker.class));
    }

    public static /* synthetic */ Pair worker$default(Module module, Qualifier qualifier, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "T");
            qualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(qualifier2, "qualifier");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return DefinitionBindingKt.bind(new Pair(module, factoryInstanceFactory), Reflection.getOrCreateKotlinClass(ListenableWorker.class));
    }

    public static /* synthetic */ Pair worker$default(Module module, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "T");
            qualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(qualifier2, "qualifier");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, ModuleExtKt$worker$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return DefinitionBindingKt.bind(new Pair(module, factoryInstanceFactory), Reflection.getOrCreateKotlinClass(ListenableWorker.class));
    }
}
