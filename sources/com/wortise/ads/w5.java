package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B)\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0006X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\b8\u0006X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/wortise/ads/w5;", "", "T", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/wortise/ads/y5;", "error", "Lcom/wortise/ads/y5;", "a", "()Lcom/wortise/ads/y5;", "result", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "success", "Z", "c", "()Z", "<init>", "(Lcom/wortise/ads/y5;Ljava/lang/Object;Z)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Response.kt */
public final class w5<T> {
    @SerializedName("error")
    private final y5 a;
    @SerializedName("result")
    private final T b;
    @SerializedName("success")
    private final boolean c;

    public w5() {
        this((y5) null, (Object) null, false, 7, (DefaultConstructorMarker) null);
    }

    public w5(y5 y5Var, T t, boolean z) {
        this.a = y5Var;
        this.b = t;
        this.c = z;
    }

    public final y5 a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w5)) {
            return false;
        }
        w5 w5Var = (w5) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) w5Var.a) && Intrinsics.areEqual((Object) this.b, (Object) w5Var.b) && this.c == w5Var.c;
    }

    public int hashCode() {
        y5 y5Var = this.a;
        int i = 0;
        int hashCode = (y5Var == null ? 0 : y5Var.hashCode()) * 31;
        T t = this.b;
        if (t != null) {
            i = t.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "Response(error=" + this.a + ", result=" + this.b + ", success=" + this.c + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w5(y5 y5Var, Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : y5Var, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? false : z);
    }
}
