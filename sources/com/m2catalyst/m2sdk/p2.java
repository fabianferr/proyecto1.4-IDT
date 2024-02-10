package com.m2catalyst.m2sdk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class p2 {
    public final Integer a;
    public final Boolean b;
    public final Integer c;
    public final Boolean d;
    public final Boolean e;
    public final Boolean f;
    public final Integer g;

    public p2(Integer num, Boolean bool, Integer num2, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3) {
        this.a = num;
        this.b = bool;
        this.c = num2;
        this.d = bool2;
        this.e = bool3;
        this.f = bool4;
        this.g = num3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p2)) {
            return false;
        }
        p2 p2Var = (p2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) p2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) p2Var.b) && Intrinsics.areEqual((Object) this.c, (Object) p2Var.c) && Intrinsics.areEqual((Object) this.d, (Object) p2Var.d) && Intrinsics.areEqual((Object) this.e, (Object) p2Var.e) && Intrinsics.areEqual((Object) this.f, (Object) p2Var.f) && Intrinsics.areEqual((Object) this.g, (Object) p2Var.g);
    }

    public final int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.b;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.c;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool2 = this.d;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.e;
        int hashCode5 = (hashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.f;
        int hashCode6 = (hashCode5 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Integer num3 = this.g;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode6 + i;
    }

    public final String toString() {
        Integer num = this.a;
        Boolean bool = this.b;
        Integer num2 = this.c;
        Boolean bool2 = this.d;
        Boolean bool3 = this.e;
        Boolean bool4 = this.f;
        Integer num3 = this.g;
        return "M2GeneralConfig(resync=" + num + ", monitor_stats_enabled=" + bool + ", delete_data_after=" + num2 + ", broadcast_receivers_enabled=" + bool2 + ", flex_enabled=" + bool3 + ", next_nav_enabled=" + bool4 + ", min_sdk=" + num3 + ")";
    }
}
