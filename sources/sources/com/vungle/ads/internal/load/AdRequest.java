package com.vungle.ads.internal.load;

import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/vungle/ads/internal/load/AdRequest;", "Ljava/io/Serializable;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "adMarkup", "Lcom/vungle/ads/internal/model/BidPayload;", "requestAdSize", "", "(Lcom/vungle/ads/internal/model/Placement;Lcom/vungle/ads/internal/model/BidPayload;Ljava/lang/String;)V", "getAdMarkup", "()Lcom/vungle/ads/internal/model/BidPayload;", "getPlacement", "()Lcom/vungle/ads/internal/model/Placement;", "getRequestAdSize", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdRequest.kt */
public final class AdRequest implements Serializable {
    private final BidPayload adMarkup;
    private final Placement placement;
    private final String requestAdSize;

    public AdRequest(Placement placement2, BidPayload bidPayload, String str) {
        Intrinsics.checkNotNullParameter(placement2, "placement");
        Intrinsics.checkNotNullParameter(str, "requestAdSize");
        this.placement = placement2;
        this.adMarkup = bidPayload;
        this.requestAdSize = str;
    }

    public final BidPayload getAdMarkup() {
        return this.adMarkup;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    public final String getRequestAdSize() {
        return this.requestAdSize;
    }

    public String toString() {
        return "AdRequest{placementId='" + this.placement.getReferenceId() + "', adMarkup=" + this.adMarkup + ", requestAdSize=" + this.requestAdSize + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        AdRequest adRequest = (AdRequest) obj;
        if (!Intrinsics.areEqual((Object) this.placement.getReferenceId(), (Object) adRequest.placement.getReferenceId()) || !Intrinsics.areEqual((Object) this.requestAdSize, (Object) adRequest.requestAdSize)) {
            return false;
        }
        BidPayload bidPayload = this.adMarkup;
        BidPayload bidPayload2 = adRequest.adMarkup;
        if (bidPayload != null) {
            return Intrinsics.areEqual((Object) bidPayload, (Object) bidPayload2);
        }
        if (bidPayload2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.placement.getReferenceId().hashCode() * 31) + this.requestAdSize.hashCode()) * 31;
        BidPayload bidPayload = this.adMarkup;
        return hashCode + (bidPayload != null ? bidPayload.hashCode() : 0);
    }
}
