package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.Context;
import com.startapp.d9;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public class SplashMetaData implements Serializable {
    public static volatile SplashMetaData a = new SplashMetaData();
    public static final Object b = new Object();
    private static final long serialVersionUID = 5949259263399692883L;
    @d9(complex = true)
    private SplashConfig SplashConfig = new SplashConfig();
    private String splashMetadataUpdateVersion = "4.11.0";

    public SplashConfig a() {
        return this.SplashConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SplashMetaData splashMetaData = (SplashMetaData) obj;
        if (!k9.a(this.SplashConfig, splashMetaData.SplashConfig) || !k9.a(this.splashMetadataUpdateVersion, splashMetaData.splashMetadataUpdateVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.SplashConfig, this.splashMetadataUpdateVersion};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public static void a(Context context, SplashMetaData splashMetaData) {
        synchronized (b) {
            splashMetaData.splashMetadataUpdateVersion = "4.11.0";
            a = splashMetaData;
            f2.a(context, "StartappSplashMetadata", (Serializable) splashMetaData);
        }
    }

    public static void a(Context context) {
        SplashMetaData splashMetaData = (SplashMetaData) f2.a(context, "StartappSplashMetadata", SplashMetaData.class);
        SplashMetaData splashMetaData2 = new SplashMetaData();
        if (splashMetaData != null) {
            boolean b2 = k9.b(splashMetaData, splashMetaData2);
            if (!(!"4.11.0".equals(splashMetaData.splashMetadataUpdateVersion)) && b2) {
                i3 i3Var = new i3(j3.e);
                i3Var.d = "metadata_null";
                i3Var.a();
            }
            a = splashMetaData;
            return;
        }
        a = splashMetaData2;
    }
}
