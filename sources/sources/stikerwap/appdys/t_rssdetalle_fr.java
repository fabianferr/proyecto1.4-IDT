package stikerwap.appdys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.MimeTypeMap;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.core.net.MailTo;
import androidx.fragment.app.Fragment;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class t_rssdetalle_fr extends Fragment {
    Bundle extras;
    boolean finalizar = false;
    config globales;
    boolean limpiar_hist = true;
    boolean linksexternos = false;
    WebChromeClient mClient;
    LinearLayout mContentView;
    View mCustomView;
    WebChromeClient.CustomViewCallback mCustomViewCallback;
    FrameLayout mTargetView;
    WebView myWebView;
    boolean primera = true;
    View v;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        config config = (config) getActivity().getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        boolean z = false;
        this.v = layoutInflater.inflate(R.layout.rssdetalle, viewGroup, false);
        this.extras = getActivity().getIntent().getExtras();
        if (this.globales.secciones_a[this.globales.ind_secc_sel_2].linksexternos == 1) {
            z = true;
        }
        this.linksexternos = z;
        WebView webView = (WebView) this.v.findViewById(R.id.webview);
        this.myWebView = webView;
        AnonymousClass1 r4 = new WebChromeClient() {
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                t_rssdetalle_fr.this.mCustomViewCallback = customViewCallback;
                t_rssdetalle_fr.this.mTargetView.addView(view);
                t_rssdetalle_fr.this.mCustomView = view;
                t_rssdetalle_fr.this.mContentView.setVisibility(8);
                t_rssdetalle_fr.this.mTargetView.setVisibility(0);
                t_rssdetalle_fr.this.getActivity().getWindow().getDecorView().setSystemUiVisibility(4);
            }

            public void onHideCustomView() {
                if (t_rssdetalle_fr.this.getActivity() != null) {
                    t_rssdetalle_fr.this.getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
                    if (t_rssdetalle_fr.this.mCustomView != null) {
                        t_rssdetalle_fr.this.mCustomView.setVisibility(8);
                        t_rssdetalle_fr.this.mTargetView.removeView(t_rssdetalle_fr.this.mCustomView);
                        t_rssdetalle_fr.this.mCustomView = null;
                        t_rssdetalle_fr.this.mTargetView.setVisibility(8);
                        t_rssdetalle_fr.this.mCustomViewCallback.onCustomViewHidden();
                        t_rssdetalle_fr.this.mContentView.setVisibility(0);
                    }
                }
            }

            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                callback.invoke(str, true, false);
            }
        };
        this.mClient = r4;
        webView.setWebChromeClient(r4);
        wv_set();
        this.myWebView.getSettings().setBuiltInZoomControls(true);
        this.myWebView.getSettings().setSupportZoom(true);
        this.myWebView.getSettings().setDomStorageEnabled(true);
        this.myWebView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        this.myWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                t_rssdetalle_fr.this.startActivity(intent);
            }
        });
        if (this.globales.secciones_a[this.globales.ind_secc_sel_2].adaptar_ancho) {
            this.myWebView.getSettings().setUseWideViewPort(true);
            this.myWebView.getSettings().setLoadWithOverviewMode(true);
        }
        final ProgressBar progressBar = (ProgressBar) this.v.findViewById(R.id.pb_url);
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(progressBar, this.globales.c_icos);
        }
        this.myWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                progressBar.setVisibility(0);
            }

            public void onPageFinished(WebView webView, String str) {
                progressBar.setVisibility(8);
                if (t_rssdetalle_fr.this.limpiar_hist) {
                    webView.clearHistory();
                    t_rssdetalle_fr.this.limpiar_hist = false;
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10 = str;
                String lowerCase = str.toLowerCase();
                String[] strArr = {"doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "pages", "ai", "psd", "tiff", "dxf", "svg", "eps", "ps", "ttf", "otf", "xps", "zip", "rar"};
                String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(lowerCase);
                if (lowerCase.startsWith("tel:") || lowerCase.startsWith("http://tel:")) {
                    if (lowerCase.startsWith("tel:")) {
                        str2 = str10.substring(4);
                    } else {
                        str2 = str10.substring(11);
                    }
                    if (str2.endsWith("/")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    try {
                        t_rssdetalle_fr.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str2)));
                    } catch (Exception unused) {
                    }
                    return true;
                } else if (lowerCase.startsWith(MailTo.MAILTO_SCHEME) || lowerCase.startsWith("http://mailto:")) {
                    if (lowerCase.startsWith(MailTo.MAILTO_SCHEME)) {
                        str3 = str10.substring(7).trim();
                    } else {
                        str3 = str10.substring(14).trim();
                    }
                    if (!str3.equals("")) {
                        int indexOf = str3.indexOf("?");
                        if (indexOf > 0) {
                            int indexOf2 = str3.indexOf("?subject=");
                            if (indexOf2 != -1) {
                                str5 = str3.substring(indexOf2 + 9).trim();
                                int indexOf3 = str5.indexOf("&body=");
                                if (indexOf3 != -1) {
                                    str4 = str5.substring(indexOf3 + 6).trim();
                                    str5 = str5.substring(0, indexOf3).trim();
                                } else {
                                    str4 = "";
                                }
                            } else {
                                str5 = "";
                                str4 = str5;
                            }
                            str3 = str3.substring(0, indexOf).trim();
                        } else {
                            str5 = "";
                            str4 = str5;
                        }
                        if (str3.endsWith("/")) {
                            str3 = str3.substring(0, str3.length() - 1);
                        }
                        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str3, (String) null));
                        if (!str5.equals("")) {
                            try {
                                str5 = URLDecoder.decode(str5, "UTF-8");
                            } catch (Exception unused2) {
                            }
                            intent.putExtra("android.intent.extra.SUBJECT", str5);
                        }
                        if (!str4.equals("")) {
                            try {
                                str4 = URLDecoder.decode(str4, "UTF-8");
                            } catch (Exception unused3) {
                            }
                            intent.putExtra("android.intent.extra.TEXT", str4);
                        }
                        t_rssdetalle_fr t_rssdetalle_fr = t_rssdetalle_fr.this;
                        t_rssdetalle_fr.startActivity(Intent.createChooser(intent, t_rssdetalle_fr.getResources().getString(R.string.enviar_email)));
                    }
                    return true;
                } else if (lowerCase.startsWith("smsto:") || lowerCase.startsWith("http://smsto:")) {
                    if (lowerCase.startsWith("smsto:")) {
                        str6 = str10.substring(6).trim();
                    } else {
                        str6 = str10.substring(13).trim();
                    }
                    if (!str6.equals("")) {
                        int indexOf4 = str6.indexOf("?");
                        if (indexOf4 > 0) {
                            int indexOf5 = str6.indexOf("?body=");
                            if (indexOf5 != -1) {
                                str7 = str6.substring(indexOf5 + 6).trim();
                            } else {
                                str7 = "";
                            }
                            str6 = str6.substring(0, indexOf4).trim();
                        } else {
                            str7 = "";
                        }
                        if (str6.endsWith("/")) {
                            str6 = str6.substring(0, str6.length() - 1);
                        }
                        Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str6));
                        if (!str7.equals("")) {
                            try {
                                str7 = URLDecoder.decode(str7, "UTF-8");
                            } catch (Exception unused4) {
                            }
                            intent2.putExtra("sms_body", str7);
                        }
                        try {
                            t_rssdetalle_fr.this.startActivity(intent2);
                        } catch (Exception unused5) {
                        }
                    }
                    return true;
                } else if (lowerCase.startsWith("go:") || lowerCase.startsWith("http://go:")) {
                    if (lowerCase.startsWith("go:")) {
                        str8 = str10.substring(3);
                    } else {
                        str8 = str10.substring(10);
                    }
                    if (str8.endsWith("/")) {
                        str8 = str8.substring(0, str8.length() - 1);
                    }
                    try {
                        str8 = URLDecoder.decode(str8, "UTF-8");
                    } catch (Exception unused6) {
                    }
                    for (int i = 0; i < t_rssdetalle_fr.this.globales.secciones_a.length; i++) {
                        if (t_rssdetalle_fr.this.globales.secciones_a[i].idgo.equalsIgnoreCase(str8)) {
                            t_rssdetalle_fr.this.startActivityForResult(t_rssdetalle_fr.this.globales.crear_rgi(Integer.valueOf(i), t_rssdetalle_fr.this.v.getContext()).i, 0);
                            return true;
                        }
                    }
                    t_rssdetalle_fr.this.primera = false;
                    return false;
                } else if (lowerCase.startsWith("vnd.youtube:")) {
                    int indexOf6 = str10.indexOf("?");
                    if (indexOf6 > 0) {
                        str9 = str10.substring(12, indexOf6);
                    } else {
                        str9 = str10.substring(12);
                    }
                    String str11 = "https://www.youtube.com/watch?v=" + str9;
                    if (t_rssdetalle_fr.this.linksexternos) {
                        t_rssdetalle_fr.this.globales.abrir_ext(t_rssdetalle_fr.this.v.getContext(), str11);
                    } else {
                        t_rssdetalle_fr.this.primera = false;
                        t_rssdetalle_fr.this.myWebView.loadUrl(str11);
                    }
                    return true;
                } else if (lowerCase.endsWith(".mp3")) {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setDataAndType(Uri.parse(str), "audio/*");
                    webView.getContext().startActivity(intent3);
                    return true;
                } else if (lowerCase.endsWith(".mp4") || lowerCase.endsWith(".3gp")) {
                    Intent intent4 = new Intent("android.intent.action.VIEW");
                    intent4.setDataAndType(Uri.parse(str), "video/*");
                    webView.getContext().startActivity(intent4);
                    return true;
                } else if (lowerCase.startsWith("upi://")) {
                    Intent intent5 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    t_rssdetalle_fr t_rssdetalle_fr2 = t_rssdetalle_fr.this;
                    t_rssdetalle_fr2.startActivity(Intent.createChooser(intent5, t_rssdetalle_fr2.getResources().getString(R.string.selecciona)));
                    return true;
                } else if (t_rssdetalle_fr.this.linksexternos || lowerCase.startsWith("rtsp://") || lowerCase.startsWith("rtmp://") || lowerCase.startsWith("market://") || lowerCase.endsWith(".apk") || lowerCase.startsWith("whatsapp://") || lowerCase.endsWith(".m3u") || lowerCase.endsWith(".m3u8")) {
                    return t_rssdetalle_fr.this.globales.abrir_ext(t_rssdetalle_fr.this.v.getContext(), str10);
                } else {
                    if (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("") || !Arrays.asList(strArr).contains(fileExtensionFromUrl) || lowerCase.contains("docs.google.com")) {
                        t_rssdetalle_fr.this.primera = false;
                        return false;
                    } else if (!t_rssdetalle_fr.this.myWebView.getUrl().contains("docs.google.com")) {
                        try {
                            str10 = URLEncoder.encode(str10, "utf-8");
                        } catch (Exception unused7) {
                        }
                        t_rssdetalle_fr.this.myWebView.loadUrl("https://docs.google.com/viewer?embedded=true&url=" + str10);
                        t_rssdetalle_fr.this.primera = false;
                        return true;
                    } else {
                        t_rssdetalle_fr.this.globales.abrir_ext(t_rssdetalle_fr.this.v.getContext(), str10);
                        return true;
                    }
                }
            }
        });
        this.myWebView.getSettings().setJavaScriptEnabled(true);
        this.myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        WebSettings settings = this.myWebView.getSettings();
        settings.setUserAgentString(this.myWebView.getSettings().getUserAgentString() + " Vinebre");
        return this.v;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.myWebView.restoreState(bundle);
        } else {
            Bundle bundle2 = this.extras;
            if (!(bundle2 == null || bundle2.getString("url") == null)) {
                this.myWebView.loadUrl(this.extras.getString("url"));
            }
        }
        this.mContentView = (LinearLayout) getActivity().findViewById(R.id.ll_princ);
        this.mTargetView = (FrameLayout) getActivity().findViewById(R.id.target_view);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.mCustomView != null) {
            this.mClient.onHideCustomView();
            return true;
        } else if (this.primera || !this.myWebView.canGoBack()) {
            return false;
        } else {
            this.myWebView.goBack();
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }

    public void actContenido(String str) {
        if (this.v != null) {
            this.primera = true;
            this.limpiar_hist = true;
            this.myWebView.loadUrl(str);
        }
    }

    public void onResume() {
        super.onResume();
        this.myWebView.onResume();
    }

    public void onPause() {
        if (this.mCustomView != null) {
            this.mClient.onHideCustomView();
        }
        super.onPause();
        this.myWebView.onPause();
        if (this.finalizar || getActivity().isFinishing()) {
            try {
                this.myWebView.loadData("", "text/html", "utf-8");
            } catch (Exception unused) {
            }
        }
    }

    private void wv_set() {
        if (Build.VERSION.SDK_INT > 20) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.myWebView, true);
        }
    }
}
