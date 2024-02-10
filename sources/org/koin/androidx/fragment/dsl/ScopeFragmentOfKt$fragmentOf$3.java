package org.koin.androidx.fragment.dsl;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "R", "Landroidx/fragment/app/Fragment;", "T1", "Lorg/koin/core/scope/Scope;", "it", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Landroidx/fragment/app/Fragment;"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: ScopeFragmentOf.kt */
public final class ScopeFragmentOfKt$fragmentOf$3 extends Lambda implements Function2<Scope, ParametersHolder, R> {
    final /* synthetic */ Function1<T1, R> $constructor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScopeFragmentOfKt$fragmentOf$3(Function1<? super T1, ? extends R> function1) {
        super(2);
        this.$constructor = function1;
    }

    public final R invoke(Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "$this$_factoryInstanceFactory");
        Intrinsics.checkNotNullParameter(parametersHolder, "it");
        Function1<T1, R> function1 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        return (Fragment) function1.invoke(scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
