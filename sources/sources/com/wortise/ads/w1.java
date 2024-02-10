package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/wortise/ads/w1;", "", "", "toString", "", "hashCode", "other", "", "equals", "denyText", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "grantText", "b", "message", "c", "required", "Z", "d", "()Z", "title", "e", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConsentSettings.kt */
public final class w1 {
    @SerializedName("denyText")
    private final String a;
    @SerializedName("grantText")
    private final String b;
    @SerializedName("message")
    private final String c;
    @SerializedName("required")
    private final boolean d;
    @SerializedName("title")
    private final String e;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) w1Var.a) && Intrinsics.areEqual((Object) this.b, (Object) w1Var.b) && Intrinsics.areEqual((Object) this.c, (Object) w1Var.c) && this.d == w1Var.d && Intrinsics.areEqual((Object) this.e, (Object) w1Var.e);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.e;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ConsentSettings(denyText=" + this.a + ", grantText=" + this.b + ", message=" + this.c + ", required=" + this.d + ", title=" + this.e + ')';
    }
}
