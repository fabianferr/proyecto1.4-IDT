package com.wortise.ads;

import android.content.Context;
import android.content.ContextWrapper;
import android.location.LocationManager;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/m2;", "Landroid/content/ContextWrapper;", "", "a", "()Z", "hasBackgroundLocation", "b", "hasCoarseLocation", "c", "hasGpsLocation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DeviceCapabilities.kt */
public final class m2 extends ContextWrapper {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m2(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT < 29 || b2.a((Context) this, "android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final boolean b() {
        return b2.a((Context) this, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public final boolean c() {
        if (!b2.a((Context) this, "android.permission.ACCESS_FINE_LOCATION")) {
            return false;
        }
        Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (!(systemService instanceof LocationManager)) {
            systemService = null;
        }
        LocationManager locationManager = (LocationManager) systemService;
        if (locationManager != null && locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }
}
