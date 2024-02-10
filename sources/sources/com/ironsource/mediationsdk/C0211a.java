package com.ironsource.mediationsdk;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.d.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.a  reason: case insensitive filesystem */
public abstract class C0211a<Listener extends AdapterAdListener> extends BaseAdAdapter<G, Listener> implements AdapterAdFullScreenInterface<Listener>, AdapterBannerInterface<Listener>, AdapterNativeAdInterface<Listener> {
    protected AbstractAdapter a;
    protected WeakReference<Listener> b = new WeakReference<>((Object) null);

    public C0211a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        super(ad_unit, networkSettings);
        this.a = abstractAdapter;
    }

    public static C0211a<?> a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return new Q(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return new x(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return new C0223m(abstractAdapter, networkSettings);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return new F(abstractAdapter, networkSettings);
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("ad unit not supported - " + ad_unit);
        return null;
    }

    private void a(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        a(c.a(adData.getConfiguration()), c.a(adData.getAdUnitData()), adData);
    }

    private void b(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error(a("Method '" + str + "' is not supported for " + getClass().getName()));
    }

    /* access modifiers changed from: protected */
    public abstract IronSource.AD_UNIT a();

    /* access modifiers changed from: protected */
    public final String a(String str) {
        String ad_unit = a().toString();
        if (TextUtils.isEmpty(str)) {
            return ad_unit;
        }
        return ad_unit + " - " + str;
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        b("showAd");
    }

    /* access modifiers changed from: protected */
    public abstract void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData);

    /* access modifiers changed from: protected */
    public final String b() {
        return a((String) null);
    }

    /* access modifiers changed from: protected */
    public boolean b(JSONObject jSONObject) {
        b("isAdAvailable");
        return false;
    }

    /* access modifiers changed from: protected */
    public void c(JSONObject jSONObject) {
        b("destroyAd");
    }

    public void destroyAd(AdData adData) {
        c(c.a(adData.getConfiguration()));
    }

    public boolean isAdAvailable(AdData adData) {
        return b(c.a(adData.getConfiguration()));
    }

    public void loadAd(AdData adData, Activity activity, ISBannerSize iSBannerSize, Listener listener) {
        a(adData, listener);
    }

    public void loadAd(AdData adData, Activity activity, Listener listener) {
        a(adData, listener);
    }

    public void releaseMemory() {
        IronLog.INTERNAL.verbose(a((String) null));
        AbstractAdapter abstractAdapter = this.a;
        if (abstractAdapter != null) {
            abstractAdapter.releaseMemory(a(), new JSONObject());
            this.a = null;
        }
    }

    public void showAd(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        a(c.a(adData.getConfiguration()));
    }
}
