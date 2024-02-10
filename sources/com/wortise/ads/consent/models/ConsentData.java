package com.wortise.ads.consent.models;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.AdSettings;
import com.wortise.ads.consent.ConsentManager;
import com.wortise.ads.l6;
import com.wortise.ads.m6;
import com.wortise.ads.q1;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/wortise/ads/consent/models/ConsentData;", "", "date", "Ljava/util/Date;", "granted", "", "iabString", "", "source", "Lcom/wortise/ads/consent/models/ConsentSource;", "(Ljava/util/Date;ZLjava/lang/String;Lcom/wortise/ads/consent/models/ConsentSource;)V", "getDate", "()Ljava/util/Date;", "getGranted", "()Z", "setGranted", "(Z)V", "getIabString", "()Ljava/lang/String;", "getSource", "()Lcom/wortise/ads/consent/models/ConsentSource;", "canCollectData", "context", "Landroid/content/Context;", "canRequestPersonalizedAds", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConsentData.kt */
public final class ConsentData {
    @SerializedName("date")
    private final Date date;
    @SerializedName("granted")
    private boolean granted;
    @SerializedName("iabString")
    private final String iabString;
    @SerializedName("source")
    private final ConsentSource source;

    public ConsentData(Date date2, boolean z, String str, ConsentSource consentSource) {
        this.date = date2;
        this.granted = z;
        this.iabString = str;
        this.source = consentSource;
        l6 a = q1.a(this);
        if (a != null) {
            setGranted(m6.a(a));
        }
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

    public final boolean canCollectData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !AdSettings.isChildDirected(context) && this.granted;
    }

    public final boolean canRequestPersonalizedAds(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ConsentManager.INSTANCE.canRequestPersonalizedAds$sdk_productionRelease(context, this);
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

    public final boolean getGranted() {
        return this.granted;
    }

    public final String getIabString() {
        return this.iabString;
    }

    public final ConsentSource getSource() {
        return this.source;
    }

    public int hashCode() {
        Date date2 = this.date;
        int i = 0;
        int hashCode = (date2 == null ? 0 : date2.hashCode()) * 31;
        boolean z = this.granted;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.iabString;
        int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        ConsentSource consentSource = this.source;
        if (consentSource != null) {
            i = consentSource.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setGranted(boolean z) {
        this.granted = z;
    }

    public String toString() {
        return "ConsentData(date=" + this.date + ", granted=" + this.granted + ", iabString=" + this.iabString + ", source=" + this.source + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentData(Date date2, boolean z, String str, ConsentSource consentSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(date2, z, (i & 4) != 0 ? null : str, consentSource);
    }
}
