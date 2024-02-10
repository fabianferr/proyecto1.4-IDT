package stikerwap.appdys;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class alarma_rss extends BroadcastReceiver {
    public SharedPreferences settings;

    public void onReceive(Context context, Intent intent) {
        this.settings = context.getSharedPreferences(CampaignUnit.JSON_KEY_SH, 0);
        if (System.currentTimeMillis() - this.settings.getLong("f_ult_rss", 0) >= 120000) {
            SharedPreferences.Editor edit = this.settings.edit();
            edit.putLong("f_ult_rss", System.currentTimeMillis());
            edit.commit();
            String string = this.settings.getString("idseccs", "");
            if (!string.equals("")) {
                String[] split = string.split(",");
                int i = 0;
                for (int i2 = 0; i2 < split.length; i2++) {
                    SharedPreferences sharedPreferences = this.settings;
                    if (sharedPreferences.getInt(CmcdHeadersFactory.STREAMING_FORMAT_SS + split[i2] + "_tipo", 0) == 8) {
                        String str = split[i2];
                        i++;
                        SharedPreferences sharedPreferences2 = this.settings;
                        if (!sharedPreferences2.getString("rss_" + str + "_ultpost", "").equals("")) {
                            SharedPreferences sharedPreferences3 = this.settings;
                            String string2 = sharedPreferences3.getString(CmcdHeadersFactory.STREAMING_FORMAT_SS + str + "_url", "");
                            if (!string2.equals("")) {
                                new RssDataController(context, str, i).execute(new String[]{string2});
                            }
                        }
                    }
                }
            }
        }
    }

    public void SetAlarm(Context context, int i) {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(context, alarma_rss.class);
        if (Build.VERSION.SDK_INT >= 23) {
            pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 201326592);
        } else {
            pendingIntent = PendingIntent.getBroadcast(context, 1, intent, C.BUFFER_FLAG_FIRST_SAMPLE);
        }
        PendingIntent pendingIntent2 = pendingIntent;
        if (i == 0) {
            alarmManager.cancel(pendingIntent2);
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.add(13, 60);
        alarmManager.setInexactRepeating(1, instance.getTimeInMillis(), (long) (i * 3600000), pendingIntent2);
    }

    private class RssDataController extends AsyncTask<String, Integer, ArrayList<rss_item>> {
        private Context c2;
        private String idsecc;
        private int n_rss;

        public RssDataController(Context context, String str, int i) {
            this.c2 = context;
            this.idsecc = str;
            this.n_rss = i;
        }

        /* access modifiers changed from: protected */
        public ArrayList<rss_item> doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                return config.tratar_rss(httpURLConnection.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:59:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.util.ArrayList<stikerwap.appdys.rss_item> r19) {
            /*
                r18 = this;
                r1 = r18
                r2 = r19
                if (r2 == 0) goto L_0x0167
                int r0 = r19.size()
                if (r0 <= 0) goto L_0x0167
                r3 = 0
                java.lang.Object r0 = r2.get(r3)
                stikerwap.appdys.rss_item r0 = (stikerwap.appdys.rss_item) r0
                java.lang.String r0 = r0.postLink
                if (r0 == 0) goto L_0x0167
                java.lang.Object r0 = r2.get(r3)
                stikerwap.appdys.rss_item r0 = (stikerwap.appdys.rss_item) r0
                java.lang.String r0 = r0.postLink
                java.lang.String r4 = ""
                boolean r0 = r0.equals(r4)
                if (r0 != 0) goto L_0x0167
                java.lang.Object r0 = r2.get(r3)
                stikerwap.appdys.rss_item r0 = (stikerwap.appdys.rss_item) r0
                java.lang.String r0 = r0.postLink
                stikerwap.appdys.alarma_rss r5 = stikerwap.appdys.alarma_rss.this
                android.content.SharedPreferences r5 = r5.settings
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "rss_"
                r6.<init>(r7)
                java.lang.String r8 = r1.idsecc
                r6.append(r8)
                java.lang.String r8 = "_ultpost"
                r6.append(r8)
                java.lang.String r6 = r6.toString()
                java.lang.String r5 = r5.getString(r6, r4)
                boolean r0 = r0.equals(r5)
                if (r0 != 0) goto L_0x0167
                r5 = 1
                android.content.Context r0 = r1.c2     // Catch:{ Exception -> 0x009b }
                java.lang.String r6 = "sh"
                android.content.SharedPreferences r0 = r0.getSharedPreferences(r6, r3)     // Catch:{ Exception -> 0x009b }
                java.lang.String r6 = "rss_i"
                int r6 = r0.getInt(r6, r3)     // Catch:{ Exception -> 0x009b }
                java.lang.String r9 = "rss_n"
                int r9 = r0.getInt(r9, r3)     // Catch:{ Exception -> 0x0098 }
                java.lang.String r10 = "rss_t"
                java.lang.String r10 = r0.getString(r10, r4)     // Catch:{ Exception -> 0x0095 }
                android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Exception -> 0x0093 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0093 }
                r11.<init>(r7)     // Catch:{ Exception -> 0x0093 }
                java.lang.String r7 = r1.idsecc     // Catch:{ Exception -> 0x0093 }
                r11.append(r7)     // Catch:{ Exception -> 0x0093 }
                r11.append(r8)     // Catch:{ Exception -> 0x0093 }
                java.lang.String r7 = r11.toString()     // Catch:{ Exception -> 0x0093 }
                java.lang.Object r8 = r2.get(r3)     // Catch:{ Exception -> 0x0093 }
                stikerwap.appdys.rss_item r8 = (stikerwap.appdys.rss_item) r8     // Catch:{ Exception -> 0x0093 }
                java.lang.String r8 = r8.postLink     // Catch:{ Exception -> 0x0093 }
                r0.putString(r7, r8)     // Catch:{ Exception -> 0x0093 }
                r0.commit()     // Catch:{ Exception -> 0x0093 }
                r11 = r10
                r0 = 1
                goto L_0x00a4
            L_0x0093:
                r0 = move-exception
                goto L_0x009f
            L_0x0095:
                r0 = move-exception
                r10 = r4
                goto L_0x009f
            L_0x0098:
                r0 = move-exception
                r10 = r4
                goto L_0x009e
            L_0x009b:
                r0 = move-exception
                r10 = r4
                r6 = 0
            L_0x009e:
                r9 = 0
            L_0x009f:
                r0.printStackTrace()
                r11 = r10
                r0 = 0
            L_0x00a4:
                if (r0 == 0) goto L_0x0167
                if (r6 <= 0) goto L_0x0167
                boolean r0 = r11.equals(r4)
                if (r0 != 0) goto L_0x0167
                java.lang.String r0 = "notification"
                android.content.Context r4 = r1.c2
                java.lang.Object r0 = r4.getSystemService(r0)
                android.app.NotificationManager r0 = (android.app.NotificationManager) r0
                if (r9 != r5) goto L_0x00bc
                r4 = 1
                goto L_0x00bd
            L_0x00bc:
                r4 = 0
            L_0x00bd:
                int r6 = android.os.Build.VERSION.SDK_INT
                r7 = 26
                if (r6 < r7) goto L_0x00d3
                androidx.core.app.NotificationCompat$Builder r6 = new androidx.core.app.NotificationCompat$Builder
                android.content.Context r7 = r1.c2
                android.app.NotificationChannel r8 = stikerwap.appdys.config.crear_channel(r7, r4)
                java.lang.String r8 = r8.getId()
                r6.<init>((android.content.Context) r7, (java.lang.String) r8)
                goto L_0x00da
            L_0x00d3:
                androidx.core.app.NotificationCompat$Builder r6 = new androidx.core.app.NotificationCompat$Builder
                android.content.Context r7 = r1.c2
                r6.<init>(r7)
            L_0x00da:
                r7 = 2131231598(0x7f08036e, float:1.8079282E38)
                androidx.core.app.NotificationCompat$Builder r7 = r6.setSmallIcon((int) r7)
                androidx.core.app.NotificationCompat$Builder r7 = r7.setContentTitle(r11)
                java.lang.Object r8 = r2.get(r3)
                stikerwap.appdys.rss_item r8 = (stikerwap.appdys.rss_item) r8
                java.lang.String r8 = r8.postTitle
                androidx.core.app.NotificationCompat$Builder r7 = r7.setContentText(r8)
                r7.setAutoCancel(r5)
                android.content.Context r7 = r1.c2
                android.graphics.Bitmap r7 = stikerwap.appdys.config.ico_en_notif(r7)
                if (r7 == 0) goto L_0x00ff
                r6.setLargeIcon(r7)
            L_0x00ff:
                if (r4 != r5) goto L_0x0105
                r4 = 5
                r6.setDefaults(r4)
            L_0x0105:
                android.content.Intent r4 = new android.content.Intent
                android.content.Context r5 = r1.c2
                java.lang.Class<stikerwap.appdys.preinicio> r7 = stikerwap.appdys.preinicio.class
                r4.<init>(r5, r7)
                java.lang.String r5 = "notif_id"
                java.lang.String r7 = "0"
                r4.putExtra(r5, r7)
                java.lang.String r5 = "notif_tipo"
                java.lang.String r7 = "1"
                r4.putExtra(r5, r7)
                java.lang.String r5 = "notif_idelem"
                java.lang.String r7 = r1.idsecc
                r4.putExtra(r5, r7)
                android.content.Context r10 = r1.c2
                java.lang.Object r2 = r2.get(r3)
                stikerwap.appdys.rss_item r2 = (stikerwap.appdys.rss_item) r2
                java.lang.String r12 = r2.postTitle
                int r2 = r1.n_rss
                int r14 = r2 + 100
                r15 = 3
                java.lang.String r16 = "0"
                java.lang.String r17 = "0"
                r13 = r4
                stikerwap.appdys.config.crear_notif(r10, r11, r12, r13, r14, r15, r16, r17)
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 23
                if (r2 < r3) goto L_0x014d
                android.content.Context r2 = r1.c2
                int r3 = r1.n_rss
                int r3 = r3 + 100
                r5 = 201326592(0xc000000, float:9.8607613E-32)
                android.app.PendingIntent r2 = android.app.PendingIntent.getActivity(r2, r3, r4, r5)
                goto L_0x0159
            L_0x014d:
                android.content.Context r2 = r1.c2
                int r3 = r1.n_rss
                int r3 = r3 + 100
                r5 = 134217728(0x8000000, float:3.85186E-34)
                android.app.PendingIntent r2 = android.app.PendingIntent.getActivity(r2, r3, r4, r5)
            L_0x0159:
                r6.setContentIntent(r2)
                int r2 = r1.n_rss
                int r2 = r2 + 100
                android.app.Notification r3 = r6.build()
                r0.notify(r2, r3)
            L_0x0167:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.alarma_rss.RssDataController.onPostExecute(java.util.ArrayList):void");
        }
    }
}
