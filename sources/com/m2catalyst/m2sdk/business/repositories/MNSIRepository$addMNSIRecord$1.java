package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.MNSI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MNSIRepository.kt */
public /* synthetic */ class MNSIRepository$addMNSIRecord$1 extends FunctionReferenceImpl implements Function1<MNSI[], Unit> {
    public MNSIRepository$addMNSIRecord$1(Object obj) {
        super(1, obj, MNSIRepository.class, "addMNSIRecord", "addMNSIRecord([Lcom/m2catalyst/m2sdk/business/models/MNSI;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MNSI[]) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(MNSI[] mnsiArr) {
        Intrinsics.checkNotNullParameter(mnsiArr, "p0");
        ((MNSIRepository) this.receiver).addMNSIRecord(mnsiArr);
    }
}
