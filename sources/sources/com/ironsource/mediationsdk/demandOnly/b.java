package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyAuctionWaterfall;", "", "createWaterfallStringFromAuctionItems", "", "get", "Lcom/ironsource/mediationsdk/AuctionResponseItem;", "index", "", "getAuctionResponseItem", "instanceName", "isEmpty", "", "Base", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface b {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyAuctionWaterfall$Base;", "Lcom/ironsource/mediationsdk/demandOnly/DemandOnlyAuctionWaterfall;", "waterfall", "", "Lcom/ironsource/mediationsdk/AuctionResponseItem;", "(Ljava/util/List;)V", "createWaterfallStringFromAuctionItems", "", "get", "index", "", "getAuctionResponseItem", "instanceName", "isEmpty", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements b {
        private final List<com.ironsource.mediationsdk.adunit.a.a> a;

        public a() {
            this((List) null, 1);
        }

        public a(List<com.ironsource.mediationsdk.adunit.a.a> list) {
            Intrinsics.checkNotNullParameter(list, "waterfall");
            this.a = list;
        }

        private /* synthetic */ a(List list, int i) {
            this(new ArrayList());
        }

        public final com.ironsource.mediationsdk.adunit.a.a a(int i) {
            return this.a.get(0);
        }

        public final com.ironsource.mediationsdk.adunit.a.a a(String str) {
            Object obj;
            Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_NAME);
            Iterator it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((com.ironsource.mediationsdk.adunit.a.a) obj).a(), (Object) str)) {
                    break;
                }
            }
            return (com.ironsource.mediationsdk.adunit.a.a) obj;
        }

        public final String a() {
            if (this.a.isEmpty()) {
                return "";
            }
            return "1" + ((com.ironsource.mediationsdk.adunit.a.a) CollectionsKt.first(this.a)).a();
        }

        public final boolean b() {
            return this.a.isEmpty();
        }
    }

    com.ironsource.mediationsdk.adunit.a.a a(int i);

    com.ironsource.mediationsdk.adunit.a.a a(String str);

    String a();

    boolean b();
}
