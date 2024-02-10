package com.ironsource.mediationsdk.adunit.c.a;

import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/RewardedVideoAdDataManager;", "Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/AdManagerData;", "userId", "", "providerList", "", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "configs", "Lcom/ironsource/mediationsdk/model/RewardedVideoConfigurations;", "isManual", "", "(Ljava/lang/String;Ljava/util/List;Lcom/ironsource/mediationsdk/model/RewardedVideoConfigurations;Z)V", "getConfigs", "()Lcom/ironsource/mediationsdk/model/RewardedVideoConfigurations;", "()Z", "getProviderList", "()Ljava/util/List;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e extends a {
    private final String e;
    private final List<NetworkSettings> f;
    private final q g;
    private final boolean h;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(java.lang.String r25, java.util.List<? extends com.ironsource.mediationsdk.model.NetworkSettings> r26, com.ironsource.mediationsdk.model.q r27, boolean r28) {
        /*
            r24 = this;
            r15 = r24
            r14 = r27
            r12 = r28
            java.lang.String r0 = "configs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO
            com.ironsource.mediationsdk.utils.c r4 = r14.m
            java.lang.String r0 = "configs.rewardedVideoAuctionSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            int r5 = r14.c
            int r6 = r14.e
            boolean r7 = r14.d
            int r8 = r14.g
            int r9 = r14.f
            if (r12 == 0) goto L_0x0025
            com.ironsource.mediationsdk.adunit.c.c.a$a r0 = com.ironsource.mediationsdk.adunit.c.c.a.C0109a.MANUAL
        L_0x0022:
            r17 = r0
            goto L_0x0031
        L_0x0025:
            com.ironsource.mediationsdk.utils.c r0 = r14.m
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x002e
            com.ironsource.mediationsdk.adunit.c.c.a$a r0 = com.ironsource.mediationsdk.adunit.c.c.a.C0109a.AUTOMATIC_LOAD_WHILE_SHOW
            goto L_0x0022
        L_0x002e:
            com.ironsource.mediationsdk.adunit.c.c.a$a r0 = com.ironsource.mediationsdk.adunit.c.c.a.C0109a.AUTOMATIC_LOAD_AFTER_CLOSE
            goto L_0x0022
        L_0x0031:
            com.ironsource.mediationsdk.adunit.c.c.a r10 = new com.ironsource.mediationsdk.adunit.c.c.a
            com.ironsource.mediationsdk.utils.c r0 = r14.m
            long r2 = r0.i
            com.ironsource.mediationsdk.utils.c r0 = r14.m
            long r11 = r0.h
            r22 = -1
            r16 = r10
            r18 = r2
            r20 = r11
            r16.<init>(r17, r18, r20, r22)
            boolean r11 = r14.h
            long r12 = r14.i
            boolean r3 = r14.j
            boolean r2 = r14.k
            r0 = r24
            r16 = r2
            r2 = r25
            r17 = r3
            r3 = r26
            r14 = r17
            r15 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15)
            r1 = r25
            r0.e = r1
            r1 = r26
            r0.f = r1
            r1 = r27
            r0.g = r1
            r1 = r28
            r0.h = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.a.e.<init>(java.lang.String, java.util.List, com.ironsource.mediationsdk.model.q, boolean):void");
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
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual((Object) this.e, (Object) eVar.e) && Intrinsics.areEqual((Object) this.f, (Object) eVar.f) && Intrinsics.areEqual((Object) this.g, (Object) eVar.g) && this.h == eVar.h;
    }

    public final int hashCode() {
        String str = this.e;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<NetworkSettings> list = this.f;
        if (list != null) {
            i = list.hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + this.g.hashCode()) * 31;
        boolean z = this.h;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    public final String toString() {
        return "RewardedVideoAdDataManager(userId=" + this.e + ", providerList=" + this.f + ", configs=" + this.g + ", isManual=" + this.h + ')';
    }
}
