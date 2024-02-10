package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.rewarded.modules.BaseRewardedModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a,\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule;", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "Landroid/content/Context;", "context", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;", "listener", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: BaseRewardedModule.kt */
public final class m0 {
    public static final boolean a(KClass<? extends BaseRewardedModule> kClass, AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        try {
            Object invoke = JvmClassMappingKt.getJavaClass(kClass).getDeclaredMethod("canParse", new Class[]{AdResponse.class}).invoke((Object) null, new Object[]{adResponse});
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final BaseRewardedModule a(KClass<? extends BaseRewardedModule> kClass, Context context, AdResponse adResponse, BaseRewardedModule.Listener listener) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        try {
            return (BaseRewardedModule) JvmClassMappingKt.getJavaClass(kClass).getConstructor((Class[]) Arrays.copyOf(new Class[]{Context.class, AdResponse.class, BaseRewardedModule.Listener.class}, 3)).newInstance(new Object[]{context, adResponse, listener});
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
