package org.koin.androidx.fragment.android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lorg/koin/androidx/fragment/android/KoinFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "Lorg/koin/core/component/KoinComponent;", "scope", "Lorg/koin/core/scope/Scope;", "(Lorg/koin/core/scope/Scope;)V", "instantiate", "Landroidx/fragment/app/Fragment;", "classLoader", "Ljava/lang/ClassLoader;", "className", "", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: KoinFragmentFactory.kt */
public final class KoinFragmentFactory extends FragmentFactory implements KoinComponent {
    private final Scope scope;

    public KoinFragmentFactory() {
        this((Scope) null, 1, (DefaultConstructorMarker) null);
    }

    public KoinFragmentFactory(Scope scope2) {
        this.scope = scope2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KoinFragmentFactory(Scope scope2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : scope2);
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public Fragment instantiate(ClassLoader classLoader, String str) {
        Fragment fragment;
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(str, "className");
        Class<?> cls = Class.forName(str);
        Intrinsics.checkNotNullExpressionValue(cls, "forName(className)");
        KClass<?> kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
        Scope scope2 = this.scope;
        if (scope2 != null) {
            fragment = (Fragment) Scope.getOrNull$default(scope2, kotlinClass, (Qualifier) null, (Function0) null, 6, (Object) null);
        } else {
            fragment = (Fragment) Koin.getOrNull$default(getKoin(), kotlinClass, (Qualifier) null, (Function0) null, 6, (Object) null);
        }
        if (fragment != null) {
            return fragment;
        }
        Fragment instantiate = super.instantiate(classLoader, str);
        Intrinsics.checkNotNullExpressionValue(instantiate, "super.instantiate(classLoader, className)");
        return instantiate;
    }
}
