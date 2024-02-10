package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
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

@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a_\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e¢\u0006\u0002\u0010\u000f\u001aY\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0016\b\n\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a`\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000e\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\n\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0016\b\n\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"getStateViewModel", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "state", "Lkotlin/Function0;", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "clazz", "Lkotlin/reflect/KClass;", "parameters", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Landroidx/activity/ComponentActivity;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "(Landroidx/activity/ComponentActivity;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "stateViewModel", "Lkotlin/Lazy;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ActivityStateVM.kt */
public final class ActivityStateVMKt {
    public static /* synthetic */ Lazy stateViewModel$default(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function03 = function0;
        Function0 function04 = (i & 4) != 0 ? null : function02;
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(function03, "state");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityStateVMKt$stateViewModel$$inlined$viewModels$2(componentActivity), new ActivityStateVMKt$stateViewModel$1(componentActivity, qualifier2, function04, function03, koinScope));
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> stateViewModel(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return new ViewModelLazy<>(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityStateVMKt$stateViewModel$$inlined$viewModels$2(componentActivity), new ActivityStateVMKt$stateViewModel$1(componentActivity, qualifier, function02, function0, koinScope));
    }

    public static /* synthetic */ Lazy stateViewModel$default(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, KClass kClass, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        if ((i & 8) != 0) {
            function02 = null;
        }
        return stateViewModel(componentActivity, qualifier, function0, kClass, function02);
    }

    public static final <T extends ViewModel> Lazy<T> stateViewModel(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, KClass<T> kClass, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return new ViewModelLazy<>(kClass, new ActivityStateVMKt$stateViewModel$2(componentActivity), new ActivityStateVMKt$stateViewModel$3(componentActivity, kClass, qualifier, function02, function0, AndroidKoinScopeExtKt.getKoinScope(componentActivity)));
    }

    public static /* synthetic */ ViewModel getStateViewModel$default(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, Function0 function02, int i, Object obj) {
        Qualifier qualifier2 = (i & 1) != 0 ? null : qualifier;
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        Function0<Bundle> function03 = function0;
        Function0 function04 = (i & 4) != 0 ? null : function02;
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(function03, "state");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityStateVMKt$stateViewModel$$inlined$viewModels$2(componentActivity), new ActivityStateVMKt$getStateViewModel$$inlined$stateViewModel$1(componentActivity, qualifier2, function04, function03, koinScope)).getValue();
    }

    public static /* synthetic */ ViewModel getStateViewModel$default(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, KClass kClass, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = ScopeExtKt.emptyState();
        }
        if ((i & 8) != 0) {
            function02 = null;
        }
        return getStateViewModel(componentActivity, qualifier, function0, kClass, function02);
    }

    public static final <T extends ViewModel> T getStateViewModel(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, KClass<T> kClass, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        return (ViewModel) stateViewModel(componentActivity, qualifier, function0, kClass, function02).getValue();
    }

    public static final /* synthetic */ <T extends ViewModel> T getStateViewModel(ComponentActivity componentActivity, Qualifier qualifier, Function0<Bundle> function0, Function0<? extends ParametersHolder> function02) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(function0, "state");
        Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (ViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), new ActivityStateVMKt$stateViewModel$$inlined$viewModels$2(componentActivity), new ActivityStateVMKt$getStateViewModel$$inlined$stateViewModel$1(componentActivity, qualifier, function02, function0, koinScope)).getValue();
    }
}
