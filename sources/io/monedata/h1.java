package io.monedata;

import com.google.gson.annotations.SerializedName;
import io.monedata.models.Extras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/monedata/h1;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lio/monedata/models/Extras;", "extras", "Lio/monedata/models/Extras;", "a", "()Lio/monedata/models/Extras;", "id", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class h1 {
    @SerializedName("extras")
    private final Extras a;
    @SerializedName("id")
    private final String b;

    public final Extras a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) h1Var.a) && Intrinsics.areEqual((Object) this.b, (Object) h1Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Partner(extras=" + this.a + ", id=" + this.b + ')';
    }
}
