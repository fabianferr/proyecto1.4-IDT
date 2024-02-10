package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.wortise.ads.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/x1;", "", "", "toString", "", "hashCode", "other", "", "equals", "assetKey", "auid", "Lcom/wortise/ads/consent/models/ConsentData;", "consent", "udid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/wortise/ads/consent/models/ConsentData;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConsentSubmitRequest.kt */
public final class x1 {
    @SerializedName("assetKey")
    private final String a;
    @SerializedName("auid")
    private final String b;
    @SerializedName("consent")
    private final ConsentData c;
    @SerializedName("udid")
    private final String d;

    public x1(String str, String str2, ConsentData consentData, String str3) {
        Intrinsics.checkNotNullParameter(str, "assetKey");
        Intrinsics.checkNotNullParameter(str2, JsonStorageKeyNames.AUID_ID_KEY);
        Intrinsics.checkNotNullParameter(consentData, "consent");
        this.a = str;
        this.b = str2;
        this.c = consentData;
        this.d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) x1Var.a) && Intrinsics.areEqual((Object) this.b, (Object) x1Var.b) && Intrinsics.areEqual((Object) this.c, (Object) x1Var.c) && Intrinsics.areEqual((Object) this.d, (Object) x1Var.d);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ConsentSubmitRequest(assetKey=" + this.a + ", auid=" + this.b + ", consent=" + this.c + ", udid=" + this.d + ')';
    }
}
