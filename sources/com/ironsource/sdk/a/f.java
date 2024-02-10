package com.ironsource.sdk.a;

import android.util.Log;
import com.ironsource.a.a;
import com.ironsource.a.b;
import com.ironsource.sdk.a.h;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private static f a;
    private b b;

    private f() {
    }

    private static f a() {
        if (a == null) {
            a = new f();
        }
        return a;
    }

    public static void a(a aVar, d dVar) {
        if (aVar != null) {
            try {
                a().b = new b(aVar, dVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(h.a aVar) {
        a(aVar, (Map<String, Object>) new HashMap());
    }

    public static void a(h.a aVar, Map<String, Object> map) {
        b bVar = a().b;
        if (bVar == null) {
            Log.d("sdk5Events", "logEvent failed eventsTracker doesn't exist");
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.b));
        }
        bVar.a(aVar.a, map);
    }
}
