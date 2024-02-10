package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.api.submodels.UserAppCategory;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/wortise/ads/q6;", "", "", "toString", "", "hashCode", "other", "", "equals", "appId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lcom/wortise/ads/api/submodels/UserAppCategory;", "category", "Ljava/util/Date;", "installDate", "isInactive", "lastUpdate", "", "name", "", "version", "versionName", "<init>", "(Ljava/lang/String;Lcom/wortise/ads/api/submodels/UserAppCategory;Ljava/util/Date;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/CharSequence;Ljava/lang/Long;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserApp.kt */
public final class q6 {
    @SerializedName("appId")
    private final String a;
    @SerializedName("category")
    private final UserAppCategory b;
    @SerializedName("installDate")
    private final Date c;
    @SerializedName("isInactive")
    private final Boolean d;
    @SerializedName("lastUpdate")
    private final Date e;
    @SerializedName("name")
    private final CharSequence f;
    @SerializedName("version")
    private final Long g;
    @SerializedName("versionName")
    private final String h;

    public q6(String str, UserAppCategory userAppCategory, Date date, Boolean bool, Date date2, CharSequence charSequence, Long l, String str2) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(date, "installDate");
        Intrinsics.checkNotNullParameter(date2, "lastUpdate");
        this.a = str;
        this.b = userAppCategory;
        this.c = date;
        this.d = bool;
        this.e = date2;
        this.f = charSequence;
        this.g = l;
        this.h = str2;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q6)) {
            return false;
        }
        q6 q6Var = (q6) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) q6Var.a) && this.b == q6Var.b && Intrinsics.areEqual((Object) this.c, (Object) q6Var.c) && Intrinsics.areEqual((Object) this.d, (Object) q6Var.d) && Intrinsics.areEqual((Object) this.e, (Object) q6Var.e) && Intrinsics.areEqual((Object) this.f, (Object) q6Var.f) && Intrinsics.areEqual((Object) this.g, (Object) q6Var.g) && Intrinsics.areEqual((Object) this.h, (Object) q6Var.h);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        UserAppCategory userAppCategory = this.b;
        int i = 0;
        int hashCode2 = (((hashCode + (userAppCategory == null ? 0 : userAppCategory.hashCode())) * 31) + this.c.hashCode()) * 31;
        Boolean bool = this.d;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + this.e.hashCode()) * 31;
        CharSequence charSequence = this.f;
        int hashCode4 = (hashCode3 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        Long l = this.g;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.h;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "UserApp(appId=" + this.a + ", category=" + this.b + ", installDate=" + this.c + ", isInactive=" + this.d + ", lastUpdate=" + this.e + ", name=" + this.f + ", version=" + this.g + ", versionName=" + this.h + ')';
    }
}
