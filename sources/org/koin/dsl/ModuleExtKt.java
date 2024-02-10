package org.koin.dsl;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a7\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\b\u001aA\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\b¨\u0006\u000b"}, d2 = {"factory", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "T", "", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "single", "createOnStart", "", "koin-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModuleExt.kt */
public final class ModuleExtKt {
    public static /* synthetic */ Pair single$default(Module module, Qualifier qualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, ModuleExtKt$single$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(singleInstanceFactory);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new Pair(module, singleInstanceFactory);
    }

    @Deprecated(message = "API is deprecated in favor of singleOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> single(Module module, Qualifier qualifier, boolean z) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, ModuleExtKt$single$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(singleInstanceFactory);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new Pair<>(module, singleInstanceFactory);
    }

    public static /* synthetic */ Pair factory$default(Module module, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, ModuleExtKt$factory$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair(module, factoryInstanceFactory);
    }

    @Deprecated(message = "API is deprecated in favor of factoryOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T> Pair<Module, InstanceFactory<T>> factory(Module module, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, ModuleExtKt$factory$1.INSTANCE, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }
}
