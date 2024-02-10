package io.monedata;

import com.google.gson.annotations.SerializedName;
import io.monedata.net.NetworkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u000e"}, d2 = {"Lio/monedata/j0;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lio/monedata/net/NetworkType;", "type", "vpn", "<init>", "(Lio/monedata/net/NetworkType;Ljava/lang/Boolean;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class j0 {
    @SerializedName("type")
    private final NetworkType a;
    @SerializedName("vpn")
    private final Boolean b;

    public j0(NetworkType networkType, Boolean bool) {
        this.a = networkType;
        this.b = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.a == j0Var.a && Intrinsics.areEqual((Object) this.b, (Object) j0Var.b);
    }

    public int hashCode() {
        NetworkType networkType = this.a;
        int i = 0;
        int hashCode = (networkType == null ? 0 : networkType.hashCode()) * 31;
        Boolean bool = this.b;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "DeviceNetwork(type=" + this.a + ", vpn=" + this.b + ')';
    }
}
