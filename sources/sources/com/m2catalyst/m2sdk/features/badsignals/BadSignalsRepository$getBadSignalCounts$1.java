package com.m2catalyst.m2sdk.features.badsignals;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadSignalsRepository.kt */
public /* synthetic */ class BadSignalsRepository$getBadSignalCounts$1 extends FunctionReferenceImpl implements Function1<BadSignalTimeRange, int[]> {
    public BadSignalsRepository$getBadSignalCounts$1(Object obj) {
        super(1, obj, BadSignalsRepository.class, "getBadSignalCounts", "getBadSignalCounts(Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTimeRange;)[I", 0);
    }

    public final int[] invoke(BadSignalTimeRange badSignalTimeRange) {
        Intrinsics.checkNotNullParameter(badSignalTimeRange, "p0");
        return ((BadSignalsRepository) this.receiver).getBadSignalCounts(badSignalTimeRange);
    }
}
