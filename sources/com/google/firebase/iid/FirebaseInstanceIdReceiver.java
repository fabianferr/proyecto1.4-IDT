package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.PlatformVersion;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private static boolean zzbf = false;
    private static zzh zzbg;
    private static zzh zzbh;

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                zza(context, intent2, intent.getAction());
            } else {
                zza(context, intent, intent.getAction());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(android.content.Context r5, android.content.Intent r6, java.lang.String r7) {
        /*
            r4 = this;
            r0 = 0
            r6.setComponent(r0)
            java.lang.String r1 = r5.getPackageName()
            r6.setPackage(r1)
            java.lang.String r1 = "gcm.rawData64"
            java.lang.String r2 = r6.getStringExtra(r1)
            if (r2 == 0) goto L_0x0020
            r3 = 0
            byte[] r2 = android.util.Base64.decode(r2, r3)
            java.lang.String r3 = "rawData"
            r6.putExtra(r3, r2)
            r6.removeExtra(r1)
        L_0x0020:
            java.lang.String r1 = "from"
            java.lang.String r1 = r6.getStringExtra(r1)
            java.lang.String r2 = "google.com/iid"
            boolean r1 = r2.equals(r1)
            java.lang.String r2 = "com.google.firebase.INSTANCE_ID_EVENT"
            if (r1 != 0) goto L_0x0050
            boolean r1 = r2.equals(r7)
            if (r1 == 0) goto L_0x0037
            goto L_0x0050
        L_0x0037:
            java.lang.String r1 = "com.google.android.c2dm.intent.RECEIVE"
            boolean r1 = r1.equals(r7)
            java.lang.String r2 = "com.google.firebase.MESSAGING_EVENT"
            if (r1 != 0) goto L_0x0050
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L_0x0048
            goto L_0x0050
        L_0x0048:
            java.lang.String r7 = "FirebaseInstanceId"
            java.lang.String r1 = "Unexpected intent"
            android.util.Log.d(r7, r1)
            goto L_0x0051
        L_0x0050:
            r0 = r2
        L_0x0051:
            if (r0 == 0) goto L_0x0058
            int r5 = zza(r4, r5, r0, r6)
            goto L_0x0059
        L_0x0058:
            r5 = -1
        L_0x0059:
            boolean r6 = r4.isOrderedBroadcast()
            if (r6 == 0) goto L_0x0062
            r4.setResultCode(r5)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdReceiver.zza(android.content.Context, android.content.Intent, java.lang.String):void");
    }

    public static int zza(BroadcastReceiver broadcastReceiver, Context context, String str, Intent intent) {
        boolean z = true;
        boolean z2 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z = false;
        }
        if (z2 && !z) {
            return zzb(broadcastReceiver, context, str, intent);
        }
        int zzb = zzav.zzai().zzb(context, str, intent);
        if (!PlatformVersion.isAtLeastO() || zzb != 402) {
            return zzb;
        }
        zzb(broadcastReceiver, context, str, intent);
        return 403;
    }

    private static int zzb(BroadcastReceiver broadcastReceiver, Context context, String str, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Binding to service: ".concat(valueOf) : new String("Binding to service: "));
        }
        if (broadcastReceiver.isOrderedBroadcast()) {
            broadcastReceiver.setResultCode(-1);
        }
        zza(context, str).zza(intent, broadcastReceiver.goAsync());
        return -1;
    }

    private static synchronized zzh zza(Context context, String str) {
        synchronized (FirebaseInstanceIdReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (zzbh == null) {
                    zzbh = new zzh(context, str);
                }
                zzh zzh = zzbh;
                return zzh;
            }
            if (zzbg == null) {
                zzbg = new zzh(context, str);
            }
            zzh zzh2 = zzbg;
            return zzh2;
        }
    }
}
