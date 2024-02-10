package com.m2catalyst.m2sdk;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class h2 {
    public final Integer a;
    public final Integer b;
    public final List<String> c;
    public final Boolean d;
    public final Integer e;
    public final Integer f;

    public h2(Integer num, Integer num2, List<String> list, Boolean bool, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(list, "providers_order");
        this.a = num;
        this.b = num2;
        this.c = list;
        this.d = bool;
        this.e = num3;
        this.f = num4;
    }

    public final Integer a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h2)) {
            return false;
        }
        h2 h2Var = (h2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) h2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) h2Var.b) && Intrinsics.areEqual((Object) this.c, (Object) h2Var.c) && Intrinsics.areEqual((Object) this.d, (Object) h2Var.d) && Intrinsics.areEqual((Object) this.e, (Object) h2Var.e) && Intrinsics.areEqual((Object) this.f, (Object) h2Var.f);
    }

    public final int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int hashCode2 = (this.c.hashCode() + ((hashCode + (num2 == null ? 0 : num2.hashCode())) * 31)) * 31;
        Boolean bool = this.d;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num3 = this.e;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f;
        if (num4 != null) {
            i = num4.hashCode();
        }
        return hashCode4 + i;
    }

    public final String toString() {
        Integer num = this.a;
        Integer num2 = this.b;
        List<String> list = this.c;
        Boolean bool = this.d;
        Integer num3 = this.e;
        Integer num4 = this.f;
        return "LocationConfiguration(request_location_updates=" + num + ", location_alarm_update=" + num2 + ", providers_order=" + list + ", barometric_enabled=" + bool + ", accuracy_required=" + num3 + ", time_required=" + num4 + ")";
    }
}
