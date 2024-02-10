package com.ironsource.mediationsdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/model/InterstitialPlacement;", "Lcom/ironsource/mediationsdk/model/BasePlacement;", "placementId", "", "placementName", "", "isDefault", "", "placementAvailabilitySettings", "Lcom/ironsource/mediationsdk/model/PlacementAvailabilitySettings;", "(ILjava/lang/String;ZLcom/ironsource/mediationsdk/model/PlacementAvailabilitySettings;)V", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InterstitialPlacement extends BasePlacement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterstitialPlacement(int i, String str, boolean z, m mVar) {
        super(i, str, z, mVar);
        Intrinsics.checkNotNullParameter(str, "placementName");
    }
}
