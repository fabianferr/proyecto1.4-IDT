package com.wortise.ads;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/k6;", "", "", "id", "I", "b", "()I", "<init>", "(Ljava/lang/String;II)V", "PRECISE_GEOLOCATION", "SCAN_DEVICE_CHARACTERISTICS", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: TcfSpecialFeature.kt */
public enum k6 {
    PRECISE_GEOLOCATION(1),
    SCAN_DEVICE_CHARACTERISTICS(2);
    
    private final int a;

    private k6(int i) {
        this.a = i;
    }

    public final int b() {
        return this.a;
    }
}
