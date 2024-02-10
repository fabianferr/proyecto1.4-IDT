package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NDTRepository.kt */
public /* synthetic */ class NDTRepository$getNetworkDiagnosticCount$1 extends FunctionReferenceImpl implements Function0<Integer> {
    public NDTRepository$getNetworkDiagnosticCount$1(Object obj) {
        super(0, obj, NDTRepository.class, "getNetworkDiagnosticCount", "getNetworkDiagnosticCount()I", 0);
    }

    public final Integer invoke() {
        return Integer.valueOf(((NDTRepository) this.receiver).getNetworkDiagnosticCount());
    }
}
