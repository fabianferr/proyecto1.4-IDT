package com.unity3d.services.core.di;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0006\u001a3\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\b¨\u0006\u000b"}, d2 = {"get", "T", "", "Lcom/unity3d/services/core/di/ServiceComponent;", "named", "", "(Lcom/unity3d/services/core/di/ServiceComponent;Ljava/lang/String;)Ljava/lang/Object;", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceComponent.kt */
public final class ServiceComponentKt {
    public static /* synthetic */ Object get$default(ServiceComponent serviceComponent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkNotNullParameter(serviceComponent, "<this>");
        Intrinsics.checkNotNullParameter(str, "named");
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        return registry.getService(str, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final /* synthetic */ <T> T get(ServiceComponent serviceComponent, String str) {
        Intrinsics.checkNotNullParameter(serviceComponent, "<this>");
        Intrinsics.checkNotNullParameter(str, "named");
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        return registry.getService(str, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Lazy inject$default(ServiceComponent serviceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        }
        Intrinsics.checkNotNullParameter(serviceComponent, "<this>");
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new ServiceComponentKt$inject$1(serviceComponent, str));
    }

    public static final /* synthetic */ <T> Lazy<T> inject(ServiceComponent serviceComponent, String str, LazyThreadSafetyMode lazyThreadSafetyMode) {
        Intrinsics.checkNotNullParameter(serviceComponent, "<this>");
        Intrinsics.checkNotNullParameter(str, "named");
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new ServiceComponentKt$inject$1(serviceComponent, str));
    }
}
