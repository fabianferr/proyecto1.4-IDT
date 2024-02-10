package com.iab.omid.library.ironsrc.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.ironsrc.adsession.a;
import com.iab.omid.library.ironsrc.devicevolume.b;
import com.iab.omid.library.ironsrc.devicevolume.c;
import com.iab.omid.library.ironsrc.devicevolume.e;
import com.iab.omid.library.ironsrc.internal.d;
import com.iab.omid.library.ironsrc.walking.TreeWalker;

public class h implements c, d.a {
    private static h f;
    private float a = 0.0f;
    private final e b;
    private final b c;
    private com.iab.omid.library.ironsrc.devicevolume.d d;
    private c e;

    public h(e eVar, b bVar) {
        this.b = eVar;
        this.c = bVar;
    }

    private c a() {
        if (this.e == null) {
            this.e = c.c();
        }
        return this.e;
    }

    public static h c() {
        if (f == null) {
            f = new h(new e(), new b());
        }
        return f;
    }

    public void a(float f2) {
        this.a = f2;
        for (a adSessionStatePublisher : a().a()) {
            adSessionStatePublisher.getAdSessionStatePublisher().a(f2);
        }
    }

    public void a(Context context) {
        this.d = this.b.a(new Handler(), context, this.c.a(), this);
    }

    public void a(boolean z) {
        if (z) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }

    public float b() {
        return this.a;
    }

    public void d() {
        b.g().a((d.a) this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.d.d();
    }
}
