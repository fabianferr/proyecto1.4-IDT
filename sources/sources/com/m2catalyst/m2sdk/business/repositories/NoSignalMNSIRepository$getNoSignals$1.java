package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.NoSignalData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NoSignalMNSIRepository.kt */
public /* synthetic */ class NoSignalMNSIRepository$getNoSignals$1 extends FunctionReferenceImpl implements Function3<Long, Long, Integer, List<? extends NoSignalData>> {
    public NoSignalMNSIRepository$getNoSignals$1(Object obj) {
        super(3, obj, NoSignalMNSIRepository.class, "getNoSignals", "getNoSignals(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/util/List;", 0);
    }

    public final List<NoSignalData> invoke(Long l, Long l2, Integer num) {
        return ((NoSignalMNSIRepository) this.receiver).getNoSignals(l, l2, num);
    }
}
