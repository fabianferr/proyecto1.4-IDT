package com.m2catalyst.m2sdk.external;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SDKState.kt */
public /* synthetic */ class SDKState$getCurrentNDTTest$1 extends FunctionReferenceImpl implements Function0<DiagnosticsResults> {
    public SDKState$getCurrentNDTTest$1(Object obj) {
        super(0, obj, SDKState.class, "getCurrentNDTTest", "getCurrentNDTTest()Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", 0);
    }

    public final DiagnosticsResults invoke() {
        return ((SDKState) this.receiver).getCurrentNDTTest();
    }
}
