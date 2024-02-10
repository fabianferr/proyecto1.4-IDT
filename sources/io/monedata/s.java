package io.monedata;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lio/monedata/s;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lio/monedata/n0;", "errorCollector", "Lio/monedata/n0;", "a", "()Lio/monedata/n0;", "", "Lio/monedata/h1;", "partners", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lio/monedata/k1;", "ping", "Lio/monedata/k1;", "c", "()Lio/monedata/k1;", "<init>", "(Lio/monedata/n0;Ljava/util/List;Lio/monedata/k1;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class s {
    @SerializedName("errorCollector")
    private final n0 a;
    @SerializedName(alternate = {"networks"}, value = "partners")
    private final List<h1> b;
    @SerializedName("ping")
    private final k1 c;

    public s() {
        this((n0) null, (List) null, (k1) null, 7, (DefaultConstructorMarker) null);
    }

    public s(n0 n0Var, List<h1> list, k1 k1Var) {
        Intrinsics.checkNotNullParameter(list, "partners");
        this.a = n0Var;
        this.b = list;
        this.c = k1Var;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(n0 n0Var, List list, k1 k1Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : n0Var, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : k1Var);
    }

    public final n0 a() {
        return this.a;
    }

    public final List<h1> b() {
        return this.b;
    }

    public final k1 c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) sVar.a) && Intrinsics.areEqual((Object) this.b, (Object) sVar.b) && Intrinsics.areEqual((Object) this.c, (Object) sVar.c);
    }

    public int hashCode() {
        n0 n0Var = this.a;
        int i = 0;
        int hashCode = (((n0Var == null ? 0 : n0Var.hashCode()) * 31) + this.b.hashCode()) * 31;
        k1 k1Var = this.c;
        if (k1Var != null) {
            i = k1Var.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Config(errorCollector=" + this.a + ", partners=" + this.b + ", ping=" + this.c + ')';
    }
}
