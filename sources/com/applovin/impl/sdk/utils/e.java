package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.m;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class e implements AppLovinBroadcastManager.Receiver {
    private static final Set<e> a = new HashSet();
    private final o b;
    private final m c;

    private e(long j, m mVar, final Runnable runnable) {
        this.b = o.a(j, mVar, new Runnable() {
            public void run() {
                e.this.a();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        this.c = mVar;
        a.add(this);
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public static e a(long j, m mVar, Runnable runnable) {
        return new e(j, mVar, runnable);
    }

    public void a() {
        this.b.d();
        this.c.aj().unregisterReceiver(this);
        a.remove(this);
    }

    public long b() {
        return this.b.a();
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.b.b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.b.c();
        }
    }
}
