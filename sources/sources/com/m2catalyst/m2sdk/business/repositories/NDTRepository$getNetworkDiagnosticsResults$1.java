package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTRepository.kt */
public /* synthetic */ class NDTRepository$getNetworkDiagnosticsResults$1 extends FunctionReferenceImpl implements Function6<Long, Long, Integer, Integer, Boolean, Integer, List<? extends DiagnosticsResults>> {
    public NDTRepository$getNetworkDiagnosticsResults$1(Object obj) {
        super(6, obj, NDTRepository.class, "getNetworkDiagnosticsResults", "getNetworkDiagnosticsResults(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Ljava/util/List;", 0);
    }

    public final List<DiagnosticsResults> invoke(Long l, Long l2, Integer num, Integer num2, Boolean bool, Integer num3) {
        return ((NDTRepository) this.receiver).getNetworkDiagnosticsResults(l, l2, num, num2, bool, num3);
    }
}
