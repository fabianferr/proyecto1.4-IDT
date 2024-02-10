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
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
import stikerwap.appdys.t_chat;

public class privados extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private Anuncios anun;
    private boolean atras_pulsado = false;
    private boolean c1_esclaro;
    /* access modifiers changed from: private */
    public String codigo;
    private Bundle extras;
    int fotos_perfil;
    /* access modifiers changed from: private */
    public config globales;
    /* access modifiers changed from: private */
    public long idusu;
    boolean mAd_visto = false;
    ListView mDrawerList;
    private SharedPreferences settings;
    /* access modifiers changed from: private */
    public View v_sel;

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
        int i = this.globales.ind_secc_sel_2;
        this.cbtn = config.aplicar_color_dialog(this.globales.secciones_a[i].c1, this.globales.c_icos);
        if (!config.esClaro("#" + this.globales.secciones_a[i].c1)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.privados);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                privados.this.finalizar = false;
                privados.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                privados.this.buscador_on = false;
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
        this.codigo = this.settings.getString("cod", "");
        this.c1_esclaro = config.esClaro("#" + this.globales.secciones_a[i].c1);
        if (!this.globales.secciones_a[i].c1.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.secciones_a[i].c1), Color.parseColor("#" + this.globales.secciones_a[i].c2)}));
        }
        int i2 = !this.c1_esclaro ? -1 : ViewCompat.MEASURED_STATE_MASK;
        ((TextView) findViewById(R.id.tv_listaprivados)).setTextColor(i2);
        findViewById(R.id.v_listaprivados).setBackgroundColor(i2);
        ((TextView) findViewById(R.id.tv_sinprivados)).setTextColor(i2);
        this.fotos_perfil = 1;
        mostrar_privados();
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
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mostrar_privados() {
        /*
            r20 = this;
            r0 = r20
            java.io.File r1 = r20.getFilesDir()
            r2 = 2131362648(0x7f0a0358, float:1.8345083E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r2.removeAllViews()
            java.lang.String r3 = "layout_inflater"
            java.lang.Object r3 = r0.getSystemService(r3)
            android.view.LayoutInflater r3 = (android.view.LayoutInflater) r3
            r5 = 0
            r6 = 0
        L_0x001c:
            r7 = 100
            if (r5 >= r7) goto L_0x02d5
            android.content.SharedPreferences r7 = r0.settings
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "privado"
            r8.<init>(r9)
            r8.append(r5)
            java.lang.String r10 = "_id"
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x02cd
            android.content.SharedPreferences r6 = r0.settings
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r5)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ""
            java.lang.String r6 = r6.getString(r7, r8)
            boolean r7 = r6.equals(r8)
            r11 = 1
            if (r7 != 0) goto L_0x0066
            int r7 = r6.length()
            int r7 = r7 - r11
            int r12 = r6.length()
            java.lang.String r6 = r6.substring(r7, r12)
        L_0x0066:
            boolean r7 = r0.c1_esclaro
            java.lang.String r12 = "9"
            java.lang.String r13 = "4"
            java.lang.String r14 = "8"
            java.lang.String r15 = "3"
            java.lang.String r11 = "7"
            java.lang.String r4 = "2"
            r16 = r2
            java.lang.String r2 = "6"
            r17 = r1
            java.lang.String r1 = "1"
            r18 = r8
            java.lang.String r8 = "5"
            r19 = r10
            java.lang.String r10 = "0"
            if (r7 == 0) goto L_0x00ee
            boolean r7 = r6.equals(r10)
            if (r7 != 0) goto L_0x00e6
            boolean r7 = r6.equals(r8)
            if (r7 == 0) goto L_0x0093
            goto L_0x00e6
        L_0x0093:
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x00de
            boolean r1 = r6.equals(r2)
            if (r1 == 0) goto L_0x00a0
            goto L_0x00de
        L_0x00a0:
            boolean r1 = r6.equals(r4)
            if (r1 != 0) goto L_0x00d6
            boolean r1 = r6.equals(r11)
            if (r1 == 0) goto L_0x00ad
            goto L_0x00d6
        L_0x00ad:
            boolean r1 = r6.equals(r15)
            if (r1 != 0) goto L_0x00ce
            boolean r1 = r6.equals(r14)
            if (r1 == 0) goto L_0x00ba
            goto L_0x00ce
        L_0x00ba:
            boolean r1 = r6.equals(r13)
            if (r1 != 0) goto L_0x00c6
            boolean r1 = r6.equals(r12)
            if (r1 == 0) goto L_0x012f
        L_0x00c6:
            java.lang.String r1 = "#FFCC0000"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x00ce:
            java.lang.String r1 = "#FF9E5400"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x00d6:
            java.lang.String r1 = "#FF3D5C00"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x00de:
            java.lang.String r1 = "#FF9933CC"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x00e6:
            java.lang.String r1 = "#FF00698C"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x00ee:
            boolean r7 = r6.equals(r10)
            if (r7 != 0) goto L_0x014e
            boolean r7 = r6.equals(r8)
            if (r7 == 0) goto L_0x00fb
            goto L_0x014e
        L_0x00fb:
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x0147
            boolean r1 = r6.equals(r2)
            if (r1 == 0) goto L_0x0108
            goto L_0x0147
        L_0x0108:
            boolean r1 = r6.equals(r4)
            if (r1 != 0) goto L_0x0140
            boolean r1 = r6.equals(r11)
            if (r1 == 0) goto L_0x0115
            goto L_0x0140
        L_0x0115:
            boolean r1 = r6.equals(r15)
            if (r1 != 0) goto L_0x0139
            boolean r1 = r6.equals(r14)
            if (r1 == 0) goto L_0x0122
            goto L_0x0139
        L_0x0122:
            boolean r1 = r6.equals(r13)
            if (r1 != 0) goto L_0x0132
            boolean r1 = r6.equals(r12)
            if (r1 == 0) goto L_0x012f
            goto L_0x0132
        L_0x012f:
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x0154
        L_0x0132:
            java.lang.String r1 = "#FF33FFFF"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x0139:
            java.lang.String r1 = "#FF87BFFF"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x0140:
            java.lang.String r1 = "#FFC9ADFF"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x0147:
            java.lang.String r1 = "#FF66CC33"
            int r1 = android.graphics.Color.parseColor(r1)
            goto L_0x0154
        L_0x014e:
            java.lang.String r1 = "#FFFF6633"
            int r1 = android.graphics.Color.parseColor(r1)
        L_0x0154:
            r2 = 2131558687(0x7f0d011f, float:1.8742697E38)
            r4 = 0
            android.view.View r2 = r3.inflate(r2, r4)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r4 = 2131362421(0x7f0a0275, float:1.8344622E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            int r6 = r0.fotos_perfil
            if (r6 != 0) goto L_0x018a
            r6 = 8
            r4.setVisibility(r6)
            r4 = 2131363494(0x7f0a06a6, float:1.8346798E38)
            android.view.View r6 = r2.findViewById(r4)
            r6.setBackgroundColor(r1)
            android.view.View r4 = r2.findViewById(r4)
            r6 = 0
            r4.setVisibility(r6)
            r10 = r17
            r13 = r18
            r12 = r19
            goto L_0x0206
        L_0x018a:
            r4.setBackgroundColor(r1)
            android.content.ContentResolver r6 = r20.getContentResolver()     // Catch:{ Exception -> 0x01de }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x01de }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01de }
            r8.<init>()     // Catch:{ Exception -> 0x01de }
            java.lang.String r10 = "fperfil_"
            r8.append(r10)     // Catch:{ Exception -> 0x01de }
            android.content.SharedPreferences r10 = r0.settings     // Catch:{ Exception -> 0x01de }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01de }
            r11.<init>()     // Catch:{ Exception -> 0x01de }
            r11.append(r9)     // Catch:{ Exception -> 0x01de }
            r11.append(r5)     // Catch:{ Exception -> 0x01de }
            r12 = r19
            r11.append(r12)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01d9 }
            r13 = r18
            java.lang.String r10 = r10.getString(r11, r13)     // Catch:{ Exception -> 0x01d6 }
            r8.append(r10)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r10 = ".jpg"
            r8.append(r10)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01d6 }
            r10 = r17
            r7.<init>(r10, r8)     // Catch:{ Exception -> 0x01e4 }
            android.net.Uri r7 = android.net.Uri.fromFile(r7)     // Catch:{ Exception -> 0x01e4 }
            android.graphics.Bitmap r6 = android.provider.MediaStore.Images.Media.getBitmap(r6, r7)     // Catch:{ Exception -> 0x01e4 }
            r4.setImageBitmap(r6)     // Catch:{ Exception -> 0x01e4 }
            goto L_0x0206
        L_0x01d6:
            r10 = r17
            goto L_0x01e4
        L_0x01d9:
            r10 = r17
            r13 = r18
            goto L_0x01e4
        L_0x01de:
            r10 = r17
            r13 = r18
            r12 = r19
        L_0x01e4:
            boolean r6 = r0.c1_esclaro
            if (r6 == 0) goto L_0x01f8
            android.content.res.Resources r6 = r20.getResources()
            r7 = 2131231691(0x7f0803cb, float:1.807947E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)
            r4.setImageDrawable(r6)
            goto L_0x0206
        L_0x01f8:
            android.content.res.Resources r6 = r20.getResources()
            r7 = 2131231689(0x7f0803c9, float:1.8079466E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)
            r4.setImageDrawable(r6)
        L_0x0206:
            r4 = 2131363453(0x7f0a067d, float:1.8346715E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            android.content.SharedPreferences r6 = r0.settings
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r5)
            java.lang.String r8 = "_nombre"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r6 = r6.getString(r7, r13)
            r4.setText(r6)
            r6 = 2131363452(0x7f0a067c, float:1.8346713E38)
            android.view.View r6 = r2.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.util.Date r7 = new java.util.Date
            android.content.SharedPreferences r11 = r0.settings
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r9)
            r14.append(r5)
            java.lang.String r15 = "_fultconex"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r17 = r2
            r15 = r3
            r2 = 0
            long r2 = r11.getLong(r14, r2)
            r7.<init>(r2)
            android.content.Context r2 = r20.getApplicationContext()
            java.text.DateFormat r2 = android.text.format.DateFormat.getDateFormat(r2)
            android.content.Context r3 = r20.getApplicationContext()
            java.text.DateFormat r3 = android.text.format.DateFormat.getTimeFormat(r3)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r2 = r2.format(r7)
            r11.append(r2)
            java.lang.String r2 = " "
            r11.append(r2)
            java.lang.String r2 = r3.format(r7)
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            r6.setText(r2)
            r4.setTextColor(r1)
            r6.setTextColor(r1)
            android.content.SharedPreferences r1 = r0.settings
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r5)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.String r1 = r1.getString(r2, r13)
            r2 = 2131362376(0x7f0a0248, float:1.834453E38)
            r3 = r17
            r3.setTag(r2, r1)
            android.content.SharedPreferences r1 = r0.settings
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r5)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.String r1 = r1.getString(r2, r13)
            r2 = 2131362379(0x7f0a024b, float:1.8344537E38)
            r3.setTag(r2, r1)
            r0.registerForContextMenu(r3)
            r3.setOnClickListener(r0)
            r2 = r16
            r2.addView(r3)
            r6 = 1
            goto L_0x02cf
        L_0x02cd:
            r10 = r1
            r15 = r3
        L_0x02cf:
            int r5 = r5 + 1
            r1 = r10
            r3 = r15
            goto L_0x001c
        L_0x02d5:
            if (r6 != 0) goto L_0x02f7
            android.content.res.Resources r1 = r20.getResources()
            r2 = 2131034118(0x7f050006, float:1.7678745E38)
            boolean r1 = r1.getBoolean(r2)
            r2 = 2131363464(0x7f0a0688, float:1.8346738E38)
            if (r1 == 0) goto L_0x02ef
            android.view.View r1 = r0.findViewById(r2)
            r3 = 4
            r1.setTextDirection(r3)
        L_0x02ef:
            android.view.View r1 = r0.findViewById(r2)
            r2 = 0
            r1.setVisibility(r2)
        L_0x02f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.privados.mostrar_privados():void");
    }

    public void onClick(View view) {
        if (view.getTag(R.id.idaux1) != null) {
            openContextMenu(view);
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

    public boolean onSearchRequested() {
        this.finalizar = true;
        this.buscador_on = true;
        return super.onSearchRequested();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.v_sel = view;
        contextMenu.setHeaderTitle((String) view.getTag(R.id.idaux3));
        getMenuInflater().inflate(R.menu.m1_privado, contextMenu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.eliminar) {
            final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    new t_chat.cancelar_solicitud((String) privados.this.v_sel.getTag(R.id.idaux1), 1, privados.this.idusu, privados.this.codigo).execute(new String[0]);
                }
            }).setMessage(R.string.confirmar_bloquearprivado).create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + privados.this.cbtn));
                        Button button2 = create.getButton(-2);
                        button2.setTextColor(Color.parseColor("#" + privados.this.cbtn));
                    }
                });
            }
            final AlertDialog create2 = new AlertDialog.Builder(this).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    privados privados = privados.this;
                    config.elim_privado(privados, (String) privados.v_sel.getTag(R.id.idaux1));
                    privados.this.mostrar_privados();
                    create.show();
                    try {
                        ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                    } catch (Exception unused) {
                    }
                }
            }).setMessage(R.string.confirmar_elimprivado).create();
            if (!this.cbtn.equals("")) {
                create2.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create2.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + privados.this.cbtn));
                        Button button2 = create2.getButton(-2);
                        button2.setTextColor(Color.parseColor("#" + privados.this.cbtn));
                    }
                });
            }
            create2.show();
            try {
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused) {
            }
            return true;
        } else if (itemId != R.id.pedirprivado) {
            return super.onContextItemSelected(menuItem);
        } else {
            config.anyadir_privado(this, (String) this.v_sel.getTag(R.id.idaux1), (String) this.v_sel.getTag(R.id.idaux3));
            SharedPreferences.Editor edit = getSharedPreferences("accion", 0).edit();
            edit.putString("id_remit", (String) this.v_sel.getTag(R.id.idaux1));
            edit.putString("nombre_remit", (String) this.v_sel.getTag(R.id.idaux3));
            edit.commit();
            Intent intent = new Intent();
            intent.putExtra("abrir_privado", true);
            setResult(-1, intent);
            finish();
            return true;
        }
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        SharedPreferences.Editor edit = getSharedPreferences("accion", 0).edit();
        edit.putInt("accion", 0);
        edit.commit();
        SharedPreferences.Editor edit2 = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
        edit2.putBoolean("activa", true);
        edit2.commit();
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (this.globales.admob_pos != 0 && (anuncios = this.anun) != null && anuncios.wortiseBanner != null) {
            this.anun.wortiseBanner.resume();
        }
    }

    private void finalizar() {
        SharedPreferences.Editor edit = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).edit();
        edit.putBoolean("activa", false);
        edit.commit();
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
        if (isFinishing()) {
            finalizar();
        }
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
                if (!privados.this.globales.admob_rew_failed(context, privados.this.mAd_appnext)) {
                    privados.this.dialog_cargando.cancel();
                    privados privados = privados.this;
                    privados.abrir_secc(privados.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                privados.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        privados.this.abrir_secc(privados.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (privados.this.mAd_visto) {
                            privados.this.abrir_secc(privados.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        privados.this.mAd_visto = true;
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
                if (privados.this.mAd_visto) {
                    privados privados = privados.this;
                    privados.abrir_secc(privados.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
