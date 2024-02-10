package com.wortise.ads;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.renderers.modules.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a4\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/renderers/modules/a;", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "Landroid/view/View;", "adView", "Lcom/wortise/ads/renderers/modules/a$a;", "listener", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: BaseAdRenderer.kt */
public final class c0 {
    public static final boolean a(KClass<? extends a<?>> kClass, AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        try {
            Object invoke = JvmClassMappingKt.getJavaClass(kClass).getDeclaredMethod("canRender", new Class[]{AdResponse.class}).invoke((Object) null, new Object[]{adResponse});
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final a<?> a(KClass<? extends a<?>> kClass, View view, AdResponse adResponse, a.C0192a aVar) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        try {
            return (a) JvmClassMappingKt.getJavaClass(kClass).getConstructor((Class[]) Arrays.copyOf(new Class[]{View.class, AdResponse.class, a.C0192a.class}, 3)).newInstance(new Object[]{view, adResponse, aVar});
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
