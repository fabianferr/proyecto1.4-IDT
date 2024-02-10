package com.ironsource.mediationsdk.adunit.d;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.adunit.c.b.b;
import com.ironsource.mediationsdk.adunit.d.a.a;

public final class c extends a<b> implements InterstitialAdListener {
    public c(a aVar, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, b bVar) {
        super(aVar, baseAdAdapter, new com.ironsource.mediationsdk.model.a(aVar.c, aVar.c.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), bVar);
    }
}
