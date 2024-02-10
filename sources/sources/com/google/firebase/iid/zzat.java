package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzl;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzat {
    private static int zzcf;
    private static PendingIntent zzcr;
    private final zzan zzan;
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzcs = new SimpleArrayMap<>();
    private Messenger zzct;
    private Messenger zzcu;
    private zzl zzcv;
    private final Context zzx;

    public zzat(Context context, zzan zzan2) {
        this.zzx = context;
        this.zzan = zzan2;
        this.zzct = new Messenger(new zzau(this, Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    public final void zzb(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new zzl.zza());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzl) {
                this.zzcv = (zzl) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzcu = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf2 = String.valueOf(stringExtra2);
                    Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                }
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (split.length <= 2 || !"ID".equals(split[1])) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.w("FirebaseInstanceId", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                        return;
                    }
                    String str = split[2];
                    String str2 = split[3];
                    if (str2.startsWith(CertificateUtil.DELIMITER)) {
                        str2 = str2.substring(1);
                    }
                    zza(str, intent2.putExtra("error", str2).getExtras());
                    return;
                }
                synchronized (this.zzcs) {
                    for (int i = 0; i < this.zzcs.size(); i++) {
                        zza(this.zzcs.keyAt(i), intent2.getExtras());
                    }
                }
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                zza(group, extras);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf4 = String.valueOf(stringExtra);
                Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected response string: ".concat(valueOf4) : new String("Unexpected response string: "));
            }
        } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf5 = String.valueOf(action);
            Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response action: ".concat(valueOf5) : new String("Unexpected response action: "));
        }
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzat.class) {
            if (zzcr == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzcr = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, zzcr);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcs) {
            TaskCompletionSource remove = this.zzcs.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzc(Bundle bundle) throws IOException {
        if (this.zzan.zzaf() < 12000000) {
            return zzd(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzab.zzc(this.zzx).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if (!(e.getCause() instanceof zzal) || ((zzal) e.getCause()).getErrorCode() != 4) {
                return null;
            }
            return zzd(bundle);
        }
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle zze = zze(bundle);
        if (zze == null || !zze.containsKey("google.messenger")) {
            return zze;
        }
        Bundle zze2 = zze(bundle);
        if (zze2 == null || !zze2.containsKey("google.messenger")) {
            return zze2;
        }
        return null;
    }

    private static synchronized String zzah() {
        String num;
        synchronized (zzat.class) {
            int i = zzcf;
            zzcf = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final android.os.Bundle zze(android.os.Bundle r9) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = zzah()
            com.google.android.gms.tasks.TaskCompletionSource r1 = new com.google.android.gms.tasks.TaskCompletionSource
            r1.<init>()
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r8.zzcs
            monitor-enter(r2)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r8.zzcs     // Catch:{ all -> 0x0124 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0124 }
            monitor-exit(r2)     // Catch:{ all -> 0x0124 }
            com.google.firebase.iid.zzan r2 = r8.zzan
            int r2 = r2.zzac()
            if (r2 == 0) goto L_0x011c
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            com.google.firebase.iid.zzan r3 = r8.zzan
            int r3 = r3.zzac()
            r4 = 2
            if (r3 != r4) goto L_0x0033
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
            goto L_0x0038
        L_0x0033:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
        L_0x0038:
            r2.putExtras(r9)
            android.content.Context r9 = r8.zzx
            zza((android.content.Context) r9, (android.content.Intent) r2)
            java.lang.String r9 = "kid"
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + 5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = "|ID|"
            r5.append(r3)
            r5.append(r0)
            java.lang.String r3 = "|"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r2.putExtra(r9, r3)
            java.lang.String r9 = "FirebaseInstanceId"
            r3 = 3
            boolean r9 = android.util.Log.isLoggable(r9, r3)
            if (r9 == 0) goto L_0x0096
            java.lang.String r9 = "FirebaseInstanceId"
            android.os.Bundle r5 = r2.getExtras()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = java.lang.String.valueOf(r5)
            int r6 = r6.length()
            int r6 = r6 + 8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Sending "
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            android.util.Log.d(r9, r5)
        L_0x0096:
            java.lang.String r9 = "google.messenger"
            android.os.Messenger r5 = r8.zzct
            r2.putExtra(r9, r5)
            android.os.Messenger r9 = r8.zzcu
            if (r9 != 0) goto L_0x00a5
            com.google.firebase.iid.zzl r9 = r8.zzcv
            if (r9 == 0) goto L_0x00c9
        L_0x00a5:
            android.os.Message r9 = android.os.Message.obtain()
            r9.obj = r2
            android.os.Messenger r5 = r8.zzcu     // Catch:{ RemoteException -> 0x00b9 }
            if (r5 == 0) goto L_0x00b3
            r5.send(r9)     // Catch:{ RemoteException -> 0x00b9 }
            goto L_0x00dc
        L_0x00b3:
            com.google.firebase.iid.zzl r5 = r8.zzcv     // Catch:{ RemoteException -> 0x00b9 }
            r5.send(r9)     // Catch:{ RemoteException -> 0x00b9 }
            goto L_0x00dc
        L_0x00b9:
            java.lang.String r9 = "FirebaseInstanceId"
            boolean r9 = android.util.Log.isLoggable(r9, r3)
            if (r9 == 0) goto L_0x00c9
            java.lang.String r9 = "FirebaseInstanceId"
            java.lang.String r3 = "Messenger failed, fallback to startService"
            android.util.Log.d(r9, r3)
        L_0x00c9:
            com.google.firebase.iid.zzan r9 = r8.zzan
            int r9 = r9.zzac()
            if (r9 != r4) goto L_0x00d7
            android.content.Context r9 = r8.zzx
            r9.sendBroadcast(r2)
            goto L_0x00dc
        L_0x00d7:
            android.content.Context r9 = r8.zzx
            r9.startService(r2)
        L_0x00dc:
            com.google.android.gms.tasks.Task r9 = r1.getTask()     // Catch:{ InterruptedException | TimeoutException -> 0x0100, ExecutionException -> 0x00f9 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException | TimeoutException -> 0x0100, ExecutionException -> 0x00f9 }
            r2 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r9 = com.google.android.gms.tasks.Tasks.await(r9, r2, r1)     // Catch:{ InterruptedException | TimeoutException -> 0x0100, ExecutionException -> 0x00f9 }
            android.os.Bundle r9 = (android.os.Bundle) r9     // Catch:{ InterruptedException | TimeoutException -> 0x0100, ExecutionException -> 0x00f9 }
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r8.zzcs
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r8.zzcs     // Catch:{ all -> 0x00f4 }
            r2.remove(r0)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            return r9
        L_0x00f4:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            throw r9
        L_0x00f7:
            r9 = move-exception
            goto L_0x010f
        L_0x00f9:
            r9 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00f7 }
            r1.<init>(r9)     // Catch:{ all -> 0x00f7 }
            throw r1     // Catch:{ all -> 0x00f7 }
        L_0x0100:
            java.lang.String r9 = "FirebaseInstanceId"
            java.lang.String r1 = "No response"
            android.util.Log.w(r9, r1)     // Catch:{ all -> 0x00f7 }
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x00f7 }
            java.lang.String r1 = "TIMEOUT"
            r9.<init>(r1)     // Catch:{ all -> 0x00f7 }
            throw r9     // Catch:{ all -> 0x00f7 }
        L_0x010f:
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r8.zzcs
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r8.zzcs     // Catch:{ all -> 0x0119 }
            r2.remove(r0)     // Catch:{ all -> 0x0119 }
            monitor-exit(r1)     // Catch:{ all -> 0x0119 }
            throw r9
        L_0x0119:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0119 }
            throw r9
        L_0x011c:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r0 = "MISSING_INSTANCEID_SERVICE"
            r9.<init>(r0)
            throw r9
        L_0x0124:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0124 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzat.zze(android.os.Bundle):android.os.Bundle");
    }
}