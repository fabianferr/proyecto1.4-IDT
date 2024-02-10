package com.appnext.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class f {
    private static f cF;
    /* access modifiers changed from: private */
    public a cA;
    private Runnable cB;
    private List cC;
    /* access modifiers changed from: private */
    public final ArrayList<b> cD = new ArrayList<>();
    private int cE;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public WebView cy;
    /* access modifiers changed from: private */
    public WebView cz;
    private Handler handler;

    public interface a {
        void error(String str);

        void onMarket(String str);
    }

    private class b {
        String cN;
        String cO;
        a cP;
        String cQ;
        long cR;
        String v;

        b(String str, String str2, String str3, String str4, a aVar, long j) {
            this.cN = str;
            this.cO = str2;
            this.v = str3;
            this.cP = aVar;
            this.cQ = str4;
            this.cR = j;
        }
    }

    public static f b(Context context2) {
        if (cF == null) {
            synchronized (f.class) {
                if (cF == null) {
                    cF = new f(context2);
                }
            }
        }
        return cF;
    }

    private f(Context context2) {
        try {
            this.context = context2.getApplicationContext();
            this.handler = new Handler(Looper.getMainLooper());
            this.cE = 0;
            this.cA = new a() {
                public final void onMarket(String str) {
                    try {
                        f.this.b(0);
                        if (f.this.cD.size() != 0) {
                            b bVar = (b) f.this.cD.get(0);
                            if (bVar.cP != null) {
                                bVar.cP.onMarket(str);
                            }
                            String str2 = "";
                            if (f.this.cD != null && !f.this.cD.isEmpty()) {
                                str2 = "https://admin.appnext.com/tools/navtac.html?bid=" + ((b) f.this.cD.get(0)).cQ + "&guid=" + g.e("admin.appnext.com", "applink") + "&url=" + URLEncoder.encode(str, "UTF-8");
                            }
                            if (f.this.cz == null) {
                                f.this.cz = new WebView(f.this.context);
                                f.this.cz.getSettings().setJavaScriptEnabled(true);
                                f.this.cz.getSettings().setDomStorageEnabled(true);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    f.this.cz.getSettings().setMixedContentMode(0);
                                }
                                f.this.cz.setWebViewClient(new WebViewClient() {
                                    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                                        if (str == null) {
                                            return false;
                                        }
                                        try {
                                            if (str.contains("about:blank")) {
                                                return false;
                                            }
                                            webView.loadUrl(str);
                                            return true;
                                        } catch (Throwable th) {
                                            com.appnext.base.a.a("AppnextCK$AppnextCK", th);
                                            return false;
                                        }
                                    }

                                    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                                        if (Build.VERSION.SDK_INT < 26 || renderProcessGoneDetail.didCrash()) {
                                            return false;
                                        }
                                        if (f.this.cz == null) {
                                            return true;
                                        }
                                        f.this.cz.destroy();
                                        f.this.cz = null;
                                        return true;
                                    }
                                });
                            }
                            f.this.cz.loadUrl("about:blank");
                            f.this.cz.loadUrl(str2);
                            f.this.U();
                            f.this.T();
                        }
                    } catch (UnsupportedEncodingException e) {
                        com.appnext.base.a.a("AppnextCK$AppnextCK", e);
                        f.this.T();
                    } catch (Throwable th) {
                        com.appnext.base.a.a("AppnextCK$AppnextCK", th);
                    }
                }

                public final void error(String str) {
                    f.this.b(0);
                    if (f.this.cD.size() != 0) {
                        b bVar = (b) f.this.cD.get(0);
                        if (bVar.cP != null) {
                            bVar.cP.error(str);
                        }
                        f.this.T();
                    }
                }
            };
            this.cB = new Runnable() {
                public final void run() {
                    if (!(f.this.cA == null || f.this.cy == null)) {
                        f.this.cA.error(f.this.cy.getUrl());
                        f.this.cy.stopLoading();
                    }
                    f.this.T();
                }
            };
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextCK$AppnextCK", th);
        }
    }

    public final void a(String str, String str2, String str3, String str4, a aVar) {
        a(str, str2, str3, str4, aVar, 16000);
    }

    public final void a(String str, String str2, String str3, String str4, a aVar, long j) {
        String str5 = str3;
        try {
            if (this.context != null) {
                if (str5 != null) {
                    Iterator<b> it = this.cD.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (!TextUtils.isEmpty(next.v) && next.v.equals(str5)) {
                            return;
                        }
                    }
                    if (str5.endsWith("&ox=0")) {
                        this.cD.add(new b(str, str2, str3, str4, aVar, j));
                    } else {
                        this.cE = 0;
                        if (this.cD.size() > 0 && !this.cD.get(0).v.endsWith("&ox=0")) {
                            String str6 = this.cD.get(0).v;
                            this.cD.get(0).cP = null;
                            this.cD.remove(0);
                            this.cD.size();
                        }
                        this.cD.add(0, new b(str, str2, str3, str4, aVar, j));
                    }
                }
                if (this.cD.size() > 0 && this.cE != 1) {
                    this.cE = 1;
                    String str7 = this.cD.get(0).cQ;
                    String str8 = this.cD.get(0).v;
                    a(this.cD.get(0));
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextCK$load", th);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        this.cE = i;
    }

    /* access modifiers changed from: private */
    public void U() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    private boolean n(String str) {
        try {
            this.context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r7.startsWith("https://play.google.com/store") != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097 A[Catch:{ all -> 0x0074, all -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openMarket(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "com.android.vending"
            java.lang.String r1 = "market://"
            boolean r1 = r7.startsWith(r1)     // Catch:{ all -> 0x009b }
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            java.lang.String r3 = "android.intent.action.VIEW"
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = "https://play.google.com/store"
            boolean r1 = r7.startsWith(r1)     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x007b
        L_0x0016:
            boolean r1 = r6.n(r0)     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x007b
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0074 }
            android.net.Uri r4 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x0074 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0074 }
            android.content.Context r3 = r6.context     // Catch:{ all -> 0x0074 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x0074 }
            r4 = 0
            java.util.List r3 = r3.queryIntentActivities(r1, r4)     // Catch:{ all -> 0x0074 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0074 }
        L_0x0034:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x0093
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0074 }
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4     // Catch:{ all -> 0x0074 }
            android.content.pm.ActivityInfo r5 = r4.activityInfo     // Catch:{ all -> 0x0074 }
            android.content.pm.ApplicationInfo r5 = r5.applicationInfo     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r5.packageName     // Catch:{ all -> 0x0074 }
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x0074 }
            if (r5 == 0) goto L_0x0034
            android.content.pm.ActivityInfo r0 = r4.activityInfo     // Catch:{ all -> 0x0074 }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ all -> 0x0074 }
            android.content.pm.ApplicationInfo r4 = r0.applicationInfo     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r4.packageName     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.name     // Catch:{ all -> 0x0074 }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0074 }
            r1.addFlags(r2)     // Catch:{ all -> 0x0074 }
            r0 = 2097152(0x200000, float:2.938736E-39)
            r1.addFlags(r0)     // Catch:{ all -> 0x0074 }
            r0 = 131072(0x20000, float:1.83671E-40)
            r1.addFlags(r0)     // Catch:{ all -> 0x0074 }
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r1.addFlags(r0)     // Catch:{ all -> 0x0074 }
            r1.setComponent(r3)     // Catch:{ all -> 0x0074 }
            android.content.Context r0 = r6.context     // Catch:{ all -> 0x0074 }
            r0.startActivity(r1)     // Catch:{ all -> 0x0074 }
            goto L_0x0093
        L_0x0074:
            r0 = move-exception
            java.lang.String r1 = "AppnextCK$openMarketOnGooglePlay"
            com.appnext.base.a.a(r1, r0)     // Catch:{ all -> 0x009b }
            goto L_0x0093
        L_0x007b:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x008d }
            android.net.Uri r1 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x008d }
            r0.<init>(r3, r1)     // Catch:{ all -> 0x008d }
            r0.setFlags(r2)     // Catch:{ all -> 0x008d }
            android.content.Context r1 = r6.context     // Catch:{ all -> 0x008d }
            r1.startActivity(r0)     // Catch:{ all -> 0x008d }
            goto L_0x0093
        L_0x008d:
            r0 = move-exception
            java.lang.String r1 = "AppnextCK$openMarketOnStore"
            com.appnext.base.a.a(r1, r0)     // Catch:{ all -> 0x009b }
        L_0x0093:
            com.appnext.core.f$a r0 = r6.cA     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x009a
            r0.onMarket(r7)     // Catch:{ all -> 0x009b }
        L_0x009a:
            return
        L_0x009b:
            r0 = move-exception
            java.lang.String r1 = "AppnextCK$openMarket"
            com.appnext.base.a.a(r1, r0)
            com.appnext.core.f$a r0 = r6.cA
            if (r0 == 0) goto L_0x00a8
            r0.error(r7)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.f.openMarket(java.lang.String):void");
    }

    public final void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            openMarket(str);
        } else if (aVar != null) {
            aVar.error(str);
        }
    }

    private void a(final b bVar) {
        try {
            String str = bVar.cO;
            if (!TextUtils.isEmpty(bVar.cO)) {
                openMarket(bVar.cO);
                n.aa().a(new Runnable() {
                    public final void run() {
                        try {
                            g.a(f.this.context, bVar.cN, (HashMap<String, String>) null);
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            U();
            if (this.cy == null) {
                WebView webView = new WebView(this.context);
                this.cy = webView;
                webView.getSettings().setJavaScriptEnabled(true);
                this.cy.getSettings().setDomStorageEnabled(true);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.cy.getSettings().setMixedContentMode(0);
                }
                this.cy.setWebViewClient(new WebViewClient() {
                    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dd A[Catch:{ all -> 0x00fe }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final boolean shouldOverrideUrlLoading(android.webkit.WebView r7, java.lang.String r8) {
                        /*
                            r6 = this;
                            java.lang.String r0 = "browser_fallback_url"
                            java.lang.String r1 = "market_referrer"
                            r2 = 0
                            if (r8 != 0) goto L_0x0008
                            return r2
                        L_0x0008:
                            java.lang.String r3 = "https://play.google.com/store/apps/"
                            boolean r4 = r8.startsWith(r3)
                            if (r4 == 0) goto L_0x0016
                            java.lang.String r4 = "market://"
                            java.lang.String r8 = r8.replace(r3, r4)
                        L_0x0016:
                            java.lang.String r3 = "about:blank"
                            boolean r3 = r8.contains(r3)
                            if (r3 == 0) goto L_0x001f
                            return r2
                        L_0x001f:
                            java.lang.String r3 = "http://"
                            boolean r3 = r8.startsWith(r3)
                            r4 = 1
                            if (r3 != 0) goto L_0x0143
                            java.lang.String r3 = "https://"
                            boolean r3 = r8.startsWith(r3)
                            if (r3 != 0) goto L_0x0143
                            java.lang.String r3 = "intent://"
                            boolean r3 = r8.startsWith(r3)
                            if (r3 == 0) goto L_0x00ff
                            android.content.Intent r7 = android.content.Intent.parseUri(r8, r4)     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f r3 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            android.content.Context r3 = r3.context     // Catch:{ all -> 0x00fe }
                            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x00fe }
                            r5 = 65536(0x10000, float:9.18355E-41)
                            android.content.pm.ResolveInfo r3 = r3.resolveActivity(r7, r5)     // Catch:{ all -> 0x00fe }
                            if (r3 == 0) goto L_0x006d
                            com.appnext.core.f r8 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            r8.U()     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f r8 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f$a r8 = r8.cA     // Catch:{ all -> 0x00fe }
                            if (r8 == 0) goto L_0x006c
                            com.appnext.core.f r8 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f$a r8 = r8.cA     // Catch:{ all -> 0x00fe }
                            android.net.Uri r7 = r7.getData()     // Catch:{ all -> 0x00fe }
                            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00fe }
                            r8.onMarket(r7)     // Catch:{ all -> 0x00fe }
                        L_0x006c:
                            return r4
                        L_0x006d:
                            android.os.Bundle r3 = r7.getExtras()     // Catch:{ all -> 0x00fe }
                            java.lang.String r5 = ""
                            if (r3 == 0) goto L_0x0096
                            android.os.Bundle r3 = r7.getExtras()     // Catch:{ all -> 0x00fe }
                            boolean r3 = r3.containsKey(r0)     // Catch:{ all -> 0x00fe }
                            if (r3 == 0) goto L_0x0096
                            android.os.Bundle r3 = r7.getExtras()     // Catch:{ all -> 0x00fe }
                            java.lang.String r3 = r3.getString(r0)     // Catch:{ all -> 0x00fe }
                            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x00fe }
                            if (r3 != 0) goto L_0x0096
                            android.os.Bundle r7 = r7.getExtras()     // Catch:{ all -> 0x00fe }
                            java.lang.String r7 = r7.getString(r0)     // Catch:{ all -> 0x00fe }
                            goto L_0x00d0
                        L_0x0096:
                            android.os.Bundle r0 = r7.getExtras()     // Catch:{ all -> 0x00fe }
                            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x00fe }
                            if (r0 == 0) goto L_0x00e7
                            android.os.Bundle r0 = r7.getExtras()     // Catch:{ all -> 0x00fe }
                            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x00fe }
                            boolean r0 = r0.equals(r5)     // Catch:{ all -> 0x00fe }
                            if (r0 != 0) goto L_0x00e7
                            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
                            java.lang.String r0 = "market://details?id="
                            r8.<init>(r0)     // Catch:{ all -> 0x00fe }
                            java.lang.String r0 = r7.getPackage()     // Catch:{ all -> 0x00fe }
                            r8.append(r0)     // Catch:{ all -> 0x00fe }
                            java.lang.String r0 = "&referrer="
                            r8.append(r0)     // Catch:{ all -> 0x00fe }
                            android.os.Bundle r7 = r7.getExtras()     // Catch:{ all -> 0x00fe }
                            java.lang.String r7 = r7.getString(r1)     // Catch:{ all -> 0x00fe }
                            r8.append(r7)     // Catch:{ all -> 0x00fe }
                            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00fe }
                        L_0x00d0:
                            com.appnext.core.f r8 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            r8.U()     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f r8 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f$a r8 = r8.cA     // Catch:{ all -> 0x00fe }
                            if (r8 == 0) goto L_0x00e6
                            com.appnext.core.f r8 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f$a r8 = r8.cA     // Catch:{ all -> 0x00fe }
                            r8.onMarket(r7)     // Catch:{ all -> 0x00fe }
                        L_0x00e6:
                            return r4
                        L_0x00e7:
                            com.appnext.core.f r7 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            r7.U()     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f r7 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f$a r7 = r7.cA     // Catch:{ all -> 0x00fe }
                            if (r7 == 0) goto L_0x00fd
                            com.appnext.core.f r7 = com.appnext.core.f.this     // Catch:{ all -> 0x00fe }
                            com.appnext.core.f$a r7 = r7.cA     // Catch:{ all -> 0x00fe }
                            r7.error(r8)     // Catch:{ all -> 0x00fe }
                        L_0x00fd:
                            return r4
                        L_0x00fe:
                            return r2
                        L_0x00ff:
                            android.content.Intent r0 = new android.content.Intent
                            java.lang.String r1 = "android.intent.action.VIEW"
                            r0.<init>(r1)
                            android.net.Uri r1 = android.net.Uri.parse(r8)
                            r0.setData(r1)
                            com.appnext.core.f r1 = com.appnext.core.f.this     // Catch:{ all -> 0x0142 }
                            android.content.Context r1 = r1.context     // Catch:{ all -> 0x0142 }
                            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x0142 }
                            java.util.List r0 = r1.queryIntentActivities(r0, r2)     // Catch:{ all -> 0x0142 }
                            if (r0 == 0) goto L_0x013f
                            int r0 = r0.size()     // Catch:{ all -> 0x0142 }
                            if (r0 <= 0) goto L_0x013f
                            com.appnext.core.f r7 = com.appnext.core.f.this     // Catch:{ all -> 0x0142 }
                            r7.U()     // Catch:{ all -> 0x0142 }
                            com.appnext.core.f r7 = com.appnext.core.f.this     // Catch:{ all -> 0x0142 }
                            r7.openMarket(r8)     // Catch:{ all -> 0x0142 }
                            com.appnext.core.f r7 = com.appnext.core.f.this     // Catch:{ all -> 0x0142 }
                            com.appnext.core.f$a r7 = r7.cA     // Catch:{ all -> 0x0142 }
                            if (r7 == 0) goto L_0x013e
                            com.appnext.core.f r7 = com.appnext.core.f.this     // Catch:{ all -> 0x0142 }
                            com.appnext.core.f$a r7 = r7.cA     // Catch:{ all -> 0x0142 }
                            r7.onMarket(r8)     // Catch:{ all -> 0x0142 }
                        L_0x013e:
                            return r4
                        L_0x013f:
                            r7.loadUrl(r8)     // Catch:{ all -> 0x0142 }
                        L_0x0142:
                            return r2
                        L_0x0143:
                            com.appnext.core.f r0 = com.appnext.core.f.this
                            android.content.Intent r1 = com.appnext.core.f.o(r8)
                            r2 = 0
                            android.content.Intent r1 = r1.setComponent(r2)
                            android.content.Intent r0 = r0.a((android.content.Intent) r1)
                            if (r0 == 0) goto L_0x0179
                            com.appnext.core.f r7 = com.appnext.core.f.this
                            r7.U()
                            com.appnext.core.f r7 = com.appnext.core.f.this
                            com.appnext.core.f$a r7 = r7.cA
                            if (r7 == 0) goto L_0x016a
                            com.appnext.core.f r7 = com.appnext.core.f.this
                            com.appnext.core.f$a r7 = r7.cA
                            r7.onMarket(r8)
                        L_0x016a:
                            r7 = 268435456(0x10000000, float:2.5243549E-29)
                            r0.addFlags(r7)
                            com.appnext.core.f r7 = com.appnext.core.f.this
                            android.content.Context r7 = r7.context
                            r7.startActivity(r0)
                            return r4
                        L_0x0179:
                            r7.loadUrl(r8)
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.f.AnonymousClass4.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
                    }

                    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                        if (Build.VERSION.SDK_INT < 26 || renderProcessGoneDetail.didCrash()) {
                            return false;
                        }
                        if (f.this.cy == null) {
                            return true;
                        }
                        f.this.cy.destroy();
                        f.this.cy = null;
                        return true;
                    }
                });
            }
            this.cy.stopLoading();
            this.cy.loadUrl("about:blank");
            this.cC = a(this.context, o(bVar.v).setComponent((ComponentName) null));
            this.cy.loadUrl(bVar.v);
            String str2 = bVar.v;
            this.handler.postDelayed(this.cB, bVar.v.endsWith("&ox=0") ? 15000 : bVar.cR);
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextCK$load1", th);
            a aVar = this.cA;
            if (aVar != null) {
                aVar.error(bVar.v);
            }
            T();
        }
    }

    public final void d(final AppnextAd appnextAd) {
        n.aa().a(new Runnable() {
            public final void run() {
                try {
                    g.a(f.this.context, appnextAd.getImpressionURL(), (HashMap<String, String>) null);
                } catch (Throwable th) {
                    com.appnext.base.a.a("AppnextCK$adImpression", th);
                }
            }
        });
    }

    private static List a(Context context2, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context2.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo next : queryIntentActivities) {
            arrayList.add(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
        }
        return arrayList;
    }

    public final Intent a(Intent intent) {
        List<ComponentName> a2 = a(this.context, intent);
        new HashSet();
        for (ComponentName componentName : a2) {
            if (!this.cC.contains(componentName)) {
                Intent intent2 = new Intent();
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static Intent o(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return intent;
    }

    /* access modifiers changed from: private */
    public void T() {
        try {
            this.cE = 0;
            if (this.cD.size() != 0) {
                String str = this.cD.get(0).v;
                this.cD.get(0).cP = null;
                this.cD.remove(0);
                this.cD.size();
                a((String) null, (String) null, (String) null, (String) null, (a) null);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("AppnextCK$loadNext", th);
        }
    }
}
