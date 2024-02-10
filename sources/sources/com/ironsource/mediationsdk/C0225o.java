package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.a;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.o  reason: case insensitive filesystem */
public abstract class C0225o {
    protected a a = new a();
    protected IronSourceSegment b;
    protected AdInfo c;
    private HashSet<ImpressionDataListener> d;

    public C0225o(HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        new HashSet();
        this.d = hashSet;
        this.b = ironSourceSegment;
    }

    protected static String c() {
        return "fallback_" + System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public final void a(IronSource.AD_UNIT ad_unit) {
        this.a.a(ad_unit, false);
    }

    public final void a(IronSourceSegment ironSourceSegment) {
        this.b = ironSourceSegment;
    }

    /* access modifiers changed from: protected */
    public final void a(com.ironsource.mediationsdk.adunit.a.a aVar, String str) {
        if (aVar != null) {
            ImpressionData a2 = aVar.a(str);
            if (a2 != null) {
                Iterator<ImpressionDataListener> it = this.d.iterator();
                while (it.hasNext()) {
                    ImpressionDataListener next = it.next();
                    IronLog ironLog = IronLog.CALLBACK;
                    ironLog.info("onImpressionSuccess " + next.getClass().getSimpleName() + ": " + a2);
                    next.onImpressionSuccess(a2);
                }
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
    }

    public final void a(ImpressionData impressionData) {
        if (impressionData != null) {
            this.c = new AdInfo(impressionData);
        }
    }

    public final void a(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.d.add(impressionDataListener);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        boolean z = false;
        if (jSONObject != null) {
            z = jSONObject.optBoolean("isAdUnitCapped", false);
        }
        this.a.a(ad_unit, z);
    }

    public final void a_() {
        this.c = null;
    }

    public final void b(ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.d.remove(impressionDataListener);
        }
    }
}
