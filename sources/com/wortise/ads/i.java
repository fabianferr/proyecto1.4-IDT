package com.wortise.ads;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.renderers.modules.a;
import com.wortise.ads.renderers.modules.c;
import com.wortise.ads.renderers.modules.d;
import com.wortise.ads.renderers.modules.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/wortise/ads/i;", "", "Landroid/view/View;", "adView", "Lcom/wortise/ads/AdResponse;", "response", "Lcom/wortise/ads/renderers/modules/a$a;", "listener", "Lcom/wortise/ads/renderers/modules/a;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdRendererFactory.kt */
public final class i {
    public static final i a = new i();
    private static final Sequence<KClass<? extends com.wortise.ads.renderers.modules.a<? extends View>>> b = SequencesKt.sequenceOf(Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(d.class), Reflection.getOrCreateKotlinClass(com.wortise.ads.renderers.modules.b.class), Reflection.getOrCreateKotlinClass(e.class));

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/renderers/modules/a;", "Landroid/view/View;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdRendererFactory.kt */
    static final class a extends Lambda implements Function1<KClass<? extends com.wortise.ads.renderers.modules.a<? extends View>>, Boolean> {
        final /* synthetic */ AdResponse a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AdResponse adResponse) {
            super(1);
            this.a = adResponse;
        }

        /* renamed from: a */
        public final Boolean invoke(KClass<? extends com.wortise.ads.renderers.modules.a<? extends View>> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "it");
            return Boolean.valueOf(c0.a(kClass, this.a));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0016\u0010\u0003\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/renderers/modules/a;", "Landroid/view/View;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdRendererFactory.kt */
    static final class b extends Lambda implements Function1<KClass<? extends com.wortise.ads.renderers.modules.a<? extends View>>, com.wortise.ads.renderers.modules.a<?>> {
        final /* synthetic */ View a;
        final /* synthetic */ AdResponse b;
        final /* synthetic */ a.C0192a c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(View view, AdResponse adResponse, a.C0192a aVar) {
            super(1);
            this.a = view;
            this.b = adResponse;
            this.c = aVar;
        }

        /* renamed from: a */
        public final com.wortise.ads.renderers.modules.a<?> invoke(KClass<? extends com.wortise.ads.renderers.modules.a<? extends View>> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "it");
            return c0.a(kClass, this.a, this.b, this.c);
        }
    }

    private i() {
    }

    public final com.wortise.ads.renderers.modules.a<?> a(View view, AdResponse adResponse, a.C0192a aVar) {
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return (com.wortise.ads.renderers.modules.a) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(b, new a(adResponse)), new b(view, adResponse, aVar)));
    }
}
