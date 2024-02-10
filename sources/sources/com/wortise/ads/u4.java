package com.wortise.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wortise.ads.location.models.LocationData;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/wortise/ads/u4;", "", "Landroid/content/Context;", "context", "Landroid/location/Location;", "a", "location", "", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: LocationStore.kt */
public final class u4 {
    public static final u4 a = new u4();

    private u4() {
    }

    public final Location a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            WortiseLog.d$default("Loading last location from preferences...", (Throwable) null, 2, (Object) null);
            LocationData locationData = (LocationData) g6.a(r5.a.a(context), "lastLocation", Reflection.getOrCreateKotlinClass(LocationData.class));
            if (locationData == null) {
                return null;
            }
            return locationData.j();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final boolean a(Context context, Location location) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(location, FirebaseAnalytics.Param.LOCATION);
        try {
            WortiseLog.d$default("Saving last location to preferences...", (Throwable) null, 2, (Object) null);
            Location a2 = a.a(context);
            if (a2 == null || a2.getTime() <= location.getTime()) {
                SharedPreferences.Editor edit = r5.a.a(context).edit();
                g6.a(edit, "lastLocation", new LocationData(location), (Type) null, 4, (Object) null);
                edit.apply();
                return true;
            }
            WortiseLog.d$default("Not saved. Stored location has a greater timestamp", (Throwable) null, 2, (Object) null);
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
