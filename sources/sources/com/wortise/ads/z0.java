package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/z0;", "", "", "toString", "", "hashCode", "other", "", "equals", "backgroundLocation", "coarseLocation", "gpsLocation", "<init>", "(ZZZ)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Capabilities.kt */
public final class z0 {
    @SerializedName("backgroundLocation")
    private final boolean a;
    @SerializedName("coarseLocation")
    private final boolean b;
    @SerializedName("gpsLocation")
    private final boolean c;

    public z0(boolean z, boolean z2, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.a == z0Var.a && this.b == z0Var.b && this.c == z0Var.c;
    }

    public int hashCode() {
        boolean z = this.a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.b;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.c;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "Capabilities(backgroundLocation=" + this.a + ", coarseLocation=" + this.b + ", gpsLocation=" + this.c + ')';
    }
}
