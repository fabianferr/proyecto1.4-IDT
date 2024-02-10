package com.m2catalyst.m2sdk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: M2RemoteConfig.kt */
public final class q2 {
    public final Integer a;
    public final Integer b;

    public q2(Integer num, Integer num2) {
        this.a = num;
        this.b = num2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q2)) {
            return false;
        }
        q2 q2Var = (q2) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) q2Var.a) && Intrinsics.areEqual((Object) this.b, (Object) q2Var.b);
    }

    public final int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        Integer num = this.a;
        Integer num2 = this.b;
        return "M2IngestionConfig(transmission_interval_data=" + num + ", transmission_interval_wifi=" + num2 + ")";
    }
}
