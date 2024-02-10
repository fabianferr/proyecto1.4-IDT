package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.NoSignalData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NoSignalMNSIRepository.kt */
public /* synthetic */ class NoSignalMNSIRepository$addNoSignal$1 extends FunctionReferenceImpl implements Function1<NoSignalData, Unit> {
    public NoSignalMNSIRepository$addNoSignal$1(Object obj) {
        super(1, obj, NoSignalMNSIRepository.class, "addNoSignal", "addNoSignal(Lcom/m2catalyst/m2sdk/business/models/NoSignalData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NoSignalData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NoSignalData noSignalData) {
        Intrinsics.checkNotNullParameter(noSignalData, "p0");
        ((NoSignalMNSIRepository) this.receiver).addNoSignal(noSignalData);
    }
}
