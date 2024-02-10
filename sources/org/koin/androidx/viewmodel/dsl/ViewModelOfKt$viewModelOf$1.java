package org.koin.androidx.viewmodel.dsl;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/scope/Scope;", "it", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: ViewModelOf.kt */
public final class ViewModelOfKt$viewModelOf$1 extends Lambda implements Function2<Scope, ParametersHolder, R> {
    final /* synthetic */ Function0<R> $constructor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewModelOfKt$viewModelOf$1(Function0<? extends R> function0) {
        super(2);
        this.$constructor = function0;
    }

    public final R invoke(Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "$this$_factoryInstanceFactory");
        Intrinsics.checkNotNullParameter(parametersHolder, "it");
        return (ViewModel) this.$constructor.invoke();
    }
}
