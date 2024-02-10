package com.startapp;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.CastStatusCodes;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.inappbrowser.AnimatingProgressBar;
import com.startapp.sdk.inappbrowser.NavigationBarLayout;
import java.util.HashMap;

/* compiled from: Sta */
public class c3 extends k2 implements View.OnClickListener {
    public static boolean C = false;
    public FrameLayout A;
    public String B;
    public RelativeLayout w;
    public NavigationBarLayout x;
    public WebView y;
    public AnimatingProgressBar z;

    /* compiled from: Sta */
    public class a extends WebChromeClient {
        public a() {
        }

        public void onProgressChanged(WebView webView, int i) {
            c3.this.z.setProgress(i);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (str != null && !str.equals("")) {
                c3.this.x.f.setText(str);
            }
        }
    }

    /* compiled from: Sta */
    public static class b extends WebViewClient {
        public Context a;
        public c3 b;
        public NavigationBarLayout c;
        public AnimatingProgressBar d;
        public int e = 0;
        public boolean f = false;

        public b(Context context, NavigationBarLayout navigationBarLayout, AnimatingProgressBar animatingProgressBar, c3 c3Var) {
            this.a = context;
            this.d = animatingProgressBar;
            this.c = navigationBarLayout;
            this.b = c3Var;
        }

        public void onPageFinished(WebView webView, String str) {
            if (!c3.C) {
                this.c.a(webView);
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    this.f = false;
                    this.d.a();
                    if (this.d.isShown()) {
                        this.d.setVisibility(8);
                    }
                    this.c.a(webView);
                }
                super.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!c3.C) {
                if (this.f) {
                    this.e = 1;
                    this.d.a();
                    this.c.a(webView);
                } else {
                    this.e = Math.max(this.e, 1);
                }
                this.d.setVisibility(0);
                this.c.g.setText(str);
                this.c.a(webView);
                super.onPageStarted(webView, str, bitmap);
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.d.a();
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView != null && str != null && !k9.b(webView.getContext(), str) && !c3.C) {
                if (!this.f) {
                    this.f = true;
                    this.d.a();
                    this.e = 0;
                }
                this.e++;
                if (com.startapp.sdk.adsbase.a.c(str) && !com.startapp.sdk.adsbase.a.b(str)) {
                    return false;
                }
                this.e = 1;
                com.startapp.sdk.adsbase.a.b(this.a, str, (String) null);
                c3 c3Var = this.b;
                if (c3Var != null) {
                    c3Var.i();
                }
            }
            return true;
        }
    }

    public c3(String str) {
        this.B = str;
    }

    public void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        w4.a((Context) this.b).a(this.d, new IntentFilter("com.startapp.android.CloseAdActivity"));
        C = false;
        this.w = new RelativeLayout(this.b);
        String str = this.B;
        if (this.x == null) {
            NavigationBarLayout navigationBarLayout = new NavigationBarLayout(this.b);
            this.x = navigationBarLayout;
            navigationBarLayout.setDescendantFocusability(262144);
            navigationBarLayout.setBackgroundColor(Color.parseColor("#e9e9e9"));
            navigationBarLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, f9.a(navigationBarLayout.getContext(), 60)));
            navigationBarLayout.setId(2101);
            HashMap hashMap = new HashMap();
            hashMap.put("BACK", new u5((Bitmap) null, 14, 22, "back_.png"));
            hashMap.put("BACK_DARK", new u5((Bitmap) null, 14, 22, "back_dark.png"));
            hashMap.put("FORWARD", new u5((Bitmap) null, 14, 22, "forward_.png"));
            hashMap.put("FORWARD_DARK", new u5((Bitmap) null, 14, 22, "forward_dark.png"));
            hashMap.put("X", new u5((Bitmap) null, 23, 23, "x_dark.png"));
            hashMap.put("BROWSER", new u5((Bitmap) null, 28, 28, "browser_icon_dark.png"));
            navigationBarLayout.i = hashMap;
            NavigationBarLayout navigationBarLayout2 = this.x;
            navigationBarLayout2.getClass();
            Typeface typeface = Typeface.DEFAULT;
            Typeface typeface2 = typeface;
            navigationBarLayout2.f = f9.a(navigationBarLayout2.getContext(), navigationBarLayout2.f, typeface2, 1, 16.46f, NavigationBarLayout.j, 2102);
            navigationBarLayout2.g = f9.a(navigationBarLayout2.getContext(), navigationBarLayout2.f, typeface2, 1, 12.12f, NavigationBarLayout.k, 2107);
            navigationBarLayout2.f.setText("Loading...");
            RelativeLayout relativeLayout = new RelativeLayout(navigationBarLayout2.getContext());
            navigationBarLayout2.a = relativeLayout;
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            navigationBarLayout2.a.addView(navigationBarLayout2.f, f9.a(navigationBarLayout2.getContext(), new int[]{0, 0, 0, 0}, new int[0]));
            RelativeLayout relativeLayout2 = navigationBarLayout2.a;
            TextView textView = navigationBarLayout2.g;
            RelativeLayout.LayoutParams a2 = f9.a(navigationBarLayout2.getContext(), new int[]{0, 0, 0, 0}, new int[0]);
            a2.addRule(3, 2102);
            relativeLayout2.addView(textView, a2);
            for (u5 next : navigationBarLayout2.i.values()) {
                Bitmap a3 = a1.a(navigationBarLayout2.getContext(), next.d);
                if (a3 != null) {
                    next.a = Bitmap.createScaledBitmap(a3, f9.a(navigationBarLayout2.getContext(), next.b), f9.a(navigationBarLayout2.getContext(), next.c), true);
                }
            }
            navigationBarLayout2.b = f9.a(navigationBarLayout2.getContext(), navigationBarLayout2.b, navigationBarLayout2.i.get("X").a, 2103);
            navigationBarLayout2.d = f9.a(navigationBarLayout2.getContext(), navigationBarLayout2.d, navigationBarLayout2.i.get("BROWSER").a, CastStatusCodes.MEDIA_ERROR);
            navigationBarLayout2.e = f9.a(navigationBarLayout2.getContext(), navigationBarLayout2.e, navigationBarLayout2.i.get("BACK").a, 2105);
            navigationBarLayout2.c = f9.a(navigationBarLayout2.getContext(), navigationBarLayout2.c, navigationBarLayout2.i.get("FORWARD").a, 2106);
            int a4 = f9.a(navigationBarLayout2.getContext(), 10);
            navigationBarLayout2.c.setPadding(a4, a4, a4, a4);
            navigationBarLayout2.c.setEnabled(false);
            navigationBarLayout2.e.setPadding(a4, a4, a4, a4);
            navigationBarLayout2.addView(navigationBarLayout2.b, f9.a(navigationBarLayout2.getContext(), new int[]{0, 0, 16, 0}, new int[]{15, 11}));
            ImageView imageView = navigationBarLayout2.d;
            RelativeLayout.LayoutParams a5 = f9.a(navigationBarLayout2.getContext(), new int[]{0, 0, 17, 0}, new int[]{15});
            a5.addRule(0, 2103);
            navigationBarLayout2.addView(imageView, a5);
            RelativeLayout relativeLayout3 = navigationBarLayout2.a;
            RelativeLayout.LayoutParams a6 = f9.a(navigationBarLayout2.getContext(), new int[]{16, 6, 16, 0}, new int[]{9});
            a6.addRule(0, CastStatusCodes.MEDIA_ERROR);
            navigationBarLayout2.addView(relativeLayout3, a6);
            this.x.setButtonsListener(this);
        }
        this.w.addView(this.x);
        this.z = new AnimatingProgressBar(this.b, (AttributeSet) null, 16842872);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#45d200"));
        this.z.setProgressDrawable(new ClipDrawable(shapeDrawable, 3, 1));
        this.z.setBackgroundColor(-1);
        this.z.setId(2108);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, f9.a((Context) this.b, 4));
        layoutParams.addRule(3, 2101);
        this.w.addView(this.z, layoutParams);
        this.A = new FrameLayout(this.b);
        if (this.y == null) {
            try {
                j();
                this.y.loadUrl(str);
            } catch (Throwable th) {
                i3.a(th);
                this.x.a();
                com.startapp.sdk.adsbase.a.b(this.b, str, (String) null);
                this.b.finish();
            }
        }
        this.A.addView(this.y);
        this.A.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(15);
        layoutParams2.addRule(3, 2108);
        this.w.addView(this.A, layoutParams2);
        if (bundle2 != null) {
            this.y.restoreState(bundle2);
        }
        this.b.setContentView(this.w, new RelativeLayout.LayoutParams(-2, -2));
    }

    public void b(Bundle bundle) {
        this.y.saveState(bundle);
    }

    public void e() {
    }

    public void f() {
    }

    public void i() {
        try {
            C = true;
            this.y.stopLoading();
            this.y.removeAllViews();
            this.y.postInvalidate();
            a0.a(this.y);
            this.y.destroy();
            this.y = null;
        } catch (Exception unused) {
        }
        this.x.a();
        this.b.finish();
    }

    public final void j() {
        WebView b2 = ComponentLocator.a((Context) this.b).x().b();
        this.y = b2;
        b2.getSettings().setJavaScriptEnabled(true);
        this.y.getSettings().setUseWideViewPort(true);
        this.y.getSettings().setLoadWithOverviewMode(true);
        this.y.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.y.getSettings().setBuiltInZoomControls(true);
        this.y.getSettings().setDisplayZoomControls(false);
        this.y.setWebViewClient(new b(this.b, this.x, this.z, this));
        this.y.setWebChromeClient(new a());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2103:
                i();
                return;
            case CastStatusCodes.MEDIA_ERROR:
                WebView webView = this.y;
                if (webView != null) {
                    com.startapp.sdk.adsbase.a.b(this.b, webView.getUrl(), (String) null);
                    i();
                    return;
                }
                return;
            case 2105:
                WebView webView2 = this.y;
                if (webView2 != null && webView2.canGoBack()) {
                    this.z.a();
                    this.y.goBack();
                    return;
                }
                return;
            case 2106:
                WebView webView3 = this.y;
                if (webView3 != null && webView3.canGoForward()) {
                    this.z.a();
                    this.y.goForward();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 4) {
            return false;
        }
        WebView webView = this.y;
        if (webView == null || !webView.canGoBack()) {
            i();
            return true;
        }
        this.z.a();
        this.y.goBack();
        return true;
    }
}
