package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.model.q;

/* compiled from: SlotUtils */
public class v {
    public static boolean a(q qVar) {
        int aS;
        if (qVar == null || (aS = qVar.aS()) == 8 || aS == 7 || qVar.I() == null || Build.VERSION.SDK_INT > 27) {
            return false;
        }
        return true;
    }
}
