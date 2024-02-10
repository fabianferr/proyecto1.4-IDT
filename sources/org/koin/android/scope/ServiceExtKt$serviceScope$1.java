package org.koin.android.scope;

import android.app.Service;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/koin/core/scope/Scope;", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ServiceExt.kt */
final class ServiceExtKt$serviceScope$1 extends Lambda implements Function0<Scope> {
    final /* synthetic */ Service $this_serviceScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceExtKt$serviceScope$1(Service service) {
        super(0);
        this.$this_serviceScope = service;
    }

    public final Scope invoke() {
        Scope scopeOrNull = ServiceExtKt.getScopeOrNull(this.$this_serviceScope);
        return scopeOrNull == null ? ServiceExtKt.createScope$default(this.$this_serviceScope, (Object) null, 1, (Object) null) : scopeOrNull;
    }
}
