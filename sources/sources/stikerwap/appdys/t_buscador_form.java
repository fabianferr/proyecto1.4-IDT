package stikerwap.appdys;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.DialogFragment;
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
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class t_buscador_form extends FragmentActivity_ext_class implements Activity_ext, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, RewardedVideoAdListener, OnAdLoaded, OnAdClosed, OnVideoEnded, OnAdError, VideoListener, AdEventListener {
    static int anyo;
    static TextView c_busc_antiguedad_st;
    static int dia;
    static ImageView iv_antiguedad_limpiar_st;
    static int mes;
    static TableLayout tl_busc_antiguedad_st;
    Anuncios anun;
    boolean atras_pulsado = false;
    Bundle extras;
    config globales;
    int[] id_cats_a;
    int[] id_orden_a;
    int idcat = 0;
    boolean mAd_visto = false;
    ListView mDrawerList;
    SharedPreferences settings;

    public void onAdClicked(Ad ad) {
    }

    public void onLoggingImpression(Ad ad) {
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        Bundle bundle2 = bundle;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        establec_ralc(this);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        int i3 = 1;
        if (bundle2 == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle2.containsKey("es_root") && bundle2.getBoolean("es_root", false);
        }
        this.cbtn = config.aplicar_color_dialog(this.globales.c1_prods, this.globales.c_icos_prods);
        if (!config.esClaro("#" + this.globales.c1_prods)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.t_buscador_form);
        incluir_menu_pre();
        this.globales.onCreate_global(this, true);
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                t_buscador_form.this.finalizar = false;
                t_buscador_form.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                t_buscador_form.this.buscador_on = false;
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
        getWindow().setSoftInputMode(2);
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
        c_busc_antiguedad_st = (TextView) findViewById(R.id.c_busc_antiguedad);
        tl_busc_antiguedad_st = (TableLayout) findViewById(R.id.tl_busc_antiguedad);
        iv_antiguedad_limpiar_st = (ImageView) findViewById(R.id.iv_antiguedad_limpiar);
        if (!this.globales.prods_tit.equals("")) {
            ((TextView) findViewById(R.id.tv_tit)).setText(this.globales.prods_tit);
        }
        if (!this.globales.c_tit_prods.equals("")) {
            ((TextView) findViewById(R.id.tv_tit)).setTextColor(Color.parseColor("#" + this.globales.c_tit_prods));
        }
        if (!this.globales.c_sep_prods.equals("")) {
            View findViewById = findViewById(R.id.v_sep);
            findViewById.setBackgroundColor(Color.parseColor("#" + this.globales.c_sep_prods));
        }
        if (!this.globales.c_ico_sep_prods.equals("")) {
            Drawable drawable = getResources().getDrawable(R.drawable.search_white);
            drawable.setColorFilter(Color.parseColor("#" + this.globales.c_ico_sep_prods), PorterDuff.Mode.MULTIPLY);
            ((ImageView) findViewById(R.id.iv_search)).setImageDrawable(drawable);
        }
        if (!this.globales.c_txt_prods.equals("")) {
            int parseColor = Color.parseColor("#" + this.globales.c_txt_prods);
            ((TextView) findViewById(R.id.tv_busc_texto)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_busc_cat)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.c_busc_cat)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_busc_precio)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_busc_antiguedad)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.c_busc_antiguedad)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.tv_busc_orden)).setTextColor(parseColor);
            ((TextView) findViewById(R.id.busc_divisa)).setTextColor(parseColor);
            if (Build.VERSION.SDK_INT > 20) {
                config.edittext_color((EditText) findViewById(R.id.c_busc_texto), Boolean.valueOf(config.esClaro("#" + this.globales.c_txt_prods)), this.globales.c_icos_2_prods);
                config.edittext_color((EditText) findViewById(R.id.c_busc_precio), Boolean.valueOf(config.esClaro("#" + this.globales.c_txt_prods)), this.globales.c_icos_2_prods);
            }
        }
        if (this.globales.busc_texto) {
            findViewById(R.id.tr_texto).setVisibility(0);
        }
        if (this.globales.busc_cat) {
            SQLiteDatabase readableDatabase = new bd(getApplicationContext()).getReadableDatabase();
            Cursor rawQuery = readableDatabase.rawQuery("SELECT _id FROM cats WHERE idcat>0 LIMIT 1", (String[]) null);
            if (rawQuery.moveToFirst()) {
                findViewById(R.id.c_busc_cat).setVisibility(0);
                ImageView imageView = (ImageView) findViewById(R.id.iv_cat);
                Drawable drawable2 = getResources().getDrawable(R.drawable.tree);
                drawable2.setColorFilter(Color.parseColor("#" + this.globales.c_icos_prods), PorterDuff.Mode.MULTIPLY);
                imageView.setImageDrawable(drawable2);
                imageView.setOnClickListener(this);
                imageView.setVisibility(0);
                ImageView imageView2 = (ImageView) findViewById(R.id.iv_cat_limpiar);
                Drawable drawable3 = getResources().getDrawable(R.drawable.reload);
                drawable3.setColorFilter(Color.parseColor("#" + this.globales.c_icos_2_prods), PorterDuff.Mode.MULTIPLY);
                imageView2.setImageDrawable(drawable3);
                imageView2.setOnClickListener(this);
                findViewById(R.id.tl_busc_cat).setOnClickListener(this);
            } else {
                Spinner spinner = (Spinner) findViewById(R.id.sp_busc_cat);
                rawQuery = readableDatabase.rawQuery("SELECT * FROM cats ORDER BY descr", (String[]) null);
                if (rawQuery.moveToFirst()) {
                    CharSequence[] charSequenceArr = new CharSequence[(rawQuery.getCount() + 1)];
                    charSequenceArr[0] = getResources().getString(R.string.todo);
                    int[] iArr = new int[(rawQuery.getCount() + 1)];
                    this.id_cats_a = iArr;
                    iArr[0] = 0;
                    while (!rawQuery.isAfterLast()) {
                        charSequenceArr[rawQuery.getPosition() + i3] = rawQuery.getString(rawQuery.getColumnIndex("descr"));
                        this.id_cats_a[rawQuery.getPosition() + i3] = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                        rawQuery.moveToNext();
                        i3 = 1;
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, new ArrayList(Arrays.asList(charSequenceArr)));
                    arrayAdapter.setDropDownViewResource(17367049);
                    spinner.setAdapter(arrayAdapter);
                    spinner.setVisibility(0);
                    findViewById(R.id.iv_cat).setVisibility(8);
                }
            }
            rawQuery.close();
            readableDatabase.close();
            findViewById(R.id.tr_cat).setVisibility(0);
        }
        if (this.globales.busc_precio) {
            ((TextView) findViewById(R.id.busc_divisa)).setText(Html.fromHtml(this.globales.divisa));
            findViewById(R.id.tr_precio).setVisibility(0);
        }
        if (this.globales.busc_antiguedad) {
            ImageView imageView3 = (ImageView) findViewById(R.id.iv_antiguedad);
            Drawable drawable4 = getResources().getDrawable(R.drawable.calendar);
            drawable4.setColorFilter(Color.parseColor("#" + this.globales.c_icos_prods), PorterDuff.Mode.MULTIPLY);
            imageView3.setImageDrawable(drawable4);
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.iv_antiguedad_limpiar);
            Drawable drawable5 = getResources().getDrawable(R.drawable.reload);
            drawable5.setColorFilter(Color.parseColor("#" + this.globales.c_icos_2_prods), PorterDuff.Mode.MULTIPLY);
            imageView4.setImageDrawable(drawable5);
            imageView4.setOnClickListener(this);
            findViewById(R.id.tl_busc_antiguedad).setOnClickListener(this);
            findViewById(R.id.tr_antiguedad).setVisibility(0);
        }
        if (this.globales.ord_texto || this.globales.ord_precio || this.globales.ord_antiguedad) {
            Spinner spinner2 = (Spinner) findViewById(R.id.c_busc_orden);
            int i4 = this.globales.ord_texto;
            if (this.globales.ord_precio) {
                i4++;
            }
            if (this.globales.ord_antiguedad) {
                i4++;
            }
            CharSequence[] charSequenceArr2 = new CharSequence[i4];
            this.id_orden_a = new int[i4];
            if (this.globales.ord_texto) {
                charSequenceArr2[0] = getString(R.string.titulo);
                this.id_orden_a[0] = 1;
                this.globales.ord_def.indexOf("TITULO");
                i = 1;
            } else {
                i = 0;
            }
            if (this.globales.ord_precio) {
                charSequenceArr2[i] = getString(R.string.precio);
                this.id_orden_a[i] = 2;
                i2 = this.globales.ord_def.indexOf("PRECIO") != -1 ? i : 0;
                i++;
            } else {
                i2 = 0;
            }
            if (this.globales.ord_antiguedad) {
                charSequenceArr2[i] = getString(R.string.antiguedad);
                this.id_orden_a[i] = 3;
                if (this.globales.ord_def.indexOf("FANTIGUEDAD") != -1) {
                    i2 = i;
                }
            }
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, 17367048, new ArrayList(Arrays.asList(charSequenceArr2)));
            arrayAdapter2.setDropDownViewResource(17367049);
            spinner2.setAdapter(arrayAdapter2);
            spinner2.setSelection(i2);
            ((ToggleButton) findViewById(R.id.togglebutton)).setChecked(this.globales.ord_def.contains("ASC"));
            findViewById(R.id.tr_orden).setVisibility(0);
        }
        if (config.esClaro("#" + this.globales.c_icos_2_prods)) {
            findViewById(R.id.iv_btn_fondo_n).setVisibility(0);
        } else {
            findViewById(R.id.iv_btn_fondo_b).setVisibility(0);
        }
        Drawable drawable6 = getResources().getDrawable(R.drawable.buscar_btn);
        drawable6.setColorFilter(Color.parseColor("#" + this.globales.c_icos_2_prods), PorterDuff.Mode.MULTIPLY);
        ImageView imageView5 = (ImageView) findViewById(R.id.button1);
        imageView5.setImageDrawable(drawable6);
        imageView5.setOnClickListener(this);
        if (!this.globales.c1_prods.equals("") && !this.globales.c2_prods.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.globales.c1_prods), Color.parseColor("#" + this.globales.c2_prods)}));
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

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        public Dialog onCreateDialog(Bundle bundle) {
            int i;
            int i2;
            int i3;
            Calendar instance = Calendar.getInstance();
            if (t_buscador_form.dia == 0) {
                i3 = instance.get(1);
                i2 = instance.get(2);
                i = instance.get(5);
            } else {
                i3 = t_buscador_form.anyo;
                i2 = t_buscador_form.mes;
                i = t_buscador_form.dia;
            }
            int i4 = i3;
            int i5 = i2;
            return new DatePickerDialog(getActivity(), this, i4, i5, i);
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Date date;
            boolean z;
            t_buscador_form.dia = i3;
            t_buscador_form.mes = i2;
            t_buscador_form.anyo = i;
            try {
                DateFormat dateInstance = DateFormat.getDateInstance(3, Locale.US);
                StringBuilder sb = new StringBuilder();
                z = true;
                sb.append(t_buscador_form.mes + 1);
                sb.append("/");
                sb.append(t_buscador_form.dia);
                sb.append("/");
                sb.append(t_buscador_form.anyo);
                date = dateInstance.parse(sb.toString());
            } catch (Exception unused) {
                date = null;
                z = false;
            }
            t_buscador_form.c_busc_antiguedad_st.setText(z ? DateFormat.getDateInstance().format(date) : "");
            t_buscador_form.tl_busc_antiguedad_st.setVisibility(0);
            t_buscador_form.iv_antiguedad_limpiar_st.setVisibility(0);
        }
    }

    public void onClick(View view) {
        int i = 1;
        if (view.getId() == R.id.button1) {
            Intent intent = new Intent(this, t_buscador.class);
            if (this.globales.busc_texto) {
                intent.putExtra("texto", ((EditText) findViewById(R.id.c_busc_texto)).getText().toString());
            }
            if (this.globales.busc_cat) {
                Spinner spinner = (Spinner) findViewById(R.id.sp_busc_cat);
                if (spinner.getVisibility() == 0) {
                    intent.putExtra("idcat", this.id_cats_a[spinner.getSelectedItemPosition()]);
                } else {
                    intent.putExtra("idcat", this.idcat);
                }
            }
            if (this.globales.busc_precio) {
                intent.putExtra("precio", ((EditText) findViewById(R.id.c_busc_precio)).getText().toString());
            }
            if (this.globales.busc_antiguedad) {
                intent.putExtra("dia", dia);
                intent.putExtra("mes", mes + 1);
                intent.putExtra("anyo", anyo);
            }
            if (this.globales.ord_texto || this.globales.ord_precio || this.globales.ord_antiguedad) {
                intent.putExtra("orden", this.id_orden_a[((Spinner) findViewById(R.id.c_busc_orden)).getSelectedItemPosition()]);
                intent.putExtra("orden_tipo", ((ToggleButton) findViewById(R.id.togglebutton)).isChecked());
            } else {
                if (this.globales.ord_def.indexOf("TITULO") == -1) {
                    i = this.globales.ord_def.indexOf("PRECIO") != -1 ? 2 : 3;
                }
                intent.putExtra("orden", i);
                intent.putExtra("orden_tipo", this.globales.ord_def.contains("ASC"));
            }
            startActivityForResult(intent, 0);
        } else if (view.getId() == R.id.iv_cat || view.getId() == R.id.tl_busc_cat) {
            startActivityForResult(new Intent(this, cats.class), 0);
        } else if (view.getId() == R.id.iv_cat_limpiar) {
            this.idcat = 0;
            findViewById(R.id.tl_busc_cat).setVisibility(8);
            ((TextView) findViewById(R.id.c_busc_cat)).setText("");
            ((ImageView) findViewById(R.id.iv_cat_limpiar)).setVisibility(8);
        } else if (view.getId() == R.id.iv_antiguedad || view.getId() == R.id.tl_busc_antiguedad) {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.setCancelable(true);
            datePickerFragment.show(getSupportFragmentManager(), "datePicker");
        } else if (view.getId() == R.id.iv_antiguedad_limpiar) {
            dia = 0;
            mes = 0;
            anyo = 0;
            findViewById(R.id.tl_busc_antiguedad).setVisibility(8);
            ((TextView) findViewById(R.id.c_busc_antiguedad)).setText("");
            ((ImageView) findViewById(R.id.iv_antiguedad_limpiar)).setVisibility(8);
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if ((config != null && config.onActivityResult_glob(i, i2, intent, this)) || i2 != -1) {
            return;
        }
        if (intent != null && intent.hasExtra("idcat")) {
            Bundle extras2 = intent.getExtras();
            this.idcat = extras2.getInt("idcat", 0);
            ((TextView) findViewById(R.id.c_busc_cat)).setText(extras2.getString("cat"));
            findViewById(R.id.tl_busc_cat).setVisibility(0);
            ((ImageView) findViewById(R.id.iv_cat_limpiar)).setVisibility(0);
        } else if (intent != null && intent.hasExtra("finalizar") && intent.getExtras().getBoolean("finalizar")) {
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
                if (!t_buscador_form.this.globales.admob_rew_failed(context, t_buscador_form.this.mAd_appnext)) {
                    t_buscador_form.this.dialog_cargando.cancel();
                    t_buscador_form t_buscador_form = t_buscador_form.this;
                    t_buscador_form.abrir_secc(t_buscador_form.v_abrir_secc);
                }
            }

            public void onAdLoaded(RewardedAd rewardedAd) {
                t_buscador_form.this.dialog_cargando.cancel();
                rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    public void onAdShowedFullScreenContent() {
                    }

                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        t_buscador_form.this.abrir_secc(t_buscador_form.this.v_abrir_secc);
                    }

                    public void onAdDismissedFullScreenContent() {
                        if (t_buscador_form.this.mAd_visto) {
                            t_buscador_form.this.abrir_secc(t_buscador_form.this.v_abrir_secc);
                        }
                    }
                });
                rewardedAd.show((Activity) context, new OnUserEarnedRewardListener() {
                    public void onUserEarnedReward(RewardItem rewardItem) {
                        t_buscador_form.this.mAd_visto = true;
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
                if (t_buscador_form.this.mAd_visto) {
                    t_buscador_form t_buscador_form = t_buscador_form.this;
                    t_buscador_form.abrir_secc(t_buscador_form.v_abrir_secc);
                }
            }
        });
    }

    public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {
        this.dialog_cargando.cancel();
        abrir_secc(this.v_abrir_secc);
    }
}
