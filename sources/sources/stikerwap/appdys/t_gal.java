package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
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
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class t_gal extends Activity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, AdapterView.OnItemClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean atras_pulsado = false;
    boolean c1_esclaro;
    cargar_fotos c_f;
    cargar_stickers c_s;
    cargar_usus c_u;
    boolean cargado_primeravez = false;
    boolean es_primeracarga = true;
    Bundle extras;
    config globales;
    GridViewAdapter gridAdapter;
    GridView gridView;
    long idusu;
    int ind_abrir_secc = -1;
    int ind_secc;
    boolean mAd_visto = false;
    ListView mDrawerList;
    int n_stickers;
    obtener_img_g o_i_g;
    ProgressDialog pd_stickers;
    SharedPreferences settings;
    ArrayList<Usu> usus_a;
    boolean usus_a_completo;
    boolean wa;
    boolean wa_b;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2 = bundle;
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
        if (bundle2 == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle2.containsKey("es_root") && bundle2.getBoolean("es_root", false);
        }
        this.ind_secc = this.globales.ind_secc_sel_2;
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        setContentView(R.layout.t_gal);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_gal.this.finalizar = false;
                t_gal.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_gal.this.buscador_on = false;
            }
        });
        config config2 = this.globales;
        Bundle bundle3 = this.extras;
        boolean z = bundle3 != null && bundle3.containsKey("ad_entrar");
        Bundle bundle4 = this.extras;
        config2.toca_int(this, z, bundle4 != null && bundle4.containsKey("fb_entrar"));
        this.anun = this.globales.mostrar_banner(this, false);
        config config3 = this.globales;
        config3.oncreate_popup(this, config3.ind_secc_sel_2, this.cbtn, bundle2);
        if (!str.equals("")) {
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#" + str), Color.parseColor("#" + str2)}));
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
        if (this.globales.secciones_a[this.ind_secc].stickers) {
            this.wa = false;
            this.wa_b = false;
            PackageManager packageManager = getPackageManager();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.whatsapp", 0);
                if (applicationInfo != null || applicationInfo.enabled) {
                    this.wa = true;
                }
            } catch (Exception unused2) {
            }
            if (!this.wa) {
                try {
                    ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo("com.whatsapp.w4b", 0);
                    if (applicationInfo2 != null || applicationInfo2.enabled) {
                        this.wa_b = true;
                    }
                } catch (Exception unused3) {
                }
            }
            if (this.wa || this.wa_b) {
                ComponentName componentName = new ComponentName(this, "stikerwap.appdys.StickerContentProvider");
                if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                    packageManager.setComponentEnabledSetting(componentName, 1, 1);
                }
                findViewById(R.id.env_stickers).setOnClickListener(new View.OnClickListener() {
                    /* JADX WARNING: Can't wrap try/catch for region: R(6:26|(1:28)|29|30|31|32) */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x015d */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onClick(android.view.View r7) {
                        /*
                            r6 = this;
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            stikerwap.appdys.t_gal$cargar_stickers r7 = r7.c_s
                            if (r7 == 0) goto L_0x0012
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            stikerwap.appdys.t_gal$cargar_stickers r7 = r7.c_s
                            android.os.AsyncTask$Status r7 = r7.getStatus()
                            android.os.AsyncTask$Status r0 = android.os.AsyncTask.Status.RUNNING
                            if (r7 == r0) goto L_0x0184
                        L_0x0012:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            r0 = 0
                            r7.n_stickers = r0
                            java.io.File r7 = new java.io.File
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            java.io.File r1 = r1.getFilesDir()
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            java.lang.String r3 = "img_s"
                            r2.<init>(r3)
                            stikerwap.appdys.t_gal r3 = stikerwap.appdys.t_gal.this
                            stikerwap.appdys.config r3 = r3.globales
                            stikerwap.appdys.Seccion[] r3 = r3.secciones_a
                            stikerwap.appdys.t_gal r4 = stikerwap.appdys.t_gal.this
                            int r4 = r4.ind_secc
                            r3 = r3[r4]
                            int r3 = r3.id
                            r2.append(r3)
                            java.lang.String r3 = "_ico"
                            r2.append(r3)
                            java.lang.String r2 = r2.toString()
                            r7.<init>(r1, r2)
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            stikerwap.appdys.config r1 = r1.globales
                            stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                            stikerwap.appdys.t_gal r2 = stikerwap.appdys.t_gal.this
                            int r2 = r2.ind_secc
                            r1 = r1[r2]
                            boolean r1 = r1.ico_cargando
                            r2 = 1
                            if (r1 != 0) goto L_0x005a
                            boolean r7 = r7.exists()
                            if (r7 != 0) goto L_0x0061
                        L_0x005a:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            int r1 = r7.n_stickers
                            int r1 = r1 + r2
                            r7.n_stickers = r1
                        L_0x0061:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            java.util.ArrayList<stikerwap.appdys.t_gal$Usu> r7 = r7.usus_a
                            if (r7 == 0) goto L_0x00b1
                            r7 = 0
                        L_0x0068:
                            r1 = 30
                            if (r7 >= r1) goto L_0x00b1
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            java.util.ArrayList<stikerwap.appdys.t_gal$Usu> r1 = r1.usus_a
                            int r1 = r1.size()
                            if (r7 != r1) goto L_0x0077
                            goto L_0x00b1
                        L_0x0077:
                            java.io.File r1 = new java.io.File
                            stikerwap.appdys.t_gal r3 = stikerwap.appdys.t_gal.this
                            java.io.File r3 = r3.getFilesDir()
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            java.lang.String r5 = "gal_"
                            r4.<init>(r5)
                            stikerwap.appdys.t_gal r5 = stikerwap.appdys.t_gal.this
                            java.util.ArrayList<stikerwap.appdys.t_gal$Usu> r5 = r5.usus_a
                            java.lang.Object r5 = r5.get(r7)
                            stikerwap.appdys.t_gal$Usu r5 = (stikerwap.appdys.t_gal.Usu) r5
                            java.lang.String r5 = r5.id
                            r4.append(r5)
                            java.lang.String r5 = "_g.webp"
                            r4.append(r5)
                            java.lang.String r4 = r4.toString()
                            r1.<init>(r3, r4)
                            boolean r1 = r1.exists()
                            if (r1 != 0) goto L_0x00ae
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            int r3 = r1.n_stickers
                            int r3 = r3 + r2
                            r1.n_stickers = r3
                        L_0x00ae:
                            int r7 = r7 + 1
                            goto L_0x0068
                        L_0x00b1:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            int r7 = r7.n_stickers
                            if (r7 <= 0) goto L_0x016f
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.content.Context r7 = r7.getApplicationContext()
                            boolean r7 = stikerwap.appdys.config.isNetworkAvailable(r7)
                            if (r7 != 0) goto L_0x00e5
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.content.res.Resources r0 = r7.getResources()
                            r1 = 2131886359(0x7f120117, float:1.9407295E38)
                            java.lang.String r0 = r0.getString(r1)
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            android.content.res.Resources r1 = r1.getResources()
                            r2 = 2131886358(0x7f120116, float:1.9407293E38)
                            java.lang.String r1 = r1.getString(r2)
                            stikerwap.appdys.t_gal r2 = stikerwap.appdys.t_gal.this
                            java.lang.String r2 = r2.cbtn
                            stikerwap.appdys.config.mostrar_error(r7, r0, r1, r2)
                            return
                        L_0x00e5:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r1 = new android.app.ProgressDialog
                            stikerwap.appdys.t_gal r3 = stikerwap.appdys.t_gal.this
                            r1.<init>(r3)
                            r7.pd_stickers = r1
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r7 = r7.pd_stickers
                            r7.setCancelable(r0)
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r7 = r7.pd_stickers
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            android.content.res.Resources r1 = r1.getResources()
                            r3 = 2131886164(0x7f120054, float:1.94069E38)
                            java.lang.String r1 = r1.getString(r3)
                            r7.setMessage(r1)
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r7 = r7.pd_stickers
                            r7.setProgressStyle(r2)
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r7 = r7.pd_stickers
                            r7.setProgress(r0)
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r7 = r7.pd_stickers
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            int r1 = r1.n_stickers
                            r7.setMax(r1)
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r7 = r7.pd_stickers
                            stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this
                            android.content.res.Resources r1 = r1.getResources()
                            r2 = 2131886163(0x7f120053, float:1.9406897E38)
                            java.lang.String r1 = r1.getString(r2)
                            stikerwap.appdys.t_gal$3$1 r2 = new stikerwap.appdys.t_gal$3$1
                            r2.<init>()
                            r3 = -2
                            r7.setButton(r3, r1, r2)
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            java.lang.String r7 = r7.cbtn
                            java.lang.String r1 = ""
                            boolean r7 = r7.equals(r1)
                            if (r7 != 0) goto L_0x0156
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            android.app.ProgressDialog r7 = r7.pd_stickers
                            stikerwap.appdys.t_gal$3$2 r1 = new stikerwap.appdys.t_gal$3$2
                            r1.<init>()
                            r7.setOnShowListener(r1)
                        L_0x0156:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this     // Catch:{ Exception -> 0x015d }
                            android.app.ProgressDialog r7 = r7.pd_stickers     // Catch:{ Exception -> 0x015d }
                            r7.show()     // Catch:{ Exception -> 0x015d }
                        L_0x015d:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this     // Catch:{ Exception -> 0x016f }
                            android.app.ProgressDialog r7 = r7.pd_stickers     // Catch:{ Exception -> 0x016f }
                            r1 = 16908299(0x102000b, float:2.387726E-38)
                            android.view.View r7 = r7.findViewById(r1)     // Catch:{ Exception -> 0x016f }
                            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x016f }
                            android.graphics.Typeface r1 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x016f }
                            r7.setTypeface(r1)     // Catch:{ Exception -> 0x016f }
                        L_0x016f:
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            stikerwap.appdys.t_gal$cargar_stickers r1 = new stikerwap.appdys.t_gal$cargar_stickers
                            stikerwap.appdys.t_gal r2 = stikerwap.appdys.t_gal.this
                            r3 = 0
                            r1.<init>()
                            r7.c_s = r1
                            stikerwap.appdys.t_gal r7 = stikerwap.appdys.t_gal.this
                            stikerwap.appdys.t_gal$cargar_stickers r7 = r7.c_s
                            java.lang.String[] r0 = new java.lang.String[r0]
                            r7.execute(r0)
                        L_0x0184:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_gal.AnonymousClass3.onClick(android.view.View):void");
                    }
                });
                findViewById(R.id.env_stickers).setVisibility(0);
            }
        }
        this.usus_a = new ArrayList<>();
        this.usus_a_completo = false;
        this.gridView = (GridView) findViewById(R.id.grid);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, R.layout.t_gal_row, this.usus_a);
        this.gridAdapter = gridViewAdapter;
        this.gridView.setAdapter(gridViewAdapter);
        this.gridView.setOnItemClickListener(this);
        this.cargado_primeravez = false;
        if (config.isNetworkAvailable(this)) {
            cargar_usus cargar_usus2 = new cargar_usus(0);
            this.c_u = cargar_usus2;
            cargar_usus2.execute(new String[0]);
            return;
        }
        this.usus_a_completo = true;
        if (this.settings.contains("gal_a_" + this.globales.secciones_a[this.ind_secc].id)) {
            for (String str3 : this.settings.getString("gal_a_" + this.globales.secciones_a[this.ind_secc].id, "").split("/")) {
                if (!str3.equals("")) {
                    String[] split = str3.split("@");
                    if (split.length == 4 || split.length == 5 || split.length == 6) {
                        Usu usu = new Usu();
                        usu.id = split[0];
                        if (new File(getApplicationContext().getFilesDir(), "gal_" + usu.id + ".webp").exists()) {
                            usu.foto_pendiente = false;
                        } else {
                            usu.foto_pendiente = true;
                        }
                        usu.descr = split[2].replace("BARRA98", "/").replace("ARROBA98", "@");
                        usu.abrir_idsec = split[3];
                        if (split.length == 5) {
                            usu.abrir_url = split[4].replace("BARRA98", "/").replace("ARROBA98", "@");
                        } else {
                            usu.abrir_url = "";
                        }
                        if (split.length == 6) {
                            usu.tipo = split[5];
                        } else {
                            usu.tipo = "0";
                        }
                        this.usus_a.add(usu);
                    }
                }
            }
            this.gridAdapter.notifyDataSetChanged();
            this.gridView.requestFocus();
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if (config != null && config.onActivityResult_glob(i, i2, intent, this)) {
            return;
        }
        if (i == 110) {
            if (i2 == 0 && intent != null) {
                intent.getStringExtra("validation_error");
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

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Usu usu = this.usus_a.get(i);
        if (!usu.id.equals("-1")) {
            obtener_img_g obtener_img_g2 = this.o_i_g;
            if (obtener_img_g2 != null && obtener_img_g2.getStatus() == AsyncTask.Status.RUNNING) {
                return;
            }
            if (!usu.abrir_idsec.equals("0")) {
                View view2 = new View(this);
                int indexOf = config.secciones_alist.indexOf(Integer.valueOf(Integer.parseInt(usu.abrir_idsec)));
                view2.setId(indexOf);
                view2.setTag(R.id.TAG_IDSECC, Integer.valueOf(indexOf));
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
                this.v_abrir_secc = null;
                this.ind_abrir_secc = indexOf;
                if (!this.globales.rewarded(this, view2, this.cbtn, this.dialog_cargando, this.ralc, this.mAd_appnext, this.mAd_fb, this.mAd_st, this.v_abrir_secc)) {
                    this.globales.abrir_go(this, indexOf);
                }
            } else if (!usu.abrir_url.equals("")) {
                ResultGetIntent intent_porURL = this.globales.getIntent_porURL(usu.abrir_url, this);
                if (intent_porURL.finalizar) {
                    this.finalizar = true;
                    Intent intent = new Intent();
                    intent.putExtra("finalizar", true);
                    intent.putExtra("finalizar_app", intent_porURL.finalizar_app);
                    setResult(-1, intent);
                }
                if (intent_porURL.esmas) {
                    startActivityForResult(intent_porURL.i, 0);
                } else if (intent_porURL.i != null) {
                    if (intent_porURL.finalizar) {
                        this.es_root = false;
                        if (this.globales.tipomenu != 2) {
                            intent_porURL.i.putExtra("es_root", true);
                        }
                        try {
                            startActivity(intent_porURL.i);
                        } catch (Exception unused) {
                        }
                    } else {
                        startActivityForResult(intent_porURL.i, 0);
                    }
                }
                if (this.finalizar && !this.buscador_on) {
                    finish();
                }
            } else {
                File filesDir = getFilesDir();
                File file = new File(filesDir, "gal_" + usu.id + "_g.webp");
                if (file.exists()) {
                    Intent intent2 = new Intent(this, t_gal_foto.class);
                    intent2.putExtra("url", AdPayload.FILE_SCHEME + file.getAbsolutePath());
                    intent2.putExtra("idf", usu.id);
                    intent2.putExtra("descr", usu.descr);
                    startActivityForResult(intent2, 0);
                } else if (config.isNetworkAvailable(this)) {
                    obtener_img_g obtener_img_g3 = new obtener_img_g(usu.id, i, usu.descr);
                    this.o_i_g = obtener_img_g3;
                    obtener_img_g3.execute(new String[0]);
                }
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

    private class cargar_usus extends AsyncTask<String, Void, String> {
        int ind_ini;

        cargar_usus(int i) {
            this.ind_ini = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_gal.this.usus_a.isEmpty() || !t_gal.this.usus_a.get(t_gal.this.usus_a.size() - 1).id.equals("-1")) {
                Usu usu = new Usu();
                usu.id = "-1";
                usu.descr = "";
                t_gal.this.usus_a.add(usu);
                t_gal.this.gridAdapter.notifyDataSetChanged();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
                r0.<init>()     // Catch:{ Exception -> 0x009a }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x009a }
                r0.append(r1)     // Catch:{ Exception -> 0x009a }
                java.lang.String r1 = "/srv/obtener_gal.php?idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x009a }
                stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this     // Catch:{ Exception -> 0x009a }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x009a }
                r0.append(r1)     // Catch:{ Exception -> 0x009a }
                java.lang.String r1 = "&ind_ini="
                r0.append(r1)     // Catch:{ Exception -> 0x009a }
                int r1 = r5.ind_ini     // Catch:{ Exception -> 0x009a }
                r0.append(r1)     // Catch:{ Exception -> 0x009a }
                java.lang.String r1 = "&idsec="
                r0.append(r1)     // Catch:{ Exception -> 0x009a }
                stikerwap.appdys.t_gal r1 = stikerwap.appdys.t_gal.this     // Catch:{ Exception -> 0x009a }
                stikerwap.appdys.config r1 = r1.globales     // Catch:{ Exception -> 0x009a }
                stikerwap.appdys.Seccion[] r1 = r1.secciones_a     // Catch:{ Exception -> 0x009a }
                stikerwap.appdys.t_gal r2 = stikerwap.appdys.t_gal.this     // Catch:{ Exception -> 0x009a }
                int r2 = r2.ind_secc     // Catch:{ Exception -> 0x009a }
                r1 = r1[r2]     // Catch:{ Exception -> 0x009a }
                int r1 = r1.id     // Catch:{ Exception -> 0x009a }
                r0.append(r1)     // Catch:{ Exception -> 0x009a }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009a }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x009a }
                r1.<init>(r0)     // Catch:{ Exception -> 0x009a }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x009a }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x009a }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r6.<init>()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            L_0x006c:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                if (r2 == 0) goto L_0x0087
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r3.<init>()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r3.append(r2)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                r6.append(r2)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                goto L_0x006c
            L_0x0087:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
                if (r0 == 0) goto L_0x0090
                r0.disconnect()
            L_0x0090:
                return r6
            L_0x0091:
                r6 = move-exception
                goto L_0x00a2
            L_0x0093:
                r6 = r0
                goto L_0x009a
            L_0x0095:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x00a2
            L_0x009a:
                java.lang.String r0 = ""
                if (r6 == 0) goto L_0x00a1
                r6.disconnect()
            L_0x00a1:
                return r0
            L_0x00a2:
                if (r0 == 0) goto L_0x00a7
                r0.disconnect()
            L_0x00a7:
                goto L_0x00a9
            L_0x00a8:
                throw r6
            L_0x00a9:
                goto L_0x00a8
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_gal.cargar_usus.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String str2;
            String str3;
            if (t_gal.this.usus_a != null && t_gal.this.usus_a.get(t_gal.this.usus_a.size() - 1).id.equals("-1")) {
                t_gal.this.usus_a.remove(t_gal.this.usus_a.size() - 1);
                t_gal.this.gridAdapter.notifyDataSetChanged();
            }
            if (str.contains("ANDROID:OK DATOS:")) {
                String[] split = str.substring(str.indexOf("DATOS:") + 6).split(";");
                int i = 0;
                while (true) {
                    str2 = "";
                    if (!split[i].equals(ExifInterface.LATITUDE_SOUTH) && !split[i].equals("N")) {
                        String[] split2 = split[i].split(",");
                        Usu usu = new Usu();
                        usu.id = split2[0];
                        usu.descr = split2[1].replace("@X@", ",").replace("@Y@", ";");
                        usu.abrir_idsec = split2[2];
                        if (split2.length > 3) {
                            usu.abrir_url = split2[3].replace("@X@", ",").replace("@Y@", ";");
                        } else {
                            usu.abrir_url = str2;
                        }
                        if (split2.length > 4) {
                            usu.tipo = split2[4];
                        } else {
                            usu.tipo = "0";
                        }
                        File filesDir = t_gal.this.getApplicationContext().getFilesDir();
                        if (new File(filesDir, "gal_" + split2[0] + ".webp").exists()) {
                            usu.cargando = false;
                            usu.foto_pendiente = false;
                        }
                        t_gal.this.usus_a.add(usu);
                        i++;
                    }
                }
                if (split[i].equals("N")) {
                    t_gal.this.usus_a_completo = true;
                }
                t_gal.this.gridAdapter.notifyDataSetChanged();
                if (t_gal.this.es_primeracarga) {
                    t_gal.this.es_primeracarga = false;
                    t_gal.this.gridView.requestFocus();
                }
                Iterator<Usu> it = t_gal.this.usus_a.iterator();
                while (it.hasNext()) {
                    Usu next = it.next();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(next.id);
                    sb.append("@");
                    if (next.foto_pendiente) {
                        str3 = "1";
                    } else {
                        str3 = "0";
                    }
                    sb.append(str3);
                    sb.append("@");
                    sb.append(next.descr.replace("/", "BARRA98").replace("@", "ARROBA98"));
                    sb.append("@");
                    sb.append(next.abrir_idsec);
                    sb.append("@");
                    sb.append(next.abrir_url.replace("/", "BARRA98").replace("@", "ARROBA98"));
                    sb.append("@");
                    sb.append(next.tipo);
                    sb.append("/");
                    str2 = sb.toString();
                }
                SharedPreferences.Editor edit = t_gal.this.settings.edit();
                edit.putString("gal_a_" + t_gal.this.globales.secciones_a[t_gal.this.ind_secc].id, str2);
                edit.commit();
                if (i <= 0) {
                    return;
                }
                if (t_gal.this.c_f == null || t_gal.this.c_f.getStatus() != AsyncTask.Status.RUNNING) {
                    t_gal.this.c_f = new cargar_fotos();
                    t_gal.this.c_f.execute(new String[0]);
                    t_gal.this.cargado_primeravez = true;
                }
            }
        }
    }

    private class cargar_stickers extends AsyncTask<String, Void, String> {
        Bitmap bm;
        int ind;

        private cargar_stickers() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.ind = -2;
            File filesDir = t_gal.this.getFilesDir();
            File file = new File(filesDir, "img_s" + t_gal.this.globales.secciones_a[t_gal.this.ind_secc].id + "_ico");
            if (t_gal.this.globales.secciones_a[t_gal.this.ind_secc].ico_cargando || !file.exists()) {
                this.ind = -1;
            } else if (t_gal.this.usus_a != null) {
                int i = 0;
                while (true) {
                    if (i >= 30 || i == t_gal.this.usus_a.size()) {
                        break;
                    }
                    File filesDir2 = t_gal.this.getFilesDir();
                    if (!new File(filesDir2, "gal_" + t_gal.this.usus_a.get(i).id + "_g.webp").exists()) {
                        this.ind = i;
                        break;
                    }
                    i++;
                }
            }
            if (this.ind == -2) {
                cancel(false);
                try {
                    t_gal.this.pd_stickers.dismiss();
                } catch (Exception unused) {
                }
                t_gal.this.globales.secciones_a[t_gal.this.ind_secc].v_stickers = System.currentTimeMillis();
                Intent intent = new Intent();
                if (t_gal.this.wa) {
                    intent.setPackage("com.whatsapp");
                } else if (t_gal.this.wa_b) {
                    intent.setPackage("com.whatsapp.w4b");
                }
                intent.setAction("com.whatsapp.intent.action.ENABLE_STICKER_PACK");
                intent.putExtra("sticker_pack_id", t_gal.this.globales.secciones_a[t_gal.this.ind_secc].id + "");
                intent.putExtra("sticker_pack_authority", BuildConfig.CONTENT_PROVIDER_AUTHORITY);
                intent.putExtra(StickerContentProvider.STICKER_PACK_NAME_IN_QUERY, t_gal.this.globales.secciones_a[t_gal.this.ind_secc].titulo);
                t_gal.this.startActivityForResult(intent, 110);
            }
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            String str;
            if (this.ind != -1) {
                str = config.DOM_CDN + "/srv/imgs/gal/" + t_gal.this.usus_a.get(this.ind).id + ".png";
            } else if (t_gal.this.globales.secciones_a[t_gal.this.ind_secc].ico_id == 0) {
                str = config.DOM_CDN + "/srv/imgs/seccs/" + t_gal.this.globales.secciones_a[t_gal.this.ind_secc].id + "_ico.png?v=" + t_gal.this.globales.secciones_a[t_gal.this.ind_secc].v_ico;
            } else {
                str = config.DOM_CDN + "/android-app-creator/icos_secc/" + t_gal.this.globales.secciones_a[t_gal.this.ind_secc].ico_id + ".png";
            }
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.connect();
                    if (this.ind == -1) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        this.bm = BitmapFactory.decodeStream(inputStream);
                        inputStream.close();
                        httpURLConnection.disconnect();
                        try {
                            FileOutputStream openFileOutput = t_gal.this.openFileOutput("img_s" + t_gal.this.globales.secciones_a[t_gal.this.ind_secc].id + "_ico", 0);
                            this.bm.compress(Bitmap.CompressFormat.PNG, 100, openFileOutput);
                            openFileOutput.close();
                            if (!(t_gal.this.globales == null || t_gal.this.settings == null)) {
                                int i = t_gal.this.ind_secc;
                                SharedPreferences.Editor edit = t_gal.this.settings.edit();
                                t_gal.this.globales.secciones_a[i].ico = this.bm;
                                t_gal.this.globales.secciones_a[i].ico_cargando = false;
                                edit.putInt(CmcdHeadersFactory.STREAMING_FORMAT_SS + t_gal.this.globales.secciones_a[i].id + "_ico", 0);
                                edit.putLong("ico_cargado", System.currentTimeMillis());
                                if (t_gal.this.globales.tipomenu == 1 && !t_gal.this.globales.secciones_a[i].oculta) {
                                    t_gal.this.globales.opcions.get(t_gal.this.globales.secciones_a[i].ind_menu).img = this.bm;
                                    t_gal.this.globales.opcions.get(t_gal.this.globales.secciones_a[i].ind_menu).img_cargando = false;
                                }
                                edit.commit();
                            }
                            return "1";
                        } catch (Exception | OutOfMemoryError unused) {
                            return "0";
                        }
                    } else if (t_gal.this.usus_a.get(this.ind).tipo.equals("1")) {
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(t_gal.this.getApplicationContext().getFilesDir(), "gal_" + t_gal.this.usus_a.get(this.ind).id + "_g.webp"));
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    fileOutputStream.flush();
                                    inputStream2.close();
                                    httpURLConnection.disconnect();
                                    return "1";
                                }
                            }
                        } catch (Exception unused2) {
                            return "0";
                        } catch (OutOfMemoryError e) {
                            e.printStackTrace();
                            return "0";
                        }
                    } else {
                        InputStream inputStream3 = httpURLConnection.getInputStream();
                        this.bm = BitmapFactory.decodeStream(inputStream3);
                        inputStream3.close();
                        httpURLConnection.disconnect();
                        try {
                            this.bm.compress(Bitmap.CompressFormat.WEBP, 100, new FileOutputStream(new File(t_gal.this.getApplicationContext().getFilesDir(), "gal_" + t_gal.this.usus_a.get(this.ind).id + "_g.webp")));
                            return "1";
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return "0";
                        } catch (OutOfMemoryError e3) {
                            e3.printStackTrace();
                            return "0";
                        }
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return "0";
                }
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
                return "0";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (str.equals("1")) {
                try {
                    t_gal.this.pd_stickers.incrementProgressBy(1);
                } catch (Exception unused) {
                }
                t_gal t_gal = t_gal.this;
                t_gal.c_s = new cargar_stickers();
                t_gal.this.c_s.execute(new String[0]);
            } else if (str.equals("0")) {
                try {
                    t_gal.this.pd_stickers.dismiss();
                    if (t_gal.this.cbtn != null) {
                        t_gal t_gal2 = t_gal.this;
                        config.mostrar_error(t_gal2, t_gal2.getResources().getString(R.string.error_http_tit), t_gal.this.getResources().getString(R.string.error_http), t_gal.this.cbtn);
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    private class cargar_fotos extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        int i_cargando;
        String idusu_acargar;

        private cargar_fotos() {
            this.i_cargando = -1;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            int firstVisiblePosition = t_gal.this.gridView.getFirstVisiblePosition();
            while (firstVisiblePosition <= Math.max(t_gal.this.gridView.getLastVisiblePosition(), 30) && t_gal.this.usus_a != null && firstVisiblePosition < t_gal.this.usus_a.size()) {
                if (!t_gal.this.usus_a.get(firstVisiblePosition).foto_pendiente || t_gal.this.usus_a.get(firstVisiblePosition).id.equals("-1")) {
                    firstVisiblePosition++;
                } else {
                    this.idusu_acargar = t_gal.this.usus_a.get(firstVisiblePosition).id;
                    t_gal.this.usus_a.get(firstVisiblePosition).cargando = true;
                    t_gal.this.usus_a.get(firstVisiblePosition).foto_pendiente = false;
                    this.i_cargando = firstVisiblePosition;
                    return;
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
                java.lang.String r0 = "gal_"
                java.lang.String r1 = r4.idusu_acargar
                if (r1 != 0) goto L_0x000b
                java.lang.String r5 = "-1"
                return r5
            L_0x000b:
                java.net.URL r1 = new java.net.URL     // Catch:{  }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
                r2.<init>()     // Catch:{  }
                java.lang.String r3 = stikerwap.appdys.config.DOM_CDN     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "/srv/imgs/gal/"
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = r4.idusu_acargar     // Catch:{  }
                r2.append(r3)     // Catch:{  }
                java.lang.String r3 = "_p.png"
                r2.append(r3)     // Catch:{  }
                java.lang.String r2 = r2.toString()     // Catch:{  }
                r1.<init>(r2)     // Catch:{  }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{  }
                r2 = 1
                r1.setDoInput(r2)     // Catch:{  }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{  }
                r2 = 20000(0x4e20, float:2.8026E-41)
                r1.setReadTimeout(r2)     // Catch:{  }
                r1.connect()     // Catch:{  }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{  }
                android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{  }
                r4.bmImg = r3     // Catch:{  }
                r2.close()     // Catch:{  }
                r1.disconnect()     // Catch:{  }
                java.io.File r1 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_gal r2 = stikerwap.appdys.t_gal.this     // Catch:{  }
                android.content.Context r2 = r2.getApplicationContext()     // Catch:{  }
                java.io.File r2 = r2.getFilesDir()     // Catch:{  }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{  }
                r3.<init>(r0)     // Catch:{  }
                java.lang.String r0 = r4.idusu_acargar     // Catch:{  }
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = ".webp"
                r3.append(r0)     // Catch:{  }
                java.lang.String r0 = r3.toString()     // Catch:{  }
                r1.<init>(r2, r0)     // Catch:{  }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x0086 }
                r0.<init>(r1)     // Catch:{ MalformedURLException -> 0x0086 }
                android.graphics.Bitmap r1 = r4.bmImg     // Catch:{ MalformedURLException -> 0x0086 }
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ MalformedURLException -> 0x0086 }
                r3 = 100
                r1.compress(r2, r3, r0)     // Catch:{ MalformedURLException -> 0x0086 }
                java.lang.String r5 = "1"
            L_0x0086:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_gal.cargar_fotos.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            if (!(this.i_cargando == -1 || t_gal.this.usus_a == null)) {
                try {
                    t_gal.this.usus_a.get(this.i_cargando).cargando = false;
                } catch (Exception unused) {
                    return;
                }
            }
            if (this.idusu_acargar != null) {
                t_gal.this.gridAdapter.notifyDataSetChanged();
                new cargar_fotos().execute(new String[0]);
            }
        }
    }

    private class obtener_img_g extends AsyncTask<String, Void, String> {
        Bitmap bmImg;
        String descr;
        String idimg_acargar;
        int ind;

        public obtener_img_g(String str, int i, String str2) {
            this.idimg_acargar = str;
            this.descr = str2;
            this.ind = i;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            t_gal.this.usus_a.get(this.ind).cargando_grande = true;
            t_gal.this.gridAdapter.notifyDataSetChanged();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r8) {
            /*
                r7 = this;
                java.lang.String r8 = "1"
                java.lang.String r0 = "0"
                java.lang.String r1 = "gal_"
                java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x00b3 }
                r3.<init>()     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r4 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x00b3 }
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r4 = "/srv/imgs/gal/"
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r4 = r7.idimg_acargar     // Catch:{ MalformedURLException -> 0x00b3 }
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r4 = ".png"
                r3.append(r4)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x00b3 }
                r2.<init>(r3)     // Catch:{ MalformedURLException -> 0x00b3 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{  }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{  }
                r3 = 1
                r2.setDoInput(r3)     // Catch:{  }
                r3 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r3)     // Catch:{  }
                r3 = 60000(0xea60, float:8.4078E-41)
                r2.setReadTimeout(r3)     // Catch:{  }
                r2.connect()     // Catch:{  }
                java.io.File r3 = new java.io.File     // Catch:{  }
                stikerwap.appdys.t_gal r4 = stikerwap.appdys.t_gal.this     // Catch:{  }
                android.content.Context r4 = r4.getApplicationContext()     // Catch:{  }
                java.io.File r4 = r4.getFilesDir()     // Catch:{  }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{  }
                r5.<init>(r1)     // Catch:{  }
                java.lang.String r1 = r7.idimg_acargar     // Catch:{  }
                r5.append(r1)     // Catch:{  }
                java.lang.String r1 = "_g.webp"
                r5.append(r1)     // Catch:{  }
                java.lang.String r1 = r5.toString()     // Catch:{  }
                r3.<init>(r4, r1)     // Catch:{  }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00af }
                r1.<init>(r3)     // Catch:{ Exception -> 0x00af }
                java.io.InputStream r3 = r2.getInputStream()     // Catch:{ Exception -> 0x00af }
                stikerwap.appdys.t_gal r4 = stikerwap.appdys.t_gal.this     // Catch:{ Exception -> 0x00af }
                java.util.ArrayList<stikerwap.appdys.t_gal$Usu> r4 = r4.usus_a     // Catch:{ Exception -> 0x00af }
                int r5 = r7.ind     // Catch:{ Exception -> 0x00af }
                java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x00af }
                stikerwap.appdys.t_gal$Usu r4 = (stikerwap.appdys.t_gal.Usu) r4     // Catch:{ Exception -> 0x00af }
                java.lang.String r4 = r4.tipo     // Catch:{ Exception -> 0x00af }
                boolean r4 = r4.equals(r8)     // Catch:{ Exception -> 0x00af }
                if (r4 == 0) goto L_0x0099
                r4 = 4096(0x1000, float:5.74E-42)
                byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x00af }
            L_0x0083:
                int r5 = r3.read(r4)     // Catch:{ Exception -> 0x00af }
                r6 = -1
                if (r5 == r6) goto L_0x008f
                r6 = 0
                r1.write(r4, r6, r5)     // Catch:{ Exception -> 0x00af }
                goto L_0x0083
            L_0x008f:
                r1.flush()     // Catch:{ Exception -> 0x00af }
                r3.close()     // Catch:{ Exception -> 0x00af }
                r2.disconnect()     // Catch:{ Exception -> 0x00af }
                goto L_0x00ae
            L_0x0099:
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ Exception -> 0x00af }
                r7.bmImg = r4     // Catch:{ Exception -> 0x00af }
                r3.close()     // Catch:{ Exception -> 0x00af }
                r2.disconnect()     // Catch:{ Exception -> 0x00af }
                android.graphics.Bitmap r2 = r7.bmImg     // Catch:{ Exception -> 0x00af }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ Exception -> 0x00af }
                r4 = 100
                r2.compress(r3, r4, r1)     // Catch:{ Exception -> 0x00af }
            L_0x00ae:
                return r8
            L_0x00af:
                r8 = move-exception
                r8.printStackTrace()     // Catch:{  }
            L_0x00b3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_gal.obtener_img_g.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            t_gal.this.usus_a.get(this.ind).cargando_grande = false;
            t_gal.this.gridAdapter.notifyDataSetChanged();
            Intent intent = new Intent(t_gal.this, t_gal_foto.class);
            File filesDir = t_gal.this.getApplicationContext().getFilesDir();
            File file = new File(filesDir, "gal_" + this.idimg_acargar + "_g.webp");
            StringBuilder sb = new StringBuilder(AdPayload.FILE_SCHEME);
            sb.append(file.getAbsolutePath());
            intent.putExtra("url", sb.toString());
            intent.putExtra("descr", this.descr);
            t_gal.this.startActivityForResult(intent, 0);
        }
    }

    private class Usu {
        String abrir_idsec;
        String abrir_url;
        boolean cargando;
        boolean cargando_grande;
        String descr;
        boolean foto_pendiente;
        String id;
        boolean mostrado;
        String tipo;

        private Usu() {
            this.foto_pendiente = true;
            this.cargando = false;
            this.cargando_grande = false;
            this.mostrado = false;
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

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (!t_gal.this.usus_a_completo && t_gal.this.usus_a.size() - i < 10 && (t_gal.this.c_u == null || t_gal.this.c_u.getStatus() != AsyncTask.Status.RUNNING)) {
                t_gal t_gal = t_gal.this;
                t_gal t_gal2 = t_gal.this;
                t_gal.c_u = new cargar_usus(t_gal2.usus_a.size());
                t_gal.this.c_u.execute(new String[0]);
            }
            Bitmap bitmap = null;
            if (t_gal.this.cargado_primeravez && (t_gal.this.c_f == null || t_gal.this.c_f.getStatus() != AsyncTask.Status.RUNNING)) {
                t_gal.this.c_f = new cargar_fotos();
                t_gal.this.c_f.execute(new String[0]);
            }
            if (view == null) {
                view = ((Activity) this.context).getLayoutInflater().inflate(this.layoutResourceId, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.image = (ImageView) view.findViewById(R.id.iv_usugrid);
                viewHolder.pb_foto = (ProgressBar) view.findViewById(R.id.pb_foto);
                viewHolder.pb_foto_inv = (ProgressBar) view.findViewById(R.id.pb_foto_inv);
                if (Build.VERSION.SDK_INT > 20) {
                    config.progress_color(viewHolder.pb_foto, t_gal.this.globales.c_icos);
                    config.progress_color(viewHolder.pb_foto_inv, t_gal.this.globales.c_icos);
                }
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Usu usu = this.data.get(i);
            if (usu.id.equals("-1")) {
                viewHolder.image.setImageBitmap((Bitmap) null);
                viewHolder.pb_foto.setVisibility(8);
                viewHolder.pb_foto_inv.setVisibility(8);
                if (t_gal.this.c1_esclaro) {
                    viewHolder.pb_foto_inv.setVisibility(0);
                } else {
                    viewHolder.pb_foto.setVisibility(0);
                }
                return view;
            }
            viewHolder.pb_foto.setVisibility(8);
            viewHolder.pb_foto_inv.setVisibility(8);
            if (usu.cargando || usu.foto_pendiente) {
                viewHolder.image.setImageBitmap((Bitmap) null);
                if (t_gal.this.c1_esclaro) {
                    viewHolder.pb_foto_inv.setVisibility(0);
                } else {
                    viewHolder.pb_foto.setVisibility(0);
                }
            } else {
                try {
                    File filesDir = t_gal.this.getApplicationContext().getFilesDir();
                    File file = new File(filesDir, "gal_" + usu.id + ".webp");
                    if (file.exists()) {
                        bitmap = MediaStore.Images.Media.getBitmap(t_gal.this.getContentResolver(), Uri.fromFile(file));
                    }
                } catch (Exception unused) {
                }
                viewHolder.image.setImageBitmap(bitmap);
                if (!usu.mostrado) {
                    usu.mostrado = true;
                    config.fade_in(viewHolder.image);
                }
            }
            if (usu.cargando_grande) {
                if (t_gal.this.c1_esclaro) {
                    viewHolder.pb_foto_inv.setVisibility(0);
                } else {
                    viewHolder.pb_foto.setVisibility(0);
                }
            }
            return view;
        }

        class ViewHolder {
            ImageView image;
            ProgressBar pb_foto;
            ProgressBar pb_foto_inv;

            ViewHolder() {
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
                if (!t_gal.this.globales.admob_rew_failed(context, t_gal.this.mAd_appnext)) {
                    t_gal.this.dialog_cargando.cancel();
                    t_gal t_gal = t_gal.this;
                    t_gal.abrir_secc(t_gal.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_gal.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_gal.this.abrir_secc(t_gal.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_gal.this.mAd_visto) {
                            t_gal.this.abrir_secc(t_gal.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_gal.this.mAd_visto = true;
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
                if (t_gal.this.mAd_visto) {
                    t_gal t_gal = t_gal.this;
                    t_gal.abrir_secc(t_gal.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
