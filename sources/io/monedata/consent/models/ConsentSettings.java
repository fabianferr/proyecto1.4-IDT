package io.monedata.consent.models;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/monedata/consent/models/ConsentSettings;", "", "allowText", "", "denyText", "message", "required", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAllowText", "()Ljava/lang/String;", "getDenyText", "getMessage", "getRequired", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConsentSettings {
    @SerializedName("allowText")
    private final String allowText;
    @SerializedName("denyText")
    private final String denyText;
    @SerializedName("message")
    private final String message;
    @SerializedName("required")
    private final boolean required;

    public ConsentSettings(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "allowText");
        Intrinsics.checkNotNullParameter(str2, "denyText");
        Intrinsics.checkNotNullParameter(str3, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.allowText = str;
        this.denyText = str2;
        this.message = str3;
        this.required = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentSettings(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? true : z);
    }

    public static /* synthetic */ ConsentSettings copy$default(ConsentSettings consentSettings, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consentSettings.allowText;
        }
        if ((i & 2) != 0) {
            str2 = consentSettings.denyText;
        }
        if ((i & 4) != 0) {
            str3 = consentSettings.message;
        }
        if ((i & 8) != 0) {
            z = consentSettings.required;
        }
        return consentSettings.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.allowText;
    }

    public final String component2() {
        return this.denyText;
    }

    public final String component3() {
        return this.message;
    }

    public final boolean component4() {
        return this.required;
    }

    public final ConsentSettings copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "allowText");
        Intrinsics.checkNotNullParameter(str2, "denyText");
        Intrinsics.checkNotNullParameter(str3, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new ConsentSettings(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentSettings)) {
            return false;
        }
        ConsentSettings consentSettings = (ConsentSettings) obj;
        return Intrinsics.areEqual((Object) this.allowText, (Object) consentSettings.allowText) && Intrinsics.areEqual((Object) this.denyText, (Object) consentSettings.denyText) && Intrinsics.areEqual((Object) this.message, (Object) consentSettings.message) && this.required == consentSettings.required;
    }

    public final String getAllowText() {
        return this.allowText;
    }

    public final String getDenyText() {
        return this.denyText;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public int hashCode() {
        int hashCode = ((((this.allowText.hashCode() * 31) + this.denyText.hashCode()) * 31) + this.message.hashCode()) * 31;
        boolean z = this.required;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ConsentSettings(allowText=" + this.allowText + ", denyText=" + this.denyText + ", message=" + this.message + ", required=" + this.required + ')';
    }
}
