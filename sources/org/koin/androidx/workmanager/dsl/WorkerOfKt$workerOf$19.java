package org.koin.androidx.workmanager.dsl;

import androidx.work.ListenableWorker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u0001\"\u0006\b\u0006\u0010\b\u0018\u0001\"\u0006\b\u0007\u0010\t\u0018\u0001\"\u0006\b\b\u0010\n\u0018\u0001\"\u0006\b\t\u0010\u000b\u0018\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"<anonymous>", "R", "Landroidx/work/ListenableWorker;", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "Lorg/koin/core/scope/Scope;", "it", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Landroidx/work/ListenableWorker;"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: WorkerOf.kt */
public final class WorkerOfKt$workerOf$19 extends Lambda implements Function2<Scope, ParametersHolder, R> {
    final /* synthetic */ Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> $constructor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerOfKt$workerOf$19(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        super(2);
        this.$constructor = function9;
    }

    public final R invoke(Scope scope, ParametersHolder parametersHolder) {
        Intrinsics.checkNotNullParameter(scope, "$this$_factoryInstanceFactory");
        Intrinsics.checkNotNullParameter(parametersHolder, "it");
        Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9 = this.$constructor;
        Intrinsics.reifiedOperationMarker(4, "T1");
        Object obj = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T2");
        Object obj2 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T3");
        Object obj3 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T4");
        Object obj4 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T5");
        Object obj5 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T6");
        Object obj6 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T7");
        Object obj7 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T8");
        Object obj8 = scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        Intrinsics.reifiedOperationMarker(4, "T9");
        return (ListenableWorker) function9.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, scope.get(Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null));
    }
}
