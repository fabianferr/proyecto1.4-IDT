package com.wortise.ads;

import android.content.Context;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/wortise/ads/u5;", "", "Landroid/content/Context;", "context", "Lkotlin/sequences/Sequence;", "Lcom/wortise/ads/k0;", "a", "Lcom/wortise/ads/AdResponse;", "response", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PushModuleFactory.kt */
public final class u5 {
    public static final u5 a = new u5();

    private u5() {
    }

    private final Sequence<k0> a(Context context) {
        return SequencesKt.sequenceOf(new c3(context), new j2(context));
    }

    public final k0 b(Context context, AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        for (k0 next : a(context)) {
            if (next.b(adResponse)) {
                return next;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final k0 a(Context context, AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "response");
        k0 b = b(context, adResponse);
        b.a(adResponse);
        return b;
    }
}
