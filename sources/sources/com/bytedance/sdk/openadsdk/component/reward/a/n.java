package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.g.c;
import com.bytedance.sdk.openadsdk.core.g.e;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.b;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.i.g;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;

/* compiled from: VastEndCardManager */
public class n implements g {
    private final Activity a;
    /* access modifiers changed from: private */
    public final q b;
    private SSWebView c;
    /* access modifiers changed from: private */
    public ImageView d;
    private boolean e;
    private com.bytedance.sdk.openadsdk.core.b.g f;
    /* access modifiers changed from: private */
    public boolean g;
    private volatile boolean h;
    private final a i;
    private int j;

    public n(a aVar) {
        this.i = aVar;
        this.b = aVar.a;
        this.a = aVar.V;
    }

    public void a() {
        DeviceUtils.AudioInfoReceiver.a((g) this);
        this.j = DeviceUtils.f();
        if (this.b.au() != null) {
            this.f = new com.bytedance.sdk.openadsdk.core.b.g("VAST_END_CARD", this.b.au()) {
                public void a() {
                }
            };
            c c2 = this.b.au().c();
            if (c2 != null) {
                final String e2 = c2.e();
                if (!TextUtils.isEmpty(e2)) {
                    this.e = true;
                    this.d = (ImageView) this.a.findViewById(i.h);
                    a(c2.b(), c2.c());
                    d.a(e2).a(c2.b()).b(c2.c()).d(ad.d(o.a())).c(ad.c(o.a())).a(u.BITMAP).a((com.bytedance.sdk.component.d.o) new b(this.b, e2, new com.bytedance.sdk.component.d.o<Bitmap>() {
                        public void a(k<Bitmap> kVar) {
                            if (n.this.d != null && kVar != null) {
                                Bitmap b2 = kVar.b();
                                if (b2 == null) {
                                    n.this.a(-1, e2);
                                    return;
                                }
                                n.this.d.setImageBitmap(b2);
                                boolean unused = n.this.g = true;
                                n.this.d();
                            }
                        }

                        public void a(int i, String str, Throwable th) {
                            if (n.this.d != null) {
                                n.this.d.setVisibility(8);
                            }
                            n.this.a(-2, e2);
                        }
                    }));
                    return;
                }
                SSWebView sSWebView = (SSWebView) this.a.findViewById(i.i);
                this.c = sSWebView;
                if (sSWebView != null) {
                    e();
                    String d2 = c2.d();
                    if (d2 != null) {
                        this.e = true;
                        if (d2.startsWith("http")) {
                            this.c.a_(d2);
                            return;
                        }
                        String a2 = e.a(d2);
                        String str = TextUtils.isEmpty(a2) ? d2 : a2;
                        this.c.setDefaultTextEncodingName("UTF -8");
                        this.c.a((String) null, str, "text/html", "UTF-8", (String) null);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        a(Integer.MAX_VALUE, (String) null);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (!this.h) {
            this.h = true;
            final String k = this.b.au() != null ? this.b.au().k() : "";
            if (i2 == Integer.MAX_VALUE) {
                com.bytedance.sdk.openadsdk.b.c.b(this.b, k, "load_vast_endcard_success", (JSONObject) null);
                return;
            }
            final int i3 = i2;
            final String str2 = str;
            com.bytedance.sdk.openadsdk.b.c.a((h) new h("load_vast_endcard_fail") {
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("reason_code", i3);
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i3);
                        String str = str2;
                        if (str != null) {
                            jSONObject.put("url", str);
                        }
                        com.bytedance.sdk.openadsdk.b.c.b(n.this.b, k, "load_vast_endcard_fail", jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void e() {
        this.c.c_();
        a(this.c);
        this.c.setDisplayZoomControls(false);
        this.c.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (i == 100) {
                    n.this.d();
                }
            }
        });
        this.c.setWebViewClient(new SSWebView.a() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (n.this.a(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (Build.VERSION.SDK_INT >= 21 && webResourceRequest.isForMainFrame()) {
                    n.this.a(webResourceResponse.getStatusCode(), webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : null);
                }
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                n.this.d();
            }
        });
    }

    private void a(SSWebView sSWebView) {
        sSWebView.setVerticalScrollBarEnabled(false);
        sSWebView.setHorizontalScrollBarEnabled(false);
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.setMixedContentMode(0);
        }
        sSWebView.setJavaScriptEnabled(true);
        sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
        sSWebView.setDomStorageEnabled(true);
        sSWebView.setDatabaseEnabled(true);
        sSWebView.setAppCacheEnabled(true);
        sSWebView.setAllowFileAccess(false);
        sSWebView.setSupportZoom(true);
        sSWebView.setBuiltInZoomControls(true);
        sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        sSWebView.setUseWideViewPort(true);
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        q qVar;
        if (str == null || (qVar = this.b) == null || qVar.au() == null || this.f == null) {
            return false;
        }
        this.b.au().g(str);
        this.f.onClick(this.c);
        return true;
    }

    private void a(int i2, int i3) {
        if (i2 != 0 && i3 != 0 && this.d != null) {
            int c2 = ad.c((Context) this.a);
            int d2 = ad.d((Context) this.a);
            float f2 = ((float) i2) / ((float) i3);
            float f3 = (float) c2;
            if (f2 <= f3 / ((float) d2)) {
                c2 = (int) Math.ceil((double) (f3 * f2));
            } else {
                d2 = (int) Math.ceil((double) (f3 / f2));
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.width = c2;
            layoutParams.height = d2;
            this.d.setLayoutParams(layoutParams);
            this.d.setOnClickListener(this.f);
            this.d.setOnTouchListener(this.f);
        }
    }

    public boolean a(l lVar) {
        c c2;
        if (!this.e) {
            return false;
        }
        ImageView imageView = this.d;
        if (imageView == null || !this.g) {
            SSWebView sSWebView = this.c;
            if (sSWebView != null) {
                sSWebView.setVisibility(0);
                if (this.c.getWebView() != null) {
                    this.c.getWebView().setOnTouchListener(this.f);
                }
            }
        } else {
            imageView.setVisibility(0);
        }
        q qVar = this.b;
        if (qVar == null || qVar.au() == null || (c2 = this.b.au().c()) == null) {
            return true;
        }
        c2.b(lVar != null ? lVar.g() : -1);
        return true;
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        com.bytedance.sdk.openadsdk.core.b.g gVar = this.f;
        if (gVar != null) {
            gVar.a(eVar);
        }
    }

    public void b() {
        DeviceUtils.AudioInfoReceiver.b((g) this);
        SSWebView sSWebView = this.c;
        if (sSWebView != null) {
            aa.a(sSWebView.getWebView());
        }
    }

    public void a(int i2) {
        int i3 = this.j;
        if (i3 == 0 && i2 > 0) {
            this.b.au().a().i(this.i.G.g());
        } else if (i3 > 0 && i2 == 0) {
            this.b.au().a().h(this.i.G.g());
        }
        this.j = i2;
    }

    public boolean c() {
        if (!this.e) {
            return false;
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.performClick();
            return true;
        }
        SSWebView sSWebView = this.c;
        if (sSWebView == null) {
            return false;
        }
        this.f.onClick(sSWebView);
        return true;
    }
}
