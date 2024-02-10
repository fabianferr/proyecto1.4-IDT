package org.koin.androidx.scope;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isActive", "", "Landroidx/lifecycle/LifecycleOwner;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: LifecycleScopeDelegate.kt */
public final class LifecycleScopeDelegateKt {
    public static final boolean isActive(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Lifecycle.State currentState = lifecycleOwner.getLifecycle().getCurrentState();
        Intrinsics.checkNotNullExpressionValue(currentState, "lifecycle.currentState");
        return currentState.isAtLeast(Lifecycle.State.CREATED);
    }
}
