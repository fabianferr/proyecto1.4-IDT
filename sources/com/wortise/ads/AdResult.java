package com.wortise.ads;

import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J*\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/wortise/ads/AdResult;", "", "ads", "", "Lcom/wortise/ads/AdResponse;", "refreshTime", "", "(Ljava/util/List;Ljava/lang/Long;)V", "getAds", "()Ljava/util/List;", "<set-?>", "", "index", "getIndex", "()I", "getRefreshTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "size", "getSize", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Long;)Lcom/wortise/ads/AdResult;", "equals", "", "other", "hashCode", "nextAd", "toString", "", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AdResult.kt */
public final class AdResult {
    @SerializedName("ads")
    private final List<AdResponse> ads;
    private transient int index;
    @SerializedName("refreshTime")
    private final Long refreshTime;

    public AdResult() {
        this((List) null, (Long) null, 3, (DefaultConstructorMarker) null);
    }

    public AdResult(List<AdResponse> list, Long l) {
        Intrinsics.checkNotNullParameter(list, CampaignUnit.JSON_KEY_ADS);
        this.ads = list;
        this.refreshTime = l;
    }

    public static /* synthetic */ AdResult copy$default(AdResult adResult, List<AdResponse> list, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            list = adResult.ads;
        }
        if ((i & 2) != 0) {
            l = adResult.refreshTime;
        }
        return adResult.copy(list, l);
    }

    public final List<AdResponse> component1() {
        return this.ads;
    }

    public final Long component2() {
        return this.refreshTime;
    }

    public final AdResult copy(List<AdResponse> list, Long l) {
        Intrinsics.checkNotNullParameter(list, CampaignUnit.JSON_KEY_ADS);
        return new AdResult(list, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdResult)) {
            return false;
        }
        AdResult adResult = (AdResult) obj;
        return Intrinsics.areEqual((Object) this.ads, (Object) adResult.ads) && Intrinsics.areEqual((Object) this.refreshTime, (Object) adResult.refreshTime);
    }

    public final List<AdResponse> getAds() {
        return this.ads;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Long getRefreshTime() {
        return this.refreshTime;
    }

    public final int getSize() {
        return this.ads.size();
    }

    public int hashCode() {
        int hashCode = this.ads.hashCode() * 31;
        Long l = this.refreshTime;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    public final AdResponse nextAd() {
        try {
            if (getIndex() >= getSize()) {
                return null;
            }
            List<AdResponse> ads2 = getAds();
            int index2 = getIndex();
            this.index = index2 + 1;
            return (AdResponse) CollectionsKt.getOrNull(ads2, index2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        return "AdResult(ads=" + this.ads + ", refreshTime=" + this.refreshTime + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdResult(List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : l);
    }
}
