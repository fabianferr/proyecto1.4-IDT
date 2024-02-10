package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
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

public class eliminarperfil extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean desde_main;
    boolean desde_main_oblig;
    ProgressDialog dialog_eliminando;
    boolean externo;
    Bundle extras;
    config globales;
    int idsecc;
    long idusu;
    boolean mAd_visto = false;
    ListView mDrawerList;
    SharedPreferences settings;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        this.globales = (config) getApplicationContext();
        establec_ralc(this);
        this.cbtn = config.aplicar_color_dialog("FFFFFFFF", this.globales.c_icos);
        super.onCreate(bundle);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        this.externo = this.extras.containsKey("externo");
        this.desde_main = this.extras.getBoolean("desde_main", false);
        this.desde_main_oblig = this.extras.getBoolean("desde_main_oblig", false);
        setContentView(R.layout.eliminarperfil);
        incluir_menu_pre();
        if (!this.desde_main_oblig) {
            this.globales.onCreate_global(this, false);
        }
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                eliminarperfil.this.finalizar = false;
                eliminarperfil.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                eliminarperfil.this.buscador_on = false;
            }
        });
        this.anun = this.globales.mostrar_banner(this, false);
        int i = this.globales.ind_secc_sel_2;
        if (this.desde_main) {
            str = this.globales.c1c;
            str2 = this.globales.c2c;
            this.idsecc = 0;
        } else {
            if (this.externo) {
                str4 = this.globales.secciones_a[i].c1;
                str3 = this.globales.secciones_a[i].c2;
            } else {
                str4 = this.globales.secciones_a[i].c1;
                str3 = this.globales.secciones_a[i].c2;
                this.idsecc = this.extras.getInt("idsecc");
            }
            String str5 = str4;
            str2 = str3;
            str = str5;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        if (!str.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + str), Color.parseColor("#" + str2)}));
            if (config.esClaro("#" + str)) {
                ((TextView) findViewById(R.id.message_text)).setTextColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                ((TextView) findViewById(R.id.message_text)).setTextColor(-1);
            }
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog_eliminando = progressDialog;
        progressDialog.setMessage(getString(R.string.eliminando));
        this.dialog_eliminando.setIndeterminate(true);
        if (Build.VERSION.SDK_INT > 20) {
            this.dialog_eliminando.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    config.progress_color((ProgressBar) eliminarperfil.this.dialog_eliminando.findViewById(16908301), eliminarperfil.this.globales.c_icos);
                }
            });
        }
        this.dialog_eliminando.show();
        new eliminar().execute(new String[0]);
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
        if (this.desde_main_oblig) {
            this.globales.incluir_menu_2(this, false);
            return;
        }
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

    /* access modifiers changed from: package-private */
    public void mostrar_msg() {
        final AlertDialog create = new AlertDialog.Builder(this).setCancelable(false).setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                eliminarperfil.this.finalizar = true;
                config.finalizar_app = true;
                Intent intent = new Intent();
                intent.putExtra("finalizar", true);
                intent.putExtra("finalizar_app", true);
                eliminarperfil.this.setResult(-1, intent);
                eliminarperfil.this.finish();
            }
        }).setMessage(R.string.perfileliminado).create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + eliminarperfil.this.cbtn));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    private class eliminar extends AsyncTask<String, Void, Byte> {
        private eliminar() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:23|22|25|26|(1:28)|29) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00a4 */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                java.lang.String r7 = "&idapp=3008836&c="
                r0 = 2
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
                r2.<init>()     // Catch:{ Exception -> 0x00a4 }
                java.lang.String r3 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x00a4 }
                r2.append(r3)     // Catch:{ Exception -> 0x00a4 }
                java.lang.String r3 = "/srv/eliminar_perfil.php?idusu="
                r2.append(r3)     // Catch:{ Exception -> 0x00a4 }
                stikerwap.appdys.eliminarperfil r3 = stikerwap.appdys.eliminarperfil.this     // Catch:{ Exception -> 0x00a4 }
                long r3 = r3.idusu     // Catch:{ Exception -> 0x00a4 }
                r2.append(r3)     // Catch:{ Exception -> 0x00a4 }
                r2.append(r7)     // Catch:{ Exception -> 0x00a4 }
                stikerwap.appdys.eliminarperfil r7 = stikerwap.appdys.eliminarperfil.this     // Catch:{ Exception -> 0x00a4 }
                android.content.SharedPreferences r7 = r7.settings     // Catch:{ Exception -> 0x00a4 }
                java.lang.String r3 = "cod"
                java.lang.String r4 = ""
                java.lang.String r7 = r7.getString(r3, r4)     // Catch:{ Exception -> 0x00a4 }
                r2.append(r7)     // Catch:{ Exception -> 0x00a4 }
                java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x00a4 }
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00a4 }
                r2.<init>(r7)     // Catch:{ Exception -> 0x00a4 }
                java.net.URLConnection r7 = r2.openConnection()     // Catch:{ Exception -> 0x00a4 }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x00a4 }
                r1 = 1
                r7.setDoInput(r1)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r2 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r7.setReadTimeout(r2)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.lang.String r2 = "User-Agent"
                java.lang.String r3 = "Android Vinebre Software"
                r7.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.io.InputStream r2 = r7.getInputStream()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r4.<init>(r2)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r3.<init>(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r2.<init>()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            L_0x0061:
                java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                if (r4 == 0) goto L_0x007c
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r5.<init>()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r5.append(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.lang.String r4 = "\n"
                r5.append(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r2.append(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                goto L_0x0061
            L_0x007c:
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                java.lang.String r3 = "ANDROID:OK"
                int r2 = r2.indexOf(r3)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                r3 = -1
                if (r2 == r3) goto L_0x0093
                java.lang.Byte r0 = java.lang.Byte.valueOf(r1)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                if (r7 == 0) goto L_0x0092
                r7.disconnect()
            L_0x0092:
                return r0
            L_0x0093:
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
                if (r7 == 0) goto L_0x009c
                r7.disconnect()
            L_0x009c:
                return r0
            L_0x009d:
                r0 = move-exception
                r1 = r7
                goto L_0x00ae
            L_0x00a0:
                r1 = r7
                goto L_0x00a4
            L_0x00a2:
                r0 = move-exception
                goto L_0x00ae
            L_0x00a4:
                java.lang.Byte r7 = java.lang.Byte.valueOf(r0)     // Catch:{ all -> 0x00a2 }
                if (r1 == 0) goto L_0x00ad
                r1.disconnect()
            L_0x00ad:
                return r7
            L_0x00ae:
                if (r1 == 0) goto L_0x00b3
                r1.disconnect()
            L_0x00b3:
                goto L_0x00b5
            L_0x00b4:
                throw r0
            L_0x00b5:
                goto L_0x00b4
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.eliminarperfil.eliminar.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (eliminarperfil.this.dialog_eliminando.isShowing()) {
                eliminarperfil.this.dialog_eliminando.dismiss();
            }
            if (b.byteValue() == 1) {
                try {
                    eliminarperfil.this.globales.getTempFile(eliminarperfil.this, 1).delete();
                } catch (Exception unused) {
                }
                SharedPreferences.Editor edit = eliminarperfil.this.settings.edit();
                edit.putBoolean("dadodebaja", true);
                edit.commit();
                eliminarperfil.this.mostrar_msg();
                return;
            }
            final AlertDialog create = new AlertDialog.Builder(eliminarperfil.this).setCancelable(false).setPositiveButton(eliminarperfil.this.getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(eliminarperfil.this, preperfil.class);
                    if (eliminarperfil.this.externo) {
                        intent = config.completar_externo(intent, eliminarperfil.this.extras);
                    } else {
                        intent.putExtra("idsecc", eliminarperfil.this.idsecc);
                    }
                    if (eliminarperfil.this.globales.tipomenu != 2 || eliminarperfil.this.desde_main_oblig) {
                        intent.putExtra("es_root", true);
                        eliminarperfil.this.es_root = false;
                    }
                    intent.putExtra("desde_main", eliminarperfil.this.desde_main);
                    intent.putExtra("desde_main_oblig", eliminarperfil.this.desde_main_oblig);
                    eliminarperfil.this.finalizar = true;
                    eliminarperfil.this.startActivity(intent);
                }
            }).setMessage(R.string.error_http).create();
            if (!eliminarperfil.this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + eliminarperfil.this.cbtn));
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused2) {
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
                if (!eliminarperfil.this.globales.admob_rew_failed(context, eliminarperfil.this.mAd_appnext)) {
                    eliminarperfil.this.dialog_cargando.cancel();
                    eliminarperfil eliminarperfil = eliminarperfil.this;
                    eliminarperfil.abrir_secc(eliminarperfil.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                eliminarperfil.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        eliminarperfil.this.abrir_secc(eliminarperfil.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (eliminarperfil.this.mAd_visto) {
                            eliminarperfil.this.abrir_secc(eliminarperfil.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        eliminarperfil.this.mAd_visto = true;
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
                if (eliminarperfil.this.mAd_visto) {
                    eliminarperfil eliminarperfil = eliminarperfil.this;
                    eliminarperfil.abrir_secc(eliminarperfil.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
