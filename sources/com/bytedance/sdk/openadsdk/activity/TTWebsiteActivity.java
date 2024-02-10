package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.common.h;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;
import java.net.URLEncoder;
import java.util.HashMap;

public class TTWebsiteActivity extends TTBaseActivity {
    private String a = null;
    /* access modifiers changed from: private */
    public h b;
    /* access modifiers changed from: private */
    public WebView c;

    public static void a(Context context, q qVar, String str) {
        if (context != null) {
            c.a(qVar, str, "open_policy");
            if (!TextUtils.isEmpty(o.d().J())) {
                Intent intent = new Intent(context, TTWebsiteActivity.class);
                if (qVar != null) {
                    intent.putExtra("_extra_meta", qVar.ao().toString());
                    intent.putExtra("_extra_glo_d", qVar.bp());
                }
                b.a(context, intent, (b.a) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(getApplicationContext());
        if (!l.e()) {
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("_extra_meta");
        String stringExtra2 = getIntent().getStringExtra("_extra_glo_d");
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this);
        pAGLinearLayout.setBackgroundColor(-1);
        pAGLinearLayout.setId(520093726);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        try {
            setContentView(pAGLinearLayout);
            int b2 = ad.b((Context) this, 5.0f);
            int b3 = ad.b((Context) this, 8.0f);
            int b4 = ad.b((Context) this, 10.0f);
            int b5 = ad.b((Context) this, 12.0f);
            int b6 = ad.b((Context) this, 14.0f);
            int b7 = ad.b((Context) this, 20.0f);
            int b8 = ad.b((Context) this, 24.0f);
            int b9 = ad.b((Context) this, 40.0f);
            int b10 = ad.b((Context) this, 44.0f);
            int b11 = ad.b((Context) this, 191.0f);
            PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(this);
            pAGRelativeLayout.setGravity(15);
            String str = stringExtra2;
            pAGRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, b10));
            PAGImageView pAGImageView = new PAGImageView(this);
            pAGImageView.setId(520093720);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b9, b10);
            layoutParams.setMarginStart(b3);
            pAGImageView.setLayoutParams(layoutParams);
            pAGImageView.setClickable(true);
            pAGImageView.setFocusable(true);
            pAGImageView.setPadding(b6, b5, b6, b5);
            pAGImageView.setImageDrawable(s.c(this, "tt_ad_arrow_backward_wrapper"));
            final PAGImageView pAGImageView2 = new PAGImageView(this);
            String str2 = stringExtra;
            pAGImageView2.setId(520093716);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b9, b10);
            PAGLinearLayout pAGLinearLayout2 = pAGLinearLayout;
            PAGImageView pAGImageView3 = pAGImageView;
            layoutParams2.addRule(17, 520093720);
            pAGImageView2.setLayoutParams(layoutParams2);
            pAGImageView2.setClickable(true);
            pAGImageView2.setFocusable(true);
            pAGImageView2.setPadding(b5, b6, b5, b6);
            pAGImageView2.setImageDrawable(s.c(this, "tt_ad_xmark"));
            PAGTextView pAGTextView = new PAGTextView(this);
            pAGTextView.setId(i.ao);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b11, b8);
            layoutParams3.setMarginStart(b2);
            layoutParams3.addRule(15);
            layoutParams3.addRule(16, 520093741);
            layoutParams3.addRule(17, 520093716);
            pAGTextView.setLayoutParams(layoutParams3);
            pAGTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            pAGTextView.setGravity(17);
            pAGTextView.setSingleLine(true);
            pAGTextView.setTextColor(Color.parseColor("#222222"));
            pAGTextView.setTextSize(17.0f);
            PAGImageView pAGImageView4 = new PAGImageView(this);
            pAGImageView4.setId(520093741);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(b9, b10);
            layoutParams4.addRule(16, 520093742);
            pAGImageView4.setLayoutParams(layoutParams4);
            pAGImageView4.setPadding(b4, b5, b4, b5);
            pAGImageView4.setImageDrawable(s.c(this, "tt_ad_link"));
            PAGImageView pAGImageView5 = new PAGImageView(this);
            pAGImageView5.setId(520093742);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(b9, b10);
            layoutParams5.addRule(21);
            layoutParams5.setMarginEnd(b3);
            pAGImageView5.setLayoutParams(layoutParams5);
            pAGImageView5.setPadding(b5, b7, b5, b7);
            pAGImageView5.setImageDrawable(s.c(this, "tt_ad_threedots"));
            final PAGProgressBar pAGProgressBar = new PAGProgressBar(this, (AttributeSet) null, 16973855);
            pAGProgressBar.setId(520093743);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, ad.b((Context) this, 2.0f));
            layoutParams6.addRule(12);
            pAGProgressBar.setLayoutParams(layoutParams6);
            pAGProgressBar.setProgress(1);
            pAGProgressBar.setProgressDrawable(s.c(this, "tt_privacy_progress_style"));
            View view = new View(this);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, ad.b((Context) this, 1.0f));
            layoutParams7.addRule(12);
            view.setLayoutParams(layoutParams7);
            PAGImageView pAGImageView6 = pAGImageView3;
            pAGRelativeLayout.addView(pAGImageView6);
            pAGRelativeLayout.addView(pAGImageView2);
            pAGRelativeLayout.addView(pAGTextView);
            pAGRelativeLayout.addView(pAGImageView4);
            pAGRelativeLayout.addView(pAGImageView5);
            pAGRelativeLayout.addView(pAGProgressBar);
            pAGRelativeLayout.addView(view);
            PAGLinearLayout pAGLinearLayout3 = pAGLinearLayout2;
            pAGLinearLayout3.addView(pAGRelativeLayout);
            try {
                WebView webView = new WebView(this);
                this.c = webView;
                webView.setBackgroundColor(-1);
                pAGLinearLayout3.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
                pAGImageView6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (TTWebsiteActivity.this.c.canGoBack()) {
                            TTWebsiteActivity.this.c.goBack();
                        } else {
                            TTWebsiteActivity.this.finish();
                        }
                    }
                });
                pAGImageView2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TTWebsiteActivity.this.finish();
                    }
                });
                pAGImageView2.setVisibility(4);
                pAGImageView2.setClickable(false);
                pAGTextView.setText(s.a(this, "tt_privacy_title"));
                pAGImageView4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        String url = TTWebsiteActivity.this.c.getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            intent.setData(Uri.parse(url));
                            b.a(TTWebsiteActivity.this, intent, (b.a) null);
                        }
                    }
                });
                final String str3 = str2;
                pAGImageView5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (TTWebsiteActivity.this.b == null) {
                            h unused = TTWebsiteActivity.this.b = new h(TTWebsiteActivity.this);
                            TTWebsiteActivity.this.b.a(str3);
                            TTWebsiteActivity.this.b.setCanceledOnTouchOutside(false);
                        }
                        TTWebsiteActivity.this.b.show();
                    }
                });
                if (o.d() != null) {
                    this.a = o.d().J();
                    if (!TextUtils.isEmpty(str)) {
                        String encode = URLEncoder.encode(str);
                        if (this.a.contains("?")) {
                            this.a += "&gdid_encrypted=" + encode;
                        } else {
                            this.a += "?gdid_encrypted=" + encode;
                        }
                    }
                }
                if (this.a != null) {
                    WebSettings settings = this.c.getSettings();
                    if (Build.VERSION.SDK_INT >= 21) {
                        settings.setMixedContentMode(0);
                    }
                    try {
                        settings.setJavaScriptEnabled(true);
                        settings.setDomStorageEnabled(true);
                        settings.setSavePassword(false);
                        settings.setAllowFileAccess(false);
                    } catch (Throwable unused) {
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Referer", TTAdConstant.REQUEST_HEAD_REFERER);
                    try {
                        this.c.loadUrl(this.a, hashMap);
                    } catch (Throwable unused2) {
                        this.c.loadUrl(this.a);
                    }
                    this.c.setWebChromeClient(new WebChromeClient() {
                        public void onProgressChanged(WebView webView, int i) {
                            super.onProgressChanged(webView, i);
                            if (pAGProgressBar != null && !TTWebsiteActivity.this.isFinishing()) {
                                if (i == 100) {
                                    pAGProgressBar.setVisibility(8);
                                    if (webView.canGoBack()) {
                                        pAGImageView2.setVisibility(0);
                                        pAGImageView2.setClickable(true);
                                        return;
                                    }
                                    pAGImageView2.setVisibility(4);
                                    pAGImageView2.setClickable(false);
                                    return;
                                }
                                pAGProgressBar.setVisibility(0);
                                pAGProgressBar.setProgress(i);
                            }
                        }
                    });
                    this.c.setWebViewClient(new SSWebView.a() {
                        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                            if (webView == null || webResourceRequest == null) {
                                return false;
                            }
                            if (Build.VERSION.SDK_INT >= 21) {
                                webView.loadUrl(webResourceRequest.getUrl().toString());
                                return true;
                            }
                            webView.loadUrl(webResourceRequest.toString());
                            return true;
                        }

                        public void onPageFinished(WebView webView, String str) {
                            super.onPageFinished(webView, str);
                        }

                        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                            com.bytedance.sdk.component.utils.l.e("TTAD.TTWebsiteActivity", "onReceivedHttpError invoke....errorResponse=" + webResourceResponse);
                        }

                        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                            super.onReceivedError(webView, webResourceRequest, webResourceError);
                            com.bytedance.sdk.component.utils.l.e("TTAD.TTWebsiteActivity", "onReceivedError invoke....onReceivedError=" + webResourceError.getErrorCode());
                        }

                        public void onReceivedError(WebView webView, int i, String str, String str2) {
                            super.onReceivedError(webView, i, str, str2);
                        }
                    });
                    com.bytedance.sdk.openadsdk.core.widget.a.c.b(this.c);
                    return;
                }
                finish();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.l.c("TTAD.TTWebsiteActivity", "onCreate: ", e);
                finish();
            }
        } catch (Throwable unused3) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        aa.a(this.c);
    }
}
