package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.mediarouter.app.MediaRouteButton;
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
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.images.WebImage;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class t_video_playerjs extends FragmentActivity_ext_class implements Activity_ext, View.OnKeyListener, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private int TV_MARGIN;
    private int TV_PADDING;
    private int WIDTH_IMGS;
    HashMap<String, String> acargar_m;
    AlertDialog.Builder adb;
    private int altura;
    Anuncios anun;
    boolean atras_pulsado = false;
    Bitmap bm_propia;
    String c1;
    boolean c1_esclaro;
    String c2;
    boolean c2_esclaro;
    boolean c_fondotxt_esclaro;
    Context c_princ = this;
    boolean cl_history = false;
    /* access modifiers changed from: private */
    public String codigo;
    boolean coments;
    boolean con_chat;
    String contra;
    boolean descargar;
    private int descr;
    /* access modifiers changed from: private */
    public String dia_act;
    private int dist;
    int dp10;
    int dp3;
    enviar env;
    boolean es_playlist;
    EditText et_contra;
    EditText et_usu;
    Bundle extras;
    private int fnac;
    private int fotos_chat;
    HashMap<String, Bitmap> fotos_m;
    /* access modifiers changed from: private */
    public int fotos_perfil;
    boolean galeria;
    config globales;
    HttpAuthHandler handler_glob;
    boolean hapassat_per_landscape = false;
    boolean hayfrasedeotrousu = false;
    int height_global;
    boolean history_cleared = false;
    String html;
    /* access modifiers changed from: private */
    public int idfrase_masantigua_glob;
    private int idsecc;
    /* access modifiers changed from: private */
    public int idtema;
    /* access modifiers changed from: private */
    public long idusu;
    /* access modifiers changed from: private */
    public String idusu_act;
    private long idusu_global;
    int ind;
    int ind_abrir_secc = -1;
    HashMap<String, String> intentados_m;
    int linksexternos = 0;
    LinearLayout llchat;
    boolean loader = true;
    boolean logineado_ok;
    boolean mAd_visto = false;
    /* access modifiers changed from: private */
    public CastSession mCastSession;
    private WebChromeClient mClient;
    /* access modifiers changed from: private */
    public LinearLayout mContentView;
    /* access modifiers changed from: private */
    public View mCustomView;
    /* access modifiers changed from: private */
    public WebChromeClient.CustomViewCallback mCustomViewCallback;
    ListView mDrawerList;
    /* access modifiers changed from: private */
    public SessionManager mSessionManager;
    private final SessionManagerListener mSessionManagerListener = new SessionManagerListenerImpl();
    /* access modifiers changed from: private */
    public FrameLayout mTargetView;
    int marge_mateix;
    WebView myWebView;
    /* access modifiers changed from: private */
    public int nfrases;
    obtener_foto o_f;
    OrientationEventListener orientationListener;
    File path;
    ProgressBar pb_enviando;
    boolean primer_load = true;
    boolean privados;
    float scale;
    Seccion seccion;
    SharedPreferences settings;
    private int sexo;
    List<String> spool = new ArrayList();
    String ua;
    String url_load;
    String usu;
    int width_ad;
    int width_frase;
    int width_global;
    int width_portrait;
    boolean zoom = false;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    private class SessionManagerListenerImpl implements SessionManagerListener {
        public void onSessionEnded(Session session, int i) {
        }

        public void onSessionEnding(Session session) {
        }

        public void onSessionResumeFailed(Session session, int i) {
        }

        public void onSessionResuming(Session session, String str) {
        }

        public void onSessionStartFailed(Session session, int i) {
        }

        public void onSessionStarting(Session session) {
        }

        public void onSessionSuspended(Session session, int i) {
        }

        private SessionManagerListenerImpl() {
        }

        public void onSessionStarted(Session session, String str) {
            String str2;
            t_video_playerjs.this.invalidateOptionsMenu();
            String str3 = t_video_playerjs.this.url_load;
            MediaMetadata mediaMetadata = new MediaMetadata(1);
            mediaMetadata.putString(MediaMetadata.KEY_TITLE, t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].titulo);
            if (!t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].ico_cargando && t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].ico != null) {
                if (t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].ico_id == 0) {
                    str2 = config.DOM_CDN + "/srv/imgs/seccs/" + t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].id + "_ico.png?v=" + t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].v_ico;
                } else {
                    str2 = config.DOM_CDN + "/android-app-creator/icos_secc/" + t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].ico_id + ".png";
                }
                mediaMetadata.addImage(new WebImage(Uri.parse(str2)));
            }
            MediaInfo build = new MediaInfo.Builder(str3).setStreamType(0).setContentType("video/*").setMetadata(mediaMetadata).build();
            try {
                t_video_playerjs t_video_playerjs = t_video_playerjs.this;
                t_video_playerjs.mCastSession = t_video_playerjs.mSessionManager.getCurrentCastSession();
                final RemoteMediaClient remoteMediaClient = t_video_playerjs.this.mCastSession.getRemoteMediaClient();
                remoteMediaClient.addListener(new RemoteMediaClient.Listener() {
                    public void onAdBreakStatusUpdated() {
                    }

                    public void onMetadataUpdated() {
                    }

                    public void onPreloadStatusUpdated() {
                    }

                    public void onQueueStatusUpdated() {
                    }

                    public void onSendingRemoteMediaRequest() {
                    }

                    public void onStatusUpdated() {
                        t_video_playerjs.this.startActivity(new Intent(t_video_playerjs.this, ExpandedControlsActivity.class));
                        remoteMediaClient.removeListener(this);
                    }
                });
                t_video_playerjs.this.myWebView.evaluateJavascript("player.api('pause');", (ValueCallback) null);
                remoteMediaClient.load(build, true);
            } catch (Exception unused) {
            }
        }

        public void onSessionResumed(Session session, boolean z) {
            t_video_playerjs.this.invalidateOptionsMenu();
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2 = bundle;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        setTheme(2131952120);
        establec_ralc(this);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        this.ind = extras2.getInt("ind");
        this.ua = this.extras.getString("ua");
        Seccion seccion2 = this.globales.secciones_a[this.ind];
        this.seccion = seccion2;
        this.es_playlist = false;
        boolean z = true;
        if (!seccion2.url.equals("")) {
            this.url_load = this.seccion.url;
        } else if (this.seccion.playlist != null) {
            this.es_playlist = true;
            this.url_load = this.seccion.playlist;
        } else {
            this.url_load = "";
        }
        this.cbtn = config.aplicar_color_dialog(this.seccion.c1, this.globales.c_icos);
        super.onCreate(bundle);
        setContentView((int) R.layout.t_video_playerjs);
        if (bundle2 == null) {
            Bundle bundle3 = this.extras;
            this.es_root = bundle3 != null && bundle3.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle2.containsKey("es_root") && bundle2.getBoolean("es_root", false);
        }
        incluir_menu_pre();
        this.globales.onCreate_global(this, true);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_video_playerjs.this.finalizar = false;
                t_video_playerjs.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_video_playerjs.this.buscador_on = false;
            }
        });
        this.settings = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.myWebView = (WebView) findViewById(R.id.webview);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width_portrait = displayMetrics.widthPixels;
        if (getResources().getConfiguration().orientation == 2) {
            this.width_portrait = displayMetrics.heightPixels;
        }
        this.orientationListener = new OrientationEventListener(this, 2) {
            public void onOrientationChanged(int i) {
                if ((i >= 60 && i <= 120) || (i >= 240 && i <= 300)) {
                    t_video_playerjs.this.hapassat_per_landscape = true;
                } else if (t_video_playerjs.this.hapassat_per_landscape) {
                    t_video_playerjs.this.orientationListener.disable();
                    t_video_playerjs.this.hapassat_per_landscape = false;
                    t_video_playerjs.this.setRequestedOrientation(-1);
                }
            }
        };
        this.linksexternos = 0;
        this.loader = false;
        this.zoom = false;
        this.descargar = true;
        this.anun = this.globales.mostrar_banner(this, this.url_load.contains("youtube.com") || this.url_load.contains("youtu.be"));
        config config2 = this.globales;
        config2.oncreate_popup(this, config2.ind_secc_sel_2, this.cbtn, bundle2);
        if (!this.es_playlist) {
            try {
                this.mSessionManager = CastContext.getSharedInstance(this).getSessionManager();
                CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), (MediaRouteButton) findViewById(R.id.vcv_img_cast));
            } catch (Exception unused) {
            }
        }
        if (!this.seccion.c1.equals("")) {
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#" + this.seccion.c1), Color.parseColor("#" + this.seccion.c2)}));
        }
        WebView webView = this.myWebView;
        AnonymousClass4 r10 = new WebChromeClient() {
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                t_video_playerjs.this.mCustomViewCallback = customViewCallback;
                t_video_playerjs.this.mTargetView.addView(view);
                t_video_playerjs.this.mCustomView = view;
                t_video_playerjs.this.mContentView.setVisibility(8);
                t_video_playerjs.this.mTargetView.setVisibility(0);
                t_video_playerjs.this.getWindow().getDecorView().setSystemUiVisibility(4);
                if (t_video_playerjs.this.getResources().getConfiguration().orientation == 1) {
                    t_video_playerjs.this.setRequestedOrientation(0);
                    t_video_playerjs.this.hapassat_per_landscape = false;
                    t_video_playerjs.this.orientationListener.enable();
                }
            }

            public void onHideCustomView() {
                t_video_playerjs.this.getWindow().getDecorView().setSystemUiVisibility(0);
                if (t_video_playerjs.this.mCustomView != null) {
                    t_video_playerjs.this.mCustomView.setVisibility(8);
                    t_video_playerjs.this.mTargetView.removeView(t_video_playerjs.this.mCustomView);
                    t_video_playerjs.this.mCustomView = null;
                    t_video_playerjs.this.mTargetView.setVisibility(8);
                    t_video_playerjs.this.mCustomViewCallback.onCustomViewHidden();
                    t_video_playerjs.this.mContentView.setVisibility(0);
                }
            }
        };
        this.mClient = r10;
        webView.setWebChromeClient(r10);
        wv_set();
        this.myWebView.getSettings().setBuiltInZoomControls(this.zoom);
        this.myWebView.getSettings().setSupportZoom(this.zoom);
        this.myWebView.getSettings().setDomStorageEnabled(true);
        this.myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
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
                    stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
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
                    stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
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
                    stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                    stikerwap.appdys.config r4 = r4.globales
                    stikerwap.appdys.t_video_playerjs r5 = stikerwap.appdys.t_video_playerjs.this
                    r4.fdescargar(r3, r6, r7, r5)
                L_0x0084:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_playerjs.AnonymousClass6.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
            }
        });
        this.myWebView.getSettings().setUseWideViewPort(true);
        this.myWebView.getSettings().setLoadWithOverviewMode(true);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_url);
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(progressBar, this.globales.c_icos);
        }
        this.myWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return true;
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                FileInputStream fileInputStream;
                if (!str.contains("playerjs.js")) {
                    return null;
                }
                try {
                    if (t_video_playerjs.this.globales.playerjs_v == 0) {
                        fileInputStream = t_video_playerjs.this.openFileInput("playerjs_def_config");
                    } else {
                        fileInputStream = t_video_playerjs.this.openFileInput("playerjs_config");
                    }
                    return new WebResourceResponse("text/javascript", "UTF-8", fileInputStream);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
                t_video_playerjs.this.handler_glob = httpAuthHandler;
                t_video_playerjs.this.adb = new AlertDialog.Builder(t_video_playerjs.this);
                t_video_playerjs.this.adb.setTitle(t_video_playerjs.this.getResources().getString(R.string.chat_acceso));
                View inflate = t_video_playerjs.this.getLayoutInflater().inflate(R.layout.usucontra, (ViewGroup) null);
                t_video_playerjs.this.et_usu = (EditText) inflate.findViewById(R.id.et_usu);
                t_video_playerjs.this.et_contra = (EditText) inflate.findViewById(R.id.et_contra);
                t_video_playerjs.this.adb.setView(inflate);
                t_video_playerjs.this.adb.setCancelable(true);
                t_video_playerjs.this.adb.setPositiveButton(t_video_playerjs.this.getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        t_video_playerjs.this.usu = t_video_playerjs.this.et_usu.getText().toString();
                        t_video_playerjs.this.contra = t_video_playerjs.this.et_contra.getText().toString();
                        t_video_playerjs.this.handler_glob.proceed(t_video_playerjs.this.usu, t_video_playerjs.this.contra);
                    }
                });
                t_video_playerjs.this.adb.setNegativeButton(t_video_playerjs.this.getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        t_video_playerjs.this.handler_glob.cancel();
                    }
                });
                t_video_playerjs.this.adb.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        t_video_playerjs.this.handler_glob.cancel();
                    }
                });
                t_video_playerjs.this.adb.create().show();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (!config.isNetworkAvailable(t_video_playerjs.this)) {
                    if (!t_video_playerjs.this.globales.wv_sinconex_txt.equals("")) {
                        String str3 = t_video_playerjs.this.globales.wv_sinconex_txt;
                        if (!str3.toLowerCase(Locale.getDefault()).contains("<html")) {
                            str3 = "<html><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body>" + str3 + "</body></html>";
                        }
                        t_video_playerjs.this.myWebView.loadData(str3, "text/html; charset=utf-8", "utf-8");
                    } else {
                        t_video_playerjs.this.myWebView.loadData("<html><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body>" + t_video_playerjs.this.getResources().getString(R.string.wv_sinconex) + "</body></html>", "text/html; charset=utf-8", "utf-8");
                    }
                    t_video_playerjs.this.myWebView.clearHistory();
                    t_video_playerjs.this.history_cleared = true;
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                boolean z;
                boolean z2;
                if (!t_video_playerjs.this.finalizar && !t_video_playerjs.this.isFinishing() && !t_video_playerjs.this.url_load.contains("youtube.com") && !t_video_playerjs.this.url_load.contains("youtu.be")) {
                    if (t_video_playerjs.this.primer_load) {
                        z = true;
                        z2 = t_video_playerjs.this.extras != null && t_video_playerjs.this.extras.containsKey("ad_entrar");
                        if (t_video_playerjs.this.extras == null || !t_video_playerjs.this.extras.containsKey("fb_entrar")) {
                            z = false;
                        }
                        t_video_playerjs.this.primer_load = false;
                    } else {
                        z2 = false;
                        z = false;
                    }
                    t_video_playerjs.this.globales.toca_int_2(t_video_playerjs.this, z2, z, false);
                }
                if (t_video_playerjs.this.loader) {
                    progressBar.setVisibility(0);
                }
            }

            public void onPageFinished(WebView webView, String str) {
                progressBar.setVisibility(8);
                if (t_video_playerjs.this.cl_history) {
                    t_video_playerjs.this.cl_history = false;
                    t_video_playerjs.this.myWebView.clearHistory();
                }
            }
        });
        this.myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        JavaScriptInterface javaScriptInterface = new JavaScriptInterface(this);
        this.myWebView.getSettings().setJavaScriptEnabled(true);
        this.myWebView.addJavascriptInterface(javaScriptInterface, "JSInterface");
        this.myWebView.getSettings().setCacheMode(-1);
        if (!config.isNetworkAvailable(this)) {
            this.myWebView.getSettings().setCacheMode(1);
        }
        if (this.ua.equals("")) {
            this.myWebView.getSettings().setUserAgentString(this.myWebView.getSettings().getUserAgentString() + " Vinebre");
        } else {
            this.myWebView.getSettings().setUserAgentString(this.ua);
        }
        if (bundle2 == null) {
            this.mContentView = (LinearLayout) findViewById(R.id.ll_princ);
            this.mTargetView = (FrameLayout) findViewById(R.id.target_view);
            SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            if ((this.globales.playerjs_v <= 0 || sharedPreferences.getInt("playerjs_v_act", 0) == this.globales.playerjs_v) && (this.globales.playerjs_v != 0 || sharedPreferences.getInt("playerjs_def_v_act", 0) == this.globales.playerjs_def_v)) {
                iniciar();
            } else {
                new cargar_playerjs().execute(new String[0]);
            }
        }
        if (this.extras.getBoolean("desde_chat", false)) {
            this.con_chat = false;
        } else {
            this.con_chat = this.globales.chatsecc_en_video;
        }
        this.c1 = this.globales.secciones_a[this.ind].c1;
        this.c2 = this.globales.secciones_a[this.ind].c2;
        if (this.con_chat) {
            this.logineado_ok = true;
            int i = this.globales.chatsecc_p_fnac;
            int i2 = this.globales.chatsecc_p_sexo;
            int i3 = this.globales.chatsecc_p_descr;
            this.fotos_perfil = this.globales.chatsecc_fotos_perfil;
            if (this.settings.getString("nick", "").equals("") || (this.globales.fb_modo == 3 && !this.settings.getBoolean("email_confirmado", false))) {
                this.logineado_ok = false;
            } else if ((this.fotos_perfil == 2 && !this.globales.getTempFile(this, 1).exists()) || ((i == 2 && (this.settings.getInt("fnac_d", 0) == 0 || this.settings.getInt("fnac_m", 0) == 0 || this.settings.getInt("fnac_a", 0) == 0)) || ((i2 == 2 && this.settings.getInt("sexo", 0) == 0) || (i3 == 2 && this.settings.getString("descr", "").equals(""))))) {
                this.logineado_ok = false;
            }
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            this.altura = point.y;
            this.c1_esclaro = config.esClaro("#" + this.globales.secciones_a[this.ind].c1);
            this.c2_esclaro = config.esClaro("#" + this.globales.secciones_a[this.ind].c2);
            if (this.globales.bubbles > 0) {
                this.c_fondotxt_esclaro = true;
                if (!this.globales.c_bubbles.equals("")) {
                    this.c_fondotxt_esclaro = config.esClaro("#" + this.globales.c_bubbles);
                }
            } else {
                this.c_fondotxt_esclaro = this.c1_esclaro;
            }
            try {
                this.idtema = this.globales.secciones_a[this.ind].temas_a[0].id;
            } catch (Exception unused2) {
                this.idtema = 0;
            }
            this.fotos_perfil = this.globales.chatsecc_fotos_perfil;
            this.privados = this.globales.chatsecc_privados;
            this.coments = this.globales.chatsecc_coments;
            this.galeria = this.globales.chatsecc_galeria;
            this.fnac = this.globales.chatsecc_p_fnac;
            this.sexo = this.globales.chatsecc_p_sexo;
            this.dist = this.globales.chatsecc_p_dist;
            this.descr = this.globales.chatsecc_p_descr;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            this.width_global = displayMetrics2.widthPixels;
            this.height_global = displayMetrics2.heightPixels;
            int i4 = this.width_global;
            if (getResources().getConfiguration().orientation == 2) {
                i4 = this.height_global;
            }
            double d = (double) (i4 / 2);
            Double.isNaN(d);
            this.width_frase = (int) (d * 1.1d);
            double d2 = (double) i4;
            Double.isNaN(d2);
            this.width_ad = (int) (d2 * 0.8d);
            if (this.fotos_perfil > 0) {
                int dp_to_px = config.dp_to_px(this, 50);
                this.width_frase -= dp_to_px;
                this.width_ad -= dp_to_px;
            }
            this.marge_mateix = config.dp_to_px(this, 4);
            if (this.globales.bubbles == 1) {
                this.marge_mateix = config.dp_to_px(this, 14);
            } else if (this.globales.bubbles == 2) {
                this.marge_mateix = config.dp_to_px(this, 5);
            } else if (this.globales.bubbles == 3) {
                this.marge_mateix = config.dp_to_px(this, 12);
            } else if (this.globales.bubbles == 4) {
                this.marge_mateix = config.dp_to_px(this, 4);
            }
            this.dp3 = config.dp_to_px(this, 3);
            this.dp10 = config.dp_to_px(this, 10);
            if (!this.globales.emojis) {
                findViewById(R.id.btnemotic).setVisibility(8);
            }
            this.WIDTH_IMGS = (int) ((getResources().getDisplayMetrics().density * 100.0f) + 0.5f);
            this.TV_PADDING = (int) ((getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
            this.TV_MARGIN = (int) ((getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
            this.path = getFilesDir();
            this.nfrases = 0;
            this.dia_act = "";
            this.idusu_act = "";
            this.hayfrasedeotrousu = false;
            SharedPreferences sharedPreferences2 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
            this.settings = sharedPreferences2;
            this.idusu = sharedPreferences2.getLong("idusu", 0);
            this.codigo = this.settings.getString("cod", "");
            this.llchat = (LinearLayout) findViewById(R.id.llchat);
            this.pb_enviando = (ProgressBar) findViewById(R.id.pb_chat_env_inv);
            if (!this.c1.equals("")) {
                if (Build.VERSION.SDK_INT > 20) {
                    config.edittext_color((EditText) findViewById(R.id.c_mensaje), Boolean.valueOf(!this.c1_esclaro), this.cbtn);
                } else {
                    ((EditText) findViewById(R.id.c_mensaje)).setTextColor(-1);
                }
                if (!this.c2_esclaro) {
                    ((ImageView) findViewById(R.id.btnemotic)).setImageDrawable(getResources().getDrawable(R.drawable.emoticono_sel_light));
                    this.pb_enviando = (ProgressBar) findViewById(R.id.pb_chat_env);
                }
                if (Build.VERSION.SDK_INT > 20) {
                    config.progress_color(this.pb_enviando, this.cbtn);
                }
                Drawable drawable = getResources().getDrawable(R.drawable.btn_enviar_2);
                if (!this.cbtn.equals("")) {
                    drawable.setColorFilter(Color.parseColor("#" + this.cbtn), PorterDuff.Mode.MULTIPLY);
                }
                ((ImageView) findViewById(R.id.btnenv)).setImageDrawable(drawable);
            }
            findViewById(R.id.btnemotic).setOnClickListener(this);
            findViewById(R.id.btnenv).setOnClickListener(this);
            findViewById(R.id.c_mensaje).setOnKeyListener(this);
            findViewById(R.id.rl_chat).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    t_video_playerjs.this.cerrar_chat();
                }
            });
            findViewById(R.id.btn_verchat).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!t_video_playerjs.this.logineado_ok) {
                        Intent intent = new Intent(t_video_playerjs.this, chat_perfil.class);
                        intent.putExtra("idsecc", t_video_playerjs.this.globales.secciones_a[t_video_playerjs.this.ind].id);
                        intent.putExtra("desde_video", true);
                        if (t_video_playerjs.this.es_root) {
                            intent.putExtra("es_root", t_video_playerjs.this.es_root);
                        }
                        t_video_playerjs.this.es_root = false;
                        t_video_playerjs.this.finalizar = true;
                        t_video_playerjs.this.startActivityForResult(intent, 0);
                    } else if (t_video_playerjs.this.findViewById(R.id.sv_chat).getVisibility() == 0) {
                        t_video_playerjs.this.cerrar_chat();
                    } else {
                        t_video_playerjs.this.findViewById(R.id.sv_chat).setVisibility(0);
                        if (!t_video_playerjs.this.globales.banners_enchats && t_video_playerjs.this.anun != null && t_video_playerjs.this.anun.adView != null) {
                            t_video_playerjs.this.ocultar_banner();
                        }
                    }
                }
            });
            findViewById(R.id.btn_verchat).setVisibility(0);
            this.fotos_m = new HashMap<>();
            this.acargar_m = new HashMap<>();
            this.intentados_m = new HashMap<>();
            this.bm_propia = null;
            try {
                if (this.c_fondotxt_esclaro) {
                    this.bm_propia = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto_light);
                } else {
                    this.bm_propia = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto);
                }
            } catch (OutOfMemoryError unused3) {
            }
            if (this.fotos_perfil > 0) {
                File tempFile = this.globales.getTempFile(this, 1);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(tempFile.getPath(), options);
                    int i5 = options.outWidth;
                    int i6 = options.outWidth;
                    int i7 = options.outHeight;
                    if (i6 > 75 || i7 > 100) {
                        z = false;
                    }
                    if (!z) {
                        int round = Math.round(((float) i6) / ((float) config.calculateNewWidth(i6, i7, 75, 100)));
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = round;
                        this.bm_propia = BitmapFactory.decodeFile(tempFile.getPath(), options2);
                    } else {
                        this.bm_propia = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(tempFile));
                    }
                } catch (Exception unused4) {
                }
            }
            this.idfrase_masantigua_glob = 0;
            if (this.logineado_ok) {
                new cargar_ultimas("0", "0", this.idfrase_masantigua_glob).execute(new String[0]);
            }
        }
    }

    public class JavaScriptInterface {
        private Activity activity;

        public JavaScriptInterface(Activity activity2) {
            this.activity = activity2;
        }

        @JavascriptInterface
        public void descarregar() {
            String str;
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(t_video_playerjs.this.url_load);
            if (fileExtensionFromUrl == null || fileExtensionFromUrl.equals("") || (str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.replace(".", ""))) == null || str.equals("")) {
                str = "video/*";
            }
            String lowerCase = config.removeAccents(t_video_playerjs.this.seccion.titulo).toLowerCase();
            try {
                lowerCase = URLUtil.guessFileName(t_video_playerjs.this.url_load, (String) null, str);
            } catch (Exception unused) {
            }
            t_video_playerjs.this.globales.fdescargar(t_video_playerjs.this.url_load, str, lowerCase, t_video_playerjs.this);
        }

        @JavascriptInterface
        public void f_chromecast() {
            new Handler(t_video_playerjs.this.c_princ.getMainLooper()).post(new Runnable() {
                public void run() {
                    ((MediaRouteButton) t_video_playerjs.this.findViewById(R.id.vcv_img_cast)).showDialog();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void iniciar() {
        FileInputStream fileInputStream;
        try {
            if (this.globales.playerjs_v == 0) {
                fileInputStream = openFileInput("playerjs_def_config");
            } else {
                fileInputStream = openFileInput("playerjs_config");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            do {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } while (new BufferedReader(inputStreamReader).readLine() != null);
            try {
                inputStreamReader.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            String str = "1";
            String str2 = this.seccion.stream ? str : "0";
            String str3 = "";
            String str4 = (this.globales.playerjs_v != 0 || !this.globales.video_cast || this.es_playlist) ? str3 : ",mostrar_chromecast:1";
            if (this.globales.playerjs_v == 0 && this.seccion.descargar && !this.es_playlist) {
                str3 = ",mostrar_download:1";
            }
            this.html = "<!doctype html><html style='width:100%;height:100%;'><head>";
            this.html += "<script src='http://localhost/playerjs.js' type='text/javascript'>";
            this.html += "</script></head><body style='background-color:#000000;margin:0;padding:0;width:100%;height:100%;'><div style='position: relative;height:100%;'><div id='player' style='margin: 0;position: absolute;top: 50%;-ms-transform: translateY(-50%);transform: translateY(-50%);width:100%;height:100%;'></div></div><script>";
            this.html += "var player = new Playerjs({id:'player',live:" + str2 + str4 + str3 + ",file:";
            if (this.es_playlist) {
                this.html += this.url_load.replace("@CCORCH@", "]");
            } else {
                this.html += "'" + this.url_load + "'";
            }
            this.html += "});";
            if (getResources().getConfiguration().orientation == 2) {
                str = "0";
            }
            this.html += "function PlayerjsEvents(event,id,data){   if(event=='download'){      window.JSInterface.descarregar();   }   else if(event=='init'){      f_estilo(" + str + ");   }};";
            this.html += "function ac_chromecast(){window.JSInterface.f_chromecast();};";
            this.html += "function f_estilo(modo){console.log('f_estilo modo:'+modo);if(modo==1){var h=Math.floor((9*" + this.width_portrait + ")/16);document.getElementById('player').style.width = '100%';document.getElementById('player').style.height = (h+'px');}else{document.getElementById('player').style.width = '100%';document.getElementById('player').style.height = '100%';}};";
            String str5 = this.html + "</script></body></html>";
            this.html = str5;
            this.myWebView.loadDataWithBaseURL("http://localhost/", str5, "text/html", "utf-8", (String) null);
        }
    }

    private class cargar_playerjs extends AsyncTask<String, Void, Byte> {
        private cargar_playerjs() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            t_video_playerjs.this.findViewById(R.id.pb_url).setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                stikerwap.appdys.t_video_playerjs r6 = stikerwap.appdys.t_video_playerjs.this
                stikerwap.appdys.config r6 = r6.globales
                int r6 = r6.playerjs_v
                if (r6 != 0) goto L_0x0025
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = stikerwap.appdys.config.DOM_CDN
                r6.append(r0)
                java.lang.String r0 = "/playerjs_def_config/c.txt?v="
                r6.append(r0)
                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                stikerwap.appdys.config r0 = r0.globales
                int r0 = r0.playerjs_def_v
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                goto L_0x0041
            L_0x0025:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = stikerwap.appdys.config.DOM_CDN
                r6.append(r0)
                java.lang.String r0 = "/playerjs_configs/c3008836.txt?v="
                r6.append(r0)
                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                stikerwap.appdys.config r0 = r0.globales
                int r0 = r0.playerjs_v
                r6.append(r0)
                java.lang.String r6 = r6.toString()
            L_0x0041:
                r0 = 0
                r1 = 1
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x004a }
                r2.<init>(r6)     // Catch:{ MalformedURLException -> 0x004a }
                r6 = 1
                goto L_0x0050
            L_0x004a:
                r6 = move-exception
                r6.printStackTrace()
                r2 = 0
                r6 = 0
            L_0x0050:
                if (r6 == 0) goto L_0x00a4
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x009f }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x009f }
                r2.setDoInput(r1)     // Catch:{ IOException -> 0x009f }
                r1 = 5000(0x1388, float:7.006E-42)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x009f }
                r1 = 7000(0x1b58, float:9.809E-42)
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x009f }
                r2.connect()     // Catch:{ IOException -> 0x009f }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x009f }
                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x009a }
                stikerwap.appdys.config r2 = r2.globales     // Catch:{ Exception -> 0x009a }
                int r2 = r2.playerjs_v     // Catch:{ Exception -> 0x009a }
                if (r2 != 0) goto L_0x007d
                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x009a }
                java.lang.String r3 = "playerjs_def_config"
                java.io.FileOutputStream r2 = r2.openFileOutput(r3, r0)     // Catch:{ Exception -> 0x009a }
                goto L_0x0085
            L_0x007d:
                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x009a }
                java.lang.String r3 = "playerjs_config"
                java.io.FileOutputStream r2 = r2.openFileOutput(r3, r0)     // Catch:{ Exception -> 0x009a }
            L_0x0085:
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x009a }
            L_0x0089:
                int r4 = r1.read(r3)     // Catch:{ Exception -> 0x009a }
                if (r4 <= 0) goto L_0x0093
                r2.write(r3, r0, r4)     // Catch:{ Exception -> 0x009a }
                goto L_0x0089
            L_0x0093:
                r2.close()     // Catch:{ Exception -> 0x009a }
                r1.close()     // Catch:{ Exception -> 0x009a }
                goto L_0x00a4
            L_0x009a:
                r6 = move-exception
                r6.printStackTrace()     // Catch:{ IOException -> 0x009f }
                goto L_0x00a3
            L_0x009f:
                r6 = move-exception
                r6.printStackTrace()
            L_0x00a3:
                r6 = 0
            L_0x00a4:
                if (r6 == 0) goto L_0x00ab
                java.lang.Byte r6 = java.lang.Byte.valueOf(r0)
                return r6
            L_0x00ab:
                r6 = -1
                java.lang.Byte r6 = java.lang.Byte.valueOf(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_playerjs.cargar_playerjs.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            t_video_playerjs.this.findViewById(R.id.pb_url).setVisibility(8);
            if (!(b.byteValue() != 0 || t_video_playerjs.this.globales == null || t_video_playerjs.this.globales.c1 == null)) {
                SharedPreferences.Editor edit = t_video_playerjs.this.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
                if (t_video_playerjs.this.globales.playerjs_v == 0) {
                    edit.putInt("playerjs_def_v_act", t_video_playerjs.this.globales.playerjs_def_v);
                } else {
                    edit.putInt("playerjs_v_act", t_video_playerjs.this.globales.playerjs_v);
                }
                edit.commit();
            }
            t_video_playerjs.this.iniciar();
        }
    }

    /* access modifiers changed from: private */
    public void ocultar_banner() {
        if (((LinearLayout) findViewById(R.id.ll_ad)).getChildCount() > 0) {
            findViewById(R.id.ll_ad).setVisibility(8);
        }
        View findViewWithTag = findViewById(R.id.ll_princ).findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER));
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void cerrar_chat() {
        Anuncios anuncios;
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((TextView) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
        } catch (Exception unused) {
        }
        findViewById(R.id.sv_chat).setVisibility(8);
        if (!this.globales.banners_enchats && (anuncios = this.anun) != null && anuncios.adView != null) {
            if (((LinearLayout) findViewById(R.id.ll_ad)).getChildCount() > 0) {
                findViewById(R.id.ll_ad).setVisibility(0);
            }
            View findViewWithTag = findViewById(R.id.ll_princ).findViewWithTag(Integer.valueOf(R.id.TAG_ESBANNER));
            if (findViewWithTag != null) {
                findViewWithTag.setVisibility(0);
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        f_enviar(true);
        return true;
    }

    private void f_enviar(boolean z) {
        String trim = ((TextView) findViewById(R.id.c_mensaje)).getText().toString().replace("@", "").trim();
        if (!trim.equals("")) {
            if (z && this.altura < 600) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((TextView) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
            }
            ((EditText) findViewById(R.id.c_mensaje)).setText("");
            SharedPreferences.Editor edit = this.settings.edit();
            edit.putString("f2_id", this.idusu + "");
            edit.putString("f2_frase", trim);
            edit.putString("f2_fcrea", new SimpleDateFormat("ddMMyyHHmm").format(new Date()));
            edit.putString("f2_b64", "");
            edit.putString("f2_idfrase", "0");
            edit.putString("f2_idtema", this.idtema + "");
            edit.putString("f2_vfoto", "0");
            edit.putBoolean("f2_ultimas", false);
            edit.putString("f2_ts", System.currentTimeMillis() + "");
            edit.commit();
            this.globales.toca_int_chat(this);
            config config = this.globales;
            SharedPreferences sharedPreferences = this.settings;
            config.toca_inchat(this, sharedPreferences, this.idtema + "");
            this.spool.add(trim);
            enviar enviar2 = this.env;
            if (enviar2 == null || enviar2.getStatus() != AsyncTask.Status.RUNNING) {
                enviar enviar3 = new enviar();
                this.env = enviar3;
                enviar3.execute(new String[0]);
            }
        }
    }

    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences.contains("f2_idfrase") && str.equals("f2_ts")) {
            SharedPreferences sharedPreferences2 = this.settings;
            if (!sharedPreferences2.contains("ban_" + sharedPreferences.getString("f2_id", ""))) {
                String string = sharedPreferences.getString("f2_idtema", "0");
                if (string.equals(this.idtema + "")) {
                    runOnUiThread(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:232:0x0760, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07f2;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:240:0x0786, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07c1;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:252:0x07bf, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07c1;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:253:0x07c1, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble4_flip;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:254:0x07c5, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble_flip;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:264:0x07f0, code lost:
                            if (r1.this$0.globales.bubbles == 4) goto L_0x07f2;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:265:0x07f2, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble4;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:266:0x07f6, code lost:
                            r6 = stikerwap.appdys.R.drawable.bubble;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0035, code lost:
                            if (r3.equals(stikerwap.appdys.t_video_playerjs.m1543$$Nest$fgetidusu_act(r1.this$0) + "") == false) goto L_0x0037;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0051, code lost:
                            if (r4.getString("f2_id", "").equals(r4.getString("f2_idusu_prev", "")) != false) goto L_0x0053;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0053, code lost:
                            r0 = true;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:140:0x04e8  */
                        /* JADX WARNING: Removed duplicated region for block: B:148:0x050e  */
                        /* JADX WARNING: Removed duplicated region for block: B:149:0x0525  */
                        /* JADX WARNING: Removed duplicated region for block: B:194:0x063d  */
                        /* JADX WARNING: Removed duplicated region for block: B:195:0x064e  */
                        /* JADX WARNING: Removed duplicated region for block: B:199:0x067a  */
                        /* JADX WARNING: Removed duplicated region for block: B:218:0x06fe  */
                        /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6  */
                        /* JADX WARNING: Removed duplicated region for block: B:270:0x081e  */
                        /* JADX WARNING: Removed duplicated region for block: B:277:0x084b  */
                        /* JADX WARNING: Removed duplicated region for block: B:290:0x08b3  */
                        /* JADX WARNING: Removed duplicated region for block: B:294:0x08cf  */
                        /* JADX WARNING: Removed duplicated region for block: B:299:0x0900  */
                        /* JADX WARNING: Removed duplicated region for block: B:300:0x0908  */
                        /* JADX WARNING: Removed duplicated region for block: B:305:0x0936  */
                        /* JADX WARNING: Removed duplicated region for block: B:306:0x0945  */
                        /* JADX WARNING: Removed duplicated region for block: B:311:0x0979  */
                        /* JADX WARNING: Removed duplicated region for block: B:313:? A[RETURN, SYNTHETIC] */
                        /* JADX WARNING: Removed duplicated region for block: B:32:0x0103  */
                        /* JADX WARNING: Removed duplicated region for block: B:33:0x0147  */
                        /* JADX WARNING: Removed duplicated region for block: B:50:0x01de  */
                        /* JADX WARNING: Removed duplicated region for block: B:56:0x01fe  */
                        /* JADX WARNING: Removed duplicated region for block: B:64:0x0289  */
                        /* JADX WARNING: Removed duplicated region for block: B:67:0x02ba  */
                        /* JADX WARNING: Removed duplicated region for block: B:77:0x02f5  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r24 = this;
                                r1 = r24
                                r2 = 0
                                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r4 = "f2_ultimas"
                                boolean r3 = r3.getBoolean(r4, r2)
                                r5 = 1
                                java.lang.String r6 = "f2_id"
                                java.lang.String r7 = ""
                                if (r3 != 0) goto L_0x0037
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r3 = r3.getString(r6, r7)
                                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                                r8.<init>()
                                stikerwap.appdys.t_video_playerjs r9 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r9 = r9.idusu_act
                                r8.append(r9)
                                r8.append(r7)
                                java.lang.String r8 = r8.toString()
                                boolean r3 = r3.equals(r8)
                                if (r3 != 0) goto L_0x0053
                            L_0x0037:
                                android.content.SharedPreferences r3 = r4
                                boolean r3 = r3.getBoolean(r4, r2)
                                if (r3 == 0) goto L_0x0057
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r3 = r3.getString(r6, r7)
                                android.content.SharedPreferences r8 = r4
                                java.lang.String r9 = "f2_idusu_prev"
                                java.lang.String r8 = r8.getString(r9, r7)
                                boolean r3 = r3.equals(r8)
                                if (r3 == 0) goto L_0x0057
                            L_0x0053:
                                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
                            L_0x0057:
                                android.content.SharedPreferences r3 = r4
                                boolean r3 = r3.getBoolean(r4, r2)
                                if (r3 != 0) goto L_0x006a
                                stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
                                android.content.SharedPreferences r8 = r4
                                java.lang.String r8 = r8.getString(r6, r7)
                                r3.idusu_act = r8
                            L_0x006a:
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r3 = r3.getString(r6, r7)
                                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                                r8.<init>()
                                stikerwap.appdys.t_video_playerjs r9 = stikerwap.appdys.t_video_playerjs.this
                                long r9 = r9.idusu
                                r8.append(r9)
                                r8.append(r7)
                                java.lang.String r8 = r8.toString()
                                boolean r3 = r3.equals(r8)
                                if (r3 == 0) goto L_0x00a7
                                android.content.SharedPreferences r3 = r4
                                boolean r3 = r3.getBoolean(r4, r2)
                                if (r3 == 0) goto L_0x009e
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r8 = "f2_mateixusu_hastafinal"
                                boolean r3 = r3.getBoolean(r8, r2)
                                if (r3 == 0) goto L_0x00a5
                                goto L_0x00a4
                            L_0x009e:
                                stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
                                boolean r3 = r3.hayfrasedeotrousu
                                if (r3 != 0) goto L_0x00a5
                            L_0x00a4:
                                goto L_0x00ab
                            L_0x00a5:
                                r3 = 1
                                goto L_0x00ac
                            L_0x00a7:
                                stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
                                r3.hayfrasedeotrousu = r5
                            L_0x00ab:
                                r3 = 0
                            L_0x00ac:
                                android.content.SharedPreferences r8 = r4
                                boolean r8 = r8.getBoolean(r4, r2)
                                java.lang.String r9 = "f2_fcrea"
                                if (r8 == 0) goto L_0x00dd
                                android.content.SharedPreferences r8 = r4
                                java.lang.String r8 = r8.getString(r9, r7)
                                boolean r10 = r8.equals(r7)
                                if (r10 != 0) goto L_0x00dd
                                r10 = 6
                                java.lang.String r8 = r8.substring(r2, r10)
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r10 = r10.dia_act
                                boolean r10 = r8.equals(r10)
                                if (r10 != 0) goto L_0x00dd
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                r10.mostrar_fecha()
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                r10.dia_act = r8
                            L_0x00dd:
                                stikerwap.appdys.t_video_playerjs r8 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r10 = "layout_inflater"
                                java.lang.Object r8 = r8.getSystemService(r10)
                                android.view.LayoutInflater r8 = (android.view.LayoutInflater) r8
                                r10 = 2131558529(0x7f0d0081, float:1.8742376E38)
                                r11 = 0
                                android.view.View r8 = r8.inflate(r10, r11)
                                android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
                                boolean r10 = r0.booleanValue()
                                r12 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                r13 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                r14 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                r15 = 8
                                r11 = 4
                                if (r10 == 0) goto L_0x0147
                                android.view.View r10 = r8.findViewById(r13)
                                r10.setVisibility(r11)
                                android.view.View r10 = r8.findViewById(r12)
                                android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
                                r10.height = r5
                                r10 = 2131362421(0x7f0a0275, float:1.8344622E38)
                                android.view.View r10 = r8.findViewById(r10)
                                android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
                                r10.height = r5
                                android.widget.LinearLayout$LayoutParams r10 = new android.widget.LinearLayout$LayoutParams
                                r12 = -2
                                r11 = -2
                                r10.<init>(r12, r11)
                                stikerwap.appdys.t_video_playerjs r11 = stikerwap.appdys.t_video_playerjs.this
                                int r11 = r11.marge_mateix
                                stikerwap.appdys.t_video_playerjs r12 = stikerwap.appdys.t_video_playerjs.this
                                int r12 = r12.marge_mateix
                                r10.setMargins(r11, r2, r12, r2)
                                android.view.View r11 = r8.findViewById(r14)
                                android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
                                r11.setLayoutParams(r10)
                                r10 = 2131362603(0x7f0a032b, float:1.8344991E38)
                                android.view.View r10 = r8.findViewById(r10)
                                r10.setVisibility(r15)
                                goto L_0x01be
                            L_0x0147:
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                int r10 = r10.dp3
                                stikerwap.appdys.t_video_playerjs r11 = stikerwap.appdys.t_video_playerjs.this
                                int r11 = r11.dp10
                                stikerwap.appdys.t_video_playerjs r12 = stikerwap.appdys.t_video_playerjs.this
                                int r12 = r12.dp3
                                r8.setPadding(r10, r11, r12, r2)
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r10 = r10.globales
                                boolean r10 = r10.spam_mostrar
                                if (r10 == 0) goto L_0x01be
                                android.content.SharedPreferences r10 = r4
                                java.lang.String r10 = r10.getString(r6, r7)
                                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                                r11.<init>()
                                stikerwap.appdys.t_video_playerjs r12 = stikerwap.appdys.t_video_playerjs.this
                                long r13 = r12.idusu
                                r11.append(r13)
                                r11.append(r7)
                                java.lang.String r11 = r11.toString()
                                boolean r10 = r10.equals(r11)
                                if (r10 != 0) goto L_0x01be
                                boolean r10 = r0.booleanValue()
                                if (r10 != 0) goto L_0x01be
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                boolean r10 = r10.c_fondotxt_esclaro
                                r11 = 2131362422(0x7f0a0276, float:1.8344624E38)
                                if (r10 == 0) goto L_0x019b
                                android.view.View r10 = r8.findViewById(r11)
                                android.widget.ImageView r10 = (android.widget.ImageView) r10
                                int r12 = stikerwap.appdys.config.NEGRO
                                android.graphics.PorterDuff$Mode r13 = android.graphics.PorterDuff.Mode.MULTIPLY
                                r10.setColorFilter(r12, r13)
                            L_0x019b:
                                android.view.View r10 = r8.findViewById(r11)
                                r10.setVisibility(r2)
                                android.view.View r10 = r8.findViewById(r11)
                                android.content.SharedPreferences r12 = r4
                                java.lang.String r12 = r12.getString(r6, r7)
                                r13 = 2131362376(0x7f0a0248, float:1.834453E38)
                                r10.setTag(r13, r12)
                                android.view.View r10 = r8.findViewById(r11)
                                stikerwap.appdys.t_video_playerjs$10$1 r11 = new stikerwap.appdys.t_video_playerjs$10$1
                                r11.<init>()
                                r10.setOnClickListener(r11)
                            L_0x01be:
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                int r10 = r10.width_frase
                                if (r10 == 0) goto L_0x01d8
                                boolean r10 = r0.booleanValue()
                                if (r10 != 0) goto L_0x01d8
                                r10 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                android.view.View r11 = r8.findViewById(r10)
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                int r10 = r10.width_frase
                                r11.setMinimumWidth(r10)
                            L_0x01d8:
                                r10 = 2131034118(0x7f050006, float:1.7678745E38)
                                r11 = 3
                                if (r3 == 0) goto L_0x01f8
                                stikerwap.appdys.t_video_playerjs r12 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r12 = r12.getResources()
                                boolean r12 = r12.getBoolean(r10)
                                if (r12 == 0) goto L_0x01f1
                                r8.setGravity(r11)
                                r8.setLayoutDirection(r2)
                                goto L_0x01f8
                            L_0x01f1:
                                r12 = 5
                                r8.setGravity(r12)
                                r8.setLayoutDirection(r5)
                            L_0x01f8:
                                int r12 = android.os.Build.VERSION.SDK_INT
                                r13 = 20
                                if (r12 <= r13) goto L_0x023e
                                r12 = 2131363001(0x7f0a04b9, float:1.8345798E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_playerjs r13 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                                r12 = 2131363004(0x7f0a04bc, float:1.8345805E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_playerjs r13 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                                r12 = 2131363002(0x7f0a04ba, float:1.83458E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_playerjs r13 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                                r12 = 2131363003(0x7f0a04bb, float:1.8345803E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
                                stikerwap.appdys.t_video_playerjs r13 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r13 = r13.cbtn
                                stikerwap.appdys.config.progress_color(r12, r13)
                            L_0x023e:
                                r12 = 2131362421(0x7f0a0275, float:1.8344622E38)
                                android.view.View r12 = r8.findViewById(r12)
                                android.widget.ImageView r12 = (android.widget.ImageView) r12
                                r13 = 2131363453(0x7f0a067d, float:1.8346715E38)
                                android.view.View r13 = r8.findViewById(r13)
                                android.widget.TextView r13 = (android.widget.TextView) r13
                                r14 = 2131363417(0x7f0a0659, float:1.8346642E38)
                                android.view.View r14 = r8.findViewById(r14)
                                android.widget.TextView r14 = (android.widget.TextView) r14
                                java.lang.String r16 = "#C0FFFFFF"
                                int r16 = android.graphics.Color.parseColor(r16)
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r15 = r15.c1
                                java.lang.String r11 = "FFFFFFFF"
                                boolean r11 = r15.equals(r11)
                                if (r11 == 0) goto L_0x027d
                                stikerwap.appdys.t_video_playerjs r11 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.String r11 = r11.c2
                                java.lang.String r15 = "FFFFFFFF"
                                boolean r11 = r11.equals(r15)
                                if (r11 == 0) goto L_0x027d
                                java.lang.String r11 = "#C0EEEEEE"
                                int r16 = android.graphics.Color.parseColor(r11)
                            L_0x027d:
                                java.lang.String r11 = "#555555"
                                int r11 = android.graphics.Color.parseColor(r11)
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                boolean r15 = r15.c_fondotxt_esclaro
                                if (r15 != 0) goto L_0x028f
                                java.lang.String r11 = "#999999"
                                int r11 = android.graphics.Color.parseColor(r11)
                            L_0x028f:
                                r13.setTextColor(r11)
                                r14.setTextColor(r11)
                                android.content.SharedPreferences r11 = r4
                                java.lang.String r11 = r11.getString(r6, r7)
                                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                                r15.<init>()
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                r18 = r6
                                long r5 = r10.idusu
                                r15.append(r5)
                                r15.append(r7)
                                java.lang.String r5 = r15.toString()
                                boolean r5 = r11.equals(r5)
                                java.lang.String r11 = "1"
                                if (r5 == 0) goto L_0x02f5
                                stikerwap.appdys.t_video_playerjs r5 = stikerwap.appdys.t_video_playerjs.this
                                boolean r5 = r5.c_fondotxt_esclaro
                                if (r5 != 0) goto L_0x02c2
                                r5 = -1
                                goto L_0x02c4
                            L_0x02c2:
                                r5 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                            L_0x02c4:
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r15 = r15.getResources()
                                r6 = 2131886857(0x7f120309, float:1.9408305E38)
                                java.lang.String r6 = r15.getString(r6)
                                r13.setText(r6)
                                stikerwap.appdys.t_video_playerjs r6 = stikerwap.appdys.t_video_playerjs.this
                                int r6 = r6.fotos_perfil
                                if (r6 <= 0) goto L_0x02ed
                                stikerwap.appdys.t_video_playerjs r6 = stikerwap.appdys.t_video_playerjs.this
                                android.graphics.Bitmap r6 = r6.bm_propia
                                if (r6 == 0) goto L_0x02ed
                                stikerwap.appdys.t_video_playerjs r6 = stikerwap.appdys.t_video_playerjs.this
                                android.graphics.Bitmap r6 = r6.bm_propia
                                android.graphics.Bitmap r6 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r6, r2)
                                r12.setImageBitmap(r6)
                            L_0x02ed:
                                r20 = r4
                                r22 = r11
                                r21 = r18
                                goto L_0x06f5
                            L_0x02f5:
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r6 = "f2_nombre"
                                java.lang.String r5 = r5.getString(r6, r7)
                                java.lang.String r5 = r5.trim()
                                r13.setText(r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r6 = "0"
                                r13 = r18
                                java.lang.String r5 = r5.getString(r13, r6)
                                r15 = 2131362376(0x7f0a0248, float:1.834453E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_privados"
                                java.lang.String r5 = r5.getString(r15, r11)
                                r15 = 2131362378(0x7f0a024a, float:1.8344535E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_nombre"
                                java.lang.String r5 = r5.getString(r15, r7)
                                r15 = 2131362379(0x7f0a024b, float:1.8344537E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_coments"
                                java.lang.String r5 = r5.getString(r15, r11)
                                r15 = 2131362380(0x7f0a024c, float:1.8344539E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_fnac_d"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362381(0x7f0a024d, float:1.834454E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_fnac_m"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362382(0x7f0a024e, float:1.8344543E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_fnac_a"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362383(0x7f0a024f, float:1.8344545E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_sexo"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362384(0x7f0a0250, float:1.8344547E38)
                                r8.setTag(r15, r5)
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r15 = "f2_vfoto"
                                java.lang.String r5 = r5.getString(r15, r6)
                                r15 = 2131362385(0x7f0a0251, float:1.834455E38)
                                r8.setTag(r15, r5)
                                stikerwap.appdys.t_video_playerjs r5 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r5 = r5.globales
                                boolean r5 = r5.chatsecc_acceso_a_perfil
                                if (r5 == 0) goto L_0x03b0
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r5 = r5.getString(r13, r7)
                                boolean r5 = r5.equals(r11)
                                if (r5 != 0) goto L_0x03b0
                                r5 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                android.view.View r15 = r8.findViewById(r5)
                                stikerwap.appdys.t_video_playerjs r5 = stikerwap.appdys.t_video_playerjs.this
                                r15.setOnClickListener(r5)
                                r5 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                android.view.View r15 = r8.findViewById(r5)
                                stikerwap.appdys.t_video_playerjs r5 = stikerwap.appdys.t_video_playerjs.this
                                r15.setOnClickListener(r5)
                            L_0x03b0:
                                android.content.SharedPreferences r5 = r4
                                java.lang.String r5 = r5.getString(r13, r7)
                                int r15 = r5.length()
                                r17 = 1
                                int r15 = r15 + -1
                                int r10 = r5.length()
                                java.lang.String r10 = r5.substring(r15, r10)
                                boolean r15 = r5.equals(r11)
                                if (r15 == 0) goto L_0x03cd
                                r10 = r6
                            L_0x03cd:
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                boolean r15 = r15.c_fondotxt_esclaro
                                if (r15 == 0) goto L_0x046a
                                boolean r15 = r10.equals(r6)
                                if (r15 != 0) goto L_0x045c
                                java.lang.String r15 = "5"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x03e3
                                goto L_0x045c
                            L_0x03e3:
                                boolean r15 = r10.equals(r11)
                                if (r15 != 0) goto L_0x044e
                                java.lang.String r15 = "6"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x03f2
                                goto L_0x044e
                            L_0x03f2:
                                java.lang.String r15 = "2"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x0440
                                java.lang.String r15 = "7"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0403
                                goto L_0x0440
                            L_0x0403:
                                java.lang.String r15 = "3"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x0432
                                java.lang.String r15 = "8"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0414
                                goto L_0x0432
                            L_0x0414:
                                java.lang.String r15 = "4"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x0424
                                java.lang.String r15 = "9"
                                boolean r10 = r10.equals(r15)
                                if (r10 == 0) goto L_0x04bb
                            L_0x0424:
                                java.lang.String r10 = "#FFCC0000"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0FFDFDF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x0432:
                                java.lang.String r10 = "#FF9E5400"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0FFF0DF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x0440:
                                java.lang.String r10 = "#FF3D5C00"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0F4FFDF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x044e:
                                java.lang.String r10 = "#FF9933CC"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0F2E6F9"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x045c:
                                java.lang.String r10 = "#FF00698C"
                                int r10 = android.graphics.Color.parseColor(r10)
                                java.lang.String r15 = "#C0DFF8FF"
                                int r16 = android.graphics.Color.parseColor(r15)
                                goto L_0x04e0
                            L_0x046a:
                                boolean r15 = r10.equals(r6)
                                if (r15 != 0) goto L_0x04da
                                java.lang.String r15 = "5"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0479
                                goto L_0x04da
                            L_0x0479:
                                boolean r15 = r10.equals(r11)
                                if (r15 != 0) goto L_0x04d3
                                java.lang.String r15 = "6"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0488
                                goto L_0x04d3
                            L_0x0488:
                                java.lang.String r15 = "2"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x04cc
                                java.lang.String r15 = "7"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x0499
                                goto L_0x04cc
                            L_0x0499:
                                java.lang.String r15 = "3"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x04c5
                                java.lang.String r15 = "8"
                                boolean r15 = r10.equals(r15)
                                if (r15 == 0) goto L_0x04aa
                                goto L_0x04c5
                            L_0x04aa:
                                java.lang.String r15 = "4"
                                boolean r15 = r10.equals(r15)
                                if (r15 != 0) goto L_0x04be
                                java.lang.String r15 = "9"
                                boolean r10 = r10.equals(r15)
                                if (r10 == 0) goto L_0x04bb
                                goto L_0x04be
                            L_0x04bb:
                                r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                goto L_0x04e0
                            L_0x04be:
                                java.lang.String r10 = "#FF33FFFF"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04c5:
                                java.lang.String r10 = "#FF87BFFF"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04cc:
                                java.lang.String r10 = "#FFC9ADFF"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04d3:
                                java.lang.String r10 = "#FF66CC33"
                                int r10 = android.graphics.Color.parseColor(r10)
                                goto L_0x04e0
                            L_0x04da:
                                java.lang.String r10 = "#FFFF6633"
                                int r10 = android.graphics.Color.parseColor(r10)
                            L_0x04e0:
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r15 = r15.globales
                                boolean r15 = r15.c_txt_chats
                                if (r15 != 0) goto L_0x04f2
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this
                                boolean r10 = r10.c_fondotxt_esclaro
                                if (r10 == 0) goto L_0x04f1
                                r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                goto L_0x04f2
                            L_0x04f1:
                                r10 = -1
                            L_0x04f2:
                                android.content.SharedPreferences r15 = r4
                                java.lang.String r2 = "f2_vfoto"
                                java.lang.String r2 = r15.getString(r2, r6)
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                int r15 = r15.fotos_perfil
                                if (r15 <= 0) goto L_0x0525
                                android.content.SharedPreferences r15 = r4
                                java.lang.String r15 = r15.getString(r13, r7)
                                boolean r15 = r15.equals(r11)
                                if (r15 == 0) goto L_0x0525
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r2 = r2.getResources()
                                r5 = 2131230922(0x7f0800ca, float:1.807791E38)
                                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r5)
                                r5 = 0
                                android.graphics.Bitmap r2 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r2, r5)
                                r12.setImageBitmap(r2)
                                goto L_0x06eb
                            L_0x0525:
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                int r15 = r15.fotos_perfil
                                if (r15 <= 0) goto L_0x0560
                                boolean r15 = r2.equals(r6)
                                if (r15 == 0) goto L_0x0560
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                boolean r2 = r2.c_fondotxt_esclaro
                                if (r2 == 0) goto L_0x054a
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r2 = r2.getResources()
                                r5 = 2131231691(0x7f0803cb, float:1.807947E38)
                                android.graphics.drawable.Drawable r2 = r2.getDrawable(r5)
                                r12.setImageDrawable(r2)
                                goto L_0x055a
                            L_0x054a:
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r2 = r2.getResources()
                                r5 = 2131231689(0x7f0803c9, float:1.8079466E38)
                                android.graphics.drawable.Drawable r2 = r2.getDrawable(r5)
                                r12.setImageDrawable(r2)
                            L_0x055a:
                                r2 = 0
                                r12.setVisibility(r2)
                                goto L_0x06eb
                            L_0x0560:
                                stikerwap.appdys.t_video_playerjs r15 = stikerwap.appdys.t_video_playerjs.this
                                int r15 = r15.fotos_perfil
                                if (r15 <= 0) goto L_0x06eb
                                boolean r6 = r2.equals(r6)
                                if (r6 != 0) goto L_0x06eb
                                stikerwap.appdys.t_video_playerjs r6 = stikerwap.appdys.t_video_playerjs.this
                                java.util.HashMap<java.lang.String, android.graphics.Bitmap> r6 = r6.fotos_m
                                java.lang.Object r6 = r6.get(r5)
                                android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
                                java.lang.String r15 = "fperfil_"
                                if (r6 == 0) goto L_0x058e
                                r19 = r10
                                r10 = 0
                                android.graphics.Bitmap r6 = stikerwap.appdys.config.getCircularBitmapWithWhiteBorder(r6, r10)
                                r12.setImageBitmap(r6)
                                r20 = r4
                                r22 = r11
                                r21 = r13
                                goto L_0x0662
                            L_0x058e:
                                r19 = r10
                                java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0630 }
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x0630 }
                                java.io.File r10 = r10.path     // Catch:{ Exception -> 0x0630 }
                                r20 = r4
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0632 }
                                r4.<init>(r15)     // Catch:{ Exception -> 0x0632 }
                                r4.append(r5)     // Catch:{ Exception -> 0x0632 }
                                r21 = r13
                                java.lang.String r13 = ".jpg"
                                r4.append(r13)     // Catch:{ Exception -> 0x062d }
                                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x062d }
                                r6.<init>(r10, r4)     // Catch:{ Exception -> 0x062d }
                                android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x062d }
                                r4.<init>()     // Catch:{ Exception -> 0x062d }
                                r10 = 1
                                r4.inJustDecodeBounds = r10     // Catch:{ Exception -> 0x062d }
                                java.lang.String r10 = r6.getPath()     // Catch:{ Exception -> 0x062d }
                                android.graphics.BitmapFactory.decodeFile(r10, r4)     // Catch:{ Exception -> 0x062d }
                                int r10 = r4.outWidth     // Catch:{ Exception -> 0x062d }
                                stikerwap.appdys.t_video_playerjs r10 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x062d }
                                android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x062d }
                                android.util.DisplayMetrics r10 = r10.getDisplayMetrics()     // Catch:{ Exception -> 0x062d }
                                float r10 = r10.density     // Catch:{ Exception -> 0x062d }
                                r13 = 1111490560(0x42400000, float:48.0)
                                float r10 = r10 * r13
                                r13 = 1056964608(0x3f000000, float:0.5)
                                float r10 = r10 + r13
                                int r10 = (int) r10     // Catch:{ Exception -> 0x062d }
                                stikerwap.appdys.t_video_playerjs r13 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x062d }
                                android.content.res.Resources r13 = r13.getResources()     // Catch:{ Exception -> 0x062d }
                                android.util.DisplayMetrics r13 = r13.getDisplayMetrics()     // Catch:{ Exception -> 0x062d }
                                float r13 = r13.density     // Catch:{ Exception -> 0x062d }
                                r22 = 1111490560(0x42400000, float:48.0)
                                float r13 = r13 * r22
                                r22 = 1056964608(0x3f000000, float:0.5)
                                float r13 = r13 + r22
                                int r13 = (int) r13
                                r22 = r11
                                int r11 = r4.outWidth     // Catch:{ Exception -> 0x0636 }
                                int r4 = r4.outHeight     // Catch:{ Exception -> 0x0636 }
                                if (r11 > r10) goto L_0x05f5
                                if (r4 > r13) goto L_0x05f5
                                r23 = 1
                                goto L_0x05f7
                            L_0x05f5:
                                r23 = 0
                            L_0x05f7:
                                if (r23 != 0) goto L_0x0614
                                int r4 = stikerwap.appdys.config.calculateNewWidth(r11, r4, r10, r13)     // Catch:{ Exception -> 0x0636 }
                                float r10 = (float) r11     // Catch:{ Exception -> 0x0636 }
                                float r4 = (float) r4     // Catch:{ Exception -> 0x0636 }
                                float r10 = r10 / r4
                                int r4 = java.lang.Math.round(r10)     // Catch:{ Exception -> 0x0636 }
                                android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0636 }
                                r10.<init>()     // Catch:{ Exception -> 0x0636 }
                                r10.inSampleSize = r4     // Catch:{ Exception -> 0x0636 }
                                java.lang.String r4 = r6.getPath()     // Catch:{ Exception -> 0x0636 }
                                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeFile(r4, r10)     // Catch:{ Exception -> 0x0636 }
                                goto L_0x0622
                            L_0x0614:
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x0636 }
                                android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0636 }
                                android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ Exception -> 0x0636 }
                                android.graphics.Bitmap r4 = android.provider.MediaStore.Images.Media.getBitmap(r4, r6)     // Catch:{ Exception -> 0x0636 }
                            L_0x0622:
                                r12.setImageBitmap(r4)     // Catch:{ Exception -> 0x0636 }
                                stikerwap.appdys.t_video_playerjs r6 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x0636 }
                                java.util.HashMap<java.lang.String, android.graphics.Bitmap> r6 = r6.fotos_m     // Catch:{ Exception -> 0x0636 }
                                r6.put(r5, r4)     // Catch:{ Exception -> 0x0636 }
                                goto L_0x0662
                            L_0x062d:
                                r22 = r11
                                goto L_0x0636
                            L_0x0630:
                                r20 = r4
                            L_0x0632:
                                r22 = r11
                                r21 = r13
                            L_0x0636:
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                boolean r4 = r4.c_fondotxt_esclaro
                                if (r4 == 0) goto L_0x064e
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r4 = r4.getResources()
                                r6 = 2131231691(0x7f0803cb, float:1.807947E38)
                                android.graphics.drawable.Drawable r4 = r4.getDrawable(r6)
                                r12.setImageDrawable(r4)
                                goto L_0x065e
                            L_0x064e:
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r4 = r4.getResources()
                                r6 = 2131231689(0x7f0803c9, float:1.8079466E38)
                                android.graphics.drawable.Drawable r4 = r4.getDrawable(r6)
                                r12.setImageDrawable(r4)
                            L_0x065e:
                                r4 = 0
                                r12.setVisibility(r4)
                            L_0x0662:
                                android.content.SharedPreferences r4 = r4
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                r6.<init>(r15)
                                r6.append(r5)
                                java.lang.String r6 = r6.toString()
                                java.lang.String r4 = r4.getString(r6, r7)
                                boolean r4 = r4.equals(r2)
                                if (r4 != 0) goto L_0x06f3
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                boolean r4 = r4.c1_esclaro
                                if (r4 == 0) goto L_0x068c
                                r4 = 2131363004(0x7f0a04bc, float:1.8345805E38)
                                android.view.View r4 = r8.findViewById(r4)
                                r6 = 0
                                r4.setVisibility(r6)
                                goto L_0x0697
                            L_0x068c:
                                r6 = 0
                                r4 = 2131363001(0x7f0a04b9, float:1.8345798E38)
                                android.view.View r4 = r8.findViewById(r4)
                                r4.setVisibility(r6)
                            L_0x0697:
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.acargar_m
                                boolean r4 = r4.containsKey(r5)
                                if (r4 != 0) goto L_0x06f3
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.intentados_m
                                boolean r4 = r4.containsKey(r5)
                                if (r4 == 0) goto L_0x06bb
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.intentados_m
                                java.lang.Object r4 = r4.get(r5)
                                java.lang.String r4 = (java.lang.String) r4
                                boolean r4 = r4.equals(r2)
                                if (r4 != 0) goto L_0x06f3
                            L_0x06bb:
                                stikerwap.appdys.t_video_playerjs r4 = stikerwap.appdys.t_video_playerjs.this
                                java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.acargar_m
                                r4.put(r5, r2)
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.t_video_playerjs$obtener_foto r2 = r2.o_f
                                if (r2 == 0) goto L_0x06d4
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.t_video_playerjs$obtener_foto r2 = r2.o_f
                                android.os.AsyncTask$Status r2 = r2.getStatus()
                                android.os.AsyncTask$Status r4 = android.os.AsyncTask.Status.RUNNING
                                if (r2 == r4) goto L_0x06f3
                            L_0x06d4:
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.t_video_playerjs$obtener_foto r4 = new stikerwap.appdys.t_video_playerjs$obtener_foto
                                stikerwap.appdys.t_video_playerjs r5 = stikerwap.appdys.t_video_playerjs.this
                                r6 = 0
                                r4.<init>()
                                r2.o_f = r4
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.t_video_playerjs$obtener_foto r2 = r2.o_f
                                r4 = 0
                                java.lang.String[] r5 = new java.lang.String[r4]
                                r2.execute(r5)
                                goto L_0x06f3
                            L_0x06eb:
                                r20 = r4
                                r19 = r10
                                r22 = r11
                                r21 = r13
                            L_0x06f3:
                                r5 = r19
                            L_0x06f5:
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r2 = r2.globales
                                int r2 = r2.bubbles
                                r4 = 2
                                if (r2 <= 0) goto L_0x0812
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r2 = r2.globales
                                java.lang.String r2 = r2.c_bubbles
                                boolean r2 = r2.equals(r7)
                                if (r2 != 0) goto L_0x0726
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                java.lang.String r6 = "#C0"
                                r2.<init>(r6)
                                stikerwap.appdys.t_video_playerjs r6 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r6 = r6.globales
                                java.lang.String r6 = r6.c_bubbles
                                java.lang.String r6 = r6.substring(r4)
                                r2.append(r6)
                                java.lang.String r2 = r2.toString()
                                int r16 = android.graphics.Color.parseColor(r2)
                            L_0x0726:
                                r2 = r16
                                r6 = 2131230950(0x7f0800e6, float:1.8077967E38)
                                if (r3 == 0) goto L_0x0789
                                stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r3 = r3.getResources()
                                r10 = 2131034118(0x7f050006, float:1.7678745E38)
                                boolean r3 = r3.getBoolean(r10)
                                if (r3 == 0) goto L_0x0764
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x0744
                                goto L_0x07f9
                            L_0x0744:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x074e
                                goto L_0x07d8
                            L_0x074e:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x0759
                                goto L_0x07e5
                            L_0x0759:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07f6
                                goto L_0x07f2
                            L_0x0764:
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x076c
                                goto L_0x07f9
                            L_0x076c:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x0775
                                goto L_0x07a7
                            L_0x0775:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x077f
                                goto L_0x07b4
                            L_0x077f:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07c5
                                goto L_0x07c1
                            L_0x0789:
                                stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r3 = r3.getResources()
                                r10 = 2131034118(0x7f050006, float:1.7678745E38)
                                boolean r3 = r3.getBoolean(r10)
                                if (r3 == 0) goto L_0x07c9
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x079f
                                goto L_0x07f9
                            L_0x079f:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x07ab
                            L_0x07a7:
                                r6 = 2131230944(0x7f0800e0, float:1.8077955E38)
                                goto L_0x07f9
                            L_0x07ab:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x07b8
                            L_0x07b4:
                                r6 = 2131230946(0x7f0800e2, float:1.807796E38)
                                goto L_0x07f9
                            L_0x07b8:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07c5
                            L_0x07c1:
                                r6 = 2131230948(0x7f0800e4, float:1.8077963E38)
                                goto L_0x07f9
                            L_0x07c5:
                                r6 = 2131230949(0x7f0800e5, float:1.8077965E38)
                                goto L_0x07f9
                            L_0x07c9:
                                boolean r0 = r0.booleanValue()
                                if (r0 == 0) goto L_0x07d0
                                goto L_0x07f9
                            L_0x07d0:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 != r4) goto L_0x07dc
                            L_0x07d8:
                                r6 = 2131230943(0x7f0800df, float:1.8077953E38)
                                goto L_0x07f9
                            L_0x07dc:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 3
                                if (r0 != r3) goto L_0x07e9
                            L_0x07e5:
                                r6 = 2131230945(0x7f0800e1, float:1.8077957E38)
                                goto L_0x07f9
                            L_0x07e9:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                r3 = 4
                                if (r0 != r3) goto L_0x07f6
                            L_0x07f2:
                                r6 = 2131230947(0x7f0800e3, float:1.8077961E38)
                                goto L_0x07f9
                            L_0x07f6:
                                r6 = 2131230942(0x7f0800de, float:1.807795E38)
                            L_0x07f9:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                android.content.res.Resources r0 = r0.getResources()
                                android.graphics.drawable.Drawable r0 = r0.getDrawable(r6)
                                android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
                                r0.setColorFilter(r2, r3)
                                r2 = 2131362605(0x7f0a032d, float:1.8344995E38)
                                android.view.View r2 = r8.findViewById(r2)
                                r2.setBackgroundDrawable(r0)
                            L_0x0812:
                                android.content.SharedPreferences r0 = r4
                                java.lang.String r0 = r0.getString(r9, r7)
                                boolean r2 = r0.equals(r7)
                                if (r2 != 0) goto L_0x0842
                                r2 = 6
                                r3 = 10
                                java.lang.String r0 = r0.substring(r2, r3)
                                java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
                                java.lang.String r3 = "HHmm"
                                r2.<init>(r3)
                                java.util.Date r0 = r2.parse(r0)     // Catch:{ Exception -> 0x083e }
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x083e }
                                java.text.DateFormat r2 = android.text.format.DateFormat.getTimeFormat(r2)     // Catch:{ Exception -> 0x083e }
                                java.lang.String r0 = r2.format(r0)     // Catch:{ Exception -> 0x083e }
                                r14.setText(r0)     // Catch:{ Exception -> 0x083e }
                                goto L_0x0842
                            L_0x083e:
                                r0 = move-exception
                                r0.printStackTrace()
                            L_0x0842:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                int r0 = r0.fotos_perfil
                                if (r0 <= 0) goto L_0x084b
                                goto L_0x088f
                            L_0x084b:
                                r2 = 8
                                r12.setVisibility(r2)
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                int r0 = r0.bubbles
                                if (r0 <= 0) goto L_0x0863
                                r3 = 2131362308(0x7f0a0204, float:1.8344393E38)
                                android.view.View r0 = r8.findViewById(r3)
                                r0.setVisibility(r2)
                                goto L_0x088f
                            L_0x0863:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                boolean r0 = r0.c_txt_chats
                                if (r0 == 0) goto L_0x0870
                                r6 = r5
                                r2 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                goto L_0x0880
                            L_0x0870:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                boolean r0 = r0.c1_esclaro
                                if (r0 == 0) goto L_0x087c
                                r2 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                goto L_0x0880
                            L_0x087c:
                                r2 = 2131363494(0x7f0a06a6, float:1.8346798E38)
                                r6 = -1
                            L_0x0880:
                                android.view.View r0 = r8.findViewById(r2)
                                r0.setBackgroundColor(r6)
                                android.view.View r0 = r8.findViewById(r2)
                                r2 = 0
                                r0.setVisibility(r2)
                            L_0x088f:
                                r0 = 2131363424(0x7f0a0660, float:1.8346656E38)
                                android.view.View r0 = r8.findViewById(r0)
                                android.widget.TextView r0 = (android.widget.TextView) r0
                                android.content.SharedPreferences r2 = r4
                                java.lang.String r3 = "f2_frase"
                                java.lang.String r2 = r2.getString(r3, r7)
                                android.content.SharedPreferences r3 = r4
                                java.lang.String r6 = "f2_tipo"
                                java.lang.String r3 = r3.getString(r6, r7)
                                r6 = r22
                                r3.equals(r6)
                                boolean r3 = r2.equals(r7)
                                if (r3 != 0) goto L_0x08cf
                                stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
                                java.lang.CharSequence r2 = stikerwap.appdys.t_chat.addSmileySpans(r3, r2)
                                stikerwap.appdys.t_video_playerjs r3 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r3 = r3.globales
                                boolean r3 = r3.links_enchats
                                if (r3 == 0) goto L_0x08c8
                                r3 = 1
                                r0.setAutoLinkMask(r3)
                                r0.setLinkTextColor(r5)
                            L_0x08c8:
                                r0.setText(r2)
                                r0.setTextColor(r5)
                                goto L_0x08ea
                            L_0x08cf:
                                android.content.SharedPreferences r0 = r4
                                java.lang.String r2 = "f2_b64"
                                java.lang.String r0 = r0.getString(r2, r7)
                                java.lang.String r2 = "es_ad"
                                boolean r0 = r0.equals(r2)
                                if (r0 == 0) goto L_0x08ea
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                stikerwap.appdys.config r0 = r0.globales
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                int r2 = r2.width_ad
                                r0.mostrar_inchat_post(r8, r5, r2)
                            L_0x08ea:
                                android.content.SharedPreferences r0 = r4
                                r2 = r21
                                java.lang.String r0 = r0.getString(r2, r7)
                                r8.setTag(r0)
                                android.content.SharedPreferences r0 = r4
                                r3 = r20
                                r2 = 0
                                boolean r0 = r0.getBoolean(r3, r2)
                                if (r0 == 0) goto L_0x0908
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                android.widget.LinearLayout r0 = r0.llchat
                                r0.addView(r8, r2)
                                goto L_0x0923
                            L_0x0908:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                android.widget.LinearLayout r0 = r0.llchat
                                r0.addView(r8)
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                android.widget.LinearLayout r0 = r0.llchat
                                int r0 = r0.getChildCount()
                                r2 = 200(0xc8, float:2.8E-43)
                                if (r0 <= r2) goto L_0x0923
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                android.widget.LinearLayout r0 = r0.llchat
                                r2 = 0
                                r0.removeViewAt(r2)
                            L_0x0923:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                int r2 = r0.nfrases
                                r3 = 1
                                int r2 = r2 + r3
                                r0.nfrases = r2
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                int r0 = r0.nfrases
                                if (r0 != r3) goto L_0x0945
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                r2 = 2131363531(0x7f0a06cb, float:1.8346873E38)
                                android.view.View r0 = r0.findViewById(r2)
                                r2 = 8
                                r0.setVisibility(r2)
                                goto L_0x095b
                            L_0x0945:
                                r2 = 8
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                int r0 = r0.nfrases
                                if (r0 != r4) goto L_0x095b
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                r3 = 2131363532(0x7f0a06cc, float:1.8346875E38)
                                android.view.View r0 = r0.findViewById(r3)
                                r0.setVisibility(r2)
                            L_0x095b:
                                stikerwap.appdys.t_video_playerjs r0 = stikerwap.appdys.t_video_playerjs.this
                                r2 = 2131363236(0x7f0a05a4, float:1.8346275E38)
                                android.view.View r0 = r0.findViewById(r2)
                                android.widget.ScrollView r0 = (android.widget.ScrollView) r0
                                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this
                                android.widget.LinearLayout r2 = r2.llchat
                                int r2 = r2.getMeasuredHeight()
                                int r3 = r0.getScrollY()
                                int r4 = r0.getHeight()
                                int r3 = r3 + r4
                                if (r2 > r3) goto L_0x0981
                                stikerwap.appdys.t_video_playerjs$10$2 r2 = new stikerwap.appdys.t_video_playerjs$10$2
                                r2.<init>()
                                r0.post(r2)
                            L_0x0981:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_playerjs.AnonymousClass10.run():void");
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_fecha() {
        boolean z;
        Date date;
        if (!this.dia_act.equals("")) {
            try {
                date = new SimpleDateFormat("ddMMyy").parse(this.dia_act);
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                date = null;
                z = false;
            }
            if (z) {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int i = this.TV_MARGIN;
                layoutParams.setMargins(0, i * 8, 0, i * 2);
                layoutParams.gravity = 1;
                textView.setLayoutParams(layoutParams);
                textView.setGravity(1);
                textView.setBackgroundResource(R.drawable.fondo_rounded_fecha);
                textView.setTextSize(1, 13.0f);
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextColor(-12303292);
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance2.setTime(date);
                if (instance2.get(1) == instance.get(1) && instance2.get(6) == instance.get(6)) {
                    textView.setText(getResources().getString(R.string.hoy));
                } else {
                    textView.setText(DateFormat.getDateFormat(this).format(date));
                }
                this.llchat.addView(textView, 0);
            }
        }
    }

    private class enviar extends AsyncTask<String, Void, String> {
        private enviar() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            Iterator<String> it = t_video_playerjs.this.spool.iterator();
            while (it.hasNext()) {
                try {
                    it.remove();
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                    HttpPost httpPost = new HttpPost(config.PROTOC_GEN + "gcm." + config.DOM_EDROID + "/enviar_mensaje.php");
                    MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                    multipartEntity.addPart("v", new StringBody("4"));
                    multipartEntity.addPart("idapp", new StringBody("3008836"));
                    multipartEntity.addPart("idusu", new StringBody(t_video_playerjs.this.idusu + ""));
                    multipartEntity.addPart("c", new StringBody(t_video_playerjs.this.codigo));
                    multipartEntity.addPart("idtema", new StringBody(t_video_playerjs.this.idtema + ""));
                    multipartEntity.addPart("idusudest", new StringBody("0"));
                    multipartEntity.addPart("externo", new StringBody("0"));
                    multipartEntity.addPart("m", new StringBody(URLEncoder.encode(it.next(), "UTF-8")));
                    httpPost.setEntity(multipartEntity);
                    httpPost.setHeader("User-Agent", "Android Vinebre Software");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent(), "UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        }
                    }
                } catch (Exception unused) {
                    return "KO";
                }
            }
            return "OK";
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.equals("OK") && t_video_playerjs.this.spool.size() > 0) {
                t_video_playerjs t_video_playerjs = t_video_playerjs.this;
                t_video_playerjs.env = new enviar();
                t_video_playerjs.this.env.execute(new String[0]);
            }
        }
    }

    private class obtener_foto extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String idusu_acargar;
        String vfoto_acargar;

        private obtener_foto() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_video_playerjs.this.acargar_m.equals("")) {
                cancel(false);
                return;
            }
            try {
                this.idusu_acargar = (String) t_video_playerjs.this.acargar_m.keySet().toArray()[0];
            } catch (Exception unused) {
                cancel(false);
            }
            if (this.idusu_acargar != null) {
                this.vfoto_acargar = t_video_playerjs.this.acargar_m.get(this.idusu_acargar);
                t_video_playerjs.this.intentados_m.put(this.idusu_acargar, t_video_playerjs.this.acargar_m.get(this.idusu_acargar));
                t_video_playerjs.this.acargar_m.remove(this.idusu_acargar);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "fperfil_"
                java.lang.String r0 = r4.idusu_acargar
                java.lang.String r1 = "0"
                if (r0 == 0) goto L_0x0088
                java.lang.String r0 = r4.vfoto_acargar
                if (r0 != 0) goto L_0x000d
                goto L_0x0088
            L_0x000d:
                java.net.URL r0 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/usus/"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.idusu_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_1_p.jpg?v="
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.vfoto_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r0.<init>(r2)     // Catch:{  }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{  }
                r2 = 1
                r0.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r0.setReadTimeout(r2)     // Catch:{  }
                r0.connect()     // Catch:{  }
                java.io.InputStream r2 = r0.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{  }
                r4.bmImg = r3     // Catch:{  }
                r2.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                java.io.File r0 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_video_playerjs r2 = stikerwap.appdys.t_video_playerjs.this     // Catch:{  }
                java.io.File r2 = r2.path     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r5)     // Catch:{  }
                java.lang.String r5 = r4.idusu_acargar     // Catch:{  }
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = ".jpg"
                r3.append(r5)     // Catch:{  }
                java.lang.String r5 = r3.toString()     // Catch:{  }
                r0.<init>(r2, r5)     // Catch:{  }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x0088 }
                r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x0088 }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x0088 }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x0088 }
                r3 = 70
                r0.compress(r2, r3, r5)     // Catch:{ MalformedURLException -> 0x0088 }
                java.lang.String r5 = "1"
                return r5
            L_0x0088:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_playerjs.obtener_foto.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (t_video_playerjs.this.fotos_m != null) {
                if (str == "1") {
                    t_video_playerjs.this.fotos_m.put(this.idusu_acargar, this.bmImg);
                    SharedPreferences.Editor edit = t_video_playerjs.this.settings.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, t_video_playerjs.this.intentados_m.get(this.idusu_acargar));
                    edit.commit();
                }
                int childCount = t_video_playerjs.this.llchat.getChildCount();
                int i = 0;
                while (i < childCount) {
                    try {
                        String str2 = (String) t_video_playerjs.this.llchat.getChildAt(i).getTag();
                        if (str2 != null && str2.equals(this.idusu_acargar)) {
                            t_video_playerjs.this.llchat.getChildAt(i).findViewById(R.id.pb_foto).setVisibility(8);
                            t_video_playerjs.this.llchat.getChildAt(i).findViewById(R.id.pb_foto_inv).setVisibility(8);
                            if (str == "1") {
                                ((ImageView) t_video_playerjs.this.llchat.getChildAt(i).findViewById(R.id.iv_avatar_f)).setImageBitmap(config.getCircularBitmapWithWhiteBorder(this.bmImg, 0));
                            }
                        }
                        i++;
                    } catch (Exception unused) {
                    }
                }
                if (!t_video_playerjs.this.acargar_m.equals("")) {
                    t_video_playerjs t_video_playerjs = t_video_playerjs.this;
                    t_video_playerjs.o_f = new obtener_foto();
                    t_video_playerjs.this.o_f.execute(new String[0]);
                }
            }
        }
    }

    private class cargar_ultimas extends AsyncTask<String, Void, String> {
        private String idconversante;
        private int idfrase_masantigua;
        private String idprivado_finalizar;

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        public cargar_ultimas(String str, String str2, int i) {
            this.idprivado_finalizar = str;
            this.idconversante = str2;
            this.idfrase_masantigua = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1 }
                r0.<init>()     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "/srv/ultimas_frases.php?ver=1&idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_video_playerjs r1 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x00b1 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_video_playerjs r1 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = r1.codigo     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idtema="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                stikerwap.appdys.t_video_playerjs r1 = stikerwap.appdys.t_video_playerjs.this     // Catch:{ Exception -> 0x00b1 }
                int r1 = r1.idtema     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idf="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                int r1 = r5.idfrase_masantigua     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&idprivado_finalizar=0&idconversante="
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = r5.idconversante     // Catch:{ Exception -> 0x00b1 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r1 = "&externo=0"
                r0.append(r1)     // Catch:{ Exception -> 0x00b1 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b1 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b1 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x00b1 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x00b1 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00b1 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            L_0x0083:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r2 == 0) goto L_0x009e
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                r6.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                goto L_0x0083
            L_0x009e:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
                if (r0 == 0) goto L_0x00a7
                r0.disconnect()
            L_0x00a7:
                return r6
            L_0x00a8:
                r6 = move-exception
                goto L_0x00b9
            L_0x00aa:
                r6 = r0
                goto L_0x00b1
            L_0x00ac:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00b9
            L_0x00b1:
                java.lang.String r0 = "ANDROID:KO"
                if (r6 == 0) goto L_0x00b8
                r6.disconnect()
            L_0x00b8:
                return r0
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                goto L_0x00c0
            L_0x00bf:
                throw r6
            L_0x00c0:
                goto L_0x00bf
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_video_playerjs.cargar_ultimas.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            boolean z;
            int i;
            String str3;
            String str4 = str;
            if (this.idfrase_masantigua != -1) {
                if (str4.indexOf("ANDROID:OK") != -1 || str4.indexOf("ANDROID:KO") != -1 || str4.indexOf("ANDROID:PERFILKO") != -1) {
                    if (str4.indexOf("ANDROID:PERFILKO") != -1) {
                        final AlertDialog create = new AlertDialog.Builder(t_video_playerjs.this).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).setMessage(R.string.perfil_desactivado).create();
                        if (!t_video_playerjs.this.cbtn.equals("")) {
                            create.setOnShowListener(new DialogInterface.OnShowListener() {
                                public void onShow(DialogInterface dialogInterface) {
                                    Button button = create.getButton(-1);
                                    button.setTextColor(Color.parseColor("#" + t_video_playerjs.this.cbtn));
                                    Button button2 = create.getButton(-2);
                                    button2.setTextColor(Color.parseColor("#" + t_video_playerjs.this.cbtn));
                                }
                            });
                        }
                        create.show();
                        try {
                            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                        } catch (Exception unused) {
                        }
                    } else if (str4.indexOf("ANDROID:OK") != -1) {
                        int indexOf = str4.indexOf("@XYY53@");
                        String str5 = "";
                        String str6 = str5;
                        boolean z2 = false;
                        for (int i2 = -1; indexOf != i2; i2 = -1) {
                            int indexOf2 = str4.indexOf("@", indexOf + 1) + 1;
                            int indexOf3 = str4.indexOf("@", indexOf2);
                            String substring = str4.substring(indexOf2, indexOf3);
                            t_video_playerjs.this.idfrase_masantigua_glob = Integer.parseInt(substring);
                            int i3 = indexOf3 + 1;
                            int indexOf4 = str4.indexOf("@", i3);
                            String substring2 = str4.substring(i3, indexOf4);
                            int i4 = indexOf4 + 1;
                            int indexOf5 = str4.indexOf("@", i4);
                            String substring3 = str4.substring(i4, indexOf5);
                            int i5 = indexOf5 + 1;
                            int indexOf6 = str4.indexOf("@", i5);
                            String substring4 = str4.substring(i5, indexOf6);
                            int i6 = indexOf6 + 1;
                            int indexOf7 = str4.indexOf("@", i6);
                            String substring5 = str4.substring(i6, indexOf7);
                            int i7 = indexOf7 + 1;
                            String str7 = substring5;
                            int indexOf8 = str4.indexOf("@", i7);
                            String substring6 = str4.substring(i7, indexOf8);
                            int i8 = indexOf8 + 1;
                            String str8 = substring6;
                            int indexOf9 = str4.indexOf("@", i8);
                            String substring7 = str4.substring(i8, indexOf9);
                            int i9 = indexOf9 + 1;
                            String str9 = substring7;
                            int indexOf10 = str4.indexOf("@", i9);
                            String substring8 = str4.substring(i9, indexOf10);
                            int i10 = indexOf10 + 1;
                            String str10 = substring8;
                            int indexOf11 = str4.indexOf("@", i10);
                            String substring9 = str4.substring(i10, indexOf11);
                            int i11 = indexOf11 + 1;
                            String str11 = substring9;
                            int indexOf12 = str4.indexOf("@", i11);
                            String substring10 = str4.substring(i11, indexOf12);
                            int i12 = indexOf12 + 1;
                            String str12 = substring10;
                            int indexOf13 = str4.indexOf("@", i12);
                            String substring11 = str4.substring(i12, indexOf13);
                            int i13 = indexOf13 + 1;
                            String str13 = substring11;
                            int indexOf14 = str4.indexOf("@", i13);
                            String substring12 = str4.substring(i13, indexOf14);
                            int i14 = indexOf14 + 1;
                            int indexOf15 = str4.indexOf("@", i14);
                            String substring13 = str4.substring(i14, indexOf15);
                            if (str5.equals("") || substring4.equals("") || !str5.equals(substring4) || str6.equals("") || substring2.equals("") || !str6.equals(substring2)) {
                                int indexOf16 = str4.indexOf("@XYY53@", indexOf15);
                                if (indexOf16 != -1) {
                                    int indexOf17 = str4.indexOf("@", str4.indexOf("@", indexOf16 + 1) + 1) + 1;
                                    str2 = str4.substring(indexOf17, str4.indexOf("@", indexOf17));
                                } else {
                                    str2 = "";
                                }
                                if (z2 || str4.indexOf("ZXRT4@1@") != -1) {
                                    z = z2;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    z = z2;
                                    sb.append(t_video_playerjs.this.idusu);
                                    sb.append("");
                                    if (substring2.equals(sb.toString())) {
                                        int i15 = indexOf15;
                                        while (true) {
                                            int indexOf18 = str4.indexOf("@XYY53@", i15);
                                            if (indexOf18 != -1) {
                                                int indexOf19 = str4.indexOf("@", str4.indexOf("@", indexOf18 + 1) + 1) + 1;
                                                i = str4.indexOf("@", indexOf19);
                                                str3 = str4.substring(indexOf19, i);
                                            } else {
                                                i = i15;
                                                str3 = "";
                                            }
                                            if (str3.equals("")) {
                                                z2 = true;
                                                break;
                                            } else if (!str3.equals(substring2)) {
                                                z2 = false;
                                                break;
                                            } else {
                                                i15 = i;
                                            }
                                        }
                                        SharedPreferences.Editor edit = t_video_playerjs.this.settings.edit();
                                        edit.putString("f2_idfrase", substring);
                                        edit.putString("f2_id", substring2);
                                        edit.putString("f2_idusu_prev", str2);
                                        edit.putBoolean("f2_mateixusu_hastafinal", z2);
                                        edit.putString("f2_nombre", substring3);
                                        edit.putString("f2_privados", str8);
                                        edit.putString("f2_frase", substring4);
                                        edit.putString("f2_fcrea", config.convertir_fecha(str9));
                                        edit.putString("f2_b64", "");
                                        edit.putString("f2_tipo", substring13);
                                        edit.putString("f2_b64_th", "");
                                        edit.putString("f2_idvideo", "");
                                        edit.putString("f2_formato", "");
                                        edit.putString("f2_idtema", t_video_playerjs.this.idtema + "");
                                        edit.putString("f2_vfoto", str7);
                                        edit.putString("f2_fnac_d", str10);
                                        edit.putString("f2_fnac_m", str11);
                                        edit.putString("f2_fnac_a", str12);
                                        edit.putString("f2_sexo", str13);
                                        edit.putString("f2_coments", substring12);
                                        edit.putBoolean("f2_ultimas", true);
                                        edit.putString("f2_ts", System.currentTimeMillis() + "");
                                        edit.commit();
                                        str6 = substring2;
                                        str5 = substring4;
                                    }
                                }
                                z2 = z;
                                SharedPreferences.Editor edit2 = t_video_playerjs.this.settings.edit();
                                edit2.putString("f2_idfrase", substring);
                                edit2.putString("f2_id", substring2);
                                edit2.putString("f2_idusu_prev", str2);
                                edit2.putBoolean("f2_mateixusu_hastafinal", z2);
                                edit2.putString("f2_nombre", substring3);
                                edit2.putString("f2_privados", str8);
                                edit2.putString("f2_frase", substring4);
                                edit2.putString("f2_fcrea", config.convertir_fecha(str9));
                                edit2.putString("f2_b64", "");
                                edit2.putString("f2_tipo", substring13);
                                edit2.putString("f2_b64_th", "");
                                edit2.putString("f2_idvideo", "");
                                edit2.putString("f2_formato", "");
                                edit2.putString("f2_idtema", t_video_playerjs.this.idtema + "");
                                edit2.putString("f2_vfoto", str7);
                                edit2.putString("f2_fnac_d", str10);
                                edit2.putString("f2_fnac_m", str11);
                                edit2.putString("f2_fnac_a", str12);
                                edit2.putString("f2_sexo", str13);
                                edit2.putString("f2_coments", substring12);
                                edit2.putBoolean("f2_ultimas", true);
                                edit2.putString("f2_ts", System.currentTimeMillis() + "");
                                edit2.commit();
                                str6 = substring2;
                                str5 = substring4;
                            }
                            indexOf = str4.indexOf("@XYY53@", indexOf15);
                        }
                        if (str4.indexOf("ZXRT4@1@") == -1) {
                            t_video_playerjs.this.mostrar_fecha();
                        }
                    }
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (findViewById(R.id.sv_chat).getVisibility() == 0) {
                cerrar_chat();
                return true;
            } else if (this.mCustomView != null) {
                this.atras_pulsado = false;
                this.mClient.onHideCustomView();
                return true;
            } else if (this.es_root && !this.atras_pulsado && this.globales.pedir_confirm_exit) {
                this.atras_pulsado = true;
                config.confirmar_exit(this);
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
        if (view.getId() == R.id.btnemotic) {
            new EmojisMenu((EditText) findViewById(R.id.c_mensaje), this).show();
        } else if (view.getId() == R.id.btnenv) {
            f_enviar(false);
        } else if ((view.getId() == R.id.ll_frase_txt || view.getId() == R.id.fl_frase) && ((View) view.getParent()).getTag(R.id.idaux1) != null && !((View) view.getParent()).getTag(R.id.idaux1).equals("0") && !((View) view.getParent()).getTag(R.id.idaux1).equals("1")) {
            View view2 = (View) view.getParent();
            Intent intent = new Intent(this, profile.class);
            intent.putExtra("id", (String) view2.getTag(R.id.idaux1));
            intent.putExtra("privados", (String) view2.getTag(R.id.idaux2));
            intent.putExtra("nombre", (String) view2.getTag(R.id.idaux3));
            intent.putExtra("coments", (String) view2.getTag(R.id.idaux4));
            intent.putExtra("fnac_d", (String) view2.getTag(R.id.idaux5));
            intent.putExtra("fnac_m", (String) view2.getTag(R.id.idaux6));
            intent.putExtra("fnac_a", (String) view2.getTag(R.id.idaux7));
            intent.putExtra("sexo", (String) view2.getTag(R.id.idaux8));
            intent.putExtra("vfoto", (String) view2.getTag(R.id.idaux9));
            intent.putExtra("p_fnac", this.fnac);
            intent.putExtra("p_sexo", this.sexo);
            intent.putExtra("p_descr", this.descr);
            intent.putExtra("p_dist", this.dist);
            intent.putExtra("coments_chat", this.coments);
            intent.putExtra("galeria", this.galeria);
            intent.putExtra("privados_chat", this.privados);
            intent.putExtra("fotos_perfil", this.fotos_perfil);
            intent.putExtra("fotos_chat", this.fotos_chat);
            startActivityForResult(intent, 0);
        } else if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
            abrir_secc(view);
        } else {
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
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config != null && config.onActivityResult_glob(i, i2, intent, this)) || i2 != -1) {
            return;
        }
        if (intent == null || !intent.hasExtra("finalizar")) {
            if (intent != null && intent.hasExtra("idusu_ban")) {
                t_chat.ocultar_frases(this, intent.getStringExtra("idusu_ban"));
            }
        } else if (intent.getExtras().getBoolean("finalizar")) {
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
        if (!this.es_playlist) {
            try {
                SessionManager sessionManager = this.mSessionManager;
                if (sessionManager != null) {
                    sessionManager.removeSessionManagerListener(this.mSessionManagerListener);
                }
                this.mCastSession = null;
            } catch (Exception unused) {
            }
        }
        if (this.finalizar || isFinishing()) {
            try {
                this.myWebView.loadData("", "text/html", "utf-8");
            } catch (Exception unused2) {
            }
        }
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        SessionManager sessionManager;
        try {
            if (!this.es_playlist && (sessionManager = this.mSessionManager) != null) {
                this.mCastSession = sessionManager.getCurrentCastSession();
                this.mSessionManager.addSessionManagerListener(this.mSessionManagerListener);
            }
        } catch (Exception unused) {
        }
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
        if (this.con_chat && this.logineado_ok) {
            this.settings.registerOnSharedPreferenceChangeListener(this);
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
        if (this.con_chat && this.logineado_ok) {
            try {
                this.settings.unregisterOnSharedPreferenceChangeListener(this);
            } catch (Exception unused) {
            }
        }
        if ((this.es_root && isFinishing()) || config.finalizar_app) {
            config.finalizar_app(this);
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Anuncios anuncios;
        super.onConfigurationChanged(configuration);
        boolean z = false;
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        ((LinearLayout) findViewById(R.id.ll_ad)).removeAllViews();
        Anuncios anuncios2 = this.anun;
        if (!(anuncios2 == null || anuncios2.adView == null)) {
            try {
                this.anun.adView.destroy();
            } catch (Exception unused) {
            }
        }
        Anuncios anuncios3 = this.anun;
        if (!(anuncios3 == null || anuncios3.adView_fb == null)) {
            try {
                this.anun.adView_fb.destroy();
            } catch (Exception unused2) {
            }
        }
        Anuncios anuncios4 = this.anun;
        if (!(anuncios4 == null || anuncios4.wortiseBanner == null)) {
            try {
                this.anun.wortiseBanner.destroy();
            } catch (Exception unused3) {
            }
        }
        config config = this.globales;
        if (this.url_load.contains("youtube.com") || this.url_load.contains("youtu.be")) {
            z = true;
        }
        this.anun = config.mostrar_banner(this, z);
        if (findViewById(R.id.sv_chat).getVisibility() == 0 && !this.globales.banners_enchats && (anuncios = this.anun) != null && anuncios.adView != null) {
            ocultar_banner();
        }
        if (getResources().getConfiguration().orientation == 2) {
            this.myWebView.evaluateJavascript("f_estilo(0)", (ValueCallback) null);
            this.myWebView.evaluateJavascript("player.api('fullscreen');", (ValueCallback) null);
            return;
        }
        this.myWebView.evaluateJavascript("f_estilo(1)", (ValueCallback) null);
        this.myWebView.evaluateJavascript("player.api('exitfullscreen');", (ValueCallback) null);
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
                if (!t_video_playerjs.this.globales.admob_rew_failed(context, t_video_playerjs.this.mAd_appnext)) {
                    t_video_playerjs.this.dialog_cargando.cancel();
                    t_video_playerjs t_video_playerjs = t_video_playerjs.this;
                    t_video_playerjs.abrir_secc(t_video_playerjs.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_video_playerjs.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_video_playerjs.this.abrir_secc(t_video_playerjs.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_video_playerjs.this.mAd_visto) {
                            t_video_playerjs.this.abrir_secc(t_video_playerjs.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_video_playerjs.this.mAd_visto = true;
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
                if (t_video_playerjs.this.mAd_visto) {
                    t_video_playerjs t_video_playerjs = t_video_playerjs.this;
                    t_video_playerjs.abrir_secc(t_video_playerjs.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
