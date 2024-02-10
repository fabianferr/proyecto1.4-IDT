package com.wortise.ads;

import android.content.res.TypedArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003¨\u0006\u0006"}, d2 = {"Landroid/content/res/TypedArray;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: TypedArray.kt */
public final class n6 {
    public static final void a(TypedArray typedArray, Function1<? super TypedArray, Unit> function1) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(typedArray);
        typedArray.recycle();
    }
}
