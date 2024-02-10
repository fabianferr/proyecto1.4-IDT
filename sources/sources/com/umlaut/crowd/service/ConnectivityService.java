package com.umlaut.crowd.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.CT;
import com.umlaut.crowd.internal.OCTL;
import com.umlaut.crowd.threads.ThreadManager;

public class ConnectivityService extends Service {
    private static final boolean k = false;
    private static final String l = "ConnectivityService";
    public static final int m = 30000;
    private static final int n = ConnectivityService.class.hashCode();
    public static final String o = "com.p3group.insight.extra.EXTRA_FOREGROUND";
    public static final String p = "com.p3group.insight.extra.EXTRA_NOTIFICATION";
    public static final String q = "com.p3group.insight.action.UPDATE_INTERVAL";
    public static final String r = "com.p3group.insight.action.ACTION_FOREGROUND_ONETIME_RUN";
    private AlarmManager a;
    private PendingIntent b;
    /* access modifiers changed from: private */
    public CT c;
    /* access modifiers changed from: private */
    public boolean d;
    private IS e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private boolean j;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ConnectivityService.this.c.b(com.umlaut.crowd.internal.a.Periodic);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ConnectivityService.this.c.b(com.umlaut.crowd.internal.a.Periodic);
        }
    }

    class c implements OCTL {
        c() {
        }

        public void a() {
            boolean unused = ConnectivityService.this.d = false;
        }

        public void onConnectivityTestStart() {
            boolean unused = ConnectivityService.this.d = true;
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Log.i(l, "Service created");
        if (!InsightCore.isInitialized()) {
            stopSelf();
            return;
        }
        this.e = new IS(getApplicationContext());
        IC insightConfig = InsightCore.getInsightConfig();
        this.i = insightConfig.K();
        this.g = insightConfig.V();
        this.h = insightConfig.J();
        if (!this.e.m() || this.e.n()) {
            this.f = this.g;
        } else {
            this.f = this.h;
        }
        a();
        if (this.e.w() > SystemClock.elapsedRealtime()) {
            this.e.f(0);
            this.j = true;
        }
        this.a = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent service = PendingIntent.getService(getApplicationContext(), 0, new Intent(getApplicationContext(), ConnectivityService.class), 0);
        this.b = service;
        this.a.cancel(service);
        if (!this.i || Build.VERSION.SDK_INT < 23) {
            long w = this.e.w() + this.f;
            if (w < SystemClock.elapsedRealtime()) {
                w = SystemClock.elapsedRealtime() + this.f;
            }
            this.a.setInexactRepeating(3, w, this.f, this.b);
        }
        if (InsightCore.getInsightConfig().l1()) {
            startForeground(n, new Notification.Builder(getApplicationContext()).setContentTitle("CT measurement ongoing").setSmallIcon(17301543).build());
        }
    }

    public void onDestroy() {
        PendingIntent pendingIntent;
        Log.i(l, "onDestroy");
        AlarmManager alarmManager = this.a;
        if (!(alarmManager == null || (pendingIntent = this.b) == null)) {
            alarmManager.cancel(pendingIntent);
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (!InsightCore.isInitialized() || this.e == null) {
            return 2;
        }
        if (intent != null) {
            if (intent.hasExtra(o)) {
                runInForeground(intent.getBooleanExtra(o, false), (Notification) intent.getParcelableExtra(p));
                return 1;
            } else if (intent.getAction() != null && intent.getAction().equals(q)) {
                if (!this.e.m() || this.e.n()) {
                    this.f = this.g;
                } else {
                    this.f = this.h;
                }
                if (!this.i || Build.VERSION.SDK_INT < 23) {
                    this.a.cancel(this.b);
                    long w = this.e.w() + this.f;
                    if (w < SystemClock.elapsedRealtime()) {
                        w = SystemClock.elapsedRealtime() + this.f;
                    }
                    this.a.setInexactRepeating(3, w, this.f, this.b);
                    return 1;
                }
            } else if (intent.getAction() != null && intent.getAction().equals(r)) {
                if (!this.d) {
                    if (SystemClock.elapsedRealtime() - this.e.w() >= Math.min(InsightCore.getInsightConfig().x0(), InsightCore.getInsightConfig().y0()) || this.j) {
                        ThreadManager.getInstance().getCachedThreadPool().execute(new a());
                        if (this.j) {
                            this.j = false;
                        }
                    }
                }
                return 1;
            }
        }
        if (this.i && Build.VERSION.SDK_INT >= 23) {
            this.a.cancel(this.b);
            this.a.setAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + this.f, this.b);
        }
        if (!this.d) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.e.w();
            double d2 = (double) this.f;
            Double.isNaN(d2);
            if (elapsedRealtime >= ((long) (d2 * 0.9d)) || this.j) {
                ThreadManager.getInstance().getCachedThreadPool().execute(new b());
                if (this.j) {
                    this.j = false;
                }
            }
        }
        return 1;
    }

    private void a() {
        CT ct = new CT(this);
        this.c = ct;
        ct.a((OCTL) new c());
    }

    public void runInForeground(boolean z, Notification notification) {
        if (z) {
            if (notification == null) {
                notification = new Notification.Builder(getApplicationContext()).setContentTitle("CT measurement ongoing").setSmallIcon(17301543).build();
            }
            startForeground(n, notification);
            return;
        }
        stopForeground(true);
    }
}
