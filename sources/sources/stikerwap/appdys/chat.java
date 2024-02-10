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
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
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
import java.io.InputStreamReader;
import java.net.URLEncoder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class chat extends Activity_ext_class implements Activity_ext, View.OnKeyListener, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    private int altura;
    Anuncios anun;
    boolean atras_pulsado = false;
    Bundle extras;
    /* access modifiers changed from: private */
    public config globales;
    /* access modifiers changed from: private */
    public long idusu;
    boolean mAd_visto = false;
    ListView mDrawerList;
    /* access modifiers changed from: private */
    public String m_global;
    /* access modifiers changed from: private */
    public SharedPreferences settings;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        int indexOf;
        int i;
        String str;
        Bundle bundle2 = bundle;
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
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle2 == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle2.containsKey("es_root") && bundle2.getBoolean("es_root", false);
        }
        super.onCreate(bundle);
        setContentView(R.layout.chat);
        incluir_menu_pre();
        this.globales.onCreate_global(this, false);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                chat.this.finalizar = false;
                chat.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                chat.this.buscador_on = false;
            }
        });
        if (bundle2 == null) {
            config config2 = this.globales;
            Bundle bundle3 = this.extras;
            boolean z = bundle3 != null && bundle3.containsKey("ad_entrar");
            Bundle bundle4 = this.extras;
            config2.toca_int(this, z, bundle4 != null && bundle4.containsKey("fb_entrar"));
        }
        this.anun = this.globales.mostrar_banner(this, false);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.altura = point.y;
        if (!this.globales.c1_ofic.equals("")) {
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#" + this.globales.c1_ofic), Color.parseColor("#" + this.globales.c2_ofic)}));
        }
        if (!this.globales.c_ico_sep_ofic.equals("")) {
            Drawable drawable = getResources().getDrawable(R.drawable.chat_contactar);
            drawable.setColorFilter(Color.parseColor("#" + this.globales.c_ico_sep_ofic), PorterDuff.Mode.MULTIPLY);
            ((ImageView) findViewById(R.id.iv_chat)).setImageDrawable(drawable);
        }
        if (!this.globales.c_tit_ofic.equals("")) {
            ((TextView) findViewById(R.id.tv_tit)).setTextColor(Color.parseColor("#" + this.globales.c_tit_ofic));
        }
        if (!this.globales.c_sep_ofic.equals("")) {
            findViewById(R.id.v_sep).setBackgroundColor(Color.parseColor("#" + this.globales.c_sep_ofic));
        }
        if (Build.VERSION.SDK_INT > 20) {
            config.progress_color((ProgressBar) findViewById(R.id.pb_chat_env), this.globales.c_ir_ofic);
        }
        findViewById(R.id.iv_env).setOnClickListener(this);
        if (Build.VERSION.SDK_INT > 20) {
            config.edittext_color((EditText) findViewById(R.id.c_mensaje), false, this.globales.c_ir_ofic);
        } else {
            ((EditText) findViewById(R.id.c_mensaje)).setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        findViewById(R.id.c_mensaje).setOnKeyListener(this);
        if (config.esClaro("#" + this.globales.c_ir_ofic)) {
            findViewById(R.id.iv_btn_fondo_n).setVisibility(0);
        } else {
            findViewById(R.id.iv_btn_fondo_b).setVisibility(0);
        }
        Drawable drawable2 = getResources().getDrawable(R.drawable.btn_enviar);
        drawable2.setColorFilter(Color.parseColor("#" + this.globales.c_ir_ofic), PorterDuff.Mode.MULTIPLY);
        ((ImageView) findViewById(R.id.iv_env)).setImageDrawable(drawable2);
        this.settings.registerOnSharedPreferenceChangeListener(this);
        String string = this.settings.getString("conv", "");
        if (!string.equals("")) {
            SharedPreferences.Editor edit = this.settings.edit();
            edit.putString("f_idfrase", "0");
            edit.commit();
            for (int i2 = 0; i2 != -1; i2 = indexOf) {
                int i3 = i2 + 1;
                int indexOf2 = string.indexOf("@0@", i3);
                indexOf = string.indexOf("@" + this.idusu + "@", i3);
                if (indexOf2 != -1 && indexOf != -1) {
                    indexOf = Math.min(indexOf2, indexOf);
                } else if (indexOf2 != -1) {
                    indexOf = indexOf2;
                } else if (indexOf == -1) {
                    indexOf = -1;
                }
                if (string.substring(i2, i2 + 3).equals("@0@")) {
                    edit.putString("f_id", "0");
                    i = 3;
                } else {
                    edit.putString("f_id", this.idusu + "");
                    i = (this.idusu + "").length() + 2;
                }
                edit.putString("f_idfrase", config.idfrase_global + "");
                if (indexOf != -1) {
                    str = string.substring(i2 + i, indexOf);
                } else {
                    str = string.substring(i2 + i);
                }
                edit.putString("f_frase", str);
                edit.commit();
                config.idfrase_global++;
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        f_enviar(true);
        return true;
    }

    private void f_enviar(boolean z) {
        String obj = ((EditText) findViewById(R.id.c_mensaje)).getText().toString();
        this.m_global = obj;
        String trim = obj.trim();
        this.m_global = trim;
        if (!trim.equals("")) {
            if (z && this.altura < 600) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((EditText) findViewById(R.id.c_mensaje)).getWindowToken(), 0);
            }
            if (this.settings.getString("nombre", "").equals("")) {
                final EditText editText = new EditText(this);
                editText.setSingleLine();
                editText.setInputType(8193);
                if (!this.cbtn.equals("")) {
                    config.edittext_color(editText, Boolean.valueOf(!config.esClaro("#" + this.globales.c1_ofic)), this.cbtn);
                }
                final AlertDialog create = new AlertDialog.Builder(this).setNegativeButton(getString(R.string.cancelar), (DialogInterface.OnClickListener) null).setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String obj = editText.getText().toString();
                        if (!obj.equals("")) {
                            SharedPreferences.Editor edit = chat.this.settings.edit();
                            edit.putString("nombre", obj);
                            edit.commit();
                            ((EditText) chat.this.findViewById(R.id.c_mensaje)).setTextColor(-7829368);
                            chat.this.findViewById(R.id.pb_chat_env).setVisibility(0);
                            chat chat = chat.this;
                            new enviar(chat.m_global).execute(new String[0]);
                            return;
                        }
                        final AlertDialog create = new AlertDialog.Builder(chat.this).setPositiveButton(chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.falta_nombre).create();
                        if (!chat.this.cbtn.equals("")) {
                            create.setOnShowListener(new DialogInterface.OnShowListener() {
                                public void onShow(DialogInterface dialogInterface) {
                                    Button button = create.getButton(-1);
                                    button.setTextColor(Color.parseColor("#" + chat.this.cbtn));
                                }
                            });
                        }
                        create.show();
                        try {
                            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                        } catch (Exception unused) {
                        }
                    }
                }).setMessage(R.string.pon_nombre).setView(editText).create();
                if (!this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat.this.cbtn));
                            Button button2 = create.getButton(-2);
                            button2.setTextColor(Color.parseColor("#" + chat.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            } else {
                ((EditText) findViewById(R.id.c_mensaje)).setTextColor(-7829368);
                findViewById(R.id.pb_chat_env).setVisibility(0);
                new enviar(this.m_global).execute(new String[0]);
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_env) {
            f_enviar(false);
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

    public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences.contains("f_idfrase") && str.equals("f_idfrase") && !sharedPreferences.getString("f_idfrase", "0").equals("0")) {
            runOnUiThread(new Runnable() {
                public void run() {
                    LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) chat.this.getSystemService("layout_inflater")).inflate(R.layout.frase, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.message_text);
                    textView.setText(sharedPreferences.getString("f_frase", "").replace("XYARROBAYX", "@"));
                    String string = sharedPreferences.getString("f_id", "");
                    if (string.equals(chat.this.idusu + "")) {
                        textView.setBackgroundResource(R.drawable.speech_bubble_gray);
                    } else {
                        textView.setBackgroundResource(R.drawable.speech_bubble_green);
                    }
                    LinearLayout linearLayout2 = (LinearLayout) chat.this.findViewById(R.id.llchat);
                    linearLayout2.addView(linearLayout);
                    ScrollView scrollView = (ScrollView) chat.this.findViewById(R.id.sv_chat);
                    if (linearLayout2.getMeasuredHeight() <= scrollView.getScrollY() + scrollView.getHeight()) {
                        scrollView.post(new Runnable() {
                            public void run() {
                                ((ScrollView) chat.this.findViewById(R.id.sv_chat)).fullScroll(130);
                            }
                        });
                    }
                }
            });
        }
    }

    private class enviar extends AsyncTask<String, Void, String> {
        String m;

        public enviar(String str) {
            this.m = str;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/enviarmensaje.php");
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("idusu", new StringBody(chat.this.idusu + ""));
                multipartEntity.addPart("idapp", new StringBody("3008836"));
                multipartEntity.addPart("nombre", new StringBody(URLEncoder.encode(chat.this.settings.getString("nombre", ""), "UTF-8")));
                multipartEntity.addPart("m", new StringBody(URLEncoder.encode(this.m, "UTF-8")));
                httpPost.setEntity(multipartEntity);
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpPost).getEntity().getContent(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return sb.toString();
                    }
                    sb.append(readLine);
                }
            } catch (Exception unused) {
                return "ANDROID:KO";
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            AlertDialog.Builder builder = new AlertDialog.Builder(chat.this);
            try {
                chat.this.findViewById(R.id.pb_chat_env).setVisibility(8);
                ((EditText) chat.this.findViewById(R.id.c_mensaje)).setTextColor(ViewCompat.MEASURED_STATE_MASK);
            } catch (Exception unused) {
            }
            if (str.indexOf("ANDROID:OK") == -1 && str.indexOf("ANDROID:KO") == -1) {
                final AlertDialog create = builder.setCancelable(false).setPositiveButton(chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.error_http).create();
                if (!chat.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused2) {
                }
            } else if (str.indexOf("ANDROID:OK") != -1) {
                ((EditText) chat.this.findViewById(R.id.c_mensaje)).setText("");
                SharedPreferences.Editor edit = chat.this.settings.edit();
                String string = chat.this.settings.getString("conv", "");
                edit.putString("conv", string + "@" + chat.this.idusu + "@" + this.m);
                StringBuilder sb = new StringBuilder();
                sb.append(chat.this.idusu);
                sb.append("");
                edit.putString("f_id", sb.toString());
                edit.putString("f_frase", this.m);
                edit.putString("f_idfrase", config.idfrase_global + "");
                config.idfrase_global = config.idfrase_global + 1;
                edit.commit();
                if (chat.this.settings.getBoolean("primer_msg_chat", true)) {
                    edit.putBoolean("primer_msg_chat", false);
                    edit.commit();
                    final AlertDialog create2 = builder.setCancelable(false).setPositiveButton(chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.primer_msg_chat).create();
                    if (!chat.this.cbtn.equals("")) {
                        create2.setOnShowListener(new DialogInterface.OnShowListener() {
                            public void onShow(DialogInterface dialogInterface) {
                                Button button = create2.getButton(-1);
                                button.setTextColor(Color.parseColor("#" + chat.this.cbtn));
                            }
                        });
                    }
                    create2.show();
                    ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                }
            } else if (str.indexOf("ANDROID:KO MOTIVO:NOGCM") != -1) {
                final AlertDialog create3 = builder.setCancelable(false).setPositiveButton(chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.nogcm).create();
                if (!chat.this.cbtn.equals("")) {
                    create3.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create3.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat.this.cbtn));
                        }
                    });
                }
                create3.show();
                ((TextView) create3.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } else {
                final AlertDialog create4 = builder.setCancelable(false).setPositiveButton(chat.this.getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(R.string.error_http).create();
                if (!chat.this.cbtn.equals("")) {
                    create4.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create4.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + chat.this.cbtn));
                        }
                    });
                }
                create4.show();
                ((TextView) create4.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
        }
    }

    public void onResume() {
        Anuncios anuncios;
        Anuncios anuncios2;
        super.onResume();
        config.onResume_global(this);
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putBoolean("activa", true);
        edit.commit();
        this.settings.registerOnSharedPreferenceChangeListener(this);
        if (!(this.globales.admob_pos == 0 || (anuncios2 = this.anun) == null || anuncios2.adView == null)) {
            this.anun.adView.resume();
        }
        if (this.globales.admob_pos != 0 && (anuncios = this.anun) != null && anuncios.wortiseBanner != null) {
            this.anun.wortiseBanner.resume();
        }
    }

    /* access modifiers changed from: package-private */
    public void finalizar() {
        SharedPreferences.Editor edit = this.settings.edit();
        edit.putBoolean("activa", false);
        edit.commit();
        this.settings.unregisterOnSharedPreferenceChangeListener(this);
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
        finalizar();
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
                if (!chat.this.globales.admob_rew_failed(context, chat.this.mAd_appnext)) {
                    chat.this.dialog_cargando.cancel();
                    chat chat = chat.this;
                    chat.abrir_secc(chat.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                chat.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        chat.this.abrir_secc(chat.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (chat.this.mAd_visto) {
                            chat.this.abrir_secc(chat.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        chat.this.mAd_visto = true;
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
                if (chat.this.mAd_visto) {
                    chat chat = chat.this;
                    chat.abrir_secc(chat.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
