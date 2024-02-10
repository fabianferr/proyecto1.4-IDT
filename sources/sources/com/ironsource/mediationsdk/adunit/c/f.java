package com.ironsource.mediationsdk.adunit.c;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.c.d.d;
import com.ironsource.mediationsdk.adunit.d.a;
import com.ironsource.mediationsdk.adunit.d.c;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.h;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

public final class f extends c<c, AdapterAdInteractionListener> {
    public f(List<NetworkSettings> list, h hVar, String str, com.ironsource.mediationsdk.d.c cVar, IronSourceSegment ironSourceSegment, boolean z) {
        super(new com.ironsource.mediationsdk.adunit.c.a.c(str, list, hVar), cVar, ironSourceSegment, z);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ com.ironsource.mediationsdk.adunit.d.a.c a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str) {
        return new c(new a(IronSource.AD_UNIT.INTERSTITIAL, this.l.b(), i, this.h, str, this.f, this.g, networkSettings, this.l.e()), baseAdAdapter, this);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(NetworkSettings networkSettings) {
        return networkSettings.getInterstitialSettings();
    }

    /* access modifiers changed from: protected */
    public final com.ironsource.mediationsdk.adunit.c.d.a b() {
        return new d();
    }

    /* access modifiers changed from: protected */
    public final String e() {
        return IronSourceConstants.OPW_IS_MANAGER_NAME;
    }

    /* access modifiers changed from: protected */
    public final String f() {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }
}
