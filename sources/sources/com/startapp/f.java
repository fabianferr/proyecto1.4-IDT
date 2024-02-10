package com.startapp;

import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Sta */
public class f {
    public static f d = new f();
    public List<e> a = new ArrayList();
    public Map<AdPreferences.Placement, List<e>> b = new HashMap();
    public Map<String, List<e>> c = new HashMap();

    public static f a() {
        return d;
    }

    public int b() {
        return this.a.size();
    }

    public synchronized void a(e eVar) {
        this.a.add(0, eVar);
        List list = this.b.get(eVar.b);
        if (list == null) {
            list = new ArrayList();
            this.b.put(eVar.b, list);
        }
        list.add(0, eVar);
        List list2 = this.c.get(eVar.c);
        if (list2 == null) {
            list2 = new ArrayList();
            this.c.put(eVar.c, list2);
        }
        list2.add(0, eVar);
    }
}
