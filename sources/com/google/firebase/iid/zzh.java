package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class zzh implements ServiceConnection {
    private final Queue<zzd> zzaa;
    private zzf zzab;
    private boolean zzac;
    private final Context zzx;
    private final Intent zzy;
    private final ScheduledExecutorService zzz;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zzaa = new ArrayDeque();
        this.zzac = false;
        Context applicationContext = context.getApplicationContext();
        this.zzx = applicationContext;
        this.zzy = new Intent(str).setPackage(applicationContext.getPackageName());
        this.zzz = scheduledExecutorService;
    }

    public final synchronized void zza(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.zzaa.add(new zzd(intent, pendingResult, this.zzz));
        zzc();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzc() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "EnhancedIntentService"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "flush queue called"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00a9 }
        L_0x0011:
            java.util.Queue<com.google.firebase.iid.zzd> r0 = r6.zzaa     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x00a7
            java.lang.String r0 = "EnhancedIntentService"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "found intent to be delivered"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00a9 }
        L_0x0028:
            com.google.firebase.iid.zzf r0 = r6.zzab     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x004f
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x004f
            java.lang.String r0 = "EnhancedIntentService"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "binder is alive, sending the intent."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00a9 }
        L_0x0041:
            java.util.Queue<com.google.firebase.iid.zzd> r0 = r6.zzaa     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x00a9 }
            com.google.firebase.iid.zzd r0 = (com.google.firebase.iid.zzd) r0     // Catch:{ all -> 0x00a9 }
            com.google.firebase.iid.zzf r2 = r6.zzab     // Catch:{ all -> 0x00a9 }
            r2.zza((com.google.firebase.iid.zzd) r0)     // Catch:{ all -> 0x00a9 }
            goto L_0x0011
        L_0x004f:
            java.lang.String r0 = "EnhancedIntentService"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00a9 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = "EnhancedIntentService"
            boolean r3 = r6.zzac     // Catch:{ all -> 0x00a9 }
            if (r3 != 0) goto L_0x0061
            r3 = 1
            goto L_0x0062
        L_0x0061:
            r3 = 0
        L_0x0062:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r5 = 39
            r4.<init>(r5)     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = "binder is dead. start connection? "
            r4.append(r5)     // Catch:{ all -> 0x00a9 }
            r4.append(r3)     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x00a9 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00a9 }
        L_0x0078:
            boolean r0 = r6.zzac     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x00a5
            r6.zzac = r2     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ SecurityException -> 0x0098 }
            android.content.Context r2 = r6.zzx     // Catch:{ SecurityException -> 0x0098 }
            android.content.Intent r3 = r6.zzy     // Catch:{ SecurityException -> 0x0098 }
            r4 = 65
            boolean r0 = r0.bindService(r2, r3, r6, r4)     // Catch:{ SecurityException -> 0x0098 }
            if (r0 == 0) goto L_0x0090
            monitor-exit(r6)
            return
        L_0x0090:
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "binding to the service failed"
            android.util.Log.e(r0, r2)     // Catch:{ SecurityException -> 0x0098 }
            goto L_0x00a0
        L_0x0098:
            r0 = move-exception
            java.lang.String r2 = "EnhancedIntentService"
            java.lang.String r3 = "Exception while binding the service"
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x00a9 }
        L_0x00a0:
            r6.zzac = r1     // Catch:{ all -> 0x00a9 }
            r6.zzd()     // Catch:{ all -> 0x00a9 }
        L_0x00a5:
            monitor-exit(r6)
            return
        L_0x00a7:
            monitor-exit(r6)
            return
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x00ad
        L_0x00ac:
            throw r0
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzh.zzc():void");
    }

    private final void zzd() {
        while (!this.zzaa.isEmpty()) {
            this.zzaa.poll().finish();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.zzac = false;
            this.zzab = (zzf) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("onServiceConnected: ");
                sb.append(valueOf);
                Log.d("EnhancedIntentService", sb.toString());
            }
            if (iBinder == null) {
                Log.e("EnhancedIntentService", "Null service connection");
                zzd();
            } else {
                zzc();
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("EnhancedIntentService", sb.toString());
        }
        zzc();
    }
}
