package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
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
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class t_buscchats extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    static final int GV_H_DP = 40;
    static final int GV_MARGIN_DP = 10;
    static final int GV_W_DP = 149;
    Anuncios anun;
    boolean atras_pulsado = false;
    int dp30;
    int dp5;
    Bundle extras;
    config globales;
    GridView gridview;
    int gv_margin_px;
    int gv_w_px;
    int id_arr_cats;
    int id_arr_idcats;
    int idcat;
    int idfoto_acargar = 1;
    long idusu;
    int ind;
    boolean mAd_visto = false;
    ListView mDrawerList;
    boolean mostrar_cards;
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
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        this.ind = this.extras.getInt("ind");
        this.idcat = this.extras.getInt("idcat", 0);
        this.cbtn = config.aplicar_color_dialog(this.globales.secciones_a[this.ind].c1, this.globales.c_icos);
        if (!config.esClaro("#" + this.globales.secciones_a[this.ind].c1)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.t_buscchats);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_buscchats.this.finalizar = false;
                t_buscchats.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_buscchats.this.buscador_on = false;
            }
        });
        config config2 = this.globales;
        Bundle bundle2 = this.extras;
        boolean z = bundle2 != null && bundle2.containsKey("ad_entrar");
        Bundle bundle3 = this.extras;
        config2.toca_int(this, z, bundle3 != null && bundle3.containsKey("fb_entrar"));
        this.anun = this.globales.mostrar_banner(this, false);
        if (this.idcat == 0) {
            config config3 = this.globales;
            config3.oncreate_popup(this, config3.ind_secc_sel_2, this.cbtn, bundle);
        }
        this.settings = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
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
        int i = config.NEGRO;
        int i2 = -1;
        if (!this.globales.secciones_a[this.ind].c1.equals("")) {
            if (!config.esClaro("#" + this.globales.secciones_a[this.ind].c1)) {
                findViewById(R.id.ll_cabe).setBackgroundColor(config.GRIS_CLARO);
                ((TextView) findViewById(R.id.tv_cabe)).setTextColor(config.NEGRO);
                i = -1;
            } else {
                findViewById(R.id.ll_cabe).setBackgroundColor(config.GRIS_OSCURO);
                ((TextView) findViewById(R.id.tv_cabe)).setTextColor(-1);
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.secciones_a[this.ind].c1), Color.parseColor("#" + this.globales.secciones_a[this.ind].c2)}));
        }
        this.idusu = this.settings.getLong("idusu", 0);
        ((TextView) findViewById(R.id.tv_cats)).setTextColor(i);
        ((TextView) findViewById(R.id.tv_nuevos)).setTextColor(i);
        ((TextView) findViewById(R.id.tv_populares)).setTextColor(i);
        if (!this.cbtn.equals("")) {
            ((TextView) findViewById(R.id.tv_fav)).setBackgroundColor(Color.parseColor("#" + this.cbtn));
            ((TextView) findViewById(R.id.tv_mas_nuevos)).setBackgroundColor(Color.parseColor("#" + this.cbtn));
            ((TextView) findViewById(R.id.tv_mas_pop)).setBackgroundColor(Color.parseColor("#" + this.cbtn));
            if (config.esClaro("#" + this.cbtn)) {
                i2 = config.NEGRO;
            }
            ((TextView) findViewById(R.id.tv_fav)).setTextColor(i2);
            ((TextView) findViewById(R.id.tv_mas_nuevos)).setTextColor(i2);
            ((TextView) findViewById(R.id.tv_mas_pop)).setTextColor(i2);
        } else {
            ((TextView) findViewById(R.id.tv_fav)).setTextColor(i);
            ((TextView) findViewById(R.id.tv_mas_nuevos)).setTextColor(i);
            ((TextView) findViewById(R.id.tv_mas_pop)).setTextColor(i);
        }
        Bundle bundle4 = this.extras;
        if (bundle4 != null && bundle4.containsKey("tit_cab")) {
            ((TextView) findViewById(R.id.tv_cabe)).setText(this.extras.getString("tit_cab"));
            findViewById(R.id.tv_cabe).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    t_buscchats.this.finish();
                }
            });
            findViewById(R.id.iv_cabe).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    t_buscchats.this.finish();
                }
            });
            findViewById(R.id.ll_cabe).setVisibility(0);
        }
        this.mostrar_cards = true;
        int i3 = this.idcat;
        if (i3 > 0) {
            if (i3 == 1) {
                this.id_arr_cats = R.array.cats_1_a;
                this.id_arr_idcats = R.array.idcats_1_a;
            } else if (i3 == 2) {
                this.id_arr_cats = R.array.cats_2_a;
                this.id_arr_idcats = R.array.idcats_2_a;
            } else if (i3 == 3) {
                this.id_arr_cats = R.array.cats_3_a;
                this.id_arr_idcats = R.array.idcats_3_a;
            } else if (i3 == 4) {
                this.id_arr_cats = R.array.cats_4_a;
                this.id_arr_idcats = R.array.idcats_4_a;
            } else if (i3 == 5) {
                this.id_arr_cats = R.array.cats_5_a;
                this.id_arr_idcats = R.array.idcats_5_a;
            } else if (i3 == 6) {
                this.id_arr_cats = R.array.cats_6_a;
                this.id_arr_idcats = R.array.idcats_6_a;
            } else if (i3 == 7) {
                this.id_arr_cats = R.array.cats_7_a;
                this.id_arr_idcats = R.array.idcats_7_a;
            } else if (i3 == 9) {
                this.id_arr_cats = R.array.cats_9_a;
                this.id_arr_idcats = R.array.idcats_9_a;
            } else if (i3 == 10) {
                this.id_arr_cats = R.array.cats_10_a;
                this.id_arr_idcats = R.array.idcats_10_a;
            } else if (i3 == 11) {
                this.id_arr_cats = R.array.cats_11_a;
                this.id_arr_idcats = R.array.idcats_11_a;
            } else if (i3 == 12) {
                this.id_arr_cats = R.array.cats_12_a;
                this.id_arr_idcats = R.array.idcats_12_a;
            } else if (i3 == 13) {
                this.id_arr_cats = R.array.cats_13_a;
                this.id_arr_idcats = R.array.idcats_13_a;
            } else if (i3 == 14) {
                this.id_arr_cats = R.array.cats_14_a;
                this.id_arr_idcats = R.array.idcats_14_a;
            } else if (i3 == 15) {
                this.id_arr_cats = R.array.cats_15_a;
                this.id_arr_idcats = R.array.idcats_15_a;
            }
            if (this.globales.secciones_a[this.ind].idcat == 0) {
                this.mostrar_cards = false;
                findViewById(R.id.rl_chats_fila1).setVisibility(8);
                findViewById(R.id.ll_chats_fila1).setVisibility(8);
                findViewById(R.id.rl_chats_fila2).setVisibility(8);
                findViewById(R.id.ll_chats_fila2).setVisibility(8);
            }
        }
        GridView gridView = (GridView) findViewById(R.id.gridview);
        this.gridview = gridView;
        gridView.setAdapter(new ImageAdapter(this));
        this.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent;
                if (t_buscchats.this.idcat == 0) {
                    intent = new Intent(t_buscchats.this, t_buscchats.class);
                    intent.putExtra("idcat", Integer.parseInt(t_buscchats.this.getResources().getStringArray(R.array.idcats_menu_a)[i]));
                    intent.putExtra("tit_cab", t_buscchats.this.getResources().getStringArray(R.array.cats_menu_a)[i]);
                } else {
                    intent = new Intent(t_buscchats.this, t_buscchats_lista.class);
                    intent.putExtra("idcat", t_buscchats.this.idcat);
                    intent.putExtra("idsubcat", Integer.parseInt(t_buscchats.this.getResources().getStringArray(t_buscchats.this.id_arr_idcats)[i]));
                    intent.putExtra("tit_cab", t_buscchats.this.getResources().getStringArray(t_buscchats.this.id_arr_cats)[i]);
                }
                intent.putExtra("ind", t_buscchats.this.ind);
                t_buscchats.this.startActivityForResult(intent, 0);
            }
        });
        this.dp30 = (int) ((getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
        this.dp5 = (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f);
        this.gv_w_px = convertDpToPixels(149.0f, this);
        this.gv_margin_px = convertDpToPixels(10.0f, this);
        redim_gridview();
        findViewById(R.id.tv_fav).setOnClickListener(this);
        findViewById(R.id.tv_mas_nuevos).setOnClickListener(this);
        findViewById(R.id.tv_mas_pop).setOnClickListener(this);
        new cargar_chats().execute(new String[0]);
    }

    public class ImageAdapter extends BaseAdapter {
        private int[] colores_a = {R.drawable.bg_1, R.drawable.bg_2, R.drawable.bg_3, R.drawable.bg_4, R.drawable.bg_5, R.drawable.bg_6, R.drawable.bg_7, R.drawable.bg_8, R.drawable.bg_9, R.drawable.bg_10, R.drawable.bg_11, R.drawable.bg_12, R.drawable.bg_13, R.drawable.bg_14, R.drawable.bg_1, R.drawable.bg_2, R.drawable.bg_3, R.drawable.bg_4, R.drawable.bg_5, R.drawable.bg_6, R.drawable.bg_7, R.drawable.bg_8, R.drawable.bg_9, R.drawable.bg_10, R.drawable.bg_11, R.drawable.bg_12, R.drawable.bg_13, R.drawable.bg_14, R.drawable.bg_1, R.drawable.bg_2, R.drawable.bg_3, R.drawable.bg_4};
        private Context mContext;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public ImageAdapter(Context context) {
            this.mContext = context;
        }

        public int getCount() {
            if (t_buscchats.this.idcat == 0) {
                return t_buscchats.this.getResources().getStringArray(R.array.cats_menu_a).length;
            }
            return t_buscchats.this.getResources().getStringArray(t_buscchats.this.id_arr_cats).length;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(this.mContext);
                textView.setSingleLine(true);
                textView.setHeight(t_buscchats.this.dp30);
                textView.setBackgroundResource(this.colores_a[i]);
                textView.setTextColor(-1);
                textView.setPadding(t_buscchats.this.dp5, 0, t_buscchats.this.dp5, 0);
                textView.setGravity(16);
                if (t_buscchats.this.getResources().getBoolean(R.bool.es_rtl)) {
                    textView.setTextDirection(4);
                }
            } else {
                textView = (TextView) view;
            }
            if (t_buscchats.this.idcat == 0) {
                textView.setText(t_buscchats.this.getResources().getStringArray(R.array.cats_menu_a)[i].toUpperCase(Locale.getDefault()));
            } else {
                textView.setText(t_buscchats.this.getResources().getStringArray(t_buscchats.this.id_arr_cats)[i].toUpperCase(Locale.getDefault()));
            }
            return textView;
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

    public void onClick(View view) {
        boolean z = true;
        if (view.getId() == R.id.tv_fav) {
            Intent intent = new Intent(this, t_buscchats_lista.class);
            intent.putExtra("ind", this.ind);
            intent.putExtra("idcat", 0);
            intent.putExtra("tipo", 3);
            intent.putExtra("tit_cab", getResources().getString(R.string.favoritos).charAt(0) + getResources().getString(R.string.favoritos).substring(1).toLowerCase());
            startActivityForResult(intent, 0);
        } else if (view.getId() == R.id.tv_mas_nuevos) {
            Intent intent2 = new Intent(this, t_buscchats_lista.class);
            intent2.putExtra("ind", this.ind);
            intent2.putExtra("idcat", this.idcat);
            intent2.putExtra("tipo", 1);
            intent2.putExtra("tit_cab", getResources().getString(R.string.chats_nuevos));
            startActivityForResult(intent2, 0);
        } else if (view.getId() == R.id.tv_mas_pop) {
            Intent intent3 = new Intent(this, t_buscchats_lista.class);
            intent3.putExtra("ind", this.ind);
            intent3.putExtra("idcat", this.idcat);
            intent3.putExtra("tipo", 2);
            intent3.putExtra("tit_cab", getResources().getString(R.string.chats_maspopulares));
            startActivityForResult(intent3, 0);
        } else if (view.getId() == R.id.card_view_1 || view.getId() == R.id.card_view_2 || view.getId() == R.id.card_view_3 || view.getId() == R.id.card_view_4 || view.getId() == R.id.card_view_5 || view.getId() == R.id.card_view_6) {
            Intent intent4 = new Intent(this, t_chat_contra.class);
            intent4.putExtra("externo", true);
            intent4.putExtra("idapp", Integer.parseInt(view.getTag(R.id.tag_idapp) + ""));
            intent4.putExtra("idchat", Integer.parseInt(view.getTag() + ""));
            intent4.putExtra("idtema", Integer.parseInt(view.getTag(R.id.tag_idtema) + ""));
            intent4.putExtra("fotos_perfil", Integer.parseInt(view.getTag(R.id.tag_fotos_perfil) + ""));
            intent4.putExtra("fnac", Integer.parseInt(view.getTag(R.id.tag_fnac) + ""));
            intent4.putExtra("sexo", Integer.parseInt(view.getTag(R.id.tag_sexo) + ""));
            intent4.putExtra("descr", Integer.parseInt(view.getTag(R.id.tag_descr) + ""));
            intent4.putExtra("dist", Integer.parseInt(view.getTag(R.id.tag_dist) + ""));
            StringBuilder sb = new StringBuilder();
            sb.append(view.getTag(R.id.tag_privados));
            sb.append("");
            intent4.putExtra("privados", Integer.parseInt(sb.toString()) == 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(view.getTag(R.id.tag_coments));
            sb2.append("");
            intent4.putExtra("coments", Integer.parseInt(sb2.toString()) == 1);
            if (Integer.parseInt(view.getTag(R.id.tag_galeria) + "") != 1) {
                z = false;
            }
            intent4.putExtra("galeria", z);
            intent4.putExtra("fotos_chat", Integer.parseInt(view.getTag(R.id.tag_fotos_chat) + ""));
            intent4.putExtra("c1", view.getTag(R.id.tag_c1) + "");
            intent4.putExtra("c2", view.getTag(R.id.tag_c2) + "");
            intent4.putExtra("tit_cab", view.getTag(R.id.tag_titulo) + "");
            startActivityForResult(intent4, 0);
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

    /* access modifiers changed from: private */
    public void asignar_cardview(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, String str, String str2, String str3, int i14) {
        findViewById(i).setTag(Integer.valueOf(i2));
        findViewById(i).setTag(R.id.tag_idtema, Integer.valueOf(i3));
        findViewById(i).setTag(R.id.tag_idapp, Integer.valueOf(i4));
        findViewById(i).setTag(R.id.tag_fotos_perfil, Integer.valueOf(i5));
        findViewById(i).setTag(R.id.tag_fnac, Integer.valueOf(i6));
        findViewById(i).setTag(R.id.tag_sexo, Integer.valueOf(i7));
        findViewById(i).setTag(R.id.tag_descr, Integer.valueOf(i8));
        findViewById(i).setTag(R.id.tag_dist, Integer.valueOf(i9));
        findViewById(i).setTag(R.id.tag_privados, Integer.valueOf(i10));
        findViewById(i).setTag(R.id.tag_coments, Integer.valueOf(i11));
        findViewById(i).setTag(R.id.tag_galeria, Integer.valueOf(i12));
        findViewById(i).setTag(R.id.tag_fotos_chat, Integer.valueOf(i13));
        findViewById(i).setTag(R.id.tag_titulo, str);
        findViewById(i).setTag(R.id.tag_c1, str2);
        findViewById(i).setTag(R.id.tag_c2, str3);
        findViewById(i).setTag(R.id.tag_nusus, Integer.valueOf(i14));
        findViewById(i).setOnClickListener(this);
    }

    private class cargar_chats extends AsyncTask<String, Void, String> {
        private cargar_chats() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x009b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0097 }
                r0.<init>()     // Catch:{ Exception -> 0x0097 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x0097 }
                r0.append(r1)     // Catch:{ Exception -> 0x0097 }
                java.lang.String r1 = "/srv/chats_home.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x0097 }
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this     // Catch:{ Exception -> 0x0097 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x0097 }
                r0.append(r1)     // Catch:{ Exception -> 0x0097 }
                java.lang.String r1 = "&idcat="
                r0.append(r1)     // Catch:{ Exception -> 0x0097 }
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this     // Catch:{ Exception -> 0x0097 }
                int r1 = r1.idcat     // Catch:{ Exception -> 0x0097 }
                r0.append(r1)     // Catch:{ Exception -> 0x0097 }
                java.lang.String r1 = "&chats="
                r0.append(r1)     // Catch:{ Exception -> 0x0097 }
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this     // Catch:{ Exception -> 0x0097 }
                boolean r1 = r1.mostrar_cards     // Catch:{ Exception -> 0x0097 }
                r2 = 1
                if (r1 == 0) goto L_0x0031
                r1 = 1
                goto L_0x0032
            L_0x0031:
                r1 = 0
            L_0x0032:
                r0.append(r1)     // Catch:{ Exception -> 0x0097 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0097 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0097 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0097 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x0097 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0097 }
                r0.setDoInput(r2)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r6.<init>()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            L_0x0069:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                if (r2 == 0) goto L_0x0084
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r3.<init>()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r3.append(r2)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                r6.append(r2)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                goto L_0x0069
            L_0x0084:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
                if (r0 == 0) goto L_0x008d
                r0.disconnect()
            L_0x008d:
                return r6
            L_0x008e:
                r6 = move-exception
                goto L_0x009f
            L_0x0090:
                r6 = r0
                goto L_0x0097
            L_0x0092:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x009f
            L_0x0097:
                java.lang.String r0 = "ANDROID:KO"
                if (r6 == 0) goto L_0x009e
                r6.disconnect()
            L_0x009e:
                return r0
            L_0x009f:
                if (r0 == 0) goto L_0x00a4
                r0.disconnect()
            L_0x00a4:
                goto L_0x00a6
            L_0x00a5:
                throw r6
            L_0x00a6:
                goto L_0x00a5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscchats.cargar_chats.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* JADX WARNING: type inference failed for: r2v36, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v38, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v40, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v42, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v44, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v46, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v48, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v50, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v52, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v54, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v56, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r2v58, types: [android.view.View] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r33) {
            /*
                r32 = this;
                r0 = r32
                r1 = r33
                java.lang.String r2 = "ANDROID:OK RESULT:"
                int r3 = r1.indexOf(r2)
                r4 = -1
                if (r3 != r4) goto L_0x0015
                java.lang.String r3 = "ANDROID:KO"
                int r3 = r1.indexOf(r3)
                if (r3 == r4) goto L_0x02f4
            L_0x0015:
                int r2 = r1.indexOf(r2)
                if (r2 == r4) goto L_0x02f4
                stikerwap.appdys.t_buscchats r3 = stikerwap.appdys.t_buscchats.this
                android.content.SharedPreferences r3 = r3.settings
                android.content.SharedPreferences$Editor r3 = r3.edit()
                java.lang.String r5 = "@y@"
                int r2 = r1.indexOf(r5, r2)
                r6 = 0
                r7 = r6
                r8 = r7
            L_0x002c:
                r9 = 2
                if (r2 == r4) goto L_0x0262
                int r2 = r2 + 3
                java.lang.String r10 = ";"
                int r11 = r1.indexOf(r10, r2)
                java.lang.String r2 = r1.substring(r2, r11)
                int r2 = java.lang.Integer.parseInt(r2)
                r12 = 1
                int r11 = r11 + r12
                int r13 = r1.indexOf(r10, r11)
                java.lang.String r11 = r1.substring(r11, r13)
                int r18 = java.lang.Integer.parseInt(r11)
                int r13 = r13 + r12
                int r11 = r1.indexOf(r10, r13)
                java.lang.String r13 = r1.substring(r13, r11)
                int r16 = java.lang.Integer.parseInt(r13)
                int r11 = r11 + r12
                int r13 = r1.indexOf(r10, r11)
                java.lang.String r11 = r1.substring(r11, r13)
                int r17 = java.lang.Integer.parseInt(r11)
                int r13 = r13 + r12
                int r11 = r1.indexOf(r10, r13)
                java.lang.String r13 = r1.substring(r13, r11)
                int r19 = java.lang.Integer.parseInt(r13)
                int r11 = r11 + r12
                int r13 = r1.indexOf(r10, r11)
                java.lang.String r11 = r1.substring(r11, r13)
                int r24 = java.lang.Integer.parseInt(r11)
                int r13 = r13 + r12
                int r11 = r1.indexOf(r10, r13)
                int r11 = r11 + r12
                int r13 = r1.indexOf(r10, r11)
                java.lang.String r11 = r1.substring(r11, r13)
                int r27 = java.lang.Integer.parseInt(r11)
                int r13 = r13 + r12
                int r11 = r1.indexOf(r10, r13)
                java.lang.String r13 = r1.substring(r13, r11)
                int r11 = r11 + r12
                int r14 = r1.indexOf(r10, r11)
                java.lang.String r29 = r1.substring(r11, r14)
                int r14 = r14 + r12
                int r11 = r1.indexOf(r10, r14)
                java.lang.String r30 = r1.substring(r14, r11)
                int r11 = r11 + r12
                int r14 = r1.indexOf(r10, r11)
                java.lang.String r11 = r1.substring(r11, r14)
                int r11 = java.lang.Integer.parseInt(r11)
                int r14 = r14 + r12
                int r15 = r1.indexOf(r10, r14)
                java.lang.String r14 = r1.substring(r14, r15)
                int r25 = java.lang.Integer.parseInt(r14)
                int r15 = r15 + r12
                int r14 = r1.indexOf(r10, r15)
                java.lang.String r15 = r1.substring(r15, r14)
                int r20 = java.lang.Integer.parseInt(r15)
                int r14 = r14 + r12
                int r15 = r1.indexOf(r10, r14)
                java.lang.String r14 = r1.substring(r14, r15)
                int r21 = java.lang.Integer.parseInt(r14)
                int r15 = r15 + r12
                int r14 = r1.indexOf(r10, r15)
                java.lang.String r15 = r1.substring(r15, r14)
                int r22 = java.lang.Integer.parseInt(r15)
                int r14 = r14 + r12
                int r15 = r1.indexOf(r10, r14)
                java.lang.String r14 = r1.substring(r14, r15)
                int r26 = java.lang.Integer.parseInt(r14)
                int r15 = r15 + r12
                int r10 = r1.indexOf(r10, r15)
                java.lang.String r14 = r1.substring(r15, r10)
                int r23 = java.lang.Integer.parseInt(r14)
                if (r2 != r12) goto L_0x0131
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r7 = 2131363393(0x7f0a0641, float:1.8346594E38)
                android.view.View r2 = r2.findViewById(r7)
                r7 = r2
                android.widget.TextView r7 = (android.widget.TextView) r7
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r8 = 2131363043(0x7f0a04e3, float:1.8345884E38)
                android.view.View r2 = r2.findViewById(r8)
                r8 = r2
                android.widget.TextView r8 = (android.widget.TextView) r8
                stikerwap.appdys.t_buscchats r14 = stikerwap.appdys.t_buscchats.this
                r15 = 2131362046(0x7f0a00fe, float:1.8343862E38)
                r28 = r13
                r31 = r11
                r14.asignar_cardview(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                goto L_0x01f9
            L_0x0131:
                if (r2 != r9) goto L_0x0159
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r7 = 2131363394(0x7f0a0642, float:1.8346596E38)
                android.view.View r2 = r2.findViewById(r7)
                r7 = r2
                android.widget.TextView r7 = (android.widget.TextView) r7
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r8 = 2131363044(0x7f0a04e4, float:1.8345886E38)
                android.view.View r2 = r2.findViewById(r8)
                r8 = r2
                android.widget.TextView r8 = (android.widget.TextView) r8
                stikerwap.appdys.t_buscchats r14 = stikerwap.appdys.t_buscchats.this
                r15 = 2131362047(0x7f0a00ff, float:1.8343864E38)
                r28 = r13
                r31 = r11
                r14.asignar_cardview(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                goto L_0x01f9
            L_0x0159:
                r9 = 3
                if (r2 != r9) goto L_0x0182
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r7 = 2131363395(0x7f0a0643, float:1.8346598E38)
                android.view.View r2 = r2.findViewById(r7)
                r7 = r2
                android.widget.TextView r7 = (android.widget.TextView) r7
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r8 = 2131363045(0x7f0a04e5, float:1.8345888E38)
                android.view.View r2 = r2.findViewById(r8)
                r8 = r2
                android.widget.TextView r8 = (android.widget.TextView) r8
                stikerwap.appdys.t_buscchats r14 = stikerwap.appdys.t_buscchats.this
                r15 = 2131362048(0x7f0a0100, float:1.8343866E38)
                r28 = r13
                r31 = r11
                r14.asignar_cardview(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                goto L_0x01f9
            L_0x0182:
                r9 = 4
                if (r2 != r9) goto L_0x01aa
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r7 = 2131363396(0x7f0a0644, float:1.83466E38)
                android.view.View r2 = r2.findViewById(r7)
                r7 = r2
                android.widget.TextView r7 = (android.widget.TextView) r7
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r8 = 2131363046(0x7f0a04e6, float:1.834589E38)
                android.view.View r2 = r2.findViewById(r8)
                r8 = r2
                android.widget.TextView r8 = (android.widget.TextView) r8
                stikerwap.appdys.t_buscchats r14 = stikerwap.appdys.t_buscchats.this
                r15 = 2131362049(0x7f0a0101, float:1.8343868E38)
                r28 = r13
                r31 = r11
                r14.asignar_cardview(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                goto L_0x01f9
            L_0x01aa:
                r9 = 5
                if (r2 != r9) goto L_0x01d2
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r7 = 2131363397(0x7f0a0645, float:1.8346602E38)
                android.view.View r2 = r2.findViewById(r7)
                r7 = r2
                android.widget.TextView r7 = (android.widget.TextView) r7
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r8 = 2131363047(0x7f0a04e7, float:1.8345892E38)
                android.view.View r2 = r2.findViewById(r8)
                r8 = r2
                android.widget.TextView r8 = (android.widget.TextView) r8
                stikerwap.appdys.t_buscchats r14 = stikerwap.appdys.t_buscchats.this
                r15 = 2131362050(0x7f0a0102, float:1.834387E38)
                r28 = r13
                r31 = r11
                r14.asignar_cardview(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
                goto L_0x01f9
            L_0x01d2:
                r9 = 6
                if (r2 != r9) goto L_0x01f9
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r7 = 2131363398(0x7f0a0646, float:1.8346604E38)
                android.view.View r2 = r2.findViewById(r7)
                r7 = r2
                android.widget.TextView r7 = (android.widget.TextView) r7
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r8 = 2131363048(0x7f0a04e8, float:1.8345894E38)
                android.view.View r2 = r2.findViewById(r8)
                r8 = r2
                android.widget.TextView r8 = (android.widget.TextView) r8
                stikerwap.appdys.t_buscchats r14 = stikerwap.appdys.t_buscchats.this
                r15 = 2131362051(0x7f0a0103, float:1.8343872E38)
                r28 = r13
                r31 = r11
                r14.asignar_cardview(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            L_0x01f9:
                if (r7 == 0) goto L_0x025c
                int r2 = stikerwap.appdys.config.NEGRO
                r7.setTextColor(r2)
                int r2 = stikerwap.appdys.config.NEGRO_2
                r8.setTextColor(r2)
                r2 = 99999(0x1869f, float:1.40128E-40)
                int r2 = java.lang.Math.min(r11, r2)
                r7.setText(r13)
                r9 = 10
                r11 = 2131886862(0x7f12030e, float:1.9408315E38)
                if (r2 >= r9) goto L_0x0232
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r9 = "<10 "
                r2.<init>(r9)
                stikerwap.appdys.t_buscchats r9 = stikerwap.appdys.t_buscchats.this
                android.content.res.Resources r9 = r9.getResources()
                java.lang.String r9 = r9.getString(r11)
                r2.append(r9)
                java.lang.String r2 = r2.toString()
                r8.setText(r2)
                goto L_0x025c
            L_0x0232:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.text.NumberFormat r12 = java.text.NumberFormat.getInstance()
                long r13 = (long) r2
                java.lang.String r2 = r12.format(r13)
                r9.append(r2)
                java.lang.String r2 = " "
                r9.append(r2)
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                android.content.res.Resources r2 = r2.getResources()
                java.lang.String r2 = r2.getString(r11)
                r9.append(r2)
                java.lang.String r2 = r9.toString()
                r8.setText(r2)
            L_0x025c:
                int r2 = r1.indexOf(r5, r10)
                goto L_0x002c
            L_0x0262:
                r3.commit()
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r2.ocultar_chats()
                java.lang.String r2 = "@z@"
                int r2 = r1.indexOf(r2)
                r3 = 0
                if (r2 == r4) goto L_0x02e8
                int r2 = r2 + r9
                java.lang.String r1 = r1.substring(r2)
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                int r2 = r2.idcat
                if (r2 != 0) goto L_0x028c
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                android.content.res.Resources r2 = r2.getResources()
                r5 = 2130903077(0x7f030025, float:1.7412962E38)
                java.lang.String[] r2 = r2.getStringArray(r5)
                goto L_0x029a
            L_0x028c:
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                android.content.res.Resources r2 = r2.getResources()
                stikerwap.appdys.t_buscchats r5 = stikerwap.appdys.t_buscchats.this
                int r5 = r5.id_arr_idcats
                java.lang.String[] r2 = r2.getStringArray(r5)
            L_0x029a:
                r5 = 0
            L_0x029b:
                int r7 = r2.length
                if (r5 >= r7) goto L_0x02e8
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "@"
                r7.<init>(r8)
                r9 = r2[r5]
                r7.append(r9)
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                int r7 = r1.indexOf(r7)
                if (r7 != r4) goto L_0x02e5
                stikerwap.appdys.t_buscchats r7 = stikerwap.appdys.t_buscchats.this
                android.widget.GridView r7 = r7.gridview
                android.view.View r7 = r7.getChildAt(r5)
                r8 = -3355444(0xffffffffffcccccc, float:NaN)
                r7.setBackgroundColor(r8)
                stikerwap.appdys.t_buscchats r7 = stikerwap.appdys.t_buscchats.this
                android.widget.GridView r7 = r7.gridview
                android.view.View r7 = r7.getChildAt(r5)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r8 = -12303292(0xffffffffff444444, float:-2.6088314E38)
                r7.setTextColor(r8)
                stikerwap.appdys.t_buscchats r7 = stikerwap.appdys.t_buscchats.this
                android.widget.GridView r7 = r7.gridview
                android.view.View r7 = r7.getChildAt(r5)
                stikerwap.appdys.t_buscchats$cargar_chats$1 r8 = new stikerwap.appdys.t_buscchats$cargar_chats$1
                r8.<init>()
                r7.setOnClickListener(r8)
            L_0x02e5:
                int r5 = r5 + 1
                goto L_0x029b
            L_0x02e8:
                stikerwap.appdys.t_buscchats$cargar_foto r1 = new stikerwap.appdys.t_buscchats$cargar_foto
                stikerwap.appdys.t_buscchats r2 = stikerwap.appdys.t_buscchats.this
                r1.<init>()
                java.lang.String[] r2 = new java.lang.String[r3]
                r1.execute(r2)
            L_0x02f4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscchats.cargar_chats.onPostExecute(java.lang.String):void");
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

    private class cargar_foto extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        int idapp;
        ImageView iv;

        private cargar_foto() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:3:0x0008  */
        /* JADX WARNING: Removed duplicated region for block: B:4:0x0020  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPreExecute() {
            /*
                r4 = this;
                r0 = 0
            L_0x0001:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r1 = r1.idfoto_acargar
                r2 = 1
                if (r1 != r2) goto L_0x0020
                stikerwap.appdys.t_buscchats r0 = stikerwap.appdys.t_buscchats.this
                r1 = 2131362046(0x7f0a00fe, float:1.8343862E38)
                android.view.View r0 = r0.findViewById(r1)
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                r3 = 2131362435(0x7f0a0283, float:1.834465E38)
                android.view.View r1 = r1.findViewById(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r4.iv = r1
                goto L_0x00b6
            L_0x0020:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r1 = r1.idfoto_acargar
                r3 = 2
                if (r1 != r3) goto L_0x003f
                stikerwap.appdys.t_buscchats r0 = stikerwap.appdys.t_buscchats.this
                r1 = 2131362047(0x7f0a00ff, float:1.8343864E38)
                android.view.View r0 = r0.findViewById(r1)
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                r3 = 2131362436(0x7f0a0284, float:1.8344653E38)
                android.view.View r1 = r1.findViewById(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r4.iv = r1
                goto L_0x00b6
            L_0x003f:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r1 = r1.idfoto_acargar
                r3 = 3
                if (r1 != r3) goto L_0x005d
                stikerwap.appdys.t_buscchats r0 = stikerwap.appdys.t_buscchats.this
                r1 = 2131362048(0x7f0a0100, float:1.8343866E38)
                android.view.View r0 = r0.findViewById(r1)
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                r3 = 2131362437(0x7f0a0285, float:1.8344655E38)
                android.view.View r1 = r1.findViewById(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r4.iv = r1
                goto L_0x00b6
            L_0x005d:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r1 = r1.idfoto_acargar
                r3 = 4
                if (r1 != r3) goto L_0x007b
                stikerwap.appdys.t_buscchats r0 = stikerwap.appdys.t_buscchats.this
                r1 = 2131362049(0x7f0a0101, float:1.8343868E38)
                android.view.View r0 = r0.findViewById(r1)
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                r3 = 2131362438(0x7f0a0286, float:1.8344657E38)
                android.view.View r1 = r1.findViewById(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r4.iv = r1
                goto L_0x00b6
            L_0x007b:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r1 = r1.idfoto_acargar
                r3 = 5
                if (r1 != r3) goto L_0x0099
                stikerwap.appdys.t_buscchats r0 = stikerwap.appdys.t_buscchats.this
                r1 = 2131362050(0x7f0a0102, float:1.834387E38)
                android.view.View r0 = r0.findViewById(r1)
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                r3 = 2131362439(0x7f0a0287, float:1.8344659E38)
                android.view.View r1 = r1.findViewById(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r4.iv = r1
                goto L_0x00b6
            L_0x0099:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r1 = r1.idfoto_acargar
                r3 = 6
                if (r1 != r3) goto L_0x00b6
                stikerwap.appdys.t_buscchats r0 = stikerwap.appdys.t_buscchats.this
                r1 = 2131362051(0x7f0a0103, float:1.8343872E38)
                android.view.View r0 = r0.findViewById(r1)
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                r3 = 2131362440(0x7f0a0288, float:1.834466E38)
                android.view.View r1 = r1.findViewById(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r4.iv = r1
            L_0x00b6:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r3 = r1.idfoto_acargar
                int r3 = r3 + r2
                r1.idfoto_acargar = r3
                java.lang.Object r1 = r0.getTag()
                if (r1 != 0) goto L_0x00ca
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r1 = r1.idfoto_acargar
                r3 = 7
                if (r1 < r3) goto L_0x0001
            L_0x00ca:
                java.lang.Object r1 = r0.getTag()
                if (r1 != 0) goto L_0x00d4
                r4.cancel(r2)
                goto L_0x00f9
            L_0x00d4:
                stikerwap.appdys.t_buscchats r1 = stikerwap.appdys.t_buscchats.this
                int r3 = r1.idfoto_acargar
                int r3 = r3 - r2
                r1.idfoto_acargar = r3
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r2 = 2131363262(0x7f0a05be, float:1.8346328E38)
                java.lang.Object r0 = r0.getTag(r2)
                r1.append(r0)
                java.lang.String r0 = ""
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                int r0 = java.lang.Integer.parseInt(r0)
                r4.idapp = r0
            L_0x00f9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscchats.cargar_foto.onPreExecute():void");
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                URL url = new URL(config.DOM_CDN + "/srv/imgs/gen/" + this.idapp + "_ico.png");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(7000);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                inputStream.close();
                httpURLConnection.disconnect();
                int round = Math.round(TypedValue.applyDimension(1, 200.0f, t_buscchats.this.getResources().getDisplayMetrics()));
                options.inSampleSize = config.calculateInSampleSize(options, round, round);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(7000);
                httpURLConnection2.connect();
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                options.inJustDecodeBounds = false;
                this.bmImg = BitmapFactory.decodeStream(inputStream2, (Rect) null, options);
                inputStream2.close();
                return "ANDROID:OK";
            } catch (Exception e) {
                e.printStackTrace();
                return "ANDROID:KO";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.indexOf("ANDROID:OK") != -1) {
                this.iv.setImageBitmap(this.bmImg);
                config.fade_in(this.iv);
            }
            if (t_buscchats.this.idfoto_acargar < 6) {
                t_buscchats.this.idfoto_acargar++;
                new cargar_foto().execute(new String[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ocultar_chats() {
        if (this.mostrar_cards) {
            int obtener_ancho = obtener_ancho();
            int convertDpToPixels = convertDpToPixels(10.0f, this);
            int convertDpToPixels2 = (obtener_ancho - (convertDpToPixels * 2)) / (convertDpToPixels(120.0f, this) + convertDpToPixels);
            findViewById(R.id.ll_chats_fila1).setVisibility(0);
            findViewById(R.id.rl_chats_fila1).setVisibility(0);
            findViewById(R.id.ll_chats_fila2).setVisibility(0);
            findViewById(R.id.rl_chats_fila2).setVisibility(0);
            findViewById(R.id.card_view_1).setVisibility(0);
            findViewById(R.id.card_view_2).setVisibility(0);
            findViewById(R.id.card_view_3).setVisibility(0);
            findViewById(R.id.card_view_4).setVisibility(0);
            findViewById(R.id.card_view_5).setVisibility(0);
            findViewById(R.id.card_view_6).setVisibility(0);
            if (convertDpToPixels2 < 3) {
                findViewById(R.id.card_view_3).setVisibility(8);
                findViewById(R.id.card_view_6).setVisibility(8);
                if (convertDpToPixels2 < 2) {
                    findViewById(R.id.card_view_2).setVisibility(8);
                    findViewById(R.id.card_view_5).setVisibility(8);
                }
            }
            if (findViewById(R.id.card_view_3).getTag() == null) {
                findViewById(R.id.card_view_3).setVisibility(8);
                if (findViewById(R.id.card_view_2).getTag() == null) {
                    findViewById(R.id.card_view_2).setVisibility(8);
                    if (findViewById(R.id.card_view_1).getTag() == null) {
                        findViewById(R.id.ll_chats_fila1).setVisibility(8);
                        findViewById(R.id.rl_chats_fila1).setVisibility(8);
                    }
                }
            }
            if (findViewById(R.id.card_view_6).getTag() == null) {
                findViewById(R.id.card_view_6).setVisibility(8);
                if (findViewById(R.id.card_view_5).getTag() == null) {
                    findViewById(R.id.card_view_5).setVisibility(8);
                    if (findViewById(R.id.card_view_4).getTag() == null) {
                        findViewById(R.id.ll_chats_fila2).setVisibility(8);
                        findViewById(R.id.rl_chats_fila2).setVisibility(8);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void redim_gridview() {
        int obtener_ancho = (obtener_ancho() - this.gv_margin_px) / this.gv_w_px;
        int i = this.idcat > 0 ? this.id_arr_idcats : R.array.cats_menu_a;
        ViewGroup.LayoutParams layoutParams = this.gridview.getLayoutParams();
        layoutParams.height = convertDpToPixels((float) ((((int) Math.ceil((double) (((float) getResources().getStringArray(i).length) / ((float) obtener_ancho)))) * 40) - 5), this);
        this.gridview.setLayoutParams(layoutParams);
    }

    public int convertDpToPixels(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public int obtener_ancho() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
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

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        redim_gridview();
        ocultar_chats();
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
                if (!t_buscchats.this.globales.admob_rew_failed(context, t_buscchats.this.mAd_appnext)) {
                    t_buscchats.this.dialog_cargando.cancel();
                    t_buscchats t_buscchats = t_buscchats.this;
                    t_buscchats.abrir_secc(t_buscchats.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_buscchats.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_buscchats.this.abrir_secc(t_buscchats.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_buscchats.this.mAd_visto) {
                            t_buscchats.this.abrir_secc(t_buscchats.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_buscchats.this.mAd_visto = true;
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
                if (t_buscchats.this.mAd_visto) {
                    t_buscchats t_buscchats = t_buscchats.this;
                    t_buscchats.abrir_secc(t_buscchats.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
