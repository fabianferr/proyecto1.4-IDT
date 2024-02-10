package com.applovin.impl.mediation.debugger.ui.b;

import android.app.Activity;
import android.content.Context;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.debugger.b.b.b;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.mediation.debugger.ui.d.d;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.f;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class b extends d implements AppLovinCommunicatorSubscriber {
    private m a;
    private List<com.applovin.impl.mediation.debugger.b.a.a> b;
    private List<com.applovin.impl.mediation.debugger.b.a.a> d;
    private String e;
    private String f;
    private String g;
    private final StringBuilder h = new StringBuilder("");
    private final AtomicBoolean i = new AtomicBoolean();
    private boolean j = false;
    private List<com.applovin.impl.mediation.debugger.b.b.b> k = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.b.b> l = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.b.b> m = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.a.d> n = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.a.d> o = new ArrayList();
    private List<com.applovin.impl.mediation.debugger.b.b.b> p = new ArrayList();
    private List<c> q = new ArrayList();
    private List<c> r = new ArrayList();
    private List<c> s = new ArrayList();
    private List<c> t = new ArrayList();
    private List<c> u = new ArrayList();
    private List<c> v = new ArrayList();
    private List<c> w = new ArrayList();

    public enum a {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        SELECT_TEST_MODE_NETWORKS,
        INITIALIZATION_AD_UNITS,
        COUNT
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$b  reason: collision with other inner class name */
    public enum C0018b {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public b(Context context) {
        super(context);
    }

    private c a(String str) {
        c.a p2 = c.p();
        if (!this.a.J().a()) {
            p2.a(this.c);
        }
        c.a a2 = p2.a((StringUtils.isValidString(str) ? "" : "Select ").concat("Live Network"));
        if (this.a.J().a()) {
            str = "Enable";
        }
        return a2.b(str).b(-16776961).d("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").a(true).a();
    }

    private List<c> a(String str, String str2) {
        ArrayList arrayList = new ArrayList(3);
        c.a p2 = c.p();
        arrayList.add(p2.a("View Ad Units (" + this.b.size() + ")").a(this.c).a(true).a());
        arrayList.add(a(str));
        arrayList.add(b(str2));
        if (!this.d.isEmpty()) {
            c.a p3 = c.p();
            arrayList.add(p3.a("Selective Init Ad Units (" + this.d.size() + ")").a(this.c).a(true).a());
        }
        return arrayList;
    }

    private void a(c.a aVar, String str) {
        aVar.c("MAX Ad Review").d(str).a(R.drawable.applovin_ic_x_mark).c(f.a(R.color.applovin_sdk_xmarkColor, this.c)).a(true);
    }

    private void a(StringBuilder sb, String str) {
        String sb2 = sb.toString();
        if (sb2.length() + str.length() >= ((Integer) this.a.a(com.applovin.impl.sdk.d.b.aj)).intValue()) {
            u.f("MediationDebuggerListAdapter", sb2);
            this.h.append(sb2);
            sb.setLength(1);
        }
        sb.append(str);
    }

    private void a(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        List<com.applovin.impl.mediation.debugger.b.b.b> list2;
        for (com.applovin.impl.mediation.debugger.b.b.b next : list) {
            if (!next.g()) {
                if (next.a() == b.a.INCOMPLETE_INTEGRATION || next.a() == b.a.INVALID_INTEGRATION) {
                    list2 = this.k;
                } else if (next.a() == b.a.COMPLETE) {
                    list2 = this.l;
                } else if (next.a() == b.a.MISSING) {
                    list2 = this.m;
                }
                list2.add(next);
            }
        }
    }

    private c b(String str) {
        c.a p2 = c.p();
        if (this.a.J().a()) {
            p2.a(this.c);
        }
        c.a a2 = p2.a((StringUtils.isValidString(str) ? "" : "Select ").concat("Test Mode Network"));
        if (!this.a.J().a()) {
            str = "Enable";
        }
        return a2.b(str).b(-16776961).d("Please re-launch the app to enable test mode. This will allow the selection of test mode networks.").a(true).a();
    }

    private c b(String str, String str2) {
        c.a a2 = c.p().a(str);
        if (StringUtils.isValidString(str2)) {
            a2.b(str2);
        } else {
            a2.a(R.drawable.applovin_ic_x_mark);
            a2.c(f.a(R.color.applovin_sdk_xmarkColor, this.c));
        }
        return a2.a();
    }

    private void b(List<com.applovin.impl.mediation.debugger.b.a.a> list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (com.applovin.impl.mediation.debugger.b.a.a e2 : list) {
            com.applovin.impl.mediation.debugger.b.a.c e3 = e2.e();
            for (com.applovin.impl.mediation.debugger.b.a.b a2 : e3.a()) {
                hashSet.add(a2.a());
            }
            for (com.applovin.impl.mediation.debugger.b.a.b a3 : e3.b()) {
                hashSet2.add(a3.a());
            }
        }
        this.n = new ArrayList(hashSet);
        this.o = new ArrayList(hashSet2);
        Collections.sort(this.n);
        Collections.sort(this.o);
    }

    private void c(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        for (com.applovin.impl.mediation.debugger.b.b.b next : list) {
            if (next.c() == b.C0015b.READY) {
                this.p.add(next);
            }
        }
    }

    private List<c> d(List<com.applovin.impl.mediation.debugger.b.b.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (com.applovin.impl.mediation.debugger.b.b.b aVar : list) {
            arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.a(aVar, this.c));
        }
        return arrayList;
    }

    private void o() {
        Map<String, String> metaData;
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + Utils.isPubInDebugMode(this.c, this.a));
        sb.append("\nTest Mode - ".concat(this.a.J().a() ? "enabled" : "disabled"));
        sb.append("\nTarget SDK - " + this.a.V().h().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.a.a(com.applovin.impl.sdk.d.b.dC);
        String a2 = e.a();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb2 = new StringBuilder("\nPlugin Version - ");
        String str3 = "None";
        if (!StringUtils.isValidString(str2)) {
            str2 = str3;
        }
        sb2.append(str2);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder("\nAd Review Version - ");
        if (!StringUtils.isValidString(a2)) {
            a2 = "Disabled";
        }
        sb3.append(a2);
        sb.append(sb3.toString());
        if (this.a.g() && (metaData = Utils.getMetaData(this.a.p())) != null) {
            String str4 = metaData.get("UnityVersion");
            StringBuilder sb4 = new StringBuilder("\nUnity Version - ");
            if (StringUtils.isValidString(str4)) {
                str3 = str4;
            }
            sb4.append(str3);
            sb.append(sb4.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(j.a(this.c));
        sb.append("\n========== NETWORKS ==========");
        for (com.applovin.impl.mediation.debugger.b.b.b y : this.l) {
            a(sb, y.y());
        }
        for (com.applovin.impl.mediation.debugger.b.b.b y2 : this.k) {
            a(sb, y2.y());
        }
        sb.append("\n========== AD UNITS ==========");
        for (com.applovin.impl.mediation.debugger.b.a.a f2 : this.b) {
            a(sb, f2.f());
        }
        sb.append("\n========== END ==========");
        u.f("MediationDebuggerListAdapter", sb.toString());
        this.h.append(sb.toString());
    }

    private List<c> p() {
        String str;
        ArrayList arrayList = new ArrayList(5);
        try {
            str = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(c.p().a("Package Name").b(this.c.getPackageName()).a());
        c.a a2 = c.p().a("App Version");
        String str2 = "None";
        if (!StringUtils.isValidString(str)) {
            str = str2;
        }
        arrayList.add(a2.b(str).a());
        arrayList.add(c.p().a("OS").b(Utils.getAndroidOSInfo()).a());
        arrayList.add(c.p().a("Account").b(StringUtils.isValidString(this.g) ? this.g : str2).a());
        c.a a3 = c.p().a("Mediation Provider");
        if (StringUtils.isValidString(this.a.t())) {
            str2 = this.a.t();
        }
        arrayList.add(a3.b(str2).a());
        arrayList.add(c.p().a("OM SDK Version").b(this.a.al().c()).a());
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.applovin.impl.mediation.debugger.ui.d.c> q() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 4
            r0.<init>(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.ui.d.c.p()
            java.lang.String r2 = "SDK Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.sdk.AppLovinSdk.VERSION
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.b((java.lang.String) r2)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.a()
            r0.add(r1)
            com.applovin.impl.sdk.m r1 = r6.a
            com.applovin.impl.sdk.d.b<java.lang.String> r2 = com.applovin.impl.sdk.d.b.dC
            java.lang.Object r1 = r1.a(r2)
            java.lang.String r1 = (java.lang.String) r1
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = com.applovin.impl.mediation.debugger.ui.d.c.p()
            java.lang.String r3 = "Plugin Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = r2.a((java.lang.String) r3)
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            java.lang.String r4 = "None"
            if (r3 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r4
        L_0x003b:
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r2.b((java.lang.String) r1)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.a()
            r0.add(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.ui.d.c.p()
            java.lang.String r2 = "Ad Review Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = com.applovin.impl.sdk.e.a()
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r2)
            if (r3 == 0) goto L_0x0096
            java.lang.String r3 = com.applovin.impl.sdk.e.b()
            boolean r5 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)
            if (r5 == 0) goto L_0x0092
            com.applovin.impl.sdk.m r5 = r6.a
            java.lang.String r5 = r5.z()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0071
            goto L_0x0092
        L_0x0071:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MAX Ad Review integrated with wrong SDK key. Please check that your "
            r2.<init>(r3)
            com.applovin.impl.sdk.m r3 = r6.a
            boolean r3 = r3.g()
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = "SDK key is downloaded"
            goto L_0x0085
        L_0x0083:
            java.lang.String r3 = "Gradle plugin snippet is integrated"
        L_0x0085:
            r2.append(r3)
            java.lang.String r3 = " from the correct account."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L_0x0098
        L_0x0092:
            r1.b((java.lang.String) r2)
            goto L_0x009b
        L_0x0096:
            java.lang.String r2 = "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps."
        L_0x0098:
            r6.a((com.applovin.impl.mediation.debugger.ui.d.c.a) r1, (java.lang.String) r2)
        L_0x009b:
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.a()
            r0.add(r1)
            com.applovin.impl.sdk.m r1 = r6.a
            boolean r1 = r1.g()
            if (r1 == 0) goto L_0x00ce
            com.applovin.impl.sdk.m r1 = r6.a
            com.applovin.sdk.AppLovinSdkSettings r1 = r1.p()
            java.util.Map r1 = com.applovin.impl.sdk.utils.Utils.getMetaData(r1)
            if (r1 == 0) goto L_0x00ce
            java.lang.String r2 = "UnityVersion"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            if (r2 == 0) goto L_0x00c5
            r4 = r1
        L_0x00c5:
            java.lang.String r1 = "Unity Version"
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r6.b(r1, r4)
            r0.add(r1)
        L_0x00ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.ui.b.b.q():java.util.List");
    }

    private List<c> r() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(j.a(), true, this.c));
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(j.b(), false, this.c));
        arrayList.add(new com.applovin.impl.mediation.debugger.ui.b.a.b(j.c(), true, this.c));
        return arrayList;
    }

    private List<c> s() {
        return a((String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        return (i2 == C0018b.APP_INFO.ordinal() ? this.q : i2 == C0018b.MAX.ordinal() ? this.r : i2 == C0018b.PRIVACY.ordinal() ? this.s : i2 == C0018b.ADS.ordinal() ? this.t : i2 == C0018b.INCOMPLETE_NETWORKS.ordinal() ? this.u : i2 == C0018b.COMPLETED_NETWORKS.ordinal() ? this.v : this.w).size();
    }

    public void a(List<com.applovin.impl.mediation.debugger.b.b.b> list, List<com.applovin.impl.mediation.debugger.b.a.a> list2, List<com.applovin.impl.mediation.debugger.b.a.a> list3, String str, String str2, String str3, m mVar) {
        Activity ao;
        this.a = mVar;
        this.b = list2;
        this.d = list3;
        this.e = str;
        this.f = str2;
        this.g = str3;
        if (!(this.c instanceof Activity) && (ao = mVar.ao()) != null) {
            this.c = ao;
        }
        if (list != null && this.i.compareAndSet(false, true)) {
            mVar.A().b("MediationDebuggerListAdapter", "Populating networks...");
            a(list);
            b(list2);
            c(this.l);
            this.q.addAll(p());
            this.r.addAll(q());
            this.s.addAll(r());
            this.t.addAll(s());
            this.u = d(this.k);
            this.v = d(this.l);
            this.w = d(this.m);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            arrayList.add("live_network_updated");
            arrayList.add("test_mode_network_updated");
            AppLovinCommunicator.getInstance(this.c).subscribe((AppLovinCommunicatorSubscriber) this, (List<String>) arrayList);
            o();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                b.this.notifyDataSetChanged();
            }
        });
    }

    public void a(boolean z) {
        this.j = z;
    }

    public boolean a() {
        return this.i.get();
    }

    /* access modifiers changed from: protected */
    public int b() {
        return C0018b.COUNT.ordinal();
    }

    /* access modifiers changed from: protected */
    public c b(int i2) {
        return i2 == C0018b.APP_INFO.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("APP INFO") : i2 == C0018b.MAX.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("MAX") : i2 == C0018b.PRIVACY.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("PRIVACY") : i2 == C0018b.ADS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("ADS") : i2 == C0018b.INCOMPLETE_NETWORKS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("INCOMPLETE INTEGRATIONS") : i2 == C0018b.COMPLETED_NETWORKS.ordinal() ? new com.applovin.impl.mediation.debugger.ui.d.e("COMPLETED INTEGRATIONS") : new com.applovin.impl.mediation.debugger.ui.d.e("MISSING INTEGRATIONS");
    }

    /* access modifiers changed from: protected */
    public List<c> c(int i2) {
        return i2 == C0018b.APP_INFO.ordinal() ? this.q : i2 == C0018b.MAX.ordinal() ? this.r : i2 == C0018b.PRIVACY.ordinal() ? this.s : i2 == C0018b.ADS.ordinal() ? this.t : i2 == C0018b.INCOMPLETE_NETWORKS.ordinal() ? this.u : i2 == C0018b.COMPLETED_NETWORKS.ordinal() ? this.v : this.w;
    }

    public boolean c() {
        return this.j;
    }

    public m d() {
        return this.a;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.a> e() {
        return this.b;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.a> f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    public String h() {
        return this.f;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.d> i() {
        return this.n;
    }

    public List<com.applovin.impl.mediation.debugger.b.a.d> j() {
        return this.o;
    }

    public List<com.applovin.impl.mediation.debugger.b.b.b> k() {
        return this.p;
    }

    public String l() {
        return this.h.toString();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        List<c> a2;
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.s = r();
        } else if ("network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.u = d(this.k);
            this.v = d(this.l);
        } else {
            if ("live_network_updated".equals(appLovinCommunicatorMessage.getTopic())) {
                a2 = a(appLovinCommunicatorMessage.getMessageData().getString("live_network", (String) null), (String) null);
            } else if ("test_mode_network_updated".equals(appLovinCommunicatorMessage.getTopic())) {
                a2 = a((String) null, appLovinCommunicatorMessage.getMessageData().getString("test_mode_network", (String) null));
            } else {
                return;
            }
            this.t = a2;
        }
        m();
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.i.get() + "}";
    }
}
