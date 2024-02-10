package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ActivityStateVM.kt */
final class ActivityStateVMKt$stateViewModel$3 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ KClass<T> $clazz;
    final /* synthetic */ Function0<ParametersHolder> $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ Scope $scope;
    final /* synthetic */ Function0<Bundle> $state;
    final /* synthetic */ ComponentActivity $this_stateViewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityStateVMKt$stateViewModel$3(ComponentActivity componentActivity, KClass<T> kClass, Qualifier qualifier, Function0<? extends ParametersHolder> function0, Function0<Bundle> function02, Scope scope) {
        super(0);
        this.$this_stateViewModel = componentActivity;
        this.$clazz = kClass;
        this.$qualifier = qualifier;
        this.$parameters = function0;
        this.$state = function02;
        this.$scope = scope;
    }

    public final ViewModelProvider.Factory invoke() {
        return GetViewModelFactoryKt.getViewModelFactory(this.$this_stateViewModel, this.$clazz, this.$qualifier, this.$parameters, this.$state, this.$scope);
    }
}
