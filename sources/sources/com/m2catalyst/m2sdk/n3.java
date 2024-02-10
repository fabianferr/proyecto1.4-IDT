package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage;
import com.m2catalyst.m2sdk.external.SDKState;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageBuilderHelper.kt */
public final class n3 {
    public static ApiRequestMessage.Builder a(r2 r2Var) {
        Intrinsics.checkNotNullParameter(r2Var, "configuration");
        boolean z = false;
        M2Configuration a = r2Var.a(false);
        d6 d6Var = r2Var.h;
        ApiRequestMessage.Builder builder = new ApiRequestMessage.Builder();
        z5 a2 = r2Var.a();
        a6 a6Var = a6.PERMISSION_MONITOR_MODE;
        Object obj = Boolean.FALSE;
        String str = a6Var.a;
        if (a2.a.getAll().containsKey(str)) {
            obj = a2.a.getAll().get(str);
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            z = bool.booleanValue();
        }
        builder.version(a.getVersionName()).device_id(Integer.valueOf(d6Var.a)).persistent_mode(Boolean.valueOf(z)).message_create_time(Long.valueOf(Calendar.getInstance().getTimeInMillis())).company_id(Integer.valueOf(d6Var.c)).host_package_name(a.getPackageName()).api_key(d6Var.d).version_code(Integer.valueOf(a.getVersionCode())).android_version(Integer.valueOf(a.getAndroidVersion())).permissions(o4.a(SDKState.Companion.getInstance()));
        return builder;
    }
}
