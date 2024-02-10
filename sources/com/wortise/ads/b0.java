package com.wortise.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Landroid/util/AttributeSet;", "Landroid/content/Context;", "context", "", "attrs", "Landroid/content/res/TypedArray;", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: AttributeSet.kt */
public final class b0 {
    public static final TypedArray a(AttributeSet attributeSet, Context context, int[] iArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iArr, "attrs");
        if (attributeSet == null) {
            return null;
        }
        return context.obtainStyledAttributes(attributeSet, iArr);
    }
}
