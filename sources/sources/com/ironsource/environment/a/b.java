package com.ironsource.environment.a;

import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.c.a;
import com.ironsource.environment.c.c;
import com.ironsource.environment.c.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000e\u001a\u00020\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ironsource/environment/auction/AuctionProvider;", "", "adUnit", "Lcom/ironsource/environment/globaldata/GlobalDataConstants$AdUnit;", "(Lcom/ironsource/environment/globaldata/GlobalDataConstants$AdUnit;)V", "mAuctionKeyList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mGlobalDataReader", "Lcom/ironsource/environment/globaldata/GlobalDataReader;", "formatDataMetaData", "Lorg/json/JSONObject;", "tokenData", "getAuctionData", "environment_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {
    private final a.C0105a a;
    private final ArrayList<String> b = new ArrayList<>(new a().a);
    private final c c = new c();

    public b(a.C0105a aVar) {
        this.a = aVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject;
        a.C0105a aVar = this.a;
        if (aVar != null) {
            c cVar = this.c;
            List list = this.b;
            jSONObject = c.a(cVar.a(ContextProvider.getInstance().getApplicationContext(), aVar), (String[]) list.toArray(new String[list.size()]));
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = this.c.a((List<String>) this.b);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "mGlobalDataReader.getDataByKeys(mAuctionKeyList)");
        }
        JSONObject a2 = d.a(jSONObject.optJSONObject("md"));
        if (a2 != null) {
            jSONObject.put("md", a2);
        }
        return jSONObject;
    }
}
