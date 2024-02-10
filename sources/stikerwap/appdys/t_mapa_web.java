package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
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
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public class t_mapa_web extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    config globales;
    boolean mAd_visto = false;
    ListView mDrawerList;
    WebView myWebView;

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
        try {
            this.cbtn = config.aplicar_color_dialog(this.globales.secciones_a[this.globales.ind_secc_sel_2].c1, this.globales.c_icos);
        } catch (Exception unused) {
            this.cbtn = "";
        }
        super.onCreate(bundle);
        setContentView(R.layout.t_mapa_web);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_mapa_web.this.finalizar = false;
                t_mapa_web.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_mapa_web.this.buscador_on = false;
            }
        });
        this.globales.toca_int(this, false, false);
        this.anun = this.globales.mostrar_banner(this, false);
        WebView webView = (WebView) findViewById(R.id.webview);
        this.myWebView = webView;
        webView.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                callback.invoke(str, true, false);
            }
        });
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_url);
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(progressBar, this.globales.c_icos);
        }
        this.myWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                progressBar.setVisibility(0);
            }

            public void onPageFinished(WebView webView, String str) {
                progressBar.setVisibility(8);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.toLowerCase().startsWith("intent://")) {
                    try {
                        Intent parseUri = Intent.parseUri(str, 1);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent((ComponentName) null);
                        parseUri.setSelector((Intent) null);
                        t_mapa_web.this.startActivity(parseUri);
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
        });
        this.myWebView.getSettings().setJavaScriptEnabled(true);
        this.myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        if (bundle == null) {
            this.myWebView.loadUrl("https://www.google.com/maps/search/?api=1&query=" + (((float) getIntent().getIntExtra("x", 0)) / 1000000.0f) + "," + (((float) getIntent().getIntExtra("y", 0)) / 1000000.0f));
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config == null || !config.onActivityResult_glob(i, i2, intent, this)) && i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
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

    public void onClick(View view) {
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
        if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
            abrir_secc(view);
        }
    }

    public void abrir_secc(View view) {
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

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.myWebView.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.myWebView.goBack();
        return true;
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
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
        super.onPause();
        config.onPause_global(this);
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (this.globales.admob_pos != 0 && (anuncios = this.anun) != null && anuncios.wortiseBanner != null) {
            this.anun.wortiseBanner.resume();
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
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
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
        this.anun = this.globales.mostrar_banner(this, false);
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
                if (!t_mapa_web.this.globales.admob_rew_failed(context, t_mapa_web.this.mAd_appnext)) {
                    t_mapa_web.this.dialog_cargando.cancel();
                    t_mapa_web t_mapa_web = t_mapa_web.this;
                    t_mapa_web.abrir_secc(t_mapa_web.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_mapa_web.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_mapa_web.this.abrir_secc(t_mapa_web.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_mapa_web.this.mAd_visto) {
                            t_mapa_web.this.abrir_secc(t_mapa_web.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_mapa_web.this.mAd_visto = true;
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
                if (t_mapa_web.this.mAd_visto) {
                    t_mapa_web t_mapa_web = t_mapa_web.this;
                    t_mapa_web.abrir_secc(t_mapa_web.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
