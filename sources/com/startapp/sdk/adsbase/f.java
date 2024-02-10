package com.startapp.sdk.adsbase;

import android.content.Context;
import android.text.TextUtils;
import com.startapp.a3;
import com.startapp.g2;
import com.startapp.i3;
import com.startapp.k9;
import com.startapp.n7;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z5;

/* compiled from: Sta */
public class f implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ComponentLocator b;
    public final /* synthetic */ e c;

    public f(StartAppSDKInternal startAppSDKInternal, Context context, ComponentLocator componentLocator, e eVar) {
        this.a = context;
        this.b = componentLocator;
        this.c = eVar;
    }

    public void run() {
        a3 m;
        Boolean bool;
        z5.a aVar;
        try {
            n7 n7Var = new n7(this.a);
            n7Var.a(this.a, new AdPreferences());
            m = this.b.m();
            StringBuilder sb = new StringBuilder();
            MetaData metaData = MetaData.k;
            String str = metaData.trackDownloadHost;
            if (str == null) {
                str = metaData.d();
            }
            sb.append(str);
            sb.append(AdsConstants.c);
            bool = null;
            aVar = m.a(sb.toString(), n7Var, (g2<Throwable, Void>) null);
        } catch (Throwable th) {
            i3.a(th);
            return;
        }
        if (aVar != null) {
            String str2 = aVar.b;
            if (!TextUtils.isEmpty(str2)) {
                String a2 = k9.a(str2, "@ct@", "@ct@");
                String a3 = k9.a(str2, "@tsc@", "@tsc@");
                String a4 = k9.a(str2, "@apc@", "@apc@");
                try {
                    Integer valueOf = !TextUtils.isEmpty(a2) ? Integer.valueOf(Integer.parseInt(a2)) : null;
                    Long valueOf2 = !TextUtils.isEmpty(a3) ? Long.valueOf(Long.parseLong(a3)) : null;
                    if (!TextUtils.isEmpty(a4)) {
                        bool = Boolean.valueOf(Boolean.parseBoolean(a4));
                    }
                    Boolean bool2 = bool;
                    if (!(valueOf == null && valueOf2 == null && bool2 == null)) {
                        this.b.g().a(valueOf, valueOf2, bool2, false, true);
                    }
                } catch (Throwable th2) {
                    i3.a(th2);
                }
            }
        }
        e.a a5 = this.c.edit();
        a5.a("shared_prefs_first_init", Boolean.FALSE);
        a5.a.putBoolean("shared_prefs_first_init", false);
        a5.apply();
    }
}
