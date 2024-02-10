package com.m2catalyst.m2sdk.features.badsignals;

import com.m2catalyst.m2sdk.database.entities.BadSignal;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadSignalsRepository.kt */
public /* synthetic */ class BadSignalsRepository$addEntries$1 extends FunctionReferenceImpl implements Function1<List<? extends BadSignal>, Unit> {
    public BadSignalsRepository$addEntries$1(Object obj) {
        super(1, obj, BadSignalsRepository.class, "addEntries", "addEntries(Ljava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<BadSignal>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<BadSignal> list) {
        Intrinsics.checkNotNullParameter(list, "p0");
        ((BadSignalsRepository) this.receiver).addEntries(list);
    }
}
