package com.ironsource.mediationsdk.a;

import com.ironsource.mediationsdk.demandOnly.q;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/ironsource/mediationsdk/auction/AuctionDataInstances;", "", "getPlumbus", "Lcom/ironsource/mediationsdk/demandOnly/Plumbus;", "instanceId", "", "Base", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ironsource/mediationsdk/auction/AuctionDataInstances$Base;", "Lcom/ironsource/mediationsdk/auction/AuctionDataInstances;", "instances", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getPlumbus", "Lcom/ironsource/mediationsdk/demandOnly/Plumbus;", "instanceId", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.ironsource.mediationsdk.a.a$a  reason: collision with other inner class name */
    public static final class C0107a implements a {
        private final JSONObject a;

        public C0107a() {
            this((JSONObject) null, 1);
        }

        public C0107a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        private /* synthetic */ C0107a(JSONObject jSONObject, int i) {
            this(new JSONObject());
        }

        public final q a(String str) {
            Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID);
            JSONObject jSONObject = this.a;
            String str2 = null;
            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(str) : null;
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("plumbus");
            }
            return str2 != null ? new q.a(str2) : new q.b();
        }
    }

    q a(String str);
}
