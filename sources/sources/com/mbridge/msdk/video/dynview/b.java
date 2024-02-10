package com.mbridge.msdk.video.dynview;

import android.view.View;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.h.a;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MBUIController */
public class b {
    private static volatile b b;
    public Map<String, SoftReference<View>> a = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar;
        if (b != null) {
            return b;
        }
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public final void a(c cVar, g gVar) {
        new a(cVar, gVar, new HashMap());
    }
}
