package stikerwap.appdys;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.iid.FirebaseInstanceId;
import com.mbridge.msdk.foundation.entity.CampaignUnit;

public class RegistrationIntentService extends IntentService {
    String accion = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    long idusu;

    public RegistrationIntentService() {
        super("RegistrationIntentService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        long j = sharedPreferences.getLong("idusu", 0);
        this.idusu = j;
        if (j > 0) {
            try {
                sendRegistrationToServer(FirebaseInstanceId.getInstance().getToken());
            } catch (Exception unused) {
                sharedPreferences.edit().putBoolean("SENT_TOKEN_TO_SERVER", false).apply();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendRegistrationToServer(java.lang.String r7) {
        /*
            r6 = this;
            long r0 = r6.idusu
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00be
            if (r7 == 0) goto L_0x00be
            java.lang.String r0 = ""
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00be
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = stikerwap.appdys.config.DOM_SRV
            r0.append(r1)
            java.lang.String r1 = "/srv/guardargcmid.php?idusu="
            r0.append(r1)
            long r1 = r6.idusu
            r0.append(r1)
            java.lang.String r1 = "&gcmid="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = "&accion="
            r0.append(r7)
            java.lang.String r7 = r6.accion
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b8, all -> 0x00ae }
            r1.<init>(r7)     // Catch:{ Exception -> 0x00b8, all -> 0x00ae }
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x00b8, all -> 0x00ae }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x00b8, all -> 0x00ae }
            r0 = 1
            r7.setDoInput(r0)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r1 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r7.setReadTimeout(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r1 = "User-Agent"
            java.lang.String r2 = "Android Vinebre Software"
            r7.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.io.InputStream r1 = r7.getInputStream()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r1.<init>()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
        L_0x006e:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            if (r3 == 0) goto L_0x0078
            r1.append(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            goto L_0x006e
        L_0x0078:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r2 = "ANDROID:OK"
            int r1 = r1.indexOf(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r2 = -1
            if (r1 == r2) goto L_0x00a3
            java.lang.String r1 = r6.accion     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r2 = "A"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            if (r1 == 0) goto L_0x00a3
            java.lang.String r1 = "sh"
            r2 = 0
            android.content.SharedPreferences r1 = r6.getSharedPreferences(r1, r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r2 = "SENT_TOKEN_TO_SERVER"
            android.content.SharedPreferences$Editor r0 = r1.putBoolean(r2, r0)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r0.apply()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
        L_0x00a3:
            if (r7 == 0) goto L_0x00be
            r7.disconnect()
            goto L_0x00be
        L_0x00a9:
            r0 = move-exception
            goto L_0x00b2
        L_0x00ab:
            r0 = r7
            goto L_0x00b9
        L_0x00ae:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x00b2:
            if (r7 == 0) goto L_0x00b7
            r7.disconnect()
        L_0x00b7:
            throw r0
        L_0x00b8:
        L_0x00b9:
            if (r0 == 0) goto L_0x00be
            r0.disconnect()
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.RegistrationIntentService.sendRegistrationToServer(java.lang.String):void");
    }
}
