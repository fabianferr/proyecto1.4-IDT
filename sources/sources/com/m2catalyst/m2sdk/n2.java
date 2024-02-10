package com.m2catalyst.m2sdk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class n2 {
    public final l2 a;
    public final l2 b;
    public final l2 c;
    public final l2 d;
    public final l2 e;
    public final l2 f;
    public final l2 g;
    public final l2 h;
    public final l2 i;

    public n2(l2 l2Var, l2 l2Var2, l2 l2Var3, l2 l2Var4, l2 l2Var5, l2 l2Var6, l2 l2Var7, l2 l2Var8, l2 l2Var9) {
        this.a = l2Var;
        this.b = l2Var2;
        this.c = l2Var3;
        this.d = l2Var4;
        this.e = l2Var5;
        this.f = l2Var6;
        this.g = l2Var7;
        this.h = l2Var8;
        this.i = l2Var9;
    }

    public final l2 a() {
        return this.d;
    }

    public final l2 b() {
        return this.f;
    }

    public final l2 c() {
        return this.g;
    }

    public final l2 d() {
        return this.c;
    }

    public final l2 e() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n2)) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) n2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) n2Var.b) && Intrinsics.areEqual((Object) this.c, (Object) n2Var.c) && Intrinsics.areEqual((Object) this.d, (Object) n2Var.d) && Intrinsics.areEqual((Object) this.e, (Object) n2Var.e) && Intrinsics.areEqual((Object) this.f, (Object) n2Var.f) && Intrinsics.areEqual((Object) this.g, (Object) n2Var.g) && Intrinsics.areEqual((Object) this.h, (Object) n2Var.h) && Intrinsics.areEqual((Object) this.i, (Object) n2Var.i);
    }

    public final l2 f() {
        return this.e;
    }

    public final l2 g() {
        return this.b;
    }

    public final int hashCode() {
        l2 l2Var = this.a;
        int i2 = 0;
        int hashCode = (l2Var == null ? 0 : l2Var.hashCode()) * 31;
        l2 l2Var2 = this.b;
        int hashCode2 = (hashCode + (l2Var2 == null ? 0 : l2Var2.hashCode())) * 31;
        l2 l2Var3 = this.c;
        int hashCode3 = (hashCode2 + (l2Var3 == null ? 0 : l2Var3.hashCode())) * 31;
        l2 l2Var4 = this.d;
        int hashCode4 = (hashCode3 + (l2Var4 == null ? 0 : l2Var4.hashCode())) * 31;
        l2 l2Var5 = this.e;
        int hashCode5 = (hashCode4 + (l2Var5 == null ? 0 : l2Var5.hashCode())) * 31;
        l2 l2Var6 = this.f;
        int hashCode6 = (hashCode5 + (l2Var6 == null ? 0 : l2Var6.hashCode())) * 31;
        l2 l2Var7 = this.g;
        int hashCode7 = (hashCode6 + (l2Var7 == null ? 0 : l2Var7.hashCode())) * 31;
        l2 l2Var8 = this.h;
        int hashCode8 = (hashCode7 + (l2Var8 == null ? 0 : l2Var8.hashCode())) * 31;
        l2 l2Var9 = this.i;
        if (l2Var9 != null) {
            i2 = l2Var9.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        l2 l2Var = this.a;
        l2 l2Var2 = this.b;
        l2 l2Var3 = this.c;
        l2 l2Var4 = this.d;
        l2 l2Var5 = this.e;
        l2 l2Var6 = this.f;
        l2 l2Var7 = this.g;
        l2 l2Var8 = this.h;
        l2 l2Var9 = this.i;
        return "M2DataAccess(m2_config=" + l2Var + ", wifi=" + l2Var2 + ", no_signal=" + l2Var3 + ", bad_signals=" + l2Var4 + ", speed_test=" + l2Var5 + ", location=" + l2Var6 + ", mnsi=" + l2Var7 + ", device=" + l2Var8 + ", sdk_state=" + l2Var9 + ")";
    }
}
