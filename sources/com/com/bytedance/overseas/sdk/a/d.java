package com.com.bytedance.overseas.sdk.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.ac;

/* compiled from: TTDownloadFactory */
public class d {
    public static c a(Context context, q qVar, String str) {
        if (ac.i(context)) {
            return new b(context, qVar, str);
        }
        return new a(context, qVar, str);
    }
}
