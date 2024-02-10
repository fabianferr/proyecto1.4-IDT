package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsResult;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.facebook.ads.Ad;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

public class t_html extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    AlertDialog.Builder adb;
    Anuncios anun;
    boolean atras_pulsado = false;
    GeolocationPermissions.Callback callback_glob;
    boolean cl_history = false;
    String contra;
    boolean descargar;
    EditText et_contra;
    EditText et_usu;
    Bundle extras;
    config globales;
    HttpAuthHandler handler_glob;
    boolean history_cleared = false;
    String html;
    int ind;
    int ind_abrir_secc = -1;
    int linksexternos = 0;
    boolean loader = true;
    boolean mAd_visto = false;
    private WebChromeClient mClient;
    /* access modifiers changed from: private */
    public LinearLayout mContentView;
    /* access modifiers changed from: private */
    public View mCustomView;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback mCustomViewCallback;
    ListView mDrawerList;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> mFilePathCallback;
    /* access modifiers changed from: private */
    public FrameLayout mTargetView;
    /* access modifiers changed from: private */
    public ValueCallback<Uri> mUploadMessage;
    WebView myWebView;
    String origin_glob;
    boolean primer_load = true;
    boolean ptr = false;
    SwipeRefreshLayout swipe;
    String usu;
    boolean zoom = false;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        establec_ralc(this);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        this.ind = extras2.getInt("idsecc");
        this.cbtn = config.aplicar_color_dialog(this.globales.secciones_a[this.ind].c1, this.globales.c_icos);
        super.onCreate(bundle);
        setContentView(R.layout.t_url);
        if (bundle == null) {
            Bundle bundle2 = this.extras;
            this.es_root = bundle2 != null && bundle2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_html.this.finalizar = false;
                t_html.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_html.this.buscador_on = false;
            }
        });
        this.myWebView = (WebView) findViewById(R.id.webview);
        this.html = this.globales.secciones_a[this.ind].html;
        if (this.globales.ind_secc_sel_2 != -1) {
            this.linksexternos = this.globales.secciones_a[this.globales.ind_secc_sel_2].linksexternos;
            this.loader = this.globales.secciones_a[this.globales.ind_secc_sel_2].loader;
            this.zoom = this.globales.secciones_a[this.globales.ind_secc_sel_2].zoom;
            this.ptr = this.globales.secciones_a[this.globales.ind_secc_sel_2].pulltorefresh;
            this.descargar = this.globales.secciones_a[this.globales.ind_secc_sel_2].descargar;
        } else {
            this.linksexternos = 0;
            this.loader = true;
            this.zoom = true;
            this.ptr = false;
            this.descargar = false;
        }
        if (!this.html.startsWith("GET_") || this.html.length() <= 4) {
            iniciar(bundle);
            return;
        }
        String[] split = this.html.split("_");
        if (split.length == 2) {
            new cargar_html(split[1]).execute(new String[0]);
        } else {
            iniciar(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void iniciar(Bundle bundle) {
        String str;
        String str2;
        registerForContextMenu(this.myWebView);
        this.anun = this.globales.mostrar_banner(this, this.html.contains("youtube.com") || this.html.contains("youtu.be"));
        config config = this.globales;
        config.oncreate_popup(this, config.ind_secc_sel_2, this.cbtn, bundle);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl);
        this.swipe = swipeRefreshLayout;
        if (this.ptr) {
            if (Build.VERSION.SDK_INT > 20) {
                this.swipe.setColorSchemeColors(Color.parseColor("#" + this.globales.c_icos));
            }
            this.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                public void onRefresh() {
                    t_html.this.myWebView.reload();
                }
            });
        } else {
            swipeRefreshLayout.setEnabled(false);
        }
        if (this.linksexternos == 2) {
            this.myWebView.getSettings().setSupportMultipleWindows(true);
        }
        WebView webView = this.myWebView;
        AnonymousClass4 r5 = new WebChromeClient() {
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                WebView webView2 = new WebView(t_html.this);
                webView2.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        t_html.this.globales.abrir_ext(t_html.this, str);
                        return true;
                    }
                });
                ((WebView.WebViewTransport) message.obj).setWebView(webView2);
                message.sendToTarget();
                return true;
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                t_html.this.mCustomViewCallback = customViewCallback;
                t_html.this.mTargetView.addView(view);
                t_html.this.mCustomView = view;
                t_html.this.mContentView.setVisibility(8);
                t_html.this.mTargetView.setVisibility(0);
                t_html.this.getWindow().getDecorView().setSystemUiVisibility(4);
            }

            public void onHideCustomView() {
                t_html.this.getWindow().getDecorView().setSystemUiVisibility(0);
                if (t_html.this.mCustomView != null) {
                    t_html.this.mCustomView.setVisibility(8);
                    t_html.this.mTargetView.removeView(t_html.this.mCustomView);
                    t_html.this.mCustomView = null;
                    t_html.this.mTargetView.setVisibility(8);
                    t_html.this.mCustomViewCallback.onCustomViewHidden();
                    t_html.this.mContentView.setVisibility(0);
                }
            }

            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                if (!config.p_location(t_html.this)) {
                    return;
                }
                if (ContextCompat.checkSelfPermission(t_html.this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(t_html.this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    callback.invoke(str, true, false);
                    return;
                }
                t_html.this.origin_glob = str;
                t_html.this.callback_glob = callback;
                ActivityCompat.requestPermissions(t_html.this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 103);
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                t_html.this.mUploadMessage = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                t_html t_html = t_html.this;
                t_html.startActivityForResult(Intent.createChooser(intent, t_html.getResources().getString(R.string.selecciona)), 10);
            }

            public void openFileChooser(ValueCallback valueCallback, String str) {
                t_html.this.mUploadMessage = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                t_html t_html = t_html.this;
                t_html.startActivityForResult(Intent.createChooser(intent, t_html.getResources().getString(R.string.selecciona)), 10);
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                t_html.this.mUploadMessage = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                t_html t_html = t_html.this;
                t_html.startActivityForResult(Intent.createChooser(intent, t_html.getResources().getString(R.string.selecciona)), 10);
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (t_html.this.mFilePathCallback != null) {
                    t_html.this.mFilePathCallback.onReceiveValue((Object) null);
                }
                t_html.this.mFilePathCallback = valueCallback;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                t_html t_html = t_html.this;
                t_html.startActivityForResult(Intent.createChooser(intent, t_html.getResources().getString(R.string.selecciona)), 10);
                return true;
            }
        };
        this.mClient = r5;
        webView.setWebChromeClient(r5);
        wv_set();
        this.myWebView.getSettings().setBuiltInZoomControls(this.zoom);
        this.myWebView.getSettings().setSupportZoom(this.zoom);
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
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[SYNTHETIC, Splitter:B:27:0x0077] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onDownloadStart(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, long r7) {
                /*
                    r2 = this;
                    stikerwap.appdys.t_html r4 = stikerwap.appdys.t_html.this
                    boolean r4 = r4.descargar
                    if (r4 != 0) goto L_0x0023
                    java.lang.String r4 = ".apk"
                    boolean r4 = r3.endsWith(r4)
                    if (r4 == 0) goto L_0x000f
                    goto L_0x0023
                L_0x000f:
                    android.content.Intent r4 = new android.content.Intent
                    java.lang.String r5 = "android.intent.action.VIEW"
                    r4.<init>(r5)
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r4.setData(r3)
                    stikerwap.appdys.t_html r3 = stikerwap.appdys.t_html.this
                    r3.startActivity(r4)
                    goto L_0x0084
                L_0x0023:
                    java.lang.String r4 = ""
                    if (r5 == 0) goto L_0x0070
                    java.lang.String r7 = "filename="
                    boolean r7 = r5.contains(r7)
                    if (r7 == 0) goto L_0x0070
                    java.lang.String r7 = "(?i)^.*filename=\"?([^\"]+)\"?.*$"
                    java.lang.String r8 = "$1"
                    java.lang.String r7 = r5.replaceFirst(r7, r8)
                    java.lang.String r8 = "UTF-8"
                    java.lang.String r7 = r7.replace(r8, r4)
                    java.lang.String r8 = "."
                    boolean r0 = r7.contains(r8)
                    if (r0 == 0) goto L_0x0070
                    int r0 = r7.lastIndexOf(r8)
                    r1 = -1
                    if (r0 == r1) goto L_0x0051
                    java.lang.String r0 = r7.substring(r0)
                    goto L_0x0052
                L_0x0051:
                    r0 = r4
                L_0x0052:
                    java.lang.String r8 = r0.replace(r8, r4)
                    if (r8 == 0) goto L_0x0071
                    boolean r0 = r8.equals(r4)
                    if (r0 != 0) goto L_0x0071
                    android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
                    java.lang.String r8 = r0.getMimeTypeFromExtension(r8)
                    if (r8 == 0) goto L_0x0071
                    boolean r0 = r8.equals(r4)
                    if (r0 != 0) goto L_0x0071
                    r6 = r8
                    goto L_0x0071
                L_0x0070:
                    r7 = r4
                L_0x0071:
                    boolean r4 = r7.equals(r4)
                    if (r4 == 0) goto L_0x007b
                    java.lang.String r7 = android.webkit.URLUtil.guessFileName(r3, r5, r6)     // Catch:{ Exception -> 0x007b }
                L_0x007b:
                    stikerwap.appdys.t_html r4 = stikerwap.appdys.t_html.this
                    stikerwap.appdys.config r4 = r4.globales
                    stikerwap.appdys.t_html r5 = stikerwap.appdys.t_html.this
                    r4.fdescargar(r3, r6, r7, r5)
                L_0x0084:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_html.AnonymousClass6.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
            }
        });
        if (this.globales.ind_secc_sel_2 != -1 && this.globales.secciones_a[this.globales.ind_secc_sel_2].adaptar_ancho) {
            this.myWebView.getSettings().setUseWideViewPort(true);
            this.myWebView.getSettings().setLoadWithOverviewMode(true);
        }
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_url);
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(progressBar, this.globales.c_icos);
        }
        this.myWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
                t_html.this.handler_glob = httpAuthHandler;
                t_html.this.adb = new AlertDialog.Builder(t_html.this);
                t_html.this.adb.setTitle(t_html.this.getResources().getString(R.string.chat_acceso));
                View inflate = t_html.this.getLayoutInflater().inflate(R.layout.usucontra, (ViewGroup) null);
                t_html.this.et_usu = (EditText) inflate.findViewById(R.id.et_usu);
                t_html.this.et_contra = (EditText) inflate.findViewById(R.id.et_contra);
                t_html.this.adb.setView(inflate);
                t_html.this.adb.setCancelable(true);
                t_html.this.adb.setPositiveButton(t_html.this.getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        t_html.this.usu = t_html.this.et_usu.getText().toString();
                        t_html.this.contra = t_html.this.et_contra.getText().toString();
                        t_html.this.handler_glob.proceed(t_html.this.usu, t_html.this.contra);
                    }
                });
                t_html.this.adb.setNegativeButton(t_html.this.getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        t_html.this.handler_glob.cancel();
                    }
                });
                t_html.this.adb.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        t_html.this.handler_glob.cancel();
                    }
                });
                t_html.this.adb.create().show();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (!config.isNetworkAvailable(t_html.this)) {
                    if (!t_html.this.globales.wv_sinconex_txt.equals("")) {
                        String str3 = t_html.this.globales.wv_sinconex_txt;
                        if (!str3.toLowerCase(Locale.getDefault()).contains("<html")) {
                            str3 = "<html><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body>" + str3 + "</body></html>";
                        }
                        t_html.this.myWebView.loadData(str3, "text/html; charset=utf-8", "utf-8");
                    } else {
                        t_html.this.myWebView.loadData("<html><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body>" + t_html.this.getResources().getString(R.string.wv_sinconex) + "</body></html>", "text/html; charset=utf-8", "utf-8");
                    }
                    t_html.this.myWebView.clearHistory();
                    t_html.this.history_cleared = true;
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                boolean z;
                boolean z2;
                if (!t_html.this.finalizar && !t_html.this.isFinishing() && !t_html.this.html.contains("youtube.com") && !t_html.this.html.contains("youtu.be")) {
                    if (t_html.this.primer_load) {
                        z = true;
                        z2 = t_html.this.extras != null && t_html.this.extras.containsKey("ad_entrar");
                        if (t_html.this.extras == null || !t_html.this.extras.containsKey("fb_entrar")) {
                            z = false;
                        }
                        t_html.this.primer_load = false;
                    } else {
                        z2 = false;
                        z = false;
                    }
                    t_html.this.globales.toca_int_2(t_html.this, z2, z, false);
                }
                if (t_html.this.loader && !t_html.this.swipe.isRefreshing()) {
                    progressBar.setVisibility(0);
                }
            }

            public void onPageFinished(WebView webView, String str) {
                progressBar.setVisibility(8);
                t_html.this.swipe.setRefreshing(false);
                if (t_html.this.cl_history) {
                    t_html.this.cl_history = false;
                    t_html.this.myWebView.clearHistory();
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
                int i = 0;
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
                        t_html.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str2)));
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
                            if (str4.equals("")) {
                                try {
                                    String[] split = Uri.parse(str).getQuery().split("&");
                                    int length = split.length;
                                    int i2 = 0;
                                    while (i2 < length) {
                                        String str11 = split[i2];
                                        int indexOf4 = str11.indexOf("=");
                                        String decode = URLDecoder.decode(str11.substring(i, indexOf4), "UTF-8");
                                        String decode2 = URLDecoder.decode(str11.substring(indexOf4 + 1), "UTF-8");
                                        if (!decode.equalsIgnoreCase("subject")) {
                                            str4 = str4 + "<b>" + decode + "</b>: " + decode2 + "<br>";
                                        }
                                        i2++;
                                        i = 0;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
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
                            StringBuilder sb = new StringBuilder();
                            sb.append("<p>" + str4 + "</p>");
                            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(sb.toString()));
                        }
                        t_html t_html = t_html.this;
                        t_html.startActivity(Intent.createChooser(intent, t_html.getResources().getString(R.string.enviar_email)));
                    }
                    return true;
                } else if (lowerCase.startsWith("smsto:") || lowerCase.startsWith("http://smsto:")) {
                    if (lowerCase.startsWith("smsto:")) {
                        str6 = str10.substring(6).trim();
                    } else {
                        str6 = str10.substring(13).trim();
                    }
                    if (!str6.equals("")) {
                        int indexOf5 = str6.indexOf("?");
                        if (indexOf5 > 0) {
                            int indexOf6 = str6.indexOf("?body=");
                            if (indexOf6 != -1) {
                                str7 = str6.substring(indexOf6 + 6).trim();
                            } else {
                                str7 = "";
                            }
                            str6 = str6.substring(0, indexOf5).trim();
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
                            t_html.this.startActivity(intent2);
                        } catch (Exception unused5) {
                        }
                    }
                    return true;
                } else if (lowerCase.startsWith("action_") || lowerCase.startsWith("http://action_")) {
                    ResultGetIntent intent_porURL = t_html.this.globales.getIntent_porURL(lowerCase, t_html.this);
                    if (intent_porURL.finalizar) {
                        t_html.this.finalizar = true;
                        Intent intent3 = new Intent();
                        intent3.putExtra("finalizar", true);
                        intent3.putExtra("finalizar_app", intent_porURL.finalizar_app);
                        t_html.this.setResult(-1, intent3);
                    }
                    if (intent_porURL.esmas) {
                        t_html.this.startActivityForResult(intent_porURL.i, 0);
                    } else if (intent_porURL.i != null) {
                        if (intent_porURL.finalizar) {
                            t_html.this.es_root = false;
                            if (t_html.this.globales.tipomenu != 2) {
                                intent_porURL.i.putExtra("es_root", true);
                            }
                            try {
                                t_html.this.startActivity(intent_porURL.i);
                            } catch (Exception unused6) {
                            }
                        } else {
                            t_html.this.startActivityForResult(intent_porURL.i, 0);
                        }
                    }
                    if (t_html.this.finalizar && !t_html.this.buscador_on) {
                        t_html.this.finish();
                    }
                    return true;
                } else if (lowerCase.startsWith("intent://") || lowerCase.startsWith("wvc-x-callback://")) {
                    try {
                        Intent parseUri = Intent.parseUri(str10, 1);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent((ComponentName) null);
                        parseUri.setSelector((Intent) null);
                        t_html.this.startActivity(parseUri);
                        return true;
                    } catch (Exception unused7) {
                        return false;
                    }
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
                    } catch (Exception unused8) {
                    }
                    for (int i3 = 0; i3 < t_html.this.globales.secciones_a.length; i3++) {
                        if (t_html.this.globales.secciones_a[i3].idgo.equalsIgnoreCase(str8)) {
                            if ((t_html.this.globales.appnext_rew_cod == null || t_html.this.globales.appnext_rew_cod.equals("")) && ((t_html.this.globales.precio_secc == null || t_html.this.globales.precio_secc.equals("")) && ((t_html.this.globales.admob_rew_cod == null || t_html.this.globales.admob_rew_cod.equals("")) && ((t_html.this.globales.fb_rew_cod == null || t_html.this.globales.fb_rew_cod.equals("")) && ((t_html.this.globales.st_rew_cod == null || t_html.this.globales.st_rew_cod.equals("")) && ((t_html.this.globales.pollfish_cod == null || t_html.this.globales.pollfish_cod.equals("")) && ((t_html.this.globales.uni_rew_cod == null || t_html.this.globales.uni_rew_cod.equals("")) && (t_html.this.globales.is_rew_cod == null || t_html.this.globales.is_rew_cod.equals(""))))))))) {
                                t_html.this.globales.abrir_go(t_html.this, i3);
                            } else {
                                if (t_html.this.globales.appnext_rew_cod != null && !t_html.this.globales.appnext_rew_cod.equals("")) {
                                    t_html t_html2 = t_html.this;
                                    t_html t_html3 = t_html.this;
                                    t_html2.mAd_appnext = new RewardedVideo((Context) t_html3, t_html3.globales.appnext_rew_cod);
                                }
                                if (t_html.this.globales.admob_rew_cod != null) {
                                    t_html.this.globales.admob_rew_cod.equals("");
                                }
                                if (t_html.this.globales.fb_rew_cod != null && !t_html.this.globales.fb_rew_cod.equals("")) {
                                    t_html t_html4 = t_html.this;
                                    t_html t_html5 = t_html.this;
                                    t_html4.mAd_fb = new RewardedVideoAd(t_html5, t_html5.globales.fb_rew_cod);
                                }
                                if (t_html.this.globales.st_rew_cod != null && !t_html.this.globales.st_rew_cod.equals("")) {
                                    t_html.this.mAd_st = new StartAppAd(t_html.this);
                                }
                                t_html.this.dialog_cargando = new ProgressDialog(t_html.this);
                                View view = new View(t_html.this);
                                view.setId(i3);
                                view.setTag(R.id.TAG_IDSECC, Integer.valueOf(i3));
                                t_html.this.v_abrir_secc = null;
                                t_html.this.ind_abrir_secc = i3;
                                config config = t_html.this.globales;
                                t_html t_html6 = t_html.this;
                                if (!config.rewarded(t_html6, view, t_html6.cbtn, t_html.this.dialog_cargando, t_html.this.ralc, t_html.this.mAd_appnext, t_html.this.mAd_fb, t_html.this.mAd_st, t_html.this.v_abrir_secc)) {
                                    t_html.this.globales.abrir_go(t_html.this, i3);
                                }
                            }
                            return true;
                        }
                    }
                    return false;
                } else if (lowerCase.startsWith("vnd.youtube:")) {
                    int indexOf7 = str10.indexOf("?");
                    if (indexOf7 > 0) {
                        str9 = str10.substring(12, indexOf7);
                    } else {
                        str9 = str10.substring(12);
                    }
                    String str12 = "https://www.youtube.com/watch?v=" + str9;
                    if (t_html.this.linksexternos == 1) {
                        t_html.this.globales.abrir_ext(t_html.this, str12);
                    } else {
                        t_html.this.myWebView.loadUrl(str12);
                    }
                    return true;
                } else if (t_html.this.descargar && (lowerCase.endsWith(".mp3") || lowerCase.endsWith(".mp4"))) {
                    t_html.this.globales.fdescargar(str10, "", "", t_html.this);
                    return true;
                } else if (!t_html.this.descargar && lowerCase.endsWith(".mp3")) {
                    Intent intent4 = new Intent("android.intent.action.VIEW");
                    intent4.setDataAndType(Uri.parse(str), "audio/*");
                    webView.getContext().startActivity(intent4);
                    return true;
                } else if (!t_html.this.descargar && (lowerCase.endsWith(".mp4") || lowerCase.endsWith(".3gp"))) {
                    Intent intent5 = new Intent("android.intent.action.VIEW");
                    intent5.setDataAndType(Uri.parse(str), "video/*");
                    webView.getContext().startActivity(intent5);
                    return true;
                } else if (lowerCase.startsWith("upi://")) {
                    Intent intent6 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    t_html t_html7 = t_html.this;
                    t_html7.startActivity(Intent.createChooser(intent6, t_html7.getResources().getString(R.string.selecciona)));
                    return true;
                } else if (t_html.this.linksexternos == 1 || lowerCase.startsWith("rtsp://") || lowerCase.startsWith("rtmp://") || lowerCase.startsWith("market://") || lowerCase.startsWith("whatsapp://") || lowerCase.endsWith(".m3u") || lowerCase.endsWith(".m3u8") || lowerCase.startsWith("http://www.appcreator24.com/open") || lowerCase.startsWith("https://www.appcreator24.com/open")) {
                    return t_html.this.globales.abrir_ext(t_html.this, str10);
                } else {
                    if (t_html.this.descargar || fileExtensionFromUrl == null || fileExtensionFromUrl.equals("") || !Arrays.asList(strArr).contains(fileExtensionFromUrl) || lowerCase.contains("docs.google.com")) {
                        return false;
                    }
                    if (!t_html.this.myWebView.getUrl().contains("docs.google.com")) {
                        try {
                            str10 = URLEncoder.encode(str10, "utf-8");
                        } catch (Exception unused9) {
                        }
                        t_html.this.myWebView.loadUrl("https://docs.google.com/viewer?embedded=true&url=" + str10);
                        return true;
                    }
                    t_html.this.globales.abrir_ext(t_html.this, str10);
                    return true;
                }
            }
        });
        this.myWebView.getSettings().setJavaScriptEnabled(true);
        this.myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        if (!this.globales.wv_cache && !this.globales.wv_cache_limpiada && config.isNetworkAvailable(this)) {
            this.myWebView.clearCache(true);
            this.globales.wv_cache_limpiada = true;
        }
        this.myWebView.getSettings().setCacheMode(-1);
        if (!config.isNetworkAvailable(this)) {
            if (this.globales.wv_sinconex) {
                this.myWebView.getSettings().setCacheMode(1);
            } else {
                this.myWebView.getSettings().setCacheMode(2);
            }
        }
        if (this.globales.ind_secc_sel_2 == -1 || this.globales.secciones_a[this.globales.ind_secc_sel_2].ua.equals("")) {
            str = "";
        } else {
            str = this.globales.secciones_a[this.globales.ind_secc_sel_2].ua;
        }
        if (str.equals("")) {
            this.myWebView.getSettings().setUserAgentString(this.myWebView.getSettings().getUserAgentString() + " Vinebre");
        } else {
            this.myWebView.getSettings().setUserAgentString(str);
        }
        if (bundle == null) {
            String string = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getString("ft", "0");
            if (!this.globales.secciones_a[this.ind].puroHTML && !string.equals("0") && !string.equals("")) {
                this.myWebView.getSettings().setAllowFileAccess(true);
                if (!string.equals("1")) {
                    str2 = "file:///android_asset/fonts/" + this.globales.obtenerFuente(Integer.parseInt(string));
                } else if (new File(getFilesDir(), "font").exists()) {
                    str2 = AdPayload.FILE_SCHEME + getFilesDir().getAbsolutePath() + "/font";
                } else {
                    str2 = "";
                }
                if (!str2.equals("")) {
                    this.html = this.html.replaceFirst(Pattern.quote("</head>"), "<style type=\"text/css\">@font-face {font-family: fontAC;src: url(\"" + str2 + "\")} body,input,textarea,select{font-family: fontAC;}</style></head>");
                }
            }
            this.myWebView.loadDataWithBaseURL("http://localhost/", this.html.replace("@CCORCH@", "]"), "text/html", "utf-8", (String) null);
            this.mContentView = (LinearLayout) findViewById(R.id.ll_princ);
            this.mTargetView = (FrameLayout) findViewById(R.id.target_view);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getMenuInflater().inflate(R.menu.m3, contextMenu);
        WebView.HitTestResult hitTestResult = this.myWebView.getHitTestResult();
        if (!this.descargar || !(hitTestResult.getType() == 5 || hitTestResult.getType() == 8)) {
            contextMenu.removeItem(R.id.guardar);
        } else {
            MenuItem findItem = contextMenu.findItem(R.id.guardar);
            String str = findItem.getTitle() + "";
            findItem.setTitle(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
        }
        if (!this.descargar || !(hitTestResult.getType() == 5 || hitTestResult.getType() == 8)) {
            contextMenu.removeItem(R.id.compartir);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        String str;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.compartir) {
            String str2 = this.myWebView.getHitTestResult().getExtra().toString();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str2);
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.compartir)));
            return true;
        } else if (itemId != R.id.guardar) {
            return super.onContextItemSelected(menuItem);
        } else {
            WebView.HitTestResult hitTestResult = this.myWebView.getHitTestResult();
            String str3 = hitTestResult.getExtra().toString();
            if (str3 != null) {
                String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(hitTestResult.getExtra().toString());
                String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : "image/*";
                try {
                    str = URLUtil.guessFileName(str3, (String) null, mimeTypeFromExtension);
                } catch (Exception unused) {
                    str = "";
                }
                this.globales.fdescargar(str3, mimeTypeFromExtension, str, this);
            }
            return true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mCustomView != null) {
                this.atras_pulsado = false;
                this.mClient.onHideCustomView();
                return true;
            } else if (this.myWebView.canGoBack() && !this.history_cleared) {
                this.atras_pulsado = false;
                WebBackForwardList copyBackForwardList = this.myWebView.copyBackForwardList();
                String url = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1).getUrl();
                if (url.equals("about:blank") || url.equals("data:text/html;charset=utf-8;base64,")) {
                    this.cl_history = true;
                    this.myWebView.clearHistory();
                    this.myWebView.loadDataWithBaseURL("http://localhost/", this.html.replace("@CCORCH@", "]"), "text/html", "utf-8", (String) null);
                    this.myWebView.clearHistory();
                } else {
                    this.myWebView.goBack();
                }
                return true;
            } else if (this.es_root && !this.atras_pulsado && this.globales.pedir_confirm_exit) {
                this.atras_pulsado = true;
                config.confirmar_exit(this);
                return true;
            } else if (this.es_root && this.myWebView.getUrl() != null && (this.myWebView.getUrl().toLowerCase(Locale.getDefault()).contains("youtube.com") || this.myWebView.getUrl().toLowerCase(Locale.getDefault()).contains("youtu.be"))) {
                startActivity(new Intent(this, finalizar.class));
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void abrir_secc(View view) {
        if (view == null) {
            int i = this.ind_abrir_secc;
            if (i != -1) {
                this.globales.abrir_go(this, i);
                return;
            }
            return;
        }
        ResultGetIntent intent = this.globales.getIntent(view, this);
        if (intent != null) {
            if (intent.finalizar) {
                this.finalizar = true;
                Intent intent2 = new Intent();
                intent2.putExtra("finalizar", true);
                intent2.putExtra("finalizar_app", intent.finalizar_app);
                setResult(-1, intent2);
            }
            if (intent.esmas) {
                if (this.myWebView.getUrl() != null && (this.myWebView.getUrl().toLowerCase().contains("youtube.com") || this.myWebView.getUrl().toLowerCase().contains("youtu.be"))) {
                    this.myWebView.reload();
                }
                startActivityForResult(intent.i, 0);
            } else if (intent.i != null) {
                if (intent.finalizar) {
                    this.es_root = false;
                    if (this.globales.tipomenu != 2) {
                        intent.i.putExtra("es_root", true);
                    }
                    try {
                        startActivity(intent.i);
                    } catch (Exception unused) {
                    }
                } else {
                    startActivityForResult(intent.i, 0);
                }
            }
            if (this.finalizar && !this.buscador_on) {
                finish();
            }
        }
    }

    public void onClick(View view) {
        if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
            abrir_secc(view);
            return;
        }
        if (this.globales.appnext_rew_cod != null && !this.globales.appnext_rew_cod.equals("")) {
            this.mAd_appnext = new RewardedVideo((Context) this, this.globales.appnext_rew_cod);
        }
        if (this.globales.admob_rew_cod != null) {
            this.globales.admob_rew_cod.equals("");
        }
        if (this.globales.fb_rew_cod != null && !this.globales.fb_rew_cod.equals("")) {
            this.mAd_fb = new RewardedVideoAd(this, this.globales.fb_rew_cod);
        }
        if (this.globales.st_rew_cod != null && !this.globales.st_rew_cod.equals("")) {
            this.mAd_st = new StartAppAd(this);
        }
        this.dialog_cargando = new ProgressDialog(this);
        this.v_abrir_secc = view;
        this.ind_abrir_secc = -1;
        if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
            abrir_secc(view);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 103) {
            boolean p_location = config.p_location(this);
            if (!p_location || iArr.length <= 0 || ((!strArr[0].equals("android.permission.ACCESS_FINE_LOCATION") && !strArr[0].equals("android.permission.ACCESS_COARSE_LOCATION")) || iArr[0] != 0)) {
                if (p_location && iArr.length > 1) {
                    if ((!strArr[1].equals("android.permission.ACCESS_FINE_LOCATION") && !strArr[1].equals("android.permission.ACCESS_COARSE_LOCATION")) || iArr[1] != 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.callback_glob.invoke(this.origin_glob, true, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String dataString;
        config config = this.globales;
        if (config != null && config.onActivityResult_glob(i, i2, intent, this)) {
            return;
        }
        if (i == 10) {
            ValueCallback<Uri> valueCallback = this.mUploadMessage;
            if (valueCallback != null || this.mFilePathCallback != null) {
                if (valueCallback != null) {
                    this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    this.mUploadMessage = null;
                } else if (this.mFilePathCallback != null) {
                    this.mFilePathCallback.onReceiveValue((intent == null || (dataString = intent.getDataString()) == null) ? null : new Uri[]{Uri.parse(dataString)});
                    this.mFilePathCallback = null;
                }
            }
        } else if (i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
            if (!intent.getExtras().getBoolean("finalizar_app")) {
                this.es_root = false;
            }
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void incluir_menu_pre() {
        int incluir_menu = this.globales.incluir_menu(this);
        if (this.globales.tipomenu == 1) {
            ListView listView = (ListView) findViewById(R.id.left_drawer);
            this.mDrawerList = listView;
            this.globales.config_drawer(listView);
        } else if (this.globales.tipomenu == 0) {
            int i = 0;
            for (int i2 = 0; i2 < this.globales.secciones_a.length; i2++) {
                if (!this.globales.secciones_a[i2].oculta) {
                    findViewById(i2).setOnClickListener(this);
                    i++;
                    if (i == incluir_menu) {
                        break;
                    }
                }
            }
            if (findViewById(R.id.idaux9999) != null && findViewById(R.id.idaux9999).getVisibility() == 0) {
                findViewById(R.id.idaux9999).setOnClickListener(this);
            }
        }
        for (int i3 = 0; i3 < this.globales.icos_a.length; i3++) {
            if (this.globales.icos_a[i3] > 0) {
                findViewById(this.globales.icos_a[i3]).setOnClickListener(this);
            }
        }
    }

    private class cargar_html extends AsyncTask<String, Void, String> {
        String fum;

        public cargar_html(String str) {
            this.fum = str;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_html.this.loader) {
                try {
                    t_html.this.findViewById(R.id.pb_url).setVisibility(0);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:8|(2:10|11)|12|13|14|(3:15|16|17)) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r1 = new java.io.BufferedReader(new java.io.InputStreamReader(r0.getInputStream()));
            r5 = new java.lang.StringBuilder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
            r2 = r1.readLine();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
            if (r2 == null) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0091, code lost:
            r5.append(r2 + "\n");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
            r5 = r5.toString();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00aa, code lost:
            if (r0 == null) goto L_0x00af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ac, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
            return r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0055 */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "/html/get_html.php?ida=3008836&ids="
                r0 = 0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2 }
                r1.<init>()     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r2 = stikerwap.appdys.config.PROTOC_GEN     // Catch:{ Exception -> 0x00b2 }
                r1.append(r2)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r2 = "html."
                r1.append(r2)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r2 = stikerwap.appdys.config.DOM_EDROID     // Catch:{ Exception -> 0x00b2 }
                r1.append(r2)     // Catch:{ Exception -> 0x00b2 }
                r1.append(r5)     // Catch:{ Exception -> 0x00b2 }
                stikerwap.appdys.t_html r5 = stikerwap.appdys.t_html.this     // Catch:{ Exception -> 0x00b2 }
                stikerwap.appdys.config r5 = r5.globales     // Catch:{ Exception -> 0x00b2 }
                stikerwap.appdys.Seccion[] r5 = r5.secciones_a     // Catch:{ Exception -> 0x00b2 }
                stikerwap.appdys.t_html r2 = stikerwap.appdys.t_html.this     // Catch:{ Exception -> 0x00b2 }
                int r2 = r2.ind     // Catch:{ Exception -> 0x00b2 }
                r5 = r5[r2]     // Catch:{ Exception -> 0x00b2 }
                int r5 = r5.id     // Catch:{ Exception -> 0x00b2 }
                r1.append(r5)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r5 = "&fum="
                r1.append(r5)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r5 = r4.fum     // Catch:{ Exception -> 0x00b2 }
                r1.append(r5)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x00b2 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b2 }
                r1.<init>(r5)     // Catch:{ Exception -> 0x00b2 }
                r5 = 0
            L_0x003f:
                if (r0 == 0) goto L_0x004b
                java.util.Map r2 = r0.getHeaderFields()     // Catch:{ Exception -> 0x00b2 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x00b2 }
                if (r2 != 0) goto L_0x0078
            L_0x004b:
                r2 = 5
                if (r5 >= r2) goto L_0x0078
                int r5 = r5 + 1
                if (r0 == 0) goto L_0x0055
                r0.disconnect()     // Catch:{ Exception -> 0x0055 }
            L_0x0055:
                java.net.URLConnection r2 = r1.openConnection()     // Catch:{ Exception -> 0x00b2 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00b2 }
                r0 = 1
                r2.setDoInput(r0)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r2.setReadTimeout(r0)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r0 = "User-Agent"
                java.lang.String r3 = "Android Vinebre Software"
                r2.setRequestProperty(r0, r3)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r2.connect()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r0 = r2
                goto L_0x003f
            L_0x0073:
                r5 = move-exception
                r0 = r2
                goto L_0x00ba
            L_0x0076:
                r0 = r2
                goto L_0x00b2
            L_0x0078:
                java.io.InputStream r5 = r0.getInputStream()     // Catch:{ Exception -> 0x00b2 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b2 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b2 }
                r2.<init>(r5)     // Catch:{ Exception -> 0x00b2 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00b2 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2 }
                r5.<init>()     // Catch:{ Exception -> 0x00b2 }
            L_0x008b:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x00b2 }
                if (r2 == 0) goto L_0x00a6
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2 }
                r3.<init>()     // Catch:{ Exception -> 0x00b2 }
                r3.append(r2)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00b2 }
                r5.append(r2)     // Catch:{ Exception -> 0x00b2 }
                goto L_0x008b
            L_0x00a6:
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00b2 }
                if (r0 == 0) goto L_0x00af
                r0.disconnect()
            L_0x00af:
                return r5
            L_0x00b0:
                r5 = move-exception
                goto L_0x00ba
            L_0x00b2:
                java.lang.String r5 = ""
                if (r0 == 0) goto L_0x00b9
                r0.disconnect()
            L_0x00b9:
                return r5
            L_0x00ba:
                if (r0 == 0) goto L_0x00bf
                r0.disconnect()
            L_0x00bf:
                goto L_0x00c1
            L_0x00c0:
                throw r5
            L_0x00c1:
                goto L_0x00c0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_html.cargar_html.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            if (t_html.this.loader) {
                try {
                    t_html.this.findViewById(R.id.pb_url).setVisibility(0);
                } catch (Exception unused) {
                }
            }
            int indexOf = str.indexOf("[");
            if (indexOf != -1) {
                str2 = str.substring(indexOf + 1);
            } else {
                str2 = "";
            }
            String replace = str2.replace("]", "").replace("@MNQ@", "<");
            t_html.this.html = replace;
            if (!replace.equals("")) {
                t_html.this.globales.secciones_a[t_html.this.ind].html = replace;
                SharedPreferences.Editor edit = t_html.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                edit.putString(CmcdHeadersFactory.STREAMING_FORMAT_SS + t_html.this.globales.secciones_a[t_html.this.ind].id + "_html", replace);
                edit.commit();
            }
            t_html.this.iniciar((Bundle) null);
        }
    }

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.myWebView.saveState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.myWebView.restoreState(bundle);
        if (this.myWebView.copyBackForwardList().getCurrentIndex() == 0) {
            this.myWebView.loadDataWithBaseURL("http://localhost/", this.html.replace("@CCORCH@", "]"), "text/html", "utf-8", (String) null);
        }
    }

    public void onStop() {
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
        }
    }

    public void onPause() {
        Anuncios anuncios;
        Anuncios anuncios2;
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.pause();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.pause();
        }
        if (this.mCustomView != null) {
            this.mClient.onHideCustomView();
        }
        super.onPause();
        config.onPause_global(this);
        this.myWebView.onPause();
        if (this.finalizar || isFinishing()) {
            try {
                this.myWebView.loadData("", "text/html", "utf-8");
            } catch (Exception unused) {
            }
        }
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.resume();
        }
        WebView webView = this.myWebView;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void onDestroy() {
        Anuncios anuncios;
        Anuncios anuncios2;
        Anuncios anuncios3;
        if (!(this.globales.admob_pos == 0 || (anuncios3 = this.anun) == null || anuncios3.adView == null)) {
            this.anun.adView.destroy();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView_fb == null)) {
            this.anun.adView_fb.destroy();
        }
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.destroy();
        }
        if ((this.es_root && isFinishing()) || config.finalizar_app) {
            config.finalizar_app(this);
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = false;
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        ((LinearLayout) findViewById(R.id.ll_ad)).removeAllViews();
        Anuncios anuncios = this.anun;
        if (!(anuncios == null || anuncios.adView == null)) {
            try {
                this.anun.adView.destroy();
            } catch (Exception unused) {
            }
        }
        Anuncios anuncios2 = this.anun;
        if (!(anuncios2 == null || anuncios2.adView_fb == null)) {
            try {
                this.anun.adView_fb.destroy();
            } catch (Exception unused2) {
            }
        }
        Anuncios anuncios3 = this.anun;
        if (!(anuncios3 == null || anuncios3.wortiseBanner == null)) {
            try {
                this.anun.wortiseBanner.destroy();
            } catch (Exception unused3) {
            }
        }
        config config = this.globales;
        if (this.html.contains("youtube.com") || this.html.contains("youtu.be")) {
            z = true;
        }
        this.anun = config.mostrar_banner(this, z);
    }

    private void wv_set() {
        if (Build.VERSION.SDK_INT > 20) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.myWebView, true);
        }
    }

    public void adLoaded(String str, AppnextAdCreativeType appnextAdCreativeType) {
        this.dialog_cargando.cancel();
        this.mAd_appnext.showAd();
    }

    public void onAdClosed() {
        if (this.mAd_visto) {
            abrir_secc(this.v_abrir_secc);
        }
    }

    public void adError(String str) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }

    public void videoEnded() {
        this.mAd_visto = true;
        config.rew_visto(this);
    }

    private void establec_ralc(final Context context) {
        this.ralc = new RewardedAdLoadCallback() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                if (!t_html.this.globales.admob_rew_failed(context, t_html.this.mAd_appnext)) {
                    t_html.this.dialog_cargando.cancel();
                    t_html t_html = t_html.this;
                    t_html.abrir_secc(t_html.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_html.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_html.this.abrir_secc(t_html.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_html.this.mAd_visto) {
                            t_html.this.abrir_secc(t_html.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_html.this.mAd_visto = true;
                        config.rew_visto(context);
                    }
                });
            }
        };
    }

    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }

    public void onAdLoaded(Ad ad) {
        this.dialog_cargando.cancel();
        this.mAd_fb.show();
    }

    public void onRewardedVideoCompleted() {
        this.mAd_visto = true;
        config.rew_visto(this);
    }

    public void onRewardedVideoClosed() {
        if (this.mAd_visto) {
            abrir_secc(this.v_abrir_secc);
        }
    }

    public void onVideoCompleted() {
        this.mAd_visto = true;
        config.rew_visto(this);
    }

    public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        this.mAd_st.showAd("REWARDED VIDEO", new AdDisplayListener() {
            public void adClicked(com.startapp.sdk.adsbase.Ad ad) {
            }

            public void adDisplayed(com.startapp.sdk.adsbase.Ad ad) {
            }

            public void adNotDisplayed(com.startapp.sdk.adsbase.Ad ad) {
            }

            public void adHidden(com.startapp.sdk.adsbase.Ad ad) {
                if (t_html.this.mAd_visto) {
                    t_html t_html = t_html.this;
                    t_html.abrir_secc(t_html.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
