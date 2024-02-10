package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTRepository.kt */
public /* synthetic */ class NDTRepository$getNetworkDiagnosticById$1 extends FunctionReferenceImpl implements Function1<Long, DiagnosticsResults> {
    public NDTRepository$getNetworkDiagnosticById$1(Object obj) {
        super(1, obj, NDTRepository.class, "getNetworkDiagnosticById", "getNetworkDiagnosticById(J)Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", 0);
    }

    public final DiagnosticsResults invoke(long j) {
        return ((NDTRepository) this.receiver).getNetworkDiagnosticById(j);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }
}
