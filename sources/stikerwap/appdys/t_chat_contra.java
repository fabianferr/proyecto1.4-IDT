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
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class t_chat_contra extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    AlertDialog.Builder adb;
    Anuncios anun;
    boolean atras_pulsado = false;
    String c1;
    boolean c1_esclaro;
    String c2;
    String contra;
    boolean contra_ko = false;
    /* access modifiers changed from: private */
    public ProgressDialog dialog_enviando;
    CheckBox dontShowAgain;
    EditText et_contra;
    boolean externo;
    Bundle extras;
    boolean finalizar_2 = false;
    config globales;
    int idsecc;
    long idusu;
    int ind;
    boolean mAd_visto = false;
    ListView mDrawerList;
    SharedPreferences sp;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.finalizar_2 = bundle.getBoolean("finalizar_2", false);
        }
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
        Bundle bundle2 = this.extras;
        boolean z = bundle2 != null && bundle2.containsKey("externo");
        this.externo = z;
        if (z) {
            this.c1 = this.extras.getString("c1");
            this.c2 = this.extras.getString("c2");
        } else {
            this.ind = this.extras.getInt("ind");
            this.c1 = this.globales.secciones_a[this.ind].c1;
            this.c2 = this.globales.secciones_a[this.ind].c2;
            this.idsecc = this.globales.secciones_a[this.ind].id;
        }
        this.c1_esclaro = config.esClaro("#" + this.c1);
        this.cbtn = config.aplicar_color_dialog(this.c1, this.globales.c_icos);
        if (!this.c1_esclaro) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.t_chat_contra);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_chat_contra.this.finalizar = false;
                t_chat_contra.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_chat_contra.this.buscador_on = false;
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.sp = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        if (!this.c1.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.c1), Color.parseColor("#" + this.c2)}));
            if (config.esClaro("#" + this.c1)) {
                ((TextView) findViewById(R.id.message_text)).setTextColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                ((TextView) findViewById(R.id.message_text)).setTextColor(-1);
            }
        }
        if (!this.externo) {
            SharedPreferences sharedPreferences2 = this.sp;
            if (!sharedPreferences2.getBoolean("chat" + this.idsecc + "_validado", true)) {
                preguntar_contra();
                return;
            }
        }
        if (bundle == null) {
            iniciar();
        }
    }

    /* access modifiers changed from: package-private */
    public void preguntar_contra() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        this.adb = builder;
        builder.setTitle(getResources().getString(R.string.chat_acceso));
        View inflate = getLayoutInflater().inflate(R.layout.contra, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.message)).setText(getResources().getString(R.string.chat_introduce_contra));
        this.et_contra = (EditText) inflate.findViewById(R.id.et_contra);
        if (this.contra_ko) {
            inflate.findViewById(R.id.message_error).setVisibility(0);
        }
        this.dontShowAgain = (CheckBox) inflate.findViewById(R.id.skip);
        if (!this.cbtn.equals("")) {
            EditText editText = this.et_contra;
            config.edittext_color(editText, Boolean.valueOf(!config.esClaro("#" + this.c1)), this.cbtn);
            config.checkbox_color(this.dontShowAgain, this.cbtn);
        }
        CheckBox checkBox = this.dontShowAgain;
        SharedPreferences sharedPreferences = this.sp;
        checkBox.setChecked(sharedPreferences.getBoolean("chat" + this.idsecc + "_nomostrarmas_def", true));
        this.adb.setView(inflate);
        this.adb.setCancelable(true);
        this.adb.setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences.Editor edit = t_chat_contra.this.sp.edit();
                if (t_chat_contra.this.dontShowAgain.isChecked()) {
                    edit.putBoolean("chat" + t_chat_contra.this.idsecc + "_nomostrarmas_def", true);
                } else {
                    edit.putBoolean("chat" + t_chat_contra.this.idsecc + "_nomostrarmas_def", false);
                }
                edit.commit();
                t_chat_contra.this.dialog_enviando = new ProgressDialog(t_chat_contra.this);
                t_chat_contra.this.dialog_enviando.setMessage(t_chat_contra.this.getString(R.string.comprobando));
                t_chat_contra.this.dialog_enviando.setIndeterminate(true);
                if (Build.VERSION.SDK_INT > 20) {
                    t_chat_contra.this.dialog_enviando.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            config.progress_color((ProgressBar) t_chat_contra.this.dialog_enviando.findViewById(16908301), t_chat_contra.this.cbtn);
                        }
                    });
                }
                t_chat_contra.this.dialog_enviando.show();
                t_chat_contra t_chat_contra = t_chat_contra.this;
                t_chat_contra.contra = t_chat_contra.et_contra.getText().toString();
                new enviarTask().execute(new String[0]);
            }
        });
        this.adb.setNegativeButton(getString(R.string.cancelar), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                t_chat_contra.this.mostrar_msg(0);
            }
        });
        this.adb.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                t_chat_contra.this.mostrar_msg(0);
            }
        });
        final AlertDialog create = this.adb.create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + t_chat_contra.this.cbtn));
                    Button button2 = create.getButton(-2);
                    button2.setTextColor(Color.parseColor("#" + t_chat_contra.this.cbtn));
                }
            });
        }
        try {
            create.show();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void iniciar() {
        Class cls;
        Intent intent;
        Bundle bundle = this.extras;
        if (bundle != null && bundle.containsKey("clase")) {
            int i = this.extras.getInt("clase");
            if (i == 1) {
                cls = t_url.class;
            } else if (i == 2) {
                cls = t_html.class;
            } else if (i == 3) {
                cls = t_and.class;
            } else if (i == 4) {
                cls = t_oficinas.class;
            } else if (i == 5) {
                cls = t_buscador.class;
            } else if (i == 6) {
                cls = this.globales.secciones_a[this.ind].tipo_player == 0 ? t_video.class : this.globales.secciones_a[this.ind].tipo_player == 1 ? t_video_exoplayer.class : t_video_playerjs.class;
            } else if (i == 7) {
                cls = t_radio.class;
            } else if (i == 8) {
                cls = t_rss.class;
            } else if (i == 10) {
                cls = this.globales.secciones_a[this.ind].idsubcat > 0 ? t_buscchats_lista.class : t_buscchats.class;
            } else if (i == 11) {
                cls = t_buscusus.class;
            } else if (i == 12) {
                cls = t_submenu.class;
            } else if (i == 22) {
                cls = t_submenu_ultimas.class;
            } else if (i == 13) {
                cls = t_gal.class;
            } else if (i == 14) {
                cls = t_card.class;
            } else if (i == 16) {
                cls = t_buscvideos.class;
            } else if (i == 19) {
                cls = t_vistafb.class;
            } else {
                cls = i == 20 ? t_qr.class : null;
            }
            if (cls != null) {
                if (i == 4) {
                    intent = this.globales.intent_ofics(this).i;
                } else if (i == 5) {
                    intent = this.globales.intent_prods(this).i;
                } else {
                    intent = new Intent(this, cls);
                    intent.putExtras(this.extras);
                }
                this.es_root = false;
                this.finalizar_2 = true;
                startActivityForResult(intent, 0);
            }
        } else if (this.sp.getString("nick", "").equals("") || (this.globales.fb_modo == 3 && !this.sp.getBoolean("email_confirmado", false))) {
            Intent intent2 = new Intent(this, chat_perfil.class);
            if (this.externo) {
                intent2 = config.completar_externo(intent2, this.extras);
            } else {
                intent2.putExtra("idsecc", this.idsecc);
            }
            if (this.es_root) {
                intent2.putExtra("es_root", this.es_root);
            }
            this.es_root = false;
            this.finalizar_2 = true;
            startActivityForResult(intent2, 0);
        } else if ((((!this.externo || this.extras.getInt("fotos_perfil") != 2) && (this.externo || this.globales.secciones_a[this.ind].fotos_perfil != 2)) || this.globales.getTempFile(this, 1).exists()) && ((((!this.externo || this.extras.getInt("fnac") != 2) && (this.externo || this.globales.secciones_a[this.ind].p_fnac != 2)) || !(this.sp.getInt("fnac_d", 0) == 0 || this.sp.getInt("fnac_m", 0) == 0 || this.sp.getInt("fnac_a", 0) == 0)) && ((((!this.externo || this.extras.getInt("sexo") != 2) && (this.externo || this.globales.secciones_a[this.ind].p_sexo != 2)) || this.sp.getInt("sexo", 0) != 0) && (((!this.externo || this.extras.getInt("descr") != 2) && (this.externo || this.globales.secciones_a[this.ind].p_descr != 2)) || !this.sp.getString("descr", "").equals(""))))) {
            Intent intent3 = new Intent(this, t_chat.class);
            if (this.externo) {
                intent3 = config.completar_externo(intent3, this.extras);
                if (this.extras.containsKey("tit_cab")) {
                    intent3.putExtra("tit_cab", this.extras.getString("tit_cab"));
                }
            } else {
                intent3.putExtra("idsecc", this.idsecc);
            }
            if (this.es_root) {
                intent3.putExtra("es_root", this.es_root);
            }
            this.es_root = false;
            Bundle bundle2 = this.extras;
            if (!(bundle2 == null || bundle2.getString("id_remit") == null)) {
                intent3.putExtra("id_remit", this.extras.getString("id_remit"));
                intent3.putExtra("nombre_remit", this.extras.getString("nombre_remit"));
                if (this.extras.containsKey("empezar_privado")) {
                    intent3.putExtra("empezar_privado", true);
                }
            }
            this.finalizar_2 = true;
            startActivityForResult(intent3, 0);
        } else {
            Intent intent4 = new Intent(this, preperfil.class);
            if (this.externo) {
                intent4 = config.completar_externo(intent4, this.extras);
            } else {
                intent4.putExtra("idsecc", this.idsecc);
            }
            if (this.es_root) {
                intent4.putExtra("es_root", this.es_root);
            }
            this.es_root = false;
            this.finalizar_2 = true;
            startActivityForResult(intent4, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_msg(int i) {
        TextView textView = (TextView) findViewById(R.id.message_text);
        if (i == 0) {
            textView.setText(R.string.chat_contra_necesaria);
        } else if (i == 1) {
            textView.setText(R.string.error_http);
        }
        textView.setVisibility(0);
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

    private class enviarTask extends AsyncTask<String, Void, Byte> {
        private enviarTask() {
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/comprobar_contra.php?v=1&idapp=3008836&idusu=" + t_chat_contra.this.idusu + "&idchat=" + t_chat_contra.this.idsecc);
            StringBuilder sb = new StringBuilder();
            try {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new BasicNameValuePair("contra", t_chat_contra.this.contra));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                if (sb.indexOf("ANDROID:KO") != -1) {
                    return (byte) 2;
                }
                if (sb.indexOf("ANDROID:OK") != -1) {
                    return (byte) 1;
                }
                return (byte) 0;
            } catch (ClientProtocolException unused) {
                return (byte) 0;
            } catch (IOException unused2) {
                return (byte) 0;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            try {
                t_chat_contra.this.dialog_enviando.dismiss();
            } catch (Exception unused) {
            }
            if (b.byteValue() == 1) {
                SharedPreferences sharedPreferences = t_chat_contra.this.sp;
                if (sharedPreferences.getBoolean("chat" + t_chat_contra.this.idsecc + "_nomostrarmas_def", true)) {
                    SharedPreferences.Editor edit = t_chat_contra.this.sp.edit();
                    edit.putBoolean("chat" + t_chat_contra.this.idsecc + "_validado", true);
                    edit.commit();
                }
                t_chat_contra.this.iniciar();
            } else if (b.byteValue() == 2) {
                t_chat_contra.this.contra_ko = true;
                t_chat_contra.this.preguntar_contra();
            } else {
                t_chat_contra.this.mostrar_msg(1);
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

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("finalizar_2", this.finalizar_2);
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
                if (!t_chat_contra.this.globales.admob_rew_failed(context, t_chat_contra.this.mAd_appnext)) {
                    t_chat_contra.this.dialog_cargando.cancel();
                    t_chat_contra t_chat_contra = t_chat_contra.this;
                    t_chat_contra.abrir_secc(t_chat_contra.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_chat_contra.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_chat_contra.this.abrir_secc(t_chat_contra.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_chat_contra.this.mAd_visto) {
                            t_chat_contra.this.abrir_secc(t_chat_contra.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_chat_contra.this.mAd_visto = true;
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
                if (t_chat_contra.this.mAd_visto) {
                    t_chat_contra t_chat_contra = t_chat_contra.this;
                    t_chat_contra.abrir_secc(t_chat_contra.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
