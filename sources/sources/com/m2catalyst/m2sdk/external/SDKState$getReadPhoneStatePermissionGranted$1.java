package com.m2catalyst.m2sdk.external;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SDKState.kt */
public /* synthetic */ class SDKState$getReadPhoneStatePermissionGranted$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public SDKState$getReadPhoneStatePermissionGranted$1(Object obj) {
        super(0, obj, SDKState.class, "getReadPhoneStatePermissionGranted", "getReadPhoneStatePermissionGranted()Ljava/lang/Boolean;", 0);
    }

    public final Boolean invoke() {
        return ((SDKState) this.receiver).getReadPhoneStatePermissionGranted();
    }
}
