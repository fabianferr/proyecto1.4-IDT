package com.ironsource.mediationsdk;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u001d\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/ironsource/mediationsdk/AuctionInstanceInfo;", "", "name", "", "bidder", "", "(Ljava/lang/String;Z)V", "additionalData", "", "getAdditionalData", "()Ljava/util/Map;", "setAdditionalData", "(Ljava/util/Map;)V", "auctionHistory", "Lcom/ironsource/mediationsdk/AuctionHistory;", "getAuctionHistory", "()Lcom/ironsource/mediationsdk/AuctionHistory;", "setAuctionHistory", "(Lcom/ironsource/mediationsdk/AuctionHistory;)V", "getBidder", "()Z", "biddingData", "", "getBiddingData", "setBiddingData", "getName", "()Ljava/lang/String;", "plumbus", "getPlumbus", "setPlumbus", "(Ljava/lang/String;)V", "useTestAds", "getUseTestAds", "setUseTestAds", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.ironsource.mediationsdk.i  reason: case insensitive filesystem */
public final class C0219i {
    private final String a;
    private final boolean b = false;
    private String c = "";
    private Map<String, ? extends Object> d = MapsKt.emptyMap();
    private Map<String, Object> e = new HashMap();

    public C0219i(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void a(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.d = map;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final Map<String, Object> d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0219i)) {
            return false;
        }
        C0219i iVar = (C0219i) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) iVar.a) && this.b == iVar.b;
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "AuctionInstanceInfo(name=" + this.a + ", bidder=" + this.b + ')';
    }
}
