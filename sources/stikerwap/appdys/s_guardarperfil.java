package stikerwap.appdys;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.Toast;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class s_guardarperfil extends IntentService {
    Bundle extras;
    config globales;
    long idusu;
    Handler mHandler = new Handler();
    SharedPreferences settings;

    public s_guardarperfil() {
        super("s_guardarperfil");
    }

    private class DisplayToast implements Runnable {
        String mText;
        Integer mmodo;

        public DisplayToast(Integer num, Integer num2) {
            this.mText = s_guardarperfil.this.getString(num.intValue());
            this.mmodo = num2;
        }

        public void run() {
            config.mostrar_toast(Toast.makeText(s_guardarperfil.this.getApplicationContext(), this.mText, this.mmodo.intValue()));
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        this.globales = (config) getApplicationContext();
        this.mHandler.post(new DisplayToast(Integer.valueOf(R.string.guardando), 0));
        this.extras = intent.getExtras();
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        this.settings = sharedPreferences;
        this.idusu = sharedPreferences.getLong("idusu", 0);
        try {
            new guardar().execute(new String[0]);
        } catch (Exception unused) {
        }
    }

    private class guardar extends AsyncTask<String, Void, Byte> {
        private guardar() {
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            byte b;
            Bitmap bitmap;
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                StringBuilder sb = new StringBuilder();
                DefaultHttpClient defaultHttpClient2 = defaultHttpClient;
                sb.append(config.DOM_SRV);
                sb.append("/srv/guardar_perfil.php?idusu=");
                String str = "coments";
                String str2 = "sexo";
                sb.append(s_guardarperfil.this.idusu);
                sb.append("&idapp=3008836&c=");
                sb.append(s_guardarperfil.this.settings.getString("cod", ""));
                HttpPost httpPost = new HttpPost(sb.toString());
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                if (s_guardarperfil.this.extras.getString("foto1_modif").equals("1")) {
                    if (s_guardarperfil.this.globales.getTempFile(s_guardarperfil.this, 1).exists()) {
                        File tempFile = s_guardarperfil.this.globales.getTempFile(s_guardarperfil.this, 1);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(tempFile.getPath(), options);
                        int i = options.outWidth;
                        int i2 = options.outWidth;
                        int i3 = options.outHeight;
                        if (!(i2 <= 600 && i3 <= 600)) {
                            config config = s_guardarperfil.this.globales;
                            int round = Math.round(((float) i2) / ((float) config.calculateNewWidth(i2, i3, 600, 600)));
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inSampleSize = round;
                            bitmap = BitmapFactory.decodeFile(tempFile.getPath(), options2);
                        } else {
                            bitmap = MediaStore.Images.Media.getBitmap(s_guardarperfil.this.getContentResolver(), Uri.fromFile(tempFile));
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        multipartEntity.addPart("foto1", new ByteArrayBody(byteArrayOutputStream.toByteArray(), "temporal.jpg"));
                    } else {
                        multipartEntity.addPart("foto1_elim", new StringBody("1"));
                    }
                }
                multipartEntity.addPart("nombre", new StringBody(URLEncoder.encode(s_guardarperfil.this.settings.getString("nick", ""), "UTF-8")));
                multipartEntity.addPart("descr", new StringBody(URLEncoder.encode(s_guardarperfil.this.settings.getString("descr", ""), "UTF-8")));
                multipartEntity.addPart("privados", new StringBody(s_guardarperfil.this.settings.getInt("privados", 1) + ""));
                multipartEntity.addPart("foto1_modif", new StringBody(s_guardarperfil.this.extras.getString("foto1_modif")));
                multipartEntity.addPart("fnac_d", new StringBody(s_guardarperfil.this.settings.getInt("fnac_d", 0) + ""));
                multipartEntity.addPart("fnac_m", new StringBody(s_guardarperfil.this.settings.getInt("fnac_m", 0) + ""));
                multipartEntity.addPart("fnac_a", new StringBody(s_guardarperfil.this.settings.getInt("fnac_a", 0) + ""));
                StringBuilder sb2 = new StringBuilder();
                String str3 = str2;
                sb2.append(s_guardarperfil.this.settings.getInt(str3, 0));
                sb2.append("");
                multipartEntity.addPart(str3, new StringBody(sb2.toString()));
                StringBuilder sb3 = new StringBuilder();
                String str4 = str;
                sb3.append(s_guardarperfil.this.settings.getInt(str4, 1));
                sb3.append("");
                multipartEntity.addPart(str4, new StringBody(sb3.toString()));
                httpPost.setEntity(multipartEntity);
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient2.execute(httpPost).getEntity().getContent(), "UTF-8"));
                StringBuilder sb4 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb4.append(readLine);
                }
                if (sb4.indexOf("ANDROID:OK") != -1) {
                    return (byte) 1;
                }
                b = 0;
                try {
                    return (byte) 0;
                } catch (Exception unused) {
                    return Byte.valueOf(b);
                }
            } catch (Exception unused2) {
                b = 0;
                return Byte.valueOf(b);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Byte b) {
            if (b.byteValue() == 1) {
                s_guardarperfil.this.mHandler.post(new DisplayToast(Integer.valueOf(R.string.guardado), 0));
            } else {
                s_guardarperfil.this.mHandler.post(new DisplayToast(Integer.valueOf(R.string.error_http), 1));
            }
        }
    }
}
