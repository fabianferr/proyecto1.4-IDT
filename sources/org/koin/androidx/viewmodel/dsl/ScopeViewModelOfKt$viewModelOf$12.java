package org.koin.androidx.viewmodel.dsl;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"<anonymous>", "R", "Landroidx/lifecycle/ViewModel;", "T1", "T2", "T3", "T4", "T5", "Lorg/koin/core/scope/Scope;", "it", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Landroidx/lifecycle/ViewModel;"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: ScopeViewModelOf.kt */
public final class ScopeViewModelOfKt$viewModelOf$12 extends Lambda implements Function2<Scope, ParametersHolder, R> {
    final /* synthetic */ Function5<T1, T2, T3, T4, T5, R> $constructor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScopeViewModelOfKt$viewModelOf$12(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        super(2);
        this.$constructor = function5;
    }

    public final R invoke(Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "$this$viewModel");
        Intrinsics.checkNotNullParameter(parametersHolder, "it");
        Function5<T1, T2, T3, T4, T5, R> function5 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object obj = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object obj2 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object obj3 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object obj4 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        return (ViewModel) function5.invoke(obj, obj2, obj3, obj4, scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
