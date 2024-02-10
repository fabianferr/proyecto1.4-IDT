package org.koin.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.qualifier.TypeQualifier;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lorg/koin/core/component/KoinScopeComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Koin.kt */
final class Koin$createScope$4 extends Lambda implements Function0<String> {
    final /* synthetic */ TypeQualifier $qualifier;
    final /* synthetic */ String $scopeId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Koin$createScope$4(String str, TypeQualifier typeQualifier) {
        super(0);
        this.$scopeId = str;
        this.$qualifier = typeQualifier;
    }

    public final String invoke() {
        return "|- create scope - id:'" + this.$scopeId + "' q:" + this.$qualifier;
    }
}
