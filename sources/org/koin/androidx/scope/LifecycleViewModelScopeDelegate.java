package org.koin.androidx.scope;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\u001d\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lorg/koin/androidx/scope/LifecycleViewModelScopeDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/lifecycle/LifecycleOwner;", "Lorg/koin/core/scope/Scope;", "lifecycleOwner", "koin", "Lorg/koin/core/Koin;", "createScope", "Lkotlin/Function1;", "(Landroidx/lifecycle/LifecycleOwner;Lorg/koin/core/Koin;Lkotlin/jvm/functions/Function1;)V", "_scope", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "scopeId", "", "Lorg/koin/core/qualifier/QualifierValue;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LifecycleViewModelScopeDelegate.kt */
public final class LifecycleViewModelScopeDelegate implements ReadOnlyProperty<LifecycleOwner, Scope> {
    /* access modifiers changed from: private */
    public Scope _scope;
    private final Function1<Koin, Scope> createScope;
    private final Koin koin;
    private final LifecycleOwner lifecycleOwner;
    private final String scopeId;

    public LifecycleViewModelScopeDelegate(LifecycleOwner lifecycleOwner2, Koin koin2, Function1<? super Koin, Scope> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(koin2, "koin");
        Intrinsics.checkNotNullParameter(function1, "createScope");
        this.lifecycleOwner = lifecycleOwner2;
        this.koin = koin2;
        this.createScope = function1;
        String value = KoinScopeComponentKt.getScopeName(lifecycleOwner2).getValue();
        this.scopeId = value;
        boolean z = lifecycleOwner2 instanceof ComponentActivity;
        final Logger logger = koin2.getLogger();
        logger.debug("setup scope: " + this._scope + " for " + lifecycleOwner2);
        Scope scopeOrNull = koin2.getScopeOrNull(value);
        this._scope = scopeOrNull == null ? function1.invoke(koin2) : scopeOrNull;
        logger.debug("got scope: " + this._scope + " for " + lifecycleOwner2);
        lifecycleOwner2.getLifecycle().addObserver(new DefaultLifecycleObserver() {
            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
            }

            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
            }

            public void onCreate(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                Logger logger = logger;
                logger.debug("Attach ViewModel scope: " + this._scope + " to " + this.getLifecycleOwner());
                ComponentActivity componentActivity = (ComponentActivity) this.getLifecycleOwner();
                ScopeHandlerViewModel scopeHandlerViewModel = (ScopeHandlerViewModel) new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScopeHandlerViewModel.class), new LifecycleViewModelScopeDelegate$3$onCreate$$inlined$viewModels$default$2(componentActivity), new LifecycleViewModelScopeDelegate$3$onCreate$$inlined$viewModels$default$1(componentActivity)).getValue();
                if (scopeHandlerViewModel.getScope() == null) {
                    scopeHandlerViewModel.setScope(this._scope);
                }
            }
        });
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LifecycleViewModelScopeDelegate(final LifecycleOwner lifecycleOwner2, Koin koin2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner2, koin2, (i & 4) != 0 ? new Function1<Koin, Scope>() {
            public final Scope invoke(Koin koin) {
                Intrinsics.checkNotNullParameter(koin, "koin");
                return Koin.createScope$default(koin, KoinScopeComponentKt.getScopeName(lifecycleOwner2).getValue(), KoinScopeComponentKt.getScopeName(lifecycleOwner2), (Object) null, 4, (Object) null);
            }
        } : function1);
    }

    public Scope getValue(LifecycleOwner lifecycleOwner2, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Scope scope = this._scope;
        if (scope != null) {
            Intrinsics.checkNotNull(scope);
            return scope;
        } else if (LifecycleScopeDelegateKt.isActive(lifecycleOwner2)) {
            Scope scopeOrNull = this.koin.getScopeOrNull(KoinScopeComponentKt.getScopeName(this.lifecycleOwner).getValue());
            if (scopeOrNull == null) {
                scopeOrNull = this.createScope.invoke(this.koin);
            }
            this._scope = scopeOrNull;
            Logger logger = this.koin.getLogger();
            logger.debug("got scope: " + this._scope + " for " + this.lifecycleOwner);
            Scope scope2 = this._scope;
            Intrinsics.checkNotNull(scope2);
            return scope2;
        } else {
            throw new IllegalStateException(("can't get Scope for " + this.lifecycleOwner + " - LifecycleOwner is not Active").toString());
        }
    }
}
