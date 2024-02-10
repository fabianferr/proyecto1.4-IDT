package com.startapp.sdk.adsbase.model;

import android.app.Activity;
import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.UserDataStore;
import com.startapp.a;
import com.startapp.e0;
import com.startapp.f;
import com.startapp.k9;
import com.startapp.r6;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.SDKAdPreferences;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.common.utils.Pair;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.t7;
import com.startapp.u1;
import com.startapp.u7;
import com.startapp.w0;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: Sta */
public class GetAdRequest extends w0 {
    public boolean A0 = true;
    public boolean B0;
    public int C0 = 0;
    public Set<String> D0 = null;
    public Set<String> E0 = null;
    public Set<String> F0 = null;
    public Set<String> G0 = null;
    public Set<String> H0 = null;
    public Pair<String, String> I0;
    public boolean J0 = true;
    public long K0;
    public int L0;
    public String M0;
    public String N0;
    public String O0;
    public boolean P0;
    public Boolean Q0;
    public Boolean R0;
    public String S0;
    public Ad.AdType T0 = null;
    public AdPreferences.Placement j0;
    public String k0;
    public boolean l0;
    public boolean m0;
    public Integer n0;
    public Long o0;
    public Boolean p0;
    public SDKAdPreferences.Gender q0;
    public String r0;
    public int s0 = 1;
    public boolean t0 = true;
    public Boolean u0;
    public boolean v0 = AdsCommonMetaData.k().M();
    public Double w0;
    public String x0;
    public String y0;
    public Integer z0;

    /* compiled from: Sta */
    public enum VideoRequestMode {
        INTERSTITIAL,
        REWARDED
    }

    /* compiled from: Sta */
    public enum VideoRequestType {
        ENABLED,
        DISABLED,
        FORCED,
        FORCED_NONVAST
    }

    public GetAdRequest() {
        super(4);
        long currentTimeMillis = System.currentTimeMillis();
        t7 t7Var = t7.d;
        this.K0 = currentTimeMillis - t7.d.b();
        Map<Activity, Integer> map = k9.a;
        this.L0 = f.a().b();
        this.M0 = MetaData.w().F();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e8, code lost:
        if (r3 == false) goto L_0x00eb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r3, com.startapp.sdk.adsbase.model.AdPreferences r4, com.startapp.sdk.adsbase.model.AdPreferences.Placement r5, com.startapp.sdk.common.utils.Pair<java.lang.String, java.lang.String> r6) {
        /*
            r2 = this;
            r2.j0 = r5
            java.lang.String r5 = r4.getPlacementId()
            r2.k0 = r5
            r2.I0 = r6
            java.lang.Boolean r5 = r4.getAi()
            r2.Q0 = r5
            java.lang.Boolean r5 = r4.getAs()
            r2.R0 = r5
            com.startapp.sdk.adsbase.SDKAdPreferences$Gender r5 = r4.getGender(r3)
            r2.q0 = r5
            java.lang.String r5 = r4.getKeywords()
            r2.r0 = r5
            boolean r5 = r4.isTestMode()
            r2.l0 = r5
            java.util.Set r5 = r4.getCategories()
            r2.D0 = r5
            java.util.Set r5 = r4.getCategoriesExclude()
            r2.E0 = r5
            boolean r5 = r4.b()
            r2.t0 = r5
            java.lang.Integer r5 = r4.a()
            r2.z0 = r5
            int r5 = com.startapp.a0.a
            android.content.ContentResolver r5 = r3.getContentResolver()
            java.lang.String r6 = "auto_time"
            r0 = 0
            int r5 = android.provider.Settings.Global.getInt(r5, r6, r0)
            r6 = 1
            if (r5 <= 0) goto L_0x0052
            r5 = 1
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r2.u0 = r5
            java.lang.Double r5 = r4.getMinCpm()
            r2.w0 = r5
            java.lang.String r5 = r4.getAdTag()
            r2.x0 = r5
            java.lang.Object r5 = com.startapp.sdk.adsbase.remoteconfig.MetaData.d
            java.lang.String r5 = "StartappMetadata"
            java.io.File r5 = r3.getFileStreamPath(r5)
            boolean r5 = r5.exists()
            r5 = r5 ^ r6
            r2.A0 = r5
            com.startapp.sdk.adsbase.Ad$AdType r5 = r4.type
            r2.T0 = r5
            java.lang.String r5 = r4.getCustomProductId()
            r2.b = r5
            com.startapp.sdk.adsbase.AdsCommonMetaData r5 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            com.startapp.sdk.adsbase.VideoConfig r5 = r5.G()
            if (r5 == 0) goto L_0x0097
            java.lang.String r1 = r5.l()
            if (r1 == 0) goto L_0x0097
            java.lang.String r5 = r5.l()
            java.lang.String r1 = "muted"
            boolean r5 = r5.equals(r1)
            goto L_0x0098
        L_0x0097:
            r5 = 0
        L_0x0098:
            if (r5 != 0) goto L_0x00b8
            java.lang.String r5 = "audio"
            java.lang.Object r5 = r3.getSystemService(r5)     // Catch:{ all -> 0x00b3 }
            boolean r1 = r5 instanceof android.media.AudioManager     // Catch:{ all -> 0x00b3 }
            if (r1 == 0) goto L_0x00ba
            android.media.AudioManager r5 = (android.media.AudioManager) r5     // Catch:{ all -> 0x00b3 }
            r1 = 3
            int r5 = r5.getStreamVolume(r1)     // Catch:{ all -> 0x00b3 }
            if (r5 <= 0) goto L_0x00af
            r5 = 1
            goto L_0x00b0
        L_0x00af:
            r5 = 0
        L_0x00b0:
            r2.B0 = r5     // Catch:{ all -> 0x00b3 }
            goto L_0x00ba
        L_0x00b3:
            r5 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r5)
            goto L_0x00ba
        L_0x00b8:
            r2.B0 = r0
        L_0x00ba:
            java.lang.Object r5 = com.startapp.sdk.adsbase.StartAppSDKInternal.E     // Catch:{ all -> 0x00ed }
            com.startapp.sdk.adsbase.StartAppSDKInternal r5 = com.startapp.sdk.adsbase.StartAppSDKInternal.d.a     // Catch:{ all -> 0x00ed }
            boolean r5 = r5.D     // Catch:{ all -> 0x00ed }
            if (r5 != 0) goto L_0x00ea
            com.startapp.sdk.components.ComponentLocator r3 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r3)     // Catch:{ all -> 0x00ed }
            com.startapp.n4<com.startapp.d> r3 = r3.L     // Catch:{ all -> 0x00ed }
            java.lang.Object r3 = r3.a()     // Catch:{ all -> 0x00ed }
            com.startapp.d r3 = (com.startapp.d) r3     // Catch:{ all -> 0x00ed }
            com.startapp.i2<com.startapp.sdk.adsbase.remoteconfig.AdDebuggerMetadata> r5 = r3.c     // Catch:{ all -> 0x00ed }
            java.lang.Object r5 = r5.a()     // Catch:{ all -> 0x00ed }
            com.startapp.sdk.adsbase.remoteconfig.AdDebuggerMetadata r5 = (com.startapp.sdk.adsbase.remoteconfig.AdDebuggerMetadata) r5     // Catch:{ all -> 0x00ed }
            if (r5 != 0) goto L_0x00d9
            goto L_0x00e7
        L_0x00d9:
            boolean r3 = r3.a()     // Catch:{ all -> 0x00ed }
            if (r3 == 0) goto L_0x00e7
            boolean r3 = r5.c()     // Catch:{ all -> 0x00ed }
            if (r3 == 0) goto L_0x00e7
            r3 = 1
            goto L_0x00e8
        L_0x00e7:
            r3 = 0
        L_0x00e8:
            if (r3 == 0) goto L_0x00eb
        L_0x00ea:
            r0 = 1
        L_0x00eb:
            r2.m0 = r0     // Catch:{ all -> 0x00ed }
        L_0x00ed:
            java.util.Set<java.lang.String> r3 = r4.packageInclude
            r2.G0 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.model.GetAdRequest.a(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences, com.startapp.sdk.adsbase.model.AdPreferences$Placement, com.startapp.sdk.common.utils.Pair):void");
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        Ad.AdType adType = this.T0;
        return adType == Ad.AdType.VIDEO || adType == Ad.AdType.REWARDED_VIDEO;
    }

    public void f(Context context) {
        String str;
        u7 u = ComponentLocator.a(context).u();
        AdPreferences.Placement placement = this.j0;
        if (placement == null) {
            str = null;
        } else {
            str = u.a.get(new u7.a(placement, -1));
        }
        this.y0 = str;
    }

    public void g(Context context) {
        u1 g = ComponentLocator.a(context).g();
        this.n0 = g.b();
        this.o0 = (!g.d() || !g.b.contains("consentTimestamp")) ? null : Long.valueOf(g.b.getLong("consentTimestamp", 0));
        this.p0 = g.a();
    }

    public void a(r6 r6Var) throws SDKException {
        super.a(r6Var);
        r6Var.a("placement", (Object) this.j0.name(), true, true);
        r6Var.a("placementId", (Object) this.k0, false, true);
        r6Var.a("testMode", (Object) Boolean.toString(this.l0), false, true);
        r6Var.a("gender", (Object) this.q0, false, true);
        r6Var.a("keywords", (Object) this.r0, false, true);
        r6Var.a("adsNumber", (Object) Integer.toString(this.s0), false, true);
        r6Var.a("category", this.D0, false, true);
        r6Var.a("categoryExclude", this.E0, false, true);
        r6Var.a("packageExclude", this.F0, false, true);
        r6Var.a("campaignExclude", this.H0, false, true);
        r6Var.a(TypedValues.CycleType.S_WAVE_OFFSET, (Object) Integer.toString(this.C0), false, true);
        r6Var.a("ai", (Object) this.Q0, false, true);
        r6Var.a("as", (Object) this.R0, false, true);
        Double d = this.w0;
        Map<Activity, Integer> map = k9.a;
        r6Var.a("minCPM", (Object) d != null ? String.format(Locale.US, "%.2f", new Object[]{d}) : null, false, true);
        r6Var.a("adTag", (Object) this.x0, false, true);
        r6Var.a("previousAdId", (Object) this.y0, false, true);
        r6Var.a("twoClicks", (Object) Boolean.valueOf(!this.v0), false, true);
        r6Var.a("engInclude", (Object) Boolean.toString(this.J0), false, true);
        Ad.AdType adType = this.T0;
        if (adType == Ad.AdType.INTERSTITIAL || adType == Ad.AdType.RICH_TEXT) {
            r6Var.a("type", (Object) adType, false, true);
        }
        r6Var.a("timeSinceSessionStart", (Object) Long.valueOf(this.K0), true, true);
        r6Var.a("adsDisplayed", (Object) Integer.valueOf(this.L0), true, true);
        r6Var.a("profileId", (Object) this.M0, false, true);
        r6Var.a("hardwareAccelerated", (Object) Boolean.valueOf(this.t0), false, true);
        r6Var.a("autoLoadAmount", (Object) this.z0, false, true);
        r6Var.a("dts", (Object) this.u0, false, true);
        r6Var.a("downloadingMode", (Object) "CACHE", false, true);
        r6Var.a("primaryImg", (Object) this.N0, false, true);
        r6Var.a("moreImg", (Object) this.O0, false, true);
        r6Var.a("contentAd", (Object) Boolean.toString(this.P0), false, true);
        r6Var.a(UserDataStore.CITY, (Object) this.n0, false, true);
        r6Var.a("tsc", (Object) this.o0, false, true);
        r6Var.a("apc", (Object) this.p0, false, true);
        if (this.m0) {
            r6Var.a("testAdsEnabled", (Object) Boolean.TRUE, false, true);
        }
        String a = a.a();
        r6Var.a(a.b, (Object) a, true, true);
        String str = a.d;
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append(this.j0.name());
        String str2 = this.Q;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(this.c);
        sb.append(a);
        r6Var.a(str, (Object) a.a(sb.toString()), true, false);
        r6Var.a("sound", (Object) Boolean.valueOf(this.B0), false, true);
        Set<String> set = this.G0;
        if (set != null) {
            r6Var.a("packageInclude", set, false, true);
        }
        r6Var.a("defaultMetaData", (Object) Boolean.valueOf(this.A0), true, true);
        Pair<String, String> pair = this.I0;
        r6Var.a((String) pair.first, (Object) pair.second, false, true);
        String str3 = this.S0;
        if (str3 != null) {
            r6Var.a("trv", (Object) str3, false, false);
        }
        e0 e0Var = this.g0;
        if (e0Var != null) {
            Integer num = e0Var.c.get(this.j0);
            int intValue = num != null ? num.intValue() : 0;
            if (intValue > 0) {
                r6Var.a("adsDisplayed", (Object) Integer.valueOf(intValue), false, false);
            }
        }
    }
}
