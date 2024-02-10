package com.ironsource.mediationsdk.testSuite;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/TestSuiteLoadAdConfig;", "", "adNetworkName", "", "isBiddingNetwork", "", "useTestAds", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", "mAdNetworkName", "mIsBiddingNetwork", "mUseTestAds", "Ljava/lang/Boolean;", "shouldAddProviderInfo", "networkSettings", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {
    private final String a;
    private final boolean b;
    private final Boolean c;

    public c(String str, boolean z, Boolean bool) {
        this.a = str;
        this.b = z;
        this.c = bool;
    }

    public final boolean a() {
        return Intrinsics.areEqual((Object) this.c, (Object) Boolean.TRUE);
    }

    public final boolean a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        CharSequence charSequence = this.a;
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        d dVar = d.a;
        if (Intrinsics.areEqual((Object) d.a(networkSettings), (Object) this.a)) {
            d dVar2 = d.a;
            if (d.a(networkSettings, ad_unit) == this.b) {
                return true;
            }
        }
        return false;
    }
}
