package io.monedata;

import com.google.gson.annotations.SerializedName;
import io.monedata.consent.models.ConsentData;
import io.monedata.identifier.IdentifierType;
import io.monedata.models.Extras;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001Bc\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u001d"}, d2 = {"Lio/monedata/f0;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lio/monedata/b;", "adapters", "asset", "Lio/monedata/q;", "client", "Lio/monedata/consent/models/ConsentData;", "consent", "Lio/monedata/h0;", "device", "Lio/monedata/models/Extras;", "extras", "Lio/monedata/j0;", "network", "uid", "Lio/monedata/identifier/IdentifierType;", "uidType", "version", "<init>", "(Ljava/util/List;Ljava/lang/String;Lio/monedata/q;Lio/monedata/consent/models/ConsentData;Lio/monedata/h0;Lio/monedata/models/Extras;Lio/monedata/j0;Ljava/lang/String;Lio/monedata/identifier/IdentifierType;Ljava/lang/String;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class f0 {
    @SerializedName("adapters")
    private final List<b> a;
    @SerializedName("asset")
    private final String b;
    @SerializedName("client")
    private final q c;
    @SerializedName("consent")
    private final ConsentData d;
    @SerializedName("device")
    private final h0 e;
    @SerializedName("extras")
    private final Extras f;
    @SerializedName("network")
    private final j0 g;
    @SerializedName("uid")
    private final String h;
    @SerializedName("uidType")
    private final IdentifierType i;
    @SerializedName("version")
    private final String j;

    public f0(List<b> list, String str, q qVar, ConsentData consentData, h0 h0Var, Extras extras, j0 j0Var, String str2, IdentifierType identifierType, String str3) {
        Intrinsics.checkNotNullParameter(list, "adapters");
        Intrinsics.checkNotNullParameter(str, "asset");
        Intrinsics.checkNotNullParameter(qVar, "client");
        Intrinsics.checkNotNullParameter(h0Var, "device");
        Intrinsics.checkNotNullParameter(j0Var, "network");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(identifierType, "uidType");
        Intrinsics.checkNotNullParameter(str3, "version");
        this.a = list;
        this.b = str;
        this.c = qVar;
        this.d = consentData;
        this.e = h0Var;
        this.f = extras;
        this.g = j0Var;
        this.h = str2;
        this.i = identifierType;
        this.j = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) f0Var.a) && Intrinsics.areEqual((Object) this.b, (Object) f0Var.b) && Intrinsics.areEqual((Object) this.c, (Object) f0Var.c) && Intrinsics.areEqual((Object) this.d, (Object) f0Var.d) && Intrinsics.areEqual((Object) this.e, (Object) f0Var.e) && Intrinsics.areEqual((Object) this.f, (Object) f0Var.f) && Intrinsics.areEqual((Object) this.g, (Object) f0Var.g) && Intrinsics.areEqual((Object) this.h, (Object) f0Var.h) && this.i == f0Var.i && Intrinsics.areEqual((Object) this.j, (Object) f0Var.j);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        ConsentData consentData = this.d;
        int i2 = 0;
        int hashCode2 = (((hashCode + (consentData == null ? 0 : consentData.hashCode())) * 31) + this.e.hashCode()) * 31;
        Extras extras = this.f;
        if (extras != null) {
            i2 = extras.hashCode();
        }
        return ((((((((hashCode2 + i2) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    }

    public String toString() {
        return "DataRequest(adapters=" + this.a + ", asset=" + this.b + ", client=" + this.c + ", consent=" + this.d + ", device=" + this.e + ", extras=" + this.f + ", network=" + this.g + ", uid=" + this.h + ", uidType=" + this.i + ", version=" + this.j + ')';
    }
}
