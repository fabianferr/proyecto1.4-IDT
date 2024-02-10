package com.mbridge.msdk.dycreator.f;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: MBRewardData */
public final class a implements com.mbridge.msdk.dycreator.f.a.a {
    private DyOption a;
    private CampaignEx b;

    public a(DyOption dyOption) {
        this.a = dyOption;
        this.b = dyOption.getCampaignEx();
    }

    public final CampaignEx getBindData() {
        return this.b;
    }

    public final DyOption getEffectData() {
        return this.a;
    }
}
