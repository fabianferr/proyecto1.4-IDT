package stikerwap.appdys;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.lang.Thread;
import java.net.URLEncoder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler defaultUEH = Thread.getDefaultUncaughtExceptionHandler();

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            new enviar(Log.getStackTraceString(th), getDeviceName()).execute(new String[0]);
        } catch (Exception unused) {
        }
        this.defaultUEH.uncaughtException(thread, th);
    }

    private class enviar extends AsyncTask<String, Void, Byte> {
        String descr;
        String dispositivo;

        enviar(String str, String str2) {
            this.descr = str;
            this.dispositivo = str2;
        }

        /* access modifiers changed from: protected */
        public Byte doInBackground(String... strArr) {
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient((HttpParams) basicHttpParams);
                HttpPost httpPost = new HttpPost(config.PROTOC_GEN + "log." + config.DOM_EDROID + "/srv/log.php?v=172&vcode=1&idapp=3008836&nivelapi=" + Build.VERSION.SDK_INT + "&dispo=" + URLEncoder.encode(this.dispositivo, "UTF-8"));
                MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                multipartEntity.addPart("descr", new StringBody(this.descr));
                httpPost.setEntity(multipartEntity);
                httpPost.setHeader("User-Agent", "Android Vinebre Software");
                defaultHttpClient.execute(httpPost);
            } catch (Exception unused) {
            }
            return (byte) 0;
        }
    }

    private static String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return capitalize(str2);
        }
        return capitalize(str) + " " + str2;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            } else {
                sb.append(Character.toUpperCase(c));
                z = false;
            }
        }
        return sb.toString();
    }
}
