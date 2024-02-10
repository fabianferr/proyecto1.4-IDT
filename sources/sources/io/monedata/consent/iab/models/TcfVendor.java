package io.monedata.consent.iab.models;

import io.monedata.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/monedata/consent/iab/models/TcfVendor;", "Lio/monedata/w1;", "", "component1", "component2", "id", "version", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getId", "()I", "getVersion", "<init>", "(II)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class TcfVendor implements w1 {
    private final int id;
    private final int version;

    public TcfVendor(int i, int i2) {
        this.id = i;
        this.version = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TcfVendor(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 1 : i2);
    }

    public static /* synthetic */ TcfVendor copy$default(TcfVendor tcfVendor, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tcfVendor.getId();
        }
        if ((i3 & 2) != 0) {
            i2 = tcfVendor.getVersion();
        }
        return tcfVendor.copy(i, i2);
    }

    public final int component1() {
        return getId();
    }

    public final int component2() {
        return getVersion();
    }

    public final TcfVendor copy(int i, int i2) {
        return new TcfVendor(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TcfVendor)) {
            return false;
        }
        TcfVendor tcfVendor = (TcfVendor) obj;
        return getId() == tcfVendor.getId() && getVersion() == tcfVendor.getVersion();
    }

    public int getId() {
        return this.id;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (getId() * 31) + getVersion();
    }

    public String toString() {
        return "TcfVendor(id=" + getId() + ", version=" + getVersion() + ')';
    }
}
