package com.ironsource.mediationsdk.adunit.e;

import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/waterfall/BidderSensitiveSmashPicker;", "Smash", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSmashPicker;", "maxSmashesToLoad", "", "waterfall", "", "waterfallFromServer", "", "", "Lcom/ironsource/mediationsdk/AuctionResponseItem;", "isBidderReached", "", "(ILjava/util/List;Ljava/util/Map;Z)V", "pickEligibleSmash", "", "smash", "(Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;)V", "shouldStopPicking", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a<Smash extends c<?>> extends h<Smash> {
    private boolean e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private a(int i, List<? extends Smash> list, Map<String, ? extends com.ironsource.mediationsdk.adunit.a.a> map, boolean z) {
        super(i, list, map);
        Intrinsics.checkNotNullParameter(list, "waterfall");
        Intrinsics.checkNotNullParameter(map, "waterfallFromServer");
        this.e = z;
    }

    public /* synthetic */ a(int i, List list, Map map, boolean z, int i2) {
        this(i, list, map, false);
    }

    public final void a(Smash smash) {
        String str;
        Intrinsics.checkNotNullParameter(smash, "smash");
        if (!smash.k()) {
            IronLog.INTERNAL.verbose(smash.r().name() + " - Smash " + smash.n() + " (non-bidder) is ready to load");
            this.b.add(smash);
            return;
        }
        this.e = true;
        if (b() == 0) {
            str = "Advanced Loading: Starting to load bidder " + smash.n() + ". No other instances will be loaded at the same time.";
            this.b.add(smash);
        } else {
            str = "Advanced Loading: Won't start loading bidder " + smash.n() + " as a non bidder is being loaded";
        }
        IronLog.INTERNAL.verbose(smash.r().name() + " - " + str);
        IronSourceUtils.sendAutomationLog(str);
    }

    public final boolean a() {
        return super.a() || this.e;
    }
}
