package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class i extends a {
    private static final AtomicBoolean a = new AtomicBoolean();
    private final int c;
    /* access modifiers changed from: private */
    public final Object d = new Object();
    /* access modifiers changed from: private */
    public a e;

    public interface a {
        void a(JSONObject jSONObject);
    }

    private class b extends a {
        public b(m mVar) {
            super("TaskTimeoutFetchBasicSettings", mVar, true);
        }

        public void run() {
            synchronized (i.this.d) {
                if (i.this.e != null) {
                    if (u.a()) {
                        d("Timing out fetch basic settings...");
                    }
                    i.this.a(new JSONObject());
                }
            }
        }
    }

    public i(int i, m mVar, a aVar) {
        super("TaskFetchBasicSettings", mVar, true);
        this.c = i;
        this.e = aVar;
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        synchronized (this.d) {
            a aVar = this.e;
            if (aVar != null) {
                aVar.a(jSONObject);
                this.e = null;
            }
        }
    }

    private String c() {
        return h.a((String) this.b.a(com.applovin.impl.sdk.d.b.aR), "5.0/i", d());
    }

    private String h() {
        return h.a((String) this.b.a(com.applovin.impl.sdk.d.b.aS), "5.0/i", d());
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        Map<String, String> map = CollectionUtils.map();
        map.put("rid", UUID.randomUUID().toString());
        if (!((Boolean) this.b.a(com.applovin.impl.sdk.d.b.es)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.b.z());
        }
        Boolean a2 = j.b().a(f());
        if (a2 != null) {
            map.put(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, a2.toString());
        }
        Boolean a3 = j.a().a(f());
        if (a3 != null) {
            map.put(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, a3.toString());
        }
        Boolean a4 = j.c().a(f());
        if (a4 != null) {
            map.put(AppLovinSdkExtraParameterKey.DO_NOT_SELL, a4.toString());
        }
        return map;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|(1:4)|5|(1:7)|8|(1:10)|11|(1:13)|14|(1:16)|17|(1:21)|22|(1:24)|25|26|(1:28)|29|30|(1:32)|33|(1:39)|40|(1:45)|46|(1:48)|49|(1:51)|52|(1:54)|55|(1:57)|58|(1:60)|61|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x01d0 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01e0 A[Catch:{ JSONException -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0270 A[Catch:{ JSONException -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x028b A[Catch:{ JSONException -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02a6 A[Catch:{ JSONException -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02bd A[Catch:{ JSONException -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02d2 A[Catch:{ JSONException -> 0x02ec }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject b() {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = "screen_size_in"
            java.lang.String r2 = "is_tablet"
            java.lang.String r3 = "revision"
            java.lang.String r4 = "model"
            java.lang.String r5 = "hardware"
            java.lang.String r6 = "brand_name"
            java.lang.String r7 = "brand"
            java.lang.String r8 = "locale"
            java.lang.String r9 = "os"
            java.lang.String r10 = "platform"
            java.lang.String r11 = "IABTCF_gdprApplies"
            java.lang.String r12 = "IABTCF_TCString"
            java.lang.String r13 = "target_sdk"
            java.lang.String r14 = "tg"
            java.lang.String r15 = "debug"
            r16 = r0
            java.lang.String r0 = "test_ads"
            r17 = r2
            java.lang.String r2 = "app_version"
            r18 = r3
            java.lang.String r3 = "package_name"
            r19 = r4
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r20 = r5
            java.lang.String r5 = "sdk_version"
            r21 = r6
            java.lang.String r6 = com.applovin.sdk.AppLovinSdk.VERSION     // Catch:{ JSONException -> 0x02ec }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r5 = "is_cross_promo"
            com.applovin.impl.sdk.m r6 = r1.b     // Catch:{ JSONException -> 0x02ec }
            boolean r6 = r6.e()     // Catch:{ JSONException -> 0x02ec }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r5 = "init_count"
            int r6 = r1.c     // Catch:{ JSONException -> 0x02ec }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r5 = "server_installed_at"
            com.applovin.impl.sdk.m r6 = r1.b     // Catch:{ JSONException -> 0x02ec }
            r22 = r7
            com.applovin.impl.sdk.d.b<java.lang.String> r7 = com.applovin.impl.sdk.d.b.ad     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r6 = r6.a(r7)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r5 = com.applovin.impl.sdk.utils.Utils.getUserEngagementSdkVersion()     // Catch:{ JSONException -> 0x02ec }
            boolean r6 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r5)     // Catch:{ JSONException -> 0x02ec }
            if (r6 == 0) goto L_0x006e
            java.lang.String r6 = "ue_sdk_version"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x02ec }
        L_0x006e:
            com.applovin.impl.sdk.m r5 = r1.b     // Catch:{ JSONException -> 0x02ec }
            boolean r5 = r5.P()     // Catch:{ JSONException -> 0x02ec }
            r6 = 1
            if (r5 == 0) goto L_0x007c
            java.lang.String r5 = "first_install"
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x02ec }
        L_0x007c:
            com.applovin.impl.sdk.m r5 = r1.b     // Catch:{ JSONException -> 0x02ec }
            boolean r5 = r5.Q()     // Catch:{ JSONException -> 0x02ec }
            if (r5 != 0) goto L_0x0089
            java.lang.String r5 = "first_install_v2"
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x02ec }
        L_0x0089:
            com.applovin.impl.sdk.m r5 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.d.b<java.lang.String> r7 = com.applovin.impl.sdk.d.b.dC     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r5 = r5.a(r7)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x02ec }
            boolean r7 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r5)     // Catch:{ JSONException -> 0x02ec }
            if (r7 == 0) goto L_0x009e
            java.lang.String r7 = "plugin_version"
            r4.put(r7, r5)     // Catch:{ JSONException -> 0x02ec }
        L_0x009e:
            com.applovin.impl.sdk.m r5 = r1.b     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r5 = r5.t()     // Catch:{ JSONException -> 0x02ec }
            boolean r7 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r5)     // Catch:{ JSONException -> 0x02ec }
            if (r7 == 0) goto L_0x00af
            java.lang.String r7 = "mediation_provider"
            r4.put(r7, r5)     // Catch:{ JSONException -> 0x02ec }
        L_0x00af:
            java.lang.String r5 = "installed_mediation_adapters"
            com.applovin.impl.sdk.m r7 = r1.b     // Catch:{ JSONException -> 0x02ec }
            org.json.JSONArray r7 = com.applovin.impl.mediation.d.c.a((com.applovin.impl.sdk.m) r7)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r5, r7)     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.m r5 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.o r5 = r5.V()     // Catch:{ JSONException -> 0x02ec }
            java.util.Map r5 = r5.h()     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r7 = r5.get(r3)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r3, r7)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r3 = r5.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r2 = r5.get(r0)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r0 = r5.get(r15)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r15, r0)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r0 = r5.get(r14)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r14, r0)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r0 = r5.get(r13)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r13, r0)     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.sdk.AppLovinSdkSettings r0 = r0.p()     // Catch:{ JSONException -> 0x02ec }
            java.util.List r0 = r0.getInitializationAdUnitIds()     // Catch:{ JSONException -> 0x02ec }
            if (r0 == 0) goto L_0x0111
            int r2 = r0.size()     // Catch:{ JSONException -> 0x02ec }
            if (r2 <= 0) goto L_0x0111
            java.util.List r0 = com.applovin.impl.sdk.utils.CollectionUtils.removeTrimmedEmptyStrings(r0)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r2 = "ad_unit_ids"
            int r3 = r0.size()     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r0 = com.applovin.impl.sdk.utils.CollectionUtils.implode(r0, r3)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r0)     // Catch:{ JSONException -> 0x02ec }
        L_0x0111:
            java.lang.Object r0 = r5.get(r12)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r12, r0)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r0 = r5.get(r11)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r11, r0)     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.o r0 = r0.V()     // Catch:{ JSONException -> 0x02ec }
            java.util.Map r0 = r0.b()     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r2 = r0.get(r10)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r10, r2)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r2 = r0.get(r9)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r9, r2)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r2 = r0.get(r8)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r8, r2)     // Catch:{ JSONException -> 0x02ec }
            r2 = r22
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            r2 = r21
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            r2 = r20
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            r2 = r19
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            r2 = r18
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            r2 = r17
            java.lang.Object r3 = r0.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            r2 = r16
            java.lang.Object r0 = r0.get(r2)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r0)     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.d.b.dL     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x02ec }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x02ec }
            if (r0 == 0) goto L_0x019c
            java.lang.String r0 = "mtl"
            com.applovin.impl.sdk.m r2 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.x r2 = r2.ad()     // Catch:{ JSONException -> 0x02ec }
            int r2 = r2.b()     // Catch:{ JSONException -> 0x02ec }
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x02ec }
        L_0x019c:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ all -> 0x01d0 }
            android.content.Context r0 = r0.L()     // Catch:{ all -> 0x01d0 }
            java.lang.String r2 = "activity"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x01d0 }
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch:{ all -> 0x01d0 }
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x01d0 }
            r2.<init>()     // Catch:{ all -> 0x01d0 }
            if (r0 == 0) goto L_0x01d0
            r0.getMemoryInfo(r2)     // Catch:{ all -> 0x01d0 }
            java.lang.String r0 = "fm"
            long r7 = r2.availMem     // Catch:{ all -> 0x01d0 }
            r4.put(r0, r7)     // Catch:{ all -> 0x01d0 }
            java.lang.String r0 = "tm"
            long r7 = r2.totalMem     // Catch:{ all -> 0x01d0 }
            r4.put(r0, r7)     // Catch:{ all -> 0x01d0 }
            java.lang.String r0 = "lmt"
            long r7 = r2.threshold     // Catch:{ all -> 0x01d0 }
            r4.put(r0, r7)     // Catch:{ all -> 0x01d0 }
            java.lang.String r0 = "lm"
            boolean r2 = r2.lowMemory     // Catch:{ all -> 0x01d0 }
            r4.put(r0, r2)     // Catch:{ all -> 0x01d0 }
        L_0x01d0:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.AppLovinTargetingDataImpl r0 = r0.r()     // Catch:{ JSONException -> 0x02ec }
            java.util.Map r0 = r0.getAllData()     // Catch:{ JSONException -> 0x02ec }
            boolean r2 = r0.isEmpty()     // Catch:{ JSONException -> 0x02ec }
            if (r2 != 0) goto L_0x01ea
            java.lang.String r2 = "targeting_data"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02ec }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
        L_0x01ea:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.o r0 = r0.V()     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.o$a r0 = r0.k()     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r2 = "dnt"
            boolean r3 = r0.a     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.j$a r2 = com.applovin.impl.sdk.j.a()     // Catch:{ JSONException -> 0x02ec }
            android.content.Context r3 = r23.f()     // Catch:{ JSONException -> 0x02ec }
            java.lang.Boolean r2 = r2.a((android.content.Context) r3)     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.m r3 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r5 = com.applovin.impl.sdk.d.b.dy     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r3 = r3.a(r5)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x02ec }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x02ec }
            if (r3 == 0) goto L_0x022e
            java.lang.String r3 = r0.b     // Catch:{ JSONException -> 0x02ec }
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)     // Catch:{ JSONException -> 0x02ec }
            if (r3 == 0) goto L_0x022e
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x02ec }
            boolean r3 = r3.equals(r2)     // Catch:{ JSONException -> 0x02ec }
            if (r3 != 0) goto L_0x022e
            java.lang.String r3 = "idfa"
            java.lang.String r0 = r0.b     // Catch:{ JSONException -> 0x02ec }
            r4.put(r3, r0)     // Catch:{ JSONException -> 0x02ec }
        L_0x022e:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.o r0 = r0.V()     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.o$b r0 = r0.l()     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.m r3 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r5 = com.applovin.impl.sdk.d.b.dr     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r3 = r3.a(r5)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x02ec }
            boolean r3 = r3.booleanValue()     // Catch:{ JSONException -> 0x02ec }
            if (r3 == 0) goto L_0x0260
            if (r0 == 0) goto L_0x0260
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x02ec }
            boolean r2 = r3.equals(r2)     // Catch:{ JSONException -> 0x02ec }
            if (r2 != 0) goto L_0x0260
            java.lang.String r2 = "idfv"
            java.lang.String r3 = r0.a     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r2 = "idfv_scope"
            int r0 = r0.b     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r0)     // Catch:{ JSONException -> 0x02ec }
        L_0x0260:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.sdk.AppLovinUserSegment r0 = r0.q()     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r0 = r0.getName()     // Catch:{ JSONException -> 0x02ec }
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)     // Catch:{ JSONException -> 0x02ec }
            if (r2 == 0) goto L_0x027b
            java.lang.String r2 = "user_segment_name"
            com.applovin.impl.sdk.m r3 = r1.b     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.encodeUriString(r0, r3)     // Catch:{ JSONException -> 0x02ec }
            r4.put(r2, r0)     // Catch:{ JSONException -> 0x02ec }
        L_0x027b:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.d.b.du     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x02ec }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x02ec }
            if (r0 == 0) goto L_0x0296
            java.lang.String r0 = "compass_random_token"
            com.applovin.impl.sdk.m r2 = r1.b     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r2 = r2.n()     // Catch:{ JSONException -> 0x02ec }
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x02ec }
        L_0x0296:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.d.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.d.b.dw     // Catch:{ JSONException -> 0x02ec }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x02ec }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x02ec }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x02ec }
            if (r0 == 0) goto L_0x02b1
            java.lang.String r0 = "applovin_random_token"
            com.applovin.impl.sdk.m r2 = r1.b     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r2 = r2.o()     // Catch:{ JSONException -> 0x02ec }
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x02ec }
        L_0x02b1:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.mediation.debugger.ui.testmode.c r0 = r0.J()     // Catch:{ JSONException -> 0x02ec }
            boolean r0 = r0.a()     // Catch:{ JSONException -> 0x02ec }
            if (r0 == 0) goto L_0x02c2
            java.lang.String r0 = "test_mode"
            r4.put(r0, r6)     // Catch:{ JSONException -> 0x02ec }
        L_0x02c2:
            com.applovin.impl.sdk.m r0 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.mediation.debugger.ui.testmode.c r0 = r0.J()     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r0 = r0.c()     // Catch:{ JSONException -> 0x02ec }
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)     // Catch:{ JSONException -> 0x02ec }
            if (r2 == 0) goto L_0x02d7
            java.lang.String r2 = "test_mode_network"
            r4.put(r2, r0)     // Catch:{ JSONException -> 0x02ec }
        L_0x02d7:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02ec }
            com.applovin.impl.sdk.m r2 = r1.b     // Catch:{ JSONException -> 0x02ec }
            com.applovin.sdk.AppLovinSdkSettings r2 = r2.p()     // Catch:{ JSONException -> 0x02ec }
            java.util.Map r2 = r2.getExtraParameters()     // Catch:{ JSONException -> 0x02ec }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x02ec }
            java.lang.String r2 = "sdk_extra_parameters"
            r4.put(r2, r0)     // Catch:{ JSONException -> 0x02ec }
            goto L_0x02f8
        L_0x02ec:
            r0 = move-exception
            boolean r2 = com.applovin.impl.sdk.u.a()
            if (r2 == 0) goto L_0x02f8
            java.lang.String r2 = "Failed to construct JSON body"
            r1.a(r2, r0)
        L_0x02f8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.f.i.b():org.json.JSONObject");
    }

    public void run() {
        if (!g.i() && a.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(this.b.L());
            } catch (Throwable th) {
                if (u.a()) {
                    a("Cannot update security provider", th);
                }
            }
        }
        Map<String, String> a2 = a();
        c<T> a3 = c.a(this.b).a(c()).c(h()).a(a2).a(b()).d(((Boolean) this.b.a(com.applovin.impl.sdk.d.b.ey)).booleanValue()).b("POST").a(new JSONObject()).a(((Integer) this.b.a(com.applovin.impl.sdk.d.b.cZ)).intValue()).c(((Integer) this.b.a(com.applovin.impl.sdk.d.b.dc)).intValue()).b(((Integer) this.b.a(com.applovin.impl.sdk.d.b.cY)).intValue()).a();
        this.b.S().a((a) new b(this.b), o.a.TIMEOUT, ((long) ((Integer) this.b.a(com.applovin.impl.sdk.d.b.cY)).intValue()) + 250);
        AnonymousClass1 r1 = new u<JSONObject>(a3, this.b, g()) {
            public void a(int i, String str, JSONObject jSONObject) {
                if (u.a()) {
                    d("Unable to fetch basic SDK settings: server returned " + i);
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                i.this.a(jSONObject);
            }

            public void a(JSONObject jSONObject, int i) {
                i.this.a(jSONObject);
            }
        };
        r1.a(com.applovin.impl.sdk.d.b.aR);
        r1.b(com.applovin.impl.sdk.d.b.aS);
        this.b.S().a((a) r1);
    }
}
