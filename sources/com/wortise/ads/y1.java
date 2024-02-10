package com.wortise.ads;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wortise/ads/y1;", "", "", "GEOFENCE_EXPIRATION_IN_MILLISECONDS", "J", "a", "()J", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Constants.kt */
public final class y1 {
    public static final y1 a = new y1();
    private static final long b = TimeUnit.HOURS.toMillis(24);

    private y1() {
    }

    public final long a() {
        return b;
    }
}
