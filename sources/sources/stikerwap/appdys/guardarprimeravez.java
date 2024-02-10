package stikerwap.appdys;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.ProgressBar;
import com.mbridge.msdk.foundation.entity.CampaignUnit;

public class guardarprimeravez extends Activity {
    Activity acti;
    String cbtn;
    boolean desde_main;
    boolean desde_main_oblig;
    ProgressDialog dialog_guardando;
    boolean externo;
    Bundle extras;
    config globales;
    int idsecc;
    long idusu;
    SharedPreferences settings;

    public void onCreate(Bundle bundle) {
        String str;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        this.acti = this;
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        this.externo = extras2 != null && extras2.containsKey("externo");
        Bundle bundle2 = this.extras;
        this.desde_main = bundle2 != null && bundle2.getBoolean("desde_main", false);
        this.desde_main_oblig = this.extras.getBoolean("desde_main_oblig", false);
        if (this.desde_main) {
            str = this.globales.c1c;
            this.idsecc = 0;
        } else if (this.externo) {
            str = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
        } else {
            str = this.globales.secciones_a[this.globales.ind_secc_sel_2].c1;
            this.idsecc = this.extras.getInt("idsecc");
        }
        this.cbtn = config.aplicar_color_dialog(str, this.globales.c_icos);
        if (!config.esClaro("#" + str)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog_guardando = progressDialog;
        progressDialog.setMessage(getString(R.string.guardando));
        this.dialog_guardando.setIndeterminate(true);
        if (Build.VERSION.SDK_INT > 20) {
            this.dialog_guardando.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    config.progress_color((ProgressBar) guardarprimeravez.this.dialog_guardando.findViewById(16908301), guardarprimeravez.this.globales.c_icos);
                }
            });
        }
        this.dialog_guardando.show();
        new guardar().execute(new String[0]);
    }

    private class guardar extends AsyncTask<String, Void, Byte> {
        private guardar() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:29|30|34|35|36|37) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x02db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x02dc */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x02e7 A[Catch:{ Exception -> 0x033c }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0329 A[Catch:{ Exception -> 0x033c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Byte doInBackground(java.lang.String... r25) {
            /*
                r24 = this;
                r1 = r24
                java.lang.String r0 = " TRANS:"
                java.lang.String r2 = " EMAIL:"
                java.lang.String r3 = "y"
                java.lang.String r4 = "coments"
                java.lang.String r5 = "sexo"
                java.lang.String r6 = "fnac_a"
                java.lang.String r7 = "fnac_m"
                java.lang.String r8 = "fnac_d"
                java.lang.String r9 = "contra"
                java.lang.String r10 = "privados"
                java.lang.String r11 = "descr"
                java.lang.String r12 = "x"
                java.lang.String r13 = "cod_g"
                java.lang.String r14 = "UTF-8"
                java.lang.String r15 = ""
                r25 = r0
                java.lang.String r0 = "&idapp=3008836&idl="
                r16 = 2
                r17 = r2
                org.apache.http.params.BasicHttpParams r2 = new org.apache.http.params.BasicHttpParams     // Catch:{ Exception -> 0x033c }
                r2.<init>()     // Catch:{ Exception -> 0x033c }
                r18 = r3
                r3 = 10000(0x2710, float:1.4013E-41)
                org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r2, r3)     // Catch:{ Exception -> 0x033c }
                r3 = 20000(0x4e20, float:2.8026E-41)
                org.apache.http.params.HttpConnectionParams.setSoTimeout(r2, r3)     // Catch:{ Exception -> 0x033c }
                org.apache.http.impl.client.DefaultHttpClient r3 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ Exception -> 0x033c }
                r3.<init>((org.apache.http.params.HttpParams) r2)     // Catch:{ Exception -> 0x033c }
                org.apache.http.client.methods.HttpPost r2 = new org.apache.http.client.methods.HttpPost     // Catch:{ Exception -> 0x033c }
                r19 = r3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r3.<init>()     // Catch:{ Exception -> 0x033c }
                r20 = r12
                java.lang.String r12 = stikerwap.appdys.config.DOM_SRV     // Catch:{ Exception -> 0x033c }
                r3.append(r12)     // Catch:{ Exception -> 0x033c }
                java.lang.String r12 = "/srv/guardar_primeravez.php?idusu="
                r3.append(r12)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r12 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                r21 = r4
                r22 = r5
                long r4 = r12.idusu     // Catch:{ Exception -> 0x033c }
                r3.append(r4)     // Catch:{ Exception -> 0x033c }
                r3.append(r0)     // Catch:{ Exception -> 0x033c }
                java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x033c }
                java.lang.String r0 = r0.getLanguage()     // Catch:{ Exception -> 0x033c }
                r3.append(r0)     // Catch:{ Exception -> 0x033c }
                java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x033c }
                r2.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.MultipartEntity r0 = new org.apache.http.entity.mime.MultipartEntity     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.HttpMultipartMode r3 = org.apache.http.entity.mime.HttpMultipartMode.BROWSER_COMPATIBLE     // Catch:{ Exception -> 0x033c }
                r0.<init>(r3)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = r3.getString(r13, r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = java.net.URLEncoder.encode(r3, r14)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r4 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                r4.<init>(r3)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r13, r4)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                java.lang.String r4 = "nick"
                java.lang.String r3 = r3.getString(r4, r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = java.net.URLEncoder.encode(r3, r14)     // Catch:{ Exception -> 0x033c }
                java.lang.String r4 = "nombre"
                org.apache.http.entity.mime.content.StringBody r5 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                r5.<init>(r3)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r4, r5)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.config r3 = r3.globales     // Catch:{ Exception -> 0x033c }
                int r3 = r3.fb_modo     // Catch:{ Exception -> 0x033c }
                java.lang.String r4 = "email_confirmado"
                r5 = 3
                java.lang.String r12 = "email"
                r23 = r13
                r13 = 0
                if (r3 != r5) goto L_0x00e8
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                boolean r3 = r3.getBoolean(r4, r13)     // Catch:{ Exception -> 0x033c }
                if (r3 != 0) goto L_0x00e8
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = r3.getString(r12, r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = java.net.URLEncoder.encode(r3, r14)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r5 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                r5.<init>(r3)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r12, r5)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.os.Bundle r3 = r3.extras     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = r3.getString(r9, r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = java.net.URLEncoder.encode(r3, r14)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r5 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                r5.<init>(r3)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r9, r5)     // Catch:{ Exception -> 0x033c }
            L_0x00e8:
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = r3.getString(r11, r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r3 = java.net.URLEncoder.encode(r3, r14)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r5 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                r5.<init>(r3)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r11, r5)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r5.<init>()     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r9 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r9 = r9.settings     // Catch:{ Exception -> 0x033c }
                r11 = 1
                int r9 = r9.getInt(r10, r11)     // Catch:{ Exception -> 0x033c }
                r5.append(r9)     // Catch:{ Exception -> 0x033c }
                r5.append(r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x033c }
                r3.<init>(r5)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r10, r3)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r5.<init>()     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r9 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r9 = r9.settings     // Catch:{ Exception -> 0x033c }
                int r9 = r9.getInt(r8, r13)     // Catch:{ Exception -> 0x033c }
                r5.append(r9)     // Catch:{ Exception -> 0x033c }
                r5.append(r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x033c }
                r3.<init>(r5)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r8, r3)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r5.<init>()     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r8 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r8 = r8.settings     // Catch:{ Exception -> 0x033c }
                int r8 = r8.getInt(r7, r13)     // Catch:{ Exception -> 0x033c }
                r5.append(r8)     // Catch:{ Exception -> 0x033c }
                r5.append(r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x033c }
                r3.<init>(r5)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r7, r3)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r5.<init>()     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r7 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r7 = r7.settings     // Catch:{ Exception -> 0x033c }
                int r7 = r7.getInt(r6, r13)     // Catch:{ Exception -> 0x033c }
                r5.append(r7)     // Catch:{ Exception -> 0x033c }
                r5.append(r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x033c }
                r3.<init>(r5)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r6, r3)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r5.<init>()     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r6 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r6 = r6.settings     // Catch:{ Exception -> 0x033c }
                r7 = r22
                int r6 = r6.getInt(r7, r13)     // Catch:{ Exception -> 0x033c }
                r5.append(r6)     // Catch:{ Exception -> 0x033c }
                r5.append(r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x033c }
                r3.<init>(r5)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r7, r3)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r5.<init>()     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r6 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r6 = r6.settings     // Catch:{ Exception -> 0x033c }
                r7 = r21
                int r6 = r6.getInt(r7, r11)     // Catch:{ Exception -> 0x033c }
                r5.append(r6)     // Catch:{ Exception -> 0x033c }
                r5.append(r15)     // Catch:{ Exception -> 0x033c }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x033c }
                r3.<init>(r5)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r7, r3)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                r5 = r20
                java.lang.String r3 = r3.getString(r5, r15)     // Catch:{ Exception -> 0x033c }
                boolean r3 = r3.equals(r15)     // Catch:{ Exception -> 0x033c }
                if (r3 != 0) goto L_0x01ed
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r6 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r6 = r6.settings     // Catch:{ Exception -> 0x033c }
                java.lang.String r6 = r6.getString(r5, r15)     // Catch:{ Exception -> 0x033c }
                r3.<init>(r6)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r5, r3)     // Catch:{ Exception -> 0x033c }
                org.apache.http.entity.mime.content.StringBody r3 = new org.apache.http.entity.mime.content.StringBody     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r5 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r5 = r5.settings     // Catch:{ Exception -> 0x033c }
                r6 = r18
                java.lang.String r5 = r5.getString(r6, r15)     // Catch:{ Exception -> 0x033c }
                r3.<init>(r5)     // Catch:{ Exception -> 0x033c }
                r0.addPart(r6, r3)     // Catch:{ Exception -> 0x033c }
            L_0x01ed:
                r2.setEntity(r0)     // Catch:{ Exception -> 0x033c }
                java.lang.String r0 = "User-Agent"
                java.lang.String r3 = "Android Vinebre Software"
                r2.setHeader(r0, r3)     // Catch:{ Exception -> 0x033c }
                r0 = r19
                org.apache.http.HttpResponse r0 = r0.execute(r2)     // Catch:{ Exception -> 0x033c }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x033c }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x033c }
                org.apache.http.HttpEntity r0 = r0.getEntity()     // Catch:{ Exception -> 0x033c }
                java.io.InputStream r0 = r0.getContent()     // Catch:{ Exception -> 0x033c }
                r3.<init>(r0, r14)     // Catch:{ Exception -> 0x033c }
                r2.<init>(r3)     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r0.<init>()     // Catch:{ Exception -> 0x033c }
            L_0x0214:
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x033c }
                if (r3 == 0) goto L_0x021e
                r0.append(r3)     // Catch:{ Exception -> 0x033c }
                goto L_0x0214
            L_0x021e:
                r2 = r17
                int r3 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                r5 = -1
                if (r3 == r5) goto L_0x0248
                int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                int r2 = r2 + 7
                java.lang.String r3 = "@FINEMAIL@"
                int r3 = r0.indexOf(r3, r2)     // Catch:{ Exception -> 0x033c }
                java.lang.String r2 = r0.substring(r2, r3)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x033c }
                r3.putString(r12, r2)     // Catch:{ Exception -> 0x033c }
                r3.putBoolean(r4, r11)     // Catch:{ Exception -> 0x033c }
                r3.commit()     // Catch:{ Exception -> 0x033c }
            L_0x0248:
                r2 = r25
                int r3 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                if (r3 == r5) goto L_0x02df
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                java.lang.String r4 = "sh"
                android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r13)     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x033c }
                int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                int r2 = r2 + 7
                java.lang.String r4 = "-"
                int r4 = r0.indexOf(r4, r2)     // Catch:{ Exception -> 0x033c }
                java.lang.String r2 = r0.substring(r2, r4)     // Catch:{ Exception -> 0x033c }
                java.lang.String r4 = "@"
                java.lang.String[] r2 = r2.split(r4)     // Catch:{ Exception -> 0x033c }
                r4 = r2[r13]     // Catch:{ Exception -> 0x033c }
                r6 = r2[r11]     // Catch:{ Exception -> 0x033c }
                r2 = r2[r16]     // Catch:{ Exception -> 0x033c }
                java.lang.String r7 = "idusu"
                long r8 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x033c }
                r3.putLong(r7, r8)     // Catch:{ Exception -> 0x033c }
                java.lang.String r7 = "cod"
                r3.putString(r7, r6)     // Catch:{ Exception -> 0x033c }
                r6 = r23
                r3.putString(r6, r2)     // Catch:{ Exception -> 0x033c }
                r3.commit()     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                int r6 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x033c }
                long r6 = (long) r6     // Catch:{ Exception -> 0x033c }
                r3.idusu = r6     // Catch:{ Exception -> 0x033c }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x033c }
                r3.<init>()     // Catch:{ Exception -> 0x033c }
                r3.append(r4)     // Catch:{ Exception -> 0x033c }
                java.lang.String r4 = "@"
                r3.append(r4)     // Catch:{ Exception -> 0x033c }
                r3.append(r2)     // Catch:{ Exception -> 0x033c }
                java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x033c }
                r3 = 0
                stikerwap.appdys.guardarprimeravez r4 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x02dc, all -> 0x02d7 }
                java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x02dc, all -> 0x02d7 }
                java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x02dc, all -> 0x02d7 }
                java.lang.String r7 = "vinebre_ac.txt"
                r6.<init>(r4, r7)     // Catch:{ Exception -> 0x02dc, all -> 0x02d7 }
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x02dc, all -> 0x02d7 }
                r4.<init>(r6)     // Catch:{ Exception -> 0x02dc, all -> 0x02d7 }
                java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x02d5, all -> 0x02d2 }
                java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x02d5, all -> 0x02d2 }
                r6.<init>(r4)     // Catch:{ Exception -> 0x02d5, all -> 0x02d2 }
                r3.<init>(r6)     // Catch:{ Exception -> 0x02d5, all -> 0x02d2 }
                r3.write(r2)     // Catch:{ Exception -> 0x02d5, all -> 0x02d2 }
                r3.close()     // Catch:{ Exception -> 0x02d5, all -> 0x02d2 }
                r4.close()     // Catch:{ Exception -> 0x02df }
                goto L_0x02df
            L_0x02d2:
                r0 = move-exception
                r3 = r4
                goto L_0x02d8
            L_0x02d5:
                r3 = r4
                goto L_0x02dc
            L_0x02d7:
                r0 = move-exception
            L_0x02d8:
                r3.close()     // Catch:{ Exception -> 0x02db }
            L_0x02db:
                throw r0     // Catch:{ Exception -> 0x033c }
            L_0x02dc:
                r3.close()     // Catch:{ Exception -> 0x02df }
            L_0x02df:
                java.lang.String r2 = "ANDROID:OK"
                int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                if (r2 == r5) goto L_0x0329
                java.lang.String r2 = "ANDROID:OK COD:"
                int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                if (r2 == r5) goto L_0x0307
                r2 = 15
                r3 = 21
                java.lang.String r2 = r0.substring(r2, r3)     // Catch:{ Exception -> 0x033c }
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences r3 = r3.settings     // Catch:{ Exception -> 0x033c }
                android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x033c }
                java.lang.String r4 = "cod"
                r3.putString(r4, r2)     // Catch:{ Exception -> 0x033c }
                r3.commit()     // Catch:{ Exception -> 0x033c }
            L_0x0307:
                java.lang.String r2 = " PEND:1"
                int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                if (r2 == r5) goto L_0x0315
                r2 = 3
                java.lang.Byte r0 = java.lang.Byte.valueOf(r2)     // Catch:{ Exception -> 0x033c }
                return r0
            L_0x0315:
                java.lang.String r2 = " VALID:1"
                int r0 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                if (r0 == r5) goto L_0x0324
                r0 = 11
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ Exception -> 0x033c }
                return r0
            L_0x0324:
                java.lang.Byte r0 = java.lang.Byte.valueOf(r11)     // Catch:{ Exception -> 0x033c }
                return r0
            L_0x0329:
                java.lang.String r2 = "ANDROID:KO -CONTRA-"
                int r0 = r0.indexOf(r2)     // Catch:{ Exception -> 0x033c }
                if (r0 == r5) goto L_0x0337
                r0 = 4
                java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ Exception -> 0x033c }
                return r0
            L_0x0337:
                java.lang.Byte r0 = java.lang.Byte.valueOf(r16)     // Catch:{ Exception -> 0x033c }
                return r0
            L_0x033c:
                java.lang.Byte r0 = java.lang.Byte.valueOf(r16)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.guardarprimeravez.guardar.doInBackground(java.lang.String[]):java.lang.Byte");
        }

        /* JADX WARNING: type inference failed for: r3v41, types: [boolean] */
        /* JADX WARNING: type inference failed for: r3v61 */
        /* JADX WARNING: type inference failed for: r3v62 */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0221  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x024f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.Byte r19) {
            /*
                r18 = this;
                r0 = r18
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x000a }
                android.app.ProgressDialog r1 = r1.dialog_guardando     // Catch:{ Exception -> 0x000a }
                r1.dismiss()     // Catch:{ Exception -> 0x000a }
                goto L_0x000b
            L_0x000a:
            L_0x000b:
                byte r1 = r19.byteValue()
                java.lang.String r2 = "email_confirmado"
                java.lang.String r4 = "idsecc"
                java.lang.String r6 = "desde_vistafb"
                java.lang.String r7 = "desde_quiz"
                java.lang.String r8 = "desde_radio"
                java.lang.String r9 = "desde_video"
                java.lang.String r10 = "desde_px"
                java.lang.String r11 = "desde_game"
                java.lang.String r12 = "desde_foro"
                java.lang.String r13 = "desde_buscvideos"
                java.lang.String r14 = "desde_buscusus"
                java.lang.String r15 = "es_root"
                r5 = 1
                if (r1 == r5) goto L_0x02be
                byte r1 = r19.byteValue()
                r5 = 11
                if (r1 != r5) goto L_0x0034
                goto L_0x02be
            L_0x0034:
                byte r1 = r19.byteValue()
                java.lang.String r5 = "desde_main_oblig"
                java.lang.String r3 = "desde_main"
                r16 = r6
                r6 = 3
                if (r1 != r6) goto L_0x0163
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                int r1 = r1.fb_modo
                if (r1 != r6) goto L_0x0059
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.content.SharedPreferences r1 = r1.settings
                android.content.SharedPreferences$Editor r1 = r1.edit()
                r6 = 0
                r1.putBoolean(r2, r6)
                r1.commit()
                goto L_0x005a
            L_0x0059:
                r6 = 0
            L_0x005a:
                android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x00a9 }
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x00a9 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00a9 }
                android.app.AlertDialog$Builder r1 = r1.setCancelable(r6)     // Catch:{ Exception -> 0x00a9 }
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x00a9 }
                r6 = 2131886114(0x7f120022, float:1.9406798E38)
                java.lang.String r2 = r2.getString(r6)     // Catch:{ Exception -> 0x00a9 }
                stikerwap.appdys.guardarprimeravez$guardar$1 r6 = new stikerwap.appdys.guardarprimeravez$guardar$1     // Catch:{ Exception -> 0x00a9 }
                r6.<init>()     // Catch:{ Exception -> 0x00a9 }
                android.app.AlertDialog$Builder r1 = r1.setPositiveButton(r2, r6)     // Catch:{ Exception -> 0x00a9 }
                r2 = 2131886305(0x7f1200e1, float:1.9407185E38)
                android.app.AlertDialog$Builder r1 = r1.setMessage(r2)     // Catch:{ Exception -> 0x00a9 }
                android.app.AlertDialog r1 = r1.create()     // Catch:{ Exception -> 0x00a9 }
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x00a9 }
                java.lang.String r2 = r2.cbtn     // Catch:{ Exception -> 0x00a9 }
                java.lang.String r6 = ""
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x00a9 }
                if (r2 != 0) goto L_0x0096
                stikerwap.appdys.guardarprimeravez$guardar$2 r2 = new stikerwap.appdys.guardarprimeravez$guardar$2     // Catch:{ Exception -> 0x00a9 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x00a9 }
                r1.setOnShowListener(r2)     // Catch:{ Exception -> 0x00a9 }
            L_0x0096:
                r1.show()     // Catch:{ Exception -> 0x00a9 }
                r2 = 16908299(0x102000b, float:2.387726E-38)
                android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x05ba }
                android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x05ba }
                android.graphics.Typeface r2 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x05ba }
                r1.setTypeface(r2)     // Catch:{ Exception -> 0x05ba }
                goto L_0x05ba
            L_0x00a9:
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.chat_perfil> r6 = stikerwap.appdys.chat_perfil.class
                r1.<init>(r2, r6)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.externo
                if (r2 == 0) goto L_0x00c2
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                android.content.Intent r1 = stikerwap.appdys.config.completar_externo(r1, r2)
                goto L_0x00c9
            L_0x00c2:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                int r2 = r2.idsecc
                r1.putExtra(r4, r2)
            L_0x00c9:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                int r2 = r2.tipomenu
                r4 = 2
                if (r2 != r4) goto L_0x00d8
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.desde_main_oblig
                if (r2 == 0) goto L_0x00dc
            L_0x00d8:
                r2 = 1
                r1.putExtra(r15, r2)
            L_0x00dc:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.desde_main
                r1.putExtra(r3, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.desde_main_oblig
                r1.putExtra(r5, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                if (r2 == 0) goto L_0x0156
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                r3 = 0
                boolean r2 = r2.getBoolean(r14, r3)
                r1.putExtra(r14, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r13, r3)
                r1.putExtra(r13, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r12, r3)
                r1.putExtra(r12, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r11, r3)
                r1.putExtra(r11, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r10, r3)
                r1.putExtra(r10, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r9, r3)
                r1.putExtra(r9, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r8, r3)
                r1.putExtra(r8, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r7, r3)
                r1.putExtra(r7, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                r6 = r16
                boolean r2 = r2.getBoolean(r6, r3)
                r1.putExtra(r6, r2)
            L_0x0156:
                java.lang.String r2 = "nocompletar"
                r3 = 1
                r1.putExtra(r2, r3)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                r2.startActivity(r1)
                goto L_0x05ba
            L_0x0163:
                r6 = r16
                byte r1 = r19.byteValue()
                r2 = 2
                if (r1 != r2) goto L_0x017c
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.content.SharedPreferences r1 = r1.settings
                android.content.SharedPreferences$Editor r1 = r1.edit()
                java.lang.String r2 = "nick"
                r1.remove(r2)
                r1.commit()
            L_0x017c:
                android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x0204 }
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x0204 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0204 }
                r2 = 0
                android.app.AlertDialog$Builder r1 = r1.setCancelable(r2)     // Catch:{ Exception -> 0x0204 }
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x0204 }
                r16 = r6
                r6 = 2131886114(0x7f120022, float:1.9406798E38)
                java.lang.String r2 = r2.getString(r6)     // Catch:{ Exception -> 0x0206 }
                stikerwap.appdys.guardarprimeravez$guardar$3 r6 = new stikerwap.appdys.guardarprimeravez$guardar$3     // Catch:{ Exception -> 0x0206 }
                r6.<init>()     // Catch:{ Exception -> 0x0206 }
                android.app.AlertDialog$Builder r1 = r1.setPositiveButton(r2, r6)     // Catch:{ Exception -> 0x0206 }
                android.app.AlertDialog r1 = r1.create()     // Catch:{ Exception -> 0x0206 }
                byte r2 = r19.byteValue()     // Catch:{ Exception -> 0x0206 }
                r6 = 4
                if (r2 != r6) goto L_0x01cb
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x0206 }
                android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x0206 }
                r6 = 2131886306(0x7f1200e2, float:1.9407187E38)
                java.lang.String r2 = r2.getString(r6)     // Catch:{ Exception -> 0x0206 }
                r1.setMessage(r2)     // Catch:{ Exception -> 0x0206 }
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x0206 }
                android.content.SharedPreferences r2 = r2.settings     // Catch:{ Exception -> 0x0206 }
                android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0206 }
                java.lang.String r6 = "mostrar_recordarcontra"
                r17 = r7
                r7 = 1
                r2.putBoolean(r6, r7)     // Catch:{ Exception -> 0x0208 }
                r2.commit()     // Catch:{ Exception -> 0x0208 }
                goto L_0x01dd
            L_0x01cb:
                r17 = r7
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x0208 }
                android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x0208 }
                r6 = 2131886358(0x7f120116, float:1.9407293E38)
                java.lang.String r2 = r2.getString(r6)     // Catch:{ Exception -> 0x0208 }
                r1.setMessage(r2)     // Catch:{ Exception -> 0x0208 }
            L_0x01dd:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this     // Catch:{ Exception -> 0x0208 }
                java.lang.String r2 = r2.cbtn     // Catch:{ Exception -> 0x0208 }
                java.lang.String r6 = ""
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0208 }
                if (r2 != 0) goto L_0x01f1
                stikerwap.appdys.guardarprimeravez$guardar$4 r2 = new stikerwap.appdys.guardarprimeravez$guardar$4     // Catch:{ Exception -> 0x0208 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0208 }
                r1.setOnShowListener(r2)     // Catch:{ Exception -> 0x0208 }
            L_0x01f1:
                r1.show()     // Catch:{ Exception -> 0x0208 }
                r2 = 16908299(0x102000b, float:2.387726E-38)
                android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x05ba }
                android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x05ba }
                android.graphics.Typeface r2 = android.graphics.Typeface.MONOSPACE     // Catch:{ Exception -> 0x05ba }
                r1.setTypeface(r2)     // Catch:{ Exception -> 0x05ba }
                goto L_0x05ba
            L_0x0204:
                r16 = r6
            L_0x0206:
                r17 = r7
            L_0x0208:
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.chat_perfil> r6 = stikerwap.appdys.chat_perfil.class
                r1.<init>(r2, r6)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.externo
                if (r2 == 0) goto L_0x0221
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                android.content.Intent r1 = stikerwap.appdys.config.completar_externo(r1, r2)
                goto L_0x0228
            L_0x0221:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                int r2 = r2.idsecc
                r1.putExtra(r4, r2)
            L_0x0228:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                int r2 = r2.tipomenu
                r4 = 2
                if (r2 != r4) goto L_0x0237
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.desde_main_oblig
                if (r2 == 0) goto L_0x023b
            L_0x0237:
                r2 = 1
                r1.putExtra(r15, r2)
            L_0x023b:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.desde_main
                r1.putExtra(r3, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.desde_main_oblig
                r1.putExtra(r5, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                if (r2 == 0) goto L_0x02b7
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                r3 = 0
                boolean r2 = r2.getBoolean(r14, r3)
                r1.putExtra(r14, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r13, r3)
                r1.putExtra(r13, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r12, r3)
                r1.putExtra(r12, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r11, r3)
                r1.putExtra(r11, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r10, r3)
                r1.putExtra(r10, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r9, r3)
                r1.putExtra(r9, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                boolean r2 = r2.getBoolean(r8, r3)
                r1.putExtra(r8, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                r5 = r17
                boolean r2 = r2.getBoolean(r5, r3)
                r1.putExtra(r5, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                r6 = r16
                boolean r2 = r2.getBoolean(r6, r3)
                r1.putExtra(r6, r2)
            L_0x02b7:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                r2.startActivity(r1)
                goto L_0x05ba
            L_0x02be:
                r5 = r7
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                int r1 = r1.fb_modo
                r3 = 3
                if (r1 != r3) goto L_0x02d7
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.content.SharedPreferences r1 = r1.settings
                android.content.SharedPreferences$Editor r1 = r1.edit()
                r3 = 1
                r1.putBoolean(r2, r3)
                r1.commit()
            L_0x02d7:
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.s_guardarperfil> r3 = stikerwap.appdys.s_guardarperfil.class
                r1.<init>(r2, r3)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.content.SharedPreferences r2 = r2.settings
                java.lang.String r3 = "0"
                java.lang.String r7 = "foto1_modif"
                java.lang.String r2 = r2.getString(r7, r3)
                r1.putExtra(r7, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                r2.startService(r1)
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                boolean r1 = r1.desde_main
                if (r1 == 0) goto L_0x03cf
                byte r1 = r19.byteValue()
                java.lang.String r2 = "glob_acceso_validado"
                r3 = 11
                if (r1 != r3) goto L_0x0315
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.content.SharedPreferences r1 = r1.settings
                android.content.SharedPreferences$Editor r1 = r1.edit()
                r3 = 1
                android.content.SharedPreferences$Editor r1 = r1.putBoolean(r2, r3)
                r1.commit()
                goto L_0x0316
            L_0x0315:
                r3 = 1
            L_0x0316:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                int r1 = r1.glob_acceso
                if (r1 <= r3) goto L_0x033c
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.content.SharedPreferences r1 = r1.settings
                r4 = 0
                boolean r1 = r1.getBoolean(r2, r4)
                if (r1 != 0) goto L_0x033c
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.codigo> r4 = stikerwap.appdys.codigo.class
                r1.<init>(r2, r4)
                r1.putExtra(r15, r3)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                r2.startActivity(r1)
                goto L_0x05ba
            L_0x033c:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                int r1 = r1.tipomenu
                r2 = 2
                if (r1 != r2) goto L_0x0354
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                boolean r1 = r1.desde_main_oblig
                if (r1 != 0) goto L_0x0354
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.app.Activity r1 = r1.acti
                r1.finish()
                goto L_0x05ba
            L_0x0354:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                int r1 = r1.tipomenu
                r2 = 2
                if (r1 != r2) goto L_0x038f
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_menugrid> r3 = stikerwap.appdys.t_menugrid.class
                r1.<init>(r2, r3)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                r3 = 900(0x384, float:1.261E-42)
                r2.ind_secc_sel = r3
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.content.SharedPreferences r2 = r2.settings
                android.content.SharedPreferences$Editor r2 = r2.edit()
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r3 = r3.globales
                int r3 = r3.ind_secc_sel
                java.lang.String r4 = "ind_secc_sel"
                r2.putInt(r4, r3)
                r2.commit()
                r2 = 1
                r1.putExtra(r15, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                r2.startActivity(r1)
                goto L_0x05ba
            L_0x038f:
                r1 = 0
                r2 = 0
            L_0x0391:
                if (r1 != 0) goto L_0x03ad
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r3 = r3.globales
                stikerwap.appdys.Seccion[] r3 = r3.secciones_a
                int r3 = r3.length
                if (r2 >= r3) goto L_0x03ad
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r3 = r3.globales
                stikerwap.appdys.Seccion[] r3 = r3.secciones_a
                r3 = r3[r2]
                boolean r3 = r3.oculta
                if (r3 != 0) goto L_0x03aa
                r1 = 1
                goto L_0x0391
            L_0x03aa:
                int r2 = r2 + 1
                goto L_0x0391
            L_0x03ad:
                if (r1 != 0) goto L_0x03b1
                r3 = 0
                goto L_0x03b2
            L_0x03b1:
                r3 = r2
            L_0x03b2:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.ResultGetIntent r1 = r1.crear_rgi(r2, r3)
                android.content.Intent r2 = r1.i
                r3 = 1
                r2.putExtra(r15, r3)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.content.Intent r1 = r1.i
                r2.startActivity(r1)
                goto L_0x05ba
            L_0x03cf:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x03eb
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r14, r2)
                if (r1 == 0) goto L_0x03eb
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_buscusus> r3 = stikerwap.appdys.t_buscusus.class
                r1.<init>(r2, r3)
                goto L_0x0592
            L_0x03eb:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x0407
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r13, r2)
                if (r1 == 0) goto L_0x0407
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_buscvideos> r3 = stikerwap.appdys.t_buscvideos.class
                r1.<init>(r2, r3)
                goto L_0x0592
            L_0x0407:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x0423
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r12, r2)
                if (r1 == 0) goto L_0x0423
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_url> r3 = stikerwap.appdys.t_url.class
                r1.<init>(r2, r3)
                goto L_0x0592
            L_0x0423:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x043f
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r11, r2)
                if (r1 == 0) goto L_0x043f
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_url> r3 = stikerwap.appdys.t_url.class
                r1.<init>(r2, r3)
                goto L_0x0592
            L_0x043f:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x045b
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r10, r2)
                if (r1 == 0) goto L_0x045b
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_url> r3 = stikerwap.appdys.t_url.class
                r1.<init>(r2, r3)
                goto L_0x0592
            L_0x045b:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x0521
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r9, r2)
                if (r1 == 0) goto L_0x0521
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                java.util.ArrayList<java.lang.Integer> r2 = stikerwap.appdys.config.secciones_alist
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                int r3 = r3.idsecc
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                int r2 = r2.indexOf(r3)
                r1 = r1[r2]
                int r1 = r1.tipo_player
                if (r1 != 0) goto L_0x0494
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_video> r3 = stikerwap.appdys.t_video.class
                r1.<init>(r2, r3)
                goto L_0x04c6
            L_0x0494:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r1 = r1.globales
                stikerwap.appdys.Seccion[] r1 = r1.secciones_a
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                java.util.ArrayList<java.lang.Integer> r2 = stikerwap.appdys.config.secciones_alist
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                int r3 = r3.idsecc
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                int r2 = r2.indexOf(r3)
                r1 = r1[r2]
                int r1 = r1.tipo_player
                r2 = 1
                if (r1 != r2) goto L_0x04bd
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_video_exoplayer> r3 = stikerwap.appdys.t_video_exoplayer.class
                r1.<init>(r2, r3)
                goto L_0x04c6
            L_0x04bd:
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_video_playerjs> r3 = stikerwap.appdys.t_video_playerjs.class
                r1.<init>(r2, r3)
            L_0x04c6:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                stikerwap.appdys.Seccion[] r2 = r2.secciones_a
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r3 = r3.globales
                java.util.ArrayList<java.lang.Integer> r3 = stikerwap.appdys.config.secciones_alist
                stikerwap.appdys.guardarprimeravez r5 = stikerwap.appdys.guardarprimeravez.this
                int r5 = r5.idsecc
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                int r3 = r3.indexOf(r5)
                r2 = r2[r3]
                java.lang.String r2 = r2.url
                java.lang.String r3 = "url"
                r1.putExtra(r3, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                stikerwap.appdys.Seccion[] r2 = r2.secciones_a
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r3 = r3.globales
                java.util.ArrayList<java.lang.Integer> r3 = stikerwap.appdys.config.secciones_alist
                stikerwap.appdys.guardarprimeravez r5 = stikerwap.appdys.guardarprimeravez.this
                int r5 = r5.idsecc
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                int r3 = r3.indexOf(r5)
                r2 = r2[r3]
                java.lang.String r2 = r2.ua
                java.lang.String r3 = "ua"
                r1.putExtra(r3, r2)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                java.util.ArrayList<java.lang.Integer> r2 = stikerwap.appdys.config.secciones_alist
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                int r3 = r3.idsecc
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                int r2 = r2.indexOf(r3)
                java.lang.String r3 = "ind"
                r1.putExtra(r3, r2)
                goto L_0x0592
            L_0x0521:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x0553
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r8, r2)
                if (r1 == 0) goto L_0x0553
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_radio> r3 = stikerwap.appdys.t_radio.class
                r1.<init>(r2, r3)
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                java.util.ArrayList<java.lang.Integer> r2 = stikerwap.appdys.config.secciones_alist
                stikerwap.appdys.guardarprimeravez r3 = stikerwap.appdys.guardarprimeravez.this
                int r3 = r3.idsecc
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                int r2 = r2.indexOf(r3)
                java.lang.String r3 = "ind"
                r1.putExtra(r3, r2)
                goto L_0x0592
            L_0x0553:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x056e
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r5, r2)
                if (r1 == 0) goto L_0x056e
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_url> r3 = stikerwap.appdys.t_url.class
                r1.<init>(r2, r3)
                goto L_0x0592
            L_0x056e:
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                if (r1 == 0) goto L_0x0589
                stikerwap.appdys.guardarprimeravez r1 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r1 = r1.extras
                r2 = 0
                boolean r1 = r1.getBoolean(r6, r2)
                if (r1 == 0) goto L_0x0589
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_vistafb> r3 = stikerwap.appdys.t_vistafb.class
                r1.<init>(r2, r3)
                goto L_0x0592
            L_0x0589:
                android.content.Intent r1 = new android.content.Intent
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                java.lang.Class<stikerwap.appdys.t_chat> r3 = stikerwap.appdys.t_chat.class
                r1.<init>(r2, r3)
            L_0x0592:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                boolean r2 = r2.externo
                if (r2 == 0) goto L_0x05a1
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                android.os.Bundle r2 = r2.extras
                android.content.Intent r1 = stikerwap.appdys.config.completar_externo(r1, r2)
                goto L_0x05a8
            L_0x05a1:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                int r2 = r2.idsecc
                r1.putExtra(r4, r2)
            L_0x05a8:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                stikerwap.appdys.config r2 = r2.globales
                int r2 = r2.tipomenu
                r3 = 2
                if (r2 == r3) goto L_0x05b5
                r2 = 1
                r1.putExtra(r15, r2)
            L_0x05b5:
                stikerwap.appdys.guardarprimeravez r2 = stikerwap.appdys.guardarprimeravez.this
                r2.startActivity(r1)
            L_0x05ba:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.guardarprimeravez.guardar.onPostExecute(java.lang.Byte):void");
        }
    }

    public void onStop() {
        super.onStop();
        finish();
    }
}
