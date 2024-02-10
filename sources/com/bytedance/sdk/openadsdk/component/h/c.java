package com.bytedance.sdk.openadsdk.component.h;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.b.d.b.o;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.video.a.b;

/* compiled from: TTAppOpenVideoManager */
public class c implements a.C0061a {
    private Context a;
    private FrameLayout b;
    private q c;
    private b d;

    public c(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a(FrameLayout frameLayout, q qVar) {
        this.b = frameLayout;
        this.c = qVar;
        this.d = new b(this.a, frameLayout, qVar);
    }

    public boolean a() {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
            str = CacheDirFactory.getICacheDir(0).b();
        } else {
            try {
                str = com.bytedance.sdk.openadsdk.component.g.a.a();
            } catch (Throwable unused) {
                str = "";
            }
        }
        b a2 = q.a(str, this.c);
        a2.b(this.c.Y());
        a2.a(this.b.getWidth());
        a2.b(this.b.getHeight());
        a2.c(this.c.ac());
        a2.a(0);
        a2.a(true);
        return this.d.a((com.bykv.vk.openvk.component.video.api.c.c) a2);
    }

    public boolean b() {
        b bVar = this.d;
        return (bVar == null || bVar.l() == null || !this.d.l().f()) ? false : true;
    }

    public boolean c() {
        b bVar = this.d;
        return (bVar == null || bVar.l() == null || !this.d.l().g()) ? false : true;
    }

    public void a(c.a aVar) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public void d() {
        try {
            if (b()) {
                this.d.a();
            }
        } catch (Throwable th) {
            l.d("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void e() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void f() {
        b bVar = this.d;
        if (bVar != null) {
            this.a = null;
            bVar.c();
            this.d = null;
        }
    }

    public long g() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.e();
        }
        return 0;
    }

    public long h() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.f();
        }
        return 0;
    }

    public long i() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.h() + this.d.f();
        }
        return 0;
    }

    public void a(int i) {
        if (this.d != null) {
            o.a aVar = new o.a();
            aVar.a(g());
            aVar.c(i());
            aVar.b(h());
            aVar.c(i);
            aVar.d(this.d.g());
            this.d.a(aVar);
        }
    }

    public long getVideoProgress() {
        return g();
    }
}
