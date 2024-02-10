package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.external.SDKState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MNSIRepository.kt */
public /* synthetic */ class MNSIRepository$getStateForLiveData$1 extends FunctionReferenceImpl implements Function0<SDKState> {
    public MNSIRepository$getStateForLiveData$1(Object obj) {
        super(0, obj, MNSIRepository.class, "getStateForLiveData", "getStateForLiveData()Lcom/m2catalyst/m2sdk/external/SDKState;", 0);
    }

    public final SDKState invoke() {
        return ((MNSIRepository) this.receiver).getStateForLiveData();
    }
}
