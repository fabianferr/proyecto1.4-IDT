package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.i;

/* compiled from: LandingPageNewStyleManager */
public class f {
    private final q a;
    private RelativeLayout b;
    private final Context c;
    private SSWebView d;
    private ImageView e;
    private final String f;
    private i g;
    private g h;

    public f(Context context, q qVar, String str) {
        this.c = context;
        this.a = qVar;
        this.f = str;
        f();
    }

    private static RelativeLayout a(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.addView(new LandingPageBrowserNewTitleBar(context));
        SSWebView sSWebView = new SSWebView(context);
        sSWebView.setId(i.O);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(3, i.ac);
        relativeLayout.addView(sSWebView, layoutParams);
        LandingPageBrowserNewBottomBar landingPageBrowserNewBottomBar = new LandingPageBrowserNewBottomBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(landingPageBrowserNewBottomBar.getLayoutParams());
        layoutParams2.addRule(12);
        relativeLayout.addView(landingPageBrowserNewBottomBar, layoutParams2);
        return relativeLayout;
    }

    private void f() {
        RelativeLayout a2 = a(this.c);
        this.b = a2;
        this.d = (SSWebView) a2.findViewById(i.O);
        i iVar = new i(this.c, (RelativeLayout) this.b.findViewById(i.ac), this.a);
        this.g = iVar;
        this.e = iVar.c();
        this.h = new g(this.c, (LinearLayout) this.b.findViewById(i.ah), this.d, this.a, this.f);
    }

    public void a() {
        i iVar = this.g;
        if (iVar != null) {
            iVar.a();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void b() {
        i iVar = this.g;
        if (iVar != null) {
            iVar.b();
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.b();
        }
    }

    public ImageView c() {
        return this.e;
    }

    public SSWebView d() {
        return this.d;
    }

    public View e() {
        return this.b;
    }

    public void a(WebView webView, int i) {
        i iVar = this.g;
        if (iVar != null) {
            iVar.a(i);
        }
        g gVar = this.h;
        if (gVar != null) {
            gVar.a(webView);
        }
    }
}
