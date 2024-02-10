package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.e;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: DataEnergize */
public class a {
    private static volatile a b;
    public com.mbridge.msdk.video.dynview.d.a a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (b != null) {
            return b;
        }
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public final void a(View view, c cVar, Map map, e eVar) {
        int h = cVar.h();
        if (h == 1) {
            com.mbridge.msdk.video.dynview.j.a aVar = new com.mbridge.msdk.video.dynview.j.a();
            aVar.a(cVar, view, map, eVar);
            this.a = aVar.a;
        } else if (h == 102 || h == 202 || h == 302 || h == 802 || h == 904) {
            new com.mbridge.msdk.video.dynview.j.a().b(cVar, view, map, eVar);
        } else if (h == 4) {
            new com.mbridge.msdk.video.dynview.j.a().a(cVar, view, eVar);
        } else if (h != 5) {
            eVar.a(view, new ArrayList());
        } else {
            new com.mbridge.msdk.video.dynview.j.a().c(cVar, view, map, eVar);
        }
    }

    public final void b() {
        com.mbridge.msdk.video.dynview.d.a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
