package io.monedata;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0017"}, d2 = {"Lio/monedata/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "appId", "Lio/monedata/o;", "features", "foreground", "framework", "", "permissions", "requestedPermissions", "utm", "", "version", "versionName", "<init>", "(Ljava/lang/String;Lio/monedata/o;ZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class q {
    @SerializedName("appId")
    private final String a;
    @SerializedName("features")
    private final o b;
    @SerializedName("foreground")
    private final boolean c;
    @SerializedName("framework")
    private final String d;
    @SerializedName("permissions")
    private final List<String> e;
    @SerializedName("requestedPermissions")
    private final List<String> f;
    @SerializedName("utm")
    private final String g;
    @SerializedName("version")
    private final Long h;
    @SerializedName("versionName")
    private final String i;

    public q(String str, o oVar, boolean z, String str2, List<String> list, List<String> list2, String str3, Long l, String str4) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(oVar, "features");
        Intrinsics.checkNotNullParameter(list, "permissions");
        Intrinsics.checkNotNullParameter(list2, "requestedPermissions");
        this.a = str;
        this.b = oVar;
        this.c = z;
        this.d = str2;
        this.e = list;
        this.f = list2;
        this.g = str3;
        this.h = l;
        this.i = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) qVar.a) && Intrinsics.areEqual((Object) this.b, (Object) qVar.b) && this.c == qVar.c && Intrinsics.areEqual((Object) this.d, (Object) qVar.d) && Intrinsics.areEqual((Object) this.e, (Object) qVar.e) && Intrinsics.areEqual((Object) this.f, (Object) qVar.f) && Intrinsics.areEqual((Object) this.g, (Object) qVar.g) && Intrinsics.areEqual((Object) this.h, (Object) qVar.h) && Intrinsics.areEqual((Object) this.i, (Object) qVar.i);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.d;
        int i3 = 0;
        int hashCode2 = (((((i2 + (str == null ? 0 : str.hashCode())) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String str2 = this.g;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.h;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.i;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "ClientInfo(appId=" + this.a + ", features=" + this.b + ", foreground=" + this.c + ", framework=" + this.d + ", permissions=" + this.e + ", requestedPermissions=" + this.f + ", utm=" + this.g + ", version=" + this.h + ", versionName=" + this.i + ')';
    }
}
