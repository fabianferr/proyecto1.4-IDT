package com.appnext.core.webview;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnext.core.g;
import com.appnext.core.n;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AppnextWebView {
    /* access modifiers changed from: private */
    public static AppnextWebView eH;
    /* access modifiers changed from: private */
    public Context aM;
    /* access modifiers changed from: private */
    public WebAppInterface av;
    /* access modifiers changed from: private */
    public final HashMap<String, b> eI = new HashMap<>();
    private HashMap<String, WebView> eJ;

    public interface c {
        void error(String str);

        void f(String str);
    }

    public final void a(WebAppInterface webAppInterface) {
        if (this.av == webAppInterface) {
            this.av = null;
        }
    }

    private class b {
        public ArrayList<c> dt;
        public String eN;
        public int m;
        public String v;

        private b() {
            this.m = 0;
            this.eN = "";
            this.dt = new ArrayList<>();
        }
    }

    public static AppnextWebView q(Context context) {
        if (eH == null) {
            AppnextWebView appnextWebView = new AppnextWebView(context);
            eH = appnextWebView;
            appnextWebView.eJ = new HashMap<>();
        }
        return eH;
    }

    private AppnextWebView(Context context) {
        this.aM = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r8, com.appnext.core.webview.AppnextWebView.c r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.HashMap<java.lang.String, com.appnext.core.webview.AppnextWebView$b> r0 = r7.eI     // Catch:{ all -> 0x004b }
            boolean r0 = r0.containsKey(r8)     // Catch:{ all -> 0x004b }
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.util.HashMap<java.lang.String, com.appnext.core.webview.AppnextWebView$b> r0 = r7.eI     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x004b }
            com.appnext.core.webview.AppnextWebView$b r0 = (com.appnext.core.webview.AppnextWebView.b) r0     // Catch:{ all -> 0x004b }
            goto L_0x001a
        L_0x0013:
            com.appnext.core.webview.AppnextWebView$b r0 = new com.appnext.core.webview.AppnextWebView$b     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            r0.v = r8     // Catch:{ all -> 0x004b }
        L_0x001a:
            int r2 = r0.m     // Catch:{ all -> 0x004b }
            r3 = 2
            if (r2 != r3) goto L_0x0025
            if (r9 == 0) goto L_0x0049
            r9.f(r8)     // Catch:{ all -> 0x004b }
            goto L_0x0051
        L_0x0025:
            int r2 = r0.m     // Catch:{ all -> 0x004b }
            if (r2 != 0) goto L_0x003d
            r2 = 1
            r0.m = r2     // Catch:{ all -> 0x004b }
            com.appnext.core.webview.AppnextWebView$a r4 = new com.appnext.core.webview.AppnextWebView$a     // Catch:{ all -> 0x004b }
            r4.<init>(r0)     // Catch:{ all -> 0x004b }
            java.util.concurrent.Executor r5 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch:{ all -> 0x004b }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x004b }
            r6 = 0
            r3[r6] = r8     // Catch:{ all -> 0x004b }
            r3[r2] = r1     // Catch:{ all -> 0x004b }
            r4.executeOnExecutor(r5, r3)     // Catch:{ all -> 0x004b }
        L_0x003d:
            if (r9 == 0) goto L_0x0044
            java.util.ArrayList<com.appnext.core.webview.AppnextWebView$c> r1 = r0.dt     // Catch:{ all -> 0x004b }
            r1.add(r9)     // Catch:{ all -> 0x004b }
        L_0x0044:
            java.util.HashMap<java.lang.String, com.appnext.core.webview.AppnextWebView$b> r9 = r7.eI     // Catch:{ all -> 0x004b }
            r9.put(r8, r0)     // Catch:{ all -> 0x004b }
        L_0x0049:
            monitor-exit(r7)
            return
        L_0x004b:
            r8 = move-exception
            java.lang.String r9 = "AppnextWebView$download"
            com.appnext.base.a.a(r9, r8)     // Catch:{ all -> 0x0053 }
        L_0x0051:
            monitor-exit(r7)
            return
        L_0x0053:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.webview.AppnextWebView.a(java.lang.String, com.appnext.core.webview.AppnextWebView$c):void");
    }

    private class a extends AsyncTask<String, Void, String> {
        b eM;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            super.onPostExecute(str);
            try {
                if (str.startsWith("error:")) {
                    this.eM.m = 0;
                    AppnextWebView.this.eI.put(this.eM.v, this.eM);
                    AppnextWebView.this.a(this.eM, str.substring(7));
                    return;
                }
                this.eM.m = 2;
                AppnextWebView.this.eI.put(this.eM.v, this.eM);
                AppnextWebView.this.b(this.eM, str);
            } catch (Throwable th) {
                com.appnext.base.a.a("AppnextWebView$download", th);
            }
        }

        public a(b bVar) {
            this.eM = bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final String doInBackground(String... strArr) {
            try {
                b bVar = (b) AppnextWebView.this.eI.get(strArr[0]);
                bVar.eN = g.a(AppnextWebView.this.aM, strArr[0], (HashMap<String, String>) null, true, 10000);
                AppnextWebView.this.eI.put(strArr[0], bVar);
                return strArr[0];
            } catch (HttpRetryException e) {
                com.appnext.base.a.a("AppnextWebView$doInBackground", e);
                return "error: " + e.getReason();
            } catch (IOException e2) {
                com.appnext.base.a.a("AppnextWebView$doInBackground", e2);
                return "error: network problem";
            } catch (Throwable th) {
                com.appnext.base.a.a("AppnextWebView$doInBackground", th);
                return "error: unknown error";
            }
        }
    }

    public final WebView a(Context context, String str, String str2, String str3, WebAppInterface webAppInterface, a aVar, String str4) {
        String str5;
        try {
            eH.av = webAppInterface;
            WebView webView = this.eJ.get(str4);
            if (!(webView == null || webView.getParent() == null)) {
                ((ViewGroup) webView.getParent()).removeView(webView);
            }
            URL url = new URL(str3);
            String str6 = url.getProtocol() + "://" + url.getHost();
            WebView webView2 = new WebView(context.getApplicationContext());
            webView2.getSettings().setJavaScriptEnabled(true);
            webView2.getSettings().setAppCacheEnabled(true);
            webView2.getSettings().setDomStorageEnabled(true);
            webView2.getSettings().setDatabaseEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                webView2.getSettings().setMixedContentMode(0);
            }
            webView2.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView2.setWebChromeClient(new WebChromeClient());
            webView2.setWebViewClient(new WebViewClient() {
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (str == null) {
                        return false;
                    }
                    if (!str.startsWith("http")) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    webView.loadUrl(str);
                    return true;
                }
            });
            if (this.eI.containsKey(str3)) {
                if (this.eI.get(str3).m == 2 && !this.eI.get(str3).eN.equals("")) {
                    str5 = "<script>" + this.eI.get(str3).eN + "</script>";
                    webView2.loadDataWithBaseURL(str6, "<html><body>" + str5 + "</body></html>", (String) null, "UTF-8", (String) null);
                    this.eJ.put(str4, webView2);
                    webView2.addJavascriptInterface(new WebInterface(context, str, str2), "Appnext");
                    return webView2;
                }
            }
            if (aVar != null) {
                str5 = "<script>" + aVar.D() + "</script>";
            } else {
                str5 = "<script src='" + str3 + "'></script>";
            }
            webView2.loadDataWithBaseURL(str6, "<html><body>" + str5 + "</body></html>", (String) null, "UTF-8", (String) null);
            this.eJ.put(str4, webView2);
            webView2.addJavascriptInterface(new WebInterface(context, str, str2), "Appnext");
            return webView2;
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextWebView$loadWebview", th);
            return null;
        }
    }

    public final WebView C(String str) {
        WebView webView = this.eJ.get(str);
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
        }
        return webView;
    }

    public final String D(String str) {
        b bVar = this.eI.get(str);
        if (bVar == null || bVar.m != 2) {
            return null;
        }
        return bVar.eN;
    }

    /* access modifiers changed from: private */
    public void a(b bVar, String str) {
        synchronized (this.eI) {
            Iterator<c> it = bVar.dt.iterator();
            while (it.hasNext()) {
                it.next().error(str);
            }
            bVar.dt.clear();
            this.eI.remove(bVar.v);
        }
    }

    /* access modifiers changed from: private */
    public void b(b bVar, String str) {
        synchronized (this.eI) {
            Iterator<c> it = bVar.dt.iterator();
            while (it.hasNext()) {
                it.next().f(str);
            }
            bVar.dt.clear();
        }
    }

    /* access modifiers changed from: private */
    public void b(final String str, final String str2, final String str3) {
        n.aa().a(new Runnable() {
            public final void run() {
                try {
                    String f = g.f(str3, "b");
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f) && !TextUtils.isEmpty(str2)) {
                        com.appnext.core.adswatched.a.l(AppnextWebView.this.av.context).j(f, str2);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private class WebInterface extends WebAppInterface {
        private String auid;
        private String bk;

        public WebInterface(Context context, String str, String str2) {
            super(context);
            this.bk = str;
            this.auid = str2;
        }

        @JavascriptInterface
        public void destroy(String str) {
            super.destroy(str);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.destroy(str);
            }
        }

        @JavascriptInterface
        public void postView(String str) {
            super.postView(str);
            AppnextWebView.this.b(this.bk, this.auid, str);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.postView(str);
            }
        }

        @JavascriptInterface
        public void openStore(String str) {
            super.openStore(str);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.openStore(str);
            }
        }

        @JavascriptInterface
        public void play() {
            super.play();
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.play();
            }
        }

        @JavascriptInterface
        public String filterAds(String str) {
            super.filterAds(str);
            return AppnextWebView.eH.av != null ? AppnextWebView.eH.av.filterAds(str) : str;
        }

        @JavascriptInterface
        public String loadAds() {
            super.loadAds();
            return AppnextWebView.eH.av != null ? AppnextWebView.eH.av.loadAds() : "";
        }

        @JavascriptInterface
        public void openLink(String str) {
            super.openLink(str);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.openLink(str);
            }
        }

        @JavascriptInterface
        public void gotoAppWall() {
            super.gotoAppWall();
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.gotoAppWall();
            }
        }

        @JavascriptInterface
        public void videoPlayed() {
            super.videoPlayed();
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.videoPlayed();
            }
        }

        @JavascriptInterface
        public void notifyImpression(String str) {
            super.notifyImpression(str);
            AppnextWebView.this.b(this.bk, this.auid, str);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.notifyImpression(str);
            }
        }

        @JavascriptInterface
        public void jsError(String str) {
            super.jsError(str);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.jsError(str);
            }
        }

        @JavascriptInterface
        public void openResultPage(String str) {
            super.openResultPage(str);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.openResultPage(str);
            }
        }

        @JavascriptInterface
        public void logSTP(String str, String str2) {
            super.logSTP(str, str2);
            if (AppnextWebView.eH.av != null) {
                AppnextWebView.eH.av.logSTP(str, str2);
            }
        }
    }
}
