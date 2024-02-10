package com.m2catalyst.m2sdk.business.models;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkInfoSnapshot.kt */
public final class NetworkInfoSnapshot$1$4$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $str;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkInfoSnapshot$1$4$1(String str) {
        super(0);
        this.$str = str;
    }

    public final String invoke() {
        String substring = this.$str.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
