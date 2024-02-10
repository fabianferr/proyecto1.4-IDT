package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.multipro.d.a;

/* compiled from: MultiGlobalInfo */
public class b {
    public static Boolean a;

    public static void a() {
        a = true;
        a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
    }

    public static void b() {
        a = false;
        BinderPoolService.a = true;
    }

    public static boolean c() {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!l.e()) {
            return false;
        }
        if (a == null) {
            a = Boolean.valueOf(a.a("sp_multi_info", "is_support_multi_process", false));
        }
        return a.booleanValue();
    }
}
