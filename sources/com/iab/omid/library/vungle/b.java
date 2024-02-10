package com.iab.omid.library.vungle;

import android.content.Context;
import com.iab.omid.library.vungle.internal.f;
import com.iab.omid.library.vungle.internal.h;
import com.iab.omid.library.vungle.utils.a;
import com.iab.omid.library.vungle.utils.c;
import com.iab.omid.library.vungle.utils.e;
import com.iab.omid.library.vungle.utils.g;

public class b {
    private boolean a;

    private void b(Context context) {
        g.a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return "1.4.8-Vungle";
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        b(context);
        if (!b()) {
            a(true);
            h.c().a(context);
            com.iab.omid.library.vungle.internal.b.g().a(context);
            a.a(context);
            c.a(context);
            e.a(context);
            f.b().a(context);
            com.iab.omid.library.vungle.internal.a.a().a(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.a = z;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        g.a();
        com.iab.omid.library.vungle.internal.a.a().d();
    }
}
