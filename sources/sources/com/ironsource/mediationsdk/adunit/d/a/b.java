package com.ironsource.mediationsdk.adunit.d.a;

import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.b.j;
import com.ironsource.mediationsdk.adunit.c.b.e;
import com.ironsource.mediationsdk.adunit.d.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.d;
import com.ironsource.mediationsdk.z;
import java.util.HashMap;

public class b<Listener extends e> extends a<Listener> implements AdapterAdRewardListener {
    private d a;

    public b(a aVar, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, com.ironsource.mediationsdk.model.a aVar2, Listener listener) {
        super(aVar, baseAdAdapter, aVar2, listener);
    }

    public void onAdClosed() {
        this.a = new d();
        super.onAdClosed();
    }

    public void onAdOpened() {
        this.a = null;
        super.onAdOpened();
    }

    public void onAdRewarded() {
        if (this.h != null) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose(b("placement name = " + x()));
            if (this.f != null) {
                HashMap hashMap = new HashMap();
                if (z.a().j != null) {
                    for (String next : z.a().j.keySet()) {
                        hashMap.put("custom_" + next, z.a().j.get(next));
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.f.f.a(x(), this.h.getRewardName(), this.h.getRewardAmount(), currentTimeMillis, IronSourceUtils.getTransId(currentTimeMillis, n()), d.a(this.a), hashMap, z.a().i);
            }
            ((e) this.d).a(this, this.h);
            return;
        }
        IronLog.INTERNAL.verbose(b("placement is null "));
        if (this.f != null) {
            j jVar = this.f.g;
            jVar.n("mCurrentPlacement is null state = " + this.g);
        }
    }
}
