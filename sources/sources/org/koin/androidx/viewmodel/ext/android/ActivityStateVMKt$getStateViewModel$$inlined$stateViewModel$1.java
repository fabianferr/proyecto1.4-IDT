package org.koin.androidx.viewmodel.ext.android;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "invoke", "org/koin/androidx/viewmodel/ext/android/ActivityStateVMKt$stateViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: ActivityStateVM.kt */
public final class ActivityStateVMKt$getStateViewModel$$inlined$stateViewModel$1 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ Scope $scope;
    final /* synthetic */ Function0 $state;
    final /* synthetic */ ComponentActivity $this_stateViewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityStateVMKt$getStateViewModel$$inlined$stateViewModel$1(ComponentActivity componentActivity, Qualifier qualifier, Function0 function0, Function0 function02, Scope scope) {
        super(0);
        this.$this_stateViewModel = componentActivity;
        this.$qualifier = qualifier;
        this.$parameters = function0;
        this.$state = function02;
        this.$scope = scope;
    }

    public final ViewModelProvider.Factory invoke() {
        Qualifier qualifier = this.$qualifier;
        Function0 function0 = this.$parameters;
        Function0 function02 = this.$state;
        Scope scope = this.$scope;
        Intrinsics.reifiedOperationMarker(4, "T");
        return GetViewModelFactoryKt.getViewModelFactory(this.$this_stateViewModel, Reflection.getOrCreateKotlinClass(ViewModel.class), qualifier, function0, function02, scope);
    }
}