package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.core.model.q;
import java.lang.ref.SoftReference;

/* compiled from: AdUtils */
public class b {
    public static SoftReference<q> a;

    public static q a() {
        SoftReference<q> softReference = a;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public static void a(q qVar) {
        if (qVar != null) {
            a = new SoftReference<>(qVar);
        }
    }
}
