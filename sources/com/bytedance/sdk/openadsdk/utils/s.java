package com.bytedance.sdk.openadsdk.utils;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.o;

/* compiled from: PropSwitchUtils */
public class s {
    public static boolean a = a();

    private static boolean a() {
        SharedPreferences sharedPreferences;
        try {
            if (o.a() == null || (sharedPreferences = o.a().getSharedPreferences("pag_sp_prop_switch", 0)) == null || sharedPreferences.getInt("perf_con_use_prop", 1) == 1) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            l.d(th.getMessage());
        }
        return true;
    }

    public static void a(int i) {
        try {
            SharedPreferences.Editor edit = o.a().getSharedPreferences("pag_sp_prop_switch", 0).edit();
            edit.putInt("perf_con_use_prop", i);
            edit.apply();
        } catch (Throwable th) {
            l.d(th.getMessage());
        }
    }
}
