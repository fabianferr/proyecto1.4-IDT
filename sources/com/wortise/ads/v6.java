package com.wortise.ads;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.wortise.ads.api.submodels.UserLocation;
import com.wortise.ads.consent.ConsentManager;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0005\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J$\u0010\u0005\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/v6;", "", "Landroid/content/Context;", "context", "", "a", "", "latitude", "longitude", "Landroid/location/Address;", "Landroid/location/Location;", "value", "reverse", "Lcom/wortise/ads/api/submodels/UserLocation;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserLocationFactory.kt */
public final class v6 {
    public static final v6 a = new v6();

    private v6() {
    }

    public final UserLocation a(Context context, Location location, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        try {
            v6 v6Var = a;
            if (v6Var.a(context2)) {
                Location a2 = location == null ? t4.a(t4.a, context, 0, 2, (Object) null) : location;
                if (a2 != null) {
                    double latitude = a2.getLatitude();
                    double longitude = a2.getLongitude();
                    Address a3 = z ? v6Var.a(context, latitude, longitude) : null;
                    UserLocation.Accuracy accuracy = new UserLocation.Accuracy(Float.valueOf(a2.getAccuracy()), s4.b(a2));
                    UserLocation.Speed speed = new UserLocation.Speed(s4.a(a2), a2.getSpeed());
                    if (a3 == null) {
                        str = null;
                    } else {
                        str = a3.getAdminArea();
                    }
                    Double valueOf = Double.valueOf(a2.getAltitude());
                    Float valueOf2 = Float.valueOf(a2.getBearing());
                    if (a3 == null) {
                        str2 = null;
                    } else {
                        str2 = a3.getLocality();
                    }
                    if (a3 == null) {
                        str3 = null;
                    } else {
                        str3 = a3.getCountryCode();
                    }
                    Date date = new Date(a2.getTime());
                    if (a3 == null) {
                        str4 = null;
                    } else {
                        str4 = a3.getFeatureName();
                    }
                    if (a3 == null) {
                        str5 = null;
                    } else {
                        str5 = a3.getPostalCode();
                    }
                    String provider = a2.getProvider();
                    if (a3 == null) {
                        str6 = null;
                    } else {
                        str6 = a3.getSubAdminArea();
                    }
                    if (a3 == null) {
                        str7 = null;
                    } else {
                        str7 = a3.getSubLocality();
                    }
                    if (a3 == null) {
                        str8 = null;
                    } else {
                        str8 = a3.getSubThoroughfare();
                    }
                    if (a3 == null) {
                        str9 = null;
                    } else {
                        str9 = a3.getThoroughfare();
                    }
                    return new UserLocation(accuracy, str, valueOf, valueOf2, str2, str3, date, str4, latitude, longitude, str5, provider, speed, str6, str7, str8, str9);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable unused) {
            return null;
        }
    }

    private final boolean a(Context context) {
        l6 a2 = t1.a(ConsentManager.INSTANCE, context);
        if (a2 != null && !a2.a(k6.PRECISE_GEOLOCATION)) {
            return false;
        }
        return ConsentManager.canCollectData(context);
    }

    private final Address a(Context context, double d, double d2) {
        try {
            List<Address> fromLocation = new Geocoder(context, Locale.US).getFromLocation(d, d2, 1);
            Intrinsics.checkNotNullExpressionValue(fromLocation, "Geocoder(context, Locale…n(latitude, longitude, 1)");
            return (Address) CollectionsKt.firstOrNull(fromLocation);
        } catch (Throwable unused) {
            return null;
        }
    }
}
