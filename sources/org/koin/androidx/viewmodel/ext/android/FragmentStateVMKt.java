package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.scope.ScopeExtKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000D\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001as\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011¢\u0006\u0002\u0010\u0012\u001am\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b2\u0012\b\n\u0010\f\u001a\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e2\u0016\b\n\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001at\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011\u001an\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b2\u0012\b\n\u0010\f\u001a\f\u0012\u0004\u0012\u00020\r0\tj\u0002`\u000e2\u0016\b\n\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"getStateViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "clazz", "Lkotlin/reflect/KClass;", "state", "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lorg/koin/androidx/viewmodel/ViewModelStoreOwnerProducer;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "stateViewModel", "Lkotlin/Lazy;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: FragmentStateVM.kt */
public final class FragmentStateVMKt {
    public static /* synthetic */ Lazy stateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 4) != 0) {
            function02 = new FragmentStateVMKt$stateViewModel$1(fragment);
        }
        Function0 function05 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function04, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentStateVMKt$stateViewModel$$inlined$viewModels$1(function02), new FragmentStateVMKt$stateViewModel$2(function02, qualifier2, function05, function04, koinScope));
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> stateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentStateVMKt$stateViewModel$$inlined$viewModels$1(function02), new FragmentStateVMKt$stateViewModel$2(function02, qualifier, function03, function0, koinScope));
    }

    public static /* synthetic */ Lazy stateViewModel$default(Fragment fragment, Qualifier qualifier, KClass kClass, Function0<Bundle> function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 4) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 8) != 0) {
            function02 = new FragmentStateVMKt$stateViewModel$3(fragment);
        }
        return stateViewModel(fragment, qualifier2, kClass, function04, function02, (i & 16) != 0 ? null : function03);
    }

    public static final <T extends ViewModel> Lazy<T> stateViewModel(Fragment fragment, Qualifier qualifier, KClass<T> kClass, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, kClass, new FragmentStateVMKt$stateViewModel$4(fragment), new FragmentStateVMKt$stateViewModel$5(function02, kClass, qualifier, function03, function0, AndroidKoinScopeExtKt.getKoinScope(fragment)));
    }

    public static /* synthetic */ ViewModel getStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 4) != 0) {
            function02 = new FragmentStateVMKt$getStateViewModel$1(fragment);
        }
        Function0 function05 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function04, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentStateVMKt$stateViewModel$$inlined$viewModels$1(function02), new FragmentStateVMKt$getStateViewModel$$inlined$stateViewModel$1(function02, qualifier2, function05, function04, koinScope)).getValue();
    }

    public static /* synthetic */ ViewModel getStateViewModel$default(Fragment fragment, Qualifier qualifier, KClass kClass, Function0<Bundle> function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 4) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 8) != 0) {
            function02 = new FragmentStateVMKt$getStateViewModel$2(fragment);
        }
        return getStateViewModel(fragment, qualifier2, kClass, function04, function02, (i & 16) != 0 ? null : function03);
    }

    public static final <T extends ViewModel> T getStateViewModel(Fragment fragment, Qualifier qualifier, KClass<T> kClass, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        return (ViewModel) stateViewModel(fragment, qualifier, kClass, function0, function02, function03).getValue();
    }

    public static final /* synthetic */ <T extends ViewModel> T getStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentStateVMKt$stateViewModel$$inlined$viewModels$1(function02), new FragmentStateVMKt$getStateViewModel$$inlined$stateViewModel$1(function02, qualifier, function03, function0, koinScope)).getValue();
    }
}
