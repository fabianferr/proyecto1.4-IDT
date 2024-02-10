package com.ironsource.mediationsdk.adunit.c.a;

import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/BannerAdManagerData;", "Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/AdManagerData;", "userId", "", "providerList", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "configs", "Lcom/ironsource/mediationsdk/model/BannerConfigurations;", "(Ljava/lang/String;Ljava/util/List;Lcom/ironsource/mediationsdk/model/BannerConfigurations;)V", "getConfigs", "()Lcom/ironsource/mediationsdk/model/BannerConfigurations;", "getProviderList", "()Ljava/util/List;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends a {
    private final String e;
    private final List<NetworkSettings> f;
    private final d g;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(java.lang.String r26, java.util.List<? extends com.ironsource.mediationsdk.model.NetworkSettings> r27, com.ironsource.mediationsdk.model.d r28) {
        /*
            r25 = this;
            r15 = r25
            r14 = r28
            java.lang.String r0 = "configs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER
            com.ironsource.mediationsdk.utils.c r4 = r14.i
            java.lang.String r0 = "configs.bannerAuctionSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            int r5 = r14.b
            long r2 = r14.c
            r6 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r6
            int r8 = (int) r2
            boolean r9 = r14.d
            int r10 = r14.h
            com.ironsource.mediationsdk.adunit.c.c.a r12 = new com.ironsource.mediationsdk.adunit.c.c.a
            com.ironsource.mediationsdk.adunit.c.c.a$a r17 = com.ironsource.mediationsdk.adunit.c.c.a.C0109a.MANUAL_WITH_AUTOMATIC_RELOAD
            com.ironsource.mediationsdk.utils.c r0 = r14.i
            long r2 = r0.i
            com.ironsource.mediationsdk.utils.c r0 = r14.i
            r24 = r12
            long r11 = r0.h
            int r0 = r14.g
            long r13 = (long) r0
            long r22 = r13 * r6
            r16 = r24
            r18 = r2
            r20 = r11
            r16.<init>(r17, r18, r20, r22)
            r14 = r28
            boolean r11 = r14.k
            long r12 = r14.l
            boolean r7 = r14.m
            boolean r6 = r14.n
            r0 = r25
            r2 = r26
            r3 = r27
            r16 = r6
            r6 = r8
            r17 = r7
            r7 = r9
            r8 = r10
            r9 = -1
            r10 = r24
            r14 = r17
            r15 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15)
            r1 = r26
            r0.e = r1
            r1 = r27
            r0.f = r1
            r1 = r28
            r0.g = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.a.b.<init>(java.lang.String, java.util.List, com.ironsource.mediationsdk.model.d):void");
    }

    public final String b() {
        return this.e;
    }

    public final List<NetworkSettings> c() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual((Object) this.e, (Object) bVar.e) && Intrinsics.areEqual((Object) this.f, (Object) bVar.f) && Intrinsics.areEqual((Object) this.g, (Object) bVar.g);
    }

    public final int hashCode() {
        String str = this.e;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.f;
        if (list != null) {
            i = list.hashCode();
        }
        return ((hashCode + i) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "BannerAdManagerData(userId=" + this.e + ", providerList=" + this.f + ", configs=" + this.g + ')';
    }
}
