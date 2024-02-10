package com.iab.omid.library.bytedance2.internal;

import android.content.Context;
import com.iab.omid.library.bytedance2.internal.d;
import com.iab.omid.library.bytedance2.utils.f;
import java.util.Date;

public class a implements d.a {
    private static a f = new a(new d());
    protected f a = new f();
    private Date b;
    private boolean c;
    private d d;
    private boolean e;

    private a(d dVar) {
        this.d = dVar;
    }

    public static a a() {
        return f;
    }

    private void c() {
        if (this.c && this.b != null) {
            for (com.iab.omid.library.bytedance2.adsession.a adSessionStatePublisher : c.c().a()) {
                adSessionStatePublisher.getAdSessionStatePublisher().a(b());
            }
        }
    }

    public void a(Context context) {
        if (!this.c) {
            this.d.a(context);
            this.d.a((d.a) this);
            this.d.e();
            this.e = this.d.c();
            this.c = true;
        }
    }

    public void a(boolean z) {
        if (!this.e && z) {
            d();
        }
        this.e = z;
    }

    public Date b() {
        Date date = this.b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date a2 = this.a.a();
        Date date = this.b;
        if (date == null || a2.after(date)) {
            this.b = a2;
            c();
        }
    }
}
