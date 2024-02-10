package com.ironsource.mediationsdk.adunit.b;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;

public final class j extends f {
    public j(d dVar) {
        super(dVar);
    }

    public final void a(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_LOAD_FAILED, hashMap);
    }

    public final void a(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        hashMap.put(IronSourceConstants.EVENTS_EXT1, str2);
        a(b.TROUBLESHOOT_NOTIFICATION_ERROR, hashMap);
    }

    public final void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, hashMap);
    }

    public final void a(Map<String, Object> map, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        a(b.TROUBLESHOOT_BIDDING_DATA_MISSING, hashMap);
    }

    public final void b(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, hashMap);
    }

    public final void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, hashMap);
    }

    public final void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, hashMap);
    }

    public final void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, hashMap);
    }

    public final void e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, hashMap);
    }

    public final void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, hashMap);
    }

    public final void g(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, hashMap);
    }

    public final void h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, hashMap);
    }

    public final void i(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, hashMap);
    }

    public final void j(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, hashMap);
    }

    public final void k(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_CLOSED, hashMap);
    }

    public final void l(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_TIMEOUT, hashMap);
    }

    public final void m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_UNEXPECTED_OPENED, hashMap);
    }

    public final void n(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_INTERNAL_ERROR, hashMap);
    }

    public final void o(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOTING_WATERFALL_OVERHEAD, hashMap);
    }

    public final void p(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOT_AD_EXPIRED, hashMap);
    }

    public final void q(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        a(b.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, hashMap);
    }
}
