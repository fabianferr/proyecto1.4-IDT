package com.bytedance.sdk.component.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.a.k;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: Environment */
public class j {
    WebView a;
    a b;
    String c = "IESJSBridge";
    h d;
    Context e;
    boolean f;
    boolean g;
    boolean h;
    m i;
    n j;
    String k = "host";
    final Set<String> l = new LinkedHashSet();
    final Set<String> m = new LinkedHashSet();
    boolean n;
    boolean o;
    k.b p;

    j(WebView webView) {
        this.a = webView;
    }

    j() {
    }

    public j a(a aVar) {
        this.b = aVar;
        return this;
    }

    public j a(String str) {
        this.c = str;
        return this;
    }

    public j a(l lVar) {
        this.d = h.a(lVar);
        return this;
    }

    public j a(boolean z) {
        this.f = z;
        return this;
    }

    public j b(boolean z) {
        this.g = z;
        return this;
    }

    public j a() {
        this.o = true;
        return this;
    }

    public r b() {
        c();
        return new r(this);
    }

    private void c() {
        if ((this.a == null && !this.n && this.b == null) || ((TextUtils.isEmpty(this.c) && this.a != null) || this.d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
