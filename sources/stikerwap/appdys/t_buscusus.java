package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class t_buscusus extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, AdapterView.OnItemClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean atras_pulsado = false;
    boolean c1_esclaro;
    cargar_fotos c_f;
    cargar_usus c_u;
    boolean cargado_primeravez = false;
    String codigo;
    boolean coments_glob;
    Dialog dialog_filtros;
    Bundle extras;
    boolean fdist;
    int fdist_v;
    boolean fedad1;
    int fedad1_v;
    boolean fedad2;
    int fedad2_v;
    boolean finalizar_2 = false;
    boolean fnick;
    String fnick_v;
    int fotos_perfil;
    boolean fsexo;
    int fsexo_v;
    boolean galeria;
    config globales;
    GridViewAdapter gridAdapter;
    GridView gridView;
    long idusu;
    int ind_secc;
    boolean mAd_visto = false;
    ListView mDrawerList;
    int p_descr;
    int p_dist;
    int p_fnac;
    int p_sexo;
    int padding_1;
    int padding_2;
    String pais;
    File path;
    boolean privados_glob;
    SharedPreferences settings;
    Bitmap sinfoto;
    TextView tv_fdist;
    TextView tv_fedad1;
    TextView tv_fedad2;
    TextView tv_fnick;
    TextView tv_fsexo;
    ArrayList<Usu> usus_a;
    boolean usus_a_completo;

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
        String str = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
        String str2 = this.globales.secciones_a[this.globales.ind_secc_sel_2].c2;
        this.c1_esclaro = config.esClaro("#" + str);
        this.cbtn = config.aplicar_color_dialog(str, this.globales.c_icos);
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
        this.path = getFilesDir();
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.codigo = this.settings.getString("cod", "");
        float f = getResources().getDisplayMetrics().density;
        this.padding_1 = (int) ((5.0f * f) + 0.5f);
        this.padding_2 = (int) ((f * 15.0f) + 0.5f);
        this.pais = Locale.getDefault().getCountry();
        this.p_fnac = this.globales.secciones_a[this.ind_secc].p_fnac;
        this.p_sexo = this.globales.secciones_a[this.ind_secc].p_sexo;
        this.p_descr = this.globales.secciones_a[this.ind_secc].p_descr;
        this.p_dist = this.globales.secciones_a[this.ind_secc].p_dist;
        this.coments_glob = this.globales.secciones_a[this.ind_secc].coments;
        this.galeria = this.globales.secciones_a[this.ind_secc].galeria;
        this.privados_glob = this.globales.secciones_a[this.ind_secc].privados;
        this.fotos_perfil = this.globales.secciones_a[this.ind_secc].fotos_perfil;
        this.fsexo = this.globales.secciones_a[this.ind_secc].fsexo;
        this.fnick = this.globales.secciones_a[this.ind_secc].fnick;
        this.fdist = this.globales.secciones_a[this.ind_secc].fdist;
        this.fedad1 = this.globales.secciones_a[this.ind_secc].fedad1;
        this.fedad2 = this.globales.secciones_a[this.ind_secc].fedad2;
        this.fsexo_v = this.globales.secciones_a[this.ind_secc].fsexo_def;
        this.fnick_v = "";
        this.fdist_v = this.globales.secciones_a[this.ind_secc].fdist_def;
        this.fedad1_v = this.globales.secciones_a[this.ind_secc].fedad1_def;
        this.fedad2_v = this.globales.secciones_a[this.ind_secc].fedad2_def;
        if (this.fdist) {
            SharedPreferences sharedPreferences2 = this.settings;
            this.fdist_v = sharedPreferences2.getInt("fdist_v_" + this.globales.secciones_a[this.ind_secc].id, this.fdist_v);
        }
        if (this.fsexo) {
            SharedPreferences sharedPreferences3 = this.settings;
            this.fsexo_v = sharedPreferences3.getInt("fsexo_v_" + this.globales.secciones_a[this.ind_secc].id, this.fsexo_v);
        }
        if (this.fedad1) {
            SharedPreferences sharedPreferences4 = this.settings;
            this.fedad1_v = sharedPreferences4.getInt("fedad1_v_" + this.globales.secciones_a[this.ind_secc].id, this.fedad1_v);
        }
        if (this.fedad2) {
            SharedPreferences sharedPreferences5 = this.settings;
            this.fedad2_v = sharedPreferences5.getInt("fedad2_v_" + this.globales.secciones_a[this.ind_secc].id, this.fedad2_v);
        }
        if (this.settings.getString("nick", "").equals("") || (this.globales.fb_modo == 3 && !this.settings.getBoolean("email_confirmado", false))) {
            Intent intent = new Intent(this, chat_perfil.class);
            intent.putExtra("idsecc", this.globales.secciones_a[this.ind_secc].id);
            intent.putExtra("desde_buscusus", true);
            if (this.es_root) {
                intent.putExtra("es_root", this.es_root);
            }
            this.es_root = false;
            this.finalizar_2 = true;
            startActivityForResult(intent, 0);
        } else if ((this.fotos_perfil == 2 && !this.globales.getTempFile(this, 1).exists()) || ((this.p_fnac == 2 && (this.settings.getInt("fnac_d", 0) == 0 || this.settings.getInt("fnac_m", 0) == 0 || this.settings.getInt("fnac_a", 0) == 0)) || ((this.p_sexo == 2 && this.settings.getInt("sexo", 0) == 0) || (this.p_descr == 2 && this.settings.getString("descr", "").equals(""))))) {
            Intent intent2 = new Intent(this, preperfil.class);
            intent2.putExtra("idsecc", this.globales.secciones_a[this.ind_secc].id);
            intent2.putExtra("desde_buscusus", true);
            if (this.es_root) {
                intent2.putExtra("es_root", this.es_root);
            }
            this.es_root = false;
            this.finalizar_2 = true;
            startActivityForResult(intent2, 0);
        }
        if (!this.finalizar_2) {
            setContentView(R.layout.t_buscusus);
            incluir_menu_pre();
            this.globales.onCreate_global(this, false);
            SearchManager searchManager = (SearchManager) getSystemService("search");
            searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
                public void onCancel() {
                    t_buscusus.this.finalizar = false;
                    t_buscusus.this.setResult(0);
                }
            });
            searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
                public void onDismiss() {
                    t_buscusus.this.buscador_on = false;
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
            if (!str.equals("")) {
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + str), Color.parseColor("#" + str2)}));
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
            if (this.c1_esclaro) {
                this.sinfoto = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto_light);
            } else {
                this.sinfoto = BitmapFactory.decodeResource(getResources(), R.drawable.sinfoto);
            }
            ImageView imageView = (ImageView) findViewById(R.id.btnperfil);
            if (this.globales.v_ico_perfil > 0 && this.settings.getInt("v_ico_perfil_act", 0) == this.globales.v_ico_perfil) {
                try {
                    this.globales.file_to_iv("ico_perfil", imageView);
                } catch (Exception unused2) {
                }
            }
            imageView.setOnClickListener(this);
            imageView.setVisibility(0);
            this.tv_fsexo = (TextView) findViewById(R.id.tv_fsexo);
            this.tv_fnick = (TextView) findViewById(R.id.tv_fnick);
            this.tv_fdist = (TextView) findViewById(R.id.tv_fdist);
            this.tv_fedad1 = (TextView) findViewById(R.id.tv_fedad1);
            this.tv_fedad2 = (TextView) findViewById(R.id.tv_fedad2);
            mostrar_filtros();
            this.usus_a = new ArrayList<>();
            this.usus_a_completo = false;
            this.gridView = (GridView) findViewById(R.id.grid);
            GridViewAdapter gridViewAdapter = new GridViewAdapter(this, R.layout.t_buscusus_row, this.usus_a);
            this.gridAdapter = gridViewAdapter;
            this.gridView.setAdapter(gridViewAdapter);
            this.gridView.setOnItemClickListener(this);
            this.dialog_filtros = crear_dialog_filtros();
            this.cargado_primeravez = false;
            cargar_usus cargar_usus2 = new cargar_usus(0);
            this.c_u = cargar_usus2;
            cargar_usus2.execute(new String[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if (config == null || !config.onActivityResult_glob(i, i2, intent, this)) {
            boolean z = false;
            if (i2 == -1 && intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
                if (!intent.getExtras().getBoolean("finalizar_app")) {
                    this.es_root = false;
                }
                setResult(-1, intent);
                finish();
                z = true;
            }
            if (!z && this.finalizar_2) {
                finish();
            }
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

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Usu usu = this.usus_a.get(i);
        if (!usu.id.equals("-1")) {
            Intent intent = new Intent(this, profile.class);
            intent.putExtra("id", usu.id);
            intent.putExtra("privados", usu.privados);
            intent.putExtra("nombre", usu.nick);
            intent.putExtra("coments", usu.coments);
            intent.putExtra("fnac_d", usu.fnac_d);
            intent.putExtra("fnac_m", usu.fnac_m);
            intent.putExtra("fnac_a", usu.fnac_a);
            intent.putExtra("sexo", usu.sexo);
            intent.putExtra("vfoto", usu.vfoto);
            intent.putExtra("dist", usu.dist);
            intent.putExtra("p_fnac", this.p_fnac);
            intent.putExtra("p_sexo", this.p_sexo);
            intent.putExtra("p_descr", this.p_descr);
            intent.putExtra("p_dist", this.p_dist);
            intent.putExtra("coments_chat", this.coments_glob);
            intent.putExtra("galeria", this.galeria);
            intent.putExtra("privados_chat", this.privados_glob);
            intent.putExtra("fotos_perfil", this.fotos_perfil);
            intent.putExtra("fotos_chat", 1);
            intent.putExtra("conectado", usu.conectado);
            startActivityForResult(intent, 0);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ll_filtros) {
            this.dialog_filtros.show();
        } else if (view.getId() == R.id.btnperfil) {
            Intent intent = new Intent(this, preperfil.class);
            intent.putExtra("idsecc", this.globales.secciones_a[this.ind_secc].id);
            intent.putExtra("nocompletar", true);
            intent.putExtra("desde_buscusus", true);
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

    private class cargar_usus extends AsyncTask<String, Void, String> {
        int ind_ini;

        cargar_usus(int i) {
            this.ind_ini = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_buscusus.this.usus_a.isEmpty() || !t_buscusus.this.usus_a.get(t_buscusus.this.usus_a.size() - 1).id.equals("-1")) {
                Usu usu = new Usu();
                usu.id = "-1";
                usu.vfoto = "0";
                t_buscusus.this.usus_a.add(usu);
                t_buscusus.this.gridAdapter.notifyDataSetChanged();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x013f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                java.lang.String r7 = r7.pais
                java.lang.String r0 = "US"
                boolean r7 = r7.equals(r0)
                if (r7 != 0) goto L_0x0028
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                java.lang.String r7 = r7.pais
                java.lang.String r0 = "GB"
                boolean r7 = r7.equals(r0)
                if (r7 != 0) goto L_0x0028
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                java.lang.String r7 = r7.pais
                java.lang.String r0 = "MM"
                boolean r7 = r7.equals(r0)
                if (r7 == 0) goto L_0x0025
                goto L_0x0028
            L_0x0025:
                java.lang.String r7 = "km"
                goto L_0x002a
            L_0x0028:
                java.lang.String r7 = "mi"
            L_0x002a:
                r0 = 0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013b }
                r1.<init>()     // Catch:{ Exception -> 0x013b }
                java.lang.String r2 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x013b }
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                java.lang.String r2 = "/srv/obtener_usus.php?idusu="
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r2 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                long r2 = r2.idusu     // Catch:{ Exception -> 0x013b }
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                java.lang.String r2 = "&c="
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r2 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                java.lang.String r2 = r2.codigo     // Catch:{ Exception -> 0x013b }
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                java.lang.String r2 = "&ind_ini="
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                int r2 = r6.ind_ini     // Catch:{ Exception -> 0x013b }
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                java.lang.String r2 = "&accext="
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r2 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.config r2 = r2.globales     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.Seccion[] r2 = r2.secciones_a     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r3 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                int r3 = r3.ind_secc     // Catch:{ Exception -> 0x013b }
                r2 = r2[r3]     // Catch:{ Exception -> 0x013b }
                boolean r2 = r2.acceso_a_externo     // Catch:{ Exception -> 0x013b }
                r3 = 1
                if (r2 == 0) goto L_0x006f
                r2 = 1
                goto L_0x0070
            L_0x006f:
                r2 = 0
            L_0x0070:
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                java.lang.String r2 = "&idsec="
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r2 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.config r2 = r2.globales     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.Seccion[] r2 = r2.secciones_a     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r4 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                int r4 = r4.ind_secc     // Catch:{ Exception -> 0x013b }
                r2 = r2[r4]     // Catch:{ Exception -> 0x013b }
                int r2 = r2.id     // Catch:{ Exception -> 0x013b }
                r1.append(r2)     // Catch:{ Exception -> 0x013b }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x013b }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013b }
                r2.<init>()     // Catch:{ Exception -> 0x013b }
                r2.append(r1)     // Catch:{ Exception -> 0x013b }
                java.lang.String r1 = "&fdist_v="
                r2.append(r1)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                int r1 = r1.fdist_v     // Catch:{ Exception -> 0x013b }
                r2.append(r1)     // Catch:{ Exception -> 0x013b }
                java.lang.String r1 = "&fdist_u="
                r2.append(r1)     // Catch:{ Exception -> 0x013b }
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                java.lang.String r7 = "&fsexo_v="
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                int r7 = r7.fsexo_v     // Catch:{ Exception -> 0x013b }
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                java.lang.String r7 = "&fedad1_v="
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                int r7 = r7.fedad1_v     // Catch:{ Exception -> 0x013b }
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                java.lang.String r7 = "&fedad2_v="
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                int r7 = r7.fedad2_v     // Catch:{ Exception -> 0x013b }
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                java.lang.String r7 = "&fnick_v="
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x013b }
                java.lang.String r7 = r7.fnick_v     // Catch:{ Exception -> 0x013b }
                r2.append(r7)     // Catch:{ Exception -> 0x013b }
                java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x013b }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x013b }
                r1.<init>(r7)     // Catch:{ Exception -> 0x013b }
                java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x013b }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x013b }
                r7.setDoInput(r3)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r7.setReadTimeout(r0)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                java.lang.String r0 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r7.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                java.io.InputStream r0 = r7.getInputStream()     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r0.<init>()     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
            L_0x010d:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                if (r2 == 0) goto L_0x0128
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r3.<init>()     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r3.append(r2)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                r0.append(r2)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                goto L_0x010d
            L_0x0128:
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
                if (r7 == 0) goto L_0x0131
                r7.disconnect()
            L_0x0131:
                return r0
            L_0x0132:
                r0 = move-exception
                goto L_0x0143
            L_0x0134:
                r0 = r7
                goto L_0x013b
            L_0x0136:
                r7 = move-exception
                r5 = r0
                r0 = r7
                r7 = r5
                goto L_0x0143
            L_0x013b:
                java.lang.String r7 = ""
                if (r0 == 0) goto L_0x0142
                r0.disconnect()
            L_0x0142:
                return r7
            L_0x0143:
                if (r7 == 0) goto L_0x0148
                r7.disconnect()
            L_0x0148:
                goto L_0x014a
            L_0x0149:
                throw r0
            L_0x014a:
                goto L_0x0149
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscusus.cargar_usus.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            int i;
            String str3 = str;
            if (t_buscusus.this.usus_a != null && t_buscusus.this.usus_a.get(t_buscusus.this.usus_a.size() - 1).id.equals("-1")) {
                t_buscusus.this.usus_a.remove(t_buscusus.this.usus_a.size() - 1);
                t_buscusus.this.gridAdapter.notifyDataSetChanged();
            }
            if (str3.contains("ANDROID:OK DATOS:")) {
                char c = 6;
                String[] split = str3.substring(str3.indexOf("DATOS:") + 6).split(";");
                SharedPreferences.Editor edit = t_buscusus.this.settings.edit();
                char c2 = 0;
                int i2 = 0;
                while (true) {
                    str2 = "";
                    if (split[i2].equals(ExifInterface.LATITUDE_SOUTH) || split[i2].equals("N")) {
                        edit.commit();
                    } else {
                        String[] split2 = split[i2].split("@");
                        Usu usu = new Usu();
                        usu.id = split2[c2];
                        usu.nick = split2[1];
                        usu.vfoto = split2[2];
                        usu.privados = split2[3];
                        usu.fnac_d = split2[4];
                        usu.fnac_m = split2[5];
                        usu.fnac_a = split2[c];
                        if (usu.fnac_d.equals("0") || usu.fnac_m.equals("0") || usu.fnac_a.equals("0")) {
                            i = 0;
                        } else {
                            Calendar instance = Calendar.getInstance();
                            instance.set(Integer.parseInt(usu.fnac_a), Integer.parseInt(usu.fnac_m) - 1, Integer.parseInt(usu.fnac_d));
                            Calendar instance2 = Calendar.getInstance();
                            i = instance2.get(1) - instance.get(1);
                            if (instance.get(2) > instance2.get(2) || (instance.get(2) == instance2.get(2) && instance.get(5) > instance2.get(5))) {
                                i--;
                            }
                        }
                        usu.edad = i;
                        usu.sexo = split2[7];
                        usu.coments = split2[8];
                        if (!split2[9].equals("-1")) {
                            str2 = split2[9];
                        }
                        usu.dist = str2;
                        usu.fav = split2[10].equals("1");
                        if (usu.fav) {
                            edit.putBoolean("usufav_" + usu.id, true);
                        } else {
                            edit.remove("usufav_" + usu.id);
                        }
                        usu.conectado = split2[11].equals("1");
                        t_buscusus.this.usus_a.add(usu);
                        i2++;
                        c = 6;
                        c2 = 0;
                    }
                }
                edit.commit();
                if (split[i2].equals("N")) {
                    t_buscusus.this.usus_a_completo = true;
                }
                t_buscusus.this.gridAdapter.notifyDataSetChanged();
                if (i2 > 0 && (t_buscusus.this.c_f == null || t_buscusus.this.c_f.getStatus() != AsyncTask.Status.RUNNING)) {
                    t_buscusus.this.c_f = new cargar_fotos();
                    t_buscusus.this.c_f.execute(new String[0]);
                    t_buscusus.this.cargado_primeravez = true;
                }
                if (t_buscusus.this.usus_a.isEmpty()) {
                    final AlertDialog create = new AlertDialog.Builder(t_buscusus.this).setPositiveButton(R.string.aceptar, (DialogInterface.OnClickListener) null).setMessage(R.string.sin_usus).create();
                    if (!t_buscusus.this.cbtn.equals(str2)) {
                        create.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + t_buscusus.this.cbtn));
                            }
                        });
                    }
                    try {
                        create.show();
                    } catch (Exception unused) {
                    }
                    try {
                        ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                    } catch (Exception unused2) {
                    }
                }
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

    private class cargar_fotos extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        int i_cargando;
        String idusu_acargar;
        String vfoto_bd;

        private cargar_fotos() {
            this.i_cargando = -1;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            int firstVisiblePosition = t_buscusus.this.gridView.getFirstVisiblePosition();
            while (firstVisiblePosition <= Math.max(t_buscusus.this.gridView.getLastVisiblePosition(), 30) && t_buscusus.this.usus_a != null && firstVisiblePosition < t_buscusus.this.usus_a.size()) {
                if (t_buscusus.this.usus_a.get(firstVisiblePosition).foto_pendiente && !t_buscusus.this.usus_a.get(firstVisiblePosition).vfoto.equals("0")) {
                    String str = t_buscusus.this.usus_a.get(firstVisiblePosition).vfoto;
                    SharedPreferences sharedPreferences = t_buscusus.this.settings;
                    if (!str.equals(sharedPreferences.getString("fperfil_" + t_buscusus.this.usus_a.get(firstVisiblePosition).id, "0"))) {
                        this.idusu_acargar = t_buscusus.this.usus_a.get(firstVisiblePosition).id + "";
                        this.vfoto_bd = t_buscusus.this.usus_a.get(firstVisiblePosition).vfoto;
                        t_buscusus.this.usus_a.get(firstVisiblePosition).cargando = true;
                        t_buscusus.this.usus_a.get(firstVisiblePosition).foto_pendiente = false;
                        this.i_cargando = firstVisiblePosition;
                        return;
                    }
                }
                firstVisiblePosition++;
            }
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            if (this.idusu_acargar == null) {
                return "-1";
            }
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(config.DOM_CDN + "/srv/imgs/usus/" + this.idusu_acargar + "_1_p.jpg?v=" + this.vfoto_bd).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    this.bmImg = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    httpURLConnection.disconnect();
                    File file = t_buscusus.this.path;
                    try {
                        this.bmImg.compress(Bitmap.CompressFormat.JPEG, 70, new FileOutputStream(new File(file, "fperfil_" + this.idusu_acargar + ".jpg")));
                        return "1";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "0";
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return "0";
                }
            } catch (MalformedURLException unused) {
                return "0";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (!(this.i_cargando == -1 || t_buscusus.this.usus_a == null)) {
                try {
                    t_buscusus.this.usus_a.get(this.i_cargando).cargando = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (this.idusu_acargar != null && !str.equals("-1")) {
                if (str == "1") {
                    SharedPreferences.Editor edit = t_buscusus.this.settings.edit();
                    edit.putString("fperfil_" + this.idusu_acargar, this.vfoto_bd);
                    edit.commit();
                }
                t_buscusus.this.gridAdapter.notifyDataSetChanged();
                new cargar_fotos().execute(new String[0]);
            } else if (!str.equals("-1")) {
                t_buscusus.this.gridAdapter.notifyDataSetChanged();
            }
        }
    }

    private class Usu {
        boolean cargando;
        String coments;
        boolean conectado;
        String dist;
        int edad;
        boolean fav;
        String fnac_a;
        String fnac_d;
        String fnac_m;
        boolean foto_pendiente;
        String id;
        boolean mostrado;
        String nick;
        String privados;
        String sexo;
        String vfoto;

        private Usu() {
            this.foto_pendiente = true;
            this.cargando = false;
            this.mostrado = false;
            this.fav = false;
            this.conectado = false;
        }
    }

    public class GridViewAdapter extends ArrayAdapter<Usu> {
        private Context context;
        private ArrayList<Usu> data;
        private int layoutResourceId;

        public GridViewAdapter(Context context2, int i, ArrayList<Usu> arrayList) {
            super(context2, i, arrayList);
            new ArrayList();
            this.layoutResourceId = i;
            this.context = context2;
            this.data = arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:81:0x02bd, code lost:
            if (r11.vfoto.equals(r10.this$0.settings.getString("fperfil_" + r11.id, "0")) == false) goto L_0x02c2;
         */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x02c5  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x02dd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
            /*
                r10 = this;
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                boolean r0 = r0.usus_a_completo
                r1 = 0
                if (r0 != 0) goto L_0x0040
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                java.util.ArrayList<stikerwap.appdys.t_buscusus$Usu> r0 = r0.usus_a
                int r0 = r0.size()
                int r0 = r0 - r11
                r2 = 10
                if (r0 >= r2) goto L_0x0040
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_usus r0 = r0.c_u
                if (r0 == 0) goto L_0x0026
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_usus r0 = r0.c_u
                android.os.AsyncTask$Status r0 = r0.getStatus()
                android.os.AsyncTask$Status r2 = android.os.AsyncTask.Status.RUNNING
                if (r0 == r2) goto L_0x0040
            L_0x0026:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_usus r2 = new stikerwap.appdys.t_buscusus$cargar_usus
                stikerwap.appdys.t_buscusus r3 = stikerwap.appdys.t_buscusus.this
                java.util.ArrayList<stikerwap.appdys.t_buscusus$Usu> r4 = r3.usus_a
                int r4 = r4.size()
                r2.<init>(r4)
                r0.c_u = r2
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_usus r0 = r0.c_u
                java.lang.String[] r2 = new java.lang.String[r1]
                r0.execute(r2)
            L_0x0040:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                int r0 = r0.fotos_perfil
                r2 = 0
                if (r0 <= 0) goto L_0x0073
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                boolean r0 = r0.cargado_primeravez
                if (r0 == 0) goto L_0x0073
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_fotos r0 = r0.c_f
                if (r0 == 0) goto L_0x005f
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_fotos r0 = r0.c_f
                android.os.AsyncTask$Status r0 = r0.getStatus()
                android.os.AsyncTask$Status r3 = android.os.AsyncTask.Status.RUNNING
                if (r0 == r3) goto L_0x0073
            L_0x005f:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_fotos r3 = new stikerwap.appdys.t_buscusus$cargar_fotos
                stikerwap.appdys.t_buscusus r4 = stikerwap.appdys.t_buscusus.this
                r3.<init>()
                r0.c_f = r3
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.t_buscusus$cargar_fotos r0 = r0.c_f
                java.lang.String[] r3 = new java.lang.String[r1]
                r0.execute(r3)
            L_0x0073:
                if (r12 != 0) goto L_0x0107
                android.content.Context r12 = r10.context
                android.app.Activity r12 = (android.app.Activity) r12
                android.view.LayoutInflater r12 = r12.getLayoutInflater()
                int r0 = r10.layoutResourceId
                android.view.View r12 = r12.inflate(r0, r13, r1)
                stikerwap.appdys.t_buscusus$GridViewAdapter$ViewHolder r13 = new stikerwap.appdys.t_buscusus$GridViewAdapter$ViewHolder
                r13.<init>()
                r0 = 2131363479(0x7f0a0697, float:1.8346768E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r13.imageTitle = r0
                r0 = 2131363480(0x7f0a0698, float:1.834677E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r13.imageSubtitle = r0
                r0 = 2131362516(0x7f0a02d4, float:1.8344815E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                r13.image = r0
                r0 = 2131363001(0x7f0a04b9, float:1.8345798E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
                r13.pb_foto = r0
                r0 = 2131363004(0x7f0a04bc, float:1.8345805E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
                r13.pb_foto_inv = r0
                r0 = 2131362642(0x7f0a0352, float:1.834507E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                r13.ll_txt = r0
                r0 = 2131362598(0x7f0a0326, float:1.8344981E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                r13.ll_favorito_top = r0
                r0 = 2131362597(0x7f0a0325, float:1.834498E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                r13.ll_favorito_bottom = r0
                r0 = 2131362580(0x7f0a0314, float:1.8344945E38)
                android.view.View r0 = r12.findViewById(r0)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                r13.ll_conectado = r0
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 20
                if (r0 <= r3) goto L_0x0103
                android.widget.ProgressBar r0 = r13.pb_foto
                stikerwap.appdys.t_buscusus r3 = stikerwap.appdys.t_buscusus.this
                java.lang.String r3 = r3.cbtn
                stikerwap.appdys.config.progress_color(r0, r3)
                android.widget.ProgressBar r0 = r13.pb_foto_inv
                stikerwap.appdys.t_buscusus r3 = stikerwap.appdys.t_buscusus.this
                java.lang.String r3 = r3.cbtn
                stikerwap.appdys.config.progress_color(r0, r3)
            L_0x0103:
                r12.setTag(r13)
                goto L_0x010d
            L_0x0107:
                java.lang.Object r13 = r12.getTag()
                stikerwap.appdys.t_buscusus$GridViewAdapter$ViewHolder r13 = (stikerwap.appdys.t_buscusus.GridViewAdapter.ViewHolder) r13
            L_0x010d:
                java.util.ArrayList<stikerwap.appdys.t_buscusus$Usu> r0 = r10.data
                java.lang.Object r11 = r0.get(r11)
                stikerwap.appdys.t_buscusus$Usu r11 = (stikerwap.appdys.t_buscusus.Usu) r11
                java.lang.String r0 = r11.id
                java.lang.String r3 = "-1"
                boolean r0 = r0.equals(r3)
                java.lang.String r3 = ""
                r4 = 8
                if (r0 == 0) goto L_0x0162
                android.widget.TextView r11 = r13.imageTitle
                r11.setText(r3)
                android.widget.TextView r11 = r13.imageSubtitle
                r11.setText(r3)
                android.widget.ImageView r11 = r13.image
                r11.setImageBitmap(r2)
                android.widget.ProgressBar r11 = r13.pb_foto
                r11.setVisibility(r4)
                android.widget.ProgressBar r11 = r13.pb_foto_inv
                r11.setVisibility(r4)
                stikerwap.appdys.t_buscusus r11 = stikerwap.appdys.t_buscusus.this
                boolean r11 = r11.c1_esclaro
                if (r11 == 0) goto L_0x0148
                android.widget.ProgressBar r11 = r13.pb_foto_inv
                r11.setVisibility(r1)
                goto L_0x014d
            L_0x0148:
                android.widget.ProgressBar r11 = r13.pb_foto
                r11.setVisibility(r1)
            L_0x014d:
                android.widget.LinearLayout r11 = r13.ll_txt
                r11.setVisibility(r4)
                android.widget.LinearLayout r11 = r13.ll_favorito_top
                r11.setVisibility(r4)
                android.widget.LinearLayout r11 = r13.ll_favorito_bottom
                r11.setVisibility(r4)
                android.widget.LinearLayout r11 = r13.ll_conectado
                r11.setVisibility(r4)
                return r12
            L_0x0162:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                int r0 = r0.fotos_perfil
                if (r0 != 0) goto L_0x017d
                android.widget.LinearLayout r0 = r13.ll_txt
                stikerwap.appdys.t_buscusus r5 = stikerwap.appdys.t_buscusus.this
                int r5 = r5.padding_1
                stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                int r6 = r6.padding_2
                stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                int r7 = r7.padding_1
                stikerwap.appdys.t_buscusus r8 = stikerwap.appdys.t_buscusus.this
                int r8 = r8.padding_2
                r0.setPadding(r5, r6, r7, r8)
            L_0x017d:
                android.widget.LinearLayout r0 = r13.ll_txt
                r0.setVisibility(r1)
                boolean r0 = r11.fav
                if (r0 == 0) goto L_0x0191
                android.widget.LinearLayout r0 = r13.ll_favorito_bottom
                r0.setVisibility(r4)
                android.widget.LinearLayout r0 = r13.ll_favorito_top
                r0.setVisibility(r1)
                goto L_0x019b
            L_0x0191:
                android.widget.LinearLayout r0 = r13.ll_favorito_top
                r0.setVisibility(r4)
                android.widget.LinearLayout r0 = r13.ll_favorito_bottom
                r0.setVisibility(r4)
            L_0x019b:
                boolean r0 = r11.conectado
                if (r0 == 0) goto L_0x01a5
                android.widget.LinearLayout r0 = r13.ll_conectado
                r0.setVisibility(r1)
                goto L_0x01aa
            L_0x01a5:
                android.widget.LinearLayout r0 = r13.ll_conectado
                r0.setVisibility(r4)
            L_0x01aa:
                android.widget.TextView r0 = r13.imageTitle
                java.lang.String r5 = r11.nick
                r0.setText(r5)
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                int r0 = r0.p_fnac
                r5 = 1
                if (r0 > 0) goto L_0x01be
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                int r0 = r0.p_dist
                if (r0 != r5) goto L_0x027d
            L_0x01be:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                int r0 = r0.p_fnac
                if (r0 <= 0) goto L_0x01e7
                int r0 = r11.edad
                if (r0 <= 0) goto L_0x01e7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r3)
                int r6 = r11.edad
                r0.append(r6)
                stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                android.content.res.Resources r6 = r6.getResources()
                r7 = 2131886128(0x7f120030, float:1.9406826E38)
                java.lang.String r6 = r6.getString(r7)
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                goto L_0x01e8
            L_0x01e7:
                r0 = r3
            L_0x01e8:
                stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                int r6 = r6.p_dist
                if (r6 != r5) goto L_0x0273
                java.lang.String r6 = r11.dist
                boolean r6 = r6.equals(r3)
                if (r6 != 0) goto L_0x0273
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x020d
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                java.lang.String r0 = ", "
                r3.append(r0)
                java.lang.String r0 = r3.toString()
            L_0x020d:
                java.lang.String r3 = r11.dist
                int r3 = java.lang.Integer.parseInt(r3)
                int r3 = r3 / 1000
                stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                java.lang.String r6 = r6.pais
                java.lang.String r7 = "US"
                boolean r6 = r6.equals(r7)
                if (r6 != 0) goto L_0x023d
                stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                java.lang.String r6 = r6.pais
                java.lang.String r7 = "GB"
                boolean r6 = r6.equals(r7)
                if (r6 != 0) goto L_0x023d
                stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                java.lang.String r6 = r6.pais
                java.lang.String r7 = "MM"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x023a
                goto L_0x023d
            L_0x023a:
                java.lang.String r6 = "km."
                goto L_0x024a
            L_0x023d:
                double r6 = (double) r3
                r8 = 4609884578576439706(0x3ff999999999999a, double:1.6)
                java.lang.Double.isNaN(r6)
                double r6 = r6 / r8
                int r3 = (int) r6
                java.lang.String r6 = "mi."
            L_0x024a:
                if (r3 != 0) goto L_0x0261
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                java.lang.String r0 = "<1"
                r3.append(r0)
                r3.append(r6)
                java.lang.String r0 = r3.toString()
                goto L_0x0273
            L_0x0261:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r0)
                r7.append(r3)
                r7.append(r6)
                java.lang.String r0 = r7.toString()
            L_0x0273:
                android.widget.TextView r3 = r13.imageSubtitle
                r3.setText(r0)
                android.widget.TextView r0 = r13.imageSubtitle
                r0.setVisibility(r1)
            L_0x027d:
                android.widget.ProgressBar r0 = r13.pb_foto
                r0.setVisibility(r4)
                android.widget.ProgressBar r0 = r13.pb_foto_inv
                r0.setVisibility(r4)
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                int r0 = r0.fotos_perfil
                if (r0 <= 0) goto L_0x0345
                boolean r0 = r11.cargando
                java.lang.String r3 = "0"
                java.lang.String r4 = "fperfil_"
                if (r0 != 0) goto L_0x02c2
                boolean r0 = r11.foto_pendiente
                if (r0 == 0) goto L_0x02c0
                java.lang.String r0 = r11.vfoto
                boolean r0 = r0.equals(r3)
                if (r0 != 0) goto L_0x02c0
                java.lang.String r0 = r11.vfoto
                stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                android.content.SharedPreferences r6 = r6.settings
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>(r4)
                java.lang.String r8 = r11.id
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                java.lang.String r6 = r6.getString(r7, r3)
                boolean r0 = r0.equals(r6)
                if (r0 != 0) goto L_0x02c0
                goto L_0x02c2
            L_0x02c0:
                r0 = 0
                goto L_0x02c3
            L_0x02c2:
                r0 = 1
            L_0x02c3:
                if (r0 == 0) goto L_0x02dd
                android.widget.ImageView r11 = r13.image
                r11.setImageBitmap(r2)
                stikerwap.appdys.t_buscusus r11 = stikerwap.appdys.t_buscusus.this
                boolean r11 = r11.c1_esclaro
                if (r11 == 0) goto L_0x02d7
                android.widget.ProgressBar r11 = r13.pb_foto_inv
                r11.setVisibility(r1)
                goto L_0x034a
            L_0x02d7:
                android.widget.ProgressBar r11 = r13.pb_foto
                r11.setVisibility(r1)
                goto L_0x034a
            L_0x02dd:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                stikerwap.appdys.config r0 = r0.globales
                stikerwap.appdys.Seccion[] r0 = r0.secciones_a
                stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this
                int r1 = r1.ind_secc
                r0 = r0[r1]
                int r0 = r0.fotos_perfil
                if (r0 <= 0) goto L_0x0330
                java.lang.String r0 = r11.vfoto
                boolean r0 = r0.equals(r3)
                if (r0 != 0) goto L_0x0330
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x032b }
                stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x032b }
                java.io.File r1 = r1.path     // Catch:{ Exception -> 0x032b }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032b }
                r2.<init>(r4)     // Catch:{ Exception -> 0x032b }
                java.lang.String r3 = r11.id     // Catch:{ Exception -> 0x032b }
                r2.append(r3)     // Catch:{ Exception -> 0x032b }
                java.lang.String r3 = ".jpg"
                r2.append(r3)     // Catch:{ Exception -> 0x032b }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x032b }
                r0.<init>(r1, r2)     // Catch:{ Exception -> 0x032b }
                boolean r1 = r0.exists()     // Catch:{ Exception -> 0x032b }
                if (r1 == 0) goto L_0x0326
                stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x032b }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x032b }
                android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ Exception -> 0x032b }
                android.graphics.Bitmap r0 = android.provider.MediaStore.Images.Media.getBitmap(r1, r0)     // Catch:{ Exception -> 0x032b }
                goto L_0x0334
            L_0x0326:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this     // Catch:{ Exception -> 0x032b }
                android.graphics.Bitmap r0 = r0.sinfoto     // Catch:{ Exception -> 0x032b }
                goto L_0x0334
            L_0x032b:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                android.graphics.Bitmap r0 = r0.sinfoto
                goto L_0x0334
            L_0x0330:
                stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                android.graphics.Bitmap r0 = r0.sinfoto
            L_0x0334:
                android.widget.ImageView r1 = r13.image
                r1.setImageBitmap(r0)
                boolean r0 = r11.mostrado
                if (r0 != 0) goto L_0x034a
                r11.mostrado = r5
                android.widget.ImageView r11 = r13.image
                stikerwap.appdys.config.fade_in(r11)
                goto L_0x034a
            L_0x0345:
                android.widget.ImageView r11 = r13.image
                r11.setVisibility(r4)
            L_0x034a:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscusus.GridViewAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        class ViewHolder {
            ImageView image;
            TextView imageSubtitle;
            TextView imageTitle;
            LinearLayout ll_conectado;
            LinearLayout ll_favorito_bottom;
            LinearLayout ll_favorito_top;
            LinearLayout ll_txt;
            ProgressBar pb_foto;
            ProgressBar pb_foto_inv;

            ViewHolder() {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Dialog crear_dialog_filtros() {
        Dialog dialog = new Dialog(this);
        if (getResources().getConfiguration().orientation == 2) {
            dialog.setContentView(R.layout.filtros_h);
        } else {
            dialog.setContentView(R.layout.filtros);
        }
        dialog.setTitle(getResources().getString(R.string.selecciona));
        TextView textView = (TextView) dialog.findViewById(R.id.btn_aceptar);
        textView.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:33:0x008c  */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x00da  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0106  */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x0159  */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x01a6  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r10) {
                /*
                    r9 = this;
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    android.content.SharedPreferences r10 = r10.settings
                    android.content.SharedPreferences$Editor r10 = r10.edit()
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    boolean r0 = r0.fdist
                    r1 = 5
                    r2 = 3
                    r3 = 1
                    r4 = 2
                    r5 = 0
                    if (r0 == 0) goto L_0x0085
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    android.app.Dialog r0 = r0.dialog_filtros
                    r6 = 2131363193(0x7f0a0579, float:1.8346188E38)
                    android.view.View r0 = r0.findViewById(r6)
                    android.widget.Spinner r0 = (android.widget.Spinner) r0
                    int r0 = r0.getSelectedItemPosition()
                    if (r0 != r4) goto L_0x0028
                    r6 = 1
                    goto L_0x0056
                L_0x0028:
                    if (r0 != r2) goto L_0x002c
                    r6 = 2
                    goto L_0x0056
                L_0x002c:
                    r6 = 4
                    if (r0 != r6) goto L_0x0031
                    r6 = 5
                    goto L_0x0056
                L_0x0031:
                    r6 = 10
                    if (r0 != r1) goto L_0x0036
                    goto L_0x0056
                L_0x0036:
                    r7 = 6
                    if (r0 != r7) goto L_0x003c
                    r6 = 20
                    goto L_0x0056
                L_0x003c:
                    r7 = 7
                    if (r0 != r7) goto L_0x0042
                    r6 = 50
                    goto L_0x0056
                L_0x0042:
                    r7 = 8
                    if (r0 != r7) goto L_0x0049
                    r6 = 100
                    goto L_0x0056
                L_0x0049:
                    r7 = 9
                    if (r0 != r7) goto L_0x0050
                    r6 = 200(0xc8, float:2.8E-43)
                    goto L_0x0056
                L_0x0050:
                    if (r0 != r6) goto L_0x0055
                    r6 = 500(0x1f4, float:7.0E-43)
                    goto L_0x0056
                L_0x0055:
                    r6 = 0
                L_0x0056:
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    int r0 = r0.fdist_v
                    if (r0 == r6) goto L_0x0085
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    r0.fdist_v = r6
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r6 = "fdist_v_"
                    r0.<init>(r6)
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.config r6 = r6.globales
                    stikerwap.appdys.Seccion[] r6 = r6.secciones_a
                    stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                    int r7 = r7.ind_secc
                    r6 = r6[r7]
                    int r6 = r6.id
                    r0.append(r6)
                    java.lang.String r0 = r0.toString()
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    int r6 = r6.fdist_v
                    r10.putInt(r0, r6)
                    r0 = 1
                    goto L_0x0086
                L_0x0085:
                    r0 = 0
                L_0x0086:
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    boolean r6 = r6.fsexo
                    if (r6 == 0) goto L_0x00d4
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    android.app.Dialog r6 = r6.dialog_filtros
                    r7 = 2131363196(0x7f0a057c, float:1.8346194E38)
                    android.view.View r6 = r6.findViewById(r7)
                    android.widget.Spinner r6 = (android.widget.Spinner) r6
                    int r6 = r6.getSelectedItemPosition()
                    if (r6 != r4) goto L_0x00a1
                    r6 = 1
                    goto L_0x00a6
                L_0x00a1:
                    if (r6 != r2) goto L_0x00a5
                    r6 = 2
                    goto L_0x00a6
                L_0x00a5:
                    r6 = 0
                L_0x00a6:
                    stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                    int r7 = r7.fsexo_v
                    if (r7 == r6) goto L_0x00d4
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    r0.fsexo_v = r6
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r6 = "fsexo_v_"
                    r0.<init>(r6)
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.config r6 = r6.globales
                    stikerwap.appdys.Seccion[] r6 = r6.secciones_a
                    stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                    int r7 = r7.ind_secc
                    r6 = r6[r7]
                    int r6 = r6.id
                    r0.append(r6)
                    java.lang.String r0 = r0.toString()
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    int r6 = r6.fsexo_v
                    r10.putInt(r0, r6)
                    r0 = 1
                L_0x00d4:
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    boolean r6 = r6.fnick
                    if (r6 == 0) goto L_0x00fe
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    android.app.Dialog r6 = r6.dialog_filtros
                    r7 = 2131363450(0x7f0a067a, float:1.834671E38)
                    android.view.View r6 = r6.findViewById(r7)
                    android.widget.EditText r6 = (android.widget.EditText) r6
                    android.text.Editable r6 = r6.getText()
                    java.lang.String r6 = r6.toString()
                    stikerwap.appdys.t_buscusus r7 = stikerwap.appdys.t_buscusus.this
                    java.lang.String r7 = r7.fnick_v
                    boolean r7 = r7.equals(r6)
                    if (r7 != 0) goto L_0x00fe
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    r0.fnick_v = r6
                    r0 = 1
                L_0x00fe:
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    boolean r6 = r6.fedad1
                    r7 = 18
                    if (r6 == 0) goto L_0x0153
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    android.app.Dialog r6 = r6.dialog_filtros
                    r8 = 2131363194(0x7f0a057a, float:1.834619E38)
                    android.view.View r6 = r6.findViewById(r8)
                    android.widget.Spinner r6 = (android.widget.Spinner) r6
                    int r6 = r6.getSelectedItemPosition()
                    if (r6 != r4) goto L_0x011c
                    r6 = 18
                    goto L_0x0125
                L_0x011c:
                    if (r6 <= r4) goto L_0x0124
                    int r6 = r6 - r2
                    int r6 = r6 * 5
                    int r6 = r6 + 25
                    goto L_0x0125
                L_0x0124:
                    r6 = 0
                L_0x0125:
                    stikerwap.appdys.t_buscusus r8 = stikerwap.appdys.t_buscusus.this
                    int r8 = r8.fedad1_v
                    if (r8 == r6) goto L_0x0153
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    r0.fedad1_v = r6
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r6 = "fedad1_v_"
                    r0.<init>(r6)
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.config r6 = r6.globales
                    stikerwap.appdys.Seccion[] r6 = r6.secciones_a
                    stikerwap.appdys.t_buscusus r8 = stikerwap.appdys.t_buscusus.this
                    int r8 = r8.ind_secc
                    r6 = r6[r8]
                    int r6 = r6.id
                    r0.append(r6)
                    java.lang.String r0 = r0.toString()
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    int r6 = r6.fedad1_v
                    r10.putInt(r0, r6)
                    r0 = 1
                L_0x0153:
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    boolean r6 = r6.fedad2
                    if (r6 == 0) goto L_0x01a4
                    stikerwap.appdys.t_buscusus r6 = stikerwap.appdys.t_buscusus.this
                    android.app.Dialog r6 = r6.dialog_filtros
                    r8 = 2131363195(0x7f0a057b, float:1.8346192E38)
                    android.view.View r6 = r6.findViewById(r8)
                    android.widget.Spinner r6 = (android.widget.Spinner) r6
                    int r6 = r6.getSelectedItemPosition()
                    if (r6 != r4) goto L_0x016d
                    goto L_0x0176
                L_0x016d:
                    if (r6 <= r4) goto L_0x0175
                    int r6 = r6 - r2
                    int r6 = r6 * 5
                    int r7 = r6 + 25
                    goto L_0x0176
                L_0x0175:
                    r7 = 0
                L_0x0176:
                    stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this
                    int r1 = r1.fedad2_v
                    if (r1 == r7) goto L_0x01a4
                    stikerwap.appdys.t_buscusus r0 = stikerwap.appdys.t_buscusus.this
                    r0.fedad2_v = r7
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "fedad2_v_"
                    r0.<init>(r1)
                    stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.config r1 = r1.globales
                    stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                    stikerwap.appdys.t_buscusus r2 = stikerwap.appdys.t_buscusus.this
                    int r2 = r2.ind_secc
                    r1 = r1[r2]
                    int r1 = r1.id
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this
                    int r1 = r1.fedad2_v
                    r10.putInt(r0, r1)
                    r0 = 1
                L_0x01a4:
                    if (r0 == 0) goto L_0x01e5
                    r10.commit()
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    r10.mostrar_filtros()
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    java.util.ArrayList<stikerwap.appdys.t_buscusus$Usu> r10 = r10.usus_a
                    r10.clear()
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    r10.usus_a_completo = r5
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.t_buscusus$GridViewAdapter r10 = r10.gridAdapter
                    r10.notifyDataSetChanged()
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    r10.cargado_primeravez = r5
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.t_buscusus$cargar_usus r10 = r10.c_u
                    if (r10 == 0) goto L_0x01d1
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.t_buscusus$cargar_usus r10 = r10.c_u
                    r10.cancel(r3)
                L_0x01d1:
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.t_buscusus$cargar_usus r0 = new stikerwap.appdys.t_buscusus$cargar_usus
                    stikerwap.appdys.t_buscusus r1 = stikerwap.appdys.t_buscusus.this
                    r0.<init>(r5)
                    r10.c_u = r0
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    stikerwap.appdys.t_buscusus$cargar_usus r10 = r10.c_u
                    java.lang.String[] r0 = new java.lang.String[r5]
                    r10.execute(r0)
                L_0x01e5:
                    stikerwap.appdys.t_buscusus r10 = stikerwap.appdys.t_buscusus.this
                    android.app.Dialog r10 = r10.dialog_filtros
                    r10.dismiss()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_buscusus.AnonymousClass3.onClick(android.view.View):void");
            }
        });
        if (Build.VERSION.SDK_INT > 20) {
            textView.setTextColor(Color.parseColor("#" + this.cbtn));
        }
        if (this.fedad1) {
            Spinner spinner = (Spinner) dialog.findViewById(R.id.sp_edad1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(getResources().getString(R.string.edad_min));
            arrayList.add(getResources().getString(R.string.todo));
            arrayList.add(">18" + getResources().getString(R.string.anyos_abrev));
            int i = 25;
            int i2 = -1;
            for (int i3 = 76; i < i3; i3 = 76) {
                arrayList.add(">" + i + getResources().getString(R.string.anyos_abrev));
                if (this.fedad1_v == i) {
                    i2 = arrayList.size() - 1;
                }
                i += 5;
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, arrayList);
            arrayAdapter.setDropDownViewResource(17367049);
            spinner.setAdapter(arrayAdapter);
            if (i2 != -1) {
                spinner.setSelection(i2);
            } else if (this.fedad1_v == 18) {
                spinner.setSelection(2);
            } else {
                spinner.setSelection(0);
            }
            spinner.setVisibility(0);
        }
        if (this.fedad2) {
            Spinner spinner2 = (Spinner) dialog.findViewById(R.id.sp_edad2);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(getResources().getString(R.string.edad_max));
            arrayList2.add(getResources().getString(R.string.todo));
            arrayList2.add("<18" + getResources().getString(R.string.anyos_abrev));
            int i4 = -1;
            for (int i5 = 25; i5 < 76; i5 += 5) {
                arrayList2.add("<" + i5 + getResources().getString(R.string.anyos_abrev));
                if (this.fedad2_v == i5) {
                    i4 = arrayList2.size() - 1;
                }
            }
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, 17367048, arrayList2);
            arrayAdapter2.setDropDownViewResource(17367049);
            spinner2.setAdapter(arrayAdapter2);
            if (i4 != -1) {
                spinner2.setSelection(i4);
            } else if (this.fedad2_v == 18) {
                spinner2.setSelection(2);
            } else {
                spinner2.setSelection(0);
            }
            spinner2.setVisibility(0);
        }
        if (this.fsexo) {
            Spinner spinner3 = (Spinner) dialog.findViewById(R.id.sp_sexo);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(getResources().getString(R.string.petic_sexo));
            arrayList3.add(getResources().getString(R.string.todo));
            arrayList3.add(getResources().getString(R.string.hombres));
            arrayList3.add(getResources().getString(R.string.mujeres));
            ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, 17367048, arrayList3);
            arrayAdapter3.setDropDownViewResource(17367049);
            spinner3.setAdapter(arrayAdapter3);
            int i6 = this.fsexo_v;
            if (i6 == 1) {
                spinner3.setSelection(2);
            } else if (i6 == 2) {
                spinner3.setSelection(3);
            } else {
                spinner3.setSelection(0);
            }
            spinner3.setVisibility(0);
        }
        if (this.fnick) {
            dialog.findViewById(R.id.tv_nick).setVisibility(0);
        }
        if (this.fdist) {
            Spinner spinner4 = (Spinner) dialog.findViewById(R.id.sp_dist);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(getResources().getString(R.string.dist));
            arrayList4.add(getResources().getString(R.string.todo));
            String str = (this.pais.equals("US") || this.pais.equals("GB") || this.pais.equals("MM")) ? "mi." : "km.";
            arrayList4.add("<1".concat(str));
            arrayList4.add("<2".concat(str));
            arrayList4.add("<5".concat(str));
            arrayList4.add("<10".concat(str));
            arrayList4.add("<20".concat(str));
            arrayList4.add("<50".concat(str));
            arrayList4.add("<100".concat(str));
            arrayList4.add("<200".concat(str));
            arrayList4.add("<500".concat(str));
            ArrayAdapter arrayAdapter4 = new ArrayAdapter(this, 17367048, arrayList4);
            arrayAdapter4.setDropDownViewResource(17367049);
            spinner4.setAdapter(arrayAdapter4);
            int i7 = this.fdist_v;
            if (i7 == 1) {
                spinner4.setSelection(2);
            } else if (i7 == 2) {
                spinner4.setSelection(3);
            } else if (i7 == 5) {
                spinner4.setSelection(4);
            } else if (i7 == 10) {
                spinner4.setSelection(5);
            } else if (i7 == 20) {
                spinner4.setSelection(6);
            } else if (i7 == 50) {
                spinner4.setSelection(7);
            } else if (i7 == 100) {
                spinner4.setSelection(8);
            } else if (i7 == 200) {
                spinner4.setSelection(9);
            } else if (i7 == 500) {
                spinner4.setSelection(10);
            } else {
                spinner4.setSelection(0);
            }
            spinner4.setVisibility(0);
        }
        return dialog;
    }

    /* access modifiers changed from: package-private */
    public void mostrar_filtros() {
        boolean z;
        int i;
        int i2;
        if (this.fsexo || this.fdist || this.fedad1 || this.fedad2 || this.fnick) {
            findViewById(R.id.ll_filtros).setOnClickListener(this);
            findViewById(R.id.ll_filtros).setVisibility(0);
            boolean z2 = true;
            if (!this.fsexo || (i2 = this.fsexo_v) == 0) {
                this.tv_fsexo.setVisibility(8);
                z = false;
            } else {
                if (i2 == 1) {
                    this.tv_fsexo.setText(getResources().getString(R.string.hombres));
                } else {
                    this.tv_fsexo.setText(getResources().getString(R.string.mujeres));
                }
                this.tv_fsexo.setVisibility(0);
                z = true;
            }
            if (!this.fnick || this.fnick_v.equals("")) {
                this.tv_fnick.setVisibility(8);
            } else {
                this.tv_fnick.setText(this.fnick_v);
                this.tv_fnick.setVisibility(0);
                z = true;
            }
            if (!this.fdist || (i = this.fdist_v) == 0) {
                this.tv_fdist.setVisibility(8);
            } else {
                long j = (long) i;
                String str = (this.pais.equals("US") || this.pais.equals("GB") || this.pais.equals("MM")) ? "mi." : "km.";
                TextView textView = this.tv_fdist;
                textView.setText(j + " " + str);
                this.tv_fdist.setVisibility(0);
                z = true;
            }
            if (!this.fedad1 || this.fedad1_v == 0) {
                this.tv_fedad1.setVisibility(8);
            } else {
                TextView textView2 = this.tv_fedad1;
                textView2.setText(">" + this.fedad1_v + getResources().getString(R.string.anyos_abrev));
                this.tv_fedad1.setVisibility(0);
                z = true;
            }
            if (!this.fedad2 || this.fedad2_v == 0) {
                this.tv_fedad2.setVisibility(8);
                z2 = z;
            } else {
                TextView textView3 = this.tv_fedad2;
                textView3.setText("<" + this.fedad2_v + getResources().getString(R.string.anyos_abrev));
                this.tv_fedad2.setVisibility(0);
            }
            if (z2) {
                findViewById(R.id.tv_filtrar).setVisibility(8);
            } else {
                findViewById(R.id.tv_filtrar).setVisibility(0);
            }
        } else {
            findViewById(R.id.ll_filtros).setVisibility(8);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.gridView.setNumColumns(configuration.orientation == 2 ? 6 : 3);
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
        this.dialog_filtros.dismiss();
        this.dialog_filtros = crear_dialog_filtros();
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
        super.onPause();
        config.onPause_global(this);
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        GridViewAdapter gridViewAdapter = this.gridAdapter;
        if (gridViewAdapter != null) {
            gridViewAdapter.notifyDataSetChanged();
        }
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
                if (!t_buscusus.this.globales.admob_rew_failed(context, t_buscusus.this.mAd_appnext)) {
                    t_buscusus.this.dialog_cargando.cancel();
                    t_buscusus t_buscusus = t_buscusus.this;
                    t_buscusus.abrir_secc(t_buscusus.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_buscusus.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_buscusus.this.abrir_secc(t_buscusus.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_buscusus.this.mAd_visto) {
                            t_buscusus.this.abrir_secc(t_buscusus.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_buscusus.this.mAd_visto = true;
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
                if (t_buscusus.this.mAd_visto) {
                    t_buscusus t_buscusus = t_buscusus.this;
                    t_buscusus.abrir_secc(t_buscusus.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
