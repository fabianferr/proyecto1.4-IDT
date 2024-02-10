package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.network.models.NetworkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/z4;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/wortise/ads/network/models/NetworkType;", "type", "Lcom/wortise/ads/network/models/NetworkType;", "a", "()Lcom/wortise/ads/network/models/NetworkType;", "vpn", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "Lcom/wortise/ads/c7;", "wifi", "<init>", "(Lcom/wortise/ads/network/models/NetworkType;Ljava/lang/Boolean;Lcom/wortise/ads/c7;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Network.kt */
public final class z4 {
    @SerializedName("type")
    private final NetworkType a;
    @SerializedName("vpn")
    private final Boolean b;
    @SerializedName("wifi")
    private final c7 c;

    public z4(NetworkType networkType, Boolean bool, c7 c7Var) {
        this.a = networkType;
        this.b = bool;
        this.c = c7Var;
    }

    public final NetworkType a() {
        return this.a;
    }

    public final Boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z4)) {
            return false;
        }
        z4 z4Var = (z4) obj;
        return this.a == z4Var.a && Intrinsics.areEqual((Object) this.b, (Object) z4Var.b) && Intrinsics.areEqual((Object) this.c, (Object) z4Var.c);
    }

    public int hashCode() {
        NetworkType networkType = this.a;
        int i = 0;
        int hashCode = (networkType == null ? 0 : networkType.hashCode()) * 31;
        Boolean bool = this.b;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        c7 c7Var = this.c;
        if (c7Var != null) {
            i = c7Var.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Network(type=" + this.a + ", vpn=" + this.b + ", wifi=" + this.c + ')';
    }
}
