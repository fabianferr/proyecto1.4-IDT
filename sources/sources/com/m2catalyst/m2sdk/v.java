package com.m2catalyst.m2sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class v {
    public static int a(PackageManager packageManager, String str, Context context, String str2) {
        Intrinsics.checkNotNullExpressionValue(packageManager, str);
        return packageManager.checkPermission(str2, context.getPackageName());
    }
}
