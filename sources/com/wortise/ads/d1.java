package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\r"}, d2 = {"Lcom/wortise/ads/d1;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "cid", "<init>", "(Ljava/lang/Long;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellIdentity.kt */
public final class d1 {
    @SerializedName("cid")
    private final Long a;

    public d1(Long l) {
        this.a = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d1) && Intrinsics.areEqual((Object) this.a, (Object) ((d1) obj).a);
    }

    public int hashCode() {
        Long l = this.a;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "CellIdentity(cid=" + this.a + ')';
    }
}
