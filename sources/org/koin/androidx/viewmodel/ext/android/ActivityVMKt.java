package org.koin.androidx.viewmodel.ext.android;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aO\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\n\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bH\bø\u0001\u0000¢\u0006\u0002\u0010\f\u001aP\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\n\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroidx/activity/ComponentActivity;Lorg/koin/core/qualifier/Qualifier;Landroidx/lifecycle/ViewModelStoreOwner;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "viewModel", "Lkotlin/Lazy;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ActivityVM.kt */
public final class ActivityVMKt {
    public static /* synthetic */ Lazy viewModel$default(ComponentActivity componentActivity, Qualifier qualifier, ViewModelStoreOwner viewModelStoreOwner, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            viewModelStoreOwner = componentActivity;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityVMKt$viewModel$$inlined$viewModels$2(componentActivity), new ActivityVMKt$viewModel$1(viewModelStoreOwner, qualifier, function0, koinScope));
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> viewModel(ComponentActivity componentActivity, Qualifier qualifier, ViewModelStoreOwner viewModelStoreOwner, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return new ViewModelLazy<>(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityVMKt$viewModel$$inlined$viewModels$2(componentActivity), new ActivityVMKt$viewModel$1(viewModelStoreOwner, qualifier, function0, koinScope));
    }

    public static /* synthetic */ ViewModel getViewModel$default(ComponentActivity componentActivity, Qualifier qualifier, ViewModelStoreOwner viewModelStoreOwner, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            viewModelStoreOwner = componentActivity;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityVMKt$viewModel$$inlined$viewModels$2(componentActivity), new ActivityVMKt$getViewModel$$inlined$viewModel$1(viewModelStoreOwner, qualifier, function0, koinScope)).getValue();
    }

    public static final /* synthetic */ <T extends ViewModel> T getViewModel(ComponentActivity componentActivity, Qualifier qualifier, ViewModelStoreOwner viewModelStoreOwner, Function0<? extends ParametersHolder> function0) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityVMKt$viewModel$$inlined$viewModels$2(componentActivity), new ActivityVMKt$getViewModel$$inlined$viewModel$1(viewModelStoreOwner, qualifier, function0, koinScope)).getValue();
    }
}
