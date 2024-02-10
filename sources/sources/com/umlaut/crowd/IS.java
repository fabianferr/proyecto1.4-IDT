package com.umlaut.crowd;

import android.content.Context;
import android.content.SharedPreferences;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CDC;
import com.umlaut.crowd.internal.CLC;
import com.umlaut.crowd.internal.RBR;
import com.umlaut.crowd.internal.d;
import com.umlaut.crowd.internal.p7;
import com.umlaut.crowd.internal.w2;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class IS {
    private static final String A = "P3INS_PFK_QOE_MANAGER_ENABLED";
    private static final String B = "P3INS_PFK_REGISTRATION_TIMESTAMP";
    private static final String C = "P3INS_PFK_IS_ALREADY_REGISTERED";
    private static final String D = "P3INS_PFK_SEND_REGISTRATION_TIMESTAMP_ENABLED";
    private static final String E = "P3INS_PFK_UPLOAD_EXTRA";
    private static final String F = "P3INS_PFK_VOWIFI_TEST_MANAGER_ENABLED";
    private static final String G = "P3INS_PFK_CT_CRITERIA_SERVER_LIST";
    private static final String H = "P3INS_PFK_LTR_CRITERIA_SERVER_LIST";
    private static final String I = "P3INS_PFK_CDN_CT_SERVER_LIST";
    private static final String J = "P3INS_PFK_CDN_CT_CRITERIA";
    private static final String K = "P3INS_PFK_CDN_LTR_SERVER_LIST";
    private static final String L = "P3INS_PFK_CDN_LTR_CRITERIA";
    private static final String M = "P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_MODIFIED";
    private static final String N = "P3INS_PFK_CONNECTIVITY_TEST_CDNCONFIG_LAST_CHECK";
    private static final String O = "P3INS_PFK_WIFI_SCAN_TIMESTAMP";
    private static final String P = "P3INS_PFK_WIFI_SCAN_ENABLED";
    private static final String Q = "P3INS_PFK_BACKGROUND_TEST_SERVICE_ENABLED";
    private static final String R = "P3INS_PFK_PERSISTENT_RANDOM_INT";
    private static final String S = "P3INS_PFK_CONNECTED_DEVICES_TIMESTAMP";
    private static final String T = "P3INS_PFK_GUID_MAX_AGE";
    private static final String U = "P3INS_PFK_ANDROID_ID";
    private static final String V = "P3INS_PFK_AUTO_UPLOAD_ENABLED";
    private static final String W = "p3inspreferences";
    private static final String c = "p3ins_pfk_ul_params";
    private static final String d = "p3ins_pfk_ul_paramsetid";
    private static final String e = "p3ins_pfk_ul_allowed";
    private static final String f = "p3ins_pfk_db_retry";
    private static final String g = "p3ins_pfk_last_upload_time";
    private static final String h = "p3ins_pfk_guid";
    private static final String i = "P3INS_PFK_GUID_TIMESTAMP";
    private static final String j = "P3INS_PFK_CONNECTIVITY_TEST_TRACEROUTE_ENABLED";
    private static final String k = "P3INS_PFK_CONNECTIVITY_TEST_ENABLED";
    private static final String l = "P3INS_PFK_CONNECTIVITY_KEEPALIVE_ENABLED";
    private static final String m = "P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_CHECK";
    private static final String n = "P3INS_PFK_CONNECTIVITY_TEST_TRUSTSTORE_LAST_MODIFIED";
    private static final String o = "P3INS_PFK_CONNECTIVITY_TEST_TIMESTAMP";
    private static final String p = "P3INS_PFK_APPUSAGE_SERVICE_ENABLED";
    private static final String q = "P3INS_PFK_APPUSAGE_LAST_SCREEN_SESSION_COUNTER";
    private static final String r = "P3INS_PFK_APPUSAGE_BROWSER_SESSION_TRACKING_ENABLED";
    private static final String s = "P3INS_PFK_VOICEMANAGER_PHONENUMBER_RECORD_TYPE";
    private static final String t = "P3INS_PFK_VOICE_SERVICE_ENABLED";
    private static final String u = "P3INS_PFK_MESSAGING_SERVICE_ENABLED";
    private static final String v = "P3INS_PFK_MESSAGINGMANAGER_PHONENUMBER_RECORD_TYPE";
    private static final String w = "P3INS_PFK_COVERAGE_SERVICE_ENABLED";
    private static final String x = "P3INS_PFK_COVERAGE_SERVICE_TRIGGER_PROVIDER_MODE";
    private static final String y = "P3INS_PFK_TRAFFIC_ANALYZER_ENABLED";
    private static final String z = "P3INS_PFK_LAST_EXPORT_TIME";
    private SharedPreferences a;
    private Context b;

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public void run() {
            InsightCore.OnGuidChangedListener onGuidChangedListener = InsightCore.getOnGuidChangedListener();
            if (onGuidChangedListener != null) {
                onGuidChangedListener.OnGuidChanged(this.a);
            }
        }
    }

    public IS(Context context) {
        this.a = context.getSharedPreferences(W, 0);
        this.b = context;
    }

    private boolean R() {
        return this.a.getBoolean(C, false);
    }

    public long A() {
        return this.a.getLong(O, 2147483647L);
    }

    public d B() {
        return a(this.a.getString(v, InsightCore.getInsightConfig().N0().toString()));
    }

    public boolean C() {
        return this.a.getBoolean(u, InsightCore.getInsightConfig().O0());
    }

    public int D() {
        int i2 = this.a.getInt(R, -1);
        if (i2 != -1) {
            return i2;
        }
        int abs = Math.abs(new Random().nextInt());
        this.a.edit().putInt(R, abs).commit();
        return abs;
    }

    public boolean E() {
        return this.a.getBoolean(A, InsightCore.getInsightConfig().g1());
    }

    public long F() {
        return this.a.getLong(B, 0);
    }

    public boolean G() {
        return this.a.getBoolean(D, InsightCore.getInsightConfig().i1());
    }

    public boolean H() {
        return this.a.getBoolean(y, InsightCore.getInsightConfig().u1());
    }

    public long I() {
        return this.a.getLong(n, 0);
    }

    public String J() {
        return this.a.getString(E, "");
    }

    public String K() {
        return this.a.getString(d, "");
    }

    public String L() {
        return this.a.getString(c, "");
    }

    public long M() {
        return this.a.getLong(f, 0);
    }

    public boolean N() {
        return this.a.getBoolean(F, InsightCore.getInsightConfig().W1());
    }

    public d O() {
        return a(this.a.getString(s, InsightCore.getInsightConfig().Q1().toString()));
    }

    public boolean P() {
        return this.a.getBoolean(t, InsightCore.getInsightConfig().T1());
    }

    public boolean Q() {
        return this.a.getBoolean(P, InsightCore.getInsightConfig().l2());
    }

    public boolean S() {
        return this.a.getBoolean(e, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(boolean r12) {
        /*
            r11 = this;
            android.content.SharedPreferences r0 = r11.a
            java.lang.String r1 = "p3ins_pfk_guid"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)
            r1 = 1
            if (r0 == 0) goto L_0x003d
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0014
            goto L_0x003d
        L_0x0014:
            long r2 = com.umlaut.crowd.timeserver.TimeServer.getTimeInMillis()
            android.content.SharedPreferences r4 = r11.a
            java.lang.String r5 = "P3INS_PFK_GUID_TIMESTAMP"
            r6 = 0
            long r4 = r4.getLong(r5, r6)
            long r6 = r11.r()
            r8 = -1
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x002e
            if (r12 == 0) goto L_0x0036
        L_0x002e:
            long r2 = r2 - r4
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x0038
            if (r12 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r12 = 0
            goto L_0x0042
        L_0x0038:
            java.lang.String r0 = r11.a()
            goto L_0x0041
        L_0x003d:
            java.lang.String r0 = r11.a()
        L_0x0041:
            r12 = 1
        L_0x0042:
            if (r12 == 0) goto L_0x0064
            android.os.Handler r12 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r12.<init>(r2)
            com.umlaut.crowd.IS$a r2 = new com.umlaut.crowd.IS$a
            r2.<init>(r0)
            r12.post(r2)
            boolean r12 = r11.G()
            if (r12 == 0) goto L_0x0064
            boolean r12 = r11.R()
            if (r12 == 0) goto L_0x0064
            r11.b((boolean) r1)
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.IS.a(boolean):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        p7 p7Var = new p7(InsightCore.getInsightConfig().f1(), q());
        p7Var.TimeInfoOnRegistration = TimeServer.getTimeInfo();
        p7Var.DeviceInfo = CDC.getDeviceInfo(this.b);
        p7Var.AcceptedTerms = z2;
        if (R()) {
            p7Var.RecurringRegistration = true;
        } else {
            p7Var.RecurringRegistration = false;
            if (z2) {
                c(true);
            }
        }
        InsightCore.getDatabaseHelper().a(w2.REG, (RBR) p7Var);
    }

    public boolean c() {
        return this.a.getBoolean(r, InsightCore.getInsightConfig().c());
    }

    public boolean d() {
        return this.a.getBoolean(p, InsightCore.getInsightConfig().g());
    }

    public boolean e() {
        return this.a.getBoolean(V, InsightCore.getInsightConfig().i());
    }

    public void f(boolean z2) {
        this.a.edit().putBoolean(V, z2).commit();
    }

    public void g(long j2) {
        this.a.edit().putLong(z, j2).commit();
    }

    public boolean getConnectivityTestTracerouteEnabled() {
        return this.a.getBoolean(j, InsightCore.getInsightConfig().Q());
    }

    public void h(boolean z2) {
        this.a.edit().putBoolean(l, z2).commit();
    }

    public void i(long j2) {
        this.a.edit().putLong(g, j2).apply();
    }

    public void j(boolean z2) {
        this.a.edit().putBoolean(w, z2).commit();
    }

    public void k(boolean z2) {
        this.a.edit().putBoolean(u, z2).commit();
    }

    public void l(boolean z2) {
        this.a.edit().putBoolean(A, z2).commit();
    }

    public boolean m() {
        return this.a.getBoolean(l, InsightCore.getInsightConfig().I());
    }

    public boolean n() {
        return this.a.getBoolean(k, InsightCore.getInsightConfig().O());
    }

    public boolean o() {
        return this.a.getBoolean(w, InsightCore.getInsightConfig().h0());
    }

    public void p(boolean z2) {
        this.a.edit().putBoolean(F, z2).commit();
    }

    public String q() {
        return a(false);
    }

    public void r(boolean z2) {
        this.a.edit().putBoolean(P, z2).commit();
    }

    public Set<String> s() {
        return this.a.getStringSet(H, (Set) null);
    }

    public void setConnectivityTestTracerouteEnabled(boolean z2) {
        this.a.edit().putBoolean(j, z2).commit();
    }

    public long t() {
        return this.a.getLong(q, 1);
    }

    public long u() {
        return this.a.getLong(N, 0);
    }

    public long v() {
        return this.a.getLong(S, Long.MAX_VALUE);
    }

    public long w() {
        return this.a.getLong(o, 2147483647L);
    }

    public long x() {
        return this.a.getLong(z, 0);
    }

    public long y() {
        return this.a.getLong(m, 0);
    }

    public long z() {
        return this.a.getLong(g, 0);
    }

    private void c(boolean z2) {
        this.a.edit().putBoolean(C, z2).commit();
    }

    public void d(boolean z2) {
        this.a.edit().putBoolean(r, z2).commit();
    }

    public void e(boolean z2) {
        this.a.edit().putBoolean(p, z2).commit();
    }

    public void f(long j2) {
        this.a.edit().putLong(o, j2).apply();
    }

    public void g(String str) {
        this.a.edit().putString(d, str).commit();
    }

    public void h(String str) {
        this.a.edit().putString(c, str).commit();
    }

    public void i(boolean z2) {
        this.a.edit().putBoolean(k, z2).commit();
    }

    public String[] j() {
        Set<String> stringSet = this.a.getStringSet(I, (Set) null);
        if (stringSet == null || stringSet.isEmpty()) {
            return InsightCore.getInsightConfig().T();
        }
        return (String[]) stringSet.toArray(new String[stringSet.size()]);
    }

    public void k(long j2) {
        this.a.edit().putLong(B, j2).commit();
    }

    public void l(long j2) {
        this.a.edit().putLong(n, j2).commit();
    }

    public void m(boolean z2) {
        this.a.edit().putBoolean(D, z2).commit();
    }

    public void n(boolean z2) {
        this.a.edit().putBoolean(y, z2).commit();
    }

    public void o(boolean z2) {
        this.a.edit().putBoolean(e, z2).commit();
    }

    public CLC.ProviderMode p() {
        return b(this.a.getString(x, InsightCore.getInsightConfig().p0().toString()));
    }

    public void q(boolean z2) {
        this.a.edit().putBoolean(t, z2).commit();
    }

    public long r() {
        return this.a.getLong(T, InsightCore.getInsightConfig().E0());
    }

    public void c(long j2) {
        this.a.edit().putLong(q, j2).apply();
    }

    public void d(Set<String> set) {
        this.a.edit().putStringSet(H, set).commit();
    }

    public void e(String str) {
        this.a.edit().putString(L, str).commit();
    }

    public void f(String str) {
        this.a.edit().putString(E, str).commit();
    }

    public Set<String> g() {
        return this.a.getStringSet(G, (Set) null);
    }

    public void h(long j2) {
        this.a.edit().putLong(m, j2).commit();
    }

    public String i() {
        return this.a.getString(J, InsightCore.getInsightConfig().N().name());
    }

    public String k() {
        return this.a.getString(L, InsightCore.getInsightConfig().I0().name());
    }

    public String[] l() {
        Set<String> stringSet = this.a.getStringSet(K, (Set) null);
        if (stringSet == null || stringSet.isEmpty()) {
            return InsightCore.getInsightConfig().J0();
        }
        return (String[]) stringSet.toArray(new String[stringSet.size()]);
    }

    public void m(long j2) {
        this.a.edit().putLong(f, j2).commit();
    }

    public void c(Set<String> set) {
        this.a.edit().putStringSet(K, set).commit();
    }

    public void d(long j2) {
        this.a.edit().putLong(N, j2).commit();
    }

    public void e(long j2) {
        this.a.edit().putLong(S, j2).commit();
    }

    public boolean f() {
        return this.a.getBoolean(Q, InsightCore.getInsightConfig().s());
    }

    public void g(boolean z2) {
        this.a.edit().putBoolean(Q, z2).commit();
    }

    public long h() {
        return this.a.getLong(M, 0);
    }

    public void c(String str) {
        this.a.edit().putString(U, str).commit();
    }

    public void d(String str) {
        this.a.edit().putString(J, str).commit();
    }

    public void j(long j2) {
        this.a.edit().putLong(O, j2).apply();
    }

    public void b(d dVar) {
        this.a.edit().putString(s, dVar.toString()).commit();
    }

    private CLC.ProviderMode b(String str) {
        CLC.ProviderMode providerMode = CLC.ProviderMode.Gps;
        if (str.equals(providerMode.toString())) {
            return providerMode;
        }
        CLC.ProviderMode providerMode2 = CLC.ProviderMode.GpsAndNetwork;
        if (str.equals(providerMode2.toString())) {
            return providerMode2;
        }
        CLC.ProviderMode providerMode3 = CLC.ProviderMode.Network;
        if (str.equals(providerMode3.toString())) {
            return providerMode3;
        }
        CLC.ProviderMode providerMode4 = CLC.ProviderMode.Passive;
        if (str.equals(providerMode4.toString())) {
            return providerMode4;
        }
        CLC.ProviderMode providerMode5 = CLC.ProviderMode.RailNet;
        if (str.equals(providerMode5.toString())) {
            return providerMode5;
        }
        return null;
    }

    public void b(Set<String> set) {
        this.a.edit().putStringSet(I, set).commit();
    }

    public void b(long j2) {
        this.a.edit().putLong(T, j2).commit();
    }

    public String b() {
        return this.a.getString(U, "");
    }

    private String a() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(h, replace);
        edit.putLong(i, TimeServer.getTimeInMillis());
        edit.commit();
        return replace;
    }

    public void a(d dVar) {
        this.a.edit().putString(v, dVar.toString()).commit();
    }

    private d a(String str) {
        d dVar = d.Anonymized;
        if (str.equals(dVar.toString())) {
            return dVar;
        }
        d dVar2 = d.Full;
        if (str.equals(dVar2.toString())) {
            return dVar2;
        }
        d dVar3 = d.None;
        str.equals(dVar3.toString());
        return dVar3;
    }

    public void a(Set<String> set) {
        this.a.edit().putStringSet(G, set).commit();
    }

    public void a(long j2) {
        this.a.edit().putLong(M, j2).commit();
    }
}
