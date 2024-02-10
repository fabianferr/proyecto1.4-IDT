package org.koin.androidx.scope;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B+\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\u0010\nJ\b\u0010\b\u001a\u00020\u000eH\u0002J\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00032\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lorg/koin/androidx/scope/LifecycleScopeDelegate;", "T", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/lifecycle/LifecycleOwner;", "Lorg/koin/core/scope/Scope;", "lifecycleOwner", "koin", "Lorg/koin/core/Koin;", "createScope", "Lkotlin/Function1;", "(Landroidx/lifecycle/LifecycleOwner;Lorg/koin/core/Koin;Lkotlin/jvm/functions/Function1;)V", "_scope", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LifecycleScopeDelegate.kt */
public final class LifecycleScopeDelegate<T> implements ReadOnlyProperty<LifecycleOwner, Scope> {
    /* access modifiers changed from: private */
    public Scope _scope;
    private final Function1<Koin, Scope> createScope;
    private final Koin koin;
    private final LifecycleOwner lifecycleOwner;

    public LifecycleScopeDelegate(LifecycleOwner lifecycleOwner2, Koin koin2, Function1<? super Koin, Scope> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(koin2, "koin");
        Intrinsics.checkNotNullParameter(function1, "createScope");
        this.lifecycleOwner = lifecycleOwner2;
        this.koin = koin2;
        this.createScope = function1;
        final Logger logger = koin2.getLogger();
        logger.debug("setup scope: " + this._scope + " for " + lifecycleOwner2);
        lifecycleOwner2.getLifecycle().addObserver(new DefaultLifecycleObserver(this) {
            final /* synthetic */ LifecycleScopeDelegate<T> this$0;

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

            {
                this.this$0 = r1;
            }

            public void onCreate(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                this.this$0.createScope();
            }

            public void onDestroy(LifecycleOwner lifecycleOwner) {
                Scope access$get_scope$p;
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                Logger logger = logger;
                logger.debug("Closing scope: " + this.this$0._scope + " for " + this.this$0.getLifecycleOwner());
                Scope access$get_scope$p2 = this.this$0._scope;
                boolean z = false;
                if (access$get_scope$p2 != null && !access$get_scope$p2.getClosed()) {
                    z = true;
                }
                if (z && (access$get_scope$p = this.this$0._scope) != null) {
                    access$get_scope$p.close();
                }
                this.this$0._scope = null;
            }
        });
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LifecycleScopeDelegate(final LifecycleOwner lifecycleOwner2, Koin koin2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner2, koin2, (i & 4) != 0 ? new Function1<Koin, Scope>() {
            public final Scope invoke(Koin koin) {
                Intrinsics.checkNotNullParameter(koin, "koin");
                return koin.createScope(KoinScopeComponentKt.getScopeId(lifecycleOwner2), KoinScopeComponentKt.getScopeName(lifecycleOwner2), lifecycleOwner2);
            }
        } : function1);
    }

    /* access modifiers changed from: private */
    public final void createScope() {
        if (this._scope == null) {
            Logger logger = this.koin.getLogger();
            logger.debug("Create scope: " + this._scope + " for " + this.lifecycleOwner);
            Scope scopeOrNull = this.koin.getScopeOrNull(KoinScopeComponentKt.getScopeId(this.lifecycleOwner));
            if (scopeOrNull == null) {
                scopeOrNull = this.createScope.invoke(this.koin);
            }
            this._scope = scopeOrNull;
        }
    }

    public Scope getValue(LifecycleOwner lifecycleOwner2, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Scope scope = this._scope;
        if (scope == null) {
            createScope();
            Scope scope2 = this._scope;
            if (scope2 != null) {
                return scope2;
            }
            throw new IllegalStateException(("can't get Scope for " + this.lifecycleOwner).toString());
        } else if (scope != null) {
            return scope;
        } else {
            throw new IllegalStateException(("can't get Scope for " + this.lifecycleOwner).toString());
        }
    }
}
