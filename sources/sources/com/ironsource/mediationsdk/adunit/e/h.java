package com.ironsource.mediationsdk.adunit.e;

import com.ironsource.mediationsdk.adunit.d.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 !*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003:\u0001!B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020\u0019H\u0016R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSmashPicker;", "Smash", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "", "maxSmashesToLoad", "", "waterfall", "", "waterfallFromServer", "", "", "Lcom/ironsource/mediationsdk/AuctionResponseItem;", "(ILjava/util/List;Ljava/util/Map;)V", "loadedSmashes", "", "loadingInProgressSmashes", "getLoadingInProgressSmashes$mediationsdk_release", "()Ljava/util/List;", "smashesToLoad", "getSmashesToLoad$mediationsdk_release", "getLowestLoadedShowOrderIndex", "getShowOrderIndex", "smash", "(Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;)I", "isBetterSmashAlreadyLoaded", "", "(Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;)Z", "numOfTotalLoadingCandidates", "pickEligibleSmash", "", "(Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;)V", "pickSmash", "shouldStopPicking", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class h<Smash extends c<?>> {
    public static final a a = new a((byte) 0);
    final List<Smash> b = new ArrayList();
    final List<Smash> c = new ArrayList();
    final List<Smash> d = new ArrayList();
    private final int e;
    private final List<Smash> f;
    private final Map<String, com.ironsource.mediationsdk.adunit.a.a> g;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\f\b\u0001\u0010\u0005*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¨\u0006\u0011"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSmashPicker$Companion;", "", "()V", "createSmashPicker", "Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSmashPicker;", "Smash", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "loadingStrategy", "Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallLoadingStrategy;", "maxSmashesToLoad", "", "waterfall", "", "waterfallFromServer", "", "", "Lcom/ironsource/mediationsdk/AuctionResponseItem;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.ironsource.mediationsdk.adunit.e.h$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0110a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[e.values().length];
                iArr[e.DEFAULT.ordinal()] = 1;
                iArr[e.BIDDER_SENSITIVE.ordinal()] = 2;
                a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public h(int i, List<? extends Smash> list, Map<String, ? extends com.ironsource.mediationsdk.adunit.a.a> map) {
        Intrinsics.checkNotNullParameter(list, "waterfall");
        Intrinsics.checkNotNullParameter(map, "waterfallFromServer");
        this.e = i;
        this.f = list;
        this.g = map;
    }

    public abstract void a(Smash smash);

    public boolean a() {
        return b() >= this.e;
    }

    public final int b() {
        return this.b.size() + this.c.size() + this.d.size();
    }

    /* access modifiers changed from: package-private */
    public final int b(Smash smash) {
        com.ironsource.mediationsdk.adunit.a.a aVar = this.g.get(smash.n());
        if (aVar != null) {
            return aVar.e();
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        Comparable comparable;
        Collection arrayList = new ArrayList();
        for (Object next : this.f) {
            if (((c) next).g()) {
                arrayList.add(next);
            }
        }
        Iterator it = ((List) arrayList).iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Comparable valueOf = Integer.valueOf(b((c) it.next()));
            while (it.hasNext()) {
                Comparable valueOf2 = Integer.valueOf(b((c) it.next()));
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
            comparable = valueOf;
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }
}
