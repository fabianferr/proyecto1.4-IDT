package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.user.UserGender;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/wortise/ads/s6;", "", "", "toString", "", "hashCode", "other", "", "equals", "age", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "Lcom/wortise/ads/user/UserGender;", "gender", "Lcom/wortise/ads/user/UserGender;", "b", "()Lcom/wortise/ads/user/UserGender;", "", "Lcom/wortise/ads/q3;", "emails", "id", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Lcom/wortise/ads/user/UserGender;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserData.kt */
public final class s6 {
    @SerializedName("age")
    private final Integer a;
    @SerializedName("emails")
    private final List<q3> b;
    @SerializedName("gender")
    private final UserGender c;
    @SerializedName("id")
    private final String d;

    public s6(Integer num, List<q3> list, UserGender userGender, String str) {
        this.a = num;
        this.b = list;
        this.c = userGender;
        this.d = str;
    }

    public final Integer a() {
        return this.a;
    }

    public final UserGender b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s6)) {
            return false;
        }
        s6 s6Var = (s6) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) s6Var.a) && Intrinsics.areEqual((Object) this.b, (Object) s6Var.b) && this.c == s6Var.c && Intrinsics.areEqual((Object) this.d, (Object) s6Var.d);
    }

    public int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<q3> list = this.b;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        UserGender userGender = this.c;
        int hashCode3 = (hashCode2 + (userGender == null ? 0 : userGender.hashCode())) * 31;
        String str = this.d;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "UserData(age=" + this.a + ", emails=" + this.b + ", gender=" + this.c + ", id=" + this.d + ')';
    }
}
