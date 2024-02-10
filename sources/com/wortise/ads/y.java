package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0017"}, d2 = {"Lcom/wortise/ads/y;", "", "", "toString", "", "hashCode", "other", "", "equals", "appId", "Lcom/wortise/ads/z0;", "capabilities", "notifications", "", "permissions", "sdkPlatform", "sdkVersion", "utm", "", "version", "versionName", "<init>", "(Ljava/lang/String;Lcom/wortise/ads/z0;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: App.kt */
public final class y {
    @SerializedName("appId")
    private final String a;
    @SerializedName("capabilities")
    private final z0 b;
    @SerializedName("notifications")
    private final boolean c;
    @SerializedName("permissions")
    private final List<String> d;
    @SerializedName("sdkPlatform")
    private final String e;
    @SerializedName("sdkVersion")
    private final String f;
    @SerializedName("utm")
    private final String g;
    @SerializedName("version")
    private final Long h;
    @SerializedName("versionName")
    private final String i;

    public y(String str, z0 z0Var, boolean z, List<String> list, String str2, String str3, String str4, Long l, String str5) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(z0Var, "capabilities");
        Intrinsics.checkNotNullParameter(list, "permissions");
        Intrinsics.checkNotNullParameter(str2, "sdkPlatform");
        Intrinsics.checkNotNullParameter(str3, "sdkVersion");
        this.a = str;
        this.b = z0Var;
        this.c = z;
        this.d = list;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = l;
        this.i = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) yVar.a) && Intrinsics.areEqual((Object) this.b, (Object) yVar.b) && this.c == yVar.c && Intrinsics.areEqual((Object) this.d, (Object) yVar.d) && Intrinsics.areEqual((Object) this.e, (Object) yVar.e) && Intrinsics.areEqual((Object) this.f, (Object) yVar.f) && Intrinsics.areEqual((Object) this.g, (Object) yVar.g) && Intrinsics.areEqual((Object) this.h, (Object) yVar.h) && Intrinsics.areEqual((Object) this.i, (Object) yVar.i);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int hashCode2 = (((((((hashCode + (z ? 1 : 0)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        int i2 = 0;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.h;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.i;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "App(appId=" + this.a + ", capabilities=" + this.b + ", notifications=" + this.c + ", permissions=" + this.d + ", sdkPlatform=" + this.e + ", sdkVersion=" + this.f + ", utm=" + this.g + ", version=" + this.h + ", versionName=" + this.i + ')';
    }
}
