package com.bytedance.sdk.openadsdk.k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.b.a.d;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.f.a;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.concurrent.TimeUnit;

/* compiled from: TTNetClient */
public class c {
    private static volatile c a;
    private final Context b;
    private final a c;
    private com.bytedance.sdk.openadsdk.k.a.c d;

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(o.a());
                }
            }
        }
        return a;
    }

    private c(Context context) {
        this.b = context == null ? o.a() : context.getApplicationContext();
        a a2 = new a.C0054a().a(10000, TimeUnit.MILLISECONDS).b(10000, TimeUnit.MILLISECONDS).c(10000, TimeUnit.MILLISECONDS).a(true).a();
        this.c = a2;
        d a3 = a2.e().a();
        if (a3 != null) {
            a3.a(32);
        }
    }

    public a b() {
        return this.c;
    }

    public com.bytedance.sdk.openadsdk.k.a.c c() {
        d();
        return this.d;
    }

    public void a(String str, int i, int i2, ImageView imageView, q qVar) {
        com.bytedance.sdk.openadsdk.f.d.a(str).a(i).b(i2).d(ad.d(o.a())).c(ad.c(o.a())).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.f.c.a(qVar, str, imageView));
    }

    public void a(int i, final ImageView imageView, final q qVar) {
        com.bytedance.sdk.openadsdk.f.d.a(qVar.f()).a(i).b(i).d(ad.d(o.a())).c(ad.c(o.a())).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.f.c.a(qVar, qVar.f(), imageView));
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (imageView.getDrawable() != null) {
                        Intent intent = new Intent();
                        String g = qVar.g();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(g));
                        try {
                            b.a(o.a(), intent, (b.a) null);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public void a(n nVar, ImageView imageView, q qVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.a()) && imageView != null) {
            com.bytedance.sdk.openadsdk.f.d.a(nVar).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.f.c.a(qVar, nVar.a(), imageView));
        }
    }

    private void d() {
        if (this.d == null) {
            this.d = new com.bytedance.sdk.openadsdk.k.a.c();
        }
    }
}
