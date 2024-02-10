package com.wortise.ads;

import android.content.Context;
import android.os.Bundle;
import com.wortise.ads.events.modules.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\b\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/events/modules/a;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Landroid/os/Bundle;", "extras", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: BaseEventHandler.kt */
public final class d0 {
    public static final a a(KClass<? extends a> kClass, Context context, AdResponse adResponse, Bundle bundle) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        try {
            return (a) JvmClassMappingKt.getJavaClass(kClass).getConstructor((Class[]) Arrays.copyOf(new Class[]{Context.class, AdResponse.class, Bundle.class}, 3)).newInstance(new Object[]{context, adResponse, bundle});
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "Caught an exception";
            }
            WortiseLog.e(message, th);
            return null;
        }
    }
}
