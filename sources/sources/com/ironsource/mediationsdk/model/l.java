package com.ironsource.mediationsdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/ironsource/mediationsdk/model/OfferwallPlacement;", "Lcom/ironsource/mediationsdk/model/BasePlacement;", "placementId", "", "placementName", "", "isDefault", "", "(ILjava/lang/String;Z)V", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l extends BasePlacement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(int i, String str, boolean z) {
        super(i, str, z, (m) null);
        Intrinsics.checkNotNullParameter(str, "placementName");
    }

    public final String toString() {
        return super.toString() + ", placement id: " + getPlacementId();
    }
}
