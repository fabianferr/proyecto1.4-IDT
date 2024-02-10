package com.ironsource.mediationsdk.adunit.e;

import com.ironsource.mediationsdk.adunit.d.a.c;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ4\u0010\u000b\u001a\u00020\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fJ.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0013J/\u0010\u0014\u001a\u0004\u0018\u00018\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0010\u0015J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSelector;", "Smash", "Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "", "managerData", "Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/AdManagerData;", "(Lcom/ironsource/mediationsdk/adunit/manager/adManagerData/AdManagerData;)V", "didReachLoadedSmashesLimit", "", "waterfall", "", "isBestSmashToShow", "smash", "", "waterfallFromServer", "", "", "Lcom/ironsource/mediationsdk/AuctionResponseItem;", "orderedWaterfallToShow", "", "selectSmashToShow", "(Ljava/util/List;Ljava/util/Map;)Lcom/ironsource/mediationsdk/adunit/smash/bases/BaseAdUnitSmash;", "selectSmashesToLoad", "Lcom/ironsource/mediationsdk/adunit/waterfall/WaterfallSelectorResult;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f<Smash extends c<?>> {
    private final com.ironsource.mediationsdk.adunit.c.a.a a;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements Comparator {
        private /* synthetic */ Map a;

        public a(Map map) {
            this.a = map;
        }

        public final int compare(T t, T t2) {
            com.ironsource.mediationsdk.adunit.a.a aVar = (com.ironsource.mediationsdk.adunit.a.a) this.a.get(((c) t).n());
            int i = Integer.MAX_VALUE;
            Comparable valueOf = Integer.valueOf(aVar != null ? aVar.e() : Integer.MAX_VALUE);
            com.ironsource.mediationsdk.adunit.a.a aVar2 = (com.ironsource.mediationsdk.adunit.a.a) this.a.get(((c) t2).n());
            if (aVar2 != null) {
                i = aVar2.e();
            }
            return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
        }
    }

    public f(com.ironsource.mediationsdk.adunit.c.a.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "managerData");
        this.a = aVar;
    }

    public static List<Smash> a(List<? extends Smash> list, Map<String, ? extends com.ironsource.mediationsdk.adunit.a.a> map) {
        Intrinsics.checkNotNullParameter(list, "waterfall");
        Intrinsics.checkNotNullParameter(map, "waterfallFromServer");
        return CollectionsKt.sortedWith(list, new a(map));
    }

    public final boolean a(c<?> cVar, List<Smash> list, Map<String, com.ironsource.mediationsdk.adunit.a.a> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(cVar, "smash");
        Intrinsics.checkNotNullParameter(list, "waterfall");
        Intrinsics.checkNotNullParameter(map, "waterfallFromServer");
        Iterator it = a(list, map).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((c) obj).h()) {
                break;
            }
        }
        return Intrinsics.areEqual(obj, (Object) cVar);
    }

    public final boolean a(List<? extends Smash> list) {
        int i;
        Intrinsics.checkNotNullParameter(list, "waterfall");
        Iterable<c> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            i = 0;
            for (c g : iterable) {
                if (g.g() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i = 0;
        }
        return i >= this.a.b;
    }

    public final Smash b(List<? extends Smash> list, Map<String, ? extends com.ironsource.mediationsdk.adunit.a.a> map) {
        Smash smash;
        Intrinsics.checkNotNullParameter(list, "waterfall");
        Intrinsics.checkNotNullParameter(map, "waterfallFromServer");
        Iterator it = a(list, map).iterator();
        while (true) {
            if (!it.hasNext()) {
                smash = null;
                break;
            }
            smash = it.next();
            if (((c) smash).b_()) {
                break;
            }
        }
        return (c) smash;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.ironsource.mediationsdk.adunit.e.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.ironsource.mediationsdk.adunit.e.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: com.ironsource.mediationsdk.adunit.e.a} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0162 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ironsource.mediationsdk.adunit.e.g<Smash> c(java.util.List<? extends Smash> r11, java.util.Map<java.lang.String, ? extends com.ironsource.mediationsdk.adunit.a.a> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "waterfall"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r1 = "waterfallFromServer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.ironsource.mediationsdk.adunit.c.a.a r4 = r10.a
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = r4.a
            java.lang.String r4 = r4.name()
            r3.append(r4)
            java.lang.String r4 = " waterfall size: "
            r3.append(r4)
            int r4 = r11.size()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.verbose(r3)
            com.ironsource.mediationsdk.adunit.c.a.a r2 = r10.a
            boolean r2 = r2.d
            if (r2 == 0) goto L_0x003a
            com.ironsource.mediationsdk.adunit.e.e r2 = com.ironsource.mediationsdk.adunit.e.e.BIDDER_SENSITIVE
            goto L_0x003c
        L_0x003a:
            com.ironsource.mediationsdk.adunit.e.e r2 = com.ironsource.mediationsdk.adunit.e.e.DEFAULT
        L_0x003c:
            com.ironsource.mediationsdk.adunit.e.h$a r3 = com.ironsource.mediationsdk.adunit.e.h.a
            com.ironsource.mediationsdk.adunit.c.a.a r3 = r10.a
            int r5 = r3.b
            java.lang.String r3 = "loadingStrategy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            int[] r0 = com.ironsource.mediationsdk.adunit.e.h.a.C0110a.a
            int r1 = r2.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x006d
            r2 = 2
            if (r0 != r2) goto L_0x0067
            com.ironsource.mediationsdk.adunit.e.a r0 = new com.ironsource.mediationsdk.adunit.e.a
            r8 = 0
            r9 = 8
            r4 = r0
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0072
        L_0x0067:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x006d:
            com.ironsource.mediationsdk.adunit.e.b r0 = new com.ironsource.mediationsdk.adunit.e.b
            r0.<init>(r5, r11, r12)
        L_0x0072:
            com.ironsource.mediationsdk.adunit.e.h r0 = (com.ironsource.mediationsdk.adunit.e.h) r0
            java.util.Iterator r11 = r11.iterator()
        L_0x0078:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0168
            java.lang.Object r12 = r11.next()
            com.ironsource.mediationsdk.adunit.d.a.c r12 = (com.ironsource.mediationsdk.adunit.d.a.c) r12
            java.lang.String r2 = "smash"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            boolean r2 = r12.h()
            if (r2 == 0) goto L_0x00bc
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = r12.r()
            java.lang.String r4 = r4.name()
            r3.append(r4)
            java.lang.String r4 = " - smash "
            r3.append(r4)
            java.lang.String r12 = r12.o()
            r3.append(r12)
            java.lang.String r12 = " is failed to load"
            r3.append(r12)
            java.lang.String r12 = r3.toString()
        L_0x00b7:
            r2.verbose(r12)
            goto L_0x015c
        L_0x00bc:
            boolean r2 = r12.g()
            java.lang.String r3 = " - Smash "
            if (r2 == 0) goto L_0x00f2
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = r12.r()
            java.lang.String r5 = r5.name()
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r12.o()
            r4.append(r3)
            java.lang.String r3 = " is already loaded"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.verbose(r3)
            java.util.List<Smash> r2 = r0.c
        L_0x00ee:
            r2.add(r12)
            goto L_0x015c
        L_0x00f2:
            boolean r2 = r12.f()
            if (r2 == 0) goto L_0x0123
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = r12.r()
            java.lang.String r5 = r5.name()
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r12.o()
            r4.append(r3)
            java.lang.String r3 = " still loading"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.verbose(r3)
            java.util.List<Smash> r2 = r0.d
            goto L_0x00ee
        L_0x0123:
            int r2 = r0.c()
            int r4 = r0.b(r12)
            if (r2 >= r4) goto L_0x012f
            r2 = 1
            goto L_0x0130
        L_0x012f:
            r2 = 0
        L_0x0130:
            if (r2 == 0) goto L_0x0159
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = r12.r()
            java.lang.String r5 = r5.name()
            r4.append(r5)
            r4.append(r3)
            java.lang.String r12 = r12.o()
            r4.append(r12)
            java.lang.String r12 = " is not better than already loaded smashes"
            r4.append(r12)
            java.lang.String r12 = r4.toString()
            goto L_0x00b7
        L_0x0159:
            r0.a(r12)
        L_0x015c:
            boolean r12 = r0.a()
            if (r12 == 0) goto L_0x0078
            com.ironsource.mediationsdk.adunit.e.g r11 = new com.ironsource.mediationsdk.adunit.e.g
            r11.<init>(r0)
            return r11
        L_0x0168:
            com.ironsource.mediationsdk.adunit.e.g r11 = new com.ironsource.mediationsdk.adunit.e.g
            r11.<init>(r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.e.f.c(java.util.List, java.util.Map):com.ironsource.mediationsdk.adunit.e.g");
    }
}
