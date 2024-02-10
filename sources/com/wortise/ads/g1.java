package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/g1;", "", "", "toString", "", "hashCode", "other", "", "equals", "asu", "ber", "cqi", "ecio", "evdoSnr", "level", "rsrp", "rsrq", "rssi", "rssnr", "ta", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellSignal.kt */
public final class g1 {
    @SerializedName("asu")
    private final Integer a;
    @SerializedName("ber")
    private final Integer b;
    @SerializedName("cqi")
    private final Integer c;
    @SerializedName("ecio")
    private final Integer d;
    @SerializedName("evdoSnr")
    private final Integer e;
    @SerializedName("level")
    private final Integer f;
    @SerializedName("rsrp")
    private final Integer g;
    @SerializedName("rsrq")
    private final Integer h;
    @SerializedName("rssi")
    private final Integer i;
    @SerializedName("rssnr")
    private final Integer j;
    @SerializedName("ta")
    private final Integer k;

    public g1(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = num5;
        this.f = num6;
        this.g = num7;
        this.h = num8;
        this.i = num9;
        this.j = num10;
        this.k = num11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) g1Var.a) && Intrinsics.areEqual((Object) this.b, (Object) g1Var.b) && Intrinsics.areEqual((Object) this.c, (Object) g1Var.c) && Intrinsics.areEqual((Object) this.d, (Object) g1Var.d) && Intrinsics.areEqual((Object) this.e, (Object) g1Var.e) && Intrinsics.areEqual((Object) this.f, (Object) g1Var.f) && Intrinsics.areEqual((Object) this.g, (Object) g1Var.g) && Intrinsics.areEqual((Object) this.h, (Object) g1Var.h) && Intrinsics.areEqual((Object) this.i, (Object) g1Var.i) && Intrinsics.areEqual((Object) this.j, (Object) g1Var.j) && Intrinsics.areEqual((Object) this.k, (Object) g1Var.k);
    }

    public int hashCode() {
        Integer num = this.a;
        int i2 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.d;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.e;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f;
        int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.g;
        int hashCode7 = (hashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.h;
        int hashCode8 = (hashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.i;
        int hashCode9 = (hashCode8 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.j;
        int hashCode10 = (hashCode9 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.k;
        if (num11 != null) {
            i2 = num11.hashCode();
        }
        return hashCode10 + i2;
    }

    public String toString() {
        return "CellSignal(asu=" + this.a + ", ber=" + this.b + ", cqi=" + this.c + ", ecio=" + this.d + ", evdoSnr=" + this.e + ", level=" + this.f + ", rsrp=" + this.g + ", rsrq=" + this.h + ", rssi=" + this.i + ", rssnr=" + this.j + ", ta=" + this.k + ')';
    }
}
