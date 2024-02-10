package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.b.c;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\b\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyEvents;", "", "sendEvent", "", "eventId", "", "instanceId", "", "EventBaseData", "ManagerEvents", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface e {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0001J\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyEvents$EventBaseData;", "", "providerName", "", "(Ljava/lang/String;)V", "data", "", "add", "", "key", "value", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        final Map<String, Object> a;

        public a(String str) {
            Intrinsics.checkNotNullParameter(str, "providerName");
            this.a = MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_PROVIDER, str), TuplesKt.to(IronSourceConstants.EVENTS_DEMAND_ONLY, 1));
        }

        public final void a(String str, Object obj) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(obj, "value");
            this.a.put(str, obj);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyEvents$ManagerEvents;", "Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyEvents;", "eventManager", "Lcom/ironsource/eventsmodule/IEventsManager;", "eventBaseData", "Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyEvents$EventBaseData;", "(Lcom/ironsource/eventsmodule/IEventsManager;Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyEvents$EventBaseData;)V", "sendEvent", "", "eventId", "", "instanceId", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements e {
        private final c a;
        private final a b;

        public b(c cVar, a aVar) {
            Intrinsics.checkNotNullParameter(cVar, "eventManager");
            Intrinsics.checkNotNullParameter(aVar, "eventBaseData");
            this.a = cVar;
            this.b = aVar;
        }

        public final void a(int i, String str) {
            Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID);
            Map<String, Object> mutableMap = MapsKt.toMutableMap(this.b.a);
            mutableMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, str);
            this.a.a(new com.ironsource.environment.c.a(i, new JSONObject(MapsKt.toMap(mutableMap))));
        }
    }

    void a(int i, String str);
}
