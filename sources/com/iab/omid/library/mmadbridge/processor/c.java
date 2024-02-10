package com.iab.omid.library.mmadbridge.processor;

import android.view.View;
import com.iab.omid.library.mmadbridge.adsession.a;
import com.iab.omid.library.mmadbridge.processor.a;
import com.iab.omid.library.mmadbridge.utils.e;
import com.iab.omid.library.mmadbridge.utils.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class c implements a {
    private final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<View> a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        com.iab.omid.library.mmadbridge.internal.c c = com.iab.omid.library.mmadbridge.internal.c.c();
        if (c != null) {
            Collection<a> a2 = c.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a2.size() * 2) + 3);
            for (a c2 : a2) {
                View c3 = c2.c();
                if (c3 != null && h.e(c3) && (rootView = c3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float c4 = h.c(rootView);
                    int size = arrayList.size();
                    while (size > 0 && h.c(arrayList.get(size - 1)) > c4) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    public JSONObject a(View view) {
        JSONObject a2 = com.iab.omid.library.mmadbridge.utils.c.a(0, 0, 0, 0);
        com.iab.omid.library.mmadbridge.utils.c.a(a2, e.a());
        return a2;
    }

    public void a(View view, JSONObject jSONObject, a.C0088a aVar, boolean z, boolean z2) {
        Iterator<View> it = a().iterator();
        while (it.hasNext()) {
            aVar.a(it.next(), this.a, jSONObject, z2);
        }
    }
}
