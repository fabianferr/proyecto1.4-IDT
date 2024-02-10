package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: NetworkUtils.kt */
public final class k4 extends Lambda implements Function0<String> {
    public final /* synthetic */ String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k4(String str) {
        super(0);
        this.a = str;
    }

    public final Object invoke() {
        String substring = this.a.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
