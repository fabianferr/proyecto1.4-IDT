package com.unity3d.services.core.di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: ServiceComponent.kt */
public final class ServiceComponentKt$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ String $named;
    final /* synthetic */ ServiceComponent $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceComponentKt$inject$1(ServiceComponent serviceComponent, String str) {
        super(0);
        this.$this_inject = serviceComponent;
        this.$named = str;
    }

    public final T invoke() {
        ServiceComponent serviceComponent = this.$this_inject;
        String str = this.$named;
        IServicesRegistry registry = serviceComponent.getServiceProvider().getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        return registry.getService(str, Reflection.getOrCreateKotlinClass(Object.class));
    }
}
