package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.identifier.IdentifierType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0016\u0010\u0017B'\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u0016\u0010\u001eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X.¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\f\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/wortise/ads/e2;", "Lcom/wortise/ads/d2;", "Lcom/wortise/ads/h4;", "", "assetKey", "Ljava/lang/String;", "getAssetKey", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "auid", "getAuid", "a", "udid", "getUdid", "b", "Lcom/wortise/ads/identifier/IdentifierType;", "udidType", "Lcom/wortise/ads/identifier/IdentifierType;", "getUdidType", "()Lcom/wortise/ads/identifier/IdentifierType;", "(Lcom/wortise/ads/identifier/IdentifierType;)V", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/location/Location;", "location", "", "collectApps", "(Landroid/content/Context;Landroid/location/Location;Z)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DataRequest.kt */
public class e2 extends d2 implements h4 {
    @SerializedName("assetKey")
    private String i;
    @SerializedName("auid")
    public String j;
    @SerializedName("udid")
    private String k;
    @SerializedName("udidType")
    private IdentifierType l;

    public e2() {
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.j = str;
    }

    public void b(String str) {
        this.k = str;
    }

    public void c(String str) {
        this.i = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e2(Context context, Location location, boolean z) {
        super(context, location, z);
        Intrinsics.checkNotNullParameter(context, "context");
        i4.a(this, context);
    }

    public void a(IdentifierType identifierType) {
        this.l = identifierType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e2(Context context, Location location, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : location, (i2 & 4) != 0 ? true : z);
    }
}
