package org.koin.androidx.viewmodel;

import androidx.lifecycle.StateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.androidx.viewmodel.factory.DefaultViewModelFactory;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007\u001a)\u0010\u0007\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"pickFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/scope/Scope;", "viewModelParameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "resolveInstance", "Landroidx/lifecycle/ViewModelProvider;", "(Landroidx/lifecycle/ViewModelProvider;Lorg/koin/androidx/viewmodel/ViewModelParameter;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewModelResolver.kt */
public final class ViewModelResolverKt {
    public static final <T extends ViewModel> T resolveInstance(ViewModelProvider viewModelProvider, ViewModelParameter<T> viewModelParameter) {
        Intrinsics.checkNotNullParameter(viewModelProvider, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameter, "viewModelParameters");
        Class<T> javaClass = JvmClassMappingKt.getJavaClass(viewModelParameter.getClazz());
        if (viewModelParameter.getQualifier() != null) {
            T t = viewModelProvider.get(viewModelParameter.getQualifier().toString(), javaClass);
            Intrinsics.checkNotNullExpressionValue(t, "{\n        get(viewModelP…tring(), javaClass)\n    }");
            return t;
        }
        T t2 = viewModelProvider.get(javaClass);
        Intrinsics.checkNotNullExpressionValue(t2, "{\n        get(javaClass)\n    }");
        return t2;
    }

    public static final <T extends ViewModel> ViewModelProvider.Factory pickFactory(Scope scope, ViewModelParameter<T> viewModelParameter) {
        Intrinsics.checkNotNullParameter(scope, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameter, "viewModelParameters");
        if (viewModelParameter.getRegistryOwner() == null || viewModelParameter.getState() == null) {
            return new DefaultViewModelFactory(scope, viewModelParameter);
        }
        return new StateViewModelFactory(scope, viewModelParameter);
    }
}
