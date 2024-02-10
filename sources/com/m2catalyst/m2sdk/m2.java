package com.m2catalyst.m2sdk;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;

/* compiled from: M2DIExtensions.kt */
public final class m2 extends Lambda implements Function1<KoinApplication, Unit> {
    public final /* synthetic */ t2 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m2(t2 t2Var) {
        super(1);
        this.a = t2Var;
    }

    public final Object invoke(Object obj) {
        KoinApplication koinApplication = (KoinApplication) obj;
        Intrinsics.checkNotNullParameter(koinApplication, "$this$startKoin");
        Context context = this.a.b;
        Intrinsics.checkNotNull(context);
        KoinExtKt.androidContext(koinApplication, context);
        koinApplication.modules(this.a.a);
        return Unit.INSTANCE;
    }
}
