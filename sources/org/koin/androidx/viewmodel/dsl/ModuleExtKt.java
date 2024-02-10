package org.koin.androidx.viewmodel.dsl;

import androidx.lifecycle.ViewModel;
import java.util.List;
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
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\b\u001ae\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00040\tj\b\u0012\u0004\u0012\u0002H\u0004`\f¢\u0006\u0002\b\rH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"viewModel", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "T", "Landroidx/lifecycle/ViewModel;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ModuleExt.kt */
public final class ModuleExtKt {
    public static /* synthetic */ Pair viewModel$default(Module module, Qualifier qualifier, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair(module, factoryInstanceFactory);
    }

    public static /* synthetic */ Pair viewModel$default(Module module, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, ModuleExtKt$viewModel$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair(module, factoryInstanceFactory);
    }

    @KoinReflectAPI
    public static final /* synthetic */ <T extends ViewModel> Pair<Module, InstanceFactory<T>> viewModel(Module module, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, ModuleExtKt$viewModel$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <T extends ViewModel> Pair<Module, InstanceFactory<T>> viewModel(Module module, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(ScopeRegistry.Companion.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }
}
