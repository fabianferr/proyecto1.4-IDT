package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.MNSI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MNSIRepository.kt */
public /* synthetic */ class MNSIRepository$getMNSIRecords$1 extends FunctionReferenceImpl implements Function3<Long, Long, Integer, List<? extends MNSI>> {
    public MNSIRepository$getMNSIRecords$1(Object obj) {
        super(3, obj, MNSIRepository.class, "getMNSIRecords", "getMNSIRecords(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Ljava/util/List;", 0);
    }

    public final List<MNSI> invoke(Long l, Long l2, Integer num) {
        return ((MNSIRepository) this.receiver).getMNSIRecords(l, l2, num);
    }
}
