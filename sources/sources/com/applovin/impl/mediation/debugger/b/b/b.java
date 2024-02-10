package com.applovin.impl.mediation.debugger.b.b;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.util.VersionInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements AppLovinCommunicatorSubscriber, Comparable<b> {
    private final boolean A;
    private final String B;
    private final Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> C;
    private final m a;
    private final a b;
    private int c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final String m;
    private final String n;
    private final String o;
    private String p;
    private final String q;
    private final String r;
    private final String s;
    private final int t;
    private final List<MaxAdFormat> u;
    private final List<d> v;
    private final List<a> w;
    private final List<String> x;
    private final c y;
    private final Map<MaxAdFormat, String> z;

    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");
        
        private final String e;

        private a(String str) {
            this.e = str;
        }

        /* access modifiers changed from: private */
        public String a() {
            return this.e;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.b.b.b$b  reason: collision with other inner class name */
    public enum C0015b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");
        
        private final String f;
        private final int g;
        private final String h;

        private C0015b(String str, int i2, String str2) {
            this.f = str;
            this.g = i2;
            this.h = str2;
        }

        public String a() {
            return this.f;
        }

        public int b() {
            return this.g;
        }

        public String c() {
            return this.h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01b8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0268  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(org.json.JSONObject r20, com.applovin.impl.sdk.m r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r4 = "MediatedNetwork"
            r19.<init>()
            r1.a = r3
            java.lang.String r0 = "name"
            java.lang.String r5 = ""
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.m = r0
            java.lang.String r0 = "display_name"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.n = r0
            java.lang.String r6 = "adapter_class"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r6, r5)
            r1.o = r0
            java.lang.String r0 = "latest_adapter_version"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.r = r0
            java.util.List r0 = r19.a((org.json.JSONObject) r20)
            r1.x = r0
            r7 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)
            java.lang.String r8 = "hide_if_missing"
            java.lang.Boolean r8 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r8, r0)
            boolean r8 = r8.booleanValue()
            r1.j = r8
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r9 = "configuration"
            org.json.JSONObject r8 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r9, (org.json.JSONObject) r8)
            java.util.List r9 = r1.a(r8, r3)
            r1.v = r9
            com.applovin.impl.mediation.debugger.b.b.c r9 = new com.applovin.impl.mediation.debugger.b.b.c
            r9.<init>(r8, r3)
            r1.y = r9
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r10 = "test_mode"
            org.json.JSONObject r9 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r8, (java.lang.String) r10, (org.json.JSONObject) r9)
            java.lang.String r11 = "false_coppa_required"
            java.lang.Boolean r11 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r9, r11, r0)
            boolean r11 = r11.booleanValue()
            r1.l = r11
            java.lang.String r11 = "network_names"
            r12 = 0
            org.json.JSONObject r9 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r9, (java.lang.String) r11, (org.json.JSONObject) r12)
            if (r9 == 0) goto L_0x00b4
            int r11 = r9.length()
            if (r11 <= 0) goto L_0x00b4
            int r11 = r9.length()
            java.util.Map r11 = com.applovin.impl.sdk.utils.CollectionUtils.map((int) r11)
            java.util.Iterator r13 = r9.keys()
        L_0x0090:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00b1
            java.lang.Object r14 = r13.next()
            java.lang.String r14 = (java.lang.String) r14
            com.applovin.mediation.MaxAdFormat r15 = com.applovin.mediation.MaxAdFormat.formatFromString(r14)
            java.lang.String r14 = com.applovin.impl.sdk.utils.JsonUtils.getString(r9, r14, r12)
            if (r15 == 0) goto L_0x0090
            boolean r16 = android.text.TextUtils.isEmpty(r14)
            if (r16 == 0) goto L_0x00ad
            goto L_0x0090
        L_0x00ad:
            r11.put(r15, r14)
            goto L_0x0090
        L_0x00b1:
            r1.z = r11
            goto L_0x00b6
        L_0x00b4:
            r1.z = r12
        L_0x00b6:
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            org.json.JSONObject r9 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r10, (org.json.JSONObject) r9)
            java.lang.String r10 = "supported"
            r11 = 1
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r11)
            java.lang.Boolean r10 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r9, r10, r13)
            boolean r10 = r10.booleanValue()
            r1.h = r10
            java.lang.String r10 = "test_mode_requires_init"
            java.lang.Boolean r0 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r10, r0)
            boolean r0 = r0.booleanValue()
            r1.i = r0
            java.lang.String r0 = "message"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r9, r0, r12)
            r1.s = r0
            java.lang.String r0 = "existence_classes"
            java.util.List r0 = com.applovin.impl.sdk.utils.JsonUtils.getList(r2, r0, r12)
            if (r0 == 0) goto L_0x00f1
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkClassesExistence(r0)
            goto L_0x00fb
        L_0x00f1:
            java.lang.String r0 = "existence_class"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkClassExistence(r0)
        L_0x00fb:
            r1.d = r0
            java.util.List r9 = java.util.Collections.emptyList()
            java.lang.String r0 = r1.o
            com.applovin.mediation.adapter.MaxAdapter r0 = com.applovin.impl.mediation.d.c.b(r0, r3)
            if (r0 == 0) goto L_0x0185
            r1.e = r11
            java.lang.String r10 = r0.getAdapterVersion()     // Catch:{ all -> 0x012d }
            java.lang.String r13 = r0.getSdkVersion()     // Catch:{ all -> 0x012a }
            if (r13 == 0) goto L_0x011a
            java.lang.String r13 = r0.getSdkVersion()     // Catch:{ all -> 0x012a }
            goto L_0x011b
        L_0x011a:
            r13 = r5
        L_0x011b:
            java.util.List r9 = r1.a((com.applovin.mediation.adapter.MaxAdapter) r0)     // Catch:{ all -> 0x0128 }
            boolean r0 = r0.isBeta()     // Catch:{ all -> 0x0128 }
            r14 = r13
            r13 = r10
            r10 = r9
            r9 = r0
            goto L_0x014f
        L_0x0128:
            r0 = move-exception
            goto L_0x0130
        L_0x012a:
            r0 = move-exception
            r13 = r5
            goto L_0x0130
        L_0x012d:
            r0 = move-exception
            r10 = r5
            r13 = r10
        L_0x0130:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "Failed to load adapter for network "
            r14.<init>(r15)
            java.lang.String r15 = r1.m
            r14.append(r15)
            java.lang.String r15 = ". Please check that you have a compatible network SDK integrated. Error: "
            r14.append(r15)
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            com.applovin.impl.sdk.u.i(r4, r0)
            r14 = r13
            r13 = r10
            r10 = r9
            r9 = 0
        L_0x014f:
            java.lang.String r0 = r1.o     // Catch:{ all -> 0x0177 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0177 }
            java.lang.String r15 = "loadNativeAd"
            r12 = 3
            java.lang.Class[] r12 = new java.lang.Class[r12]     // Catch:{ all -> 0x0177 }
            java.lang.Class<com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters> r17 = com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters.class
            r12[r7] = r17     // Catch:{ all -> 0x0177 }
            java.lang.Class<android.app.Activity> r17 = android.app.Activity.class
            r12[r11] = r17     // Catch:{ all -> 0x0177 }
            java.lang.Class<com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener> r17 = com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener.class
            r18 = 2
            r12[r18] = r17     // Catch:{ all -> 0x0177 }
            java.lang.reflect.Method r12 = r0.getMethod(r15, r12)     // Catch:{ all -> 0x0177 }
            java.lang.Class r12 = r12.getDeclaringClass()     // Catch:{ all -> 0x0177 }
            boolean r0 = r12.equals(r0)     // Catch:{ all -> 0x0177 }
            r4 = r9
            r9 = r10
            goto L_0x018b
        L_0x0177:
            r0 = move-exception
            com.applovin.impl.sdk.u r12 = r21.A()
            java.lang.String r15 = "Failed to check if adapter overrides MaxNativeAdAdapter"
            r12.b(r4, r15, r0)
            r4 = r9
            r9 = r10
            r0 = 0
            goto L_0x018b
        L_0x0185:
            r1.e = r7
            r13 = r5
            r14 = r13
            r0 = 0
            r4 = 0
        L_0x018b:
            r1.q = r13
            r1.p = r14
            r1.u = r9
            r1.k = r0
            java.util.List r0 = r1.a(r8, r13, r3)
            r1.w = r0
            java.lang.String r0 = "alternative_network"
            r9 = 0
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r0, (org.json.JSONObject) r9)
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r6, r5)
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkClassExistence(r0)
            r1.g = r0
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = r19.C()
            r1.b = r0
            java.lang.String r0 = r1.r
            boolean r0 = r13.equals(r0)
            if (r0 != 0) goto L_0x01bc
            if (r4 != 0) goto L_0x01bc
            r0 = 1
            goto L_0x01bd
        L_0x01bc:
            r0 = 0
        L_0x01bd:
            r1.f = r0
            android.content.Context r0 = r21.L()
            java.lang.String r2 = r1.m
            java.lang.String r3 = "_"
            int r2 = r2.lastIndexOf(r3)
            r3 = -1
            if (r2 == r3) goto L_0x01d9
            java.lang.String r3 = r1.m
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r2 = r3.substring(r7, r2)
            goto L_0x01df
        L_0x01d9:
            java.lang.String r2 = r1.m
            java.lang.String r2 = r2.toLowerCase()
        L_0x01df:
            android.content.res.Resources r3 = r0.getResources()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "applovin_ic_mediation_"
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = "drawable"
            java.lang.String r5 = r0.getPackageName()
            int r2 = r3.getIdentifier(r2, r4, r5)
            r1.t = r2
            com.applovin.mediation.adapter.MaxAdapter$InitializationStatus r2 = com.applovin.mediation.adapter.MaxAdapter.InitializationStatus.NOT_INITIALIZED
            int r2 = r2.getCode()
            r1.c = r2
            com.applovin.communicator.AppLovinCommunicator r0 = com.applovin.communicator.AppLovinCommunicator.getInstance(r0)
            java.lang.String r2 = "adapter_initialization_status"
            r0.subscribe((com.applovin.communicator.AppLovinCommunicatorSubscriber) r1, (java.lang.String) r2)
            java.lang.String r0 = "amazon_marketplace"
            r2 = 0
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r8, (java.lang.String) r0, (org.json.JSONObject) r2)
            if (r0 == 0) goto L_0x0268
            boolean r3 = r1.d
            if (r3 == 0) goto L_0x0268
            r1.A = r11
            java.lang.String r3 = "test_mode_app_id"
            java.lang.String r3 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r3, r2)
            r1.B = r3
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "test_mode_slot_ids"
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r0, (java.lang.String) r3, (org.json.JSONObject) r2)
            int r2 = r0.length()
            java.util.Map r2 = com.applovin.impl.sdk.utils.CollectionUtils.map((int) r2)
            java.util.Iterator r3 = r0.keys()
        L_0x023c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x026d
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.applovin.mediation.MaxAdFormat r5 = com.applovin.mediation.MaxAdFormat.formatFromString(r4)
            r6 = 0
            org.json.JSONObject r4 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r0, (java.lang.String) r4, (org.json.JSONObject) r6)
            if (r5 == 0) goto L_0x023c
            if (r4 != 0) goto L_0x0256
            goto L_0x023c
        L_0x0256:
            java.lang.String r7 = "uuid"
            java.lang.String r7 = com.applovin.impl.sdk.utils.JsonUtils.getString(r4, r7, r6)
            if (r7 != 0) goto L_0x025f
            goto L_0x023c
        L_0x025f:
            com.applovin.impl.mediation.debugger.a.b r6 = new com.applovin.impl.mediation.debugger.a.b
            r6.<init>(r7, r4, r5)
            r2.put(r5, r6)
            goto L_0x023c
        L_0x0268:
            r1.A = r7
            r2 = 0
            r1.B = r2
        L_0x026d:
            r1.C = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.b.b.b.<init>(org.json.JSONObject, com.applovin.impl.sdk.m):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        r0 = com.applovin.impl.mediation.debugger.b.b.b.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r3.g != false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r3.e != false) goto L_0x0014;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.impl.mediation.debugger.b.b.b.a C() {
        /*
            r3 = this;
            boolean r0 = r3.d
            if (r0 == 0) goto L_0x0010
            boolean r0 = r3.e
            if (r0 == 0) goto L_0x000b
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.COMPLETE
            goto L_0x0019
        L_0x000b:
            boolean r0 = r3.g
            if (r0 == 0) goto L_0x0014
            goto L_0x0017
        L_0x0010:
            boolean r0 = r3.e
            if (r0 == 0) goto L_0x0017
        L_0x0014:
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INCOMPLETE_INTEGRATION
            goto L_0x0019
        L_0x0017:
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.MISSING
        L_0x0019:
            com.applovin.impl.mediation.debugger.b.b.b$a r1 = com.applovin.impl.mediation.debugger.b.b.b.a.MISSING
            if (r0 != r1) goto L_0x001e
            return r0
        L_0x001e:
            java.util.List<com.applovin.impl.mediation.debugger.b.b.d> r1 = r3.v
            java.util.Iterator r1 = r1.iterator()
        L_0x0024:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r1.next()
            com.applovin.impl.mediation.debugger.b.b.d r2 = (com.applovin.impl.mediation.debugger.b.b.d) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x0024
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INVALID_INTEGRATION
            return r0
        L_0x0039:
            java.util.List<com.applovin.impl.mediation.debugger.b.b.a> r1 = r3.w
            java.util.Iterator r1 = r1.iterator()
        L_0x003f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0054
            java.lang.Object r2 = r1.next()
            com.applovin.impl.mediation.debugger.b.b.a r2 = (com.applovin.impl.mediation.debugger.b.b.a) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x003f
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INVALID_INTEGRATION
            return r0
        L_0x0054:
            com.applovin.impl.mediation.debugger.b.b.c r1 = r3.y
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0066
            com.applovin.impl.mediation.debugger.b.b.c r1 = r3.y
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x0066
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INCOMPLETE_INTEGRATION
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.b.b.b.C():com.applovin.impl.mediation.debugger.b.b.b$a");
    }

    private List<MaxAdFormat> a(MaxAdapter maxAdapter) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            arrayList.add(MaxAdFormat.MREC);
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List<String> a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", (JSONArray) null), (List) null);
    }

    private List<d> a(JSONObject jSONObject, m mVar) {
        ArrayList arrayList = new ArrayList();
        if (this.o.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            d dVar = new d("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", mVar.L());
            if (dVar.c()) {
                arrayList.add(dVar);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                arrayList.add(new d(next, jSONObject2.getString(next), mVar.L()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List<a> a(JSONObject jSONObject, String str, m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new a(jSONObject2, mVar));
            }
        }
        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i3, (JSONObject) null);
            if (jSONObject3 != null && a.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", (String) null), JsonUtils.getString(jSONObject3, "max_adapter_version", (String) null))) {
                arrayList.add(new a(jSONObject3, mVar));
            }
        }
        return arrayList;
    }

    public String A() {
        return this.B;
    }

    public Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> B() {
        return this.C;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return this.n.compareToIgnoreCase(bVar.n);
    }

    public a a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public C0015b c() {
        return !this.h ? C0015b.NOT_SUPPORTED : (this.b == a.COMPLETE || (this.b == a.INCOMPLETE_INTEGRATION && d() && e())) ? !this.a.J().a() ? C0015b.DISABLED : (!this.i || !(this.c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? C0015b.READY : C0015b.NOT_INITIALIZED : C0015b.INVALID_INTEGRATION;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.b == a.MISSING && this.j;
    }

    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public String h() {
        return this.m;
    }

    public String i() {
        return this.n;
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.q;
    }

    public String l() {
        return this.r;
    }

    public String m() {
        return this.o;
    }

    public List<String> n() {
        return this.x;
    }

    public int o() {
        return this.t;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.o.equals(string)) {
            this.c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter b2 = c.b(string, this.a);
            if (b2 != null && !this.p.equals(b2.getSdkVersion())) {
                this.p = b2.getSdkVersion();
                this.a.ag().a(this.p, string);
            }
        }
    }

    public List<MaxAdFormat> p() {
        return this.u;
    }

    public boolean q() {
        return this.k;
    }

    public List<d> r() {
        return this.v;
    }

    public List<a> s() {
        return this.w;
    }

    public final c t() {
        return this.y;
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.m + ", displayName=" + this.n + ", sdkAvailable=" + this.d + ", sdkVersion=" + this.p + ", adapterAvailable=" + this.e + ", adapterVersion=" + this.q + "}";
    }

    public Map<MaxAdFormat, String> u() {
        return this.z;
    }

    public String v() {
        return this.s;
    }

    public boolean w() {
        return this.l;
    }

    public final m x() {
        return this.a;
    }

    public final String y() {
        StringBuilder sb = new StringBuilder("\n---------- ");
        sb.append(this.m);
        sb.append(" ----------\nStatus  - ");
        sb.append(this.b.a());
        sb.append("\nSDK     - ");
        boolean z2 = this.d;
        String str = VersionInfo.UNAVAILABLE;
        sb.append((!z2 || TextUtils.isEmpty(this.p)) ? str : this.p);
        sb.append("\nAdapter - ");
        if (this.e && !TextUtils.isEmpty(this.q)) {
            str = this.q;
        }
        sb.append(str);
        if (this.y.a() && !this.y.b()) {
            sb.append("\n* ");
            sb.append(this.y.c());
        }
        for (d next : r()) {
            if (!next.c()) {
                sb.append("\n* MISSING ");
                sb.append(next.a());
                sb.append(": ");
                sb.append(next.b());
            }
        }
        for (a next2 : s()) {
            if (!next2.c()) {
                sb.append("\n* MISSING ");
                sb.append(next2.a());
                sb.append(": ");
                sb.append(next2.b());
            }
        }
        return sb.toString();
    }

    public boolean z() {
        return this.A;
    }
}
