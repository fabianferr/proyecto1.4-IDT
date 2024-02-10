package com.ironsource.mediationsdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/ironsource/mediationsdk/model/BasePlacement;", "", "placementId", "", "placementName", "", "isDefault", "", "placementAvailabilitySettings", "Lcom/ironsource/mediationsdk/model/PlacementAvailabilitySettings;", "(ILjava/lang/String;ZLcom/ironsource/mediationsdk/model/PlacementAvailabilitySettings;)V", "()Z", "getPlacementAvailabilitySettings", "()Lcom/ironsource/mediationsdk/model/PlacementAvailabilitySettings;", "getPlacementId", "()I", "getPlacementName", "()Ljava/lang/String;", "isPlacementId", "id", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BasePlacement {
    private final int a;
    private final String b;
    private final boolean c;
    private final m d;

    public BasePlacement(int i, String str, boolean z, m mVar) {
        Intrinsics.checkNotNullParameter(str, "placementName");
        this.a = i;
        this.b = str;
        this.c = z;
        this.d = mVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasePlacement(int i, String str, boolean z, m mVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : mVar);
    }

    public final m getPlacementAvailabilitySettings() {
        return this.d;
    }

    public final int getPlacementId() {
        return this.a;
    }

    public final String getPlacementName() {
        return this.b;
    }

    public final boolean isDefault() {
        return this.c;
    }

    public final boolean isPlacementId(int i) {
        return this.a == i;
    }

    public String toString() {
        return "placement name: " + this.b;
    }
}
