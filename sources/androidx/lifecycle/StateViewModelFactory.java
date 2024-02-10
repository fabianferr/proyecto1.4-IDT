package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.androidx.viewmodel.ViewModelParameter;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J5\u0010\u0013\u001a\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0014¢\u0006\u0002\u0010\u0018R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/StateViewModelFactory;", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "(Lorg/koin/core/scope/Scope;Lorg/koin/androidx/viewmodel/ViewModelParameter;)V", "getParameters", "()Lorg/koin/androidx/viewmodel/ViewModelParameter;", "getScope", "()Lorg/koin/core/scope/Scope;", "addHandle", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "create", "key", "", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StateViewModelFactory.kt */
public final class StateViewModelFactory<T extends ViewModel> extends AbstractSavedStateViewModelFactory {
    private final ViewModelParameter<T> parameters;
    private final Scope scope;

    public final Scope getScope() {
        return this.scope;
    }

    public final ViewModelParameter<T> getParameters() {
        return this.parameters;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StateViewModelFactory(org.koin.core.scope.Scope r3, org.koin.androidx.viewmodel.ViewModelParameter<T> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.savedstate.SavedStateRegistryOwner r0 = r4.getRegistryOwner()
            if (r0 == 0) goto L_0x0026
            kotlin.jvm.functions.Function0 r1 = r4.getState()
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r1.invoke()
            android.os.Bundle r1 = (android.os.Bundle) r1
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            r2.<init>(r0, r1)
            r2.scope = r3
            r2.parameters = r4
            return
        L_0x0026:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Can't create SavedStateViewModelFactory without a proper stateRegistryOwner"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.StateViewModelFactory.<init>(org.koin.core.scope.Scope, org.koin.androidx.viewmodel.ViewModelParameter):void");
    }

    /* access modifiers changed from: protected */
    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
        return (ViewModel) this.scope.get(this.parameters.getClazz(), this.parameters.getQualifier(), addHandle(savedStateHandle));
    }

    private final Function0<ParametersHolder> addHandle(SavedStateHandle savedStateHandle) {
        ParametersHolder parametersHolder;
        Function0<ParametersHolder> parameters2 = this.parameters.getParameters();
        if (parameters2 == null || (parametersHolder = parameters2.invoke()) == null) {
            parametersHolder = ParametersHolderKt.emptyParametersHolder();
        }
        return new StateViewModelFactory$addHandle$1(parametersHolder, savedStateHandle);
    }
}
