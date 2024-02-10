package com.wortise.ads;

import com.wortise.ads.geofencing.models.GeofenceTransition;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/d3;", "", "", "transition", "Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeofenceTransitionFactory.kt */
public final class d3 {
    public static final d3 a = new d3();

    private d3() {
    }

    public final GeofenceTransition a(int i) {
        for (GeofenceTransition geofenceTransition : GeofenceTransition.values()) {
            if (geofenceTransition.getValue() == i) {
                return geofenceTransition;
            }
        }
        return null;
    }
}
