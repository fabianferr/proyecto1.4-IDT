package com.wortise.ads;

import android.content.Context;
import android.os.Bundle;
import com.wortise.ads.events.modules.b;
import com.wortise.ads.events.modules.c;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nJ\"\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/s2;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Landroid/os/Bundle;", "adExtras", "Lcom/wortise/ads/events/modules/a;", "a", "", "open", "b", "c", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: EventHandler.kt */
public final class s2 {
    public static final s2 a = new s2();
    private static final Sequence<KClass<? extends com.wortise.ads.events.modules.a>> b = SequencesKt.sequenceOf(Reflection.getOrCreateKotlinClass(b.class), Reflection.getOrCreateKotlinClass(c.class), Reflection.getOrCreateKotlinClass(i2.class));

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/reflect/KClass;", "Lcom/wortise/ads/events/modules/a;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: EventHandler.kt */
    static final class a extends Lambda implements Function1<KClass<? extends com.wortise.ads.events.modules.a>, com.wortise.ads.events.modules.a> {
        final /* synthetic */ Context a;
        final /* synthetic */ AdResponse b;
        final /* synthetic */ Bundle c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, AdResponse adResponse, Bundle bundle) {
            super(1);
            this.a = context;
            this.b = adResponse;
            this.c = bundle;
        }

        /* renamed from: a */
        public final com.wortise.ads.events.modules.a invoke(KClass<? extends com.wortise.ads.events.modules.a> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "it");
            return d0.a(kClass, this.a, this.b, this.c);
        }
    }

    private s2() {
    }

    private final com.wortise.ads.events.modules.a a(Context context, AdResponse adResponse, Bundle bundle) {
        R r;
        Iterator<R> it = SequencesKt.mapNotNull(b, new a(context, adResponse, bundle)).iterator();
        while (true) {
            if (!it.hasNext()) {
                r = null;
                break;
            }
            r = it.next();
            if (((com.wortise.ads.events.modules.a) r).canHandle()) {
                break;
            }
        }
        return (com.wortise.ads.events.modules.a) r;
    }

    public final boolean b(Context context, AdResponse adResponse, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        com.wortise.ads.events.modules.a a2 = a(context, adResponse, bundle);
        return a2 != null && a2.handleCompletion();
    }

    public final boolean c(Context context, AdResponse adResponse, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        com.wortise.ads.events.modules.a a2 = a(context, adResponse, bundle);
        return a2 != null && a2.handleImpression();
    }

    public final boolean a(Context context, AdResponse adResponse, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        com.wortise.ads.events.modules.a a2 = a(context, adResponse, bundle);
        return a2 != null && a2.handleClick(z);
    }

    public static /* synthetic */ boolean a(s2 s2Var, Context context, AdResponse adResponse, Bundle bundle, int i, Object obj) {
        if ((i & 4) != 0) {
            bundle = null;
        }
        return s2Var.c(context, adResponse, bundle);
    }
}
