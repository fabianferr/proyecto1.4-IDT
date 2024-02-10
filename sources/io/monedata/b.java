package io.monedata;

import com.google.gson.annotations.SerializedName;
import io.monedata.models.Extras;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u000f"}, d2 = {"Lio/monedata/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lio/monedata/models/Extras;", "extras", "id", "version", "<init>", "(Lio/monedata/models/Extras;Ljava/lang/String;Ljava/lang/String;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class b {
    @SerializedName("extras")
    private final Extras a;
    @SerializedName("id")
    private final String b;
    @SerializedName("version")
    private final String c;

    public b(Extras extras, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a = extras;
        this.b = str;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) bVar.a) && Intrinsics.areEqual((Object) this.b, (Object) bVar.b) && Intrinsics.areEqual((Object) this.c, (Object) bVar.c);
    }

    public int hashCode() {
        Extras extras = this.a;
        int i = 0;
        int hashCode = (((extras == null ? 0 : extras.hashCode()) * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Adapter(extras=" + this.a + ", id=" + this.b + ", version=" + this.c + ')';
    }
}
