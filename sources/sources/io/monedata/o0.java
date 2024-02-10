package io.monedata;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0014"}, d2 = {"Lio/monedata/o0;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lio/monedata/b;", "adapter", "asset", "Lio/monedata/q;", "client", "Lio/monedata/h0;", "device", "stackTrace", "version", "<init>", "(Lio/monedata/b;Ljava/lang/String;Lio/monedata/q;Lio/monedata/h0;Ljava/lang/String;Ljava/lang/String;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class o0 {
    @SerializedName("adapter")
    private final b a;
    @SerializedName("asset")
    private final String b;
    @SerializedName("client")
    private final q c;
    @SerializedName("device")
    private final h0 d;
    @SerializedName("stackTrace")
    private final String e;
    @SerializedName("version")
    private final String f;

    public o0(b bVar, String str, q qVar, h0 h0Var, String str2, String str3) {
        Intrinsics.checkNotNullParameter(bVar, "adapter");
        Intrinsics.checkNotNullParameter(qVar, "client");
        Intrinsics.checkNotNullParameter(h0Var, "device");
        Intrinsics.checkNotNullParameter(str2, "stackTrace");
        Intrinsics.checkNotNullParameter(str3, "version");
        this.a = bVar;
        this.b = str;
        this.c = qVar;
        this.d = h0Var;
        this.e = str2;
        this.f = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) o0Var.a) && Intrinsics.areEqual((Object) this.b, (Object) o0Var.b) && Intrinsics.areEqual((Object) this.c, (Object) o0Var.c) && Intrinsics.areEqual((Object) this.d, (Object) o0Var.d) && Intrinsics.areEqual((Object) this.e, (Object) o0Var.e) && Intrinsics.areEqual((Object) this.f, (Object) o0Var.f);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "ErrorRequest(adapter=" + this.a + ", asset=" + this.b + ", client=" + this.c + ", device=" + this.d + ", stackTrace=" + this.e + ", version=" + this.f + ')';
    }
}
