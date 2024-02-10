package org.koin.androidx.scope;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lorg/koin/androidx/scope/ScopeHandlerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "setScope", "(Lorg/koin/core/scope/Scope;)V", "onCleared", "", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ScopeHandlerViewModel.kt */
public final class ScopeHandlerViewModel extends ViewModel {
    private Scope scope;

    public final Scope getScope() {
        return this.scope;
    }

    public final void setScope(Scope scope2) {
        this.scope = scope2;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        Scope scope2 = this.scope;
        if (scope2 != null && scope2.isNotClosed()) {
            Logger logger = scope2.getLogger();
            logger.debug("Closing scope " + this.scope);
            scope2.close();
        }
        this.scope = null;
    }
}
