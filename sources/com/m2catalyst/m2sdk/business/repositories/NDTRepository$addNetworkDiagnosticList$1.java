package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTRepository.kt */
public /* synthetic */ class NDTRepository$addNetworkDiagnosticList$1 extends FunctionReferenceImpl implements Function1<List<? extends DiagnosticsResults>, Unit> {
    public NDTRepository$addNetworkDiagnosticList$1(Object obj) {
        super(1, obj, NDTRepository.class, "addNetworkDiagnosticList", "addNetworkDiagnosticList(Ljava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<DiagnosticsResults>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<DiagnosticsResults> list) {
        Intrinsics.checkNotNullParameter(list, "p0");
        ((NDTRepository) this.receiver).addNetworkDiagnosticList(list);
    }
}
