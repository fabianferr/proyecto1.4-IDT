package io.monedata.consent.models;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import io.monedata.consent.iab.models.TcfString;
import io.monedata.v;
import io.monedata.y1;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0017\u0010\u001f\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0002\b J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lio/monedata/consent/models/ConsentData;", "", "date", "Ljava/util/Date;", "granted", "", "iabString", "", "source", "Lio/monedata/consent/models/ConsentSource;", "(Ljava/util/Date;ZLjava/lang/String;Lio/monedata/consent/models/ConsentSource;)V", "getDate", "()Ljava/util/Date;", "isGranted", "()Z", "getIabString", "()Ljava/lang/String;", "getSource", "()Lio/monedata/consent/models/ConsentSource;", "canCollectPersonalData", "context", "Landroid/content/Context;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "isEqual", "isEqual$core_productionRelease", "toString", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConsentData {
    @SerializedName("date")
    private final Date date;
    @SerializedName("granted")
    private final boolean granted;
    @SerializedName("iabString")
    private final String iabString;
    @SerializedName("source")
    private final ConsentSource source;

    public ConsentData(Date date2, boolean z, String str, ConsentSource consentSource) {
        Intrinsics.checkNotNullParameter(date2, "date");
        this.date = date2;
        this.granted = z;
        this.iabString = str;
        this.source = consentSource;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentData(Date date2, boolean z, String str, ConsentSource consentSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Date() : date2, z, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : consentSource);
    }

    public static /* synthetic */ ConsentData copy$default(ConsentData consentData, Date date2, boolean z, String str, ConsentSource consentSource, int i, Object obj) {
        if ((i & 1) != 0) {
            date2 = consentData.date;
        }
        if ((i & 2) != 0) {
            z = consentData.granted;
        }
        if ((i & 4) != 0) {
            str = consentData.iabString;
        }
        if ((i & 8) != 0) {
            consentSource = consentData.source;
        }
        return consentData.copy(date2, z, str, consentSource);
    }

    public final boolean canCollectPersonalData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TcfString a = v.a(this);
        return a != null ? y1.a(a) : this.granted;
    }

    public final Date component1() {
        return this.date;
    }

    public final boolean component2() {
        return this.granted;
    }

    public final String component3() {
        return this.iabString;
    }

    public final ConsentSource component4() {
        return this.source;
    }

    public final ConsentData copy(Date date2, boolean z, String str, ConsentSource consentSource) {
        Intrinsics.checkNotNullParameter(date2, "date");
        return new ConsentData(date2, z, str, consentSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentData)) {
            return false;
        }
        ConsentData consentData = (ConsentData) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) consentData.date) && this.granted == consentData.granted && Intrinsics.areEqual((Object) this.iabString, (Object) consentData.iabString) && this.source == consentData.source;
    }

    public final Date getDate() {
        return this.date;
    }

    public final String getIabString() {
        return this.iabString;
    }

    public final ConsentSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = this.date.hashCode() * 31;
        boolean z = this.granted;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.iabString;
        int i2 = 0;
        int hashCode2 = (i + (str == null ? 0 : str.hashCode())) * 31;
        ConsentSource consentSource = this.source;
        if (consentSource != null) {
            i2 = consentSource.hashCode();
        }
        return hashCode2 + i2;
    }

    public final boolean isEqual$core_productionRelease(ConsentData consentData) {
        return consentData != null && this.granted == consentData.granted && Intrinsics.areEqual((Object) this.iabString, (Object) consentData.iabString) && this.source == consentData.source;
    }

    public final boolean isGranted() {
        return this.granted;
    }

    public String toString() {
        return "ConsentData(date=" + this.date + ", granted=" + this.granted + ", iabString=" + this.iabString + ", source=" + this.source + ')';
    }
}
