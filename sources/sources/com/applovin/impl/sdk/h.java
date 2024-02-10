package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class h extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {
    public static int a = -1;
    private final AudioManager b;
    private final Context c;
    private final m d;
    private final Set<a> e = new HashSet();
    private final Object f = new Object();
    private boolean g;
    private int h;

    public interface a {
        void a(int i);
    }

    h(m mVar) {
        this.d = mVar;
        Context L = mVar.L();
        this.c = L;
        this.b = (AudioManager) L.getSystemService("audio");
    }

    public static boolean a(int i) {
        return i == 0 || i == 1;
    }

    private void b() {
        if (u.a()) {
            this.d.A().b("AudioSessionManager", "Observing ringer mode...");
        }
        this.h = a;
        this.c.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.d.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.d.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    private void b(final int i) {
        if (!this.g) {
            if (u.a()) {
                u A = this.d.A();
                A.b("AudioSessionManager", "Ringer mode is " + i);
            }
            synchronized (this.f) {
                for (final a next : this.e) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            next.a(i);
                        }
                    });
                }
            }
        }
    }

    private void c() {
        if (u.a()) {
            this.d.A().b("AudioSessionManager", "Stopping observation of mute switch state...");
        }
        this.c.unregisterReceiver(this);
        this.d.aj().unregisterReceiver(this);
    }

    public int a() {
        return this.b.getRingerMode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.applovin.impl.sdk.h.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.e     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.e     // Catch:{ all -> 0x0020 }
            r1.add(r3)     // Catch:{ all -> 0x0020 }
            java.util.Set<com.applovin.impl.sdk.h$a> r3 = r2.e     // Catch:{ all -> 0x0020 }
            int r3 = r3.size()     // Catch:{ all -> 0x0020 }
            r1 = 1
            if (r3 != r1) goto L_0x001e
            r2.b()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.h.a(com.applovin.impl.sdk.h$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.applovin.impl.sdk.h.a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.e     // Catch:{ all -> 0x001f }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.h$a> r1 = r2.e     // Catch:{ all -> 0x001f }
            r1.remove(r3)     // Catch:{ all -> 0x001f }
            java.util.Set<com.applovin.impl.sdk.h$a> r3 = r2.e     // Catch:{ all -> 0x001f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x001d
            r2.c()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.h.b(com.applovin.impl.sdk.h$a):void");
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            b(this.b.getRingerMode());
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.g = true;
            this.h = this.b.getRingerMode();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.g = false;
            if (this.h != this.b.getRingerMode()) {
                this.h = a;
                b(this.b.getRingerMode());
            }
        }
    }
}
