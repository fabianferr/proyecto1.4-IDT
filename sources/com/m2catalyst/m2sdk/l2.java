package com.m2catalyst.m2sdk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class l2 {
    public final Boolean a;
    public final Boolean b;
    public final Boolean c;

    public l2(Boolean bool, Boolean bool2, Boolean bool3) {
        this.a = bool;
        this.b = bool2;
        this.c = bool3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) l2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) l2Var.b) && Intrinsics.areEqual((Object) this.c, (Object) l2Var.c);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.b;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.c;
        if (bool3 != null) {
            i = bool3.hashCode();
        }
        return hashCode2 + i;
    }

    public final String toString() {
        Boolean bool = this.a;
        Boolean bool2 = this.b;
        Boolean bool3 = this.c;
        return "M2ComponentAccess(read=" + bool + ", write=" + bool2 + ", observer=" + bool3 + ")";
    }
}
