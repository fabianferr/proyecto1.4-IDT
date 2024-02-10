package com.appnext.banners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.appnext.banners.e;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.n;
import com.appnext.core.p;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class BannerActivity extends Activity {
    boolean aA;
    BannerAd bannerAd;
    BannerAdData bh;
    String bi;
    String bj;
    String bk;
    String bl;
    String bm;
    BaseBannerAdapter bn;
    Banner bo;
    BannerAdData selectedAd;
    p userAction;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            super.onCreate(bundle);
            this.bn = new a();
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            setContentView(linearLayout);
            this.userAction = new p(this, new p.a() {
                public final void report(String str) {
                }

                public final Ad c() {
                    return BannerActivity.this.bannerAd;
                }

                public final AppnextAd d() {
                    return BannerActivity.this.bh;
                }

                public final SettingsManager e() {
                    return d.K();
                }
            });
            Bundle extras = getIntent().getExtras();
            this.bk = extras.getString("placement");
            String string = extras.getString("size");
            this.bl = string;
            BannerAd bannerAd2 = (BannerAd) b(this.bk, string);
            this.bannerAd = bannerAd2;
            bannerAd2.setPostback(extras.getString("postback"));
            this.bannerAd.setCategories(extras.getString("category"));
            this.bj = extras.getString("clicked");
            this.aA = extras.getBoolean("shouldClose", false);
            this.selectedAd = (BannerAdData) extras.getSerializable("selected");
            this.bi = b.J().k(this.bannerAd);
            ArrayList<AppnextAd> e = b.J().e(this.bannerAd);
            JSONArray jSONArray = new JSONArray();
            if (e != null) {
                Iterator<AppnextAd> it = e.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject(new BannerAdData(it.next()).getAdJSON()));
                }
            }
            this.bm = new JSONObject().put("apps", jSONArray).toString();
            Banner banner = new Banner(this);
            this.bo = banner;
            linearLayout.addView(banner);
            this.bo.getLayoutParams().height = -1;
            this.bo.getLayoutParams().width = -1;
            this.bo.setPlacementId(this.bk);
            this.bo.setBannerSize(j(this.bl));
            this.bo.loadAd((BannerAdRequest) null);
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerActivity$onCreate", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            p pVar = this.userAction;
            if (pVar != null) {
                pVar.destroy();
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerActivity$onDestroy", th);
        }
        try {
            BannerAd bannerAd2 = this.bannerAd;
            if (bannerAd2 != null) {
                bannerAd2.destroy();
            }
        } catch (Throwable th2) {
            com.appnext.base.a.a("BannerActivity$onDestroy", th2);
        }
        try {
            Banner banner = this.bo;
            if (banner != null) {
                banner.destroy();
            }
        } catch (Throwable th3) {
            com.appnext.base.a.a("BannerActivity$onDestroy", th3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0044 A[Catch:{ all -> 0x0047 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.appnext.banners.BannerSize j(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()     // Catch:{ all -> 0x0047 }
            r1 = -1966536496(0xffffffff8ac908d0, float:-1.9358911E-32)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -96588539(0xfffffffffa3e2d05, float:-2.4686238E35)
            if (r0 == r1) goto L_0x0020
            r1 = 1951953708(0x7458732c, float:6.859571E31)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "BANNER"
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "MEDIUM_RECTANGLE"
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x0034
            r4 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "LARGE_BANNER"
            boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.appnext.banners.BannerSize r4 = com.appnext.banners.BannerSize.BANNER
            return r4
        L_0x003e:
            com.appnext.banners.BannerSize r4 = com.appnext.banners.BannerSize.MEDIUM_RECTANGLE     // Catch:{ all -> 0x0047 }
            return r4
        L_0x0041:
            com.appnext.banners.BannerSize r4 = com.appnext.banners.BannerSize.LARGE_BANNER     // Catch:{ all -> 0x0047 }
            return r4
        L_0x0044:
            com.appnext.banners.BannerSize r4 = com.appnext.banners.BannerSize.BANNER     // Catch:{ all -> 0x0047 }
            return r4
        L_0x0047:
            r4 = move-exception
            java.lang.String r0 = "BannerActivity$getSize"
            com.appnext.base.a.a(r0, r4)
            com.appnext.banners.BannerSize r4 = com.appnext.banners.BannerSize.BANNER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.BannerActivity.j(java.lang.String):com.appnext.banners.BannerSize");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004d A[Catch:{ all -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appnext.core.Ad b(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r6.hashCode()     // Catch:{ all -> 0x0053 }
            r1 = -1966536496(0xffffffff8ac908d0, float:-1.9358911E-32)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -96588539(0xfffffffffa3e2d05, float:-2.4686238E35)
            if (r0 == r1) goto L_0x0020
            r1 = 1951953708(0x7458732c, float:6.859571E31)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "BANNER"
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0034
            r6 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "MEDIUM_RECTANGLE"
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0034
            r6 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "LARGE_BANNER"
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0034
            r6 = 1
            goto L_0x0035
        L_0x0034:
            r6 = -1
        L_0x0035:
            if (r6 == 0) goto L_0x004d
            if (r6 == r3) goto L_0x0047
            if (r6 == r2) goto L_0x0041
            com.appnext.banners.SmallBannerAd r6 = new com.appnext.banners.SmallBannerAd
            r6.<init>(r4, r5)
            return r6
        L_0x0041:
            com.appnext.banners.MediumRectangleAd r6 = new com.appnext.banners.MediumRectangleAd     // Catch:{ all -> 0x0053 }
            r6.<init>(r4, r5)     // Catch:{ all -> 0x0053 }
            return r6
        L_0x0047:
            com.appnext.banners.LargeBannerAd r6 = new com.appnext.banners.LargeBannerAd     // Catch:{ all -> 0x0053 }
            r6.<init>(r4, r5)     // Catch:{ all -> 0x0053 }
            return r6
        L_0x004d:
            com.appnext.banners.SmallBannerAd r6 = new com.appnext.banners.SmallBannerAd     // Catch:{ all -> 0x0053 }
            r6.<init>(r4, r5)     // Catch:{ all -> 0x0053 }
            return r6
        L_0x0053:
            r6 = move-exception
            java.lang.String r0 = "BannerActivity$createAd"
            com.appnext.base.a.a(r0, r6)
            com.appnext.banners.SmallBannerAd r6 = new com.appnext.banners.SmallBannerAd
            r6.<init>(r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.BannerActivity.b(java.lang.String, java.lang.String):com.appnext.core.Ad");
    }

    private class a extends e {
        /* access modifiers changed from: protected */
        public final String getJSurl() {
            return "https://cdn.appnext.com/tools/sdk/banner/2.4.3/result.min.js";
        }

        private a() {
        }

        /* access modifiers changed from: protected */
        public final String getFallbackScript() {
            return new com.appnext.core.result.b().D();
        }

        /* access modifiers changed from: protected */
        public final int getLayout() {
            return R.layout.apnxt_full_screen;
        }

        /* access modifiers changed from: protected */
        public final BannerAd getBannerAd() {
            return BannerActivity.this.bannerAd;
        }

        /* access modifiers changed from: protected */
        public final BannerAdData getSelectedAd() {
            return BannerActivity.this.selectedAd;
        }

        public final void loadAd(BannerAdRequest bannerAdRequest) {
            inflateView(0, (AppnextAd) null);
        }

        /* access modifiers changed from: protected */
        public final BannerAdRequest getAdRequest() {
            return new BannerAdRequest();
        }

        /* access modifiers changed from: protected */
        public final e.a getWebInterface() {
            return new b();
        }

        /* access modifiers changed from: protected */
        public final WebViewClient getWebViewClient() {
            return new C0024a();
        }

        public class b extends e.a {
            public b() {
                super();
            }

            @JavascriptInterface
            public final void adClicked(String str, int i) {
                BannerActivity bannerActivity = BannerActivity.this;
                b.J();
                bannerActivity.bh = new BannerAdData((AppnextAd) b.parseAd(str));
                p pVar = BannerActivity.this.userAction;
                BannerAdData bannerAdData = BannerActivity.this.bh;
                pVar.a(bannerAdData, BannerActivity.this.bh.getAppURL() + "&tem_id=" + a.this.getBannerAd().getTemId(a.this.getSelectedAd()) + "1", a.this.getPlacementId(), new f.a() {
                    public final void error(String str) {
                    }

                    public final void onMarket(String str) {
                        if (BannerActivity.this.aA) {
                            BannerActivity.this.finish();
                        }
                    }
                });
            }

            @JavascriptInterface
            public final void impression(String str) {
                b.J();
                BannerActivity.this.userAction.d((AppnextAd) b.parseAd(str));
            }

            @JavascriptInterface
            public final void postView(String str) {
                b.J();
                BannerAdData bannerAdData = new BannerAdData((AppnextAd) b.parseAd(str));
                p pVar = BannerActivity.this.userAction;
                pVar.a(bannerAdData, bannerAdData.getImpressionURL() + "&tem_id=" + a.this.getBannerAd().getTemId(a.this.getSelectedAd()) + "1", (f.a) null);
            }

            @JavascriptInterface
            public final void openLink(String str) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                BannerActivity.this.startActivity(intent);
            }
        }

        /* renamed from: com.appnext.banners.BannerActivity$a$a  reason: collision with other inner class name */
        public class C0024a extends WebViewClient {
            public C0024a() {
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str == null) {
                    return false;
                }
                try {
                    if (str.startsWith("http")) {
                        webView.loadUrl(str);
                        return true;
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("BWebViewClient$shouldOverrideUrlLoading", th);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                n.aa().a(new Runnable() {
                    public final void run() {
                        final String b = g.b(a.this.context, false);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                try {
                                    a aVar = a.this;
                                    aVar.loadJS("javascript:(function() { try { Appnext.setParams(" + a.this.getConfigParams().put("did", b).toString() + "); } catch(err){ Appnext.jsError(err.message); }})()");
                                } catch (Throwable unused) {
                                }
                                a aVar2 = a.this;
                                aVar2.loadJS("javascript:(function() { try { Appnext.load(" + a.this.getSelectedAd().getAdJSON() + "," + BannerActivity.this.bm + "," + BannerActivity.this.bi + "); } catch(err){ Appnext.jsError(err.message); }})()");
                            }
                        });
                    }
                });
            }
        }
    }

    private class Banner extends BannerView {
        public Banner(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public BaseBannerAdapter getBannerAdapter() {
            return BannerActivity.this.bn;
        }
    }
}
