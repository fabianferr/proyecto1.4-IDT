package com.m2catalyst.m2sdk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class f6 {
    public final Integer a;
    public final Integer b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final Integer k;
    public final Integer l;
    public final Integer m;
    public final Integer n;
    public final Boolean o;
    public final Boolean p;
    public final Boolean q;

    public f6(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Boolean bool, Boolean bool2, Boolean bool3) {
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
        this.l = num12;
        this.m = num13;
        this.n = num14;
        this.o = bool;
        this.p = bool2;
        this.q = bool3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f6)) {
            return false;
        }
        f6 f6Var = (f6) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) f6Var.a) && Intrinsics.areEqual((Object) this.b, (Object) f6Var.b) && Intrinsics.areEqual((Object) this.c, (Object) f6Var.c) && Intrinsics.areEqual((Object) this.d, (Object) f6Var.d) && Intrinsics.areEqual((Object) this.e, (Object) f6Var.e) && Intrinsics.areEqual((Object) this.f, (Object) f6Var.f) && Intrinsics.areEqual((Object) this.g, (Object) f6Var.g) && Intrinsics.areEqual((Object) this.h, (Object) f6Var.h) && Intrinsics.areEqual((Object) this.i, (Object) f6Var.i) && Intrinsics.areEqual((Object) this.j, (Object) f6Var.j) && Intrinsics.areEqual((Object) this.k, (Object) f6Var.k) && Intrinsics.areEqual((Object) this.l, (Object) f6Var.l) && Intrinsics.areEqual((Object) this.m, (Object) f6Var.m) && Intrinsics.areEqual((Object) this.n, (Object) f6Var.n) && Intrinsics.areEqual((Object) this.o, (Object) f6Var.o) && Intrinsics.areEqual((Object) this.p, (Object) f6Var.p) && Intrinsics.areEqual((Object) this.q, (Object) f6Var.q);
    }

    public final int hashCode() {
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
        int hashCode11 = (hashCode10 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.l;
        int hashCode12 = (hashCode11 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.m;
        int hashCode13 = (hashCode12 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.n;
        int hashCode14 = (hashCode13 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Boolean bool = this.o;
        int hashCode15 = (hashCode14 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.p;
        int hashCode16 = (hashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.q;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        return hashCode16 + i2;
    }

    public final String toString() {
        Integer num = this.a;
        Integer num2 = this.b;
        Integer num3 = this.c;
        Integer num4 = this.d;
        Integer num5 = this.e;
        Integer num6 = this.f;
        Integer num7 = this.g;
        Integer num8 = this.h;
        Integer num9 = this.i;
        Integer num10 = this.j;
        Integer num11 = this.k;
        Integer num12 = this.l;
        Integer num13 = this.m;
        Integer num14 = this.n;
        Boolean bool = this.o;
        Boolean bool2 = this.p;
        return "SpeedTestConfiguration(max_auto_test_per_day=" + num + ", max_auto_test_per_week=" + num2 + ", max_auto_test_per_month=" + num3 + ", max_auto_test_per_day_5G=" + num4 + ", max_auto_test_per_week_5G=" + num5 + ", max_auto_test_per_month_5G=" + num6 + ", max_data_consumed_per_test=" + num7 + ", max_data_consumed_per_day=" + num8 + ", max_data_consumed_per_week=" + num9 + ", max_data_consumed_per_month=" + num10 + ", max_data_consumed_per_test_5G=" + num11 + ", max_data_consumed_per_day_5G=" + num12 + ", max_data_consumed_per_week_5G=" + num13 + ", max_data_consumed_per_month_5G=" + num14 + ", beast_mode_enabled=" + bool + ", override_max_data=" + bool2 + ", override_max_tests=" + this.q + ")";
    }
}
