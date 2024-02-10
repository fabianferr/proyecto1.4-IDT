package com.vungle.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ServiceLocator.kt */
public final class ServiceLocator$Companion$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceLocator$Companion$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final T invoke() {
        ServiceLocator instance = ServiceLocator.Companion.getInstance(this.$context);
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        return instance.getOrBuild$vungle_ads_release(cls);
    }
}
