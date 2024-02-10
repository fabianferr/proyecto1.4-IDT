package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.business.models.M2Location;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationCollectorManager.kt */
public final class d2 implements c2 {
    public final q3 a;

    public d2(q3 q3Var) {
        Intrinsics.checkNotNullParameter(q3Var, "networkCollectionManager");
        this.a = q3Var;
    }

    public final Unit a(M2Location m2Location) {
        q3 q3Var = this.a;
        q3Var.getClass();
        j3.b(new r3(m2Location, q3Var, (Continuation<? super r3>) null));
        Unit unit = Unit.INSTANCE;
        return unit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? unit : Unit.INSTANCE;
    }
}
