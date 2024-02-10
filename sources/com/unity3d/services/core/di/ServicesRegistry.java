package com.unity3d.services.core.di;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J.\u0010\u000b\u001a\u00020\u0005\"\u0006\b\u0000\u0010\f\u0018\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\b\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\bø\u0001\u0000J \u0010\u0011\u001a\u0002H\f\"\u0006\b\u0000\u0010\f\u0018\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\b¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u0004\u0018\u0001H\f\"\u0006\b\u0000\u0010\f\u0018\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\b¢\u0006\u0002\u0010\u0012J'\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J.\u0010\u001b\u001a\u00020\u0005\"\u0006\b\u0000\u0010\f\u0018\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\b\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\bø\u0001\u0000J$\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0018\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0006H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"Lcom/unity3d/services/core/di/ServicesRegistry;", "Lcom/unity3d/services/core/di/IServicesRegistry;", "()V", "_services", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/unity3d/services/core/di/ServiceKey;", "Lkotlin/Lazy;", "services", "", "getServices", "()Ljava/util/Map;", "factory", "T", "named", "", "instance", "Lkotlin/Function0;", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "getOrNull", "getService", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "resolveService", "key", "(Lcom/unity3d/services/core/di/ServiceKey;)Ljava/lang/Object;", "resolveServiceOrNull", "single", "updateService", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServicesRegistry.kt */
public final class ServicesRegistry implements IServicesRegistry {
    private final ConcurrentHashMap<ServiceKey, Lazy<?>> _services = new ConcurrentHashMap<>();

    public Map<ServiceKey, Lazy<?>> getServices() {
        return this._services;
    }

    public static /* synthetic */ ServiceKey single$default(ServicesRegistry servicesRegistry, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, "instance");
        Intrinsics.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        servicesRegistry.updateService(serviceKey, LazyKt.lazy(function0));
        return serviceKey;
    }

    public final /* synthetic */ <T> ServiceKey single(String str, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, "instance");
        Intrinsics.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        updateService(serviceKey, LazyKt.lazy(function0));
        return serviceKey;
    }

    public static /* synthetic */ ServiceKey factory$default(ServicesRegistry servicesRegistry, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, "instance");
        Intrinsics.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        servicesRegistry.updateService(serviceKey, ServiceFactoryKt.factoryOf(function0));
        return serviceKey;
    }

    public final /* synthetic */ <T> ServiceKey factory(String str, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(function0, "instance");
        Intrinsics.reifiedOperationMarker(4, "T");
        ServiceKey serviceKey = new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class));
        updateService(serviceKey, ServiceFactoryKt.factoryOf(function0));
        return serviceKey;
    }

    public <T> void updateService(ServiceKey serviceKey, Lazy<? extends T> lazy) {
        Intrinsics.checkNotNullParameter(serviceKey, "key");
        Intrinsics.checkNotNullParameter(lazy, "instance");
        if (!getServices().containsKey(serviceKey)) {
            this._services.put(serviceKey, lazy);
            return;
        }
        throw new IllegalStateException("Cannot have multiple identical services".toString());
    }

    public static /* synthetic */ Object get$default(ServicesRegistry servicesRegistry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        return servicesRegistry.resolveService(new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class)));
    }

    public final /* synthetic */ <T> T get(String str) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        return resolveService(new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class)));
    }

    public <T> T getService(String str, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(kClass, "instance");
        return resolveService(new ServiceKey(str, kClass));
    }

    public static /* synthetic */ Object getOrNull$default(ServicesRegistry servicesRegistry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        return servicesRegistry.resolveServiceOrNull(new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class)));
    }

    public final /* synthetic */ <T> T getOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.reifiedOperationMarker(4, "T");
        return resolveServiceOrNull(new ServiceKey(str, Reflection.getOrCreateKotlinClass(Object.class)));
    }

    public <T> T resolveService(ServiceKey serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "key");
        Lazy lazy = getServices().get(serviceKey);
        if (lazy != null) {
            return lazy.getValue();
        }
        throw new IllegalStateException("No service instance found for " + serviceKey);
    }

    public <T> T resolveServiceOrNull(ServiceKey serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "key");
        Lazy lazy = getServices().get(serviceKey);
        if (lazy == null) {
            return null;
        }
        return lazy.getValue();
    }
}
