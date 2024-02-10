package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
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

@Metadata(d1 = {"\u0000D\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001as\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0007j\u0002`\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011¢\u0006\u0002\u0010\u0012\u001am\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0012\b\n\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0007j\u0002`\f2\u0016\b\n\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001at\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0007j\u0002`\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011\u001an\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0012\b\n\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0007j\u0002`\f2\u0016\b\n\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"getSharedStateViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "state", "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lorg/koin/androidx/viewmodel/ViewModelStoreOwnerProducer;", "clazz", "Lkotlin/reflect/KClass;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "(Landroidx/fragment/app/Fragment;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "sharedStateViewModel", "Lkotlin/Lazy;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: FragmentSharedStateVM.kt */
public final class FragmentSharedStateVMKt {
    public static /* synthetic */ Lazy sharedStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 4) != 0) {
            function02 = new FragmentSharedStateVMKt$sharedStateViewModel$1(fragment);
        }
        Function0 function05 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function04, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentSharedStateVMKt$sharedStateViewModel$$inlined$viewModels$1(function02), new FragmentSharedStateVMKt$sharedStateViewModel$2(function02, qualifier2, function05, function04, koinScope));
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> sharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentSharedStateVMKt$sharedStateViewModel$$inlined$viewModels$1(function02), new FragmentSharedStateVMKt$sharedStateViewModel$2(function02, qualifier, function03, function0, koinScope));
    }

    public static /* synthetic */ Lazy sharedStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, KClass kClass, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 4) != 0) {
            function02 = new FragmentSharedStateVMKt$sharedStateViewModel$3(fragment);
        }
        return sharedStateViewModel(fragment, qualifier2, function04, function02, kClass, (i & 16) != 0 ? null : function03);
    }

    public static final <T extends ViewModel> Lazy<T> sharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, KClass<T> kClass, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return new ViewModelLazy<>(kClass, new FragmentSharedStateVMKt$sharedStateViewModel$4(fragment), new FragmentSharedStateVMKt$sharedStateViewModel$5(function02, kClass, qualifier, function03, function0, AndroidKoinScopeExtKt.getKoinScope(fragment)));
    }

    public static /* synthetic */ ViewModel getSharedStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 4) != 0) {
            function02 = new FragmentSharedStateVMKt$getSharedStateViewModel$1(fragment);
        }
        Function0 function05 = (i & 8) != 0 ? null : function03;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function04, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentSharedStateVMKt$sharedStateViewModel$$inlined$viewModels$1(function02), new FragmentSharedStateVMKt$getSharedStateViewModel$$inlined$sharedStateViewModel$1(function02, qualifier2, function05, function04, koinScope)).getValue();
    }

    public static /* synthetic */ ViewModel getSharedStateViewModel$default(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, KClass kClass, Function0 function03, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function04 = function0;
        if ((i & 4) != 0) {
            function02 = new FragmentSharedStateVMKt$getSharedStateViewModel$2(fragment);
        }
        return getSharedStateViewModel(fragment, qualifier2, function04, function02, kClass, (i & 16) != 0 ? null : function03);
    }

    public static final <T extends ViewModel> T getSharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, KClass<T> kClass, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return (ViewModel) sharedStateViewModel(fragment, qualifier, function0, function02, kClass, function03).getValue();
    }

    public static final /* synthetic */ <T extends ViewModel> T getSharedStateViewModel(Fragment fragment, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ViewModelStoreOwner> function02, Function0<? extends ParametersHolder> function03) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(function02, "owner");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ViewModel.class), new FragmentSharedStateVMKt$sharedStateViewModel$$inlined$viewModels$1(function02), new FragmentSharedStateVMKt$getSharedStateViewModel$$inlined$sharedStateViewModel$1(function02, qualifier, function03, function0, koinScope)).getValue();
    }
}
