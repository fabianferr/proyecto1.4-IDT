package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import java.util.Map;

/* compiled from: UIEnergize */
public class b {
    private static volatile b a;

    private b() {
    }

    public static b a() {
        b bVar;
        if (a != null) {
            return a;
        }
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public final void a(View view, c cVar, Map<String, Object> map) {
        if (cVar != null) {
            int h = cVar.h();
            if (h == 1) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, map);
            } else if (h == 102 || h == 202 || h == 302 || h == 802 || h == 904) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, cVar, map);
            } else if (h == 3) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, cVar);
            } else if (h == 4) {
                new com.mbridge.msdk.video.dynview.j.b().b(view, cVar, map);
            } else if (h == 5) {
                new com.mbridge.msdk.video.dynview.j.b();
            }
        }
    }
}
