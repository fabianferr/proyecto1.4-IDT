package org.koin.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: KoinApplication.kt */
final class KoinApplication$modules$duration$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<Module> $modules;
    final /* synthetic */ KoinApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KoinApplication$modules$duration$1(KoinApplication koinApplication, List<Module> list) {
        super(0);
        this.this$0 = koinApplication;
        this.$modules = list;
    }

    public final void invoke() {
        this.this$0.loadModules(this.$modules);
    }
}
