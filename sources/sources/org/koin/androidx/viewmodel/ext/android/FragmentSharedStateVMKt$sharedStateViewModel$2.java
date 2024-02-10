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
/* compiled from: FragmentSharedStateVM.kt */
public final class FragmentSharedStateVMKt$sharedStateViewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Function0<ViewModelStoreOwner> $owner;
    final /* synthetic */ Function0<ParametersHolder> $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ Scope $scope;
    final /* synthetic */ Function0<Bundle> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentSharedStateVMKt$sharedStateViewModel$2(Function0<? extends ViewModelStoreOwner> function0, Qualifier qualifier, Function0<? extends ParametersHolder> function02, Function0<Bundle> function03, Scope scope) {
        super(0);
        this.$owner = function0;
        this.$qualifier = qualifier;
        this.$parameters = function02;
        this.$state = function03;
        this.$scope = scope;
    }

    public final ViewModelProvider.Factory invoke() {
        Qualifier qualifier = this.$qualifier;
        Function0<ParametersHolder> function0 = this.$parameters;
        Function0<Bundle> function02 = this.$state;
        Scope scope = this.$scope;
        Intrinsics.reifiedOperationMarker(4, "T");
        return GetViewModelFactoryKt.getViewModelFactory(this.$owner.invoke(), Reflection.getOrCreateKotlinClass(ViewModel.class), qualifier, function0, function02, scope);
    }
}
