package com.wortise.ads;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ab\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u001d\u0010\u0005\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002¢\u0006\u0002\b\u00042#\u0010\u0007\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u00020\u0002¢\u0006\u0002\b\u0004¨\u0006\n"}, d2 = {"T", "U", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lkotlin/ExtensionFunctionType;", "getter", "", "setter", "Lcom/wortise/ads/b6;", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: SafeDelegate.kt */
public final class c6 {
    public static final <T, U> b6<T, U> a(Function1<? super T, ? extends Function0<? extends U>> function1, Function1<? super T, ? extends Function1<? super U, ? extends Object>> function12) {
        Intrinsics.checkNotNullParameter(function1, "getter");
        Intrinsics.checkNotNullParameter(function12, "setter");
        return new b6<>(function1, function12);
    }
}
