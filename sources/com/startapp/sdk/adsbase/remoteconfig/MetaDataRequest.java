package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.startapp.a;
import com.startapp.a0;
import com.startapp.i3;
import com.startapp.k9;
import com.startapp.r6;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.common.Constants;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.common.utils.Pair;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u1;
import com.startapp.w0;
import java.util.Map;

/* compiled from: Sta */
public class MetaDataRequest extends w0 {
    public final e j0;
    public int k0;
    public int l0 = b();
    public boolean m0;
    public float n0;
    public RequestReason o0;
    public String p0;
    public String q0;
    public Integer r0;
    public Pair<String, String> s0;
    public Integer t0;
    public Boolean u0;
    public long v0;

    /* compiled from: Sta */
    public enum RequestReason {
        LAUNCH(1),
        APP_IDLE(2),
        IN_APP_PURCHASE(3),
        CUSTOM(4),
        PERIODIC(5),
        PAS(6),
        CONSENT(7),
        IMPLICIT_LAUNCH(8),
        EXTRAS(9);
        
        private int index;

        /* access modifiers changed from: public */
        RequestReason(int i) {
            this.index = i;
        }
    }

    public MetaDataRequest(Context context, e eVar, RequestReason requestReason) {
        super(2);
        this.j0 = eVar;
        this.k0 = eVar.getInt("totalSessions", 0);
        this.n0 = eVar.getFloat("inAppPurchaseAmount", 0.0f);
        this.m0 = eVar.getBoolean("payingUser", false);
        this.p0 = MetaData.w().F();
        this.o0 = requestReason;
        this.q0 = a(context, eVar, StartAppSDKInternal.a().b());
        f(context);
        this.s0 = SimpleTokenUtils.a();
        this.v0 = SimpleTokenUtils.c();
        u1 g = ComponentLocator.a(context).g();
        this.t0 = g.b();
        this.u0 = g.a();
        a(ComponentLocator.a(context).b().a());
    }

    public void a(r6 r6Var) throws SDKException {
        super.a(r6Var);
        r6Var.a(a.b, (Object) a.a(), true, true);
        r6Var.a("totalSessions", (Object) Integer.valueOf(this.k0), true, true);
        r6Var.a("daysSinceFirstSession", (Object) Integer.valueOf(this.l0), true, true);
        r6Var.a("payingUser", (Object) Boolean.valueOf(this.m0), true, true);
        r6Var.a("profileId", (Object) this.p0, false, true);
        r6Var.a("paidAmount", (Object) Float.valueOf(this.n0), true, true);
        r6Var.a(IronSourceConstants.EVENTS_ERROR_REASON, (Object) this.o0, true, true);
        r6Var.a(UserDataStore.CITY, (Object) this.t0, false, true);
        r6Var.a("apc", (Object) this.u0, false, true);
        Object obj = StartAppSDKInternal.E;
        r6Var.a("testAdsEnabled", (Object) StartAppSDKInternal.d.a.D ? Boolean.TRUE : null, false, true);
        r6Var.a("apkHash", (Object) this.q0, false, true);
        r6Var.a("ian", (Object) this.r0, false, true);
        Pair<String, String> pair = this.s0;
        r6Var.a((String) pair.first, (Object) pair.second, false, true);
        long j = this.v0;
        if (j != 0) {
            r6Var.a("firstInstalledAppTS", (Object) Long.valueOf(j), false, true);
        }
    }

    public final int b() {
        return (int) ((System.currentTimeMillis() - this.j0.getLong("firstSessionTime", System.currentTimeMillis())) / 86400000);
    }

    public void f(Context context) {
        SimpleTokenConfig K = MetaData.k.K();
        if (K != null && K.a(context)) {
            int i = a0.a;
            int i2 = 0;
            try {
                for (PackageInfo next : a0.a(context.getPackageManager())) {
                    if (!a0.a(next) || next.packageName.equals(Constants.a)) {
                        i2++;
                    }
                }
            } catch (Throwable unused) {
            }
            if (i2 > 0) {
                this.r0 = Integer.valueOf(i2);
            }
        }
    }

    public static String a(Context context, e eVar, boolean z) {
        String str = null;
        String string = eVar.getString("shared_prefs_app_apk_hash", (String) null);
        if (!TextUtils.isEmpty(string) && !z) {
            return string;
        }
        Map<Activity, Integer> map = k9.a;
        try {
            str = a0.a("SHA-256", context);
        } catch (Throwable th) {
            i3.a(th);
        }
        e.a a = eVar.edit();
        a.a("shared_prefs_app_apk_hash", str);
        a.a.putString("shared_prefs_app_apk_hash", str);
        a.apply();
        return str;
    }
}
