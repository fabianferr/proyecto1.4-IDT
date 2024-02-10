package com.m2catalyst.m2sdk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class f3 {
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;

    public f3(Integer num, Integer num2, Integer num3, Integer num4) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
    }

    public final Integer a() {
        return this.c;
    }

    public final Integer b() {
        return this.b;
    }

    public final Integer c() {
        return this.a;
    }

    public final Integer d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f3)) {
            return false;
        }
        f3 f3Var = (f3) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) f3Var.a) && Intrinsics.areEqual((Object) this.b, (Object) f3Var.b) && Intrinsics.areEqual((Object) this.c, (Object) f3Var.c) && Intrinsics.areEqual((Object) this.d, (Object) f3Var.d);
    }

    public final int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.d;
        if (num4 != null) {
            i = num4.hashCode();
        }
        return hashCode3 + i;
    }

    public final String toString() {
        Integer num = this.a;
        Integer num2 = this.b;
        Integer num3 = this.c;
        Integer num4 = this.d;
        return "MNSIConfiguration(obsolete_time_limit=" + num + ", distance_diff_required=" + num2 + ", db_diff_required=" + num3 + ", timestamp_diff_required=" + num4 + ")";
    }
}
