package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.cellular.CellConnection;
import com.wortise.ads.cellular.CellType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/b1;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/wortise/ads/cellular/CellConnection;", "connection", "Lcom/wortise/ads/d1;", "identity", "Lcom/wortise/ads/g1;", "signal", "Lcom/wortise/ads/cellular/CellType;", "type", "<init>", "(Lcom/wortise/ads/cellular/CellConnection;Lcom/wortise/ads/d1;Lcom/wortise/ads/g1;Lcom/wortise/ads/cellular/CellType;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellData.kt */
public final class b1 {
    @SerializedName("connection")
    private final CellConnection a;
    @SerializedName("identity")
    private final d1 b;
    @SerializedName("signal")
    private final g1 c;
    @SerializedName("type")
    private final CellType d;

    public b1(CellConnection cellConnection, d1 d1Var, g1 g1Var, CellType cellType) {
        this.a = cellConnection;
        this.b = d1Var;
        this.c = g1Var;
        this.d = cellType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return this.a == b1Var.a && Intrinsics.areEqual((Object) this.b, (Object) b1Var.b) && Intrinsics.areEqual((Object) this.c, (Object) b1Var.c) && this.d == b1Var.d;
    }

    public int hashCode() {
        CellConnection cellConnection = this.a;
        int i = 0;
        int hashCode = (cellConnection == null ? 0 : cellConnection.hashCode()) * 31;
        d1 d1Var = this.b;
        int hashCode2 = (hashCode + (d1Var == null ? 0 : d1Var.hashCode())) * 31;
        g1 g1Var = this.c;
        int hashCode3 = (hashCode2 + (g1Var == null ? 0 : g1Var.hashCode())) * 31;
        CellType cellType = this.d;
        if (cellType != null) {
            i = cellType.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CellData(connection=" + this.a + ", identity=" + this.b + ", signal=" + this.c + ", type=" + this.d + ')';
    }
}
