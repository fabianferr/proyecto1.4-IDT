package com.umlaut.crowd.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.umlaut.crowd.InsightCore;

public class InsightService extends Service {
    private static final String a = "InsightService";
    private static final int b = InsightService.class.hashCode();

    private void a(String str) {
        NotificationChannel notificationChannel = new NotificationChannel(str, a, 3);
        notificationChannel.enableLights(false);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Notification.Builder builder;
        String str = a;
        Log.i(str, "Service created");
        if (!InsightCore.isInitialized()) {
            stopSelf();
        } else if (InsightCore.getInsightConfig().l1()) {
            if (Build.VERSION.SDK_INT >= 26) {
                String str2 = str + b;
                a(str2);
                builder = new Notification.Builder(getApplicationContext(), str2);
            } else {
                builder = new Notification.Builder(getApplicationContext());
            }
            startForeground(b, builder.setContentTitle("insightService running").setSmallIcon(17301543).build());
        }
    }

    public void onDestroy() {
        Log.i(a, "onDestroy");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}
