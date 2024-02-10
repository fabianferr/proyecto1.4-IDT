package org.koin.androidx.viewmodel.ext.android;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.viewmodel.ViewModelParameter;
import org.koin.androidx.viewmodel.ViewModelResolverKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001ah\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001ab\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\b\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r2\u0016\b\n\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\bø\u0001\u0000\u001a$\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"getViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "clazz", "Lkotlin/reflect/KClass;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "state", "Landroid/os/Bundle;", "Lorg/koin/androidx/viewmodel/scope/BundleDefinition;", "scope", "Lorg/koin/core/scope/Scope;", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: GetViewModelFactory.kt */
public final class GetViewModelFactoryKt {
    public static /* synthetic */ ViewModelProvider.Factory getViewModelFactory$default(ViewModelStoreOwner viewModelStoreOwner, Qualifier qualifier, Function0 function0, Function0 function02, Scope scope, int i, Object obj) {
        if ((i & 8) != 0) {
            function02 = null;
        }
        Function0 function03 = function02;
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getViewModelFactory(viewModelStoreOwner, Reflection.getOrCreateKotlinClass(ViewModel.class), qualifier, function0, function03, scope);
    }

    public static final /* synthetic */ <T extends ViewModel> ViewModelProvider.Factory getViewModelFactory(ViewModelStoreOwner viewModelStoreOwner, Qualifier qualifier, Function0<? extends ParametersHolder> function0, Function0<Bundle> function02, Scope scope) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getViewModelFactory(viewModelStoreOwner, Reflection.getOrCreateKotlinClass(ViewModel.class), qualifier, function0, function02, scope);
    }

    public static final <T extends ViewModel> ViewModelProvider.Factory getViewModelFactory(Scope scope, ViewModelParameter<T> viewModelParameter) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameter, "parameters");
        return ViewModelResolverKt.pickFactory(scope, viewModelParameter);
    }

    public static /* synthetic */ ViewModelProvider.Factory getViewModelFactory$default(ViewModelStoreOwner viewModelStoreOwner, KClass kClass, Qualifier qualifier, Function0 function0, Function0 function02, Scope scope, int i, Object obj) {
        if ((i & 16) != 0) {
            function02 = null;
        }
        return getViewModelFactory(viewModelStoreOwner, kClass, qualifier, function0, function02, scope);
    }

    public static final <T extends ViewModel> ViewModelProvider.Factory getViewModelFactory(ViewModelStoreOwner viewModelStoreOwner, KClass<T> kClass, Qualifier qualifier, Function0<? extends ParametersHolder> function0, Function0<Bundle> function02, Scope scope) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(scope, "scope");
        SavedStateRegistryOwner savedStateRegistryOwner = null;
        if ((function02 != null) && (viewModelStoreOwner instanceof SavedStateRegistryOwner)) {
            savedStateRegistryOwner = (SavedStateRegistryOwner) viewModelStoreOwner;
        }
        return ViewModelResolverKt.pickFactory(scope, new ViewModelParameter(kClass, qualifier, function02, function0, viewModelStoreOwner, savedStateRegistryOwner));
    }
}
