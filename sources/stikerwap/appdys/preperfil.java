package stikerwap.appdys;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignUnit;

public class preperfil extends Activity_ext_class implements Activity_ext, View.OnClickListener {
    boolean desde_buscusus = false;
    boolean desde_buscvideos = false;
    boolean desde_foro = false;
    boolean desde_game = false;
    boolean desde_main;
    boolean desde_main_oblig;
    boolean desde_px = false;
    boolean desde_quiz = false;
    boolean desde_radio = false;
    boolean desde_video = false;
    boolean desde_vistafb = false;
    /* access modifiers changed from: private */
    public ProgressDialog dialog_enviando;
    boolean externo;
    Bundle extras;
    config globales;
    int idsecc;
    long idusu;
    int ind;
    ListView mDrawerList;
    boolean nocompletar = false;
    SharedPreferences sp;

    public void abrir_secc(View view) {
    }

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        boolean z;
        Bundle bundle2 = bundle;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        this.ind = this.globales.ind_secc_sel_2;
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (bundle2 == null) {
            this.es_root = extras2 != null && extras2.containsKey("es_root") && this.extras.getBoolean("es_root", false);
        } else {
            this.es_root = bundle2.containsKey("es_root") && bundle2.getBoolean("es_root", false);
        }
        this.externo = this.extras.containsKey("externo");
        this.desde_main = this.extras.getBoolean("desde_main", false);
        this.desde_main_oblig = this.extras.getBoolean("desde_main_oblig", false);
        if (this.desde_main) {
            str2 = this.globales.c1c;
            str = this.globales.c2c;
            this.idsecc = 0;
        } else if (this.externo) {
            str2 = this.globales.secciones_a[this.ind].c1;
            str = this.globales.secciones_a[this.ind].c2;
        } else {
            this.idsecc = this.extras.getInt("idsecc");
            str2 = this.globales.secciones_a[this.ind].c1;
            str = this.globales.secciones_a[this.ind].c2;
        }
        boolean esClaro = config.esClaro("#" + str2);
        this.cbtn = config.aplicar_color_dialog(str2, this.globales.c_icos);
        if (!esClaro) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.preperfil);
        incluir_menu_pre();
        SearchManager searchManager = (SearchManager) getSystemService("search");
        searchManager.setOnCancelListener(new SearchManager.OnCancelListener() {
            public void onCancel() {
                preperfil.this.finalizar = false;
                preperfil.this.setResult(0);
            }
        });
        searchManager.setOnDismissListener(new SearchManager.OnDismissListener() {
            public void onDismiss() {
                preperfil.this.buscador_on = false;
            }
        });
        this.nocompletar = this.extras.getBoolean("nocompletar", false);
        this.desde_buscusus = this.extras.getBoolean("desde_buscusus", false);
        this.desde_buscvideos = this.extras.getBoolean("desde_buscvideos", false);
        this.desde_foro = this.extras.getBoolean("desde_foro", false);
        this.desde_game = this.extras.getBoolean("desde_game", false);
        this.desde_px = this.extras.getBoolean("desde_px", false);
        String str4 = "desde_main_oblig";
        this.desde_video = this.extras.getBoolean("desde_video", false);
        String str5 = "desde_main";
        this.desde_radio = this.extras.getBoolean("desde_radio", false);
        String str6 = "es_root";
        this.desde_quiz = this.extras.getBoolean("desde_quiz", false);
        String str7 = "desde_quiz";
        this.desde_vistafb = this.extras.getBoolean("desde_vistafb", false);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.sp = sharedPreferences;
        String str8 = "desde_radio";
        String str9 = "desde_video";
        this.idusu = sharedPreferences.getLong("idusu", 0);
        if (!str2.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            str3 = "desde_vistafb";
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + str2), Color.parseColor("#" + str)}));
        } else {
            str3 = "desde_vistafb";
        }
        if (!this.sp.getString("nick", "").equals("")) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.dialog_enviando = progressDialog;
            progressDialog.setMessage(getString(R.string.recuperando));
            this.dialog_enviando.setIndeterminate(true);
            if (Build.VERSION.SDK_INT > 20) {
                this.dialog_enviando.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        config.progress_color((ProgressBar) preperfil.this.dialog_enviando.findViewById(16908301), preperfil.this.globales.c_icos);
                    }
                });
            }
            this.dialog_enviando.show();
            new cargarperfilTask().execute(new String[0]);
            return;
        }
        Intent intent = new Intent(this, chat_perfil.class);
        if (this.externo) {
            intent = config.completar_externo(intent, this.extras);
        } else {
            intent.putExtra("idsecc", this.idsecc);
        }
        intent.putExtra("nocompletar", this.nocompletar);
        intent.putExtra("desde_buscusus", this.desde_buscusus);
        intent.putExtra("desde_buscvideos", this.desde_buscvideos);
        intent.putExtra("desde_foro", this.desde_foro);
        intent.putExtra("desde_game", this.desde_game);
        intent.putExtra("desde_px", this.desde_px);
        intent.putExtra(str9, this.desde_video);
        intent.putExtra(str8, this.desde_radio);
        intent.putExtra(str7, this.desde_quiz);
        intent.putExtra(str3, this.desde_vistafb);
        if ((this.desde_main || this.globales.tipomenu == 2) && !this.desde_main_oblig) {
            z = true;
        } else {
            z = true;
            intent.putExtra(str6, true);
        }
        this.es_root = false;
        intent.putExtra(str5, this.desde_main);
        intent.putExtra(str4, this.desde_main_oblig);
        this.finalizar = z;
        Intent intent2 = new Intent();
        intent2.putExtra("finalizar", z);
        setResult(-1, intent2);
        startActivityForResult(intent, 0);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void mostrar_error(int i) {
        int i2 = i == 3 ? R.string.perfil_desactivado : R.string.error_http;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false).setPositiveButton(getString(R.string.aceptar), (DialogInterface.OnClickListener) null).setMessage(i2);
        try {
            final AlertDialog create = builder.create();
            if (!this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + preperfil.this.cbtn));
                    }
                });
            }
            create.show();
            ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bajar_foto(int r5, java.lang.String r6) {
        /*
            r4 = this;
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x002e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x002e }
            r1.<init>()     // Catch:{ MalformedURLException -> 0x002e }
            java.lang.String r2 = stikerwap.appdys.config.DOM_CDN     // Catch:{ MalformedURLException -> 0x002e }
            r1.append(r2)     // Catch:{ MalformedURLException -> 0x002e }
            java.lang.String r2 = "/srv/imgs/usus/"
            r1.append(r2)     // Catch:{ MalformedURLException -> 0x002e }
            long r2 = r4.idusu     // Catch:{ MalformedURLException -> 0x002e }
            r1.append(r2)     // Catch:{ MalformedURLException -> 0x002e }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ MalformedURLException -> 0x002e }
            r1.append(r5)     // Catch:{ MalformedURLException -> 0x002e }
            java.lang.String r2 = ".jpg?v="
            r1.append(r2)     // Catch:{ MalformedURLException -> 0x002e }
            r1.append(r6)     // Catch:{ MalformedURLException -> 0x002e }
            java.lang.String r6 = r1.toString()     // Catch:{ MalformedURLException -> 0x002e }
            r0.<init>(r6)     // Catch:{ MalformedURLException -> 0x002e }
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            java.net.URLConnection r6 = r0.openConnection()     // Catch:{  }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{  }
            r0 = 1
            r6.setDoInput(r0)     // Catch:{  }
            r0 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r0)     // Catch:{  }
            r0 = 20000(0x4e20, float:2.8026E-41)
            r6.setReadTimeout(r0)     // Catch:{  }
            r6.connect()     // Catch:{  }
            java.io.InputStream r0 = r6.getInputStream()     // Catch:{  }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{  }
            r0.close()     // Catch:{  }
            r6.disconnect()     // Catch:{  }
            stikerwap.appdys.config r6 = r4.globales     // Catch:{  }
            java.io.File r5 = r6.getTempFile(r4, r5)     // Catch:{  }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0066 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0066 }
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0066 }
            r0 = 100
            r1.compress(r5, r0, r6)     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preperfil.bajar_foto(int, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        config config = this.globales;
        if (config != null && config.onActivityResult_glob(i, i2, intent, this)) {
            return;
        }
        if (i2 != -1) {
            finish();
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

    private class cargarperfilTask extends AsyncTask<String, Void, Byte> {
        private cargarperfilTask() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0186, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0180 */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0186  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x018c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r15) {
            /*
                r14 = this;
                java.lang.String r15 = ";"
                r0 = 2
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0180 }
                r2.<init>()     // Catch:{ Exception -> 0x0180 }
                java.lang.String r3 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x0180 }
                r2.append(r3)     // Catch:{ Exception -> 0x0180 }
                java.lang.String r3 = "/srv/obtener_perfil.php?v=1&idusu="
                r2.append(r3)     // Catch:{ Exception -> 0x0180 }
                stikerwap.appdys.preperfil r3 = stikerwap.appdys.preperfil.this     // Catch:{ Exception -> 0x0180 }
                long r3 = r3.idusu     // Catch:{ Exception -> 0x0180 }
                r2.append(r3)     // Catch:{ Exception -> 0x0180 }
                java.lang.String r3 = "&c="
                r2.append(r3)     // Catch:{ Exception -> 0x0180 }
                stikerwap.appdys.preperfil r3 = stikerwap.appdys.preperfil.this     // Catch:{ Exception -> 0x0180 }
                android.content.SharedPreferences r3 = r3.sp     // Catch:{ Exception -> 0x0180 }
                java.lang.String r4 = "cod"
                java.lang.String r5 = ""
                java.lang.String r3 = r3.getString(r4, r5)     // Catch:{ Exception -> 0x0180 }
                r2.append(r3)     // Catch:{ Exception -> 0x0180 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0180 }
                java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0180 }
                r3.<init>(r2)     // Catch:{ Exception -> 0x0180 }
                java.net.URLConnection r2 = r3.openConnection()     // Catch:{ Exception -> 0x0180 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0180 }
                r1 = 1
                r2.setDoInput(r1)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r3 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r3 = "User-Agent"
                java.lang.String r4 = "Android Vinebre Software"
                r2.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.io.InputStream r3 = r2.getInputStream()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r5.<init>(r3)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r3.<init>()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
            L_0x0063:
                java.lang.String r5 = r4.readLine()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                if (r5 == 0) goto L_0x007e
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r6.<init>()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r6.append(r5)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r5 = "\n"
                r6.append(r5)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r3.append(r5)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                goto L_0x0063
            L_0x007e:
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "ANDROID:PERFILKO"
                int r4 = r3.indexOf(r4)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r5 = -1
                if (r4 == r5) goto L_0x0096
                r15 = 3
                java.lang.Byte r15 = java.lang.Byte.valueOf(r15)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                if (r2 == 0) goto L_0x0095
                r2.disconnect()
            L_0x0095:
                return r15
            L_0x0096:
                java.lang.String r4 = "ANDROID:OK"
                int r4 = r3.indexOf(r4)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                if (r4 != r5) goto L_0x00a8
                java.lang.Byte r15 = java.lang.Byte.valueOf(r0)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                if (r2 == 0) goto L_0x00a7
                r2.disconnect()
            L_0x00a7:
                return r15
            L_0x00a8:
                java.lang.String r4 = "DATOSUSU:"
                int r4 = r3.indexOf(r4)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r4 = r4 + 9
                int r5 = r3.indexOf(r15, r4)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = r3.substring(r4, r5)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r5 = r5 + r1
                int r6 = r3.indexOf(r15, r5)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r5 = r3.substring(r5, r6)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r6 = r6 + r1
                int r7 = r3.indexOf(r15, r6)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r6 = r3.substring(r6, r7)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r7 = r7 + r1
                int r8 = r3.indexOf(r15, r7)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r7 = r3.substring(r7, r8)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r8 = r8 + r1
                int r9 = r3.indexOf(r15, r8)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r8 = r3.substring(r8, r9)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r9 = r9 + r1
                int r10 = r3.indexOf(r15, r9)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r9 = r3.substring(r9, r10)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r10 = r10 + r1
                int r11 = r3.indexOf(r15, r10)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r10 = r3.substring(r10, r11)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r11 = r11 + r1
                int r12 = r3.indexOf(r15, r11)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r11 = r3.substring(r11, r12)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r12 = r12 + r1
                int r13 = r3.indexOf(r15, r12)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r12 = r3.substring(r12, r13)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                int r13 = r13 + r1
                int r15 = r3.indexOf(r15, r13)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r15 = r3.substring(r13, r15)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                stikerwap.appdys.preperfil r3 = stikerwap.appdys.preperfil.this     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                android.content.SharedPreferences r3 = r3.sp     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r13 = "nick"
                r3.putString(r13, r4)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "privados"
                r3.putInt(r4, r6)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "fnac_d"
                r3.putInt(r4, r7)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "fnac_m"
                r3.putInt(r4, r8)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "fnac_a"
                r3.putInt(r4, r9)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "sexo"
                r3.putInt(r4, r10)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "coments"
                r3.putInt(r4, r11)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r4 = "descr"
                r3.putString(r4, r12)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r3.commit()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.lang.String r3 = "1"
                boolean r3 = r5.equals(r3)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                if (r3 == 0) goto L_0x0162
                stikerwap.appdys.preperfil r3 = stikerwap.appdys.preperfil.this     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r3.bajar_foto(r1, r15)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                goto L_0x016f
            L_0x0162:
                stikerwap.appdys.preperfil r15 = stikerwap.appdys.preperfil.this     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                stikerwap.appdys.config r15 = r15.globales     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                stikerwap.appdys.preperfil r3 = stikerwap.appdys.preperfil.this     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                java.io.File r15 = r15.getTempFile(r3, r1)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                r15.delete()     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
            L_0x016f:
                java.lang.Byte r15 = java.lang.Byte.valueOf(r1)     // Catch:{ Exception -> 0x017c, all -> 0x0179 }
                if (r2 == 0) goto L_0x0178
                r2.disconnect()
            L_0x0178:
                return r15
            L_0x0179:
                r15 = move-exception
                r1 = r2
                goto L_0x018a
            L_0x017c:
                r1 = r2
                goto L_0x0180
            L_0x017e:
                r15 = move-exception
                goto L_0x018a
            L_0x0180:
                java.lang.Byte r15 = java.lang.Byte.valueOf(r0)     // Catch:{ all -> 0x017e }
                if (r1 == 0) goto L_0x0189
                r1.disconnect()
            L_0x0189:
                return r15
            L_0x018a:
                if (r1 == 0) goto L_0x018f
                r1.disconnect()
            L_0x018f:
                goto L_0x0191
            L_0x0190:
                throw r15
            L_0x0191:
                goto L_0x0190
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.preperfil.cargarperfilTask.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            try {
                preperfil.this.dialog_enviando.dismiss();
            } catch (Exception unused) {
            }
            if (b.byteValue() == 1) {
                Intent intent = new Intent(preperfil.this, chat_perfil.class);
                if (preperfil.this.externo) {
                    intent = config.completar_externo(intent, preperfil.this.extras);
                } else {
                    intent.putExtra("idsecc", preperfil.this.idsecc);
                }
                intent.putExtra("nocompletar", preperfil.this.nocompletar);
                intent.putExtra("desde_buscusus", preperfil.this.desde_buscusus);
                intent.putExtra("desde_buscvideos", preperfil.this.desde_buscvideos);
                intent.putExtra("desde_foro", preperfil.this.desde_foro);
                intent.putExtra("desde_game", preperfil.this.desde_game);
                intent.putExtra("desde_px", preperfil.this.desde_px);
                intent.putExtra("desde_video", preperfil.this.desde_video);
                intent.putExtra("desde_radio", preperfil.this.desde_radio);
                intent.putExtra("desde_quiz", preperfil.this.desde_quiz);
                intent.putExtra("desde_vistafb", preperfil.this.desde_vistafb);
                intent.putExtra("desde_main", preperfil.this.desde_main);
                intent.putExtra("desde_main_oblig", preperfil.this.desde_main_oblig);
                preperfil.this.startActivityForResult(intent, 0);
            } else if (b.byteValue() == 3) {
                preperfil.this.mostrar_error(3);
            } else {
                preperfil.this.mostrar_error(2);
            }
        }
    }

    public void onClick(View view) {
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

    public void onStop() {
        super.onStop();
        if (this.finalizar && !this.buscador_on) {
            finish();
        }
    }

    public void onDestroy() {
        if ((this.es_root && isFinishing()) || config.finalizar_app) {
            config.finalizar_app(this);
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((LinearLayout) findViewById(R.id.ll_princ)).removeViewAt(0);
        incluir_menu_pre();
    }
}
