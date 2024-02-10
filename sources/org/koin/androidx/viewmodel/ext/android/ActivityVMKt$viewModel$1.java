package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 176)
/* compiled from: ActivityVM.kt */
public final class ActivityVMKt$viewModel$1 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ ViewModelStoreOwner $owner;
    final /* synthetic */ Function0<ParametersHolder> $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ Scope $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityVMKt$viewModel$1(ViewModelStoreOwner viewModelStoreOwner, Qualifier qualifier, Function0<? extends ParametersHolder> function0, Scope scope) {
        super(0);
        this.$owner = viewModelStoreOwner;
        this.$qualifier = qualifier;
        this.$parameters = function0;
        this.$scope = scope;
    }

    public final ViewModelProvider.Factory invoke() {
        ViewModelStoreOwner viewModelStoreOwner = this.$owner;
        Qualifier qualifier = this.$qualifier;
        Function0<ParametersHolder> function0 = this.$parameters;
        Scope scope = this.$scope;
        Intrinsics.reifiedOperationMarker(4, "T");
        return GetViewModelFactoryKt.getViewModelFactory(viewModelStoreOwner, Reflection.getOrCreateKotlinClass(ViewModel.class), qualifier, function0, (Function0<Bundle>) null, scope);
    }
}
