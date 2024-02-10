package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.AdDebuggerMetadata;
import com.startapp.sdk.common.advertisingid.AdvertisingIdResolver;
import java.util.Set;

/* compiled from: Sta */
public class d {
    public final Context a;
    public final n4<AdvertisingIdResolver> b;
    public final i2<AdDebuggerMetadata> c;

    public d(Context context, n4<AdvertisingIdResolver> n4Var, i2<AdDebuggerMetadata> i2Var) {
        this.a = context;
        this.b = n4Var;
        this.c = i2Var;
    }

    public boolean a() {
        Set<String> a2;
        AdDebuggerMetadata a3 = this.c.a();
        if (a3 == null || (a2 = a3.a()) == null) {
            return false;
        }
        return a2.contains(this.b.a().a().a);
    }
}
