package org.koin.core;

import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.error.ScopeNotCreatedException;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.EmptyLogger;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.registry.PropertyRegistry;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.core.time.MeasureKt;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u001d\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u0002H\u001c¢\u0006\u0002\u0010\u001fJ#\u0010\u001a\u001a\u00020\u001b\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\f\b\u0002\u0010 \u001a\u00060!j\u0002`\"H\bJ-\u0010\u001a\u001a\u00020\u001b\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0010 \u001a\u00060!j\u0002`\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0001H\bJ&\u0010\u001a\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0001JH\u0010&\u001a\u00020\u0018\"\u0006\b\u0000\u0010\u001c\u0018\u00012\u0006\u0010'\u001a\u0002H\u001c2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0012\b\u0002\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)2\b\b\u0002\u0010+\u001a\u00020,H\b¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020!J\u0012\u00100\u001a\u00020\u00182\n\u0010 \u001a\u00060!j\u0002`\"JA\u00101\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\n\u00102\u001a\u0006\u0012\u0002\b\u00030*2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6¢\u0006\u0002\u00107JA\u00101\u001a\u0002H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\b\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\bø\u0001\u0000¢\u0006\u0002\u00108J\u0017\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001c0)\"\u0006\b\u0000\u0010\u001c\u0018\u0001H\bJ!\u0010:\u001a\u00020\u001b\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0010 \u001a\u00060!j\u0002`\"H\bJ&\u0010:\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0001JC\u0010;\u001a\u0004\u0018\u0001H\u001c\"\u0004\b\u0000\u0010\u001c2\n\u00102\u001a\u0006\u0012\u0002\b\u00030*2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6¢\u0006\u0002\u00107JC\u0010;\u001a\u0004\u0018\u0001H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\b\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\bø\u0001\u0000¢\u0006\u0002\u00108J\u001f\u0010<\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0006\u0010/\u001a\u00020!¢\u0006\u0002\u0010=J%\u0010<\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0006\u0010/\u001a\u00020!2\u0006\u0010>\u001a\u0002H\u001c¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"J\u0014\u0010A\u001a\u0004\u0018\u00010\u001b2\n\u0010 \u001a\u00060!j\u0002`\"JL\u0010B\u001a\b\u0012\u0004\u0012\u0002H\u001c0C\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010D\u001a\u00020E2\u0016\b\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\bø\u0001\u0000JN\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0C\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010D\u001a\u00020E2\u0016\b\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\bø\u0001\u0000J\u001e\u0010G\u001a\u00020\u00182\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0)2\b\b\u0002\u0010+\u001a\u00020,J\u0016\u0010J\u001a\u00020\u00182\u0006\u0010/\u001a\u00020!2\u0006\u0010K\u001a\u00020\u0001J\u0010\u0010L\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0007J\u0014\u0010M\u001a\u00020\u00182\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0)R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006N"}, d2 = {"Lorg/koin/core/Koin;", "", "()V", "instanceRegistry", "Lorg/koin/core/registry/InstanceRegistry;", "getInstanceRegistry$annotations", "getInstanceRegistry", "()Lorg/koin/core/registry/InstanceRegistry;", "<set-?>", "Lorg/koin/core/logger/Logger;", "logger", "getLogger", "()Lorg/koin/core/logger/Logger;", "propertyRegistry", "Lorg/koin/core/registry/PropertyRegistry;", "getPropertyRegistry$annotations", "getPropertyRegistry", "()Lorg/koin/core/registry/PropertyRegistry;", "scopeRegistry", "Lorg/koin/core/registry/ScopeRegistry;", "getScopeRegistry$annotations", "getScopeRegistry", "()Lorg/koin/core/registry/ScopeRegistry;", "close", "", "createEagerInstances", "createScope", "Lorg/koin/core/scope/Scope;", "T", "Lorg/koin/core/component/KoinScopeComponent;", "t", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "scopeId", "", "Lorg/koin/core/scope/ScopeID;", "source", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "declare", "instance", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "deleteProperty", "key", "deleteScope", "get", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getOrCreateScope", "getOrNull", "getProperty", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getScope", "getScopeOrNull", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "loadModules", "modules", "Lorg/koin/core/module/Module;", "setProperty", "value", "setupLogger", "unloadModules", "koin-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Koin.kt */
public final class Koin {
    private final InstanceRegistry instanceRegistry = new InstanceRegistry(this);
    private Logger logger = new EmptyLogger();
    private final PropertyRegistry propertyRegistry = new PropertyRegistry(this);
    private final ScopeRegistry scopeRegistry = new ScopeRegistry(this);

    public static /* synthetic */ void getInstanceRegistry$annotations() {
    }

    public static /* synthetic */ void getPropertyRegistry$annotations() {
    }

    public static /* synthetic */ void getScopeRegistry$annotations() {
    }

    public final ScopeRegistry getScopeRegistry() {
        return this.scopeRegistry;
    }

    public final InstanceRegistry getInstanceRegistry() {
        return this.instanceRegistry;
    }

    public final PropertyRegistry getPropertyRegistry() {
        return this.propertyRegistry;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final void setupLogger(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.logger = logger2;
    }

    public static /* synthetic */ Lazy inject$default(Koin koin, Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            lazyThreadSafetyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Koin$inject$$inlined$inject$1(rootScope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Koin$inject$$inlined$inject$1(rootScope, qualifier, function0));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Koin koin, Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            lazyThreadSafetyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Koin$injectOrNull$$inlined$injectOrNull$1(rootScope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Koin$injectOrNull$$inlined$injectOrNull$1(rootScope, qualifier, function0));
    }

    public static /* synthetic */ Object get$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T");
        return rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T");
        return rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T");
        return rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T");
        return rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public static /* synthetic */ Object get$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.get(kClass, qualifier, function0);
    }

    public final <T> T get(KClass<?> kClass, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return this.scopeRegistry.getRootScope().get(kClass, qualifier, function0);
    }

    public static /* synthetic */ Object getOrNull$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> kClass, Qualifier qualifier, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return this.scopeRegistry.getRootScope().getOrNull(kClass, qualifier, function0);
    }

    public static /* synthetic */ void declare$default(Koin koin, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        Qualifier qualifier2 = (i & 2) != 0 ? null : qualifier;
        List emptyList = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        boolean z2 = (i & 8) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(emptyList, "secondaryTypes");
        InstanceRegistry instanceRegistry2 = koin.getInstanceRegistry();
        Qualifier scopeQualifier = instanceRegistry2.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Object obj3 = obj;
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, new Koin$declare$$inlined$declareRootInstance$1(obj), kind, emptyList);
        InstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        InstanceRegistry.saveMapping$default(instanceRegistry2, z2, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, (Object) null);
        for (KClass indexKey : beanDefinition.getSecondaryTypes()) {
            InstanceRegistry.saveMapping$default(instanceRegistry2, z2, BeanDefinitionKt.indexKey(indexKey, beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, (Object) null);
        }
    }

    public final /* synthetic */ <T> void declare(T t, Qualifier qualifier, List<? extends KClass<?>> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "secondaryTypes");
        InstanceRegistry instanceRegistry2 = getInstanceRegistry();
        Qualifier scopeQualifier = instanceRegistry2.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, new Koin$declare$$inlined$declareRootInstance$1(t), kind, list);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        InstanceFactory instanceFactory = singleInstanceFactory;
        InstanceRegistry.saveMapping$default(instanceRegistry2, z, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), instanceFactory, false, 8, (Object) null);
        for (KClass indexKey : beanDefinition.getSecondaryTypes()) {
            InstanceRegistry.saveMapping$default(instanceRegistry2, z, BeanDefinitionKt.indexKey(indexKey, beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), instanceFactory, false, 8, (Object) null);
        }
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T");
        return rootScope.getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return koin.createScope(str, qualifier, obj);
    }

    public final Scope createScope(String str, Qualifier qualifier, Object obj) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        this.logger.log(Level.DEBUG, (Function0<String>) new Koin$createScope$1(str, qualifier));
        return this.scopeRegistry.createScope(str, qualifier, obj);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        koin.getLogger().log(Level.DEBUG, (Function0<String>) new Koin$createScope$2(str, typeQualifier));
        return koin.getScopeRegistry().createScope(str, typeQualifier, obj);
    }

    public final /* synthetic */ <T> Scope createScope(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        getLogger().log(Level.DEBUG, (Function0<String>) new Koin$createScope$2(str, typeQualifier));
        return getScopeRegistry().createScope(str, typeQualifier, obj);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = KoinPlatformTools.INSTANCE.generateId();
        }
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        koin.getLogger().log(Level.DEBUG, (Function0<String>) new Koin$createScope$3(str, typeQualifier));
        return koin.getScopeRegistry().createScope(str, typeQualifier, (Object) null);
    }

    public final /* synthetic */ <T> Scope createScope(String str) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        getLogger().log(Level.DEBUG, (Function0<String>) new Koin$createScope$3(str, typeQualifier));
        return getScopeRegistry().createScope(str, typeQualifier, (Object) null);
    }

    public final <T extends KoinScopeComponent> Scope createScope(T t) {
        Intrinsics.checkNotNullParameter(t, "t");
        String scopeId = KoinScopeComponentKt.getScopeId(t);
        TypeQualifier scopeName = KoinScopeComponentKt.getScopeName(t);
        this.logger.log(Level.DEBUG, (Function0<String>) new Koin$createScope$4(scopeId, scopeName));
        return this.scopeRegistry.createScope(scopeId, scopeName, (Object) null);
    }

    public static /* synthetic */ Scope getOrCreateScope$default(Koin koin, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return koin.getOrCreateScope(str, qualifier, obj);
    }

    public final Scope getOrCreateScope(String str, Qualifier qualifier, Object obj) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Scope scopeOrNull = this.scopeRegistry.getScopeOrNull(str);
        return scopeOrNull == null ? createScope(str, qualifier, obj) : scopeOrNull;
    }

    public final /* synthetic */ <T> Scope getOrCreateScope(String str) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Intrinsics.reifiedOperationMarker(4, "T");
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        Scope scopeOrNull = getScopeRegistry().getScopeOrNull(str);
        if (scopeOrNull != null) {
            return scopeOrNull;
        }
        return createScope$default(this, str, typeQualifier, (Object) null, 4, (Object) null);
    }

    public final Scope getScope(String str) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        Scope scopeOrNull = this.scopeRegistry.getScopeOrNull(str);
        if (scopeOrNull != null) {
            return scopeOrNull;
        }
        throw new ScopeNotCreatedException("No scope found for id '" + str + '\'');
    }

    public final Scope getScopeOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        return this.scopeRegistry.getScopeOrNull(str);
    }

    public final void deleteScope(String str) {
        Intrinsics.checkNotNullParameter(str, "scopeId");
        this.scopeRegistry.deleteScope$koin_core(str);
    }

    public final <T> T getProperty(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(t, "defaultValue");
        T property = this.propertyRegistry.getProperty(str);
        return property == null ? t : property;
    }

    public final <T> T getProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.propertyRegistry.getProperty(str);
    }

    public final void setProperty(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        this.propertyRegistry.saveProperty$koin_core(str, obj);
    }

    public final void deleteProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.propertyRegistry.deleteProperty(str);
    }

    public final void close() {
        this.scopeRegistry.close$koin_core();
        this.instanceRegistry.close$koin_core();
        this.propertyRegistry.close();
    }

    public static /* synthetic */ void loadModules$default(Koin koin, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        koin.loadModules(list, z);
    }

    public final void loadModules(List<Module> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "modules");
        Set flatten$default = ModuleKt.flatten$default(list, (Set) null, 2, (Object) null);
        this.instanceRegistry.loadModules$koin_core(flatten$default, z);
        this.scopeRegistry.loadScopes(flatten$default);
    }

    public final void unloadModules(List<Module> list) {
        Intrinsics.checkNotNullParameter(list, "modules");
        this.instanceRegistry.unloadModules$koin_core(ModuleKt.flatten$default(list, (Set) null, 2, (Object) null));
    }

    public final void createEagerInstances() {
        this.logger.info("create eager instances ...");
        if (this.logger.isAt(Level.DEBUG)) {
            double measureDuration = MeasureKt.measureDuration(new Koin$createEagerInstances$duration$1(this));
            Logger logger2 = this.logger;
            logger2.debug("eager instances created in " + measureDuration + " ms");
            return;
        }
        this.instanceRegistry.createAllEagerInstances$koin_core();
    }
}
