package com.m2catalyst.m2sdk;

import android.content.Context;
import androidx.core.app.ActivityCompat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: PermissionUtility.kt */
public final class n4 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ Context a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n4(Context context) {
        super(0);
        this.a = context;
    }

    public final Object invoke() {
        return Boolean.valueOf(ActivityCompat.checkSelfPermission(this.a, "android.permission.ACCESS_NETWORK_STATE") == 0);
    }
}
