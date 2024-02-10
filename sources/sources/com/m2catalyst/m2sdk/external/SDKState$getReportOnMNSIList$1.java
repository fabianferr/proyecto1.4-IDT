package com.m2catalyst.m2sdk.external;

import com.m2catalyst.m2sdk.business.models.MNSI;
import com.m2catalyst.m2sdk.t4;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SDKState.kt */
public /* synthetic */ class SDKState$getReportOnMNSIList$1 extends FunctionReferenceImpl implements Function1<List<? extends MNSI>, t4> {
    public SDKState$getReportOnMNSIList$1(Object obj) {
        super(1, obj, SDKState.class, "getReportOnMNSIList", "getReportOnMNSIList(Ljava/util/List;)Lcom/m2catalyst/m2sdk/testing/business/QualityReport;", 0);
    }

    public final t4 invoke(List<? extends MNSI> list) {
        Intrinsics.checkNotNullParameter(list, "p0");
        return ((SDKState) this.receiver).getReportOnMNSIList(list);
    }
}
