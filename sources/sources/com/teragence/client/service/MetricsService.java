package com.teragence.client.service;

import android.app.AlarmManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.teragence.client.i;
import com.teragence.library.j2;
import com.teragence.library.n2;

public class MetricsService extends Service {
    private f b;

    public IBinder onBind(Intent intent) {
        i.a("MetricsService", "onBind() called with: arg0 = [" + intent + "]");
        return null;
    }

    public void onCreate() {
        String str;
        try {
            i.a("MetricsService", "onCreate() called");
            if (Build.VERSION.SDK_INT < 21) {
                i.a("MetricsService", "onCreate: Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP");
                if (!getSharedPreferences("MySP", 0).getBoolean("manuallyStopped", false)) {
                    h hVar = new h(new c(new j(new n(new i(this, new n2(new j2(this, (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)))), new b(new m(getSharedPreferences("MetricsServiceStats", 0)), this)), this)));
                    this.b = hVar;
                    hVar.a();
                    return;
                }
                str = "onCreate: Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP Manually disabled SDK";
            } else {
                stopSelf();
                str = "onCreate: Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP stopSelf() calling";
            }
            i.a("MetricsService", str);
        } catch (Exception e) {
            i.b("MetricsService", e.getMessage());
            stopSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0065, code lost:
        if (r5 != null) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "onStartCommand() called with: intent = ["
            java.lang.String r1 = "MetricsService"
            r2 = 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x007c }
            r3.append(r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = "], flags = ["
            r3.append(r0)     // Catch:{ Exception -> 0x007c }
            r3.append(r6)     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = "], startId = ["
            r3.append(r6)     // Catch:{ Exception -> 0x007c }
            r3.append(r7)     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = "]"
            r3.append(r6)     // Catch:{ Exception -> 0x007c }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x007c }
            com.teragence.client.i.a((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x007c }
            if (r5 == 0) goto L_0x007b
            java.lang.String r5 = r5.getDataString()     // Catch:{ Exception -> 0x007c }
            if (r5 == 0) goto L_0x007b
            java.lang.String r6 = "alarm"
            boolean r6 = r5.equals(r6)     // Catch:{ Exception -> 0x007c }
            if (r6 == 0) goto L_0x006b
            java.lang.String r5 = "MySP"
            r6 = 0
            android.content.SharedPreferences r5 = r4.getSharedPreferences(r5, r6)     // Catch:{ Exception -> 0x007c }
            java.lang.String r7 = "manuallyStopped"
            boolean r5 = r5.getBoolean(r7, r6)     // Catch:{ Exception -> 0x007c }
            if (r5 != 0) goto L_0x0063
            com.teragence.client.service.f r5 = r4.b     // Catch:{ Exception -> 0x007c }
            if (r5 == 0) goto L_0x007b
            com.teragence.library.i2 r6 = new com.teragence.library.i2     // Catch:{ Exception -> 0x007c }
            com.teragence.library.e2 r7 = new com.teragence.library.e2     // Catch:{ Exception -> 0x007c }
            com.teragence.library.g2 r0 = new com.teragence.library.g2     // Catch:{ Exception -> 0x007c }
            android.os.PowerManager$WakeLock r3 = com.teragence.client.service.l.a(r4)     // Catch:{ Exception -> 0x007c }
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x007c }
            r7.<init>(r0)     // Catch:{ Exception -> 0x007c }
            r6.<init>(r7)     // Catch:{ Exception -> 0x007c }
            r5.a(r6)     // Catch:{ Exception -> 0x007c }
            goto L_0x007b
        L_0x0063:
            com.teragence.client.service.f r5 = r4.b     // Catch:{ Exception -> 0x007c }
            if (r5 == 0) goto L_0x0078
        L_0x0067:
            r5.b()     // Catch:{ Exception -> 0x007c }
            goto L_0x0078
        L_0x006b:
            java.lang.String r6 = "COMMAND_FINISH"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x007c }
            if (r5 == 0) goto L_0x007b
            com.teragence.client.service.f r5 = r4.b     // Catch:{ Exception -> 0x007c }
            if (r5 == 0) goto L_0x0078
            goto L_0x0067
        L_0x0078:
            r4.stopSelf()     // Catch:{ Exception -> 0x007c }
        L_0x007b:
            return r2
        L_0x007c:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.teragence.client.i.b(r1, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.client.service.MetricsService.onStartCommand(android.content.Intent, int, int):int");
    }
}
