package com.bytedance.sdk.openadsdk.n.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PAGMrcTrackerManager */
public class e {
    private static final Map<Integer, b> a = new ConcurrentHashMap();

    public static void a(View view, q qVar, int i) {
        if (view != null && qVar != null && !qVar.aB()) {
            boolean c = c(qVar);
            if (t.b(qVar)) {
                i = -1;
            }
            a(a(view, qVar, c, i));
        }
    }

    private static boolean c(q qVar) {
        if (qVar == null) {
            return false;
        }
        String a2 = ac.a(qVar);
        if (!((("open_ad".equals(a2) || "fullscreen_interstitial_ad".equals(a2) || "rewarded_video".equals(a2)) && !t.b(qVar)) && qVar.o() != 5) || !q.c(qVar) || qVar.K() == null) {
            return false;
        }
        return true;
    }

    private static b a(View view, q qVar, boolean z, int i) {
        if (view == null || qVar == null || qVar.Y() == null) {
            return null;
        }
        Integer b = b(qVar);
        Map<Integer, b> map = a;
        if (map.containsKey(b)) {
            b bVar = map.get(b);
            if (bVar != null) {
                bVar.a(view);
            }
            return bVar;
        }
        b a2 = b.a(z, b, view, qVar, i);
        map.put(b, a2);
        return a2;
    }

    private static void a(b bVar) {
        if (bVar != null) {
            bVar.a();
        }
    }

    public static void a(q qVar, int i) {
        if (qVar != null && qVar.Y() != null) {
            a(a.get(b(qVar)), i);
        }
    }

    public static void a(b bVar, int i) {
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public static void a(q qVar) {
        if (qVar != null && qVar.Y() != null) {
            Integer b = b(qVar);
            Map<Integer, b> map = a;
            b bVar = map.get(b);
            if (bVar != null) {
                bVar.j();
            }
            b(b);
            if (map.size() <= 0) {
                g.a();
            }
        }
    }

    public static b a(Integer num) {
        return a.get(num);
    }

    public static void b(Integer num) {
        a.remove(num);
    }

    public static Integer b(q qVar) {
        return Integer.valueOf((qVar.bc() + qVar.Y()).hashCode());
    }
}
