package com.ironsource.mediationsdk.adunit.d;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.adunit.d.a.b;
import com.ironsource.mediationsdk.model.a;

public final class e extends b<com.ironsource.mediationsdk.adunit.c.b.e> implements RewardedVideoAdListener {
    public e(a aVar, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, com.ironsource.mediationsdk.adunit.c.b.e eVar) {
        super(aVar, baseAdAdapter, new a(aVar.c, aVar.c.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), eVar);
    }
}
