package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.C0215e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/EnrichedAdmToAuctionData;", "Lcom/ironsource/mediationsdk/Mapper;", "", "Lcom/ironsource/mediationsdk/AuctionDataUtils$AuctionData;", "()V", "map", "input", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class k implements l<String, C0215e.a> {
    public final /* synthetic */ Object a(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, "input");
        C0215e.a();
        C0215e.a a = C0215e.a(new JSONObject(str));
        Intrinsics.checkNotNullExpressionValue(a, "getInstance().getAuction…sponse(JSONObject(input))");
        return a;
    }
}
