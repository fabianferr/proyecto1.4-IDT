package com.m2catalyst.m2sdk;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: PermissionUtility.kt */
public final class o4 {

    /* compiled from: PermissionUtility.kt */
    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.a = context;
        }

        public final Object invoke() {
            return Boolean.valueOf(ActivityCompat.checkSelfPermission(this.a, "android.permission.PACKAGE_USAGE_STATS") == 0);
        }
    }

    public static boolean a(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT > 28) {
            try {
                i = context.checkCallingOrSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION");
            } catch (RuntimeException unused) {
                i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.ACCESS_BACKGROUND_LOCATION");
            }
            if (i == 0) {
                return true;
            }
            return false;
        } else if (b(context) || c(context)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean b(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i = context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        } catch (RuntimeException unused) {
            i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.ACCESS_COARSE_LOCATION");
        }
        return i == 0;
    }

    public static boolean c(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i = context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        } catch (RuntimeException unused) {
            i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.ACCESS_FINE_LOCATION");
        }
        return i == 0;
    }

    public static boolean d(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        a aVar = new a(context);
        Object obj = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(aVar, "block");
        try {
            obj = aVar.invoke();
        } catch (Exception unused) {
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static boolean e(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        } catch (RuntimeException unused) {
            i = v.a(context.getPackageManager(), "context.packageManager", context, "android.permission.READ_PHONE_STATE");
        }
        return i == 0;
    }

    public static String a(SDKState sDKState, Context context, String str) {
        Intrinsics.checkNotNullParameter(sDKState, "sdkState");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "logSource");
        if (!sDKState.getFineLocationPermissionGranted$m2sdk_release()) {
            SDKState.Companion companion = SDKState.Companion;
            companion.getInstance().setCoarseLocationPermissionGranted$m2sdk_release(b(context));
            companion.getInstance().setFineLocationPermissionGranted$m2sdk_release(c(context));
            companion.getInstance().setBackgroundLocationPermissionGranted$m2sdk_release(a(context));
            companion.getInstance().setReadPhoneStatePermissionGranted$m2sdk_release(e(context));
            companion.getInstance().setPackageUsageStatsPermissionGranted$m2sdk_release(d(context));
            M2SDKLogger.Companion.i("permission_logs", "permission state recheck needed", new String[0]);
        }
        if (!sDKState.getFineLocationPermissionGranted$m2sdk_release()) {
            SDKState.Companion companion2 = SDKState.Companion;
            companion2.getInstance().setCoarseLocationPermissionGranted$m2sdk_release(b(context));
            companion2.getInstance().setFineLocationPermissionGranted$m2sdk_release(c(context));
            companion2.getInstance().setBackgroundLocationPermissionGranted$m2sdk_release(a(context));
            companion2.getInstance().setReadPhoneStatePermissionGranted$m2sdk_release(e(context));
            companion2.getInstance().setPackageUsageStatsPermissionGranted$m2sdk_release(d(context));
            M2SDKLogger.Companion.i("permission_logs", "permission state recheck needed 2nd time", new String[0]);
        }
        String a2 = a(sDKState.getCoarseLocationPermissionGranted$m2sdk_release(), sDKState.getFineLocationPermissionGranted$m2sdk_release(), sDKState.getPackageUsageStatsPermissionGranted$m2sdk_release(), sDKState.getBackgroundLocationPermissionGranted$m2sdk_release(), sDKState.getReadPhoneStatePermissionGranted$m2sdk_release());
        M2SDKLogger.Companion companion3 = M2SDKLogger.Companion;
        companion3.v("permission_logs", str + " permission set to: " + a2, new String[0]);
        return a2;
    }

    public static String a(SDKState sDKState) {
        Intrinsics.checkNotNullParameter(sDKState, "sdkState");
        Intrinsics.checkNotNullParameter("message_builder_helper", "logSource");
        String a2 = a(sDKState.getCoarseLocationPermissionGranted$m2sdk_release(), sDKState.getFineLocationPermissionGranted$m2sdk_release(), sDKState.getPackageUsageStatsPermissionGranted$m2sdk_release(), sDKState.getBackgroundLocationPermissionGranted$m2sdk_release(), sDKState.getReadPhoneStatePermissionGranted$m2sdk_release());
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        companion.v("permission_logs", "message_builder_helper permission set to: " + a2, new String[0]);
        return a2;
    }

    public static String a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        String[] strArr = new String[5];
        String str = "1";
        strArr[0] = z ? str : "0";
        strArr[1] = z2 ? str : "0";
        strArr[2] = z3 ? str : "0";
        strArr[3] = z4 ? str : "0";
        if (!z5) {
            str = "0";
        }
        strArr[4] = str;
        String str2 = "";
        for (int i = 0; i < 5; i++) {
            str2 = str2 + strArr[i];
        }
        return str2;
    }
}
