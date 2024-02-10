package stikerwap.appdys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class contactar extends Activity_ext_class implements Activity_ext, View.OnClickListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    Anuncios anun;
    boolean atras_pulsado = false;
    /* access modifiers changed from: private */
    public ProgressDialog dialog_enviando;
    /* access modifiers changed from: private */
    public String email;
    config globales;
    int idofic;
    long idusu;
    boolean mAd_visto = false;
    ListView mDrawerList;
    /* access modifiers changed from: private */
    public String nombre;
    /* access modifiers changed from: private */
    public String observ;
    /* access modifiers changed from: private */
    public String telefono;

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
        this.cbtn = config.aplicar_color_dialog(this.globales.c1_ofic, this.globales.c_ir_ofic);
        if (!config.esClaro("#" + this.globales.c1_ofic)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.contactar);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                contactar.this.finalizar = false;
                contactar.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                contactar.this.buscador_on = false;
            }
        });
        if (bundle == null) {
            this.globales.toca_int(this, false, false);
        }
        this.anun = this.globales.mostrar_banner(this, false);
        Bundle extras = getIntent().getExtras();
        if (bundle == null) {
            this.es_root = extras != null && extras.containsKey("es_root") && extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle.containsKey("es_root") && bundle.getBoolean("es_root", false);
        }
        this.idofic = extras.getInt("idofic");
        this.idusu = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0).getLong("idusu", 0);
        if (!this.globales.c_tit_ofic.equals("")) {
            ((TextView) findViewById(R.id.tv_tit)).setTextColor(Color.parseColor("#" + this.globales.c_tit_ofic));
        }
        if (!this.globales.c_sep_ofic.equals("")) {
            View findViewById = findViewById(R.id.v_sep);
            findViewById.setBackgroundColor(Color.parseColor("#" + this.globales.c_sep_ofic));
        }
        if (!this.globales.c_ico_sep_ofic.equals("")) {
            Drawable drawable = getResources().getDrawable(R.drawable.email_contactar);
            drawable.setColorFilter(Color.parseColor("#" + this.globales.c_ico_sep_ofic), PorterDuff.Mode.MULTIPLY);
            ((ImageView) findViewById(R.id.iv_email)).setImageDrawable(drawable);
        }
        if (!this.globales.c_txt_ofic.equals("")) {
            int parseColor = Color.parseColor("#" + this.globales.c_txt_ofic);
            ((TextView) findViewById(R.id.tv_to_lit)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_to)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_nombre)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.opcional_nombre)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_email)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.opcional_email)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_tel)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.opcional_tel)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_msg)).setTextColor(parseColor);
            if (Build.VERSION.SDK_INT > 20) {
                config.edittext_color((EditText) findViewById(R.id.c_nombre), Boolean.valueOf(config.esClaro("#" + this.globales.c_txt_ofic)), this.globales.c_ir_ofic);
                config.edittext_color((EditText) findViewById(R.id.c_email), Boolean.valueOf(config.esClaro("#" + this.globales.c_txt_ofic)), this.globales.c_ir_ofic);
                config.edittext_color((EditText) findViewById(R.id.c_telefono), Boolean.valueOf(config.esClaro("#" + this.globales.c_txt_ofic)), this.globales.c_ir_ofic);
                config.edittext_color((EditText) findViewById(R.id.c_observ), Boolean.valueOf(config.esClaro("#" + this.globales.c_txt_ofic)), this.globales.c_ir_ofic);
            }
        }
        if (config.esClaro("#" + this.globales.c_ir_ofic)) {
            findViewById(R.id.iv_btn_fondo_n).setVisibility(0);
        } else {
            findViewById(R.id.iv_btn_fondo_b).setVisibility(0);
        }
        Drawable drawable2 = getResources().getDrawable(R.drawable.enviar_btn);
        drawable2.setColorFilter(Color.parseColor("#" + this.globales.c_ir_ofic), PorterDuff.Mode.MULTIPLY);
        ImageView imageView = (ImageView) findViewById(R.id.button1);
        imageView.setImageDrawable(drawable2);
        imageView.setOnClickListener(this);
        int i = 0;
        while (true) {
            if (i < this.globales.oficinas_a.length) {
                if (this.globales.oficinas_a[i].id == this.idofic && this.globales.oficinas_a[i].t_email && !this.globales.oficinas_a[i].email.equals("")) {
                    ((TextView) findViewById(R.id.tv_to)).setText(this.globales.oficinas_a[i].email);
                    findViewById(R.id.tr_to).setVisibility(0);
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (this.globales.petic_ask_nombre > 0) {
            if (this.globales.petic_ask_nombre == 1) {
                findViewById(R.id.opcional_nombre).setVisibility(0);
            }
            findViewById(R.id.tr_nombre).setVisibility(0);
        }
        if (this.globales.petic_ask_email > 0) {
            if (this.globales.petic_ask_email == 1) {
                findViewById(R.id.opcional_email).setVisibility(0);
            }
            findViewById(R.id.tr_email).setVisibility(0);
        }
        if (this.globales.petic_ask_tel > 0) {
            if (this.globales.petic_ask_tel == 1) {
                findViewById(R.id.opcional_tel).setVisibility(0);
            }
            findViewById(R.id.tr_tel).setVisibility(0);
        }
        if (extras.containsKey("msg_predefinido")) {
            ((EditText) findViewById(R.id.c_observ)).setText(getResources().getString(R.string.masinfo_sobre) + " " + extras.getString("msg_predefinido"));
        }
        if (!this.globales.c1_ofic.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.c1_ofic), Color.parseColor("#" + this.globales.c2_ofic)}));
        }
    }

    /* access modifiers changed from: package-private */
    public void mostrar_error() {
        final AlertDialog create = new AlertDialog.Builder(this).setCancelable(false).setPositiveButton(R.string.cerrar, (DialogInterface.OnClickListener) null).setMessage(R.string.error_http).create();
        if (!this.cbtn.equals("")) {
            create.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    Button button = create.getButton(-1);
                    button.setTextColor(Color.parseColor("#" + contactar.this.cbtn));
                }
            });
        }
        create.show();
        try {
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    private class enviarTask extends AsyncTask<String, Void, Byte> {
        private enviarTask() {
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/enviar_petic.php?v=1&idapp=3008836&idusu=" + contactar.this.idusu + "&idofic=" + contactar.this.idofic);
            StringBuilder sb = new StringBuilder();
            try {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new BasicNameValuePair("nombre", contactar.this.nombre));
                arrayList.add(new BasicNameValuePair("email", contactar.this.email));
                arrayList.add(new BasicNameValuePair("tel", contactar.this.telefono));
                arrayList.add(new BasicNameValuePair("observ", contactar.this.observ));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
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
                return (byte) 2;
            } catch (ClientProtocolException unused) {
                return (byte) 2;
            } catch (IOException unused2) {
                return (byte) 2;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            try {
                contactar.this.dialog_enviando.dismiss();
            } catch (Exception unused) {
            }
            if (b.byteValue() == 1) {
                final AlertDialog create = new AlertDialog.Builder(contactar.this).setCancelable(false).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (contactar.this.es_root) {
                            int i2 = 0;
                            boolean z = false;
                            int i3 = 0;
                            while (!z && i3 < contactar.this.globales.secciones_a.length) {
                                if (!contactar.this.globales.secciones_a[i3].oculta) {
                                    z = true;
                                } else {
                                    i3++;
                                }
                            }
                            if (z) {
                                i2 = i3;
                            }
                            ResultGetIntent crear_rgi = contactar.this.globales.crear_rgi(Integer.valueOf(i2), contactar.this);
                            crear_rgi.i.putExtra("es_root", true);
                            contactar.this.startActivity(crear_rgi.i);
                        }
                        contactar.this.finish();
                    }
                }).setMessage(R.string.mensaje_enviado).create();
                if (!contactar.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + contactar.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused2) {
                }
            } else {
                contactar.this.mostrar_error();
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false).setPositiveButton(getResources().getString(R.string.cerrar), (DialogInterface.OnClickListener) null);
            this.nombre = ((TextView) findViewById(R.id.c_nombre)).getText().toString();
            this.email = ((TextView) findViewById(R.id.c_email)).getText().toString();
            this.telefono = ((TextView) findViewById(R.id.c_telefono)).getText().toString();
            this.observ = ((TextView) findViewById(R.id.c_observ)).getText().toString();
            if (this.nombre.length() == 0 && this.globales.petic_ask_nombre == 2) {
                builder.setMessage(R.string.falta_nombre);
                final AlertDialog create = builder.create();
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + contactar.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            } else if (this.email.length() == 0 && this.globales.petic_ask_email == 2) {
                builder.setMessage(R.string.falta_email);
                final AlertDialog create2 = builder.create();
                if (!this.cbtn.equals("")) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + contactar.this.cbtn));
                        }
                    });
                }
                create2.show();
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (this.telefono.length() == 0 && this.globales.petic_ask_tel == 2) {
                builder.setMessage(R.string.falta_tel);
                final AlertDialog create3 = builder.create();
                if (!this.cbtn.equals("")) {
                    create3.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create3.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + contactar.this.cbtn));
                        }
                    });
                }
                create3.show();
                ((TextView) create3.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (this.observ.length() == 0) {
                builder.setMessage(R.string.falta_msg);
                final AlertDialog create4 = builder.create();
                if (!this.cbtn.equals("")) {
                    create4.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create4.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + contactar.this.cbtn));
                        }
                    });
                }
                create4.show();
                ((TextView) create4.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else if (this.email.length() <= 0 || this.email.contains("@")) {
                ProgressDialog progressDialog = new ProgressDialog(this);
                this.dialog_enviando = progressDialog;
                progressDialog.setMessage(getString(R.string.enviando));
                this.dialog_enviando.setIndeterminate(true);
                if (Build.VERSION.SDK_INT > 20) {
                    this.dialog_enviando.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            config.progress_color((ProgressBar) contactar.this.dialog_enviando.findViewById(16908301), contactar.this.globales.c_ir_ofic);
                        }
                    });
                }
                this.dialog_enviando.show();
                new enviarTask().execute(new String[0]);
            } else {
                builder.setMessage(R.string.email_nook);
                final AlertDialog create5 = builder.create();
                if (!this.cbtn.equals("")) {
                    create5.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create5.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + contactar.this.cbtn));
                        }
                    });
                }
                create5.show();
                ((TextView) create5.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
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
                if (!contactar.this.globales.admob_rew_failed(context, contactar.this.mAd_appnext)) {
                    contactar.this.dialog_cargando.cancel();
                    contactar contactar = contactar.this;
                    contactar.abrir_secc(contactar.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                contactar.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        contactar.this.abrir_secc(contactar.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (contactar.this.mAd_visto) {
                            contactar.this.abrir_secc(contactar.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        contactar.this.mAd_visto = true;
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
                if (contactar.this.mAd_visto) {
                    contactar contactar = contactar.this;
                    contactar.abrir_secc(contactar.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
