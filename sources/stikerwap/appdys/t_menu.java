package stikerwap.appdys;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
import stikerwap.appdys.config;

public class t_menu extends ListActivity implements Activity_ext, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    boolean buscador_on = false;
    String cbtn;
    ProgressDialog dialog_cargando;
    boolean finalizar = false;
    config globales;
    int j_glob;
    RewardedVideo mAd_appnext;
    RewardedVideoAd mAd_fb;
    StartAppAd mAd_st;
    boolean mAd_visto = false;
    int position_abrir_secc;
    final RewardedAdLoadCallback ralc = new RewardedAdLoadCallback() {
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            config config = t_menu.this.globales;
            t_menu t_menu = t_menu.this;
            if (!config.admob_rew_failed(t_menu, t_menu.mAd_appnext)) {
                t_menu.this.dialog_cargando.cancel();
                t_menu.this.abrir_secc((View) null);
            }
        }

        public void onAdLoaded(RewardedAd rewardedAd) {
            t_menu.this.dialog_cargando.cancel();
            rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                public void onAdShowedFullScreenContent() {
                }

                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    t_menu.this.abrir_secc((View) null);
                }

                public void onAdDismissedFullScreenContent() {
                    if (t_menu.this.mAd_visto) {
                        t_menu.this.abrir_secc((View) null);
                    }
                }
            });
            rewardedAd.show(t_menu.this, new OnUserEarnedRewardListener() {
                public void onUserEarnedReward(RewardItem rewardItem) {
                    t_menu.this.mAd_visto = true;
                    config.rew_visto(t_menu.this);
                }
            });
        }
    };
    int[] values_ind;

    public void onAdClicked(Ad ad) {
    }

    public void onClick(View view) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        this.cbtn = config.aplicar_color_dialog(this.globales.c1, this.globales.c_icos);
        String str = this.globales.c1;
        if (!config.esClaro("#" + str)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        config.aplicar_color_top(this, this.globales.c1);
        this.j_glob = 0;
        int i = this.globales.nsecc_visibles;
        if (this.globales.privacy_enmenu) {
            i++;
        }
        String[] strArr = new String[i];
        this.values_ind = new int[i];
        for (int i2 = 0; i2 < this.globales.secciones_a.length; i2++) {
            if (!this.globales.secciones_a[i2].oculta) {
                strArr[this.j_glob] = this.globales.secciones_a[i2].titulo;
                int[] iArr = this.values_ind;
                int i3 = this.j_glob;
                iArr[i3] = i2;
                this.j_glob = i3 + 1;
            }
        }
        if (this.globales.privacy_enmenu) {
            strArr[this.j_glob] = getResources().getString(R.string.privacidad);
            this.values_ind[this.j_glob] = -123;
        }
        if (getResources().getBoolean(R.bool.es_rtl)) {
            getListView().setTextDirection(4);
        }
        setListAdapter(new ArrayAdapter(this, 17367043, strArr));
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView listView, View view, int i, long j) {
        if (!this.globales.privacy_enmenu || this.values_ind[i] != -123) {
            view.setId(this.globales.menu_a_secciones[i]);
            view.setTag(R.id.TAG_IDSECC, Integer.valueOf(this.globales.menu_a_secciones[i]));
            this.position_abrir_secc = i;
            if ((this.globales.appnext_rew_cod == null || this.globales.appnext_rew_cod.equals("")) && ((this.globales.precio_secc == null || this.globales.precio_secc.equals("")) && ((this.globales.admob_rew_cod == null || this.globales.admob_rew_cod.equals("")) && ((this.globales.fb_rew_cod == null || this.globales.fb_rew_cod.equals("")) && ((this.globales.st_rew_cod == null || this.globales.st_rew_cod.equals("")) && ((this.globales.pollfish_cod == null || this.globales.pollfish_cod.equals("")) && ((this.globales.uni_rew_cod == null || this.globales.uni_rew_cod.equals("")) && (this.globales.is_rew_cod == null || this.globales.is_rew_cod.equals(""))))))))) {
                abrir_secc((View) null);
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
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.dialog_cargando = progressDialog;
            if (!this.globales.rewarded(this, view, this.cbtn, progressDialog, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, (View) null)) {
                abrir_secc((View) null);
                return;
            }
            return;
        }
        new config.cargarprivacidad_glob(this, this.globales.c_icos, config.aplicar_color_dialog(this.globales.c1, this.globales.c_icos)).execute(new String[0]);
    }

    public void abrir_secc(View view) {
        ResultGetIntent crear_rgi = this.globales.crear_rgi(Integer.valueOf(this.values_ind[this.position_abrir_secc]), this);
        this.finalizar = true;
        Intent intent = new Intent();
        intent.putExtra("finalizar", crear_rgi.finalizar);
        setResult(-1, intent);
        if (this.globales.tipomenu != 2) {
            crear_rgi.i.putExtra("es_root", true);
        }
        startActivity(crear_rgi.i);
        finish();
    }

    public void onStop() {
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
        }
    }

    public void adLoaded(String str, AppnextAdCreativeType appnextAdCreativeType) {
        this.dialog_cargando.cancel();
        this.mAd_appnext.showAd();
    }

    public void onAdClosed() {
        if (this.mAd_visto) {
            abrir_secc((View) null);
        }
    }

    public void adError(String str) {
        this.dialog_cargando.cancel();
        abrir_secc((View) null);
    }

    public void videoEnded() {
        this.mAd_visto = true;
        config.rew_visto(this);
    }

    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        this.dialog_cargando.cancel();
        abrir_secc((View) null);
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
            abrir_secc((View) null);
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
                if (t_menu.this.mAd_visto) {
                    t_menu.this.abrir_secc((View) null);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc((View) null);
    }
}
