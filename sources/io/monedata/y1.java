package io.monedata;

import io.monedata.consent.iab.models.TcfPurpose;
import io.monedata.consent.iab.models.TcfString;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/monedata/consent/iab/models/TcfString;", "", "a", "(Lio/monedata/consent/iab/models/TcfString;)Z", "hasRequiredPurposes", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class y1 {
    private static final TcfPurpose[] a = {TcfPurpose.STORE_INFORMATION, TcfPurpose.MARKET_RESEARCH, TcfPurpose.DEVELOP_AND_IMPROVE_PRODUCTS};

    public static final boolean a(TcfString tcfString) {
        Intrinsics.checkNotNullParameter(tcfString, "<this>");
        TcfPurpose[] tcfPurposeArr = a;
        return tcfString.isPurposesAccepted((TcfPurpose[]) Arrays.copyOf(tcfPurposeArr, tcfPurposeArr.length));
    }
}
