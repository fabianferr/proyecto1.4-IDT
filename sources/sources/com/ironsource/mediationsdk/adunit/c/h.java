package com.ironsource.mediationsdk.adunit.c;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.c.c.a;
import com.ironsource.mediationsdk.adunit.c.d.f;
import com.ironsource.mediationsdk.adunit.d.a;
import com.ironsource.mediationsdk.adunit.d.e;
import com.ironsource.mediationsdk.d.c;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.q;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

public final class h extends e<e> {
    public h(List<NetworkSettings> list, q qVar, String str, boolean z, c cVar, IronSourceSegment ironSourceSegment, boolean z2) {
        super(new com.ironsource.mediationsdk.adunit.c.a.e(str, list, qVar, z), cVar, ironSourceSegment, z2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ com.ironsource.mediationsdk.adunit.d.a.c a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str) {
        return new e(new a(IronSource.AD_UNIT.REWARDED_VIDEO, this.l.b(), i, this.h, str, this.f, this.g, networkSettings, this.l.e()), baseAdAdapter, this);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(NetworkSettings networkSettings) {
        return networkSettings.getRewardedVideoSettings();
    }

    /* access modifiers changed from: protected */
    public final com.ironsource.mediationsdk.adunit.c.d.a b() {
        return new f();
    }

    /* access modifiers changed from: protected */
    public final String e() {
        return IronSourceConstants.OPW_RV_MANAGER_NAME;
    }

    /* access modifiers changed from: protected */
    public final String f() {
        return IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    /* access modifiers changed from: protected */
    public final boolean p() {
        return this.l.h().a == a.C0109a.MANUAL;
    }
}
