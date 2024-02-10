package com.m2catalyst.m2sdk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class x2 {
    public final q2 a;
    public final n2 b;
    public final f6 c;
    public final h2 d;
    public final f3 e;
    public final p2 f;

    public x2(q2 q2Var, n2 n2Var, f6 f6Var, h2 h2Var, f3 f3Var, p2 p2Var) {
        this.a = q2Var;
        this.b = n2Var;
        this.c = f6Var;
        this.d = h2Var;
        this.e = f3Var;
        this.f = p2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x2)) {
            return false;
        }
        x2 x2Var = (x2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) x2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) x2Var.b) && Intrinsics.areEqual((Object) this.c, (Object) x2Var.c) && Intrinsics.areEqual((Object) this.d, (Object) x2Var.d) && Intrinsics.areEqual((Object) this.e, (Object) x2Var.e) && Intrinsics.areEqual((Object) this.f, (Object) x2Var.f);
    }

    public final int hashCode() {
        q2 q2Var = this.a;
        int i = 0;
        int hashCode = (q2Var == null ? 0 : q2Var.hashCode()) * 31;
        n2 n2Var = this.b;
        int hashCode2 = (hashCode + (n2Var == null ? 0 : n2Var.hashCode())) * 31;
        f6 f6Var = this.c;
        int hashCode3 = (hashCode2 + (f6Var == null ? 0 : f6Var.hashCode())) * 31;
        h2 h2Var = this.d;
        int hashCode4 = (hashCode3 + (h2Var == null ? 0 : h2Var.hashCode())) * 31;
        f3 f3Var = this.e;
        int hashCode5 = (hashCode4 + (f3Var == null ? 0 : f3Var.hashCode())) * 31;
        p2 p2Var = this.f;
        if (p2Var != null) {
            i = p2Var.hashCode();
        }
        return hashCode5 + i;
    }

    public final String toString() {
        q2 q2Var = this.a;
        n2 n2Var = this.b;
        f6 f6Var = this.c;
        h2 h2Var = this.d;
        f3 f3Var = this.e;
        p2 p2Var = this.f;
        return "M2RemoteConfig(ingestion=" + q2Var + ", access=" + n2Var + ", speed_test=" + f6Var + ", location=" + h2Var + ", mnsi=" + f3Var + ", config=" + p2Var + ")";
    }
}
