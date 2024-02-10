package io.monedata;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0016"}, d2 = {"Lio/monedata/h0;", "", "", "toString", "", "hashCode", "other", "", "equals", "country", "device", "emulator", "fingerprint", "language", "manufacturer", "model", "os", "osRelease", "osVersion", "timezone", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class h0 {
    @SerializedName("country")
    private final String a;
    @SerializedName("device")
    private final String b;
    @SerializedName("emulator")
    private final boolean c;
    @SerializedName("fingerprint")
    private final String d;
    @SerializedName("language")
    private final String e;
    @SerializedName("manufacturer")
    private final String f;
    @SerializedName("model")
    private final String g;
    @SerializedName("os")
    private final String h;
    @SerializedName("osRelease")
    private final String i;
    @SerializedName("osVersion")
    private final int j;
    @SerializedName("timezone")
    private final String k;

    public h0(String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "device");
        Intrinsics.checkNotNullParameter(str3, "fingerprint");
        Intrinsics.checkNotNullParameter(str4, "language");
        Intrinsics.checkNotNullParameter(str5, "manufacturer");
        Intrinsics.checkNotNullParameter(str6, "model");
        Intrinsics.checkNotNullParameter(str7, "os");
        Intrinsics.checkNotNullParameter(str8, "osRelease");
        Intrinsics.checkNotNullParameter(str9, "timezone");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = i2;
        this.k = str9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) h0Var.a) && Intrinsics.areEqual((Object) this.b, (Object) h0Var.b) && this.c == h0Var.c && Intrinsics.areEqual((Object) this.d, (Object) h0Var.d) && Intrinsics.areEqual((Object) this.e, (Object) h0Var.e) && Intrinsics.areEqual((Object) this.f, (Object) h0Var.f) && Intrinsics.areEqual((Object) this.g, (Object) h0Var.g) && Intrinsics.areEqual((Object) this.h, (Object) h0Var.h) && Intrinsics.areEqual((Object) this.i, (Object) h0Var.i) && this.j == h0Var.j && Intrinsics.areEqual((Object) this.k, (Object) h0Var.k);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        return ((((((((((((((((hashCode + (z ? 1 : 0)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j) * 31) + this.k.hashCode();
    }

    public String toString() {
        return "DeviceInfo(country=" + this.a + ", device=" + this.b + ", emulator=" + this.c + ", fingerprint=" + this.d + ", language=" + this.e + ", manufacturer=" + this.f + ", model=" + this.g + ", os=" + this.h + ", osRelease=" + this.i + ", osVersion=" + this.j + ", timezone=" + this.k + ')';
    }
}
