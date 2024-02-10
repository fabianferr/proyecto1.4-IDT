package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.k;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.cast.MediaError;
import java.util.List;
import java.util.Map;

public class u {
    private final m a;

    u(final m mVar) {
        this.a = mVar;
        if (!mVar.e()) {
            a("SDK Session Begin");
            mVar.aj().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    u.this.a("SDK Session End");
                    mVar.aj().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        k kVar = new k();
        kVar.a().a(str).a();
        f("AppLovinSdk", kVar.toString());
    }

    private void a(String str, String str2, boolean z) {
        int intValue;
        if (StringUtils.isValidString(str2) && (intValue = ((Integer) this.a.a(b.aj)).intValue()) > 0) {
            int length = str2.length();
            int i = ((length + intValue) - 1) / intValue;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * intValue;
                String substring = str2.substring(i3, Math.min(length, i3 + intValue));
                if (z) {
                    Log.d(str, substring);
                } else {
                    b(str, substring);
                }
            }
        }
    }

    public static boolean a() {
        List<AppLovinSdk> a2 = AppLovinSdk.a();
        if (a2.isEmpty()) {
            return false;
        }
        AppLovinSdk appLovinSdk = a2.get(0);
        return appLovinSdk == null || a(appLovinSdk.coreSdk);
    }

    public static boolean a(m mVar) {
        return mVar != null && mVar.K().d();
    }

    public static void c(String str, String str2, Throwable th) {
        Log.e("AppLovinSdk", "[" + str + "] " + str2, th);
    }

    public static void f(String str, String str2) {
        Log.d("AppLovinSdk", "[" + str + "] " + str2);
    }

    public static void g(String str, String str2) {
        Log.i("AppLovinSdk", "[" + str + "] " + str2);
    }

    public static void h(String str, String str2) {
        Log.w("AppLovinSdk", "[" + str + "] " + str2);
    }

    public static void i(String str, String str2) {
        c(str, str2, (Throwable) null);
    }

    private void j(String str, String str2) {
    }

    public void a(String str, String str2) {
        if (a(this.a)) {
            a(str, str2, false);
        }
    }

    public void a(String str, String str2, Throwable th) {
        if (a(this.a)) {
            String str3 = "[" + str + "] " + str2;
            Log.w("AppLovinSdk", str3, th);
            j("WARN", str3);
        }
    }

    public void b(String str, String str2) {
        if (a(this.a)) {
            String str3 = "[" + str + "] " + str2;
            Log.d("AppLovinSdk", str3);
            j("DEBUG", str3);
        }
    }

    public void b(String str, String str2, Throwable th) {
        if (a(this.a)) {
            String str3 = "[" + str + "] " + str2;
            Log.e("AppLovinSdk", str3, th);
            j(MediaError.ERROR_TYPE_ERROR, str3 + " : " + th);
        }
    }

    public void c(String str, String str2) {
        if (a(this.a)) {
            String str3 = "[" + str + "] " + str2;
            Log.i("AppLovinSdk", str3);
            j("INFO", str3);
        }
    }

    public void d(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    public void e(String str, String str2) {
        b(str, str2, (Throwable) null);
    }
}
