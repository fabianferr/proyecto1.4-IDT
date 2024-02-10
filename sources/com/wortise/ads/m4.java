package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.interstitial.modules.BaseInterstitialModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/wortise/ads/m4;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "response", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule$Listener;", "listener", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: InterstitialModuleFactory.kt */
public final class m4 {
    public static final m4 a = new m4();
    private static final Sequence<KClass<? extends BaseInterstitialModule>> b = SequencesKt.sequenceOf(Reflection.getOrCreateKotlinClass(com.wortise.ads.interstitial.modules.a.class), Reflection.getOrCreateKotlinClass(com.wortise.ads.interstitial.modules.b.class));

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: InterstitialModuleFactory.kt */
    static final class a extends Lambda implements Function1<KClass<? extends BaseInterstitialModule>, Boolean> {
        final /* synthetic */ AdResponse a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AdResponse adResponse) {
            super(1);
            this.a = adResponse;
        }

        /* renamed from: a */
        public final Boolean invoke(KClass<? extends BaseInterstitialModule> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "it");
            return Boolean.valueOf(g0.a(kClass, this.a));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: InterstitialModuleFactory.kt */
    static final class b extends Lambda implements Function1<KClass<? extends BaseInterstitialModule>, BaseInterstitialModule> {
        final /* synthetic */ Context a;
        final /* synthetic */ AdResponse b;
        final /* synthetic */ BaseInterstitialModule.Listener c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, AdResponse adResponse, BaseInterstitialModule.Listener listener) {
            super(1);
            this.a = context;
            this.b = adResponse;
            this.c = listener;
        }

        /* renamed from: a */
        public final BaseInterstitialModule invoke(KClass<? extends BaseInterstitialModule> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "it");
            return g0.a(kClass, this.a, this.b, this.c);
        }
    }

    private m4() {
    }

    public final BaseInterstitialModule a(Context context, AdResponse adResponse, BaseInterstitialModule.Listener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return (BaseInterstitialModule) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(b, new a(adResponse)), new b(context, adResponse, listener)));
    }
}
