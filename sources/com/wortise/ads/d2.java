package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.api.submodels.UserLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b-\u0010.B'\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b-\u00104R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/wortise/ads/d2;", "", "", "Lcom/wortise/ads/q6;", "apps", "Ljava/util/List;", "a", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "Lcom/wortise/ads/q0;", "battery", "Lcom/wortise/ads/q0;", "b", "()Lcom/wortise/ads/q0;", "setBattery", "(Lcom/wortise/ads/q0;)V", "Lcom/wortise/ads/j1;", "cellular", "Lcom/wortise/ads/j1;", "c", "()Lcom/wortise/ads/j1;", "setCellular", "(Lcom/wortise/ads/j1;)V", "Lcom/wortise/ads/api/submodels/UserLocation;", "location", "Lcom/wortise/ads/api/submodels/UserLocation;", "d", "()Lcom/wortise/ads/api/submodels/UserLocation;", "setLocation", "(Lcom/wortise/ads/api/submodels/UserLocation;)V", "Lcom/wortise/ads/z4;", "network", "Lcom/wortise/ads/z4;", "e", "()Lcom/wortise/ads/z4;", "setNetwork", "(Lcom/wortise/ads/z4;)V", "Lcom/wortise/ads/s6;", "user", "Lcom/wortise/ads/s6;", "f", "()Lcom/wortise/ads/s6;", "setUser", "(Lcom/wortise/ads/s6;)V", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/location/Location;", "", "collectApps", "(Landroid/content/Context;Landroid/location/Location;Z)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DataModel.kt */
public class d2 {
    @SerializedName("app")
    private y a;
    @SerializedName("apps")
    private List<q6> b;
    @SerializedName("battery")
    private q0 c;
    @SerializedName("cellular")
    private j1 d;
    @SerializedName("device")
    private l2 e;
    @SerializedName("location")
    private UserLocation f;
    @SerializedName("network")
    private z4 g;
    @SerializedName("user")
    private s6 h;

    public d2() {
    }

    public final List<q6> a() {
        return this.b;
    }

    public final q0 b() {
        return this.c;
    }

    public final j1 c() {
        return this.d;
    }

    public final UserLocation d() {
        return this.f;
    }

    public final z4 e() {
        return this.g;
    }

    public final s6 f() {
        return this.h;
    }

    public d2(Context context, Location location, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = z.a.a(context);
        this.c = r0.a.a(context);
        this.d = k1.a.a(context);
        this.e = n2.a.a(context);
        this.f = v6.a.a(context, location, true);
        this.g = a5.a.a(context);
        this.h = t6.a.a(context);
        this.b = z ? r6.a.a(context) : null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d2(Context context, Location location, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : location, (i & 4) != 0 ? true : z);
    }
}
