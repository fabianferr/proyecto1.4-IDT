package com.ironsource.mediationsdk.bidding;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.d;
import com.ironsource.mediationsdk.utils.j;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

public final class a implements Callable<j> {
    final int a;
    final String b;
    private final AdData c;
    private final c d;
    private final b e;
    private final NetworkSettings f;

    public a(int i, String str, AdData adData, c cVar, b bVar, NetworkSettings networkSettings) {
        this.a = i;
        this.b = str;
        this.c = adData;
        this.d = cVar;
        this.e = bVar;
        this.f = networkSettings;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public j call() {
        final d dVar = new d();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(this.b + " fetching bidding data");
        final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        try {
            this.d.a(this.c, new BiddingDataCallback() {
                public final void onFailure(String str) {
                    arrayBlockingQueue.add(new j(a.this.a, a.this.b, (Map<String, Object>) null, d.a(dVar), str));
                }

                public final void onSuccess(Map<String, Object> map) {
                    arrayBlockingQueue.add(new j(a.this.a, a.this.b, map, d.a(dVar), (String) null));
                }
            });
        } catch (Exception e2) {
            IronLog.INTERNAL.error(e2.getMessage());
            e2.printStackTrace();
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.b(this.f);
        }
        return (j) arrayBlockingQueue.take();
    }
}
