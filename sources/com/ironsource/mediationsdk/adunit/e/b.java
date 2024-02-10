package com.ironsource.mediationsdk.adunit.e;

import com.ironsource.mediationsdk.adunit.a.a;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/waterfall/DefaultSmashPicker;", "Smash", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSmashPicker;", "maxSmashesToLoad", "", "waterfall", "", "waterfallFromServer", "", "", "Lcom/ironsource/mediationsdk/AuctionResponseItem;", "(ILjava/util/List;Ljava/util/Map;)V", "pickEligibleSmash", "", "smash", "(Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;)V", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b<Smash extends c<?>> extends h<Smash> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i, List<? extends Smash> list, Map<String, ? extends a> map) {
        super(i, list, map);
        Intrinsics.checkNotNullParameter(list, "waterfall");
        Intrinsics.checkNotNullParameter(map, "waterfallFromServer");
    }

    public final void a(Smash smash) {
        Intrinsics.checkNotNullParameter(smash, "smash");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(smash.r().name() + " - Smash " + smash.o() + " is ready to load");
        this.b.add(smash);
    }
}
