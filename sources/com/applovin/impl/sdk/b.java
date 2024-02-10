package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.o;
import java.util.Map;

public class b implements AppLovinBroadcastManager.Receiver {
    private final m a;
    /* access modifiers changed from: private */
    public final a b;
    private o c;
    private final Object d = new Object();
    private long e;

    public interface a {
        void onAdExpired();
    }

    public b(m mVar, a aVar) {
        this.a = mVar;
        this.b = aVar;
    }

    private void b() {
        o oVar = this.c;
        if (oVar != null) {
            oVar.d();
            this.c = null;
        }
    }

    private void c() {
        synchronized (this.d) {
            b();
        }
    }

    private void d() {
        boolean z;
        synchronized (this.d) {
            long currentTimeMillis = this.e - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                a();
                z = true;
            } else {
                a(currentTimeMillis);
                z = false;
            }
        }
        if (z) {
            this.b.onAdExpired();
        }
    }

    public void a() {
        synchronized (this.d) {
            b();
            this.a.aj().unregisterReceiver(this);
        }
    }

    public void a(long j) {
        synchronized (this.d) {
            a();
            this.e = System.currentTimeMillis() + j;
            this.a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            this.a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
            if (((Boolean) this.a.a(com.applovin.impl.sdk.d.a.D)).booleanValue() || !this.a.ad().a()) {
                this.c = o.a(j, this.a, new Runnable() {
                    public void run() {
                        b.this.a();
                        b.this.b.onAdExpired();
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            c();
        } else if ("com.applovin.application_resumed".equals(action)) {
            d();
        }
    }
}
