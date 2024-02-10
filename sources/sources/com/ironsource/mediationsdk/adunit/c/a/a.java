package com.ironsource.mediationsdk.adunit.c.a;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\b\u0016\u0018\u0000 32\u00020\u0001:\u00013B\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0002\u0010\u0019J\u0010\u00100\u001a\u0004\u0018\u00010\b2\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u000fR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0017\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0018\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001f¨\u00064"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/AdManagerData;", "", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "userId", "", "providerList", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "auctionSettings", "Lcom/ironsource/mediationsdk/utils/AuctionSettings;", "maxSmashesToLoad", "", "smashLoadTimeout", "advancedLoading", "", "delayLoadFailure", "adExpirationInMinutes", "loadingData", "Lcom/ironsource/mediationsdk/adunit/manager/loading/AdUnitLoadingData;", "collectBiddingDataAsyncEnabled", "collectBiddingDataTimeout", "", "providersParallelInit", "waitUntilAllProvidersFinishInit", "(Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;Ljava/lang/String;Ljava/util/List;Lcom/ironsource/mediationsdk/utils/AuctionSettings;IIZIILcom/ironsource/mediationsdk/adunit/manager/loading/AdUnitLoadingData;ZJZZ)V", "getAdExpirationInMinutes", "()I", "getAdUnit", "()Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "getAdvancedLoading", "()Z", "getAuctionSettings", "()Lcom/ironsource/mediationsdk/utils/AuctionSettings;", "getCollectBiddingDataAsyncEnabled", "getCollectBiddingDataTimeout", "()J", "getDelayLoadFailure", "getLoadingData", "()Lcom/ironsource/mediationsdk/adunit/manager/loading/AdUnitLoadingData;", "getMaxSmashesToLoad", "getProviderList", "()Ljava/util/List;", "getProvidersParallelInit", "getSmashLoadTimeout", "getUserId", "()Ljava/lang/String;", "getWaitUntilAllProvidersFinishInit", "getProviderSettings", "instanceName", "isAuctionEnabled", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a {
    public final IronSource.AD_UNIT a;
    public final int b;
    public final int c;
    public final boolean d;
    private final String e;
    private final List<NetworkSettings> f;
    private final c g;
    private final int h;
    private final int i;
    private final com.ironsource.mediationsdk.adunit.c.c.a j;
    private final boolean k;
    private final long l;
    private final boolean m;
    private final boolean n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/AdManagerData$Companion;", "", "()V", "DISABLED", "", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.ironsource.mediationsdk.adunit.c.a.a$a  reason: collision with other inner class name */
    public static final class C0108a {
        private C0108a() {
        }

        public /* synthetic */ C0108a(byte b) {
            this();
        }
    }

    static {
        new C0108a((byte) 0);
    }

    public a(IronSource.AD_UNIT ad_unit, String str, List<? extends NetworkSettings> list, c cVar, int i2, int i3, boolean z, int i4, int i5, com.ironsource.mediationsdk.adunit.c.c.a aVar, boolean z2, long j2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        Intrinsics.checkNotNullParameter(cVar, "auctionSettings");
        Intrinsics.checkNotNullParameter(aVar, "loadingData");
        this.a = ad_unit;
        this.e = str;
        this.f = list;
        this.g = cVar;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.h = i4;
        this.i = i5;
        this.j = aVar;
        this.k = z2;
        this.l = j2;
        this.m = z3;
        this.n = z4;
    }

    public final IronSource.AD_UNIT a() {
        return this.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.ironsource.mediationsdk.model.NetworkSettings} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.ironsource.mediationsdk.model.NetworkSettings} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.ironsource.mediationsdk.model.NetworkSettings} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.ironsource.mediationsdk.model.NetworkSettings} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ironsource.mediationsdk.model.NetworkSettings a(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "instanceName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List r0 = r4.c()
            r1 = 0
            if (r0 == 0) goto L_0x002c
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.ironsource.mediationsdk.model.NetworkSettings r3 = (com.ironsource.mediationsdk.model.NetworkSettings) r3
            java.lang.String r3 = r3.getProviderInstanceName()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0012
            r1 = r2
        L_0x002a:
            com.ironsource.mediationsdk.model.NetworkSettings r1 = (com.ironsource.mediationsdk.model.NetworkSettings) r1
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.a.a.a(java.lang.String):com.ironsource.mediationsdk.model.NetworkSettings");
    }

    public String b() {
        return this.e;
    }

    public List<NetworkSettings> c() {
        return this.f;
    }

    public final c d() {
        return this.g;
    }

    public final int e() {
        return this.c;
    }

    public final int f() {
        return this.h;
    }

    public final int g() {
        return this.i;
    }

    public final com.ironsource.mediationsdk.adunit.c.c.a h() {
        return this.j;
    }

    public final boolean i() {
        return this.k;
    }

    public final long j() {
        return this.l;
    }

    public final boolean k() {
        return this.m;
    }

    public final boolean l() {
        return this.n;
    }

    public final boolean m() {
        return this.g.c > 0;
    }
}
