package com.teragence.library;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import com.teragence.client.service.MetricsService;

public class j2 implements l2 {
    private final Context a;
    private final AlarmManager b;

    public j2(Context context, AlarmManager alarmManager) {
        this.a = context;
        this.b = alarmManager;
    }

    public void a() {
        Intent intent = new Intent(this.a, MetricsService.class);
        intent.setData(Uri.parse(NotificationCompat.CATEGORY_ALARM));
        PendingIntent service = PendingIntent.getService(this.a, 0, intent, C.BUFFER_FLAG_FIRST_SAMPLE);
        service.cancel();
        this.b.cancel(service);
    }

    public void a(int i) {
        try {
            a();
        } catch (Exception unused) {
        }
        Intent intent = new Intent(this.a, MetricsService.class);
        intent.setData(Uri.parse(NotificationCompat.CATEGORY_ALARM));
        PendingIntent service = PendingIntent.getService(this.a, 0, intent, 0);
        this.b.setRepeating(0, System.currentTimeMillis() + 1000, (long) i, service);
    }

    public void b(int i) {
        a();
        a(i);
    }
}
