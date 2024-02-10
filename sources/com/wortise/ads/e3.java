package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\b8\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/wortise/ads/e3;", "Lcom/wortise/ads/o5;", "", "toString", "", "hashCode", "", "other", "", "equals", "adUnitId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "enabled", "Z", "a", "()Z", "", "interval", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "<init>", "(Ljava/lang/String;ZLjava/lang/Long;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeosmartConfig.kt */
public final class e3 implements o5 {
    @SerializedName("adUnitId")
    private final String a;
    @SerializedName("enabled")
    private final boolean b;
    @SerializedName("interval")
    private final Long c;

    public e3() {
        this((String) null, false, (Long) null, 7, (DefaultConstructorMarker) null);
    }

    public e3(String str, boolean z, Long l) {
        this.a = str;
        this.b = z;
        this.c = l;
    }

    public boolean a() {
        return this.b;
    }

    public Long b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e3)) {
            return false;
        }
        e3 e3Var = (e3) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) e3Var.a) && a() == e3Var.a() && Intrinsics.areEqual((Object) b(), (Object) e3Var.b());
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean a2 = a();
        if (a2) {
            a2 = true;
        }
        int i2 = (hashCode + (a2 ? 1 : 0)) * 31;
        if (b() != null) {
            i = b().hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "GeosmartConfig(adUnitId=" + this.a + ", enabled=" + a() + ", interval=" + b() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e3(String str, boolean z, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : l);
    }
}
