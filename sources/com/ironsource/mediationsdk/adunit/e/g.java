package com.ironsource.mediationsdk.adunit.e;

import com.ironsource.mediationsdk.adunit.d.a.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSelectorResult;", "Smash", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "", "smashPicker", "Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSmashPicker;", "(Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSmashPicker;)V", "smashesToLoad", "", "getSmashesToLoad", "()Ljava/util/List;", "noPendingSmashes", "", "noSmashesAvailable", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g<Smash extends c<?>> {
    private final h<Smash> a;

    public g(h<Smash> hVar) {
        Intrinsics.checkNotNullParameter(hVar, "smashPicker");
        this.a = hVar;
    }

    public final boolean a() {
        return this.a.b() == 0;
    }

    public final boolean b() {
        return this.a.b.isEmpty() && this.a.d.isEmpty();
    }

    public final List<Smash> c() {
        return this.a.b;
    }
}
