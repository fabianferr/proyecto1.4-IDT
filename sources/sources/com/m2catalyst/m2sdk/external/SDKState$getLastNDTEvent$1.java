package com.m2catalyst.m2sdk.external;

import com.m2catalyst.m2sdk.speed_test.legacy.TestBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SDKState.kt */
public /* synthetic */ class SDKState$getLastNDTEvent$1 extends FunctionReferenceImpl implements Function0<TestBaseEvent> {
    public SDKState$getLastNDTEvent$1(Object obj) {
        super(0, obj, SDKState.class, "getLastNDTEvent", "getLastNDTEvent()Lcom/m2catalyst/m2sdk/speed_test/legacy/TestBaseEvent;", 0);
    }

    public final TestBaseEvent invoke() {
        return ((SDKState) this.receiver).getLastNDTEvent();
    }
}
