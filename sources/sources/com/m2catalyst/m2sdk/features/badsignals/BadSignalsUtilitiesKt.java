package com.m2catalyst.m2sdk.features.badsignals;

import com.m2catalyst.m2sdk.a;
import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.m4;
import com.m2catalyst.m2sdk.x3;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0004H\u0002¨\u0006\t"}, d2 = {"getBadSignalsByType", "", "transmittedEntries", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "noNetworkCount", "", "getNetworkTypeForBadSignal", "Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTypeDefinition;", "m2sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadSignalsUtilities.kt */
public final class BadSignalsUtilitiesKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BadSignalsUtilities.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0015 */
        static {
            /*
                r0 = 5
                int[] r1 = com.m2catalyst.m2sdk.x3.b(r0)
                int r1 = r1.length
                int[] r1 = new int[r1]
                r2 = 1
                r3 = 4
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000c }
            L_0x000c:
                r4 = 2
                r5 = 0
                r1[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r5 = 3
                r1[r2] = r5     // Catch:{ NoSuchFieldError -> 0x0013 }
            L_0x0013:
                r1[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                $EnumSwitchMapping$0 = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.features.badsignals.BadSignalsUtilitiesKt.WhenMappings.<clinit>():void");
        }
    }

    public static final int[] getBadSignalsByType(List<? extends MNSI> list, int i) {
        Intrinsics.checkNotNullParameter(list, "transmittedEntries");
        int[] iArr = {0, 0, 0, 0, 0};
        for (MNSI mnsi : list) {
            BadSignalTypeDefinition networkTypeForBadSignal = getNetworkTypeForBadSignal(mnsi);
            if (networkTypeForBadSignal != BadSignalTypeDefinition.UNKNOWN) {
                Integer dbm = mnsi.getDbm();
                if ((dbm != null ? dbm.intValue() : 0) <= networkTypeForBadSignal.getThreshold()) {
                    int type = networkTypeForBadSignal.getType() - 2;
                    iArr[type] = iArr[type] + 1;
                }
            }
        }
        iArr[4] = i;
        return iArr;
    }

    private static final BadSignalTypeDefinition getNetworkTypeForBadSignal(MNSI mnsi) {
        M2SDKLogger m2SDKLogger = m4.a;
        Intrinsics.checkNotNullParameter(mnsi, "<this>");
        int networkType = mnsi.getNetworkType();
        int i = 5;
        if (networkType != -1) {
            if (a.a(Integer.valueOf(networkType), new Integer[]{10, 15, 14, 6, 12, 5, 9, 8, 3, 17})) {
                i = 2;
            } else {
                if (a.a(Integer.valueOf(networkType), new Integer[]{4, 2, 11, 1, 7, 16})) {
                    i = 1;
                } else {
                    if (a.a(Integer.valueOf(networkType), new Integer[]{20})) {
                        i = 4;
                    } else {
                        if (a.a(Integer.valueOf(networkType), new Integer[]{13})) {
                            i = 3;
                        }
                    }
                }
            }
        }
        if (i == 3 && Intrinsics.areEqual((Object) mnsi.is5GConnected(), (Object) Boolean.TRUE)) {
            i = 4;
        }
        int a = x3.a(i);
        if (a == 0) {
            return BadSignalTypeDefinition.TWO_G;
        }
        if (a == 1) {
            return BadSignalTypeDefinition.THREE_G;
        }
        if (a == 2) {
            return BadSignalTypeDefinition.FOUR_G;
        }
        if (a == 3) {
            return BadSignalTypeDefinition.FIVE_G;
        }
        if (a == 4) {
            return BadSignalTypeDefinition.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }
}
