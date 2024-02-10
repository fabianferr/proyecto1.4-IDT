package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020#J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u0013\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010Q\u001a\u00020(2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020>HÖ\u0001J\t\u0010T\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R!\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R*\u00100\u001a\b\u0012\u0004\u0012\u00020\u0015018\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0017\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001a\u0010F\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+R\u001a\u0010I\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001e\"\u0004\bK\u0010 ¨\u0006U"}, d2 = {"Lcom/ironsource/mediationsdk/AuctionRequestParams;", "", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;)V", "getAdUnit", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "auctionHistory", "Lcom/ironsource/mediationsdk/AuctionHistory;", "getAuctionHistory", "()Lcom/ironsource/mediationsdk/AuctionHistory;", "setAuctionHistory", "(Lcom/ironsource/mediationsdk/AuctionHistory;)V", "bannerSize", "Lcom/ironsource/mediationsdk/ISBannerSize;", "getBannerSize", "()Lcom/ironsource/mediationsdk/ISBannerSize;", "setBannerSize", "(Lcom/ironsource/mediationsdk/ISBannerSize;)V", "bidders", "", "", "getBidders$annotations", "()V", "getBidders", "()Ljava/util/Map;", "setBidders", "(Ljava/util/Map;)V", "instanceId", "getInstanceId", "()Ljava/lang/String;", "setInstanceId", "(Ljava/lang/String;)V", "instancesInfo", "Ljava/util/ArrayList;", "Lcom/ironsource/mediationsdk/AuctionInstanceInfo;", "Lkotlin/collections/ArrayList;", "getInstancesInfo", "()Ljava/util/ArrayList;", "isDemandOnly", "", "()Z", "setDemandOnly", "(Z)V", "isEncryptedResponse", "setEncryptedResponse", "isOneFlow", "setOneFlow", "nonBidders", "", "getNonBidders$annotations", "getNonBidders", "()Ljava/util/List;", "setNonBidders", "(Ljava/util/List;)V", "segment", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "getSegment", "()Lcom/ironsource/mediationsdk/IronSourceSegment;", "setSegment", "(Lcom/ironsource/mediationsdk/IronSourceSegment;)V", "sessionDepth", "", "getSessionDepth", "()I", "setSessionDepth", "(I)V", "testSuiteLaunched", "getTestSuiteLaunched", "setTestSuiteLaunched", "useTestAds", "getUseTestAds", "setUseTestAds", "waterfallString", "getWaterfallString", "setWaterfallString", "addInstanceInfo", "", "instanceInfo", "component1", "copy", "equals", "other", "hashCode", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.ironsource.mediationsdk.k  reason: case insensitive filesystem */
public final class C0221k {
    final IronSource.AD_UNIT a;
    boolean b;
    boolean c;
    Map<String, Object> d = new HashMap();
    List<String> e = new ArrayList();
    int f = -1;
    C0218h g;
    IronSourceSegment h;
    ISBannerSize i;
    boolean j;
    boolean k;
    boolean l;
    private final ArrayList<C0219i> m = new ArrayList<>();
    private String n = "";
    private String o = "";

    public C0221k(IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        this.a = ad_unit;
    }

    public final IronSource.AD_UNIT a() {
        return this.a;
    }

    public final void a(int i2) {
        this.f = i2;
    }

    public final void a(ISBannerSize iSBannerSize) {
        this.i = iSBannerSize;
    }

    public final void a(IronSourceSegment ironSourceSegment) {
        this.h = ironSourceSegment;
    }

    public final void a(C0218h hVar) {
        this.g = hVar;
    }

    public final void a(C0219i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "instanceInfo");
        this.m.add(iVar);
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.n = str;
    }

    public final void a(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.e = list;
    }

    public final void a(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.d = map;
    }

    public final void a(boolean z) {
        this.b = true;
    }

    public final ArrayList<C0219i> b() {
        return this.m;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.o = str;
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final void c(boolean z) {
        this.j = true;
    }

    public final boolean c() {
        return this.b;
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public final boolean d() {
        return this.c;
    }

    public final Map<String, Object> e() {
        return this.d;
    }

    public final void e(boolean z) {
        this.l = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0221k) && this.a == ((C0221k) obj).a;
    }

    public final List<String> f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    public final C0218h h() {
        return this.g;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final IronSourceSegment i() {
        return this.h;
    }

    public final String j() {
        return this.o;
    }

    public final ISBannerSize k() {
        return this.i;
    }

    public final boolean l() {
        return this.j;
    }

    public final boolean m() {
        return this.k;
    }

    public final boolean n() {
        return this.l;
    }

    public final String toString() {
        return "AuctionRequestParams(adUnit=" + this.a + ')';
    }
}
