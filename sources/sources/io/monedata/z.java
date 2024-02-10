package io.monedata;

import com.google.gson.annotations.SerializedName;
import io.monedata.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u000f"}, d2 = {"Lio/monedata/z;", "", "", "toString", "", "hashCode", "other", "", "equals", "asset", "Lio/monedata/consent/models/ConsentData;", "consent", "uid", "<init>", "(Ljava/lang/String;Lio/monedata/consent/models/ConsentData;Ljava/lang/String;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class z {
    @SerializedName("asset")
    private final String a;
    @SerializedName("consent")
    private final ConsentData b;
    @SerializedName("uid")
    private final String c;

    public z(String str, ConsentData consentData, String str2) {
        Intrinsics.checkNotNullParameter(str, "asset");
        Intrinsics.checkNotNullParameter(consentData, "consent");
        Intrinsics.checkNotNullParameter(str2, "uid");
        this.a = str;
        this.b = consentData;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) zVar.a) && Intrinsics.areEqual((Object) this.b, (Object) zVar.b) && Intrinsics.areEqual((Object) this.c, (Object) zVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ConsentRequest(asset=" + this.a + ", consent=" + this.b + ", uid=" + this.c + ')';
    }
}
