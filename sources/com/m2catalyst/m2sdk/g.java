package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: CellInfoStrategy.kt */
public final class g extends Lambda implements Function0<Integer> {
    public final /* synthetic */ String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str) {
        super(0);
        this.a = str;
    }

    public final Object invoke() {
        String str = this.a;
        String substring = str.substring(3, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return Integer.valueOf(Integer.parseInt(substring));
    }
}
