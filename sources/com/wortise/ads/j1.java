package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.network.models.CellNetworkType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f¨\u0006!"}, d2 = {"Lcom/wortise/ads/j1;", "", "", "toString", "", "hashCode", "other", "", "equals", "carrier", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "mcc", "b", "mnc", "c", "networkCountry", "d", "Lcom/wortise/ads/network/models/CellNetworkType;", "networkType", "Lcom/wortise/ads/network/models/CellNetworkType;", "e", "()Lcom/wortise/ads/network/models/CellNetworkType;", "simCountry", "f", "", "Lcom/wortise/ads/b1;", "cells", "simCarrier", "simCarrierId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/wortise/ads/network/models/CellNetworkType;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Cellular.kt */
public final class j1 {
    @SerializedName("carrier")
    private final String a;
    @SerializedName("cells")
    private final List<b1> b;
    @SerializedName("mcc")
    private final String c;
    @SerializedName("mnc")
    private final String d;
    @SerializedName("networkCountry")
    private final String e;
    @SerializedName("networkType")
    private final CellNetworkType f;
    @SerializedName("simCarrier")
    private final String g;
    @SerializedName("simCarrierId")
    private final Integer h;
    @SerializedName("simCountry")
    private final String i;

    public j1(String str, List<b1> list, String str2, String str3, String str4, CellNetworkType cellNetworkType, String str5, Integer num, String str6) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = cellNetworkType;
        this.g = str5;
        this.h = num;
        this.i = str6;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final CellNetworkType e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) j1Var.a) && Intrinsics.areEqual((Object) this.b, (Object) j1Var.b) && Intrinsics.areEqual((Object) this.c, (Object) j1Var.c) && Intrinsics.areEqual((Object) this.d, (Object) j1Var.d) && Intrinsics.areEqual((Object) this.e, (Object) j1Var.e) && this.f == j1Var.f && Intrinsics.areEqual((Object) this.g, (Object) j1Var.g) && Intrinsics.areEqual((Object) this.h, (Object) j1Var.h) && Intrinsics.areEqual((Object) this.i, (Object) j1Var.i);
    }

    public final String f() {
        return this.i;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<b1> list = this.b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        CellNetworkType cellNetworkType = this.f;
        int hashCode6 = (hashCode5 + (cellNetworkType == null ? 0 : cellNetworkType.hashCode())) * 31;
        String str5 = this.g;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.h;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str6 = this.i;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode8 + i2;
    }

    public String toString() {
        return "Cellular(carrier=" + this.a + ", cells=" + this.b + ", mcc=" + this.c + ", mnc=" + this.d + ", networkCountry=" + this.e + ", networkType=" + this.f + ", simCarrier=" + this.g + ", simCarrierId=" + this.h + ", simCountry=" + this.i + ')';
    }
}
