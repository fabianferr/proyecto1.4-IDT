package com.iab.omid.library.vungle.internal;

import com.iab.omid.library.vungle.adsession.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class c {
    private static c c = new c();
    private final ArrayList<a> a = new ArrayList<>();
    private final ArrayList<a> b = new ArrayList<>();

    private c() {
    }

    public static c c() {
        return c;
    }

    public Collection<a> a() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void a(a aVar) {
        this.a.add(aVar);
    }

    public Collection<a> b() {
        return Collections.unmodifiableCollection(this.a);
    }

    public void b(a aVar) {
        boolean d = d();
        this.a.remove(aVar);
        this.b.remove(aVar);
        if (d && !d()) {
            h.c().e();
        }
    }

    public void c(a aVar) {
        boolean d = d();
        this.b.add(aVar);
        if (!d) {
            h.c().d();
        }
    }

    public boolean d() {
        return this.b.size() > 0;
    }
}
