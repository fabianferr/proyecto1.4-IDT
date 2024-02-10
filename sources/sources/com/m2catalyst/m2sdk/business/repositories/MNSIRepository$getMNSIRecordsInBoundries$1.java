package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.MNSI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MNSIRepository.kt */
public /* synthetic */ class MNSIRepository$getMNSIRecordsInBoundries$1 extends FunctionReferenceImpl implements Function8<Double, Double, Double, Double, Long, Long, String, Integer, List<? extends MNSI>> {
    public MNSIRepository$getMNSIRecordsInBoundries$1(Object obj) {
        super(8, obj, MNSIRepository.class, "getMNSIRecordsInBoundries", "getMNSIRecordsInBoundries(DDDDLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return invoke(((Number) obj).doubleValue(), ((Number) obj2).doubleValue(), ((Number) obj3).doubleValue(), ((Number) obj4).doubleValue(), (Long) obj5, (Long) obj6, (String) obj7, (Integer) obj8);
    }

    public final List<MNSI> invoke(double d, double d2, double d3, double d4, Long l, Long l2, String str, Integer num) {
        return ((MNSIRepository) this.receiver).getMNSIRecordsInBoundries(d, d2, d3, d4, l, l2, str, num);
    }
}
