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
import org.koin.core.scope.Scope;
import org.koin.dsl.DefinitionBindingKt;
import org.koin.dsl.ScopeDSL;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\b\u001aa\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2)\b\b\u0010\t\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00040\nj\b\u0012\u0004\u0012\u0002H\u0004`\r¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"worker", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "T", "Landroidx/work/ListenableWorker;", "Lorg/koin/dsl/ScopeDSL;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "koin-androidx-workmanager_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ScopeDSLExt.kt */
public final class ScopeDSLExtKt {
    @Deprecated(message = "API is deprecated in favor of workerOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T extends ListenableWorker> Pair<Module, InstanceFactory<?>> worker(ScopeDSL scopeDSL, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, ScopeDSLExtKt$worker$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        Pair<Module, InstanceFactory<?>> pair = new Pair<>(module, factoryInstanceFactory);
        DefinitionBindingKt.bind(pair, Reflection.getOrCreateKotlinClass(ListenableWorker.class));
        return pair;
    }

    public static final /* synthetic */ <T extends ListenableWorker> Pair<Module, InstanceFactory<?>> worker(ScopeDSL scopeDSL, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, function2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        Pair<Module, InstanceFactory<?>> pair = new Pair<>(module, factoryInstanceFactory);
        DefinitionBindingKt.bind(pair, Reflection.getOrCreateKotlinClass(ListenableWorker.class));
        return pair;
    }

    public static /* synthetic */ Pair worker$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "T");
            qualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(qualifier2, "qualifier");
        Intrinsics.checkNotNullParameter(function2, "definition");
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function2, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        Pair pair = new Pair(module, factoryInstanceFactory);
        DefinitionBindingKt.bind(pair, Reflection.getOrCreateKotlinClass(ListenableWorker.class));
        return pair;
    }

    public static /* synthetic */ Pair worker$default(ScopeDSL scopeDSL, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "T");
            qualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(qualifier2, "qualifier");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, ScopeDSLExtKt$worker$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        Pair pair = new Pair(module, factoryInstanceFactory);
        DefinitionBindingKt.bind(pair, Reflection.getOrCreateKotlinClass(ListenableWorker.class));
        return pair;
    }
}
