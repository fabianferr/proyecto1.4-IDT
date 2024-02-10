package com.ironsource.mediationsdk;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.C0216f;
import com.ironsource.mediationsdk.a.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.c;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ironsource/mediationsdk/AuctionHelper;", "Lcom/ironsource/mediationsdk/AuctionHelperInterface;", "settings", "Lcom/ironsource/mediationsdk/utils/AuctionSettings;", "isOneToken", "", "sessionId", "", "(Lcom/ironsource/mediationsdk/utils/AuctionSettings;ZLjava/lang/String;)V", "generateRequest", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "auctionRequestParams", "Lcom/ironsource/mediationsdk/AuctionRequestParams;", "generateRequestTask", "Lcom/ironsource/mediationsdk/AuctionHandler$AuctionHttpRequestTask;", "auctionListener", "Lcom/ironsource/mediationsdk/AuctionCompletionListener;", "isAuctionEnabled", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.ironsource.mediationsdk.g  reason: case insensitive filesystem */
public final class C0217g {
    private final c a;
    private final boolean b;
    private final String c;

    public C0217g(c cVar, boolean z, String str) {
        Intrinsics.checkNotNullParameter(cVar, "settings");
        Intrinsics.checkNotNullParameter(str, JsonStorageKeyNames.SESSION_ID_KEY);
        this.a = cVar;
        this.b = z;
        this.c = str;
    }

    public final C0216f.a a(Context context, C0221k kVar, C0214d dVar) {
        JSONObject a2;
        C0221k kVar2 = kVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(kVar2, "auctionRequestParams");
        Intrinsics.checkNotNullParameter(dVar, "auctionListener");
        new JSONObject();
        if (this.b) {
            a2 = C0215e.a().a(kVar2);
            Intrinsics.checkNotNullExpressionValue(a2, "getInstance().enrichToke…low(auctionRequestParams)");
        } else {
            IronSourceSegment ironSourceSegment = kVar2.h;
            a2 = C0215e.a().a(context, kVar2.d, kVar2.e, kVar2.g, kVar2.f, this.c, this.a, kVar2.i, ironSourceSegment != null ? ironSourceSegment.toJson() : null, kVar2.k, kVar2.l);
            Intrinsics.checkNotNullExpressionValue(a2, "getInstance().enrichToke….useTestAds\n            )");
            a2.put("adUnit", kVar2.a);
            a2.put("doNotEncryptResponse", kVar2.c ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (kVar2.j) {
                a2.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            }
            if (kVar2.b) {
                a2.put("isOneFlow", 1);
            }
        }
        JSONObject jSONObject = a2;
        String a3 = this.a.a(kVar2.j);
        if (kVar2.j) {
            return new b(dVar, new URL(a3), jSONObject, kVar2.c, this.a.c, this.a.f, this.a.l, this.a.m, this.a.n);
        }
        return new C0216f.a(dVar, new URL(a3), jSONObject, kVar2.c, this.a.c, this.a.f, this.a.l, this.a.m, this.a.n);
    }

    public final boolean a() {
        return this.a.c > 0;
    }
}
