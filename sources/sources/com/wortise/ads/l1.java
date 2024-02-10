package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.wortise.ads.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/wortise/ads/l1;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/wortise/ads/consent/models/ConsentData;", "consent", "Lcom/wortise/ads/consent/models/ConsentData;", "a", "()Lcom/wortise/ads/consent/models/ConsentData;", "Lcom/wortise/ads/e3;", "geosmart", "Lcom/wortise/ads/e3;", "b", "()Lcom/wortise/ads/e3;", "requiresConsent", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "<init>", "(Lcom/wortise/ads/consent/models/ConsentData;Lcom/wortise/ads/e3;Ljava/lang/Boolean;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Config.kt */
public final class l1 {
    @SerializedName("consent")
    private final ConsentData a;
    @SerializedName("geosmart")
    private final e3 b;
    @SerializedName("requiresConsent")
    private final Boolean c;

    public l1() {
        this((ConsentData) null, (e3) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public l1(ConsentData consentData, e3 e3Var, Boolean bool) {
        this.a = consentData;
        this.b = e3Var;
        this.c = bool;
    }

    public final ConsentData a() {
        return this.a;
    }

    public final e3 b() {
        return this.b;
    }

    public final Boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) l1Var.a) && Intrinsics.areEqual((Object) this.b, (Object) l1Var.b) && Intrinsics.areEqual((Object) this.c, (Object) l1Var.c);
    }

    public int hashCode() {
        ConsentData consentData = this.a;
        int i = 0;
        int hashCode = (consentData == null ? 0 : consentData.hashCode()) * 31;
        e3 e3Var = this.b;
        int hashCode2 = (hashCode + (e3Var == null ? 0 : e3Var.hashCode())) * 31;
        Boolean bool = this.c;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Config(consent=" + this.a + ", geosmart=" + this.b + ", requiresConsent=" + this.c + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l1(ConsentData consentData, e3 e3Var, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : consentData, (i & 2) != 0 ? null : e3Var, (i & 4) != 0 ? null : bool);
    }
}
