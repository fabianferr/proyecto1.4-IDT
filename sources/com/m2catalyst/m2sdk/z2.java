package com.m2catalyst.m2sdk;

import android.content.ContextWrapper;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.module.Module;

/* compiled from: M2SDKDI.kt */
public final class z2 extends Lambda implements Function1<t2, Unit> {
    public final /* synthetic */ ContextWrapper a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z2(ContextWrapper contextWrapper) {
        super(1);
        this.a = contextWrapper;
    }

    public final Object invoke(Object obj) {
        t2 t2Var = (t2) obj;
        Intrinsics.checkNotNullParameter(t2Var, "$this$startM2Koin");
        ContextWrapper contextWrapper = this.a;
        t2Var.getClass();
        Intrinsics.checkNotNullParameter(contextWrapper, "context");
        t2Var.b = contextWrapper;
        List<Module> list = a3.a;
        Intrinsics.checkNotNullParameter(list, "modules");
        t2Var.a = list;
        return Unit.INSTANCE;
    }
}
