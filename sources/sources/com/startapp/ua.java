package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.internal.ServerProtocol;
import com.startapp.k9;
import com.startapp.sdk.adsbase.AdsConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Sta */
public class ua {
    public final va a;
    public final Queue<WeakReference<WebView>> b = new LinkedList();

    /* compiled from: Sta */
    public class a extends WebViewClient {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ WebView c;
        public final /* synthetic */ k9.b d;
        public final /* synthetic */ AtomicLong e;
        public final /* synthetic */ int f;

        /* renamed from: com.startapp.ua$a$a  reason: collision with other inner class name */
        /* compiled from: Sta */
        public class C0167a implements Runnable {
            public final /* synthetic */ long a;

            public C0167a(long j) {
                this.a = j;
            }

            public void run() {
                if (a.this.b.compareAndSet(false, true)) {
                    a aVar = a.this;
                    ua.this.a(aVar.c);
                    a aVar2 = a.this;
                    aVar2.d.a(false, aVar2.e.get(), this.a, true);
                }
            }
        }

        /* compiled from: Sta */
        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            public void run() {
                if (a.this.b.compareAndSet(false, true)) {
                    a aVar = a.this;
                    ua.this.a(aVar.c);
                    a.this.d.a(3, String.valueOf(this.a));
                }
            }
        }

        public a(Handler handler, AtomicBoolean atomicBoolean, WebView webView, k9.b bVar, AtomicLong atomicLong, int i) {
            this.a = handler;
            this.b = atomicBoolean;
            this.c = webView;
            this.d = bVar;
            this.e = atomicLong;
            this.f = i;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            long a2 = k9.a();
            this.a.removeCallbacksAndMessages((Object) null);
            this.a.postDelayed(new C0167a(a2), (long) this.f);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.a.removeCallbacksAndMessages((Object) null);
            this.a.post(new b(str));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView == null || str == null || k9.b(webView.getContext(), str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ k9.b c;

        public b(AtomicBoolean atomicBoolean, WebView webView, k9.b bVar) {
            this.a = atomicBoolean;
            this.b = webView;
            this.c = bVar;
        }

        public void run() {
            if (this.a.compareAndSet(false, true)) {
                ua.this.a(this.b);
                this.c.a(2, "Unknown error");
            }
        }
    }

    /* compiled from: Sta */
    public class c implements Runnable {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ k9.b c;
        public final /* synthetic */ AtomicLong d;

        public c(AtomicBoolean atomicBoolean, WebView webView, k9.b bVar, AtomicLong atomicLong) {
            this.a = atomicBoolean;
            this.b = webView;
            this.c = bVar;
            this.d = atomicLong;
        }

        public void run() {
            if (this.a.compareAndSet(false, true)) {
                ua.this.a(this.b);
                this.c.a(false, this.d.get(), k9.a(), false);
            }
        }
    }

    public ua(Context context, va vaVar) {
        this.a = vaVar;
    }

    public void a(WebView webView) {
        webView.stopLoading();
        webView.loadUrl("about:blank");
        if (this.b.size() < 3) {
            this.b.add(new WeakReference(webView));
        } else {
            webView.destroy();
        }
    }

    public void a(String str, k9.b bVar) {
        int i;
        String str2 = str;
        k9.b bVar2 = bVar;
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(k9.a(str2, "@doNotRender@", "@doNotRender@"))) {
            bVar.a(true, 0, 0, false);
            return;
        }
        WebView webView = null;
        while (webView == null) {
            try {
                if (this.b.size() <= 0) {
                    break;
                }
                WeakReference poll = this.b.poll();
                if (poll != null) {
                    webView = (WebView) poll.get();
                }
            } catch (Throwable th) {
                i3.a(th);
                bVar2.a(1, "WebView instantiation Error");
                return;
            }
        }
        if (webView == null) {
            webView = this.a.b();
        }
        WebView webView2 = webView;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        Handler handler = new Handler(Looper.getMainLooper());
        AtomicLong atomicLong = new AtomicLong();
        if (AdsConstants.f.booleanValue()) {
            webView2.getSettings().setBlockNetworkImage(false);
            webView2.getSettings().setLoadsImagesAutomatically(true);
            webView2.getSettings().setJavaScriptEnabled(true);
            i = 25000;
        } else {
            i = 0;
        }
        webView2.setWebChromeClient(new WebChromeClient());
        a aVar = r1;
        AtomicLong atomicLong2 = atomicLong;
        a aVar2 = new a(handler, atomicBoolean, webView2, bVar, atomicLong, i);
        webView2.setWebViewClient(aVar);
        atomicLong2.set(k9.a());
        if (!k9.a(webView2, str2)) {
            handler.removeCallbacksAndMessages((Object) null);
            handler.post(new b(atomicBoolean, webView2, bVar2));
            return;
        }
        handler.postDelayed(new c(atomicBoolean, webView2, bVar, atomicLong2), 25000);
    }
}
