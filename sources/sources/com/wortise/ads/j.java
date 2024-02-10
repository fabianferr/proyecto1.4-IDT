package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.consent.ConsentManager;
import com.wortise.ads.consent.models.ConsentData;
import com.wortise.ads.device.Dimensions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b9\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001a\u0010\r\u001a\u00020\b8\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010 \u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR(\u0010#\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR(\u0010&\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001cR\u001a\u0010,\u001a\u00020'8\u0006X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u00102\u001a\u0004\u0018\u00010-8\u0006X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00108\u001a\u0004\u0018\u0001038\u0006X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/wortise/ads/j;", "Lcom/wortise/ads/e2;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/device/Dimensions;", "size", "", "a", "", "m", "Ljava/lang/String;", "getAdUnitId", "()Ljava/lang/String;", "adUnitId", "n", "getAgent", "agent", "Lcom/wortise/ads/AdType;", "o", "Lcom/wortise/ads/AdType;", "getType", "()Lcom/wortise/ads/AdType;", "type", "", "<set-?>", "p", "Ljava/lang/Integer;", "getAdHeight", "()Ljava/lang/Integer;", "adHeight", "q", "getAdHeightDp", "adHeightDp", "r", "getAdWidth", "adWidth", "s", "getAdWidthDp", "adWidthDp", "", "t", "Z", "getChildDirected", "()Z", "childDirected", "Lcom/wortise/ads/consent/models/ConsentData;", "u", "Lcom/wortise/ads/consent/models/ConsentData;", "getConsent", "()Lcom/wortise/ads/consent/models/ConsentData;", "consent", "Lcom/wortise/ads/AdContentRating;", "v", "Lcom/wortise/ads/AdContentRating;", "getMaxContentRating", "()Lcom/wortise/ads/AdContentRating;", "maxContentRating", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/wortise/ads/AdType;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdRequest.kt */
public final class j extends e2 {
    @SerializedName("adUnitId")
    private final String m;
    @SerializedName("agent")
    private final String n;
    @SerializedName("type")
    private final AdType o;
    @SerializedName("adHeight")
    private Integer p;
    @SerializedName("adHeightDp")
    private Integer q;
    @SerializedName("adWidth")
    private Integer r;
    @SerializedName("adWidthDp")
    private Integer s;
    @SerializedName("childDirected")
    private final boolean t;
    @SerializedName("consent")
    private final ConsentData u;
    @SerializedName("maxContentRating")
    private final AdContentRating v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Context context, String str, String str2, AdType adType) {
        super(context, (Location) null, false, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(adType, "type");
        this.m = str;
        this.n = str2;
        this.o = adType;
        this.t = AdSettings.isChildDirected(context);
        this.u = ConsentManager.get(context);
        this.v = AdSettings.getMaxAdContentRating(context);
    }

    public final void a(Context context, Dimensions dimensions) {
        Integer num;
        Integer num2;
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num3 = null;
        this.p = dimensions == null ? null : Integer.valueOf(dimensions.a());
        if (dimensions == null) {
            num = null;
        } else {
            num = Integer.valueOf(dimensions.a(context));
        }
        this.q = num;
        if (dimensions == null) {
            num2 = null;
        } else {
            num2 = Integer.valueOf(dimensions.c());
        }
        this.r = num2;
        if (dimensions != null) {
            num3 = Integer.valueOf(dimensions.b(context));
        }
        this.s = num3;
    }
}
