package com.wortise.ads;

import android.telephony.TelephonyManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/wortise/ads/k1;", "", "Landroid/telephony/TelephonyManager;", "telephonyManager", "", "", "a", "Landroid/content/Context;", "context", "Lcom/wortise/ads/j1;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: CellularFactory.kt */
public final class k1 {
    public static final k1 a = new k1();

    private k1() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a A[SYNTHETIC, Splitter:B:18:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[Catch:{ all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089 A[Catch:{ all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f A[Catch:{ all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0091 A[Catch:{ all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7 A[Catch:{ all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b9 A[Catch:{ all -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c1 A[SYNTHETIC, Splitter:B:52:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d5 A[SYNTHETIC, Splitter:B:63:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f0 A[SYNTHETIC, Splitter:B:73:0x00f0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.wortise.ads.j1 a(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 0
            boolean r1 = com.wortise.ads.consent.ConsentManager.canCollectData(r14)     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = "phone"
            java.lang.Object r14 = r14.getSystemService(r2)     // Catch:{ all -> 0x00fd }
            boolean r2 = r14 instanceof android.telephony.TelephonyManager     // Catch:{ all -> 0x00fd }
            if (r2 != 0) goto L_0x0015
            r14 = r0
        L_0x0015:
            android.telephony.TelephonyManager r14 = (android.telephony.TelephonyManager) r14     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x0046
            if (r14 != 0) goto L_0x001c
            goto L_0x0046
        L_0x001c:
            java.util.List r1 = r14.getAllCellInfo()     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "allCellInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ all -> 0x0045 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0045 }
            r2.<init>()     // Catch:{ all -> 0x0045 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0045 }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0047
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0045 }
            r4 = r3
            android.telephony.CellInfo r4 = (android.telephony.CellInfo) r4     // Catch:{ all -> 0x0045 }
            boolean r4 = r4.isRegistered()     // Catch:{ all -> 0x0045 }
            if (r4 == 0) goto L_0x002e
            r2.add(r3)     // Catch:{ all -> 0x0045 }
            goto L_0x002e
        L_0x0045:
        L_0x0046:
            r2 = r0
        L_0x0047:
            if (r14 != 0) goto L_0x004a
            goto L_0x0062
        L_0x004a:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005e }
            r3 = 30
            if (r1 < r3) goto L_0x0055
            int r1 = r14.getDataNetworkType()     // Catch:{ all -> 0x005e }
            goto L_0x0059
        L_0x0055:
            int r1 = r14.getNetworkType()     // Catch:{ all -> 0x005e }
        L_0x0059:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x005e }
            goto L_0x0060
        L_0x005e:
            r1 = r0
        L_0x0060:
            if (r1 != 0) goto L_0x0064
        L_0x0062:
            r9 = r0
            goto L_0x006f
        L_0x0064:
            com.wortise.ads.network.models.CellNetworkType$a r3 = com.wortise.ads.network.models.CellNetworkType.Companion     // Catch:{ all -> 0x00fd }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00fd }
            com.wortise.ads.network.models.CellNetworkType r1 = r3.a(r1)     // Catch:{ all -> 0x00fd }
            r9 = r1
        L_0x006f:
            com.wortise.ads.k1 r1 = a     // Catch:{ all -> 0x00fd }
            java.util.List r1 = r1.a((android.telephony.TelephonyManager) r14)     // Catch:{ all -> 0x00fd }
            r3 = 0
            java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x00fd }
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00fd }
            r4 = 1
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x00fd }
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00fd }
            if (r14 != 0) goto L_0x0089
            r1 = r0
            goto L_0x008d
        L_0x0089:
            java.lang.String r1 = r14.getNetworkOperatorName()     // Catch:{ all -> 0x00fd }
        L_0x008d:
            if (r2 != 0) goto L_0x0091
            r5 = r0
            goto L_0x00b5
        L_0x0091:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r5.<init>()     // Catch:{ all -> 0x00fd }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00fd }
        L_0x009a:
            boolean r8 = r2.hasNext()     // Catch:{ all -> 0x00fd }
            if (r8 == 0) goto L_0x00b5
            java.lang.Object r8 = r2.next()     // Catch:{ all -> 0x00fd }
            android.telephony.CellInfo r8 = (android.telephony.CellInfo) r8     // Catch:{ all -> 0x00ad }
            com.wortise.ads.c1 r10 = com.wortise.ads.c1.a     // Catch:{ all -> 0x00ad }
            com.wortise.ads.b1 r8 = r10.a(r8, r9)     // Catch:{ all -> 0x00ad }
            goto L_0x00af
        L_0x00ad:
            r8 = r0
        L_0x00af:
            if (r8 == 0) goto L_0x009a
            r5.add(r8)     // Catch:{ all -> 0x00fd }
            goto L_0x009a
        L_0x00b5:
            if (r14 != 0) goto L_0x00b9
            r8 = r0
            goto L_0x00be
        L_0x00b9:
            java.lang.String r2 = r14.getNetworkCountryIso()     // Catch:{ all -> 0x00fd }
            r8 = r2
        L_0x00be:
            if (r14 != 0) goto L_0x00c1
            goto L_0x00ca
        L_0x00c1:
            java.lang.CharSequence r2 = r14.getSimCarrierIdName()     // Catch:{ all -> 0x00c6 }
            goto L_0x00c8
        L_0x00c6:
            r2 = r0
        L_0x00c8:
            if (r2 != 0) goto L_0x00cc
        L_0x00ca:
            r10 = r0
            goto L_0x00d1
        L_0x00cc:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00fd }
            r10 = r2
        L_0x00d1:
            if (r14 != 0) goto L_0x00d5
        L_0x00d3:
            r11 = r0
            goto L_0x00ec
        L_0x00d5:
            int r2 = r14.getSimCarrierId()     // Catch:{ all -> 0x00ea }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00ea }
            int r11 = r2.intValue()     // Catch:{ all -> 0x00ea }
            if (r11 <= 0) goto L_0x00e4
            r3 = 1
        L_0x00e4:
            if (r3 == 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r2 = r0
        L_0x00e8:
            r11 = r2
            goto L_0x00ec
        L_0x00ea:
            goto L_0x00d3
        L_0x00ec:
            if (r14 != 0) goto L_0x00f0
            r12 = r0
            goto L_0x00f5
        L_0x00f0:
            java.lang.String r14 = r14.getSimCountryIso()     // Catch:{ all -> 0x00fd }
            r12 = r14
        L_0x00f5:
            com.wortise.ads.j1 r14 = new com.wortise.ads.j1     // Catch:{ all -> 0x00fd }
            r3 = r14
            r4 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00fd }
            r0 = r14
        L_0x00fd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.k1.a(android.content.Context):com.wortise.ads.j1");
    }

    private final List<String> a(TelephonyManager telephonyManager) {
        String networkOperator = telephonyManager == null ? null : telephonyManager.getNetworkOperator();
        if (networkOperator == null) {
            return CollectionsKt.listOf(null, null);
        }
        int min = Math.min(3, networkOperator.length());
        String substring = networkOperator.substring(0, min);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = networkOperator.substring(min);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return CollectionsKt.listOf(substring, substring2);
    }
}
