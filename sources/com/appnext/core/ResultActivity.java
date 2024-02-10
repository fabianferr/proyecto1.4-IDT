package com.appnext.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.appnext.base.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ResultActivity extends Activity {

    /* renamed from: do  reason: not valid java name */
    private Intent f1do;
    /* access modifiers changed from: private */
    public WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            setContentView(linearLayout);
            linearLayout.setOrientation(1);
            WebView webView2 = new WebView(getApplicationContext());
            this.webView = webView2;
            webView2.getSettings().setTextZoom(100);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setAppCacheEnabled(true);
            this.webView.getSettings().setDomStorageEnabled(true);
            this.webView.getSettings().setDatabaseEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                this.webView.getSettings().setMixedContentMode(0);
            }
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            this.webView.setLayerType(2, (Paint) null);
            this.webView.setWebViewClient(new WebViewClient() {
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    String str2;
                    if (str == null) {
                        return false;
                    }
                    try {
                        if (str.startsWith("http")) {
                            if (ResultActivity.this.hasNewResolver(ResultActivity.o(str).setComponent((ComponentName) null))) {
                                ResultActivity.this.openLink(str);
                            } else {
                                webView.loadUrl(str);
                            }
                            return true;
                        } else if (str.startsWith("intent://")) {
                            Intent parseUri = Intent.parseUri(str, 1);
                            if (ResultActivity.this.getPackageManager().resolveActivity(parseUri, 65536) != null) {
                                ResultActivity.this.openLink(parseUri.getData().toString());
                                return true;
                            }
                            if (parseUri.getExtras() != null) {
                                if (parseUri.getExtras().containsKey("browser_fallback_url") && !parseUri.getExtras().getString("browser_fallback_url").equals("")) {
                                    str2 = parseUri.getExtras().getString("browser_fallback_url");
                                    ResultActivity.this.openLink(str2);
                                    return true;
                                }
                            }
                            if (parseUri.getExtras().containsKey("market_referrer") && !parseUri.getExtras().getString("market_referrer").equals("")) {
                                str2 = "market://details?id=" + parseUri.getPackage() + "&referrer=" + parseUri.getExtras().getString("market_referrer");
                                ResultActivity.this.openLink(str2);
                            }
                            return true;
                        } else {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(str));
                            try {
                                if (ResultActivity.this.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
                                    return false;
                                }
                                ResultActivity.this.openLink(str);
                                return true;
                            } catch (Throwable th) {
                                a.a("ResultActivity$onCreate", th);
                                return false;
                            }
                        }
                    } catch (Throwable th2) {
                        a.a("ResultActivity$onCreate", th2);
                        return false;
                    }
                }

                public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                    if (Build.VERSION.SDK_INT < 26 || renderProcessGoneDetail.didCrash()) {
                        return false;
                    }
                    if (ResultActivity.this.webView == null) {
                        return true;
                    }
                    ResultActivity.this.webView.destroy();
                    ResultActivity.this.webView = null;
                    return true;
                }
            });
            linearLayout.addView(this.webView);
            this.webView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
            ((LinearLayout.LayoutParams) this.webView.getLayoutParams()).weight = 1.0f;
            String string = getIntent().getExtras().getString("url");
            getIntent().getExtras().getString("title");
            this.f1do = new Intent(o(string)).setComponent((ComponentName) null);
            Intent selector = this.f1do.getSelector();
            if (selector != null) {
                selector.setComponent((ComponentName) null);
            }
            this.webView.loadUrl(string);
        } catch (Throwable th) {
            a.a("ResultActivity$onCreate", th);
            finish();
        }
    }

    private static List a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo next : queryIntentActivities) {
            arrayList.add(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
        }
        return arrayList;
    }

    public final boolean hasNewResolver(Intent intent) {
        if (this.f1do == null) {
            return intent != null;
        }
        if (intent == null) {
            return false;
        }
        List<ComponentName> a = a(this, intent);
        HashSet hashSet = new HashSet();
        hashSet.addAll(a(this, this.f1do));
        for (ComponentName contains : a) {
            if (!hashSet.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static Intent o(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return intent;
    }

    /* access modifiers changed from: private */
    public void openLink(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public void onBackPressed() {
        try {
            WebView webView2 = this.webView;
            if (webView2 == null || !webView2.canGoBack()) {
                super.onBackPressed();
            } else {
                this.webView.goBack();
            }
        } catch (Throwable th) {
            a.a("ResultActivity$onBackPressed", th);
            finish();
        }
    }
}
