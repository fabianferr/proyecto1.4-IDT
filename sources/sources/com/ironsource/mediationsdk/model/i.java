package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.c;
import com.ironsource.sdk.controller.x;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 C2\u00020\u0001:\u0001CBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\u0010\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010#J\u0010\u0010@\u001a\u0004\u0018\u00010#2\u0006\u0010A\u001a\u00020BR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010(\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u001a\u00100\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\u0010\u00103\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0012\u0012\u0004\u0012\u00020#05j\b\u0012\u0004\u0012\u00020#`6X\u0004¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\u001a\u0010:\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010\u0015¨\u0006D"}, d2 = {"Lcom/ironsource/mediationsdk/model/NativeAdConfigurations;", "", "adaptersSmartLoadAmount", "", "adaptersSmartLoadTimeoutInMills", "", "adapterAdvancedLoading", "", "events", "Lcom/ironsource/mediationsdk/model/ApplicationEvents;", "auctionSettings", "Lcom/ironsource/mediationsdk/utils/AuctionSettings;", "delayLoadFailure", "collectBiddingDataAsyncEnabled", "collectBiddingDataTimeout", "providersParallelInit", "waitUntilAllProvidersFinishInit", "(IJZLcom/ironsource/mediationsdk/model/ApplicationEvents;Lcom/ironsource/mediationsdk/utils/AuctionSettings;IZJZZ)V", "getAdapterAdvancedLoading$mediationsdk_release", "()Z", "setAdapterAdvancedLoading$mediationsdk_release", "(Z)V", "getAdaptersSmartLoadAmount$mediationsdk_release", "()I", "setAdaptersSmartLoadAmount$mediationsdk_release", "(I)V", "getAdaptersSmartLoadTimeoutInMills$mediationsdk_release", "()J", "setAdaptersSmartLoadTimeoutInMills$mediationsdk_release", "(J)V", "getAuctionSettings$mediationsdk_release", "()Lcom/ironsource/mediationsdk/utils/AuctionSettings;", "setAuctionSettings$mediationsdk_release", "(Lcom/ironsource/mediationsdk/utils/AuctionSettings;)V", "defaultPlacement", "Lcom/ironsource/mediationsdk/model/NativeAdPlacement;", "getDefaultPlacement", "()Lcom/ironsource/mediationsdk/model/NativeAdPlacement;", "getDelayLoadFailure$mediationsdk_release", "setDelayLoadFailure$mediationsdk_release", "eventsConfigurations", "getEventsConfigurations", "()Lcom/ironsource/mediationsdk/model/ApplicationEvents;", "setEventsConfigurations", "(Lcom/ironsource/mediationsdk/model/ApplicationEvents;)V", "mCollectBiddingDataAsyncEnabled", "getMCollectBiddingDataAsyncEnabled$mediationsdk_release", "setMCollectBiddingDataAsyncEnabled$mediationsdk_release", "mCollectBiddingDataTimeout", "getMCollectBiddingDataTimeout$mediationsdk_release", "setMCollectBiddingDataTimeout$mediationsdk_release", "mDefaultPlacement", "mPlacements", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mProvidersParallelInit", "getMProvidersParallelInit$mediationsdk_release", "setMProvidersParallelInit$mediationsdk_release", "mWaitUntilAllProvidersFinishInit", "getMWaitUntilAllProvidersFinishInit$mediationsdk_release", "setMWaitUntilAllProvidersFinishInit$mediationsdk_release", "addPlacement", "", "placement", "getPlacement", "placementName", "", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i {
    public int a;
    public long b;
    public boolean c;
    public int d;
    public c e;
    public boolean f;
    public long g;
    public boolean h;
    public boolean i;
    private x j;
    private final ArrayList<j> k = new ArrayList<>();
    private j l;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ironsource/mediationsdk/model/NativeAdConfigurations$Companion;", "", "()V", "DEFAULT_NA_PLACEMENT_ID", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        new a((byte) 0);
    }

    public i(int i2, long j2, boolean z, x xVar, c cVar, int i3, boolean z2, long j3, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(xVar, "events");
        Intrinsics.checkNotNullParameter(cVar, "auctionSettings");
        this.a = i2;
        this.b = j2;
        this.c = z;
        this.j = xVar;
        this.d = i3;
        this.e = cVar;
        this.f = z2;
        this.g = j3;
        this.h = z3;
        this.i = z4;
    }

    public final j a(String str) {
        Intrinsics.checkNotNullParameter(str, "placementName");
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (Intrinsics.areEqual((Object) next.getPlacementName(), (Object) str)) {
                return next;
            }
        }
        return null;
    }

    public final x a() {
        return this.j;
    }

    public final void a(j jVar) {
        if (jVar != null) {
            this.k.add(jVar);
            if (this.l == null) {
                this.l = jVar;
            } else if (jVar.getPlacementId() == 0) {
                this.l = jVar;
            }
        }
    }

    public final j b() {
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.l;
    }
}
