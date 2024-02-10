package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/f3;", "Lcom/wortise/ads/p5;", "", "adUnitId", "", "interval", "<init>", "(Ljava/lang/String;J)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeosmartJobInfo.kt */
public final class f3 extends p5 {
    @SerializedName("adUnitId")
    private final String c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f3(String str, long j) {
        super(j);
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        this.c = str;
    }
}
