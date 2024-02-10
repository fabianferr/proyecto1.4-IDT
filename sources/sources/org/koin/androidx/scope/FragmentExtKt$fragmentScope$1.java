package org.koin.androidx.scope;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.koin.core.Koin;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lorg/koin/core/scope/Scope;", "koin", "Lorg/koin/core/Koin;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: FragmentExt.kt */
final class FragmentExtKt$fragmentScope$1 extends Lambda implements Function1<Koin, Scope> {
    final /* synthetic */ Fragment $this_fragmentScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentExtKt$fragmentScope$1(Fragment fragment) {
        super(1);
        this.$this_fragmentScope = fragment;
    }

    public final Scope invoke(Koin koin) {
        Intrinsics.checkNotNullParameter(koin, "koin");
        Scope createScope$default = Koin.createScope$default(koin, KoinScopeComponentKt.getScopeId(this.$this_fragmentScope), KoinScopeComponentKt.getScopeName(this.$this_fragmentScope), (Object) null, 4, (Object) null);
        FragmentActivity activity = this.$this_fragmentScope.getActivity();
        Scope scopeOrNull = activity != null ? ComponentActivityExtKt.getScopeOrNull(activity) : null;
        if (scopeOrNull != null) {
            createScope$default.linkTo(scopeOrNull);
        }
        return createScope$default;
    }
}
