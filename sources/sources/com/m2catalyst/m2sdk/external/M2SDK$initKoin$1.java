package com.m2catalyst.m2sdk.external;

import android.content.ContextWrapper;
import com.m2catalyst.m2sdk.a3;
import com.m2catalyst.m2sdk.m2;
import com.m2catalyst.m2sdk.t2;
import com.m2catalyst.m2sdk.z2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.context.DefaultContextExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/m2catalyst/m2sdk/t2;", "", "invoke", "(Lcom/m2catalyst/m2sdk/t2;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* compiled from: M2SDK.kt */
public final class M2SDK$initKoin$1 extends Lambda implements Function1<t2, Unit> {
    final /* synthetic */ ContextWrapper $contextWrapper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M2SDK$initKoin$1(ContextWrapper contextWrapper) {
        super(1);
        this.$contextWrapper = contextWrapper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((t2) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(t2 t2Var) {
        Intrinsics.checkNotNullParameter(t2Var, "$this$startM2Koin");
        ContextWrapper contextWrapper = this.$contextWrapper;
        t2Var.getClass();
        Intrinsics.checkNotNullParameter(contextWrapper, "context");
        t2Var.b = contextWrapper;
        ContextWrapper contextWrapper2 = this.$contextWrapper;
        List<Module> list = a3.a;
        Intrinsics.checkNotNullParameter(contextWrapper2, "application");
        z2 z2Var = new z2(contextWrapper2);
        Intrinsics.checkNotNullParameter(z2Var, "declaration");
        t2 t2Var2 = new t2();
        z2Var.invoke(t2Var2);
        if (GlobalContext.INSTANCE.getOrNull() == null) {
            DefaultContextExtKt.startKoin((Function1<? super KoinApplication, Unit>) new m2(t2Var2));
        } else {
            Koin.loadModules$default(GlobalContext.INSTANCE.get(), t2Var2.a, false, 2, (Object) null);
        }
    }
}
