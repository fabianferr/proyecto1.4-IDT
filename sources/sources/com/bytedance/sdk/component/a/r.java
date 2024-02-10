package com.bytedance.sdk.component.a;

import android.webkit.WebView;
import com.bytedance.sdk.component.a.d;
import java.util.List;

/* compiled from: JsBridge2 */
public class r {
    static w a;
    private final a b;
    private final WebView c;
    private final j d;
    private final List<n> e;
    private o f;
    private volatile boolean g = false;

    public static j a(WebView webView) {
        return new j(webView);
    }

    public r a(String str, e<?, ?> eVar) {
        return a(str, (String) null, eVar);
    }

    public r a(String str, String str2, e<?, ?> eVar) {
        b();
        this.b.g.a(str, eVar);
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public r a(String str, d.b bVar) {
        return a(str, (String) null, bVar);
    }

    public r a(String str, String str2, d.b bVar) {
        b();
        this.b.g.a(str, bVar);
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(str);
        }
        return this;
    }

    public void a() {
        if (!this.g) {
            this.b.b();
            this.g = true;
            for (n next : this.e) {
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r1 = a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    r(com.bytedance.sdk.component.a.j r4) {
        /*
            r3 = this;
            r3.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.e = r0
            r1 = 0
            r3.g = r1
            r3.d = r4
            boolean r1 = r4.h
            if (r1 == 0) goto L_0x001e
            com.bytedance.sdk.component.a.w r1 = a
            if (r1 == 0) goto L_0x001e
            java.lang.String r2 = r4.k
            com.bytedance.sdk.component.a.v r1 = r1.a((java.lang.String) r2)
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            android.webkit.WebView r2 = r4.a
            if (r2 == 0) goto L_0x0034
            com.bytedance.sdk.component.a.a r2 = r4.b
            if (r2 != 0) goto L_0x002f
            com.bytedance.sdk.component.a.z r2 = new com.bytedance.sdk.component.a.z
            r2.<init>()
            r3.b = r2
            goto L_0x0038
        L_0x002f:
            com.bytedance.sdk.component.a.a r2 = r4.b
            r3.b = r2
            goto L_0x0038
        L_0x0034:
            com.bytedance.sdk.component.a.a r2 = r4.b
            r3.b = r2
        L_0x0038:
            com.bytedance.sdk.component.a.a r2 = r3.b
            r2.a((com.bytedance.sdk.component.a.j) r4, (com.bytedance.sdk.component.a.v) r1)
            android.webkit.WebView r1 = r4.a
            r3.c = r1
            com.bytedance.sdk.component.a.n r1 = r4.j
            r0.add(r1)
            boolean r0 = r4.f
            com.bytedance.sdk.component.a.i.a((boolean) r0)
            boolean r4 = r4.g
            com.bytedance.sdk.component.a.y.a((boolean) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.a.r.<init>(com.bytedance.sdk.component.a.j):void");
    }

    private void b() {
        if (this.g) {
            i.a((RuntimeException) new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
