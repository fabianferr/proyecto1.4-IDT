package stikerwap.appdys;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
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
import java.util.ArrayList;

public class t_vistafb extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean atras_pulsado = false;
    boolean c1_esclaro;
    boolean cargado_primeravez = false;
    String codigo;
    Bundle extras;
    config globales;
    long idusu;
    int ind_abrir_secc = -1;
    int ind_secc;
    /* access modifiers changed from: private */
    public vistafb_adapter itemAdapter;
    /* access modifiers changed from: private */
    public ArrayList<widget_vistafb_item> listData;
    boolean mAd_visto = false;
    ListView mDrawerList;
    SharedPreferences settings;
    boolean usus_a_completo;

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
        this.codigo = this.settings.getString("cod", "");
        int i = this.globales.secciones_a[this.globales.ind_secc_sel_2].p_fnac;
        int i2 = this.globales.secciones_a[this.globales.ind_secc_sel_2].p_sexo;
        int i3 = this.globales.secciones_a[this.globales.ind_secc_sel_2].p_descr;
        int i4 = this.globales.secciones_a[this.globales.ind_secc_sel_2].fotos_perfil;
        if (this.settings.getString("nick", "").equals("") || (this.globales.fb_modo == 3 && !this.settings.getBoolean("email_confirmado", false))) {
            Intent intent = new Intent(this, chat_perfil.class);
            intent.putExtra("idsecc", this.globales.secciones_a[this.ind_secc].id);
            intent.putExtra("desde_vistafb", true);
            if (this.es_root) {
                intent.putExtra("es_root", this.es_root);
            }
            this.es_root = false;
            this.finalizar = true;
            startActivityForResult(intent, 0);
        } else if ((i4 == 2 && !this.globales.getTempFile(this, 1).exists()) || ((i == 2 && (this.settings.getInt("fnac_d", 0) == 0 || this.settings.getInt("fnac_m", 0) == 0 || this.settings.getInt("fnac_a", 0) == 0)) || ((i2 == 2 && this.settings.getInt("sexo", 0) == 0) || (i3 == 2 && this.settings.getString("descr", "").equals(""))))) {
            Intent intent2 = new Intent(this, preperfil.class);
            intent2.putExtra("idsecc", this.globales.secciones_a[this.ind_secc].id);
            intent2.putExtra("desde_vistafb", true);
            if (this.es_root) {
                intent2.putExtra("es_root", this.es_root);
            }
            this.es_root = false;
            this.finalizar = true;
            startActivityForResult(intent2, 0);
        }
        if (!this.finalizar) {
            setContentView(R.layout.t_vistafb);
            incluir_menu_pre();
            this.globales.onCreate_global(this, false);
            SearchManager searchManager = (SearchManager) getSystemService("search");
            searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
                public void onCancel() {
                    t_vistafb.this.finalizar = false;
                    t_vistafb.this.setResult(0);
                }
            });
            searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
                public void onDismiss() {
                    t_vistafb.this.buscador_on = false;
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
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + str), Color.parseColor("#" + str2)}));
            }
            if (this.globales.secciones_a[this.globales.ind_secc_sel_2].ico_widget && Build.VERSION.SDK_INT > 25) {
                Boolean bool = false;
                try {
                    getApplication().getPackageManager().getReceiverInfo(new ComponentName(this, widget_vistafb.class), 0);
                    bool = true;
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (bool.booleanValue()) {
                    findViewById(R.id.ico_widget).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AppWidgetManager appWidgetManager = (AppWidgetManager) t_vistafb.this.getApplicationContext().getSystemService(AppWidgetManager.class);
                            ComponentName componentName = new ComponentName(t_vistafb.this.getApplicationContext(), widget_vistafb.class);
                            if (appWidgetManager.isRequestPinAppWidgetSupported()) {
                                try {
                                    appWidgetManager.requestPinAppWidget(componentName, (Bundle) null, (PendingIntent) null);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    findViewById(R.id.ico_widget).setVisibility(0);
                }
            }
            ListView listView = (ListView) findViewById(R.id.w_main);
            listView.setCacheColorHint(0);
            if (this.c1_esclaro) {
                ((TextView) findViewById(R.id.w_empty_view)).setTextColor(config.NEGRO);
            } else {
                ((TextView) findViewById(R.id.w_empty_view)).setTextColor(config.BLANCO_2);
            }
            this.listData = new ArrayList<>();
            vistafb_adapter vistafb_adapter = new vistafb_adapter(this, R.layout.widget_vistafb_row, this.listData);
            this.itemAdapter = vistafb_adapter;
            vistafb_adapter.ind_secc = this.ind_secc;
            this.itemAdapter.c1_esclaro = this.c1_esclaro;
            listView.setAdapter(this.itemAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    t_vistafb.this.itemAdapter.clicat(i);
                }
            });
            new itemsDataController().execute(new String[0]);
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
        ResultGetIntent intent;
        if (view != null && (intent = this.globales.getIntent(view, this)) != null) {
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

    private class itemsDataController extends AsyncTask<String, Integer, ArrayList<widget_vistafb_item>> {
        ProgressBar pb;

        private itemsDataController() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (t_vistafb.this.c1_esclaro) {
                this.pb = (ProgressBar) t_vistafb.this.findViewById(R.id.w_pb);
            } else {
                this.pb = (ProgressBar) t_vistafb.this.findViewById(R.id.w_pb);
            }
            if (Build.VERSION.SDK_INT > 20) {
                config.progress_color(this.pb, t_vistafb.this.globales.c_icos);
            }
            this.pb.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(9:20|21|22|23|(3:25|26|(4:28|30|31|41))|29|30|31|41) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x01fd */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ArrayList<stikerwap.appdys.widget_vistafb_item> doInBackground(java.lang.String... r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.String r0 = ";"
                r2 = 1
                java.lang.Boolean.valueOf(r2)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = stikerwap.appdys.config.PROTOC_GEN
                r3.append(r4)
                java.lang.String r4 = "widget."
                r3.append(r4)
                java.lang.String r4 = stikerwap.appdys.config.DOM_EDROID
                r3.append(r4)
                java.lang.String r4 = "/srv/widget_fb.php?ids="
                r3.append(r4)
                stikerwap.appdys.t_vistafb r4 = stikerwap.appdys.t_vistafb.this
                stikerwap.appdys.config r4 = r4.globales
                stikerwap.appdys.Seccion[] r4 = r4.secciones_a
                stikerwap.appdys.t_vistafb r5 = stikerwap.appdys.t_vistafb.this
                stikerwap.appdys.config r5 = r5.globales
                int r5 = r5.ind_secc_sel_2
                r4 = r4[r5]
                int r4 = r4.id
                r3.append(r4)
                java.lang.String r4 = "&idusu="
                r3.append(r4)
                stikerwap.appdys.t_vistafb r4 = stikerwap.appdys.t_vistafb.this
                long r4 = r4.idusu
                r3.append(r4)
                java.lang.String r4 = "&c="
                r3.append(r4)
                stikerwap.appdys.t_vistafb r4 = stikerwap.appdys.t_vistafb.this
                android.content.SharedPreferences r4 = r4.settings
                java.lang.String r5 = "cod"
                java.lang.String r6 = ""
                java.lang.String r4 = r4.getString(r5, r6)
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r4 = 0
                org.apache.http.params.BasicHttpParams r5 = new org.apache.http.params.BasicHttpParams     // Catch:{ Exception -> 0x0214 }
                r5.<init>()     // Catch:{ Exception -> 0x0214 }
                r6 = 10000(0x2710, float:1.4013E-41)
                org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r5, r6)     // Catch:{ Exception -> 0x0214 }
                r6 = 60000(0xea60, float:8.4078E-41)
                org.apache.http.params.HttpConnectionParams.setSoTimeout(r5, r6)     // Catch:{ Exception -> 0x0214 }
                org.apache.http.impl.client.DefaultHttpClient r6 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ Exception -> 0x0214 }
                r6.<init>((org.apache.http.params.HttpParams) r5)     // Catch:{ Exception -> 0x0214 }
                org.apache.http.client.methods.HttpPost r5 = new org.apache.http.client.methods.HttpPost     // Catch:{ Exception -> 0x0214 }
                r5.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x0214 }
                org.apache.http.entity.mime.MultipartEntity r3 = new org.apache.http.entity.mime.MultipartEntity     // Catch:{ Exception -> 0x0214 }
                org.apache.http.entity.mime.HttpMultipartMode r7 = org.apache.http.entity.mime.HttpMultipartMode.BROWSER_COMPATIBLE     // Catch:{ Exception -> 0x0214 }
                r3.<init>(r7)     // Catch:{ Exception -> 0x0214 }
                java.lang.String r3 = "User-Agent"
                java.lang.String r7 = "Android Vinebre Software"
                r5.setHeader(r3, r7)     // Catch:{ Exception -> 0x0214 }
                org.apache.http.HttpResponse r3 = r6.execute(r5)     // Catch:{ Exception -> 0x0214 }
                java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0214 }
                java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0214 }
                org.apache.http.HttpEntity r3 = r3.getEntity()     // Catch:{ Exception -> 0x0214 }
                java.io.InputStream r3 = r3.getContent()     // Catch:{ Exception -> 0x0214 }
                java.lang.String r7 = "UTF-8"
                r6.<init>(r3, r7)     // Catch:{ Exception -> 0x0214 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0214 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0214 }
                r3.<init>()     // Catch:{ Exception -> 0x0214 }
            L_0x009e:
                java.lang.String r6 = r5.readLine()     // Catch:{ Exception -> 0x0214 }
                if (r6 == 0) goto L_0x00a8
                r3.append(r6)     // Catch:{ Exception -> 0x0214 }
                goto L_0x009e
            L_0x00a8:
                java.lang.String r5 = "ANDROID:OK CAD:"
                int r5 = r3.indexOf(r5)     // Catch:{ Exception -> 0x0214 }
                r6 = -1
                if (r5 != r6) goto L_0x00b2
                return r4
            L_0x00b2:
                r7 = 15
                int r5 = r5 + r7
                java.lang.String r3 = r3.substring(r5)     // Catch:{ Exception -> 0x0214 }
                java.lang.String r5 = "@"
                java.lang.String[] r3 = r3.split(r5)     // Catch:{ Exception -> 0x0214 }
                int r5 = r3.length     // Catch:{ Exception -> 0x0214 }
                if (r5 <= 0) goto L_0x0213
                r5 = 0
                r8 = r3[r5]     // Catch:{ Exception -> 0x0214 }
                int r8 = r8.indexOf(r0)     // Catch:{ Exception -> 0x0214 }
                if (r8 == r6) goto L_0x0213
                r6 = r3[r5]     // Catch:{ Exception -> 0x0214 }
                java.lang.String[] r6 = r6.split(r0)     // Catch:{ Exception -> 0x0214 }
                r6 = r6[r5]     // Catch:{ Exception -> 0x0214 }
                java.lang.String r8 = "1"
                boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x0214 }
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0214 }
                stikerwap.appdys.t_vistafb r8 = stikerwap.appdys.t_vistafb.this     // Catch:{ Exception -> 0x0214 }
                stikerwap.appdys.vistafb_adapter r8 = r8.itemAdapter     // Catch:{ Exception -> 0x0214 }
                boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x0214 }
                r8.hay_fotos = r6     // Catch:{ Exception -> 0x0214 }
                r6 = 1
            L_0x00ea:
                int r8 = r3.length     // Catch:{ Exception -> 0x0214 }
                if (r6 >= r8) goto L_0x020c
                r8 = r3[r6]     // Catch:{ Exception -> 0x0214 }
                boolean r8 = r8.contains(r0)     // Catch:{ Exception -> 0x0214 }
                if (r8 == 0) goto L_0x0206
                r8 = r3[r6]     // Catch:{ Exception -> 0x0214 }
                java.lang.String[] r8 = r8.split(r0)     // Catch:{ Exception -> 0x0214 }
                int r9 = r8.length     // Catch:{ Exception -> 0x0214 }
                r10 = 2
                if (r9 <= r10) goto L_0x0206
                r9 = r8[r5]     // Catch:{ Exception -> 0x0214 }
                r11 = r8[r2]     // Catch:{ Exception -> 0x0214 }
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r12 = 3
                r12 = r8[r12]     // Catch:{ Exception -> 0x0214 }
                r13 = 4
                r13 = r8[r13]     // Catch:{ Exception -> 0x0214 }
                r14 = 5
                r14 = r8[r14]     // Catch:{ Exception -> 0x0214 }
                stikerwap.appdys.widget_vistafb_item r15 = new stikerwap.appdys.widget_vistafb_item     // Catch:{ Exception -> 0x0214 }
                r15.<init>()     // Catch:{ Exception -> 0x0214 }
                r15.tipo = r9     // Catch:{ Exception -> 0x0214 }
                r15.idusu = r11     // Catch:{ Exception -> 0x0214 }
                r15.nick = r10     // Catch:{ Exception -> 0x0214 }
                r15.vfoto = r12     // Catch:{ Exception -> 0x0214 }
                r15.idelem = r14     // Catch:{ Exception -> 0x0214 }
                r9 = 6
                r10 = r8[r9]     // Catch:{ Exception -> 0x0214 }
                r15.idelem_2 = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 7
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.privados = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 8
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.fnac_d = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 9
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.fnac_m = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 10
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.fnac_a = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 11
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.sexo = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 12
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.coments = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 13
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.fotos_perfil = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 14
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.privados_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = r8[r7]     // Catch:{ Exception -> 0x0214 }
                r15.fotos_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 16
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.coments_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 17
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.fnac_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 18
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.sexo_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 19
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.descr_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 20
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.galeria_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 21
                r10 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.dist_chat = r10     // Catch:{ Exception -> 0x0214 }
                r10 = 22
                r8 = r8[r10]     // Catch:{ Exception -> 0x0214 }
                r15.idelem_3 = r8     // Catch:{ Exception -> 0x0214 }
                java.lang.String r8 = stikerwap.appdys.config.convertir_fecha(r13)     // Catch:{ Exception -> 0x0214 }
                java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0214 }
                java.lang.String r11 = "ddMMyyHHmm"
                r10.<init>(r11)     // Catch:{ Exception -> 0x0214 }
                stikerwap.appdys.t_vistafb r11 = stikerwap.appdys.t_vistafb.this     // Catch:{ Exception -> 0x01fd }
                java.text.DateFormat r11 = android.text.format.DateFormat.getDateFormat(r11)     // Catch:{ Exception -> 0x01fd }
                stikerwap.appdys.t_vistafb r12 = stikerwap.appdys.t_vistafb.this     // Catch:{ Exception -> 0x01fd }
                java.text.DateFormat r12 = android.text.format.DateFormat.getTimeFormat(r12)     // Catch:{ Exception -> 0x01fd }
                java.util.Date r8 = r10.parse(r8)     // Catch:{ Exception -> 0x01fd }
                java.util.Calendar r10 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x01fd }
                java.util.Calendar r13 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x01fd }
                r13.setTime(r8)     // Catch:{ Exception -> 0x01fd }
                int r14 = r13.get(r2)     // Catch:{ Exception -> 0x01fd }
                int r5 = r10.get(r2)     // Catch:{ Exception -> 0x01fd }
                java.lang.String r2 = " "
                if (r14 != r5) goto L_0x01e1
                int r5 = r13.get(r9)     // Catch:{ Exception -> 0x01fd }
                int r9 = r10.get(r9)     // Catch:{ Exception -> 0x01fd }
                if (r5 != r9) goto L_0x01e1
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fd }
                r5.<init>()     // Catch:{ Exception -> 0x01fd }
                stikerwap.appdys.t_vistafb r9 = stikerwap.appdys.t_vistafb.this     // Catch:{ Exception -> 0x01fd }
                android.content.res.Resources r9 = r9.getResources()     // Catch:{ Exception -> 0x01fd }
                r10 = 2131886471(0x7f120187, float:1.9407522E38)
                java.lang.String r9 = r9.getString(r10)     // Catch:{ Exception -> 0x01fd }
                r5.append(r9)     // Catch:{ Exception -> 0x01fd }
                r5.append(r2)     // Catch:{ Exception -> 0x01fd }
                java.lang.String r2 = r12.format(r8)     // Catch:{ Exception -> 0x01fd }
                r5.append(r2)     // Catch:{ Exception -> 0x01fd }
                java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x01fd }
                r15.fcrea = r2     // Catch:{ Exception -> 0x01fd }
                goto L_0x01fd
            L_0x01e1:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fd }
                r5.<init>()     // Catch:{ Exception -> 0x01fd }
                java.lang.String r9 = r11.format(r8)     // Catch:{ Exception -> 0x01fd }
                r5.append(r9)     // Catch:{ Exception -> 0x01fd }
                r5.append(r2)     // Catch:{ Exception -> 0x01fd }
                java.lang.String r2 = r12.format(r8)     // Catch:{ Exception -> 0x01fd }
                r5.append(r2)     // Catch:{ Exception -> 0x01fd }
                java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x01fd }
                r15.fcrea = r2     // Catch:{ Exception -> 0x01fd }
            L_0x01fd:
                stikerwap.appdys.t_vistafb r2 = stikerwap.appdys.t_vistafb.this     // Catch:{ Exception -> 0x0214 }
                java.util.ArrayList r2 = r2.listData     // Catch:{ Exception -> 0x0214 }
                r2.add(r15)     // Catch:{ Exception -> 0x0214 }
            L_0x0206:
                int r6 = r6 + 1
                r2 = 1
                r5 = 0
                goto L_0x00ea
            L_0x020c:
                stikerwap.appdys.t_vistafb r0 = stikerwap.appdys.t_vistafb.this
                java.util.ArrayList r0 = r0.listData
                return r0
            L_0x0213:
                return r4
            L_0x0214:
                r0 = move-exception
                r0.printStackTrace()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.t_vistafb.itemsDataController.doInBackground(java.lang.String[]):java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(ArrayList<widget_vistafb_item> arrayList) {
            try {
                this.pb.setVisibility(8);
            } catch (Exception unused) {
            }
            if (arrayList == null || arrayList.isEmpty()) {
                t_vistafb.this.findViewById(R.id.w_main).setVisibility(8);
                t_vistafb.this.findViewById(R.id.w_empty_view).setVisibility(0);
                return;
            }
            t_vistafb.this.itemAdapter.notifyDataSetChanged();
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
                if (!t_vistafb.this.globales.admob_rew_failed(context, t_vistafb.this.mAd_appnext)) {
                    t_vistafb.this.dialog_cargando.cancel();
                    t_vistafb t_vistafb = t_vistafb.this;
                    t_vistafb.abrir_secc(t_vistafb.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_vistafb.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_vistafb.this.abrir_secc(t_vistafb.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_vistafb.this.mAd_visto) {
                            t_vistafb.this.abrir_secc(t_vistafb.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_vistafb.this.mAd_visto = true;
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
                if (t_vistafb.this.mAd_visto) {
                    t_vistafb t_vistafb = t_vistafb.this;
                    t_vistafb.abrir_secc(t_vistafb.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
