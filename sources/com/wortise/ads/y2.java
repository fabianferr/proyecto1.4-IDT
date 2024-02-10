package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.wortise.ads.api.submodels.UserLocation;
import com.wortise.ads.geofencing.models.GeofenceEvent;
import com.wortise.ads.geofencing.models.GeofenceTransition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/wortise/ads/y2;", "", "Landroid/content/Context;", "context", "Lcom/google/android/gms/location/GeofencingEvent;", "event", "Lcom/wortise/ads/geofencing/models/GeofenceEvent;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofenceEventFactory.kt */
public final class y2 {
    public static final y2 a = new y2();

    private y2() {
    }

    public final GeofenceEvent a(Context context, GeofencingEvent geofencingEvent) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(geofencingEvent, "event");
        GeofenceTransition a2 = d3.a.a(geofencingEvent.getGeofenceTransition());
        List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();
        UserLocation userLocation = null;
        if (triggeringGeofences == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Geofence requestId : triggeringGeofences) {
                String requestId2 = requestId.getRequestId();
                if (requestId2 != null) {
                    arrayList.add(requestId2);
                }
            }
        }
        Location triggeringLocation = geofencingEvent.getTriggeringLocation();
        if (triggeringLocation != null) {
            userLocation = v6.a.a(context, triggeringLocation, false);
        }
        return new GeofenceEvent(a2, arrayList, userLocation);
    }
}
