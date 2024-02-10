package com.startapp;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: Sta */
public final /* synthetic */ class i0 {
    public static int a(Context context, int i, float f) {
        return Math.round(TypedValue.applyDimension(i, f, context.getResources().getDisplayMetrics()));
    }
}
