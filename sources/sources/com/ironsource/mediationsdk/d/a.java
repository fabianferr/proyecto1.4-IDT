package com.ironsource.mediationsdk.d;

import com.ironsource.environment.c.a;
import com.ironsource.mediationsdk.IronSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/ironsource/mediationsdk/utilities/AdUnitUtils;", "", "()V", "toGlobalDataAdUnit", "Lcom/ironsource/environment/globaldata/GlobalDataConstants$AdUnit;", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.ironsource.mediationsdk.d.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0111a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            iArr[IronSource.AD_UNIT.OFFERWALL.ordinal()] = 4;
            iArr[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 5;
            a = iArr;
        }
    }

    static {
        new a();
    }

    private a() {
    }

    @JvmStatic
    public static final a.C0105a a(IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        int i = C0111a.a[ad_unit.ordinal()];
        if (i == 1) {
            return a.C0105a.REWARDED_VIDEO;
        }
        if (i == 2) {
            return a.C0105a.INTERSTITIAL;
        }
        if (i == 3) {
            return a.C0105a.BANNER;
        }
        if (i == 4) {
            return a.C0105a.OFFERWALL;
        }
        if (i == 5) {
            return a.C0105a.NATIVE_AD;
        }
        throw new NoWhenBranchMatchedException();
    }
}
