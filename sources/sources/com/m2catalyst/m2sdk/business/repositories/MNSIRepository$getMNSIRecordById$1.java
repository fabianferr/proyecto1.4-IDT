package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.MNSI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MNSIRepository.kt */
public /* synthetic */ class MNSIRepository$getMNSIRecordById$1 extends FunctionReferenceImpl implements Function1<Long, MNSI> {
    public MNSIRepository$getMNSIRecordById$1(Object obj) {
        super(1, obj, MNSIRepository.class, "getMNSIRecordById", "getMNSIRecordById(J)Lcom/m2catalyst/m2sdk/business/models/MNSI;", 0);
    }

    public final MNSI invoke(long j) {
        return ((MNSIRepository) this.receiver).getMNSIRecordById(j);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }
}
