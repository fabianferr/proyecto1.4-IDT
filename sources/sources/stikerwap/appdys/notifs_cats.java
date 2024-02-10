package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
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

public class notifs_cats extends Activity_ext_class implements Activity_ext, View.OnClickListener, CompoundButton.OnCheckedChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private Anuncios anun;
    private boolean atras_pulsado = false;
    /* access modifiers changed from: private */
    public boolean c1_esclaro;
    /* access modifiers changed from: private */
    public String cod_g;
    private Bundle extras;
    /* access modifiers changed from: private */
    public config globales;
    /* access modifiers changed from: private */
    public long idusu;
    boolean mAd_visto = false;
    ListView mDrawerList;
    /* access modifiers changed from: private */
    public SharedPreferences settings;

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
        setContentView(R.layout.notifs_cats);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                notifs_cats.this.finalizar = false;
                notifs_cats.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                notifs_cats.this.buscador_on = false;
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
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.cod_g = this.settings.getString("cod_g", "");
        this.c1_esclaro = config.esClaro("#" + this.globales.c1c);
        if (!this.globales.c1c.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.c1c), Color.parseColor("#" + this.globales.c2c)}));
        }
        int i = !this.c1_esclaro ? -1 : ViewCompat.MEASURED_STATE_MASK;
        TextView textView = (TextView) findViewById(R.id.tv_listacatsnotifs);
        textView.setTextColor(i);
        if (!this.globales.catsnotif_tit.equals("")) {
            textView.setText(this.globales.catsnotif_tit);
        }
        findViewById(R.id.v_listacatsnotifs).setBackgroundColor(i);
        if (this.settings.getInt("catsnotif_v_aplic", 0) == this.globales.catsnotif_v_bd) {
            mostrar_cats();
        } else {
            new cargar_cats().execute(new String[0]);
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

    /* access modifiers changed from: private */
    public void mostrar_cats() {
        LayoutInflater layoutInflater;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llnotifs);
        linearLayout.removeAllViews();
        LayoutInflater layoutInflater2 = (LayoutInflater) getSystemService("layout_inflater");
        String[] split = this.settings.getString("catsnotif_ids", "").split(",");
        int i = 0;
        while (i < split.length) {
            if (!split[i].equals("")) {
                String str = split[i];
                int i2 = config.NEGRO;
                int i3 = config.GRIS_CLARO;
                if (!this.c1_esclaro) {
                    i2 = config.BLANCO;
                    i3 = config.GRIS_OSCURO;
                }
                SharedPreferences sharedPreferences = this.settings;
                if (sharedPreferences.getString("catsnotif_" + str + "_sep", "0").equals("1")) {
                    LinearLayout linearLayout2 = (LinearLayout) layoutInflater2.inflate(R.layout.notif_sep, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_sep);
                    SharedPreferences sharedPreferences2 = this.settings;
                    textView.setText(sharedPreferences2.getString("catsnotif_" + str + "_descr", ""));
                    textView.setTextColor(i2);
                    linearLayout2.findViewById(R.id.v_sep).setBackgroundColor(i3);
                    linearLayout.addView(linearLayout2);
                } else {
                    LinearLayout linearLayout3 = (LinearLayout) layoutInflater2.inflate(R.layout.notif_cat, (ViewGroup) null);
                    TextView textView2 = (TextView) linearLayout3.findViewById(R.id.tv_cat);
                    layoutInflater = layoutInflater2;
                    if (getResources().getBoolean(R.bool.es_rtl)) {
                        textView2.setTextDirection(4);
                    }
                    SharedPreferences sharedPreferences3 = this.settings;
                    textView2.setText(sharedPreferences3.getString("catsnotif_" + str + "_descr", ""));
                    textView2.setTextColor(i2);
                    Switch switchR = new Switch(this);
                    SharedPreferences sharedPreferences4 = this.settings;
                    switchR.setChecked(sharedPreferences4.getString("catsnotif_" + str + "_def", "0").equals("1"));
                    switchR.setOnCheckedChangeListener(this);
                    switchR.setTag(R.id.idaux1, str);
                    ((LinearLayout) linearLayout3.findViewById(R.id.ll_sc)).addView(switchR);
                    linearLayout3.findViewById(R.id.v_sep).setBackgroundColor(i3);
                    linearLayout.addView(linearLayout3);
                    i++;
                    layoutInflater2 = layoutInflater;
                }
            }
            layoutInflater = layoutInflater2;
            i++;
            layoutInflater2 = layoutInflater;
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        new aplic_modo((String) compoundButton.getTag(R.id.idaux1), Boolean.valueOf(z)).execute(new String[0]);
    }

    public void onClick(View view) {
        if (view.getTag(R.id.idaux1) == null) {
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

    private class aplic_modo extends AsyncTask<String, Void, Byte> {
        String idcat;
        String modo;

        aplic_modo(String str, Boolean bool) {
            this.modo = bool.booleanValue() ? "1" : "0";
            this.idcat = str;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                r7 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2 }
                r0.<init>()     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00b2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = "/srv/usu_catnotif.php?v=2&idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                stikerwap.appdys.notifs_cats r1 = stikerwap.appdys.notifs_cats.this     // Catch:{ Exception -> 0x00b2 }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x00b2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                stikerwap.appdys.notifs_cats r1 = stikerwap.appdys.notifs_cats.this     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = r1.cod_g     // Catch:{ Exception -> 0x00b2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = "&idcat="
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = r6.idcat     // Catch:{ Exception -> 0x00b2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = "&modo="
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r1 = r6.modo     // Catch:{ Exception -> 0x00b2 }
                r0.append(r1)     // Catch:{ Exception -> 0x00b2 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b2 }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b2 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x00b2 }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x00b2 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00b2 }
                r7 = 1
                r0.setDoInput(r7)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                java.lang.String r1 = "User-Agent"
                java.lang.String r2 = "Android Vinebre Software"
                r0.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r1.<init>()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            L_0x0070:
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                if (r3 == 0) goto L_0x008b
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r4.<init>()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r4.append(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                java.lang.String r3 = "\n"
                r4.append(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r1.append(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                goto L_0x0070
            L_0x008b:
                java.lang.String r2 = "ANDROID:OK"
                int r1 = r1.indexOf(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                r2 = -1
                if (r1 == r2) goto L_0x009e
                java.lang.Byte r7 = java.lang.Byte.valueOf(r7)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                if (r0 == 0) goto L_0x009d
                r0.disconnect()
            L_0x009d:
                return r7
            L_0x009e:
                r7 = 0
                java.lang.Byte r7 = java.lang.Byte.valueOf(r7)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
                if (r0 == 0) goto L_0x00a8
                r0.disconnect()
            L_0x00a8:
                return r7
            L_0x00a9:
                r7 = move-exception
                goto L_0x00bd
            L_0x00ab:
                r7 = r0
                goto L_0x00b2
            L_0x00ad:
                r0 = move-exception
                r5 = r0
                r0 = r7
                r7 = r5
                goto L_0x00bd
            L_0x00b2:
                r0 = 2
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ all -> 0x00ad }
                if (r7 == 0) goto L_0x00bc
                r7.disconnect()
            L_0x00bc:
                return r0
            L_0x00bd:
                if (r0 == 0) goto L_0x00c2
                r0.disconnect()
            L_0x00c2:
                goto L_0x00c4
            L_0x00c3:
                throw r7
            L_0x00c4:
                goto L_0x00c3
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.notifs_cats.aplic_modo.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (b.byteValue() == 1) {
                SharedPreferences.Editor edit = notifs_cats.this.settings.edit();
                edit.putString("catsnotif_" + this.idcat + "_def", this.modo);
                edit.commit();
            }
        }
    }

    private class cargar_cats extends AsyncTask<String, Void, String> {
        private cargar_cats() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (notifs_cats.this.c1_esclaro) {
                notifs_cats.this.findViewById(R.id.pb_cargarcats_inv).setVisibility(0);
            } else {
                notifs_cats.this.findViewById(R.id.pb_cargarcats).setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x008e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r6 = 0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008a }
                r0.<init>()     // Catch:{ Exception -> 0x008a }
                java.lang.String r1 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x008a }
                r0.append(r1)     // Catch:{ Exception -> 0x008a }
                java.lang.String r1 = "/srv/cargar_catsnotif.php?v=2&idusu="
                r0.append(r1)     // Catch:{ Exception -> 0x008a }
                stikerwap.appdys.notifs_cats r1 = stikerwap.appdys.notifs_cats.this     // Catch:{ Exception -> 0x008a }
                long r1 = r1.idusu     // Catch:{ Exception -> 0x008a }
                r0.append(r1)     // Catch:{ Exception -> 0x008a }
                java.lang.String r1 = "&c="
                r0.append(r1)     // Catch:{ Exception -> 0x008a }
                stikerwap.appdys.notifs_cats r1 = stikerwap.appdys.notifs_cats.this     // Catch:{ Exception -> 0x008a }
                java.lang.String r1 = r1.cod_g     // Catch:{ Exception -> 0x008a }
                r0.append(r1)     // Catch:{ Exception -> 0x008a }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x008a }
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x008a }
                r1.<init>(r0)     // Catch:{ Exception -> 0x008a }
                java.net.URLConnection r0 = r1.openConnection()     // Catch:{ Exception -> 0x008a }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x008a }
                r6 = 1
                r0.setDoInput(r6)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r6 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r0.setReadTimeout(r6)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.lang.String r6 = "User-Agent"
                java.lang.String r1 = "Android Vinebre Software"
                r0.setRequestProperty(r6, r1)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.io.InputStream r6 = r0.getInputStream()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r6.<init>()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            L_0x005c:
                java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                if (r2 == 0) goto L_0x0077
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r3.<init>()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r3.append(r2)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.lang.String r2 = "\n"
                r3.append(r2)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                r6.append(r2)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                goto L_0x005c
            L_0x0077:
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
                if (r0 == 0) goto L_0x0080
                r0.disconnect()
            L_0x0080:
                return r6
            L_0x0081:
                r6 = move-exception
                goto L_0x0092
            L_0x0083:
                r6 = r0
                goto L_0x008a
            L_0x0085:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L_0x0092
            L_0x008a:
                java.lang.String r0 = ""
                if (r6 == 0) goto L_0x0091
                r6.disconnect()
            L_0x0091:
                return r0
            L_0x0092:
                if (r0 == 0) goto L_0x0097
                r0.disconnect()
            L_0x0097:
                goto L_0x0099
            L_0x0098:
                throw r6
            L_0x0099:
                goto L_0x0098
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.notifs_cats.cargar_cats.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            String[] strArr;
            String str2 = str;
            try {
                notifs_cats.this.findViewById(R.id.pb_cargarcats).setVisibility(8);
                notifs_cats.this.findViewById(R.id.pb_cargarcats_inv).setVisibility(8);
            } catch (Exception unused) {
            }
            if (str2.contains("ANDROID:OK DATOS:")) {
                int indexOf = str2.indexOf("DATOS:") + 6;
                String[] split = str2.substring(indexOf, str2.indexOf(";", indexOf)).split(",");
                String[] split2 = notifs_cats.this.settings.getString("catsnotif_ids", "").split(",");
                SharedPreferences.Editor edit = notifs_cats.this.settings.edit();
                for (int i = 0; i < split2.length; i++) {
                    edit.remove("catsnotif_" + split2[i] + "_descr");
                    edit.remove("catsnotif_" + split2[i] + "_def");
                    edit.remove("catsnotif_" + split2[i] + "_sep");
                }
                String str3 = "";
                int i2 = 0;
                while (i2 < split.length) {
                    if (!split[i2].equals("")) {
                        String[] split3 = split[i2].split("-");
                        strArr = split;
                        if (split3.length == 2) {
                            notifs_cats.this.globales.catsnotif_v_bd = Integer.parseInt(split3[1]);
                            edit.putInt("vcn", Integer.parseInt(split3[1]));
                            edit.putInt("catsnotif_v_aplic", Integer.parseInt(split3[1]));
                        } else {
                            String str4 = split3[0];
                            if (!str3.equals("")) {
                                str3 = str3 + ",";
                            }
                            edit.putString("catsnotif_" + str4 + "_descr", split3[2].replace("@X@", "-").replace("@Y@", ",").replace("@Z@", ";"));
                            edit.putString("catsnotif_" + str4 + "_def", split3[3]);
                            edit.putString("catsnotif_" + str4 + "_sep", split3[1]);
                            str3 = str3 + str4;
                        }
                    } else {
                        strArr = split;
                    }
                    i2++;
                    split = strArr;
                }
                edit.putString("catsnotif_ids", str3);
                notifs_cats.this.globales.hay_catsnotif = !str3.equals("");
                if (str3.equals("")) {
                    edit.putInt("hcn", 0);
                } else {
                    edit.putInt("hcn", 1);
                }
                edit.commit();
                notifs_cats.this.mostrar_cats();
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
                if (!notifs_cats.this.globales.admob_rew_failed(context, notifs_cats.this.mAd_appnext)) {
                    notifs_cats.this.dialog_cargando.cancel();
                    notifs_cats notifs_cats = notifs_cats.this;
                    notifs_cats.abrir_secc(notifs_cats.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                notifs_cats.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        notifs_cats.this.abrir_secc(notifs_cats.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (notifs_cats.this.mAd_visto) {
                            notifs_cats.this.abrir_secc(notifs_cats.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        notifs_cats.this.mAd_visto = true;
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
                if (notifs_cats.this.mAd_visto) {
                    notifs_cats notifs_cats = notifs_cats.this;
                    notifs_cats.abrir_secc(notifs_cats.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
