package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {
    /* access modifiers changed from: private */
    public final m a;
    private final Map<String, Object> b;
    private final AtomicBoolean c = new AtomicBoolean();

    public EventServiceImpl(m mVar) {
        this.a = mVar;
        if (((Boolean) mVar.a(b.bg)).booleanValue()) {
            this.b = JsonUtils.toStringObjectMap((String) mVar.b(d.t, JsonUtils.EMPTY_JSON));
            return;
        }
        this.b = CollectionUtils.map();
        mVar.a(d.t, JsonUtils.EMPTY_JSON);
    }

    /* access modifiers changed from: private */
    public String a() {
        return ((String) this.a.a(b.aX)) + "4.0/pix";
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(p pVar, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        boolean contains = this.a.b(b.be).contains(pVar.a());
        map2.put("AppLovin-Event", contains ? pVar.a() : "postinstall");
        if (!contains) {
            map2.put("AppLovin-Sub-Event", pVar.a());
        }
        return map2;
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(p pVar, boolean z) {
        boolean contains = this.a.b(b.be).contains(pVar.a());
        Map<String, Object> a2 = this.a.V().a((Map<String, String>) null, z, false);
        a2.put("event", contains ? pVar.a() : "postinstall");
        a2.put("event_id", pVar.d());
        a2.put("ts", Long.toString(pVar.c()));
        if (!contains) {
            a2.put("sub_event", pVar.a());
        }
        return Utils.stringifyObjectMap(a2);
    }

    /* access modifiers changed from: private */
    public String b() {
        return ((String) this.a.a(b.aY)) + "4.0/pix";
    }

    private void c() {
        if (((Boolean) this.a.a(b.bg)).booleanValue()) {
            this.a.a(d.t, CollectionUtils.toJsonString(this.b, JsonUtils.EMPTY_JSON));
        }
    }

    public Map<String, Object> getSuperProperties() {
        return CollectionUtils.map(this.b);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.c.compareAndSet(false, true)) {
            this.a.w().trackEvent("landing");
        }
    }

    public void setSuperProperty(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (obj == null) {
                this.b.remove(str);
            } else {
                List<String> b2 = this.a.b(b.bf);
                if (Utils.objectIsOfType(obj, b2, this.a)) {
                    this.b.put(str, Utils.sanitizeSuperProperty(obj, this.a));
                } else if (u.a()) {
                    u.i("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + b2);
                    return;
                } else {
                    return;
                }
            }
            c();
        } else if (u.a()) {
            u.i("AppLovinEventService", "Super property key cannot be null or empty");
        }
    }

    public String toString() {
        return "EventService{}";
    }

    public void trackCheckout(String str, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        map2.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, map2);
    }

    public void trackEvent(String str) {
        trackEvent(str, CollectionUtils.map());
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, (Map<String, String>) null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        if (u.a()) {
            u A = this.a.A();
            A.b("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        }
        final p pVar = new p(str, map, this.b);
        try {
            this.a.S().a((a) new z(this.a, new Runnable() {
                public void run() {
                    EventServiceImpl.this.a.U().a(h.o().c(EventServiceImpl.this.a()).d(EventServiceImpl.this.b()).a((Map<String, String>) EventServiceImpl.this.a(pVar, false)).b((Map<String, String>) EventServiceImpl.this.a(pVar, (Map<String, String>) map2)).c(pVar.b()).b(((Boolean) EventServiceImpl.this.a.a(b.eB)).booleanValue()).a(((Boolean) EventServiceImpl.this.a.a(b.es)).booleanValue()).a());
                }
            }), o.a.BACKGROUND);
        } catch (Throwable th) {
            if (u.a()) {
                u A2 = this.a.A();
                A2.b("AppLovinEventService", "Unable to track event: " + pVar, th);
            }
        }
    }

    public void trackEventSynchronously(String str) {
        if (u.a()) {
            u A = this.a.A();
            A.b("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        }
        p pVar = new p(str, CollectionUtils.map(), this.b);
        this.a.U().a(h.o().c(a()).d(b()).a(a(pVar, true)).b(a(pVar, (Map<String, String>) null)).c(pVar.b()).b(((Boolean) this.a.a(b.eB)).booleanValue()).a(((Boolean) this.a.a(b.es)).booleanValue()).a());
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        Map<String, String> map2 = CollectionUtils.map(map);
        try {
            map2.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            map2.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            if (u.a()) {
                u.c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
            }
        }
        trackEvent("iap", map2);
    }
}
