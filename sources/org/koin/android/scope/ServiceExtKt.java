package org.koin.android.scope;

import android.app.Service;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u0002¨\u0006\b"}, d2 = {"createScope", "Lorg/koin/core/scope/Scope;", "Landroid/app/Service;", "source", "", "getScopeOrNull", "serviceScope", "Lkotlin/Lazy;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ServiceExt.kt */
public final class ServiceExtKt {
    public static final Lazy<Scope> serviceScope(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        return LazyKt.lazy(new ServiceExtKt$serviceScope$1(service));
    }

    public static final Scope createScope(Service service, Object obj) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        return ComponentCallbackExtKt.getKoin(service).createScope(KoinScopeComponentKt.getScopeId(service), KoinScopeComponentKt.getScopeName(service), obj);
    }

    public static /* synthetic */ Scope createScope$default(Service service, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return createScope(service, obj);
    }

    public static final Scope getScopeOrNull(Service service) {
        Intrinsics.checkNotNullParameter(service, "<this>");
        return ComponentCallbackExtKt.getKoin(service).getScopeOrNull(KoinScopeComponentKt.getScopeId(service));
    }
}
