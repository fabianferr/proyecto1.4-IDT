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
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
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
import java.io.FileOutputStream;
import java.io.IOException;

public class fotoperfil extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    String codigo;
    Bundle extras;
    config globales;
    long idusu;
    String idusu_profile;
    boolean mAd_visto = false;
    ListView mDrawerList;
    WebView myWebView;
    boolean primer_load = true;
    SharedPreferences settings;

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
        this.cbtn = config.aplicar_color_dialog("FFFFFFFF", this.globales.c_icos);
        super.onCreate(bundle);
        setContentView(R.layout.fotoperfil);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                fotoperfil.this.finalizar = false;
                fotoperfil.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                fotoperfil.this.buscador_on = false;
            }
        });
        this.anun = this.globales.mostrar_banner(this, false);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.codigo = this.settings.getString("cod", "");
        this.idusu_profile = this.extras.getString("idusu_profile");
        findViewById(R.id.iv_cerrar).setOnClickListener(this);
        String str = this.idusu_profile;
        if (str.equals(this.idusu + "")) {
            findViewById(R.id.iv_reportar).setVisibility(8);
        } else {
            findViewById(R.id.iv_reportar).setOnClickListener(this);
        }
        this.myWebView = (WebView) findViewById(R.id.webview);
        if (this.extras.getString("url").startsWith(AdPayload.FILE_SCHEME)) {
            this.myWebView.getSettings().setAllowFileAccess(true);
            registerForContextMenu(this.myWebView);
            String str2 = this.globales.c1c;
            String str3 = this.globales.c2c;
            if (this.globales.ind_secc_sel_2 != -1) {
                str2 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
                str3 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c2;
            }
            if (this.extras.containsKey("bg1")) {
                str2 = this.extras.getString("bg1");
                str3 = this.extras.getString("bg2");
            }
            if (!str2.equals("")) {
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + str2), Color.parseColor("#" + str3)}));
                this.myWebView.setBackgroundColor(0);
            }
        }
        this.myWebView.setWebChromeClient(new WebChromeClient() {
        });
        this.myWebView.getSettings().setBuiltInZoomControls(true);
        this.myWebView.getSettings().setSupportZoom(true);
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
        this.myWebView.getSettings().setUseWideViewPort(true);
        this.myWebView.getSettings().setLoadWithOverviewMode(true);
        this.myWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                boolean z;
                boolean z2;
                if (!fotoperfil.this.finalizar && !fotoperfil.this.isFinishing() && !fotoperfil.this.extras.getString("url").contains("youtube.com") && !fotoperfil.this.extras.getString("url").contains("youtu.be")) {
                    if (fotoperfil.this.primer_load) {
                        z = true;
                        z2 = fotoperfil.this.extras != null && fotoperfil.this.extras.containsKey("ad_entrar");
                        if (fotoperfil.this.extras == null || !fotoperfil.this.extras.containsKey("fb_entrar")) {
                            z = false;
                        }
                        fotoperfil.this.primer_load = false;
                    } else {
                        z2 = false;
                        z = false;
                    }
                    fotoperfil.this.globales.toca_int_2(fotoperfil.this, z2, z, false);
                }
            }
        });
        if (bundle == null) {
            this.myWebView.loadUrl(this.extras.getString("url"));
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        getMenuInflater().inflate(R.menu.m3, contextMenu);
        MenuItem findItem = contextMenu.findItem(R.id.guardar);
        String str = findItem.getTitle() + "";
        findItem.setTitle(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        boolean z;
        Uri uriForFile;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.compartir) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeFile = BitmapFactory.decodeFile(this.extras.getString("url").replace(AdPayload.FILE_SCHEME, ""), options);
            try {
                File file = new File(getCacheDir(), "images");
                file.mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(file + "/temporal.png");
                decodeFile.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                z = true;
            } catch (IOException e) {
                e.printStackTrace();
                z = false;
            }
            if (z && (uriForFile = FileProvider.getUriForFile(this, "stikerwap.appdys.fileprovider", new File(new File(getCacheDir(), "images"), "temporal.png"))) != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.addFlags(1);
                intent.setType(getContentResolver().getType(uriForFile));
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.compartir)));
            }
            return true;
        } else if (itemId != R.id.guardar) {
            return super.onContextItemSelected(menuItem);
        } else {
            config.fguardar_foto_desdefile(this.extras.getString("url"), this);
            return true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.myWebView.canGoBack()) {
            this.myWebView.goBack();
            return true;
        }
        fcerrar();
        return true;
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

    public void fcerrar() {
        finish();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_cerrar) {
            fcerrar();
        } else if (view.getId() == R.id.iv_reportar) {
            final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("elim_fotoperfil", "1");
                    fotoperfil.this.setResult(-1, intent);
                    fotoperfil.this.finish();
                }
            }).setMessage(R.string.confirmar_elimusu).create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + fotoperfil.this.cbtn));
                        Button button2 = create.getButton(-2);
                        button2.setTextColor(Color.parseColor("#" + fotoperfil.this.cbtn));
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused) {
            }
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
            if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                abrir_secc(view);
            }
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config == null || !config.onActivityResult_glob(i, i2, intent, this)) && i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
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
        if (!(this.globales.admob_pos == 0 || (anuncios = this.anun) == null || anuncios.wortiseBanner == null)) {
            this.anun.wortiseBanner.resume();
        }
        this.myWebView.onResume();
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
                if (!fotoperfil.this.globales.admob_rew_failed(context, fotoperfil.this.mAd_appnext)) {
                    fotoperfil.this.dialog_cargando.cancel();
                    fotoperfil fotoperfil = fotoperfil.this;
                    fotoperfil.abrir_secc(fotoperfil.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                fotoperfil.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        fotoperfil.this.abrir_secc(fotoperfil.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (fotoperfil.this.mAd_visto) {
                            fotoperfil.this.abrir_secc(fotoperfil.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        fotoperfil.this.mAd_visto = true;
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
                if (fotoperfil.this.mAd_visto) {
                    fotoperfil fotoperfil = fotoperfil.this;
                    fotoperfil.abrir_secc(fotoperfil.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
