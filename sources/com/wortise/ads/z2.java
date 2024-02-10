package com.wortise.ads;

import android.content.Context;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/wortise/ads/z2;", "", "Landroid/content/Context;", "context", "Lkotlin/sequences/Sequence;", "Lcom/wortise/ads/e0;", "c", "", "a", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofenceFactory.kt */
public final class z2 {
    public static final z2 a = new z2();

    private z2() {
    }

    private final Sequence<e0> c(Context context) {
        return SequencesKt.sequenceOf(new b3(context), new a3(context));
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (e0 a2 : c(context)) {
            a2.a();
        }
    }

    public final e0 b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (e0 next : c(context)) {
            if (next.c()) {
                return next;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }
}
