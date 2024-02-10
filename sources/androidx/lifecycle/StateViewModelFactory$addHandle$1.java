package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;", "T", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: StateViewModelFactory.kt */
final class StateViewModelFactory$addHandle$1 extends Lambda implements Function0<ParametersHolder> {
    final /* synthetic */ ParametersHolder $definitionParameters;
    final /* synthetic */ SavedStateHandle $handle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StateViewModelFactory$addHandle$1(ParametersHolder parametersHolder, SavedStateHandle savedStateHandle) {
        super(0);
        this.$definitionParameters = parametersHolder;
        this.$handle = savedStateHandle;
    }

    public final ParametersHolder invoke() {
        return this.$definitionParameters.add(this.$handle);
    }
}
