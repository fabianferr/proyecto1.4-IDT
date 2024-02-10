package com.vungle.ads.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleInitializer.kt */
final class VungleInitializer$downloadJs$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $downloadListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VungleInitializer$downloadJs$1(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$downloadListener = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i == 11) {
            this.$downloadListener.invoke(false);
        } else {
            this.$downloadListener.invoke(true);
        }
    }
}
