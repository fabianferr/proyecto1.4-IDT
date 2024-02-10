package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.facebook.internal.ServerProtocol;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;
import com.startapp.k2;
import com.startapp.k7;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationView;
import com.startapp.sdk.adsbase.commontracking.CloseTrackingParams;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: Sta */
public class d4 extends k2 implements View.OnClickListener {
    public k7 A;
    public boolean B = true;
    public boolean C = false;
    public int D = 0;
    public boolean E = false;
    public long F;
    public b6 G;
    public Runnable H = new a();
    public Runnable I = new b();
    public final k7.a J = new c();
    public WebView w;
    public RelativeLayout x;
    public ImageButton y;
    public long z = 0;

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d4.this.i();
            d4.this.b();
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            d4 d4Var = d4.this;
            d4Var.B = true;
            WebView webView = d4Var.w;
            d4Var.getClass();
            if (webView != null) {
                webView.setOnTouchListener((View.OnTouchListener) null);
            }
        }
    }

    /* compiled from: Sta */
    public class c implements k7.a {
        public c() {
        }

        public void onSent(String str) {
            d4 d4Var = d4.this;
            d4Var.getClass();
            Intent intent = new Intent("com.startapp.android.ShowDisplayBroadcastListener");
            intent.putExtra("dParam", str);
            w4.a((Context) d4Var.b).a(intent);
        }
    }

    /* compiled from: Sta */
    public class d implements View.OnLongClickListener {
        public d(d4 d4Var) {
        }

        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* compiled from: Sta */
    public class e implements View.OnTouchListener {
        public e() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            d4.this.B = true;
            return false;
        }
    }

    /* compiled from: Sta */
    public class f implements Runnable {
        public f() {
        }

        public void run() {
            d4.this.b();
        }
    }

    /* compiled from: Sta */
    public class g implements Runnable {
        public g() {
        }

        public void run() {
            WebView webView = d4.this.w;
            if (webView != null) {
                a0.a(webView);
            }
        }
    }

    /* compiled from: Sta */
    public class h extends WebViewClient {
        public h() {
        }

        public void onPageFinished(WebView webView, String str) {
            d4.this.a(webView);
            d4 d4Var = d4.this;
            k9.a(d4Var.w, true, "gClientInterface.setMode", d4Var.h);
            Object[] objArr = {"externalLinks"};
            k9.a(d4.this.w, true, "enableScheme", objArr);
            d4.this.r();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView == null || str == null || k9.b(webView.getContext(), str)) {
                return true;
            }
            if (!d4.this.B) {
                i3 i3Var = new i3(j3.e);
                i3Var.d = "fake_click";
                i3Var.g = d4.this.a();
                StringBuilder a2 = p0.a("jsTag=");
                a2.append(d4.this.E);
                i3Var.e = a2.toString();
                i3Var.a();
            }
            d4 d4Var = d4.this;
            if (!d4Var.E || d4Var.B) {
                return d4Var.a(str, false);
            }
            return false;
        }
    }

    public void a(Bundle bundle) {
        w4.a((Context) this.b).a(this.d, new IntentFilter("com.startapp.android.CloseAdActivity"));
        if (bundle != null) {
            if (bundle.containsKey("postrollHtml")) {
                a(bundle.getString("postrollHtml"));
            }
            this.C = bundle.getBoolean("videoCompletedBroadcastSent", false);
            this.D = bundle.getInt("replayNum");
        }
    }

    public void a(WebView webView) {
    }

    public void a(RelativeLayout relativeLayout) {
    }

    public void b() {
        this.b.runOnUiThread(new k2.b());
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.o = false;
        k7 k7Var = this.A;
        if (k7Var != null) {
            k7Var.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
        }
        this.b.runOnUiThread(new g());
    }

    public boolean c() {
        if (this.u != null && SystemClock.uptimeMillis() - this.F < this.u.longValue()) {
            return true;
        }
        i();
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.o = false;
        this.A.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
        return false;
    }

    public void d() {
        if (this.d != null) {
            w4.a((Context) this.b).a(this.d);
        }
        this.d = null;
        b6 b6Var = this.G;
        if (b6Var != null) {
            b6Var.a();
            this.G = null;
        }
        WebView webView = this.w;
        Map<Activity, Integer> map = k9.a;
        new Handler(Looper.getMainLooper()).postDelayed(new j9(webView), 1000);
    }

    public void e() {
        k7 k7Var = this.A;
        if (k7Var != null) {
            k7Var.b();
        }
        WebView webView = this.w;
        if (webView != null) {
            a0.a(webView);
        }
    }

    public void f() {
        Ad ad = this.l;
        if (ad instanceof InterstitialAd ? ((InterstitialAd) ad).d() : false) {
            b();
            return;
        }
        Object obj = StartAppSDKInternal.E;
        StartAppSDKInternal.d.a.o = true;
        if (this.A == null) {
            k7 k7Var = new k7(this.b, this.n, this.i, n(), m());
            this.A = k7Var;
            k7Var.a(this.J);
        }
        WebView webView = this.w;
        if (webView == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            this.x = relativeLayout;
            relativeLayout.setContentDescription("StartApp Ad");
            this.x.setId(1475346432);
            this.b.setContentView(this.x);
            try {
                WebView b2 = ComponentLocator.a((Context) this.b).x().b();
                this.w = b2;
                b2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                this.b.getWindow().getDecorView().findViewById(16908290).setBackgroundColor(7829367);
                this.w.setVerticalScrollBarEnabled(false);
                this.w.setHorizontalScrollBarEnabled(false);
                this.w.getSettings().setJavaScriptEnabled(true);
                this.w.getSettings().setMediaPlaybackRequiresUserGesture(false);
                if (this.v) {
                    a0.a(this.w, (Paint) null);
                }
                this.w.setOnLongClickListener(new d(this));
                this.w.setLongClickable(false);
                this.w.addJavascriptInterface(l(), "startappwall");
                q();
                b(this.w);
                u();
                k9.a(this.w, this.m);
                this.E = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(k9.a(this.m, "@jsTag@", "@jsTag@"));
                this.x.addView(this.w, new RelativeLayout.LayoutParams(-1, -1));
                RelativeLayout relativeLayout2 = this.x;
                AdInformationObject adInformationObject = new AdInformationObject(this.b, AdInformationObject.Size.LARGE, this.n, this.o, this.l.getConsentData(), this.l.getRequestUrl(), this.l.getDParam());
                this.c = adInformationObject;
                adInformationObject.a(relativeLayout2);
            } catch (Throwable th) {
                i3.a(th);
                b();
            }
        } else {
            a0.b(webView);
            this.A.c();
        }
        this.z = SystemClock.uptimeMillis();
    }

    public void i() {
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0 && strArr[0] != null) {
            com.startapp.sdk.adsbase.a.a((Context) this.b, strArr[0], o());
        }
    }

    public void j() {
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.b);
            ImageButton imageButton = new ImageButton(this.b);
            this.y = imageButton;
            imageButton.setBackgroundColor(0);
            this.y.setOnClickListener(this);
            int a2 = f9.a((Context) this.b, 50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams.addRule(13);
            relativeLayout.addView(this.y, layoutParams);
            a(relativeLayout);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a2);
            layoutParams2.addRule(10);
            layoutParams2.addRule(11);
            this.x.addView(relativeLayout, layoutParams2);
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    public long k() {
        return (SystemClock.uptimeMillis() - this.z) / 1000;
    }

    public j4 l() {
        Activity activity = this.b;
        Runnable runnable = this.H;
        Runnable runnable2 = this.I;
        j4 j4Var = new j4((Context) activity, runnable, o(), a(0));
        j4Var.d = runnable;
        j4Var.e = runnable2;
        return j4Var;
    }

    public long m() {
        Long l = this.q;
        if (l != null) {
            return TimeUnit.SECONDS.toMillis(l.longValue());
        }
        return TimeUnit.SECONDS.toMillis(MetaData.k.s());
    }

    public TrackingParams n() {
        return new TrackingParams(this.p);
    }

    public TrackingParams o() {
        return new CloseTrackingParams(k(), this.p);
    }

    public void onClick(View view) {
    }

    public boolean p() {
        return false;
    }

    public void q() {
        this.A.c();
    }

    public void r() {
        a((View) this.y);
        this.F = SystemClock.uptimeMillis();
    }

    public void s() {
    }

    public void t() {
        if (p() && !this.C && this.D == 0) {
            this.C = true;
            Intent intent = new Intent("com.startapp.android.OnVideoCompleted");
            intent.putExtra("dParam", a());
            w4.a((Context) this.b).a(intent);
            s();
        }
    }

    public void u() {
        this.w.setWebViewClient(new h());
    }

    public void v() {
        try {
            if (this.y != null) {
                this.y.setImageDrawable(new BitmapDrawable(this.b.getResources(), c1.a("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA39pVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDozODRkZTAxYi00OWRkLWM4NDYtYThkNC0wZWRiMDMwYTZlODAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QkE0Q0U2MUY2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QkE0Q0U2MUU2QzA0MTFFNUE3MkJGQjQ1MTkzOEYxQUUiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChXaW5kb3dzKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjlkZjAyMGU0LTNlYmUtZTY0ZC04YjRiLWM5ZWY4MTU4ZjFhYyIgc3RSZWY6ZG9jdW1lbnRJRD0iYWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOmU1MzEzNDdlLTZjMDEtMTFlNS1hZGZlLThmMTBjZWYxMGRiZSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PngNsEEAAANeSURBVHjatFfNS1tBEH+pUZOQ0B4i3sTSxHMRFNQoFBEP7dHgvyDiKWgguQra9F+oxqNiwOTQ+oFI1ZM3jSf1YK5FL41ooaKZzu+x+4gv2bx9Rgd+JNn5zO7s7IzH0CQiCvLHZ8YnxkfGe8ZbwS4zSowTxi/GT4/Hc2u8BLHjCOM745b06VboRJpx7GN8ZfyDxUqlQgcHB5RMJmloaIg6Ozupra3NBL5jDTzIQFYQdDOw5db5B8YxLDw+PtLKygr19PQQWDqIRqOUzWZNXUHH2rvBgr2M39C6uLig/v5+bcd2QLdUKskgYLNX57yvIL2zs0OhUOjZziU6Ojro8PBQBnGl3Alm+BknkMI54mybdS4BW3t7ezKIInzVCwDJYm4Zon4p5xLYzfPzcxlEpl7S3SNpmjlznZwQiXn/5CjEnTUzt5GBsbExamlpUfLBg0wjG8vLy3IXlqTzEAoH7m4kElEqTk1Nmfd7bW2tbhBYAw8ykFXZgQ9RJ1CsQghgEr/29/eVStPT09XFhdbX18nr9Vr81tZWyuVyFh+yMzMzSnvwJWjyDS+MYic2NzeV17O7u9vg2m79jsfjBv9bg7PbxOrqqjExMWHxIdvV1aW0V+VrFDtwhFCGh4cbnl0mk6kp+BsbGybsBNlGtkZGRqToEQK4xjfUc6csXlhYcHyFFhcXHe3Al6BrQz427e3tWldpfn5e6Rw83cIkHyvXAUAZb4SdsKZbPe0BaB+Bz+cjTiDlDmxtbZkybo9AKwn9fj9tb2875gBkINvIFnzJJMQ1PMV9GBgYUF6bQCBgFAoFY3x8/Ml6KpUy0un0kzXIQBY6KqrydapViPL5fM0/Rfcj+fhuJw5CqxBpleJYLEY3NzeW8dnZ2RoZrEmCLHQcSvGdWYrFe7CEFTwUqqjR85XLZUokEkoZ8CADWe3HqKoTcnyOdW5KI5m+vj56eHiQz3G0bkNyeXn5ag3J2dmZ/PffVC1Z8bVast3d3eqWLKDVlAaDwaadh8Nhvaa0XluOHg7n9lzn0MWRarfltp0oysEErRqGDTeDCbK9ajApuh7TxGiWERlrjWZzc3M0ODhYM5phDTzbaHb/rNHMFkhUNK13LobTv6K2RJ3se1yO519s4/k7wf5jG89/6I7n/wUYAGo3YtcprD4sAAAAAElFTkSuQmCC")));
                this.y.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.y.setVisibility(0);
            }
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[SYNTHETIC, Splitter:B:11:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            com.startapp.k7 r0 = r5.A
            r1 = 0
            r0.a(r1, r1)
            com.startapp.sdk.adsbase.Ad r0 = r5.l
            android.app.Activity r1 = r5.b
            android.content.Context r1 = com.startapp.h0.a(r1)
            if (r1 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            android.app.Activity r1 = r5.b
        L_0x0013:
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r2 = r5.n
            boolean r1 = com.startapp.sdk.adsbase.a.a((android.content.Context) r1, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r2)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0025
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.startapp.k9.a
            boolean r0 = r0 instanceof com.startapp.sdk.ads.splash.SplashAd
            if (r0 != 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            boolean r1 = r5.b((java.lang.String) r6)
            if (r1 == 0) goto L_0x0045
            int r1 = com.startapp.sdk.adsbase.a.a((java.lang.String) r6)     // Catch:{ all -> 0x0040 }
            boolean[] r4 = r5.f     // Catch:{ all -> 0x0040 }
            boolean r4 = r4[r1]     // Catch:{ all -> 0x0040 }
            if (r4 == 0) goto L_0x003c
            if (r0 != 0) goto L_0x003c
            r5.b(r6, r1, r7)     // Catch:{ all -> 0x0040 }
            goto L_0x0054
        L_0x003c:
            r5.a(r6, r1, r7)     // Catch:{ all -> 0x0040 }
            goto L_0x0054
        L_0x0040:
            r6 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r6)
            return r3
        L_0x0045:
            boolean[] r1 = r5.f
            boolean r1 = r1[r3]
            if (r1 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0051
            r5.b(r6, r3, r7)
            goto L_0x0054
        L_0x0051:
            r5.a(r6, r3, r7)
        L_0x0054:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.d4.a(java.lang.String, boolean):boolean");
    }

    public void b(WebView webView) {
        this.B = false;
        webView.setOnTouchListener(new e());
    }

    public void b(Bundle bundle) {
        String str = this.m;
        if (str != null) {
            bundle.putString("postrollHtml", str);
        }
        bundle.putBoolean("videoCompletedBroadcastSent", this.C);
        bundle.putInt("replayNum", this.D);
    }

    public boolean b(String str) {
        return !this.E && str.contains("index=");
    }

    public final void b(String str, int i, boolean z2) {
        int i2 = i;
        boolean m = MetaData.k.m();
        Activity activity = this.b;
        String[] strArr = this.j;
        String[] strArr2 = i2 < strArr.length ? new String[]{strArr[i2]} : null;
        String[] strArr3 = this.k;
        String str2 = i2 < strArr3.length ? strArr3[i2] : null;
        TrackingParams o = o();
        long z3 = AdsCommonMetaData.h.z();
        long y2 = AdsCommonMetaData.h.y();
        boolean a2 = a(i2);
        Boolean[] boolArr = this.r;
        com.startapp.sdk.adsbase.a.a(activity, str, strArr2, str2, o, z3, y2, a2, (boolArr == null || i2 < 0 || i2 >= boolArr.length) ? null : boolArr[i2], z2, m ? new f() : null);
    }

    public final void a(String str, int i, boolean z2) {
        Intent intent = new Intent("com.startapp.android.OnClickCallback");
        intent.putExtra("dParam", a());
        w4.a((Context) this.b).a(intent);
        Context a2 = h0.a(this.b);
        if (a2 == null) {
            a2 = this.b;
        }
        boolean a3 = com.startapp.sdk.adsbase.a.a(a2, this.n);
        Activity activity = this.b;
        String[] strArr = this.j;
        boolean z3 = true;
        String[] strArr2 = i < strArr.length ? new String[]{strArr[i]} : null;
        TrackingParams o = o();
        if (!a(i) || a3) {
            z3 = false;
        }
        com.startapp.sdk.adsbase.a.a((Context) activity, str, strArr2, o, z3, z2);
        if (MetaData.k.m()) {
            b();
        }
    }

    public void a(View view) {
        AdInformationView adInformationView;
        if (MetaData.k.V()) {
            b6 b6Var = new b6(this.w);
            this.G = b6Var;
            if (b6Var.c()) {
                try {
                    AdInformationObject adInformationObject = this.c;
                    if (!(adInformationObject == null || (adInformationView = adInformationObject.b) == null)) {
                        this.G.a(adInformationView, FriendlyObstructionPurpose.OTHER, (String) null);
                    }
                    if (view != null) {
                        this.G.a(view, FriendlyObstructionPurpose.CLOSE_AD, (String) null);
                    }
                } catch (RuntimeException unused) {
                }
                this.G.a(this.w);
                this.G.e();
                this.G.d();
                this.G.b();
            }
        }
    }
}
