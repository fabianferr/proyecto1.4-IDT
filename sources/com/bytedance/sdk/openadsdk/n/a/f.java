package com.bytedance.sdk.openadsdk.n.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* compiled from: PAGMrcVisibilityTracker */
public class f {
    public static boolean a(View view) {
        return a(view, false);
    }

    public static boolean a(View view, boolean z) {
        if (view == null || !DeviceUtils.a() || !view.isShown()) {
            return false;
        }
        if (y.a(view) > (z ? 0.3f : 0.5f)) {
            return true;
        }
        return false;
    }
}
