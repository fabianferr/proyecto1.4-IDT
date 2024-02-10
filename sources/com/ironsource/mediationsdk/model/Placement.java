package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u000f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0002\u0010\u000eJ\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/ironsource/mediationsdk/model/Placement;", "Lcom/ironsource/mediationsdk/model/BasePlacement;", "placementId", "", "placementName", "", "isDefault", "", "rewardName", "rewardAmount", "placementAvailabilitySettings", "Lcom/ironsource/mediationsdk/model/PlacementAvailabilitySettings;", "(ILjava/lang/String;ZLjava/lang/String;ILcom/ironsource/mediationsdk/model/PlacementAvailabilitySettings;)V", "placement", "(Lcom/ironsource/mediationsdk/model/BasePlacement;)V", "<set-?>", "getRewardAmount", "()I", "getRewardName", "()Ljava/lang/String;", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Placement extends BasePlacement {
    private String a;
    private int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Placement(int i, String str, boolean z, String str2, int i2, m mVar) {
        super(i, str, z, mVar);
        Intrinsics.checkNotNullParameter(str, "placementName");
        Intrinsics.checkNotNullParameter(str2, IronSourceConstants.EVENTS_REWARD_NAME);
        this.b = i2;
        this.a = str2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Placement(BasePlacement basePlacement) {
        super(basePlacement.getPlacementId(), basePlacement.getPlacementName(), basePlacement.isDefault(), basePlacement.getPlacementAvailabilitySettings());
        Intrinsics.checkNotNullParameter(basePlacement, "placement");
        this.a = "";
    }

    public final int getRewardAmount() {
        return this.b;
    }

    public final String getRewardName() {
        return this.a;
    }

    public final String toString() {
        return super.toString() + ", reward name: " + this.a + " , amount: " + this.b;
    }
}
