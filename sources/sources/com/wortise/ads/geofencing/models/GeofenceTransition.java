package com.wortise.ads.geofencing.models;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/geofencing/models/GeofenceTransition;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ANY", "DWELL", "ENTER", "EXIT", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GeofenceTransition.kt */
public enum GeofenceTransition {
    ANY(3),
    DWELL(4),
    ENTER(1),
    EXIT(2);
    
    private final int value;

    private GeofenceTransition(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
