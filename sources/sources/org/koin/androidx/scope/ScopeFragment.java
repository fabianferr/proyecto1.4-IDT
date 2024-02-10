package org.koin.androidx.scope;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.logger.Logger;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8VX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lorg/koin/androidx/scope/ScopeFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/koin/android/scope/AndroidScopeComponent;", "contentLayoutId", "", "initialiseScope", "", "(IZ)V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "scope$delegate", "Lorg/koin/androidx/scope/LifecycleScopeDelegate;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ScopeFragment.kt */
public abstract class ScopeFragment extends Fragment implements AndroidScopeComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ScopeFragment.class, "scope", "getScope()Lorg/koin/core/scope/Scope;", 0))};
    private final boolean initialiseScope;
    private final LifecycleScopeDelegate scope$delegate;

    public ScopeFragment() {
        this(0, false, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScopeFragment(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? true : z);
    }

    public ScopeFragment(int i, boolean z) {
        super(i);
        this.initialiseScope = z;
        this.scope$delegate = FragmentExtKt.fragmentScope(this);
    }

    public Scope getScope() {
        return this.scope$delegate.getValue((LifecycleOwner) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (this.initialiseScope) {
            Logger logger = getScope().getLogger();
            logger.debug("Open Fragment Scope: " + getScope());
        }
    }
}
