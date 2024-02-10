package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.rewarded.modules.BaseRewardedModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/wortise/ads/a6;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "response", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule$Listener;", "listener", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: RewardedModuleFactory.kt */
public final class a6 {
    public static final a6 a = new a6();
    private static final Sequence<KClass<com.wortise.ads.rewarded.modules.a>> b = SequencesKt.sequenceOf(Reflection.getOrCreateKotlinClass(com.wortise.ads.rewarded.modules.a.class));

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/rewarded/modules/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: RewardedModuleFactory.kt */
    static final class a extends Lambda implements Function1<KClass<com.wortise.ads.rewarded.modules.a>, Boolean> {
        final /* synthetic */ AdResponse a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AdResponse adResponse) {
            super(1);
            this.a = adResponse;
        }

        /* renamed from: a */
        public final Boolean invoke(KClass<com.wortise.ads.rewarded.modules.a> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "it");
            return Boolean.valueOf(m0.a(kClass, this.a));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/rewarded/modules/a;", "it", "Lcom/wortise/ads/rewarded/modules/BaseRewardedModule;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: RewardedModuleFactory.kt */
    static final class b extends Lambda implements Function1<KClass<com.wortise.ads.rewarded.modules.a>, BaseRewardedModule> {
        final /* synthetic */ Context a;
        final /* synthetic */ AdResponse b;
        final /* synthetic */ BaseRewardedModule.Listener c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, AdResponse adResponse, BaseRewardedModule.Listener listener) {
            super(1);
            this.a = context;
            this.b = adResponse;
            this.c = listener;
        }

        /* renamed from: a */
        public final BaseRewardedModule invoke(KClass<com.wortise.ads.rewarded.modules.a> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "it");
            return m0.a(kClass, this.a, this.b, this.c);
        }
    }

    private a6() {
    }

    public final BaseRewardedModule a(Context context, AdResponse adResponse, BaseRewardedModule.Listener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return (BaseRewardedModule) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(b, new a(adResponse)), new b(context, adResponse, listener)));
    }
}
