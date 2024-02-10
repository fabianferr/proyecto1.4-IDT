package com.ironsource.mediationsdk.adunit.b;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.e;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d {
    public c a;
    public g b;
    public h c;
    public i d;
    public e e;
    public a f;
    public j g;
    private final int h = -1;
    private final IronSource.AD_UNIT i;
    private final b j;
    private com.ironsource.mediationsdk.events.b k;
    private Map<b, a> l;
    private Map<b, a> m;
    private Map<b, a> n;
    private Map<b, a> o;

    static class a {
        private final int a;
        private final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* access modifiers changed from: package-private */
        public final int a(b bVar) {
            return b.MEDIATION.equals(bVar) ? this.a : this.b;
        }
    }

    public enum b {
        MEDIATION,
        PROVIDER
    }

    public d(IronSource.AD_UNIT ad_unit, b bVar, c cVar) {
        this.i = ad_unit;
        this.j = bVar;
        this.a = cVar;
        this.k = (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) || ad_unit.equals(IronSource.AD_UNIT.OFFERWALL)) ? i.d() : e.d();
        HashMap hashMap = new HashMap();
        this.l = hashMap;
        hashMap.put(b.INIT_STARTED, new a(IronSourceConstants.IS_MANAGER_INIT_STARTED, -1));
        this.l.put(b.INIT_ENDED, new a(IronSourceConstants.IS_MANAGER_INIT_ENDED, -1));
        this.l.put(b.SESSION_CAPPED, new a(-1, IronSourceConstants.IS_CAP_SESSION));
        this.l.put(b.PLACEMENT_CAPPED, new a(IronSourceConstants.IS_CAP_PLACEMENT, -1));
        this.l.put(b.AUCTION_REQUEST, new a(2000, -1));
        this.l.put(b.AUCTION_SUCCESS, new a(IronSourceConstants.IS_AUCTION_SUCCESS, -1));
        this.l.put(b.AUCTION_FAILED, new a(IronSourceConstants.IS_AUCTION_FAILED, -1));
        this.l.put(b.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, -1));
        this.l.put(b.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.IS_RESULT_WATERFALL, -1));
        this.l.put(b.INIT_SUCCESS, new a(-1, -1));
        this.l.put(b.INIT_FAILED, new a(-1, -1));
        this.l.put(b.SHOW_AD_SUCCESS, new a(-1, 2202));
        this.l.put(b.AD_OPENED, new a(-1, 2005));
        this.l.put(b.AD_CLOSED, new a(-1, IronSourceConstants.IS_INSTANCE_CLOSED));
        this.l.put(b.AD_CLICKED, new a(-1, 2006));
        this.l.put(b.LOAD_AD, new a(2001, 2002));
        this.l.put(b.LOAD_AD_SUCCESS, new a(2004, 2003));
        this.l.put(b.LOAD_AD_FAILED_WITH_REASON, new a(2110, 2200));
        this.l.put(b.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL));
        this.l.put(b.SHOW_AD, new a(2100, 2201));
        this.l.put(b.SHOW_AD_FAILED, new a(2111, IronSourceConstants.IS_INSTANCE_SHOW_FAILED));
        this.l.put(b.AD_UNIT_CAPPED, new a(IronSourceConstants.IS_AD_UNIT_CAPPED, -1));
        this.l.put(b.COLLECT_TOKEN, new a(IronSourceConstants.IS_COLLECT_TOKENS, -1));
        this.l.put(b.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.IS_COLLECT_TOKENS_COMPLETED, -1));
        this.l.put(b.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.IS_COLLECT_TOKENS_FAILED, -1));
        this.l.put(b.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN, -1));
        this.l.put(b.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_SUCCESS, -1));
        this.l.put(b.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_FAILED, -1));
        this.l.put(b.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT, -1));
        this.l.put(b.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING));
        this.l.put(b.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_SHOW_FAILED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_CLOSED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT));
        this.l.put(b.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR));
        this.l.put(b.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.l.put(b.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR));
        this.l.put(b.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, -1));
        HashMap hashMap2 = new HashMap();
        this.m = hashMap2;
        hashMap2.put(b.INIT_STARTED, new a(IronSourceConstants.RV_MANAGER_INIT_STARTED, -1));
        this.m.put(b.INIT_ENDED, new a(IronSourceConstants.RV_MANAGER_INIT_ENDED, -1));
        this.m.put(b.SESSION_CAPPED, new a(-1, IronSourceConstants.RV_CAP_SESSION));
        this.m.put(b.PLACEMENT_CAPPED, new a(IronSourceConstants.RV_CAP_PLACEMENT, -1));
        this.m.put(b.AUCTION_REQUEST, new a(IronSourceConstants.RV_AUCTION_REQUEST, -1));
        this.m.put(b.AUCTION_SUCCESS, new a(IronSourceConstants.RV_AUCTION_SUCCESS, -1));
        this.m.put(b.AUCTION_FAILED, new a(IronSourceConstants.RV_AUCTION_FAILED, -1));
        this.m.put(b.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, -1));
        this.m.put(b.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, -1));
        this.m.put(b.INIT_SUCCESS, new a(-1, -1));
        this.m.put(b.INIT_FAILED, new a(-1, -1));
        this.m.put(b.AD_VISIBLE, new a(-1, IronSourceConstants.RV_INSTANCE_VISIBLE));
        this.m.put(b.AD_OPENED, new a(-1, 1005));
        this.m.put(b.AD_CLOSED, new a(-1, IronSourceConstants.RV_INSTANCE_CLOSED));
        this.m.put(b.AD_STARTED, new a(-1, IronSourceConstants.RV_INSTANCE_STARTED));
        this.m.put(b.AD_ENDED, new a(-1, IronSourceConstants.RV_INSTANCE_ENDED));
        this.m.put(b.AD_CLICKED, new a(-1, 1006));
        this.m.put(b.AD_REWARDED, new a(-1, 1010));
        this.m.put(b.AD_AVAILABILITY_CHANGED_TRUE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE));
        this.m.put(b.AD_AVAILABILITY_CHANGED_FALSE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE));
        this.m.put(b.LOAD_AD, new a(1000, 1001));
        this.m.put(b.LOAD_AD_SUCCESS, new a(1003, 1002));
        this.m.put(b.LOAD_AD_FAILED, new a(-1, IronSourceConstants.RV_INSTANCE_LOAD_FAILED));
        this.m.put(b.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.RV_MEDIATION_LOAD_ERROR, IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.m.put(b.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL));
        this.m.put(b.SHOW_AD, new a(IronSourceConstants.RV_API_SHOW_CALLED, IronSourceConstants.RV_INSTANCE_SHOW));
        this.m.put(b.SHOW_AD_CHANCE, new a(-1, IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.m.put(b.SHOW_AD_FAILED, new a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, IronSourceConstants.RV_INSTANCE_SHOW_FAILED));
        this.m.put(b.AD_UNIT_CAPPED, new a(IronSourceConstants.RV_AD_UNIT_CAPPED, -1));
        this.m.put(b.COLLECT_TOKEN, new a(IronSourceConstants.RV_COLLECT_TOKENS, -1));
        this.m.put(b.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, -1));
        this.m.put(b.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.RV_COLLECT_TOKENS_FAILED, -1));
        this.m.put(b.INSTANCE_COLLECT_TOKEN, new a(1020, -1));
        this.m.put(b.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(1021, 1021));
        this.m.put(b.INSTANCE_COLLECT_TOKEN_FAILED, new a(1022, 1022));
        this.m.put(b.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(1023, 1023));
        this.m.put(b.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING));
        this.m.put(b.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_SHOW_FAILED));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT));
        this.m.put(b.TROUBLESHOOT_UNEXPECTED_CLOSED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_CLOSED));
        this.m.put(b.TROUBLESHOOT_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED));
        this.m.put(b.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR));
        this.m.put(b.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.m.put(b.TROUBLESHOOTING_WATERFALL_OVERHEAD, new a(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD));
        this.m.put(b.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, -1));
        this.m.put(b.TROUBLESHOOT_AD_EXPIRED, new a(IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED, IronSourceConstants.TROUBLESHOOTING_RV_AD_EXPIRED));
        HashMap hashMap3 = new HashMap();
        this.n = hashMap3;
        hashMap3.put(b.INIT_STARTED, new a(IronSourceConstants.BN_MANAGER_INIT_STARTED, -1));
        this.n.put(b.INIT_ENDED, new a(IronSourceConstants.BN_MANAGER_INIT_ENDED, -1));
        this.n.put(b.PLACEMENT_CAPPED, new a(IronSourceConstants.BN_PLACEMENT_CAPPED, -1));
        this.n.put(b.AUCTION_REQUEST, new a(IronSourceConstants.BN_AUCTION_REQUEST, -1));
        this.n.put(b.AUCTION_SUCCESS, new a(IronSourceConstants.BN_AUCTION_SUCCESS, -1));
        this.n.put(b.AUCTION_FAILED, new a(IronSourceConstants.BN_AUCTION_FAILED, -1));
        this.n.put(b.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, -1));
        this.n.put(b.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, -1));
        this.n.put(b.INIT_SUCCESS, new a(-1, -1));
        this.n.put(b.INIT_FAILED, new a(-1, -1));
        this.n.put(b.AD_OPENED, new a(IronSourceConstants.BN_CALLBACK_SHOW, IronSourceConstants.BN_INSTANCE_SHOW));
        this.n.put(b.AD_CLICKED, new a(IronSourceConstants.BN_CALLBACK_CLICK, IronSourceConstants.BN_INSTANCE_CLICK));
        this.n.put(b.LOAD_AD, new a(3001, 3002));
        this.n.put(b.RELOAD_AD, new a(IronSourceConstants.BN_RELOAD, IronSourceConstants.BN_INSTANCE_RELOAD));
        this.n.put(b.LOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, 3005));
        this.n.put(b.RELOAD_AD_SUCCESS, new a(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.n.put(b.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, IronSourceConstants.BN_INSTANCE_LOAD_ERROR));
        this.n.put(b.RELOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.BN_CALLBACK_RELOAD_ERROR, IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.n.put(b.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL));
        this.n.put(b.RELOAD_AD_NO_FILL, new a(-1, IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL));
        this.n.put(b.AD_UNIT_CAPPED, new a(IronSourceConstants.BN_AD_UNIT_CAPPED, -1));
        this.n.put(b.COLLECT_TOKEN, new a(IronSourceConstants.BN_COLLECT_TOKENS, -1));
        this.n.put(b.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, -1));
        this.n.put(b.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.BN_COLLECT_TOKENS_FAILED, -1));
        this.n.put(b.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN, -1));
        this.n.put(b.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.n.put(b.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED));
        this.n.put(b.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.n.put(b.DESTROY_AD, new a(IronSourceConstants.BN_DESTROY, IronSourceConstants.BN_INSTANCE_DESTROY));
        this.n.put(b.SKIP_RELOAD_AD, new a(IronSourceConstants.BN_SKIP_RELOAD, -1));
        this.n.put(b.AD_LEFT_APPLICATION, new a(IronSourceConstants.BN_CALLBACK_LEAVE_APP, IronSourceConstants.BN_INSTANCE_LEAVE_APP));
        this.n.put(b.AD_PRESENT_SCREEN, new a(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN));
        this.n.put(b.AD_DISMISS_SCREEN, new a(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN));
        this.n.put(b.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_BN_PROVIDER_SETTINGS_MISSING));
        this.n.put(b.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_SUCCESS));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_INIT_FAILED));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_SUCCESS));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_AUCTION_FAILED));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_SUCCESS));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_LOAD_FAILED));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_SUCCESS));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_RELOAD_FAILED));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_TIMEOUT));
        this.n.put(b.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_BN_UNEXPECTED_OPENED));
        this.n.put(b.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR));
        this.n.put(b.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.n.put(b.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR));
        this.n.put(b.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, -1));
        HashMap hashMap4 = new HashMap();
        this.o = hashMap4;
        hashMap4.put(b.INIT_STARTED, new a(IronSourceConstants.NT_MANAGER_INIT_STARTED, -1));
        this.o.put(b.INIT_ENDED, new a(IronSourceConstants.NT_MANAGER_INIT_ENDED, -1));
        this.o.put(b.PLACEMENT_CAPPED, new a(IronSourceConstants.NT_PLACEMENT_CAPPED, -1));
        this.o.put(b.AUCTION_REQUEST, new a(IronSourceConstants.NT_AUCTION_REQUEST, -1));
        this.o.put(b.AUCTION_SUCCESS, new a(IronSourceConstants.NT_AUCTION_SUCCESS, -1));
        this.o.put(b.AUCTION_FAILED, new a(IronSourceConstants.NT_AUCTION_FAILED, -1));
        this.o.put(b.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.NT_AUCTION_REQUEST_WATERFALL, -1));
        this.o.put(b.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.NT_AUCTION_RESPONSE_WATERFALL, -1));
        this.o.put(b.INIT_SUCCESS, new a(-1, -1));
        this.o.put(b.INIT_FAILED, new a(-1, -1));
        this.o.put(b.AD_OPENED, new a(IronSourceConstants.NT_CALLBACK_SHOW, IronSourceConstants.NT_INSTANCE_SHOW));
        this.o.put(b.AD_CLICKED, new a(IronSourceConstants.NT_CALLBACK_CLICK, IronSourceConstants.NT_INSTANCE_CLICK));
        this.o.put(b.LOAD_AD, new a(4001, 4002));
        this.o.put(b.LOAD_AD_SUCCESS, new a(IronSourceConstants.NT_CALLBACK_LOAD_SUCCESS, 4005));
        this.o.put(b.LOAD_AD_FAILED_WITH_REASON, new a(IronSourceConstants.NT_CALLBACK_LOAD_ERROR, IronSourceConstants.NT_INSTANCE_LOAD_ERROR));
        this.o.put(b.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.NT_INSTANCE_LOAD_NO_FILL));
        this.o.put(b.AD_UNIT_CAPPED, new a(IronSourceConstants.NT_AD_UNIT_CAPPED, -1));
        this.o.put(b.COLLECT_TOKEN, new a(IronSourceConstants.NT_COLLECT_TOKENS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN));
        this.o.put(b.COLLECT_TOKENS_COMPLETED, new a(IronSourceConstants.NT_COLLECT_TOKENS_COMPLETED, -1));
        this.o.put(b.COLLECT_TOKENS_FAILED, new a(IronSourceConstants.NT_COLLECT_TOKENS_FAILED, -1));
        this.o.put(b.INSTANCE_COLLECT_TOKEN, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN, -1));
        this.o.put(b.INSTANCE_COLLECT_TOKEN_SUCCESS, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_SUCCESS));
        this.o.put(b.INSTANCE_COLLECT_TOKEN_FAILED, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_FAILED));
        this.o.put(b.INSTANCE_COLLECT_TOKEN_TIMED_OUT, new a(IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT, IronSourceConstants.NT_INSTANCE_COLLECT_TOKEN_TIMED_OUT));
        this.o.put(b.DESTROY_AD, new a(4100, IronSourceConstants.NT_INSTANCE_DESTROY));
        this.o.put(b.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_NT_PROVIDER_SETTINGS_MISSING));
        this.o.put(b.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_NT_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_NT_BIDDING_DATA_MISSING));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_SUCCESS));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_INIT_FAILED));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_SUCCESS));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_AUCTION_FAILED));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_SUCCESS));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_LOAD_FAILED));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_TIMEOUT));
        this.o.put(b.TROUBLESHOOT_UNEXPECTED_OPENED, new a(IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED, IronSourceConstants.TROUBLESHOOTING_NT_UNEXPECTED_OPENED));
        this.o.put(b.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_NT_INTERNAL_ERROR));
        this.o.put(b.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.o.put(b.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR));
        this.o.put(b.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_NT_NOTIFICATIONS_ERROR, -1));
        this.b = new g(this);
        this.c = new h(this);
        this.d = new i(this);
        this.e = new e(this);
        this.f = new a(this);
        this.g = new j(this);
    }

    private int a(b bVar) {
        try {
            if (IronSource.AD_UNIT.INTERSTITIAL.equals(this.i) && this.l.containsKey(bVar)) {
                return this.l.get(bVar).a(this.j);
            }
            if (IronSource.AD_UNIT.REWARDED_VIDEO.equals(this.i) && this.m.containsKey(bVar)) {
                return this.m.get(bVar).a(this.j);
            }
            if (IronSource.AD_UNIT.BANNER.equals(this.i) && this.n.containsKey(bVar)) {
                return this.n.get(bVar).a(this.j);
            }
            if (!IronSource.AD_UNIT.NATIVE_AD.equals(this.i) || !this.o.containsKey(bVar)) {
                return -1;
            }
            return this.o.get(bVar).a(this.j);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(b bVar, Map<String, Object> map) {
        a(bVar, map, System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public final void a(b bVar, Map<String, Object> map, long j2) {
        int a2 = a(bVar);
        if (-1 != a2) {
            HashMap hashMap = new HashMap();
            c cVar = this.a;
            if (cVar != null) {
                hashMap.putAll(cVar.a(bVar));
            }
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(map);
            }
            this.k.a(new com.ironsource.environment.c.a(a2, j2, new JSONObject(hashMap)));
        }
    }
}
