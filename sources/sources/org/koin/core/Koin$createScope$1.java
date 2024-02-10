package org.koin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Koin.kt */
final class Koin$createScope$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ String $scopeId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Koin$createScope$1(String str, Qualifier qualifier) {
        super(0);
        this.$scopeId = str;
        this.$qualifier = qualifier;
    }

    public final String invoke() {
        return "|- create scope - id:'" + this.$scopeId + "' q:" + this.$qualifier;
    }
}
