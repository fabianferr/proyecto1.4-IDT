package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTRepository.kt */
public /* synthetic */ class NDTRepository$addNetworkDiagnosticResult$1 extends FunctionReferenceImpl implements Function1<DiagnosticsResults, Long> {
    public NDTRepository$addNetworkDiagnosticResult$1(Object obj) {
        super(1, obj, NDTRepository.class, "addNetworkDiagnosticResult", "addNetworkDiagnosticResult(Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;)J", 0);
    }

    public final Long invoke(DiagnosticsResults diagnosticsResults) {
        Intrinsics.checkNotNullParameter(diagnosticsResults, "p0");
        return Long.valueOf(((NDTRepository) this.receiver).addNetworkDiagnosticResult(diagnosticsResults));
    }
}
