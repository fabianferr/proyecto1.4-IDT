package com.unity3d.services.core.di;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005"}, d2 = {"factoryOf", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceFactory.kt */
public final class ServiceFactoryKt {
    public static final <T> Lazy<T> factoryOf(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new Factory<>(function0);
    }
}
