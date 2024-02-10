package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/v4;", "Lcom/wortise/ads/e2;", "Landroid/content/Context;", "context", "", "extras", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: LogRequest.kt */
public final class v4 extends e2 {
    @SerializedName("extras")
    private final Object m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v4(Context context, Object obj) {
        super(context, (Location) null, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.m = obj;
    }
}
