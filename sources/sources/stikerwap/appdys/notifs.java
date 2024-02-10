package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
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
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Calendar;

public class notifs extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private Anuncios anun;
    private boolean atras_pulsado = false;
    private boolean c1_esclaro;
    private Bundle extras;
    /* access modifiers changed from: private */
    public config globales;
    boolean mAd_visto = false;
    ListView mDrawerList;
    private SharedPreferences settings;

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
        this.cbtn = config.aplicar_color_dialog(this.globales.c1c, this.globales.c_icos);
        if (!config.esClaro("#" + this.globales.c1c)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.notifs);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                notifs.this.finalizar = false;
                notifs.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                notifs.this.buscador_on = false;
            }
        });
        this.globales.toca_int(this, false, false);
        this.anun = this.globales.mostrar_banner(this, false);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        this.settings = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.c1_esclaro = config.esClaro("#" + this.globales.c1c);
        if (!this.globales.c1c.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.c1c), Color.parseColor("#" + this.globales.c2c)}));
        }
        int i = !this.c1_esclaro ? -1 : ViewCompat.MEASURED_STATE_MASK;
        ((TextView) findViewById(R.id.tv_listanotifs)).setTextColor(i);
        findViewById(R.id.v_listanotifs).setBackgroundColor(i);
        ((TextView) findViewById(R.id.tv_sinnotifs)).setTextColor(i);
        if (this.c1_esclaro) {
            ((ImageView) findViewById(R.id.btntrash)).setImageDrawable(getResources().getDrawable(R.drawable.trash));
            ((ImageView) findViewById(R.id.btnsettings)).setImageDrawable(getResources().getDrawable(R.drawable.settings));
        } else {
            ((ImageView) findViewById(R.id.btntrash)).setImageDrawable(getResources().getDrawable(R.drawable.trash_light));
            ((ImageView) findViewById(R.id.btnsettings)).setImageDrawable(getResources().getDrawable(R.drawable.settings_light));
        }
        findViewById(R.id.btntrash).setOnClickListener(this);
        if (this.globales.hay_catsnotif) {
            findViewById(R.id.btnsettings).setOnClickListener(this);
            findViewById(R.id.btnsettings).setVisibility(0);
        }
        mostrar_notifs();
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

    /* access modifiers changed from: private */
    public void mostrar_notifs() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llnotifs);
        linearLayout.removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        boolean z = false;
        int i = this.settings.getInt("id_ultnotif", 0);
        int i2 = 0;
        while (i > 0) {
            if (this.settings.contains("notif_" + i + "_title")) {
                int i3 = config.NEGRO;
                int i4 = config.GRIS_OSCURO;
                if (!this.c1_esclaro) {
                    i3 = config.BLANCO;
                    i4 = config.GRIS_CLARO;
                }
                LinearLayout linearLayout2 = (LinearLayout) layoutInflater.inflate(R.layout.notif, (ViewGroup) null);
                TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_title);
                textView.setText(this.settings.getString("notif_" + i + "_title", ""));
                TextView textView2 = (TextView) linearLayout2.findViewById(R.id.tv_text);
                textView2.setText(this.settings.getString("notif_" + i + "_text", ""));
                textView.setTextColor(i3);
                textView2.setTextColor(i3);
                linearLayout2.findViewById(R.id.v_sepnotifs).setBackgroundColor(i4);
                if (!this.settings.getBoolean("notif_" + i + "_leida", z)) {
                    linearLayout2.findViewById(R.id.tv_nuevo).setVisibility(z ? 1 : 0);
                }
                DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(this);
                DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(this);
                TextView textView3 = (TextView) linearLayout2.findViewById(R.id.tv_f);
                DateFormat dateFormat2 = dateFormat;
                if (System.currentTimeMillis() - this.settings.getLong("notif_" + i + "_fcrea", 0) < 300000) {
                    textView3.setText(getResources().getString(R.string.ahora));
                } else {
                    Calendar instance = Calendar.getInstance();
                    Calendar instance2 = Calendar.getInstance();
                    instance2.setTimeInMillis(this.settings.getLong("notif_" + i + "_fcrea", 0));
                    if (instance2.get(1) == instance.get(1) && instance2.get(6) == instance.get(6)) {
                        textView3.setText(getResources().getString(R.string.hoy) + " " + timeFormat.format(Long.valueOf(instance2.getTimeInMillis())));
                    } else {
                        textView3.setText(dateFormat2.format(Long.valueOf(instance2.getTimeInMillis())) + " " + timeFormat.format(Long.valueOf(instance2.getTimeInMillis())));
                    }
                }
                linearLayout2.setTag(R.id.idaux1, Integer.valueOf(i));
                linearLayout2.setOnClickListener(this);
                linearLayout.addView(linearLayout2);
                i2++;
                if (i2 > 99) {
                    break;
                }
            }
            i--;
            z = false;
        }
        if (i2 == 0) {
            findViewById(R.id.tv_sinnotifs).setVisibility(0);
        }
    }

    public void onClick(View view) {
        Intent intent = null;
        boolean z = false;
        if (view.getId() == R.id.btntrash) {
            if (this.settings.getInt("id_ultnotif", 0) != 0) {
                final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.cancelar, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        config.elim_notifs(notifs.this);
                        notifs.this.mostrar_notifs();
                        config.mostrar_notif_noleidas(notifs.this);
                    }
                }).setMessage(R.string.confirmar_elimnotifs).create();
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + notifs.this.cbtn));
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + notifs.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            }
        } else if (view.getId() == R.id.btnsettings) {
            startActivityForResult(new Intent(this, notifs_cats.class), 0);
        } else if (view.getTag(R.id.idaux1) != null) {
            SharedPreferences sharedPreferences = this.settings;
            int i = sharedPreferences.getInt("notif_" + view.getTag(R.id.idaux1) + "_numnotif", 0);
            if (i != 0) {
                ((NotificationManager) getSystemService("notification")).cancel(i);
            }
            SharedPreferences.Editor edit = this.settings.edit();
            edit.putBoolean("notif_" + view.getTag(R.id.idaux1) + "_leida", true);
            edit.commit();
            config.act_notif_noleidas(this);
            SharedPreferences sharedPreferences2 = this.settings;
            String string = sharedPreferences2.getString("notif_" + view.getTag(R.id.idaux1) + "_intent", "");
            if (!string.equals("")) {
                try {
                    intent = Intent.parseUri(string, 0);
                    z = true;
                } catch (URISyntaxException unused2) {
                }
                if (z) {
                    intent.putExtra("directo", true);
                    startActivity(intent);
                    Intent intent2 = new Intent();
                    intent2.putExtra("finalizar", true);
                    intent2.putExtra("finalizar_app", true);
                    config.finalizar_app = true;
                    this.finalizar = true;
                    setResult(-1, intent2);
                }
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
            try {
                if (intent.i != null && intent.i.getComponent().getClassName().endsWith(".notifs")) {
                    return;
                }
            } catch (Exception unused) {
            }
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
                    } catch (Exception unused2) {
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
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

    public void onStop() {
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
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

    public void onBackPressed() {
        if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            super.onBackPressed();
            return;
        }
        this.atras_pulsado = true;
        config.confirmar_exit(this);
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
                if (!notifs.this.globales.admob_rew_failed(context, notifs.this.mAd_appnext)) {
                    notifs.this.dialog_cargando.cancel();
                    notifs notifs = notifs.this;
                    notifs.abrir_secc(notifs.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                notifs.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        notifs.this.abrir_secc(notifs.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (notifs.this.mAd_visto) {
                            notifs.this.abrir_secc(notifs.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        notifs.this.mAd_visto = true;
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
                if (notifs.this.mAd_visto) {
                    notifs notifs = notifs.this;
                    notifs.abrir_secc(notifs.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
