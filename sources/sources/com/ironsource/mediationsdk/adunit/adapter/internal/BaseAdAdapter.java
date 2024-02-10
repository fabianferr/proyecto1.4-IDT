package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.C0213c;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.model.NetworkSettings;

public abstract class BaseAdAdapter<NetworkAdapter extends AdapterBaseInterface, Listener> {
    private final IronSource.AD_UNIT mAdUnit;
    protected final NetworkSettings mNetworkSettings;

    public BaseAdAdapter(IronSource.AD_UNIT ad_unit, NetworkSettings networkSettings) {
        this.mAdUnit = ad_unit;
        this.mNetworkSettings = networkSettings;
    }

    public NetworkAdapter getNetworkAdapter() {
        NetworkAdapter a = C0213c.a().a(this.mNetworkSettings, this.mAdUnit);
        if (a != null) {
            return a;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public NetworkSettings getNetworkSettings() {
        return this.mNetworkSettings;
    }

    public void releaseMemory() {
    }
}
