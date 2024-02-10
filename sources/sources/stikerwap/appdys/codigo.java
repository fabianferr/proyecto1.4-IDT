package stikerwap.appdys;

import android.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class codigo extends Activity_ext_class implements Activity_ext, View.OnClickListener {
    boolean atras_pulsado = false;
    String c1;
    String c2;
    String cod_g;
    String codigo;
    config globales;
    long idusu;
    ProgressBar pb;
    SharedPreferences settings;

    public void abrir_secc(View view) {
    }

    public void onCreate(Bundle bundle) {
        int i;
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        this.es_root = true;
        this.c1 = this.globales.c1c;
        this.c2 = this.globales.c2c;
        this.cbtn = config.aplicar_color_dialog(this.c1, this.globales.c_icos);
        if (!config.esClaro("#" + this.c1)) {
            setTheme(R.style.holonolight);
        }
        super.onCreate(bundle);
        setContentView(R.layout.codigo);
        this.globales.incluir_menu_2(this, false);
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        this.codigo = this.settings.getString("cod", "");
        this.cod_g = this.settings.getString("cod_g", "");
        this.pb = (ProgressBar) findViewById(R.id.pb);
        if (!this.c1.equals("")) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            findViewById(R.id.ll_princ).setBackgroundDrawable(new GradientDrawable(orientation, new int[]{Color.parseColor("#" + this.c1), Color.parseColor("#" + this.c2)}));
            int i2 = config.BLANCO_2;
            if (config.esClaro("#" + this.c1)) {
                int i3 = config.NEGRO_2;
                i = ViewCompat.MEASURED_STATE_MASK;
            } else {
                i = -1;
            }
            ((TextView) findViewById(R.id.tv_solicita)).setTextColor(i);
            ((TextView) findViewById(R.id.tv_codigo)).setTextColor(i);
            if (Build.VERSION.SDK_INT > 20) {
                config.edittext_color((EditText) findViewById(R.id.et_cod), Boolean.valueOf(true ^ config.esClaro("#" + this.c1)), this.globales.c_ir_ofic);
                config.progress_color(this.pb, this.globales.c_icos);
            }
        }
        if (this.globales.glob_acceso == 2 || this.globales.glob_acceso == 4) {
            TextView textView = (TextView) findViewById(R.id.btn_enviar);
            if (!this.globales.c_icos.equals("")) {
                textView.setBackgroundColor(Color.parseColor("#" + this.globales.c_icos));
                if (config.esClaro("#" + this.globales.c_icos)) {
                    textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
            }
            textView.setOnClickListener(this);
            if (this.globales.glob_acceso == 4) {
                findViewById(R.id.tv_solicita).setOnClickListener(this);
                findViewById(R.id.tv_solicita).setVisibility(0);
            }
            if (this.globales.codigo_acceso != null) {
                new enviar_codigo(this.globales.codigo_acceso).execute(new String[0]);
                return;
            }
            findViewById(R.id.ll_contenido).setVisibility(0);
            findViewById(R.id.et_cod).requestFocus();
        } else if (this.globales.glob_acceso == 3) {
            new enviar_solicitud().execute(new String[0]);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_enviar) {
            String trim = ((EditText) findViewById(R.id.et_cod)).getText().toString().trim();
            if (!trim.equals("")) {
                new enviar_codigo(trim).execute(new String[0]);
            }
        } else if (view.getId() == R.id.tv_solicita) {
            new enviar_solicitud().execute(new String[0]);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    private class enviar_codigo extends AsyncTask<String, Void, String> {
        String codigo_acceso;

        public enviar_codigo(String str) {
            this.codigo_acceso = str;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            codigo.this.findViewById(R.id.ll_contenido).setVisibility(8);
            codigo.this.pb.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/codigo_verif.php?idusu=" + codigo.this.idusu + "&c=" + codigo.this.codigo);
            MultipartEntity multipartEntity = new MultipartEntity();
            try {
                multipartEntity.addPart("c_acceso", new StringBody(this.codigo_acceso));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            httpPost.setEntity(multipartEntity);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            String str = "";
            try {
                HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
                if (entity != null) {
                    str = EntityUtils.toString(entity);
                }
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            codigo.this.pb.setVisibility(8);
            AlertDialog.Builder builder = new AlertDialog.Builder(codigo.this);
            int i = 0;
            builder.setCancelable(false).setPositiveButton(codigo.this.getString(R.string.aceptar), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    codigo.this.findViewById(R.id.ll_contenido).setVisibility(0);
                }
            });
            if (str.indexOf("ANDROID:OK") != -1) {
                SharedPreferences.Editor edit = codigo.this.settings.edit();
                edit.putBoolean("glob_acceso_validado", true);
                edit.commit();
                if (codigo.this.globales.tipomenu == 2) {
                    Intent intent = new Intent(codigo.this, t_menugrid.class);
                    codigo.this.globales.ind_secc_sel = 900;
                    SharedPreferences.Editor edit2 = codigo.this.settings.edit();
                    edit2.putInt("ind_secc_sel", codigo.this.globales.ind_secc_sel);
                    edit2.commit();
                    intent.putExtra("es_root", true);
                    codigo.this.startActivity(intent);
                    codigo.this.finish();
                    return;
                }
                boolean z = false;
                int i2 = 0;
                while (!z && i2 < codigo.this.globales.secciones_a.length) {
                    if (!codigo.this.globales.secciones_a[i2].oculta) {
                        z = true;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    i = i2;
                }
                ResultGetIntent crear_rgi = codigo.this.globales.crear_rgi(Integer.valueOf(i), codigo.this);
                crear_rgi.i.putExtra("es_root", true);
                codigo.this.startActivity(crear_rgi.i);
                codigo.this.finish();
            } else if (str.indexOf("ANDROID:KO") != -1) {
                builder.setMessage(R.string.codigo_ko);
                final AlertDialog create = builder.create();
                if (!codigo.this.cbtn.equals("")) {
                    create.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + codigo.this.cbtn));
                        }
                    });
                }
                create.show();
                try {
                    ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
                } catch (Exception unused) {
                }
            } else {
                builder.setMessage(R.string.error_http);
                final AlertDialog create2 = builder.create();
                if (!codigo.this.cbtn.equals("")) {
                    create2.setOnShowListener(new DialogInterface.OnShowListener() {
                        public void onShow(DialogInterface dialogInterface) {
                            Button button = create2.getButton(-1);
                            button.setTextColor(Color.parseColor("#" + codigo.this.cbtn));
                        }
                    });
                }
                create2.show();
                ((TextView) create2.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            }
        }
    }

    private class enviar_solicitud extends AsyncTask<String, Void, String> {
        private enviar_solicitud() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            codigo.this.findViewById(R.id.ll_contenido).setVisibility(8);
            codigo.this.pb.setVisibility(0);
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... strArr) {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(config.DOM_SRV + "/srv/solicitar_acceso.php?idusu=" + codigo.this.idusu + "&c=" + codigo.this.codigo);
            httpPost.setHeader("User-Agent", "Android Vinebre Software");
            String str = "";
            try {
                HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
                if (entity != null) {
                    str = EntityUtils.toString(entity);
                }
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            defaultHttpClient.getConnectionManager().shutdown();
            return str;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            int i;
            codigo.this.pb.setVisibility(8);
            AlertDialog.Builder builder = new AlertDialog.Builder(codigo.this);
            int i2 = 0;
            builder.setCancelable(false);
            if (codigo.this.globales.glob_acceso == 3) {
                builder.setPositiveButton(R.string.cerrar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        codigo.this.finish();
                    }
                });
            } else {
                builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        codigo.this.findViewById(R.id.ll_contenido).setVisibility(0);
                    }
                });
            }
            if (str.indexOf("ANDROID:1-") != -1) {
                SharedPreferences.Editor edit = codigo.this.settings.edit();
                edit.putBoolean("glob_acceso_validado", true);
                edit.commit();
                if (codigo.this.globales.tipomenu == 2) {
                    Intent intent = new Intent(codigo.this, t_menugrid.class);
                    codigo.this.globales.ind_secc_sel = 900;
                    SharedPreferences.Editor edit2 = codigo.this.settings.edit();
                    edit2.putInt("ind_secc_sel", codigo.this.globales.ind_secc_sel);
                    edit2.commit();
                    intent.putExtra("es_root", true);
                    codigo.this.startActivity(intent);
                    codigo.this.finish();
                    return;
                }
                boolean z = false;
                int i3 = 0;
                while (!z && i3 < codigo.this.globales.secciones_a.length) {
                    if (!codigo.this.globales.secciones_a[i3].oculta) {
                        z = true;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    i2 = i3;
                }
                ResultGetIntent crear_rgi = codigo.this.globales.crear_rgi(Integer.valueOf(i2), codigo.this);
                crear_rgi.i.putExtra("es_root", true);
                codigo.this.startActivity(crear_rgi.i);
                codigo.this.finish();
                return;
            }
            if (str.indexOf("ANDROID:00-") != -1) {
                i = R.string.acceso_pendiente;
            } else if (str.indexOf("ANDROID:0-") != -1) {
                i = R.string.acceso_solicitado;
            } else {
                i = str.indexOf("ANDROID:2-") != -1 ? R.string.acceso_denegado : R.string.error_http;
            }
            builder.setMessage(i);
            final AlertDialog create = builder.create();
            if (!codigo.this.cbtn.equals("")) {
                create.setOnShowListener(new DialogInterface.OnShowListener() {
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = create.getButton(-1);
                        button.setTextColor(Color.parseColor("#" + codigo.this.cbtn));
                    }
                });
            }
            create.show();
            try {
                ((TextView) create.findViewById(16908299)).setTypeface(Typeface.MONOSPACE);
            } catch (Exception unused) {
            }
        }
    }

    public void onBackPressed() {
        if (!this.es_root || this.atras_pulsado || !this.globales.pedir_confirm_exit) {
            super.onBackPressed();
            return;
        }
        this.atras_pulsado = true;
        config.confirmar_exit(this);
    }
}
