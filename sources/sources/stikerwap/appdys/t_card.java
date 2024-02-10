package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.cast.MediaTrack;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.startapp.sdk.ads.banner.Mrec;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.wortise.ads.banner.BannerAd;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class t_card extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    ArrayList<Anun> anun_a;
    boolean atras_pulsado = false;
    String c1;
    boolean c1_esclaro;
    String c2;
    boolean c2_esclaro;
    cargar_cards c_c;
    cargar_fotos c_f;
    cargar_fotos_opc c_f_o;
    ArrayList<Card> cards_a;
    int dp100;
    int dp12;
    int dp16;
    int dp2;
    int dp3;
    int dp4;
    int dp8;
    Bundle extras;
    config globales;
    int idsec;
    long idusu;
    int ind_abrir_secc = -1;
    int ind_appnext;
    int ind_secc;
    boolean ironsource_mostrado = false;
    boolean mAd_visto = false;
    ListView mDrawerList;
    ArrayList<Opc> opcs_a;
    ProgressBar pb;
    SharedPreferences settings;
    ArrayList<BannerAd> wortise_ads;

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
        this.c1 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
        this.c2 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c2;
        this.c1_esclaro = config.esClaro("#" + this.c1);
        this.c2_esclaro = config.esClaro("#" + this.c2);
        this.cbtn = config.aplicar_color_dialog(this.c1, this.globales.c_icos);
        if (!this.c1_esclaro) {
            setTheme(R.style.holonolight);
        }
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        this.ind_secc = this.globales.ind_secc_sel_2;
        this.idsec = this.globales.secciones_a[this.ind_secc].id;
        super.onCreate(bundle);
        this.dp2 = config.dp_to_px(this, 2);
        this.dp3 = config.dp_to_px(this, 3);
        this.dp4 = config.dp_to_px(this, 4);
        this.dp8 = config.dp_to_px(this, 8);
        this.dp12 = config.dp_to_px(this, 12);
        this.dp16 = config.dp_to_px(this, 16);
        this.dp100 = config.dp_to_px(this, 100);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        setContentView(R.layout.t_card);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_card.this.finalizar = false;
                t_card.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_card.this.buscador_on = false;
            }
        });
        config config2 = this.globales;
        Bundle bundle2 = this.extras;
        boolean z = bundle2 != null && bundle2.containsKey("ad_entrar");
        Bundle bundle3 = this.extras;
        config2.toca_int(this, z, bundle3 != null && bundle3.containsKey("fb_entrar"));
        this.anun = this.globales.mostrar_banner(this, false);
        config config3 = this.globales;
        config3.oncreate_popup(this, config3.ind_secc_sel_2, this.cbtn, bundle);
        if (!this.c1.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.c1), Color.parseColor("#" + this.c2)}));
        }
        if (this.c1_esclaro) {
            this.pb = (ProgressBar) findViewById(R.id.pb_inv);
        } else {
            this.pb = (ProgressBar) findViewById(R.id.pb);
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color(this.pb, this.globales.c_icos);
        }
        if (this.globales.fondo_v > 0) {
            this.settings.registerOnSharedPreferenceChangeListener(this);
        }
        if (this.globales.fondo_v > 0 && this.settings.getInt("fondo_v_act", 0) == this.globales.fondo_v) {
            try {
                this.globales.tratar_fondo((ImageView) findViewById(R.id.iv_fondo), Boolean.valueOf(this.globales.fondo_margen), this.globales.fondo_tipo);
                this.globales.file_to_iv("fondo", (ImageView) findViewById(R.id.iv_fondo));
            } catch (Exception unused) {
            }
        }
        if (config.isNetworkAvailable(this)) {
            int i = this.globales.secciones_a[this.ind_secc].v;
            SharedPreferences sharedPreferences2 = this.settings;
            if (i > sharedPreferences2.getInt(CmcdHeadersFactory.STREAMING_FORMAT_SS + this.idsec + "_v_guardado", -1)) {
                cargar_cards cargar_cards2 = new cargar_cards(0);
                this.c_c = cargar_cards2;
                cargar_cards2.execute(new String[0]);
                return;
            }
            mostrar_cards();
            return;
        }
        mostrar_cards();
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
        if (!this.globales.rewarded(this, view, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
            abrir_secc(view);
        }
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

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.equals("fondo_v_act")) {
            try {
                this.globales.tratar_fondo((ImageView) findViewById(R.id.iv_fondo), Boolean.valueOf(this.globales.fondo_margen), this.globales.fondo_tipo);
                ((ImageView) findViewById(R.id.iv_fondo)).setVisibility(8);
                this.globales.file_to_iv("fondo", (ImageView) findViewById(R.id.iv_fondo));
                config.fade_in((ImageView) findViewById(R.id.iv_fondo));
            } catch (Exception unused) {
            }
        }
    }

    private class Card {
        boolean btn_pendiente;
        String btn_v;
        int id;
        boolean logo_pendiente;
        String logo_v;
        boolean main_pendiente;
        String main_v;

        private Card() {
            this.main_pendiente = false;
            this.logo_pendiente = false;
            this.btn_pendiente = false;
        }
    }

    private class Opc {
        int id;
        int idcard;
        boolean pendiente;
        String v;

        private Opc() {
            this.pendiente = false;
        }
    }

    private class Anun {
        NativeAd fb_ad;
        int idcard;

        private Anun() {
        }
    }

    /* access modifiers changed from: private */
    public void mostrar_cards() {
        LayoutInflater layoutInflater;
        String[] strArr;
        String str;
        int i;
        t_card t_card;
        LinearLayout linearLayout;
        int i2;
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i4;
        int i5;
        String str8;
        Anun anun2;
        int i6;
        String str9;
        String str10;
        int i7;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Card card;
        t_card t_card2;
        LayoutInflater layoutInflater2;
        int i8;
        LinearLayout linearLayout2;
        Card card2;
        String str16;
        LayoutInflater layoutInflater3;
        int parseInt;
        LinearLayout linearLayout3;
        String str17;
        HorizontalScrollView horizontalScrollView;
        int i9;
        String str18;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        String str19;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        int i10;
        LayoutInflater layoutInflater4;
        ProgressBar progressBar3;
        t_card t_card3 = this;
        String str20 = "";
        String string = t_card3.settings.getString("cards_" + t_card3.idsec, str20);
        if (!string.equals(str20)) {
            String str21 = ";";
            String[] split = string.split(str21);
            t_card3.cards_a = new ArrayList<>();
            t_card3.opcs_a = new ArrayList<>();
            t_card3.anun_a = new ArrayList<>();
            t_card3.wortise_ads = new ArrayList<>();
            t_card3.ind_appnext = -1;
            LinearLayout linearLayout7 = (LinearLayout) t_card3.findViewById(R.id.llcards);
            LayoutInflater layoutInflater5 = (LayoutInflater) t_card3.getSystemService("layout_inflater");
            char c = 0;
            int i11 = 0;
            while (!split[i11].equals(str20) && !split[i11].equals(ExifInterface.LATITUDE_SOUTH) && !split[i11].equals("N")) {
                String str22 = ",";
                String[] split2 = split[i11].split(str22);
                String str23 = "0";
                String str24 = "@Y@";
                String str25 = "@X@";
                if (split2[1].equals(str23)) {
                    Card card3 = new Card();
                    card3.id = Integer.parseInt(split2[c]);
                    CardView cardView = new CardView(t_card3);
                    if (t_card3.globales.f_focus_tv(cardView) && i11 == 0) {
                        cardView.requestFocus();
                    }
                    String str26 = "id";
                    LinearLayout linearLayout8 = linearLayout7;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    int i12 = t_card3.dp4;
                    layoutParams.setMargins(0, i12, 0, i12);
                    cardView.setLayoutParams(layoutParams);
                    LinearLayout linearLayout9 = new LinearLayout(t_card3);
                    strArr = split;
                    linearLayout9.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    linearLayout9.setOrientation(1);
                    String str27 = "#";
                    if (!split2[44].equals(str20)) {
                        try {
                            cardView.setCardBackgroundColor(Color.parseColor(str27 + split2[44]));
                        } catch (Exception unused) {
                        }
                    }
                    if (split2[2].equals(str23)) {
                        cardView.setCardBackgroundColor(0);
                        cardView.setCardElevation(0.0f);
                    } else {
                        cardView.setUseCompatPadding(true);
                        cardView.setCardElevation((float) t_card3.dp2);
                    }
                    if (!split2[3].equals(str23)) {
                        cardView.setTag(R.id.idaux1, split2[3]);
                        cardView.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                View view2 = new View(t_card.this);
                                config config = t_card.this.globales;
                                int indexOf = config.secciones_alist.indexOf(Integer.valueOf(Integer.parseInt((String) view.getTag(R.id.idaux1))));
                                view2.setId(indexOf);
                                view2.setTag(R.id.TAG_IDSECC, Integer.valueOf(indexOf));
                                if (t_card.this.globales.appnext_rew_cod != null && !t_card.this.globales.appnext_rew_cod.equals("")) {
                                    t_card t_card = t_card.this;
                                    t_card t_card2 = t_card.this;
                                    t_card.mAd_appnext = new RewardedVideo((Context) t_card2, t_card2.globales.appnext_rew_cod);
                                }
                                if (t_card.this.globales.admob_rew_cod != null) {
                                    t_card.this.globales.admob_rew_cod.equals("");
                                }
                                if (t_card.this.globales.fb_rew_cod != null && !t_card.this.globales.fb_rew_cod.equals("")) {
                                    t_card t_card3 = t_card.this;
                                    t_card t_card4 = t_card.this;
                                    t_card3.mAd_fb = new RewardedVideoAd(t_card4, t_card4.globales.fb_rew_cod);
                                }
                                if (t_card.this.globales.st_rew_cod != null && !t_card.this.globales.st_rew_cod.equals("")) {
                                    t_card.this.mAd_st = new StartAppAd(t_card.this);
                                }
                                t_card.this.dialog_cargando = new ProgressDialog(t_card.this);
                                t_card.this.v_abrir_secc = null;
                                t_card.this.ind_abrir_secc = indexOf;
                                config config2 = t_card.this.globales;
                                t_card t_card5 = t_card.this;
                                if (!config2.rewarded(t_card5, view2, t_card5.cbtn, t_card.this.dialog_cargando, t_card.this.ralc, t_card.this.mAd_appnext, t_card.this.mAd_fb, t_card.this.mAd_st, t_card.this.v_abrir_secc)) {
                                    t_card.this.globales.abrir_go(t_card.this, indexOf);
                                }
                            }
                        });
                    } else if (!split2[4].equals(str20)) {
                        cardView.setTag(R.id.idaux1, split2[4].replace(str25, str22).replace(str24, str21));
                        if (split2[46].equals(str23)) {
                            cardView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    String str = (String) view.getTag(R.id.idaux1);
                                    str.toLowerCase();
                                    ResultGetIntent intent_porURL = t_card.this.globales.getIntent_porURL(str, t_card.this);
                                    if (!(intent_porURL.i == null || intent_porURL.i.getAction() == null || !intent_porURL.i.getAction().equals("android.intent.action.VIEW"))) {
                                        Intent intent = new Intent(t_card.this, t_url.class);
                                        intent.putExtra("url", str);
                                        intent_porURL.i = intent;
                                    }
                                    if (intent_porURL.finalizar) {
                                        t_card.this.finalizar = true;
                                        Intent intent2 = new Intent();
                                        intent2.putExtra("finalizar", true);
                                        intent2.putExtra("finalizar_app", intent_porURL.finalizar_app);
                                        t_card.this.setResult(-1, intent2);
                                    }
                                    if (intent_porURL.esmas) {
                                        t_card.this.startActivityForResult(intent_porURL.i, 0);
                                    } else if (intent_porURL.i != null) {
                                        if (intent_porURL.finalizar) {
                                            t_card.this.es_root = false;
                                            if (t_card.this.globales.tipomenu != 2) {
                                                intent_porURL.i.putExtra("es_root", true);
                                            }
                                            try {
                                                t_card.this.startActivity(intent_porURL.i);
                                            } catch (Exception unused) {
                                            }
                                        } else {
                                            t_card.this.startActivityForResult(intent_porURL.i, 0);
                                        }
                                    }
                                    if (t_card.this.finalizar && !t_card.this.buscador_on) {
                                        t_card.this.finish();
                                    }
                                }
                            });
                        } else {
                            cardView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    ResultGetIntent intent_porURL = t_card.this.globales.getIntent_porURL((String) view.getTag(R.id.idaux1), t_card.this);
                                    if (intent_porURL.finalizar) {
                                        t_card.this.finalizar = true;
                                        Intent intent = new Intent();
                                        intent.putExtra("finalizar", true);
                                        intent.putExtra("finalizar_app", intent_porURL.finalizar_app);
                                        t_card.this.setResult(-1, intent);
                                    }
                                    if (intent_porURL.esmas) {
                                        t_card.this.startActivityForResult(intent_porURL.i, 0);
                                    } else if (intent_porURL.i != null) {
                                        if (intent_porURL.finalizar) {
                                            t_card.this.es_root = false;
                                            if (t_card.this.globales.tipomenu != 2) {
                                                intent_porURL.i.putExtra("es_root", true);
                                            }
                                            try {
                                                t_card.this.startActivity(intent_porURL.i);
                                            } catch (Exception unused) {
                                            }
                                        } else {
                                            t_card.this.startActivityForResult(intent_porURL.i, 0);
                                        }
                                    }
                                    if (t_card.this.finalizar && !t_card.this.buscador_on) {
                                        t_card.this.finish();
                                    }
                                }
                            });
                        }
                    }
                    int i13 = i11;
                    CardView cardView2 = cardView;
                    int i14 = 1;
                    for (int i15 = 5; i14 < i15; i15 = 5) {
                        int i16 = i13;
                        String str28 = "1";
                        if (!split2[i15].equals(str20 + i14) || !split2[43].equals(str28)) {
                            String str29 = str23;
                            LayoutInflater layoutInflater6 = layoutInflater5;
                            String str30 = split2[6];
                            StringBuilder sb = new StringBuilder(str20);
                            int i17 = i14;
                            sb.append(i17);
                            if (str30.equals(sb.toString())) {
                                RelativeLayout relativeLayout = (RelativeLayout) layoutInflater6.inflate(R.layout.t_card_cab, (ViewGroup) null);
                                LinearLayout linearLayout10 = (LinearLayout) relativeLayout.findViewById(R.id.ll_tit);
                                int i18 = i17;
                                LinearLayout linearLayout11 = (LinearLayout) relativeLayout.findViewById(R.id.ll_tit_2);
                                if (!split2[14].equals(str20)) {
                                    StringBuilder sb2 = new StringBuilder(str27);
                                    linearLayout4 = linearLayout9;
                                    sb2.append(split2[14]);
                                    relativeLayout.setBackgroundColor(Color.parseColor(sb2.toString()));
                                } else {
                                    linearLayout4 = linearLayout9;
                                }
                                if (split2[15].equals(str28)) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout10.getLayoutParams();
                                    layoutParams2.addRule(13);
                                    linearLayout10.setLayoutParams(layoutParams2);
                                } else {
                                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout10.getLayoutParams();
                                    layoutParams3.addRule(20);
                                    linearLayout10.setLayoutParams(layoutParams3);
                                }
                                if (split2[16].equals(str28)) {
                                    int parseInt2 = Integer.parseInt(split2[17]);
                                    SharedPreferences sharedPreferences = t_card3.settings;
                                    linearLayout6 = linearLayout11;
                                    StringBuilder sb3 = new StringBuilder("c3008836_");
                                    linearLayout5 = linearLayout10;
                                    sb3.append(card3.id);
                                    sb3.append("_logo_v");
                                    if (parseInt2 > sharedPreferences.getInt(sb3.toString(), -1)) {
                                        card3.logo_pendiente = true;
                                        card3.logo_v = split2[17];
                                        if (t_card3.c1_esclaro) {
                                            progressBar2 = (ProgressBar) relativeLayout.findViewById(R.id.pb_logo_inv);
                                        } else {
                                            progressBar2 = (ProgressBar) relativeLayout.findViewById(R.id.pb_logo);
                                        }
                                        if (Build.VERSION.SDK_INT > 20) {
                                            config.progress_color(progressBar2, t_card3.globales.c_icos);
                                        }
                                        progressBar2.setVisibility(0);
                                    } else {
                                        File file = new File(getApplicationContext().getFilesDir(), "c3008836_" + card3.id + "_logo.png");
                                        if (file.exists()) {
                                            try {
                                                ((ImageView) relativeLayout.findViewById(R.id.iv_cab_card)).setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file)));
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            } catch (OutOfMemoryError unused2) {
                                            }
                                        }
                                    }
                                    if (!split2[18].trim().equals(str20) || !split2[21].trim().equals(str20)) {
                                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                                        layoutParams4.setMargins(0, 0, t_card3.dp12, 0);
                                        layoutParams4.setMarginStart(0);
                                        layoutParams4.setMarginEnd(t_card3.dp12);
                                        ((FrameLayout) relativeLayout.findViewById(R.id.fl_cab_card)).setLayoutParams(layoutParams4);
                                        ((ImageView) relativeLayout.findViewById(R.id.iv_cab_card)).setMaxHeight(t_card3.dp100);
                                    } else {
                                        ((ImageView) relativeLayout.findViewById(R.id.iv_cab_card)).setMaxHeight(t_card3.dp100);
                                    }
                                    relativeLayout.findViewById(R.id.fl_cab_card).setVisibility(0);
                                } else {
                                    linearLayout6 = linearLayout11;
                                    linearLayout5 = linearLayout10;
                                }
                                String trim = split2[18].trim();
                                if (!trim.equals(str20)) {
                                    TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_tit);
                                    textView.setTextSize(Float.parseFloat(split2[20]));
                                    textView.setTextColor(Color.parseColor(str27 + split2[19]));
                                    textView.setText(trim.replace(str25, str22).replace(str24, str21));
                                    textView.setVisibility(0);
                                }
                                String trim2 = split2[21].trim();
                                if (!trim2.equals(str20)) {
                                    TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_subtit);
                                    textView2.setTextSize(Float.parseFloat(split2[23]));
                                    textView2.setTextColor(Color.parseColor(str27 + split2[22]));
                                    textView2.setText(trim2.replace(str25, str22).replace(str24, str21));
                                    textView2.setVisibility(0);
                                }
                                if (split2[16].equals(str28) || !split2[18].trim().equals(str20) || !split2[21].trim().equals(str20)) {
                                    linearLayout5.setVisibility(0);
                                    if (!split2[18].trim().equals(str20) || !split2[21].trim().equals(str20)) {
                                        linearLayout6.setVisibility(0);
                                    }
                                }
                                if (split2[24].equals(str28)) {
                                    if (Integer.parseInt(split2[25]) > t_card3.settings.getInt("c3008836_" + card3.id + "_btn_v", -1)) {
                                        card3.btn_pendiente = true;
                                        card3.btn_v = split2[25];
                                        if (t_card3.c1_esclaro) {
                                            progressBar = (ProgressBar) relativeLayout.findViewById(R.id.pb_btn_inv);
                                        } else {
                                            progressBar = (ProgressBar) relativeLayout.findViewById(R.id.pb_btn);
                                        }
                                        if (Build.VERSION.SDK_INT > 20) {
                                            config.progress_color(progressBar, t_card3.globales.c_icos);
                                        }
                                        progressBar.setVisibility(0);
                                    } else {
                                        File file2 = new File(getApplicationContext().getFilesDir(), "c3008836_" + card3.id + "_btn.png");
                                        if (file2.exists()) {
                                            try {
                                                ((ImageView) relativeLayout.findViewById(R.id.iv_btn)).setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file2)));
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            } catch (OutOfMemoryError unused3) {
                                            }
                                        }
                                    }
                                    relativeLayout.findViewById(R.id.fl_btn).setVisibility(0);
                                } else if (!split2[26].trim().equals(str20)) {
                                    TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_btn);
                                    textView3.setTextSize(Float.parseFloat(split2[28]));
                                    textView3.setTextColor(Color.parseColor(str27 + split2[27]));
                                    if (!split2[29].equals(str20)) {
                                        textView3.setBackgroundResource(R.drawable.fondo_rounded_2);
                                        ((GradientDrawable) textView3.getBackground()).setColor(Color.parseColor(str27 + split2[29]));
                                    }
                                    textView3.setText(split2[26].trim().replace(str25, str22).replace(str24, str21));
                                    textView3.setVisibility(0);
                                }
                                if (split2[24].equals(str28) || !split2[26].trim().equals(str20)) {
                                    LinearLayout linearLayout12 = (LinearLayout) relativeLayout.findViewById(R.id.ll_btn);
                                    linearLayout12.setVisibility(0);
                                    str19 = str29;
                                    if (!split2[30].equals(str19)) {
                                        linearLayout12.setTag(R.id.idaux1, split2[30]);
                                        linearLayout12.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View view) {
                                                View view2 = new View(t_card.this);
                                                config config = t_card.this.globales;
                                                int indexOf = config.secciones_alist.indexOf(Integer.valueOf(Integer.parseInt((String) view.getTag(R.id.idaux1))));
                                                view2.setId(indexOf);
                                                view2.setTag(R.id.TAG_IDSECC, Integer.valueOf(indexOf));
                                                if (t_card.this.globales.appnext_rew_cod != null && !t_card.this.globales.appnext_rew_cod.equals("")) {
                                                    t_card t_card = t_card.this;
                                                    t_card t_card2 = t_card.this;
                                                    t_card.mAd_appnext = new RewardedVideo((Context) t_card2, t_card2.globales.appnext_rew_cod);
                                                }
                                                if (t_card.this.globales.admob_rew_cod != null) {
                                                    t_card.this.globales.admob_rew_cod.equals("");
                                                }
                                                if (t_card.this.globales.fb_rew_cod != null && !t_card.this.globales.fb_rew_cod.equals("")) {
                                                    t_card t_card3 = t_card.this;
                                                    t_card t_card4 = t_card.this;
                                                    t_card3.mAd_fb = new RewardedVideoAd(t_card4, t_card4.globales.fb_rew_cod);
                                                }
                                                if (t_card.this.globales.st_rew_cod != null && !t_card.this.globales.st_rew_cod.equals("")) {
                                                    t_card.this.mAd_st = new StartAppAd(t_card.this);
                                                }
                                                t_card.this.dialog_cargando = new ProgressDialog(t_card.this);
                                                t_card.this.v_abrir_secc = null;
                                                t_card.this.ind_abrir_secc = indexOf;
                                                config config2 = t_card.this.globales;
                                                t_card t_card5 = t_card.this;
                                                if (!config2.rewarded(t_card5, view2, t_card5.cbtn, t_card.this.dialog_cargando, t_card.this.ralc, t_card.this.mAd_appnext, t_card.this.mAd_fb, t_card.this.mAd_st, t_card.this.v_abrir_secc)) {
                                                    t_card.this.globales.abrir_go(t_card.this, indexOf);
                                                }
                                            }
                                        });
                                    } else if (!split2[31].equals(str20)) {
                                        linearLayout12.setTag(R.id.idaux1, split2[31].replace(str25, str22).replace(str24, str21));
                                        if (split2[47].equals(str19)) {
                                            linearLayout12.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View view) {
                                                    String str = (String) view.getTag(R.id.idaux1);
                                                    str.toLowerCase();
                                                    ResultGetIntent intent_porURL = t_card.this.globales.getIntent_porURL(str, t_card.this);
                                                    if (!(intent_porURL.i == null || intent_porURL.i.getAction() == null || !intent_porURL.i.getAction().equals("android.intent.action.VIEW"))) {
                                                        Intent intent = new Intent(t_card.this, t_url.class);
                                                        intent.putExtra("url", str);
                                                        intent_porURL.i = intent;
                                                    }
                                                    if (intent_porURL.finalizar) {
                                                        t_card.this.finalizar = true;
                                                        Intent intent2 = new Intent();
                                                        intent2.putExtra("finalizar", true);
                                                        intent2.putExtra("finalizar_app", intent_porURL.finalizar_app);
                                                        t_card.this.setResult(-1, intent2);
                                                    }
                                                    if (intent_porURL.esmas) {
                                                        t_card.this.startActivityForResult(intent_porURL.i, 0);
                                                    } else if (intent_porURL.i != null) {
                                                        if (intent_porURL.finalizar) {
                                                            t_card.this.es_root = false;
                                                            if (t_card.this.globales.tipomenu != 2) {
                                                                intent_porURL.i.putExtra("es_root", true);
                                                            }
                                                            try {
                                                                t_card.this.startActivity(intent_porURL.i);
                                                            } catch (Exception unused) {
                                                            }
                                                        } else {
                                                            t_card.this.startActivityForResult(intent_porURL.i, 0);
                                                        }
                                                    }
                                                    if (t_card.this.finalizar && !t_card.this.buscador_on) {
                                                        t_card.this.finish();
                                                    }
                                                }
                                            });
                                        } else {
                                            linearLayout12.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View view) {
                                                    ResultGetIntent intent_porURL = t_card.this.globales.getIntent_porURL((String) view.getTag(R.id.idaux1), t_card.this);
                                                    if (intent_porURL.finalizar) {
                                                        t_card.this.finalizar = true;
                                                        Intent intent = new Intent();
                                                        intent.putExtra("finalizar", true);
                                                        intent.putExtra("finalizar_app", intent_porURL.finalizar_app);
                                                        t_card.this.setResult(-1, intent);
                                                    }
                                                    if (intent_porURL.esmas) {
                                                        t_card.this.startActivityForResult(intent_porURL.i, 0);
                                                    } else if (intent_porURL.i != null) {
                                                        if (intent_porURL.finalizar) {
                                                            t_card.this.es_root = false;
                                                            if (t_card.this.globales.tipomenu != 2) {
                                                                intent_porURL.i.putExtra("es_root", true);
                                                            }
                                                            try {
                                                                t_card.this.startActivity(intent_porURL.i);
                                                            } catch (Exception unused) {
                                                            }
                                                        } else {
                                                            t_card.this.startActivityForResult(intent_porURL.i, 0);
                                                        }
                                                    }
                                                    if (t_card.this.finalizar && !t_card.this.buscador_on) {
                                                        t_card.this.finish();
                                                    }
                                                }
                                            });
                                        }
                                    }
                                } else {
                                    str19 = str29;
                                }
                                linearLayout2 = linearLayout4;
                                linearLayout2.addView(relativeLayout);
                                str16 = str24;
                                t_card2 = t_card3;
                                str9 = str20;
                                str14 = str21;
                                str11 = str25;
                                str15 = str19;
                                str10 = str27;
                                layoutInflater3 = layoutInflater6;
                                i7 = i18;
                                str12 = str22;
                                card = card3;
                            } else {
                                linearLayout2 = linearLayout9;
                                int i19 = i17;
                                String str31 = str29;
                                if (!split2[7].equals(str20 + i17) || split2[33].trim().equals(str20)) {
                                    card2 = card3;
                                    if (split2[8].equals(str20 + i17) && (parseInt = Integer.parseInt(split2[45])) > 0) {
                                        if (split2[39].equals(str28) || (split2[39].equals(str31) && split2[41].equals(str28))) {
                                            str12 = str22;
                                            str13 = str24;
                                            str14 = str21;
                                            str11 = str25;
                                            i7 = i17;
                                            Card card4 = card2;
                                            layoutInflater2 = layoutInflater6;
                                            String str32 = str28;
                                            if (!split2[41].equals(str31) || !split2[42].equals(str31)) {
                                                linearLayout3 = (LinearLayout) layoutInflater2.inflate(R.layout.t_card_aux2_cen, (ViewGroup) null);
                                            } else {
                                                linearLayout3 = (LinearLayout) layoutInflater2.inflate(R.layout.t_card_aux2, (ViewGroup) null);
                                            }
                                            TableLayout tableLayout = (TableLayout) linearLayout3.findViewById(R.id.tl_opc);
                                            if (!split2[37].equals(str20)) {
                                                linearLayout3.setBackgroundColor(Color.parseColor(str27 + split2[37]));
                                            }
                                            String str33 = str32;
                                            if (split2[41].equals(str33)) {
                                                tableLayout.setLayoutParams(new TableLayout.LayoutParams(-1, -2));
                                            }
                                            int parseInt3 = Integer.parseInt(split2[40]);
                                            if (split2[39].equals(str31)) {
                                                parseInt3 = 99999;
                                            }
                                            t_card2 = this;
                                            TableRow tableRow = new TableRow(t_card2);
                                            tableRow.setPadding(0, 0, 0, 0);
                                            int i20 = i16 + 1;
                                            int i21 = 0;
                                            while (i20 <= i16 + parseInt) {
                                                i21++;
                                                String str34 = str31;
                                                Card card5 = card4;
                                                int i22 = parseInt;
                                                String str35 = str27;
                                                CardView card_opc = t_card2.card_opc(strArr[i20], card5.id, split2[38].equals(str33));
                                                if (split2[38].equals(str33)) {
                                                    str17 = str20;
                                                    TableRow.LayoutParams layoutParams5 = new TableRow.LayoutParams(-1, -2);
                                                    int i23 = t_card2.dp3;
                                                    layoutParams5.setMargins(i23, i23, i23, i23);
                                                    card_opc.setLayoutParams(layoutParams5);
                                                } else {
                                                    str17 = str20;
                                                }
                                                if (i21 > 1) {
                                                    tableRow.addView((CardView) layoutInflater2.inflate(R.layout.t_card_opc_aux, (ViewGroup) null));
                                                }
                                                tableRow.addView(card_opc);
                                                if (i21 == parseInt3) {
                                                    tableLayout.addView(tableRow);
                                                    TableRow tableRow2 = new TableRow(t_card2);
                                                    tableRow2.setPadding(0, t_card2.dp8, 0, 0);
                                                    tableRow = tableRow2;
                                                    i21 = 0;
                                                }
                                                i20++;
                                                parseInt = i22;
                                                str27 = str35;
                                                str20 = str17;
                                                card4 = card5;
                                                str31 = str34;
                                            }
                                            str9 = str20;
                                            str15 = str31;
                                            str10 = str27;
                                            card = card4;
                                            if (i21 > 0) {
                                                tableLayout.addView(tableRow);
                                            }
                                            int i24 = i20 - 1;
                                            if (split2[41].equals(str33)) {
                                                boolean z = false;
                                                TableRow tableRow3 = (TableRow) tableLayout.getChildAt(0);
                                                if (tableRow3 != null) {
                                                    int i25 = 0;
                                                    while (i25 < tableRow3.getChildCount()) {
                                                        if (i25 % 2 == 0) {
                                                            tableLayout.setColumnStretchable(i25, true);
                                                        } else {
                                                            tableLayout.setColumnShrinkable(i25, z);
                                                        }
                                                        i25++;
                                                        z = false;
                                                    }
                                                }
                                            }
                                            linearLayout2.addView(linearLayout3);
                                            i8 = i24;
                                            i14 = i7 + 1;
                                            layoutInflater5 = layoutInflater2;
                                            t_card3 = t_card2;
                                            card3 = card;
                                            str21 = str14;
                                            str24 = str13;
                                            str22 = str12;
                                            str25 = str11;
                                            str27 = str10;
                                            str20 = str9;
                                            linearLayout9 = linearLayout2;
                                            i13 = i8;
                                            str23 = str15;
                                        } else {
                                            if (split2[42].equals(str28)) {
                                                layoutInflater2 = layoutInflater6;
                                                horizontalScrollView = (HorizontalScrollView) layoutInflater2.inflate(R.layout.t_card_aux1_cen, (ViewGroup) null);
                                            } else {
                                                layoutInflater2 = layoutInflater6;
                                                horizontalScrollView = (HorizontalScrollView) layoutInflater2.inflate(R.layout.t_card_aux1, (ViewGroup) null);
                                            }
                                            LinearLayout linearLayout13 = (LinearLayout) horizontalScrollView.findViewById(R.id.ll_opc);
                                            if (!split2[37].equals(str20)) {
                                                StringBuilder sb4 = new StringBuilder(str27);
                                                str13 = str24;
                                                sb4.append(split2[37]);
                                                horizontalScrollView.setBackgroundColor(Color.parseColor(sb4.toString()));
                                            } else {
                                                str13 = str24;
                                            }
                                            int i26 = i16 + 1;
                                            str14 = str21;
                                            boolean z2 = true;
                                            while (i26 <= i16 + parseInt) {
                                                String str36 = str22;
                                                String str37 = str25;
                                                Card card6 = card2;
                                                int i27 = i17;
                                                Card card7 = card6;
                                                CardView card_opc2 = card_opc(strArr[i26], card6.id, split2[38].equals(str28));
                                                if (!z2) {
                                                    i9 = this.dp8;
                                                } else {
                                                    i9 = split2[38].equals(str28) ? this.dp3 : 0;
                                                }
                                                int i28 = split2[38].equals(str28) ? this.dp3 : 0;
                                                if (i9 > 0 || i28 > 0) {
                                                    str18 = str28;
                                                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                                                    layoutParams6.setMargins(i9, i28, i28, i28);
                                                    layoutParams6.setMarginStart(i9);
                                                    layoutParams6.setMarginEnd(i28);
                                                    card_opc2.setLayoutParams(layoutParams6);
                                                } else {
                                                    str18 = str28;
                                                }
                                                linearLayout13.addView(card_opc2);
                                                i26++;
                                                str28 = str18;
                                                str22 = str36;
                                                str25 = str37;
                                                i17 = i27;
                                                card2 = card7;
                                                z2 = false;
                                            }
                                            str12 = str22;
                                            str11 = str25;
                                            i7 = i17;
                                            Card card8 = card2;
                                            i8 = i26 - 1;
                                            linearLayout2.addView(horizontalScrollView);
                                            t_card2 = this;
                                            str9 = str20;
                                            str15 = str31;
                                            str10 = str27;
                                            card = card8;
                                            i14 = i7 + 1;
                                            layoutInflater5 = layoutInflater2;
                                            t_card3 = t_card2;
                                            card3 = card;
                                            str21 = str14;
                                            str24 = str13;
                                            str22 = str12;
                                            str25 = str11;
                                            str27 = str10;
                                            str20 = str9;
                                            linearLayout9 = linearLayout2;
                                            i13 = i8;
                                            str23 = str15;
                                        }
                                    }
                                } else {
                                    LinearLayout linearLayout14 = new LinearLayout(t_card3);
                                    card2 = card3;
                                    linearLayout14.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                                    int i29 = t_card3.dp16;
                                    linearLayout14.setPadding(i29, i29, i29, i29);
                                    if (!split2[32].equals(str20)) {
                                        linearLayout14.setBackgroundColor(Color.parseColor(str27 + split2[32]));
                                    }
                                    TextView textView4 = new TextView(t_card3);
                                    textView4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                                    if (split2[34].equals(str28)) {
                                        textView4.setGravity(1);
                                    } else if (getResources().getBoolean(R.bool.es_rtl)) {
                                        textView4.setTextDirection(4);
                                    }
                                    textView4.setTextSize(Float.parseFloat(split2[36]));
                                    textView4.setTextColor(Color.parseColor(str27 + split2[35]));
                                    textView4.setText(split2[33].trim().replace(str25, str22).replace(str24, str21));
                                    textView4.setVisibility(0);
                                    linearLayout14.addView(textView4);
                                    linearLayout2.addView(linearLayout14);
                                }
                                t_card2 = this;
                                str12 = str22;
                                str16 = str24;
                                str9 = str20;
                                str14 = str21;
                                str11 = str25;
                                str10 = str27;
                                i7 = i17;
                                layoutInflater3 = layoutInflater6;
                                Card card9 = card2;
                                str15 = str31;
                                card = card9;
                            }
                        } else {
                            String str38 = str23;
                            RelativeLayout relativeLayout2 = (RelativeLayout) layoutInflater5.inflate(R.layout.t_card_img, (ViewGroup) null);
                            String trim3 = split2[10].trim();
                            if (!trim3.equals(str20)) {
                                layoutInflater4 = layoutInflater5;
                                TextView textView5 = (TextView) relativeLayout2.findViewById(R.id.tv_img_descr);
                                i10 = i14;
                                textView5.setTextSize(Float.parseFloat(split2[13]));
                                if (split2[11].equals(str28)) {
                                    textView5.setGravity(1);
                                } else if (getResources().getBoolean(R.bool.es_rtl)) {
                                    textView5.setTextDirection(4);
                                }
                                textView5.setTextColor(Color.parseColor(str27 + split2[12]));
                                textView5.setText(trim3.replace(str25, str22).replace(str24, str21));
                                relativeLayout2.findViewById(R.id.ll_img_descr).setVisibility(0);
                            } else {
                                layoutInflater4 = layoutInflater5;
                                i10 = i14;
                            }
                            if (Integer.parseInt(split2[9]) > t_card3.settings.getInt("c3008836_" + card3.id + "_main_v", -1)) {
                                card3.main_pendiente = true;
                                card3.main_v = split2[9];
                                if (t_card3.c1_esclaro) {
                                    progressBar3 = (ProgressBar) relativeLayout2.findViewById(R.id.pb_main_inv);
                                } else {
                                    progressBar3 = (ProgressBar) relativeLayout2.findViewById(R.id.pb_main);
                                }
                                if (Build.VERSION.SDK_INT > 20) {
                                    config.progress_color(progressBar3, t_card3.globales.c_icos);
                                }
                                progressBar3.setVisibility(0);
                            } else {
                                File file3 = new File(getApplicationContext().getFilesDir(), "c3008836_" + card3.id + "_main.png");
                                if (file3.exists()) {
                                    try {
                                        ((ImageView) relativeLayout2.findViewById(R.id.img)).setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file3)));
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    } catch (OutOfMemoryError unused4) {
                                    }
                                }
                            }
                            linearLayout9.addView(relativeLayout2);
                            str16 = str24;
                            t_card2 = t_card3;
                            str9 = str20;
                            str11 = str25;
                            linearLayout2 = linearLayout9;
                            str10 = str27;
                            str15 = str38;
                            layoutInflater3 = layoutInflater4;
                            i7 = i10;
                            str12 = str22;
                            card = card3;
                            str14 = str21;
                        }
                        i8 = i16;
                        i14 = i7 + 1;
                        layoutInflater5 = layoutInflater2;
                        t_card3 = t_card2;
                        card3 = card;
                        str21 = str14;
                        str24 = str13;
                        str22 = str12;
                        str25 = str11;
                        str27 = str10;
                        str20 = str9;
                        linearLayout9 = linearLayout2;
                        i13 = i8;
                        str23 = str15;
                    }
                    String str39 = str20;
                    String str40 = str21;
                    int i30 = i13;
                    LinearLayout linearLayout15 = linearLayout9;
                    Card card10 = card3;
                    t_card = t_card3;
                    CardView cardView3 = cardView2;
                    cardView3.setTag(str26 + card10.id);
                    cardView3.addView(linearLayout15);
                    linearLayout = linearLayout8;
                    linearLayout.addView(cardView3);
                    t_card.cards_a.add(card10);
                    layoutInflater = layoutInflater5;
                    i2 = i30;
                    str = str39;
                    i = 1;
                } else {
                    String str41 = str22;
                    String str42 = str24;
                    String str43 = str20;
                    String str44 = str21;
                    strArr = split;
                    String str45 = str25;
                    String str46 = "id";
                    linearLayout = linearLayout7;
                    t_card = t_card3;
                    LayoutInflater layoutInflater7 = layoutInflater5;
                    if (!t_card.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getBoolean("sinads", false)) {
                        if (t_card.globales.card_nuestro) {
                            str7 = t_card.globales.card_admob_nuestro;
                            str6 = t_card.globales.card_appnext_nuestro;
                            str2 = t_card.globales.card_fb_nuestro;
                            str3 = t_card.globales.card_st_nuestro;
                            str21 = str44;
                            str5 = str43;
                            str4 = str5;
                        } else {
                            String str47 = str41;
                            String str48 = str45;
                            str21 = str44;
                            String str49 = str42;
                            str7 = split2[2].trim().replace(str48, str47).replace(str49, str21);
                            String replace = split2[3].trim().replace(str48, str47).replace(str49, str21);
                            str2 = split2[4].trim().replace(str48, str47).replace(str49, str21);
                            String replace2 = split2[5].trim().replace(str48, str47).replace(str49, str21);
                            str5 = t_card.globales.is_card_cod;
                            str6 = replace;
                            str3 = replace2;
                            str4 = t_card.globales.wortise_card_cod;
                        }
                        str = str43;
                        if (config.admob_app_id.equals(str)) {
                            str7 = str;
                        }
                        boolean z3 = !str7.equals(str);
                        boolean z4 = !str6.equals(str) && t_card.globales.appnext_ads != null && t_card.globales.appnext_ads.size() > 0;
                        boolean z5 = !str2.equals(str);
                        boolean z6 = !str3.equals(str);
                        boolean z7 = !str5.equals(str) && !t_card.ironsource_mostrado;
                        boolean z8 = !str4.equals(str);
                        i3 = i11;
                        ArrayList arrayList = new ArrayList();
                        if (z3) {
                            arrayList.add(1);
                        }
                        if (!z4 || z8) {
                            layoutInflater = layoutInflater7;
                        } else {
                            layoutInflater = layoutInflater7;
                            arrayList.add(2);
                        }
                        if (z5) {
                            arrayList.add(3);
                        }
                        if (z6) {
                            arrayList.add(4);
                        }
                        if (z7) {
                            arrayList.add(5);
                        }
                        if (z8) {
                            arrayList.add(6);
                        }
                        if (!arrayList.isEmpty()) {
                            i4 = 0;
                            i5 = ((Integer) arrayList.get(new Random().nextInt(((arrayList.size() - 1) - 0) + 1) + 0)).intValue();
                        } else {
                            i4 = 0;
                            i5 = 0;
                        }
                        if (i5 != 0) {
                            anun2 = new Anun();
                            anun2.idcard = Integer.parseInt(split2[i4]);
                            LinearLayout linearLayout16 = new LinearLayout(t_card);
                            str8 = str4;
                            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                            int i31 = t_card.dp4;
                            layoutParams7.setMargins(i4, i31, i4, i31);
                            linearLayout16.setLayoutParams(layoutParams7);
                            linearLayout16.setTag(str46 + split2[i4]);
                            linearLayout.addView(linearLayout16);
                            i6 = 1;
                        } else {
                            str8 = str4;
                            i6 = 1;
                            anun2 = null;
                        }
                        if (i5 == i6) {
                            AdView adView = new AdView(t_card);
                            adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
                            adView.setAdUnitId(str7);
                            LinearLayout linearLayout17 = (LinearLayout) t_card.findViewById(R.id.llcards).findViewWithTag(str46 + anun2.idcard);
                            linearLayout17.setGravity(1);
                            linearLayout17.addView(adView);
                            adView.loadAd(new AdRequest.Builder().build());
                        } else {
                            if (i5 == 2) {
                                int i32 = t_card.ind_appnext + 1;
                                t_card.ind_appnext = i32;
                                if (i32 > t_card.globales.appnext_ads.size() - 1) {
                                    t_card.ind_appnext = 0;
                                }
                                i = 1;
                                t_card.globales.appnext_mostrar_2(this, 1, 3, t_card.ind_appnext, (String) null);
                            } else {
                                i = 1;
                                if (i5 == 3) {
                                    anun2.fb_ad = new NativeAd((Context) t_card, str2);
                                    AnonymousClass9 r0 = new NativeAdListener() {
                                        public void onAdClicked(Ad ad) {
                                        }

                                        public void onError(Ad ad, AdError adError) {
                                        }

                                        public void onLoggingImpression(Ad ad) {
                                        }

                                        public void onMediaDownloaded(Ad ad) {
                                        }

                                        public void onAdLoaded(Ad ad) {
                                            NativeAdViewAttributes backgroundColor = new NativeAdViewAttributes().setTypeface(Typeface.MONOSPACE).setBackgroundColor(config.BLANCO_2);
                                            int i = 0;
                                            if (t_card.this.c2 != null && !t_card.this.c2.equals("")) {
                                                int canviarColor = config.canviarColor(Color.parseColor("#" + t_card.this.c2), 0.2f, 0);
                                                backgroundColor.setBackgroundColor(canviarColor);
                                                if (config.esClaro_int(canviarColor)) {
                                                    backgroundColor.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
                                                    backgroundColor.setDescriptionTextColor(ViewCompat.MEASURED_STATE_MASK);
                                                } else {
                                                    backgroundColor.setTitleTextColor(-1);
                                                    backgroundColor.setDescriptionTextColor(-1);
                                                }
                                            }
                                            NativeAd nativeAd = (NativeAd) ad;
                                            View render = NativeAdView.render(t_card.this, nativeAd, NativeAdView.Type.HEIGHT_300, backgroundColor);
                                            Iterator<Anun> it = t_card.this.anun_a.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                Anun next = it.next();
                                                if (next.fb_ad.equals(nativeAd)) {
                                                    i = next.idcard;
                                                    break;
                                                }
                                            }
                                            if (i != 0) {
                                                View findViewById = t_card.this.findViewById(R.id.llcards);
                                                LinearLayout linearLayout = (LinearLayout) findViewById.findViewWithTag("id" + i);
                                                try {
                                                    if (t_card.this.c2_esclaro) {
                                                        linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                                    } else {
                                                        linearLayout.setBackgroundColor(-1);
                                                    }
                                                    int dp_to_px = config.dp_to_px(t_card.this.getApplicationContext(), 1);
                                                    linearLayout.setPadding(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                linearLayout.addView(render);
                                            }
                                        }
                                    };
                                    t_card.anun_a.add(anun2);
                                    anun2.fb_ad.loadAd(anun2.fb_ad.buildLoadAdConfig().withAdListener(r0).build());
                                } else if (i5 == 4) {
                                    Mrec mrec = new Mrec((Activity) t_card);
                                    mrec.setAdTag("CARD SECTION");
                                    LinearLayout linearLayout18 = (LinearLayout) t_card.findViewById(R.id.llcards).findViewWithTag(str46 + anun2.idcard);
                                    linearLayout18.setGravity(1);
                                    linearLayout18.addView(mrec);
                                } else if (i5 == 5) {
                                    t_card.ironsource_mostrado = true;
                                    if (t_card.globales.isBanner_global != null) {
                                        IronSource.destroyBanner(t_card.globales.isBanner_global);
                                    }
                                    t_card.globales.isBanner_global = IronSource.createBanner(t_card, ISBannerSize.RECTANGLE);
                                    LinearLayout linearLayout19 = (LinearLayout) t_card.findViewById(R.id.llcards).findViewWithTag(str46 + anun2.idcard);
                                    linearLayout19.setGravity(1);
                                    try {
                                        linearLayout19.addView(t_card.globales.isBanner_global);
                                        IronSource.loadBanner(t_card.globales.isBanner_global);
                                    } catch (Exception unused5) {
                                    }
                                } else if (i5 == 6) {
                                    BannerAd bannerAd = new BannerAd(t_card);
                                    bannerAd.setAutoRefresh(false);
                                    bannerAd.setAdSize(com.wortise.ads.AdSize.HEIGHT_250);
                                    bannerAd.setAdUnitId(str8);
                                    final LinearLayout linearLayout20 = (LinearLayout) t_card.findViewById(R.id.llcards).findViewWithTag(str46 + anun2.idcard);
                                    linearLayout20.setGravity(1);
                                    if (z4) {
                                        bannerAd.setListener(new BannerAd.Listener() {
                                            public void onBannerClicked(BannerAd bannerAd) {
                                            }

                                            public void onBannerLoaded(BannerAd bannerAd) {
                                            }

                                            public void onBannerFailed(BannerAd bannerAd, com.wortise.ads.AdError adError) {
                                                Log.e("ara", "wortise banner failed:" + adError.toString());
                                                linearLayout20.removeAllViews();
                                                t_card.this.ind_appnext++;
                                                if (t_card.this.ind_appnext > t_card.this.globales.appnext_ads.size() - 1) {
                                                    t_card.this.ind_appnext = 0;
                                                }
                                                config config = t_card.this.globales;
                                                t_card t_card = t_card.this;
                                                config.appnext_mostrar_2(t_card, 1, 3, t_card.ind_appnext, (String) null);
                                            }
                                        });
                                    }
                                    linearLayout20.addView(bannerAd);
                                    t_card.wortise_ads.add(bannerAd);
                                    bannerAd.loadAd();
                                    i2 = i3;
                                }
                            }
                            i2 = i3;
                        }
                    } else {
                        i3 = i11;
                        layoutInflater = layoutInflater7;
                        str21 = str44;
                        str = str43;
                    }
                    i = 1;
                    i2 = i3;
                }
                i11 = i2 + i;
                linearLayout7 = linearLayout;
                t_card3 = t_card;
                str20 = str;
                split = strArr;
                layoutInflater5 = layoutInflater;
                c = 0;
            }
            t_card t_card4 = t_card3;
            cargar_fotos cargar_fotos2 = t_card4.c_f;
            if (cargar_fotos2 == null || cargar_fotos2.getStatus() != AsyncTask.Status.RUNNING) {
                cargar_fotos cargar_fotos3 = new cargar_fotos();
                t_card4.c_f = cargar_fotos3;
                cargar_fotos3.execute(new String[0]);
            }
            cargar_fotos_opc cargar_fotos_opc2 = t_card4.c_f_o;
            if (cargar_fotos_opc2 == null || cargar_fotos_opc2.getStatus() != AsyncTask.Status.RUNNING) {
                cargar_fotos_opc cargar_fotos_opc3 = new cargar_fotos_opc();
                t_card4.c_f_o = cargar_fotos_opc3;
                cargar_fotos_opc3.execute(new String[0]);
            }
        }
    }

    private CardView card_opc(String str, int i, boolean z) {
        CharSequence charSequence;
        CharSequence charSequence2;
        ProgressBar progressBar;
        Opc opc = new Opc();
        String[] split = str.split(",");
        CardView cardView = (CardView) ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.t_card_opc, (ViewGroup) null);
        this.globales.f_focus_tv(cardView);
        if (!z) {
            cardView.setCardBackgroundColor(0);
            cardView.setCardElevation(0.0f);
        }
        String str2 = split[0];
        opc.id = Integer.parseInt(str2);
        opc.idcard = i;
        cardView.setTag("idopc" + str2);
        if (!split[11].equals("0")) {
            cardView.setTag(R.id.idaux1, split[11]);
            cardView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    View view2 = new View(t_card.this);
                    config config = t_card.this.globales;
                    int indexOf = config.secciones_alist.indexOf(Integer.valueOf(Integer.parseInt((String) view.getTag(R.id.idaux1))));
                    view2.setId(indexOf);
                    view2.setTag(R.id.TAG_IDSECC, Integer.valueOf(indexOf));
                    if (t_card.this.globales.appnext_rew_cod != null && !t_card.this.globales.appnext_rew_cod.equals("")) {
                        t_card t_card = t_card.this;
                        t_card t_card2 = t_card.this;
                        t_card.mAd_appnext = new RewardedVideo((Context) t_card2, t_card2.globales.appnext_rew_cod);
                    }
                    if (t_card.this.globales.admob_rew_cod != null) {
                        t_card.this.globales.admob_rew_cod.equals("");
                    }
                    if (t_card.this.globales.fb_rew_cod != null && !t_card.this.globales.fb_rew_cod.equals("")) {
                        t_card t_card3 = t_card.this;
                        t_card t_card4 = t_card.this;
                        t_card3.mAd_fb = new RewardedVideoAd(t_card4, t_card4.globales.fb_rew_cod);
                    }
                    if (t_card.this.globales.st_rew_cod != null && !t_card.this.globales.st_rew_cod.equals("")) {
                        t_card.this.mAd_st = new StartAppAd(t_card.this);
                    }
                    t_card.this.dialog_cargando = new ProgressDialog(t_card.this);
                    t_card.this.v_abrir_secc = null;
                    t_card.this.ind_abrir_secc = indexOf;
                    config config2 = t_card.this.globales;
                    t_card t_card5 = t_card.this;
                    if (!config2.rewarded(t_card5, view2, t_card5.cbtn, t_card.this.dialog_cargando, t_card.this.ralc, t_card.this.mAd_appnext, t_card.this.mAd_fb, t_card.this.mAd_st, t_card.this.v_abrir_secc)) {
                        t_card.this.globales.abrir_go(t_card.this, indexOf);
                    }
                }
            });
        } else if (!split[12].trim().equals("")) {
            cardView.setTag(R.id.idaux1, split[12].trim().replace("@X@", ",").replace("@Y@", ";"));
            if (split[13].equals("0")) {
                cardView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        String str = (String) view.getTag(R.id.idaux1);
                        str.toLowerCase();
                        ResultGetIntent intent_porURL = t_card.this.globales.getIntent_porURL(str, t_card.this);
                        if (!(intent_porURL.i == null || intent_porURL.i.getAction() == null || !intent_porURL.i.getAction().equals("android.intent.action.VIEW"))) {
                            Intent intent = new Intent(t_card.this, t_url.class);
                            intent.putExtra("url", str);
                            intent_porURL.i = intent;
                        }
                        if (intent_porURL.finalizar) {
                            t_card.this.finalizar = true;
                            Intent intent2 = new Intent();
                            intent2.putExtra("finalizar", true);
                            intent2.putExtra("finalizar_app", intent_porURL.finalizar_app);
                            t_card.this.setResult(-1, intent2);
                        }
                        if (intent_porURL.esmas) {
                            t_card.this.startActivityForResult(intent_porURL.i, 0);
                        } else if (intent_porURL.i != null) {
                            if (intent_porURL.finalizar) {
                                t_card.this.es_root = false;
                                if (t_card.this.globales.tipomenu != 2) {
                                    intent_porURL.i.putExtra("es_root", true);
                                }
                                try {
                                    t_card.this.startActivity(intent_porURL.i);
                                } catch (Exception unused) {
                                }
                            } else {
                                t_card.this.startActivityForResult(intent_porURL.i, 0);
                            }
                        }
                        if (t_card.this.finalizar && !t_card.this.buscador_on) {
                            t_card.this.finish();
                        }
                    }
                });
            } else {
                cardView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ResultGetIntent intent_porURL = t_card.this.globales.getIntent_porURL((String) view.getTag(R.id.idaux1), t_card.this);
                        if (intent_porURL.finalizar) {
                            t_card.this.finalizar = true;
                            Intent intent = new Intent();
                            intent.putExtra("finalizar", true);
                            intent.putExtra("finalizar_app", intent_porURL.finalizar_app);
                            t_card.this.setResult(-1, intent);
                        }
                        if (intent_porURL.esmas) {
                            t_card.this.startActivityForResult(intent_porURL.i, 0);
                        } else if (intent_porURL.i != null) {
                            if (intent_porURL.finalizar) {
                                t_card.this.es_root = false;
                                if (t_card.this.globales.tipomenu != 2) {
                                    intent_porURL.i.putExtra("es_root", true);
                                }
                                try {
                                    t_card.this.startActivity(intent_porURL.i);
                                } catch (Exception unused) {
                                }
                            } else {
                                t_card.this.startActivityForResult(intent_porURL.i, 0);
                            }
                        }
                        if (t_card.this.finalizar && !t_card.this.buscador_on) {
                            t_card.this.finish();
                        }
                    }
                });
            }
        }
        if (!split[2].equals("")) {
            cardView.setCardBackgroundColor(Color.parseColor("#" + split[2]));
        }
        if (split[3].equals("1")) {
            FrameLayout frameLayout = (FrameLayout) cardView.findViewById(R.id.fl_card_opc);
            ImageView imageView = (ImageView) cardView.findViewById(R.id.iv_card_opc);
            if (!split[5].trim().equals("") || !split[8].trim().equals("")) {
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (split[1].equals("1")) {
                    layoutParams.gravity = 17;
                }
                frameLayout.setLayoutParams(layoutParams);
            }
            frameLayout.setVisibility(0);
            int parseInt = Integer.parseInt(split[4]);
            SharedPreferences sharedPreferences = this.settings;
            StringBuilder sb = new StringBuilder("o3008836_");
            charSequence = ";";
            sb.append(opc.id);
            sb.append("_v");
            if (parseInt > sharedPreferences.getInt(sb.toString(), -1)) {
                opc.pendiente = true;
                opc.v = split[4];
                if (this.c1_esclaro) {
                    progressBar = (ProgressBar) cardView.findViewById(R.id.pb_card_opc_inv);
                } else {
                    progressBar = (ProgressBar) cardView.findViewById(R.id.pb_card_opc);
                }
                if (Build.VERSION.SDK_INT > 20) {
                    config.progress_color(progressBar, this.globales.c_icos);
                }
                progressBar.setVisibility(0);
            } else {
                File filesDir = getApplicationContext().getFilesDir();
                File file = new File(filesDir, "o3008836_" + opc.id + ".png");
                if (file.exists()) {
                    try {
                        imageView.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(file)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (OutOfMemoryError unused) {
                    }
                }
            }
        } else {
            charSequence = ";";
        }
        if (!split[5].trim().equals("")) {
            TextView textView = (TextView) cardView.findViewById(R.id.tv_card_tit);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (split[1].equals("1")) {
                textView.setGravity(1);
            } else if (getResources().getBoolean(R.bool.es_rtl)) {
                textView.setTextDirection(4);
            }
            textView.setTextSize(Float.parseFloat(split[7]));
            textView.setTextColor(Color.parseColor("#" + split[6]));
            charSequence2 = charSequence;
            textView.setText(split[5].trim().replace("@X@", ",").replace("@Y@", charSequence2));
            textView.setVisibility(0);
            cardView.findViewById(R.id.ll_opc_txt).setVisibility(0);
        } else {
            charSequence2 = charSequence;
        }
        if (!split[8].trim().equals("")) {
            TextView textView2 = (TextView) cardView.findViewById(R.id.tv_card_subtit);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (split[1].equals("1")) {
                textView2.setGravity(1);
            } else if (getResources().getBoolean(R.bool.es_rtl)) {
                textView2.setTextDirection(4);
            }
            textView2.setTextSize(Float.parseFloat(split[10]));
            textView2.setTextColor(Color.parseColor("#" + split[9]));
            textView2.setText(split[8].trim().replace("@X@", ",").replace("@Y@", charSequence2));
            textView2.setVisibility(0);
            cardView.findViewById(R.id.ll_opc_txt).setVisibility(0);
        }
        this.opcs_a.add(opc);
        return cardView;
    }

    private class cargar_cards extends AsyncTask<String, Void, String> {
        int ind_ini;

        cargar_cards(int i) {
            this.ind_ini = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            t_card.this.pb.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0094  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090 }
                r0.<init>()     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = "/srv/obtener_cards.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                stikerwap.appdys.t_card r1 = stikerwap.appdys.t_card.this     // Catch:{ Exception -> 0x0090 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = "&ind_ini="
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                int r1 = r5.ind_ini     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r1 = "&idsec="
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                stikerwap.appdys.t_card r1 = stikerwap.appdys.t_card.this     // Catch:{ Exception -> 0x0090 }
                int r1 = r1.idsec     // Catch:{ Exception -> 0x0090 }
                r0.append(r1)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0090 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0090 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0090 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x0090 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0090 }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r6.<init>()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
            L_0x0062:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                if (r2 == 0) goto L_0x007d
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r3.<init>()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r3.append(r2)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                r6.append(r2)     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                goto L_0x0062
            L_0x007d:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0089, all -> 0x0087 }
                if (r0 == 0) goto L_0x0086
                r0.disconnect()
            L_0x0086:
                return r6
            L_0x0087:
                r6 = move-exception
                goto L_0x0098
            L_0x0089:
                r6 = r0
                goto L_0x0090
            L_0x008b:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x0098
            L_0x0090:
                java.lang.String r0 = ""
                if (r6 == 0) goto L_0x0097
                r6.disconnect()
            L_0x0097:
                return r0
            L_0x0098:
                if (r0 == 0) goto L_0x009d
                r0.disconnect()
            L_0x009d:
                goto L_0x009f
            L_0x009e:
                throw r6
            L_0x009f:
                goto L_0x009e
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_card.cargar_cards.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            try {
                t_card.this.pb.setVisibility(8);
            } catch (Exception unused) {
            }
            if (str.contains("ANDROID:OK DATOS:")) {
                SharedPreferences.Editor edit = t_card.this.settings.edit();
                edit.putString("cards_" + t_card.this.idsec, str.substring(str.indexOf("DATOS:") + 6).trim());
                edit.putInt(CmcdHeadersFactory.STREAMING_FORMAT_SS + t_card.this.idsec + "_v_guardado", t_card.this.globales.secciones_a[t_card.this.ind_secc].v);
                edit.commit();
            }
            t_card.this.mostrar_cards();
        }
    }

    private class cargar_fotos extends AsyncTask<String, Void, String> {
        String archivo;
        Bitmap bmImg;
        int i_cargando;
        int tipo_cargando;
        String tipo_str;
        String v;

        private cargar_fotos() {
            this.i_cargando = -1;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_card.this.cards_a != null && t_card.this.globales.c1 != null) {
                int i = 0;
                while (i < t_card.this.cards_a.size()) {
                    Card card = t_card.this.cards_a.get(i);
                    if (card.main_pendiente) {
                        this.i_cargando = i;
                        this.tipo_cargando = 1;
                        this.tipo_str = MediaTrack.ROLE_MAIN;
                        this.archivo = "c3008836_" + card.id + "_main.png";
                        this.v = card.main_v;
                        card.main_pendiente = false;
                        return;
                    } else if (card.logo_pendiente) {
                        this.i_cargando = i;
                        this.tipo_cargando = 2;
                        this.tipo_str = "logo";
                        this.archivo = "c3008836_" + card.id + "_logo.png";
                        this.v = card.logo_v;
                        card.logo_pendiente = false;
                        return;
                    } else if (card.btn_pendiente) {
                        this.i_cargando = i;
                        this.tipo_cargando = 3;
                        this.tipo_str = "btn";
                        this.archivo = "c3008836_" + card.id + "_btn.png";
                        this.v = card.btn_v;
                        card.btn_pendiente = false;
                        return;
                    } else {
                        i++;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                int r0 = r4.i_cargando
                r1 = -1
                if (r0 != r1) goto L_0x000a
                java.lang.String r5 = "-1"
                return r5
            L_0x000a:
                java.net.URL r0 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
                r1.<init>()     // Catch:{  }
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = "/srv/imgs/cards/"
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = r4.archivo     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = "?v="
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = r4.v     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r1 = r1.toString()     // Catch:{  }
                r0.<init>(r1)     // Catch:{  }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{  }
                r1 = 1
                r0.setDoInput(r1)     // Catch:{  }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{  }
                r1 = 20000(0x4e20, float:2.8026E-41)
                r0.setReadTimeout(r1)     // Catch:{  }
                r0.connect()     // Catch:{  }
                java.io.InputStream r1 = r0.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{  }
                r4.bmImg = r2     // Catch:{  }
                r1.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                java.io.File r0 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_card r1 = stikerwap.appdys.t_card.this     // Catch:{  }
                android.content.Context r1 = r1.getApplicationContext()     // Catch:{  }
                java.io.File r1 = r1.getFilesDir()     // Catch:{  }
                java.lang.String r2 = r4.archivo     // Catch:{  }
                r0.<init>(r1, r2)     // Catch:{  }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x008b }
                r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x008b }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x008b }
                boolean r0 = r0.hasAlpha()     // Catch:{ MalformedURLException -> 0x008b }
                if (r0 == 0) goto L_0x0080
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x008b }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ MalformedURLException -> 0x008b }
                r3 = 100
                r0.compress(r2, r3, r1)     // Catch:{ MalformedURLException -> 0x008b }
                goto L_0x0089
            L_0x0080:
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x008b }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x008b }
                r3 = 70
                r0.compress(r2, r3, r1)     // Catch:{ MalformedURLException -> 0x008b }
            L_0x0089:
                java.lang.String r5 = "1"
            L_0x008b:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_card.cargar_fotos.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            boolean z;
            if (this.i_cargando != -1 && t_card.this.cards_a != null) {
                View findViewById = t_card.this.findViewById(R.id.llcards);
                CardView cardView = (CardView) findViewById.findViewWithTag("id" + t_card.this.cards_a.get(this.i_cargando).id);
                int i = this.tipo_cargando;
                if (i == 1) {
                    cardView.findViewById(R.id.pb_main).setVisibility(8);
                    cardView.findViewById(R.id.pb_main_inv).setVisibility(8);
                } else if (i == 2) {
                    cardView.findViewById(R.id.pb_logo).setVisibility(8);
                    cardView.findViewById(R.id.pb_logo_inv).setVisibility(8);
                } else if (i == 3) {
                    cardView.findViewById(R.id.pb_btn).setVisibility(8);
                    cardView.findViewById(R.id.pb_btn_inv).setVisibility(8);
                }
                if (str.equals("1")) {
                    SharedPreferences.Editor edit = t_card.this.settings.edit();
                    edit.putInt("c3008836_" + t_card.this.cards_a.get(this.i_cargando).id + "_" + this.tipo_str + "_v", Integer.parseInt(this.v));
                    edit.commit();
                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(t_card.this.getContentResolver(), Uri.fromFile(new File(t_card.this.getApplicationContext().getFilesDir(), this.archivo)));
                        z = true;
                    } catch (Exception | OutOfMemoryError unused) {
                        z = false;
                    }
                    if (z) {
                        int i2 = this.tipo_cargando;
                        if (i2 == 1) {
                            ((ImageView) cardView.findViewById(R.id.img)).setVisibility(4);
                            ((ImageView) cardView.findViewById(R.id.img)).setImageBitmap(bitmap);
                            config.fade_in((ImageView) cardView.findViewById(R.id.img));
                        } else if (i2 == 2) {
                            ((ImageView) cardView.findViewById(R.id.iv_cab_card)).setVisibility(4);
                            ((ImageView) cardView.findViewById(R.id.iv_cab_card)).setImageBitmap(bitmap);
                            config.fade_in((ImageView) cardView.findViewById(R.id.iv_cab_card));
                        } else if (i2 == 3) {
                            ((ImageView) cardView.findViewById(R.id.iv_btn)).setVisibility(4);
                            ((ImageView) cardView.findViewById(R.id.iv_btn)).setImageBitmap(bitmap);
                            config.fade_in((ImageView) cardView.findViewById(R.id.iv_btn));
                        }
                    }
                }
                new cargar_fotos().execute(new String[0]);
            }
        }
    }

    private class cargar_fotos_opc extends AsyncTask<String, Void, String> {
        String archivo;
        Bitmap bmImg;
        int i_cargando;
        String v;

        private cargar_fotos_opc() {
            this.i_cargando = -1;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_card.this.opcs_a != null) {
                for (int i = 0; i < t_card.this.opcs_a.size(); i++) {
                    Opc opc = t_card.this.opcs_a.get(i);
                    if (opc.pendiente) {
                        this.i_cargando = i;
                        this.archivo = "o3008836_" + opc.id + ".png";
                        this.v = opc.v;
                        opc.pendiente = false;
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                java.lang.String r5 = "0"
                int r0 = r4.i_cargando
                r1 = -1
                if (r0 != r1) goto L_0x000a
                java.lang.String r5 = "-1"
                return r5
            L_0x000a:
                java.net.URL r0 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
                r1.<init>()     // Catch:{  }
                java.lang.String r2 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = "/srv/imgs/cards/"
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = r4.archivo     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = "?v="
                r1.append(r2)     // Catch:{  }
                java.lang.String r2 = r4.v     // Catch:{  }
                r1.append(r2)     // Catch:{  }
                java.lang.String r1 = r1.toString()     // Catch:{  }
                r0.<init>(r1)     // Catch:{  }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{  }
                r1 = 1
                r0.setDoInput(r1)     // Catch:{  }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{  }
                r1 = 20000(0x4e20, float:2.8026E-41)
                r0.setReadTimeout(r1)     // Catch:{  }
                r0.connect()     // Catch:{  }
                java.io.InputStream r1 = r0.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{  }
                r4.bmImg = r2     // Catch:{  }
                r1.close()     // Catch:{  }
                r0.disconnect()     // Catch:{  }
                java.io.File r0 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_card r1 = stikerwap.appdys.t_card.this     // Catch:{  }
                android.content.Context r1 = r1.getApplicationContext()     // Catch:{  }
                java.io.File r1 = r1.getFilesDir()     // Catch:{  }
                java.lang.String r2 = r4.archivo     // Catch:{  }
                r0.<init>(r1, r2)     // Catch:{  }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x008b }
                r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x008b }
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x008b }
                boolean r0 = r0.hasAlpha()     // Catch:{ MalformedURLException -> 0x008b }
                if (r0 == 0) goto L_0x0080
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x008b }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ MalformedURLException -> 0x008b }
                r3 = 100
                r0.compress(r2, r3, r1)     // Catch:{ MalformedURLException -> 0x008b }
                goto L_0x0089
            L_0x0080:
                android.graphics.Bitmap r0 = r4.bmImg     // Catch:{ MalformedURLException -> 0x008b }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ MalformedURLException -> 0x008b }
                r3 = 70
                r0.compress(r2, r3, r1)     // Catch:{ MalformedURLException -> 0x008b }
            L_0x0089:
                java.lang.String r5 = "1"
            L_0x008b:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_card.cargar_fotos_opc.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            boolean z;
            if (this.i_cargando != -1 && t_card.this.opcs_a != null) {
                View findViewById = t_card.this.findViewById(R.id.llcards);
                CardView cardView = (CardView) ((CardView) findViewById.findViewWithTag("id" + t_card.this.opcs_a.get(this.i_cargando).idcard)).findViewWithTag("idopc" + t_card.this.opcs_a.get(this.i_cargando).id);
                cardView.findViewById(R.id.pb_card_opc).setVisibility(8);
                cardView.findViewById(R.id.pb_card_opc_inv).setVisibility(8);
                if (str.equals("1")) {
                    SharedPreferences.Editor edit = t_card.this.settings.edit();
                    edit.putInt("o3008836_" + t_card.this.opcs_a.get(this.i_cargando).id + "_v", Integer.parseInt(this.v));
                    edit.commit();
                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(t_card.this.getContentResolver(), Uri.fromFile(new File(t_card.this.getApplicationContext().getFilesDir(), this.archivo)));
                        z = true;
                    } catch (Exception | OutOfMemoryError unused) {
                        z = false;
                    }
                    if (z) {
                        ((ImageView) cardView.findViewById(R.id.iv_card_opc)).setVisibility(4);
                        ((ImageView) cardView.findViewById(R.id.iv_card_opc)).setImageBitmap(bitmap);
                        config.fade_in((ImageView) cardView.findViewById(R.id.iv_card_opc));
                    }
                }
                new cargar_fotos_opc().execute(new String[0]);
            }
        }
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("es_root", this.es_root);
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
        ArrayList<BannerAd> arrayList = this.wortise_ads;
        if (arrayList != null) {
            Iterator<BannerAd> it = arrayList.iterator();
            while (it.hasNext()) {
                BannerAd next = it.next();
                if (next != null) {
                    next.pause();
                }
            }
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
        ArrayList<BannerAd> arrayList = this.wortise_ads;
        if (arrayList != null) {
            Iterator<BannerAd> it = arrayList.iterator();
            while (it.hasNext()) {
                BannerAd next = it.next();
                if (next != null) {
                    next.resume();
                }
            }
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
        ArrayList<BannerAd> arrayList = this.wortise_ads;
        if (arrayList != null) {
            Iterator<BannerAd> it = arrayList.iterator();
            while (it.hasNext()) {
                BannerAd next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
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
                if (!t_card.this.globales.admob_rew_failed(context, t_card.this.mAd_appnext)) {
                    t_card.this.dialog_cargando.cancel();
                    t_card t_card = t_card.this;
                    t_card.abrir_secc(t_card.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_card.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        t_card.this.abrir_secc(t_card.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_card.this.mAd_visto) {
                            t_card.this.abrir_secc(t_card.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_card.this.mAd_visto = true;
                        config.rew_visto(context);
                    }
                });
            }
        };
    }

    public void onError(Ad ad, AdError adError) {
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
                if (t_card.this.mAd_visto) {
                    t_card t_card = t_card.this;
                    t_card.abrir_secc(t_card.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
